// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

// Referenced classes of package com.google.android.gms.nearby.connection:
//            AppMetadataCreator

public final class AppMetadata
    implements SafeParcelable
{

    public static final AppMetadataCreator CREATOR = new AppMetadataCreator();
    private final int zzFG;
    private final List zzasE;

    AppMetadata(int i, List list)
    {
        zzFG = i;
        zzasE = (List)zzx.zzb(list, "Must specify application identifiers");
        zzx.zza(list.size(), "Application identifiers cannot be empty");
    }

    public AppMetadata(List list)
    {
        this(1, list);
    }

    public int describeContents()
    {
        AppMetadataCreator appmetadatacreator = CREATOR;
        return 0;
    }

    public List getAppIdentifiers()
    {
        return zzasE;
    }

    public int getVersionCode()
    {
        return zzFG;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        AppMetadataCreator appmetadatacreator = CREATOR;
        AppMetadataCreator.zza(this, parcel, i);
    }

}
