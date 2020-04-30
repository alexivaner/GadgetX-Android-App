// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            ProfilePonselUserActivity

public class this._cls0 extends AsyncTask
{

    final ProfilePonselUserActivity this$0;

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
            query = (new StringBuilder("idhp=")).append(id_hp_1).append("&idusr=").append(user_id).append("&stat=").append(statSubNews).append("&t=").append(t).toString();
            pushURL = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(query).toString();
            Log.e("pushURL", pushURL);
            avoid = HttpPush.getResponse(pushURL);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(query).toString());
            res = avoid.toString();
            Log.e("url ", res);
            parseJSONSubsNews(res);
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
        if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
        {
            Toast.makeText(ProfilePonselUserActivity.this, postMessageSubsNews, 1).show();
            if (statSubNews.equals("1"))
            {
                if (sdk < 16)
                {
                    detail_favoritenews.setBackgroundDrawable(drwKurang);
                } else
                {
                    detail_favoritenews.setBackground(drwKurang);
                }
            } else
            if (sdk < 16)
            {
                detail_favoritenews.setBackgroundDrawable(drw);
            } else
            {
                detail_favoritenews.setBackground(drw);
            }
            mDialog.dismiss();
            return;
        }
        if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
        {
            Toast.makeText(ProfilePonselUserActivity.this, postMessageSubsNews, 1).show();
            if (statSubNews.equals("1"))
            {
                if (sdk < 16)
                {
                    detail_favoritenews.setBackgroundDrawable(drwKurang);
                } else
                {
                    detail_favoritenews.setBackground(drwKurang);
                }
            } else
            if (sdk < 16)
            {
                detail_favoritenews.setBackgroundDrawable(drw);
            } else
            {
                detail_favoritenews.setBackground(drw);
            }
            mDialog.dismiss();
            return;
        }
        if (postStatusSubsNews.equals("40404"))
        {
            mDialog.dismiss();
            return;
        } else
        {
            Toast.makeText(ProfilePonselUserActivity.this, postMessageSubsNews, 1).show();
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (statSubNews.equals("1"))
        {
            mDialog = ProgressDialog.show(ProfilePonselUserActivity.this, "", "Menambahkan...", true);
        } else
        {
            mDialog = ProgressDialog.show(ProfilePonselUserActivity.this, "", "Menghapus...", true);
        }
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public ()
    {
        this$0 = ProfilePonselUserActivity.this;
        super();
    }
}
