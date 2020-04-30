// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
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
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.AndroidMultiPartEntity;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
import com.inponsel.android.utils.Base64;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.InternalStorageContentProvider;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import eu.janmuller.android.simplecropimage.CropImage;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.File;
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
//            RoomMyDraftPost

public class RoomPostArtikel extends SherlockFragmentActivity
    implements Observer
{
    public class SendMailTask extends AsyncTask
    {

        final RoomPostArtikel this$0;

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
            this$0 = RoomPostArtikel.this;
            super();
        }
    }

    private class UploadImage extends AsyncTask
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
                    SendPertanyaan(id_hp, user_id, URLEncoder.encode(edtJudulAskHp.getText().toString(), "utf-8"), URLEncoder.encode(edtPertanyaan.getText().toString(), "utf-8"), URLEncoder.encode(str_img_url.trim(), "utf-8"), t);
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
            mBuilder.setProgress(99, 0, false);
            mNotifyManager.notify(notif_id, mBuilder.build());
            progbar_send.setVisibility(0);
        }

        protected transient void onProgressUpdate(Integer ainteger[])
        {
            if (ainteger[0].intValue() == 100)
            {
                mBuilder.setProgress(99, 99, false);
                mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setOngoing(true).setContentText((new StringBuilder("Mengirim artikel... - ")).append(String.valueOf(99)).append("%").toString()).setSmallIcon(0x7f0201e4);
            } else
            {
                mBuilder.setProgress(99, ainteger[0].intValue(), false);
                mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setOngoing(true).setContentText((new StringBuilder("Mengirim artikel... - ")).append(String.valueOf(ainteger[0])).append("%").toString()).setSmallIcon(0x7f0201e4);
            }
            mNotifyManager.notify(notif_id, mBuilder.build());
        }

        protected volatile transient void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((Integer[])aobj);
        }



        private UploadImage()
        {
            this$0 = RoomPostArtikel.this;
            super();
        }

        UploadImage(UploadImage uploadimage)
        {
            this();
        }
    }


    private static final String FOLDER_NAME = "InPonsel";
    public static final int REQUEST_CODE_CROP_IMAGE = 3;
    public static final int REQUEST_CODE_GALLERY = 1;
    public static final int REQUEST_CODE_TAKE_PICTURE = 2;
    public static final String TEMP_PHOTO_FILE_NAME = (new StringBuilder("inponsel_")).append(System.currentTimeMillis()).append(".jpg").toString();
    ActionBar actionBar;
    int actionBarTitleId;
    private ImageLoadingListener animateFirstListener;
    Button btnPostAskHp;
    Button btnSaveAskHp;
    Button btnUpdateAskHp;
    ConnectivityManager cm;
    String codename;
    Cursor cursor;
    String curtime;
    DatabaseHandler db;
    EditText edtJudulAskHp;
    EditText edtPertanyaan;
    String email_user;
    Bundle extras;
    String fav_stat;
    String filePath;
    String gambar;
    String id_hp;
    ImageLoader imageLoader2;
    ImageView imgAskHp;
    String insert_id;
    InputStream is;
    String json_response;
    String like_stat;
    private android.support.v4.app.NotificationCompat.Builder mBuilder;
    private File mFileTemp;
    private NotificationManager mNotifyManager;
    String merk;
    String message_stat;
    String model;
    String nama_asli;
    String namalengkap;
    NetworkInfo netInfo;
    int notif_id;
    Calendar now;
    private DisplayImageOptions options;
    String path_image;
    Bitmap photo_upload;
    PonselBaseApp ponselBaseApp;
    String post_action;
    SmoothProgressBar progbar_send;
    RadioButton rbAksesoris;
    RadioButton rbApp;
    RadioButton rbGames;
    RadioButton rbHack;
    RadioButton rbOSFirm;
    RadioButton rbTips;
    RadioButton rbUmum;
    String resp;
    RadioGroup rgPilTagArtikel;
    String str_from;
    String str_img_url;
    String success_stat;
    String t;
    String tag_artikel;
    String tl_codename;
    String tl_content;
    String tl_content_ext;
    String tl_date;
    String tl_id;
    String tl_id_hp;
    String tl_id_user;
    String tl_img_url;
    String tl_judul;
    String tl_me;
    String tl_tag;
    String tl_type;
    String tl_username;
    String tl_userphoto;
    long totalSize;
    String total_like;
    TextView txtKategori;
    TextView txtLabel_artikel;
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
    ContextThemeWrapper wrapper;

    public RoomPostArtikel()
    {
        animateFirstListener = new AnimateFirstDisplayListener();
        str_img_url = "";
        filePath = "";
        notif_id = 1;
        now = Calendar.getInstance();
        totalSize = 0L;
        success_stat = "";
        message_stat = "";
        insert_id = "";
        json_response = "";
        urlEmailNotif = "";
        path_image = "";
        tag_artikel = "";
        curtime = "";
        post_action = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        t = Utility.session(RestClient.pelihara);
        user_photo = "";
        username = "";
    }

    private void SendPertanyaan(String s, String s1, String s2, String s3, String s4, String s5)
    {
        if (tl_type.equals("global"))
        {
            if (post_action.equals("edit"))
            {
                s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("edit_artikel_user").append(Utility.BASE_FORMAT).append("?idhp=").append(s).append("&idart=").append(tl_id).append("&iduser=").append(s1).append("&title=").append(s2).append("&codename=").append("&tag=").append(tag_artikel).append("&content=").append(s3).append("&img=").append(s4).append("&t=").append(s5).toString();
            } else
            {
                s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_artikel_user").append(Utility.BASE_FORMAT).append("?idhp=").append(s).append("&iduser=").append(s1).append("&title=").append(s2).append("&codename=").append("&tag=").append(tag_artikel).append("&content=").append(s3).append("&img=").append(s4).append("&t=").append(s5).toString();
            }
        } else
        if (post_action.equals("edit"))
        {
            s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("edit_artikel_user").append(Utility.BASE_FORMAT).append("?idhp=").append(s).append("&idart=").append(tl_id).append("&iduser=").append(s1).append("&title=").append(s2).append("&codename=").append(codename).append("&tag=").append(tag_artikel).append("&content=").append(s3).append("&img=").append(s4).append("&t=").append(s5).toString();
        } else
        {
            s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_artikel_user").append(Utility.BASE_FORMAT).append("?idhp=").append(s).append("&iduser=").append(s1).append("&title=").append(s2).append("&codename=").append(codename).append("&tag=").append(tag_artikel).append("&content=").append(s3).append("&img=").append(s4).append("&t=").append(s5).toString();
        }
        Log.e("urlSend", s);
        showSmoothProgress();
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final RoomPostArtikel this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSONSendMessage(jsonobject.toString());
                json_response = jsonobject.toString();
                hideSmoothProgress();
                if (post_action.equals("edit"))
                {
                    finish();
                    return;
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new SendMailTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else
                {
                    (new SendMailTask()).execute(new Void[0]);
                }
                finish();
            }

            
            {
                this$0 = RoomPostArtikel.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final RoomPostArtikel this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideSmoothProgress();
            }

            
            {
                this$0 = RoomPostArtikel.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "");
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

    private File createFolders()
    {
        File file;
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            file = Environment.getExternalStorageDirectory();
        } else
        {
            file = Environment.getExternalStorageDirectory();
        }
        if (file == null)
        {
            file = Environment.getExternalStorageDirectory();
        } else
        {
            File file1 = new File(file, "InPonsel");
            file = file1;
            if (!file1.exists())
            {
                file = file1;
                if (!file1.mkdirs())
                {
                    return Environment.getExternalStorageDirectory();
                }
            }
        }
        return file;
    }

    private File getNextFileName()
    {
        if (mFileTemp != null && mFileTemp.exists())
        {
            return new File(mFileTemp, TEMP_PHOTO_FILE_NAME);
        } else
        {
            return null;
        }
    }

    private void hideSmoothProgress()
    {
label0:
        {
            Log.e("bitmap ", String.valueOf(((BitmapDrawable)imgAskHp.getDrawable()).getBitmap()));
            btnPostAskHp.setEnabled(true);
            setResult(-1, (new Intent()).putExtra("jsonKom", json_response));
            if (progbar_send.getVisibility() == 0)
            {
                progbar_send.setVisibility(8);
                progbar_send.setVisibility(8);
                if (!success_stat.equals("1"))
                {
                    break label0;
                }
                db.delete_byARTID(curtime, edtJudulAskHp.getText().toString());
                notifBerhasil();
            }
            return;
        }
        Log.e("post", "gagal");
        btnPostAskHp.setEnabled(true);
        btnUpdateAskHp.setEnabled(true);
        notifGagal();
        mNotifyManager.notify(notif_id, mBuilder.build());
        DatabaseHandler databasehandler;
        String s;
        String s1;
        String s2;
        if (!db.checkARTJudulIfExist(curtime, edtJudulAskHp.getText().toString()))
        {
            break MISSING_BLOCK_LABEL_287;
        }
        Toast.makeText(getApplicationContext(), "Berhasil memperbaharui", 1).show();
        databasehandler = db;
        s = curtime;
        s1 = edtJudulAskHp.getText().toString();
        s2 = tag_artikel;
        if (photo_upload != null)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        Object obj = "";
_L1:
        try
        {
            databasehandler.update_byARTID(s, s1, s2, ((String) (obj)), edtPertanyaan.getText().toString(), "");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        return;
        obj = path_image;
          goto _L1
        String s3;
        databasehandler = db;
        s = id_hp;
        s1 = codename;
        s2 = edtJudulAskHp.getText().toString();
        s3 = tag_artikel;
        if (photo_upload != null)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        obj = "";
_L3:
        databasehandler.addArtUser(s, s1, "artikel", s2, s3, ((String) (obj)), edtPertanyaan.getText().toString(), "", curtime);
        return;
        obj = path_image;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private void openGallery()
    {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    private void parseJSONSendMessage(String s)
    {
        try
        {
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

    private void showSmoothProgress()
    {
        progbar_send.setVisibility(0);
        edtJudulAskHp.setEnabled(false);
        edtPertanyaan.setEnabled(false);
        imgAskHp.setEnabled(false);
        btnPostAskHp.setEnabled(false);
        if (photo_upload == null)
        {
            mBuilder.setProgress(99, 50, false);
            mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setOngoing(true).setContentText((new StringBuilder("Mengirim artikel... - ")).append(String.valueOf(50)).append("%").toString()).setSmallIcon(0x7f0201e4);
            mNotifyManager.notify(notif_id, mBuilder.build());
        }
    }

    private void startCropImage()
    {
        Intent intent = new Intent(this, eu/janmuller/android/simplecropimage/CropImage);
        intent.putExtra("image-path", mFileTemp.getPath());
        intent.putExtra("scale", true);
        intent.putExtra("aspectX", 0);
        intent.putExtra("aspectY", 0);
        startActivityForResult(intent, 3);
    }

    private void takePicture()
    {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Uri uri;
        if (!"mounted".equals(Environment.getExternalStorageState()))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        uri = Uri.fromFile(mFileTemp);
_L1:
        intent.putExtra("output", uri);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 2);
        return;
        try
        {
            uri = InternalStorageContentProvider.CONTENT_URI;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            return;
        }
          goto _L1
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

    public void notifBerhasil()
    {
        PendingIntent pendingintent = PendingIntent.getActivity(this, 0, new Intent(), 0x10000000);
        mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Berhasil mengirim artikel").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(pendingintent).setAutoCancel(true);
        mNotifyManager.notify(notif_id, mBuilder.build());
    }

    public void notifGagal()
    {
        Object obj = new Intent();
        ((Intent) (obj)).setClass(getApplicationContext(), com/inponsel/android/v2/RoomMyDraftPost);
        obj = PendingIntent.getActivity(this, 0, ((Intent) (obj)), 0x10000000);
        mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Gagal mengirim artikel").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(((PendingIntent) (obj))).setAutoCancel(true);
        mNotifyManager.notify(notif_id, mBuilder.build());
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (j == -1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        i;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 40
    //                   2 95
    //                   3 102;
           goto _L3 _L4 _L5 _L6
_L3:
        super.onActivityResult(i, j, intent);
        return;
_L4:
        try
        {
            InputStream inputstream = getContentResolver().openInputStream(intent.getData());
            FileOutputStream fileoutputstream = new FileOutputStream(mFileTemp);
            copyStream(inputstream, fileoutputstream);
            fileoutputstream.close();
            inputstream.close();
            startCropImage();
        }
        catch (Exception exception) { }
        break; /* Loop/switch isn't completed */
_L5:
        startCropImage();
        break; /* Loop/switch isn't completed */
_L6:
        path_image = intent.getStringExtra("image-path");
        Log.e("path_image", path_image);
        if (path_image == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        Bitmap bitmap = BitmapFactory.decodeFile(mFileTemp.getPath());
        photo_upload = BitmapFactory.decodeFile(mFileTemp.getPath());
        tl_img_url = "";
        imgAskHp.setImageBitmap(bitmap);
        filePath = path_image;
        if (true) goto _L3; else goto _L7
_L7:
        if (true) goto _L1; else goto _L8
_L8:
    }

    protected void onCreate(final Bundle dialog)
    {
        super.onCreate(dialog);
        setContentView(0x7f0300ac);
        cm = (ConnectivityManager)getSystemService("connectivity");
        netInfo = cm.getActiveNetworkInfo();
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        db = new DatabaseHandler(this);
        userFunctions = new UserFunctions();
        dialog = new SystemBarTintManager(this);
        dialog.setStatusBarTintEnabled(true);
        dialog.setStatusBarTintResource(0x7f080173);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        t = Utility.session(t);
        t = Utility.session(t);
        curtime = (new SimpleDateFormat("MMddHHmmss")).format(new Date());
        extras = getIntent().getExtras();
        id_hp = extras.getString("id_hph");
        str_from = extras.getString("from");
        codename = extras.getString("codename");
        model = extras.getString("model");
        merk = extras.getString("merk");
        namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        post_action = extras.getString("action");
        tl_tag = extras.getString("tl_tag");
        tl_type = extras.getString("tl_type");
        if (post_action.equals("edit"))
        {
            str_from = "";
            tl_id = extras.getString("tl_id");
            tl_judul = extras.getString("tl_judul");
            tl_content = extras.getString("tl_content");
            tl_content_ext = extras.getString("tl_content_ext");
            codename = extras.getString("tl_codename");
            tl_date = extras.getString("tl_date");
            tl_id = extras.getString("tl_id");
            tl_id_hp = extras.getString("tl_id_hp");
            tl_id_user = extras.getString("tl_id_user");
            tl_img_url = extras.getString("tl_img_url");
            tl_tag = extras.getString("tl_tag");
            tag_artikel = tl_tag;
            tl_type = extras.getString("tl_type");
            tl_username = extras.getString("tl_username");
            tl_userphoto = extras.getString("tl_userphoto");
        }
        namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        namalengkap = URLDecoder.decode(namalengkap);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e7));
        int j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        dialog = (TextView)findViewById(i);
        dialog.setSelected(true);
        dialog.setTextColor(Color.parseColor("#FFFFFF"));
        dialog.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Kirim artikel</font>"));
        wrapper = new ContextThemeWrapper(this, 0x103006e);
        txtKategori = (TextView)findViewById(0x7f0b05b2);
        txtLabel_artikel = (TextView)findViewById(0x7f0b05b0);
        imgAskHp = (ImageView)findViewById(0x7f0b051a);
        edtJudulAskHp = (EditText)findViewById(0x7f0b05a7);
        edtPertanyaan = (EditText)findViewById(0x7f0b05a8);
        edtPertanyaan.setHint("Isi artikel*");
        btnPostAskHp = (Button)findViewById(0x7f0b0520);
        btnSaveAskHp = (Button)findViewById(0x7f0b05a9);
        btnUpdateAskHp = (Button)findViewById(0x7f0b05bb);
        rgPilTagArtikel = (RadioGroup)findViewById(0x7f0b05b3);
        rbApp = (RadioButton)findViewById(0x7f0b05b5);
        rbGames = (RadioButton)findViewById(0x7f0b05b6);
        rbUmum = (RadioButton)findViewById(0x7f0b05b4);
        rbHack = (RadioButton)findViewById(0x7f0b05b9);
        rbTips = (RadioButton)findViewById(0x7f0b05b7);
        rbTips.setText("Tips & Trik");
        rbHack.setText("Hack & modding");
        rbAksesoris = (RadioButton)findViewById(0x7f0b05ba);
        rbOSFirm = (RadioButton)findViewById(0x7f0b05b8);
        rgPilTagArtikel.setVisibility(8);
        progbar_send = (SmoothProgressBar)findViewById(0x7f0b0519);
        progbar_send.setVisibility(8);
        if (userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            android.app.AlertDialog.Builder builder;
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
        if (!tl_type.equals("global")) goto _L2; else goto _L1
_L1:
        if (!tl_tag.equals("tanya") && !tl_tag.equals("katlain") && !tl_tag.equals("opini") && !tl_tag.equals("tipsumum")) goto _L4; else goto _L3
_L3:
        txtKategori.setVisibility(0);
        if (tl_tag.equals("tanya"))
        {
            txtKategori.setText("Tanya umum");
        } else
        if (tl_tag.equals("katlain"))
        {
            txtKategori.setText("Kategori : Kategori lain");
        } else
        if (tl_tag.equals("opini"))
        {
            txtKategori.setText("Kategori : Opini");
        } else
        if (tl_tag.equals("tipsumum"))
        {
            txtKategori.setText("Kategori : Tips & trik umum");
        } else
        {
            txtKategori.setVisibility(8);
        }
_L25:
        tag_artikel = tl_tag;
_L17:
        if (post_action.equals("edit"))
        {
            btnUpdateAskHp.setVisibility(0);
            btnPostAskHp.setVisibility(8);
        } else
        {
            btnUpdateAskHp.setVisibility(8);
            btnPostAskHp.setVisibility(0);
        }
        rgPilTagArtikel.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            final RoomPostArtikel this$0;

            public void onCheckedChanged(RadioGroup radiogroup, int k)
            {
                if (rbApp.isChecked())
                {
                    tag_artikel = "apps";
                } else
                if (rbGames.isChecked())
                {
                    tag_artikel = "games";
                } else
                if (rbUmum.isChecked())
                {
                    tag_artikel = "umum";
                } else
                if (rbHack.isChecked())
                {
                    tag_artikel = "hack";
                } else
                if (rbTips.isChecked())
                {
                    tag_artikel = "tips";
                } else
                if (rbAksesoris.isChecked())
                {
                    tag_artikel = "aksesoris";
                } else
                if (rbOSFirm.isChecked())
                {
                    tag_artikel = "osfirm";
                } else
                {
                    tag_artikel = "";
                }
                if (rbAksesoris.isChecked())
                {
                    if (edtJudulAskHp.getText().length() > 2)
                    {
                        btnPostAskHp.setEnabled(true);
                        btnSaveAskHp.setEnabled(true);
                        btnUpdateAskHp.setEnabled(true);
                    } else
                    {
                        btnPostAskHp.setEnabled(false);
                        btnSaveAskHp.setEnabled(false);
                        btnUpdateAskHp.setEnabled(false);
                    }
                } else
                if (edtJudulAskHp.getText().length() > 2)
                {
                    btnPostAskHp.setEnabled(true);
                    btnSaveAskHp.setEnabled(true);
                    btnUpdateAskHp.setEnabled(true);
                } else
                {
                    btnPostAskHp.setEnabled(false);
                    btnSaveAskHp.setEnabled(false);
                    btnUpdateAskHp.setEnabled(false);
                }
                Log.e("tag_artikel", tag_artikel);
            }

            
            {
                this$0 = RoomPostArtikel.this;
                super();
            }
        });
        edtJudulAskHp.addTextChangedListener(new TextWatcher() {

            final RoomPostArtikel this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
                if (rbAksesoris.isChecked())
                {
                    if (edtJudulAskHp.getText().length() > 2)
                    {
                        btnPostAskHp.setEnabled(true);
                        btnSaveAskHp.setEnabled(true);
                        btnUpdateAskHp.setEnabled(true);
                        return;
                    } else
                    {
                        btnPostAskHp.setEnabled(false);
                        btnSaveAskHp.setEnabled(false);
                        btnUpdateAskHp.setEnabled(false);
                        return;
                    }
                }
                if (edtJudulAskHp.getText().length() > 2)
                {
                    btnPostAskHp.setEnabled(true);
                    btnSaveAskHp.setEnabled(true);
                    btnUpdateAskHp.setEnabled(true);
                    return;
                } else
                {
                    btnPostAskHp.setEnabled(false);
                    btnSaveAskHp.setEnabled(false);
                    btnUpdateAskHp.setEnabled(false);
                    return;
                }
            }

            
            {
                this$0 = RoomPostArtikel.this;
                super();
            }
        });
        edtPertanyaan.addTextChangedListener(new TextWatcher() {

            final RoomPostArtikel this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
                if (rbAksesoris.isChecked())
                {
                    if (edtJudulAskHp.getText().length() > 2)
                    {
                        btnPostAskHp.setEnabled(true);
                        btnSaveAskHp.setEnabled(true);
                        btnUpdateAskHp.setEnabled(true);
                        return;
                    } else
                    {
                        btnPostAskHp.setEnabled(false);
                        btnSaveAskHp.setEnabled(false);
                        btnUpdateAskHp.setEnabled(false);
                        return;
                    }
                }
                if (edtJudulAskHp.getText().length() > 2)
                {
                    btnPostAskHp.setEnabled(true);
                    btnSaveAskHp.setEnabled(true);
                    btnUpdateAskHp.setEnabled(true);
                    return;
                } else
                {
                    btnPostAskHp.setEnabled(false);
                    btnSaveAskHp.setEnabled(false);
                    btnUpdateAskHp.setEnabled(false);
                    return;
                }
            }

            
            {
                this$0 = RoomPostArtikel.this;
                super();
            }
        });
        dialog = new ArrayAdapter(this, 0x1090011, new String[] {
            "Dari Kamera", "Dari Galeri"
        });
        builder = new android.app.AlertDialog.Builder(wrapper);
        builder.setTitle("Pilih gambar");
        builder.setAdapter(dialog, new android.content.DialogInterface.OnClickListener() {

            final RoomPostArtikel this$0;

            public void onClick(DialogInterface dialoginterface, int k)
            {
                mFileTemp = createFolders();
                mFileTemp = getNextFileName();
                if (k == 0)
                {
                    takePicture();
                } else
                {
                    openGallery();
                }
                Log.e("startActivityForResult", String.valueOf(-1));
            }

            
            {
                this$0 = RoomPostArtikel.this;
                super();
            }
        });
        if (post_action.equals("edit"))
        {
            Picasso.with(this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(200).append("&src=").append(tl_img_url).toString()).into(imgAskHp, new Callback() {

                final RoomPostArtikel this$0;

                public void onError()
                {
                }

                public void onSuccess()
                {
                }

            
            {
                this$0 = RoomPostArtikel.this;
                super();
            }
            });
        }
        dialog = builder.create();
        imgAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPostArtikel this$0;
            private final AlertDialog val$dialog;

            public void onClick(View view)
            {
                dialog.show();
            }

            
            {
                this$0 = RoomPostArtikel.this;
                dialog = alertdialog;
                super();
            }
        });
        btnSaveAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPostArtikel this$0;

            public void onClick(View view)
            {
                DatabaseHandler databasehandler;
                String s;
                String s1;
                String s2;
                if (!db.checkARTJudulIfExist(curtime, edtJudulAskHp.getText().toString()))
                {
                    break MISSING_BLOCK_LABEL_145;
                }
                Toast.makeText(getApplicationContext(), "Berhasil memperbaharui", 1).show();
                databasehandler = db;
                s = curtime;
                s1 = edtJudulAskHp.getText().toString();
                s2 = tag_artikel;
                if (photo_upload == null)
                {
                    view = "";
                    break MISSING_BLOCK_LABEL_106;
                }
                view = path_image;
                  goto _L1
                Toast.makeText(getApplicationContext(), "Berhasil menyimpan", 1).show();
                databasehandler = db;
                s = id_hp;
                s1 = codename;
                s2 = edtJudulAskHp.getText().toString();
                s3 = tag_artikel;
                if (photo_upload != null)
                {
                    break MISSING_BLOCK_LABEL_270;
                }
                view = "";
_L2:
                databasehandler.addArtUser(s, s1, "artikel", s2, s3, view, edtPertanyaan.getText().toString(), "", curtime);
                return;
_L1:
                String s3;
                try
                {
                    databasehandler.update_byARTID(s, s1, s2, view, edtPertanyaan.getText().toString(), "");
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
                this$0 = RoomPostArtikel.this;
                super();
            }
        });
        btnPostAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPostArtikel this$0;

            public void onClick(View view)
            {
                if (netInfo != null && netInfo.isConnected())
                {
                    btnPostAskHp.setEnabled(false);
                    if (tag_artikel.equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "Kategori artikel belum dipilih", 1).show();
                        return;
                    }
                    if (photo_upload == null)
                    {
                        Log.e("photo", "not");
                        view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                        notif_id = Integer.parseInt(view);
                        mNotifyManager = (NotificationManager)getSystemService("notification");
                        mBuilder = new android.support.v4.app.NotificationCompat.Builder(RoomPostArtikel.this);
                        mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Mengirim artikel... - 0%").setSmallIcon(0x7f0201e4);
                        try
                        {
                            SendPertanyaan(id_hp, user_id, URLEncoder.encode(edtJudulAskHp.getText().toString(), "utf-8"), URLEncoder.encode(edtPertanyaan.getText().toString(), "utf-8"), str_img_url, t);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            view.printStackTrace();
                        }
                        return;
                    }
                    if (tag_artikel.equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "Kategori artikel belum dipilih", 1).show();
                        return;
                    }
                    Log.e("photo", "oke");
                    view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                    notif_id = Integer.parseInt(view);
                    mNotifyManager = (NotificationManager)getSystemService("notification");
                    mBuilder = new android.support.v4.app.NotificationCompat.Builder(RoomPostArtikel.this);
                    mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Mengirim artikel... - 0%").setSmallIcon(0x7f0201e4);
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
                this$0 = RoomPostArtikel.this;
                super();
            }
        });
        btnUpdateAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPostArtikel this$0;

            public void onClick(View view)
            {
                if (netInfo != null && netInfo.isConnected())
                {
                    btnPostAskHp.setEnabled(false);
                    if (tag_artikel.equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "Kategori artikel belum dipilih", 1).show();
                        return;
                    }
                    if (photo_upload == null)
                    {
                        Log.e("photo", "not");
                        view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                        notif_id = Integer.parseInt(view);
                        mNotifyManager = (NotificationManager)getSystemService("notification");
                        mBuilder = new android.support.v4.app.NotificationCompat.Builder(RoomPostArtikel.this);
                        mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Memperbarui artikel... - 0%").setSmallIcon(0x7f0201e4);
                        try
                        {
                            SendPertanyaan(id_hp, user_id, URLEncoder.encode(edtJudulAskHp.getText().toString(), "utf-8"), URLEncoder.encode(edtPertanyaan.getText().toString(), "utf-8"), str_img_url, t);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            view.printStackTrace();
                        }
                        return;
                    }
                    if (tag_artikel.equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "Kategori artikel belum dipilih", 1).show();
                        return;
                    }
                    Log.e("photo", "oke");
                    view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                    notif_id = Integer.parseInt(view);
                    mNotifyManager = (NotificationManager)getSystemService("notification");
                    mBuilder = new android.support.v4.app.NotificationCompat.Builder(RoomPostArtikel.this);
                    mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Memperbarui artikel... - 0%").setSmallIcon(0x7f0201e4);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new UploadImage(null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new UploadImage(null)).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    Toast.makeText(getApplicationContext(), "Tidak ada koneksi internet", 1).show();
                    return;
                }
            }

            
            {
                this$0 = RoomPostArtikel.this;
                super();
            }
        });
        if (!str_from.equals("notif")) goto _L6; else goto _L5
