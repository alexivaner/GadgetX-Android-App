// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzqn, zzql

public class zzqm
    implements SafeParcelable
{
    public static final class zza
        implements SafeParcelable
    {

        public static final zzql CREATOR = new zzql();
        final int zzFG;
        private final String zzFQ;
        private final String zzSy;

        public int describeContents()
        {
            zzql zzql1 = CREATOR;
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
                if (!zzw.equal(zzSy, ((zza) (obj)).zzSy) || !zzw.equal(zzFQ, ((zza) (obj)).zzFQ))
                {
                    return false;
                }
            }
            return true;
        }

        public String getTitle()
        {
            return zzSy;
        }

        public String getUri()
        {
            return zzFQ;
        }

        public int hashCode()
        {
            return zzw.hashCode(new Object[] {
                zzSy, zzFQ
            });
        }

        public String toString()
        {
            return zzw.zzk(this).zza("title", zzSy).zza("uri", zzFQ).toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzql zzql1 = CREATOR;
            zzql.zza(this, parcel, i);
        }


        zza(int i, String s, String s1)
        {
            zzFG = i;
            zzSy = s;
            zzFQ = s1;
        }
    }


    public static final zzqn CREATOR = new zzqn();
    final int zzFG;
    private final String zzapf;
    private final List zzapg;

    zzqm(int i, String s, List list)
    {
        zzFG = i;
        zzapf = s;
        zzapg = list;
    }

    public int describeContents()
    {
        zzqn zzqn1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof zzqm))
            {
                return false;
            }
            obj = (zzqm)obj;
            if (!zzw.equal(zzapf, ((zzqm) (obj)).zzapf) || !zzw.equal(zzapg, ((zzqm) (obj)).zzapg))
            {
                return false;
            }
        }
        return true;
    }

    public List getActions()
    {
        return zzapg;
    }

    public String getData()
    {
        return zzapf;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzapf, zzapg
        });
    }

    public String toString()
    {
        return zzw.zzk(this).zza("data", zzapf).zza("actions", zzapg).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzqn zzqn1 = CREATOR;
        zzqn.zza(this, parcel, i);
    }

}
