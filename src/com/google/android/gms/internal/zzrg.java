// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzqy

public final class zzrg extends zzqy
{

    private String zzIO;
    public int zzasn;
    public int zzaso;
    public int zzasp;
    public int zztI;
    public int zztJ;

    public zzrg()
    {
    }

    public void setLanguage(String s)
    {
        zzIO = s;
    }

    public String toString()
    {
        ArrayMap arraymap = new ArrayMap();
        arraymap.put("language", zzIO);
        arraymap.put("screenColors", Integer.valueOf(zzasn));
        arraymap.put("screenWidth", Integer.valueOf(zztI));
        arraymap.put("screenHeight", Integer.valueOf(zztJ));
        arraymap.put("viewportWidth", Integer.valueOf(zzaso));
        arraymap.put("viewportHeight", Integer.valueOf(zzasp));
        return zzG(arraymap);
    }

    public void zzgp(int i)
    {
        zztI = i;
    }

    public void zzgq(int i)
    {
        zztJ = i;
    }

    public int zzrb()
    {
        return zztI;
    }

    public int zzrc()
    {
        return zztJ;
    }
}
