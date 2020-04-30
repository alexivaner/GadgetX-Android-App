// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity, ProfilePonselUserActivity, RegisterActivity, LoginActivity

class this._cls0
    implements android.view.ctivity._cls31
{

    final HomeNewMainActivity this$0;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(HomeNewMainActivity.this))
        {
            i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfilePonselUserActivity);
            i.putExtra("namalengkap", user_ponsel1);
            startActivityForResult(i, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        } else
        {
            view = new android.app.it>(HomeNewMainActivity.this);
            view.Message("Fitur ini hanya untuk pengguna terdaftar.");
            view.PositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final HomeNewMainActivity._cls31 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = HomeNewMainActivity._cls31.this;
                super();
            }
            });
            view.NeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final HomeNewMainActivity._cls31 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                    startActivityForResult(dialoginterface, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = HomeNewMainActivity._cls31.this;
                super();
            }
            });
            view.NegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final HomeNewMainActivity._cls31 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivityForResult(dialoginterface, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = HomeNewMainActivity._cls31.this;
                super();
            }
            });
            view.w();
            return;
        }
    }


    _cls3.this._cls1()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
