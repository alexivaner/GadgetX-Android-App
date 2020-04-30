// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzwn, zzww, zzxb, 
//            zzwr, zzwq, zzwy

public static final class zzvs extends zzws
{

    public byte zzaGX[];
    public String zzaGY;
    public double zzaGZ;
    public float zzaHa;
    public long zzaHb;
    public int zzaHc;
    public int zzaHd;
    public boolean zzaHe;
    public zzaHj zzaHf[];
    public zzaHj zzaHg[];
    public String zzaHh[];
    public long zzaHi[];
    public float zzaHj[];
    public long zzaHk;

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
        if (!(obj instanceof zzvs))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (zzvs)obj;
        flag = flag1;
        if (!Arrays.equals(zzaGX, ((zzaGX) (obj)).zzaGX))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (zzaGY != null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((zzaGY) (obj)).zzaGY != null)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        flag = flag1;
        if (Double.doubleToLongBits(zzaGZ) == Double.doubleToLongBits(((zzaGZ) (obj)).zzaGZ))
        {
            flag = flag1;
            if (Float.floatToIntBits(zzaHa) == Float.floatToIntBits(((zzaHa) (obj)).zzaHa))
            {
                flag = flag1;
                if (zzaHb == ((zzaHb) (obj)).zzaHb)
                {
                    flag = flag1;
                    if (zzaHc == ((zzaHc) (obj)).zzaHc)
                    {
                        flag = flag1;
                        if (zzaHd == ((zzaHd) (obj)).zzaHd)
                        {
                            flag = flag1;
                            if (zzaHe == ((zzaHe) (obj)).zzaHe)
                            {
                                flag = flag1;
                                if (zzww.equals(zzaHf, ((zzaHf) (obj)).zzaHf))
                                {
                                    flag = flag1;
                                    if (zzww.equals(zzaHg, ((zzaHg) (obj)).zzaHg))
                                    {
                                        flag = flag1;
                                        if (zzww.equals(zzaHh, ((zzaHh) (obj)).zzaHh))
                                        {
                                            flag = flag1;
                                            if (zzww.equals(zzaHi, ((zzaHi) (obj)).zzaHi))
                                            {
                                                flag = flag1;
                                                if (zzww.equals(zzaHj, ((zzaHj) (obj)).zzaHj))
                                                {
                                                    flag = flag1;
                                                    if (zzaHk == ((zzaHk) (obj)).zzaHk)
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
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!zzaGY.equals(((zzaGY) (obj)).zzaGY))
        {
            return false;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public int hashCode()
    {
        int j = Arrays.hashCode(zzaGX);
        int i;
        char c;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        long l1;
        if (zzaGY == null)
        {
            i = 0;
        } else
        {
            i = zzaGY.hashCode();
        }
        l1 = Double.doubleToLongBits(zzaGZ);
        k = (int)(l1 ^ l1 >>> 32);
        l = Float.floatToIntBits(zzaHa);
        i1 = (int)(zzaHb ^ zzaHb >>> 32);
        j1 = zzaHc;
        k1 = zzaHd;
        if (zzaHe)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        return (((((((c + ((((((i + (j + 527) * 31) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31) * 31 + zzww.hashCode(zzaHf)) * 31 + zzww.hashCode(zzaHg)) * 31 + zzww.hashCode(zzaHh)) * 31 + zzww.hashCode(zzaHi)) * 31 + zzww.hashCode(zzaHj)) * 31 + (int)(zzaHk ^ zzaHk >>> 32)) * 31 + zzvL();
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        boolean flag = false;
        if (!Arrays.equals(zzaGX, zzxb.zzaHV))
        {
            zzwr1.zza(1, zzaGX);
        }
        if (!zzaGY.equals(""))
        {
            zzwr1.zzb(2, zzaGY);
        }
        if (Double.doubleToLongBits(zzaGZ) != Double.doubleToLongBits(0.0D))
        {
            zzwr1.zza(3, zzaGZ);
        }
        if (Float.floatToIntBits(zzaHa) != Float.floatToIntBits(0.0F))
        {
            zzwr1.zzb(4, zzaHa);
        }
        if (zzaHb != 0L)
        {
            zzwr1.zzb(5, zzaHb);
        }
        if (zzaHc != 0)
        {
            zzwr1.zzy(6, zzaHc);
        }
        if (zzaHd != 0)
        {
            zzwr1.zzz(7, zzaHd);
        }
        if (zzaHe)
        {
            zzwr1.zzb(8, zzaHe);
        }
        if (zzaHf != null && zzaHf.length > 0)
        {
            for (int i = 0; i < zzaHf.length; i++)
            {
                zzvL zzvl = zzaHf[i];
                if (zzvl != null)
                {
                    zzwr1.zza(9, zzvl);
                }
            }

        }
        if (zzaHg != null && zzaHg.length > 0)
        {
            for (int j = 0; j < zzaHg.length; j++)
            {
                zzvL zzvl1 = zzaHg[j];
                if (zzvl1 != null)
                {
                    zzwr1.zza(10, zzvl1);
                }
            }

        }
        if (zzaHh != null && zzaHh.length > 0)
        {
            for (int k = 0; k < zzaHh.length; k++)
            {
                String s = zzaHh[k];
                if (s != null)
                {
                    zzwr1.zzb(11, s);
                }
            }

        }
        if (zzaHi != null && zzaHi.length > 0)
        {
            for (int l = 0; l < zzaHi.length; l++)
            {
                zzwr1.zzb(12, zzaHi[l]);
            }

        }
        if (zzaHk != 0L)
        {
            zzwr1.zzb(13, zzaHk);
        }
        if (zzaHj != null && zzaHj.length > 0)
        {
            for (int i1 = ((flag) ? 1 : 0); i1 < zzaHj.length; i1++)
            {
                zzwr1.zzb(14, zzaHj[i1]);
            }

        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzx(zzwq1);
    }

    protected int zzc()
    {
        boolean flag = false;
        int j = super.zzc();
        int i = j;
        if (!Arrays.equals(zzaGX, zzxb.zzaHV))
        {
            i = j + zzwr.zzb(1, zzaGX);
        }
        j = i;
        if (!zzaGY.equals(""))
        {
            j = i + zzwr.zzj(2, zzaGY);
        }
        i = j;
        if (Double.doubleToLongBits(zzaGZ) != Double.doubleToLongBits(0.0D))
        {
            i = j + zzwr.zzb(3, zzaGZ);
        }
        j = i;
        if (Float.floatToIntBits(zzaHa) != Float.floatToIntBits(0.0F))
        {
            j = i + zzwr.zzc(4, zzaHa);
        }
        i = j;
        if (zzaHb != 0L)
        {
            i = j + zzwr.zzd(5, zzaHb);
        }
        j = i;
        if (zzaHc != 0)
        {
            j = i + zzwr.zzA(6, zzaHc);
        }
        int k = j;
        if (zzaHd != 0)
        {
            k = j + zzwr.zzB(7, zzaHd);
        }
        i = k;
        if (zzaHe)
        {
            i = k + zzwr.zzc(8, zzaHe);
        }
        j = i;
        if (zzaHf != null)
        {
            j = i;
            if (zzaHf.length > 0)
            {
                for (j = 0; j < zzaHf.length;)
                {
                    zzx zzx1 = zzaHf[j];
                    int l = i;
                    if (zzx1 != null)
                    {
                        l = i + zzwr.zzc(9, zzx1);
                    }
                    j++;
                    i = l;
                }

                j = i;
            }
        }
        i = j;
        if (zzaHg != null)
        {
            i = j;
            if (zzaHg.length > 0)
            {
                i = j;
                for (j = 0; j < zzaHg.length;)
                {
                    zzx zzx2 = zzaHg[j];
                    int i1 = i;
                    if (zzx2 != null)
                    {
                        i1 = i + zzwr.zzc(10, zzx2);
                    }
                    j++;
                    i = i1;
                }

            }
        }
        j = i;
        if (zzaHh != null)
        {
            j = i;
            if (zzaHh.length > 0)
            {
                j = 0;
                int j1 = 0;
                int l1;
                int i2;
                for (l1 = 0; j < zzaHh.length; l1 = i2)
                {
                    String s = zzaHh[j];
                    int j2 = j1;
                    i2 = l1;
                    if (s != null)
                    {
                        i2 = l1 + 1;
                        j2 = j1 + zzwr.zzdM(s);
                    }
                    j++;
                    j1 = j2;
                }

                j = i + j1 + l1 * 1;
            }
        }
        i = j;
        if (zzaHi != null)
        {
            i = j;
            if (zzaHi.length > 0)
            {
                int k1 = 0;
                for (i = ((flag) ? 1 : 0); i < zzaHi.length; i++)
                {
                    k1 += zzwr.zzN(zzaHi[i]);
                }

                i = j + k1 + zzaHi.length * 1;
            }
        }
        j = i;
        if (zzaHk != 0L)
        {
            j = i + zzwr.zzd(13, zzaHk);
        }
        i = j;
        if (zzaHj != null)
        {
            i = j;
            if (zzaHj.length > 0)
            {
                i = j + zzaHj.length * 4 + zzaHj.length * 1;
            }
        }
        return i;
    }

    public zzaHj zzvs()
    {
        zzaGX = zzxb.zzaHV;
        zzaGY = "";
        zzaGZ = 0.0D;
        zzaHa = 0.0F;
        zzaHb = 0L;
        zzaHc = 0;
        zzaHd = 0;
        zzaHe = false;
        zzaHf = zzaHf();
        zzaHg = ();
        zzaHh = zzxb.zzaHT;
        zzaHi = zzxb.zzaHP;
        zzaHj = zzxb.zzaHQ;
        zzaHk = 0L;
        zzaHB = null;
        zzaHM = -1;
        return this;
    }

    public zzaHM zzx(zzwq zzwq1)
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
                zzaGX = zzwq1.readBytes();
                break;

            case 18: // '\022'
                zzaGY = zzwq1.readString();
                break;

            case 25: // '\031'
                zzaGZ = zzwq1.readDouble();
                break;

            case 37: // '%'
                zzaHa = zzwq1.readFloat();
                break;

            case 40: // '('
                zzaHb = zzwq1.zzvw();
                break;

            case 48: // '0'
                zzaHc = zzwq1.zzvx();
                break;

            case 56: // '8'
                zzaHd = zzwq1.zzvz();
                break;

            case 64: // '@'
                zzaHe = zzwq1.zzvy();
                break;

            case 74: // 'J'
                int i2 = zzxb.zzc(zzwq1, 74);
                zzaHM azzahm[];
                int j;
                if (zzaHf == null)
                {
                    j = 0;
                } else
                {
                    j = zzaHf.length;
                }
                azzahm = new zzaHf[i2 + j];
                i2 = j;
                if (j != 0)
                {
                    System.arraycopy(zzaHf, 0, azzahm, 0, j);
                    i2 = j;
                }
                for (; i2 < azzahm.length - 1; i2++)
                {
                    azzahm[i2] = new zzaHf();
                    zzwq1.zza(azzahm[i2]);
                    zzwq1.zzvu();
                }

                azzahm[i2] = new zzaHf();
                zzwq1.zza(azzahm[i2]);
                zzaHf = azzahm;
                break;

            case 82: // 'R'
                int j2 = zzxb.zzc(zzwq1, 82);
                zzaHM azzahm1[];
                int k;
                if (zzaHg == null)
                {
                    k = 0;
                } else
                {
                    k = zzaHg.length;
                }
                azzahm1 = new zzaHg[j2 + k];
                j2 = k;
                if (k != 0)
                {
                    System.arraycopy(zzaHg, 0, azzahm1, 0, k);
                    j2 = k;
                }
                for (; j2 < azzahm1.length - 1; j2++)
                {
                    azzahm1[j2] = new t>();
                    zzwq1.zza(azzahm1[j2]);
                    zzwq1.zzvu();
                }

                azzahm1[j2] = new t>();
                zzwq1.zza(azzahm1[j2]);
                zzaHg = azzahm1;
                break;

            case 90: // 'Z'
                int k2 = zzxb.zzc(zzwq1, 90);
                String as[];
                int l;
                if (zzaHh == null)
                {
                    l = 0;
                } else
                {
                    l = zzaHh.length;
                }
                as = new String[k2 + l];
                k2 = l;
                if (l != 0)
                {
                    System.arraycopy(zzaHh, 0, as, 0, l);
                    k2 = l;
                }
                for (; k2 < as.length - 1; k2++)
                {
                    as[k2] = zzwq1.readString();
                    zzwq1.zzvu();
                }

                as[k2] = zzwq1.readString();
                zzaHh = as;
                break;

            case 96: // '`'
                int l2 = zzxb.zzc(zzwq1, 96);
                long al[];
                int i1;
                if (zzaHi == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = zzaHi.length;
                }
                al = new long[l2 + i1];
                l2 = i1;
                if (i1 != 0)
                {
                    System.arraycopy(zzaHi, 0, al, 0, i1);
                    l2 = i1;
                }
                for (; l2 < al.length - 1; l2++)
                {
                    al[l2] = zzwq1.zzvw();
                    zzwq1.zzvu();
                }

                al[l2] = zzwq1.zzvw();
                zzaHi = al;
                break;

            case 98: // 'b'
                int l3 = zzwq1.zzip(zzwq1.zzvB());
                int j1 = zzwq1.getPosition();
                int i3;
                for (i3 = 0; zzwq1.zzvG() > 0; i3++)
                {
                    zzwq1.zzvw();
                }

                zzwq1.zzir(j1);
                long al1[];
                if (zzaHi == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = zzaHi.length;
                }
                al1 = new long[i3 + j1];
                i3 = j1;
                if (j1 != 0)
                {
                    System.arraycopy(zzaHi, 0, al1, 0, j1);
                    i3 = j1;
                }
                for (; i3 < al1.length; i3++)
                {
                    al1[i3] = zzwq1.zzvw();
                }

                zzaHi = al1;
                zzwq1.zziq(l3);
                break;

            case 104: // 'h'
                zzaHk = zzwq1.zzvw();
                break;

            case 117: // 'u'
                int j3 = zzxb.zzc(zzwq1, 117);
                float af[];
                int k1;
                if (zzaHj == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = zzaHj.length;
                }
                af = new float[j3 + k1];
                j3 = k1;
                if (k1 != 0)
                {
                    System.arraycopy(zzaHj, 0, af, 0, k1);
                    j3 = k1;
                }
                for (; j3 < af.length - 1; j3++)
                {
                    af[j3] = zzwq1.readFloat();
                    zzwq1.zzvu();
                }

                af[j3] = zzwq1.readFloat();
                zzaHj = af;
                break;

            case 114: // 'r'
                int l1 = zzwq1.zzvB();
                int i4 = zzwq1.zzip(l1);
                int k3 = l1 / 4;
                float af1[];
                if (zzaHj == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = zzaHj.length;
                }
                af1 = new float[k3 + l1];
                k3 = l1;
                if (l1 != 0)
                {
                    System.arraycopy(zzaHj, 0, af1, 0, l1);
                    k3 = l1;
                }
                for (; k3 < af1.length; k3++)
                {
                    af1[k3] = zzwq1.readFloat();
                }

                zzaHj = af1;
                zzwq1.zziq(i4);
                break;
            }
        } while (true);
    }

    public ()
    {
        zzvs();
    }
}
