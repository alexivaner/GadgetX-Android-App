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
//            Hal1RSSDetail, ReplyKomRSSActivity

class this._cls2
    implements android.content.mentarAsycTask._cls6._cls2
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1).getActivity(), com/inponsel/android/v2/RegisterActivity);
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.user_photo()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$KomentarAsycTask$6

/* anonymous class */
    class Hal1RSSDetail.KomentarAsycTask._cls6
        implements android.view.View.OnClickListener
    {

        final Hal1RSSDetail.KomentarAsycTask this$1;
        private final String val$id_komrss;
        private final String val$id_rss;
        private final String val$komen_rss;
        private final String val$tanggal_kom;
        private final String val$user_name;
        private final String val$user_photo;

        public void onClick(View view)
        {
            if (Hal1RSSDetail.KomentarAsycTask.access$2(Hal1RSSDetail.KomentarAsycTask.this).userFunctions.isUserLoggedIn(Hal1RSSDetail.KomentarAsycTask.access$2(Hal1RSSDetail.KomentarAsycTask.this).getActivity()))
            {
                view = new Intent(Hal1RSSDetail.KomentarAsycTask.access$2(Hal1RSSDetail.KomentarAsycTask.this).getActivity(), com/inponsel/android/rssfeeddetail/ReplyKomRSSActivity);
                view.putExtra("rss_title", Hal1RSSDetail.KomentarAsycTask.access$2(Hal1RSSDetail.KomentarAsycTask.this).rss_title);
                view.putExtra("id_rss", id_rss);
                view.putExtra("id_komrss", id_komrss);
                view.putExtra("user_id", Hal1RSSDetail.KomentarAsycTask.access$2(Hal1RSSDetail.KomentarAsycTask.this).user_id);
                view.putExtra("user_name", user_name);
                view.putExtra("tanggal_kom", tanggal_kom);
                view.putExtra("komen_rss", komen_rss);
                view.putExtra("user_photo", user_photo);
                view.putExtra("top_id", Hal1RSSDetail.KomentarAsycTask.access$2(Hal1RSSDetail.KomentarAsycTask.this).top_id);
                Log.e("id_komrss_to", id_komrss);
                Hal1RSSDetail.KomentarAsycTask.access$2(Hal1RSSDetail.KomentarAsycTask.this).startActivityForResult(view, Hal1RSSDetail.access$9());
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(Hal1RSSDetail.KomentarAsycTask.access$2(Hal1RSSDetail.KomentarAsycTask.this).wrapperLight);
                view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new Hal1RSSDetail.KomentarAsycTask._cls6._cls1());
                view.setNeutralButton("Register", new Hal1RSSDetail.KomentarAsycTask._cls6._cls2());
                view.setNegativeButton("Login", new Hal1RSSDetail.KomentarAsycTask._cls6._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasyctask;
                id_rss = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$KomentarAsycTask$6$1

/* anonymous class */
        class Hal1RSSDetail.KomentarAsycTask._cls6._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1RSSDetail.KomentarAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = Hal1RSSDetail.KomentarAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rssfeeddetail/Hal1RSSDetail$KomentarAsycTask$6$3

/* anonymous class */
        class Hal1RSSDetail.KomentarAsycTask._cls6._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal1RSSDetail.KomentarAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(Hal1RSSDetail.KomentarAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                Hal1RSSDetail.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = Hal1RSSDetail.KomentarAsycTask._cls6.this;
                        super();
                    }
        }

    }

}