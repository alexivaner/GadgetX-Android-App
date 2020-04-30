// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzpa, zzpf

class eApiClient extends a
{

    final zzpa zzamN;
    final List zzamQ;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzpf));
    }

    protected void zza(zzpf zzpf1)
        throws RemoteException
    {
        com.google.android.gms.location.  = new com.google.android.gms.location.zzf.zzb() {

            final zzpa._cls3 zzamR;

            public void zzb(int i, PendingIntent pendingintent)
            {
                Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
            }

            public void zzb(int i, String as[])
            {
                zzamR.setResult(LocationStatusCodes.zzfr(i));
            }

            
            {
                zzamR = zzpa._cls3.this;
                super();
            }
        };
        zzpf1.zza(zzamQ, );
    }

    eApiClient(zzpa zzpa1, GoogleApiClient googleapiclient, List list)
    {
        zzamN = zzpa1;
        zzamQ = list;
        super(googleapiclient);
    }
}
