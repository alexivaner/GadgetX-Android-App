// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            AppsByCategory, RegisterActivity, KatAppsReplyFormActivity, LoginActivity

class this._cls2
    implements android.content.ask._cls6._cls2
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/RegisterActivity);
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.id_komrss()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/AppsByCategory$KomentarAsycTask$6

/* anonymous class */
    class AppsByCategory.KomentarAsycTask._cls6
        implements android.view.View.OnClickListener
    {

        final AppsByCategory.KomentarAsycTask this$1;
        private final String val$id_komrss;
        private final String val$komen_rss;
        private final String val$tanggal_kom;
        private final String val$user_name;
        private final String val$user_photo;

        public void onClick(View view)
        {
            if (AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).userFunctions.isUserLoggedIn(AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this)))
            {
                view = new Intent(AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this), com/inponsel/android/v2/KatAppsReplyFormActivity);
                view.putExtra("top_id", AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).top_id);
                view.putExtra("idkomen", AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).idkom_pos);
                view.putExtra("id_kat", AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).str_SC_ID);
                view.putExtra("userkomen", user_name);
                view.putExtra("tanggal", tanggal_kom);
                view.putExtra("isikomentar", komen_rss);
                view.putExtra("userpict", user_photo);
                view.putExtra("sc_nama", "");
                view.putExtra("sc_merk", "");
                view.putExtra("type", AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).str_category);
                Log.e("id_komrss_to", id_komrss);
                AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this).startActivityForResult(view, AppsByCategory.access$5());
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(AppsByCategory.KomentarAsycTask.access$2(AppsByCategory.KomentarAsycTask.this));
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new AppsByCategory.KomentarAsycTask._cls6._cls1());
                view.setNeutralButton("Register", new AppsByCategory.KomentarAsycTask._cls6._cls2());
                view.setNegativeButton("Login", new AppsByCategory.KomentarAsycTask._cls6._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasyctask;
                user_name = s;
                tanggal_kom = s1;
                komen_rss = s2;
                user_photo = s3;
                id_komrss = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/AppsByCategory$KomentarAsycTask$6$1

/* anonymous class */
        class AppsByCategory.KomentarAsycTask._cls6._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final AppsByCategory.KomentarAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = AppsByCategory.KomentarAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/AppsByCategory$KomentarAsycTask$6$3

/* anonymous class */
        class AppsByCategory.KomentarAsycTask._cls6._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final AppsByCategory.KomentarAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(AppsByCategory.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                AppsByCategory.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = AppsByCategory.KomentarAsycTask._cls6.this;
                        super();
                    }
        }

    }

}
