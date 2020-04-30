// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.inponsel.android.utils:
//            AndroidMultiPartEntity

public static class transferred extends FilterOutputStream
{

    private final transferred listener;
    private long transferred;

    public void write(int i)
        throws IOException
    {
        out.write(i);
        transferred = transferred + 1L;
        listener.sferred(transferred);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        out.write(abyte0, i, j);
        transferred = transferred + (long)j;
        listener.sferred(transferred);
    }

    public (OutputStream outputstream,  )
    {
        super(outputstream);
        listener = ;
        transferred = 0L;
    }
}
