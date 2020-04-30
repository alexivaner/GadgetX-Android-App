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
//            HomeNewsActivity, RegisterActivity, LoginActivity

class this._cls1
    implements android.content.ckListener
{

    final er this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeNewsActivity$5

/* anonymous class */
    class HomeNewsActivity._cls5
        implements android.view.View.OnClickListener
    {

        final HomeNewsActivity this$0;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(getApplicationContext()))
            {
                statusLikeHp = "1";
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new HomeNewsActivity.PostBagusKurangTask(HomeNewsActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new HomeNewsActivity.PostBagusKurangTask(HomeNewsActivity.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(HomeNewsActivity.this);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new HomeNewsActivity._cls5._cls1());
                view.setNeutralButton("Register", new HomeNewsActivity._cls5._cls2());
                view.setNegativeButton("Login", new HomeNewsActivity._cls5._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeNewsActivity$5$2

/* anonymous class */
        class HomeNewsActivity._cls5._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeNewsActivity._cls5 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = HomeNewsActivity._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeNewsActivity$5$3

/* anonymous class */
        class HomeNewsActivity._cls5._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeNewsActivity._cls5 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = HomeNewsActivity._cls5.this;
                        super();
                    }
        }

    }

}
