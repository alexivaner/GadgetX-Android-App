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
//            RSSFeedByTag, RegisterActivity, LoginActivity

class val.id_rss
    implements android.view.AsycTask._cls3
{

    final this._cls1 this$1;
    private final String val$id_rss;

    public void onClick(View view)
    {
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this)))
        {
            cess._mth2(this._cls1.this).statuslike = "1";
            cess._mth2(this._cls1.this).idkom_pos = val$id_rss;
            cess._mth2(this._cls1.this).querylike = (new StringBuilder("status=")).append(cess._mth2(this._cls1.this).statuslike).append("&id_rss=").append(val$id_rss).append("&id_usr=").append(cess._mth2(this._cls1.this).user_id).append("&t=").append(cess._mth2(this._cls1.this).t).toString();
            Log.e("querylike", cess._mth2(this._cls1.this).querylike);
            if (android.os.ylike >= 11)
            {
                (new sk(cess._mth2(this._cls1.this))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            } else
            {
                (new sk(cess._mth2(this._cls1.this))).execute(new Void[0]);
                return;
            }
        } else
        {
            view = new android.app.agusKurangTask.execute(cess._mth2(this._cls1.this).wrapperLight);
            view.("Untuk memberi penilaian harus login terlebih dahulu.");
            view.eButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final RSSFeedByTag.RSSOldAsycTask._cls3 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = RSSFeedByTag.RSSOldAsycTask._cls3.this;
                super();
            }
            });
            view.Button("Register", new android.content.DialogInterface.OnClickListener() {

                final RSSFeedByTag.RSSOldAsycTask._cls3 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(RSSFeedByTag.RSSOldAsycTask.access$2(this$1), com/inponsel/android/v2/RegisterActivity);
                    RSSFeedByTag.RSSOldAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = RSSFeedByTag.RSSOldAsycTask._cls3.this;
                super();
            }
            });
            view.eButton("Login", new android.content.DialogInterface.OnClickListener() {

                final RSSFeedByTag.RSSOldAsycTask._cls3 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(RSSFeedByTag.RSSOldAsycTask.access$2(this$1), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    RSSFeedByTag.RSSOldAsycTask.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = RSSFeedByTag.RSSOldAsycTask._cls3.this;
                super();
            }
            });
            view._mth3();
            return;
        }
    }


    _cls3.this._cls2()
    {
        this$1 = final__pcls2;
        val$id_rss = String.this;
        super();
    }
}
