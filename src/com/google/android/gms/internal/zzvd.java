// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzwx, zzwy, zzwr, 
//            zzwq

public interface zzvd
{
    public static final class zza extends zzws
    {

        public long zzaBK;
        public zzc.zzj zzaBL;
        public zzc.zzf zzgs;

        public static zza zzm(byte abyte0[])
            throws zzwx
        {
            return (zza)zzwy.zza(new zza(), abyte0);
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
            flag = flag1;
            if (zzaBK != ((zza) (obj)).zzaBK) goto _L4; else goto _L5
_L5:
            if (zzgs != null) goto _L7; else goto _L6
_L6:
            flag = flag1;
            if (((zza) (obj)).zzgs != null) goto _L4; else goto _L8
_L8:
            if (zzaBL != null)
            {
                break MISSING_BLOCK_LABEL_93;
            }
            flag = flag1;
            if (((zza) (obj)).zzaBL != null) goto _L4; else goto _L9
_L9:
            return zza(((zzws) (obj)));
_L7:
            if (!zzgs.equals(((zza) (obj)).zzgs))
            {
                return false;
            }
              goto _L8
            if (!zzaBL.equals(((zza) (obj)).zzaBL))
            {
                return false;
            }
              goto _L9
        }

        public int hashCode()
        {
            int j = 0;
            int k = (int)(zzaBK ^ zzaBK >>> 32);
            int i;
            if (zzgs == null)
            {
                i = 0;
            } else
            {
                i = zzgs.hashCode();
            }
            if (zzaBL != null)
            {
                j = zzaBL.hashCode();
            }
            return ((i + (k + 527) * 31) * 31 + j) * 31 + zzvL();
        }

        public void zza(zzwr zzwr1)
            throws IOException
        {
            zzwr1.zzb(1, zzaBK);
            if (zzgs != null)
            {
                zzwr1.zza(2, zzgs);
            }
            if (zzaBL != null)
            {
                zzwr1.zza(3, zzaBL);
            }
            super.zza(zzwr1);
        }

        public zzwy zzb(zzwq zzwq1)
            throws IOException
        {
            return zzt(zzwq1);
        }

        protected int zzc()
        {
            int j = super.zzc() + zzwr.zzd(1, zzaBK);
            int i = j;
            if (zzgs != null)
            {
                i = j + zzwr.zzc(2, zzgs);
            }
            j = i;
            if (zzaBL != null)
            {
                j = i + zzwr.zzc(3, zzaBL);
            }
            return j;
        }

        public zza zzt(zzwq zzwq1)
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
                    zzaBK = zzwq1.zzvw();
                    break;

                case 18: // '\022'
                    if (zzgs == null)
                    {
                        zzgs = new zzc.zzf();
                    }
                    zzwq1.zza(zzgs);
                    break;

                case 26: // '\032'
                    if (zzaBL == null)
                    {
                        zzaBL = new zzc.zzj();
                    }
                    zzwq1.zza(zzaBL);
                    break;
                }
            } while (true);
        }

        public zza zzug()
        {
            zzaBK = 0L;
            zzgs = null;
            zzaBL = null;
            zzaHB = null;
            zzaHM = -1;
            return this;
        }

        public zza()
        {
            zzug();
        }
    }

}
