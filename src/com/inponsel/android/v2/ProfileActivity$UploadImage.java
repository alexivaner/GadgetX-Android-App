// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.Button;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Base64;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity

public class this._cls0 extends AsyncTask
{

    final ProfileActivity this$0;

    protected transient Long doInBackground(URL aurl[])
    {
        aurl = new ByteArrayOutputStream();
        photo_upload.compress(android.graphics._upload, 100, aurl);
        String s = Base64.encodeBytes(aurl.toByteArray());
        aurl = new ArrayList();
        aurl.add(new BasicNameValuePair("image", s));
        try
        {
            DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost((new StringBuilder(String.valueOf(Util.BASE_PATH_UPLIMG))).append("photo_upload").append(Utility.BASE_FORMAT).append("?id=").append(user_id).toString());
            httppost.setEntity(new UrlEncodedFormEntity(aurl));
            aurl = defaulthttpclient.execute(httppost).getEntity();
            is = aurl.getContent();
            resp = ProfileActivity.access$6(is);
            Log.e("url", resp);
        }
        // Misplaced declaration of an exception variable
        catch (URL aurl[])
        {
            Log.e("log_tag", (new StringBuilder("Error in http connection ")).append(aurl.toString()).toString());
        }
        return null;
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((URL[])aobj);
    }

    protected void onPostExecute(Long long1)
    {
        super.onPostExecute(long1);
        try
        {
            Log.e("update_byImage", resp);
            if (resp.contains(".jpg"))
            {
                btnprof_savepic.setVisibility(8);
                db.update_byImage(user_id, resp);
                ponselBaseApp.getObserver().setLoginStat("1");
            }
            mDialog.dismiss();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Long long1)
        {
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Long)obj);
    }

    protected void onPreExecute()
    {
        mDialog = ProgressDialog.show(wrapper, "", "Saving image...", true);
        mDialog.setCancelable(true);
        mDialog.show();
    }

    public _cls9()
    {
        this$0 = ProfileActivity.this;
        super();
    }
}
