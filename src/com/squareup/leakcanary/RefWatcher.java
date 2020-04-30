// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.leakcanary;

import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.leakcanary:
//            GcTrigger, Preconditions, DebuggerControl, HeapDumper, 
//            KeyedWeakReference, HeapDump

public final class RefWatcher
{

    public static final RefWatcher DISABLED;
    private final DebuggerControl debuggerControl;
    private final GcTrigger gcTrigger;
    private final HeapDumper heapDumper;
    private final HeapDump.Listener heapdumpListener;
    private final ReferenceQueue queue = new ReferenceQueue();
    private final Set retainedKeys = new CopyOnWriteArraySet();
    private final Executor watchExecutor;

    public RefWatcher(Executor executor, DebuggerControl debuggercontrol, GcTrigger gctrigger, HeapDumper heapdumper, HeapDump.Listener listener)
    {
        watchExecutor = (Executor)Preconditions.checkNotNull(executor, "watchExecutor");
        debuggerControl = (DebuggerControl)Preconditions.checkNotNull(debuggercontrol, "debuggerControl");
        gcTrigger = (GcTrigger)Preconditions.checkNotNull(gctrigger, "gcTrigger");
        heapDumper = (HeapDumper)Preconditions.checkNotNull(heapdumper, "heapDumper");
        heapdumpListener = (HeapDump.Listener)Preconditions.checkNotNull(listener, "heapdumpListener");
    }

    private boolean gone(KeyedWeakReference keyedweakreference)
    {
        return !retainedKeys.contains(keyedweakreference.key);
    }

    private void removeWeaklyReachableReferences()
    {
        do
        {
            KeyedWeakReference keyedweakreference = (KeyedWeakReference)queue.poll();
            if (keyedweakreference == null)
            {
                return;
            }
            retainedKeys.remove(keyedweakreference.key);
        } while (true);
    }

    void ensureGone(KeyedWeakReference keyedweakreference, long l)
    {
        long l1 = System.nanoTime();
        l = TimeUnit.NANOSECONDS.toMillis(l1 - l);
        removeWeaklyReachableReferences();
        if (!gone(keyedweakreference) && !debuggerControl.isDebuggerAttached())
        {
            gcTrigger.runGc();
            removeWeaklyReachableReferences();
            if (!gone(keyedweakreference))
            {
                long l2 = System.nanoTime();
                l1 = TimeUnit.NANOSECONDS.toMillis(l2 - l1);
                File file = heapDumper.dumpHeap();
                if (file != null)
                {
                    l2 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l2);
                    heapdumpListener.analyze(new HeapDump(file, keyedweakreference.key, keyedweakreference.name, l, l1, l2));
                    return;
                }
            }
        }
    }

    public void watch(Object obj)
    {
        watch(obj, "");
    }

    public void watch(final Object reference, String s)
    {
        Preconditions.checkNotNull(reference, "watchedReference");
        Preconditions.checkNotNull(s, "referenceName");
        if (debuggerControl.isDebuggerAttached())
        {
            return;
        } else
        {
            final long watchStartNanoTime = System.nanoTime();
            String s1 = UUID.randomUUID().toString();
            retainedKeys.add(s1);
            reference = new KeyedWeakReference(reference, s1, s, queue);
            watchExecutor.execute(new Runnable() {

                final RefWatcher this$0;
                private final KeyedWeakReference val$reference;
                private final long val$watchStartNanoTime;

                public void run()
                {
                    ensureGone(reference, watchStartNanoTime);
                }

            
            {
                this$0 = RefWatcher.this;
                reference = keyedweakreference;
                watchStartNanoTime = l;
                super();
            }
            });
            return;
        }
    }

    static 
    {
        DISABLED = new RefWatcher(new Executor() {

            public void execute(Runnable runnable)
            {
            }

        }, new DebuggerControl() {

            public boolean isDebuggerAttached()
            {
                return true;
            }

        }, GcTrigger.DEFAULT, new HeapDumper() {

            public File dumpHeap()
            {
                return null;
            }

        }, new HeapDump.Listener() {

            public void analyze(HeapDump heapdump)
            {
            }

        });
    }
}
