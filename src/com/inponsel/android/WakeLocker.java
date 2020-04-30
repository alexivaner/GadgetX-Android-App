// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android;

import android.content.Context;
import android.os.PowerManager;

public abstract class WakeLocker
{

    private static android.os.PowerManager.WakeLock wakeLock;

    public WakeLocker()
    {
    }

    public static void acquire(Context context)
    {
        if (wakeLock != null)
        {
            wakeLock.release();
        }
        wakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(0x3000001a, "WakeLock");
        wakeLock.acquire();
    }

    public static void release()
    {
        if (wakeLock != null)
        {
            wakeLock.release();
        }
        wakeLock = null;
    }
}
