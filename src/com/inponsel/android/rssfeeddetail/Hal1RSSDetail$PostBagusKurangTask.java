// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.TextView;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeRSSHelper;
import com.inponsel.android.utils.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

public class this._cls0 extends AsyncTask
{

    final Hal1RSSDetail this$0;

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
        ponselBaseApp.getObserver().setIndexRSS(id_rss);
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
            if (android.os.ail.PostBagusKurangTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.nit>(avoid)).rmitDiskWrites().ild());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_rss.php?").append(querylike).toString();
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
        Log.e("index_komposlike", tot_LikeRSS);
        ponselBaseApp.getObserver().setUpdateType("likerss");
        ponselBaseApp.getObserver().setStatus_like_ponsel("-");
        Log.e("postStatusLikeKom", postStatusLikeKom);
        if (!postStatusLikeKom.equals("1"))
        {
            break MISSING_BLOCK_LABEL_203;
        }
        if (!statuslike.equals("1"))
        {
            break MISSING_BLOCK_LABEL_154;
        }
        notificationLikeHelper.completed("Berita RSS", notificationLikeHelper.suclikefrontKomen);
_L1:
        txtLikeKom.setText(tot_LikeRSS);
        if (android.os.ail.tot_LikeRSS < 16)
        {
            list_img_like.setBackgroundDrawable(drwLoveFull);
            return;
        }
        break MISSING_BLOCK_LABEL_185;
        try
        {
            notificationLikeHelper.completed("Berita RSS", notificationLikeHelper.sucdislikefrontKomen);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            void1.printStackTrace();
            return;
        }
          goto _L1
        list_img_like.setBackground(drwLoveFull);
        return;
        if (statuslike.equals("1"))
        {
            notificationLikeHelper.gagal("Berita RSS", notificationLikeHelper.gaglikefrontKomen);
            return;
        }
        notificationLikeHelper.gagal("Berita RSS", notificationLikeHelper.gagdislikefrontKomen);
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (statuslike.equals("1"))
        {
            notificationLikeHelper.createNotification("Berita RSS", notificationLikeHelper.likefrontKomen);
            return;
        } else
        {
            notificationLikeHelper.createNotification("Berita RSS", notificationLikeHelper.dislikefrontKomen);
            return;
        }
    }

    public ()
    {
        this$0 = Hal1RSSDetail.this;
        super();
    }
}
