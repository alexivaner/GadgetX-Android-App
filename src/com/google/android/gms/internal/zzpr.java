// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzi;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            zzps

public class zzpr
    implements GeoDataApi
{

    private static final String TAG = com/google/android/gms/internal/zzpr.getSimpleName();

    public zzpr()
    {
    }

    public PendingResult addPlace(GoogleApiClient googleapiclient, AddPlaceRequest addplacerequest)
    {
        return googleapiclient.zzb(new com.google.android.gms.location.places.zzi.zzc(Places.zzanT, googleapiclient, addplacerequest) {

            final AddPlaceRequest zzaok;
            final zzpr zzaol;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzps)zza1);
            }

            protected void zza(zzps zzps1)
                throws RemoteException
            {
                zzps1.zza(new zzi(this, zzps1.getContext()), zzaok);
            }

            
            {
                zzaol = zzpr.this;
                zzaok = addplacerequest;
                super(zzc, googleapiclient);
            }
        });
    }

    public PendingResult getAutocompletePredictions(GoogleApiClient googleapiclient, String s, LatLngBounds latlngbounds, AutocompleteFilter autocompletefilter)
    {
        return googleapiclient.zza(new com.google.android.gms.location.places.zzi.zza(Places.zzanT, googleapiclient, s, latlngbounds, autocompletefilter) {

            final String zzafV;
            final zzpr zzaol;
            final LatLngBounds zzaon;
            final AutocompleteFilter zzaoo;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzps)zza1);
            }

            protected void zza(zzps zzps1)
                throws RemoteException
            {
                zzps1.zza(new zzi(this), zzafV, zzaon, zzaoo);
            }

            
            {
                zzaol = zzpr.this;
                zzafV = s;
                zzaon = latlngbounds;
                zzaoo = autocompletefilter;
                super(zzc, googleapiclient);
            }
        });
    }

    public transient PendingResult getPlaceById(GoogleApiClient googleapiclient, String as[])
    {
        boolean flag = true;
        if (as == null || as.length < 1)
        {
            flag = false;
        }
        zzx.zzO(flag);
        return googleapiclient.zza(new com.google.android.gms.location.places.zzi.zzc(Places.zzanT, googleapiclient, as) {

            final zzpr zzaol;
            final String zzaom[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzps)zza1);
            }

            protected void zza(zzps zzps1)
                throws RemoteException
            {
                java.util.List list = Arrays.asList(zzaom);
                zzps1.zza(new zzi(this, zzps1.getContext()), list);
            }

            
            {
                zzaol = zzpr.this;
                zzaom = as;
                super(zzc, googleapiclient);
            }
        });
    }

}
