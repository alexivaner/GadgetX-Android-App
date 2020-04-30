// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.details:
//            KomentarTwitter

class val.id_tw
    implements android.view.rNextAsycTask._cls4
{

    final this._cls1 this$1;
    private final String val$id_komtw;
    private final String val$id_tw;

    public void onClick(View view)
    {
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this)))
        {
            cess._mth2(this._cls1.this).statuslike = "1";
            cess._mth2(this._cls1.this).idkom_pos = val$id_komtw;
            cess._mth2(this._cls1.this).querylike = (new StringBuilder("status=")).append(cess._mth2(this._cls1.this).statuslike).append("&id_kom=").append(val$id_komtw).append("&id_tw=").append(val$id_tw).append("&id_usr=").append(cess._mth2(this._cls1.this).user_id).append("&t=").append(cess._mth2(this._cls1.this).t).toString();
            Log.e("querylike", cess._mth2(this._cls1.this).querylike);
            if (android.os.like >= 11)
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
            view = new android.app.gusKurangTask.execute(cess._mth2(this._cls1.this).wrapperLight);
            view.rLight("Untuk memberi penilaian harus login terlebih dahulu.");
            view.rLight("Tutup", new android.content.DialogInterface.OnClickListener() {

                final KomentarTwitter.KomentarNextAsycTask._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = KomentarTwitter.KomentarNextAsycTask._cls4.this;
                super();
            }
            });
            view._mth4("Register", new android.content.DialogInterface.OnClickListener() {

                final KomentarTwitter.KomentarNextAsycTask._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(KomentarTwitter.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                    KomentarTwitter.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = KomentarTwitter.KomentarNextAsycTask._cls4.this;
                super();
            }
            });
            view._mth4("Login", new android.content.DialogInterface.OnClickListener() {

                final KomentarTwitter.KomentarNextAsycTask._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(KomentarTwitter.KomentarNextAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    KomentarTwitter.KomentarNextAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = KomentarTwitter.KomentarNextAsycTask._cls4.this;
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
        val$id_komtw = s;
        val$id_tw = String.this;
        super();
    }
}
