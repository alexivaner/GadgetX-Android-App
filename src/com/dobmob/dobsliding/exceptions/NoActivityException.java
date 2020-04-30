// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.exceptions;


public class NoActivityException extends Exception
{

    private static final long serialVersionUID = 0x5c893d3492915ef8L;

    public NoActivityException()
    {
    }

    public NoActivityException(String s)
    {
        super(s);
    }

    public NoActivityException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public NoActivityException(Throwable throwable)
    {
        super(throwable);
    }
}
