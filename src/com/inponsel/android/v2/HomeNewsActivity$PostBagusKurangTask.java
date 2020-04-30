// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.StrictMode;
import android.widget.ImageView;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

public class this._cls0 extends AsyncTask
{

    final HomeNewsActivity this$0;

    private void parseJSONLikePon(String s)
    {
        try
        {
            JSONObject jsonobject = new JSONObject(s);
            postStatusLikePon = jsonobject.getString("success");
            postMessageLikePon = jsonobject.getString("message");
            Log.e("postStatusLikePon", s);
            jArray = jsonobject.getJSONArray("InPonsel");
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
            if (android.os.usKurangTask > 9)
            {
                StrictMode.setThreadPolicy((new android.os.>()).tAll().());
            }
            avoid = (new StringBuilder("idhp=")).append(random_id_hp).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode(random_merek_hp, "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_ponsel").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
            Log.e("pushURL", avoid);
            parseJSONLikePon(HttpPush.getResponse(avoid).toString());
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
            break MISSING_BLOCK_LABEL_146;
        }
        notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.SucdislikeStatement);
        img_likerandom_ponsel.setEnabled(false);
        img_dislikerandom_ponsel.setEnabled(false);
        if (!statusLikeHp.equals("1"))
        {
            break MISSING_BLOCK_LABEL_131;
        }
        img_likerandom_ponsel.setBackgroundResource(0x7f02025b);
_L1:
        (new Handler()).postDelayed(new Runnable() {

            final HomeNewsActivity.PostBagusKurangTask this$1;

            public void run()
            {
                HomeNewsActivity.access$4(this$0);
            }

            
            {
                this$1 = HomeNewsActivity.PostBagusKurangTask.this;
                super();
            }
        }, 2000L);
        return;
        try
        {
            img_likerandom_ponsel.setBackgroundResource(0x7f0201a7);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
        notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
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


    public _cls1.this._cls1()
    {
        this$0 = HomeNewsActivity.this;
        super();
    }
}
