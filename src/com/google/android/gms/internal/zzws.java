// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwy, zzwt, zzxb, zzwu, 
//            zzwv, zzwq, zzxa, zzww, 
//            zzwr

public abstract class zzws extends zzwy
{

    protected zzwu zzaHB;

    public zzws()
    {
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return zzvM();
    }

    public final Object zza(zzwt zzwt1)
    {
        zzwv zzwv1;
        if (zzaHB != null)
        {
            if ((zzwv1 = zzaHB.zziE(zzxb.zziI(zzwt1.tag))) != null)
            {
                return zzwv1.zzb(zzwt1);
            }
        }
        return null;
    }

    public void zza(zzwr zzwr)
        throws IOException
    {
        if (zzaHB != null)
        {
            int i = 0;
            while (i < zzaHB.size()) 
            {
                zzaHB.zziF(i).zza(zzwr);
                i++;
            }
        }
    }

    protected final boolean zza(zzwq zzwq1, int i)
        throws IOException
    {
        int j = zzwq1.getPosition();
        if (!zzwq1.zzin(i))
        {
            return false;
        }
        int k = zzxb.zziI(i);
        zzxa zzxa1 = new zzxa(i, zzwq1.zzx(j, zzwq1.getPosition() - j));
        zzwq1 = null;
        Object obj;
        if (zzaHB == null)
        {
            zzaHB = new zzwu();
        } else
        {
            zzwq1 = zzaHB.zziE(k);
        }
        obj = zzwq1;
        if (zzwq1 == null)
        {
            obj = new zzwv();
            zzaHB.zza(k, ((zzwv) (obj)));
        }
        ((zzwv) (obj)).zza(zzxa1);
        return true;
    }

    protected final boolean zza(zzws zzws1)
    {
        if (zzaHB == null || zzaHB.isEmpty())
        {
            return zzws1.zzaHB == null || zzws1.zzaHB.isEmpty();
        } else
        {
            return zzaHB.equals(zzws1.zzaHB);
        }
    }

    protected int zzc()
    {
        int j = 0;
        int k;
        if (zzaHB != null)
        {
            int i = 0;
            do
            {
                k = i;
                if (j >= zzaHB.size())
                {
                    break;
                }
                i += zzaHB.zziF(j).zzc();
                j++;
            } while (true);
        } else
        {
            k = 0;
        }
        return k;
    }

    protected final int zzvL()
    {
        if (zzaHB == null || zzaHB.isEmpty())
        {
            return 0;
        } else
        {
            return zzaHB.hashCode();
        }
    }

    public zzws zzvM()
        throws CloneNotSupportedException
    {
        zzws zzws1 = (zzws)super.zzvN();
        zzww.zza(this, zzws1);
        return zzws1;
    }

    public zzwy zzvN()
        throws CloneNotSupportedException
    {
        return zzvM();
    }
}
