// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

// Referenced classes of package com.google.android.gms.internal:
//            zzqj, zzqg, zzpy, zzqa

public class zzqc extends zzqj
    implements PlaceLikelihood
{

    private final Context mContext;

    public zzqc(DataHolder dataholder, int i, Context context)
    {
        super(dataholder, i);
        mContext = context;
    }

    public Object freeze()
    {
        return zzpX();
    }

    public float getLikelihood()
    {
        return zza("place_likelihood", -1F);
    }

    public Place getPlace()
    {
        return new zzqg(zzMd, zzNQ, mContext);
    }

    public PlaceLikelihood zzpX()
    {
        return zzqa.zza((zzpy)getPlace().freeze(), getLikelihood());
    }
}
