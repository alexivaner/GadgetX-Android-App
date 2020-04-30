// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.zzac;
import com.google.android.gms.fitness.request.zzae;
import com.google.android.gms.fitness.result.DataSourcesResult;

// Referenced classes of package com.google.android.gms.internal:
//            zznx, zzne, zzno, zzoh

public class zzof
    implements SensorsApi
{
    private static interface zza
    {

        public abstract void zzlN();
    }

    private static class zzb extends zznh.zza
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;

        public void zza(DataSourcesResult datasourcesresult)
        {
            zzHa.zzd(datasourcesresult);
        }

        private zzb(com.google.android.gms.common.api.zza.zzb zzb1)
        {
            zzHa = zzb1;
        }

    }

    private static class zzc extends zznv.zza
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;
        private final zza zzaaB;

        public void zzi(Status status)
        {
            if (zzaaB != null && status.isSuccess())
            {
                zzaaB.zzlN();
            }
            zzHa.zzd(status);
        }

        private zzc(com.google.android.gms.common.api.zza.zzb zzb1, zza zza1)
        {
            zzHa = zzb1;
            zzaaB = zza1;
        }

    }


    public zzof()
    {
    }

    private PendingResult zza(GoogleApiClient googleapiclient, zzk zzk, PendingIntent pendingintent, zza zza1)
    {
        return googleapiclient.zzb(new zzne.zzc(googleapiclient, zza1, zzk, pendingintent) {

            final PendingIntent zzaaA;
            final zzof zzaat;
            final zza zzaay;
            final zzk zzaaz;

            protected Result createFailedResult(Status status)
            {
                return zzb(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza2)
                throws RemoteException
            {
                zza((zzne)zza2);
            }

            protected void zza(zzne zzne1)
                throws RemoteException
            {
                zzc zzc1 = new zzc(this, zzaay);
                String s = zzne1.getContext().getPackageName();
                ((zzno)zzne1.zzjb()).zza(new zzae(zzaaz, zzaaA, zzc1, s));
            }

            protected Status zzb(Status status)
            {
                return status;
            }

            
            {
                zzaat = zzof.this;
                zzaay = zza1;
                zzaaz = zzk;
                zzaaA = pendingintent;
                super(googleapiclient);
            }
        });
    }

    private PendingResult zza(GoogleApiClient googleapiclient, SensorRequest sensorrequest, zzk zzk, PendingIntent pendingintent)
    {
        return googleapiclient.zza(new zzne.zzc(googleapiclient, sensorrequest, zzk, pendingintent) {

            final zzof zzaat;
            final SensorRequest zzaau;
            final zzk zzaav;
            final PendingIntent zzaaw;

            protected Result createFailedResult(Status status)
            {
                return zzb(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzne)zza1);
            }

            protected void zza(zzne zzne1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s = zzne1.getContext().getPackageName();
                ((zzno)zzne1.zzjb()).zza(new zzac(zzaau, zzaav, zzaaw, zzoh1, s));
            }

            protected Status zzb(Status status)
            {
                return status;
            }

            
            {
                zzaat = zzof.this;
                zzaau = sensorrequest;
                zzaav = zzk;
                zzaaw = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult add(GoogleApiClient googleapiclient, SensorRequest sensorrequest, PendingIntent pendingintent)
    {
        return zza(googleapiclient, sensorrequest, ((zzk) (null)), pendingintent);
    }

    public PendingResult add(GoogleApiClient googleapiclient, SensorRequest sensorrequest, OnDataPointListener ondatapointlistener)
    {
        return zza(googleapiclient, sensorrequest, com.google.android.gms.fitness.data.zzl.zza.zzlG().zza(ondatapointlistener), ((PendingIntent) (null)));
    }

    public PendingResult findDataSources(GoogleApiClient googleapiclient, DataSourcesRequest datasourcesrequest)
    {
        return googleapiclient.zza(new zzne.zza(googleapiclient, datasourcesrequest) {

            final DataSourcesRequest zzaas;
            final zzof zzaat;

            protected Result createFailedResult(Status status)
            {
                return zzy(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzne)zza1);
            }

            protected void zza(zzne zzne1)
                throws RemoteException
            {
                zzb zzb1 = new zzb(this);
                String s = zzne1.getContext().getPackageName();
                ((zzno)zzne1.zzjb()).zza(new DataSourcesRequest(zzaas, zzb1, s));
            }

            protected DataSourcesResult zzy(Status status)
            {
                return DataSourcesResult.zzC(status);
            }

            
            {
                zzaat = zzof.this;
                zzaas = datasourcesrequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult remove(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return zza(googleapiclient, ((zzk) (null)), pendingintent, ((zza) (null)));
    }

    public PendingResult remove(GoogleApiClient googleapiclient, OnDataPointListener ondatapointlistener)
    {
        com.google.android.gms.fitness.data.zzl zzl = com.google.android.gms.fitness.data.zzl.zza.zzlG().zzb(ondatapointlistener);
        if (zzl == null)
        {
            return new zznx(Status.zzNo);
        } else
        {
            return zza(googleapiclient, zzl, ((PendingIntent) (null)), new zza(ondatapointlistener) {

                final zzof zzaat;
                final OnDataPointListener zzaax;

                public void zzlN()
                {
                    com.google.android.gms.fitness.data.zzl.zza.zzlG().zzc(zzaax);
                }

            
            {
                zzaat = zzof.this;
                zzaax = ondatapointlistener;
                super();
            }
            });
        }
    }
}
