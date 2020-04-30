// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zzis, zziy, zziz

public class zzir
    implements SafeParcelable
{

    public static final zzis CREATOR = new zzis();
    public static final int zzFR = Integer.parseInt("-1");
    private static final zziz zzFS = (new zziz.zza("SsbContext")).zzI(true).zzaz("blob").zzgX();
    final int zzFG;
    public final String zzFT;
    final zziz zzFU;
    public final int zzFV;
    public final byte zzFW[];

    zzir(int i, String s, zziz zziz, int j, byte abyte0[])
    {
        boolean flag;
        if (j == zzFR || zziy.zzV(j) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, (new StringBuilder()).append("Invalid section type ").append(j).toString());
        zzFG = i;
        zzFT = s;
        zzFU = zziz;
        zzFV = j;
        zzFW = abyte0;
        s = zzgV();
        if (s != null)
        {
            throw new IllegalArgumentException(s);
        } else
        {
            return;
        }
    }

    public zzir(String s, zziz zziz)
    {
        this(1, s, zziz, zzFR, null);
    }

    public zzir(String s, zziz zziz, String s1)
    {
        this(1, s, zziz, zziy.zzay(s1), null);
    }

    public zzir(byte abyte0[], zziz zziz)
    {
        this(1, null, zziz, zzFR, abyte0);
    }

    public static zzir zzd(byte abyte0[])
    {
        return new zzir(abyte0, zzFS);
    }

    public int describeContents()
    {
        zzis zzis1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzis zzis1 = CREATOR;
        zzis.zza(this, parcel, i);
    }

    public String zzgV()
    {
        if (zzFV != zzFR && zziy.zzV(zzFV) == null)
        {
            return (new StringBuilder()).append("Invalid section type ").append(zzFV).toString();
        }
        if (zzFT != null && zzFW != null)
        {
            return "Both content and blobContent set";
        } else
        {
            return null;
        }
    }

}
