// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

// Referenced classes of package com.google.android.gms.common.data:
//            zzc, DataBuffer, zzd

public class zzh extends zzc
{

    private Object zzOk;

    public zzh(DataBuffer databuffer)
    {
        super(databuffer);
    }

    public Object next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException((new StringBuilder()).append("Cannot advance the iterator beyond ").append(zzNO).toString());
        }
        zzNO = zzNO + 1;
        if (zzNO == 0)
        {
            zzOk = zzNN.get(0);
            if (!(zzOk instanceof zzd))
            {
                throw new IllegalStateException((new StringBuilder()).append("DataBuffer reference of type ").append(zzOk.getClass()).append(" is not movable").toString());
            }
        } else
        {
            ((zzd)zzOk).zzav(zzNO);
        }
        return zzOk;
    }
}
