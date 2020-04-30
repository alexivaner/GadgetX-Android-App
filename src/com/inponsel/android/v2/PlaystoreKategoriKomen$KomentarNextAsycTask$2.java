// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            PlaystoreKategoriKomen, RegisterActivity, LoginActivity

class val.id_kat
    implements android.view.AsycTask._cls2
{

    final this._cls1 this$1;
    private final String val$id_kat;
    private final String val$id_komrss;

    public void onClick(View view)
    {
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this)))
        {
            cess._mth2(this._cls1.this).statuslike = "0";
            cess._mth2(this._cls1.this).idkom_pos = val$id_komrss;
            cess._mth2(this._cls1.this).querylike = (new StringBuilder("status=")).append(cess._mth2(this._cls1.this).statuslike).append("&id_kom=").append(val$id_komrss).append("&id_kat=").append(val$id_kat).append("&id_usr=").append(cess._mth2(this._cls1.this).user_id).append("&t=").append(cess._mth2(this._cls1.this).t).toString();
            Log.e("querylike", cess._mth2(this._cls1.this).querylike);
            if (android.os.xtAsycTask >= 11)
            {
                (new it>(cess._mth2(this._cls1.this))).cuteOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new it>(cess._mth2(this._cls1.this))).cute(new Void[0]);
                return;
            }
        } else
        {
            view = new android.app.rangTask.execute(cess._mth2(this._cls1.this));
            view.tAsycTask("Untuk memberi penilaian harus login terlebih dahulu.");
            view.tAsycTask("Tutup", new android.content.DialogInterface.OnClickListener() {

                final PlaystoreKategoriKomen.KomentarNextAsycTask._cls2 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = PlaystoreKategoriKomen.KomentarNextAsycTask._cls2.this;
                super();
            }
            });
            view._mth2("Register", new android.content.DialogInterface.OnClickListener() {

                final PlaystoreKategoriKomen.KomentarNextAsycTask._cls2 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                    PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = PlaystoreKategoriKomen.KomentarNextAsycTask._cls2.this;
                super();
            }
            });
            view._mth2("Login", new android.content.DialogInterface.OnClickListener() {

                final PlaystoreKategoriKomen.KomentarNextAsycTask._cls2 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    PlaystoreKategoriKomen.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = PlaystoreKategoriKomen.KomentarNextAsycTask._cls2.this;
                super();
            }
            });
            view._mth2();
            return;
        }
    }


    _cls3.this._cls2()
    {
        this$1 = final__pcls2;
        val$id_komrss = s;
        val$id_kat = String.this;
        super();
    }
}
