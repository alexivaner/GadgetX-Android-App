// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zzaa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzo, LatLng, zzp

public final class PolylineOptions
    implements SafeParcelable
{

    public static final zzo CREATOR = new zzo();
    private int mColor;
    private final int zzFG;
    private final List zzarB;
    private boolean zzarD;
    private float zzarb;
    private boolean zzarc;
    private float zzarg;

    public PolylineOptions()
    {
        zzarg = 10F;
        mColor = 0xff000000;
        zzarb = 0.0F;
        zzarc = true;
        zzarD = false;
        zzFG = 1;
        zzarB = new ArrayList();
    }

    PolylineOptions(int i, List list, float f, int j, float f1, boolean flag, boolean flag1)
    {
        zzarg = 10F;
        mColor = 0xff000000;
        zzarb = 0.0F;
        zzarc = true;
        zzarD = false;
        zzFG = i;
        zzarB = list;
        zzarg = f;
        mColor = j;
        zzarb = f1;
        zzarc = flag;
        zzarD = flag1;
    }

    public PolylineOptions add(LatLng latlng)
    {
        zzarB.add(latlng);
        return this;
    }

    public transient PolylineOptions add(LatLng alatlng[])
    {
        zzarB.addAll(Arrays.asList(alatlng));
        return this;
    }

    public PolylineOptions addAll(Iterable iterable)
    {
        LatLng latlng;
        for (iterable = iterable.iterator(); iterable.hasNext(); zzarB.add(latlng))
        {
            latlng = (LatLng)iterable.next();
        }

        return this;
    }

    public PolylineOptions color(int i)
    {
        mColor = i;
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public PolylineOptions geodesic(boolean flag)
    {
        zzarD = flag;
        return this;
    }

    public int getColor()
    {
        return mColor;
    }

    public List getPoints()
    {
        return zzarB;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public float getWidth()
    {
        return zzarg;
    }

    public float getZIndex()
    {
        return zzarb;
    }

    public boolean isGeodesic()
    {
        return zzarD;
    }

    public boolean isVisible()
    {
        return zzarc;
    }

    public PolylineOptions visible(boolean flag)
    {
        zzarc = flag;
        return this;
    }

    public PolylineOptions width(float f)
    {
        zzarg = f;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (zzaa.zzqF())
        {
            zzp.zza(this, parcel, i);
            return;
        } else
        {
            zzo.zza(this, parcel, i);
            return;
        }
    }

    public PolylineOptions zIndex(float f)
    {
        zzarb = f;
        return this;
    }

}
