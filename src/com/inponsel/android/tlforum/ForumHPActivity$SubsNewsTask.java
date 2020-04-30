// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.Toast;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

public class this._cls0 extends AsyncTask
{

    final ForumHPActivity this$0;

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
            querySubs = (new StringBuilder("idhp=")).append(id_hp).append("&idusr=").append(ForumHPActivity.user_id).append("&type=").append("all").append("&stat=").append(statSubNews).append("&t=").append(t).toString();
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
        if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
        {
            Toast.makeText(ForumHPActivity.this, postMessageSubsNews, 1).show();
            if (statSubNews.equals("1"))
            {
                img_NotifHp.setBackgroundResource(0x7f02013b);
                img_NotifHp.setText("Hapus");
                img_NotifHp.setTextColor(getResources().getColor(0x7f080182));
            } else
            {
                img_NotifHp.setBackgroundResource(0x7f02013a);
                img_NotifHp.setText("Ikuti");
                img_NotifHp.setTextColor(Color.parseColor("#795548"));
            }
            mDialog.dismiss();
            return;
        }
        if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
        {
            Toast.makeText(ForumHPActivity.this, postMessageSubsNews, 1).show();
            if (statSubNews.equals("1"))
            {
                img_NotifHp.setBackgroundResource(0x7f02013b);
                img_NotifHp.setText("Hapus");
                img_NotifHp.setTextColor(getResources().getColor(0x7f080182));
            } else
            {
                img_NotifHp.setBackgroundResource(0x7f02013a);
                img_NotifHp.setText("Ikuti");
                img_NotifHp.setTextColor(Color.parseColor("#795548"));
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
            Toast.makeText(ForumHPActivity.this, postMessageSubsNews, 1).show();
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (statSubNews.equals("1"))
        {
            mDialog = ProgressDialog.show(ForumHPActivity.this, "", "Menambahkan...", true);
        } else
        {
            mDialog = ProgressDialog.show(ForumHPActivity.this, "", "Menghapus...", true);
        }
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public ()
    {
        this$0 = ForumHPActivity.this;
        super();
    }
}
