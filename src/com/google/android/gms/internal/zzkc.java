// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

public class zzkc
{

    private static boolean zzKR = false;
    protected final String mTag;
    private boolean zzKS;
    private boolean zzKT;
    private String zzKU;

    public zzkc(String s)
    {
        this(s, zzhG());
    }

    public zzkc(String s, boolean flag)
    {
        mTag = s;
        zzKS = flag;
        zzKT = false;
    }

    public static boolean zzhG()
    {
        return zzKR;
    }

    public transient void zza(String s, Object aobj[])
    {
        if (zzhF())
        {
            Log.v(mTag, zze(s, aobj));
        }
    }

    public transient void zza(Throwable throwable, String s, Object aobj[])
    {
        if (zzhE() || zzKR)
        {
            Log.d(mTag, zze(s, aobj), throwable);
        }
    }

    public void zzaP(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            s = null;
        } else
        {
            s = String.format("[%s] ", new Object[] {
                s
            });
        }
        zzKU = s;
    }

    public transient void zzb(String s, Object aobj[])
    {
        if (zzhE() || zzKR)
        {
            Log.d(mTag, zze(s, aobj));
        }
    }

    public transient void zzc(String s, Object aobj[])
    {
        Log.i(mTag, zze(s, aobj));
    }

    public transient void zzd(String s, Object aobj[])
    {
        Log.w(mTag, zze(s, aobj));
    }

    protected transient String zze(String s, Object aobj[])
    {
        if (aobj.length != 0)
        {
            s = String.format(Locale.ROOT, s, aobj);
        }
        aobj = s;
        if (!TextUtils.isEmpty(zzKU))
        {
            aobj = (new StringBuilder()).append(zzKU).append(s).toString();
        }
        return ((String) (aobj));
    }

    public boolean zzhE()
    {
        return zzKS;
    }

    public boolean zzhF()
    {
        return zzKT;
    }

}
