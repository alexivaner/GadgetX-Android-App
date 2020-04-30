// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.Toast;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            MerekActivity

public class this._cls1 extends AsyncTask
{

    final this._cls1 this$1;

    private void parseJSONSubsNews(String s)
    {
        try
        {
            s = new JSONObject(s);
            SubsNews = s.getString("success");
            eSubsNews = s.getString("message");
            eSubsNews(this._cls1.this).jArray = s.getJSONArray("InPonsel");
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
            this._cls1.this.doInBackground = (new StringBuilder("idhp=")).append(_fld1).append("&idusr=").append(this._mth1(this._cls1.this).user_id).append("&stat=").append(s).append("&t=").append(s).toString();
            s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_fav_brand").append(Utility.BASE_FORMAT).append("?").append(s).toString();
            Log.e("pushURL", s);
            avoid = HttpPush.getResponse(s);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(s).toString());
            s = avoid.toString();
            Log.e("url ", s);
            parseJSONSubsNews(this._cls1.this.parseJSONSubsNews);
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
        Log.e("postStatusSubsNews", SubsNews);
        Log.e("statFavNews", s);
        if (SubsNews.equals("1") || SubsNews.equals("10"))
        {
            Toast.makeText(SubsNews(this._cls1.this), eSubsNews, 1).show();
            eSubsNews(this._cls1.this).updateViewFavBrand(_fld1, s);
            s.dismiss();
            s(this._cls1.this).ponselBaseApp.getObserver().setUpdateType("sidemenufav");
            this._mth1(this._cls1.this).ponselBaseApp.getObserver().setLoginStat("1");
            return;
        }
        if (SubsNews.equals("00") || SubsNews.equals("0"))
        {
            Toast.makeText(SubsNews(this._cls1.this), eSubsNews, 1).show();
            eSubsNews.dismiss();
            return;
        }
        if (SubsNews.equals("40404"))
        {
            SubsNews.dismiss();
            return;
        } else
        {
            Toast.makeText(SubsNews(this._cls1.this), eSubsNews, 1).show();
            eSubsNews.imgFavoritBrand.setBackgroundResource(0x7f020240);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (s.equals("1"))
        {
            s = ProgressDialog.show(s(this._cls1.this), "", "Menambahkan...", true);
        } else
        {
            _fld1 = ProgressDialog.show(this._mth1(this._cls1.this), "", "Menghapus...", true);
        }
        _fld1.setCancelable(true);
        _fld1.show();
    }

    public ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
