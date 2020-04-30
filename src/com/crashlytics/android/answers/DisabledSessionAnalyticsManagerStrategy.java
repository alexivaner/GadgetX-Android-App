// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionAnalyticsManagerStrategy

class DisabledSessionAnalyticsManagerStrategy
    implements SessionAnalyticsManagerStrategy
{

    DisabledSessionAnalyticsManagerStrategy()
    {
    }

    public void cancelTimeBasedFileRollOver()
    {
    }

    public void deleteAllEvents()
    {
    }

    public void processEvent(SessionEvent.Builder builder)
    {
    }

    public boolean rollFileOver()
        throws IOException
    {
        return false;
    }

    public void scheduleTimeBasedRollOverIfNeeded()
    {
    }

    public void sendEvents()
    {
    }

    public void setAnalyticsSettingsData(AnalyticsSettingsData analyticssettingsdata, String s)
    {
    }
}
