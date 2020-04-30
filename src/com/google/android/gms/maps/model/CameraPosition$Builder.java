// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;


// Referenced classes of package com.google.android.gms.maps.model:
//            CameraPosition, LatLng

public static final class zzaqU
{

    private LatLng zzaqR;
    private float zzaqS;
    private float zzaqT;
    private float zzaqU;

    public zzaqU bearing(float f)
    {
        zzaqU = f;
        return this;
    }

    public CameraPosition build()
    {
        return new CameraPosition(zzaqR, zzaqS, zzaqT, zzaqU);
    }

    public zzaqU target(LatLng latlng)
    {
        zzaqR = latlng;
        return this;
    }

    public zzaqR tilt(float f)
    {
        zzaqT = f;
        return this;
    }

    public zzaqT zoom(float f)
    {
        zzaqS = f;
        return this;
    }

    public ()
    {
    }

    public (CameraPosition cameraposition)
    {
        zzaqR = cameraposition.target;
        zzaqS = cameraposition.zoom;
        zzaqT = cameraposition.tilt;
        zzaqU = cameraposition.bearing;
    }
}
