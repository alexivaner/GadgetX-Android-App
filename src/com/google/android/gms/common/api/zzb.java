// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.data.DataHolder;

public abstract class zzb
    implements zze.zzb
{

    private final DataHolder zzMd;

    protected zzb(DataHolder dataholder)
    {
        zzMd = dataholder;
    }

    protected abstract void zza(Object obj, DataHolder dataholder);

    public final void zze(Object obj)
    {
        zza(obj, zzMd);
    }

    public void zzhX()
    {
        if (zzMd != null)
        {
            zzMd.close();
        }
    }
}
