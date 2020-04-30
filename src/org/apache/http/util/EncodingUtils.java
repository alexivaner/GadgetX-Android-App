// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.http.Consts;

// Referenced classes of package org.apache.http.util:
//            Args

public final class EncodingUtils
{

    private EncodingUtils()
    {
    }

    public static byte[] getAsciiBytes(String s)
    {
        Args.notNull(s, "Input");
        try
        {
            s = s.getBytes(Consts.ASCII.name());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new Error("ASCII not supported");
        }
        return s;
    }

    public static String getAsciiString(byte abyte0[])
    {
        Args.notNull(abyte0, "Input");
        return getAsciiString(abyte0, 0, abyte0.length);
    }

    public static String getAsciiString(byte abyte0[], int i, int j)
    {
        Args.notNull(abyte0, "Input");
        try
        {
            abyte0 = new String(abyte0, i, j, Consts.ASCII.name());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new Error("ASCII not supported");
        }
        return abyte0;
    }

    public static byte[] getBytes(String s, String s1)
    {
        Args.notNull(s, "Input");
        Args.notEmpty(s1, "Charset");
        try
        {
            s1 = s.getBytes(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return s.getBytes();
        }
        return s1;
    }

    public static String getString(byte abyte0[], int i, int j, String s)
    {
        Args.notNull(abyte0, "Input");
        Args.notEmpty(s, "Charset");
        try
        {
            s = new String(abyte0, i, j, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return new String(abyte0, i, j);
        }
        return s;
    }

    public static String getString(byte abyte0[], String s)
    {
        Args.notNull(abyte0, "Input");
        return getString(abyte0, 0, abyte0.length, s);
    }
}
