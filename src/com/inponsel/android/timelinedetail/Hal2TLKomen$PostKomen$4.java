// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal2TLKomen

class val.tl_id
    implements android.view.al2TLKomen.PostKomen._cls4
{

    final y this$1;
    private final String val$id_komrss;
    private final String val$tl_id;

    public void onClick(View view)
    {
        if (cess._mth2(this._cls1.this).userFunctions.isUserLoggedIn(cess._mth2(this._cls1.this).getActivity()))
        {
            cess._mth2(this._cls1.this).statuslike = "0";
            cess._mth2(this._cls1.this).idkom_pos = val$id_komrss;
            cess._mth2(this._cls1.this).querylike = (new StringBuilder("status=")).append(cess._mth2(this._cls1.this).statuslike).append("&id_kom=").append(val$id_komrss).append("&tl_id=").append(val$tl_id).append("&id_usr=").append(cess._mth2(this._cls1.this).user_id).append("&t=").append(cess._mth2(this._cls1.this).t).toString();
            Log.e("querylike", cess._mth2(this._cls1.this).querylike);
            if (android.os..Hal2TLKomen.querylike >= 11)
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
            view = new android.app.t>(cess._mth2(this._cls1.this).getActivity());
            view.essage("Untuk memberi penilaian harus login terlebih dahulu.");
            view.ositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final Hal2TLKomen.PostKomen._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$2 = Hal2TLKomen.PostKomen._cls4.this;
                super();
            }
            });
            view.eutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                final Hal2TLKomen.PostKomen._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(Hal2TLKomen.PostKomen.access$2(this$1).getActivity(), com/inponsel/android/v2/RegisterActivity);
                    Hal2TLKomen.PostKomen.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = Hal2TLKomen.PostKomen._cls4.this;
                super();
            }
            });
            view.egativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                final Hal2TLKomen.PostKomen._cls4 this$2;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = new Intent(Hal2TLKomen.PostKomen.access$2(this$1).getActivity(), com/inponsel/android/v2/LoginActivity);
                    dialoginterface.putExtra("activity", "main");
                    Hal2TLKomen.PostKomen.access$2(this$1).startActivity(dialoginterface);
                }

            
            {
                this$2 = Hal2TLKomen.PostKomen._cls4.this;
                super();
            }
            });
            view.();
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
