// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.timelinedetail.ReplyKomTLActivity;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSInteraksiActivity

class this._cls2
    implements android.content.sycTask._cls6._cls3
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ss._mth2(_fld1), com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        ss._mth2(_fld1).startActivity(dialoginterface);
    }

    l.user_photo()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/rsstab/RSSInteraksiActivity$KomentarAsycTask$6

/* anonymous class */
    class RSSInteraksiActivity.KomentarAsycTask._cls6
        implements android.view.View.OnClickListener
    {

        final RSSInteraksiActivity.KomentarAsycTask this$1;
        private final String val$id_komrss;
        private final String val$komen_rss;
        private final String val$tanggal_kom;
        private final String val$tl_id;
        private final String val$user_name;
        private final String val$user_photo;

        public void onClick(View view)
        {
            if (RSSInteraksiActivity.KomentarAsycTask.access$2(RSSInteraksiActivity.KomentarAsycTask.this).userFunctions.isUserLoggedIn(RSSInteraksiActivity.KomentarAsycTask.access$2(RSSInteraksiActivity.KomentarAsycTask.this)))
            {
                view = new Intent(RSSInteraksiActivity.KomentarAsycTask.access$2(RSSInteraksiActivity.KomentarAsycTask.this), com/inponsel/android/timelinedetail/ReplyKomTLActivity);
                view.putExtra("tl_judul", RSSInteraksiActivity.KomentarAsycTask.access$2(RSSInteraksiActivity.KomentarAsycTask.this).tl_judul);
                view.putExtra("tl_type", RSSInteraksiActivity.KomentarAsycTask.access$2(RSSInteraksiActivity.KomentarAsycTask.this).tl_type);
                view.putExtra("tl_id", tl_id);
                view.putExtra("id_komrss", id_komrss);
                view.putExtra("user_id", RSSInteraksiActivity.KomentarAsycTask.access$2(RSSInteraksiActivity.KomentarAsycTask.this).user_id);
                view.putExtra("user_name", user_name);
                view.putExtra("tanggal_kom", tanggal_kom);
                view.putExtra("komen_rss", komen_rss);
                view.putExtra("user_photo", user_photo);
                view.putExtra("top_id", RSSInteraksiActivity.KomentarAsycTask.access$2(RSSInteraksiActivity.KomentarAsycTask.this).top_id);
                view.putExtra("bottom_id", RSSInteraksiActivity.KomentarAsycTask.access$2(RSSInteraksiActivity.KomentarAsycTask.this).bottom_id);
                Log.e("id_komrss_to", id_komrss);
                Log.e("tl_id", tl_id);
                RSSInteraksiActivity.KomentarAsycTask.access$2(RSSInteraksiActivity.KomentarAsycTask.this).startActivityForResult(view, RSSInteraksiActivity.access$4());
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(RSSInteraksiActivity.KomentarAsycTask.access$2(RSSInteraksiActivity.KomentarAsycTask.this).wrapperLight);
                view.setMessage("Untuk membalas komentar harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new RSSInteraksiActivity.KomentarAsycTask._cls6._cls1());
                view.setNeutralButton("Register", new RSSInteraksiActivity.KomentarAsycTask._cls6._cls2());
                view.setNegativeButton("Login", new RSSInteraksiActivity.KomentarAsycTask._cls6._cls3());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final_komentarasyctask;
                tl_id = s;
                id_komrss = s1;
                user_name = s2;
                tanggal_kom = s3;
                komen_rss = s4;
                user_photo = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/rsstab/RSSInteraksiActivity$KomentarAsycTask$6$1

/* anonymous class */
        class RSSInteraksiActivity.KomentarAsycTask._cls6._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSInteraksiActivity.KomentarAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = RSSInteraksiActivity.KomentarAsycTask._cls6.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/rsstab/RSSInteraksiActivity$KomentarAsycTask$6$2

/* anonymous class */
        class RSSInteraksiActivity.KomentarAsycTask._cls6._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final RSSInteraksiActivity.KomentarAsycTask._cls6 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RSSInteraksiActivity.KomentarAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                RSSInteraksiActivity.KomentarAsycTask.access$2(this$1).startActivity(dialoginterface);
            }

                    
                    {
                        this$2 = RSSInteraksiActivity.KomentarAsycTask._cls6.this;
                        super();
                    }
        }

    }

}
