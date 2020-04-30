// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            zzws, zzxf, zzww, zzwq, 
//            zzxb, zzwr, zzwy

public static final class zzwr extends zzws
{

    public String tag;
    public long zzaIX;
    public int zzaIY;
    public int zzaIZ;
    public boolean zzaJa;
    public zzaHM zzaJb[];
    public zzaHM zzaJc;
    public byte zzaJd[];
    public byte zzaJe[];
    public byte zzaJf[];
    public zzaHM zzaJg;
    public String zzaJh;
    public long zzaJi;
    public zzaHM zzaJj;

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
        if (!(obj instanceof zzwr)) goto _L4; else goto _L3
_L3:
        obj = (zzwr)obj;
        flag = flag1;
        if (zzaIX != ((zzaIX) (obj)).zzaIX) goto _L4; else goto _L5
_L5:
        if (tag != null) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (((tag) (obj)).tag != null) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (zzaIY != ((zzaIY) (obj)).zzaIY) goto _L4; else goto _L9
_L9:
        flag = flag1;
        if (zzaIZ != ((zzaIZ) (obj)).zzaIZ) goto _L4; else goto _L10
_L10:
        flag = flag1;
        if (zzaJa != ((zzaJa) (obj)).zzaJa) goto _L4; else goto _L11
_L11:
        flag = flag1;
        if (!zzww.equals(zzaJb, ((zzaJb) (obj)).zzaJb)) goto _L4; else goto _L12
_L12:
        if (zzaJc != null) goto _L14; else goto _L13
_L13:
        flag = flag1;
        if (((zzaJc) (obj)).zzaJc != null) goto _L4; else goto _L15
_L15:
        flag = flag1;
        if (!Arrays.equals(zzaJd, ((zzaJd) (obj)).zzaJd)) goto _L4; else goto _L16
_L16:
        flag = flag1;
        if (!Arrays.equals(zzaJe, ((zzaJe) (obj)).zzaJe)) goto _L4; else goto _L17
_L17:
        flag = flag1;
        if (!Arrays.equals(zzaJf, ((zzaJf) (obj)).zzaJf)) goto _L4; else goto _L18
_L18:
        if (zzaJg != null) goto _L20; else goto _L19
_L19:
        flag = flag1;
        if (((zzaJg) (obj)).zzaJg != null) goto _L4; else goto _L21
_L21:
        if (zzaJh != null) goto _L23; else goto _L22
_L22:
        flag = flag1;
        if (((zzaJh) (obj)).zzaJh != null) goto _L4; else goto _L24
_L24:
        flag = flag1;
        if (zzaJi != ((zzaJi) (obj)).zzaJi) goto _L4; else goto _L25
_L25:
        if (zzaJj != null)
        {
            break MISSING_BLOCK_LABEL_306;
        }
        flag = flag1;
        if (((zzaJj) (obj)).zzaJj != null) goto _L4; else goto _L26
_L26:
        return zza(((zzws) (obj)));
_L7:
        if (!tag.equals(((tag) (obj)).tag))
        {
            return false;
        }
          goto _L8
_L14:
        if (!zzaJc.equals(((equals) (obj)).zzaJc))
        {
            return false;
        }
          goto _L15
_L20:
        if (!zzaJg.equals(((equals) (obj)).zzaJg))
        {
            return false;
        }
          goto _L21
_L23:
        if (!zzaJh.equals(((zzaJh) (obj)).zzaJh))
        {
            return false;
        }
          goto _L24
        if (!zzaJj.equals(((equals) (obj)).zzaJj))
        {
            return false;
        }
          goto _L26
    }

    public int hashCode()
    {
        int i1 = 0;
        int j1 = (int)(zzaIX ^ zzaIX >>> 32);
        int i;
        char c;
        int j;
        int k;
        int l;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        if (tag == null)
        {
            i = 0;
        } else
        {
            i = tag.hashCode();
        }
        k1 = zzaIY;
        l1 = zzaIZ;
        if (zzaJa)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        i2 = zzww.hashCode(zzaJb);
        if (zzaJc == null)
        {
            j = 0;
        } else
        {
            j = zzaJc.hashCode();
        }
        j2 = Arrays.hashCode(zzaJd);
        k2 = Arrays.hashCode(zzaJe);
        l2 = Arrays.hashCode(zzaJf);
        if (zzaJg == null)
        {
            k = 0;
        } else
        {
            k = zzaJg.hashCode();
        }
        if (zzaJh == null)
        {
            l = 0;
        } else
        {
            l = zzaJh.hashCode();
        }
        i3 = (int)(zzaJi ^ zzaJi >>> 32);
        if (zzaJj != null)
        {
            i1 = zzaJj.hashCode();
        }
        return (((l + (k + ((((j + ((c + (((i + (j1 + 527) * 31) * 31 + k1) * 31 + l1) * 31) * 31 + i2) * 31) * 31 + j2) * 31 + k2) * 31 + l2) * 31) * 31) * 31 + i3) * 31 + i1) * 31 + zzvL();
    }

    public zzvL zzN(zzwq zzwq1)
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
                zzaIX = zzwq1.zzvw();
                break;

            case 18: // '\022'
                tag = zzwq1.readString();
                break;

            case 26: // '\032'
                int k = zzxb.zzc(zzwq1, 26);
                zzvL azzvl[];
                int j;
                if (zzaJb == null)
                {
                    j = 0;
                } else
                {
                    j = zzaJb.length;
                }
                azzvl = new zzaJb[k + j];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zzaJb, 0, azzvl, 0, j);
                    k = j;
                }
                for (; k < azzvl.length - 1; k++)
                {
                    azzvl[k] = new <init>();
                    zzwq1.zza(azzvl[k]);
                    zzwq1.zzvu();
                }

                azzvl[k] = new <init>();
                zzwq1.zza(azzvl[k]);
                zzaJb = azzvl;
                break;

            case 50: // '2'
                zzaJd = zzwq1.readBytes();
                break;

            case 58: // ':'
                if (zzaJg == null)
                {
                    zzaJg = new <init>();
                }
                zzwq1.zza(zzaJg);
                break;

            case 66: // 'B'
                zzaJe = zzwq1.readBytes();
                break;

            case 74: // 'J'
                if (zzaJc == null)
                {
                    zzaJc = new <init>();
                }
                zzwq1.zza(zzaJc);
                break;

            case 80: // 'P'
                zzaJa = zzwq1.zzvy();
                break;

            case 88: // 'X'
                zzaIY = zzwq1.zzvx();
                break;

            case 96: // '`'
                zzaIZ = zzwq1.zzvx();
                break;

            case 106: // 'j'
                zzaJf = zzwq1.readBytes();
                break;

            case 114: // 'r'
                zzaJh = zzwq1.readString();
                break;

            case 120: // 'x'
                zzaJi = zzwq1.zzvA();
                break;

            case 130: 
                if (zzaJj == null)
                {
                    zzaJj = new <init>();
                }
                zzwq1.zza(zzaJj);
                break;
            }
        } while (true);
    }

    public void zza(zzwr zzwr1)
        throws IOException
    {
        if (zzaIX != 0L)
        {
            zzwr1.zzb(1, zzaIX);
        }
        if (!tag.equals(""))
        {
            zzwr1.zzb(2, tag);
        }
        if (zzaJb != null && zzaJb.length > 0)
        {
            for (int i = 0; i < zzaJb.length; i++)
            {
                zzaJj zzajj = zzaJb[i];
                if (zzajj != null)
                {
                    zzwr1.zza(3, zzajj);
                }
            }

        }
        if (!Arrays.equals(zzaJd, zzxb.zzaHV))
        {
            zzwr1.zza(6, zzaJd);
        }
        if (zzaJg != null)
        {
            zzwr1.zza(7, zzaJg);
        }
        if (!Arrays.equals(zzaJe, zzxb.zzaHV))
        {
            zzwr1.zza(8, zzaJe);
        }
        if (zzaJc != null)
        {
            zzwr1.zza(9, zzaJc);
        }
        if (zzaJa)
        {
            zzwr1.zzb(10, zzaJa);
        }
        if (zzaIY != 0)
        {
            zzwr1.zzy(11, zzaIY);
        }
        if (zzaIZ != 0)
        {
            zzwr1.zzy(12, zzaIZ);
        }
        if (!Arrays.equals(zzaJf, zzxb.zzaHV))
        {
            zzwr1.zza(13, zzaJf);
        }
        if (!zzaJh.equals(""))
        {
            zzwr1.zzb(14, zzaJh);
        }
        if (zzaJi != 0x2bf20L)
        {
            zzwr1.zzc(15, zzaJi);
        }
        if (zzaJj != null)
        {
            zzwr1.zza(16, zzaJj);
        }
        super.zza(zzwr1);
    }

    public zzwy zzb(zzwq zzwq1)
        throws IOException
    {
        return zzN(zzwq1);
    }

    protected int zzc()
    {
        int i = super.zzc();
        int j = i;
        if (zzaIX != 0L)
        {
            j = i + com.google.android.gms.internal.zzwr.zzd(1, zzaIX);
        }
        i = j;
        if (!tag.equals(""))
        {
            i = j + com.google.android.gms.internal.zzwr.zzj(2, tag);
        }
        j = i;
        if (zzaJb != null)
        {
            j = i;
            if (zzaJb.length > 0)
            {
                for (j = 0; j < zzaJb.length;)
                {
                    zzN zzn = zzaJb[j];
                    int k = i;
                    if (zzn != null)
                    {
                        k = i + com.google.android.gms.internal.zzwr.zzc(3, zzn);
                    }
                    j++;
                    i = k;
                }

                j = i;
            }
        }
        i = j;
        if (!Arrays.equals(zzaJd, zzxb.zzaHV))
        {
            i = j + com.google.android.gms.internal.zzwr.zzb(6, zzaJd);
        }
        j = i;
        if (zzaJg != null)
        {
            j = i + com.google.android.gms.internal.zzwr.zzc(7, zzaJg);
        }
        i = j;
        if (!Arrays.equals(zzaJe, zzxb.zzaHV))
        {
            i = j + com.google.android.gms.internal.zzwr.zzb(8, zzaJe);
        }
        j = i;
        if (zzaJc != null)
        {
            j = i + com.google.android.gms.internal.zzwr.zzc(9, zzaJc);
        }
        i = j;
        if (zzaJa)
        {
            i = j + com.google.android.gms.internal.zzwr.zzc(10, zzaJa);
        }
        j = i;
        if (zzaIY != 0)
        {
            j = i + com.google.android.gms.internal.zzwr.zzA(11, zzaIY);
        }
        i = j;
        if (zzaIZ != 0)
        {
            i = j + com.google.android.gms.internal.zzwr.zzA(12, zzaIZ);
        }
        j = i;
        if (!Arrays.equals(zzaJf, zzxb.zzaHV))
        {
            j = i + com.google.android.gms.internal.zzwr.zzb(13, zzaJf);
        }
        i = j;
        if (!zzaJh.equals(""))
        {
            i = j + com.google.android.gms.internal.zzwr.zzj(14, zzaJh);
        }
        j = i;
        if (zzaJi != 0x2bf20L)
        {
            j = i + com.google.android.gms.internal.zzwr.zze(15, zzaJi);
        }
        i = j;
        if (zzaJj != null)
        {
            i = j + com.google.android.gms.internal.zzwr.zzc(16, zzaJj);
        }
        return i;
    }

    public zzaJj zzwr()
    {
        zzaIX = 0L;
        tag = "";
        zzaIY = 0;
        zzaIZ = 0;
        zzaJa = false;
        zzaJb = zzws();
        zzaJc = null;
        zzaJd = zzxb.zzaHV;
        zzaJe = zzxb.zzaHV;
        zzaJf = zzxb.zzaHV;
        zzaJg = null;
        zzaJh = "";
        zzaJi = 0x2bf20L;
        zzaJj = null;
        zzaHB = null;
        zzaHM = -1;
        return this;
    }

    public ()
    {
        zzwr();
    }
}
