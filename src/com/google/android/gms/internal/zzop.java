// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzww, zzwr, zzwq, 
//            zzxb, zzwy

public interface zzop
{
    public static final class zza extends zzws
    {

        public zza zzale[];

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
                if (obj instanceof zza)
                {
                    obj = (zza)obj;
                    flag = flag1;
                    if (zzww.equals(zzale, ((zza) (obj)).zzale))
                    {
                        return zza(((zzws) (obj)));
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return (zzww.hashCode(zzale) + 527) * 31 + zzvL();
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            if (zzale != null && zzale.length > 0)
            {
                for (int i = 0; i < zzale.length; i++)
                {
                    zza zza1 = zzale[i];
                    if (zza1 != null)
                    {
                        zzwr1.zza(1, zza1);
                    }
                }

            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzo(zzwq1);
        }

        protected int zzc()
        {
            int i = super.zzc();
            int k = i;
            if (zzale != null)
            {
                k = i;
                if (zzale.length > 0)
                {
                    int j = 0;
                    do
                    {
                        k = i;
                        if (j >= zzale.length)
                        {
                            break;
                        }
                        zza zza1 = zzale[j];
                        k = i;
                        if (zza1 != null)
                        {
                            k = i + zzwr.zzc(1, zza1);
                        }
                        j++;
                        i = k;
                    } while (true);
                }
            }
            return k;
        }

        public zza zzo(zzwq zzwq1)
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
                    int k = zzxb.zzc(zzwq1, 10);
                    zza azza[];
                    int j;
                    if (zzale == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzale.length;
                    }
                    azza = new zza[k + j];
                    k = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzale, 0, azza, 0, j);
                        k = j;
                    }
                    for (; k < azza.length - 1; k++)
                    {
                        azza[k] = new zza();
                        zzwq1.zza(azza[k]);
                        zzwq1.zzvu();
                    }

