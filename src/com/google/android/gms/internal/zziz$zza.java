// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zziz, zzit

public static final class zzGq
{

    private final String mName;
    private String zzGo;
    private boolean zzGp;
    private int zzGq;
    private boolean zzGr;
    private String zzGs;
    private final List zzGt = new ArrayList();
    private BitSet zzGu;
    private String zzGv;

    public zzGq zzI(boolean flag)
    {
        zzGp = flag;
        return this;
    }

    public zzGp zzJ(boolean flag)
    {
        zzGr = flag;
        return this;
    }

    public zzGr zzW(int i)
    {
        if (zzGu == null)
        {
            zzGu = new BitSet();
        }
        zzGu.set(i);
        return this;
    }

    public zzGu zzaA(String s)
    {
        zzGv = s;
        return this;
    }

    public zzGv zzaz(String s)
    {
        zzGo = s;
        return this;
    }

    public zziz zzgX()
    {
        int i = 0;
        int ai[] = null;
        if (zzGu != null)
        {
            int ai1[] = new int[zzGu.cardinality()];
            int j = zzGu.nextSetBit(0);
            do
            {
                ai = ai1;
                if (j < 0)
                {
                    break;
                }
                ai1[i] = j;
                j = zzGu.nextSetBit(j + 1);
                i++;
            } while (true);
        }
        return new zziz(mName, zzGo, zzGp, zzGq, zzGr, zzGs, (zzit[])zzGt.toArray(new zzit[zzGt.size()]), ai, zzGv);
    }

    public (String s)
    {
        mName = s;
        zzGq = 1;
    }
}