_L5:
        dialog = extras.getString("id_date");
        curtime = dialog;
        if (!db.checkArtIfExist(dialog)) goto _L6; else goto _L7
_L7:
        cursor = db.getARTID(dialog);
        cursor.moveToFirst();
        id_hp = cursor.getString(1);
        edtJudulAskHp.setText(cursor.getString(4));
        edtPertanyaan.setText(cursor.getString(7));
        if (!cursor.getString(5).equals("apps")) goto _L9; else goto _L8
_L8:
        rbApp.setChecked(true);
_L18:
        if (cursor.getString(6).equals("")) goto _L6; else goto _L10
_L10:
        dialog = new File(cursor.getString(6));
        if (!dialog.exists()) goto _L12; else goto _L11
_L11:
        dialog = BitmapFactory.decodeFile(dialog.getAbsolutePath());
        imgAskHp.setImageBitmap(dialog);
_L6:
        if (!post_action.equals("edit")) goto _L14; else goto _L13
_L13:
        edtJudulAskHp.setText(tl_judul);
        tl_content = Html.fromHtml(tl_content).toString();
        edtPertanyaan.setText(tl_content);
        if (!tl_img_url.equals(""))
        {
            imageLoader2.displayImage(tl_img_url.trim(), imgAskHp, options, animateFirstListener);
        }
        if (!tl_tag.equals("apps")) goto _L16; else goto _L15
