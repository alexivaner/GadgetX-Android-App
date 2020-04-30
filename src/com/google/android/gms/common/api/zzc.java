// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.common.api:
//            Releasable, Result, Status

public abstract class zzc
    implements Releasable, Result
{

    protected final Status zzHb;
    protected final DataHolder zzMd;

    protected zzc(DataHolder dataholder)
    {
        this(dataholder, new Status(dataholder.getStatusCode()));
    }

    protected zzc(DataHolder dataholder, Status status)
    {
        zzHb = status;
        zzMd = dataholder;
    }

    public Status getStatus()
    {
        return zzHb;
    }

    public void release()
    {
        if (zzMd != null)
        {
            zzMd.close();
        }
    }
}
