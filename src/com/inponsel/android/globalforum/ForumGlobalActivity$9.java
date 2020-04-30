// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity, PostGlobalForum

class this._cls0
    implements android.view.rumGlobalActivity._cls9
{

    final ForumGlobalActivity this$0;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            view = new Intent(ForumGlobalActivity.this, com/inponsel/android/globalforum/PostGlobalForum);
            startActivityForResult(view, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        } else
        {
            view = new android.app.nit>(wrapperLight);
            view.tMessage("Untuk membuat artikel harus login terlebih dahulu.");
            view.tPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final ForumGlobalActivity._cls9 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = ForumGlobalActivity._cls9.this;
                super();
            }
            });
            view.tNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final ForumGlobalActivity._cls9 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = ForumGlobalActivity._cls9.this;
                super();
            }
            });
            view.tNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final ForumGlobalActivity._cls9 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = ForumGlobalActivity._cls9.this;
                super();
            }
            });
            view.ow();
            return;
        }
    }


    _cls3.this._cls1()
    {
        this$0 = ForumGlobalActivity.this;
        super();
    }
}
