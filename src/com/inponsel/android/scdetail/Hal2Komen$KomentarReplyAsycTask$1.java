// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal2Komen

class val.sc_id
    implements android.view.rReplyAsycTask._cls1
{

    final this._cls1 this$1;
    private final String val$id_komrss;
    private final String val$sc_id;

    public void onClick(View view)
    {
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this).getActivity()))
        {
            cess._mth2(this._cls1.this).statuslike = "1";
            cess._mth2(this._cls1.this).idkom_pos = val$id_komrss;
            cess._mth2(this._cls1.this).querylike = (new StringBuilder("status=")).append(cess._mth2(this._cls1.this).statuslike).append("&idkomen=").append(cess._mth2(this._cls1.this).idkom_pos).append("&idsc=").append(val$sc_id).append("&idusr=").append(cess._mth2(this._cls1.this).user_id).append("&t=").append(cess._mth2(this._cls1.this).t).toString();
            Log.e("querylike", cess._mth2(this._cls1.this).querylike);
            if (android.os.like >= 11)
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
            view = new android.app.gusKurangTask.execute(cess._mth2(this._cls1.this).getActivity());
            view.ivity("Untuk memberi penilaian harus login terlebih dahulu.");
            view.ton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal2Komen.KomentarReplyAsycTask._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = Hal2Komen.KomentarReplyAsycTask._cls1.this;
                super();
            }
            });
            view.on("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal2Komen.KomentarReplyAsycTask._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(Hal2Komen.KomentarReplyAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                    Hal2Komen.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = Hal2Komen.KomentarReplyAsycTask._cls1.this;
                super();
            }
            });
            view.ton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal2Komen.KomentarReplyAsycTask._cls1 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(Hal2Komen.KomentarReplyAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    Hal2Komen.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = Hal2Komen.KomentarReplyAsycTask._cls1.this;
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
        val$id_komrss = s;
        val$sc_id = String.this;
        super();
    }
}
