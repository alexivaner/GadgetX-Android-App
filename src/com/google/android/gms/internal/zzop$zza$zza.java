// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzop, zzww, zzwr, 
//            zzwq, zzwy

public static final class zzph extends zzws
{

    private static volatile zzaHM zzalf[];
    public int viewId;
    public String zzalg;
    public String zzalh;

    public static zzph[] zzpg()
    {
        if (zzalf == null)
        {
            synchronized (zzww.zzaHL)
            {
                if (zzalf == null)
                {
                    zzalf = new zzalf[0];
                }
            }
        }
        return zzalf;
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
        if (!(obj instanceof zzalf)) goto _L4; else goto _L3
_L3:
        obj = (zzalf)obj;
        if (zzalg != null) goto _L6; else goto _L5
_L5:
        flag = flag1;
        if (((zzalg) (obj)).zzalg != null) goto _L4; else goto _L7
_L7:
        if (zzalh != null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        flag = flag1;
        if (((zzalh) (obj)).zzalh != null) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (viewId == ((viewId) (obj)).viewId)
        {
            return zza(((zzws) (obj)));
        }
          goto _L4
_L6:
        if (!zzalg.equals(((zzalg) (obj)).zzalg))
        {
            return false;
        }
          goto _L7
        if (!zzalh.equals(((zzalh) (obj)).zzalh))
        {
            return false;
        }
          goto _L8
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (zzalg == null)
        {
            i = 0;
        } else
        {
            i = zzalg.hashCode();
        }
        if (zzalh != null)
        {
            j = zzalh.hashCode();
        }
        return (((i + 527) * 31 + j) * 31 + viewId) * 31 + zzvL();
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        if (!zzalg.equals(""))
        {
            zzwr1.zzb(1, zzalg);
        }
        if (!zzalh.equals(""))
        {
            zzwr1.zzb(2, zzalh);
        }
        if (viewId != 0)
        {
            zzwr1.zzy(3, viewId);
        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzp(zzwq1);
    }

    protected int zzc()
    {
        int j = super.zzc();
        int i = j;
        if (!zzalg.equals(""))
        {
            i = j + zzwr.zzj(1, zzalg);
        }
        j = i;
        if (!zzalh.equals(""))
        {
            j = i + zzwr.zzj(2, zzalh);
        }
        i = j;
        if (viewId != 0)
        {
            i = j + zzwr.zzA(3, viewId);
        }
        return i;
    }

    public viewId zzp(zzwq zzwq1)
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
                zzalg = zzwq1.readString();
                break;

            case 18: // '\022'
                zzalh = zzwq1.readString();
                break;

            case 24: // '\030'
                viewId = zzwq1.zzvx();
                break;
            }
        } while (true);
    }

    public viewId zzph()
    {
        zzalg = "";
        zzalh = "";
        viewId = 0;
        zzaHB = null;
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzph();
    }
}
