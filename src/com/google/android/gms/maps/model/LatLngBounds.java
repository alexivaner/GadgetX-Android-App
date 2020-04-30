// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.zzaa;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzg, LatLng, zzh

public final class LatLngBounds
    implements SafeParcelable
{
    public static final class Builder
    {

        private double zzaro;
        private double zzarp;
        private double zzarq;
        private double zzarr;

        private boolean zzd(double d)
        {
            boolean flag = false;
            if (zzarq <= zzarr)
            {
                return zzarq <= d && d <= zzarr;
            }
            if (zzarq <= d || d <= zzarr)
            {
                flag = true;
            }
            return flag;
        }

        public LatLngBounds build()
        {
            boolean flag;
            if (!Double.isNaN(zzarq))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "no included points");
            return new LatLngBounds(new LatLng(zzaro, zzarq), new LatLng(zzarp, zzarr));
        }

        public Builder include(LatLng latlng)
        {
            zzaro = Math.min(zzaro, latlng.latitude);
            zzarp = Math.max(zzarp, latlng.latitude);
            double d = latlng.longitude;
            if (Double.isNaN(zzarq))
            {
                zzarq = d;
                zzarr = d;
            } else
            if (!zzd(d))
            {
                if (LatLngBounds.zzd(zzarq, d) < LatLngBounds.zze(zzarr, d))
                {
                    zzarq = d;
                    return this;
                } else
                {
                    zzarr = d;
                    return this;
                }
            }
            return this;
        }

        public Builder()
        {
            zzaro = (1.0D / 0.0D);
            zzarp = (-1.0D / 0.0D);
            zzarq = (0.0D / 0.0D);
            zzarr = (0.0D / 0.0D);
        }
    }


    public static final zzg CREATOR = new zzg();
    public final LatLng northeast;
    public final LatLng southwest;
    private final int zzFG;

    LatLngBounds(int i, LatLng latlng, LatLng latlng1)
    {
        zzx.zzb(latlng, "null southwest");
        zzx.zzb(latlng1, "null northeast");
        boolean flag;
        if (latlng1.latitude >= latlng.latitude)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "southern latitude exceeds northern latitude (%s > %s)", new Object[] {
            Double.valueOf(latlng.latitude), Double.valueOf(latlng1.latitude)
        });
        zzFG = i;
        southwest = latlng;
        northeast = latlng1;
    }

    public LatLngBounds(LatLng latlng, LatLng latlng1)
    {
        this(1, latlng, latlng1);
    }

    public static Builder builder()
    {
        return new Builder();
    }

    private static double zzb(double d, double d1)
    {
        return ((d - d1) + 360D) % 360D;
    }

    private static double zzc(double d, double d1)
    {
        return ((d1 - d) + 360D) % 360D;
    }

    private boolean zzc(double d)
    {
        return southwest.latitude <= d && d <= northeast.latitude;
    }

    static double zzd(double d, double d1)
    {
        return zzb(d, d1);
    }

    private boolean zzd(double d)
    {
        boolean flag = false;
        if (southwest.longitude <= northeast.longitude)
        {
            return southwest.longitude <= d && d <= northeast.longitude;
        }
        if (southwest.longitude <= d || d <= northeast.longitude)
        {
            flag = true;
        }
        return flag;
    }

    static double zze(double d, double d1)
    {
        return zzc(d, d1);
    }

    public boolean contains(LatLng latlng)
    {
        return zzc(latlng.latitude) && zzd(latlng.longitude);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof LatLngBounds))
            {
                return false;
            }
            obj = (LatLngBounds)obj;
            if (!southwest.equals(((LatLngBounds) (obj)).southwest) || !northeast.equals(((LatLngBounds) (obj)).northeast))
            {
                return false;
            }
        }
        return true;
    }

    public LatLng getCenter()
    {
        double d1 = (southwest.latitude + northeast.latitude) / 2D;
        double d = northeast.longitude;
        double d2 = southwest.longitude;
        if (d2 <= d)
        {
            d = (d + d2) / 2D;
        } else
        {
            d = (d + 360D + d2) / 2D;
        }
        return new LatLng(d1, d);
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            southwest, northeast
        });
    }

    public LatLngBounds including(LatLng latlng)
    {
        double d3 = Math.min(southwest.latitude, latlng.latitude);
        double d4 = Math.max(northeast.latitude, latlng.latitude);
        double d1 = northeast.longitude;
        double d2 = southwest.longitude;
        double d = latlng.longitude;
        if (!zzd(d))
        {
            if (zzb(d2, d) >= zzc(d1, d))
            {
                d1 = d;
                d = d2;
            }
        } else
        {
            d = d2;
        }
        return new LatLngBounds(new LatLng(d3, d), new LatLng(d4, d1));
    }

    public String toString()
    {
        return zzw.zzk(this).zza("southwest", southwest).zza("northeast", northeast).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (zzaa.zzqF())
        {
            zzh.zza(this, parcel, i);
            return;
        } else
        {
            zzg.zza(this, parcel, i);
            return;
        }
    }

}
