// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwy, zzww, zzwq, zzxb, 
//            zzwr

public interface zzxd
{
    public static final class zza extends zzwy
    {

        public long zzaIq;
        public long zzaIr;
        public int zzaIs;
        public zzxe.zza zzaIt;
        public int zzaIu;
        public zzc zzaIv[];
        public int zzaIw;
        public boolean zzaIx;
        public zzxc.zzb zzaIy[];

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (!(obj instanceof zza))
                {
                    return false;
                }
                obj = (zza)obj;
                if (zzaIq != ((zza) (obj)).zzaIq)
                {
                    return false;
                }
                if (zzaIr != ((zza) (obj)).zzaIr)
                {
                    return false;
                }
                if (zzaIs != ((zza) (obj)).zzaIs)
                {
                    return false;
                }
                if (zzaIt == null)
                {
                    if (((zza) (obj)).zzaIt != null)
                    {
                        return false;
                    }
                } else
                if (!zzaIt.equals(((zza) (obj)).zzaIt))
                {
                    return false;
                }
                if (zzaIu != ((zza) (obj)).zzaIu)
                {
                    return false;
                }
                if (!zzww.equals(zzaIv, ((zza) (obj)).zzaIv))
                {
                    return false;
                }
                if (zzaIw != ((zza) (obj)).zzaIw)
                {
                    return false;
                }
                if (zzaIx != ((zza) (obj)).zzaIx)
                {
                    return false;
                }
                if (!zzww.equals(zzaIy, ((zza) (obj)).zzaIy))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            int j = (int)(zzaIq ^ zzaIq >>> 32);
            int k = (int)(zzaIr ^ zzaIr >>> 32);
            int l = zzaIs;
            int i;
            char c;
            int i1;
            int j1;
            int k1;
            if (zzaIt == null)
            {
                i = 0;
            } else
            {
                i = zzaIt.hashCode();
            }
            i1 = zzaIu;
            j1 = zzww.hashCode(zzaIv);
            k1 = zzaIw;
            if (zzaIx)
            {
                c = '\u04CF';
            } else
            {
                c = '\u04D5';
            }
            return (c + ((((i + (((j + 527) * 31 + k) * 31 + l) * 31) * 31 + i1) * 31 + j1) * 31 + k1) * 31) * 31 + zzww.hashCode(zzaIy);
        }

