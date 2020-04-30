// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.cast:
//            MediaMetadata

private static class 
{

    private final Map zzJd = new HashMap();
    private final Map zzJe = new HashMap();
    private final Map zzJf = new HashMap();

    public String zzaE(String s)
    {
        return (String)zzJd.get(s);
    }

    public String zzaF(String s)
    {
        return (String)zzJe.get(s);
    }

    public int zzaG(String s)
    {
        s = (Integer)zzJf.get(s);
        if (s != null)
        {
            return s.intValue();
        } else
        {
            return 0;
        }
    }

    public zzJf zzb(String s, String s1, int i)
    {
        zzJd.put(s, s1);
        zzJe.put(s1, s);
        zzJf.put(s, Integer.valueOf(i));
        return this;
    }

    public ()
    {
    }
}
