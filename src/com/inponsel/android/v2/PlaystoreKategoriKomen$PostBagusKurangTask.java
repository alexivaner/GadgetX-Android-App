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
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            PlaystoreKategoriKomen

public class this._cls0 extends AsyncTask
{

    final PlaystoreKategoriKomen this$0;

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
            if (android.os.usKurangTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.usKurangTask(avoid)).rites().rites());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("katapps_komen_likedis.php?").append(querylike).toString();
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
        ponselBaseApp.getObserver().setUpdateType("appskategorikom");
        ponselBaseApp.getObserver().setStatus_like_ponsel("-");
        Log.e("postStatusLikeKom", postStatusLikeKom);
        if (!postStatusLikeKom.equals("1"))
        {
            break MISSING_BLOCK_LABEL_179;
        }
        if (!statuslike.equals("1"))
        {
            break MISSING_BLOCK_LABEL_149;
        }
        notificationLikeHelper.completed(title, notificationLikeHelper.suclikefrontKomen);
_L1:
        Log.e("mArrayListData", String.valueOf(PlaystoreKategoriKomen.access$1(PlaystoreKategoriKomen.this).size()));
        Log.e("index_komposlike", idkom_pos);
        updateViewLikeDis(idkom_pos);
        return;
        try
        {
            notificationLikeHelper.completed(title, notificationLikeHelper.sucdislikefrontKomen);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
        if (statuslike.equals("1"))
        {
            notificationLikeHelper.gagal(title, postMessageLikeKom);
            return;
        }
        notificationLikeHelper.gagal(title, postMessageLikeKom);
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (statuslike.equals("1"))
        {
            notificationLikeHelper.createNotification(title, notificationLikeHelper.likefrontKomen);
            return;
        } else
        {
            notificationLikeHelper.createNotification(title, notificationLikeHelper.dislikefrontKomen);
            return;
        }
    }

    public ()
    {
        this$0 = PlaystoreKategoriKomen.this;
        super();
    }
}
