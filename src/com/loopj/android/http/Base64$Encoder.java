// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;


// Referenced classes of package com.loopj.android.http:
//            Base64

static class count extends count
{

    private static final byte ENCODE[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47
    };
    private static final byte ENCODE_WEBSAFE[] = {
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95
    };
    public static final int LINE_GROUPS = 19;
    private final byte alphabet[];
    private int count;
    public final boolean do_cr;
    public final boolean do_newline;
    public final boolean do_padding;
    private final byte tail[] = new byte[2];
    int tailLen;

    public int maxOutputSize(int i)
    {
        return (i * 8) / 5 + 10;
    }

    public boolean process(byte abyte0[], int i, int j, boolean flag)
    {
        byte abyte1[];
        byte abyte4[];
        int k;
        int l;
        int i2;
        int l2;
        int i3;
        abyte1 = alphabet;
        abyte4 = output;
        i2 = 0;
        l2 = count;
        k = i;
        i3 = j + i;
        j = -1;
        i = k;
        l = j;
        tailLen;
        JVM INSTR tableswitch 0 2: default 68
    //                   0 74
    //                   1 412
    //                   2 488;
           goto _L1 _L2 _L3 _L4
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        l = j;
        i = k;
_L12:
        j = l2;
        k = i2;
        i2 = i;
        if (l == -1) goto _L6; else goto _L5
_L5:
        int j2;
        k = 0 + 1;
        abyte4[0] = abyte1[l >> 18 & 0x3f];
        j = k + 1;
        abyte4[k] = abyte1[l >> 12 & 0x3f];
        k = j + 1;
        abyte4[j] = abyte1[l >> 6 & 0x3f];
        j2 = k + 1;
        abyte4[k] = abyte1[l & 0x3f];
        l = l2 - 1;
        j = l;
        k = j2;
        i2 = i;
        if (l != 0) goto _L6; else goto _L7
_L7:
        j = j2;
        if (do_cr)
        {
            abyte4[j2] = 13;
            j = j2 + 1;
        }
        k = j + 1;
        abyte4[j] = 10;
        l = 19;
        j = i;
        i = k;
        k = l;
_L11:
        if (j + 3 > i3) goto _L9; else goto _L8
_L8:
        l = (abyte0[j] & 0xff) << 16 | (abyte0[j + 1] & 0xff) << 8 | abyte0[j + 2] & 0xff;
        abyte4[i] = abyte1[l >> 18 & 0x3f];
        abyte4[i + 1] = abyte1[l >> 12 & 0x3f];
        abyte4[i + 2] = abyte1[l >> 6 & 0x3f];
        abyte4[i + 3] = abyte1[l & 0x3f];
        l = j + 3;
        i += 4;
        j2 = k - 1;
        j = j2;
        k = i;
        i2 = l;
        if (j2 != 0) goto _L6; else goto _L10
_L10:
        j = i;
        if (do_cr)
        {
            abyte4[i] = 13;
            j = i + 1;
        }
        i = j + 1;
        abyte4[j] = 10;
        k = 19;
        j = l;
          goto _L11
_L3:
        i = k;
        l = j;
        if (k + 2 <= i3)
        {
            j = tail[0];
            l = k + 1;
            k = abyte0[k];
            i = l + 1;
            l = (j & 0xff) << 16 | (k & 0xff) << 8 | abyte0[l] & 0xff;
            tailLen = 0;
        }
          goto _L12
_L4:
        i = k;
        l = j;
        if (k + 1 <= i3)
        {
            l = (tail[0] & 0xff) << 16 | (tail[1] & 0xff) << 8 | abyte0[k] & 0xff;
            tailLen = 0;
            i = k + 1;
        }
          goto _L12
_L9:
        if (!flag) goto _L14; else goto _L13
_L13:
        if (j - tailLen != i3 - 1) goto _L16; else goto _L15
_L15:
        int i1 = 0;
        if (tailLen > 0)
        {
            i1 = tail[0];
            j = 0 + 1;
        } else
        {
            i2 = abyte0[j];
            j = i1;
            i1 = i2;
        }
        i1 = (i1 & 0xff) << 4;
        tailLen = tailLen - j;
        j = i + 1;
        abyte4[i] = abyte1[i1 >> 6 & 0x3f];
        i = j + 1;
        abyte4[j] = abyte1[i1 & 0x3f];
        j = i;
        if (do_padding)
        {
            i1 = i + 1;
            abyte4[i] = 61;
            j = i1 + 1;
            abyte4[i1] = 61;
        }
        i = j;
        if (do_newline)
        {
            i = j;
            if (do_cr)
            {
                abyte4[j] = 13;
                i = j + 1;
            }
            j = i + 1;
            abyte4[i] = 10;
            i = j;
        }
_L17:
        op = i;
        count = k;
        return true;
_L16:
        if (j - tailLen == i3 - 2)
        {
            int j1 = 0;
            if (tailLen > 1)
            {
                j1 = tail[0];
                int k2 = 0 + 1;
                i2 = j;
                j = k2;
            } else
            {
                i2 = j + 1;
                byte byte0 = abyte0[j];
                j = j1;
                j1 = byte0;
            }
            if (tailLen > 0)
            {
                i2 = tail[j];
                j++;
            } else
            {
                i2 = abyte0[i2];
            }
            j1 = (j1 & 0xff) << 10 | (i2 & 0xff) << 2;
            tailLen = tailLen - j;
            j = i + 1;
            abyte4[i] = abyte1[j1 >> 12 & 0x3f];
            i2 = j + 1;
            abyte4[j] = abyte1[j1 >> 6 & 0x3f];
            i = i2 + 1;
            abyte4[i2] = abyte1[j1 & 0x3f];
            j = i;
            if (do_padding)
            {
                abyte4[i] = 61;
                j = i + 1;
            }
            i = j;
            if (do_newline)
            {
                i = j;
                if (do_cr)
                {
                    abyte4[j] = 13;
                    i = j + 1;
                }
                j = i + 1;
                abyte4[i] = 10;
                i = j;
            }
        } else
        if (do_newline && i > 0 && k != 19)
        {
            if (do_cr)
            {
                j = i + 1;
                abyte4[i] = 13;
                i = j;
            }
            abyte4[i] = 10;
            i++;
        }
        continue; /* Loop/switch isn't completed */
_L14:
        if (j == i3 - 1)
        {
            byte abyte2[] = tail;
            int k1 = tailLen;
            tailLen = k1 + 1;
            abyte2[k1] = abyte0[j];
        } else
        if (j == i3 - 2)
        {
            byte abyte3[] = tail;
            int l1 = tailLen;
            tailLen = l1 + 1;
            abyte3[l1] = abyte0[j];
            abyte3 = tail;
            l1 = tailLen;
            tailLen = l1 + 1;
            abyte3[l1] = abyte0[j + 1];
        }
        if (true) goto _L17; else goto _L6
_L6:
        i = k;
        k = j;
        j = i2;
          goto _L11
    }


    public (int i, byte abyte0[])
    {
        boolean flag1 = true;
        super();
        output = abyte0;
        boolean flag;
        if ((i & 1) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        do_padding = flag;
        if ((i & 2) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        do_newline = flag;
        if ((i & 4) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        do_cr = flag;
        if ((i & 8) == 0)
        {
            abyte0 = ENCODE;
        } else
        {
            abyte0 = ENCODE_WEBSAFE;
        }
        alphabet = abyte0;
        tailLen = 0;
        if (do_newline)
        {
            i = 19;
        } else
        {
            i = -1;
        }
        count = i;
    }
}
