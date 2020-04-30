// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.fonts;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;

public class Roboto
{

    private static Roboto instance;
    private Context context;

    public Roboto(Context context1)
    {
        context = context1;
    }

    public static Roboto getInstance(Context context1)
    {
        com/inponsel/android/fonts/Roboto;
        JVM INSTR monitorenter ;
        if (instance == null)
        {
            instance = new Roboto(context1);
        }
        context1 = instance;
        com/inponsel/android/fonts/Roboto;
        JVM INSTR monitorexit ;
        return context1;
        context1;
        com/inponsel/android/fonts/Roboto;
        JVM INSTR monitorexit ;
        throw context1;
    }

    public Typeface getTypeFace()
    {
        return Typeface.createFromAsset(context.getResources().getAssets(), "Roboto-Regular.ttf");
    }
}
