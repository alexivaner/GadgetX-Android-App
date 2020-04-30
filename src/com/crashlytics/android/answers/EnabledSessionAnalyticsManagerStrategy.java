// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.events.TimeBasedFileRollOverRunnable;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionAnalyticsManagerStrategy, KeepAllEventFilter, SessionAnalyticsFilesManager, SessionEvent, 
//            EventFilter, SessionAnalyticsFilesSender, AnswersRetryFilesSender, SamplingEventFilter, 
//            SessionEventMetadata

class EnabledSessionAnalyticsManagerStrategy
    implements SessionAnalyticsManagerStrategy
{

    static final int UNDEFINED_ROLLOVER_INTERVAL_SECONDS = -1;
    ApiKey apiKey;
    private final Context context;
    boolean customEventsEnabled;
    EventFilter eventFilter;
    private final ScheduledExecutorService executorService;
    private final SessionAnalyticsFilesManager filesManager;
    FilesSender filesSender;
    private final HttpRequestFactory httpRequestFactory;
    private final Kit kit;
    final SessionEventMetadata metadata;
    boolean predefinedEventsEnabled;
    private final AtomicReference rolloverFutureRef = new AtomicReference();
    volatile int rolloverIntervalSeconds;

    public EnabledSessionAnalyticsManagerStrategy(Kit kit1, Context context1, ScheduledExecutorService scheduledexecutorservice, SessionAnalyticsFilesManager sessionanalyticsfilesmanager, HttpRequestFactory httprequestfactory, SessionEventMetadata sessioneventmetadata)
    {
        apiKey = new ApiKey();
        eventFilter = new KeepAllEventFilter();
        customEventsEnabled = true;
        predefinedEventsEnabled = true;
        rolloverIntervalSeconds = -1;
        kit = kit1;
        context = context1;
        executorService = scheduledexecutorservice;
        filesManager = sessionanalyticsfilesmanager;
        httpRequestFactory = httprequestfactory;
        metadata = sessioneventmetadata;
    }

    public void cancelTimeBasedFileRollOver()
    {
        if (rolloverFutureRef.get() != null)
        {
            CommonUtils.logControlled(context, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture)rolloverFutureRef.get()).cancel(false);
            rolloverFutureRef.set(null);
        }
    }

    public void deleteAllEvents()
    {
        filesManager.deleteAllEventsFiles();
    }

    public void processEvent(SessionEvent.Builder builder)
    {
        builder = builder.build(metadata);
        if (!customEventsEnabled && SessionEvent.Type.CUSTOM.equals(((SessionEvent) (builder)).type))
        {
            Fabric.getLogger().d("Answers", (new StringBuilder()).append("Custom events tracking disabled - skipping event: ").append(builder).toString());
            return;
        }
        if (!predefinedEventsEnabled && SessionEvent.Type.PREDEFINED.equals(((SessionEvent) (builder)).type))
        {
            Fabric.getLogger().d("Answers", (new StringBuilder()).append("Predefined events tracking disabled - skipping event: ").append(builder).toString());
            return;
        }
        if (eventFilter.skipEvent(builder))
        {
            Fabric.getLogger().d("Answers", (new StringBuilder()).append("Skipping filtered event: ").append(builder).toString());
            return;
        }
        try
        {
            filesManager.writeEvent(builder);
        }
        catch (IOException ioexception)
        {
            Fabric.getLogger().e("Answers", (new StringBuilder()).append("Failed to write event: ").append(builder).toString(), ioexception);
        }
        scheduleTimeBasedRollOverIfNeeded();
    }

    public boolean rollFileOver()
    {
        boolean flag;
        try
        {
            flag = filesManager.rollFileOver();
        }
        catch (IOException ioexception)
        {
            CommonUtils.logControlledError(context, "Failed to roll file over.", ioexception);
            return false;
        }
        return flag;
    }

    void scheduleTimeBasedFileRollOver(long l, long l1)
    {
        TimeBasedFileRollOverRunnable timebasedfilerolloverrunnable;
        boolean flag;
        if (rolloverFutureRef.get() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        timebasedfilerolloverrunnable = new TimeBasedFileRollOverRunnable(context, this);
        CommonUtils.logControlled(context, (new StringBuilder()).append("Scheduling time based file roll over every ").append(l1).append(" seconds").toString());
        rolloverFutureRef.set(executorService.scheduleAtFixedRate(timebasedfilerolloverrunnable, l, l1, TimeUnit.SECONDS));
        return;
        RejectedExecutionException rejectedexecutionexception;
        rejectedexecutionexception;
        CommonUtils.logControlledError(context, "Failed to schedule time based file roll over", rejectedexecutionexception);
        return;
    }

    public void scheduleTimeBasedRollOverIfNeeded()
    {
        boolean flag;
        if (rolloverIntervalSeconds != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            scheduleTimeBasedFileRollOver(rolloverIntervalSeconds, rolloverIntervalSeconds);
        }
    }

    public void sendEvents()
    {
        if (filesSender != null) goto _L2; else goto _L1
_L1:
        CommonUtils.logControlled(context, "skipping files send because we don't yet know the target endpoint");
_L6:
        return;
_L2:
        List list;
        int j;
        CommonUtils.logControlled(context, "Sending all files");
        j = 0;
        list = filesManager.getBatchOfFilesToSend();
_L7:
        int i;
        int k;
        k = j;
        i = j;
        if (list.size() <= 0) goto _L4; else goto _L3
_L3:
        i = j;
        CommonUtils.logControlled(context, String.format(Locale.US, "attempt to send batch of %d files", new Object[] {
            Integer.valueOf(list.size())
        }));
        i = j;
        boolean flag = filesSender.send(list);
        k = j;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        i = j;
        k = j + list.size();
        i = k;
        filesManager.deleteSentFiles(list);
        if (flag) goto _L5; else goto _L4
_L4:
        if (k == 0)
        {
            filesManager.deleteOldestInRollOverIfOverMax();
            return;
        }
          goto _L6
_L5:
        i = k;
        list = filesManager.getBatchOfFilesToSend();
        j = k;
          goto _L7
        Exception exception;
        exception;
        CommonUtils.logControlledError(context, (new StringBuilder()).append("Failed to send batch of analytics files to server: ").append(exception.getMessage()).toString(), exception);
        k = i;
          goto _L4
    }

    public void setAnalyticsSettingsData(AnalyticsSettingsData analyticssettingsdata, String s)
    {
        filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(kit, s, analyticssettingsdata.analyticsURL, httpRequestFactory, apiKey.getValue(context)));
        filesManager.setAnalyticsSettingsData(analyticssettingsdata);
        customEventsEnabled = analyticssettingsdata.trackCustomEvents;
        Logger logger = Fabric.getLogger();
        StringBuilder stringbuilder = (new StringBuilder()).append("Custom event tracking ");
        if (customEventsEnabled)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        logger.d("Answers", stringbuilder.append(s).toString());
        predefinedEventsEnabled = analyticssettingsdata.trackPredefinedEvents;
        logger = Fabric.getLogger();
        stringbuilder = (new StringBuilder()).append("Predefined event tracking ");
        if (predefinedEventsEnabled)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        logger.d("Answers", stringbuilder.append(s).toString());
        if (analyticssettingsdata.samplingRate > 1)
        {
            Fabric.getLogger().d("Answers", "Event sampling enabled");
            eventFilter = new SamplingEventFilter(analyticssettingsdata.samplingRate);
        }
        rolloverIntervalSeconds = analyticssettingsdata.flushIntervalSeconds;
        scheduleTimeBasedFileRollOver(0L, rolloverIntervalSeconds);
    }
}
