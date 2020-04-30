// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.leakcanary;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

// Referenced classes of package com.squareup.leakcanary:
//            Preconditions

final class KeyedWeakReference extends WeakReference
{

    public final String key;
    public final String name;

    KeyedWeakReference(Object obj, String s, String s1, ReferenceQueue referencequeue)
    {
        super(Preconditions.checkNotNull(obj, "referent"), (ReferenceQueue)Preconditions.checkNotNull(referencequeue, "referenceQueue"));
        key = (String)Preconditions.checkNotNull(s, "key");
        name = (String)Preconditions.checkNotNull(s1, "name");
    }
}
