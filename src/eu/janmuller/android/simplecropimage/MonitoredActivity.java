// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public class MonitoredActivity extends Activity
{
    public static class LifeCycleAdapter
        implements LifeCycleListener
    {

        public void onActivityCreated(MonitoredActivity monitoredactivity)
        {
        }

        public void onActivityDestroyed(MonitoredActivity monitoredactivity)
        {
        }

        public void onActivityPaused(MonitoredActivity monitoredactivity)
        {
        }

        public void onActivityResumed(MonitoredActivity monitoredactivity)
        {
        }

        public void onActivityStarted(MonitoredActivity monitoredactivity)
        {
        }

        public void onActivityStopped(MonitoredActivity monitoredactivity)
        {
        }

        public LifeCycleAdapter()
        {
        }
    }

    public static interface LifeCycleListener
    {

        public abstract void onActivityCreated(MonitoredActivity monitoredactivity);

        public abstract void onActivityDestroyed(MonitoredActivity monitoredactivity);

        public abstract void onActivityPaused(MonitoredActivity monitoredactivity);

        public abstract void onActivityResumed(MonitoredActivity monitoredactivity);

        public abstract void onActivityStarted(MonitoredActivity monitoredactivity);

        public abstract void onActivityStopped(MonitoredActivity monitoredactivity);
    }


    private final ArrayList mListeners = new ArrayList();

    public MonitoredActivity()
    {
    }

    public void addLifeCycleListener(LifeCycleListener lifecyclelistener)
    {
        if (mListeners.contains(lifecyclelistener))
        {
            return;
        } else
        {
            mListeners.add(lifecyclelistener);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = mListeners.iterator();
        do
        {
            if (!bundle.hasNext())
            {
                return;
            }
            ((LifeCycleListener)bundle.next()).onActivityCreated(this);
        } while (true);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        Iterator iterator = mListeners.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            ((LifeCycleListener)iterator.next()).onActivityDestroyed(this);
        } while (true);
    }

    protected void onStart()
    {
        super.onStart();
        Iterator iterator = mListeners.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            ((LifeCycleListener)iterator.next()).onActivityStarted(this);
        } while (true);
    }

    protected void onStop()
    {
        super.onStop();
        Iterator iterator = mListeners.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            ((LifeCycleListener)iterator.next()).onActivityStopped(this);
        } while (true);
    }

    public void removeLifeCycleListener(LifeCycleListener lifecyclelistener)
    {
        mListeners.remove(lifecyclelistener);
    }
}
