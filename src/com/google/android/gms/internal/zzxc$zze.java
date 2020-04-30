// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwy, zzxc, zzwq, zzxb, 
//            zzwr

public static final class zzwf extends zzwy
{

    public String version;
    public Integer zzaIb;
    public String zzaIj;
    public String zzaIk;
    public String zzaIl;
    public Integer zzaIm;

    public boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof zzwf))
        {
            return false;
        }
        obj = (zzwf)obj;
        if (zzaIj == null)
        {
            if (((zzaIj) (obj)).zzaIj != null)
            {
                return false;
            }
        } else
        if (!zzaIj.equals(((zzaIj) (obj)).zzaIj))
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
        if (version == null)
        {
            if (((version) (obj)).version != null)
            {
                return false;
            }
        } else
        if (!version.equals(((version) (obj)).version))
        {
            return false;
        }
        if (zzaIk == null)
        {
            if (((zzaIk) (obj)).zzaIk != null)
            {
                return false;
            }
        } else
        if (!zzaIk.equals(((zzaIk) (obj)).zzaIk))
        {
            return false;
        }
        if (zzaIl == null)
        {
            if (((zzaIl) (obj)).zzaIl != null)
            {
                return false;
            }
        } else
        if (!zzaIl.equals(((zzaIl) (obj)).zzaIl))
        {
            return false;
        }
        if (zzaIm != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((zzaIm) (obj)).zzaIm == null) goto _L1; else goto _L3
_L3:
        return false;
        if (zzaIm.equals(((zzaIm) (obj)).zzaIm)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int j1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        if (zzaIj == null)
        {
            i = 0;
        } else
        {
            i = zzaIj.hashCode();
        }
        if (zzaIb == null)
        {
            j = 0;
        } else
        {
            j = zzaIb.intValue();
        }
        if (version == null)
        {
            k = 0;
        } else
        {
            k = version.hashCode();
        }
        if (zzaIk == null)
        {
            l = 0;
        } else
        {
            l = zzaIk.hashCode();
        }
        if (zzaIl == null)
        {
            i1 = 0;
        } else
        {
            i1 = zzaIl.hashCode();
        }
        if (zzaIm != null)
        {
            j1 = zzaIm.intValue();
        }
        return (i1 + (l + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + j1;
    }

    public zzaIm zzE(zzwq zzwq1)
        throws IOException
    {
_L9:
        int i = zzwq1.zzvu();
        i;
        JVM INSTR lookupswitch 7: default 72
    //                   0: 80
    //                   10: 82
    //                   16: 93
    //                   26: 150
    //                   34: 161
    //                   42: 172
    //                   48: 183;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        if (zzxb.zzb(zzwq1, i)) goto _L9; else goto _L2
_L2:
        return this;
_L3:
        zzaIj = zzwq1.readString();
          goto _L9
_L4:
        int j = zzwq1.zzvx();
        switch (j)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            zzaIb = Integer.valueOf(j);
            break;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        version = zzwq1.readString();
        continue; /* Loop/switch isn't completed */
_L6:
        zzaIk = zzwq1.readString();
        continue; /* Loop/switch isn't completed */
_L7:
        zzaIl = zzwq1.readString();
        continue; /* Loop/switch isn't completed */
_L8:
        int k = zzwq1.zzvx();
        switch (k)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            zzaIm = Integer.valueOf(k);
            break;
        }
        if (true) goto _L9; else goto _L10
_L10:
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        if (zzaIj != null)
        {
            zzwr1.zzb(1, zzaIj);
        }
        if (zzaIb != null)
        {
            zzwr1.zzy(2, zzaIb.intValue());
        }
        if (version != null)
        {
            zzwr1.zzb(3, version);
        }
        if (zzaIk != null)
        {
            zzwr1.zzb(4, zzaIk);
        }
        if (zzaIl != null)
        {
            zzwr1.zzb(5, zzaIl);
        }
        if (zzaIm != null)
        {
            zzwr1.zzy(6, zzaIm.intValue());
        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzE(zzwq1);
    }

    protected int zzc()
    {
        int j = super.zzc();
        int i = j;
        if (zzaIj != null)
        {
            i = j + zzwr.zzj(1, zzaIj);
        }
        j = i;
        if (zzaIb != null)
        {
            j = i + zzwr.zzA(2, zzaIb.intValue());
        }
        i = j;
        if (version != null)
        {
            i = j + zzwr.zzj(3, version);
        }
        j = i;
        if (zzaIk != null)
        {
            j = i + zzwr.zzj(4, zzaIk);
        }
        i = j;
        if (zzaIl != null)
        {
            i = j + zzwr.zzj(5, zzaIl);
        }
        j = i;
        if (zzaIm != null)
        {
            j = i + zzwr.zzA(6, zzaIm.intValue());
        }
        return j;
    }

    public zzaIm zzwf()
    {
        zzaIj = null;
        zzaIb = null;
        version = null;
        zzaIk = null;
        zzaIl = null;
        zzaIm = null;
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzwf();
    }
}
