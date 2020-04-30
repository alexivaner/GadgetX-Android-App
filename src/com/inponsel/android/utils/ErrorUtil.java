// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;

public class ErrorUtil
{

    public ErrorUtil()
    {
    }

    public static void alert(Context context, String s, String s1)
    {
        alert(context, s, s1, "OK");
    }

    public static void alert(Context context, String s, String s1, String s2)
    {
        (new android.app.AlertDialog.Builder(context)).setMessage(s1).setTitle(s).setPositiveButton(s2, null).show();
    }

    public static RuntimeException runtimeException(Exception exception)
    {
        if (exception instanceof RuntimeException)
        {
            return (RuntimeException)exception;
        } else
        {
            return new RuntimeException("Exception wrapped by RuntimeException", exception);
        }
    }
}
