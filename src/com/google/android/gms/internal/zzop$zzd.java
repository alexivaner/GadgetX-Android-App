// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzop, zzwr, zzwq, 
//            zzwy

public static final class zzpl extends zzws
{

    public String zzQN;
    public boolean zzall;
    public long zzalm;
    public double zzaln;
    public zzalo zzalo;

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof zzpl)) goto _L4; else goto _L3
_L3:
        obj = (zzpl)obj;
        flag = flag1;
        if (zzall != ((zzall) (obj)).zzall) goto _L4; else goto _L5
_L5:
        if (zzQN != null) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (((zzQN) (obj)).zzQN != null) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (zzalm != ((zzalm) (obj)).zzalm) goto _L4; else goto _L9
_L9:
        flag = flag1;
        if (Double.doubleToLongBits(zzaln) != Double.doubleToLongBits(((zzaln) (obj)).zzaln)) goto _L4; else goto _L10
_L10:
        if (zzalo != null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        flag = flag1;
        if (((zzalo) (obj)).zzalo != null) goto _L4; else goto _L11
_L11:
        return zza(((zzws) (obj)));
_L7:
        if (!zzQN.equals(((zzQN) (obj)).zzQN))
        {
            return false;
        }
          goto _L8
        if (!zzalo.equals(((equals) (obj)).zzalo))
        {
            return false;
        }
          goto _L11
    }

    public int hashCode()
    {
        int j = 0;
        char c;
        int i;
        int k;
        int l;
        long l1;
        if (zzall)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        if (zzQN == null)
        {
            i = 0;
        } else
        {
            i = zzQN.hashCode();
        }
        k = (int)(zzalm ^ zzalm >>> 32);
        l1 = Double.doubleToLongBits(zzaln);
        l = (int)(l1 ^ l1 >>> 32);
        if (zzalo != null)
        {
            j = zzalo.hashCode();
        }
        return ((((i + (c + 527) * 31) * 31 + k) * 31 + l) * 31 + j) * 31 + zzvL();
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        if (zzall)
        {
            zzwr1.zzb(1, zzall);
        }
        if (!zzQN.equals(""))
        {
            zzwr1.zzb(2, zzQN);
        }
        if (zzalm != 0L)
        {
            zzwr1.zzb(3, zzalm);
        }
        if (Double.doubleToLongBits(zzaln) != Double.doubleToLongBits(0.0D))
        {
            zzwr1.zza(4, zzaln);
        }
        if (zzalo != null)
        {
            zzwr1.zza(5, zzalo);
        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzs(zzwq1);
    }

    protected int zzc()
    {
        int j = super.zzc();
        int i = j;
        if (zzall)
        {
            i = j + zzwr.zzc(1, zzall);
        }
        j = i;
        if (!zzQN.equals(""))
        {
            j = i + zzwr.zzj(2, zzQN);
        }
        i = j;
        if (zzalm != 0L)
        {
            i = j + zzwr.zzd(3, zzalm);
        }
        j = i;
        if (Double.doubleToLongBits(zzaln) != Double.doubleToLongBits(0.0D))
        {
            j = i + zzwr.zzb(4, zzaln);
        }
        i = j;
        if (zzalo != null)
        {
            i = j + zzwr.zzc(5, zzalo);
        }
        return i;
    }

    public zzalo zzpl()
    {
        zzall = false;
        zzQN = "";
        zzalm = 0L;
        zzaln = 0.0D;
        zzalo = null;
        zzaHB = null;
        zzaHM = -1;
        return this;
    }

    public zzaHM zzs(zzwq zzwq1)
        throws IOException
    {
        do
        {
            int i = zzwq1.zzvu();
            switch (i)
            {
            default:
                if (zza(zzwq1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                zzall = zzwq1.zzvy();
                break;

            case 18: // '\022'
                zzQN = zzwq1.readString();
                break;

            case 24: // '\030'
                zzalm = zzwq1.zzvw();
                break;

            case 33: // '!'
                zzaln = zzwq1.readDouble();
                break;

            case 42: // '*'
                if (zzalo == null)
                {
                    zzalo = new <init>();
                }
                zzwq1.zza(zzalo);
                break;
            }
        } while (true);
    }

    public ()
    {
        zzpl();
    }
}
