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
    implements android.content.rOldAsycTask._cls5._cls3
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

    // Unreferenced inner class com/inponsel/android/globalforum/ForumInteraksiActivity$KomentarOldAsycTask$5

/* anonymous class */
    class ForumInteraksiActivity.KomentarOldAsycTask._cls5
        implements android.view.View.OnClickListener
    {

        final ForumInteraksiActivity.KomentarOldAsycTask this$1;
        private final String val$id_komrss;
        private final String val$tl_id;

        public void onClick(View view)
        {
            if (ForumInteraksiActivity.KomentarOldAsycTask.access$2(ForumInteraksiActivity.KomentarOldAsycTask.this).userFunctions.isUserLoggedIn(ForumInteraksiActivity.KomentarOldAsycTask.access$2(ForumInteraksiActivity.KomentarOldAsycTask.this)))
            {
                ForumInteraksiActivity.KomentarOldAsycTask.access$2(ForumInteraksiActivity.KomentarOldAsycTask.this).statuslike = "0";
                ForumInteraksiActivity.KomentarOldAsycTask.access$2(ForumInteraksiActivity.KomentarOldAsycTask.this).idkom_pos = id_komrss;
                ForumInteraksiActivity.KomentarOldAsycTask.access$2(ForumInteraksiActivity.KomentarOldAsycTask.this).querylike = (new StringBuilder("status=")).append(ForumInteraksiActivity.KomentarOldAsycTask.access$2(ForumInteraksiActivity.KomentarOldAsycTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(ForumInteraksiActivity.KomentarOldAsycTask.access$2(ForumInteraksiActivity.KomentarOldAsycTask.this).user_id).append("&t=").append(ForumInteraksiActivity.KomentarOldAsycTask.access$2(ForumInteraksiActivity.KomentarOldAsycTask.this).t).toString();
                Log.e("querylike", ForumInteraksiActivity.KomentarOldAsycTask.access$2(ForumInteraksiActivity.KomentarOldAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new ForumInteraksiActivity.PostBagusKurangTask(ForumInteraksiActivity.KomentarOldAsycTask.access$2(ForumInteraksiActivity.KomentarOldAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new ForumInteraksiActivity.PostBagusKurangTask(ForumInteraksiActivity.KomentarOldAsycTask.access$2(ForumInteraksiActivity.KomentarOldAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(ForumInteraksiActivity.KomentarOldAsycTask.access$2(ForumInteraksiActivity.KomentarOldAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new ForumInteraksiActivity.KomentarOldAsycTask._cls5._cls1());
                view.setNeutralButton("Register", new ForumInteraksiActivity.KomentarOldAsycTask._cls5._cls2());
                view.setNegativeButton("Login", new ForumInteraksiActivity.KomentarOldAsycTask._cls5._cls3());
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

        // Unreferenced inner class com/inponsel/android/globalforum/ForumInteraksiActivity$KomentarOldAsycTask$5$1

/* anonymous class */
        class ForumInteraksiActivity.KomentarOldAsycTask._cls5._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumInteraksiActivity.KomentarOldAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = ForumInteraksiActivity.KomentarOldAsycTask._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/globalforum/ForumInteraksiActivity$KomentarOldAsycTask$5$2

/* anonymous class */
        class ForumInteraksiActivity.KomentarOldAsycTask._cls5._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumInteraksiActivity.KomentarOldAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ForumInteraksiActivity.KomentarOldAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                ForumInteraksiActivity.KomentarOldAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = ForumInteraksiActivity.KomentarOldAsycTask._cls5.this;
                        super();
                    }
        }

    }

}