        public zza zzG(zzwq zzwq1)
            throws IOException
        {
_L12:
            int i = zzwq1.zzvu();
            i;
            JVM INSTR lookupswitch 10: default 96
        //                       0: 104
        //                       8: 106
        //                       16: 117
        //                       24: 128
        //                       34: 139
        //                       40: 168
        //                       50: 179
        //                       56: 303
        //                       64: 355
        //                       74: 366;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
            if (zzxb.zzb(zzwq1, i)) goto _L12; else goto _L2
_L2:
            return this;
_L3:
            zzaIq = zzwq1.zzvw();
              goto _L12
_L4:
            zzaIr = zzwq1.zzvw();
              goto _L12
_L5:
            zzaIs = zzwq1.zzvx();
              goto _L12
_L6:
            if (zzaIt == null)
            {
                zzaIt = new zzxe.zza();
            }
            zzwq1.zza(zzaIt);
              goto _L12
_L7:
            zzaIu = zzwq1.zzvx();
              goto _L12
_L8:
            int i1 = zzxb.zzc(zzwq1, 50);
            zzc azzc[];
            int j;
            if (zzaIv == null)
            {
                j = 0;
            } else
            {
                j = zzaIv.length;
            }
            azzc = new zzc[i1 + j];
            i1 = j;
            if (j != 0)
            {
                System.arraycopy(zzaIv, 0, azzc, 0, j);
                i1 = j;
            }
            for (; i1 < azzc.length - 1; i1++)
            {
                azzc[i1] = new zzc();
                zzwq1.zza(azzc[i1]);
                zzwq1.zzvu();
            }

            azzc[i1] = new zzc();
            zzwq1.zza(azzc[i1]);
            zzaIv = azzc;
              goto _L12
_L9:
            int k = zzwq1.zzvx();
            switch (k)
            {
            case 0: // '\0'
            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
                zzaIw = k;
                break;
            }
            continue; /* Loop/switch isn't completed */
_L10:
            zzaIx = zzwq1.zzvy();
            continue; /* Loop/switch isn't completed */
_L11:
            int j1 = zzxb.zzc(zzwq1, 74);
            zzxc.zzb azzb[];
            int l;
            if (zzaIy == null)
            {
                l = 0;
            } else
            {
                l = zzaIy.length;
            }
            azzb = new zzxc.zzb[j1 + l];
            j1 = l;
            if (l != 0)
            {
                System.arraycopy(zzaIy, 0, azzb, 0, l);
                j1 = l;
            }
            for (; j1 < azzb.length - 1; j1++)
            {
                azzb[j1] = new zzxc.zzb();
                zzwq1.zza(azzb[j1]);
                zzwq1.zzvu();
            }

            azzb[j1] = new zzxc.zzb();
            zzwq1.zza(azzb[j1]);
            zzaIy = azzb;
            if (true) goto _L12; else goto _L13
_L13:
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            boolean flag = false;
            if (zzaIq != 0L)
            {
                zzwr1.zzb(1, zzaIq);
            }
            if (zzaIr != 0L)
            {
                zzwr1.zzb(2, zzaIr);
            }
            if (zzaIs != 0)
            {
                zzwr1.zzy(3, zzaIs);
            }
            if (zzaIt != null)
            {
                zzwr1.zza(4, zzaIt);
            }
            if (zzaIu != 0)
            {
                zzwr1.zzy(5, zzaIu);
            }
            if (zzaIv != null && zzaIv.length > 0)
            {
                for (int i = 0; i < zzaIv.length; i++)
                {
                    zzc zzc1 = zzaIv[i];
                    if (zzc1 != null)
                    {
                        zzwr1.zza(6, zzc1);
                    }
                }

            }
            if (zzaIw != 0)
            {
                zzwr1.zzy(7, zzaIw);
            }
            if (zzaIx)
            {
                zzwr1.zzb(8, zzaIx);
            }
            if (zzaIy != null && zzaIy.length > 0)
            {
                for (int j = ((flag) ? 1 : 0); j < zzaIy.length; j++)
                {
                    zzxc.zzb zzb1 = zzaIy[j];
                    if (zzb1 != null)
                    {
                        zzwr1.zza(9, zzb1);
                    }
                }

            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzG(zzwq1);
        }

        protected int zzc()
        {
            boolean flag = false;
            int j = super.zzc();
            int i = j;
            if (zzaIq != 0L)
            {
                i = j + zzwr.zzd(1, zzaIq);
            }
            j = i;
            if (zzaIr != 0L)
            {
                j = i + zzwr.zzd(2, zzaIr);
            }
            i = j;
            if (zzaIs != 0)
            {
                i = j + zzwr.zzA(3, zzaIs);
            }
            j = i;
            if (zzaIt != null)
            {
                j = i + zzwr.zzc(4, zzaIt);
            }
            i = j;
            if (zzaIu != 0)
            {
                i = j + zzwr.zzA(5, zzaIu);
            }
            j = i;
            if (zzaIv != null)
            {
                j = i;
                if (zzaIv.length > 0)
                {
                    for (j = 0; j < zzaIv.length;)
                    {
                        zzc zzc1 = zzaIv[j];
                        int l = i;
                        if (zzc1 != null)
                        {
                            l = i + zzwr.zzc(6, zzc1);
                        }
                        j++;
                        i = l;
                    }

                    j = i;
                }
            }
            int i1 = j;
            if (zzaIw != 0)
            {
                i1 = j + zzwr.zzA(7, zzaIw);
            }
            i = i1;
            if (zzaIx)
            {
                i = i1 + zzwr.zzc(8, zzaIx);
            }
            i1 = i;
            if (zzaIy != null)
            {
                i1 = i;
                if (zzaIy.length > 0)
                {
                    int k = ((flag) ? 1 : 0);
                    do
                    {
                        i1 = i;
                        if (k >= zzaIy.length)
                        {
                            break;
                        }
                        zzxc.zzb zzb1 = zzaIy[k];
                        i1 = i;
                        if (zzb1 != null)
                        {
                            i1 = i + zzwr.zzc(9, zzb1);
                        }
                        k++;
                        i = i1;
                    } while (true);
                }
            }
            return i1;
        }

        public zza zzwi()
        {
            zzaIq = 0L;
            zzaIr = 0L;
            zzaIs = 0;
            zzaIt = null;
            zzaIu = 0;
            zzaIv = zzc.zzwl();
            zzaIw = 0;
            zzaIx = false;
            zzaIy = zzxc.zzb.zzwa();
            zzaHM = -1;
            return this;
        }

        public zza()
        {
            zzwi();
        }
    }

    public static final class zzb extends zzwy
    {

        private static volatile zzb zzaIz[];
        public long zzaIA;
        public long zzaIB;
        public zzxc.zzf zzaIC[];
        public int zzaID;
        public zzxc.zzb zzaIE;
        public int zzaIF;
        public zzxc.zzb zzaIG;
        public long zzaIH;
        public long zzaII;

