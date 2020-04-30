// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.globalforum.PostGlobalForum;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            LoginActivity, HomeForumActivity, RegisterActivity

class this._cls1
    implements android.content.kListener
{

    final tActivity this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        startActivity(dialoginterface);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$8

/* anonymous class */
    class HomeForumActivity._cls8
        implements android.view.View.OnClickListener
    {

        final HomeForumActivity this$0;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(getApplicationContext()))
            {
                view = new Intent(HomeForumActivity.this, com/inponsel/android/globalforum/PostGlobalForum);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapperLight);
                view.setMessage("Untuk membuat artikel harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new HomeForumActivity._cls8._cls1());
                view.setNeutralButton("Register", new HomeForumActivity._cls8._cls2());
                view.setNegativeButton("Login", new HomeForumActivity._cls8._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$0 = HomeForumActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$8$1

/* anonymous class */
        class HomeForumActivity._cls8._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity._cls8 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = HomeForumActivity._cls8.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$8$2

/* anonymous class */
        class HomeForumActivity._cls8._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity._cls8 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = HomeForumActivity._cls8.this;
                        super();
                    }
        }

    }

}
