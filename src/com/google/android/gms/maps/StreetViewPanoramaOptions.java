// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

// Referenced classes of package com.google.android.gms.maps:
//            zzc

public final class StreetViewPanoramaOptions
    implements SafeParcelable
{

    public static final zzc CREATOR = new zzc();
    private final int zzFG;
    private Boolean zzapK;
    private Boolean zzapQ;
    private Boolean zzaqA;
    private Boolean zzaqB;
    private StreetViewPanoramaCamera zzaqv;
    private String zzaqw;
    private LatLng zzaqx;
    private Integer zzaqy;
    private Boolean zzaqz;

    public StreetViewPanoramaOptions()
    {
        zzaqz = Boolean.valueOf(true);
        zzapQ = Boolean.valueOf(true);
        zzaqA = Boolean.valueOf(true);
        zzaqB = Boolean.valueOf(true);
        zzFG = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetviewpanoramacamera, String s, LatLng latlng, Integer integer, byte byte0, byte byte1, 
            byte byte2, byte byte3, byte byte4)
    {
        zzaqz = Boolean.valueOf(true);
        zzapQ = Boolean.valueOf(true);
        zzaqA = Boolean.valueOf(true);
        zzaqB = Boolean.valueOf(true);
        zzFG = i;
        zzaqv = streetviewpanoramacamera;
        zzaqx = latlng;
        zzaqy = integer;
        zzaqw = s;
        zzaqz = zza.zza(byte0);
        zzapQ = zza.zza(byte1);
        zzaqA = zza.zza(byte2);
        zzaqB = zza.zza(byte3);
        zzapK = zza.zza(byte4);
    }

    public int describeContents()
    {
        return 0;
    }

    public Boolean getPanningGesturesEnabled()
    {
        return zzaqA;
    }

    public String getPanoramaId()
    {
        return zzaqw;
    }

    public LatLng getPosition()
    {
        return zzaqx;
    }

    public Integer getRadius()
    {
        return zzaqy;
    }

    public Boolean getStreetNamesEnabled()
    {
        return zzaqB;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera()
    {
        return zzaqv;
    }

    public Boolean getUseViewLifecycleInFragment()
    {
        return zzapK;
    }

    public Boolean getUserNavigationEnabled()
    {
        return zzaqz;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public Boolean getZoomGesturesEnabled()
    {
        return zzapQ;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean flag)
    {
        zzaqA = Boolean.valueOf(flag);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetviewpanoramacamera)
    {
        zzaqv = streetviewpanoramacamera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String s)
    {
        zzaqw = s;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latlng)
    {
        zzaqx = latlng;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latlng, Integer integer)
    {
        zzaqx = latlng;
        zzaqy = integer;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean flag)
    {
        zzaqB = Boolean.valueOf(flag);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean flag)
    {
        zzapK = Boolean.valueOf(flag);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean flag)
    {
        zzaqz = Boolean.valueOf(flag);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.maps.zzc.zza(this, parcel, i);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean flag)
    {
        zzapQ = Boolean.valueOf(flag);
        return this;
    }

    byte zzqi()
    {
        return zza.zzd(zzapK);
    }

    byte zzqm()
    {
        return zza.zzd(zzapQ);
    }

    byte zzqw()
    {
        return zza.zzd(zzaqz);
    }

    byte zzqx()
    {
        return zza.zzd(zzaqA);
    }

    byte zzqy()
    {
        return zza.zzd(zzaqB);
    }

}
