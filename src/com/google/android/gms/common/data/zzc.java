// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.android.gms.common.data:
//            DataBuffer

public class zzc
    implements Iterator
{

    protected final DataBuffer zzNN;
    protected int zzNO;

    public zzc(DataBuffer databuffer)
    {
        zzNN = (DataBuffer)zzx.zzl(databuffer);
        zzNO = -1;
    }

    public boolean hasNext()
    {
        return zzNO < zzNN.getCount() - 1;
    }

    public Object next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException((new StringBuilder()).append("Cannot advance the iterator beyond ").append(zzNO).toString());
        } else
        {
            DataBuffer databuffer = zzNN;
            int i = zzNO + 1;
            zzNO = i;
            return databuffer.get(i);
        }
    }

    public void remove()
    {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
