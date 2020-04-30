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
    implements android.content.arOldAsycTask._cls6._cls2
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/RegisterActivity);
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.tl_id()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/conversation/ConversationInteraksiActivity$KomentarOldAsycTask$6

/* anonymous class */
    class ConversationInteraksiActivity.KomentarOldAsycTask._cls6
        implements android.view.View.OnClickListener
    {

        final ConversationInteraksiActivity.KomentarOldAsycTask this$1;
        private final String val$id_komrss;
        private final String val$tl_id;

        public void onClick(View view)
        {
            if (ConversationInteraksiActivity.KomentarOldAsycTask.access$2(ConversationInteraksiActivity.KomentarOldAsycTask.this).userFunctions.isUserLoggedIn(ConversationInteraksiActivity.KomentarOldAsycTask.access$2(ConversationInteraksiActivity.KomentarOldAsycTask.this)))
            {
                ConversationInteraksiActivity.KomentarOldAsycTask.access$2(ConversationInteraksiActivity.KomentarOldAsycTask.this).statuslike = "0";
                ConversationInteraksiActivity.KomentarOldAsycTask.access$2(ConversationInteraksiActivity.KomentarOldAsycTask.this).idkom_pos = id_komrss;
                ConversationInteraksiActivity.KomentarOldAsycTask.access$2(ConversationInteraksiActivity.KomentarOldAsycTask.this).querylike = (new StringBuilder("status=")).append(ConversationInteraksiActivity.KomentarOldAsycTask.access$2(ConversationInteraksiActivity.KomentarOldAsycTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(ConversationInteraksiActivity.KomentarOldAsycTask.access$2(ConversationInteraksiActivity.KomentarOldAsycTask.this).user_id).append("&t=").append(ConversationInteraksiActivity.KomentarOldAsycTask.access$2(ConversationInteraksiActivity.KomentarOldAsycTask.this).t).toString();
                Log.e("querylike", ConversationInteraksiActivity.KomentarOldAsycTask.access$2(ConversationInteraksiActivity.KomentarOldAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new ConversationInteraksiActivity.PostBagusKurangTask(ConversationInteraksiActivity.KomentarOldAsycTask.access$2(ConversationInteraksiActivity.KomentarOldAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new ConversationInteraksiActivity.PostBagusKurangTask(ConversationInteraksiActivity.KomentarOldAsycTask.access$2(ConversationInteraksiActivity.KomentarOldAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(ConversationInteraksiActivity.KomentarOldAsycTask.access$2(ConversationInteraksiActivity.KomentarOldAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new ConversationInteraksiActivity.KomentarOldAsycTask._cls6._cls1());
                view.setNeutralButton("Register", new ConversationInteraksiActivity.KomentarOldAsycTask._cls6._cls2());
                view.setNegativeButton("Login", new ConversationInteraksiActivity.KomentarOldAsycTask._cls6._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentaroldasyctask;
                id_komrss = s;
                tl_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/conversation/ConversationInteraksiActivity$KomentarOldAsycTask$6$1

/* anonymous class */
        class ConversationInteraksiActivity.KomentarOldAsycTask._cls6._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationInteraksiActivity.KomentarOldAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = ConversationInteraksiActivity.KomentarOldAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/conversation/ConversationInteraksiActivity$KomentarOldAsycTask$6$3

/* anonymous class */
        class ConversationInteraksiActivity.KomentarOldAsycTask._cls6._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final ConversationInteraksiActivity.KomentarOldAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ConversationInteraksiActivity.KomentarOldAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                ConversationInteraksiActivity.KomentarOldAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = ConversationInteraksiActivity.KomentarOldAsycTask._cls6.this;
                        super();
                    }
        }

    }

}
