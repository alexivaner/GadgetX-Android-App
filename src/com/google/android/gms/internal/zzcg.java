// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

// Referenced classes of package com.google.android.gms.internal:
//            zzv

public final class zzcg extends zzci.zza
{

    private final zzv zzrg;
    private final String zzrh;
    private final String zzri;

    public zzcg(zzv zzv1, String s, String s1)
    {
        zzrg = zzv1;
        zzrh = s;
        zzri = s1;
    }

    public String getContent()
    {
        return zzri;
    }

    public void recordClick()
    {
        zzrg.recordClick();
    }

    public void recordImpression()
    {
        zzrg.recordImpression();
    }

    public void zza(zzd zzd)
    {
        if (zzd == null)
        {
            return;
        } else
        {
            zzrg.zzb((View)zze.zzf(zzd));
            return;
        }
    }

    public String zzcv()
    {
        return zzrh;
    }
}
