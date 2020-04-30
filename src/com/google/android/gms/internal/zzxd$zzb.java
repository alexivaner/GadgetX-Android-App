// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwy, zzxd, zzww, zzwq, 
//            zzxb, zzwr

public static final class zzwk extends zzwy
{

    private static volatile zzaHM zzaIz[];
    public long zzaIA;
    public long zzaIB;
    public zzaHM zzaIC[];
    public int zzaID;
    public zzaHM zzaIE;
    public int zzaIF;
    public zzaHM zzaIG;
    public long zzaIH;
    public long zzaII;

    public static zzwk[] zzwj()
    {
        if (zzaIz == null)
        {
            synchronized (zzww.zzaHL)
            {
                if (zzaIz == null)
                {
                    zzaIz = new zzaIz[0];
                }
            }
        }
        return zzaIz;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzaIz))
            {
                return false;
            }
            obj = (zzaIz)obj;
            if (zzaIA != ((zzaIA) (obj)).zzaIA)
            {
                return false;
            }
            if (zzaIB != ((zzaIB) (obj)).zzaIB)
            {
                return false;
            }
            if (!zzww.equals(zzaIC, ((zzaIC) (obj)).zzaIC))
            {
                return false;
            }
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
            if (zzaIF != ((zzaIF) (obj)).zzaIF)
            {
                return false;
            }
            if (zzaIG == null)
            {
                if (((zzaIG) (obj)).zzaIG != null)
                {
                    return false;
                }
            } else
            if (!zzaIG.equals(((equals) (obj)).zzaIG))
            {
                return false;
            }
            if (zzaIH != ((zzaIH) (obj)).zzaIH)
            {
                return false;
            }
            if (zzaII != ((zzaII) (obj)).zzaII)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = 0;
        int k = (int)(zzaIA ^ zzaIA >>> 32);
        int l = (int)(zzaIB ^ zzaIB >>> 32);
        int i1 = zzww.hashCode(zzaIC);
        int j1 = zzaID;
        int i;
        int k1;
        if (zzaIE == null)
        {
            i = 0;
        } else
        {
            i = zzaIE.hashCode();
        }
        k1 = zzaIF;
        if (zzaIG != null)
        {
            j = zzaIG.hashCode();
        }
        return ((((i + ((((k + 527) * 31 + l) * 31 + i1) * 31 + j1) * 31) * 31 + k1) * 31 + j) * 31 + (int)(zzaIH ^ zzaIH >>> 32)) * 31 + (int)(zzaII ^ zzaII >>> 32);
    }

    public zzaII zzH(zzwq zzwq1)
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
                zzaIA = zzwq1.zzvw();
                break;

            case 16: // '\020'
                zzaIB = zzwq1.zzvw();
                break;

            case 26: // '\032'
                int k = zzxb.zzc(zzwq1, 26);
                zzaII azzaii[];
                int j;
                if (zzaIC == null)
                {
                    j = 0;
                } else
                {
                    j = zzaIC.length;
                }
                azzaii = new zzaIC[k + j];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zzaIC, 0, azzaii, 0, j);
                    k = j;
                }
                for (; k < azzaii.length - 1; k++)
                {
                    azzaii[k] = new <init>();
                    zzwq1.zza(azzaii[k]);
                    zzwq1.zzvu();
                }

                azzaii[k] = new <init>();
                zzwq1.zza(azzaii[k]);
                zzaIC = azzaii;
                break;

            case 32: // ' '
                zzaID = zzwq1.zzvx();
                break;

            case 42: // '*'
                if (zzaIE == null)
                {
                    zzaIE = new <init>();
                }
                zzwq1.zza(zzaIE);
                break;

            case 48: // '0'
                zzaIF = zzwq1.zzvx();
                break;

            case 58: // ':'
                if (zzaIG == null)
                {
                    zzaIG = new <init>();
                }
                zzwq1.zza(zzaIG);
                break;

            case 64: // '@'
                zzaIH = zzwq1.zzvw();
                break;

            case 72: // 'H'
                zzaII = zzwq1.zzvw();
                break;
            }
        } while (true);
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        if (zzaIA != 0L)
        {
            zzwr1.zzb(1, zzaIA);
        }
        if (zzaIB != 0L)
        {
            zzwr1.zzb(2, zzaIB);
        }
        if (zzaIC != null && zzaIC.length > 0)
        {
            for (int i = 0; i < zzaIC.length; i++)
            {
                  = zzaIC[i];
                if ( != null)
                {
                    zzwr1.zza(3, );
                }
            }

        }
        if (zzaID != 0)
        {
            zzwr1.zzy(4, zzaID);
        }
        if (zzaIE != null)
        {
            zzwr1.zza(5, zzaIE);
        }
        if (zzaIF != 0)
        {
            zzwr1.zzy(6, zzaIF);
        }
        if (zzaIG != null)
        {
            zzwr1.zza(7, zzaIG);
        }
        if (zzaIH != 0L)
        {
            zzwr1.zzb(8, zzaIH);
        }
        if (zzaII != 0L)
        {
            zzwr1.zzb(9, zzaII);
        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzH(zzwq1);
    }

    protected int zzc()
    {
        int i = super.zzc();
        int j = i;
        if (zzaIA != 0L)
        {
            j = i + zzwr.zzd(1, zzaIA);
        }
        i = j;
        if (zzaIB != 0L)
        {
            i = j + zzwr.zzd(2, zzaIB);
        }
        j = i;
        if (zzaIC != null)
        {
            j = i;
            if (zzaIC.length > 0)
            {
                for (j = 0; j < zzaIC.length;)
                {
                    zzH zzh = zzaIC[j];
                    int k = i;
                    if (zzh != null)
                    {
                        k = i + zzwr.zzc(3, zzh);
                    }
                    j++;
                    i = k;
                }

                j = i;
            }
        }
        i = j;
        if (zzaID != 0)
        {
            i = j + zzwr.zzA(4, zzaID);
        }
        j = i;
        if (zzaIE != null)
        {
            j = i + zzwr.zzc(5, zzaIE);
        }
        i = j;
        if (zzaIF != 0)
        {
            i = j + zzwr.zzA(6, zzaIF);
        }
        j = i;
        if (zzaIG != null)
        {
            j = i + zzwr.zzc(7, zzaIG);
        }
        i = j;
        if (zzaIH != 0L)
        {
            i = j + zzwr.zzd(8, zzaIH);
        }
        j = i;
        if (zzaII != 0L)
        {
            j = i + zzwr.zzd(9, zzaII);
        }
        return j;
    }

    public zzaII zzwk()
    {
        zzaIA = 0L;
        zzaIB = 0L;
        zzaIC = zzwg();
        zzaID = 0;
        zzaIE = null;
        zzaIF = 0;
        zzaIG = null;
        zzaIH = 0L;
        zzaII = 0L;
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzwk();
    }
}
