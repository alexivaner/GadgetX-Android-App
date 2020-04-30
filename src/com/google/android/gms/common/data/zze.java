// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.common.data:
//            AbstractDataBuffer, DataHolder

public class zze extends AbstractDataBuffer
{

    private static final String zzNS[] = {
        "data"
    };
    private final android.os.Parcelable.Creator zzNT;

    public zze(DataHolder dataholder, android.os.Parcelable.Creator creator)
    {
        super(dataholder);
        zzNT = creator;
    }

    public Object get(int i)
    {
        return zzaw(i);
    }

    public SafeParcelable zzaw(int i)
    {
        byte abyte0[] = zzMd.zzf("data", i, zzMd.zzax(i));
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(abyte0, 0, abyte0.length);
        parcel.setDataPosition(0);
        SafeParcelable safeparcelable = (SafeParcelable)zzNT.createFromParcel(parcel);
        parcel.recycle();
        return safeparcelable;
    }

}
