// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

public class this._cls0 extends BroadcastReceiver
{

    final HomeNewsActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if ("Wi-Fi".equals(HomeNewsActivity.sPref) && context != null && context.getType() == 1)
        {
            HomeNewsActivity.refreshDisplay = true;
            return;
        }
        if (context != null && context.isConnected())
        {
            HomeNewsActivity.refreshDisplay = true;
            return;
        }
        if ("Any".equals(HomeNewsActivity.sPref) && context != null)
        {
            HomeNewsActivity.refreshDisplay = true;
            return;
        } else
        {
            HomeNewsActivity.refreshDisplay = false;
            HomeNewsActivity.access$3(HomeNewsActivity.this);
            return;
        }
    }

    public ()
    {
        this$0 = HomeNewsActivity.this;
        super();
    }
}
