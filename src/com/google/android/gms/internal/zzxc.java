// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwy, zzww, zzwq, zzxb, 
//            zzwr

public interface zzxc
{
    public static final class zza extends zzwy
    {

        public String name;
        public String packageName;
        public String version;
        public String zzaHW;
        public long zzaHX[];

        public boolean equals(Object obj)
        {
            if (obj != this) goto _L2; else goto _L1
_L1:
            return true;
_L2:
            if (!(obj instanceof zza))
            {
                return false;
            }
            obj = (zza)obj;
            if (packageName == null)
            {
                if (((zza) (obj)).packageName != null)
                {
                    return false;
                }
            } else
            if (!packageName.equals(((zza) (obj)).packageName))
            {
                return false;
            }
            if (version == null)
            {
                if (((zza) (obj)).version != null)
                {
                    return false;
                }
            } else
            if (!version.equals(((zza) (obj)).version))
            {
                return false;
            }
            if (zzaHW == null)
            {
                if (((zza) (obj)).zzaHW != null)
                {
                    return false;
                }
            } else
            if (!zzaHW.equals(((zza) (obj)).zzaHW))
            {
                return false;
            }
            if (!zzww.equals(zzaHX, ((zza) (obj)).zzaHX))
            {
                return false;
            }
            if (name != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((zza) (obj)).name == null) goto _L1; else goto _L3
_L3:
            return false;
            if (name.equals(((zza) (obj)).name)) goto _L1; else goto _L4
_L4:
            return false;
        }

        public int hashCode()
        {
            int l = 0;
            int i;
            int j;
            int k;
            int i1;
            if (packageName == null)
            {
                i = 0;
            } else
            {
                i = packageName.hashCode();
            }
            if (version == null)
            {
                j = 0;
            } else
            {
                j = version.hashCode();
            }
            if (zzaHW == null)
            {
                k = 0;
            } else
            {
                k = zzaHW.hashCode();
            }
            i1 = zzww.hashCode(zzaHX);
            if (name != null)
            {
                l = name.hashCode();
            }
            return ((k + (j + (i + 527) * 31) * 31) * 31 + i1) * 31 + l;
        }

        public zza zzA(zzwq zzwq1)
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

                case 10: // '\n'
                    packageName = zzwq1.readString();
                    break;

                case 18: // '\022'
                    version = zzwq1.readString();
                    break;

                case 26: // '\032'
                    zzaHW = zzwq1.readString();
                    break;

