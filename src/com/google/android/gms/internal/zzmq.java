// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.Field;

public class zzmq
{

    public static final zzmq zzZV = new zzmq();

    public zzmq()
    {
    }

    public zzxc.zzd zzb(Field field)
    {
        zzxc.zzd zzd = new zzxc.zzd();
        zzd.name = field.getName();
        zzd.zzaIh = Integer.valueOf(field.getFormat());
        return zzd;
    }

}
