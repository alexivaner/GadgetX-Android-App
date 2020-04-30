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

class val.user_photo
    implements android.view.omentarNextAsycTask._cls3
{

    final this._cls1 this$1;
    private final String val$id_komrss;
    private final String val$id_rss;
    private final String val$komen_rss;
    private final String val$tanggal_kom;
    private final String val$user_name;
    private final String val$user_photo;

    public void onClick(View view)
    {
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this).getActivity()))
        {
            view = new Intent(cess._mth2(this._cls1.this).getActivity(), com/inponsel/android/rssfeeddetail/ReplyKomRSSActivity);
            view.putExtra("rss_title", cess._mth2(this._cls1.this).rss_title);
            view.putExtra("id_rss", val$id_rss);
            view.putExtra("id_komrss", val$id_komrss);
            view.putExtra("user_id", cess._mth2(this._cls1.this).user_id);
            view.putExtra("user_name", val$user_name);
            view.putExtra("tanggal_kom", val$tanggal_kom);
            view.putExtra("komen_rss", val$komen_rss);
            view.putExtra("user_photo", val$user_photo);
            view.putExtra("top_id", cess._mth2(this._cls1.this).top_id);
            Log.e("id_komrss_to", val$id_komrss);
            cess._mth2(this._cls1.this).startActivityForResult(view, Hal2RSSKomen.access$5());
            return;
        } else
        {
            view = new android.app.access._cls5(cess._mth2(this._cls1.this).wrapperLight);
            view.wrapperLight("Untuk memberi penilaian harus login terlebih dahulu.");
            view.n("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal2RSSKomen.KomentarNextAsycTask._cls3 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = Hal2RSSKomen.KomentarNextAsycTask._cls3.this;
                super();
            }
            });
            view.("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal2RSSKomen.KomentarNextAsycTask._cls3 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(Hal2RSSKomen.KomentarNextAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                    Hal2RSSKomen.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = Hal2RSSKomen.KomentarNextAsycTask._cls3.this;
                super();
            }
            });
            view.n("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal2RSSKomen.KomentarNextAsycTask._cls3 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(Hal2RSSKomen.KomentarNextAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    Hal2RSSKomen.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = Hal2RSSKomen.KomentarNextAsycTask._cls3.this;
                super();
            }
            });
            view._mth3();
            return;
        }
    }


    _cls3.this._cls2()
    {
        this$1 = final__pcls2;
        val$id_rss = s;
        val$id_komrss = s1;
        val$user_name = s2;
        val$tanggal_kom = s3;
        val$komen_rss = s4;
        val$user_photo = String.this;
        super();
    }
}
