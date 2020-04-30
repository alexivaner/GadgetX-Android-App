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
    implements android.content.sycAfterTask._cls4._cls2
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

    // Unreferenced inner class com/inponsel/android/globalforum/ForumInteraksiActivity$KomentarAsycAfterTask$4

/* anonymous class */
    class ForumInteraksiActivity.KomentarAsycAfterTask._cls4
        implements android.view.View.OnClickListener
    {

        final ForumInteraksiActivity.KomentarAsycAfterTask this$1;
        private final String val$id_komrss;
        private final String val$tl_id;

        public void onClick(View view)
        {
            if (ForumInteraksiActivity.KomentarAsycAfterTask.access$2(ForumInteraksiActivity.KomentarAsycAfterTask.this).userFunctions.isUserLoggedIn(ForumInteraksiActivity.KomentarAsycAfterTask.access$2(ForumInteraksiActivity.KomentarAsycAfterTask.this)))
            {
                ForumInteraksiActivity.KomentarAsycAfterTask.access$2(ForumInteraksiActivity.KomentarAsycAfterTask.this).statuslike = "0";
                ForumInteraksiActivity.KomentarAsycAfterTask.access$2(ForumInteraksiActivity.KomentarAsycAfterTask.this).idkom_pos = id_komrss;
                ForumInteraksiActivity.KomentarAsycAfterTask.access$2(ForumInteraksiActivity.KomentarAsycAfterTask.this).querylike = (new StringBuilder("status=")).append(ForumInteraksiActivity.KomentarAsycAfterTask.access$2(ForumInteraksiActivity.KomentarAsycAfterTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&tl_id=").append(tl_id).append("&id_usr=").append(ForumInteraksiActivity.KomentarAsycAfterTask.access$2(ForumInteraksiActivity.KomentarAsycAfterTask.this).user_id).append("&t=").append(ForumInteraksiActivity.KomentarAsycAfterTask.access$2(ForumInteraksiActivity.KomentarAsycAfterTask.this).t).toString();
                Log.e("querylike", ForumInteraksiActivity.KomentarAsycAfterTask.access$2(ForumInteraksiActivity.KomentarAsycAfterTask.this).querylike);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new ForumInteraksiActivity.PostBagusKurangTask(ForumInteraksiActivity.KomentarAsycAfterTask.access$2(ForumInteraksiActivity.KomentarAsycAfterTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new ForumInteraksiActivity.PostBagusKurangTask(ForumInteraksiActivity.KomentarAsycAfterTask.access$2(ForumInteraksiActivity.KomentarAsycAfterTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(ForumInteraksiActivity.KomentarAsycAfterTask.access$2(ForumInteraksiActivity.KomentarAsycAfterTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new ForumInteraksiActivity.KomentarAsycAfterTask._cls4._cls1());
                view.setNeutralButton("Register", new ForumInteraksiActivity.KomentarAsycAfterTask._cls4._cls2());
                view.setNegativeButton("Login", new ForumInteraksiActivity.KomentarAsycAfterTask._cls4._cls3());
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

        // Unreferenced inner class com/inponsel/android/globalforum/ForumInteraksiActivity$KomentarAsycAfterTask$4$1

/* anonymous class */
        class ForumInteraksiActivity.KomentarAsycAfterTask._cls4._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumInteraksiActivity.KomentarAsycAfterTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = ForumInteraksiActivity.KomentarAsycAfterTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/globalforum/ForumInteraksiActivity$KomentarAsycAfterTask$4$3

/* anonymous class */
        class ForumInteraksiActivity.KomentarAsycAfterTask._cls4._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final ForumInteraksiActivity.KomentarAsycAfterTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(ForumInteraksiActivity.KomentarAsycAfterTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                ForumInteraksiActivity.KomentarAsycAfterTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = ForumInteraksiActivity.KomentarAsycAfterTask._cls4.this;
                        super();
                    }
        }

    }

}
