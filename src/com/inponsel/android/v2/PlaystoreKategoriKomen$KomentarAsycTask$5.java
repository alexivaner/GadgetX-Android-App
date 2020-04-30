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

class val.user_photo
    implements android.view.AsycTask._cls5
{

    final this._cls1 this$1;
    private final String val$id_kat;
    private final String val$id_komrss;
    private final String val$komen_rss;
    private final String val$tanggal_kom;
    private final String val$user_name;
    private final String val$user_photo;

    public void onClick(View view)
    {
        cess._mth2(this._cls1.this).idkom_pos = val$id_komrss;
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this)))
        {
            view = new Intent(cess._mth2(this._cls1.this), com/inponsel/android/v2/KatAppsReplyFormActivity);
            view.putExtra("top_id", cess._mth2(this._cls1.this).top_id);
            view.putExtra("idkomen", cess._mth2(this._cls1.this).idkom_pos);
            view.putExtra("id_kat", val$id_kat);
            view.putExtra("userkomen", val$user_name);
            view.putExtra("tanggal", val$tanggal_kom);
            view.putExtra("isikomentar", val$komen_rss);
            view.putExtra("userpict", val$user_photo);
            view.putExtra("sc_nama", "");
            view.putExtra("sc_merk", "");
            view.putExtra("type", cess._mth2(this._cls1.this).str_category);
            cess._mth2(this._cls1.this).startActivityForResult(view, PlaystoreKategoriKomen.access$5());
            return;
        } else
        {
            view = new android.app._cls5(cess._mth2(this._cls1.this).wrapperLight);
            view.Light("Untuk memberi penilaian harus login terlebih dahulu.");
            view.Light("Tutup", new android.content.DialogInterface.OnClickListener() {

                final PlaystoreKategoriKomen.KomentarAsycTask._cls5 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = PlaystoreKategoriKomen.KomentarAsycTask._cls5.this;
                super();
            }
            });
            view._mth5("Register", new android.content.DialogInterface.OnClickListener() {

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
            });
            view._mth5("Login", new android.content.DialogInterface.OnClickListener() {

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
            });
            view._mth5();
            return;
        }
    }


    _cls3.this._cls2()
    {
        this$1 = final__pcls2;
        val$id_komrss = s;
        val$id_kat = s1;
        val$user_name = s2;
        val$tanggal_kom = s3;
        val$komen_rss = s4;
        val$user_photo = String.this;
        super();
    }
}
