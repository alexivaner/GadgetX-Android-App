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
    implements android.content.men._cls5._cls1
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

    // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$PostKomen$5

/* anonymous class */
    class PlaystoreKategoriKomen.PostKomen._cls5
        implements android.view.View.OnClickListener
    {

        final PlaystoreKategoriKomen.PostKomen this$1;
        private final String val$id_kat;
        private final String val$id_komrss;
        private final String val$komen_rss;
        private final String val$tanggal_kom;
        private final String val$user_name;
        private final String val$user_photo;

        public void onClick(View view)
        {
            if (PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this).userFunctions.isUserLoggedIn(PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this)))
            {
                view = new Intent(PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this), com/inponsel/android/rssfeeddetail/ReplyKomRSSActivity);
                view.putExtra("title", PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this).title);
                view.putExtra("id_kat", id_kat);
                view.putExtra("id_kom", id_komrss);
                view.putExtra("user_id", PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this).user_id);
                view.putExtra("user_name", user_name);
                view.putExtra("tanggal_kom", tanggal_kom);
                view.putExtra("komen_rss", komen_rss);
                view.putExtra("user_photo", user_photo);
                view.putExtra("top_id", PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this).top_id);
                Log.e("id_komrss_to", id_komrss);
                PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this).startActivityForResult(view, PlaystoreKategoriKomen.access$5());
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(PlaystoreKategoriKomen.PostKomen.access$2(PlaystoreKategoriKomen.PostKomen.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new PlaystoreKategoriKomen.PostKomen._cls5._cls1());
                view.setNeutralButton("Register", new PlaystoreKategoriKomen.PostKomen._cls5._cls2());
                view.setNegativeButton("Login", new PlaystoreKategoriKomen.PostKomen._cls5._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_postkomen;
                id_kat = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$PostKomen$5$2

/* anonymous class */
        class PlaystoreKategoriKomen.PostKomen._cls5._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.PostKomen._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PlaystoreKategoriKomen.PostKomen.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                PlaystoreKategoriKomen.PostKomen.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.PostKomen._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/PlaystoreKategoriKomen$PostKomen$5$3

/* anonymous class */
        class PlaystoreKategoriKomen.PostKomen._cls5._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final PlaystoreKategoriKomen.PostKomen._cls5 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(PlaystoreKategoriKomen.PostKomen.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                PlaystoreKategoriKomen.PostKomen.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = PlaystoreKategoriKomen.PostKomen._cls5.this;
                        super();
                    }
        }

    }

}
