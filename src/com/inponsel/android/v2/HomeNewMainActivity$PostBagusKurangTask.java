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
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

public class this._cls0 extends AsyncTask
{

    final HomeNewMainActivity this$0;

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
                StrictMode.setThreadPolicy((new android.os.usKurangTask()).l().l());
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
            break MISSING_BLOCK_LABEL_120;
        }
        img_likerandom_ponsel.setEnabled(false);
        img_dislikerandom_ponsel.setEnabled(false);
        if (!statusLikeHp.equals("1"))
        {
            break MISSING_BLOCK_LABEL_104;
        }
        img_likerandom_ponsel.setBackgroundResource(0x7f02020b);
_L2:
        (new Handler()).postDelayed(new Runnable() {

            final HomeNewMainActivity.PostBagusKurangTask this$1;

            public void run()
            {
                HomeNewMainActivity.access$1(this$0);
            }

            
            {
                this$1 = HomeNewMainActivity.PostBagusKurangTask.this;
                super();
            }
        }, 2000L);
        return;
        img_dislikerandom_ponsel.setBackgroundResource(0x7f0201f2);
        if (true) goto _L2; else goto _L1
_L1:
        void1;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }


    public _cls1.this._cls1()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