                case 32: // ' '
                    int l = zzxb.zzc(zzwq1, 32);
                    long al[];
                    int j;
                    if (zzaHX == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzaHX.length;
                    }
                    al = new long[l + j];
                    l = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzaHX, 0, al, 0, j);
                        l = j;
                    }
                    for (; l < al.length - 1; l++)
                    {
                        al[l] = zzwq1.zzvw();
                        zzwq1.zzvu();
                    }

                    al[l] = zzwq1.zzvw();
                    zzaHX = al;
                    break;

                case 34: // '"'
                    int j1 = zzwq1.zzip(zzwq1.zzvB());
                    int k = zzwq1.getPosition();
                    int i1;
                    for (i1 = 0; zzwq1.zzvG() > 0; i1++)
                    {
                        zzwq1.zzvw();
                    }

                    zzwq1.zzir(k);
                    long al1[];
                    if (zzaHX == null)
                    {
                        k = 0;
                    } else
                    {
                        k = zzaHX.length;
                    }
                    al1 = new long[i1 + k];
                    i1 = k;
                    if (k != 0)
                    {
                        System.arraycopy(zzaHX, 0, al1, 0, k);
                        i1 = k;
                    }
                    for (; i1 < al1.length; i1++)
                    {
                        al1[i1] = zzwq1.zzvw();
                    }

                    zzaHX = al1;
                    zzwq1.zziq(j1);
                    break;

                case 42: // '*'
                    name = zzwq1.readString();
                    break;
                }
            } while (true);
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            if (packageName != null)
            {
                zzwr1.zzb(1, packageName);
            }
            if (version != null)
            {
                zzwr1.zzb(2, version);
            }
            if (zzaHW != null)
            {
                zzwr1.zzb(3, zzaHW);
            }
            if (zzaHX != null && zzaHX.length > 0)
            {
                for (int i = 0; i < zzaHX.length; i++)
                {
                    zzwr1.zzb(4, zzaHX[i]);
                }

            }
            if (name != null)
            {
                zzwr1.zzb(5, name);
            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzA(zzwq1);
        }

        protected int zzc()
        {
            boolean flag = false;
            int j = super.zzc();
            int i = j;
            if (packageName != null)
            {
                i = j + zzwr.zzj(1, packageName);
            }
            j = i;
            if (version != null)
            {
                j = i + zzwr.zzj(2, version);
            }
            i = j;
            if (zzaHW != null)
            {
                i = j + zzwr.zzj(3, zzaHW);
            }
            j = i;
            if (zzaHX != null)
            {
                j = i;
                if (zzaHX.length > 0)
                {
                    int k = 0;
                    for (j = ((flag) ? 1 : 0); j < zzaHX.length; j++)
                    {
                        k += zzwr.zzN(zzaHX[j]);
                    }

                    j = i + k + zzaHX.length * 1;
                }
            }
            i = j;
            if (name != null)
            {
                i = j + zzwr.zzj(5, name);
            }
            return i;
        }

        public zza zzvZ()
        {
            packageName = null;
            version = null;
            zzaHW = null;
            zzaHX = zzxb.zzaHP;
            name = null;
            zzaHM = -1;
            return this;
        }

        public zza()
        {
            zzvZ();
        }
    }

    public static final class zzb extends zzwy
    {

        private static volatile zzb zzaHY[];
        public String name;
        public String zzaHZ;
        public String zzaIa;
        public Integer zzaIb;
        public zzc zzaIc;
        public zze zzaId;
        public zza zzaIe;

        public static zzb[] zzwa()
        {
            if (zzaHY == null)
            {
                synchronized (zzww.zzaHL)
                {
                    if (zzaHY == null)
                    {
                        zzaHY = new zzb[0];
                    }
                }
            }
            return zzaHY;
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
            if (!(obj instanceof zzb))
            {
                return false;
            }
            obj = (zzb)obj;
            if (zzaHZ == null)
            {
                if (((zzb) (obj)).zzaHZ != null)
                {
                    return false;
                }
            } else
            if (!zzaHZ.equals(((zzb) (obj)).zzaHZ))
            {
                return false;
            }
            if (name == null)
            {
                if (((zzb) (obj)).name != null)
                {
                    return false;
                }
            } else
            if (!name.equals(((zzb) (obj)).name))
            {
                return false;
            }
            if (zzaIa == null)
            {
                if (((zzb) (obj)).zzaIa != null)
                {
                    return false;
                }
            } else
            if (!zzaIa.equals(((zzb) (obj)).zzaIa))
            {
                return false;
            }
            if (zzaIb == null)
            {
                if (((zzb) (obj)).zzaIb != null)
                {
                    return false;
                }
            } else
            if (!zzaIb.equals(((zzb) (obj)).zzaIb))
            {
                return false;
            }
            if (zzaIc == null)
            {
                if (((zzb) (obj)).zzaIc != null)
                {
                    return false;
                }
            } else
            if (!zzaIc.equals(((zzb) (obj)).zzaIc))
            {
                return false;
            }
            if (zzaId == null)
            {
                if (((zzb) (obj)).zzaId != null)
                {
                    return false;
                }
            } else
            if (!zzaId.equals(((zzb) (obj)).zzaId))
            {
                return false;
            }
            if (zzaIe != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((zzb) (obj)).zzaIe == null) goto _L1; else goto _L3
_L3:
            return false;
            if (zzaIe.equals(((zzb) (obj)).zzaIe)) goto _L1; else goto _L4
_L4:
            return false;
        }

        public int hashCode()
        {
            int k1 = 0;
            int i;
            int j;
            int k;
            int l;
            int i1;
            int j1;
            if (zzaHZ == null)
            {
                i = 0;
            } else
            {
                i = zzaHZ.hashCode();
            }
            if (name == null)
            {
                j = 0;
            } else
            {
                j = name.hashCode();
            }
            if (zzaIa == null)
            {
                k = 0;
            } else
            {
                k = zzaIa.hashCode();
            }
            if (zzaIb == null)
            {
                l = 0;
            } else
            {
                l = zzaIb.intValue();
            }
            if (zzaIc == null)
            {
                i1 = 0;
            } else
            {
                i1 = zzaIc.hashCode();
            }
            if (zzaId == null)
            {
                j1 = 0;
            } else
            {
                j1 = zzaId.hashCode();
            }
            if (zzaIe != null)
            {
                k1 = zzaIe.hashCode();
            }
            return (j1 + (i1 + (l + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + k1;
        }

        public zzb zzB(zzwq zzwq1)
            throws IOException
        {
_L10:
            int i = zzwq1.zzvu();
            i;
            JVM INSTR lookupswitch 8: default 80
        //                       0: 88
        //                       10: 90
        //                       34: 101
        //                       42: 112
        //                       48: 123
        //                       58: 166
        //                       66: 195
        //                       74: 224;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
            if (zzxb.zzb(zzwq1, i)) goto _L10; else goto _L2
_L2:
            return this;
_L3:
            zzaHZ = zzwq1.readString();
              goto _L10
_L4:
            name = zzwq1.readString();
              goto _L10
_L5:
            zzaIa = zzwq1.readString();
              goto _L10
_L6:
            int j = zzwq1.zzvx();
            switch (j)
            {
            case 0: // '\0'
            case 1: // '\001'
                zzaIb = Integer.valueOf(j);
                break;
            }
            continue; /* Loop/switch isn't completed */
_L7:
            if (zzaIc == null)
            {
                zzaIc = new zzc();
            }
            zzwq1.zza(zzaIc);
            continue; /* Loop/switch isn't completed */
_L8:
            if (zzaId == null)
            {
                zzaId = new zze();
            }
            zzwq1.zza(zzaId);
            continue; /* Loop/switch isn't completed */
_L9:
            if (zzaIe == null)
            {
                zzaIe = new zza();
            }
            zzwq1.zza(zzaIe);
            if (true) goto _L10; else goto _L11
_L11:
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            if (zzaHZ != null)
            {
                zzwr1.zzb(1, zzaHZ);
            }
            if (name != null)
            {
                zzwr1.zzb(4, name);
            }
            if (zzaIa != null)
            {
                zzwr1.zzb(5, zzaIa);
            }
            if (zzaIb != null)
            {
                zzwr1.zzy(6, zzaIb.intValue());
            }
            if (zzaIc != null)
            {
                zzwr1.zza(7, zzaIc);
            }
            if (zzaId != null)
            {
                zzwr1.zza(8, zzaId);
            }
            if (zzaIe != null)
            {
                zzwr1.zza(9, zzaIe);
            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzB(zzwq1);
        }

        protected int zzc()
        {
            int j = super.zzc();
            int i = j;
            if (zzaHZ != null)
            {
                i = j + zzwr.zzj(1, zzaHZ);
            }
            j = i;
            if (name != null)
            {
                j = i + zzwr.zzj(4, name);
            }
            i = j;
            if (zzaIa != null)
            {
                i = j + zzwr.zzj(5, zzaIa);
            }
            j = i;
            if (zzaIb != null)
            {
                j = i + zzwr.zzA(6, zzaIb.intValue());
            }
            i = j;
            if (zzaIc != null)
            {
                i = j + zzwr.zzc(7, zzaIc);
            }
            j = i;
            if (zzaId != null)
            {
                j = i + zzwr.zzc(8, zzaId);
            }
            i = j;
            if (zzaIe != null)
            {
                i = j + zzwr.zzc(9, zzaIe);
            }
            return i;
        }

        public zzb zzwb()
        {
            zzaHZ = null;
            name = null;
            zzaIa = null;
            zzaIb = null;
            zzaIc = null;
            zzaId = null;
            zzaIe = null;
            zzaHM = -1;
            return this;
        }

        public zzb()
        {
            zzwb();
        }
    }

    public static final class zzc extends zzwy
    {

        public String name;
        public zzd zzaIf[];

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (!(obj instanceof zzc))
                {
                    return false;
                }
                obj = (zzc)obj;
                if (name == null)
                {
                    if (((zzc) (obj)).name != null)
                    {
                        return false;
                    }
                } else
                if (!name.equals(((zzc) (obj)).name))
                {
                    return false;
                }
                if (!zzww.equals(zzaIf, ((zzc) (obj)).zzaIf))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            int i;
            if (name == null)
            {
                i = 0;
            } else
            {
                i = name.hashCode();
            }
            return (i + 527) * 31 + zzww.hashCode(zzaIf);
        }

        public zzc zzC(zzwq zzwq1)
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

                case 10: // '\n'
                    name = zzwq1.readString();
                    break;

                case 18: // '\022'
                    int k = zzxb.zzc(zzwq1, 18);
                    zzd azzd[];
                    int j;
                    if (zzaIf == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzaIf.length;
                    }
                    azzd = new zzd[k + j];
                    k = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzaIf, 0, azzd, 0, j);
                        k = j;
                    }
                    for (; k < azzd.length - 1; k++)
                    {
                        azzd[k] = new zzd();
                        zzwq1.zza(azzd[k]);
                        zzwq1.zzvu();
                    }

                    azzd[k] = new zzd();
                    zzwq1.zza(azzd[k]);
                    zzaIf = azzd;
                    break;
                }
            } while (true);
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            if (name != null)
            {
                zzwr1.zzb(1, name);
            }
            if (zzaIf != null && zzaIf.length > 0)
            {
                for (int i = 0; i < zzaIf.length; i++)
                {
                    zzd zzd1 = zzaIf[i];
                    if (zzd1 != null)
                    {
                        zzwr1.zza(2, zzd1);
                    }
                }

            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzC(zzwq1);
        }

        protected int zzc()
        {
            int j = super.zzc();
            int i = j;
            if (name != null)
            {
                i = j + zzwr.zzj(1, name);
            }
            j = i;
            if (zzaIf != null)
            {
                j = i;
                if (zzaIf.length > 0)
                {
                    for (j = 0; j < zzaIf.length;)
                    {
                        zzd zzd1 = zzaIf[j];
                        int k = i;
                        if (zzd1 != null)
                        {
                            k = i + zzwr.zzc(2, zzd1);
                        }
                        j++;
                        i = k;
                    }

                    j = i;
                }
            }
            return j;
        }

        public zzc zzwc()
        {
            name = null;
            zzaIf = zzd.zzwd();
            zzaHM = -1;
            return this;
        }

        public zzc()
        {
            zzwc();
        }
    }

    public static final class zzd extends zzwy
    {

        private static volatile zzd zzaIg[];
        public String name;
        public Integer zzaIh;
        public Boolean zzaIi;

        public static zzd[] zzwd()
        {
            if (zzaIg == null)
            {
                synchronized (zzww.zzaHL)
                {
                    if (zzaIg == null)
                    {
                        zzaIg = new zzd[0];
                    }
                }
            }
            return zzaIg;
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
            if (!(obj instanceof zzd))
            {
                return false;
            }
            obj = (zzd)obj;
            if (name == null)
            {
                if (((zzd) (obj)).name != null)
                {
                    return false;
                }
            } else
            if (!name.equals(((zzd) (obj)).name))
            {
                return false;
            }
            if (zzaIh == null)
            {
                if (((zzd) (obj)).zzaIh != null)
                {
                    return false;
                }
            } else
            if (!zzaIh.equals(((zzd) (obj)).zzaIh))
            {
                return false;
            }
            if (zzaIi != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((zzd) (obj)).zzaIi == null) goto _L1; else goto _L3
_L3:
            return false;
            if (zzaIi.equals(((zzd) (obj)).zzaIi)) goto _L1; else goto _L4
_L4:
            return false;
        }

        public int hashCode()
        {
            int k = 0;
            int i;
            int j;
            if (name == null)
            {
                i = 0;
            } else
            {
                i = name.hashCode();
            }
            if (zzaIh == null)
            {
                j = 0;
            } else
            {
                j = zzaIh.intValue();
            }
            if (zzaIi != null)
            {
                k = zzaIi.hashCode();
            }
            return (j + (i + 527) * 31) * 31 + k;
        }

        public zzd zzD(zzwq zzwq1)
            throws IOException
        {
_L6:
            int i = zzwq1.zzvu();
            i;
            JVM INSTR lookupswitch 4: default 48
        //                       0: 56
        //                       10: 58
        //                       24: 69
        //                       32: 110;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            if (zzxb.zzb(zzwq1, i)) goto _L6; else goto _L2
_L2:
            return this;
_L3:
            name = zzwq1.readString();
              goto _L6
_L4:
            int j = zzwq1.zzvx();
            switch (j)
            {
            case 1: // '\001'
            case 2: // '\002'
                zzaIh = Integer.valueOf(j);
                break;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            zzaIi = Boolean.valueOf(zzwq1.zzvy());
            if (true) goto _L6; else goto _L7
_L7:
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            if (name != null)
            {
                zzwr1.zzb(1, name);
            }
            if (zzaIh != null)
            {
                zzwr1.zzy(3, zzaIh.intValue());
            }
            if (zzaIi != null)
            {
                zzwr1.zzb(4, zzaIi.booleanValue());
            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzD(zzwq1);
        }

        protected int zzc()
        {
            int j = super.zzc();
            int i = j;
            if (name != null)
            {
                i = j + zzwr.zzj(1, name);
            }
            j = i;
            if (zzaIh != null)
            {
                j = i + zzwr.zzA(3, zzaIh.intValue());
            }
            i = j;
            if (zzaIi != null)
            {
                i = j + zzwr.zzc(4, zzaIi.booleanValue());
            }
            return i;
        }

        public zzd zzwe()
        {
            name = null;
            zzaIh = null;
            zzaIi = null;
            zzaHM = -1;
            return this;
        }

        public zzd()
        {
            zzwe();
        }
    }

    public static final class zze extends zzwy
    {

        public String version;
        public Integer zzaIb;
        public String zzaIj;
        public String zzaIk;
        public String zzaIl;
        public Integer zzaIm;

        public boolean equals(Object obj)
        {
            if (obj != this) goto _L2; else goto _L1
_L1:
            return true;
_L2:
            if (!(obj instanceof zze))
            {
                return false;
            }
            obj = (zze)obj;
            if (zzaIj == null)
            {
                if (((zze) (obj)).zzaIj != null)
                {
                    return false;
                }
            } else
            if (!zzaIj.equals(((zze) (obj)).zzaIj))
            {
                return false;
            }
            if (zzaIb == null)
            {
                if (((zze) (obj)).zzaIb != null)
                {
                    return false;
                }
            } else
            if (!zzaIb.equals(((zze) (obj)).zzaIb))
            {
                return false;
            }
            if (version == null)
            {
                if (((zze) (obj)).version != null)
                {
                    return false;
                }
            } else
            if (!version.equals(((zze) (obj)).version))
            {
                return false;
            }
            if (zzaIk == null)
            {
                if (((zze) (obj)).zzaIk != null)
                {
                    return false;
                }
            } else
            if (!zzaIk.equals(((zze) (obj)).zzaIk))
            {
                return false;
            }
            if (zzaIl == null)
            {
                if (((zze) (obj)).zzaIl != null)
                {
                    return false;
                }
            } else
            if (!zzaIl.equals(((zze) (obj)).zzaIl))
            {
                return false;
            }
            if (zzaIm != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((zze) (obj)).zzaIm == null) goto _L1; else goto _L3
_L3:
            return false;
            if (zzaIm.equals(((zze) (obj)).zzaIm)) goto _L1; else goto _L4
_L4:
            return false;
        }

        public int hashCode()
        {
            int j1 = 0;
            int i;
            int j;
            int k;
            int l;
            int i1;
            if (zzaIj == null)
            {
                i = 0;
            } else
            {
                i = zzaIj.hashCode();
            }
            if (zzaIb == null)
            {
                j = 0;
            } else
            {
                j = zzaIb.intValue();
            }
            if (version == null)
            {
                k = 0;
            } else
            {
                k = version.hashCode();
            }
            if (zzaIk == null)
            {
                l = 0;
            } else
            {
                l = zzaIk.hashCode();
            }
            if (zzaIl == null)
            {
                i1 = 0;
            } else
            {
                i1 = zzaIl.hashCode();
            }
            if (zzaIm != null)
            {
                j1 = zzaIm.intValue();
            }
            return (i1 + (l + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + j1;
        }

        public zze zzE(zzwq zzwq1)
            throws IOException
        {
_L9:
            int i = zzwq1.zzvu();
            i;
            JVM INSTR lookupswitch 7: default 72
        //                       0: 80
        //                       10: 82
        //                       16: 93
        //                       26: 150
        //                       34: 161
        //                       42: 172
        //                       48: 183;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
            if (zzxb.zzb(zzwq1, i)) goto _L9; else goto _L2
_L2:
            return this;
_L3:
            zzaIj = zzwq1.readString();
              goto _L9
_L4:
            int j = zzwq1.zzvx();
            switch (j)
            {
            case 0: // '\0'
            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
                zzaIb = Integer.valueOf(j);
                break;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            version = zzwq1.readString();
            continue; /* Loop/switch isn't completed */
_L6:
            zzaIk = zzwq1.readString();
            continue; /* Loop/switch isn't completed */
_L7:
            zzaIl = zzwq1.readString();
            continue; /* Loop/switch isn't completed */
_L8:
            int k = zzwq1.zzvx();
            switch (k)
            {
            case 0: // '\0'
            case 1: // '\001'
            case 2: // '\002'
                zzaIm = Integer.valueOf(k);
                break;
            }
            if (true) goto _L9; else goto _L10
_L10:
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            if (zzaIj != null)
            {
                zzwr1.zzb(1, zzaIj);
            }
            if (zzaIb != null)
            {
                zzwr1.zzy(2, zzaIb.intValue());
            }
            if (version != null)
            {
                zzwr1.zzb(3, version);
            }
            if (zzaIk != null)
            {
                zzwr1.zzb(4, zzaIk);
            }
            if (zzaIl != null)
            {
                zzwr1.zzb(5, zzaIl);
            }
            if (zzaIm != null)
            {
                zzwr1.zzy(6, zzaIm.intValue());
            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzE(zzwq1);
        }

        protected int zzc()
        {
            int j = super.zzc();
            int i = j;
            if (zzaIj != null)
            {
                i = j + zzwr.zzj(1, zzaIj);
            }
            j = i;
            if (zzaIb != null)
            {
                j = i + zzwr.zzA(2, zzaIb.intValue());
            }
            i = j;
            if (version != null)
            {
                i = j + zzwr.zzj(3, version);
            }
            j = i;
            if (zzaIk != null)
            {
                j = i + zzwr.zzj(4, zzaIk);
            }
            i = j;
            if (zzaIl != null)
            {
                i = j + zzwr.zzj(5, zzaIl);
            }
            j = i;
            if (zzaIm != null)
            {
                j = i + zzwr.zzA(6, zzaIm.intValue());
            }
            return j;
        }

        public zze zzwf()
        {
            zzaIj = null;
            zzaIb = null;
            version = null;
            zzaIk = null;
            zzaIl = null;
            zzaIm = null;
            zzaHM = -1;
            return this;
        }

        public zze()
        {
            zzwf();
        }
    }

    public static final class zzf extends zzwy
    {

        private static volatile zzf zzaIn[];
        public Integer zzaIo;
        public Double zzaIp;

        public static zzf[] zzwg()
        {
            if (zzaIn == null)
            {
                synchronized (zzww.zzaHL)
                {
                    if (zzaIn == null)
                    {
                        zzaIn = new zzf[0];
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
            if (!(obj instanceof zzf))
            {
                return false;
            }
            obj = (zzf)obj;
            if (zzaIo == null)
            {
                if (((zzf) (obj)).zzaIo != null)
                {
                    return false;
                }
            } else
            if (!zzaIo.equals(((zzf) (obj)).zzaIo))
            {
                return false;
            }
            if (zzaIp != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((zzf) (obj)).zzaIp == null) goto _L1; else goto _L3
_L3:
            return false;
            if (zzaIp.equals(((zzf) (obj)).zzaIp)) goto _L1; else goto _L4
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

        public zzf zzF(zzwq zzwq1)
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

        public zzf zzwh()
        {
            zzaIo = null;
            zzaIp = null;
            zzaHM = -1;
            return this;
        }

        public zzf()
        {
            zzwh();
        }
    }

}
