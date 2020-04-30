// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class BackgroundManager
{
    public static interface Listener
    {

        public abstract void onBackground();
    }


    private static final int BACKGROUND_DELAY = 5000;
    final AtomicReference backgroundFutureRef = new AtomicReference();
    private final ScheduledExecutorService executorService;
    private volatile boolean flushOnBackground;
    boolean inBackground;
    private final List listeners = new ArrayList();

    public BackgroundManager(ScheduledExecutorService scheduledexecutorservice)
    {
        flushOnBackground = true;
        inBackground = true;
        executorService = scheduledexecutorservice;
    }

    private void notifyBackground()
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((Listener)iterator.next()).onBackground()) { }
    }

    public void onActivityPaused()
    {
        if (!flushOnBackground || inBackground)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        inBackground = true;
        backgroundFutureRef.compareAndSet(null, executorService.schedule(new Runnable() {

            final BackgroundManager this$0;

            public void run()
            {
                backgroundFutureRef.set(null);
                notifyBackground();
            }

            
            {
                this$0 = BackgroundManager.this;
                super();
            }
        }, 5000L, TimeUnit.MILLISECONDS));
        return;
        RejectedExecutionException rejectedexecutionexception;
        rejectedexecutionexception;
        Fabric.getLogger().d("Answers", "Failed to schedule background detector", rejectedexecutionexception);
        return;
    }

    public void onActivityResumed()
    {
        inBackground = false;
        ScheduledFuture scheduledfuture = (ScheduledFuture)backgroundFutureRef.getAndSet(null);
        if (scheduledfuture != null)
        {
            scheduledfuture.cancel(false);
        }
    }

    public void registerListener(Listener listener)
    {
        listeners.add(listener);
    }

    public void setFlushOnBackground(boolean flag)
    {
        flushOnBackground = flag;
    }

}
