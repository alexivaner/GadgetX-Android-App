// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzx;

public final class zze
{
    private final class zza extends Handler
    {

        final zze zzNl;

        public void handleMessage(Message message)
        {
            boolean flag = true;
            if (message.what != 1)
            {
                flag = false;
            }
            zzx.zzO(flag);
            zzNl.zzb((zzb)message.obj);
        }

        public zza(Looper looper)
        {
            zzNl = zze.this;
            super(looper);
        }
    }

    public static interface zzb
    {

        public abstract void zze(Object obj);

        public abstract void zzhX();
    }


    private volatile Object mListener;
    private final zza zzNk;

    zze(Looper looper, Object obj)
    {
        zzNk = new zza(looper);
        mListener = zzx.zzb(obj, "Listener must not be null");
    }

    public void clear()
    {
        mListener = null;
    }

    public void zza(zzb zzb1)
    {
        zzx.zzb(zzb1, "Notifier must not be null");
        zzb1 = zzNk.obtainMessage(1, zzb1);
        zzNk.sendMessage(zzb1);
    }

    void zzb(zzb zzb1)
    {
        Object obj = mListener;
        if (obj == null)
        {
            zzb1.zzhX();
            return;
        }
        try
        {
            zzb1.zze(obj);
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            zzb1.zzhX();
            throw runtimeexception;
        }
    }
}
