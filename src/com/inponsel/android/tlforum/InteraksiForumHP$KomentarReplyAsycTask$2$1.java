// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.tlforum:
//            InteraksiForumHP

class this._cls2
    implements android.content.AsycTask._cls2._cls1
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

    // Unreferenced inner class com/inponsel/android/tlforum/InteraksiForumHP$KomentarReplyAsycTask$2

/* anonymous class */
    class InteraksiForumHP.KomentarReplyAsycTask._cls2
        implements android.view.View.OnClickListener
    {

        final InteraksiForumHP.KomentarReplyAsycTask this$1;
        private final String val$id_komrss;
        private final String val$tl_id;

        public void onClick(View view)
        {
            if (InteraksiForumHP.KomentarReplyAsycTask.access$2(InteraksiForumHP.KomentarReplyAsycTask.this).userFunctions.isUserLoggedIn(InteraksiForumHP.KomentarReplyAsycTask.access$2(InteraksiForumHP.KomentarReplyAsycTask.this)))
            {
                InteraksiForumHP.KomentarReplyAsycTask.access$2(InteraksiForumHP.KomentarReplyAsycTask.this).statuslike = "1";
                InteraksiForumHP.KomentarReplyAsycTask.access$2(InteraksiForumHP.KomentarReplyAsycTask.this).idkom_pos = id_komrss;
                InteraksiForumHP.KomentarReplyAsycTask.access$2(InteraksiForumHP.KomentarReplyAsycTask.this).querylike = (new StringBuilder("status=")).append(InteraksiForumHP.KomentarReplyAsycTask.access$2(InteraksiForumHP.KomentarReplyAsycTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(InteraksiForumHP.KomentarReplyAsycTask.access$2(InteraksiForumHP.KomentarReplyAsycTask.this).user_id).append("&t=").append(InteraksiForumHP.KomentarReplyAsycTask.access$2(InteraksiForumHP.KomentarReplyAsycTask.this).t).toString();
                Log.e("querylike", InteraksiForumHP.KomentarReplyAsycTask.access$2(InteraksiForumHP.KomentarReplyAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new InteraksiForumHP.PostBagusKurangTask(InteraksiForumHP.KomentarReplyAsycTask.access$2(InteraksiForumHP.KomentarReplyAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new InteraksiForumHP.PostBagusKurangTask(InteraksiForumHP.KomentarReplyAsycTask.access$2(InteraksiForumHP.KomentarReplyAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(InteraksiForumHP.KomentarReplyAsycTask.access$2(InteraksiForumHP.KomentarReplyAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new InteraksiForumHP.KomentarReplyAsycTask._cls2._cls1());
                view.setNeutralButton("Register", new InteraksiForumHP.KomentarReplyAsycTask._cls2._cls2());
                view.setNegativeButton("Login", new InteraksiForumHP.KomentarReplyAsycTask._cls2._cls3());
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

        // Unreferenced inner class com/inponsel/android/tlforum/InteraksiForumHP$KomentarReplyAsycTask$2$2

/* anonymous class */
        class InteraksiForumHP.KomentarReplyAsycTask._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final InteraksiForumHP.KomentarReplyAsycTask._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(InteraksiForumHP.KomentarReplyAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                InteraksiForumHP.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = InteraksiForumHP.KomentarReplyAsycTask._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/tlforum/InteraksiForumHP$KomentarReplyAsycTask$2$3

/* anonymous class */
        class InteraksiForumHP.KomentarReplyAsycTask._cls2._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final InteraksiForumHP.KomentarReplyAsycTask._cls2 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(InteraksiForumHP.KomentarReplyAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                InteraksiForumHP.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = InteraksiForumHP.KomentarReplyAsycTask._cls2.this;
                        super();
                    }
        }

    }

}
