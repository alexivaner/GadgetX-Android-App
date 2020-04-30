// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.widget.Toast;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.v2:
//            PengaturanActivity

public class this._cls0 extends AsyncTask
{

    final PengaturanActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            if (android.os.ngaturanTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.nit>(avoid)).rmitDiskWrites().ild());
                StrictMode.setThreadPolicy(avoid);
            }
            query = (new StringBuilder("id=")).append(user_id).append("&upass=").append(passlam).append("&mail=").append(statusEmail_mod).append("&push=").append(statusPush_mod).append("&rssmail=").append(statusEmail_rssmod).append("&rsspush=").append(statusPush_rssmod).append("&kmail=").append(komen_mail_mod).append("&lmail=").append(like_mail_mod).append("&tmail=").append(tanggap_mail_mod).append("&fmail=").append(forum_mail_mod).append("&kpush=").append(komen_push_mod).append("&lpush=").append(like_push_mod).append("&tpush=").append(tanggap_push_mod).append("&fpush=").append(forum_push_mod).append("&t=").append(t).toString();
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_pengaturan_mod").append(Utility.BASE_FORMAT).append("?").append(query).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            resStatus = avoid.toString();
            Log.e("url.............", resStatus);
            Log.e("status", resStatus);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        mDialog.dismiss();
        parseJSONResponse(resStatus);
        if (settingResp.equals("1"))
        {
            Toast.makeText(PengaturanActivity.this, settingMsg, 1).show();
        } else
        if (settingResp.equals("U404"))
        {
            void1 = new android.app.tingResp(PengaturanActivity.this);
            void1._mth0(settingMsg);
            void1.ton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final PengaturanActivity.PengaturanTask this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = PengaturanActivity.PengaturanTask.this;
                super();
            }
            });
            void1.gaturanTask();
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        mDialog = ProgressDialog.show(PengaturanActivity.this, "", "Menyimpan...", true);
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public _cls1.this._cls1()
    {
        this$0 = PengaturanActivity.this;
        super();
    }
}
