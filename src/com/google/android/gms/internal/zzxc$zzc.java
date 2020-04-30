// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwy, zzxc, zzww, zzwq, 
//            zzxb, zzwr

public static final class zzwc extends zzwy
{

    public String name;
    public zzaHM zzaIf[];

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzwc))
            {
                return false;
            }
            obj = (zzwc)obj;
            if (name == null)
            {
                if (((name) (obj)).name != null)
                {
                    return false;
                }
            } else
            if (!name.equals(((name) (obj)).name))
            {
                return false;
            }
            if (!zzww.equals(zzaIf, ((zzaIf) (obj)).zzaIf))
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

    public zzaIf zzC(zzwq zzwq1)
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
                zzaIf azzaif[];
                int j;
                if (zzaIf == null)
                {
                    j = 0;
                } else
                {
                    j = zzaIf.length;
                }
                azzaif = new zzaIf[k + j];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zzaIf, 0, azzaif, 0, j);
                    k = j;
                }
                for (; k < azzaif.length - 1; k++)
                {
                    azzaif[k] = new <init>();
                    zzwq1.zza(azzaif[k]);
                    zzwq1.zzvu();
                }

                azzaif[k] = new <init>();
                zzwq1.zza(azzaif[k]);
                zzaIf = azzaif;
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
                zzaIf zzaif = zzaIf[i];
                if (zzaif != null)
                {
                    zzwr1.zza(2, zzaif);
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
                    zzC zzc1 = zzaIf[j];
                    int k = i;
                    if (zzc1 != null)
                    {
                        k = i + zzwr.zzc(2, zzc1);
                    }
                    j++;
                    i = k;
                }

                j = i;
            }
        }
        return j;
    }

    public zzaIf zzwc()
    {
        name = null;
        zzaIf = zzwd();
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzwc();
    }
}
