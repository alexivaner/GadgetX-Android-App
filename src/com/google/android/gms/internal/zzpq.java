// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzqj, zzpo

public class zzpq extends zzqj
    implements AutocompletePrediction
{

    public zzpq(DataHolder dataholder, int i)
    {
        super(dataholder, i);
    }

    public Object freeze()
    {
        return zzpL();
    }

    public String getDescription()
    {
        return zzz("ap_description", "");
    }

    public List getMatchedSubstrings()
    {
        return zza("ap_matched_subscriptions", zzpo.zza.CREATOR, Collections.emptyList());
    }

    public String getPlaceId()
    {
        return zzz("ap_place_id", null);
    }

    public List getPlaceTypes()
    {
        return zza("ap_place_types", Collections.emptyList());
    }

    public AutocompletePrediction zzpL()
    {
        return zzpo.zza(getDescription(), getPlaceId(), getPlaceTypes(), getMatchedSubstrings(), zzpM());
    }

    public int zzpM()
    {
        return zzC("ap_personalization_type", 6);
    }
}
