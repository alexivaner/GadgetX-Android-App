// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

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
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.inponsel.android.utils.InternalStorageContentProvider;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.RoomMyDraftPost;
import com.readystatesoftware.systembartint.SystemBarTintManager;
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

public class ConversationPost extends SherlockFragmentActivity
    implements Observer
{
    public class SendMailTask extends AsyncTask
    {

        final ConversationPost this$0;

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
            this$0 = ConversationPost.this;
            super();
        }
    }

    private class UploadImage extends AsyncTask
    {

        final ConversationPost this$0;

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
                mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setOngoing(true).setContentText((new StringBuilder("Mengirim conversation... - ")).append(String.valueOf(99)).append("%").toString()).setSmallIcon(0x7f0201e4);
            } else
            {
                mBuilder.setProgress(99, ainteger[0].intValue(), false);
                mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setOngoing(true).setContentText((new StringBuilder("Mengirim conversation... - ")).append(String.valueOf(ainteger[0])).append("%").toString()).setSmallIcon(0x7f0201e4);
            }
            mNotifyManager.notify(notif_id, mBuilder.build());
        }

        protected volatile transient void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((Integer[])aobj);
        }



        private UploadImage()
        {
            this$0 = ConversationPost.this;
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
    Button btnPostAskHp;
    Button btnSaveAskHp;
    ConnectivityManager cm;
    String codename;
    Cursor cursor;
    String curtime;
    DatabaseHandler db;
    EditText edtJudulAskHp;
    EditText edtPertanyaan;
    String email_user;
    Bundle extras;
    String filePath;
    String gambar;
    String id_hp;
    ImageView imgAskHp;
    String insert_id;
    InputStream is;
    String json_response;
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
    String path_image;
    Bitmap photo_upload;
    PonselBaseApp ponselBaseApp;
    SmoothProgressBar progbar_send;
    String resp;
    String str_from;
    String str_img_url;
    String success_stat;
    String t;
    long totalSize;
    TextView txtLabelWajib;
    String type;
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

    public ConversationPost()
    {
        str_img_url = "";
        filePath = "";
        notif_id = 1;
        now = Calendar.getInstance();
        totalSize = 0L;
        urlEmailNotif = "";
        success_stat = "";
        message_stat = "";
        insert_id = "";
        json_response = "";
        path_image = "";
        curtime = "";
        type = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        t = Utility.session(RestClient.pelihara);
        user_photo = "";
        username = "";
    }

    private void SendPertanyaan(String s, String s1, String s2, String s3, String s4, String s5)
    {
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_conversation").append(Utility.BASE_FORMAT).append("?idhp=").append(s).append("&iduser=").append(s1).append("&title=").append(s2).append("&codename=").append(codename).append("&ask=").append(s3).append("&img=").append(s4).append("&t=").append(s5).append("&type=").append("conversation").toString();
        Log.e("urlSend", s);
        showSmoothProgress();
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final ConversationPost this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSONSendMessage(jsonobject.toString());
                json_response = jsonobject.toString();
                hideSmoothProgress();
            }

            
            {
                this$0 = ConversationPost.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ConversationPost this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideSmoothProgress();
            }

            
            {
                this$0 = ConversationPost.this;
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
            if (progbar_send.getVisibility() == 0)
            {
                progbar_send.setVisibility(8);
                progbar_send.setVisibility(8);
                if (!success_stat.equals("1"))
                {
                    break label0;
                }
                Log.e("urlEmailNotifsuc", urlEmailNotif);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new SendMailTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else
                {
                    (new SendMailTask()).execute(new Void[0]);
                }
                db.delete_byARTID(curtime, edtJudulAskHp.getText().toString());
                notifBerhasil();
                setResult(-1, (new Intent()).putExtra("jsonKom", json_response));
                finish();
            }
            return;
        }
        Log.e("post", "gagal");
        btnPostAskHp.setEnabled(true);
        notifGagal();
        DatabaseHandler databasehandler;
        String s;
        String s1;
        if (!db.checkARTJudulIfExist(curtime, edtJudulAskHp.getText().toString()))
        {
            break MISSING_BLOCK_LABEL_308;
        }
        Toast.makeText(getApplicationContext(), "Berhasil memperbaharui", 1).show();
        databasehandler = db;
        s = curtime;
        s1 = edtJudulAskHp.getText().toString();
        if (photo_upload != null)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        Object obj = "";
_L1:
        try
        {
            databasehandler.update_byARTID(s, s1, "0", ((String) (obj)), edtPertanyaan.getText().toString(), "");
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
        String s2;
        databasehandler = db;
        s = id_hp;
        s1 = codename;
        s2 = edtJudulAskHp.getText().toString();
        if (photo_upload != null)
        {
            break MISSING_BLOCK_LABEL_383;
        }
        obj = "";
_L3:
        databasehandler.addArtUser(s, s1, "conversation", s2, "0", ((String) (obj)), edtPertanyaan.getText().toString(), "", curtime);
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
        mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Berhasil mengirim conversation").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(pendingintent).setAutoCancel(true);
        mNotifyManager.notify(notif_id, mBuilder.build());
    }

    public void notifGagal()
    {
        Object obj = new Intent();
        ((Intent) (obj)).setClass(getApplicationContext(), com/inponsel/android/v2/RoomMyDraftPost);
        obj = PendingIntent.getActivity(this, 0, ((Intent) (obj)), 0x10000000);
        mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Gagal mengirim conversation").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(((PendingIntent) (obj))).setAutoCancel(true);
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
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        dialog = new SystemBarTintManager(this);
        dialog.setStatusBarTintEnabled(true);
        dialog.setStatusBarTintResource(0x7f08018d);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        extras = getIntent().getExtras();
        id_hp = String.valueOf((int)(System.currentTimeMillis() % 0x7fffffffL));
        str_from = extras.getString("from");
        codename = "";
        model = "";
        merk = "";
        type = "conversation";
        namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        namalengkap = URLDecoder.decode(namalengkap);
        t = Utility.session(t);
        t = Utility.session(t);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e6));
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
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
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Conversation Post</font>"));
        curtime = (new SimpleDateFormat("MMddHHmmss")).format(new Date());
        wrapper = new ContextThemeWrapper(this, 0x103006e);
        imgAskHp = (ImageView)findViewById(0x7f0b051a);
        edtJudulAskHp = (EditText)findViewById(0x7f0b05a7);
        edtPertanyaan = (EditText)findViewById(0x7f0b05a8);
        btnPostAskHp = (Button)findViewById(0x7f0b0520);
        btnSaveAskHp = (Button)findViewById(0x7f0b05a9);
        edtPertanyaan.setHint("Isi konten");
        txtLabelWajib = (TextView)findViewById(0x7f0b05b1);
        progbar_send = (SmoothProgressBar)findViewById(0x7f0b0519);
        progbar_send.setVisibility(8);
        dialog = new ArrayAdapter(this, 0x1090011, new String[] {
            "Dari Kamera", "Dari Galeri"
        });
        builder = new android.app.AlertDialog.Builder(wrapper);
        builder.setTitle("Pilih gambar");
        builder.setAdapter(dialog, new android.content.DialogInterface.OnClickListener() {

            final ConversationPost this$0;

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
                this$0 = ConversationPost.this;
                super();
            }
        });
        dialog = builder.create();
        imgAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationPost this$0;
            private final AlertDialog val$dialog;

            public void onClick(View view)
            {
                dialog.show();
            }

            
            {
                this$0 = ConversationPost.this;
                dialog = alertdialog;
                super();
            }
        });
        btnSaveAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationPost this$0;

            public void onClick(View view)
            {
                DatabaseHandler databasehandler;
                String s;
                String s1;
                if (!db.checkARTJudulIfExist(curtime, edtJudulAskHp.getText().toString()))
                {
                    break MISSING_BLOCK_LABEL_136;
                }
                Toast.makeText(getApplicationContext(), "Berhasil memperbaharui", 1).show();
                databasehandler = db;
                s = curtime;
                s1 = edtJudulAskHp.getText().toString();
                if (photo_upload == null)
                {
                    view = "";
                    break MISSING_BLOCK_LABEL_97;
                }
                view = path_image;
                  goto _L1
                Toast.makeText(getApplicationContext(), "Berhasil menyimpan", 1).show();
                databasehandler = db;
                s = id_hp;
                s1 = codename;
                s2 = edtJudulAskHp.getText().toString();
                if (photo_upload != null)
                {
                    break MISSING_BLOCK_LABEL_252;
                }
                view = "";
_L2:
                databasehandler.addArtUser(s, s1, "conversation", s2, "0", view, edtPertanyaan.getText().toString(), "", curtime);
                return;
_L1:
                String s2;
                try
                {
                    databasehandler.update_byARTID(s, s1, "0", view, edtPertanyaan.getText().toString(), "");
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
                this$0 = ConversationPost.this;
                super();
            }
        });
        btnPostAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final ConversationPost this$0;

            public void onClick(View view)
            {
                if (photo_upload == null)
                {
                    Log.e("photo", "not");
                    view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                    notif_id = Integer.parseInt(view);
                    mNotifyManager = (NotificationManager)getSystemService("notification");
                    mBuilder = new android.support.v4.app.NotificationCompat.Builder(ConversationPost.this);
                    mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Mengirim conversation... - 0%").setSmallIcon(0x7f0201e4);
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
                Log.e("photo", "oke");
                view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                notif_id = Integer.parseInt(view);
                mNotifyManager = (NotificationManager)getSystemService("notification");
                mBuilder = new android.support.v4.app.NotificationCompat.Builder(ConversationPost.this);
                mBuilder.setContentTitle(edtJudulAskHp.getText().toString()).setContentText("Mengirim conversation... - 0%").setSmallIcon(0x7f0201e4);
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
            }

            
            {
                this$0 = ConversationPost.this;
                super();
            }
        });
        edtJudulAskHp.addTextChangedListener(new TextWatcher() {

            final ConversationPost this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
                if (edtJudulAskHp.getText().length() > 5)
                {
                    btnPostAskHp.setEnabled(true);
                    btnSaveAskHp.setEnabled(true);
                    return;
                } else
                {
                    btnPostAskHp.setEnabled(false);
                    btnSaveAskHp.setEnabled(false);
                    return;
                }
            }

            
            {
                this$0 = ConversationPost.this;
                super();
            }
        });
        edtPertanyaan.addTextChangedListener(new TextWatcher() {

            final ConversationPost this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
                if (edtJudulAskHp.getText().length() > 5)
                {
                    btnPostAskHp.setEnabled(true);
                    btnSaveAskHp.setEnabled(true);
                    return;
                } else
                {
                    btnPostAskHp.setEnabled(false);
                    btnSaveAskHp.setEnabled(false);
                    return;
                }
            }

            
            {
                this$0 = ConversationPost.this;
                super();
            }
        });
        if (!str_from.equals("notif"))
        {
            break MISSING_BLOCK_LABEL_1138;
        }
        dialog = extras.getString("id_date");
        curtime = dialog;
        if (!db.checkArtIfExist(dialog))
        {
            break MISSING_BLOCK_LABEL_1138;
        }
        cursor = db.getARTID(dialog);
        cursor.moveToFirst();
        id_hp = cursor.getString(1);
        edtJudulAskHp.setText(cursor.getString(4));
        edtPertanyaan.setText(cursor.getString(6));
        if (cursor.getString(3).equals(""))
        {
            break MISSING_BLOCK_LABEL_1138;
        }
        dialog = new File(cursor.getString(5));
        if (dialog.exists())
        {
            dialog = BitmapFactory.decodeFile(dialog.getAbsolutePath());
            imgAskHp.setImageBitmap(dialog);
            return;
        }
        try
        {
            imgAskHp.setImageResource(0x7f020073);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
        }
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

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            finish();
            break;
        }
        overridePendingTransition(0x7f040001, 0x7f040002);
        return true;
    }

    public void update(Observable observable, Object obj)
    {
    }













}
