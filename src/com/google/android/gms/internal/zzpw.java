// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzi;

// Referenced classes of package com.google.android.gms.internal:
//            zzpx

public class zzpw
    implements PlaceDetectionApi
{

    public zzpw()
    {
    }

    public PendingResult getCurrentPlace(GoogleApiClient googleapiclient, PlaceFilter placefilter)
    {
        return googleapiclient.zza(new com.google.android.gms.location.places.zzi.zzd(Places.zzanU, googleapiclient, placefilter) {

            final PlaceFilter zzaot;
            final zzpw zzaou;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpx)zza1);
            }

            protected void zza(zzpx zzpx1)
                throws RemoteException
            {
                zzpx1.zza(new zzi(this, zzpx1.getContext()), zzaot);
            }

            
            {
                zzaou = zzpw.this;
                zzaot = placefilter;
                super(zzc, googleapiclient);
            }
        });
    }

    public PendingResult reportDeviceAtPlace(GoogleApiClient googleapiclient, PlaceReport placereport)
    {
        return googleapiclient.zzb(new com.google.android.gms.location.places.zzi.zzg(Places.zzanU, googleapiclient, placereport) {

            final zzpw zzaou;
            final PlaceReport zzaov;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpx)zza1);
            }

            protected void zza(zzpx zzpx1)
                throws RemoteException
            {
                zzpx1.zza(new zzi(this), zzaov);
            }

            
            {
                zzaou = zzpw.this;
                zzaov = placereport;
                super(zzc, googleapiclient);
            }
        });
    }
}
