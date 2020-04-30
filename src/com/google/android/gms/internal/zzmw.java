// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import java.util.concurrent.TimeUnit;

public class zzmw
{

    public static final zzmw zzZW = new zzmw();

    public zzmw()
    {
    }

    public Session zza(zzxe.zza zza1)
    {
        String s;
        com.google.android.gms.fitness.data.Session.Builder builder;
        if (zza1.zzaIe == null)
        {
            s = "unknown";
        } else
        {
            s = zza1.zzaIe.packageName;
        }
        builder = new com.google.android.gms.fitness.data.Session.Builder();
        if (zza1.zzfl != null)
        {
            builder.setIdentifier(zza1.zzfl);
        }
        if (zza1.name != null)
        {
            builder.setName(zza1.name);
        }
        if (zza1.description != null)
        {
            builder.setDescription(zza1.description);
        }
        if (zza1.zzaIL != null)
        {
            builder.setStartTime(zza1.zzaIL.longValue(), TimeUnit.MILLISECONDS);
        }
        if (zza1.zzaIM != null)
        {
            builder.setEndTime(zza1.zzaIM.longValue(), TimeUnit.MILLISECONDS);
        }
        if (zza1.zzaIO != null)
        {
            builder.zzds(zza1.zzaIO.intValue());
        }
        builder.zzbL(s);
        return builder.build();
    }

    public zzxe.zza zzb(Session session)
    {
        zzxe.zza zza1 = new zzxe.zza();
        zzx.zzb(session.getIdentifier(), (new StringBuilder()).append("session require identifier: ").append(session).toString());
        zza1.zzfl = session.getIdentifier();
        if (session.getName() != null)
        {
            zza1.name = session.getName();
        }
        if (session.getDescription() != null)
        {
            zza1.description = session.getDescription();
        }
        zza1.zzaIL = Long.valueOf(session.getStartTime(TimeUnit.MILLISECONDS));
        zza1.zzaIM = Long.valueOf(session.getEndTime(TimeUnit.MILLISECONDS));
        zza1.zzaIO = Integer.valueOf(session.zzln());
        if (session.getAppPackageName() != null)
        {
            zza1.zzaIe = new zzxc.zza();
            zza1.zzaIe.packageName = session.getAppPackageName();
        }
        return zza1;
    }

}
