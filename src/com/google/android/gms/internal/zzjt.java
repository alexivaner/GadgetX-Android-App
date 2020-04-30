// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.text.TextUtils;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzjv, zzkc, zzke

public abstract class zzjt
{

    protected final zzkc zzKe;
    private final String zzKf;
    private zzke zzKg;

    protected zzjt(String s, String s1, String s2)
    {
        zzjv.zzaK(s);
        zzKf = s;
        zzKe = new zzkc(s1);
        if (!TextUtils.isEmpty(s2))
        {
            zzKe.zzaP(s2);
        }
    }

    public final String getNamespace()
    {
        return zzKf;
    }

    public final void zza(zzke zzke1)
    {
        zzKg = zzke1;
        if (zzKg == null)
        {
            zzhm();
        }
    }

    protected final void zza(String s, long l, String s1)
        throws IOException
    {
        zzKe.zza("Sending text message: %s to: %s", new Object[] {
            s, s1
        });
        zzKg.zza(zzKf, s, l, s1);
    }

    public void zzaI(String s)
    {
    }

    public void zzb(long l, int i)
    {
    }

    public void zzhm()
    {
    }

    protected final long zzhn()
    {
        return zzKg.zzhk();
    }
}
