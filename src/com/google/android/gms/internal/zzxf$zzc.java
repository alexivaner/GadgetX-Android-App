// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzxf, zzww, zzwq, 
//            zzxb, zzwr, zzwy

public static final class zzwq extends zzws
{

    public byte zzaIU[];
    public byte zzaIV[][];
    public boolean zzaIW;

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
            if (obj instanceof zzwq)
            {
                obj = (zzwq)obj;
                flag = flag1;
                if (Arrays.equals(zzaIU, ((zzaIU) (obj)).zzaIU))
                {
                    flag = flag1;
                    if (zzww.zza(zzaIV, ((zzaIV) (obj)).zzaIV))
                    {
                        flag = flag1;
                        if (zzaIW == ((zzaIW) (obj)).zzaIW)
                        {
                            return zza(((zzws) (obj)));
                        }
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        int i = Arrays.hashCode(zzaIU);
        int j = zzww.zza(zzaIV);
        char c;
        if (zzaIW)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        return (c + ((i + 527) * 31 + j) * 31) * 31 + zzvL();
    }

    public zzvL zzM(zzwq zzwq1)
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
                zzaIU = zzwq1.readBytes();
                break;

            case 18: // '\022'
                int k = zzxb.zzc(zzwq1, 18);
                byte abyte0[][];
                int j;
                if (zzaIV == null)
                {
                    j = 0;
                } else
                {
                    j = zzaIV.length;
                }
                abyte0 = new byte[k + j][];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zzaIV, 0, abyte0, 0, j);
                    k = j;
                }
                for (; k < abyte0.length - 1; k++)
                {
                    abyte0[k] = zzwq1.readBytes();
                    zzwq1.zzvu();
                }

                abyte0[k] = zzwq1.readBytes();
                zzaIV = abyte0;
                break;

            case 24: // '\030'
                zzaIW = zzwq1.zzvy();
                break;
            }
        } while (true);
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        if (!Arrays.equals(zzaIU, zzxb.zzaHV))
        {
            zzwr1.zza(1, zzaIU);
        }
        if (zzaIV != null && zzaIV.length > 0)
        {
            for (int i = 0; i < zzaIV.length; i++)
            {
                byte abyte0[] = zzaIV[i];
                if (abyte0 != null)
                {
                    zzwr1.zza(2, abyte0);
                }
            }

        }
        if (zzaIW)
        {
            zzwr1.zzb(3, zzaIW);
        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzM(zzwq1);
    }

    protected int zzc()
    {
        boolean flag = false;
        int j = super.zzc();
        int i = j;
        if (!Arrays.equals(zzaIU, zzxb.zzaHV))
        {
            i = j + zzwr.zzb(1, zzaIU);
        }
        j = i;
        if (zzaIV != null)
        {
            j = i;
            if (zzaIV.length > 0)
            {
                int k = 0;
                int l = 0;
                for (j = ((flag) ? 1 : 0); j < zzaIV.length;)
                {
                    byte abyte0[] = zzaIV[j];
                    int j1 = k;
                    int i1 = l;
                    if (abyte0 != null)
                    {
                        i1 = l + 1;
                        j1 = k + zzwr.zzw(abyte0);
                    }
                    j++;
                    k = j1;
                    l = i1;
                }

                j = i + k + l * 1;
            }
        }
        i = j;
        if (zzaIW)
        {
            i = j + zzwr.zzc(3, zzaIW);
        }
        return i;
    }

    public zzaIW zzwq()
    {
        zzaIU = zzxb.zzaHV;
        zzaIV = zzxb.zzaHU;
        zzaIW = false;
        zzaHB = null;
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzwq();
    }
}
