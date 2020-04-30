// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.inponsel.android.utils.Base64;
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
//            MessageActivity

public class urlImage extends AsyncTask
{

    final MessageActivity this$0;
    String urlImage;

    protected transient Long doInBackground(URL aurl[])
    {
        aurl = new ByteArrayOutputStream();
        photo_upload.compress(android.graphics._upload, 100, aurl);
        String s = Base64.encodeBytes(aurl.toByteArray());
        aurl = new ArrayList();
        aurl.add(new BasicNameValuePair("image", s));
        if (id_send_to.equals(user_id))
        {
            id_send_to = id_to;
            Log.e("imgto1", (new StringBuilder("from ")).append(id_send_to).append(" to ").append(id_from).toString());
            urlImage = (new StringBuilder(String.valueOf(Util.BASE_PATH_UPLIMGMSG))).append("photo_upload").append(Utility.BASE_FORMAT).append("?id_from=").append(id_from).append("&id_to=").append(id_to).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
        } else
        {
            Log.e("imgto2", (new StringBuilder("from ")).append(user_id).append(" to ").append(id_to).toString());
            urlImage = (new StringBuilder(String.valueOf(Util.BASE_PATH_UPLIMGMSG))).append("photo_upload").append(Utility.BASE_FORMAT).append("?id_from=").append(user_id).append("&id_to=").append(id_send_to).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
        }
        Log.e("urlImage", urlImage);
        try
        {
            DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(urlImage);
            Log.e("urlImage", urlImage);
            httppost.setEntity(new UrlEncodedFormEntity(aurl));
            aurl = defaulthttpclient.execute(httppost).getEntity();
            inpstream = aurl.getContent();
            resp = MessageActivity.access$1(inpstream);
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
            MessageActivity.access$2(MessageActivity.this);
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
        MessageActivity.access$0(MessageActivity.this);
    }

    public _cls9()
    {
        this$0 = MessageActivity.this;
        super();
        urlImage = "";
    }
}
