// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Connectivity
{

    public Connectivity()
    {
    }

    public static NetworkInfo getNetworkInfo(Context context)
    {
        return ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static boolean isConnected(Context context)
    {
        context = getNetworkInfo(context);
        return context != null && context.isConnected();
    }

    public static boolean isConnectedFast(Context context)
    {
        context = getNetworkInfo(context);
        return context != null && context.isConnected() && isConnectionFast(context.getType(), context.getSubtype());
    }

    public static boolean isConnectedMobile(Context context)
    {
        context = getNetworkInfo(context);
        return context != null && context.isConnected() && context.getType() == 0;
    }

    public static boolean isConnectedWifi(Context context)
    {
        context = getNetworkInfo(context);
        return context != null && context.isConnected() && context.getType() == 1;
    }

    public static boolean isConnectionFast(int i, int j)
    {
        if (i != 1) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (i != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        switch (j)
        {
        default:
            return false;

        case 7: // '\007'
            return false;

        case 4: // '\004'
            return false;

        case 2: // '\002'
            return false;

        case 1: // '\001'
            return false;

        case 11: // '\013'
            return false;

        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
            break;
        }
        if (true) goto _L1; else goto _L3
_L3:
        return false;
    }
}
