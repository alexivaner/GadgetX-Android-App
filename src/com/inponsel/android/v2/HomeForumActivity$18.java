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

class val.tl_type
    implements android.view.ctivity._cls18
{

    final HomeForumActivity this$0;
    private final String val$tl_id;
    private final String val$tl_type;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(HomeForumActivity.this))
        {
            statuslike = "1";
            idkom_pos = val$tl_id;
            id_type = val$tl_type;
            querylike = (new StringBuilder("status=")).append(statuslike).append("&tl_id=").append(idkom_pos).append("&id_usr=").append(HomeForumActivity.user_id).append("&type=").append(id_type).append("&t=").append(t).toString();
            Log.e("querylike", querylike);
            if (android.os. >= 11)
            {
                (new tBagusKurangTask(HomeForumActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new tBagusKurangTask(HomeForumActivity.this)).execute(new Void[0]);
                return;
            }
        } else
        {
            view = new android.app.init>(wrapperLight);
            view.etMessage("Untuk memberi penilaian harus login terlebih dahulu.");
            view.etPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final HomeForumActivity._cls18 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = HomeForumActivity._cls18.this;
                super();
            }
            });
            view.etNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

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
            });
            view.etNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final HomeForumActivity._cls18 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = HomeForumActivity._cls18.this;
                super();
            }
            });
            view.how();
            return;
        }
    }


    _cls3.this._cls1()
    {
        this$0 = final_homeforumactivity;
        val$tl_id = s;
        val$tl_type = String.this;
        super();
    }
}
