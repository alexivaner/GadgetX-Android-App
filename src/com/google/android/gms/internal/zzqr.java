// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zze;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zzqq

public final class zzqr extends zze
    implements Result
{

    private final Status zzHb;

    public zzqr(DataHolder dataholder)
    {
        this(dataholder, new Status(dataholder.getStatusCode()));
    }

    private zzqr(DataHolder dataholder, Status status)
    {
        super(dataholder, zzqq.CREATOR);
        boolean flag;
        if (dataholder == null || dataholder.getStatusCode() == status.getStatusCode())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzO(flag);
        zzHb = status;
    }

    public static zzqr zzaE(Status status)
    {
        return new zzqr(null, status);
    }

    public Status getStatus()
    {
        return zzHb;
    }
}
