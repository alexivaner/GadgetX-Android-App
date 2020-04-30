// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzpw;

// Referenced classes of package com.google.android.gms.location.places:
//            GeoDataApi, PlaceDetectionApi

public class Places
{

    public static final Api GEO_DATA_API;
    public static final GeoDataApi GeoDataApi = new zzpr();
    public static final Api PLACE_DETECTION_API;
    public static final PlaceDetectionApi PlaceDetectionApi = new zzpw();
    public static final com.google.android.gms.common.api.Api.zzc zzanT;
    public static final com.google.android.gms.common.api.Api.zzc zzanU;

    private Places()
    {
    }

    static 
    {
        zzanT = new com.google.android.gms.common.api.Api.zzc();
        zzanU = new com.google.android.gms.common.api.Api.zzc();
        GEO_DATA_API = new Api(new com.google.android.gms.internal.zzps.zza(null, null), zzanT, new Scope[0]);
        PLACE_DETECTION_API = new Api(new com.google.android.gms.internal.zzpx.zza(null, null), zzanU, new Scope[0]);
    }
}
