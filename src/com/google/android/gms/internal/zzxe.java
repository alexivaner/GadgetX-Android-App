// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwy, zzwq, zzxb, zzwr

public interface zzxe
{
    public static final class zza extends zzwy
    {

        public String description;
        public String name;
        public Long zzaIL;
        public Long zzaIM;
        public Long zzaIN;
        public Integer zzaIO;
        public zzxc.zza zzaIe;
        public String zzfl;

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
            if (zzfl == null)
            {
                if (((zza) (obj)).zzfl != null)
                {
                    return false;
                }
            } else
            if (!zzfl.equals(((zza) (obj)).zzfl))
            {
                return false;
            }
            if (name == null)
            {
                if (((zza) (obj)).name != null)
                {
                    return false;
                }
            } else
            if (!name.equals(((zza) (obj)).name))
            {
                return false;
            }
            if (description == null)
            {
                if (((zza) (obj)).description != null)
                {
                    return false;
                }
            } else
            if (!description.equals(((zza) (obj)).description))
            {
                return false;
            }
            if (zzaIL == null)
            {
                if (((zza) (obj)).zzaIL != null)
                {
                    return false;
                }
            } else
            if (!zzaIL.equals(((zza) (obj)).zzaIL))
            {
                return false;
            }
            if (zzaIM == null)
            {
                if (((zza) (obj)).zzaIM != null)
                {
                    return false;
                }
            } else
            if (!zzaIM.equals(((zza) (obj)).zzaIM))
            {
                return false;
            }
            if (zzaIN == null)
            {
                if (((zza) (obj)).zzaIN != null)
                {
                    return false;
                }
            } else
            if (!zzaIN.equals(((zza) (obj)).zzaIN))
            {
                return false;
            }
            if (zzaIe == null)
            {
                if (((zza) (obj)).zzaIe != null)
                {
                    return false;
                }
            } else
            if (!zzaIe.equals(((zza) (obj)).zzaIe))
            {
                return false;
            }
            if (zzaIO != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((zza) (obj)).zzaIO == null) goto _L1; else goto _L3
_L3:
            return false;
            if (zzaIO.equals(((zza) (obj)).zzaIO)) goto _L1; else goto _L4
_L4:
            return false;
        }

        public int hashCode()
        {
            int l1 = 0;
            int i;
            int j;
            int k;
            int l;
            int i1;
            int j1;
            int k1;
            if (zzfl == null)
            {
                i = 0;
            } else
            {
                i = zzfl.hashCode();
            }
            if (name == null)
            {
                j = 0;
            } else
            {
                j = name.hashCode();
            }
            if (description == null)
            {
                k = 0;
            } else
            {
                k = description.hashCode();
            }
            if (zzaIL == null)
            {
                l = 0;
            } else
            {
                l = zzaIL.hashCode();
            }
            if (zzaIM == null)
            {
                i1 = 0;
            } else
            {
                i1 = zzaIM.hashCode();
            }
            if (zzaIN == null)
            {
                j1 = 0;
            } else
            {
                j1 = zzaIN.hashCode();
            }
            if (zzaIe == null)
            {
                k1 = 0;
            } else
            {
                k1 = zzaIe.hashCode();
            }
            if (zzaIO != null)
            {
                l1 = zzaIO.hashCode();
            }
            return (k1 + (j1 + (i1 + (l + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l1;
        }

        public zza zzJ(zzwq zzwq1)
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
                    zzfl = zzwq1.readString();
                    break;

                case 18: // '\022'
                    name = zzwq1.readString();
                    break;

                case 26: // '\032'
                    description = zzwq1.readString();
                    break;

                case 32: // ' '
                    zzaIL = Long.valueOf(zzwq1.zzvw());
                    break;

                case 40: // '('
                    zzaIM = Long.valueOf(zzwq1.zzvw());
                    break;

                case 64: // '@'
                    zzaIN = Long.valueOf(zzwq1.zzvw());
                    break;

                case 74: // 'J'
                    if (zzaIe == null)
                    {
                        zzaIe = new zzxc.zza();
                    }
                    zzwq1.zza(zzaIe);
                    break;

                case 80: // 'P'
                    zzaIO = Integer.valueOf(zzwq1.zzvx());
                    break;
                }
            } while (true);
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            if (zzfl != null)
            {
                zzwr1.zzb(1, zzfl);
            }
            if (name != null)
            {
                zzwr1.zzb(2, name);
            }
            if (description != null)
            {
                zzwr1.zzb(3, description);
            }
            if (zzaIL != null)
            {
                zzwr1.zzb(4, zzaIL.longValue());
            }
            if (zzaIM != null)
            {
                zzwr1.zzb(5, zzaIM.longValue());
            }
            if (zzaIN != null)
            {
                zzwr1.zzb(8, zzaIN.longValue());
            }
            if (zzaIe != null)
            {
                zzwr1.zza(9, zzaIe);
            }
            if (zzaIO != null)
            {
                zzwr1.zzy(10, zzaIO.intValue());
            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzJ(zzwq1);
        }

        protected int zzc()
        {
            int j = super.zzc();
            int i = j;
            if (zzfl != null)
            {
                i = j + zzwr.zzj(1, zzfl);
            }
            j = i;
            if (name != null)
            {
                j = i + zzwr.zzj(2, name);
            }
            i = j;
            if (description != null)
            {
                i = j + zzwr.zzj(3, description);
            }
            j = i;
            if (zzaIL != null)
            {
                j = i + zzwr.zzd(4, zzaIL.longValue());
            }
            i = j;
            if (zzaIM != null)
            {
                i = j + zzwr.zzd(5, zzaIM.longValue());
            }
            j = i;
            if (zzaIN != null)
            {
                j = i + zzwr.zzd(8, zzaIN.longValue());
            }
            i = j;
            if (zzaIe != null)
            {
                i = j + zzwr.zzc(9, zzaIe);
            }
            j = i;
            if (zzaIO != null)
            {
                j = i + zzwr.zzA(10, zzaIO.intValue());
            }
            return j;
        }

        public zza zzwn()
        {
            zzfl = null;
            name = null;
            description = null;
            zzaIL = null;
            zzaIM = null;
            zzaIN = null;
            zzaIe = null;
            zzaIO = null;
            zzaHM = -1;
            return this;
        }

        public zza()
        {
            zzwn();
        }
    }

}
