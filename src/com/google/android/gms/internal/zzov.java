// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;

// Referenced classes of package com.google.android.gms.internal:
//            zzpf

public class zzov
    implements ActivityRecognitionApi
{
    private static abstract class zza extends com.google.android.gms.location.ActivityRecognition.zza
    {

        public Result createFailedResult(Status status)
        {
            return zzb(status);
        }

        public Status zzb(Status status)
        {
            return status;
        }

        public zza(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }


    public zzov()
    {
    }

    public PendingResult removeActivityUpdates(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zza(googleapiclient, pendingintent) {

            final PendingIntent zzamC;
            final zzov zzamD;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpf)zza1);
            }

            protected void zza(zzpf zzpf1)
                throws RemoteException
            {
                zzpf1.zza(zzamC);
                setResult(Status.zzNo);
            }

            
            {
                zzamD = zzov.this;
                zzamC = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult requestActivityUpdates(GoogleApiClient googleapiclient, long l, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zza(googleapiclient, l, pendingintent) {

            final long zzamB;
            final PendingIntent zzamC;
            final zzov zzamD;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpf)zza1);
            }

            protected void zza(zzpf zzpf1)
                throws RemoteException
            {
                zzpf1.zza(zzamB, zzamC);
                setResult(Status.zzNo);
            }

            
            {
                zzamD = zzov.this;
                zzamB = l;
                zzamC = pendingintent;
                super(googleapiclient);
            }
        });
    }
}
