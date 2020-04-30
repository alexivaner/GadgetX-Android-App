// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumInteraksiActivity

class this._cls2
    implements android.content.eplyAsycTask._cls4._cls1
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

    // Unreferenced inner class com/inponsel/android/globalforum/ForumInteraksiActivity$KomentarReplyAsycTask$4

/* anonymous class */
    class ForumInteraksiActivity.KomentarReplyAsycTask._cls4
        implements android.view.View.OnClickListener
    {

        final ForumInteraksiActivity.KomentarReplyAsycTask this$1;
        private final String val$id_komrss;
        private final String val$tl_id;

        public void onClick(View view)
        {
            if (ForumInteraksiActivity.KomentarReplyAsycTask.access$2(ForumInteraksiActivity.KomentarReplyAsycTask.this).userFunctions.isUserLoggedIn(ForumInteraksiActivity.KomentarReplyAsycTask.access$2(ForumInteraksiActivity.KomentarReplyAsycTask.this)))
            {
                ForumInteraksiActivity.KomentarReplyAsycTask.access$2(ForumInteraksiActivity.KomentarReplyAsycTask.this).statuslike = "0";
                ForumInteraksiActivity.KomentarReplyAsycTask.access$2(ForumInteraksiActivity.KomentarReplyAsycTask.this).idkom_pos = id_komrss;
                ForumInteraksiActivity.KomentarReplyAsycTask.access$2(ForumInteraksiActivity.KomentarReplyAsycTask.this).querylike = (new StringBuilder("status=")).append(ForumInteraksiActivity.KomentarReplyAsycTask.access$2(ForumInteraksiActivity.KomentarReplyAsycTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(ForumInteraksiActivity.KomentarReplyAsycTask.access$2(ForumInteraksiActivity.KomentarReplyAsycTask.this).user_id).append("&t=").append(ForumInteraksiActivity.KomentarReplyAsycTask.access$2(ForumInteraksiActivity.KomentarReplyAsycTask.this).t).toString();
                Log.e("querylike", ForumInteraksiActivity.KomentarReplyAsycTask.access$2(ForumInteraksiActivity.KomentarReplyAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new ForumInteraksiActivity.PostBagusKurangTask(ForumInteraksiActivity.KomentarReplyAsycTask.access$2(ForumInteraksiActivity.KomentarReplyAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new ForumInteraksiActivity.PostBagusKurangTask(ForumInteraksiActivity.KomentarReplyAsycTask.access$2(ForumInteraksiActivity.KomentarReplyAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(ForumInteraksiActivity.KomentarReplyAsycTask.access$2(ForumInteraksiActivity.KomentarReplyAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new ForumInteraksiActivity.KomentarReplyAsycTask._cls4._cls1());
                view.setNeutralButton("Register", new ForumInteraksiActivity.KomentarReplyAsycTask._cls4._cls2());
                view.setNegativeButton("Login", new ForumInteraksiActivity.KomentarReplyAsycTask._cls4._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarreplyasyctask;
                id_komrss = s;
                tl_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/globalforum/ForumInteraksiActivity$KomentarReplyAsycTask$4$2

/* anonymous class */
        class ForumInteraksiActivity.KomentarReplyAsycTask._cls4._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumInteraksiActivity.KomentarReplyAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ForumInteraksiActivity.KomentarReplyAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                ForumInteraksiActivity.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = ForumInteraksiActivity.KomentarReplyAsycTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/globalforum/ForumInteraksiActivity$KomentarReplyAsycTask$4$3

/* anonymous class */
        class ForumInteraksiActivity.KomentarReplyAsycTask._cls4._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumInteraksiActivity.KomentarReplyAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ForumInteraksiActivity.KomentarReplyAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                ForumInteraksiActivity.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = ForumInteraksiActivity.KomentarReplyAsycTask._cls4.this;
                        super();
                    }
        }

    }

}
