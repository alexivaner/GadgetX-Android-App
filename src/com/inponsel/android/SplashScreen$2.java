// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.inponsel.android:
//            SplashScreen

class this._cls0
    implements android.content..OnClickListener
{

    final SplashScreen this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (isTablet(getApplicationContext()))
        {
            intent = new Intent("android.settings.WIFI_SETTINGS");
        } else
        {
            intent = new Intent("android.settings.DATA_ROAMING_SETTINGS");
            intent.addCategory("android.intent.category.LAUNCHER");
            dialoginterface = new ComponentName("com.android.phone", "com.android.phone.Settings");
            intent.setComponent(dialoginterface);
        }
        intent.setFlags(0x10000000);
        startActivityForResult(intent, 10);
    }

    ickListener()
    {
        this$0 = SplashScreen.this;
        super();
    }
}
