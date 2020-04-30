// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import com.inponsel.android.utils.Log;
import com.inponsel.android.v2.HomeNewMainActivity;

// Referenced classes of package com.inponsel.android.details:
//            DetailsPonsel

class this._cls0
    implements android.content.OnClickListener
{

    final DetailsPonsel this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (notif.equals("gcm") || notif.equals("email"))
        {
            Log.e("finish", "1");
            dialoginterface = new Intent(DetailsPonsel.this, com/inponsel/android/v2/HomeNewMainActivity);
            dialoginterface.addFlags(32768);
            dialoginterface.addFlags(0x10000000);
            startActivity(dialoginterface);
            finish();
            overridePendingTransition(0x7f040001, 0x7f040002);
            return;
        } else
        {
            finish();
            overridePendingTransition(0x7f040001, 0x7f040002);
            Log.e("finish", "2");
            return;
        }
    }

    er()
    {
        this$0 = DetailsPonsel.this;
        super();
    }
}
