// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.os.StrictMode;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeSelengkapActivity

public class this._cls1 extends AsyncTask
{

    final this._cls1 this$1;

    private void parseJSONLikePon(String s)
    {
        int i;
        try
        {
            JSONObject jsonobject = new JSONObject(s);
            this._mth1(this._cls1.this).postStatusLikePon = jsonobject.getString("success");
            this._mth1(this._cls1.this).postMessageLikePon = jsonobject.getString("message");
            Log.e("postStatusLikePon", s);
            this._mth1(this._cls1.this).jArray = jsonobject.getJSONArray("InPonsel");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        i = 0;
        if (i >= this._mth1(this._cls1.this).jArray.length())
        {
            return;
        }
        s = this._mth1(this._cls1.this).jArray.getJSONObject(i);
        this._mth1(this._cls1.this).jum_komenLikePon = s.getString("total_kom");
        this._mth1(this._cls1.this).tot_LikePon = s.getString("total_like");
        this._mth1(this._cls1.this).totdis_LikePon = s.getString("total_dislike");
        Log.e("jum_komenLikePon", this._mth1(this._cls1.this).jum_komenLikePon);
        Log.e("tot_LikePon", this._mth1(this._cls1.this).tot_LikePon);
        Log.e("totdis_LikePon", this._mth1(this._cls1.this).totdis_LikePon);
        _fld1.getObserver().setJum_komenLikePon(this._mth1(this._cls1.this).jum_komenLikePon);
        _fld1.getObserver().setTot_LikePon(this._mth1(this._cls1.this).tot_LikePon);
        _fld1.getObserver().setTotdis_LikePon(this._mth1(this._cls1.this).totdis_LikePon);
        _fld1.getObserver().setUpdateType("likedisPonsel");
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_65;
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
            if (android.os.usKurangTask > 9)
            {
                StrictMode.setThreadPolicy((new android.os.usKurangTask()).usKurangTask().usKurangTask());
            }
            Log.e("posA", String.valueOf(this._cls1.this.doInBackground));
            avoid = _fld1;
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_ponsel").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            _fld1 = avoid.toString();
            parseJSONLikePon(this._cls1.this.parseJSONLikePon);
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
        Log.e("postStatusLikePon", onPostExecute(this._cls1.this).postStatusLikePon);
        if (!this._mth1(this._cls1.this).postStatusLikePon.equals("1"))
        {
            break MISSING_BLOCK_LABEL_172;
        }
        this._mth1(this._cls1.this).notificationLikeHelper.completed(this._mth1(this._cls1.this).namalengkapbgskrg, this._mth1(this._cls1.this).notificationLikeHelper.SucdislikeStatement);
        this._mth1(this._cls1.this).hpMoreArray.set(this._mth1(this._cls1.this).posobser, _fld1);
        if (!_fld1.equals("1"))
        {
            break MISSING_BLOCK_LABEL_153;
        }
        _fld1.getObserver().setStatus_like_ponsel("1");
_L1:
        this._mth1(this._cls1.this).posobser = _fld1;
        return;
        try
        {
            _fld1.getObserver().setStatus_like_ponsel("0");
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
        this._mth1(this._cls1.this).notificationLikeHelper.gagal(this._mth1(this._cls1.this).namalengkapbgskrg, this._mth1(this._cls1.this).notificationLikeHelper.gagallikeStatement);
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (_fld1.equals("1"))
        {
            this._mth1(this._cls1.this).notificationLikeHelper.createNotification(this._mth1(this._cls1.this).namalengkapbgskrg, this._mth1(this._cls1.this).notificationLikeHelper.likeStatement);
            return;
        } else
        {
            this._mth1(this._cls1.this).notificationLikeHelper.createNotification(this._mth1(this._cls1.this).namalengkapbgskrg, this._mth1(this._cls1.this).notificationLikeHelper.dislikeStatement);
            return;
        }
    }

    public ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
