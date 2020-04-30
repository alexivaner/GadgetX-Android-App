// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            LoginActivity, HomeNewMainActivity, RegisterActivity

class this._cls1
    implements android.content.stener
{

    final idePendingTransition this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        startActivityForResult(dialoginterface, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$30

/* anonymous class */
    class HomeNewMainActivity._cls30
        implements android.view.View.OnClickListener
    {

        final HomeNewMainActivity this$0;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(getApplicationContext()))
            {
                statusLikeHp = "0";
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new HomeNewMainActivity.PostBagusKurangTask(HomeNewMainActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new HomeNewMainActivity.PostBagusKurangTask(HomeNewMainActivity.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(HomeNewMainActivity.this);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new HomeNewMainActivity._cls30._cls1());
                view.setNeutralButton("Register", new HomeNewMainActivity._cls30._cls2());
                view.setNegativeButton("Login", new HomeNewMainActivity._cls30._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$0 = HomeNewMainActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$30$1

/* anonymous class */
        class HomeNewMainActivity._cls30._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeNewMainActivity._cls30 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = HomeNewMainActivity._cls30.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewMainActivity$30$2

/* anonymous class */
        class HomeNewMainActivity._cls30._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeNewMainActivity._cls30 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = HomeNewMainActivity._cls30.this;
                        super();
                    }
        }

    }

}
