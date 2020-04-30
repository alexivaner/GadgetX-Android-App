// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzpp, zzqk

public class zzpo
    implements SafeParcelable, AutocompletePrediction
{
    public static class zza
        implements SafeParcelable, com.google.android.gms.location.places.AutocompletePrediction.Substring
    {

        public static final android.os.Parcelable.Creator CREATOR = new zzqk();
        final int mLength;
        final int mOffset;
        final int zzFG;

        public int describeContents()
        {
            return 0;
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (!(obj instanceof zza))
                {
                    return false;
                }
                obj = (zza)obj;
                if (!zzw.equal(Integer.valueOf(mOffset), Integer.valueOf(((zza) (obj)).mOffset)) || !zzw.equal(Integer.valueOf(mLength), Integer.valueOf(((zza) (obj)).mLength)))
                {
                    return false;
                }
            }
            return true;
        }

        public int getLength()
        {
            return mLength;
        }

        public int getOffset()
        {
            return mOffset;
        }

        public int hashCode()
        {
            return zzw.hashCode(new Object[] {
                Integer.valueOf(mOffset), Integer.valueOf(mLength)
            });
        }

        public String toString()
        {
            return zzw.zzk(this).zza("offset", Integer.valueOf(mOffset)).zza("length", Integer.valueOf(mLength)).toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzqk.zza(this, parcel, i);
        }


        public zza(int i, int j, int k)
        {
            zzFG = i;
            mOffset = j;
            mLength = k;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzpp();
    final int zzFG;
    final String zzZO;
    final String zzanM;
    final List zzanu;
    final List zzaoi;
    final int zzaoj;

    zzpo(int i, String s, String s1, List list, List list1, int j)
    {
        zzFG = i;
        zzZO = s;
        zzanM = s1;
        zzanu = list;
        zzaoi = list1;
        zzaoj = j;
    }

    public static zzpo zza(String s, String s1, List list, List list1, int i)
    {
        return new zzpo(0, (String)zzx.zzl(s), s1, list, list1, i);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof zzpo))
            {
                return false;
            }
            obj = (zzpo)obj;
            if (!zzw.equal(zzZO, ((zzpo) (obj)).zzZO) || !zzw.equal(zzanM, ((zzpo) (obj)).zzanM) || !zzw.equal(zzanu, ((zzpo) (obj)).zzanu) || !zzw.equal(zzaoi, ((zzpo) (obj)).zzaoi) || !zzw.equal(Integer.valueOf(zzaoj), Integer.valueOf(((zzpo) (obj)).zzaoj)))
            {
                return false;
            }
        }
        return true;
    }

    public Object freeze()
    {
        return zzpL();
    }

    public String getDescription()
    {
        return zzZO;
    }

    public List getMatchedSubstrings()
    {
        return zzaoi;
    }

    public String getPlaceId()
    {
        return zzanM;
    }

    public List getPlaceTypes()
    {
        return zzanu;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzZO, zzanM, zzanu, zzaoi, Integer.valueOf(zzaoj)
        });
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return zzw.zzk(this).zza("description", zzZO).zza("placeId", zzanM).zza("placeTypes", zzanu).zza("substrings", zzaoi).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzpp.zza(this, parcel, i);
    }

    public AutocompletePrediction zzpL()
    {
        return this;
    }

}
