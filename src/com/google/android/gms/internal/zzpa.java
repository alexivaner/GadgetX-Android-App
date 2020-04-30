// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzpf

public class zzpa
    implements GeofencingApi
{
    private static abstract class zza extends com.google.android.gms.location.LocationServices.zza
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


    public zzpa()
    {
    }

    public PendingResult addGeofences(GoogleApiClient googleapiclient, GeofencingRequest geofencingrequest, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zza(googleapiclient, geofencingrequest, pendingintent) {

            final PendingIntent zzaaA;
            final GeofencingRequest zzamM;
            final zzpa zzamN;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpf)zza1);
            }

            protected void zza(zzpf zzpf1)
                throws RemoteException
            {
                com.google.android.gms.location.zzf.zza zza1 = new com.google.android.gms.location.zzf.zza(this) {

                    final _cls1 zzamO;

                    public void zza(int i, String as[])
                    {
                        zzamO.setResult(LocationStatusCodes.zzfr(i));
                    }

            
            {
                zzamO = _pcls1;
                super();
            }
                };
                zzpf1.zza(zzamM, zzaaA, zza1);
            }

            
            {
                zzamN = zzpa.this;
                zzamM = geofencingrequest;
                zzaaA = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult addGeofences(GoogleApiClient googleapiclient, List list, PendingIntent pendingintent)
    {
        com.google.android.gms.location.GeofencingRequest.Builder builder = new com.google.android.gms.location.GeofencingRequest.Builder();
        builder.addGeofences(list);
        builder.setInitialTrigger(5);
        return addGeofences(googleapiclient, builder.build(), pendingintent);
    }

    public PendingResult removeGeofences(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zza(googleapiclient, pendingintent) {

            final PendingIntent zzaaA;
            final zzpa zzamN;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpf)zza1);
            }

            protected void zza(zzpf zzpf1)
                throws RemoteException
            {
                com.google.android.gms.location.zzf.zzb zzb = new com.google.android.gms.location.zzf.zzb(this) {

                    final _cls2 zzamP;

                    public void zzb(int i, PendingIntent pendingintent)
                    {
                        zzamP.setResult(LocationStatusCodes.zzfr(i));
                    }

                    public void zzb(int i, String as[])
                    {
                        Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
                    }

            
            {
                zzamP = _pcls2;
                super();
            }
                };
                zzpf1.zza(zzaaA, zzb);
            }

            
            {
                zzamN = zzpa.this;
                zzaaA = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult removeGeofences(GoogleApiClient googleapiclient, List list)
    {
        return googleapiclient.zzb(new zza(googleapiclient, list) {

            final zzpa zzamN;
            final List zzamQ;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpf)zza1);
            }

            protected void zza(zzpf zzpf1)
                throws RemoteException
            {
                com.google.android.gms.location.zzf.zzb zzb = new com.google.android.gms.location.zzf.zzb(this) {

                    final _cls3 zzamR;

                    public void zzb(int i, PendingIntent pendingintent)
                    {
                        Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
                    }

                    public void zzb(int i, String as[])
                    {
                        zzamR.setResult(LocationStatusCodes.zzfr(i));
                    }

            
            {
                zzamR = _pcls3;
                super();
            }
                };
                zzpf1.zza(zzamQ, zzb);
            }

            
            {
                zzamN = zzpa.this;
                zzamQ = list;
                super(googleapiclient);
            }
        });
    }
}
