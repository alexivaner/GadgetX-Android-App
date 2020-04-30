// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzop, zzww, zzwr, 
//            zzwq, zzxb, zzwy

public static final class zzpk extends zzws
{

    public String type;
    public zzalk zzalk[];

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
        if (!(obj instanceof zzpk))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (zzpk)obj;
        if (type != null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((type) (obj)).type != null)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        flag = flag1;
        if (zzww.equals(zzalk, ((zzalk) (obj)).zzalk))
        {
            return zza(((zzws) (obj)));
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!type.equals(((type) (obj)).type))
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
                zzvL zzvl = zzalk[i];
                if (zzvl != null)
                {
                    zzwr1.zza(2, zzvl);
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
                    zzr zzr1 = zzalk[j];
                    int k = i;
                    if (zzr1 != null)
                    {
                        k = i + zzwr.zzc(2, zzr1);
                    }
                    j++;
                    i = k;
                }

                j = i;
            }
        }
        return j;
    }

    public zzalk zzpk()
    {
        type = "";
        zzalk = zzpi();
        zzaHB = null;
        zzaHM = -1;
        return this;
    }

    public zzaHM zzr(zzwq zzwq1)
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
                zzaHM azzahm[];
                int j;
                if (zzalk == null)
                {
                    j = 0;
                } else
                {
                    j = zzalk.length;
                }
                azzahm = new zzalk[k + j];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zzalk, 0, azzahm, 0, j);
                    k = j;
                }
                for (; k < azzahm.length - 1; k++)
                {
                    azzahm[k] = new <init>();
                    zzwq1.zza(azzahm[k]);
                    zzwq1.zzvu();
                }

                azzahm[k] = new <init>();
                zzwq1.zza(azzahm[k]);
                zzalk = azzahm;
                break;
            }
        } while (true);
    }

    public ()
    {
        zzpk();
    }
}
