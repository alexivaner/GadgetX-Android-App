// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.leakcanary;


final class Preconditions
{

    private Preconditions()
    {
        throw new AssertionError();
    }

    static Object checkNotNull(Object obj, String s)
    {
        if (obj == null)
        {
            throw new NullPointerException((new StringBuilder(String.valueOf(s))).append(" must not be null").toString());
        } else
        {
            return obj;
        }
    }
}
