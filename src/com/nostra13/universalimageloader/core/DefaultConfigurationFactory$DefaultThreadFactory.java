// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            DefaultConfigurationFactory

private static class poolNumber
    implements ThreadFactory
{

    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group = Thread.currentThread().getThreadGroup();
    private final String namePrefix;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final int threadPriority;

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(group, runnable, (new StringBuilder(String.valueOf(namePrefix))).append(threadNumber.getAndIncrement()).toString(), 0L);
        if (runnable.isDaemon())
        {
            runnable.setDaemon(false);
        }
        runnable.setPriority(threadPriority);
        return runnable;
    }


    (int i, String s)
    {
        threadPriority = i;
        namePrefix = (new StringBuilder(String.valueOf(s))).append(poolNumber.getAndIncrement()).append("-thread-").toString();
    }
}
