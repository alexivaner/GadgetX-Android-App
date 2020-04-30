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
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLngBounds;

public class PlacePicker
{
    public static class IntentBuilder
    {

        private final Intent mIntent = new Intent("com.google.android.gms.location.places.ui.PICK_PLACE");

        public Intent build(Context context)
            throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
        {
            GooglePlayServicesUtil.zzI(context);
            return mIntent;
        }

        public IntentBuilder setLatLngBounds(LatLngBounds latlngbounds)
        {
            zzx.zzl(latlngbounds);
            zzc.zza(latlngbounds, mIntent, "latlng_bounds");
            return this;
        }

        public IntentBuilder()
        {
            mIntent.setPackage("com.google.android.gms");
        }
    }


    public static final int RESULT_ERROR = 2;

    public PlacePicker()
    {
    }

    public static String getAttributions(Intent intent)
    {
        return intent.getStringExtra("third_party_attributions");
    }

    public static LatLngBounds getLatLngBounds(Intent intent)
    {
        return (LatLngBounds)zzc.zza(intent, "final_latlng_bounds", LatLngBounds.CREATOR);
    }

    public static Place getPlace(Intent intent, Context context)
    {
        zzx.zzb(context, "context must not be null");
        intent = (zzpy)zzc.zza(intent, "selected_place", zzpy.CREATOR);
        intent.zza(zzqf.zzab(context));
        return intent;
    }
}
