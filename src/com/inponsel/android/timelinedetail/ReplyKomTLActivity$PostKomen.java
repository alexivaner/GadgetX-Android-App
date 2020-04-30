// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

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

// Referenced classes of package com.inponsel.android.timelinedetail:
//            ReplyKomTLActivity

public class this._cls0 extends AsyncTask
{

    final ReplyKomTLActivity this$0;

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
            ponselBaseApp.getObserver().setJum_komenLikeTL(jum_komen);
            ponselBaseApp.getObserver().setTot_LikeTL(tot_LikePon);
            ponselBaseApp.getObserver().setTotdis_LikeTL(totdis_LikePon);
            ponselBaseApp.getObserver().setIndexTL(id_rss_to);
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
            if (android.os.yKomTLActivity.PostKomen >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.er(avoid)).permitDiskWrites().build());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_repkom_forum").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).toString();
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
        if (tl_type.contains("conversation"))
        {
            ponselBaseApp.getObserver().setUpdateType("komentarconv");
        } else
        {
            ponselBaseApp.getObserver().setUpdateType("komentartl");
        }
        ponselBaseApp.getObserver().setStatus_like_ponsel("-");
        btn_send_komen.setEnabled(true);
        edt_pop_komen.setEnabled(true);
        Log.e("postStatus", postStatus);
        if (!postStatus.equals("1"))
        {
            break MISSING_BLOCK_LABEL_254;
        }
        notifBerhasil();
        edt_pop_komen.setText("");
        ponselBaseApp.getObserver().setUpdateType("komentartl");
        ponselBaseApp.getObserver().setStatus_like_ponsel("-");
        if (android.os.er.setStatus_like_ponsel < 11)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        (new sk(ReplyKomTLActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
_L1:
        setResult(-1, (new Intent()).putExtra("jsonKom", res));
        finish();
        return;
        try
        {
            (new sk(ReplyKomTLActivity.this)).execute(new Void[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
        if (postStatus.equals("040"))
        {
            notifGagal();
            void1 = new android.app.KomTLActivity.notifGagal(ctw);
            void1.e(postMessage);
            void1.veButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                final ReplyKomTLActivity.PostKomen this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = ReplyKomTLActivity.PostKomen.this;
                super();
            }
            });
            void1.PostKomen();
            return;
        }
        notifGagal();
        return;
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
        this$0 = ReplyKomTLActivity.this;
        super();
    }
}
