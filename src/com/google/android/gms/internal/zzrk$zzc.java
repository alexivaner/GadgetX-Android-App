// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zzrk

private static final class x.zzl extends x.zzl
{

    private final com.google.android.gms.common.api.nit> zzHa;
    private final zze zzasM;

    public void zza(String s, int i, byte abyte0[])
        throws RemoteException
    {
        zzasM.zza(new com.google.android.gms.common.api.zze.zzb(s, i, abyte0) {

            final int zzKJ;
            final byte zzahb[];
            final String zzasJ;
            final zzrk.zzc zzasN;

            public void zza(com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback connectionresponsecallback)
            {
                connectionresponsecallback.onConnectionResponse(zzasJ, new Status(zzKJ), zzahb);
            }

            public void zze(Object obj)
            {
                zza((com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback)obj);
            }

            public void zzhX()
            {
            }

            
            {
                zzasN = zzrk.zzc.this;
                zzasJ = s;
                zzKJ = i;
                zzahb = abyte0;
                super();
            }
        });
    }

    public void zzgu(int i)
        throws RemoteException
    {
        zzHa.zd(new Status(i));
    }

    public (com.google.android.gms.common.api.zzahb zzahb, zze zze1, zze zze2)
    {
        super(zze2);
        zzHa = (com.google.android.gms.common.api.Ha)zzx.zzl(zzahb);
        zzasM = (zze)zzx.zzl(zze1);
    }
}
