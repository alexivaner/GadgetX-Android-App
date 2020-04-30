// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            HomeForumActivity, RegisterActivity, LoginActivity

class this._cls2
    implements android.content.stener
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    tl_type()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$19

/* anonymous class */
    class HomeForumActivity._cls19
        implements android.view.View.OnClickListener
    {

        final HomeForumActivity this$0;
        private final String val$tl_id;
        private final String val$tl_type;

        public void onClick(View view)
        {
            idkom_pos = tl_id;
            id_type = tl_type;
            view = new android.app.AlertDialog.Builder(HomeForumActivity.this);
            view.setMessage("Laporkan konten ini karena tidak sesuai atau mengandung SARA?");
            view.setPositiveButton("Ya", tl_type. new HomeForumActivity._cls19._cls1());
            view.setNegativeButton("Batal", new HomeForumActivity._cls19._cls2());
            view.show();
        }


            
            {
                this$0 = final_homeforumactivity;
                tl_id = s;
                tl_type = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$19$2

/* anonymous class */
        class HomeForumActivity._cls19._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity._cls19 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = HomeForumActivity._cls19.this;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$19$1

/* anonymous class */
    class HomeForumActivity._cls19._cls1
        implements android.content.DialogInterface.OnClickListener
    {

        final HomeForumActivity._cls19 this$1;
        private final String val$tl_type;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            if (userFunctions.isUserLoggedIn(this$0))
            {
                queryFlag = (new StringBuilder("id_artanya=")).append(idkom_pos).append("&id_usr=").append(HomeForumActivity.user_id).append("&type=").append(tl_type).append("&t=").append(t).toString();
                Log.e("queryFlag", queryFlag);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new HomeForumActivity.PostFlagTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new HomeForumActivity.PostFlagTask(this$0)).execute(new Void[0]);
                    return;
                }
            } else
            {
                dialoginterface = new android.app.AlertDialog.Builder(this$0);
                dialoginterface.setMessage("Untuk memberi laporan harus login terlebih dahulu.");
                dialoginterface.setPositiveButton("Tutup", new HomeForumActivity._cls19._cls1._cls1());
                dialoginterface.setNeutralButton("Register", new HomeForumActivity._cls19._cls1._cls2());
                dialoginterface.setNegativeButton("Login", new HomeForumActivity._cls19._cls1._cls3());
                dialoginterface.show();
                return;
            }
        }


            
            {
                this$1 = final__pcls19;
                tl_type = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$19$1$2

/* anonymous class */
        class HomeForumActivity._cls19._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity._cls19._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = HomeForumActivity._cls19._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$19$1$3

/* anonymous class */
        class HomeForumActivity._cls19._cls1._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity._cls19._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = HomeForumActivity._cls19._cls1.this;
                        super();
                    }
        }

    }

}
