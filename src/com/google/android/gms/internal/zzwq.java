// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzwx, zzwy, zzxb

public final class zzwq
{

    private final byte buffer[];
    private int zzaHr;
    private int zzaHs;
    private int zzaHt;
    private int zzaHu;
    private int zzaHv;
    private int zzaHw;
    private int zzaHx;
    private int zzaHy;
    private int zzaHz;

    private zzwq(byte abyte0[], int i, int j)
    {
        zzaHw = 0x7fffffff;
        zzaHy = 64;
        zzaHz = 0x4000000;
        buffer = abyte0;
        zzaHr = i;
        zzaHs = i + j;
        zzaHu = i;
    }

    public static long zzK(long l)
    {
        return l >>> 1 ^ -(1L & l);
    }

    public static zzwq zza(byte abyte0[], int i, int j)
    {
        return new zzwq(abyte0, i, j);
    }

    public static int zzio(int i)
    {
        return i >>> 1 ^ -(i & 1);
    }

    public static zzwq zzt(byte abyte0[])
    {
        return zza(abyte0, 0, abyte0.length);
    }

    private void zzvF()
    {
        zzaHs = zzaHs + zzaHt;
        int i = zzaHs;
        if (i > zzaHw)
        {
            zzaHt = i - zzaHw;
            zzaHs = zzaHs - zzaHt;
            return;
        } else
        {
            zzaHt = 0;
            return;
        }
    }

    public int getPosition()
    {
        return zzaHu - zzaHr;
    }

    public byte[] readBytes()
        throws IOException
    {
        int i = zzvB();
        if (i <= zzaHs - zzaHu && i > 0)
        {
            byte abyte0[] = new byte[i];
            System.arraycopy(buffer, zzaHu, abyte0, 0, i);
            zzaHu = i + zzaHu;
            return abyte0;
        } else
        {
            return zzis(i);
        }
    }

    public double readDouble()
        throws IOException
    {
        return Double.longBitsToDouble(zzvE());
    }

    public float readFloat()
        throws IOException
    {
        return Float.intBitsToFloat(zzvD());
    }

    public String readString()
        throws IOException
    {
        int i = zzvB();
        if (i <= zzaHs - zzaHu && i > 0)
        {
            String s = new String(buffer, zzaHu, i, "UTF-8");
            zzaHu = i + zzaHu;
            return s;
        } else
        {
            return new String(zzis(i), "UTF-8");
        }
    }

    public void zza(zzwy zzwy1)
        throws IOException
    {
        int i = zzvB();
        if (zzaHx >= zzaHy)
        {
            throw zzwx.zzvW();
        } else
        {
            i = zzip(i);
            zzaHx = zzaHx + 1;
            zzwy1.zzb(this);
            zzim(0);
            zzaHx = zzaHx - 1;
            zziq(i);
            return;
        }
    }

    public void zza(zzwy zzwy1, int i)
        throws IOException
    {
        if (zzaHx >= zzaHy)
        {
            throw zzwx.zzvW();
        } else
        {
            zzaHx = zzaHx + 1;
            zzwy1.zzb(this);
            zzim(zzxb.zzD(i, 4));
            zzaHx = zzaHx - 1;
            return;
        }
    }

    public void zzim(int i)
        throws zzwx
    {
        if (zzaHv != i)
        {
            throw zzwx.zzvU();
        } else
        {
            return;
        }
    }

    public boolean zzin(int i)
        throws IOException
    {
        switch (zzxb.zziH(i))
        {
        default:
            throw zzwx.zzvV();

        case 0: // '\0'
            zzvx();
            return true;

        case 1: // '\001'
            zzvE();
            return true;

        case 2: // '\002'
            zzit(zzvB());
            return true;

        case 3: // '\003'
            zzvv();
            zzim(zzxb.zzD(zzxb.zziI(i), 4));
            return true;

        case 4: // '\004'
            return false;

        case 5: // '\005'
            zzvD();
            break;
        }
        return true;
    }

    public int zzip(int i)
        throws zzwx
    {
        if (i < 0)
        {
            throw zzwx.zzvR();
        }
        i = zzaHu + i;
        int j = zzaHw;
        if (i > j)
        {
            throw zzwx.zzvQ();
        } else
        {
            zzaHw = i;
            zzvF();
            return j;
        }
    }

    public void zziq(int i)
    {
        zzaHw = i;
        zzvF();
    }

