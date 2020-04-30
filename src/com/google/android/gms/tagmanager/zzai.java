// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzde, DataLayer, zzbf

class zzai
{

    private static void zza(DataLayer datalayer, com.google.android.gms.internal.zzc.zzd zzd)
    {
        zzd = zzd.zzfB;
        int j = zzd.length;
        for (int i = 0; i < j; i++)
        {
            datalayer.zzcU(zzde.zzg(zzd[i]));
        }

    }

    public static void zza(DataLayer datalayer, com.google.android.gms.internal.zzc.zzi zzi)
    {
        if (zzi.zzgq == null)
        {
            zzbf.zzac("supplemental missing experimentSupplemental");
            return;
        } else
        {
            zza(datalayer, zzi.zzgq);
            zzb(datalayer, zzi.zzgq);
            zzc(datalayer, zzi.zzgq);
            return;
        }
    }

    private static void zzb(DataLayer datalayer, com.google.android.gms.internal.zzc.zzd zzd)
    {
        zzd = zzd.zzfA;
        int j = zzd.length;
        for (int i = 0; i < j; i++)
        {
            Map map = zzc(zzd[i]);
            if (map != null)
            {
                datalayer.push(map);
            }
        }

    }

    private static Map zzc(com.google.android.gms.internal.zzd.zza zza1)
    {
        zza1 = ((com.google.android.gms.internal.zzd.zza) (zzde.zzl(zza1)));
        if (!(zza1 instanceof Map))
        {
            zzbf.zzac((new StringBuilder()).append("value: ").append(zza1).append(" is not a map value, ignored.").toString());
            return null;
        } else
        {
            return (Map)zza1;
        }
    }

    private static void zzc(DataLayer datalayer, com.google.android.gms.internal.zzc.zzd zzd)
    {
        com.google.android.gms.internal.zzc.zzc azzc[];
        int i;
        int j;
        azzc = zzd.zzfC;
        j = azzc.length;
        i = 0;
_L2:
        com.google.android.gms.internal.zzc.zzc zzc1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        zzc1 = azzc[i];
        if (zzc1.zzfv != null)
        {
            break; /* Loop/switch isn't completed */
        }
        zzbf.zzac("GaExperimentRandom: No key");
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
label0:
        {
            Object obj = datalayer.get(zzc1.zzfv);
            long l;
            long l1;
            if (!(obj instanceof Number))
            {
                zzd = null;
            } else
            {
                zzd = Long.valueOf(((Number)obj).longValue());
            }
            l = zzc1.zzfw;
            l1 = zzc1.zzfx;
            if (!zzc1.zzfy || zzd == null || zzd.longValue() < l || zzd.longValue() > l1)
            {
                if (l > l1)
                {
                    break label0;
                }
                obj = Long.valueOf(Math.round(Math.random() * (double)(l1 - l) + (double)l));
            }
            datalayer.zzcU(zzc1.zzfv);
            zzd = datalayer.zzc(zzc1.zzfv, obj);
            if (zzc1.zzfz > 0L)
            {
                if (!zzd.containsKey("gtm"))
                {
                    zzd.put("gtm", DataLayer.mapOf(new Object[] {
                        "lifetime", Long.valueOf(zzc1.zzfz)
                    }));
                } else
                {
                    Object obj1 = zzd.get("gtm");
                    if (obj1 instanceof Map)
                    {
                        ((Map)obj1).put("lifetime", Long.valueOf(zzc1.zzfz));
                    } else
                    {
                        zzbf.zzac("GaExperimentRandom: gtm not a map");
                    }
                }
            }
            datalayer.push(zzd);
        }
          goto _L3
        zzbf.zzac("GaExperimentRandom: random range invalid");
          goto _L3
          goto _L3
    }
}
