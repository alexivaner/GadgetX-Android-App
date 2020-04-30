// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzqy

public final class zzrf extends zzqy
{

    private String zzBa;
    private String zzBb;
    private String zzBc;
    private String zzBd;

    public zzrf()
    {
    }

    public void setAppId(String s)
    {
        zzBc = s;
    }

    public void setAppInstallerId(String s)
    {
        zzBd = s;
    }

    public void setAppName(String s)
    {
        zzBa = s;
    }

    public void setAppVersion(String s)
    {
        zzBb = s;
    }

    public String toString()
    {
        ArrayMap arraymap = new ArrayMap();
        arraymap.put("appName", zzBa);
        arraymap.put("appVersion", zzBb);
        arraymap.put("appId", zzBc);
        arraymap.put("appInstallerId", zzBd);
        return zzG(arraymap);
    }

    public String zzga()
    {
        return zzBa;
    }

    public String zzgc()
    {
        return zzBb;
    }

    public String zznE()
    {
        return zzBc;
    }

    public String zzra()
    {
        return zzBd;
    }
}