    public void zzir(int i)
    {
        if (i > zzaHu - zzaHr)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Position ").append(i).append(" is beyond current ").append(zzaHu - zzaHr).toString());
        }
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Bad position ").append(i).toString());
        } else
        {
            zzaHu = zzaHr + i;
            return;
        }
    }

    public byte[] zzis(int i)
        throws IOException
    {
        if (i < 0)
        {
            throw zzwx.zzvR();
        }
        if (zzaHu + i > zzaHw)
        {
            zzit(zzaHw - zzaHu);
            throw zzwx.zzvQ();
        }
        if (i <= zzaHs - zzaHu)
        {
            byte abyte0[] = new byte[i];
            System.arraycopy(buffer, zzaHu, abyte0, 0, i);
            zzaHu = zzaHu + i;
            return abyte0;
        } else
        {
            throw zzwx.zzvQ();
        }
    }

    public void zzit(int i)
        throws IOException
    {
        if (i < 0)
        {
            throw zzwx.zzvR();
        }
        if (zzaHu + i > zzaHw)
        {
            zzit(zzaHw - zzaHu);
            throw zzwx.zzvQ();
        }
        if (i <= zzaHs - zzaHu)
        {
            zzaHu = zzaHu + i;
            return;
        } else
        {
            throw zzwx.zzvQ();
        }
    }

    public long zzvA()
        throws IOException
    {
        return zzK(zzvC());
    }

    public int zzvB()
        throws IOException
    {
        int i = zzvI();
        if (i < 0) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        i &= 0x7f;
        byte byte0 = zzvI();
        if (byte0 >= 0)
        {
            return i | byte0 << 7;
        }
        i |= (byte0 & 0x7f) << 7;
        byte0 = zzvI();
        if (byte0 >= 0)
        {
            return i | byte0 << 14;
        }
        i |= (byte0 & 0x7f) << 14;
        int k = zzvI();
        if (k >= 0)
        {
            return i | k << 21;
        }
        byte0 = zzvI();
        k = i | (k & 0x7f) << 21 | byte0 << 28;
        i = k;
        if (byte0 < 0)
        {
            int j = 0;
label0:
            do
            {
label1:
                {
                    if (j >= 5)
                    {
                        break label1;
                    }
                    i = k;
                    if (zzvI() >= 0)
                    {
                        break label0;
                    }
                    j++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        throw zzwx.zzvS();
    }

    public long zzvC()
        throws IOException
    {
        int i = 0;
        long l = 0L;
        for (; i < 64; i += 7)
        {
            byte byte0 = zzvI();
            l |= (long)(byte0 & 0x7f) << i;
            if ((byte0 & 0x80) == 0)
            {
                return l;
            }
        }

        throw zzwx.zzvS();
    }

    public int zzvD()
        throws IOException
    {
        return zzvI() & 0xff | (zzvI() & 0xff) << 8 | (zzvI() & 0xff) << 16 | (zzvI() & 0xff) << 24;
    }

    public long zzvE()
        throws IOException
    {
        int i = zzvI();
        int j = zzvI();
        int k = zzvI();
        int l = zzvI();
        int i1 = zzvI();
        int j1 = zzvI();
        int k1 = zzvI();
        int l1 = zzvI();
        long l2 = i;
        return ((long)j & 255L) << 8 | l2 & 255L | ((long)k & 255L) << 16 | ((long)l & 255L) << 24 | ((long)i1 & 255L) << 32 | ((long)j1 & 255L) << 40 | ((long)k1 & 255L) << 48 | ((long)l1 & 255L) << 56;
    }

    public int zzvG()
    {
        if (zzaHw == 0x7fffffff)
        {
            return -1;
        } else
        {
            int i = zzaHu;
            return zzaHw - i;
        }
    }

    public boolean zzvH()
    {
        return zzaHu == zzaHs;
    }

    public byte zzvI()
        throws IOException
    {
        if (zzaHu == zzaHs)
        {
            throw zzwx.zzvQ();
        } else
        {
            byte abyte0[] = buffer;
            int i = zzaHu;
            zzaHu = i + 1;
            return abyte0[i];
        }
    }

    public int zzvu()
        throws IOException
    {
        if (zzvH())
        {
            zzaHv = 0;
            return 0;
        }
        zzaHv = zzvB();
        if (zzaHv == 0)
        {
            throw zzwx.zzvT();
        } else
        {
            return zzaHv;
        }
    }

    public void zzvv()
        throws IOException
    {
        int i;
        do
        {
            i = zzvu();
        } while (i != 0 && zzin(i));
    }

    public long zzvw()
        throws IOException
    {
        return zzvC();
    }

    public int zzvx()
        throws IOException
    {
        return zzvB();
    }

    public boolean zzvy()
        throws IOException
    {
        return zzvB() != 0;
    }

    public int zzvz()
        throws IOException
    {
        return zzio(zzvB());
    }

    public byte[] zzx(int i, int j)
    {
        if (j == 0)
        {
            return zzxb.zzaHV;
        } else
        {
            byte abyte0[] = new byte[j];
            int k = zzaHr;
            System.arraycopy(buffer, k + i, abyte0, 0, j);
            return abyte0;
        }
    }
}
