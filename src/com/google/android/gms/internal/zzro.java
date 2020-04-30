// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zzrp

public class zzro
    implements SafeParcelable
{

    public static final zzrp CREATOR = new zzrp();
    private final byte content[];
    private final String type;
    final int versionCode;

    zzro(int i, byte abyte0[], String s)
    {
        boolean flag;
        if (abyte0.length <= 1000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", new Object[] {
            Integer.valueOf(abyte0.length), Integer.valueOf(1000)
        });
        versionCode = i;
        content = (byte[])zzx.zzl(abyte0);
        type = (String)zzx.zzl(s);
    }

    public int describeContents()
    {
        zzrp zzrp1 = CREATOR;
        return 0;
    }

    public String getType()
    {
        return type;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzrp zzrp1 = CREATOR;
        zzrp.zza(this, parcel, i);
    }

    public byte[] zzro()
    {
        return content;
    }

}
