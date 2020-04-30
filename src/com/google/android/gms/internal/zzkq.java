// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzkp, zzkn, zzks, zzku

public final class zzkq
    implements zzkp
{
    private static class zza extends zzkn
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;

        public void zzaQ(int i)
            throws RemoteException
        {
            zzHa.zzd(new Status(i));
        }

        public zza(com.google.android.gms.common.api.zza.zzb zzb)
        {
            zzHa = zzb;
        }
    }


    public zzkq()
    {
    }

    public PendingResult zzc(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzkr.zza(googleapiclient) {

            final zzkq zzQz;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzks)zza1);
            }

            protected void zza(zzks zzks1)
                throws RemoteException
            {
                ((zzku)zzks1.zzjb()).zza(new zza(this));
            }

            
            {
                zzQz = zzkq.this;
                super(googleapiclient);
            }
        });
    }
}
