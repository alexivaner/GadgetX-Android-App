// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import com.inponsel.android.utils.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package com.inponsel.android.v2:
//            ImageFullActivity

class this._cls0 extends AsyncTask
{

    final ImageFullActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        int i;
        as = new URL(as[0]);
        URLConnection urlconnection = as.openConnection();
        urlconnection.connect();
        i = urlconnection.getContentLength();
        if (!Environment.getExternalStorageState().equals("mounted")) goto _L2; else goto _L1
_L1:
        ImageFullActivity.access$3(ImageFullActivity.this, new File(Environment.getExternalStorageDirectory(), "InPonsel Message"));
_L6:
        FileOutputStream fileoutputstream;
        byte abyte0[];
        if (!ImageFullActivity.access$4(ImageFullActivity.this).exists())
        {
            ImageFullActivity.access$4(ImageFullActivity.this).mkdirs();
        }
        as = new BufferedInputStream(as.openStream(), 8192);
        fileoutputstream = new FileOutputStream((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/InPonsel Message/").append(fileName).toString());
        abyte0 = new byte[1024];
        long l = 0L;
_L4:
        int j;
        j = as.read(abyte0);
        break MISSING_BLOCK_LABEL_150;
_L2:
        ImageFullActivity.access$3(ImageFullActivity.this, getCacheDir());
        continue; /* Loop/switch isn't completed */
        if (j == -1)
        {
            try
            {
                fileoutputstream.flush();
                fileoutputstream.close();
                as.close();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                Log.e("Error: ", as.getMessage());
            }
            break; /* Loop/switch isn't completed */
        }
        l += j;
        publishProgress(new String[] {
            (new StringBuilder()).append((int)((100L * l) / (long)i)).toString()
        });
        fileoutputstream.write(abyte0, 0, j);
        if (true) goto _L4; else goto _L3
_L3:
        return null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        s = new Intent();
        s.setAction("android.intent.action.VIEW");
        s.setDataAndType(Uri.parse((new StringBuilder("file://")).append(Environment.getExternalStorageDirectory().toString()).append("/InPonsel Message/").append(fileName).toString()), "image/*");
        s = PendingIntent.getActivity(ImageFullActivity.this, 0, s, 0x10000000);
        ImageFullActivity.access$1(ImageFullActivity.this).itle("InPonsel").ext("Download complete").(0, 0, false).n(0x7f02023f).ntent(s).el(true).n(ImageFullActivity.getBitmapFromURL(imageUrls[pagerPosition], getApplicationContext()));
        ImageFullActivity.access$2(ImageFullActivity.this).notify(id, ImageFullActivity.access$1(ImageFullActivity.this)._mth0());
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        ImageFullActivity.access$1(ImageFullActivity.this).(100, 0, false);
        ImageFullActivity.access$2(ImageFullActivity.this).notify(id, ImageFullActivity.access$1(ImageFullActivity.this)._mth0());
    }

    protected volatile transient void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((String[])aobj);
    }

    protected transient void onProgressUpdate(String as[])
    {
        ImageFullActivity.access$1(ImageFullActivity.this).(100, Integer.parseInt(as[0]), false);
        ImageFullActivity.access$2(ImageFullActivity.this).notify(id, ImageFullActivity.access$1(ImageFullActivity.this)._mth0());
        super.onProgressUpdate(as);
    }

    ()
    {
        this$0 = ImageFullActivity.this;
        super();
    }
}
