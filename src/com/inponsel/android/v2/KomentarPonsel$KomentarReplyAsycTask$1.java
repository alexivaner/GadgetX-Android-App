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
//            KomentarPonsel, RegisterActivity, LoginActivity

class val.id_hp
    implements android.view.AsycTask._cls1
{

    final this._cls1 this$1;
    private final String val$id_hp;
    private final String val$id_komentar;

    public void onClick(View view)
    {
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this)))
        {
            cess._mth2(this._cls1.this).statuslike = "1";
            cess._mth2(this._cls1.this).idkom_pos = val$id_komentar;
            cess._mth2(this._cls1.this).querylike = (new StringBuilder("status=")).append(cess._mth2(this._cls1.this).statuslike).append("&id_komen=").append(val$id_komentar).append("&idhp=").append(val$id_hp).append("&email=").append(cess._mth2(this._cls1.this).username).append("&id_user=").append(cess._mth2(this._cls1.this).user_id).append("&t=").append(cess._mth2(this._cls1.this).t).toString();
            Log.e("querylike", cess._mth2(this._cls1.this).querylike);
            if (android.os.lyAsycTask >= 11)
            {
                (new t>(cess._mth2(this._cls1.this))).uteOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new t>(cess._mth2(this._cls1.this))).ute(new Void[0]);
                return;
            }
        } else
        {
            view = new android.app.angTask.execute(cess._mth2(this._cls1.this));
            view.yAsycTask("Untuk memberi penilaian harus login terlebih dahulu.");
            view.yAsycTask("Tutup", new android.content.DialogInterface.OnClickListener() {

                final KomentarPonsel.KomentarReplyAsycTask._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = KomentarPonsel.KomentarReplyAsycTask._cls1.this;
                super();
            }
            });
            view._mth1("Register", new android.content.DialogInterface.OnClickListener() {

                final KomentarPonsel.KomentarReplyAsycTask._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(KomentarPonsel.KomentarReplyAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                    KomentarPonsel.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = KomentarPonsel.KomentarReplyAsycTask._cls1.this;
                super();
            }
            });
            view._mth1("Login", new android.content.DialogInterface.OnClickListener() {

                final KomentarPonsel.KomentarReplyAsycTask._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(KomentarPonsel.KomentarReplyAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    KomentarPonsel.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = KomentarPonsel.KomentarReplyAsycTask._cls1.this;
                super();
            }
            });
            view._mth1();
            return;
        }
    }


    _cls3.this._cls2()
    {
        this$1 = final__pcls2;
        val$id_komentar = s;
        val$id_hp = String.this;
        super();
    }
}
