// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.util.concurrent.Callable;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl.ext:
//            DiskLruCache

class this._cls0
    implements Callable
{

    final DiskLruCache this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
label0:
        {
            synchronized (DiskLruCache.this)
            {
                if (DiskLruCache.access$0(DiskLruCache.this) != null)
                {
                    break label0;
                }
            }
            return null;
        }
        DiskLruCache.access$1(DiskLruCache.this);
        DiskLruCache.access$2(DiskLruCache.this);
        if (DiskLruCache.access$3(DiskLruCache.this))
        {
            DiskLruCache.access$4(DiskLruCache.this);
            DiskLruCache.access$5(DiskLruCache.this, 0);
        }
        disklrucache;
        JVM INSTR monitorexit ;
        return null;
        exception;
        disklrucache;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = DiskLruCache.this;
        super();
    }
}
