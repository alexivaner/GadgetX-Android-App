// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;

public final class L
{

    private static final String LOG_FORMAT = "%1$s\n%2$s";
    private static volatile boolean writeDebugLogs = false;
    private static volatile boolean writeLogs = true;

    private L()
    {
    }

    public static transient void d(String s, Object aobj[])
    {
        if (writeDebugLogs)
        {
            log(3, null, s, aobj);
        }
    }

    public static void disableLogging()
    {
        writeLogs(false);
    }

    public static transient void e(String s, Object aobj[])
    {
        log(6, null, s, aobj);
    }

    public static void e(Throwable throwable)
    {
        log(6, throwable, null, new Object[0]);
    }

    public static transient void e(Throwable throwable, String s, Object aobj[])
    {
        log(6, throwable, s, aobj);
    }

    public static void enableLogging()
    {
        writeLogs(true);
    }

    public static transient void i(String s, Object aobj[])
    {
        log(4, null, s, aobj);
    }

    private static transient void log(int j, Throwable throwable, String s, Object aobj[])
    {
        if (!writeLogs)
        {
            return;
        }
        String s1 = s;
        if (aobj.length > 0)
        {
            s1 = String.format(s, aobj);
        }
        if (throwable != null)
        {
            if (s1 == null)
            {
                s = throwable.getMessage();
            } else
            {
                s = s1;
            }
            s1 = String.format("%1$s\n%2$s", new Object[] {
                s, Log.getStackTraceString(throwable)
            });
        }
        Log.println(j, ImageLoader.TAG, s1);
    }

    public static transient void w(String s, Object aobj[])
    {
        log(5, null, s, aobj);
    }

    public static void writeDebugLogs(boolean flag)
    {
        writeDebugLogs = flag;
    }

    public static void writeLogs(boolean flag)
    {
        writeLogs = flag;
    }

}
