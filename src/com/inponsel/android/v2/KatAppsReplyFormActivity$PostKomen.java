// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.DroidWriterEditText;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            KatAppsReplyFormActivity

public class this._cls0 extends AsyncTask
{

    final KatAppsReplyFormActivity this$0;

    private void parseJSONKom(String s)
    {
        try
        {
            s = new JSONObject(s);
            postStatus = s.getString("success");
            postMessage = s.getString("message");
            Log.e("postStatus", postStatus);
            if (postStatus.equals("1"))
            {
                top_id = s.getString("top_id");
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            if (android.os.ty.PostKomen >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.it>(avoid)).mitDiskWrites().ld());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_repkom_katapps").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            res = avoid.toString();
            jsonKom = avoid.toString();
            parseJSONKom(res);
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
        btn_send_komen.setEnabled(true);
        edt_pop_komen.setEnabled(true);
        if (postStatus.equals("1"))
        {
            ponselBaseApp.getObserver().setUpdateType("appskategorikom");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            edt_pop_komen.setText("");
            notifBerhasil();
            setResult(-1, (new Intent()).putExtra("jsonKom", res));
            (new Task(KatAppsReplyFormActivity.this)).execute(new Void[0]);
            finish();
            return;
        }
        if (postStatus.equals("040"))
        {
            notifGagal();
            void1 = new android.app.y.notifGagal(ctw);
            void1.ctw(postMessage);
            void1.on("Tutup", new android.content.DialogInterface.OnClickListener() {

                final KatAppsReplyFormActivity.PostKomen this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = KatAppsReplyFormActivity.PostKomen.this;
                super();
            }
            });
            void1.PostKomen();
            return;
        } else
        {
            notifGagal();
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
        btn_send_komen.setEnabled(false);
        edt_pop_komen.setEnabled(false);
    }

    public _cls1.this._cls1()
    {
        this$0 = KatAppsReplyFormActivity.this;
        super();
    }
}
