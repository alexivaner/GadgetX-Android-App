// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

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
import com.inponsel.android.utils.NotificationKomenHelper;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.DroidWriterEditText;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            ReplyKomTwActivity

public class this._cls0 extends AsyncTask
{

    final ReplyKomTwActivity this$0;

    private void parseJSONKom(String s)
    {
        try
        {
            s = new JSONObject(s);
            postStatus = s.getString("success");
            postMessage = s.getString("message");
            jum_komen = s.getString("total_komen");
            tot_LikePon = s.getString("total_like");
            totdis_LikePon = s.getString("total_dislike");
            ponselBaseApp.getObserver().setJum_komenLikeTw(jum_komen);
            ponselBaseApp.getObserver().setTot_LikeTw(tot_LikePon);
            ponselBaseApp.getObserver().setTotdis_LikeTw(totdis_LikePon);
            ponselBaseApp.getObserver().setIndexTw(id_tw_to);
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
            if (android.os.ctivity.PostKomen >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.er(avoid)).permitDiskWrites().build());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rep_kom_tw").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            res = avoid.toString();
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
        ponselBaseApp.getObserver().setUpdateType("komentartw");
        ponselBaseApp.getObserver().setStatus_like_ponsel("-");
        btn_send_komen.setEnabled(true);
        edt_pop_komen.setEnabled(true);
        Log.e("postStatus", postStatus);
        if (!postStatus.equals("1"))
        {
            break MISSING_BLOCK_LABEL_241;
        }
        mNotificationHelper.completed(tw_name, mNotificationHelper.SucdiskomStatement);
        edt_pop_komen.setText("");
        ponselBaseApp.getObserver().setUpdateType("komentar");
        ponselBaseApp.getObserver().setStatus_like_ponsel("-");
        if (android.os.er.setStatus_like_ponsel < 11)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        (new sk(ReplyKomTwActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
_L1:
        setResult(-1, (new Intent()).putExtra("jsonKom", res));
        finish();
        return;
        try
        {
            (new sk(ReplyKomTwActivity.this)).execute(new Void[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
        if (postStatus.equals("040"))
        {
            mNotificationHelper.gagal(tw_name, postMessage);
            void1 = new android.app.tivity.postMessage(ctw);
            void1.e(postMessage);
            void1.veButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final ReplyKomTwActivity.PostKomen this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = ReplyKomTwActivity.PostKomen.this;
                super();
            }
            });
            void1.PostKomen();
            return;
        }
        mNotificationHelper.gagal(tw_name, mNotificationHelper.gagalkomStatement);
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
        mNotificationHelper.createNotification(tw_name, mNotificationHelper.komenPostWords);
        btn_send_komen.setEnabled(false);
        edt_pop_komen.setEnabled(false);
    }

    public _cls1.this._cls1()
    {
        this$0 = ReplyKomTwActivity.this;
        super();
    }
}
