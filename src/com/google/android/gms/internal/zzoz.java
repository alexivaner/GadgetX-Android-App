// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

// Referenced classes of package com.google.android.gms.internal:
//            zzpf

public class zzoz
    implements FusedLocationProviderApi
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


    public zzoz()
    {
    }

    public Location getLastLocation(GoogleApiClient googleapiclient)
    {
        googleapiclient = LocationServices.zze(googleapiclient);
        try
        {
            googleapiclient = googleapiclient.zzpx();
        }
        // Misplaced declaration of an exception variable
        catch (GoogleApiClient googleapiclient)
        {
            return null;
        }
        return googleapiclient;
    }

    public PendingResult removeLocationUpdates(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zza(googleapiclient, pendingintent) {

            final PendingIntent zzamC;
            final zzoz zzamI;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpf)zza1);
            }

            protected void zza(zzpf zzpf1)
                throws RemoteException
            {
                zzpf1.zzd(zzamC);
                setResult(Status.zzNo);
            }

            
            {
                zzamI = zzoz.this;
                zzamC = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult removeLocationUpdates(GoogleApiClient googleapiclient, LocationListener locationlistener)
    {
        return googleapiclient.zzb(new zza(googleapiclient, locationlistener) {

            final LocationListener zzamH;
            final zzoz zzamI;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpf)zza1);
            }

            protected void zza(zzpf zzpf1)
                throws RemoteException
            {
                zzpf1.zza(zzamH);
                setResult(Status.zzNo);
            }

            
            {
                zzamI = zzoz.this;
                zzamH = locationlistener;
                super(googleapiclient);
            }
        });
    }

    public PendingResult requestLocationUpdates(GoogleApiClient googleapiclient, LocationRequest locationrequest, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zza(googleapiclient, locationrequest, pendingintent) {

            final PendingIntent zzamC;
            final LocationRequest zzamG;
            final zzoz zzamI;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpf)zza1);
            }

            protected void zza(zzpf zzpf1)
                throws RemoteException
            {
                zzpf1.zzb(zzamG, zzamC);
                setResult(Status.zzNo);
            }

            
            {
                zzamI = zzoz.this;
                zzamG = locationrequest;
                zzamC = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult requestLocationUpdates(GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationListener locationlistener)
    {
        return googleapiclient.zzb(new zza(googleapiclient, locationrequest, locationlistener) {

            final LocationRequest zzamG;
            final LocationListener zzamH;
            final zzoz zzamI;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpf)zza1);
            }

            protected void zza(zzpf zzpf1)
                throws RemoteException
            {
                zzpf1.zza(zzamG, zzamH, null);
                setResult(Status.zzNo);
            }

            
            {
                zzamI = zzoz.this;
                zzamG = locationrequest;
                zzamH = locationlistener;
                super(googleapiclient);
            }
        });
    }

    public PendingResult requestLocationUpdates(GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationListener locationlistener, Looper looper)
    {
        return googleapiclient.zzb(new zza(googleapiclient, locationrequest, locationlistener, looper) {

            final LocationRequest zzamG;
            final LocationListener zzamH;
            final zzoz zzamI;
            final Looper zzamL;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpf)zza1);
            }

            protected void zza(zzpf zzpf1)
                throws RemoteException
            {
                zzpf1.zza(zzamG, zzamH, zzamL);
                setResult(Status.zzNo);
            }

            
            {
                zzamI = zzoz.this;
                zzamG = locationrequest;
                zzamH = locationlistener;
                zzamL = looper;
                super(googleapiclient);
            }
        });
    }

    public PendingResult setMockLocation(GoogleApiClient googleapiclient, Location location)
    {
        return googleapiclient.zzb(new zza(googleapiclient, location) {

            final zzoz zzamI;
            final Location zzamK;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpf)zza1);
            }

            protected void zza(zzpf zzpf1)
                throws RemoteException
            {
                zzpf1.zzb(zzamK);
                setResult(Status.zzNo);
            }

            
            {
                zzamI = zzoz.this;
                zzamK = location;
                super(googleapiclient);
            }
        });
    }

    public PendingResult setMockMode(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zzb(new zza(googleapiclient, flag) {

            final zzoz zzamI;
            final boolean zzamJ;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpf)zza1);
            }

            protected void zza(zzpf zzpf1)
                throws RemoteException
            {
                zzpf1.zzW(zzamJ);
                setResult(Status.zzNo);
            }

            
            {
                zzamI = zzoz.this;
                zzamJ = flag;
                super(googleapiclient);
            }
        });
    }
}
