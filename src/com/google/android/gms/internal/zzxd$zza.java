// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwy, zzxd, zzww, zzwq, 
//            zzxb, zzwr

public static final class zzwi extends zzwy
{

    public long zzaIq;
    public long zzaIr;
    public int zzaIs;
    public zzaHM zzaIt;
    public int zzaIu;
    public zzaHM zzaIv[];
    public int zzaIw;
    public boolean zzaIx;
    public zzaHM zzaIy[];

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzwi))
            {
                return false;
            }
            obj = (zzwi)obj;
            if (zzaIq != ((zzaIq) (obj)).zzaIq)
            {
                return false;
            }
            if (zzaIr != ((zzaIr) (obj)).zzaIr)
            {
                return false;
            }
            if (zzaIs != ((zzaIs) (obj)).zzaIs)
            {
                return false;
            }
            if (zzaIt == null)
            {
                if (((zzaIt) (obj)).zzaIt != null)
                {
                    return false;
                }
            } else
            if (!zzaIt.equals(((equals) (obj)).zzaIt))
            {
                return false;
            }
            if (zzaIu != ((zzaIu) (obj)).zzaIu)
            {
                return false;
            }
            if (!zzww.equals(zzaIv, ((zzaIv) (obj)).zzaIv))
            {
                return false;
            }
            if (zzaIw != ((zzaIw) (obj)).zzaIw)
            {
                return false;
            }
            if (zzaIx != ((zzaIx) (obj)).zzaIx)
            {
                return false;
            }
            if (!zzww.equals(zzaIy, ((zzaIy) (obj)).zzaIy))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = (int)(zzaIq ^ zzaIq >>> 32);
        int k = (int)(zzaIr ^ zzaIr >>> 32);
        int l = zzaIs;
        int i;
        char c;
        int i1;
        int j1;
        int k1;
        if (zzaIt == null)
        {
            i = 0;
        } else
        {
            i = zzaIt.hashCode();
        }
        i1 = zzaIu;
        j1 = zzww.hashCode(zzaIv);
        k1 = zzaIw;
        if (zzaIx)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        return (c + ((((i + (((j + 527) * 31 + k) * 31 + l) * 31) * 31 + i1) * 31 + j1) * 31 + k1) * 31) * 31 + zzww.hashCode(zzaIy);
    }

    public zzaIy zzG(zzwq zzwq1)
        throws IOException
    {
_L12:
        int i = zzwq1.zzvu();
        i;
        JVM INSTR lookupswitch 10: default 96
    //                   0: 104
    //                   8: 106
    //                   16: 117
    //                   24: 128
    //                   34: 139
    //                   40: 168
    //                   50: 179
    //                   56: 303
    //                   64: 355
    //                   74: 366;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        if (zzxb.zzb(zzwq1, i)) goto _L12; else goto _L2
_L2:
        return this;
_L3:
        zzaIq = zzwq1.zzvw();
          goto _L12
_L4:
        zzaIr = zzwq1.zzvw();
          goto _L12
_L5:
        zzaIs = zzwq1.zzvx();
          goto _L12
_L6:
        if (zzaIt == null)
        {
            zzaIt = new <init>();
        }
        zzwq1.zza(zzaIt);
          goto _L12
_L7:
        zzaIu = zzwq1.zzvx();
          goto _L12
_L8:
        int i1 = zzxb.zzc(zzwq1, 50);
        zzaIy azzaiy[];
        int j;
        if (zzaIv == null)
        {
            j = 0;
        } else
        {
            j = zzaIv.length;
        }
        azzaiy = new zzaIv[i1 + j];
        i1 = j;
        if (j != 0)
        {
            System.arraycopy(zzaIv, 0, azzaiy, 0, j);
            i1 = j;
        }
        for (; i1 < azzaiy.length - 1; i1++)
        {
            azzaiy[i1] = new <init>();
            zzwq1.zza(azzaiy[i1]);
            zzwq1.zzvu();
        }

        azzaiy[i1] = new <init>();
        zzwq1.zza(azzaiy[i1]);
        zzaIv = azzaiy;
          goto _L12
_L9:
        int k = zzwq1.zzvx();
        switch (k)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            zzaIw = k;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        zzaIx = zzwq1.zzvy();
        continue; /* Loop/switch isn't completed */
_L11:
        int j1 = zzxb.zzc(zzwq1, 74);
        zzaIy azzaiy1[];
        int l;
        if (zzaIy == null)
        {
            l = 0;
        } else
        {
            l = zzaIy.length;
        }
        azzaiy1 = new zzaIy[j1 + l];
        j1 = l;
        if (l != 0)
        {
            System.arraycopy(zzaIy, 0, azzaiy1, 0, l);
            j1 = l;
        }
        for (; j1 < azzaiy1.length - 1; j1++)
        {
            azzaiy1[j1] = new <init>();
            zzwq1.zza(azzaiy1[j1]);
            zzwq1.zzvu();
        }

        azzaiy1[j1] = new <init>();
        zzwq1.zza(azzaiy1[j1]);
        zzaIy = azzaiy1;
        if (true) goto _L12; else goto _L13
_L13:
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        boolean flag = false;
        if (zzaIq != 0L)
        {
            zzwr1.zzb(1, zzaIq);
        }
        if (zzaIr != 0L)
        {
            zzwr1.zzb(2, zzaIr);
        }
        if (zzaIs != 0)
        {
            zzwr1.zzy(3, zzaIs);
        }
        if (zzaIt != null)
        {
            zzwr1.zza(4, zzaIt);
        }
        if (zzaIu != 0)
        {
            zzwr1.zzy(5, zzaIu);
        }
        if (zzaIv != null && zzaIv.length > 0)
        {
            for (int i = 0; i < zzaIv.length; i++)
            {
                zzaIy zzaiy = zzaIv[i];
                if (zzaiy != null)
                {
                    zzwr1.zza(6, zzaiy);
                }
            }

        }
        if (zzaIw != 0)
        {
            zzwr1.zzy(7, zzaIw);
        }
        if (zzaIx)
        {
            zzwr1.zzb(8, zzaIx);
        }
        if (zzaIy != null && zzaIy.length > 0)
        {
            for (int j = ((flag) ? 1 : 0); j < zzaIy.length; j++)
            {
                zzaIy zzaiy1 = zzaIy[j];
                if (zzaiy1 != null)
                {
                    zzwr1.zza(9, zzaiy1);
                }
            }

        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzG(zzwq1);
    }

    protected int zzc()
    {
        boolean flag = false;
        int j = super.zzc();
        int i = j;
        if (zzaIq != 0L)
        {
            i = j + zzwr.zzd(1, zzaIq);
        }
        j = i;
        if (zzaIr != 0L)
        {
            j = i + zzwr.zzd(2, zzaIr);
        }
        i = j;
        if (zzaIs != 0)
        {
            i = j + zzwr.zzA(3, zzaIs);
        }
        j = i;
        if (zzaIt != null)
        {
            j = i + zzwr.zzc(4, zzaIt);
        }
        i = j;
        if (zzaIu != 0)
        {
            i = j + zzwr.zzA(5, zzaIu);
        }
        j = i;
        if (zzaIv != null)
        {
            j = i;
            if (zzaIv.length > 0)
            {
                for (j = 0; j < zzaIv.length;)
                {
                    zzG zzg = zzaIv[j];
                    int l = i;
                    if (zzg != null)
                    {
                        l = i + zzwr.zzc(6, zzg);
                    }
                    j++;
                    i = l;
                }

                j = i;
            }
        }
        int i1 = j;
        if (zzaIw != 0)
        {
            i1 = j + zzwr.zzA(7, zzaIw);
        }
        i = i1;
        if (zzaIx)
        {
            i = i1 + zzwr.zzc(8, zzaIx);
        }
        i1 = i;
        if (zzaIy != null)
        {
            i1 = i;
            if (zzaIy.length > 0)
            {
                int k = ((flag) ? 1 : 0);
                do
                {
                    i1 = i;
                    if (k >= zzaIy.length)
                    {
                        break;
                    }
                    zzG zzg1 = zzaIy[k];
                    i1 = i;
                    if (zzg1 != null)
                    {
                        i1 = i + zzwr.zzc(9, zzg1);
                    }
                    k++;
                    i = i1;
                } while (true);
            }
        }
        return i1;
    }

    public zzaIy zzwi()
    {
        zzaIq = 0L;
        zzaIr = 0L;
        zzaIs = 0;
        zzaIt = null;
        zzaIu = 0;
        zzaIv = zzwl();
        zzaIw = 0;
        zzaIx = false;
        zzaIy = zzwa();
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzwi();
    }
}
