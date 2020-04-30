// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.zzi;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.internal:
//            zzqh, zzpt

public class zzpx extends zzk
{
    public static class zza
        implements com.google.android.gms.common.api.Api.zzb
    {

        private final String zzaor;
        private final String zzaos;

        public int getPriority()
        {
            return 0x7fffffff;
        }

        public com.google.android.gms.common.api.Api.zza zza(Context context, Looper looper, zzf zzf1, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            return zzb(context, looper, zzf1, (PlacesOptions)obj, connectioncallbacks, onconnectionfailedlistener);
        }

        public zzpx zzb(Context context, Looper looper, zzf zzf1, PlacesOptions placesoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
        {
            String s;
            String s1;
            if (zzaor != null)
            {
                s = zzaor;
            } else
            {
                s = context.getPackageName();
            }
            if (zzaos != null)
            {
                s1 = zzaos;
            } else
            {
                s1 = context.getPackageName();
            }
            if (placesoptions == null)
            {
                placesoptions = (new com.google.android.gms.location.places.PlacesOptions.Builder()).build();
            }
            return new zzpx(context, looper, zzf1, connectioncallbacks, onconnectionfailedlistener, s, s1, placesoptions);
        }

        public zza(String s, String s1)
        {
            zzaor = s;
            zzaos = s1;
        }
    }


    private final zzqh zzaop;
    private final Locale zzaoq = Locale.getDefault();

    public zzpx(Context context, Looper looper, zzf zzf1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s, String s1, 
            PlacesOptions placesoptions)
    {
        super(context, looper, 67, connectioncallbacks, onconnectionfailedlistener, zzf1);
        context = null;
        if (zzf1.getAccount() != null)
        {
            context = zzf1.getAccount().name;
        }
        zzaop = new zzqh(s, zzaoq, context, placesoptions.zzaob, s1);
    }

    public void zza(zzi zzi, PlaceFilter placefilter)
        throws RemoteException
    {
        PlaceFilter placefilter1 = placefilter;
        if (placefilter == null)
        {
            placefilter1 = PlaceFilter.zzpJ();
        }
        ((zzpt)zzjb()).zza(placefilter1, zzaop, zzi);
    }

    public void zza(zzi zzi, PlaceReport placereport)
        throws RemoteException
    {
        zzx.zzl(placereport);
        ((zzpt)zzjb()).zza(placereport, zzaop, zzi);
    }

    protected zzpt zzbq(IBinder ibinder)
    {
        return zzpt.zza.zzbn(ibinder);
    }

    protected String zzcF()
    {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    protected String zzcG()
    {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }

    protected IInterface zzp(IBinder ibinder)
    {
        return zzbq(ibinder);
    }
}
