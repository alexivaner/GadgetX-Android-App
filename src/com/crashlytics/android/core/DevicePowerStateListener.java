// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

class DevicePowerStateListener
{

    private static final IntentFilter FILTER_BATTERY_CHANGED = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static final IntentFilter FILTER_POWER_CONNECTED = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
    private static final IntentFilter FILTER_POWER_DISCONNECTED = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    private final Context context;
    private boolean isPowerConnected;
    private final BroadcastReceiver powerConnectedReceiver = new BroadcastReceiver() {

        final DevicePowerStateListener this$0;

        public void onReceive(Context context2, Intent intent1)
        {
            isPowerConnected = true;
        }

            
            {
                this$0 = DevicePowerStateListener.this;
                super();
            }
    };
    private final BroadcastReceiver powerDisconnectedReceiver = new BroadcastReceiver() {

        final DevicePowerStateListener this$0;

        public void onReceive(Context context2, Intent intent1)
        {
            isPowerConnected = false;
        }

            
            {
                this$0 = DevicePowerStateListener.this;
                super();
            }
    };
    private final AtomicBoolean receiversRegistered = new AtomicBoolean(true);

    public DevicePowerStateListener(Context context1)
    {
        int i = -1;
        super();
        context = context1;
        Intent intent = context1.registerReceiver(null, FILTER_BATTERY_CHANGED);
        if (intent != null)
        {
            i = intent.getIntExtra("status", -1);
        }
        boolean flag;
        if (i == 2 || i == 5)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isPowerConnected = flag;
        context1.registerReceiver(powerConnectedReceiver, FILTER_POWER_CONNECTED);
        context1.registerReceiver(powerDisconnectedReceiver, FILTER_POWER_DISCONNECTED);
    }

    public void dispose()
    {
        if (!receiversRegistered.getAndSet(false))
        {
            return;
        } else
        {
            context.unregisterReceiver(powerConnectedReceiver);
            context.unregisterReceiver(powerDisconnectedReceiver);
            return;
        }
    }

    public boolean isPowerConnected()
    {
        return isPowerConnected;
    }



/*
    static boolean access$002(DevicePowerStateListener devicepowerstatelistener, boolean flag)
    {
        devicepowerstatelistener.isPowerConnected = flag;
        return flag;
    }

*/
}
