// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.zzf;

// Referenced classes of package com.google.android.gms.internal:
//            zztj, zztl, zzti, zztf

public class zztd
{
    public static interface zza
    {

        public abstract void zzf(PendingIntent pendingintent);

        public abstract void zzrE();

        public abstract void zzrF();
    }


    private final zztl zzatK;
    private zztj zzatL;

    public zztd(Context context, int i, String s, String s1, zza zza1, boolean flag, String s2)
    {
        String s3;
        int j;
        s3 = context.getPackageName();
        j = 0;
        int k = context.getPackageManager().getPackageInfo(s3, 0).versionCode;
        j = k;
_L2:
        zzatL = new zztj(s3, j, i, s, s1, flag);
        zzatK = new zztl(context, context.getMainLooper(), new zzti(zza1), new zzf(null, null, 49, null, s3, s2, null));
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.wtf("PlayLogger", "This can't happen.");
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void start()
    {
        zzatK.start();
    }

    public void stop()
    {
        zzatK.stop();
    }

    public transient void zza(long l, String s, byte abyte0[], String as[])
    {
        zzatK.zzb(zzatL, new zztf(l, s, abyte0, as));
    }

    public transient void zzb(String s, byte abyte0[], String as[])
    {
        zza(System.currentTimeMillis(), s, abyte0, as);
    }
}
