// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CheckNetworkConnection
{

    public CheckNetworkConnection()
    {
    }

    public static boolean isConnectionAvailable(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context != null)
        {
            context = context.getActiveNetworkInfo();
            if (context != null && context.isConnected() && context.isConnectedOrConnecting() && context.isAvailable())
            {
                return true;
            }
        }
        return false;
    }
}
