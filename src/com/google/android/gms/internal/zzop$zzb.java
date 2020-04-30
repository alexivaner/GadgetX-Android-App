// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzop, zzww, zzwr, 
//            zzwq, zzwy

public static final class zzpj extends zzws
{

    private static volatile zzalj zzali[];
    public String name;
    public zzalj zzalj;

    public static zzpj[] zzpi()
    {
        if (zzali == null)
        {
            synchronized (zzww.zzaHL)
            {
                if (zzali == null)
                {
                    zzali = new zzali[0];
                }
            }
        }
        return zzali;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

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
        if (!(obj instanceof zzali)) goto _L4; else goto _L3
_L3:
        obj = (zzali)obj;
        if (name != null) goto _L6; else goto _L5
_L5:
        flag = flag1;
        if (((name) (obj)).name != null) goto _L4; else goto _L7
_L7:
        if (zzalj != null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        flag = flag1;
        if (((zzalj) (obj)).zzalj != null) goto _L4; else goto _L8
_L8:
        return zza(((zzws) (obj)));
_L6:
        if (!name.equals(((name) (obj)).name))
        {
            return false;
        }
          goto _L7
        if (!zzalj.equals(((equals) (obj)).zzalj))
        {
            return false;
        }
          goto _L8
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (name == null)
        {
            i = 0;
        } else
        {
            i = name.hashCode();
        }
        if (zzalj != null)
        {
            j = zzalj.hashCode();
        }
        return ((i + 527) * 31 + j) * 31 + zzvL();
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        if (!name.equals(""))
        {
            zzwr1.zzb(1, name);
        }
        if (zzalj != null)
        {
            zzwr1.zza(2, zzalj);
        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzq(zzwq1);
    }

    protected int zzc()
    {
        int j = super.zzc();
        int i = j;
        if (!name.equals(""))
        {
            i = j + zzwr.zzj(1, name);
        }
        j = i;
        if (zzalj != null)
        {
            j = i + zzwr.zzc(2, zzalj);
        }
        return j;
    }

    public zzalj zzpj()
    {
        name = "";
        zzalj = null;
        zzaHB = null;
        zzaHM = -1;
        return this;
    }

    public zzaHM zzq(zzwq zzwq1)
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

            case 10: // '\n'
                name = zzwq1.readString();
                break;

            case 18: // '\022'
                if (zzalj == null)
                {
                    zzalj = new <init>();
                }
                zzwq1.zza(zzalj);
                break;
            }
        } while (true);
    }

    public ()
    {
        zzpj();
    }
}
