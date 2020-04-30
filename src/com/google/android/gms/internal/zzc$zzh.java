// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzc, zzwt, zzww, 
//            zzwr, zzwq, zzxb, zzwy

public static final class zzn extends zzws
{

    public static final zzwt zzgf = zzwt.zza(11, com/google/android/gms/internal/zzc$zzh, 810);
    private static final  zzgg[] = new [0];
    public int zzgh[];
    public int zzgi[];
    public int zzgj[];
    public int zzgk;
    public int zzgl[];
    public int zzgm;
    public int zzgn;

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
            if (obj instanceof zzn)
            {
                obj = (zzn)obj;
                flag = flag1;
                if (zzww.equals(zzgh, ((zzgh) (obj)).zzgh))
                {
                    flag = flag1;
                    if (zzww.equals(zzgi, ((zzgi) (obj)).zzgi))
                    {
                        flag = flag1;
                        if (zzww.equals(zzgj, ((zzgj) (obj)).zzgj))
                        {
                            flag = flag1;
                            if (zzgk == ((zzgk) (obj)).zzgk)
                            {
                                flag = flag1;
                                if (zzww.equals(zzgl, ((zzgl) (obj)).zzgl))
                                {
                                    flag = flag1;
                                    if (zzgm == ((zzgm) (obj)).zzgm)
                                    {
                                        flag = flag1;
                                        if (zzgn == ((zzgn) (obj)).zzgn)
                                        {
                                            return zza(((zzws) (obj)));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return (((((((zzww.hashCode(zzgh) + 527) * 31 + zzww.hashCode(zzgi)) * 31 + zzww.hashCode(zzgj)) * 31 + zzgk) * 31 + zzww.hashCode(zzgl)) * 31 + zzgm) * 31 + zzgn) * 31 + zzvL();
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        boolean flag = false;
        if (zzgh != null && zzgh.length > 0)
        {
            for (int i = 0; i < zzgh.length; i++)
            {
                zzwr1.zzy(1, zzgh[i]);
            }

        }
        if (zzgi != null && zzgi.length > 0)
        {
            for (int j = 0; j < zzgi.length; j++)
            {
                zzwr1.zzy(2, zzgi[j]);
            }

        }
        if (zzgj != null && zzgj.length > 0)
        {
            for (int k = 0; k < zzgj.length; k++)
            {
                zzwr1.zzy(3, zzgj[k]);
            }

        }
        if (zzgk != 0)
        {
            zzwr1.zzy(4, zzgk);
        }
        if (zzgl != null && zzgl.length > 0)
        {
            for (int l = ((flag) ? 1 : 0); l < zzgl.length; l++)
            {
                zzwr1.zzy(5, zzgl[l]);
            }

        }
        if (zzgm != 0)
        {
            zzwr1.zzy(6, zzgm);
        }
        if (zzgn != 0)
        {
            zzwr1.zzy(7, zzgn);
        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzi(zzwq1);
    }

    protected int zzc()
    {
        boolean flag = false;
        int l = super.zzc();
        int j;
        int k;
        if (zzgh != null && zzgh.length > 0)
        {
            int i = 0;
            k = 0;
            for (; i < zzgh.length; i++)
            {
                k += zzwr.zziw(zzgh[i]);
            }

            k = l + k + zzgh.length * 1;
        } else
        {
            k = l;
        }
        j = k;
        if (zzgi != null)
        {
            j = k;
            if (zzgi.length > 0)
            {
                j = 0;
                l = 0;
                for (; j < zzgi.length; j++)
                {
                    l += zzwr.zziw(zzgi[j]);
                }

                j = k + l + zzgi.length * 1;
            }
        }
        k = j;
        if (zzgj != null)
        {
            k = j;
            if (zzgj.length > 0)
            {
                k = 0;
                l = 0;
                for (; k < zzgj.length; k++)
                {
                    l += zzwr.zziw(zzgj[k]);
                }

                k = j + l + zzgj.length * 1;
            }
        }
        j = k;
        if (zzgk != 0)
        {
            j = k + zzwr.zzA(4, zzgk);
        }
        k = j;
        if (zzgl != null)
        {
            k = j;
            if (zzgl.length > 0)
            {
                l = 0;
                for (k = ((flag) ? 1 : 0); k < zzgl.length; k++)
                {
                    l += zzwr.zziw(zzgl[k]);
                }

                k = j + l + zzgl.length * 1;
            }
        }
        j = k;
        if (zzgm != 0)
        {
            j = k + zzwr.zzA(6, zzgm);
        }
        k = j;
        if (zzgn != 0)
        {
            k = j + zzwr.zzA(7, zzgn);
        }
        return k;
    }

    public zzgn zzi(zzwq zzwq1)
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
                int j2 = zzxb.zzc(zzwq1, 8);
                int ai[];
                int j;
                if (zzgh == null)
                {
                    j = 0;
                } else
                {
                    j = zzgh.length;
                }
                ai = new int[j2 + j];
                j2 = j;
                if (j != 0)
                {
                    System.arraycopy(zzgh, 0, ai, 0, j);
                    j2 = j;
                }
                for (; j2 < ai.length - 1; j2++)
                {
                    ai[j2] = zzwq1.zzvx();
                    zzwq1.zzvu();
                }

                ai[j2] = zzwq1.zzvx();
                zzgh = ai;
                break;

            case 10: // '\n'
                int j4 = zzwq1.zzip(zzwq1.zzvB());
                int k = zzwq1.getPosition();
                int k2;
                for (k2 = 0; zzwq1.zzvG() > 0; k2++)
                {
                    zzwq1.zzvx();
                }

                zzwq1.zzir(k);
                int ai1[];
                if (zzgh == null)
                {
                    k = 0;
                } else
                {
                    k = zzgh.length;
                }
                ai1 = new int[k2 + k];
                k2 = k;
                if (k != 0)
                {
                    System.arraycopy(zzgh, 0, ai1, 0, k);
                    k2 = k;
                }
                for (; k2 < ai1.length; k2++)
                {
                    ai1[k2] = zzwq1.zzvx();
                }

                zzgh = ai1;
                zzwq1.zziq(j4);
                break;

            case 16: // '\020'
                int l2 = zzxb.zzc(zzwq1, 16);
                int ai2[];
                int l;
                if (zzgi == null)
                {
                    l = 0;
                } else
                {
                    l = zzgi.length;
                }
                ai2 = new int[l2 + l];
                l2 = l;
                if (l != 0)
                {
                    System.arraycopy(zzgi, 0, ai2, 0, l);
                    l2 = l;
                }
                for (; l2 < ai2.length - 1; l2++)
                {
                    ai2[l2] = zzwq1.zzvx();
                    zzwq1.zzvu();
                }

                ai2[l2] = zzwq1.zzvx();
                zzgi = ai2;
                break;

            case 18: // '\022'
                int k4 = zzwq1.zzip(zzwq1.zzvB());
                int i1 = zzwq1.getPosition();
                int i3;
                for (i3 = 0; zzwq1.zzvG() > 0; i3++)
                {
                    zzwq1.zzvx();
                }

                zzwq1.zzir(i1);
                int ai3[];
                if (zzgi == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = zzgi.length;
                }
                ai3 = new int[i3 + i1];
                i3 = i1;
                if (i1 != 0)
                {
                    System.arraycopy(zzgi, 0, ai3, 0, i1);
                    i3 = i1;
                }
                for (; i3 < ai3.length; i3++)
                {
                    ai3[i3] = zzwq1.zzvx();
                }

                zzgi = ai3;
                zzwq1.zziq(k4);
                break;

            case 24: // '\030'
                int j3 = zzxb.zzc(zzwq1, 24);
                int ai4[];
                int j1;
                if (zzgj == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = zzgj.length;
                }
                ai4 = new int[j3 + j1];
                j3 = j1;
                if (j1 != 0)
                {
                    System.arraycopy(zzgj, 0, ai4, 0, j1);
                    j3 = j1;
                }
                for (; j3 < ai4.length - 1; j3++)
                {
                    ai4[j3] = zzwq1.zzvx();
                    zzwq1.zzvu();
                }

                ai4[j3] = zzwq1.zzvx();
                zzgj = ai4;
                break;

            case 26: // '\032'
                int l4 = zzwq1.zzip(zzwq1.zzvB());
                int k1 = zzwq1.getPosition();
                int k3;
                for (k3 = 0; zzwq1.zzvG() > 0; k3++)
                {
                    zzwq1.zzvx();
                }

                zzwq1.zzir(k1);
                int ai5[];
                if (zzgj == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = zzgj.length;
                }
                ai5 = new int[k3 + k1];
                k3 = k1;
                if (k1 != 0)
                {
                    System.arraycopy(zzgj, 0, ai5, 0, k1);
                    k3 = k1;
                }
                for (; k3 < ai5.length; k3++)
                {
                    ai5[k3] = zzwq1.zzvx();
                }

                zzgj = ai5;
                zzwq1.zziq(l4);
                break;

            case 32: // ' '
                zzgk = zzwq1.zzvx();
                break;

            case 40: // '('
                int l3 = zzxb.zzc(zzwq1, 40);
                int ai6[];
                int l1;
                if (zzgl == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = zzgl.length;
                }
                ai6 = new int[l3 + l1];
                l3 = l1;
                if (l1 != 0)
                {
                    System.arraycopy(zzgl, 0, ai6, 0, l1);
                    l3 = l1;
                }
                for (; l3 < ai6.length - 1; l3++)
                {
                    ai6[l3] = zzwq1.zzvx();
                    zzwq1.zzvu();
                }

                ai6[l3] = zzwq1.zzvx();
                zzgl = ai6;
                break;

            case 42: // '*'
                int i5 = zzwq1.zzip(zzwq1.zzvB());
                int i2 = zzwq1.getPosition();
                int i4;
                for (i4 = 0; zzwq1.zzvG() > 0; i4++)
                {
                    zzwq1.zzvx();
                }

                zzwq1.zzir(i2);
                int ai7[];
                if (zzgl == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = zzgl.length;
                }
                ai7 = new int[i4 + i2];
                i4 = i2;
                if (i2 != 0)
                {
                    System.arraycopy(zzgl, 0, ai7, 0, i2);
                    i4 = i2;
                }
                for (; i4 < ai7.length; i4++)
                {
                    ai7[i4] = zzwq1.zzvx();
                }

                zzgl = ai7;
                zzwq1.zziq(i5);
                break;

            case 48: // '0'
                zzgm = zzwq1.zzvx();
                break;

            case 56: // '8'
                zzgn = zzwq1.zzvx();
                break;
            }
        } while (true);
    }

    public x zzn()
    {
        zzgh = zzxb.zzaHO;
        zzgi = zzxb.zzaHO;
        zzgj = zzxb.zzaHO;
        zzgk = 0;
        zzgl = zzxb.zzaHO;
        zzgm = 0;
        zzgn = 0;
        zzaHB = null;
        zzaHM = -1;
        return this;
    }


    public ()
    {
        zzn();
    }
}
