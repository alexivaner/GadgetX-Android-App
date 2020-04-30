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
//            ConversationInteraksiActivity

class this._cls2
    implements android.content.AsycAfterTask._cls3._cls1
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.tl_id()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/conversation/ConversationInteraksiActivity$KomentarAsycAfterTask$3

/* anonymous class */
    class ConversationInteraksiActivity.KomentarAsycAfterTask._cls3
        implements android.view.View.OnClickListener
    {

        final ConversationInteraksiActivity.KomentarAsycAfterTask this$1;
        private final String val$id_komrss;
        private final String val$tl_id;

        public void onClick(View view)
        {
            if (ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(ConversationInteraksiActivity.KomentarAsycAfterTask.this).userFunctions.isUserLoggedIn(ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(ConversationInteraksiActivity.KomentarAsycAfterTask.this)))
            {
                ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(ConversationInteraksiActivity.KomentarAsycAfterTask.this).statuslike = "1";
                ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(ConversationInteraksiActivity.KomentarAsycAfterTask.this).idkom_pos = id_komrss;
                ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(ConversationInteraksiActivity.KomentarAsycAfterTask.this).querylike = (new StringBuilder("status=")).append(ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(ConversationInteraksiActivity.KomentarAsycAfterTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(ConversationInteraksiActivity.KomentarAsycAfterTask.this).user_id).append("&t=").append(ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(ConversationInteraksiActivity.KomentarAsycAfterTask.this).t).toString();
                Log.e("querylike", ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(ConversationInteraksiActivity.KomentarAsycAfterTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new ConversationInteraksiActivity.PostBagusKurangTask(ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(ConversationInteraksiActivity.KomentarAsycAfterTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new ConversationInteraksiActivity.PostBagusKurangTask(ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(ConversationInteraksiActivity.KomentarAsycAfterTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(ConversationInteraksiActivity.KomentarAsycAfterTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new ConversationInteraksiActivity.KomentarAsycAfterTask._cls3._cls1());
                view.setNeutralButton("Register", new ConversationInteraksiActivity.KomentarAsycAfterTask._cls3._cls2());
                view.setNegativeButton("Login", new ConversationInteraksiActivity.KomentarAsycAfterTask._cls3._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasycaftertask;
                id_komrss = s;
                tl_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/conversation/ConversationInteraksiActivity$KomentarAsycAfterTask$3$2

/* anonymous class */
        class ConversationInteraksiActivity.KomentarAsycAfterTask._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationInteraksiActivity.KomentarAsycAfterTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = ConversationInteraksiActivity.KomentarAsycAfterTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationInteraksiActivity$KomentarAsycAfterTask$3$3

/* anonymous class */
        class ConversationInteraksiActivity.KomentarAsycAfterTask._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationInteraksiActivity.KomentarAsycAfterTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                ConversationInteraksiActivity.KomentarAsycAfterTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = ConversationInteraksiActivity.KomentarAsycAfterTask._cls3.this;
                        super();
                    }
        }

    }

}