                    azza[k] = new zza();
                    zzwq1.zza(azza[k]);
                    zzale = azza;
                    break;
                }
            } while (true);
        }

        public zza zzpf()
        {
            zzale = zza.zzpg();
            zzaHB = null;
            zzaHM = -1;
            return this;
        }

        public zza()
        {
            zzpf();
        }
    }

    public static final class zza.zza extends zzws
    {

        private static volatile zza.zza zzalf[];
        public int viewId;
        public String zzalg;
        public String zzalh;

        public static zza.zza[] zzpg()
        {
            if (zzalf == null)
            {
                synchronized (zzww.zzaHL)
                {
                    if (zzalf == null)
                    {
                        zzalf = new zza.zza[0];
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
            if (!(obj instanceof zza.zza)) goto _L4; else goto _L3
_L3:
            obj = (zza.zza)obj;
            if (zzalg != null) goto _L6; else goto _L5
_L5:
            flag = flag1;
            if (((zza.zza) (obj)).zzalg != null) goto _L4; else goto _L7
_L7:
            if (zzalh != null)
            {
                break MISSING_BLOCK_LABEL_92;
            }
            flag = flag1;
            if (((zza.zza) (obj)).zzalh != null) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (viewId == ((zza.zza) (obj)).viewId)
            {
                return zza(((zzws) (obj)));
            }
              goto _L4
_L6:
            if (!zzalg.equals(((zza.zza) (obj)).zzalg))
            {
                return false;
            }
              goto _L7
            if (!zzalh.equals(((zza.zza) (obj)).zzalh))
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

        public zza.zza zzp(zzwq zzwq1)
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

        public zza.zza zzph()
        {
            zzalg = "";
            zzalh = "";
            viewId = 0;
            zzaHB = null;
            zzaHM = -1;
            return this;
        }

        public zza.zza()
        {
            zzph();
        }
    }

    public static final class zzb extends zzws
    {

        private static volatile zzb zzali[];
        public String name;
        public zzd zzalj;

        public static zzb[] zzpi()
        {
            if (zzali == null)
            {
                synchronized (zzww.zzaHL)
                {
                    if (zzali == null)
                    {
                        zzali = new zzb[0];
                    }
                }
            }
            return zzali;
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
            if (!(obj instanceof zzb)) goto _L4; else goto _L3
_L3:
            obj = (zzb)obj;
            if (name != null) goto _L6; else goto _L5
_L5:
            flag = flag1;
            if (((zzb) (obj)).name != null) goto _L4; else goto _L7
_L7:
            if (zzalj != null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            flag = flag1;
            if (((zzb) (obj)).zzalj != null) goto _L4; else goto _L8
_L8:
            return zza(((zzws) (obj)));
_L6:
            if (!name.equals(((zzb) (obj)).name))
            {
                return false;
            }
              goto _L7
            if (!zzalj.equals(((zzb) (obj)).zzalj))
            {
                return false;
            }
              goto _L8
        }

        public int hashCode()
        {
            int j = 0;
            int i;
            if (name == null)
            {
                i = 0;
            } else
            {
                i = name.hashCode();
            }
            if (zzalj != null)
            {
                j = zzalj.hashCode();
            }
            return ((i + 527) * 31 + j) * 31 + zzvL();
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            if (!name.equals(""))
            {
                zzwr1.zzb(1, name);
            }
            if (zzalj != null)
            {
                zzwr1.zza(2, zzalj);
            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzq(zzwq1);
        }

        protected int zzc()
        {
            int j = super.zzc();
            int i = j;
            if (!name.equals(""))
            {
                i = j + zzwr.zzj(1, name);
            }
            j = i;
            if (zzalj != null)
            {
                j = i + zzwr.zzc(2, zzalj);
            }
            return j;
        }

        public zzb zzpj()
        {
            name = "";
            zzalj = null;
            zzaHB = null;
            zzaHM = -1;
            return this;
        }

        public zzb zzq(zzwq zzwq1)
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
                    name = zzwq1.readString();
                    break;

                case 18: // '\022'
                    if (zzalj == null)
                    {
                        zzalj = new zzd();
                    }
                    zzwq1.zza(zzalj);
                    break;
                }
            } while (true);
        }

        public zzb()
        {
            zzpj();
        }
    }

    public static final class zzc extends zzws
    {

        public String type;
        public zzb zzalk[];

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
            if (!(obj instanceof zzc))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (zzc)obj;
            if (type != null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (((zzc) (obj)).type != null)
            {
                continue; /* Loop/switch isn't completed */
            }
_L5:
            flag = flag1;
            if (zzww.equals(zzalk, ((zzc) (obj)).zzalk))
            {
                return zza(((zzws) (obj)));
            }
            if (true) goto _L4; else goto _L3
_L3:
            if (!type.equals(((zzc) (obj)).type))
            {
                return false;
            }
              goto _L5
            if (true) goto _L4; else goto _L6
_L6:
        }

        public int hashCode()
        {
            int i;
            if (type == null)
            {
                i = 0;
            } else
            {
                i = type.hashCode();
            }
            return ((i + 527) * 31 + zzww.hashCode(zzalk)) * 31 + zzvL();
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            if (!type.equals(""))
            {
                zzwr1.zzb(1, type);
            }
            if (zzalk != null && zzalk.length > 0)
            {
                for (int i = 0; i < zzalk.length; i++)
                {
                    zzb zzb1 = zzalk[i];
                    if (zzb1 != null)
                    {
                        zzwr1.zza(2, zzb1);
                    }
                }

            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzr(zzwq1);
        }

        protected int zzc()
        {
            int j = super.zzc();
            int i = j;
            if (!type.equals(""))
            {
                i = j + zzwr.zzj(1, type);
            }
            j = i;
            if (zzalk != null)
            {
                j = i;
                if (zzalk.length > 0)
                {
                    for (j = 0; j < zzalk.length;)
                    {
                        zzb zzb1 = zzalk[j];
                        int k = i;
                        if (zzb1 != null)
                        {
                            k = i + zzwr.zzc(2, zzb1);
                        }
                        j++;
                        i = k;
                    }

                    j = i;
                }
            }
            return j;
        }

        public zzc zzpk()
        {
            type = "";
            zzalk = zzb.zzpi();
            zzaHB = null;
            zzaHM = -1;
            return this;
        }

        public zzc zzr(zzwq zzwq1)
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
                    type = zzwq1.readString();
                    break;

                case 18: // '\022'
                    int k = zzxb.zzc(zzwq1, 18);
                    zzb azzb[];
                    int j;
                    if (zzalk == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzalk.length;
                    }
                    azzb = new zzb[k + j];
                    k = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzalk, 0, azzb, 0, j);
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
                    zzalk = azzb;
                    break;
                }
            } while (true);
        }

        public zzc()
        {
            zzpk();
        }
    }

    public static final class zzd extends zzws
    {

        public String zzQN;
        public boolean zzall;
        public long zzalm;
        public double zzaln;
        public zzc zzalo;

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
            if (!(obj instanceof zzd)) goto _L4; else goto _L3
_L3:
            obj = (zzd)obj;
            flag = flag1;
            if (zzall != ((zzd) (obj)).zzall) goto _L4; else goto _L5
_L5:
            if (zzQN != null) goto _L7; else goto _L6
_L6:
            flag = flag1;
            if (((zzd) (obj)).zzQN != null) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (zzalm != ((zzd) (obj)).zzalm) goto _L4; else goto _L9
_L9:
            flag = flag1;
            if (Double.doubleToLongBits(zzaln) != Double.doubleToLongBits(((zzd) (obj)).zzaln)) goto _L4; else goto _L10
_L10:
            if (zzalo != null)
            {
                break MISSING_BLOCK_LABEL_126;
            }
            flag = flag1;
            if (((zzd) (obj)).zzalo != null) goto _L4; else goto _L11
_L11:
            return zza(((zzws) (obj)));
_L7:
            if (!zzQN.equals(((zzd) (obj)).zzQN))
            {
                return false;
            }
              goto _L8
            if (!zzalo.equals(((zzd) (obj)).zzalo))
            {
                return false;
            }
              goto _L11
        }

        public int hashCode()
        {
            int j = 0;
            char c;
            int i;
            int k;
            int l;
            long l1;
            if (zzall)
            {
                c = '\u04CF';
            } else
            {
                c = '\u04D5';
            }
            if (zzQN == null)
            {
                i = 0;
            } else
            {
                i = zzQN.hashCode();
            }
            k = (int)(zzalm ^ zzalm >>> 32);
            l1 = Double.doubleToLongBits(zzaln);
            l = (int)(l1 ^ l1 >>> 32);
            if (zzalo != null)
            {
                j = zzalo.hashCode();
            }
            return ((((i + (c + 527) * 31) * 31 + k) * 31 + l) * 31 + j) * 31 + zzvL();
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            if (zzall)
            {
                zzwr1.zzb(1, zzall);
            }
            if (!zzQN.equals(""))
            {
                zzwr1.zzb(2, zzQN);
            }
            if (zzalm != 0L)
            {
                zzwr1.zzb(3, zzalm);
            }
            if (Double.doubleToLongBits(zzaln) != Double.doubleToLongBits(0.0D))
            {
                zzwr1.zza(4, zzaln);
            }
            if (zzalo != null)
            {
                zzwr1.zza(5, zzalo);
            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzs(zzwq1);
        }

        protected int zzc()
        {
            int j = super.zzc();
            int i = j;
            if (zzall)
            {
                i = j + zzwr.zzc(1, zzall);
            }
            j = i;
            if (!zzQN.equals(""))
            {
                j = i + zzwr.zzj(2, zzQN);
            }
            i = j;
            if (zzalm != 0L)
            {
                i = j + zzwr.zzd(3, zzalm);
            }
            j = i;
            if (Double.doubleToLongBits(zzaln) != Double.doubleToLongBits(0.0D))
            {
                j = i + zzwr.zzb(4, zzaln);
            }
            i = j;
            if (zzalo != null)
            {
                i = j + zzwr.zzc(5, zzalo);
            }
            return i;
        }

        public zzd zzpl()
        {
            zzall = false;
            zzQN = "";
            zzalm = 0L;
            zzaln = 0.0D;
            zzalo = null;
            zzaHB = null;
            zzaHM = -1;
            return this;
        }

        public zzd zzs(zzwq zzwq1)
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
                    zzall = zzwq1.zzvy();
                    break;

                case 18: // '\022'
                    zzQN = zzwq1.readString();
                    break;

                case 24: // '\030'
                    zzalm = zzwq1.zzvw();
                    break;

                case 33: // '!'
                    zzaln = zzwq1.readDouble();
                    break;

                case 42: // '*'
                    if (zzalo == null)
                    {
                        zzalo = new zzc();
                    }
                    zzwq1.zza(zzalo);
                    break;
                }
            } while (true);
        }

        public zzd()
        {
            zzpl();
        }
    }

}
