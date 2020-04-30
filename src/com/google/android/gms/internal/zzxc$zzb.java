// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwy, zzxc, zzww, zzwq, 
//            zzxb, zzwr

public static final class zzwb extends zzwy
{

    private static volatile zzaHM zzaHY[];
    public String name;
    public String zzaHZ;
    public String zzaIa;
    public Integer zzaIb;
    public zzaHM zzaIc;
    public zzaHM zzaId;
    public zzaHM zzaIe;

    public static zzwb[] zzwa()
    {
        if (zzaHY == null)
        {
            synchronized (zzww.zzaHL)
            {
                if (zzaHY == null)
                {
                    zzaHY = new zzaHY[0];
                }
            }
        }
        return zzaHY;
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
        if (!(obj instanceof zzaHY))
        {
            return false;
        }
        obj = (zzaHY)obj;
        if (zzaHZ == null)
        {
            if (((zzaHZ) (obj)).zzaHZ != null)
            {
                return false;
            }
        } else
        if (!zzaHZ.equals(((zzaHZ) (obj)).zzaHZ))
        {
            return false;
        }
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
        if (zzaIa == null)
        {
            if (((zzaIa) (obj)).zzaIa != null)
            {
                return false;
            }
        } else
        if (!zzaIa.equals(((zzaIa) (obj)).zzaIa))
        {
            return false;
        }
        if (zzaIb == null)
        {
            if (((zzaIb) (obj)).zzaIb != null)
            {
                return false;
            }
        } else
        if (!zzaIb.equals(((zzaIb) (obj)).zzaIb))
        {
            return false;
        }
        if (zzaIc == null)
        {
            if (((zzaIc) (obj)).zzaIc != null)
            {
                return false;
            }
        } else
        if (!zzaIc.equals(((equals) (obj)).zzaIc))
        {
            return false;
        }
        if (zzaId == null)
        {
            if (((zzaId) (obj)).zzaId != null)
            {
                return false;
            }
        } else
        if (!zzaId.equals(((equals) (obj)).zzaId))
        {
            return false;
        }
        if (zzaIe != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((zzaIe) (obj)).zzaIe == null) goto _L1; else goto _L3
_L3:
        return false;
        if (zzaIe.equals(((equals) (obj)).zzaIe)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int k1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        if (zzaHZ == null)
        {
            i = 0;
        } else
        {
            i = zzaHZ.hashCode();
        }
        if (name == null)
        {
            j = 0;
        } else
        {
            j = name.hashCode();
        }
        if (zzaIa == null)
        {
            k = 0;
        } else
        {
            k = zzaIa.hashCode();
        }
        if (zzaIb == null)
        {
            l = 0;
        } else
        {
            l = zzaIb.intValue();
        }
        if (zzaIc == null)
        {
            i1 = 0;
        } else
        {
            i1 = zzaIc.hashCode();
        }
        if (zzaId == null)
        {
            j1 = 0;
        } else
        {
            j1 = zzaId.hashCode();
        }
        if (zzaIe != null)
        {
            k1 = zzaIe.hashCode();
        }
        return (j1 + (i1 + (l + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + k1;
    }

    public hashCode zzB(zzwq zzwq1)
        throws IOException
    {
_L10:
        int i = zzwq1.zzvu();
        i;
        JVM INSTR lookupswitch 8: default 80
    //                   0: 88
    //                   10: 90
    //                   34: 101
    //                   42: 112
    //                   48: 123
    //                   58: 166
    //                   66: 195
    //                   74: 224;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        if (zzxb.zzb(zzwq1, i)) goto _L10; else goto _L2
_L2:
        return this;
_L3:
        zzaHZ = zzwq1.readString();
          goto _L10
_L4:
        name = zzwq1.readString();
          goto _L10
_L5:
        zzaIa = zzwq1.readString();
          goto _L10
_L6:
        int j = zzwq1.zzvx();
        switch (j)
        {
        case 0: // '\0'
        case 1: // '\001'
            zzaIb = Integer.valueOf(j);
            break;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (zzaIc == null)
        {
            zzaIc = new <init>();
        }
        zzwq1.zza(zzaIc);
        continue; /* Loop/switch isn't completed */
_L8:
        if (zzaId == null)
        {
            zzaId = new <init>();
        }
        zzwq1.zza(zzaId);
        continue; /* Loop/switch isn't completed */
_L9:
        if (zzaIe == null)
        {
            zzaIe = new <init>();
        }
        zzwq1.zza(zzaIe);
        if (true) goto _L10; else goto _L11
_L11:
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        if (zzaHZ != null)
        {
            zzwr1.zzb(1, zzaHZ);
        }
        if (name != null)
        {
            zzwr1.zzb(4, name);
        }
        if (zzaIa != null)
        {
            zzwr1.zzb(5, zzaIa);
        }
        if (zzaIb != null)
        {
            zzwr1.zzy(6, zzaIb.intValue());
        }
        if (zzaIc != null)
        {
            zzwr1.zza(7, zzaIc);
        }
        if (zzaId != null)
        {
            zzwr1.zza(8, zzaId);
        }
        if (zzaIe != null)
        {
            zzwr1.zza(9, zzaIe);
        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzB(zzwq1);
    }

    protected int zzc()
    {
        int j = super.zzc();
        int i = j;
        if (zzaHZ != null)
        {
            i = j + zzwr.zzj(1, zzaHZ);
        }
        j = i;
        if (name != null)
        {
            j = i + zzwr.zzj(4, name);
        }
        i = j;
        if (zzaIa != null)
        {
            i = j + zzwr.zzj(5, zzaIa);
        }
        j = i;
        if (zzaIb != null)
        {
            j = i + zzwr.zzA(6, zzaIb.intValue());
        }
        i = j;
        if (zzaIc != null)
        {
            i = j + zzwr.zzc(7, zzaIc);
        }
        j = i;
        if (zzaId != null)
        {
            j = i + zzwr.zzc(8, zzaId);
        }
        i = j;
        if (zzaIe != null)
        {
            i = j + zzwr.zzc(9, zzaIe);
        }
        return i;
    }

    public zzaIe zzwb()
    {
        zzaHZ = null;
        name = null;
        zzaIa = null;
        zzaIb = null;
        zzaIc = null;
        zzaId = null;
        zzaIe = null;
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzwb();
    }
}
