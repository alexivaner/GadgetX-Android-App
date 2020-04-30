// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal2RSSKomen

class val.id_rss
    implements android.view._cls2RSSKomen.PostKomen._cls4
{

    final y this$1;
    private final String val$id_komrss;
    private final String val$id_rss;

    public void onClick(View view)
    {
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this).getActivity()))
        {
            cess._mth2(this._cls1.this).statuslike = "0";
            cess._mth2(this._cls1.this).idkom_pos = val$id_komrss;
            cess._mth2(this._cls1.this).querylike = (new StringBuilder("status=")).append(cess._mth2(this._cls1.this).statuslike).append("&id_kom=").append(val$id_komrss).append("&id_rss=").append(val$id_rss).append("&id_usr=").append(cess._mth2(this._cls1.this).user_id).append("&t=").append(cess._mth2(this._cls1.this).t).toString();
            Log.e("querylike", cess._mth2(this._cls1.this).querylike);
            if (android.os.al2RSSKomen.querylike >= 11)
            {
                (new angTask(cess._mth2(this._cls1.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new angTask(cess._mth2(this._cls1.this))).execute(new Void[0]);
                return;
            }
        } else
        {
            view = new android.app.>(cess._mth2(this._cls1.this).getActivity());
            view.ssage("Untuk memberi penilaian harus login terlebih dahulu.");
            view.sitiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal2RSSKomen.PostKomen._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = Hal2RSSKomen.PostKomen._cls4.this;
                super();
            }
            });
            view.utralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal2RSSKomen.PostKomen._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(Hal2RSSKomen.PostKomen.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                    Hal2RSSKomen.PostKomen.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = Hal2RSSKomen.PostKomen._cls4.this;
                super();
            }
            });
            view.gativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal2RSSKomen.PostKomen._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(Hal2RSSKomen.PostKomen.access$2(this$1).getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    Hal2RSSKomen.PostKomen.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = Hal2RSSKomen.PostKomen._cls4.this;
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
        val$id_rss = String.this;
        super();
    }
}
