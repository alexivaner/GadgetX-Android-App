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
import com.inponsel.android.v2.ReplyFormActivity;

// Referenced classes of package com.inponsel.android.details:
//            Hal3KomentarPull

class val.usr_pict_komen
    implements android.view.arOldAsycTask._cls6
{

    final this._cls1 this$1;
    private final String val$codename;
    private final String val$email_komentar;
    private final String val$id_hp;
    private final String val$id_komentar;
    private final String val$komentarhp;
    private final String val$nama_komentar;
    private final String val$tanggal_komentar;
    private final String val$usr_pict_komen;

    public void onClick(View view)
    {
        Log.e("iRep", (new StringBuilder(String.valueOf(val$id_hp))).append(" - ").append(val$id_komentar).append(" - ").append(val$email_komentar).append(" - ").append(val$nama_komentar).append(" - ").append(val$tanggal_komentar).append(" - ").append(val$komentarhp).append(" - ").append(cess._mth2(this._cls1.this).namalengkap).append(" - ").append(val$codename).toString());
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this).getActivity()))
        {
            view = new Intent(cess._mth2(this._cls1.this).getActivity(), com/inponsel/android/v2/ReplyFormActivity);
            view.putExtra("idhp", val$id_hp);
            view.putExtra("idkomen", val$id_komentar);
            view.putExtra("email_komentar", val$email_komentar);
            view.putExtra("userkomen", val$nama_komentar);
            view.putExtra("tanggal", val$tanggal_komentar);
            view.putExtra("isikomentar", val$komentarhp);
            view.putExtra("nmlengkap", cess._mth2(this._cls1.this).namalengkap);
            view.putExtra("userpict", val$usr_pict_komen);
            view.putExtra("codename", val$codename);
            view.putExtra("top_id", cess._mth2(this._cls1.this).top_id);
            cess._mth2(this._cls1.this).startActivityForResult(view, Hal3KomentarPull.access$3());
            return;
        } else
        {
            view = new android.app.s._cls3(cess._mth2(this._cls1.this).wrapperLight);
            view.erLight("Untuk memberi penilaian harus login terlebih dahulu.");
            view.erLight("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal3KomentarPull.KomentarOldAsycTask._cls6 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = Hal3KomentarPull.KomentarOldAsycTask._cls6.this;
                super();
            }
            });
            view._mth6("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal3KomentarPull.KomentarOldAsycTask._cls6 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(Hal3KomentarPull.KomentarOldAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                    Hal3KomentarPull.KomentarOldAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = Hal3KomentarPull.KomentarOldAsycTask._cls6.this;
                super();
            }
            });
            view._mth6("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal3KomentarPull.KomentarOldAsycTask._cls6 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(Hal3KomentarPull.KomentarOldAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    Hal3KomentarPull.KomentarOldAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = Hal3KomentarPull.KomentarOldAsycTask._cls6.this;
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
        val$id_hp = s;
        val$id_komentar = s1;
        val$email_komentar = s2;
        val$nama_komentar = s3;
        val$tanggal_komentar = s4;
        val$komentarhp = s5;
        val$codename = s6;
        val$usr_pict_komen = String.this;
        super();
    }
}
