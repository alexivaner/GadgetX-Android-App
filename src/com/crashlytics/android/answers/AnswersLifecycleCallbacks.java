// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionAnalyticsManager, BackgroundManager

class AnswersLifecycleCallbacks extends io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
{

    private final SessionAnalyticsManager analyticsManager;
    private final BackgroundManager backgroundManager;

    public AnswersLifecycleCallbacks(SessionAnalyticsManager sessionanalyticsmanager, BackgroundManager backgroundmanager)
    {
        analyticsManager = sessionanalyticsmanager;
        backgroundManager = backgroundmanager;
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public void onActivityDestroyed(Activity activity)
    {
    }

    public void onActivityPaused(Activity activity)
    {
        analyticsManager.onLifecycle(activity, SessionEvent.Type.PAUSE);
        backgroundManager.onActivityPaused();
    }

    public void onActivityResumed(Activity activity)
    {
        analyticsManager.onLifecycle(activity, SessionEvent.Type.RESUME);
        backgroundManager.onActivityResumed();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public void onActivityStarted(Activity activity)
    {
        analyticsManager.onLifecycle(activity, SessionEvent.Type.START);
    }

    public void onActivityStopped(Activity activity)
    {
        analyticsManager.onLifecycle(activity, SessionEvent.Type.STOP);
    }
}
