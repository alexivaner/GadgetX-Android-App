// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.common.data:
//            DataBuffer, DataHolder, zzc, zzh

public abstract class AbstractDataBuffer
    implements DataBuffer
{

    protected final DataHolder zzMd;

    protected AbstractDataBuffer(DataHolder dataholder)
    {
        zzMd = dataholder;
        if (zzMd != null)
        {
            zzMd.zzg(this);
        }
    }

    public final void close()
    {
        release();
    }

    public abstract Object get(int i);

    public int getCount()
    {
        if (zzMd == null)
        {
            return 0;
        } else
        {
            return zzMd.getCount();
        }
    }

    public boolean isClosed()
    {
        return zzMd == null || zzMd.isClosed();
    }

    public Iterator iterator()
    {
        return new zzc(this);
    }

    public void release()
    {
        if (zzMd != null)
        {
            zzMd.close();
        }
    }

    public Iterator singleRefIterator()
    {
        return new zzh(this);
    }

    public Bundle zziu()
    {
        return zzMd.zziu();
    }
}
