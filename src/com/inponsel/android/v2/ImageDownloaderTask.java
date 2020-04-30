// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.inponsel.android.utils.Log;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

class ImageDownloaderTask extends AsyncTask
{

    private final WeakReference imageViewReference;

    public ImageDownloaderTask(ImageView imageview)
    {
        imageViewReference = new WeakReference(imageview);
    }

    static Bitmap downloadBitmap(String s)
    {
        AndroidHttpClient androidhttpclient;
        HttpGet httpget;
        androidhttpclient = AndroidHttpClient.newInstance("Android");
        httpget = new HttpGet(s);
        Object obj;
        int i;
        obj = androidhttpclient.execute(httpget);
        i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        if (i == 200) goto _L2; else goto _L1
_L1:
        Log.w("ImageDownloader", (new StringBuilder("Error ")).append(i).append(" while retrieving bitmap from ").append(s).toString());
        if (androidhttpclient != null)
        {
            androidhttpclient.close();
        }
        s = null;
_L6:
        return s;
_L2:
        HttpEntity httpentity = ((HttpResponse) (obj)).getEntity();
        if (httpentity == null) goto _L4; else goto _L3
_L3:
        obj = null;
        InputStream inputstream = httpentity.getContent();
        obj = inputstream;
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream);
        obj = bitmap;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        inputstream.close();
        httpentity.consumeContent();
        s = ((String) (obj));
        if (androidhttpclient == null) goto _L6; else goto _L5
_L5:
        androidhttpclient.close();
        return ((Bitmap) (obj));
        Exception exception1;
        exception1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        ((InputStream) (obj)).close();
        httpentity.consumeContent();
        throw exception1;
        Exception exception;
        exception;
        httpget.abort();
        Log.w("ImageDownloader", (new StringBuilder("Error while retrieving bitmap from ")).append(s).toString());
        if (androidhttpclient != null)
        {
            androidhttpclient.close();
        }
_L8:
        return null;
        s;
        if (androidhttpclient != null)
        {
            androidhttpclient.close();
        }
        throw s;
_L4:
        if (androidhttpclient != null)
        {
            androidhttpclient.close();
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected transient Bitmap doInBackground(String as[])
    {
        return downloadBitmap(as[0]);
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected void onPostExecute(Bitmap bitmap)
    {
        ImageView imageview;
label0:
        {
            if (isCancelled())
            {
                bitmap = null;
            }
            if (imageViewReference != null)
            {
                imageview = (ImageView)imageViewReference.get();
                imageview.setImageResource(0x7f020297);
                if (imageview != null)
                {
                    if (bitmap == null)
                    {
                        break label0;
                    }
                    imageview.setImageBitmap(bitmap);
                }
            }
            return;
        }
        imageview.setImageDrawable(imageview.getContext().getResources().getDrawable(0x7f020297));
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Bitmap)obj);
    }
}
