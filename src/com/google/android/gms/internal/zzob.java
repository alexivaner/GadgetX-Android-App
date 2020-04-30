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
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.zzl;
import com.google.android.gms.fitness.request.zzp;
import com.google.android.gms.fitness.result.DataTypeResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzna, zznk, zzoh

public class zzob
    implements ConfigApi
{
    private static class zza extends zzni.zza
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;

        public void zza(DataTypeResult datatyperesult)
        {
            zzHa.zzd(datatyperesult);
        }

        private zza(com.google.android.gms.common.api.zza.zzb zzb)
        {
            zzHa = zzb;
        }

    }


    public zzob()
    {
    }

    public PendingResult createCustomDataType(GoogleApiClient googleapiclient, DataTypeCreateRequest datatypecreaterequest)
    {
        return googleapiclient.zzb(new zzna.zza(googleapiclient, datatypecreaterequest) {

            final DataTypeCreateRequest zzaae;
            final zzob zzaaf;

            protected Result createFailedResult(Status status)
            {
                return zzv(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzna)zza1);
            }

            protected void zza(zzna zzna1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                String s = zzna1.getContext().getPackageName();
                ((zznk)zzna1.zzjb()).zza(new DataTypeCreateRequest(zzaae, zza1, s));
            }

            protected DataTypeResult zzv(Status status)
            {
                return DataTypeResult.zzD(status);
            }

            
            {
                zzaaf = zzob.this;
                zzaae = datatypecreaterequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult disableFit(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zzb(new zzna.zzc(googleapiclient) {

            final zzob zzaaf;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzna)zza1);
            }

            protected void zza(zzna zzna1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s = zzna1.getContext().getPackageName();
                ((zznk)zzna1.zzjb()).zza(new zzp(zzoh1, s));
            }

            
            {
                zzaaf = zzob.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult readDataType(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new zzna.zza(googleapiclient, s) {

            final zzob zzaaf;
            final String zzaag;

            protected Result createFailedResult(Status status)
            {
                return zzv(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzna)zza1);
            }

            protected void zza(zzna zzna1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                String s1 = zzna1.getContext().getPackageName();
                ((zznk)zzna1.zzjb()).zza(new zzl(zzaag, zza1, s1));
            }

            protected DataTypeResult zzv(Status status)
            {
                return DataTypeResult.zzD(status);
            }

            
            {
                zzaaf = zzob.this;
                zzaag = s;
                super(googleapiclient);
            }
        });
    }
}
