// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

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

// Referenced classes of package com.inponsel.android.scdetail:
//            Hal2Komen

public class this._cls0 extends AsyncTask
{

    final Hal2Komen this$0;

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
        ponselBaseApp.getObserver().setUpdateType("komentarsc");
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
        if (android.os.ostBagusKurangTask >= 11)
        {
            avoid = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy((new android.os.r(avoid)).permitDiskWrites().build());
            StrictMode.setThreadPolicy(avoid);
        }
        if (!komen_type.equals("katapps")) goto _L2; else goto _L1
_L1:
        avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("sc_komen_katapps").append(Utility.BASE_FORMAT).append("?").append(querylike).toString();
_L4:
        Log.e("pushURL", avoid);
        avoid = HttpPush.getResponse(avoid);
        reslike = avoid.toString();
        parseJSONLikeKom(reslike);
        break MISSING_BLOCK_LABEL_178;
_L2:
        avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("sc_komen_likedis").append(Utility.BASE_FORMAT).append("?").append(querylike).toString();
        if (true) goto _L4; else goto _L3
_L3:
        avoid;
        avoid.printStackTrace();
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
            break MISSING_BLOCK_LABEL_214;
        }
        if (!statuslike.equals("1"))
        {
            break MISSING_BLOCK_LABEL_164;
        }
        notificationLikeHelper.completed(sc_judul, notificationLikeHelper.suclikefrontKomen);
_L1:
        Log.e("mArrayListData", String.valueOf(Hal2Komen.access$1(Hal2Komen.this).size()));
        Log.e("index_komposlike", idkom_pos);
        updateViewLikeDis(idkom_pos);
        if (android.os.dkom_pos >= 11)
        {
            (new <init>(Hal2Komen.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        break MISSING_BLOCK_LABEL_194;
        try
        {
            notificationLikeHelper.completed(sc_judul, notificationLikeHelper.sucdislikefrontKomen);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
        (new <init>(Hal2Komen.this)).execute(new Void[0]);
        return;
        if (statuslike.equals("1"))
        {
            notificationLikeHelper.gagal(sc_judul, postMessageLikeKom);
            return;
        }
        notificationLikeHelper.gagal(sc_judul, postMessageLikeKom);
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (statuslike.equals("1"))
        {
            notificationLikeHelper.createNotification(sc_judul, notificationLikeHelper.likefrontKomen);
            return;
        } else
        {
            notificationLikeHelper.createNotification(sc_judul, notificationLikeHelper.dislikefrontKomen);
            return;
        }
    }

    public A()
    {
        this$0 = Hal2Komen.this;
        super();
    }
}
