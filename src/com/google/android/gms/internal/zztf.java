// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzth

public class zztf
    implements SafeParcelable
{

    public static final zzth CREATOR = new zzth();
    public final String tag;
    public final int versionCode;
    public final long zzatM;
    public final byte zzatN[];
    public final Bundle zzatO;

    zztf(int i, long l, String s, byte abyte0[], Bundle bundle)
    {
        versionCode = i;
        zzatM = l;
        tag = s;
        zzatN = abyte0;
        zzatO = bundle;
    }

    public transient zztf(long l, String s, byte abyte0[], String as[])
    {
        versionCode = 1;
        zzatM = l;
        tag = s;
        zzatN = abyte0;
        zzatO = zze(as);
    }

    private static transient Bundle zze(String as[])
    {
        Bundle bundle = null;
        if (as != null) goto _L2; else goto _L1
_L1:
        return bundle;
_L2:
        if (as.length % 2 != 0)
        {
            throw new IllegalArgumentException("extras must have an even number of elements");
        }
        int j = as.length / 2;
        if (j == 0)
        {
            continue;
        }
        Bundle bundle1 = new Bundle(j);
        int i = 0;
        do
        {
            bundle = bundle1;
            if (i >= j)
            {
                continue;
            }
            bundle1.putString(as[i * 2], as[i * 2 + 1]);
            i++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("tag=").append(tag).append(",");
        stringbuilder.append("eventTime=").append(zzatM).append(",");
        if (zzatO != null && !zzatO.isEmpty())
        {
            stringbuilder.append("keyValues=");
            for (Iterator iterator = zzatO.keySet().iterator(); iterator.hasNext(); stringbuilder.append(" "))
            {
                String s = (String)iterator.next();
                stringbuilder.append("(").append(s).append(",");
                stringbuilder.append(zzatO.getString(s)).append(")");
            }

        }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzth.zza(this, parcel, i);
    }

}
