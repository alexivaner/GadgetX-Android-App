// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android:
//            SplashScreen, WakeLocker

class oadcastReceiver extends WakefulBroadcastReceiver
{

    final SplashScreen this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getExtras().getString("message");
        WakeLocker.acquire(getApplicationContext());
        WakeLocker.release();
        Log.e("start", (new StringBuilder("intent")).append(context).toString());
    }

    oadcastReceiver()
    {
        this$0 = SplashScreen.this;
        super();
    }
}
