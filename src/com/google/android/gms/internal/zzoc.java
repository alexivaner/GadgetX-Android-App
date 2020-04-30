// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.zze;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zznb, zzoh, zznl

public class zzoc
    implements HistoryApi
{
    private static class zza extends zzng.zza
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;
        private int zzaam;
        private DataReadResult zzaan;

        public void zza(DataReadResult datareadresult)
        {
            this;
            JVM INSTR monitorenter ;
            Log.v("Fitness", "Received batch result");
            if (zzaan != null)
            {
                break MISSING_BLOCK_LABEL_62;
            }
            zzaan = datareadresult;
_L2:
            zzaam = zzaam + 1;
            if (zzaam == zzaan.zzmn())
            {
                zzHa.zzd(zzaan);
            }
            this;
            JVM INSTR monitorexit ;
            return;
            zzaan.zzb(datareadresult);
            if (true) goto _L2; else goto _L1
_L1:
            datareadresult;
            this;
            JVM INSTR monitorexit ;
            throw datareadresult;
        }

        private zza(com.google.android.gms.common.api.zza.zzb zzb)
        {
            zzaam = 0;
            zzaan = null;
            zzHa = zzb;
        }

    }


    public zzoc()
    {
    }

    private PendingResult zza(GoogleApiClient googleapiclient, DataSet dataset, boolean flag)
    {
        zzx.zzb(dataset, "Must set the data set");
        boolean flag1;
        if (!dataset.getDataPoints().isEmpty())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        zzx.zza(flag1, "Cannot use an empty data set");
        zzx.zzb(dataset.getDataSource().zzlz(), "Must set the app package name for the data source");
        return googleapiclient.zza(new zznb.zzc(googleapiclient, dataset, flag) {

            final DataSet zzaah;
            final boolean zzaai;
            final zzoc zzaaj;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zznb)zza1);
            }

            protected void zza(zznb zznb1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s = zznb1.getContext().getPackageName();
                ((zznl)zznb1.zzjb()).zza(new zze(zzaah, zzoh1, s, zzaai));
            }

            
            {
                zzaaj = zzoc.this;
                zzaah = dataset;
                zzaai = flag;
                super(googleapiclient);
            }
        });
    }

    public PendingResult deleteData(GoogleApiClient googleapiclient, DataDeleteRequest datadeleterequest)
    {
        return googleapiclient.zza(new zznb.zzc(googleapiclient, datadeleterequest) {

            final zzoc zzaaj;
            final DataDeleteRequest zzaak;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zznb)zza1);
            }

            protected void zza(zznb zznb1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s = zznb1.getContext().getPackageName();
                ((zznl)zznb1.zzjb()).zza(new DataDeleteRequest(zzaak, zzoh1, s));
            }

            
            {
                zzaaj = zzoc.this;
                zzaak = datadeleterequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult insertData(GoogleApiClient googleapiclient, DataSet dataset)
    {
        return zza(googleapiclient, dataset, false);
    }

    public PendingResult readData(GoogleApiClient googleapiclient, DataReadRequest datareadrequest)
    {
        return googleapiclient.zza(new zznb.zza(googleapiclient, datareadrequest) {

            final zzoc zzaaj;
            final DataReadRequest zzaal;

            protected Result createFailedResult(Status status)
            {
                return zzw(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zznb)zza1);
            }

            protected void zza(zznb zznb1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                String s = zznb1.getContext().getPackageName();
                ((zznl)zznb1.zzjb()).zza(new DataReadRequest(zzaal, zza1, s));
            }

            protected DataReadResult zzw(Status status)
            {
                return DataReadResult.zza(status, zzaal);
            }

            
            {
                zzaaj = zzoc.this;
                zzaal = datareadrequest;
                super(googleapiclient);
            }
        });
    }
}
