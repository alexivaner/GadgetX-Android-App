// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.os.AsyncTask;
import android.os.StrictMode;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

public class this._cls0 extends AsyncTask
{

    final Hal2Spek this$0;

    private void parseJSONLikePon(String s)
    {
        int i;
        try
        {
            JSONObject jsonobject = new JSONObject(s);
            postStatusLikePon = jsonobject.getString("success");
            postMessageLikePon = jsonobject.getString("message");
            Log.e("postStatusLikePon", s);
            jArray = jsonobject.getJSONArray("InPonsel");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        i = 0;
        if (i >= jArray.length())
        {
            return;
        }
        s = jArray.getJSONObject(i);
        jum_komenLikePon = s.getString("total_kom");
        tot_LikePon = s.getString("total_like");
        totdis_LikePon = s.getString("total_dislike");
        Log.e("jum_komenLikePon", jum_komenLikePon);
        Log.e("tot_LikePon", tot_LikePon);
        Log.e("totdis_LikePon", totdis_LikePon);
        ponselBaseApp.getObserver().setJum_komenLikePon(jum_komenLikePon);
        ponselBaseApp.getObserver().setTot_LikePon(tot_LikePon);
        ponselBaseApp.getObserver().setTotdis_LikePon(totdis_LikePon);
        ponselBaseApp.getObserver().setUpdateType("likedisPonsel");
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_56;
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
            if (android.os.stBagusKurangTask > 9)
            {
                StrictMode.setThreadPolicy((new android.os.er()).permitAll().build());
            }
            avoid = (new StringBuilder("idhp=")).append(id_hp).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_ponsel").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            res = avoid.toString();
            parseJSONLikePon(res);
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
        Log.e("postStatusLikePon", postStatusLikePon);
        if (!postStatusLikePon.equals("1"))
        {
            break MISSING_BLOCK_LABEL_107;
        }
        notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.SucdislikeStatement);
        if (statusLikeHp.equals("1"))
        {
            ponselBaseApp.getObserver().setStatus_like_ponsel("1");
            return;
        }
        try
        {
            ponselBaseApp.getObserver().setStatus_like_ponsel("0");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        notificationLikeHelper.gagal(namalengkapbgskrg, postMessageLikePon);
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (statusLikeHp.equals("1"))
        {
            notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.likeStatement);
            return;
        } else
        {
            notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.dislikeStatement);
            return;
        }
    }

    public ()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
