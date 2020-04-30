// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.inponsel.android.utils.AndroidMultiPartEntity;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.File;
import java.io.FileOutputStream;
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
//            RoomPostHasilFotoNoCrop, RoomMyDraftPost

private class <init> extends AsyncTask
{

    final RoomPostHasilFotoNoCrop this$0;

    private String uploadFile()
    {
        Log.e("Uploadk", "uploadFile");
        Object obj = new DefaultHttpClient();
        Object obj1 = new HttpPost((new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("upload_develop").append(".php").append("?id_from=").append(user_id).toString());
        int i;
        try
        {
            AndroidMultiPartEntity androidmultipartentity = new AndroidMultiPartEntity(new com.inponsel.android.utils.AndroidMultiPartEntity.ProgressListener() {

                final RoomPostHasilFotoNoCrop.UploadImage this$1;

                public void transferred(long l)
                {
                    publishProgress(new Integer[] {
                        Integer.valueOf((int)(((float)l / (float)totalSize) * 100F))
                    });
                }

            
            {
                this$1 = RoomPostHasilFotoNoCrop.UploadImage.this;
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
        try
        {
            avoid = (new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append("/InPonsel").toString();
            Object obj = new File(avoid);
            if (!((File) (obj)).exists())
            {
                ((File) (obj)).mkdirs();
            }
            obj = new FileOutputStream(new File(((File) (obj)), (new StringBuilder(String.valueOf(String.valueOf(notif_id)))).toString()));
            photo_upload.compress(android.graphics._upload, 100, ((java.io.OutputStream) (obj)));
            ((FileOutputStream) (obj)).flush();
            ((FileOutputStream) (obj)).close();
            Log.e("filepath", (new StringBuilder(String.valueOf(avoid))).append("/").append(String.valueOf(notif_id)).toString());
            filePath = (new StringBuilder(String.valueOf(avoid))).append("/").append(String.valueOf(notif_id)).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
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
        (new File(filePath)).delete();
        if (resp.contains(".jpg"))
        {
            str_img_url = resp;
            try
            {
                RoomPostHasilFotoNoCrop.access$2(RoomPostHasilFotoNoCrop.this, id_hp, user_id, URLEncoder.encode((new StringBuilder("Hasil kamera: ")).append(namalengkap).toString(), "utf-8"), URLEncoder.encode(edtPertanyaan.getText().toString(), "utf-8"), URLEncoder.encode(str_img_url.trim(), "utf-8"), t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            return;
        }
        str_img_url = "";
        btnPostAskHp.setEnabled(true);
        if (!db.checkARTJudulIfExist(curtime, (new StringBuilder("Hasil kamera: ")).append(namalengkap).toString())) goto _L2; else goto _L1
_L1:
        DatabaseHandler databasehandler;
        String s1;
        String s2;
        String s3;
        Toast.makeText(getApplicationContext(), "Berhasil memperbaharui", 1).show();
        databasehandler = db;
        s1 = curtime;
        s2 = (new StringBuilder("Hasil kamera: ")).append(namalengkap).toString();
        s3 = cahaya_kond;
        if (photo_upload != null) goto _L4; else goto _L3
_L3:
        s = "";
_L5:
        String s4;
        try
        {
            databasehandler.update_byARTID(s1, s2, s3, s, edtPertanyaan.getText().toString(), led_flash);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
_L6:
        s = new Intent();
        s.setClass(getApplicationContext(), com/inponsel/android/v2/RoomMyDraftPost);
        s = PendingIntent.getActivity(RoomPostHasilFotoNoCrop.this, 0, s, 0x10000000);
        RoomPostHasilFotoNoCrop.access$0(RoomPostHasilFotoNoCrop.this).tTitle((new StringBuilder("Hasil kamera: ")).append(namalengkap).toString()).tText("Gagal memposting hasil kamera").ss(0, 0, false).g(false).con(0x7f0201e4).tIntent(s).ncel(true);
        RoomPostHasilFotoNoCrop.access$1(RoomPostHasilFotoNoCrop.this).notify(notif_id, RoomPostHasilFotoNoCrop.access$0(RoomPostHasilFotoNoCrop.this)._mth0());
        return;
_L4:
        s = path_image;
          goto _L5
_L2:
        databasehandler = db;
        s1 = id_hp;
        s2 = codename;
        s3 = (new StringBuilder("Hasil kamera: ")).append(namalengkap).toString();
        s4 = cahaya_kond;
        if (photo_upload != null)
        {
            break MISSING_BLOCK_LABEL_604;
        }
        s = "";
_L7:
        databasehandler.addArtUser(s1, s2, "hasilkamera", s3, s4, s, edtPertanyaan.getText().toString(), led_flash, curtime);
          goto _L6
        s = path_image;
          goto _L7
    }

    protected void onPreExecute()
    {
        RoomPostHasilFotoNoCrop.access$0(RoomPostHasilFotoNoCrop.this).ss(99, 0, false);
        RoomPostHasilFotoNoCrop.access$1(RoomPostHasilFotoNoCrop.this).notify(notif_id, RoomPostHasilFotoNoCrop.access$0(RoomPostHasilFotoNoCrop.this)._mth0());
        progbar_send.setVisibility(0);
    }

    protected transient void onProgressUpdate(Integer ainteger[])
    {
        if (ainteger[0].intValue() == 100)
        {
            RoomPostHasilFotoNoCrop.access$0(RoomPostHasilFotoNoCrop.this).ss(99, 99, false);
            RoomPostHasilFotoNoCrop.access$0(RoomPostHasilFotoNoCrop.this).tTitle((new StringBuilder("Hasil kamera: ")).append(namalengkap).toString()).g(true).tText((new StringBuilder("Mengirim ")).append(String.valueOf(99)).append("%").toString()).con(0x7f0201e4);
        } else
        {
            RoomPostHasilFotoNoCrop.access$0(RoomPostHasilFotoNoCrop.this).ss(99, ainteger[0].intValue(), false);
            RoomPostHasilFotoNoCrop.access$0(RoomPostHasilFotoNoCrop.this).tTitle((new StringBuilder("Hasil kamera: ")).append(namalengkap).toString()).g(true).tText((new StringBuilder("Mengirim ")).append(String.valueOf(ainteger[0])).append("%").toString()).con(0x7f0201e4);
        }
        RoomPostHasilFotoNoCrop.access$1(RoomPostHasilFotoNoCrop.this).notify(notif_id, RoomPostHasilFotoNoCrop.access$0(RoomPostHasilFotoNoCrop.this)._mth0());
    }

    protected volatile transient void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Integer[])aobj);
    }



    private _cls1.this._cls1()
    {
        this$0 = RoomPostHasilFotoNoCrop.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
