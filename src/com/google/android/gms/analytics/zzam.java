// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.analytics:
//            zzm

class zzam
    implements zzm
{

    String zzFr;
    double zzFs;
    int zzFt;
    int zzFu;
    int zzFv;
    int zzFw;
    Map zzFx;

    zzam()
    {
        zzFs = -1D;
        zzFt = -1;
        zzFu = -1;
        zzFv = -1;
        zzFw = -1;
        zzFx = new HashMap();
    }

    public int getSessionTimeout()
    {
        return zzFt;
    }

    public String zzas(String s)
    {
        String s1 = (String)zzFx.get(s);
        if (s1 != null)
        {
            return s1;
        } else
        {
            return s;
        }
    }

    public boolean zzgK()
    {
        return zzFr != null;
    }

    public String zzgL()
    {
        return zzFr;
    }

    public boolean zzgM()
    {
        return zzFs >= 0.0D;
    }

    public double zzgN()
    {
        return zzFs;
    }

    public boolean zzgO()
    {
        return zzFt >= 0;
    }

    public boolean zzgP()
    {
        return zzFu != -1;
    }

    public boolean zzgQ()
    {
        return zzFu == 1;
    }

    public boolean zzgR()
    {
        return zzFv != -1;
    }

    public boolean zzgS()
    {
        return zzFv == 1;
    }

    public boolean zzgT()
    {
        return zzFw == 1;
    }

    public String zzq(Activity activity)
    {
        return zzas(activity.getClass().getCanonicalName());
    }
}
