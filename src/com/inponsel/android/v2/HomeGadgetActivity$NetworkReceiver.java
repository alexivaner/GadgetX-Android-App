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
//            HomeGadgetActivity

public class this._cls0 extends BroadcastReceiver
{

    final HomeGadgetActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if ("Wi-Fi".equals(HomeGadgetActivity.sPref) && context != null && context.getType() == 1)
        {
            HomeGadgetActivity.refreshDisplay = true;
            return;
        }
        if (context != null && context.isConnected())
        {
            HomeGadgetActivity.refreshDisplay = true;
            return;
        }
        if ("Any".equals(HomeGadgetActivity.sPref) && context != null)
        {
            HomeGadgetActivity.refreshDisplay = true;
            return;
        } else
        {
            HomeGadgetActivity.refreshDisplay = false;
            HomeGadgetActivity.access$0(HomeGadgetActivity.this);
            return;
        }
    }

    public ()
    {
        this$0 = HomeGadgetActivity.this;
        super();
    }
}
