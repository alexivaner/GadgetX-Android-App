// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.loopj.android.http:
//            Base64DataException

public class Base64OutputStream extends FilterOutputStream
{

    private static byte EMPTY[] = new byte[0];
    private int bpos;
    private byte buffer[];
    private final Base64.Coder coder;
    private final int flags;

    public Base64OutputStream(OutputStream outputstream, int i)
    {
        this(outputstream, i, true);
    }

    public Base64OutputStream(OutputStream outputstream, int i, boolean flag)
    {
        super(outputstream);
        buffer = null;
        bpos = 0;
        flags = i;
        if (flag)
        {
            coder = new Base64.Encoder(i, null);
            return;
        } else
        {
            coder = new Base64.Decoder(i, null);
            return;
        }
    }

    private byte[] embiggen(byte abyte0[], int i)
    {
        byte abyte1[];
label0:
        {
            if (abyte0 != null)
            {
                abyte1 = abyte0;
                if (abyte0.length >= i)
                {
                    break label0;
                }
            }
            abyte1 = new byte[i];
        }
        return abyte1;
    }

    private void flushBuffer()
        throws IOException
    {
        if (bpos > 0)
        {
            internalWrite(buffer, 0, bpos, false);
            bpos = 0;
        }
    }

    private void internalWrite(byte abyte0[], int i, int j, boolean flag)
        throws IOException
    {
        coder.output = embiggen(coder.output, coder.maxOutputSize(j));
        if (!coder.process(abyte0, i, j, flag))
        {
            throw new Base64DataException("bad base-64");
        } else
        {
            out.write(coder.output, 0, coder.op);
            return;
        }
    }

    public void close()
        throws IOException
    {
        IOException ioexception;
        IOException ioexception1;
        ioexception = null;
        try
        {
            flushBuffer();
            internalWrite(EMPTY, 0, 0, true);
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception) { }
        if ((flags & 0x10) != 0) goto _L2; else goto _L1
_L1:
        out.close();
        ioexception1 = ioexception;
_L3:
        IOException ioexception2;
        if (ioexception1 != null)
        {
            throw ioexception1;
        } else
        {
            return;
        }
_L2:
        out.flush();
        ioexception1 = ioexception;
          goto _L3
        ioexception2;
        ioexception1 = ioexception;
        if (ioexception != null)
        {
            ioexception1 = ioexception2;
        }
          goto _L3
    }

    public void write(int i)
        throws IOException
    {
        if (buffer == null)
        {
            buffer = new byte[1024];
        }
        if (bpos >= buffer.length)
        {
            internalWrite(buffer, 0, bpos, false);
            bpos = 0;
        }
        byte abyte0[] = buffer;
        int j = bpos;
        bpos = j + 1;
        abyte0[j] = (byte)i;
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if (j <= 0)
        {
            return;
        } else
        {
            flushBuffer();
            internalWrite(abyte0, i, j, false);
            return;
        }
    }

}
