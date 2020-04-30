// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity, NotificationCenterActivity

class enuItemStuffListener extends enuItemStuffListener
{

    final HomeNewMainActivity this$0;

    public void onClick(View view)
    {
        txt_notif_count.setVisibility(4);
        img_Notification.setBackgroundResource(0x7f02021f);
        view = new Intent(HomeNewMainActivity.this, com/inponsel/android/v2/NotificationCenterActivity);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ity(View view, String s)
    {
        this$0 = HomeNewMainActivity.this;
        super(view, s);
    }
}
