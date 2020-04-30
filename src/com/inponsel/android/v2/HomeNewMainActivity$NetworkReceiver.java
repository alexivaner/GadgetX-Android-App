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
//            HomeNewMainActivity

public class this._cls0 extends BroadcastReceiver
{

    final HomeNewMainActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if ("Wi-Fi".equals(HomeNewMainActivity.sPref) && context != null && context.getType() == 1)
        {
            HomeNewMainActivity.refreshDisplay = true;
            return;
        }
        if (context != null && context.isConnected())
        {
            HomeNewMainActivity.refreshDisplay = true;
            return;
        }
        if ("Any".equals(HomeNewMainActivity.sPref) && context != null)
        {
            HomeNewMainActivity.refreshDisplay = true;
            return;
        } else
        {
            HomeNewMainActivity.refreshDisplay = false;
            HomeNewMainActivity.access$0(HomeNewMainActivity.this);
            return;
        }
    }

    public A()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
