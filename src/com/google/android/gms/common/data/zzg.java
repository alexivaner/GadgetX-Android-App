// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.common.data:
//            AbstractDataBuffer, DataHolder

public abstract class zzg extends AbstractDataBuffer
{

    private boolean zzOi;
    private ArrayList zzOj;

    protected zzg(DataHolder dataholder)
    {
        super(dataholder);
        zzOi = false;
    }

    private void zziC()
    {
        this;
        JVM INSTR monitorenter ;
        if (zzOi) goto _L2; else goto _L1
_L1:
        int k;
        k = zzMd.getCount();
        zzOj = new ArrayList();
        if (k <= 0) goto _L4; else goto _L3
_L3:
        Object obj;
        String s1;
        zzOj.add(Integer.valueOf(0));
        s1 = zziB();
        int i = zzMd.zzax(0);
        obj = zzMd.zzc(s1, 0, i);
        int j = 1;
_L9:
        if (j >= k) goto _L4; else goto _L5
_L5:
        String s;
        int l;
        l = zzMd.zzax(j);
        s = zzMd.zzc(s1, j, l);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        throw new NullPointerException((new StringBuilder()).append("Missing value for markerColumn: ").append(s1).append(", at row: ").append(j).append(", for window: ").append(l).toString());
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (s.equals(obj)) goto _L7; else goto _L6
_L6:
        zzOj.add(Integer.valueOf(j));
        obj = s;
          goto _L7
_L4:
        zzOi = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L7:
        j++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final Object get(int i)
    {
        zziC();
        return zzj(zzaA(i), zzaB(i));
    }

    public int getCount()
    {
        zziC();
        return zzOj.size();
    }

    int zzaA(int i)
    {
        if (i < 0 || i >= zzOj.size())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Position ").append(i).append(" is out of bounds for this buffer").toString());
        } else
        {
            return ((Integer)zzOj.get(i)).intValue();
        }
    }

    protected int zzaB(int i)
    {
        int k;
        if (i < 0 || i == zzOj.size())
        {
            k = 0;
        } else
        {
            int j;
            if (i == zzOj.size() - 1)
            {
                j = zzMd.getCount() - ((Integer)zzOj.get(i)).intValue();
            } else
            {
                j = ((Integer)zzOj.get(i + 1)).intValue() - ((Integer)zzOj.get(i)).intValue();
            }
            k = j;
            if (j == 1)
            {
                i = zzaA(i);
                int l = zzMd.zzax(i);
                String s = zziD();
                k = j;
                if (s != null)
                {
                    k = j;
                    if (zzMd.zzc(s, i, l) == null)
                    {
                        return 0;
                    }
                }
            }
        }
        return k;
    }

    protected abstract String zziB();

    protected String zziD()
    {
        return null;
    }

    protected abstract Object zzj(int i, int j);
}