_L15:
        rbApp.setChecked(true);
_L23:
        return;
_L4:
        txtKategori.setVisibility(0);
        dialog = tl_tag.replace("android,", "Android, ").replace("windowsphone,", "Windows Phone, ").replace("ios,", "IOS, ").replace("blackberry,", "Blackberry, ");
        dialog = dialog.substring(0, dialog.length() - 2).replace(",", ", ");
        tl_tag = tl_tag.replaceAll(",$", "");
        Log.e("tl_tag", tl_tag);
        tag_artikel = tl_tag;
        txtKategori.setText((new StringBuilder("Kategori : ")).append(dialog).toString());
          goto _L17
_L2:
        txtKategori.setVisibility(8);
          goto _L17
_L9:
label0:
        {
            if (!cursor.getString(5).equals("games"))
            {
                break label0;
            }
            rbGames.setChecked(true);
        }
          goto _L18
label1:
        {
            if (!cursor.getString(5).equals("umum"))
            {
                break label1;
            }
            rbUmum.setChecked(true);
        }
          goto _L18
label2:
        {
            if (!cursor.getString(5).equals("hack"))
            {
                break label2;
            }
            rbHack.setChecked(true);
        }
          goto _L18
label3:
        {
            if (!cursor.getString(5).equals("tips"))
            {
                break label3;
            }
            rbTips.setChecked(true);
        }
          goto _L18
        if (!cursor.getString(5).equals("aksesoris")) goto _L20; else goto _L19
