// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal2RSSKomen, ReplyKomRSSActivity

class this._cls2
    implements android.content.rAsycAfterTask._cls6._cls1
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

    // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal2RSSKomen$KomentarAsycAfterTask$6

/* anonymous class */
    class Hal2RSSKomen.KomentarAsycAfterTask._cls6
        implements android.view.View.OnClickListener
    {

        final Hal2RSSKomen.KomentarAsycAfterTask this$1;
        private final String val$id_komrss;
        private final String val$id_rss;
        private final String val$komen_rss;
        private final String val$tanggal_kom;
        private final String val$user_name;
        private final String val$user_photo;

        public void onClick(View view)
        {
            if (Hal2RSSKomen.KomentarAsycAfterTask.access$2(Hal2RSSKomen.KomentarAsycAfterTask.this).userFunctions.isUserLoggedIn(Hal2RSSKomen.KomentarAsycAfterTask.access$2(Hal2RSSKomen.KomentarAsycAfterTask.this).getActivity()))
            {
                view = new Intent(Hal2RSSKomen.KomentarAsycAfterTask.access$2(Hal2RSSKomen.KomentarAsycAfterTask.this).getActivity(), com/inponsel/android/rssfeeddetail/ReplyKomRSSActivity);
                view.putExtra("rss_title", Hal2RSSKomen.KomentarAsycAfterTask.access$2(Hal2RSSKomen.KomentarAsycAfterTask.this).rss_title);
                view.putExtra("id_rss", id_rss);
                view.putExtra("id_komrss", id_komrss);
                view.putExtra("user_id", Hal2RSSKomen.KomentarAsycAfterTask.access$2(Hal2RSSKomen.KomentarAsycAfterTask.this).user_id);
                view.putExtra("user_name", user_name);
                view.putExtra("tanggal_kom", tanggal_kom);
                view.putExtra("komen_rss", komen_rss);
                view.putExtra("user_photo", user_photo);
                view.putExtra("top_id", Hal2RSSKomen.KomentarAsycAfterTask.access$2(Hal2RSSKomen.KomentarAsycAfterTask.this).top_id);
                Log.e("id_komrss_to", id_komrss);
                Hal2RSSKomen.KomentarAsycAfterTask.access$2(Hal2RSSKomen.KomentarAsycAfterTask.this).startActivityForResult(view, Hal2RSSKomen.access$5());
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(Hal2RSSKomen.KomentarAsycAfterTask.access$2(Hal2RSSKomen.KomentarAsycAfterTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal2RSSKomen.KomentarAsycAfterTask._cls6._cls1());
                view.setNeutralButton("Register", new Hal2RSSKomen.KomentarAsycAfterTask._cls6._cls2());
                view.setNegativeButton("Login", new Hal2RSSKomen.KomentarAsycAfterTask._cls6._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasycaftertask;
                id_rss = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal2RSSKomen$KomentarAsycAfterTask$6$2

/* anonymous class */
        class Hal2RSSKomen.KomentarAsycAfterTask._cls6._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2RSSKomen.KomentarAsycAfterTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal2RSSKomen.KomentarAsycAfterTask.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                Hal2RSSKomen.KomentarAsycAfterTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal2RSSKomen.KomentarAsycAfterTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal2RSSKomen$KomentarAsycAfterTask$6$3

/* anonymous class */
        class Hal2RSSKomen.KomentarAsycAfterTask._cls6._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2RSSKomen.KomentarAsycAfterTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal2RSSKomen.KomentarAsycAfterTask.access$2(this$1).getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                Hal2RSSKomen.KomentarAsycAfterTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal2RSSKomen.KomentarAsycAfterTask._cls6.this;
                        super();
                    }
        }

    }

}
