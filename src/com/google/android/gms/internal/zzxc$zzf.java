// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwy, zzxc, zzww, zzwq, 
//            zzxb, zzwr

public static final class zzwh extends zzwy
{

    private static volatile zzaHM zzaIn[];
    public Integer zzaIo;
    public Double zzaIp;

    public static zzwh[] zzwg()
    {
        if (zzaIn == null)
        {
            synchronized (zzww.zzaHL)
            {
                if (zzaIn == null)
                {
                    zzaIn = new zzaIn[0];
                }
            }
        }
        return zzaIn;
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
        if (!(obj instanceof zzaIn))
        {
            return false;
        }
        obj = (zzaIn)obj;
        if (zzaIo == null)
        {
            if (((zzaIo) (obj)).zzaIo != null)
            {
                return false;
            }
        } else
        if (!zzaIo.equals(((zzaIo) (obj)).zzaIo))
        {
            return false;
        }
        if (zzaIp != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((zzaIp) (obj)).zzaIp == null) goto _L1; else goto _L3
_L3:
        return false;
        if (zzaIp.equals(((zzaIp) (obj)).zzaIp)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (zzaIo == null)
        {
            i = 0;
        } else
        {
            i = zzaIo.hashCode();
        }
        if (zzaIp != null)
        {
            j = zzaIp.hashCode();
        }
        return (i + 527) * 31 + j;
    }

    public zzaIp zzF(zzwq zzwq1)
        throws IOException
    {
        do
        {
            int i = zzwq1.zzvu();
            switch (i)
            {
            default:
                if (zzxb.zzb(zzwq1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                zzaIo = Integer.valueOf(zzwq1.zzvx());
                break;

            case 17: // '\021'
                zzaIp = Double.valueOf(zzwq1.readDouble());
                break;
            }
        } while (true);
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        if (zzaIo != null)
        {
            zzwr1.zzy(1, zzaIo.intValue());
        }
        if (zzaIp != null)
        {
            zzwr1.zza(2, zzaIp.doubleValue());
        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzF(zzwq1);
    }

    protected int zzc()
    {
        int j = super.zzc();
        int i = j;
        if (zzaIo != null)
        {
            i = j + zzwr.zzA(1, zzaIo.intValue());
        }
        j = i;
        if (zzaIp != null)
        {
            j = i + zzwr.zzb(2, zzaIp.doubleValue());
        }
        return j;
    }

    public zzaIp zzwh()
    {
        zzaIo = null;
        zzaIp = null;
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzwh();
    }
}
