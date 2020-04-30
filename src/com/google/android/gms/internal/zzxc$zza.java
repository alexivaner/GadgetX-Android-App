// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwy, zzxc, zzww, zzwq, 
//            zzxb, zzwr

public static final class zzvZ extends zzwy
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
        if (!(obj instanceof zzvZ))
        {
            return false;
        }
        obj = (zzvZ)obj;
        if (packageName == null)
        {
            if (((packageName) (obj)).packageName != null)
            {
                return false;
            }
        } else
        if (!packageName.equals(((packageName) (obj)).packageName))
        {
            return false;
        }
        if (version == null)
        {
            if (((version) (obj)).version != null)
            {
                return false;
            }
        } else
        if (!version.equals(((version) (obj)).version))
        {
            return false;
        }
        if (zzaHW == null)
        {
            if (((zzaHW) (obj)).zzaHW != null)
            {
                return false;
            }
        } else
        if (!zzaHW.equals(((zzaHW) (obj)).zzaHW))
        {
            return false;
        }
        if (!zzww.equals(zzaHX, ((zzaHX) (obj)).zzaHX))
        {
            return false;
        }
        if (name != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((name) (obj)).name == null) goto _L1; else goto _L3
_L3:
        return false;
        if (name.equals(((name) (obj)).name)) goto _L1; else goto _L4
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

    public name zzA(zzwq zzwq1)
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

    public name zzvZ()
    {
        packageName = null;
        version = null;
        zzaHW = null;
        zzaHX = zzxb.zzaHP;
        name = null;
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzvZ();
    }
}
