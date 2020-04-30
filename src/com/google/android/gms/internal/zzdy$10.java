// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzdy, zzdz, zzdt, zzhx

class zzsW
    implements Runnable
{

    final zzdy zzsV;
    final com.google.ads.t.ErrorCode zzsW;

    public void run()
    {
        try
        {
            zzdy.zza(zzsV).onAdFailedToLoad(zzdz.zza(zzsW));
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Could not call onAdFailedToLoad.", remoteexception);
        }
    }

    (zzdy zzdy1, com.google.ads.t.ErrorCode errorcode)
    {
        zzsV = zzdy1;
        zzsW = errorcode;
        super();
    }
}
