// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.location:
//            LocationSettingsRequest, LocationRequest

public static final class zzamn
{

    private boolean zzamm;
    private boolean zzamn;
    private final ArrayList zzamo = new ArrayList();

    public zzamn addAllLocationRequests(Collection collection)
    {
        zzamo.addAll(collection);
        return this;
    }

    public zzamo addLocationRequest(LocationRequest locationrequest)
    {
        zzamo.add(locationrequest);
        return this;
    }

    public LocationSettingsRequest build()
    {
        return new LocationSettingsRequest(zzamo, zzamm, zzamn, null);
    }

    public zzamn setAlwaysShow(boolean flag)
    {
        zzamm = flag;
        return this;
    }

    public zzamm setNeedBle(boolean flag)
    {
        zzamn = flag;
        return this;
    }

    public ()
    {
        zzamm = false;
        zzamn = false;
    }
}
