// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Binder;
import java.util.Iterator;
import java.util.List;

public class zzmf
{

    public static String zzR(Context context)
    {
        return zzj(context, Binder.getCallingPid());
    }

    private static String zza(StackTraceElement astacktraceelement[], int i)
    {
        if (i + 4 >= astacktraceelement.length)
        {
            return "<bottom of call stack>";
        } else
        {
            astacktraceelement = astacktraceelement[i + 4];
            return (new StringBuilder()).append(astacktraceelement.getClassName()).append(".").append(astacktraceelement.getMethodName()).append(":").append(astacktraceelement.getLineNumber()).toString();
        }
    }

    public static String zzj(Context context, int i)
    {
label0:
        {
            context = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses();
            if (context == null)
            {
                break label0;
            }
            context = context.iterator();
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
            do
            {
                if (!context.hasNext())
                {
                    break label0;
                }
                runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)context.next();
            } while (runningappprocessinfo.pid != i);
            return runningappprocessinfo.processName;
        }
        return null;
    }

    public static String zzl(int i, int j)
    {
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        StringBuffer stringbuffer = new StringBuffer();
        for (int k = i; k < j + i; k++)
        {
            stringbuffer.append(zza(astacktraceelement, k)).append(" ");
        }

        return stringbuffer.toString();
    }
}
