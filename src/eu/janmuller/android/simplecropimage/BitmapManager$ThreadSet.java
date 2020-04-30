// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;

import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package eu.janmuller.android.simplecropimage:
//            BitmapManager

public static class 
    implements Iterable
{

    private final WeakHashMap mWeakCollection = new WeakHashMap();

    public void add(Thread thread)
    {
        mWeakCollection.put(thread, null);
    }

    public Iterator iterator()
    {
        return mWeakCollection.keySet().iterator();
    }

    public void remove(Thread thread)
    {
        mWeakCollection.remove(thread);
    }

    public ()
    {
    }
}
