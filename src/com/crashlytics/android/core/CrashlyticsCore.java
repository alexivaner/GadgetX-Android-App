// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ScrollView;
import android.widget.TextView;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityCallable;
import io.fabric.sdk.android.services.concurrency.Task;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStore;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.fabric.sdk.android.services.settings.FeaturesSettingsData;
import io.fabric.sdk.android.services.settings.PromptSettingsData;
import io.fabric.sdk.android.services.settings.SessionSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HttpsURLConnection;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsExecutorServiceWrapper, CrashlyticsListener, CrashlyticsUncaughtExceptionHandler, DialogStringResolver, 
//            CrashlyticsPinningInfoProvider, BuildIdValidator, CrashTest, CrashlyticsFileMarker, 
//            ReportUploader, DefaultCreateReportSpiCall, CrashlyticsMissingDependencyException, ManifestUnityVersionProvider, 
//            PinningInfoProvider, UnityVersionProvider, CreateReportSpiCall

public class CrashlyticsCore extends Kit
{
    public static class Builder
    {

        private float delay;
        private boolean disabled;
        private CrashlyticsListener listener;
        private PinningInfoProvider pinningInfoProvider;

        public CrashlyticsCore build()
        {
            if (delay < 0.0F)
            {
                delay = 1.0F;
            }
            return new CrashlyticsCore(delay, listener, pinningInfoProvider, disabled);
        }

        public Builder delay(float f)
        {
            if (f <= 0.0F)
            {
                throw new IllegalArgumentException("delay must be greater than 0");
            }
            if (delay > 0.0F)
            {
                throw new IllegalStateException("delay already set.");
            } else
            {
                delay = f;
                return this;
            }
        }

        public Builder disabled(boolean flag)
        {
            disabled = flag;
            return this;
        }

        public Builder listener(CrashlyticsListener crashlyticslistener)
        {
            if (crashlyticslistener == null)
            {
                throw new IllegalArgumentException("listener must not be null.");
            }
            if (listener != null)
            {
                throw new IllegalStateException("listener already set.");
            } else
            {
                listener = crashlyticslistener;
                return this;
            }
        }

        public Builder pinningInfo(PinningInfoProvider pinninginfoprovider)
        {
            if (pinninginfoprovider == null)
            {
                throw new IllegalArgumentException("pinningInfoProvider must not be null.");
            }
            if (pinningInfoProvider != null)
            {
                throw new IllegalStateException("pinningInfoProvider already set.");
            } else
            {
                pinningInfoProvider = pinninginfoprovider;
                return this;
            }
        }

        public Builder()
        {
            delay = -1F;
            disabled = false;
        }
    }

    private static final class CrashMarkerCheck
        implements Callable
    {

        private final CrashlyticsFileMarker crashMarker;

        public Boolean call()
            throws Exception
        {
            if (!crashMarker.isPresent())
            {
                return Boolean.FALSE;
            } else
            {
                Fabric.getLogger().d("CrashlyticsCore", "Found previous crash marker.");
                crashMarker.remove();
                return Boolean.TRUE;
            }
        }

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public CrashMarkerCheck(CrashlyticsFileMarker crashlyticsfilemarker)
        {
            crashMarker = crashlyticsfilemarker;
        }
    }

    private static final class NoOpListener
        implements CrashlyticsListener
    {

        public void crashlyticsDidDetectCrashDuringPreviousExecution()
        {
        }

        private NoOpListener()
        {
        }

    }

    private static class OptInLatch
    {

        private final CountDownLatch latch;
        private boolean send;

        void await()
        {
            try
            {
                latch.await();
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                return;
            }
        }

        boolean getOptIn()
        {
            return send;
        }

        void setOptIn(boolean flag)
        {
            send = flag;
            latch.countDown();
        }

        private OptInLatch()
        {
            send = false;
            latch = new CountDownLatch(1);
        }

    }


