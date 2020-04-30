// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwy, zzxc, zzww, zzwq, 
//            zzxb, zzwr

public static final class zzwe extends zzwy
{

    private static volatile zzaHM zzaIg[];
    public String name;
    public Integer zzaIh;
    public Boolean zzaIi;

    public static zzwe[] zzwd()
    {
        if (zzaIg == null)
        {
            synchronized (zzww.zzaHL)
            {
                if (zzaIg == null)
                {
                    zzaIg = new zzaIg[0];
                }
            }
        }
        return zzaIg;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof zzaIg))
        {
            return false;
        }
        obj = (zzaIg)obj;
        if (name == null)
        {
            if (((name) (obj)).name != null)
            {
                return false;
            }
        } else
        if (!name.equals(((name) (obj)).name))
        {
            return false;
        }
        if (zzaIh == null)
        {
            if (((zzaIh) (obj)).zzaIh != null)
            {
                return false;
            }
        } else
        if (!zzaIh.equals(((zzaIh) (obj)).zzaIh))
        {
            return false;
        }
        if (zzaIi != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((zzaIi) (obj)).zzaIi == null) goto _L1; else goto _L3
_L3:
        return false;
        if (zzaIi.equals(((zzaIi) (obj)).zzaIi)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (name == null)
        {
            i = 0;
        } else
        {
            i = name.hashCode();
        }
        if (zzaIh == null)
        {
            j = 0;
        } else
        {
            j = zzaIh.intValue();
        }
        if (zzaIi != null)
        {
            k = zzaIi.hashCode();
        }
        return (j + (i + 527) * 31) * 31 + k;
    }

    public zzaIi zzD(zzwq zzwq1)
        throws IOException
    {
_L6:
        int i = zzwq1.zzvu();
        i;
        JVM INSTR lookupswitch 4: default 48
    //                   0: 56
    //                   10: 58
    //                   24: 69
    //                   32: 110;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (zzxb.zzb(zzwq1, i)) goto _L6; else goto _L2
_L2:
        return this;
_L3:
        name = zzwq1.readString();
          goto _L6
_L4:
        int j = zzwq1.zzvx();
        switch (j)
        {
        case 1: // '\001'
        case 2: // '\002'
            zzaIh = Integer.valueOf(j);
            break;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        zzaIi = Boolean.valueOf(zzwq1.zzvy());
        if (true) goto _L6; else goto _L7
_L7:
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        if (name != null)
        {
            zzwr1.zzb(1, name);
        }
        if (zzaIh != null)
        {
            zzwr1.zzy(3, zzaIh.intValue());
        }
        if (zzaIi != null)
        {
            zzwr1.zzb(4, zzaIi.booleanValue());
        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzD(zzwq1);
    }

    protected int zzc()
    {
        int j = super.zzc();
        int i = j;
        if (name != null)
        {
            i = j + zzwr.zzj(1, name);
        }
        j = i;
        if (zzaIh != null)
        {
            j = i + zzwr.zzA(3, zzaIh.intValue());
        }
        i = j;
        if (zzaIi != null)
        {
            i = j + zzwr.zzc(4, zzaIi.booleanValue());
        }
        return i;
    }

    public zzaIi zzwe()
    {
        name = null;
        zzaIh = null;
        zzaIi = null;
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzwe();
    }
}
