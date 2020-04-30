// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;

// Referenced classes of package com.google.android.gms.internal:
//            zzpf

public class zzpn
    implements SettingsApi
{

    public zzpn()
    {
    }

    public PendingResult checkLocationSettings(GoogleApiClient googleapiclient, LocationSettingsRequest locationsettingsrequest)
    {
        return zza(googleapiclient, locationsettingsrequest, null);
    }

    public PendingResult zza(GoogleApiClient googleapiclient, LocationSettingsRequest locationsettingsrequest, String s)
    {
        return googleapiclient.zza(new com.google.android.gms.location.LocationServices.zza(googleapiclient, locationsettingsrequest, s) {

            final LocationSettingsRequest zzanq;
            final String zzanr;
            final zzpn zzans;

            public Result createFailedResult(Status status)
            {
                return zzax(status);
            }

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzpf)zza1);
            }

            protected void zza(zzpf zzpf1)
                throws RemoteException
            {
                zzpf1.zza(zzanq, this, zzanr);
            }

            public LocationSettingsResult zzax(Status status)
            {
                return new LocationSettingsResult(status);
            }

            
            {
                zzans = zzpn.this;
                zzanq = locationsettingsrequest;
                zzanr = s;
                super(googleapiclient);
            }
        });
    }
}
