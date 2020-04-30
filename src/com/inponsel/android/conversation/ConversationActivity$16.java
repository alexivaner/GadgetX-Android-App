// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationActivity

class val.tl_type
    implements android.view.versationActivity._cls16
{

    final ConversationActivity this$0;
    private final String val$tl_id;
    private final String val$tl_type;

    public void onClick(View view)
    {
        idkom_pos = val$tl_id;
        id_type = val$tl_type;
        if (userFunctions.isUserLoggedIn(ConversationActivity.this))
        {
            view = new android.app.t>(ConversationActivity.this);
            view.essage("Laporkan konten ini karena tidak sesuai atau mengandung SARA?");
            view.ositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final ConversationActivity._cls16 this$1;
                private final String val$tl_type;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    queryFlag = (new StringBuilder("id_artanya=")).append(idkom_pos).append("&id_usr=").append(ConversationActivity.user_id).append("&type=").append(tl_type).append("&t=").append(t).toString();
                    Log.e("queryFlag", queryFlag);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new ConversationActivity.PostFlagTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new ConversationActivity.PostFlagTask(this$0)).execute(new Void[0]);
                        return;
                    }
                }

            
            {
                this$1 = ConversationActivity._cls16.this;
                tl_type = s;
                super();
            }
            });
            view.egativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                final ConversationActivity._cls16 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = ConversationActivity._cls16.this;
                super();
            }
            });
            view.();
            return;
        } else
        {
            view = new android.app.t>(ConversationActivity.this);
            view.essage("Untuk memberi laporan harus login terlebih dahulu.");
            view.ositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final ConversationActivity._cls16 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = ConversationActivity._cls16.this;
                super();
            }
            });
            view.eutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final ConversationActivity._cls16 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = ConversationActivity._cls16.this;
                super();
            }
            });
            view.egativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final ConversationActivity._cls16 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = ConversationActivity._cls16.this;
                super();
            }
            });
            view.();
            return;
        }
    }


    _cls5.this._cls1()
    {
        this$0 = final_conversationactivity;
        val$tl_id = s;
        val$tl_type = String.this;
        super();
    }
}
