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
    implements android.content.NextAsycTask._cls3._cls2
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

    // Unreferenced inner class com/inponsel/android/globalforum/ForumInteraksiActivity$KomentarNextAsycTask$3

/* anonymous class */
    class ForumInteraksiActivity.KomentarNextAsycTask._cls3
        implements android.view.View.OnClickListener
    {

        final ForumInteraksiActivity.KomentarNextAsycTask this$1;
        private final String val$id_komrss;
        private final String val$tl_id;

        public void onClick(View view)
        {
            if (ForumInteraksiActivity.KomentarNextAsycTask.access$2(ForumInteraksiActivity.KomentarNextAsycTask.this).userFunctions.isUserLoggedIn(ForumInteraksiActivity.KomentarNextAsycTask.access$2(ForumInteraksiActivity.KomentarNextAsycTask.this)))
            {
                ForumInteraksiActivity.KomentarNextAsycTask.access$2(ForumInteraksiActivity.KomentarNextAsycTask.this).statuslike = "0";
                ForumInteraksiActivity.KomentarNextAsycTask.access$2(ForumInteraksiActivity.KomentarNextAsycTask.this).idkom_pos = id_komrss;
                ForumInteraksiActivity.KomentarNextAsycTask.access$2(ForumInteraksiActivity.KomentarNextAsycTask.this).querylike = (new StringBuilder("status=")).append(ForumInteraksiActivity.KomentarNextAsycTask.access$2(ForumInteraksiActivity.KomentarNextAsycTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(ForumInteraksiActivity.KomentarNextAsycTask.access$2(ForumInteraksiActivity.KomentarNextAsycTask.this).user_id).append("&t=").append(ForumInteraksiActivity.KomentarNextAsycTask.access$2(ForumInteraksiActivity.KomentarNextAsycTask.this).t).toString();
                Log.e("querylike", ForumInteraksiActivity.KomentarNextAsycTask.access$2(ForumInteraksiActivity.KomentarNextAsycTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new ForumInteraksiActivity.PostBagusKurangTask(ForumInteraksiActivity.KomentarNextAsycTask.access$2(ForumInteraksiActivity.KomentarNextAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new ForumInteraksiActivity.PostBagusKurangTask(ForumInteraksiActivity.KomentarNextAsycTask.access$2(ForumInteraksiActivity.KomentarNextAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(ForumInteraksiActivity.KomentarNextAsycTask.access$2(ForumInteraksiActivity.KomentarNextAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new ForumInteraksiActivity.KomentarNextAsycTask._cls3._cls1());
                view.setNeutralButton("Register", new ForumInteraksiActivity.KomentarNextAsycTask._cls3._cls2());
                view.setNegativeButton("Login", new ForumInteraksiActivity.KomentarNextAsycTask._cls3._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarnextasyctask;
                id_komrss = s;
                tl_id = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/globalforum/ForumInteraksiActivity$KomentarNextAsycTask$3$1

/* anonymous class */
        class ForumInteraksiActivity.KomentarNextAsycTask._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumInteraksiActivity.KomentarNextAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = ForumInteraksiActivity.KomentarNextAsycTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/globalforum/ForumInteraksiActivity$KomentarNextAsycTask$3$3

/* anonymous class */
        class ForumInteraksiActivity.KomentarNextAsycTask._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumInteraksiActivity.KomentarNextAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ForumInteraksiActivity.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                ForumInteraksiActivity.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = ForumInteraksiActivity.KomentarNextAsycTask._cls3.this;
                        super();
                    }
        }

    }

}
