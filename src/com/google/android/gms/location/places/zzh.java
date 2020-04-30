// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public class zzh
    implements Result
{

    private final Status zzHb;
    private final List zzanQ;

    public zzh(Status status, List list)
    {
        zzHb = status;
        zzanQ = list;
    }

    public Status getStatus()
    {
        return zzHb;
    }
}
