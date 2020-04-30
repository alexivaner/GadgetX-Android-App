// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationStatusCodes;

// Referenced classes of package com.google.android.gms.internal:
//            zzpa, zzpf

class eApiClient extends a
{

    final PendingIntent zzaaA;
    final GeofencingRequest zzamM;
    final zzpa zzamN;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzpf));
    }

    protected void zza(zzpf zzpf1)
        throws RemoteException
    {
        com.google.android.gms.location.  = new com.google.android.gms.location.zzf.zza() {

            final zzpa._cls1 zzamO;

            public void zza(int i, String as[])
            {
                zzamO.setResult(LocationStatusCodes.zzfr(i));
            }

            
            {
                zzamO = zzpa._cls1.this;
                super();
            }
        };
        zzpf1.zza(zzamM, zzaaA, );
    }

    eApiClient(zzpa zzpa1, GoogleApiClient googleapiclient, GeofencingRequest geofencingrequest, PendingIntent pendingintent)
    {
        zzamN = zzpa1;
        zzamM = geofencingrequest;
        zzaaA = pendingintent;
        super(googleapiclient);
    }
}
