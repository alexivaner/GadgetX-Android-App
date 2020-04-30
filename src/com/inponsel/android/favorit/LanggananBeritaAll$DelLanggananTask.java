// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.favorit:
//            LanggananBeritaAll

public class this._cls0 extends AsyncTask
{

    final LanggananBeritaAll this$0;

    private void parseJSONLangganan(String s)
    {
        try
        {
            s = new JSONObject(s);
            postStatusLikeKom = s.getString("success");
            postMessageLikeKom = s.getString("message");
            jArray = s.getJSONArray("InPonsel");
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
            querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&stat=").append("0").append("&type=").append(type).append("&t=").append(t).toString();
            pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
            Log.e("pushURL", pushURLdel);
            avoid = HttpPush.getResponse(pushURLdel);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(querydel).toString());
            resdel = avoid.toString();
            Log.e("url ", resdel);
            parseJSONLangganan(resdel);
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
        if (!postStatusLikeKom.equals("1") && !postStatusLikeKom.equals("10"))
        {
            break MISSING_BLOCK_LABEL_96;
        }
        Toast.makeText(LanggananBeritaAll.this, postMessageLikeKom, 0).show();
        if (!type.equals("hp"))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        LanggananTask();
_L1:
        mDialog.dismiss();
        return;
        try
        {
            LanggananMerekTask();
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
          goto _L1
        if (postStatusLikeKom.equals("00") || postStatusLikeKom.equals("0"))
        {
            Toast.makeText(LanggananBeritaAll.this, postMessageLikeKom, 0).show();
            mDialog.dismiss();
            return;
        }
        if (postStatusLikeKom.equals("40404"))
        {
            mDialog.dismiss();
            return;
        }
        Toast.makeText(LanggananBeritaAll.this, postMessageLikeKom, 0).show();
        return;
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        statusdel = "";
        if (statdel.equals("1"))
        {
            mDialog = ProgressDialog.show(LanggananBeritaAll.this, "", "Menambahkan...", true);
        } else
        {
            mDialog = ProgressDialog.show(LanggananBeritaAll.this, "", "Menghapus...", true);
        }
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public ()
    {
        this$0 = LanggananBeritaAll.this;
        super();
    }
}
