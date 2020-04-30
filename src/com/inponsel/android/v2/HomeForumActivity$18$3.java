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
//            LoginActivity, HomeForumActivity, RegisterActivity

class this._cls1
    implements android.content.Listener
{

    final Activity this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        startActivity(dialoginterface);
    }

    l.tl_type()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$18

/* anonymous class */
    class HomeForumActivity._cls18
        implements android.view.View.OnClickListener
    {

        final HomeForumActivity this$0;
        private final String val$tl_id;
        private final String val$tl_type;

        public void onClick(View view)
        {
            if (userFunctions.isUserLoggedIn(HomeForumActivity.this))
            {
                statuslike = "1";
                idkom_pos = tl_id;
                id_type = tl_type;
                querylike = (new StringBuilder("status=")).append(statuslike).append("&tl_id=").append(idkom_pos).append("&id_usr=").append(HomeForumActivity.user_id).append("&type=").append(id_type).append("&t=").append(t).toString();
                Log.e("querylike", querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new HomeForumActivity.PostBagusKurangTask(HomeForumActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new HomeForumActivity.PostBagusKurangTask(HomeForumActivity.this)).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new HomeForumActivity._cls18._cls1());
                view.setNeutralButton("Register", new HomeForumActivity._cls18._cls2());
                view.setNegativeButton("Login", new HomeForumActivity._cls18._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$0 = final_homeforumactivity;
                tl_id = s;
                tl_type = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$18$1

/* anonymous class */
        class HomeForumActivity._cls18._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity._cls18 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = HomeForumActivity._cls18.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeForumActivity$18$2

/* anonymous class */
        class HomeForumActivity._cls18._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeForumActivity._cls18 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivity(dialoginterface);
            }

                    
                    {
                        this$1 = HomeForumActivity._cls18.this;
                        super();
                    }
        }

    }

}
