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
    implements android.content.AsycTask._cls3._cls2
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

    // Unreferenced inner class com/inponsel/android/tlforum/InteraksiForumHP$KomentarOldAsycTask$3

/* anonymous class */
    class InteraksiForumHP.KomentarOldAsycTask._cls3
        implements android.view.View.OnClickListener
    {

        final InteraksiForumHP.KomentarOldAsycTask this$1;
        private final String val$id_komrss;
        private final String val$tl_id;

        public void onClick(View view)
        {
            if (InteraksiForumHP.KomentarOldAsycTask.access$2(InteraksiForumHP.KomentarOldAsycTask.this).userFunctions.isUserLoggedIn(InteraksiForumHP.KomentarOldAsycTask.access$2(InteraksiForumHP.KomentarOldAsycTask.this)))
            {
                InteraksiForumHP.KomentarOldAsycTask.access$2(InteraksiForumHP.KomentarOldAsycTask.this).statuslike = "1";
                InteraksiForumHP.KomentarOldAsycTask.access$2(InteraksiForumHP.KomentarOldAsycTask.this).idkom_pos = id_komrss;
                InteraksiForumHP.KomentarOldAsycTask.access$2(InteraksiForumHP.KomentarOldAsycTask.this).querylike = (new StringBuilder("status=")).append(InteraksiForumHP.KomentarOldAsycTask.access$2(InteraksiForumHP.KomentarOldAsycTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(InteraksiForumHP.KomentarOldAsycTask.access$2(InteraksiForumHP.KomentarOldAsycTask.this).user_id).append("&t=").append(InteraksiForumHP.KomentarOldAsycTask.access$2(InteraksiForumHP.KomentarOldAsycTask.this).t).toString();
                Log.e("querylike", InteraksiForumHP.KomentarOldAsycTask.access$2(InteraksiForumHP.KomentarOldAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new InteraksiForumHP.PostBagusKurangTask(InteraksiForumHP.KomentarOldAsycTask.access$2(InteraksiForumHP.KomentarOldAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new InteraksiForumHP.PostBagusKurangTask(InteraksiForumHP.KomentarOldAsycTask.access$2(InteraksiForumHP.KomentarOldAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(InteraksiForumHP.KomentarOldAsycTask.access$2(InteraksiForumHP.KomentarOldAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new InteraksiForumHP.KomentarOldAsycTask._cls3._cls1());
                view.setNeutralButton("Register", new InteraksiForumHP.KomentarOldAsycTask._cls3._cls2());
                view.setNegativeButton("Login", new InteraksiForumHP.KomentarOldAsycTask._cls3._cls3());
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

        // Unreferenced inner class com/inponsel/android/tlforum/InteraksiForumHP$KomentarOldAsycTask$3$1

/* anonymous class */
        class InteraksiForumHP.KomentarOldAsycTask._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final InteraksiForumHP.KomentarOldAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = InteraksiForumHP.KomentarOldAsycTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/tlforum/InteraksiForumHP$KomentarOldAsycTask$3$3

/* anonymous class */
        class InteraksiForumHP.KomentarOldAsycTask._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final InteraksiForumHP.KomentarOldAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(InteraksiForumHP.KomentarOldAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                InteraksiForumHP.KomentarOldAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = InteraksiForumHP.KomentarOldAsycTask._cls3.this;
                        super();
                    }
        }

    }

}
