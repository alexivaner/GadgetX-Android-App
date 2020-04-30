// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

public class this._cls0 extends AsyncTask
{

    final ForumGlobalActivity this$0;

    private void parseJSONSubsNews(String s)
    {
        try
        {
            s = new JSONObject(s);
            postStatusSubsNews = s.getString("success");
            postMessageSubsNews = s.getString("message");
            jArray = s.getJSONArray("InPonsel");
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
            querySubs = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(ForumGlobalActivity.user_id).append("&type=").append("all").append("&stat=").append("0").append("&t=").append(t).toString();
            pushURLSubs = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_artikel").append(Utility.BASE_FORMAT).append("?").append(querySubs).toString();
            Log.e("pushURL", pushURLSubs);
            avoid = HttpPush.getResponse(pushURLSubs);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(querySubs).toString());
            resSubs = avoid.toString();
            Log.e("url ", resSubs);
            parseJSONSubsNews(resSubs);
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
        dataPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_forum_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(ForumGlobalActivity.user_id).toString();
        Log.e("data", dataPonsel);
        PonselMerkTask();
        if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
        {
            Toast.makeText(ForumGlobalActivity.this, postMessageSubsNews, 1).show();
            mDialog.dismiss();
            return;
        }
        if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
        {
            Toast.makeText(ForumGlobalActivity.this, postMessageSubsNews, 1).show();
            mDialog.dismiss();
            return;
        }
        if (postStatusSubsNews.equals("40404"))
        {
            mDialog.dismiss();
            return;
        } else
        {
            Toast.makeText(ForumGlobalActivity.this, postMessageSubsNews, 1).show();
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        mDialog = ProgressDialog.show(ForumGlobalActivity.this, "", "Menghapus...", true);
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public ()
    {
        this$0 = ForumGlobalActivity.this;
        super();
    }
}
