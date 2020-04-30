// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import io.fabric.sdk.android.ActivityLifecycleManager;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionMetadataCollector, AnswersFilesManagerProvider, BackgroundManager, AnswersEventsHandler, 
//            AnswersPreferenceManager, AnswersLifecycleCallbacks, SessionEvent, CustomEvent, 
//            PredefinedEvent

class SessionAnalyticsManager
    implements BackgroundManager.Listener
{

    static final String EXECUTOR_SERVICE = "Answers Events Handler";
    static final long FIRST_LAUNCH_INTERVAL_IN_MS = 0x36ee80L;
    static final String ON_CRASH_ERROR_MSG = "onCrash called from main thread!!!";
    final BackgroundManager backgroundManager;
    final AnswersEventsHandler eventsHandler;
    private final long installedAt;
    final ActivityLifecycleManager lifecycleManager;
    final AnswersPreferenceManager preferenceManager;

    SessionAnalyticsManager(AnswersEventsHandler answerseventshandler, ActivityLifecycleManager activitylifecyclemanager, BackgroundManager backgroundmanager, AnswersPreferenceManager answerspreferencemanager, long l)
    {
        eventsHandler = answerseventshandler;
        lifecycleManager = activitylifecyclemanager;
        backgroundManager = backgroundmanager;
        preferenceManager = answerspreferencemanager;
        installedAt = l;
    }

    public static SessionAnalyticsManager build(Kit kit, Context context, IdManager idmanager, String s, String s1, long l)
    {
        idmanager = new SessionMetadataCollector(context, idmanager, s, s1);
        s = new AnswersFilesManagerProvider(context, new FileStoreImpl(kit));
        s1 = new DefaultHttpRequestFactory(Fabric.getLogger());
        ActivityLifecycleManager activitylifecyclemanager = new ActivityLifecycleManager(context);
        java.util.concurrent.ScheduledExecutorService scheduledexecutorservice = ExecutorUtils.buildSingleThreadScheduledExecutorService("Answers Events Handler");
        BackgroundManager backgroundmanager = new BackgroundManager(scheduledexecutorservice);
        return new SessionAnalyticsManager(new AnswersEventsHandler(kit, context, s, idmanager, s1, scheduledexecutorservice), activitylifecyclemanager, backgroundmanager, AnswersPreferenceManager.build(context), l);
    }

    public void disable()
    {
        lifecycleManager.resetCallbacks();
        eventsHandler.disable();
    }

    public void enable()
    {
        eventsHandler.enable();
        lifecycleManager.registerCallbacks(new AnswersLifecycleCallbacks(this, backgroundManager));
        backgroundManager.registerListener(this);
        if (isFirstLaunch(installedAt))
        {
            onInstall();
            preferenceManager.setAnalyticsLaunched();
        }
    }

    boolean installedRecently(long l)
    {
        return System.currentTimeMillis() - l < 0x36ee80L;
    }

    boolean isFirstLaunch(long l)
    {
        return !preferenceManager.hasAnalyticsLaunched() && installedRecently(l);
    }

    public void onBackground()
    {
        Fabric.getLogger().d("Answers", "Flush events when app is backgrounded");
        eventsHandler.flushEvents();
    }

    public void onCrash(String s)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new IllegalStateException("onCrash called from main thread!!!");
        } else
        {
            Fabric.getLogger().d("Answers", "Logged crash");
            eventsHandler.processEventSync(SessionEvent.crashEventBuilder(s));
            return;
        }
    }

    public void onCustom(CustomEvent customevent)
    {
        Fabric.getLogger().d("Answers", (new StringBuilder()).append("Logged custom event: ").append(customevent).toString());
        eventsHandler.processEventAsync(SessionEvent.customEventBuilder(customevent));
    }

    public void onError(String s)
    {
    }

    public void onInstall()
    {
        Fabric.getLogger().d("Answers", "Logged install");
        eventsHandler.processEventAsyncAndFlush(SessionEvent.installEventBuilder());
    }

    public void onLifecycle(Activity activity, SessionEvent.Type type)
    {
        Fabric.getLogger().d("Answers", (new StringBuilder()).append("Logged lifecycle event: ").append(type.name()).toString());
        eventsHandler.processEventAsync(SessionEvent.lifecycleEventBuilder(type, activity));
    }

    public void onPredefined(PredefinedEvent predefinedevent)
    {
        Fabric.getLogger().d("Answers", (new StringBuilder()).append("Logged predefined event: ").append(predefinedevent).toString());
        eventsHandler.processEventAsync(SessionEvent.predefinedEventBuilder(predefinedevent));
    }

    public void setAnalyticsSettingsData(AnalyticsSettingsData analyticssettingsdata, String s)
    {
        backgroundManager.setFlushOnBackground(analyticssettingsdata.flushOnBackground);
        eventsHandler.setAnalyticsSettingsData(analyticssettingsdata, s);
    }
}
