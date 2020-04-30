// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.identity.intents.model:
//            zzb

public final class UserAddress
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    String name;
    private final int zzFG;
    String zzalA;
    String zzalB;
    String zzalC;
    String zzalD;
    boolean zzalE;
    String zzalF;
    String zzalG;
    String zzalu;
    String zzalv;
    String zzalw;
    String zzalx;
    String zzaly;
    String zzalz;
    String zzyc;

    UserAddress()
    {
        zzFG = 1;
    }

    UserAddress(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, String s8, String s9, String s10, String s11, boolean flag, 
            String s12, String s13)
    {
        zzFG = i;
        name = s;
        zzalu = s1;
        zzalv = s2;
        zzalw = s3;
        zzalx = s4;
        zzaly = s5;
        zzalz = s6;
        zzalA = s7;
        zzyc = s8;
        zzalB = s9;
        zzalC = s10;
        zzalD = s11;
        zzalE = flag;
        zzalF = s12;
        zzalG = s13;
    }

    public static UserAddress fromIntent(Intent intent)
    {
        if (intent == null || !intent.hasExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS"))
        {
            return null;
        } else
        {
            return (UserAddress)intent.getParcelableExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS");
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAddress1()
    {
        return zzalu;
    }

    public String getAddress2()
    {
        return zzalv;
    }

    public String getAddress3()
    {
        return zzalw;
    }

    public String getAddress4()
    {
        return zzalx;
    }

    public String getAddress5()
    {
        return zzaly;
    }

    public String getAdministrativeArea()
    {
        return zzalz;
    }

    public String getCompanyName()
    {
        return zzalF;
    }

    public String getCountryCode()
    {
        return zzyc;
    }

    public String getEmailAddress()
    {
        return zzalG;
    }

    public String getLocality()
    {
        return zzalA;
    }

    public String getName()
    {
        return name;
    }

    public String getPhoneNumber()
    {
        return zzalD;
    }

    public String getPostalCode()
    {
        return zzalB;
    }

    public String getSortingCode()
    {
        return zzalC;
    }

    public int getVersionCode()
    {
        return zzFG;
    }

    public boolean isPostBox()
    {
        return zzalE;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
