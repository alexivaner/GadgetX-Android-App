// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common;

import com.google.android.gms.common.internal.zzx;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.common:
//            zzb

static abstract class zzLy
{

    private int zzLy;

    protected static byte[] zzaU(String s)
    {
        try
        {
            s = s.getBytes("ISO-8859-1");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError(s);
        }
        return s;
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof zzLy))
        {
            return false;
        } else
        {
            obj = (zzLy)obj;
            return Arrays.equals(getBytes(), ((getBytes) (obj)).getBytes());
        }
    }

    abstract byte[] getBytes();

    public int hashCode()
    {
        return zzLy;
    }

    protected .zzx(byte abyte0[])
    {
        boolean flag;
        if (abyte0.length == 25)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "cert hash data has incorrect length");
        zzLy = Arrays.hashCode(abyte0);
    }
}
