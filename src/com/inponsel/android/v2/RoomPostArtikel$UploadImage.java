// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.NotificationManager;
import android.os.AsyncTask;
import android.text.Editable;
import android.widget.EditText;
import com.inponsel.android.utils.AndroidMultiPartEntity;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostArtikel

private class <init> extends AsyncTask
{

    final RoomPostArtikel this$0;

    private String uploadFile()
    {
        Log.e("Uploadk", "uploadFile");
        Object obj = new DefaultHttpClient();
        Object obj1 = new HttpPost((new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("upload_develop").append(".php").append("?id_from=").append(user_id).toString());
        int i;
        try
        {
            AndroidMultiPartEntity androidmultipartentity = new AndroidMultiPartEntity(new com.inponsel.android.utils.AndroidMultiPartEntity.ProgressListener() {

                final RoomPostArtikel.UploadImage this$1;

                public void transferred(long l)
                {
                    publishProgress(new Integer[] {
                        Integer.valueOf((int)(((float)l / (float)totalSize) * 100F))
                    });
                }

            
            {
                this$1 = RoomPostArtikel.UploadImage.this;
                super();
            }
            });
            androidmultipartentity.addPart("image", new FileBody(new File(filePath)));
            totalSize = androidmultipartentity.getContentLength();
            ((HttpPost) (obj1)).setEntity(androidmultipartentity);
            obj = ((HttpClient) (obj)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)));
            obj1 = ((HttpResponse) (obj)).getEntity();
            i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            String s = clientprotocolexception.toString();
            resp = s;
            return s;
        }
        catch (IOException ioexception)
        {
            String s1 = ioexception.toString();
            resp = s1;
            return s1;
        }
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        obj = EntityUtils.toString(((org.apache.http.HttpEntity) (obj1)));
        resp = ((String) (obj));
        return ((String) (obj));
        obj = (new StringBuilder("Error occurred! Http Status Code: ")).append(i).toString();
        resp = ((String) (obj));
        return ((String) (obj));
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return uploadFile();
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        Log.e("update_byImage", resp);
        if (resp.contains(".jpg"))
        {
            str_img_url = resp;
            try
            {
                RoomPostArtikel.access$2(RoomPostArtikel.this, id_hp, user_id, URLEncoder.encode(edtJudulAskHp.getText().toString(), "utf-8"), URLEncoder.encode(edtPertanyaan.getText().toString(), "utf-8"), URLEncoder.encode(str_img_url.trim(), "utf-8"), t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            return;
        } else
        {
            str_img_url = "";
            notifGagal();
            return;
        }
    }

    protected void onPreExecute()
    {
        RoomPostArtikel.access$0(RoomPostArtikel.this).etProgress(99, 0, false);
        RoomPostArtikel.access$1(RoomPostArtikel.this).notify(notif_id, RoomPostArtikel.access$0(RoomPostArtikel.this).uild());
        progbar_send.setVisibility(0);
    }

    protected transient void onProgressUpdate(Integer ainteger[])
    {
        if (ainteger[0].intValue() == 100)
        {
            RoomPostArtikel.access$0(RoomPostArtikel.this).etProgress(99, 99, false);
            RoomPostArtikel.access$0(RoomPostArtikel.this).etContentTitle(edtJudulAskHp.getText().toString()).etOngoing(true).etContentText((new StringBuilder("Mengirim artikel... - ")).append(String.valueOf(99)).append("%").toString()).etSmallIcon(0x7f0201e4);
        } else
        {
            RoomPostArtikel.access$0(RoomPostArtikel.this).etProgress(99, ainteger[0].intValue(), false);
            RoomPostArtikel.access$0(RoomPostArtikel.this).etContentTitle(edtJudulAskHp.getText().toString()).etOngoing(true).etContentText((new StringBuilder("Mengirim artikel... - ")).append(String.valueOf(ainteger[0])).append("%").toString()).etSmallIcon(0x7f0201e4);
        }
        RoomPostArtikel.access$1(RoomPostArtikel.this).notify(notif_id, RoomPostArtikel.access$0(RoomPostArtikel.this).uild());
    }

    protected volatile transient void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Integer[])aobj);
    }



    private _cls1.this._cls1()
    {
        this$0 = RoomPostArtikel.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
