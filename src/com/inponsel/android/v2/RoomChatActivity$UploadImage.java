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
//            RoomChatActivity

public class urlImage extends AsyncTask
{

    final RoomChatActivity this$0;
    String urlImage;

    protected transient Long doInBackground(URL aurl[])
    {
        aurl = new ByteArrayOutputStream();
        photo_upload.compress(android.graphics._upload, 100, aurl);
        String s = Base64.encodeBytes(aurl.toByteArray());
        aurl = new ArrayList();
        aurl.add(new BasicNameValuePair("image", s));
        Log.e("imgto2", (new StringBuilder("from ")).append(RoomChatActivity.user_id).append(" to ").append(codename).toString());
        urlImage = (new StringBuilder(String.valueOf(Util.BASE_PATH_UPLIMGMSG))).append("photo_upload_group").append(Utility.BASE_FORMAT).append("?id_from=").append(RoomChatActivity.user_id).append("&id_to=").append(codename).append("&id_hp=").append(id_hp).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
        Log.e("urlImage", urlImage);
        try
        {
            DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(urlImage);
            Log.e("urlImage", urlImage);
            httppost.setEntity(new UrlEncodedFormEntity(aurl));
            aurl = defaulthttpclient.execute(httppost).getEntity();
            inpstream = aurl.getContent();
            resp = RoomChatActivity.access$3(inpstream);
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
            RoomChatActivity.access$4(RoomChatActivity.this);
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
        RoomChatActivity.access$2(RoomChatActivity.this);
    }

    public ()
    {
        this$0 = RoomChatActivity.this;
        super();
        urlImage = "";
    }
}