    static final float CLS_DEFAULT_PROCESS_DELAY = 1F;
    static final String COLLECT_CUSTOM_KEYS = "com.crashlytics.CollectCustomKeys";
    static final String COLLECT_CUSTOM_LOGS = "com.crashlytics.CollectCustomLogs";
    static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    static final int MAX_ATTRIBUTES = 64;
    static final int MAX_ATTRIBUTE_SIZE = 1024;
    private static final String PREF_ALWAYS_SEND_REPORTS_KEY = "always_send_reports_opt_in";
    private static final boolean SHOULD_PROMPT_BEFORE_SENDING_REPORTS_DEFAULT = false;
    public static final String TAG = "CrashlyticsCore";
    private String apiKey;
    private final ConcurrentHashMap attributes;
    private String buildId;
    private CrashlyticsFileMarker crashMarker;
    private float delay;
    private boolean disabled;
    private CrashlyticsExecutorServiceWrapper executorServiceWrapper;
    private CrashEventDataProvider externalCrashEventDataProvider;
    private FileStore fileStore;
    private CrashlyticsUncaughtExceptionHandler handler;
    private HttpRequestFactory httpRequestFactory;
    private CrashlyticsFileMarker initializationMarker;
    private String installerPackageName;
    private CrashlyticsListener listener;
    private String packageName;
    private final PinningInfoProvider pinningInfo;
    private File sdkDir;
    private final long startTime;
    private String userEmail;
    private String userId;
    private String userName;
    private String versionCode;
    private String versionName;

