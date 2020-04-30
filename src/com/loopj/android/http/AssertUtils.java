// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;


class AssertUtils
{

    private AssertUtils()
    {
    }

    public static void asserts(boolean flag, String s)
    {
        if (!flag)
        {
            throw new AssertionError(s);
        } else
        {
            return;
        }
    }
}
