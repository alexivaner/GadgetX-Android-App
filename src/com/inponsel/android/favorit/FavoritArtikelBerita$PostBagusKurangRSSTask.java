// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.os.AsyncTask;
import android.os.StrictMode;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeRSSHelper;
import com.inponsel.android.utils.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritArtikelBerita

public class this._cls0 extends AsyncTask
{

    final FavoritArtikelBerita this$0;

    private void parseJSONLikeKom(String s)
    {
        int i;
        try
        {
            s = new JSONObject(s);
            postStatusLikeKom = s.getString("success");
            postMessageLikeKom = s.getString("message");
            jArray = s.getJSONArray("InPonsel");
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
        jum_komen = s.getString("total_komen");
        tot_LikeRSS = s.getString("total_like");
        totdis_LikeKom = s.getString("total_dislike");
        Log.e("tot_LikePon", tot_LikeRSS);
        Log.e("totdis_LikePon", totdis_LikeKom);
        ponselBaseApp.getObserver().setJum_komenLikeRSS(jum_komen);
        ponselBaseApp.getObserver().setTot_LikeRSS(tot_LikeRSS);
        ponselBaseApp.getObserver().setIndexRSS(idrss_pos);
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_50;
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
            if (android.os.agusKurangRSSTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.agusKurangRSSTask(avoid)).ites().ites());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_rss.php?").append(querylikeRSS).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            reslike = avoid.toString();
            parseJSONLikeKom(reslike);
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
        ponselBaseApp.getObserver().setUpdateType("likerss");
        ponselBaseApp.getObserver().setStatus_like_ponsel("-");
        Log.e("postStatusLikeKom", postStatusLikeKom);
        if (!postStatusLikeKom.equals("1"))
        {
            break MISSING_BLOCK_LABEL_169;
        }
        if (!statuslike.equals("1"))
        {
            break MISSING_BLOCK_LABEL_144;
        }
        notificationLikeHelperRSS.completed("RSS Berita", notificationLikeHelperRSS.suclikefrontKomen);
_L1:
        Log.e("mArrayListDataTW", String.valueOf(FavoritArtikelBerita.access$0(FavoritArtikelBerita.this).size()));
        Log.e("index_komposlike", idkom_pos);
        updateViewLikeDisRSS(idrss_pos);
        return;
        try
        {
            notificationLikeHelperRSS.completed("RSS Berita", notificationLikeHelperRSS.sucdislikefrontKomen);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
        if (statuslike.equals("1"))
        {
            notificationLikeHelperRSS.gagal("RSS Berita", notificationLikeHelperRSS.gaglikefrontKomen);
            return;
        }
        notificationLikeHelperRSS.gagal("RSS Berita", notificationLikeHelperRSS.gagdislikefrontKomen);
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (statuslike.equals("1"))
        {
            notificationLikeHelperRSS.createNotification("RSS Berita", notificationLikeHelperRSS.likefrontKomen);
            return;
        } else
        {
            notificationLikeHelperRSS.createNotification("RSS Berita", notificationLikeHelperRSS.dislikefrontKomen);
            return;
        }
    }

    public ()
    {
        this$0 = FavoritArtikelBerita.this;
        super();
    }
}