    public CrashlyticsCore()
    {
        this(1.0F, null, null, false);
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticslistener, PinningInfoProvider pinninginfoprovider, boolean flag)
    {
        this(f, crashlyticslistener, pinninginfoprovider, flag, ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler"));
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticslistener, PinningInfoProvider pinninginfoprovider, boolean flag, ExecutorService executorservice)
    {
        userId = null;
        userEmail = null;
        userName = null;
        delay = f;
        if (crashlyticslistener == null)
        {
            crashlyticslistener = new NoOpListener();
        }
        listener = crashlyticslistener;
        pinningInfo = pinninginfoprovider;
        disabled = flag;
        executorServiceWrapper = new CrashlyticsExecutorServiceWrapper(executorservice);
        attributes = new ConcurrentHashMap();
        startTime = System.currentTimeMillis();
    }

    private void checkForPreviousCrash()
    {
        Boolean boolean1 = (Boolean)executorServiceWrapper.executeSyncLoggingException(new CrashMarkerCheck(crashMarker));
        if (!Boolean.TRUE.equals(boolean1))
        {
            return;
        }
        try
        {
            listener.crashlyticsDidDetectCrashDuringPreviousExecution();
            return;
        }
        catch (Exception exception)
        {
            Fabric.getLogger().e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", exception);
        }
    }

    private static int dipsToPixels(float f, int i)
    {
        return (int)((float)i * f);
    }

    private void doLog(int i, String s, String s1)
    {
        while (disabled || !ensureFabricWithCalled("prior to logging messages.")) 
        {
            return;
        }
        long l = System.currentTimeMillis();
        long l1 = startTime;
        handler.writeToLog(l - l1, formatLogMessage(i, s, s1));
    }

    private static boolean ensureFabricWithCalled(String s)
    {
        CrashlyticsCore crashlyticscore = getInstance();
        if (crashlyticscore == null || crashlyticscore.handler == null)
        {
            Fabric.getLogger().e("CrashlyticsCore", (new StringBuilder()).append("Crashlytics must be initialized by calling Fabric.with(Context) ").append(s).toString(), null);
            return false;
        } else
        {
            return true;
        }
    }

    private void finishInitSynchronously()
    {
        Object obj = new PriorityCallable() {

            final CrashlyticsCore this$0;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                return doInBackground();
            }

            public Priority getPriority()
            {
                return Priority.IMMEDIATE;
            }

            
            {
                this$0 = CrashlyticsCore.this;
                super();
            }
        };
        for (Iterator iterator = getDependencies().iterator(); iterator.hasNext(); ((PriorityCallable) (obj)).addDependency((Task)iterator.next())) { }
        obj = getFabric().getExecutorService().submit(((Callable) (obj)));
        Fabric.getLogger().d("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try
        {
            ((Future) (obj)).get(4L, TimeUnit.SECONDS);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Fabric.getLogger().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", interruptedexception);
            return;
        }
        catch (ExecutionException executionexception)
        {
            Fabric.getLogger().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", executionexception);
            return;
        }
        catch (TimeoutException timeoutexception)
        {
            Fabric.getLogger().e("CrashlyticsCore", "Crashlytics timed out during initialization.", timeoutexception);
        }
    }

    private static String formatLogMessage(int i, String s, String s1)
    {
        return (new StringBuilder()).append(CommonUtils.logPriorityToString(i)).append("/").append(s).append(" ").append(s1).toString();
    }

    public static CrashlyticsCore getInstance()
    {
        return (CrashlyticsCore)Fabric.getKit(com/crashlytics/android/core/CrashlyticsCore);
    }

    private boolean getSendDecisionFromUser(final Activity activity, final PromptSettingsData promptData)
    {
        final DialogStringResolver stringResolver = new DialogStringResolver(activity, promptData);
        final OptInLatch latch = new OptInLatch();
        activity.runOnUiThread(new Runnable() {

            final CrashlyticsCore this$0;
            final Activity val$activity;
            final OptInLatch val$latch;
            final PromptSettingsData val$promptData;
            final DialogStringResolver val$stringResolver;

            public void run()
            {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
                android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

                    final _cls7 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        latch.setOptIn(true);
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls7.this;
                super();
            }
                };
                float f = activity.getResources().getDisplayMetrics().density;
                int i = CrashlyticsCore.dipsToPixels(f, 5);
                TextView textview = new TextView(activity);
                textview.setAutoLinkMask(15);
                textview.setText(stringResolver.getMessage());
                textview.setTextAppearance(activity, 0x1030044);
                textview.setPadding(i, i, i, i);
                textview.setFocusable(false);
                ScrollView scrollview = new ScrollView(activity);
                scrollview.setPadding(CrashlyticsCore.dipsToPixels(f, 14), CrashlyticsCore.dipsToPixels(f, 2), CrashlyticsCore.dipsToPixels(f, 10), CrashlyticsCore.dipsToPixels(f, 12));
                scrollview.addView(textview);
                builder.setView(scrollview).setTitle(stringResolver.getTitle()).setCancelable(false).setNeutralButton(stringResolver.getSendButtonTitle(), onclicklistener);
                if (promptData.showCancelButton)
                {
                    android.content.DialogInterface.OnClickListener onclicklistener1 = new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            latch.setOptIn(false);
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    };
                    builder.setNegativeButton(stringResolver.getCancelButtonTitle(), onclicklistener1);
                }
                if (promptData.showAlwaysSendButton)
                {
                    android.content.DialogInterface.OnClickListener onclicklistener2 = new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            setShouldSendUserReportsWithoutPrompting(true);
                            latch.setOptIn(true);
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    };
                    builder.setPositiveButton(stringResolver.getAlwaysSendButtonTitle(), onclicklistener2);
                }
                builder.show();
            }

            
            {
                this$0 = CrashlyticsCore.this;
                activity = activity1;
                latch = optinlatch;
                stringResolver = dialogstringresolver;
                promptData = promptsettingsdata;
                super();
            }
        });
        Fabric.getLogger().d("CrashlyticsCore", "Waiting for user opt-in.");
        latch.await();
        return latch.getOptIn();
    }

    static SessionSettingsData getSessionSettingsData()
    {
        SettingsData settingsdata = Settings.getInstance().awaitSettingsData();
        if (settingsdata == null)
        {
            return null;
        } else
        {
            return settingsdata.sessionData;
        }
    }

    private void installExceptionHandler(UnityVersionProvider unityversionprovider)
    {
        try
        {
            Fabric.getLogger().d("CrashlyticsCore", "Installing exception handler...");
            handler = new CrashlyticsUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler(), executorServiceWrapper, getIdManager(), unityversionprovider, fileStore, this);
            handler.openSession();
            Thread.setDefaultUncaughtExceptionHandler(handler);
            Fabric.getLogger().d("CrashlyticsCore", "Successfully installed exception handler.");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (UnityVersionProvider unityversionprovider)
        {
            Fabric.getLogger().e("CrashlyticsCore", "There was a problem installing the exception handler.", unityversionprovider);
        }
    }

    private static boolean isRequiringBuildId(Context context)
    {
        return CommonUtils.getBooleanResourceValue(context, "com.crashlytics.RequireBuildId", true);
    }

    static void recordFatalExceptionEvent(String s)
    {
        Answers answers = (Answers)Fabric.getKit(com/crashlytics/android/answers/Answers);
        if (answers != null)
        {
            answers.onException(new io.fabric.sdk.android.services.common.Crash.FatalException(s));
        }
    }

    static void recordLoggedExceptionEvent(String s)
    {
        Answers answers = (Answers)Fabric.getKit(com/crashlytics/android/answers/Answers);
        if (answers != null)
        {
            answers.onException(new io.fabric.sdk.android.services.common.Crash.LoggedException(s));
        }
    }

    private static String sanitizeAttribute(String s)
    {
        String s1 = s;
        if (s != null)
        {
            s = s.trim();
            s1 = s;
            if (s.length() > 1024)
            {
                s1 = s.substring(0, 1024);
            }
        }
        return s1;
    }

    private void setAndValidateKitProperties(Context context, String s)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        Object obj;
        if (pinningInfo != null)
        {
            obj = new CrashlyticsPinningInfoProvider(pinningInfo);
        } else
        {
            obj = null;
        }
        httpRequestFactory = new DefaultHttpRequestFactory(Fabric.getLogger());
        httpRequestFactory.setPinningInfoProvider(((io.fabric.sdk.android.services.network.PinningInfoProvider) (obj)));
        packageName = context.getPackageName();
        installerPackageName = getIdManager().getInstallerPackageName();
        Fabric.getLogger().d("CrashlyticsCore", (new StringBuilder()).append("Installer package name is: ").append(installerPackageName).toString());
        obj = context.getPackageManager().getPackageInfo(packageName, 0);
        versionCode = Integer.toString(((PackageInfo) (obj)).versionCode);
        if (((PackageInfo) (obj)).versionName == null)
        {
            obj = "0.0";
        } else
        {
            obj = ((PackageInfo) (obj)).versionName;
        }
        versionName = ((String) (obj));
        buildId = CommonUtils.resolveBuildId(context);
        getBuildIdValidator(buildId, isRequiringBuildId(context)).validate(s, packageName);
    }

    boolean canSendWithUserApproval()
    {
        return ((Boolean)Settings.getInstance().withSettings(new io.fabric.sdk.android.services.settings.Settings.SettingsAccess() {

            final CrashlyticsCore this$0;

            public Boolean usingSettings(SettingsData settingsdata)
            {
                boolean flag1 = true;
                Activity activity = getFabric().getCurrentActivity();
                boolean flag = flag1;
                if (activity != null)
                {
                    flag = flag1;
                    if (!activity.isFinishing())
                    {
                        flag = flag1;
                        if (shouldPromptUserBeforeSendingCrashReports())
                        {
                            flag = getSendDecisionFromUser(activity, settingsdata.promptData);
                        }
                    }
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object usingSettings(SettingsData settingsdata)
            {
                return usingSettings(settingsdata);
            }

            
            {
                this$0 = CrashlyticsCore.this;
                super();
            }
        }, Boolean.valueOf(true))).booleanValue();
    }

    public void crash()
    {
        (new CrashTest()).indexOutOfBounds();
    }

    void createCrashMarker()
    {
        crashMarker.create();
    }

    boolean didPreviousInitializationFail()
    {
        return ((Boolean)executorServiceWrapper.executeSyncLoggingException(new Callable() {

            final CrashlyticsCore this$0;

            public Boolean call()
                throws Exception
            {
                return Boolean.valueOf(initializationMarker.isPresent());
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = CrashlyticsCore.this;
                super();
            }
        })).booleanValue();
    }

    protected volatile Object doInBackground()
    {
        return doInBackground();
    }

    protected Void doInBackground()
    {
        markInitializationStarted();
        handler.cleanInvalidTempFiles();
        Object obj = Settings.getInstance().awaitSettingsData();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        Fabric.getLogger().w("CrashlyticsCore", "Received null settings, skipping initialization!");
        markInitializationComplete();
        return null;
        if (((SettingsData) (obj)).featuresData.collectReports)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        Fabric.getLogger().d("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
        markInitializationComplete();
        return null;
        handler.finalizeSessions();
        obj = getCreateReportSpiCall(((SettingsData) (obj)));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        Fabric.getLogger().w("CrashlyticsCore", "Unable to create a call to upload reports.");
        markInitializationComplete();
        return null;
        (new ReportUploader(((CreateReportSpiCall) (obj)))).uploadReports(delay);
        markInitializationComplete();
        return null;
        Object obj1;
        obj1;
        Fabric.getLogger().e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", ((Throwable) (obj1)));
        markInitializationComplete();
        return null;
        obj1;
        markInitializationComplete();
        throw obj1;
    }

    String getApiKey()
    {
        return apiKey;
    }

    Map getAttributes()
    {
        return Collections.unmodifiableMap(attributes);
    }

    String getBuildId()
    {
        return buildId;
    }

    BuildIdValidator getBuildIdValidator(String s, boolean flag)
    {
        return new BuildIdValidator(s, flag);
    }

    CreateReportSpiCall getCreateReportSpiCall(SettingsData settingsdata)
    {
        if (settingsdata != null)
        {
            return new DefaultCreateReportSpiCall(this, getOverridenSpiEndpoint(), settingsdata.appData.reportsUrl, httpRequestFactory);
        } else
        {
            return null;
        }
    }

    SessionEventData getExternalCrashEventData()
    {
        SessionEventData sessioneventdata = null;
        if (externalCrashEventDataProvider != null)
        {
            sessioneventdata = externalCrashEventDataProvider.getCrashEventData();
        }
        return sessioneventdata;
    }

    CrashlyticsUncaughtExceptionHandler getHandler()
    {
        return handler;
    }

    public String getIdentifier()
    {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    String getInstallerPackageName()
    {
        return installerPackageName;
    }

    String getOverridenSpiEndpoint()
    {
        return CommonUtils.getStringsFileValue(getContext(), "com.crashlytics.ApiEndpoint");
    }

    String getPackageName()
    {
        return packageName;
    }

    public PinningInfoProvider getPinningInfoProvider()
    {
        if (!disabled)
        {
            return pinningInfo;
        } else
        {
            return null;
        }
    }

    File getSdkDirectory()
    {
        if (sdkDir == null)
        {
            sdkDir = (new FileStoreImpl(this)).getFilesDir();
        }
        return sdkDir;
    }

    String getUserEmail()
    {
        if (getIdManager().canCollectUserIds())
        {
            return userEmail;
        } else
        {
            return null;
        }
    }

    String getUserIdentifier()
    {
        if (getIdManager().canCollectUserIds())
        {
            return userId;
        } else
        {
            return null;
        }
    }

    String getUserName()
    {
        if (getIdManager().canCollectUserIds())
        {
            return userName;
        } else
        {
            return null;
        }
    }

    public String getVersion()
    {
        return "2.3.8.97";
    }

    String getVersionCode()
    {
        return versionCode;
    }

    String getVersionName()
    {
        return versionName;
    }

    boolean internalVerifyPinning(URL url)
    {
        boolean flag = false;
        if (getPinningInfoProvider() != null)
        {
            url = httpRequestFactory.buildHttpRequest(HttpMethod.GET, url.toString());
            ((HttpsURLConnection)url.getConnection()).setInstanceFollowRedirects(false);
            url.code();
            flag = true;
        }
        return flag;
    }

    public void log(int i, String s, String s1)
    {
        doLog(i, s, s1);
        Fabric.getLogger().log(i, (new StringBuilder()).append("").append(s).toString(), (new StringBuilder()).append("").append(s1).toString(), true);
    }

    public void log(String s)
    {
        doLog(3, "CrashlyticsCore", s);
    }

    public void logException(Throwable throwable)
    {
        while (disabled || !ensureFabricWithCalled("prior to logging exceptions.")) 
        {
            return;
        }
        if (throwable == null)
        {
            Fabric.getLogger().log(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
            return;
        } else
        {
            handler.writeNonFatalException(Thread.currentThread(), throwable);
            return;
        }
    }

    void markInitializationComplete()
    {
        executorServiceWrapper.executeAsync(new Callable() {

            final CrashlyticsCore this$0;

            public Boolean call()
                throws Exception
            {
                boolean flag;
                try
                {
                    flag = initializationMarker.remove();
                    Fabric.getLogger().d("CrashlyticsCore", (new StringBuilder()).append("Initialization marker file removed: ").append(flag).toString());
                }
                catch (Exception exception)
                {
                    Fabric.getLogger().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", exception);
                    return Boolean.valueOf(false);
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = CrashlyticsCore.this;
                super();
            }
        });
    }

    void markInitializationStarted()
    {
        executorServiceWrapper.executeSyncLoggingException(new Callable() {

            final CrashlyticsCore this$0;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                initializationMarker.create();
                Fabric.getLogger().d("CrashlyticsCore", "Initialization marker file created.");
                return null;
            }

            
            {
                this$0 = CrashlyticsCore.this;
                super();
            }
        });
    }

    protected boolean onPreExecute()
    {
        return onPreExecute(super.getContext());
    }

    boolean onPreExecute(Context context)
    {
        if (!disabled) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        apiKey = (new ApiKey()).getValue(context);
        if (apiKey == null) goto _L1; else goto _L3
_L3:
        Fabric.getLogger().i("CrashlyticsCore", (new StringBuilder()).append("Initializing Crashlytics ").append(getVersion()).toString());
        fileStore = new FileStoreImpl(this);
        crashMarker = new CrashlyticsFileMarker("crash_marker", fileStore);
        initializationMarker = new CrashlyticsFileMarker("initialization_marker", fileStore);
        boolean flag;
        try
        {
            setAndValidateKitProperties(context, apiKey);
            ManifestUnityVersionProvider manifestunityversionprovider = new ManifestUnityVersionProvider(context, getPackageName());
            flag = didPreviousInitializationFail();
            checkForPreviousCrash();
            installExceptionHandler(manifestunityversionprovider);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new UnmetDependencyException(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Fabric.getLogger().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", context);
            return false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        if (!CommonUtils.canTryConnection(context))
        {
            break MISSING_BLOCK_LABEL_173;
        }
        finishInitSynchronously();
        return false;
        return true;
    }

    public void setBool(String s, boolean flag)
    {
        setString(s, Boolean.toString(flag));
    }

    public void setDouble(String s, double d)
    {
        setString(s, Double.toString(d));
    }

    void setExternalCrashEventDataProvider(CrashEventDataProvider crasheventdataprovider)
    {
        externalCrashEventDataProvider = crasheventdataprovider;
    }

    public void setFloat(String s, float f)
    {
        setString(s, Float.toString(f));
    }

    public void setInt(String s, int i)
    {
        setString(s, Integer.toString(i));
    }

    public void setListener(CrashlyticsListener crashlyticslistener)
    {
        this;
        JVM INSTR monitorenter ;
        Fabric.getLogger().w("CrashlyticsCore", "Use of setListener is deprecated.");
        if (crashlyticslistener != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        throw new IllegalArgumentException("listener must not be null.");
        crashlyticslistener;
        this;
        JVM INSTR monitorexit ;
        throw crashlyticslistener;
        listener = crashlyticslistener;
        this;
        JVM INSTR monitorexit ;
    }

    public void setLong(String s, long l)
    {
        setString(s, Long.toString(l));
    }

    void setShouldSendUserReportsWithoutPrompting(boolean flag)
    {
        PreferenceStoreImpl preferencestoreimpl = new PreferenceStoreImpl(this);
        preferencestoreimpl.save(preferencestoreimpl.edit().putBoolean("always_send_reports_opt_in", flag));
    }

    public void setString(String s, String s1)
    {
        if (disabled)
        {
            return;
        }
        if (s == null)
        {
            s = getContext();
            if (s != null && CommonUtils.isAppDebuggable(s))
            {
                throw new IllegalArgumentException("Custom attribute key must not be null.");
            } else
            {
                Fabric.getLogger().e("CrashlyticsCore", "Attempting to set custom attribute with null key, ignoring.", null);
                return;
            }
        }
        String s2 = sanitizeAttribute(s);
        if (attributes.size() >= 64 && !attributes.containsKey(s2))
        {
            Fabric.getLogger().d("CrashlyticsCore", "Exceeded maximum number of custom attributes (64)");
            return;
        }
        if (s1 == null)
        {
            s = "";
        } else
        {
            s = sanitizeAttribute(s1);
        }
        attributes.put(s2, s);
        handler.cacheKeyData(attributes);
    }

    public void setUserEmail(String s)
    {
        if (disabled)
        {
            return;
        } else
        {
            userEmail = sanitizeAttribute(s);
            handler.cacheUserData(userId, userName, userEmail);
            return;
        }
    }

    public void setUserIdentifier(String s)
    {
        if (disabled)
        {
            return;
        } else
        {
            userId = sanitizeAttribute(s);
            handler.cacheUserData(userId, userName, userEmail);
            return;
        }
    }

    public void setUserName(String s)
    {
        if (disabled)
        {
            return;
        } else
        {
            userName = sanitizeAttribute(s);
            handler.cacheUserData(userId, userName, userEmail);
            return;
        }
    }

    boolean shouldPromptUserBeforeSendingCrashReports()
    {
        return ((Boolean)Settings.getInstance().withSettings(new io.fabric.sdk.android.services.settings.Settings.SettingsAccess() {

            final CrashlyticsCore this$0;

            public Boolean usingSettings(SettingsData settingsdata)
            {
                boolean flag = false;
                if (settingsdata.featuresData.promptEnabled)
                {
                    if (!shouldSendReportsWithoutPrompting())
                    {
                        flag = true;
                    }
                    return Boolean.valueOf(flag);
                } else
                {
                    return Boolean.valueOf(false);
                }
            }

            public volatile Object usingSettings(SettingsData settingsdata)
            {
                return usingSettings(settingsdata);
            }

            
            {
                this$0 = CrashlyticsCore.this;
                super();
            }
        }, Boolean.valueOf(false))).booleanValue();
    }

    boolean shouldSendReportsWithoutPrompting()
    {
        return (new PreferenceStoreImpl(this)).get().getBoolean("always_send_reports_opt_in", false);
    }

    public boolean verifyPinning(URL url)
    {
        boolean flag;
        try
        {
            flag = internalVerifyPinning(url);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Fabric.getLogger().e("CrashlyticsCore", "Could not verify SSL pinning", url);
            return false;
        }
        return flag;
    }



}
