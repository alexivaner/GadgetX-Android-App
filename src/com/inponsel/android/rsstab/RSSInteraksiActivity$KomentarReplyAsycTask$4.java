// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSInteraksiActivity

class val.tl_id
    implements android.view.eplyAsycTask._cls4
{

    final this._cls1 this$1;
    private final String val$id_komrss;
    private final String val$tl_id;

    public void onClick(View view)
    {
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this)))
        {
            cess._mth2(this._cls1.this).statuslike = "0";
            cess._mth2(this._cls1.this).idkom_pos = val$id_komrss;
            cess._mth2(this._cls1.this).querylike = (new StringBuilder("status=")).append(cess._mth2(this._cls1.this).statuslike).append("&id_kom=").append(val$id_komrss).append("&tl_id=").append(val$tl_id).append("&id_usr=").append(cess._mth2(this._cls1.this).user_id).append("&t=").append(cess._mth2(this._cls1.this).t).toString();
            Log.e("querylike", cess._mth2(this._cls1.this).querylike);
            if (android.os.ke >= 11)
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
            view = new android.app.sKurangTask.execute(cess._mth2(this._cls1.this));
            view.ReplyAsycTask("Untuk memberi penilaian harus login terlebih dahulu.");
            view.ReplyAsycTask("Tutup", new android.content.DialogInterface.OnClickListener() {

                final RSSInteraksiActivity.KomentarReplyAsycTask._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = RSSInteraksiActivity.KomentarReplyAsycTask._cls4.this;
                super();
            }
            });
            view._mth4("Register", new android.content.DialogInterface.OnClickListener() {

                final RSSInteraksiActivity.KomentarReplyAsycTask._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(RSSInteraksiActivity.KomentarReplyAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                    RSSInteraksiActivity.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = RSSInteraksiActivity.KomentarReplyAsycTask._cls4.this;
                super();
            }
            });
            view._mth4("Login", new android.content.DialogInterface.OnClickListener() {

                final RSSInteraksiActivity.KomentarReplyAsycTask._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(RSSInteraksiActivity.KomentarReplyAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    RSSInteraksiActivity.KomentarReplyAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = RSSInteraksiActivity.KomentarReplyAsycTask._cls4.this;
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
        val$tl_id = String.this;
        super();
    }
}
