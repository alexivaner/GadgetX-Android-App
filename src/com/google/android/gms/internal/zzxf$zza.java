// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzxf, zzww, zzwq, 
//            zzxb, zzwr, zzwy

public static final class zzwo extends zzws
{

    public String zzaIP[];
    public String zzaIQ[];
    public int zzaIR[];

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj instanceof zzwo)
            {
                obj = (zzwo)obj;
                flag = flag1;
                if (zzww.equals(zzaIP, ((zzaIP) (obj)).zzaIP))
                {
                    flag = flag1;
                    if (zzww.equals(zzaIQ, ((zzaIQ) (obj)).zzaIQ))
                    {
                        flag = flag1;
                        if (zzww.equals(zzaIR, ((zzaIR) (obj)).zzaIR))
                        {
                            return zza(((zzws) (obj)));
                        }
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return (((zzww.hashCode(zzaIP) + 527) * 31 + zzww.hashCode(zzaIQ)) * 31 + zzww.hashCode(zzaIR)) * 31 + zzvL();
    }

    public zzvL zzK(zzwq zzwq1)
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
                int j1 = zzxb.zzc(zzwq1, 10);
                String as[];
                int j;
                if (zzaIP == null)
                {
                    j = 0;
                } else
                {
                    j = zzaIP.length;
                }
                as = new String[j1 + j];
                j1 = j;
                if (j != 0)
                {
                    System.arraycopy(zzaIP, 0, as, 0, j);
                    j1 = j;
                }
                for (; j1 < as.length - 1; j1++)
                {
                    as[j1] = zzwq1.readString();
                    zzwq1.zzvu();
                }

                as[j1] = zzwq1.readString();
                zzaIP = as;
                break;

            case 18: // '\022'
                int k1 = zzxb.zzc(zzwq1, 18);
                String as1[];
                int k;
                if (zzaIQ == null)
                {
                    k = 0;
                } else
                {
                    k = zzaIQ.length;
                }
                as1 = new String[k1 + k];
                k1 = k;
                if (k != 0)
                {
                    System.arraycopy(zzaIQ, 0, as1, 0, k);
                    k1 = k;
                }
                for (; k1 < as1.length - 1; k1++)
                {
                    as1[k1] = zzwq1.readString();
                    zzwq1.zzvu();
                }

                as1[k1] = zzwq1.readString();
                zzaIQ = as1;
                break;

            case 24: // '\030'
                int l1 = zzxb.zzc(zzwq1, 24);
                int ai[];
                int l;
                if (zzaIR == null)
                {
                    l = 0;
                } else
                {
                    l = zzaIR.length;
                }
                ai = new int[l1 + l];
                l1 = l;
                if (l != 0)
                {
                    System.arraycopy(zzaIR, 0, ai, 0, l);
                    l1 = l;
                }
                for (; l1 < ai.length - 1; l1++)
                {
                    ai[l1] = zzwq1.zzvx();
                    zzwq1.zzvu();
                }

                ai[l1] = zzwq1.zzvx();
                zzaIR = ai;
                break;

            case 26: // '\032'
                int j2 = zzwq1.zzip(zzwq1.zzvB());
                int i1 = zzwq1.getPosition();
                int i2;
                for (i2 = 0; zzwq1.zzvG() > 0; i2++)
                {
                    zzwq1.zzvx();
                }

                zzwq1.zzir(i1);
                int ai1[];
                if (zzaIR == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = zzaIR.length;
                }
                ai1 = new int[i2 + i1];
                i2 = i1;
                if (i1 != 0)
                {
                    System.arraycopy(zzaIR, 0, ai1, 0, i1);
                    i2 = i1;
                }
                for (; i2 < ai1.length; i2++)
                {
                    ai1[i2] = zzwq1.zzvx();
                }

                zzaIR = ai1;
                zzwq1.zziq(j2);
                break;
            }
        } while (true);
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        boolean flag = false;
        if (zzaIP != null && zzaIP.length > 0)
        {
            for (int i = 0; i < zzaIP.length; i++)
            {
                String s = zzaIP[i];
                if (s != null)
                {
                    zzwr1.zzb(1, s);
                }
            }

        }
        if (zzaIQ != null && zzaIQ.length > 0)
        {
            for (int j = 0; j < zzaIQ.length; j++)
            {
                String s1 = zzaIQ[j];
                if (s1 != null)
                {
                    zzwr1.zzb(2, s1);
                }
            }

        }
        if (zzaIR != null && zzaIR.length > 0)
        {
            for (int k = ((flag) ? 1 : 0); k < zzaIR.length; k++)
            {
                zzwr1.zzy(3, zzaIR[k]);
            }

        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzK(zzwq1);
    }

    protected int zzc()
    {
        boolean flag = false;
        int k2 = super.zzc();
        int i;
        int k;
        if (zzaIP != null && zzaIP.length > 0)
        {
            i = 0;
            int j = 0;
            int l;
            int k1;
            for (l = 0; i < zzaIP.length; l = k1)
            {
                String s = zzaIP[i];
                int i2 = j;
                k1 = l;
                if (s != null)
                {
                    k1 = l + 1;
                    i2 = j + zzwr.zzdM(s);
                }
                i++;
                j = i2;
            }

            i = k2 + j + l * 1;
        } else
        {
            i = k2;
        }
        k = i;
        if (zzaIQ != null)
        {
            k = i;
            if (zzaIQ.length > 0)
            {
                k = 0;
                int i1 = 0;
                int l1;
                int j2;
                for (l1 = 0; k < zzaIQ.length; l1 = j2)
                {
                    String s1 = zzaIQ[k];
                    k2 = i1;
                    j2 = l1;
                    if (s1 != null)
                    {
                        j2 = l1 + 1;
                        k2 = i1 + zzwr.zzdM(s1);
                    }
                    k++;
                    i1 = k2;
                }

                k = i + i1 + l1 * 1;
            }
        }
        i = k;
        if (zzaIR != null)
        {
            i = k;
            if (zzaIR.length > 0)
            {
                int j1 = 0;
                for (i = ((flag) ? 1 : 0); i < zzaIR.length; i++)
                {
                    j1 += zzwr.zziw(zzaIR[i]);
                }

                i = k + j1 + zzaIR.length * 1;
            }
        }
        return i;
    }

    public zzaIR zzwo()
    {
        zzaIP = zzxb.zzaHT;
        zzaIQ = zzxb.zzaHT;
        zzaIR = zzxb.zzaHO;
        zzaHB = null;
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzwo();
    }
}
