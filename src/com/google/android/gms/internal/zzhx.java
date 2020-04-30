// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Log;

public final class zzhx
{

    public static boolean zzA(int i)
    {
        return (i >= 5 || Log.isLoggable("Ads", i)) && i != 2;
    }

    public static void zzY(String s)
    {
        if (zzA(3))
        {
            Log.d("Ads", s);
        }
    }

    public static void zzZ(String s)
    {
        if (zzA(6))
        {
            Log.e("Ads", s);
        }
    }

    public static void zza(String s, Throwable throwable)
    {
        if (zzA(3))
        {
            Log.d("Ads", s, throwable);
        }
    }

    public static void zzaa(String s)
    {
        if (zzA(4))
        {
            Log.i("Ads", s);
        }
    }

    public static void zzab(String s)
    {
        if (zzA(2))
        {
            Log.v("Ads", s);
        }
    }

    public static void zzac(String s)
    {
        if (zzA(5))
        {
            Log.w("Ads", s);
        }
    }

    public static void zzb(String s, Throwable throwable)
    {
        if (zzA(6))
        {
            Log.e("Ads", s, throwable);
        }
    }

    public static void zzc(String s, Throwable throwable)
    {
        if (zzA(4))
        {
            Log.i("Ads", s, throwable);
        }
    }

    public static void zzd(String s, Throwable throwable)
    {
        if (zzA(5))
        {
            Log.w("Ads", s, throwable);
        }
    }
}
