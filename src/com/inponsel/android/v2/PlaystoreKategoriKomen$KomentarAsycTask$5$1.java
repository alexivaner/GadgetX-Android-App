// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            PlaystoreKategoriKomen, KatAppsReplyFormActivity, RegisterActivity, LoginActivity

class this._cls2
    implements android.content.ask._cls5._cls1
{

    final this._cls2 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.user_photo()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarAsycTask$5

/* anonymous class */
    class PlaystoreKategoriKomen.KomentarAsycTask._cls5
        implements android.view.View.OnClickListener
    {

        final PlaystoreKategoriKomen.KomentarAsycTask this$1;
        private final String val$id_kat;
        private final String val$id_komrss;
        private final String val$komen_rss;
        private final String val$tanggal_kom;
        private final String val$user_name;
        private final String val$user_photo;

        public void onClick(View view)
        {
            PlaystoreKategoriKomen.KomentarAsycTask.access$2(PlaystoreKategoriKomen.KomentarAsycTask.this).idkom_pos = id_komrss;
            if (PlaystoreKategoriKomen.KomentarAsycTask.access$2(PlaystoreKategoriKomen.KomentarAsycTask.this).userFunctions.isUserLoggedIn(PlaystoreKategoriKomen.KomentarAsycTask.access$2(PlaystoreKategoriKomen.KomentarAsycTask.this)))
            {
                view = new Intent(PlaystoreKategoriKomen.KomentarAsycTask.access$2(PlaystoreKategoriKomen.KomentarAsycTask.this), com/inponsel/android/v2/KatAppsReplyFormActivity);
                view.putExtra("top_id", PlaystoreKategoriKomen.KomentarAsycTask.access$2(PlaystoreKategoriKomen.KomentarAsycTask.this).top_id);
                view.putExtra("idkomen", PlaystoreKategoriKomen.KomentarAsycTask.access$2(PlaystoreKategoriKomen.KomentarAsycTask.this).idkom_pos);
                view.putExtra("id_kat", id_kat);
                view.putExtra("userkomen", user_name);
                view.putExtra("tanggal", tanggal_kom);
                view.putExtra("isikomentar", komen_rss);
                view.putExtra("userpict", user_photo);
                view.putExtra("sc_nama", "");
                view.putExtra("sc_merk", "");
                view.putExtra("type", PlaystoreKategoriKomen.KomentarAsycTask.access$2(PlaystoreKategoriKomen.KomentarAsycTask.this).str_category);
                PlaystoreKategoriKomen.KomentarAsycTask.access$2(PlaystoreKategoriKomen.KomentarAsycTask.this).startActivityForResult(view, PlaystoreKategoriKomen.access$5());
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(PlaystoreKategoriKomen.KomentarAsycTask.access$2(PlaystoreKategoriKomen.KomentarAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new PlaystoreKategoriKomen.KomentarAsycTask._cls5._cls1());
                view.setNeutralButton("Register", new PlaystoreKategoriKomen.KomentarAsycTask._cls5._cls2());
                view.setNegativeButton("Login", new PlaystoreKategoriKomen.KomentarAsycTask._cls5._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasyctask;
                id_komrss = s;
                id_kat = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarAsycTask$5$2

/* anonymous class */
        class PlaystoreKategoriKomen.KomentarAsycTask._cls5._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.KomentarAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PlaystoreKategoriKomen.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                PlaystoreKategoriKomen.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.KomentarAsycTask._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarAsycTask$5$3

/* anonymous class */
        class PlaystoreKategoriKomen.KomentarAsycTask._cls5._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.KomentarAsycTask._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PlaystoreKategoriKomen.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                PlaystoreKategoriKomen.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.KomentarAsycTask._cls5.this;
                        super();
                    }
        }

    }

}
