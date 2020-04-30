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
            sNews = s.getString("success");
            bsNews = s.getString("message");
            bsNews(this._cls1.this).jArray = s.getJSONArray("InPonsel");
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
            this._cls1.this.doInBackground = (new StringBuilder("idhp=")).append(_fld1).append("&idusr=").append(this._mth1(this._cls1.this).user_id).append("&stat=").append(_fld1).append("&t=").append(_fld1).toString();
            _fld1 = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_brand").append(Utility.BASE_FORMAT).append("?").append(_fld1).toString();
            Log.e("pushURL", _fld1);
            avoid = HttpPush.getResponse(_fld1);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(_fld1).toString());
            _fld1 = avoid.toString();
            Log.e("url ", _fld1);
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
        Log.e("postStatusSubsNews", sNews);
        Log.e("statSubNews", sNews);
        if (sNews.equals("1") || sNews.equals("10"))
        {
            Toast.makeText(sNews(this._cls1.this), bsNews, 1).show();
            bsNews(this._cls1.this).updateViewSubsBrand(_fld1, _fld1);
            _fld1.dismiss();
            this._mth1(this._cls1.this).ponselBaseApp.getObserver().setUpdateType("sidemenufav");
            this._mth1(this._cls1.this).ponselBaseApp.getObserver().setLoginStat("1");
            return;
        }
        if (sNews.equals("00") || sNews.equals("0"))
        {
            Toast.makeText(sNews(this._cls1.this), bsNews, 1).show();
            bsNews.dismiss();
            return;
        }
        if (sNews.equals("40404"))
        {
            sNews.dismiss();
            return;
        } else
        {
            Toast.makeText(sNews(this._cls1.this), bsNews, 1).show();
            bsNews.gLanggananBerita.setBackgroundResource(0x7f020240);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (gLanggananBerita.equals("1"))
        {
            gLanggananBerita = ProgressDialog.show(gLanggananBerita(this._cls1.this), "", "Menambahkan...", true);
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
