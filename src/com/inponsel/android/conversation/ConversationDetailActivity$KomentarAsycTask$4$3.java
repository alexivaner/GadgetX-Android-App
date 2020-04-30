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
//            ConversationDetailActivity

class this._cls2
    implements android.content.entarAsycTask._cls4._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.tl_id()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/conversation/ConversationDetailActivity$KomentarAsycTask$4

/* anonymous class */
    class ConversationDetailActivity.KomentarAsycTask._cls4
        implements android.view.View.OnClickListener
    {

        final ConversationDetailActivity.KomentarAsycTask this$1;
        private final String val$id_komrss;
        private final String val$tl_id;

        public void onClick(View view)
        {
            if (ConversationDetailActivity.KomentarAsycTask.access$2(ConversationDetailActivity.KomentarAsycTask.this).userFunctions.isUserLoggedIn(ConversationDetailActivity.KomentarAsycTask.access$2(ConversationDetailActivity.KomentarAsycTask.this)))
            {
                ConversationDetailActivity.KomentarAsycTask.access$2(ConversationDetailActivity.KomentarAsycTask.this).statuslike = "1";
                ConversationDetailActivity.KomentarAsycTask.access$2(ConversationDetailActivity.KomentarAsycTask.this).idkom_pos = id_komrss;
                ConversationDetailActivity.KomentarAsycTask.access$2(ConversationDetailActivity.KomentarAsycTask.this).querylikeKomen = (new StringBuilder("status=")).append(ConversationDetailActivity.KomentarAsycTask.access$2(ConversationDetailActivity.KomentarAsycTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(ConversationDetailActivity.KomentarAsycTask.access$2(ConversationDetailActivity.KomentarAsycTask.this).id_artikel).append("&tl_id=").append(tl_id).append("&id_usr=").append(ConversationDetailActivity.KomentarAsycTask.access$2(ConversationDetailActivity.KomentarAsycTask.this).user_id).append("&t=").append(ConversationDetailActivity.KomentarAsycTask.access$2(ConversationDetailActivity.KomentarAsycTask.this).t).toString();
                Log.e("querylike", ConversationDetailActivity.KomentarAsycTask.access$2(ConversationDetailActivity.KomentarAsycTask.this).querylikeKomen);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new ConversationDetailActivity.PostBagusKurangKomenTask(ConversationDetailActivity.KomentarAsycTask.access$2(ConversationDetailActivity.KomentarAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new ConversationDetailActivity.PostBagusKurangKomenTask(ConversationDetailActivity.KomentarAsycTask.access$2(ConversationDetailActivity.KomentarAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(ConversationDetailActivity.KomentarAsycTask.access$2(ConversationDetailActivity.KomentarAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new ConversationDetailActivity.KomentarAsycTask._cls4._cls1());
                view.setNeutralButton("Register", new ConversationDetailActivity.KomentarAsycTask._cls4._cls2());
                view.setNegativeButton("Login", new ConversationDetailActivity.KomentarAsycTask._cls4._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasyctask;
                id_komrss = s;
                tl_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/conversation/ConversationDetailActivity$KomentarAsycTask$4$1

/* anonymous class */
        class ConversationDetailActivity.KomentarAsycTask._cls4._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationDetailActivity.KomentarAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = ConversationDetailActivity.KomentarAsycTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationDetailActivity$KomentarAsycTask$4$2

/* anonymous class */
        class ConversationDetailActivity.KomentarAsycTask._cls4._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationDetailActivity.KomentarAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ConversationDetailActivity.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                ConversationDetailActivity.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = ConversationDetailActivity.KomentarAsycTask._cls4.this;
                        super();
                    }
        }

    }

}
