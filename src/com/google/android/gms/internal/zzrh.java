// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.google.android.gms.internal:
//            zzqy

public final class zzrh extends zzqy
{

    private String zzasq;
    private int zzasr;
    private int zzass;
    private String zzast;
    private String zzasu;
    private boolean zzasv;
    private boolean zzasw;
    private boolean zzasx;

    public zzrh()
    {
        this(false);
    }

    public zzrh(boolean flag)
    {
        this(flag, zzrd());
    }

    public zzrh(boolean flag, int i)
    {
        zzx.zzaL(i);
        zzasr = i;
        zzasw = flag;
    }

    static int zzrd()
    {
        UUID uuid = UUID.randomUUID();
        int i = (int)(uuid.getLeastSignificantBits() & 0x7fffffffL);
        if (i == 0)
        {
            int j = (int)(uuid.getMostSignificantBits() & 0x7fffffffL);
            i = j;
            if (j == 0)
            {
                Log.e("com.google.android.gms.measurement.data.ScreenViewInfo", "UUID.randomUUID() returned 0.");
                return 0x7fffffff;
            }
        }
        return i;
    }

    private void zzrj()
    {
        if (zzasx)
        {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        } else
        {
            return;
        }
    }

    public boolean isMutable()
    {
        return !zzasx;
    }

    public void setScreenName(String s)
    {
        zzrj();
        zzasq = s;
    }

    public String toString()
    {
        ArrayMap arraymap = new ArrayMap();
        arraymap.put("screenName", zzasq);
        arraymap.put("interstitial", Boolean.valueOf(zzasv));
        arraymap.put("automatic", Boolean.valueOf(zzasw));
        arraymap.put("screenId", Integer.valueOf(zzasr));
        arraymap.put("referrerScreenId", Integer.valueOf(zzass));
        arraymap.put("referrerScreenName", zzast);
        arraymap.put("referrerUri", zzasu);
        return zzG(arraymap);
    }

    public int zzaF()
    {
        return zzasr;
    }

    public void zzaa(boolean flag)
    {
        zzrj();
        zzasv = flag;
    }

    public void zzcv(String s)
    {
        zzrj();
        zzast = s;
    }

    public void zzgr(int i)
    {
        zzrj();
        zzass = i;
    }

    public String zzre()
    {
        return zzasq;
    }

    public int zzrf()
    {
        return zzass;
    }

    public String zzrg()
    {
        return zzast;
    }

    public void zzrh()
    {
        zzasx = true;
    }

    public boolean zzri()
    {
        return zzasv;
    }
}
