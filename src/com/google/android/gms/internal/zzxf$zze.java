// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzxf, zzww, zzwq, 
//            zzwr, zzwy

public static final class zzwt extends zzws
{

    private static volatile zzaHM zzaJk[];
    public String value;
    public String zzfv;

    public static zzwt[] zzws()
    {
        if (zzaJk == null)
        {
            synchronized (zzww.zzaHL)
            {
                if (zzaJk == null)
                {
                    zzaJk = new zzaJk[0];
                }
            }
        }
        return zzaJk;
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
        if (!(obj instanceof zzaJk)) goto _L4; else goto _L3
_L3:
        obj = (zzaJk)obj;
        if (zzfv != null) goto _L6; else goto _L5
_L5:
        flag = flag1;
        if (((zzfv) (obj)).zzfv != null) goto _L4; else goto _L7
_L7:
        if (value != null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        flag = flag1;
        if (((value) (obj)).value != null) goto _L4; else goto _L8
_L8:
        return zza(((zzws) (obj)));
_L6:
        if (!zzfv.equals(((zzfv) (obj)).zzfv))
        {
            return false;
        }
          goto _L7
        if (!value.equals(((value) (obj)).value))
        {
            return false;
        }
          goto _L8
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (zzfv == null)
        {
            i = 0;
        } else
        {
            i = zzfv.hashCode();
        }
        if (value != null)
        {
            j = value.hashCode();
        }
        return ((i + 527) * 31 + j) * 31 + zzvL();
    }

    public zzvL zzO(zzwq zzwq1)
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
                zzfv = zzwq1.readString();
                break;

            case 18: // '\022'
                value = zzwq1.readString();
                break;
            }
        } while (true);
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        if (!zzfv.equals(""))
        {
            zzwr1.zzb(1, zzfv);
        }
        if (!value.equals(""))
        {
            zzwr1.zzb(2, value);
        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzO(zzwq1);
    }

    protected int zzc()
    {
        int j = super.zzc();
        int i = j;
        if (!zzfv.equals(""))
        {
            i = j + zzwr.zzj(1, zzfv);
        }
        j = i;
        if (!value.equals(""))
        {
            j = i + zzwr.zzj(2, value);
        }
        return j;
    }

    public value zzwt()
    {
        zzfv = "";
        value = "";
        zzaHB = null;
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzwt();
    }
}
