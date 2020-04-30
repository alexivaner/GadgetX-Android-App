// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.details:
//            KomentarTwitter, ReplyKomTwActivity

class val.user_photo
    implements android.view.rNextAsycTask._cls6
{

    final this._cls1 this$1;
    private final String val$id_komtw;
    private final String val$id_tw;
    private final String val$komen_tw;
    private final String val$tanggal_kom;
    private final String val$user_name;
    private final String val$user_photo;

    public void onClick(View view)
    {
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this)))
        {
            view = new Intent(cess._mth2(this._cls1.this), com/inponsel/android/details/ReplyKomTwActivity);
            view.putExtra("tw_name", cess._mth2(this._cls1.this).tw_name);
            view.putExtra("id_tw", val$id_tw);
            view.putExtra("id_komtw", val$id_komtw);
            view.putExtra("user_id", cess._mth2(this._cls1.this).user_id);
            view.putExtra("user_name", val$user_name);
            view.putExtra("tanggal_kom", val$tanggal_kom);
            view.putExtra("komen_tw", val$komen_tw);
            view.putExtra("user_photo", val$user_photo);
            view.putExtra("top_id", cess._mth2(this._cls1.this).top_id);
            Log.e("id_komtw_to", val$id_komtw);
            cess._mth2(this._cls1.this).startActivityForResult(view, KomentarTwitter.access$2());
            return;
        } else
        {
            view = new android.app.._cls2(cess._mth2(this._cls1.this).wrapperLight);
            view.rLight("Untuk memberi penilaian harus login terlebih dahulu.");
            view.rLight("Tutup", new android.content.DialogInterface.OnClickListener() {

                final KomentarTwitter.KomentarNextAsycTask._cls6 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = KomentarTwitter.KomentarNextAsycTask._cls6.this;
                super();
            }
            });
            view._mth6("Register", new android.content.DialogInterface.OnClickListener() {

                final KomentarTwitter.KomentarNextAsycTask._cls6 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(KomentarTwitter.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                    KomentarTwitter.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = KomentarTwitter.KomentarNextAsycTask._cls6.this;
                super();
            }
            });
            view._mth6("Login", new android.content.DialogInterface.OnClickListener() {

                final KomentarTwitter.KomentarNextAsycTask._cls6 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(KomentarTwitter.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    KomentarTwitter.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = KomentarTwitter.KomentarNextAsycTask._cls6.this;
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
        val$id_tw = s;
        val$id_komtw = s1;
        val$user_name = s2;
        val$tanggal_kom = s3;
        val$komen_tw = s4;
        val$user_photo = String.this;
        super();
    }
}
