// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzpq;

// Referenced classes of package com.google.android.gms.location.places:
//            AutocompletePrediction

public class AutocompletePredictionBuffer extends AbstractDataBuffer
    implements Result
{

    public AutocompletePredictionBuffer(DataHolder dataholder)
    {
        super(dataholder);
    }

    public AutocompletePrediction get(int i)
    {
        return new zzpq(zzMd, i);
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    public Status getStatus()
    {
        return new Status(zzMd.getStatusCode());
    }

    public String toString()
    {
        return zzw.zzk(this).zza("status", getStatus()).toString();
    }
}
