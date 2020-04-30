// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.content.Context;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzqg;

// Referenced classes of package com.google.android.gms.location.places:
//            Place

public class PlaceBuffer extends AbstractDataBuffer
    implements Result
{

    private final Context mContext;
    private final Status zzHb;

    public PlaceBuffer(DataHolder dataholder, Context context)
    {
        super(dataholder);
        mContext = context;
        zzHb = new Status(dataholder.getStatusCode());
    }

    public Place get(int i)
    {
        return new zzqg(zzMd, i, mContext);
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    public Status getStatus()
    {
        return zzHb;
    }
}
