// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

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

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

public class this._cls0 extends AsyncTask
{

    final ForumHPActivity this$0;

    private void parseJSONLikeKom(String s)
    {
        int i;
        try
        {
            s = new JSONObject(s);
            postStatusLikeKom = s.getString("success");
            postMessageLikeKom = s.getString("message");
            Log.e("postMessageLikeKom", postMessageLikeKom);
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
        tot_LikeTL = s.getString("total_like");
        totdis_LikeKom = s.getString("total_dislike");
        Log.e("tot_LikePon", tot_LikeTL);
        Log.e("totdis_LikePon", totdis_LikeKom);
        ponselBaseApp.getObserver().setJum_komenLikeTL(jum_komen);
        ponselBaseApp.getObserver().setTot_LikeTL(tot_LikeTL);
        ponselBaseApp.getObserver().setIndexTL(idkom_pos);
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_62;
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
            if (android.os.stBagusKurangTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.t>(avoid)).itDiskWrites().d());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_artanya.php?").append(querylike).toString();
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
        ponselBaseApp.getObserver().setStatus_like_ponsel("-");
        Log.e("postStatusLikeKom", postStatusLikeKom);
        if (!postStatusLikeKom.equals("1"))
        {
            break MISSING_BLOCK_LABEL_286;
        }
        if (!id_type.equals("faqhp")) goto _L2; else goto _L1
_L1:
        if (!statuslike.equals("1")) goto _L4; else goto _L3
_L3:
        notificationLikeHelper.completed("Tanya Ponsel", notificationLikeHelper.likefrontKomen);
_L5:
        Log.e("mArrayListData", String.valueOf(ForumHPActivity.access$0(ForumHPActivity.this).size()));
        Log.e("index_komposlike", idkom_pos);
        updateViewLikeDis(idkom_pos);
        if (android.os.kom_pos >= 11)
        {
            (new k(ForumHPActivity.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        break MISSING_BLOCK_LABEL_266;
_L4:
        try
        {
            notificationLikeHelper.completed("Tanya Ponsel", notificationLikeHelper.dislikefrontKomen);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L5
_L2:
label0:
        {
            if (!statuslike.equals("1"))
            {
                break label0;
            }
            notificationLikeHelper.completed("Artikel Ponsel", notificationLikeHelper.likefrontKomen);
        }
          goto _L5
        notificationLikeHelper.completed("Artikel Ponsel", notificationLikeHelper.dislikefrontKomen);
          goto _L5
        (new k(ForumHPActivity.this)).execute(new Void[0]);
        return;
        if (!id_type.equals("faqhp"))
        {
            break MISSING_BLOCK_LABEL_356;
        }
        if (statuslike.equals("1"))
        {
            notificationLikeHelper.gagal("Tanya Ponsel", postMessageLikeKom);
            return;
        }
        notificationLikeHelper.gagal("Tanya Ponsel", postMessageLikeKom);
        return;
        if (statuslike.equals("1"))
        {
            notificationLikeHelper.gagal("Artikel Ponsel", postMessageLikeKom);
            return;
        }
        notificationLikeHelper.gagal("Artikel Ponsel", postMessageLikeKom);
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (id_type.equals("faqhp"))
        {
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.createNotification("Tanya Ponsel", notificationLikeHelper.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelper.createNotification("Tanya Ponsel", notificationLikeHelper.dislikefrontKomen);
                return;
            }
        }
        if (statuslike.equals("1"))
        {
            notificationLikeHelper.createNotification("Artikel Ponsel", notificationLikeHelper.likefrontKomen);
            return;
        } else
        {
            notificationLikeHelper.createNotification("Artikel Ponsel", notificationLikeHelper.dislikefrontKomen);
            return;
        }
    }

    public k()
    {
        this$0 = ForumHPActivity.this;
        super();
    }
}
