// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.common.data:
//            DataBufferObserver

public final class DataBufferObserverSet
    implements DataBufferObserver, DataBufferObserver.Observable
{

    private HashSet zzNP;

    public DataBufferObserverSet()
    {
        zzNP = new HashSet();
    }

    public void addObserver(DataBufferObserver databufferobserver)
    {
        zzNP.add(databufferobserver);
    }

    public void clear()
    {
        zzNP.clear();
    }

    public boolean hasObservers()
    {
        return !zzNP.isEmpty();
    }

    public void onDataChanged()
    {
        for (Iterator iterator = zzNP.iterator(); iterator.hasNext(); ((DataBufferObserver)iterator.next()).onDataChanged()) { }
    }

    public void onDataRangeChanged(int i, int j)
    {
        for (Iterator iterator = zzNP.iterator(); iterator.hasNext(); ((DataBufferObserver)iterator.next()).onDataRangeChanged(i, j)) { }
    }

    public void onDataRangeInserted(int i, int j)
    {
        for (Iterator iterator = zzNP.iterator(); iterator.hasNext(); ((DataBufferObserver)iterator.next()).onDataRangeInserted(i, j)) { }
    }

    public void onDataRangeMoved(int i, int j, int k)
    {
        for (Iterator iterator = zzNP.iterator(); iterator.hasNext(); ((DataBufferObserver)iterator.next()).onDataRangeMoved(i, j, k)) { }
    }

    public void onDataRangeRemoved(int i, int j)
    {
        for (Iterator iterator = zzNP.iterator(); iterator.hasNext(); ((DataBufferObserver)iterator.next()).onDataRangeRemoved(i, j)) { }
    }

    public void removeObserver(DataBufferObserver databufferobserver)
    {
        zzNP.remove(databufferobserver);
    }
}
