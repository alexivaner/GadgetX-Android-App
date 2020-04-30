// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzjv;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.cast:
//            zzb

public class CastDevice
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int zzFG;
    private String zzIE;
    String zzIF;
    private Inet4Address zzIG;
    private String zzIH;
    private String zzII;
    private String zzIJ;
    private int zzIK;
    private List zzIL;
    private int zzIM;
    private int zzrX;

    private CastDevice()
    {
        this(3, null, null, null, null, null, -1, ((List) (new ArrayList())), 0, -1);
    }

    CastDevice(int i, String s, String s1, String s2, String s3, String s4, int j, 
            List list, int k, int l)
    {
        zzFG = i;
        zzIE = s;
        zzIF = s1;
        if (zzIF != null)
        {
            try
            {
                s = InetAddress.getByName(zzIF);
                if (s instanceof Inet4Address)
                {
                    zzIG = (Inet4Address)s;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                zzIG = null;
            }
        }
        zzIH = s2;
        zzII = s3;
        zzIJ = s4;
        zzIK = j;
        zzIL = list;
        zzIM = k;
        zzrX = l;
    }

    public static CastDevice getFromBundle(Bundle bundle)
    {
        if (bundle == null)
        {
            return null;
        } else
        {
            bundle.setClassLoader(com/google/android/gms/cast/CastDevice.getClassLoader());
            return (CastDevice)bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof CastDevice))
        {
            return false;
        }
        obj = (CastDevice)obj;
        if (getDeviceId() != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((CastDevice) (obj)).getDeviceId() == null) goto _L1; else goto _L3
_L3:
        return false;
        if (zzjv.zza(zzIE, ((CastDevice) (obj)).zzIE) && zzjv.zza(zzIG, ((CastDevice) (obj)).zzIG) && zzjv.zza(zzII, ((CastDevice) (obj)).zzII) && zzjv.zza(zzIH, ((CastDevice) (obj)).zzIH) && zzjv.zza(zzIJ, ((CastDevice) (obj)).zzIJ) && zzIK == ((CastDevice) (obj)).zzIK && zzjv.zza(zzIL, ((CastDevice) (obj)).zzIL) && zzIM == ((CastDevice) (obj)).zzIM && zzrX == ((CastDevice) (obj)).zzrX) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int getCapabilities()
    {
        return zzIM;
    }

    public String getDeviceId()
    {
        return zzIE;
    }

    public String getDeviceVersion()
    {
        return zzIJ;
    }

    public String getFriendlyName()
    {
        return zzIH;
    }

    public WebImage getIcon(int i, int j)
    {
        WebImage webimage = null;
        if (zzIL.isEmpty())
        {
            return null;
        }
        if (i <= 0 || j <= 0)
        {
            return (WebImage)zzIL.get(0);
        }
        Iterator iterator = zzIL.iterator();
        WebImage webimage1 = null;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            WebImage webimage2 = (WebImage)iterator.next();
            int k = webimage2.getWidth();
            int l = webimage2.getHeight();
            if (k >= i && l >= j)
            {
                if (webimage1 == null || webimage1.getWidth() > k && webimage1.getHeight() > l)
                {
                    webimage1 = webimage2;
                }
            } else
            if (k < i && l < j && (webimage == null || webimage.getWidth() < k && webimage.getHeight() < l))
            {
                webimage = webimage2;
            }
        } while (true);
        if (webimage1 == null)
        {
            if (webimage != null)
            {
                webimage1 = webimage;
            } else
            {
                webimage1 = (WebImage)zzIL.get(0);
            }
        }
        return webimage1;
    }

    public List getIcons()
    {
        return Collections.unmodifiableList(zzIL);
    }

    public Inet4Address getIpAddress()
    {
        return zzIG;
    }

    public String getModelName()
    {
        return zzII;
    }

    public int getServicePort()
    {
        return zzIK;
    }

    public int getStatus()
    {
        return zzrX;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public boolean hasIcons()
    {
        return !zzIL.isEmpty();
    }

    public int hashCode()
    {
        if (zzIE == null)
        {
            return 0;
        } else
        {
            return zzIE.hashCode();
        }
    }

    public boolean isOnLocalNetwork()
    {
        return !zzIE.startsWith("__cast_nearby__");
    }

    public boolean isSameDevice(CastDevice castdevice)
    {
        if (castdevice != null)
        {
            if (getDeviceId() == null)
            {
                if (castdevice.getDeviceId() == null)
                {
                    return true;
                }
            } else
            {
                return zzjv.zza(getDeviceId(), castdevice.getDeviceId());
            }
        }
        return false;
    }

    public void putInBundle(Bundle bundle)
    {
        if (bundle == null)
        {
            return;
        } else
        {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
            return;
        }
    }

    public String toString()
    {
        return String.format("\"%s\" (%s)", new Object[] {
            zzIH, zzIE
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
