// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zzrj, zzrk

private static final class x.zzl extends zzrj
{

    private final com.google.android.gms.common.api.nit> zzHa;
    private final zze zzasO;

    public void onConnectionRequest(String s, String s1, String s2, byte abyte0[])
        throws RemoteException
    {
        zzasO.zza(new com.google.android.gms.common.api.zze.zzb(s, s1, s2, abyte0) {

            final byte zzahb[];
            final String zzasJ;
            final String zzasP;
            final String zzasQ;
            final zzrk.zzd zzasR;

            public void zza(com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener connectionrequestlistener)
            {
                connectionrequestlistener.onConnectionRequest(zzasJ, zzasP, zzasQ, zzahb);
            }

            public void zze(Object obj)
            {
                zza((com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener)obj);
            }

            public void zzhX()
            {
            }

            
            {
                zzasR = zzrk.zzd.this;
                zzasJ = s;
                zzasP = s1;
                zzasQ = s2;
                zzahb = abyte0;
                super();
            }
        });
    }

    public void zzi(int i, String s)
        throws RemoteException
    {
        zzHa.zd(new <init>(new Status(i), s));
    }

    (com.google.android.gms.common.api.zzahb zzahb, zze zze1)
    {
        zzHa = (com.google.android.gms.common.api.Ha)zzx.zzl(zzahb);
        zzasO = (zze)zzx.zzl(zze1);
    }
}
