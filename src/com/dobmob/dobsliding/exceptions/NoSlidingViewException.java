// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.exceptions;


public class NoSlidingViewException extends Exception
{

    private static final long serialVersionUID = 0x67451c4e70f7b900L;

    public NoSlidingViewException()
    {
    }

    public NoSlidingViewException(String s)
    {
        super(s);
    }

    public NoSlidingViewException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public NoSlidingViewException(Throwable throwable)
    {
        super(throwable);
    }
}
