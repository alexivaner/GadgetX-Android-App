// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzdy, zzdt, zzhx

class zzsV
    implements Runnable
{

    final zzdy zzsV;

    public void run()
    {
        try
        {
            zzdy.zza(zzsV).onAdClicked();
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzhx.zzd("Could not call onAdClicked.", remoteexception);
        }
    }

    (zzdy zzdy1)
    {
        zzsV = zzdy1;
        super();
    }
}
