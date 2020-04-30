// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzop, zzww, zzwr, 
//            zzwq, zzxb, zzwy

public static final class zzpf extends zzws
{
    public static final class zza extends zzws
    {

        private static volatile zza zzalf[];
        public int viewId;
        public String zzalg;
        public String zzalh;

        public static zza[] zzpg()
        {
            if (zzalf == null)
            {
                synchronized (zzww.zzaHL)
                {
                    if (zzalf == null)
                    {
                        zzalf = new zza[0];
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
            if (!(obj instanceof zza)) goto _L4; else goto _L3
_L3:
            obj = (zza)obj;
            if (zzalg != null) goto _L6; else goto _L5
_L5:
            flag = flag1;
            if (((zza) (obj)).zzalg != null) goto _L4; else goto _L7
_L7:
            if (zzalh != null)
            {
                break MISSING_BLOCK_LABEL_92;
            }
            flag = flag1;
            if (((zza) (obj)).zzalh != null) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (viewId == ((zza) (obj)).viewId)
            {
                return zza(((zzws) (obj)));
            }
              goto _L4
_L6:
            if (!zzalg.equals(((zza) (obj)).zzalg))
            {
                return false;
            }
              goto _L7
            if (!zzalh.equals(((zza) (obj)).zzalh))
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

        public zza zzp(zzwq zzwq1)
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

        public zza zzph()
        {
            zzalg = "";
            zzalh = "";
            viewId = 0;
            zzaHB = null;
            zzaHM = -1;
            return this;
        }

        public zza()
        {
            zzph();
        }
    }


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
                if (zzww.equals(zzale, ((zzale) (obj)).zzale))
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

    public zzale zzo(zzwq zzwq1)
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

    public zzale zzpf()
    {
        zzale = zza.zzpg();
        zzaHB = null;
        zzaHM = -1;
        return this;
    }

    public zza.zzph()
    {
        zzpf();
    }
}
