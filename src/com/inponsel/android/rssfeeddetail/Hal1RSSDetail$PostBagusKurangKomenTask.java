// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.os.AsyncTask;
import android.os.StrictMode;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeRSSHelper;
import com.inponsel.android.utils.Util;
import java.util.ArrayList;
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
        tot_LikeKom = s.getString("total_like");
        totdis_LikeKom = s.getString("total_dislike");
        Log.e("tot_LikePon", tot_LikeKom);
        Log.e("totdis_LikePon", totdis_LikeKom);
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
            if (android.os.ostBagusKurangKomenTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.ostBagusKurangKomenTask(avoid)).iskWrites().iskWrites());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_komen_rss.php?").append(querylike).toString();
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
        Log.e("postStatusLikeKom", postStatusLikeKom);
        if (!postStatusLikeKom.equals("1"))
        {
            break MISSING_BLOCK_LABEL_199;
        }
        if (!statuslike.equals("1"))
        {
            break MISSING_BLOCK_LABEL_149;
        }
        notificationLikeHelper.completed(rss_title, notificationLikeHelper.suclikefrontKomen);
_L1:
        Log.e("mArrayListData", String.valueOf(Hal1RSSDetail.access$4(Hal1RSSDetail.this).size()));
        Log.e("index_komposlike", idkom_pos);
        updateViewLikeDis(idkom_pos);
        if (android.os.dkom_pos >= 11)
        {
            (new >(Hal1RSSDetail.this)).teOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        break MISSING_BLOCK_LABEL_179;
        try
        {
            notificationLikeHelper.completed(rss_title, notificationLikeHelper.sucdislikefrontKomen);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
        (new >(Hal1RSSDetail.this)).te(new Void[0]);
        return;
        if (statuslike.equals("1"))
        {
            notificationLikeHelper.gagal(rss_title, postMessageLikeKom);
            return;
        }
        notificationLikeHelper.gagal(rss_title, postMessageLikeKom);
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (statuslike.equals("1"))
        {
            notificationLikeHelper.createNotification(rss_title, notificationLikeHelper.likefrontKomen);
            return;
        } else
        {
            notificationLikeHelper.createNotification(rss_title, notificationLikeHelper.dislikefrontKomen);
            return;
        }
    }

    public ()
    {
        this$0 = Hal1RSSDetail.this;
        super();
    }
}
