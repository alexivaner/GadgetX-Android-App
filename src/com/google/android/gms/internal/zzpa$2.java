// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationStatusCodes;

// Referenced classes of package com.google.android.gms.internal:
//            zzpa, zzpf

class eApiClient extends a
{

    final PendingIntent zzaaA;
    final zzpa zzamN;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzpf));
    }

    protected void zza(zzpf zzpf1)
        throws RemoteException
    {
        com.google.android.gms.location.  = new com.google.android.gms.location.zzf.zzb() {

            final zzpa._cls2 zzamP;

            public void zzb(int i, PendingIntent pendingintent)
            {
                zzamP.setResult(LocationStatusCodes.zzfr(i));
            }

            public void zzb(int i, String as[])
            {
                Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
            }

            
            {
                zzamP = zzpa._cls2.this;
                super();
            }
        };
        zzpf1.zza(zzaaA, );
    }

    eApiClient(zzpa zzpa1, GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        zzamN = zzpa1;
        zzaaA = pendingintent;
        super(googleapiclient);
    }
}
