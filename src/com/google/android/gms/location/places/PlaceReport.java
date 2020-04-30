// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.location.places:
//            PlaceReportCreator

public class PlaceReport
    implements SafeParcelable
{

    public static final PlaceReportCreator CREATOR = new PlaceReportCreator();
    private final String mTag;
    final int zzFG;
    private final String zzanM;
    private final String zzanN;

    PlaceReport(int i, String s, String s1, String s2)
    {
        zzFG = i;
        zzanM = s;
        mTag = s1;
        zzanN = s2;
    }

    public static PlaceReport create(String s, String s1)
    {
        return zzf(s, s1, "unknown");
    }

    private static boolean zzcm(String s)
    {
        byte byte0;
        boolean flag;
        flag = true;
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 5: default 60
    //                   -1436706272: 128
    //                   -1194968642: 114
    //                   -284840886: 100
    //                   -262743844: 156
    //                   1287171955: 142;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        switch (byte0)
        {
        default:
            flag = false;
            // fall through

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            return flag;
        }
_L4:
        if (s.equals("unknown"))
        {
            byte0 = 0;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (s.equals("userReported"))
        {
            byte0 = 1;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (s.equals("inferredGeofencing"))
        {
            byte0 = 2;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (s.equals("inferredRadioSignals"))
        {
            byte0 = 3;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (s.equals("inferredReverseGeocoding"))
        {
            byte0 = 4;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    public static PlaceReport zzf(String s, String s1, String s2)
    {
        zzx.zzbn(s);
        zzx.zzbn(s1);
        zzx.zzbn(s2);
        zzx.zzb(zzcm(s2), "Invalid source");
        return new PlaceReport(1, s, s1, s2);
    }

    public int describeContents()
    {
        PlaceReportCreator placereportcreator = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof PlaceReport)
        {
            if (zzw.equal(zzanM, ((PlaceReport) (obj = (PlaceReport)obj)).zzanM) && zzw.equal(mTag, ((PlaceReport) (obj)).mTag) && zzw.equal(zzanN, ((PlaceReport) (obj)).zzanN))
            {
                return true;
            }
        }
        return false;
    }

    public String getPlaceId()
    {
        return zzanM;
    }

    public String getSource()
    {
        return zzanN;
    }

    public String getTag()
    {
        return mTag;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzanM, mTag, zzanN
        });
    }

    public String toString()
    {
        com.google.android.gms.common.internal.zzw.zza zza = zzw.zzk(this);
        zza.zza("placeId", zzanM);
        zza.zza("tag", mTag);
        if (!"unknown".equals(zzanN))
        {
            zza.zza("source", zzanN);
        }
        return zza.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        PlaceReportCreator placereportcreator = CREATOR;
        PlaceReportCreator.zza(this, parcel, i);
    }

}
