// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

// Referenced classes of package com.google.android.gms.internal:
//            zzon

public class zzom
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzon();
    private final int zzFG;
    private final DataSource zzYp;

    zzom(int i, DataSource datasource)
    {
        zzFG = i;
        zzYp = datasource;
    }

    public int describeContents()
    {
        return 0;
    }

    public DataSource getDataSource()
    {
        return zzYp;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public String toString()
    {
        return String.format("ApplicationUnregistrationRequest{%s}", new Object[] {
            zzYp
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzon.zza(this, parcel, i);
    }

}
