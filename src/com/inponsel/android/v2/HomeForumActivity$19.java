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
    implements android.view.ctivity._cls19
{

    final HomeForumActivity this$0;
    private final String val$tl_id;
    private final String val$tl_type;

    public void onClick(View view)
    {
        idkom_pos = val$tl_id;
        id_type = val$tl_type;
        view = new android.app.init>(HomeForumActivity.this);
        view.etMessage("Laporkan konten ini karena tidak sesuai atau mengandung SARA?");
        view.etPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

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
                    dialoginterface.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                    dialoginterface.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                    dialoginterface.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                    dialoginterface.show();
                    return;
                }
            }


            
            {
                this$1 = HomeForumActivity._cls19.this;
                tl_type = s;
                super();
            }
        });
        view.etNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

            final HomeForumActivity._cls19 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$1 = HomeForumActivity._cls19.this;
                super();
            }
        });
        view.how();
    }


    _cls2.this._cls1()
    {
        this$0 = final_homeforumactivity;
        val$tl_id = s;
        val$tl_type = String.this;
        super();
    }
}
