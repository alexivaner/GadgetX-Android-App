// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwy, zzxd, zzww, zzwq, 
//            zzxb, zzwr

public static final class zzwm extends zzwy
{

    private static volatile zzaHM zzaIJ[];
    public int zzaID;
    public zzaHM zzaIE;
    public zzaHM zzaIK[];
    public boolean zzaIx;

    public static zzwm[] zzwl()
    {
        if (zzaIJ == null)
        {
            synchronized (zzww.zzaHL)
            {
                if (zzaIJ == null)
                {
                    zzaIJ = new zzaIJ[0];
                }
            }
        }
        return zzaIJ;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzaIJ))
            {
                return false;
            }
            obj = (zzaIJ)obj;
            if (zzaID != ((zzaID) (obj)).zzaID)
            {
                return false;
            }
            if (zzaIE == null)
            {
                if (((zzaIE) (obj)).zzaIE != null)
                {
                    return false;
                }
            } else
            if (!zzaIE.equals(((equals) (obj)).zzaIE))
            {
                return false;
            }
            if (!zzww.equals(zzaIK, ((zzaIK) (obj)).zzaIK))
            {
                return false;
            }
            if (zzaIx != ((zzaIx) (obj)).zzaIx)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = zzaID;
        int i;
        char c;
        int k;
        if (zzaIE == null)
        {
            i = 0;
        } else
        {
            i = zzaIE.hashCode();
        }
        k = zzww.hashCode(zzaIK);
        if (zzaIx)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        return c + ((i + (j + 527) * 31) * 31 + k) * 31;
    }

    public zzaIx zzI(zzwq zzwq1)
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
                zzaID = zzwq1.zzvx();
                break;

            case 18: // '\022'
                if (zzaIE == null)
                {
                    zzaIE = new <init>();
                }
                zzwq1.zza(zzaIE);
                break;

            case 26: // '\032'
                int k = zzxb.zzc(zzwq1, 26);
                zzaIx azzaix[];
                int j;
                if (zzaIK == null)
                {
                    j = 0;
                } else
                {
                    j = zzaIK.length;
                }
                azzaix = new zzaIK[k + j];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zzaIK, 0, azzaix, 0, j);
                    k = j;
                }
                for (; k < azzaix.length - 1; k++)
                {
                    azzaix[k] = new <init>();
                    zzwq1.zza(azzaix[k]);
                    zzwq1.zzvu();
                }

                azzaix[k] = new <init>();
                zzwq1.zza(azzaix[k]);
                zzaIK = azzaix;
                break;

            case 32: // ' '
                zzaIx = zzwq1.zzvy();
                break;
            }
        } while (true);
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        if (zzaID != 0)
        {
            zzwr1.zzy(1, zzaID);
        }
        if (zzaIE != null)
        {
            zzwr1.zza(2, zzaIE);
        }
        if (zzaIK != null && zzaIK.length > 0)
        {
            for (int i = 0; i < zzaIK.length; i++)
            {
                  = zzaIK[i];
                if ( != null)
                {
                    zzwr1.zza(3, );
                }
            }

        }
        if (zzaIx)
        {
            zzwr1.zzb(4, zzaIx);
        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzI(zzwq1);
    }

    protected int zzc()
    {
        int i = super.zzc();
        int j = i;
        if (zzaID != 0)
        {
            j = i + zzwr.zzA(1, zzaID);
        }
        i = j;
        if (zzaIE != null)
        {
            i = j + zzwr.zzc(2, zzaIE);
        }
        j = i;
        if (zzaIK != null)
        {
            j = i;
            if (zzaIK.length > 0)
            {
                for (j = 0; j < zzaIK.length;)
                {
                    zzI zzi = zzaIK[j];
                    int k = i;
                    if (zzi != null)
                    {
                        k = i + zzwr.zzc(3, zzi);
                    }
                    j++;
                    i = k;
                }

                j = i;
            }
        }
        i = j;
        if (zzaIx)
        {
            i = j + zzwr.zzc(4, zzaIx);
        }
        return i;
    }

    public zzaIx zzwm()
    {
        zzaID = 0;
        zzaIE = null;
        zzaIK = zzwj();
        zzaIx = false;
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzwm();
    }
}
