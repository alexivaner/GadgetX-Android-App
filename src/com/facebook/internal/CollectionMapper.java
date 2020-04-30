// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import com.facebook.FacebookException;
import java.util.Iterator;

// Referenced classes of package com.facebook.internal:
//            Mutable

public class CollectionMapper
{
    public static interface Collection
    {

        public abstract Object get(Object obj);

        public abstract Iterator keyIterator();

        public abstract void set(Object obj, Object obj1, OnErrorListener onerrorlistener);
    }

    public static interface OnErrorListener
    {

        public abstract void onError(FacebookException facebookexception);
    }

    public static interface OnMapValueCompleteListener
        extends OnErrorListener
    {

        public abstract void onComplete(Object obj);
    }

    public static interface OnMapperCompleteListener
        extends OnErrorListener
    {

        public abstract void onComplete();
    }

    public static interface ValueMapper
    {

        public abstract void mapValue(Object obj, OnMapValueCompleteListener onmapvaluecompletelistener);
    }


    private CollectionMapper()
    {
    }

    public static void iterate(Collection collection, ValueMapper valuemapper, OnMapperCompleteListener onmappercompletelistener)
    {
        Mutable mutable1 = new Mutable(Boolean.valueOf(false));
        Mutable mutable = new Mutable(Integer.valueOf(1));
        onmappercompletelistener = new OnMapperCompleteListener(mutable1, mutable, onmappercompletelistener) {

            final Mutable val$didReturnError;
            final OnMapperCompleteListener val$onMapperCompleteListener;
            final Mutable val$pendingJobCount;

            public void onComplete()
            {
                if (!((Boolean)didReturnError.value).booleanValue())
                {
                    Mutable mutable2 = pendingJobCount;
                    Integer integer1 = Integer.valueOf(((Integer)pendingJobCount.value).intValue() - 1);
                    mutable2.value = integer1;
                    if (integer1.intValue() == 0)
                    {
                        onMapperCompleteListener.onComplete();
                        return;
                    }
                }
            }

            public void onError(FacebookException facebookexception)
            {
                if (((Boolean)didReturnError.value).booleanValue())
                {
                    return;
                } else
                {
                    didReturnError.value = Boolean.valueOf(true);
                    onMapperCompleteListener.onError(facebookexception);
                    return;
                }
            }

            
            {
                didReturnError = mutable;
                pendingJobCount = mutable1;
                onMapperCompleteListener = onmappercompletelistener;
                super();
            }
        };
        Object obj;
        Object obj1;
        for (Iterator iterator = collection.keyIterator(); iterator.hasNext(); valuemapper.mapValue(obj, ((OnMapValueCompleteListener) (obj1))))
        {
            obj1 = iterator.next();
            obj = collection.get(obj1);
            obj1 = new OnMapValueCompleteListener(collection, obj1, onmappercompletelistener) {

                final Collection val$collection;
                final OnMapperCompleteListener val$jobCompleteListener;
                final Object val$key;

                public void onComplete(Object obj2)
                {
                    collection.set(key, obj2, jobCompleteListener);
                    jobCompleteListener.onComplete();
                }

                public void onError(FacebookException facebookexception)
                {
                    jobCompleteListener.onError(facebookexception);
                }

            
            {
                collection = collection1;
                key = obj;
                jobCompleteListener = onmappercompletelistener;
                super();
            }
            };
            Integer integer = (Integer)mutable.value;
            mutable.value = Integer.valueOf(((Integer)mutable.value).intValue() + 1);
        }

        onmappercompletelistener.onComplete();
    }
}
