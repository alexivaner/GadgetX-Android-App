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
    implements android.content.fterTask._cls4._cls1
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

    // Unreferenced inner class com/inponsel/android/tlforum/InteraksiForumHP$KomentarAsycAfterTask$4

/* anonymous class */
    class InteraksiForumHP.KomentarAsycAfterTask._cls4
        implements android.view.View.OnClickListener
    {

        final InteraksiForumHP.KomentarAsycAfterTask this$1;
        private final String val$id_komrss;
        private final String val$tl_id;

        public void onClick(View view)
        {
            if (InteraksiForumHP.KomentarAsycAfterTask.access$2(InteraksiForumHP.KomentarAsycAfterTask.this).userFunctions.isUserLoggedIn(InteraksiForumHP.KomentarAsycAfterTask.access$2(InteraksiForumHP.KomentarAsycAfterTask.this)))
            {
                InteraksiForumHP.KomentarAsycAfterTask.access$2(InteraksiForumHP.KomentarAsycAfterTask.this).statuslike = "0";
                InteraksiForumHP.KomentarAsycAfterTask.access$2(InteraksiForumHP.KomentarAsycAfterTask.this).idkom_pos = id_komrss;
                InteraksiForumHP.KomentarAsycAfterTask.access$2(InteraksiForumHP.KomentarAsycAfterTask.this).querylike = (new StringBuilder("status=")).append(InteraksiForumHP.KomentarAsycAfterTask.access$2(InteraksiForumHP.KomentarAsycAfterTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(InteraksiForumHP.KomentarAsycAfterTask.access$2(InteraksiForumHP.KomentarAsycAfterTask.this).user_id).append("&t=").append(InteraksiForumHP.KomentarAsycAfterTask.access$2(InteraksiForumHP.KomentarAsycAfterTask.this).t).toString();
                Log.e("querylike", InteraksiForumHP.KomentarAsycAfterTask.access$2(InteraksiForumHP.KomentarAsycAfterTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new InteraksiForumHP.PostBagusKurangTask(InteraksiForumHP.KomentarAsycAfterTask.access$2(InteraksiForumHP.KomentarAsycAfterTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new InteraksiForumHP.PostBagusKurangTask(InteraksiForumHP.KomentarAsycAfterTask.access$2(InteraksiForumHP.KomentarAsycAfterTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(InteraksiForumHP.KomentarAsycAfterTask.access$2(InteraksiForumHP.KomentarAsycAfterTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new InteraksiForumHP.KomentarAsycAfterTask._cls4._cls1());
                view.setNeutralButton("Register", new InteraksiForumHP.KomentarAsycAfterTask._cls4._cls2());
                view.setNegativeButton("Login", new InteraksiForumHP.KomentarAsycAfterTask._cls4._cls3());
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

        // Unreferenced inner class com/inponsel/android/tlforum/InteraksiForumHP$KomentarAsycAfterTask$4$2

/* anonymous class */
        class InteraksiForumHP.KomentarAsycAfterTask._cls4._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final InteraksiForumHP.KomentarAsycAfterTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(InteraksiForumHP.KomentarAsycAfterTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                InteraksiForumHP.KomentarAsycAfterTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = InteraksiForumHP.KomentarAsycAfterTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/tlforum/InteraksiForumHP$KomentarAsycAfterTask$4$3

/* anonymous class */
        class InteraksiForumHP.KomentarAsycAfterTask._cls4._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final InteraksiForumHP.KomentarAsycAfterTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(InteraksiForumHP.KomentarAsycAfterTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                InteraksiForumHP.KomentarAsycAfterTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = InteraksiForumHP.KomentarAsycAfterTask._cls4.this;
                        super();
                    }
        }

    }

}
