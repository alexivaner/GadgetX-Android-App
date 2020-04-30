// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.rssfeeddetail.ReplyKomRSSActivity;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            PlaystoreKategoriKomen, RegisterActivity, LoginActivity

class this._cls2
    implements android.content.ask._cls3._cls2
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

    // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarNextAsycTask$3

/* anonymous class */
    class PlaystoreKategoriKomen.KomentarNextAsycTask._cls3
        implements android.view.View.OnClickListener
    {

        final PlaystoreKategoriKomen.KomentarNextAsycTask this$1;
        private final String val$id_kat;
        private final String val$id_komrss;
        private final String val$komen_rss;
        private final String val$tanggal_kom;
        private final String val$user_name;
        private final String val$user_photo;

        public void onClick(View view)
        {
            if (PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this).userFunctions.isUserLoggedIn(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this)))
            {
                view = new Intent(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this), com/inponsel/android/rssfeeddetail/ReplyKomRSSActivity);
                view.putExtra("title", PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this).title);
                view.putExtra("id_kat", id_kat);
                view.putExtra("id_kom", id_komrss);
                view.putExtra("user_id", PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this).user_id);
                view.putExtra("user_name", user_name);
                view.putExtra("tanggal_kom", tanggal_kom);
                view.putExtra("komen_rss", komen_rss);
                view.putExtra("user_photo", user_photo);
                view.putExtra("top_id", PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this).top_id);
                Log.e("id_komrss_to", id_komrss);
                PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this).startActivityForResult(view, PlaystoreKategoriKomen.access$5());
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(PlaystoreKategoriKomen.KomentarNextAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new PlaystoreKategoriKomen.KomentarNextAsycTask._cls3._cls1());
                view.setNeutralButton("Register", new PlaystoreKategoriKomen.KomentarNextAsycTask._cls3._cls2());
                view.setNegativeButton("Login", new PlaystoreKategoriKomen.KomentarNextAsycTask._cls3._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarnextasyctask;
                id_kat = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarNextAsycTask$3$1

/* anonymous class */
        class PlaystoreKategoriKomen.KomentarNextAsycTask._cls3._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.KomentarNextAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.KomentarNextAsycTask._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$KomentarNextAsycTask$3$3

/* anonymous class */
        class PlaystoreKategoriKomen.KomentarNextAsycTask._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.KomentarNextAsycTask._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.KomentarNextAsycTask._cls3.this;
                        super();
                    }
        }

    }

}
