// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.ui;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.LatLngBounds;

// Referenced classes of package com.google.android.gms.location.places.ui:
//            PlacePicker

public static class mIntent
{

    private final Intent mIntent = new Intent("com.google.android.gms.location.places.ui.PICK_PLACE");

    public Intent build(Context context)
        throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
    {
        GooglePlayServicesUtil.zzI(context);
        return mIntent;
    }

    public mIntent setLatLngBounds(LatLngBounds latlngbounds)
    {
        zzx.zzl(latlngbounds);
        zzc.zza(latlngbounds, mIntent, "latlng_bounds");
        return this;
    }

    public n()
    {
        mIntent.setPackage("com.google.android.gms");
    }
}
