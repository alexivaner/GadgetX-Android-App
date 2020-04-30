// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            PlaystoreKategoriKomen, RegisterActivity, KatAppsReplyFormActivity, LoginActivity

class this._cls2
    implements android.content.ask._cls6._cls2
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/RegisterActivity);
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.user_photo()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarAsycAfterTask$6

/* anonymous class */
    class PlaystoreKategoriKomen.KomentarAsycAfterTask._cls6
        implements android.view.View.OnClickListener
    {

        final PlaystoreKategoriKomen.KomentarAsycAfterTask this$1;
        private final String val$id_kat;
        private final String val$id_komrss;
        private final String val$komen_rss;
        private final String val$tanggal_kom;
        private final String val$user_name;
        private final String val$user_photo;

        public void onClick(View view)
        {
label0:
            {
                if (PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).userFunctions.isUserLoggedIn(PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this)))
                {
                    PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).idkom_pos = id_komrss;
                    if (!PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).userFunctions.isUserLoggedIn(PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this)))
                    {
                        break label0;
                    }
                    view = new Intent(PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this), com/inponsel/android/v2/KatAppsReplyFormActivity);
                    view.putExtra("top_id", PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).top_id);
                    view.putExtra("idkomen", PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).idkom_pos);
                    view.putExtra("id_kat", id_kat);
                    view.putExtra("userkomen", user_name);
                    view.putExtra("tanggal", tanggal_kom);
                    view.putExtra("isikomentar", komen_rss);
                    view.putExtra("userpict", user_photo);
                    view.putExtra("sc_nama", "");
                    view.putExtra("sc_merk", "");
                    view.putExtra("type", PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).str_category);
                    PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).startActivityForResult(view, PlaystoreKategoriKomen.access$5());
                }
                return;
            }
            view = new android.app.AlertDialog.Builder(PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(PlaystoreKategoriKomen.KomentarAsycAfterTask.this).wrapperLight);
            view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
            view.setPositiveButton("Tutup", new PlaystoreKategoriKomen.KomentarAsycAfterTask._cls6._cls1());
            view.setNeutralButton("Register", new PlaystoreKategoriKomen.KomentarAsycAfterTask._cls6._cls2());
            view.setNegativeButton("Login", new PlaystoreKategoriKomen.KomentarAsycAfterTask._cls6._cls3());
            view.show();
        }


            
            {
                this$1 = final_komentarasycaftertask;
                id_komrss = s;
                id_kat = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarAsycAfterTask$6$1

/* anonymous class */
        class PlaystoreKategoriKomen.KomentarAsycAfterTask._cls6._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.KomentarAsycAfterTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarAsycAfterTask$6$3

/* anonymous class */
        class PlaystoreKategoriKomen.KomentarAsycAfterTask._cls6._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.KomentarAsycAfterTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                PlaystoreKategoriKomen.KomentarAsycAfterTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.KomentarAsycAfterTask._cls6.this;
                        super();
                    }
        }

    }

}
