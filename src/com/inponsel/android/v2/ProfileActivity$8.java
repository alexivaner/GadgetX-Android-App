// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.DatabaseHandler;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity, HomeNewMainActivity

class this._cls0
    implements android.view.er
{

    final ProfileActivity this$0;

    public void onClick(View view)
    {
        view = new android.app.r(wrapper);
        view.setTitle("Logout InPonsel");
        view.setMessage("Ingin logout dari InPonsel?");
        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

            final ProfileActivity._cls8 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                ProfileActivity.access$8(this$0, "0");
                notifManager.cancelAll();
                db.resetUnreadMSGTables();
                db.removeAll();
                dialoginterface = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewMainActivity);
                dialoginterface.addFlags(0x4000000);
                dialoginterface.addFlags(32768);
                startActivity(dialoginterface);
                finish();
            }

            
            {
                this$1 = ProfileActivity._cls8.this;
                super();
            }
        });
        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

            final ProfileActivity._cls8 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = ProfileActivity._cls8.this;
                super();
            }
        });
        view.show();
    }


    _cls2.this._cls1()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
