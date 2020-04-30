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

class this._cls1
    implements android.content.tener
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.tl_type()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/conversation/ConversationActivity$16

/* anonymous class */
    class ConversationActivity._cls16
        implements android.view.View.OnClickListener
    {

        final ConversationActivity this$0;
        private final String val$tl_id;
        private final String val$tl_type;

        public void onClick(View view)
        {
            idkom_pos = tl_id;
            id_type = tl_type;
            if (userFunctions.isUserLoggedIn(ConversationActivity.this))
            {
                view = new android.app.AlertDialog.Builder(ConversationActivity.this);
                view.setMessage("Laporkan konten ini karena tidak sesuai atau mengandung SARA?");
                view.setPositiveButton("Ya", new ConversationActivity._cls16._cls1());
                view.setNegativeButton("Batal", new ConversationActivity._cls16._cls2());
                view.show();
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(ConversationActivity.this);
                view.setMessage("Untuk memberi laporan harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new ConversationActivity._cls16._cls3());
                view.setNeutralButton("Register", new ConversationActivity._cls16._cls4());
                view.setNegativeButton("Login", new ConversationActivity._cls16._cls5());
                view.show();
                return;
            }
        }


            
            {
                this$0 = final_conversationactivity;
                tl_id = s;
                tl_type = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/conversation/ConversationActivity$16$1

/* anonymous class */
        class ConversationActivity._cls16._cls1
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationActivity$16$3

/* anonymous class */
        class ConversationActivity._cls16._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationActivity._cls16 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = ConversationActivity._cls16.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationActivity$16$4

/* anonymous class */
        class ConversationActivity._cls16._cls4
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationActivity$16$5

/* anonymous class */
        class ConversationActivity._cls16._cls5
            implements android.content.DialogInterface.OnClickListener
        {

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
        }

    }

}
