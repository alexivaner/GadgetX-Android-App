// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.timelinedetail.ReplyKomTLActivity;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumInteraksiActivity

class val.user_photo
    implements android.view.mentarOldAsycTask._cls6
{

    final this._cls1 this$1;
    private final String val$id_komrss;
    private final String val$komen_rss;
    private final String val$tanggal_kom;
    private final String val$tl_id;
    private final String val$user_name;
    private final String val$user_photo;

    public void onClick(View view)
    {
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this)))
        {
            view = new Intent(cess._mth2(this._cls1.this), com/inponsel/android/timelinedetail/ReplyKomTLActivity);
            view.putExtra("tl_judul", cess._mth2(this._cls1.this).tl_judul);
            view.putExtra("tl_type", cess._mth2(this._cls1.this).tl_type);
            view.putExtra("tl_id", val$tl_id);
            view.putExtra("id_komrss", val$id_komrss);
            view.putExtra("user_id", cess._mth2(this._cls1.this).user_id);
            view.putExtra("user_name", val$user_name);
            view.putExtra("tanggal_kom", val$tanggal_kom);
            view.putExtra("komen_rss", val$komen_rss);
            view.putExtra("user_photo", val$user_photo);
            view.putExtra("top_id", cess._mth2(this._cls1.this).top_id);
            view.putExtra("bottom_id", cess._mth2(this._cls1.this).bottom_id);
            Log.e("id_komrss_to", val$id_komrss);
            Log.e("tl_id", val$tl_id);
            cess._mth2(this._cls1.this).startActivityForResult(view, ForumInteraksiActivity.access$4());
            return;
        } else
        {
            view = new android.app.ccess._cls4(cess._mth2(this._cls1.this).wrapperLight);
            view.rapperLight("Untuk membalas komentar harus login terlebih dahulu.");
            view.rapperLight("Tutup", new android.content.DialogInterface.OnClickListener() {

                final ForumInteraksiActivity.KomentarOldAsycTask._cls6 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = ForumInteraksiActivity.KomentarOldAsycTask._cls6.this;
                super();
            }
            });
            view._mth6("Register", new android.content.DialogInterface.OnClickListener() {

                final ForumInteraksiActivity.KomentarOldAsycTask._cls6 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(ForumInteraksiActivity.KomentarOldAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                    ForumInteraksiActivity.KomentarOldAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = ForumInteraksiActivity.KomentarOldAsycTask._cls6.this;
                super();
            }
            });
            view._mth6("Login", new android.content.DialogInterface.OnClickListener() {

                final ForumInteraksiActivity.KomentarOldAsycTask._cls6 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(ForumInteraksiActivity.KomentarOldAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    ForumInteraksiActivity.KomentarOldAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = ForumInteraksiActivity.KomentarOldAsycTask._cls6.this;
                super();
            }
            });
            view._mth6();
            return;
        }
    }


    _cls3.this._cls2()
    {
        this$1 = final__pcls2;
        val$tl_id = s;
        val$id_komrss = s1;
        val$user_name = s2;
        val$tanggal_kom = s3;
        val$komen_rss = s4;
        val$user_photo = String.this;
        super();
    }
}
