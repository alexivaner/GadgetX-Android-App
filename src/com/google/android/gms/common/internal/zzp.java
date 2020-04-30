// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zztc;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzx

public final class zzp
{

    private final String zzQq;

    public zzp(String s)
    {
        zzQq = (String)zzx.zzl(s);
    }

    public void zza(Context context, String s, String s1, Throwable throwable)
    {
        StackTraceElement astacktraceelement[] = throwable.getStackTrace();
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < astacktraceelement.length && i < 2; i++)
        {
            stringbuilder.append(astacktraceelement[i].toString());
            stringbuilder.append("\n");
        }

        context = new zztc(context, 10);
        context.zza("GMS_WTF", null, new String[] {
            "GMS_WTF", stringbuilder.toString()
        });
        context.send();
        if (zzaK(7))
        {
            Log.e(s, s1, throwable);
            Log.wtf(s, s1, throwable);
        }
    }

    public void zza(String s, String s1, Throwable throwable)
    {
        if (zzaK(4))
        {
            Log.i(s, s1, throwable);
        }
    }

    public boolean zzaK(int i)
    {
        return Log.isLoggable(zzQq, i);
    }

    public void zzb(String s, String s1, Throwable throwable)
    {
        if (zzaK(5))
        {
            Log.w(s, s1, throwable);
        }
    }

    public void zzc(String s, String s1, Throwable throwable)
    {
        if (zzaK(6))
        {
            Log.e(s, s1, throwable);
        }
    }

    public void zzq(String s, String s1)
    {
        if (zzaK(3))
        {
            Log.d(s, s1);
        }
    }

    public void zzr(String s, String s1)
    {
        if (zzaK(5))
        {
            Log.w(s, s1);
        }
    }

    public void zzs(String s, String s1)
    {
        if (zzaK(6))
        {
            Log.e(s, s1);
        }
    }
}
