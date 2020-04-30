// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

// Referenced classes of package com.google.android.gms.internal:
//            zzpz, zzqf, zzqd

public final class zzpy
    implements SafeParcelable, Place
{
    public static class zza
    {

        private String mName;
        private String zzFA;
        private int zzFG;
        private String zzYy;
        private LatLng zzant;
        private String zzanv;
        private Uri zzanw;
        private String zzaoA;
        private boolean zzaoB;
        private float zzaoC;
        private int zzaoD;
        private long zzaoE;
        private String zzaoG;
        private List zzaoH;
        private boolean zzaoI;
        private Bundle zzaoM;
        private List zzaoN;
        private float zzaoy;
        private LatLngBounds zzaoz;

        public zza zzX(boolean flag)
        {
            zzaoB = flag;
            return this;
        }

        public zza zzY(boolean flag)
        {
            zzaoI = flag;
            return this;
        }

        public zza zza(LatLng latlng)
        {
            zzant = latlng;
            return this;
        }

        public zza zza(LatLngBounds latlngbounds)
        {
            zzaoz = latlngbounds;
            return this;
        }

        public zza zzc(float f)
        {
            zzaoy = f;
            return this;
        }

        public zza zzco(String s)
        {
            zzFA = s;
            return this;
        }

        public zza zzcp(String s)
        {
            mName = s;
            return this;
        }

        public zza zzcq(String s)
        {
            zzYy = s;
            return this;
        }

        public zza zzcr(String s)
        {
            zzanv = s;
            return this;
        }

        public zza zzd(float f)
        {
            zzaoC = f;
            return this;
        }

        public zza zzfH(int i)
        {
            zzaoD = i;
            return this;
        }

        public zza zzk(Uri uri)
        {
            zzanw = uri;
            return this;
        }

        public zza zzo(List list)
        {
            zzaoN = list;
            return this;
        }

        public zza zzp(List list)
        {
            zzaoH = list;
            return this;
        }

        public zzpy zzpW()
        {
            return new zzpy(zzFG, zzFA, zzaoN, Collections.emptyList(), zzaoM, mName, zzYy, zzanv, zzaoG, zzaoH, zzant, zzaoy, zzaoz, zzaoA, zzanw, zzaoB, zzaoC, zzaoD, zzaoE, zzaoI, zzqd.zza(mName, zzYy, zzanv, zzaoG, zzaoH));
        }

        public zza()
        {
            zzFG = 0;
        }
    }


    public static final zzpz CREATOR = new zzpz();
    private final String mName;
    private final String zzFA;
    final int zzFG;
    private final String zzYy;
    private final LatLng zzant;
    private final List zzanu;
    private final String zzanv;
    private final Uri zzanw;
    private final String zzaoA;
    private final boolean zzaoB;
    private final float zzaoC;
    private final int zzaoD;
    private final long zzaoE;
    private final List zzaoF;
    private final String zzaoG;
    private final List zzaoH;
    final boolean zzaoI;
    private final Map zzaoJ = Collections.unmodifiableMap(new HashMap());
    private final TimeZone zzaoK = null;
    private zzqf zzaoL;
    private Locale zzaoq;
    private final Bundle zzaow;
    private final zzqd zzaox;
    private final float zzaoy;
    private final LatLngBounds zzaoz;

    zzpy(int i, String s, List list, List list1, Bundle bundle, String s1, String s2, 
            String s3, String s4, List list2, LatLng latlng, float f, LatLngBounds latlngbounds, String s5, 
            Uri uri, boolean flag, float f1, int j, long l, boolean flag1, 
            zzqd zzqd)
    {
        zzFG = i;
        zzFA = s;
        zzanu = Collections.unmodifiableList(list);
        zzaoF = list1;
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        zzaow = bundle;
        mName = s1;
        zzYy = s2;
        zzanv = s3;
        zzaoG = s4;
        if (list2 == null)
        {
            list2 = Collections.emptyList();
        }
        zzaoH = list2;
        zzant = latlng;
        zzaoy = f;
        zzaoz = latlngbounds;
        if (s5 == null)
        {
            s5 = "UTC";
        }
        zzaoA = s5;
        zzanw = uri;
        zzaoB = flag;
        zzaoC = f1;
        zzaoD = j;
        zzaoE = l;
        zzaoq = null;
        zzaoI = flag1;
        zzaox = zzqd;
    }

    private void zzcn(String s)
    {
        if (zzaoI && zzaoL != null)
        {
            zzaoL.zzy(zzFA, s);
        }
    }

    public int describeContents()
    {
        zzpz zzpz1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof zzpy))
            {
                return false;
            }
            obj = (zzpy)obj;
            if (!zzFA.equals(((zzpy) (obj)).zzFA) || !zzw.equal(zzaoq, ((zzpy) (obj)).zzaoq) || zzaoE != ((zzpy) (obj)).zzaoE)
            {
                return false;
            }
        }
        return true;
    }

    public Object freeze()
    {
        return zzpV();
    }

    public volatile CharSequence getAddress()
    {
        return getAddress();
    }

    public String getAddress()
    {
        zzcn("getAddress");
        return zzYy;
    }

    public String getId()
    {
        zzcn("getId");
        return zzFA;
    }

    public LatLng getLatLng()
    {
        zzcn("getLatLng");
        return zzant;
    }

    public Locale getLocale()
    {
        zzcn("getLocale");
        return zzaoq;
    }

    public volatile CharSequence getName()
    {
        return getName();
    }

    public String getName()
    {
        zzcn("getName");
        return mName;
    }

    public volatile CharSequence getPhoneNumber()
    {
        return getPhoneNumber();
    }

    public String getPhoneNumber()
    {
        zzcn("getPhoneNumber");
        return zzanv;
    }

    public List getPlaceTypes()
    {
        zzcn("getPlaceTypes");
        return zzanu;
    }

    public int getPriceLevel()
    {
        zzcn("getPriceLevel");
        return zzaoD;
    }

    public float getRating()
    {
        zzcn("getRating");
        return zzaoC;
    }

    public LatLngBounds getViewport()
    {
        zzcn("getViewport");
        return zzaoz;
    }

    public Uri getWebsiteUri()
    {
        zzcn("getWebsiteUri");
        return zzanw;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzFA, zzaoq, Long.valueOf(zzaoE)
        });
    }

    public boolean isDataValid()
    {
        return true;
    }

    public void setLocale(Locale locale)
    {
        zzaoq = locale;
    }

    public String toString()
    {
        return zzw.zzk(this).zza("id", zzFA).zza("placeTypes", zzanu).zza("locale", zzaoq).zza("name", mName).zza("address", zzYy).zza("phoneNumber", zzanv).zza("latlng", zzant).zza("viewport", zzaoz).zza("websiteUri", zzanw).zza("isPermanentlyClosed", Boolean.valueOf(zzaoB)).zza("priceLevel", Integer.valueOf(zzaoD)).zza("timestampSecs", Long.valueOf(zzaoE)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzpz zzpz1 = CREATOR;
        zzpz.zza(this, parcel, i);
    }

    public void zza(zzqf zzqf1)
    {
        zzaoL = zzqf1;
    }

    public boolean zzpI()
    {
        zzcn("isPermanentlyClosed");
        return zzaoB;
    }

    public List zzpN()
    {
        zzcn("getTypesDeprecated");
        return zzaoF;
    }

    public float zzpO()
    {
        zzcn("getLevelNumber");
        return zzaoy;
    }

    public String zzpP()
    {
        zzcn("getRegularOpenHours");
        return zzaoG;
    }

    public List zzpQ()
    {
        zzcn("getAttributions");
        return zzaoH;
    }

    public long zzpR()
    {
        return zzaoE;
    }

    public Bundle zzpS()
    {
        return zzaow;
    }

    public String zzpT()
    {
        return zzaoA;
    }

    public zzqd zzpU()
    {
        zzcn("getLocalization");
        return zzaox;
    }

    public Place zzpV()
    {
        return this;
    }

}