        public static zzb[] zzwj()
        {
            if (zzaIz == null)
            {
                synchronized (zzww.zzaHL)
                {
                    if (zzaIz == null)
                    {
                        zzaIz = new zzb[0];
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
                if (!(obj instanceof zzb))
                {
                    return false;
                }
                obj = (zzb)obj;
                if (zzaIA != ((zzb) (obj)).zzaIA)
                {
                    return false;
                }
                if (zzaIB != ((zzb) (obj)).zzaIB)
                {
                    return false;
                }
                if (!zzww.equals(zzaIC, ((zzb) (obj)).zzaIC))
                {
                    return false;
                }
                if (zzaID != ((zzb) (obj)).zzaID)
                {
                    return false;
                }
                if (zzaIE == null)
                {
                    if (((zzb) (obj)).zzaIE != null)
                    {
                        return false;
                    }
                } else
                if (!zzaIE.equals(((zzb) (obj)).zzaIE))
                {
                    return false;
                }
                if (zzaIF != ((zzb) (obj)).zzaIF)
                {
                    return false;
                }
                if (zzaIG == null)
                {
                    if (((zzb) (obj)).zzaIG != null)
                    {
                        return false;
                    }
                } else
                if (!zzaIG.equals(((zzb) (obj)).zzaIG))
                {
                    return false;
                }
                if (zzaIH != ((zzb) (obj)).zzaIH)
                {
                    return false;
                }
                if (zzaII != ((zzb) (obj)).zzaII)
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

        public zzb zzH(zzwq zzwq1)
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
                    zzxc.zzf azzf[];
                    int j;
                    if (zzaIC == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzaIC.length;
                    }
                    azzf = new zzxc.zzf[k + j];
                    k = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzaIC, 0, azzf, 0, j);
                        k = j;
                    }
                    for (; k < azzf.length - 1; k++)
                    {
                        azzf[k] = new zzxc.zzf();
                        zzwq1.zza(azzf[k]);
                        zzwq1.zzvu();
                    }

                    azzf[k] = new zzxc.zzf();
                    zzwq1.zza(azzf[k]);
                    zzaIC = azzf;
                    break;

                case 32: // ' '
                    zzaID = zzwq1.zzvx();
                    break;

                case 42: // '*'
                    if (zzaIE == null)
                    {
                        zzaIE = new zzxc.zzb();
                    }
                    zzwq1.zza(zzaIE);
                    break;

                case 48: // '0'
                    zzaIF = zzwq1.zzvx();
                    break;

                case 58: // ':'
                    if (zzaIG == null)
                    {
                        zzaIG = new zzxc.zzb();
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
                    zzxc.zzf zzf = zzaIC[i];
                    if (zzf != null)
                    {
                        zzwr1.zza(3, zzf);
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
                        zzxc.zzf zzf = zzaIC[j];
                        int k = i;
                        if (zzf != null)
                        {
                            k = i + zzwr.zzc(3, zzf);
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

        public zzb zzwk()
        {
            zzaIA = 0L;
            zzaIB = 0L;
            zzaIC = zzxc.zzf.zzwg();
            zzaID = 0;
            zzaIE = null;
            zzaIF = 0;
            zzaIG = null;
            zzaIH = 0L;
            zzaII = 0L;
            zzaHM = -1;
            return this;
        }

        public zzb()
        {
            zzwk();
        }
    }

    public static final class zzc extends zzwy
    {

        private static volatile zzc zzaIJ[];
        public int zzaID;
        public zzxc.zzb zzaIE;
        public zzb zzaIK[];
        public boolean zzaIx;

        public static zzc[] zzwl()
        {
            if (zzaIJ == null)
            {
                synchronized (zzww.zzaHL)
                {
                    if (zzaIJ == null)
                    {
                        zzaIJ = new zzc[0];
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
                if (!(obj instanceof zzc))
                {
                    return false;
                }
                obj = (zzc)obj;
                if (zzaID != ((zzc) (obj)).zzaID)
                {
                    return false;
                }
                if (zzaIE == null)
                {
                    if (((zzc) (obj)).zzaIE != null)
                    {
                        return false;
                    }
                } else
                if (!zzaIE.equals(((zzc) (obj)).zzaIE))
                {
                    return false;
                }
                if (!zzww.equals(zzaIK, ((zzc) (obj)).zzaIK))
                {
                    return false;
                }
                if (zzaIx != ((zzc) (obj)).zzaIx)
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

        public zzc zzI(zzwq zzwq1)
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
                        zzaIE = new zzxc.zzb();
                    }
                    zzwq1.zza(zzaIE);
                    break;

                case 26: // '\032'
                    int k = zzxb.zzc(zzwq1, 26);
                    zzb azzb[];
                    int j;
                    if (zzaIK == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzaIK.length;
                    }
                    azzb = new zzb[k + j];
                    k = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzaIK, 0, azzb, 0, j);
                        k = j;
                    }
                    for (; k < azzb.length - 1; k++)
                    {
                        azzb[k] = new zzb();
                        zzwq1.zza(azzb[k]);
                        zzwq1.zzvu();
                    }

                    azzb[k] = new zzb();
                    zzwq1.zza(azzb[k]);
                    zzaIK = azzb;
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
                    zzb zzb1 = zzaIK[i];
                    if (zzb1 != null)
                    {
                        zzwr1.zza(3, zzb1);
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
                        zzb zzb1 = zzaIK[j];
                        int k = i;
                        if (zzb1 != null)
                        {
                            k = i + zzwr.zzc(3, zzb1);
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

        public zzc zzwm()
        {
            zzaID = 0;
            zzaIE = null;
            zzaIK = zzb.zzwj();
            zzaIx = false;
            zzaHM = -1;
            return this;
        }

        public zzc()
        {
            zzwm();
        }
    }

}
