// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.DocumentsContract;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.AndroidMultiPartEntity;
import com.inponsel.android.utils.Base64;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.NotificationTanyaArtHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            AlbumStorageDirFactory, RoomMyDraftPost, BaseAlbumDirFactory, FroyoAlbumDirFactory

public class RoomPostHasilFotoNoCrop extends SherlockFragmentActivity
    implements Observer
{
    public class SendMailTask extends AsyncTask
    {

        final RoomPostHasilFotoNoCrop this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = urlEmailNotif;
                Log.e("pushURLemail", avoid);
                Log.e("status", HttpPush.getResponse(avoid).toString());
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
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        public SendMailTask()
        {
            this$0 = RoomPostHasilFotoNoCrop.this;
            super();
        }
    }

    private class UploadImage extends AsyncTask
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

                    final UploadImage this$1;

                    public void transferred(long l)
                    {
                        publishProgress(new Integer[] {
                            Integer.valueOf((int)(((float)l / (float)totalSize) * 100F))
                        });
                    }

            
            {
                this$1 = UploadImage.this;
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
                photo_upload.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, ((OutputStream) (obj)));
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
                    SendPertanyaan(id_hp, user_id, URLEncoder.encode((new StringBuilder("Hasil kamera: ")).append(namalengkap).toString(), "utf-8"), URLEncoder.encode(edtPertanyaan.getText().toString(), "utf-8"), URLEncoder.encode(str_img_url.trim(), "utf-8"), t);
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
            mBuilder.setContentTitle((new StringBuilder("Hasil kamera: ")).append(namalengkap).toString()).setContentText("Gagal memposting hasil kamera").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(s).setAutoCancel(true);
            mNotifyManager.notify(notif_id, mBuilder.build());
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
            mBuilder.setProgress(99, 0, false);
            mNotifyManager.notify(notif_id, mBuilder.build());
            progbar_send.setVisibility(0);
        }

        protected transient void onProgressUpdate(Integer ainteger[])
        {
            if (ainteger[0].intValue() == 100)
            {
                mBuilder.setProgress(99, 99, false);
                mBuilder.setContentTitle((new StringBuilder("Hasil kamera: ")).append(namalengkap).toString()).setOngoing(true).setContentText((new StringBuilder("Mengirim ")).append(String.valueOf(99)).append("%").toString()).setSmallIcon(0x7f0201e4);
            } else
            {
                mBuilder.setProgress(99, ainteger[0].intValue(), false);
                mBuilder.setContentTitle((new StringBuilder("Hasil kamera: ")).append(namalengkap).toString()).setOngoing(true).setContentText((new StringBuilder("Mengirim ")).append(String.valueOf(ainteger[0])).append("%").toString()).setSmallIcon(0x7f0201e4);
            }
            mNotifyManager.notify(notif_id, mBuilder.build());
        }

        protected volatile transient void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((Integer[])aobj);
        }



        private UploadImage()
        {
            this$0 = RoomPostHasilFotoNoCrop.this;
            super();
        }

        UploadImage(UploadImage uploadimage)
        {
            this();
        }
    }


    private static final String JPEG_FILE_PREFIX = "IMG_";
    private static final String JPEG_FILE_SUFFIX = ".jpg";
    private static final int PICK_FROM_CAMERA = 1;
    private static final int PICK_FROM_FILE = 2;
    public static final int REQUEST_CODE_GALLERY = 1;
    public static final int REQUEST_CODE_TAKE_PICTURE = 2;
    public static final String TEMP_PHOTO_FILE_NAME = (new StringBuilder("inponsel_")).append(System.currentTimeMillis()).append(".jpg").toString();
    ActionBar actionBar;
    int actionBarTitleId;
    File albumF;
    Button btnPostAskHp;
    Button btnSaveAskHp;
    Button btnhasilfoto;
    String cahaya_kond;
    String camera_path;
    ConnectivityManager cm;
    String codename;
    Cursor cursor;
    String curtime;
    DatabaseHandler db;
    EditText edtPertanyaan;
    String email_user;
    Bundle extras;
    String filePath;
    String gambar;
    int height;
    String id_hp;
    File imageF;
    ImageLoader imageLoader2;
    ImageView imgAskHp;
    String insert_id;
    InputStream is;
    String json_response;
    String led_flash;
    private AlbumStorageDirFactory mAlbumStorageDirFactory;
    private android.support.v4.app.NotificationCompat.Builder mBuilder;
    private String mCurrentPhotoPath;
    private NotificationManager mNotifyManager;
    String merk;
    String message_stat;
    String model;
    String nama_asli;
    String namalengkap;
    NetworkInfo netInfo;
    int notif_id;
    NotificationTanyaArtHelper notificationTanyaArtHelper;
    Calendar now;
    DisplayImageOptions options;
    String path_image;
    Bitmap photo_upload;
    String pilih_cahaya[] = {
        "Cahaya Kuat", "Cahaya Cukup", "Cahaya Kurang", "Gelap"
    };
    PonselBaseApp ponselBaseApp;
    SmoothProgressBar progbar_send;
    RadioButton rbLEDTidak;
    RadioButton rbLEDYa;
    int resizeHeight;
    int resizeWidth;
    float resolution;
    String resp;
    RadioGroup rgPilLEDFLash;
    RelativeLayout rl_benchmark;
    int rotate;
    RelativeLayout rotateLeft;
    RelativeLayout rotateRight;
    String str_from;
    String str_img_url;
    String success_stat;
    String t;
    String tag_artikel;
    long totalSize;
    String urlEmailNotif;
    private boolean useLogo;
    protected UserFunctions userFunctions;
    String user_id;
    String user_jekel;
    String user_joindate;
    String user_kota;
    String user_photo;
    String user_ponsel1;
    String user_ponsel2;
    String user_profile_update;
    String user_provider1;
    String user_provider2;
    String user_provinsi;
    String user_ttl;
    String username;
    int width;
    ContextThemeWrapper wrapper;

    public RoomPostHasilFotoNoCrop()
    {
        now = Calendar.getInstance();
        tag_artikel = "";
        str_img_url = "";
        filePath = "";
        totalSize = 0L;
        rotate = 0;
        width = 1080;
        height = 1920;
        resolution = 2048F;
        resizeWidth = 0;
        resizeHeight = 0;
        json_response = "";
        success_stat = "";
        message_stat = "";
        insert_id = "";
        notif_id = 1;
        path_image = "";
        curtime = "";
        cahaya_kond = "";
        led_flash = "";
        urlEmailNotif = "";
        camera_path = "";
        mAlbumStorageDirFactory = null;
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        t = Utility.session(RestClient.pelihara);
        user_id = "";
        user_photo = "";
        username = "";
    }

    private static int ReverseexifToDegrees(int i)
    {
        return -90;
    }

    private void SendPertanyaan(String s, String s1, String s2, String s3, String s4, String s5)
    {
        try
        {
            s2 = URLEncoder.encode((new StringBuilder("Hasil kamera: ")).append(namalengkap).toString(), "utf-8");
            tag_artikel = URLEncoder.encode(cahaya_kond, "utf-8");
            s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_hasilkamera").append(Utility.BASE_FORMAT).append("?idhp=").append(s).append("&iduser=").append(s1).append("&title=").append(s2).append("&codename=").append(codename).append("&light=").append(URLEncoder.encode(cahaya_kond, "utf-8")).append("&desc=").append(s3).append("&ext=").append(led_flash).append("&img=").append(s4).append("&t=").append(s5).toString();
            Log.e("urlSend", s);
            showSmoothProgress();
            s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

                final RoomPostHasilFotoNoCrop this$0;

                public volatile void onResponse(Object obj)
                {
                    onResponse((JSONObject)obj);
                }

                public void onResponse(JSONObject jsonobject)
                {
                    Log.e("jsonKamera", jsonobject.toString());
                    parseJSONSendMessage(jsonobject.toString());
                    json_response = jsonobject.toString();
                    hideSmoothProgress();
                }

            
            {
                this$0 = RoomPostHasilFotoNoCrop.this;
                super();
            }
            }, new com.android.volley.Response.ErrorListener() {

                final RoomPostHasilFotoNoCrop this$0;

                public void onErrorResponse(VolleyError volleyerror)
                {
                    Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                    hideSmoothProgress();
                }

            
            {
                this$0 = RoomPostHasilFotoNoCrop.this;
                super();
            }
            }, "test", "test");
            PonselBaseApp.getInstance().addToRequestQueue(s, "");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public static void copyStream(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (i == -1)
            {
                return;
            }
            outputstream.write(abyte0, 0, i);
        } while (true);
    }

    private File createImageFile()
        throws IOException
    {
        String s = (new SimpleDateFormat("yyyyMMdd_HHmmss")).format(new Date());
        s = (new StringBuilder("IMG_")).append(s).append("_").toString();
        albumF = getAlbumDir();
        imageF = File.createTempFile(s, ".jpg", albumF);
        return imageF;
    }

    private static int exifToDegrees(int i)
    {
        return 90;
    }

    private void galleryAddPic()
    {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(new File(mCurrentPhotoPath)));
        sendBroadcast(intent);
    }

    private File getAlbumDir()
    {
        File file = null;
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            File file1 = mAlbumStorageDirFactory.getAlbumStorageDir(getAlbumName());
            file = file1;
            if (file1 != null)
            {
                file = file1;
                if (!file1.mkdirs())
                {
                    file = file1;
                    if (!file1.exists())
                    {
                        Log.d("InPonsel", "failed to create directory");
                        return null;
                    }
                }
            }
        } else
        {
            Log.v(getString(0x7f0c0035), "External storage is not mounted READ/WRITE.");
        }
        return file;
    }

    private String getAlbumName()
    {
        return getString(0x7f0c0035);
    }

    public static String getDataColumn(Context context, Uri uri, String s, String as[])
    {
        Context context1 = null;
        context = context.getContentResolver().query(uri, new String[] {
            "_data"
        }, s, as, null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        context1 = context;
        if (!context.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_87;
        }
        context1 = context;
        uri = context.getString(context.getColumnIndexOrThrow("_data"));
        if (context != null)
        {
            context.close();
        }
        return uri;
        context;
        if (context1 != null)
        {
            context1.close();
        }
        throw context;
        if (context != null)
        {
            context.close();
        }
        return null;
    }

    public static Bitmap getImageFromFile(String s)
    {
        s = new File(s);
        if (!s.exists())
        {
            return null;
        }
        android.graphics.BitmapFactory.Options options2;
        int i;
        int j;
        int k;
        try
        {
            android.graphics.BitmapFactory.Options options1 = new android.graphics.BitmapFactory.Options();
            options1.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(s), null, options1);
            k = options1.outWidth;
            j = options1.outHeight;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        i = 1;
        if (k / 2 >= 600 && j / 2 >= 600)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        options2 = new android.graphics.BitmapFactory.Options();
        options2.inSampleSize = i;
        try
        {
            s = BitmapFactory.decodeStream(new FileInputStream(s), null, options2);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
        k /= 2;
        j /= 2;
        i *= 2;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_58;
        }
    }

    public static String getPath(Context context, Uri uri)
    {
        String s = null;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag || !DocumentsContract.isDocumentUri(context, uri)) goto _L2; else goto _L1
_L1:
        if (!isExternalStorageDocument(uri)) goto _L4; else goto _L3
_L3:
        context = DocumentsContract.getDocumentId(uri).split(":");
        if ("primary".equalsIgnoreCase(context[0]))
        {
            s = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(context[1]).toString();
        }
_L9:
        return s;
_L4:
        String as[];
        String s1;
        if (isDownloadsDocument(uri))
        {
            uri = DocumentsContract.getDocumentId(uri);
            return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(uri).longValue()), null, null);
        }
        if (!isMediaDocument(uri))
        {
            continue; /* Loop/switch isn't completed */
        }
        as = DocumentsContract.getDocumentId(uri).split(":");
        s1 = as[0];
        uri = null;
        if (!"image".equals(s1)) goto _L6; else goto _L5
