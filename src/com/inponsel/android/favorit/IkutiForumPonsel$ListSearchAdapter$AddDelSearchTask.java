// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.favorit:
//            IkutiForumPonsel

public class this._cls1 extends AsyncTask
{

    final this._cls1 this$1;

    private void parseJSONSubsNews(String s)
    {
        try
        {
            s = new JSONObject(s);
            this._mth1(this._cls1.this).postStatusSubsNews = s.getString("success");
            this._mth1(this._cls1.this).postMessageSubsNews = s.getString("message");
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
            doInBackground(this._cls1.this).querydel = (new StringBuilder("idhp=")).append(this._mth1(this._cls1.this).id_hp_del).append("&idusr=").append(this._mth1(this._cls1.this).user_id).append("&type=").append("all").append("&stat=1").append("&t=").append(_fld1).toString();
            this._mth1(this._cls1.this).pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_artikel").append(Utility.BASE_FORMAT).append("?").append(this._mth1(this._cls1.this).querydel).toString();
            Log.e("pushURL", this._mth1(this._cls1.this).pushURLdel);
            avoid = HttpPush.getResponse(this._mth1(this._cls1.this).pushURLdel);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(this._mth1(this._cls1.this).querydel).toString());
            this._mth1(this._cls1.this).resdel = avoid.toString();
            Log.e("url ", this._mth1(this._cls1.this).resdel);
            parseJSONSubsNews(parseJSONSubsNews(this._cls1.this).resdel);
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
        this._cls1.this.onPostExecute.dismiss();
        this._mth1(this._cls1.this).dialog.dismiss();
        try
        {
            if (this._mth1(this._cls1.this).postStatusSubsNews.equals("1") || this._mth1(this._cls1.this).postStatusSubsNews.equals("10"))
            {
                Toast.makeText(this._mth1(this._cls1.this), this._mth1(this._cls1.this).postMessageSubsNews, 1).show();
                this._mth1(this._cls1.this).FavoritHPTask();
                this._mth1(this._cls1.this).ponselBaseApp.getObserver().setUpdateType("sidemenufav");
                this._mth1(this._cls1.this).ponselBaseApp.getObserver().setLoginStat("1");
                _fld1.dismiss();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        if (this._mth1(this._cls1.this).postStatusSubsNews.equals("00") || this._mth1(this._cls1.this).postStatusSubsNews.equals("0"))
        {
            Toast.makeText(this._mth1(this._cls1.this), this._mth1(this._cls1.this).postMessageSubsNews, 1).show();
            _fld1.dismiss();
            return;
        }
        if (this._mth1(this._cls1.this).postStatusSubsNews.equals("40404"))
        {
            _fld1.dismiss();
            return;
        }
        Toast.makeText(this._mth1(this._cls1.this), this._mth1(this._cls1.this).postMessageSubsNews, 1).show();
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        this._mth1(this._cls1.this).statusdel = "";
        if (this._mth1(this._cls1.this).statdel.equals("1"))
        {
            _fld1 = ProgressDialog.show(this._mth1(this._cls1.this), "", "Menambahkan...", true);
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