_L19:
        rbAksesoris.setChecked(true);
          goto _L18
_L20:
        if (!cursor.getString(5).equals("osfirm")) goto _L18; else goto _L21
_L21:
        rbOSFirm.setChecked(true);
          goto _L18
_L12:
        try
        {
            imgAskHp.setImageResource(0x7f020073);
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
        }
          goto _L6
_L16:
        if (tl_tag.equals("games"))
        {
            rbGames.setChecked(true);
            return;
        }
        if (tl_tag.equals("umum"))
        {
            rbUmum.setChecked(true);
            return;
        }
        if (tl_tag.equals("hack"))
        {
            rbHack.setChecked(true);
            return;
        }
        if (tl_tag.equals("tips"))
        {
            rbTips.setChecked(true);
            return;
        }
        if (tl_tag.equals("aksesoris"))
        {
            rbAksesoris.setChecked(true);
            return;
        }
        if (!tl_tag.equals("osfirm")) goto _L23; else goto _L22
_L22:
        rbOSFirm.setChecked(true);
        return;
_L14:
        if (tl_tag.equals("apps"))
        {
            txtLabel_artikel.setText("Artikel Aplikasi");
            rbApp.setChecked(true);
            return;
        }
        if (tl_tag.equals("games"))
        {
            txtLabel_artikel.setText("Artikel Games");
            rbGames.setChecked(true);
            return;
        }
        if (tl_tag.equals("umum"))
        {
            txtLabel_artikel.setText("Artikel Topik Umum");
            rbUmum.setChecked(true);
            return;
        }
        if (tl_tag.equals("hack"))
        {
            txtLabel_artikel.setText("Artikel Hack");
            rbHack.setChecked(true);
            return;
        }
        if (tl_tag.equals("tips"))
        {
            txtLabel_artikel.setText("Artikel Tips & Trik");
            rbTips.setChecked(true);
            return;
        }
        if (tl_tag.equals("aksesoris"))
        {
            txtLabel_artikel.setText("Artikel Aksesoris");
            rbAksesoris.setChecked(true);
            return;
        }
        if (tl_tag.equals("osfirm"))
        {
            rbOSFirm.setChecked(true);
            return;
        }
        txtLabel_artikel.setVisibility(8);
        return;
        if (true) goto _L25; else goto _L24
_L24:
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