_L5:
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
_L7:
        return getDataColumn(context, uri, "_id=?", new String[] {
            as[1]
        });
_L6:
        if ("video".equals(s1))
        {
            uri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else
        if ("audio".equals(s1))
        {
            uri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        }
        if (true) goto _L7; else goto _L2
_L2:
        if ("content".equalsIgnoreCase(uri.getScheme()))
        {
            return getDataColumn(context, uri, null, null);
        }
        if ("file".equalsIgnoreCase(uri.getScheme()))
        {
            return uri.getPath();
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    private String getRealPathFromURI(Uri uri)
    {
        Cursor cursor1 = getContentResolver().query(uri, null, null, null, null);
        if (cursor1 == null)
        {
            return uri.getPath();
        } else
        {
            cursor1.moveToFirst();
            uri = cursor1.getString(cursor1.getColumnIndex("_data"));
            cursor1.close();
            return uri;
        }
    }

    private void handleBigCameraPhoto()
    {
        if (mCurrentPhotoPath != null)
        {
            setPic();
            galleryAddPic();
            mCurrentPhotoPath = null;
        }
    }

    private void hideSmoothProgress()
    {
label0:
        {
            Log.e("bitmap ", String.valueOf(((BitmapDrawable)imgAskHp.getDrawable()).getBitmap()));
            btnPostAskHp.setEnabled(true);
            if (progbar_send.getVisibility() == 0)
            {
                progbar_send.setVisibility(8);
                progbar_send.setVisibility(8);
                if (!success_stat.equals("1"))
                {
                    break label0;
                }
                PendingIntent pendingintent = PendingIntent.getActivity(this, 0, new Intent(), 0x10000000);
                mBuilder.setContentTitle((new StringBuilder("Hasil kamera: ")).append(namalengkap).toString()).setContentText("Berhasil memposting hasil kamera").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(pendingintent).setAutoCancel(true);
                mNotifyManager.notify(notif_id, mBuilder.build());
                db.delete_byARTID(curtime, (new StringBuilder("Hasil kamera: ")).append(namalengkap).toString());
                setResult(-1, (new Intent()).putExtra("jsonKom", json_response));
                Log.e("urlEmailNotifsuc", urlEmailNotif);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new SendMailTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else
                {
                    (new SendMailTask()).execute(new Void[0]);
                }
                finish();
            }
            return;
        }
        Log.e("post", "gagal");
        btnPostAskHp.setEnabled(true);
        if (!db.checkARTJudulIfExist(curtime, (new StringBuilder("Hasil kamera: ")).append(namalengkap).toString())) goto _L2; else goto _L1
_L1:
        DatabaseHandler databasehandler;
        String s;
        String s1;
        String s2;
        Toast.makeText(getApplicationContext(), "Berhasil memperbaharui", 1).show();
        databasehandler = db;
        s = curtime;
        s1 = (new StringBuilder("Hasil kamera: ")).append(namalengkap).toString();
        s2 = cahaya_kond;
        if (photo_upload != null) goto _L4; else goto _L3
_L3:
        Object obj = "";
_L5:
        String s3;
        try
        {
            databasehandler.update_byARTID(s, s1, s2, ((String) (obj)), edtPertanyaan.getText().toString(), led_flash);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
_L6:
        obj = new Intent();
        ((Intent) (obj)).setClass(getApplicationContext(), com/inponsel/android/v2/RoomMyDraftPost);
        obj = PendingIntent.getActivity(this, 0, ((Intent) (obj)), 0x10000000);
        mBuilder.setContentTitle((new StringBuilder("Hasil kamera: ")).append(namalengkap).toString()).setContentText("Gagal memposting hasil kamera").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(((PendingIntent) (obj))).setAutoCancel(true);
        mNotifyManager.notify(notif_id, mBuilder.build());
        return;
_L4:
        obj = path_image;
          goto _L5
_L2:
        databasehandler = db;
        s = id_hp;
        s1 = codename;
        s2 = (new StringBuilder("Hasil kamera: ")).append(namalengkap).toString();
        s3 = cahaya_kond;
        if (photo_upload != null)
        {
            break MISSING_BLOCK_LABEL_631;
        }
        obj = "";
_L7:
        databasehandler.addArtUser(s, s1, "hasilkamera", s2, s3, ((String) (obj)), edtPertanyaan.getText().toString(), led_flash, curtime);
          goto _L6
        obj = path_image;
          goto _L7
    }

    public static boolean isDownloadsDocument(Uri uri)
    {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri)
    {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri)
    {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private void notifGagal()
    {
        Object obj = new Intent();
        ((Intent) (obj)).setClass(getApplicationContext(), com/inponsel/android/v2/RoomMyDraftPost);
        obj = PendingIntent.getActivity(this, 0, ((Intent) (obj)), 0x10000000);
        mBuilder.setContentTitle((new StringBuilder("Hasil kamera: ")).append(namalengkap).toString()).setContentText("Gagal memposting hasil kamera").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(((PendingIntent) (obj))).setAutoCancel(true);
        mNotifyManager.notify(notif_id, mBuilder.build());
    }

    private void parseJSONSendMessage(String s)
    {
        try
        {
            Log.e("jsonKamera", s);
            s = new JSONObject(s);
            success_stat = s.getString("success");
            message_stat = s.getString("message_stat");
            insert_id = s.getString("insert_id");
            urlEmailNotif = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_forum").append(Utility.BASE_FORMAT).append("?id=").append(insert_id).append("&id_user=").append(user_id).append("&t=").append(t).toString();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            success_stat = "";
        }
        s.printStackTrace();
    }

    private void setPic()
    {
        File file = new File(mCurrentPhotoPath);
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new android.graphics.BitmapFactory.Options();
        obj.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        float f;
        float f1;
        try
        {
            obj = BitmapFactory.decodeStream(new FileInputStream(file), null, ((android.graphics.BitmapFactory.Options) (obj)));
            Log.e("whe", String.valueOf((new StringBuilder(String.valueOf(((Bitmap) (obj)).getWidth()))).append(" : ").append(((Bitmap) (obj)).getHeight()).toString()));
            width = ((Bitmap) (obj)).getWidth();
            height = ((Bitmap) (obj)).getHeight();
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            try
            {
                filenotfoundexception.printStackTrace();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                return;
            }
        }
        f1 = aspectratio(width, height);
        f = (float)width / f1;
        f1 = (float)height / f1;
        Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
        if ((float)width < resolution && (float)height < resolution)
        {
            break MISSING_BLOCK_LABEL_560;
        }
        if (f <= f1) goto _L4; else goto _L3
_L3:
        Log.e("image_postion", "landscape");
        Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(resolution))).append(" : ").append((resolution * f1) / f).toString()));
        Log.e("ratioDP", String.valueOf((new StringBuilder(String.valueOf(Utility.convertPixelsToDp(resolution, this)))).append(" : ").append(Utility.convertPixelsToDp((resolution * f1) / f, this)).toString()));
        resizeWidth = (int)resolution;
        resizeHeight = (int)((resolution * f1) / f);
_L5:
        camera_path = mCurrentPhotoPath;
        Log.e("camera_path", camera_path);
        photo_upload = BitmapFactory.decodeFile(camera_path);
        photo_upload = getResizedBitmap(photo_upload, resizeWidth, resizeHeight);
        Picasso.with(this).load(file).resize(resizeWidth, resizeHeight).into(imgAskHp);
_L2:
        imgAskHp.setVisibility(0);
        return;
_L4:
        Log.e("image_postion", "portrait");
        Log.e("ratioFinal", (new StringBuilder(String.valueOf(String.valueOf((resolution * f) / f1)))).append(" : ").append(resolution).toString());
        Log.e("ratioDP", String.valueOf((new StringBuilder(String.valueOf(Utility.convertPixelsToDp((resolution * f) / f1, this)))).append(" : ").append(Utility.convertPixelsToDp(resolution, this)).toString()));
        resizeWidth = (int)((resolution * f) / f1);
        resizeHeight = (int)resolution;
          goto _L5
        resizeWidth = width;
        resizeHeight = height;
          goto _L5
    }

    private void setTranslucentStatus(boolean flag)
    {
        Window window = getWindow();
        android.view.WindowManager.LayoutParams layoutparams = window.getAttributes();
        if (flag)
        {
            layoutparams.flags = layoutparams.flags | 0x4000000;
        } else
        {
            layoutparams.flags = layoutparams.flags & 0xfbffffff;
        }
        window.setAttributes(layoutparams);
    }

    private File setUpPhotoFile()
        throws IOException
    {
        File file = createImageFile();
        mCurrentPhotoPath = file.getAbsolutePath();
        return file;
    }

    private void showSmoothProgress()
    {
        progbar_send.setVisibility(0);
        edtPertanyaan.setEnabled(false);
        imgAskHp.setEnabled(false);
        btnPostAskHp.setEnabled(false);
    }

    public Bitmap StringToBitMap(String s)
    {
        try
        {
            s = Base64.decode(s, 0);
            s = BitmapFactory.decodeByteArray(s, 0, s.length);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.getMessage();
            return null;
        }
        return s;
    }

    public float aspectratio(float f, float f1)
    {
        if (f >= f1)
        {
            f2 = f;
            f = f1;
            f1 = f2;
        }
        f1 %= f;
        do
        {
            float f2 = f;
            if (f1 <= 0.0F)
            {
                return f2;
            }
            f = f1;
            f1 = f2 % f;
        } while (true);
    }

    public String getRealPathFromURI2(Uri uri)
    {
        uri = managedQuery(uri, new String[] {
            "_data"
        }, null, null, null);
        int i = uri.getColumnIndexOrThrow("_data");
        uri.moveToFirst();
        return uri.getString(i);
    }

    public Bitmap getResizedBitmap(Bitmap bitmap, int i, int j)
    {
        int k = bitmap.getWidth();
        int l = bitmap.getHeight();
        float f = (float)i / (float)k;
        float f1 = (float)j / (float)l;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f1);
        return Bitmap.createBitmap(bitmap, 0, 0, k, l, matrix, false);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (j != -1)
        {
            Log.e("camera", "cancel");
            if (i != 2)
            {
                (new File(mCurrentPhotoPath)).delete();
            }
        } else
        {
            rotateLeft.setVisibility(0);
            rotateRight.setVisibility(0);
            imgAskHp.getLayoutParams().height = (int)Utility.convertDpToPixel(300F, this);
            imgAskHp.getLayoutParams().width = (int)Utility.convertDpToPixel(300F, this);
            if (i == 2)
            {
                intent = intent.getData();
                Object obj = getRealPathFromURI2(intent);
                Log.e("file_path", intent.toString());
                obj = BitmapFactory.decodeFile(((String) (obj)));
                width = ((Bitmap) (obj)).getWidth();
                height = ((Bitmap) (obj)).getHeight();
                Log.e("whe", String.valueOf((new StringBuilder(String.valueOf(width))).append(" : ").append(height).toString()));
                float f1 = aspectratio(width, height);
                float f = (float)width / f1;
                f1 = (float)height / f1;
                Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
                if ((float)width >= resolution || (float)height >= resolution)
                {
                    if (f > f1)
                    {
                        Log.e("image_postion", "landscape");
                        Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(resolution))).append(" : ").append((resolution * f1) / f).toString()));
                        Log.e("ratioDP", String.valueOf((new StringBuilder(String.valueOf(Utility.convertPixelsToDp(resolution, this)))).append(" : ").append(Utility.convertPixelsToDp((resolution * f1) / f, this)).toString()));
                        resizeWidth = (int)resolution;
                        resizeHeight = (int)((resolution * f1) / f);
                    } else
                    {
                        Log.e("image_postion", "portrait");
                        Log.e("ratioFinal", (new StringBuilder(String.valueOf(String.valueOf((resolution * f) / f1)))).append(" : ").append(resolution).toString());
                        Log.e("ratioDP", String.valueOf((new StringBuilder(String.valueOf(Utility.convertPixelsToDp((resolution * f) / f1, this)))).append(" : ").append(Utility.convertPixelsToDp(resolution, this)).toString()));
                        resizeWidth = (int)((resolution * f) / f1);
                        resizeHeight = (int)resolution;
                    }
                } else
                {
                    resizeWidth = width;
                    resizeHeight = height;
                }
                Log.e("selpath", getRealPathFromURI(intent));
                Log.e("resizeWidth", String.valueOf(resizeWidth));
                Log.e("resizeHeight", String.valueOf(resizeHeight));
                photo_upload = BitmapFactory.decodeFile(getPath(this, intent));
                photo_upload = getResizedBitmap(photo_upload, resizeWidth, resizeHeight);
                Picasso.with(this).load(intent).resize(resizeWidth, resizeHeight).into(imgAskHp);
                Log.e("bmpres", String.valueOf(photo_upload));
                return;
            }
            if (i == 1 && j == -1)
            {
                handleBigCameraPhoto();
                return;
            }
        }
    }

    protected void onCreate(final Bundle dialog)
    {
        super.onCreate(dialog);
        setContentView(0x7f0300ab);
        cm = (ConnectivityManager)getSystemService("connectivity");
        netInfo = cm.getActiveNetworkInfo();
        db = new DatabaseHandler(this);
        userFunctions = new UserFunctions();
        if (userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            android.app.AlertDialog.Builder builder;
            int i;
            int j;
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (final Bundle dialog) { }
            nama_asli = cursor.getString(2);
            user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
            username = cursor.getString(4);
            email_user = cursor.getString(5);
            user_ttl = cursor.getString(6);
            user_provinsi = cursor.getString(7);
            user_kota = cursor.getString(8);
            user_jekel = cursor.getString(9);
            user_ponsel1 = cursor.getString(10);
            user_ponsel2 = cursor.getString(11);
            user_provider1 = cursor.getString(12);
            user_provider2 = cursor.getString(13);
            user_joindate = cursor.getString(14);
            user_profile_update = cursor.getString(15);
        }
        Log.e("user_id_start", user_id);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        dialog = new SystemBarTintManager(this);
        dialog.setStatusBarTintEnabled(true);
        dialog.setStatusBarTintResource(0x7f080173);
        t = Utility.session(t);
        t = Utility.session(t);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        curtime = (new SimpleDateFormat("MMddHHmmss")).format(new Date());
        extras = getIntent().getExtras();
        id_hp = extras.getString("id_hph");
        str_from = extras.getString("from");
        codename = extras.getString("codename");
        model = extras.getString("model");
        merk = extras.getString("merk");
        namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        namalengkap = URLDecoder.decode(namalengkap);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e7));
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        dialog = (TextView)findViewById(i);
        dialog.setSelected(true);
        dialog.setTextColor(Color.parseColor("#FFFFFF"));
        dialog.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Kirim foto</font>"));
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        wrapper = new ContextThemeWrapper(this, 0x103006e);
        notificationTanyaArtHelper = new NotificationTanyaArtHelper(this);
        rotateLeft = (RelativeLayout)findViewById(0x7f0b0081);
        rotateRight = (RelativeLayout)findViewById(0x7f0b0082);
        rotateLeft.setVisibility(8);
        rotateRight.setVisibility(8);
        imgAskHp = (ImageView)findViewById(0x7f0b051a);
        edtPertanyaan = (EditText)findViewById(0x7f0b05a8);
        edtPertanyaan.setHint("Informasi tambahan");
        btnPostAskHp = (Button)findViewById(0x7f0b0520);
        btnSaveAskHp = (Button)findViewById(0x7f0b05a9);
        btnhasilfoto = (Button)findViewById(0x7f0b05ac);
        rgPilLEDFLash = (RadioGroup)findViewById(0x7f0b05ad);
        rbLEDYa = (RadioButton)findViewById(0x7f0b05ae);
        rbLEDTidak = (RadioButton)findViewById(0x7f0b05af);
        progbar_send = (SmoothProgressBar)findViewById(0x7f0b0519);
        progbar_send.setVisibility(8);
        rgPilLEDFLash.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            final RoomPostHasilFotoNoCrop this$0;

            public void onCheckedChanged(RadioGroup radiogroup, int k)
            {
                if (rbLEDYa.isChecked())
                {
                    led_flash = "Ya";
                } else
                {
                    led_flash = "Tidak";
                }
                if (led_flash.equals("") || cahaya_kond.equals("") || photo_upload == null)
                {
                    if (!led_flash.equals("") || !cahaya_kond.equals("") || photo_upload != null)
                    {
                        btnSaveAskHp.setEnabled(true);
                        return;
                    } else
                    {
                        btnPostAskHp.setEnabled(false);
                        btnSaveAskHp.setEnabled(false);
                        return;
                    }
                }
                if (!led_flash.equals("") || !cahaya_kond.equals("") || photo_upload != null)
                {
                    btnSaveAskHp.setEnabled(true);
                }
                btnPostAskHp.setEnabled(true);
            }

            
            {
                this$0 = RoomPostHasilFotoNoCrop.this;
                super();
            }
        });
        rotateLeft.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPostHasilFotoNoCrop this$0;

            public void onClick(View view)
            {
                Log.e("photo_uploadbmp", String.valueOf(photo_upload));
                photo_upload = Bitmap.createBitmap(photo_upload);
                int k = photo_upload.getWidth();
                int l = photo_upload.getHeight();
                Log.e("width", String.valueOf(k));
                Log.e("clickpath", camera_path);
                try
                {
                    Log.e("rotate", String.valueOf(rotate));
                    int i1 = (new ExifInterface(camera_path)).getAttributeInt("Orientation", 1);
                    rotate = RoomPostHasilFotoNoCrop.ReverseexifToDegrees(i1);
                    view = new Matrix();
                    view.postRotate(rotate);
                    photo_upload = Bitmap.createBitmap(photo_upload, 0, 0, k, l, view, true);
                    imgAskHp.setImageBitmap(photo_upload);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
            }

            
            {
                this$0 = RoomPostHasilFotoNoCrop.this;
                super();
            }
        });
        rotateRight.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPostHasilFotoNoCrop this$0;

            public void onClick(View view)
            {
                photo_upload = Bitmap.createBitmap(photo_upload);
                Log.e("photo_uploadRight", String.valueOf(photo_upload));
                int k = photo_upload.getWidth();
                int l = photo_upload.getHeight();
                Log.e("width", String.valueOf(k));
                Log.e("width", String.valueOf(k));
                try
                {
                    Log.e("rotate", String.valueOf(rotate));
                    int i1 = (new ExifInterface(camera_path)).getAttributeInt("Orientation", 1);
                    rotate = RoomPostHasilFotoNoCrop.exifToDegrees(i1);
                    view = new Matrix();
                    view.postRotate(rotate);
                    photo_upload = Bitmap.createBitmap(photo_upload, 0, 0, k, l, view, true);
                    imgAskHp.setImageBitmap(photo_upload);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
            }

            
            {
                this$0 = RoomPostHasilFotoNoCrop.this;
                super();
            }
        });
        edtPertanyaan.addTextChangedListener(new TextWatcher() {

            final RoomPostHasilFotoNoCrop this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
                if (led_flash.equals("") || cahaya_kond.equals("") || photo_upload == null)
                {
                    if (!led_flash.equals("") || !cahaya_kond.equals("") || photo_upload != null)
                    {
                        btnSaveAskHp.setEnabled(true);
                        return;
                    } else
                    {
                        btnPostAskHp.setEnabled(false);
                        btnSaveAskHp.setEnabled(false);
                        return;
                    }
                }
                if (!led_flash.equals("") || !cahaya_kond.equals("") || photo_upload != null)
                {
                    btnSaveAskHp.setEnabled(true);
                }
                btnPostAskHp.setEnabled(true);
            }

            
            {
                this$0 = RoomPostHasilFotoNoCrop.this;
                super();
            }
        });
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mAlbumStorageDirFactory = new BaseAlbumDirFactory();
        } else
        {
            mAlbumStorageDirFactory = new FroyoAlbumDirFactory();
        }
        btnhasilfoto.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPostHasilFotoNoCrop this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(RoomPostHasilFotoNoCrop.this);
                view.setTitle("Pilih Kondisi Cahaya :");
                view.setSingleChoiceItems(pilih_cahaya, -1, new android.content.DialogInterface.OnClickListener() {

                    final _cls5 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        cahaya_kond = pilih_cahaya[i];
                        btnhasilfoto.setText(cahaya_kond);
                        if (led_flash.equals("") || cahaya_kond.equals("") || photo_upload == null)
                        {
                            if (!led_flash.equals("") || !cahaya_kond.equals("") || photo_upload != null)
                            {
                                btnSaveAskHp.setEnabled(true);
                            } else
                            {
                                btnPostAskHp.setEnabled(false);
                                btnSaveAskHp.setEnabled(false);
                            }
                        } else
                        {
                            if (!led_flash.equals("") || !cahaya_kond.equals("") || photo_upload != null)
                            {
                                btnSaveAskHp.setEnabled(true);
                            }
                            btnPostAskHp.setEnabled(true);
                        }
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = RoomPostHasilFotoNoCrop.this;
                super();
            }
        });
        dialog = new ArrayAdapter(this, 0x1090011, new String[] {
            "Dari Kamera", "Dari Galeri"
        });
        builder = new android.app.AlertDialog.Builder(wrapper);
        builder.setTitle("Pilih gambar");
        builder.setAdapter(dialog, new android.content.DialogInterface.OnClickListener() {

            final RoomPostHasilFotoNoCrop this$0;

            public void onClick(DialogInterface dialoginterface, int k)
            {
                if (k == 0)
                {
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    try
                    {
                        File file = setUpPhotoFile();
                        mCurrentPhotoPath = file.getAbsolutePath();
                        intent.putExtra("output", Uri.fromFile(file));
                    }
                    catch (IOException ioexception)
                    {
                        ioexception.printStackTrace();
                        mCurrentPhotoPath = null;
                    }
                    dialoginterface.cancel();
                    startActivityForResult(intent, 1);
                    return;
                } else
                {
                    dialoginterface = new Intent("android.intent.action.PICK");
                    dialoginterface.setType("image/*");
                    startActivityForResult(Intent.createChooser(dialoginterface, "Complete action using"), 2);
                    return;
                }
            }

            
            {
                this$0 = RoomPostHasilFotoNoCrop.this;
                super();
            }
        });
        dialog = builder.create();
        imgAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPostHasilFotoNoCrop this$0;
            private final AlertDialog val$dialog;

            public void onClick(View view)
            {
                dialog.show();
            }

            
            {
                this$0 = RoomPostHasilFotoNoCrop.this;
                dialog = alertdialog;
                super();
            }
        });
        btnSaveAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPostHasilFotoNoCrop this$0;

            public void onClick(View view)
            {
                DatabaseHandler databasehandler;
                String s;
                String s1;
                String s2;
                if (!db.checkARTJudulIfExist(curtime, (new StringBuilder("Hasil kamera: ")).append(namalengkap).toString()))
                {
                    break MISSING_BLOCK_LABEL_164;
                }
                Toast.makeText(getApplicationContext(), "Berhasil memperbaharui", 1).show();
                databasehandler = db;
                s = curtime;
                s1 = (new StringBuilder("Hasil kamera: ")).append(namalengkap).toString();
                s2 = cahaya_kond;
                if (photo_upload == null)
                {
                    view = "";
                    break MISSING_BLOCK_LABEL_120;
                }
                view = path_image;
                  goto _L1
                Toast.makeText(getApplicationContext(), "Berhasil menyimpan", 1).show();
                databasehandler = db;
                s = id_hp;
                s1 = codename;
                s2 = (new StringBuilder("Hasil kamera: ")).append(namalengkap).toString();
                s3 = cahaya_kond;
                if (photo_upload != null)
                {
                    break MISSING_BLOCK_LABEL_301;
                }
                view = "";
_L2:
                databasehandler.addArtUser(s, s1, "hasilkamera", s2, s3, view, edtPertanyaan.getText().toString(), led_flash, curtime);
                return;
_L1:
                String s3;
                try
                {
                    databasehandler.update_byARTID(s, s1, s2, view, edtPertanyaan.getText().toString(), led_flash);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                return;
                view = path_image;
                  goto _L2
            }

            
            {
                this$0 = RoomPostHasilFotoNoCrop.this;
                super();
            }
        });
        btnPostAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPostHasilFotoNoCrop this$0;

            public void onClick(View view)
            {
                if (netInfo != null && netInfo.isConnected())
                {
                    btnPostAskHp.setEnabled(false);
                    if (photo_upload == null)
                    {
                        Toast.makeText(getApplicationContext(), "Hasil kamera belum diisi", 1).show();
                        return;
                    }
                    if (cahaya_kond.equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "Kondisi cahaya belum dipilih", 1).show();
                        return;
                    }
                    if (led_flash.equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "Kondisi LED Flash belum dipilih", 1).show();
                        return;
                    }
                    view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                    notif_id = Integer.parseInt(view);
                    mNotifyManager = (NotificationManager)getSystemService("notification");
                    mBuilder = new android.support.v4.app.NotificationCompat.Builder(RoomPostHasilFotoNoCrop.this);
                    mBuilder.setContentTitle((new StringBuilder("Hasil kamera: ")).append(namalengkap).toString()).setContentText("Mengirim 0%").setSmallIcon(0x7f0201e4);
                    Log.e("photo", "oke");
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        try
                        {
                            (new UploadImage(null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]).get(90L, TimeUnit.SECONDS);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            notifGagal();
                            view.printStackTrace();
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            notifGagal();
                            view.printStackTrace();
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            notifGagal();
                        }
                        view.printStackTrace();
                        return;
                    }
                    try
                    {
                        (new UploadImage(null)).execute(new Void[0]).get(90L, TimeUnit.SECONDS);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        notifGagal();
                        view.printStackTrace();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        notifGagal();
                        view.printStackTrace();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        notifGagal();
                    }
                    view.printStackTrace();
                    return;
                } else
                {
                    Toast.makeText(getApplicationContext(), "Tidak ada koneksi internet", 1).show();
                    return;
                }
            }

            
            {
                this$0 = RoomPostHasilFotoNoCrop.this;
                super();
            }
        });
        if (!str_from.equals("notif")) goto _L2; else goto _L1
