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
//            HomeGadgetActivity, RegisterActivity, LoginActivity

class this._cls1
    implements android.content.Listener
{

    final  this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeGadgetActivity$5

/* anonymous class */
    class HomeGadgetActivity._cls5
        implements android.view.View.OnClickListener
    {

        final HomeGadgetActivity this$0;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(getApplicationContext()))
            {
                statusLikeHp = "1";
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new HomeGadgetActivity.PostBagusKurangTask(HomeGadgetActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new HomeGadgetActivity.PostBagusKurangTask(HomeGadgetActivity.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(HomeGadgetActivity.this);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new HomeGadgetActivity._cls5._cls1());
                view.setNeutralButton("Register", new HomeGadgetActivity._cls5._cls2());
                view.setNegativeButton("Login", new HomeGadgetActivity._cls5._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeGadgetActivity$5$2

/* anonymous class */
        class HomeGadgetActivity._cls5._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeGadgetActivity._cls5 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = HomeGadgetActivity._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeGadgetActivity$5$3

/* anonymous class */
        class HomeGadgetActivity._cls5._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeGadgetActivity._cls5 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = HomeGadgetActivity._cls5.this;
                        super();
                    }
        }

    }

}
