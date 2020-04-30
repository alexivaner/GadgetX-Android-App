// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.zzat;
import com.google.android.gms.fitness.request.zzax;
import com.google.android.gms.fitness.request.zzw;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

// Referenced classes of package com.google.android.gms.internal:
//            zznd, zznn, zzoh

public class zzoe
    implements RecordingApi
{
    private static class zza extends zznq.zza
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;

        public void zza(ListSubscriptionsResult listsubscriptionsresult)
        {
            zzHa.zzd(listsubscriptionsresult);
        }

        private zza(com.google.android.gms.common.api.zza.zzb zzb)
        {
            zzHa = zzb;
        }

    }


    public zzoe()
    {
    }

    private PendingResult zza(GoogleApiClient googleapiclient, Subscription subscription)
    {
        return googleapiclient.zza(new zznd.zzc(googleapiclient, subscription) {

            final zzoe zzaao;
            final Subscription zzaaq;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zznd)zza1);
            }

            protected void zza(zznd zznd1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s = zznd1.getContext().getPackageName();
                ((zznn)zznd1.zzjb()).zza(new zzat(zzaaq, false, zzoh1, s));
            }

            
            {
                zzaao = zzoe.this;
                zzaaq = subscription;
                super(googleapiclient);
            }
        });
    }

    public PendingResult listSubscriptions(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zznd.zza(googleapiclient) {

            final zzoe zzaao;

            protected Result createFailedResult(Status status)
            {
                return zzx(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zznd)zza1);
            }

            protected void zza(zznd zznd1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                String s = zznd1.getContext().getPackageName();
                ((zznn)zznd1.zzjb()).zza(new zzw(null, zza1, s));
            }

            protected ListSubscriptionsResult zzx(Status status)
            {
                return ListSubscriptionsResult.zzE(status);
            }

            
            {
                zzaao = zzoe.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult listSubscriptions(GoogleApiClient googleapiclient, DataType datatype)
    {
        return googleapiclient.zza(new zznd.zza(googleapiclient, datatype) {

            final zzoe zzaao;
            final DataType zzaap;

            protected Result createFailedResult(Status status)
            {
                return zzx(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zznd)zza1);
            }

            protected void zza(zznd zznd1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                String s = zznd1.getContext().getPackageName();
                ((zznn)zznd1.zzjb()).zza(new zzw(zzaap, zza1, s));
            }

            protected ListSubscriptionsResult zzx(Status status)
            {
                return ListSubscriptionsResult.zzE(status);
            }

            
            {
                zzaao = zzoe.this;
                zzaap = datatype;
                super(googleapiclient);
            }
        });
    }

    public PendingResult subscribe(GoogleApiClient googleapiclient, DataSource datasource)
    {
        return zza(googleapiclient, (new com.google.android.gms.fitness.data.Subscription.zza()).zzb(datasource).zzlK());
    }

    public PendingResult subscribe(GoogleApiClient googleapiclient, DataType datatype)
    {
        return zza(googleapiclient, (new com.google.android.gms.fitness.data.Subscription.zza()).zzb(datatype).zzlK());
    }

    public PendingResult unsubscribe(GoogleApiClient googleapiclient, DataSource datasource)
    {
        return googleapiclient.zzb(new zznd.zzc(googleapiclient, datasource) {

            final zzoe zzaao;
            final DataSource zzaar;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zznd)zza1);
            }

            protected void zza(zznd zznd1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s = zznd1.getContext().getPackageName();
                ((zznn)zznd1.zzjb()).zza(new zzax(null, zzaar, zzoh1, s));
            }

            
            {
                zzaao = zzoe.this;
                zzaar = datasource;
                super(googleapiclient);
            }
        });
    }

    public PendingResult unsubscribe(GoogleApiClient googleapiclient, DataType datatype)
    {
        return googleapiclient.zzb(new zznd.zzc(googleapiclient, datatype) {

            final zzoe zzaao;
            final DataType zzaap;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zznd)zza1);
            }

            protected void zza(zznd zznd1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s = zznd1.getContext().getPackageName();
                ((zznn)zznd1.zzjb()).zza(new zzax(zzaap, null, zzoh1, s));
            }

            
            {
                zzaao = zzoe.this;
                zzaap = datatype;
                super(googleapiclient);
            }
        });
    }

    public PendingResult unsubscribe(GoogleApiClient googleapiclient, Subscription subscription)
    {
        if (subscription.getDataType() == null)
        {
            return unsubscribe(googleapiclient, subscription.getDataSource());
        } else
        {
            return unsubscribe(googleapiclient, subscription.getDataType());
        }
    }
}