_L1:
        dialog = extras.getString("id_date");
        curtime = dialog;
        if (!db.checkArtIfExist(dialog)) goto _L2; else goto _L3
_L3:
        cursor = db.getARTID(dialog);
        cursor.moveToFirst();
        id_hp = cursor.getString(1);
        btnhasilfoto.setText(cursor.getString(5));
        cahaya_kond = cursor.getString(5);
        led_flash = cursor.getString(8);
        if (!led_flash.toLowerCase().equals("ya"))
        {
            break MISSING_BLOCK_LABEL_1418;
        }
        rbLEDYa.setChecked(true);
_L4:
        edtPertanyaan.setText(cursor.getString(7));
        if (!cursor.getString(3).equals(""))
        {
            dialog = new File(cursor.getString(6));
            if (!dialog.exists())
            {
                break MISSING_BLOCK_LABEL_1435;
            }
            dialog = BitmapFactory.decodeFile(dialog.getAbsolutePath());
            imgAskHp.setImageBitmap(dialog);
        }
_L2:
        return;
        try
        {
            rbLEDTidak.setChecked(true);
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
            return;
        }
          goto _L4
        imgAskHp.setImageResource(0x7f020073);
        return;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (netInfo == null || !netInfo.isConnected())
        {
            notifGagal();
        }
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void update(Observable observable, Object obj)
    {
    }













}
