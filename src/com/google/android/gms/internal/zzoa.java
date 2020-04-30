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
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzar;
import com.google.android.gms.fitness.request.zzav;
import com.google.android.gms.fitness.request.zzb;
import com.google.android.gms.fitness.request.zzu;
import com.google.android.gms.fitness.result.BleDevicesResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzmz, zzoh, zznj

public class zzoa
    implements BleApi
{
    private static class zza extends zzoj.zza
    {

        private final com.google.android.gms.common.api.zza.zzb zzHa;

        public void zza(BleDevicesResult bledevicesresult)
        {
            zzHa.zzd(bledevicesresult);
        }

        private zza(com.google.android.gms.common.api.zza.zzb zzb)
        {
            zzHa = zzb;
        }

    }


    public zzoa()
    {
    }

    public PendingResult claimBleDevice(GoogleApiClient googleapiclient, BleDevice bledevice)
    {
        return googleapiclient.zzb(new zzmz.zzc(googleapiclient, bledevice) {

            final zzoa zzaaa;
            final BleDevice zzaad;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzmz)zza1);
            }

            protected void zza(zzmz zzmz1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s = zzmz1.getContext().getPackageName();
                ((zznj)zzmz1.zzjb()).zza(new zzb(zzaad.getAddress(), zzaad, zzoh1, s));
            }

            
            {
                zzaaa = zzoa.this;
                zzaad = bledevice;
                super(googleapiclient);
            }
        });
    }

    public PendingResult claimBleDevice(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new zzmz.zzc(googleapiclient, s) {

            final zzoa zzaaa;
            final String zzaac;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzmz)zza1);
            }

            protected void zza(zzmz zzmz1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s1 = zzmz1.getContext().getPackageName();
                ((zznj)zzmz1.zzjb()).zza(new zzb(zzaac, null, zzoh1, s1));
            }

            
            {
                zzaaa = zzoa.this;
                zzaac = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult listClaimedBleDevices(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zzmz.zza(googleapiclient) {

            final zzoa zzaaa;

            protected Result createFailedResult(Status status)
            {
                return zzu(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzmz)zza1);
            }

            protected void zza(zzmz zzmz1)
                throws RemoteException
            {
                zza zza1 = new zza(this);
                String s = zzmz1.getContext().getPackageName();
                ((zznj)zzmz1.zzjb()).zza(new zzu(zza1, s));
            }

            protected BleDevicesResult zzu(Status status)
            {
                return BleDevicesResult.zzB(status);
            }

            
            {
                zzaaa = zzoa.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult startBleScan(GoogleApiClient googleapiclient, StartBleScanRequest startblescanrequest)
    {
        return googleapiclient.zza(new zzmz.zzc(googleapiclient, startblescanrequest) {

            final StartBleScanRequest zzZZ;
            final zzoa zzaaa;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzmz)zza1);
            }

            protected void zza(zzmz zzmz1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s = zzmz1.getContext().getPackageName();
                ((zznj)zzmz1.zzjb()).zza(new StartBleScanRequest(zzZZ, zzoh1, s));
            }

            
            {
                zzaaa = zzoa.this;
                zzZZ = startblescanrequest;
                super(googleapiclient);
            }
        });
    }

    public PendingResult stopBleScan(GoogleApiClient googleapiclient, BleScanCallback blescancallback)
    {
        return googleapiclient.zza(new zzmz.zzc(googleapiclient, blescancallback) {

            final zzoa zzaaa;
            final BleScanCallback zzaab;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzmz)zza1);
            }

            protected void zza(zzmz zzmz1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s = zzmz1.getContext().getPackageName();
                ((zznj)zzmz1.zzjb()).zza(new zzar(zzaab, zzoh1, s));
            }

            
            {
                zzaaa = zzoa.this;
                zzaab = blescancallback;
                super(googleapiclient);
            }
        });
    }

    public PendingResult unclaimBleDevice(GoogleApiClient googleapiclient, BleDevice bledevice)
    {
        return unclaimBleDevice(googleapiclient, bledevice.getAddress());
    }

    public PendingResult unclaimBleDevice(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new zzmz.zzc(googleapiclient, s) {

            final zzoa zzaaa;
            final String zzaac;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzmz)zza1);
            }

            protected void zza(zzmz zzmz1)
                throws RemoteException
            {
                zzoh zzoh1 = new zzoh(this);
                String s1 = zzmz1.getContext().getPackageName();
                ((zznj)zzmz1.zzjb()).zza(new zzav(zzaac, zzoh1, s1));
            }

            
            {
                zzaaa = zzoa.this;
                zzaac = s;
                super(googleapiclient);
            }
        });
    }
}
