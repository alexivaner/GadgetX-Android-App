// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.crashlytics.android.core:
//            DevicePowerStateListener

class this._cls0 extends BroadcastReceiver
{

    final DevicePowerStateListener this$0;

    public void onReceive(Context context, Intent intent)
    {
        DevicePowerStateListener.access$002(DevicePowerStateListener.this, false);
    }

    ()
    {
        this$0 = DevicePowerStateListener.this;
        super();
    }
}
