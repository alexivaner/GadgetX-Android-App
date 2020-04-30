// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzqr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places:
//            PlaceLikelihoodBuffer, PlaceLikelihood, Place, zzh, 
//            AutocompletePredictionBuffer, PlaceBuffer

public class zzi extends com.google.android.gms.internal.zzpv.zza
{
    public static abstract class zza extends zzb
    {

        protected Result createFailedResult(Status status)
        {
            return zzaz(status);
        }

        protected AutocompletePredictionBuffer zzaz(Status status)
        {
            return new AutocompletePredictionBuffer(DataHolder.zzay(status.getStatusCode()));
        }

        public zza(com.google.android.gms.common.api.Api.zzc zzc1, GoogleApiClient googleapiclient)
        {
            super(zzc1, googleapiclient);
        }
    }

    public static abstract class zzb extends com.google.android.gms.common.api.zza.zza
    {

        public zzb(com.google.android.gms.common.api.Api.zzc zzc1, GoogleApiClient googleapiclient)
        {
            super(zzc1, googleapiclient);
        }
    }

    public static abstract class zzc extends zzb
    {

        protected Result createFailedResult(Status status)
        {
            return zzaA(status);
        }

        protected PlaceBuffer zzaA(Status status)
        {
            return new PlaceBuffer(DataHolder.zzay(status.getStatusCode()), null);
        }

        public zzc(com.google.android.gms.common.api.Api.zzc zzc1, GoogleApiClient googleapiclient)
        {
            super(zzc1, googleapiclient);
        }
    }

    public static abstract class zzd extends zzb
    {

        protected Result createFailedResult(Status status)
        {
            return zzaB(status);
        }

        protected PlaceLikelihoodBuffer zzaB(Status status)
        {
            return new PlaceLikelihoodBuffer(DataHolder.zzay(status.getStatusCode()), 100, null);
        }

        public zzd(com.google.android.gms.common.api.Api.zzc zzc1, GoogleApiClient googleapiclient)
        {
            super(zzc1, googleapiclient);
        }
    }

    public static abstract class zze extends zzb
    {

        protected Result createFailedResult(Status status)
        {
            return zzaC(status);
        }

        protected zzh zzaC(Status status)
        {
            return new zzh(status, Collections.emptyList());
        }
    }

    public static abstract class zzf extends zzb
    {

        protected Result createFailedResult(Status status)
        {
            return zzaD(status);
        }

        protected zzqr zzaD(Status status)
        {
            return zzqr.zzaE(status);
        }
    }

    public static abstract class zzg extends zzb
    {

        protected Result createFailedResult(Status status)
        {
            return zzb(status);
        }

        protected Status zzb(Status status)
        {
            return status;
        }

        public zzg(com.google.android.gms.common.api.Api.zzc zzc1, GoogleApiClient googleapiclient)
        {
            super(zzc1, googleapiclient);
        }
    }


    private static final String TAG = com/google/android/gms/location/places/zzi.getSimpleName();
    private final Context mContext;
    private final zzd zzanV;
    private final zza zzanW;
    private final zze zzanX;
    private final zzf zzanY;
    private final zzg zzanZ;
    private final zzc zzaoa;

    public zzi(zza zza1)
    {
        zzanV = null;
        zzanX = null;
        zzanW = zza1;
        zzanY = null;
        zzanZ = null;
        zzaoa = null;
        mContext = null;
    }

    public zzi(zzc zzc1, Context context)
    {
        zzanV = null;
        zzanX = null;
        zzanW = null;
        zzanY = null;
        zzanZ = null;
        zzaoa = zzc1;
        mContext = context;
    }

    public zzi(zzd zzd1, Context context)
    {
        zzanV = zzd1;
        zzanX = null;
        zzanW = null;
        zzanY = null;
        zzanZ = null;
        zzaoa = null;
        mContext = context;
    }

    public zzi(zzg zzg1)
    {
        zzanV = null;
        zzanX = null;
        zzanW = null;
        zzanY = null;
        zzanZ = zzg1;
        zzaoa = null;
        mContext = null;
    }

    public void zzX(DataHolder dataholder)
        throws RemoteException
    {
        boolean flag2 = true;
        boolean flag;
        boolean flag1;
        boolean flag3;
        if (zzanV != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (zzanX != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag != flag1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        zzx.zza(flag3, "Only one of placeEstimator or placeReturner can be null");
        if (zzanV != null)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        if (dataholder == null)
        {
            if (Log.isLoggable(TAG, 6))
            {
                Log.e(TAG, (new StringBuilder()).append("onPlaceEstimated received null DataHolder: ").append(zzmg.zzkm()).toString());
            }
            if (flag)
            {
                zzanV.zzk(Status.zzNq);
                return;
            } else
            {
                zzanX.zzk(Status.zzNq);
                return;
            }
        }
        dataholder = new PlaceLikelihoodBuffer(dataholder, 100, mContext);
        if (flag)
        {
            zzanV.setResult(dataholder);
            return;
        }
        Status status = dataholder.getStatus();
        ArrayList arraylist = new ArrayList(dataholder.getCount());
        for (Iterator iterator = dataholder.iterator(); iterator.hasNext(); arraylist.add(((PlaceLikelihood)iterator.next()).getPlace().freeze())) { }
        dataholder.release();
        zzanX.setResult(new zzh(status, arraylist));
    }

    public void zzY(DataHolder dataholder)
        throws RemoteException
    {
        if (dataholder == null)
        {
            if (Log.isLoggable(TAG, 6))
            {
                Log.e(TAG, (new StringBuilder()).append("onAutocompletePrediction received null DataHolder: ").append(zzmg.zzkm()).toString());
            }
            zzanW.zzk(Status.zzNq);
            return;
        } else
        {
            zzanW.setResult(new AutocompletePredictionBuffer(dataholder));
            return;
        }
    }

    public void zzZ(DataHolder dataholder)
        throws RemoteException
    {
        if (dataholder == null)
        {
            if (Log.isLoggable(TAG, 6))
            {
                Log.e(TAG, (new StringBuilder()).append("onPlaceUserDataFetched received null DataHolder: ").append(zzmg.zzkm()).toString());
            }
            zzanY.zzk(Status.zzNq);
            return;
        } else
        {
            zzanY.setResult(new zzqr(dataholder));
            return;
        }
    }

    public void zzaa(DataHolder dataholder)
        throws RemoteException
    {
        dataholder = new PlaceBuffer(dataholder, mContext);
        zzaoa.setResult(dataholder);
    }

    public void zzay(Status status)
        throws RemoteException
    {
        zzanZ.setResult(status);
    }

}
