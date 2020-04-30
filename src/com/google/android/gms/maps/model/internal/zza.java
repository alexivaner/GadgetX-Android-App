// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.maps.model.internal:
//            zzb

public final class zza
    implements SafeParcelable
{

    public static final zzb CREATOR = new zzb();
    private final int zzFG;
    private byte zzarN;
    private Bundle zzarO;
    private Bitmap zzarP;

    zza(int i, byte byte0, Bundle bundle, Bitmap bitmap)
    {
        zzFG = i;
        zzarN = byte0;
        zzarO = bundle;
        zzarP = bitmap;
    }

    public int describeContents()
    {
        return 0;
    }

    public Bitmap getBitmap()
    {
        return zzarP;
    }

    public byte getType()
    {
        return zzarN;
    }

    public int getVersionCode()
    {
        return zzFG;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

    public Bundle zzqL()
    {
        return zzarO;
    }

}
