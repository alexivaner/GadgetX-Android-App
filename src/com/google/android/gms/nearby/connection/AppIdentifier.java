// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.nearby.connection:
//            AppIdentifierCreator

public final class AppIdentifier
    implements SafeParcelable
{

    public static final AppIdentifierCreator CREATOR = new AppIdentifierCreator();
    private final int zzFG;
    private final String zzZN;

    AppIdentifier(int i, String s)
    {
        zzFG = i;
        zzZN = zzx.zzb(s, "Missing application identifier value");
    }

    public AppIdentifier(String s)
    {
        this(1, s);
    }

    public int describeContents()
    {
        AppIdentifierCreator appidentifiercreator = CREATOR;
        return 0;
    }

    public String getIdentifier()
    {
        return zzZN;
    }

    public int getVersionCode()
    {
        return zzFG;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        AppIdentifierCreator appidentifiercreator = CREATOR;
        AppIdentifierCreator.zza(this, parcel, i);
    }

}
