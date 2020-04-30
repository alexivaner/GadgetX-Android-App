// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zzaa;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzc, zzd, LatLng

public final class CircleOptions
    implements SafeParcelable
{

    public static final zzc CREATOR = new zzc();
    private final int zzFG;
    private LatLng zzaqW;
    private double zzaqX;
    private float zzaqY;
    private int zzaqZ;
    private int zzara;
    private float zzarb;
    private boolean zzarc;

    public CircleOptions()
    {
        zzaqW = null;
        zzaqX = 0.0D;
        zzaqY = 10F;
        zzaqZ = 0xff000000;
        zzara = 0;
        zzarb = 0.0F;
        zzarc = true;
        zzFG = 1;
    }

    CircleOptions(int i, LatLng latlng, double d, float f, int j, int k, 
            float f1, boolean flag)
    {
        zzaqW = null;
        zzaqX = 0.0D;
        zzaqY = 10F;
        zzaqZ = 0xff000000;
        zzara = 0;
        zzarb = 0.0F;
        zzarc = true;
        zzFG = i;
        zzaqW = latlng;
        zzaqX = d;
        zzaqY = f;
        zzaqZ = j;
        zzara = k;
        zzarb = f1;
        zzarc = flag;
    }

    public CircleOptions center(LatLng latlng)
    {
        zzaqW = latlng;
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public CircleOptions fillColor(int i)
    {
        zzara = i;
        return this;
    }

    public LatLng getCenter()
    {
        return zzaqW;
    }

    public int getFillColor()
    {
        return zzara;
    }

    public double getRadius()
    {
        return zzaqX;
    }

    public int getStrokeColor()
    {
        return zzaqZ;
    }

    public float getStrokeWidth()
    {
        return zzaqY;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public float getZIndex()
    {
        return zzarb;
    }

    public boolean isVisible()
    {
        return zzarc;
    }

    public CircleOptions radius(double d)
    {
        zzaqX = d;
        return this;
    }

    public CircleOptions strokeColor(int i)
    {
        zzaqZ = i;
        return this;
    }

    public CircleOptions strokeWidth(float f)
    {
        zzaqY = f;
        return this;
    }

    public CircleOptions visible(boolean flag)
    {
        zzarc = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (zzaa.zzqF())
        {
            zzd.zza(this, parcel, i);
            return;
        } else
        {
            zzc.zza(this, parcel, i);
            return;
        }
    }

    public CircleOptions zIndex(float f)
    {
        zzarb = f;
        return this;
    }

}
