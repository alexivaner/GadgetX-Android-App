// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            AppsByCategory, LoginActivity, RegisterActivity

class this._cls2
    implements android.content.ask._cls4._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.id_komrss()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/AppsByCategory$KomentarAsycTask$4

/* anonymous class */
    class AppsByCategory.KomentarAsycTask._cls4
        implements android.view.View.OnClickListener
    {

        final AppsByCategory.KomentarAsycTask this$1;
        private final String val$id_komrss;

        public void onClick(View view)
        {
            if (AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).userFunctions.isUserLoggedIn(AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this)))
            {
                AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).statuslike = "0";
                AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).idkom_pos = id_komrss;
                AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).querylikeKomen = (new StringBuilder("status=")).append(AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).statuslike).append("&id_kom=").append(id_komrss).append("&id_kat=").append(AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).str_SC_ID).append("&id_usr=").append(AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).user_id).append("&t=").append(AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).t).toString();
                Log.e("querylikeKomen", AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).querylikeKomen);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new AppsByCategory.PostBagusKurangKomenTask(AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new AppsByCategory.PostBagusKurangKomenTask(AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this))).execute(new Void[0]);
                    return;
                }
            } else
            {
                view = new android.app.AlertDialog.Builder(AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new AppsByCategory.KomentarAsycTask._cls4._cls1());
                view.setNeutralButton("Register", new AppsByCategory.KomentarAsycTask._cls4._cls2());
                view.setNegativeButton("Login", new AppsByCategory.KomentarAsycTask._cls4._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasyctask;
                id_komrss = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/AppsByCategory$KomentarAsycTask$4$1

/* anonymous class */
        class AppsByCategory.KomentarAsycTask._cls4._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final AppsByCategory.KomentarAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = AppsByCategory.KomentarAsycTask._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/AppsByCategory$KomentarAsycTask$4$2

/* anonymous class */
        class AppsByCategory.KomentarAsycTask._cls4._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final AppsByCategory.KomentarAsycTask._cls4 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(AppsByCategory.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                AppsByCategory.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = AppsByCategory.KomentarAsycTask._cls4.this;
                        super();
                    }
        }

    }

}