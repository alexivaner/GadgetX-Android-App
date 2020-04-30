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
//            zzm, LatLng, zzn

public final class PolygonOptions
    implements SafeParcelable
{

    public static final zzm CREATOR = new zzm();
    private final int zzFG;
    private float zzaqY;
    private int zzaqZ;
    private final List zzarB;
    private final List zzarC;
    private boolean zzarD;
    private int zzara;
    private float zzarb;
    private boolean zzarc;

    public PolygonOptions()
    {
        zzaqY = 10F;
        zzaqZ = 0xff000000;
        zzara = 0;
        zzarb = 0.0F;
        zzarc = true;
        zzarD = false;
        zzFG = 1;
        zzarB = new ArrayList();
        zzarC = new ArrayList();
    }

    PolygonOptions(int i, List list, List list1, float f, int j, int k, float f1, 
            boolean flag, boolean flag1)
    {
        zzaqY = 10F;
        zzaqZ = 0xff000000;
        zzara = 0;
        zzarb = 0.0F;
        zzarc = true;
        zzarD = false;
        zzFG = i;
        zzarB = list;
        zzarC = list1;
        zzaqY = f;
        zzaqZ = j;
        zzara = k;
        zzarb = f1;
        zzarc = flag;
        zzarD = flag1;
    }

    public PolygonOptions add(LatLng latlng)
    {
        zzarB.add(latlng);
        return this;
    }

    public transient PolygonOptions add(LatLng alatlng[])
    {
        zzarB.addAll(Arrays.asList(alatlng));
        return this;
    }

    public PolygonOptions addAll(Iterable iterable)
    {
        LatLng latlng;
        for (iterable = iterable.iterator(); iterable.hasNext(); zzarB.add(latlng))
        {
            latlng = (LatLng)iterable.next();
        }

        return this;
    }

    public PolygonOptions addHole(Iterable iterable)
    {
        ArrayList arraylist = new ArrayList();
        for (iterable = iterable.iterator(); iterable.hasNext(); arraylist.add((LatLng)iterable.next())) { }
        zzarC.add(arraylist);
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public PolygonOptions fillColor(int i)
    {
        zzara = i;
        return this;
    }

    public PolygonOptions geodesic(boolean flag)
    {
        zzarD = flag;
        return this;
    }

    public int getFillColor()
    {
        return zzara;
    }

    public List getHoles()
    {
        return zzarC;
    }

    public List getPoints()
    {
        return zzarB;
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

    public boolean isGeodesic()
    {
        return zzarD;
    }

    public boolean isVisible()
    {
        return zzarc;
    }

    public PolygonOptions strokeColor(int i)
    {
        zzaqZ = i;
        return this;
    }

    public PolygonOptions strokeWidth(float f)
    {
        zzaqY = f;
        return this;
    }

    public PolygonOptions visible(boolean flag)
    {
        zzarc = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (zzaa.zzqF())
        {
            zzn.zza(this, parcel, i);
            return;
        } else
        {
            zzm.zza(this, parcel, i);
            return;
        }
    }

    public PolygonOptions zIndex(float f)
    {
        zzarb = f;
        return this;
    }

    List zzqJ()
    {
        return zzarC;
    }

}
