// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzwx, zzwy, zzww, 
//            zzwr, zzxb, zzwq

public final class zzwo extends zzws
{

    public String zzaHl[];
    public int zzaHm[];
    public byte zzaHn[][];

    public zzwo()
    {
        zzvt();
    }

    public static zzwo zzr(byte abyte0[])
        throws zzwx
    {
        return (zzwo)zzwy.zza(new zzwo(), abyte0);
    }

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
                if (zzww.equals(zzaHl, ((zzwo) (obj)).zzaHl))
                {
                    flag = flag1;
                    if (zzww.equals(zzaHm, ((zzwo) (obj)).zzaHm))
                    {
                        flag = flag1;
                        if (zzww.zza(zzaHn, ((zzwo) (obj)).zzaHn))
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
        return (((zzww.hashCode(zzaHl) + 527) * 31 + zzww.hashCode(zzaHm)) * 31 + zzww.zza(zzaHn)) * 31 + zzvL();
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        boolean flag = false;
        if (zzaHl != null && zzaHl.length > 0)
        {
            for (int i = 0; i < zzaHl.length; i++)
            {
                String s = zzaHl[i];
                if (s != null)
                {
                    zzwr1.zzb(1, s);
                }
            }

        }
        if (zzaHm != null && zzaHm.length > 0)
        {
            for (int j = 0; j < zzaHm.length; j++)
            {
                zzwr1.zzy(2, zzaHm[j]);
            }

        }
        if (zzaHn != null && zzaHn.length > 0)
        {
            for (int k = ((flag) ? 1 : 0); k < zzaHn.length; k++)
            {
                byte abyte0[] = zzaHn[k];
                if (abyte0 != null)
                {
                    zzwr1.zza(3, abyte0);
                }
            }

        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzy(zzwq1);
    }

    protected int zzc()
    {
        boolean flag = false;
        int l2 = super.zzc();
        int j;
        int k;
        if (zzaHl != null && zzaHl.length > 0)
        {
            int i = 0;
            k = 0;
            int l;
            int k1;
            for (l = 0; i < zzaHl.length; l = k1)
            {
                String s = zzaHl[i];
                int i2 = k;
                k1 = l;
                if (s != null)
                {
                    k1 = l + 1;
                    i2 = k + zzwr.zzdM(s);
                }
                i++;
                k = i2;
            }

            k = l2 + k + l * 1;
        } else
        {
            k = l2;
        }
        j = k;
        if (zzaHm != null)
        {
            j = k;
            if (zzaHm.length > 0)
            {
                j = 0;
                int i1 = 0;
                for (; j < zzaHm.length; j++)
                {
                    i1 += zzwr.zziw(zzaHm[j]);
                }

                j = k + i1 + zzaHm.length * 1;
            }
        }
        k = j;
        if (zzaHn != null)
        {
            k = j;
            if (zzaHn.length > 0)
            {
                int j1 = 0;
                int l1 = 0;
                for (k = ((flag) ? 1 : 0); k < zzaHn.length;)
                {
                    byte abyte0[] = zzaHn[k];
                    int k2 = j1;
                    int j2 = l1;
                    if (abyte0 != null)
                    {
                        j2 = l1 + 1;
                        k2 = j1 + zzwr.zzw(abyte0);
                    }
                    k++;
                    j1 = k2;
                    l1 = j2;
                }

                k = j + j1 + l1 * 1;
            }
        }
        return k;
    }

    public zzwo zzvt()
    {
        zzaHl = zzxb.zzaHT;
        zzaHm = zzxb.zzaHO;
        zzaHn = zzxb.zzaHU;
        zzaHB = null;
        zzaHM = -1;
        return this;
    }

    public zzwo zzy(zzwq zzwq1)
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
                if (zzaHl == null)
                {
                    j = 0;
                } else
                {
                    j = zzaHl.length;
                }
                as = new String[j1 + j];
                j1 = j;
                if (j != 0)
                {
                    System.arraycopy(zzaHl, 0, as, 0, j);
                    j1 = j;
                }
                for (; j1 < as.length - 1; j1++)
                {
                    as[j1] = zzwq1.readString();
                    zzwq1.zzvu();
                }

                as[j1] = zzwq1.readString();
                zzaHl = as;
                break;

            case 16: // '\020'
                int k1 = zzxb.zzc(zzwq1, 16);
                int ai[];
                int k;
                if (zzaHm == null)
                {
                    k = 0;
                } else
                {
                    k = zzaHm.length;
                }
                ai = new int[k1 + k];
                k1 = k;
                if (k != 0)
                {
                    System.arraycopy(zzaHm, 0, ai, 0, k);
                    k1 = k;
                }
                for (; k1 < ai.length - 1; k1++)
                {
                    ai[k1] = zzwq1.zzvx();
                    zzwq1.zzvu();
                }

                ai[k1] = zzwq1.zzvx();
                zzaHm = ai;
                break;

            case 18: // '\022'
                int j2 = zzwq1.zzip(zzwq1.zzvB());
                int l = zzwq1.getPosition();
                int l1;
                for (l1 = 0; zzwq1.zzvG() > 0; l1++)
                {
                    zzwq1.zzvx();
                }

                zzwq1.zzir(l);
                int ai1[];
                if (zzaHm == null)
                {
                    l = 0;
                } else
                {
                    l = zzaHm.length;
                }
                ai1 = new int[l1 + l];
                l1 = l;
                if (l != 0)
                {
                    System.arraycopy(zzaHm, 0, ai1, 0, l);
                    l1 = l;
                }
                for (; l1 < ai1.length; l1++)
                {
                    ai1[l1] = zzwq1.zzvx();
                }

                zzaHm = ai1;
                zzwq1.zziq(j2);
                break;

            case 26: // '\032'
                int i2 = zzxb.zzc(zzwq1, 26);
                byte abyte0[][];
                int i1;
                if (zzaHn == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = zzaHn.length;
                }
                abyte0 = new byte[i2 + i1][];
                i2 = i1;
                if (i1 != 0)
                {
                    System.arraycopy(zzaHn, 0, abyte0, 0, i1);
                    i2 = i1;
                }
                for (; i2 < abyte0.length - 1; i2++)
                {
                    abyte0[i2] = zzwq1.readBytes();
                    zzwq1.zzvu();
                }

                abyte0[i2] = zzwq1.readBytes();
                zzaHn = abyte0;
                break;
            }
        } while (true);
    }
}
