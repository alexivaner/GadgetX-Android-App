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
    implements android.view.tarNewAsycTask._cls4
{

    final this._cls1 this$1;
    private final String val$id_komrss;
    private final String val$sc_id;

    public void onClick(View view)
    {
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this).getActivity()))
        {
            cess._mth2(this._cls1.this).statuslike = "0";
            cess._mth2(this._cls1.this).idkom_pos = val$id_komrss;
            cess._mth2(this._cls1.this).querylike = (new StringBuilder("status=")).append(cess._mth2(this._cls1.this).statuslike).append("&idkomen=").append(cess._mth2(this._cls1.this).idkom_pos).append("&idsc=").append(val$sc_id).append("&idusr=").append(cess._mth2(this._cls1.this).user_id).append("&t=").append(cess._mth2(this._cls1.this).t).toString();
            Log.e("querylike", cess._mth2(this._cls1.this).querylike);
            if (android.os.rylike >= 11)
            {
                (new nit>(cess._mth2(this._cls1.this))).ecuteOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new nit>(cess._mth2(this._cls1.this))).ecute(new Void[0]);
                return;
            }
        } else
        {
            view = new android.app.BagusKurangTask.execute(cess._mth2(this._cls1.this).getActivity());
            view.ctivity("Untuk memberi penilaian harus login terlebih dahulu.");
            view.utton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal2Komen.KomentarNewAsycTask._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = Hal2Komen.KomentarNewAsycTask._cls4.this;
                super();
            }
            });
            view.tton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal2Komen.KomentarNewAsycTask._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(Hal2Komen.KomentarNewAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                    Hal2Komen.KomentarNewAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = Hal2Komen.KomentarNewAsycTask._cls4.this;
                super();
            }
            });
            view.utton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal2Komen.KomentarNewAsycTask._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(Hal2Komen.KomentarNewAsycTask.access$2(this$1).getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    Hal2Komen.KomentarNewAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = Hal2Komen.KomentarNewAsycTask._cls4.this;
                super();
            }
            });
            view._mth4();
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
