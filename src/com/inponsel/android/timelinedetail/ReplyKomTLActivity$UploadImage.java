// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.app.NotificationManager;
import android.os.AsyncTask;
import android.text.Editable;
import android.widget.Button;
import android.widget.ImageView;
import com.inponsel.android.utils.AndroidMultiPartEntity;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.widget.DroidWriterEditText;
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

// Referenced classes of package com.inponsel.android.timelinedetail:
//            ReplyKomTLActivity

private class <init> extends AsyncTask
{

    final ReplyKomTLActivity this$0;

    private String uploadFile()
    {
        Log.e("Uploadk", "uploadFile");
        Object obj = new DefaultHttpClient();
        Object obj1 = new HttpPost((new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("upload_develop").append(".php").append("?id_from=").append(user_id).toString());
        int i;
        try
        {
            AndroidMultiPartEntity androidmultipartentity = new AndroidMultiPartEntity(new com.inponsel.android.utils.AndroidMultiPartEntity.ProgressListener() {

                final ReplyKomTLActivity.UploadImage this$1;

                public void transferred(long l)
                {
                    publishProgress(new Integer[] {
                        Integer.valueOf((int)(((float)l / (float)totalSize) * 100F))
                    });
                }

            
            {
                this$1 = ReplyKomTLActivity.UploadImage.this;
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
            break MISSING_BLOCK_LABEL_177;
        }
        obj = EntityUtils.toString(((org.apache.http.HttpEntity) (obj1))).trim();
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
        if (resp.contains(".jpeg") || resp.contains(".jpg"))
        {
            try
            {
                s = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                querypopkomen = (new StringBuilder("rplto=")).append(id_komrss_to).append("&komen=").append(s).append("&tl_id=").append(id_rss_to).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&type=").append(tl_type).append("&img=").append(resp).toString();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            (new nit>(ReplyKomTLActivity.this)).ecute(new Void[0]);
            return;
        } else
        {
            notifGagal();
            return;
        }
    }

    protected void onPreExecute()
    {
        edt_pop_komen.setEnabled(false);
        imgAskHp.setEnabled(false);
        btn_send_komen.setEnabled(false);
        ReplyKomTLActivity.access$0(ReplyKomTLActivity.this).rogress(99, 0, false);
        ReplyKomTLActivity.access$1(ReplyKomTLActivity.this).notify(notif_id, ReplyKomTLActivity.access$0(ReplyKomTLActivity.this).d());
    }

    protected transient void onProgressUpdate(Integer ainteger[])
    {
        if (ainteger[0].intValue() == 100)
        {
            ReplyKomTLActivity.access$0(ReplyKomTLActivity.this).rogress(99, 99, false);
            ReplyKomTLActivity.access$0(ReplyKomTLActivity.this).ontentTitle("InPonsel").ngoing(true).ontentText((new StringBuilder("Mengirim komentar... - ")).append(String.valueOf(99)).append("%").toString()).mallIcon(0x7f0201e4);
        } else
        {
            ReplyKomTLActivity.access$0(ReplyKomTLActivity.this).rogress(99, ainteger[0].intValue(), false);
            ReplyKomTLActivity.access$0(ReplyKomTLActivity.this).ontentTitle("InPonsel").ngoing(true).ontentText((new StringBuilder("Mengunggah gambar... - ")).append(String.valueOf(ainteger[0])).append("%").toString()).mallIcon(0x7f0201e4);
        }
        ReplyKomTLActivity.access$1(ReplyKomTLActivity.this).notify(notif_id, ReplyKomTLActivity.access$0(ReplyKomTLActivity.this).d());
    }

    protected volatile transient void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Integer[])aobj);
    }



    private _cls1.this._cls1()
    {
        this$0 = ReplyKomTLActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
