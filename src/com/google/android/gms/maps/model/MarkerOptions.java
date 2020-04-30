// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.internal.zzaa;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzk, BitmapDescriptor, zzl, LatLng

public final class MarkerOptions
    implements SafeParcelable
{

    public static final zzk CREATOR = new zzk();
    private float mAlpha;
    private final int zzFG;
    private String zzSy;
    private LatLng zzaqx;
    private boolean zzarc;
    private float zzark;
    private float zzarl;
    private String zzart;
    private BitmapDescriptor zzaru;
    private boolean zzarv;
    private boolean zzarw;
    private float zzarx;
    private float zzary;
    private float zzarz;

    public MarkerOptions()
    {
        zzark = 0.5F;
        zzarl = 1.0F;
        zzarc = true;
        zzarw = false;
        zzarx = 0.0F;
        zzary = 0.5F;
        zzarz = 0.0F;
        mAlpha = 1.0F;
        zzFG = 1;
    }

    MarkerOptions(int i, LatLng latlng, String s, String s1, IBinder ibinder, float f, float f1, 
            boolean flag, boolean flag1, boolean flag2, float f2, float f3, float f4, float f5)
    {
        zzark = 0.5F;
        zzarl = 1.0F;
        zzarc = true;
        zzarw = false;
        zzarx = 0.0F;
        zzary = 0.5F;
        zzarz = 0.0F;
        mAlpha = 1.0F;
        zzFG = i;
        zzaqx = latlng;
        zzSy = s;
        zzart = s1;
        if (ibinder == null)
        {
            latlng = null;
        } else
        {
            latlng = new BitmapDescriptor(com.google.android.gms.dynamic.zzd.zza.zzau(ibinder));
        }
        zzaru = latlng;
        zzark = f;
        zzarl = f1;
        zzarv = flag;
        zzarc = flag1;
        zzarw = flag2;
        zzarx = f2;
        zzary = f3;
        zzarz = f4;
        mAlpha = f5;
    }

    public MarkerOptions alpha(float f)
    {
        mAlpha = f;
        return this;
    }

    public MarkerOptions anchor(float f, float f1)
    {
        zzark = f;
        zzarl = f1;
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public MarkerOptions draggable(boolean flag)
    {
        zzarv = flag;
        return this;
    }

    public MarkerOptions flat(boolean flag)
    {
        zzarw = flag;
        return this;
    }

    public float getAlpha()
    {
        return mAlpha;
    }

    public float getAnchorU()
    {
        return zzark;
    }

    public float getAnchorV()
    {
        return zzarl;
    }

    public BitmapDescriptor getIcon()
    {
        return zzaru;
    }

    public float getInfoWindowAnchorU()
    {
        return zzary;
    }

    public float getInfoWindowAnchorV()
    {
        return zzarz;
    }

    public LatLng getPosition()
    {
        return zzaqx;
    }

    public float getRotation()
    {
        return zzarx;
    }

    public String getSnippet()
    {
        return zzart;
    }

    public String getTitle()
    {
        return zzSy;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapdescriptor)
    {
        zzaru = bitmapdescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f, float f1)
    {
        zzary = f;
        zzarz = f1;
        return this;
    }

    public boolean isDraggable()
    {
        return zzarv;
    }

    public boolean isFlat()
    {
        return zzarw;
    }

    public boolean isVisible()
    {
        return zzarc;
    }

    public MarkerOptions position(LatLng latlng)
    {
        zzaqx = latlng;
        return this;
    }

    public MarkerOptions rotation(float f)
    {
        zzarx = f;
        return this;
    }

    public MarkerOptions snippet(String s)
    {
        zzart = s;
        return this;
    }

    public MarkerOptions title(String s)
    {
        zzSy = s;
        return this;
    }

    public MarkerOptions visible(boolean flag)
    {
        zzarc = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (zzaa.zzqF())
        {
            zzl.zza(this, parcel, i);
            return;
        } else
        {
            zzk.zza(this, parcel, i);
            return;
        }
    }

    IBinder zzqI()
    {
        if (zzaru == null)
        {
            return null;
        } else
        {
            return zzaru.zzqe().asBinder();
        }
    }

}
