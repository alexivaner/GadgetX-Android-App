// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            zziq

public class zzip
    implements SafeParcelable
{

    public static final zziq CREATOR = new zziq();
    final int zzFG;
    final String zzFO;
    final String zzFP;
    final String zzFQ;

    zzip(int i, String s, String s1, String s2)
    {
        zzFG = i;
        zzFO = s;
        zzFP = s1;
        zzFQ = s2;
    }

    public zzip(String s, String s1, String s2)
    {
        this(1, s, s1, s2);
    }

    public int describeContents()
    {
        zziq zziq1 = CREATOR;
        return 0;
    }

    public String toString()
    {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[] {
            zzFO, zzFP, zzFQ
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zziq zziq1 = CREATOR;
        zziq.zza(this, parcel, i);
    }

}
