// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;

// Referenced classes of package com.google.android.gms.internal:
//            zztd

public class zztc
    implements zztd.zza
{

    private final zztd zzatI;
    private boolean zzatJ;

    public zztc(Context context, int i)
    {
        this(context, i, null);
    }

    public zztc(Context context, int i, String s)
    {
        this(context, i, s, null, true);
    }

    public zztc(Context context, int i, String s, String s1, boolean flag)
    {
        String s2;
        if (context != context.getApplicationContext())
        {
            s2 = context.getClass().getName();
        } else
        {
            s2 = "OneTimePlayLogger";
        }
        zzatI = new zztd(context, i, s, s1, this, flag, s2);
        zzatJ = true;
    }

    private void zzrD()
    {
        if (!zzatJ)
        {
            throw new IllegalStateException("Cannot reuse one-time logger after sending.");
        } else
        {
            return;
        }
    }

    public void send()
    {
        zzrD();
        zzatI.start();
        zzatJ = false;
    }

    public transient void zza(String s, byte abyte0[], String as[])
    {
        zzrD();
        zzatI.zzb(s, abyte0, as);
    }

    public void zzf(PendingIntent pendingintent)
    {
        Log.w("OneTimePlayLogger", (new StringBuilder()).append("logger connection failed: ").append(pendingintent).toString());
    }

    public void zzrE()
    {
        zzatI.stop();
    }

    public void zzrF()
    {
        Log.w("OneTimePlayLogger", "logger connection failed");
    }
}
