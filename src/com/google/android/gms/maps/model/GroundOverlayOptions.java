// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.internal.zzaa;

// Referenced classes of package com.google.android.gms.maps.model:
//            zze, BitmapDescriptor, zzf, LatLng, 
//            LatLngBounds

public final class GroundOverlayOptions
    implements SafeParcelable
{

    public static final zze CREATOR = new zze();
    public static final float NO_DIMENSION = -1F;
    private final int zzFG;
    private float zzaqU;
    private float zzarb;
    private boolean zzarc;
    private BitmapDescriptor zzare;
    private LatLng zzarf;
    private float zzarg;
    private float zzarh;
    private LatLngBounds zzari;
    private float zzarj;
    private float zzark;
    private float zzarl;

    public GroundOverlayOptions()
    {
        zzarc = true;
        zzarj = 0.0F;
        zzark = 0.5F;
        zzarl = 0.5F;
        zzFG = 1;
    }

    GroundOverlayOptions(int i, IBinder ibinder, LatLng latlng, float f, float f1, LatLngBounds latlngbounds, float f2, 
            float f3, boolean flag, float f4, float f5, float f6)
    {
        zzarc = true;
        zzarj = 0.0F;
        zzark = 0.5F;
        zzarl = 0.5F;
        zzFG = i;
        zzare = new BitmapDescriptor(com.google.android.gms.dynamic.zzd.zza.zzau(ibinder));
        zzarf = latlng;
        zzarg = f;
        zzarh = f1;
        zzari = latlngbounds;
        zzaqU = f2;
        zzarb = f3;
        zzarc = flag;
        zzarj = f4;
        zzark = f5;
        zzarl = f6;
    }

    private GroundOverlayOptions zza(LatLng latlng, float f, float f1)
    {
        zzarf = latlng;
        zzarg = f;
        zzarh = f1;
        return this;
    }

    public GroundOverlayOptions anchor(float f, float f1)
    {
        zzark = f;
        zzarl = f1;
        return this;
    }

    public GroundOverlayOptions bearing(float f)
    {
        zzaqU = (f % 360F + 360F) % 360F;
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public float getAnchorU()
    {
        return zzark;
    }

    public float getAnchorV()
    {
        return zzarl;
    }

    public float getBearing()
    {
        return zzaqU;
    }

    public LatLngBounds getBounds()
    {
        return zzari;
    }

    public float getHeight()
    {
        return zzarh;
    }

    public BitmapDescriptor getImage()
    {
        return zzare;
    }

    public LatLng getLocation()
    {
        return zzarf;
    }

    public float getTransparency()
    {
        return zzarj;
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

    public GroundOverlayOptions image(BitmapDescriptor bitmapdescriptor)
    {
        zzare = bitmapdescriptor;
        return this;
    }

    public boolean isVisible()
    {
        return zzarc;
    }

    public GroundOverlayOptions position(LatLng latlng, float f)
    {
        boolean flag1 = true;
        boolean flag;
        if (zzari == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Position has already been set using positionFromBounds");
        if (latlng != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Location must be specified");
        if (f >= 0.0F)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Width must be non-negative");
        return zza(latlng, f, -1F);
    }

    public GroundOverlayOptions position(LatLng latlng, float f, float f1)
    {
        boolean flag1 = true;
        boolean flag;
        if (zzari == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Position has already been set using positionFromBounds");
        if (latlng != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Location must be specified");
        if (f >= 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Width must be non-negative");
        if (f1 >= 0.0F)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Height must be non-negative");
        return zza(latlng, f, f1);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latlngbounds)
    {
        boolean flag;
        if (zzarf == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, (new StringBuilder()).append("Position has already been set using position: ").append(zzarf).toString());
        zzari = latlngbounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f)
    {
        boolean flag;
        if (f >= 0.0F && f <= 1.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Transparency must be in the range [0..1]");
        zzarj = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean flag)
    {
        zzarc = flag;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (zzaa.zzqF())
        {
            zzf.zza(this, parcel, i);
            return;
        } else
        {
            zze.zza(this, parcel, i);
            return;
        }
    }

    public GroundOverlayOptions zIndex(float f)
    {
        zzarb = f;
        return this;
    }

    IBinder zzqH()
    {
        return zzare.zzqe().asBinder();
    }

}
