// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.os.AsyncTask;
import android.os.StrictMode;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            Hal3KomentarPull

public class this._cls0 extends AsyncTask
{

    final Hal3KomentarPull this$0;

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
        tot_LikeKom = s.getString("komen_bagus");
        totdis_LikeKom = s.getString("komen_kurang");
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
            if (android.os.stBagusKurangTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.>(avoid)).tDiskWrites().());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_komentar.php?").append(querylike).toString();
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
        notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.suclikefrontKomen);
_L1:
        Log.e("mArrayListData", String.valueOf(Hal3KomentarPull.access$1(Hal3KomentarPull.this).size()));
        Log.e("index_komposlike", idkom_pos);
        updateViewLikeDis(idkom_pos);
        if (android.os.kom_pos >= 11)
        {
            (new <init>(Hal3KomentarPull.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        break MISSING_BLOCK_LABEL_179;
        try
        {
            notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.sucdislikefrontKomen);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
        (new <init>(Hal3KomentarPull.this)).execute(new Void[0]);
        return;
        if (statuslike.equals("1"))
        {
            notificationLikeHelper.gagal(namalengkapbgskrg, postMessageLikeKom);
            return;
        }
        notificationLikeHelper.gagal(namalengkapbgskrg, postMessageLikeKom);
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (statuslike.equals("1"))
        {
            notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.likefrontKomen);
            return;
        } else
        {
            notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.dislikefrontKomen);
            return;
        }
    }

    public ()
    {
        this$0 = Hal3KomentarPull.this;
        super();
    }
}
