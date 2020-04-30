// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public class zzmr
{

    public static boolean zzV(Context context)
    {
        return (context.getResources().getConfiguration().uiMode & 0xf) == 6;
    }
}
