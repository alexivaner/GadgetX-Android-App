// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.AndroidMultiPartEntity;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
import com.inponsel.android.utils.Base64;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.InternalStorageContentProvider;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.DroidWriterEditText;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import eu.janmuller.android.simplecropimage.CropImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
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
//            RoomMyDraftPost, ImagePagerActivity, ProfileOtherUser

public class SCReplyFormActivity extends SherlockFragmentActivity
    implements Observer
{
    private static class EmoticonAdapter extends BaseAdapter
    {

        private LayoutInflater mLayoutInflater;

        public int getCount()
        {
            return SCReplyFormActivity.emotname.length;
        }

        public Object getItem(int j)
        {
            return Integer.valueOf(j);
        }

        public long getItemId(int j)
        {
            return (long)j;
        }

        public View getView(int j, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = mLayoutInflater.inflate(0x7f0300bc, viewgroup, false);
                viewgroup = new ViewHolder();
                viewgroup.mImageView = (ImageView)view.findViewById(0x7f0b0631);
                viewgroup.mTextView = (TextView)view.findViewById(0x7f0b0632);
                ((ViewHolder) (viewgroup)).mTextView.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
                ((ViewHolder) (viewgroup)).mImageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                ((ViewHolder) (viewgroup)).mImageView.setPadding(8, 8, 8, 8);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            ((ViewHolder) (viewgroup)).mTextView.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            ((ViewHolder) (viewgroup)).mTextView.setFocusable(false);
            ((ViewHolder) (viewgroup)).mTextView.setText(SCReplyFormActivity.emotname[j]);
            return view;
        }

        public EmoticonAdapter(Context context)
        {
            mLayoutInflater = LayoutInflater.from(context);
        }
    }

    public class PostKomen extends AsyncTask
    {

        final SCReplyFormActivity this$0;

        private void parseJSONKom(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatus = s.getString("success");
                postMessage = s.getString("message");
                Log.e("postStatus", postStatus);
                if (postStatus.equals("1"))
                {
                    top_id = s.getString("top_id");
                }
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_repkom_sc").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                jsonKom = avoid.toString();
                parseJSONKom(res);
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
            btn_send_komen.setEnabled(true);
            edt_pop_komen.setEnabled(true);
            if (postStatus.equals("1"))
            {
                ponselBaseApp.getObserver().setUpdateType("komentarsc");
                ponselBaseApp.getObserver().setStatus_like_ponsel("-");
                edt_pop_komen.setText("");
                notifBerhasil();
                (new SendMailSCTask()).execute(new Void[0]);
                finish();
                return;
            }
            if (postStatus.equals("040"))
            {
                notifGagal();
                void1 = new android.app.AlertDialog.Builder(ctw);
                void1.setMessage(postMessage);
                void1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                    final PostKomen this$1;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = PostKomen.this;
                super();
            }
                });
                void1.show();
                return;
            } else
            {
                notifGagal();
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
            btn_send_komen.setEnabled(false);
            edt_pop_komen.setEnabled(false);
        }

        public PostKomen()
        {
            this$0 = SCReplyFormActivity.this;
            super();
        }
    }

    public class SendMailSCTask extends AsyncTask
    {

        final SCReplyFormActivity this$0;

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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_tanggap_sc").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
                Log.e("pushURLemail", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                res = res.trim();
                res = res.replaceAll("\\s+", "");
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

        public SendMailSCTask()
        {
            this$0 = SCReplyFormActivity.this;
            super();
        }
    }

    private class UploadImage extends AsyncTask
    {

        final SCReplyFormActivity this$0;

        private String uploadFile()
        {
            Log.e("Uploadk", "uploadFile");
            Object obj = new DefaultHttpClient();
            Object obj1 = new HttpPost((new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("upload_develop").append(".php").append("?id_from=").append(user_id).toString());
            int j;
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
                j = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
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
            if (j != 200)
            {
                break MISSING_BLOCK_LABEL_177;
            }
            obj = EntityUtils.toString(((org.apache.http.HttpEntity) (obj1))).trim();
            resp = ((String) (obj));
            return ((String) (obj));
            obj = (new StringBuilder("Error occurred! Http Status Code: ")).append(j).toString();
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
                    querypopkomen = (new StringBuilder("idsc=")).append(id_sc).append("&idusr=").append(user_id).append("&kom=").append(s).append("&rplto=").append(parentidkomen).append("&top_id=").append(top_id).append("&t=").append(t).append("&img=").append(resp).toString();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                }
                (new PostKomen()).execute(new Void[0]);
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
            mBuilder.setProgress(99, 0, false);
            mNotifyManager.notify(notif_id, mBuilder.build());
        }

        protected transient void onProgressUpdate(Integer ainteger[])
        {
            if (ainteger[0].intValue() == 100)
            {
                mBuilder.setProgress(99, 99, false);
                mBuilder.setContentTitle("InPonsel").setOngoing(true).setContentText((new StringBuilder("Mengirim komentar... - ")).append(String.valueOf(99)).append("%").toString()).setSmallIcon(0x7f0201e4);
            } else
            {
                mBuilder.setProgress(99, ainteger[0].intValue(), false);
                mBuilder.setContentTitle("InPonsel").setOngoing(true).setContentText((new StringBuilder("Mengunggah gambar... - ")).append(String.valueOf(ainteger[0])).append("%").toString()).setSmallIcon(0x7f0201e4);
            }
            mNotifyManager.notify(notif_id, mBuilder.build());
        }

        protected volatile transient void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((Integer[])aobj);
        }



        private UploadImage()
        {
            this$0 = SCReplyFormActivity.this;
            super();
        }

        UploadImage(UploadImage uploadimage)
        {
            this();
        }
    }

    static class ViewHolder
    {

        ImageView mImageView;
        TextView mTextView;

        ViewHolder()
        {
        }
    }


    private static final String FOLDER_NAME = "InPonsel";
    public static final int REQUEST_CODE_CROP_IMAGE = 3;
    public static final int REQUEST_CODE_GALLERY = 1;
    public static final int REQUEST_CODE_TAKE_PICTURE = 2;
    public static final String TEMP_PHOTO_FILE_NAME = (new StringBuilder("inponsel_")).append(System.currentTimeMillis()).append(".jpg").toString();
    public static final String emotname[] = {
        "ae003j", "ae004j", "ae005j", "ae006j", "ae007j", "ae008j", "ae009j", "ae0013j", "ae0014j", "ae0015j", 
        "ae0019j", "ae0020j", "ae0021j", "ae0022j"
    };
    ActionBar actionBar;
    int actionBarTitleId;
    private ImageLoadingListener animateFirstListener;
    Button btn_komen_pic;
    Button btn_pop_emot;
    Button btn_pop_login;
    Button btn_send_komen;
    Calendar c;
    int charCount;
    ContextThemeWrapper ctw;
    Cursor cursor;
    int day;
    DatabaseHandler db;
    DroidWriterEditText edt_pop_komen;
    String email_tanggap;
    String email_user;
    Bundle extras;
    String filePath;
    Intent i;
    String id_sc;
    String idkomen;
    ImageLoader imageLoader2;
    ImageView imgAskHp;
    ImageView imgHpDetail;
    ImageView img_tanggap_picture;
    String isikomentar;
    String jsonKom;
    RelativeLayout lay_button_emot;
    GridView listEmot;
    private android.support.v4.app.NotificationCompat.Builder mBuilder;
    private File mFileTemp;
    private NotificationManager mNotifyManager;
    ProgressBar menu_progressbar_item;
    int month;
    String nama_asli;
    int notif_id;
    Calendar now;
    private DisplayImageOptions options;
    String parentidkomen;
    String path_image;
    Bitmap photo_upload;
    PonselBaseApp ponselBaseApp;
    TextView pop_txtCountKomen;
    TextView pop_txt_empty;
    String postMessage;
    String postStatus;
    ProgressBar progressbar_item;
    String querypopkomen;
    String res;
    String resp;
    RelativeLayout rl_add_image;
    String sc_merk;
    String sc_nama;
    String str_img_url;
    String t;
    String tanggal;
    TextView titleDaftarHP;
    String top_id;
    long totalSize;
    TextViewFixTouchConsume txtKomentar;
    TextView txtUsername;
    TextView txtWaktu;
    private boolean useLogo;
    UserFunctions userFunctions;
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
    String userkomen;
    String username;
    String userpict;
    int year;

    public SCReplyFormActivity()
    {
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        t = Utility.session(RestClient.pelihara);
        postStatus = "";
        postMessage = "";
        querypopkomen = "";
        jsonKom = "";
        user_photo = "";
        username = "";
        animateFirstListener = new AnimateFirstDisplayListener();
        ctw = new ContextThemeWrapper(this, 0x7f0d0055);
        path_image = "";
        resp = "-";
        str_img_url = "-";
        filePath = "";
        notif_id = 1;
        now = Calendar.getInstance();
        totalSize = 0L;
    }

    public static void copyStream(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[] = new byte[1024];
        do
        {
            int j = inputstream.read(abyte0);
            if (j == -1)
            {
                return;
            }
            outputstream.write(abyte0, 0, j);
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

    private void openGallery()
    {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    private void showPickerImagePopUp()
    {
        ArrayAdapter arrayadapter = new ArrayAdapter(this, 0x1090011, new String[] {
            "Dari Kamera", "Dari Galeri"
        });
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ctw);
        builder.setTitle("Pilih gambar");
        builder.setAdapter(arrayadapter, new android.content.DialogInterface.OnClickListener() {

            final SCReplyFormActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                mFileTemp = createFolders();
                mFileTemp = getNextFileName();
                if (j == 0)
                {
                    takePicture();
                } else
                {
                    openGallery();
                }
                Log.e("startActivityForResult", String.valueOf(-1));
            }

            
            {
                this$0 = SCReplyFormActivity.this;
                super();
            }
        });
        builder.create().show();
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

    public boolean hasFocusable()
    {
        return false;
    }

    public void notifBerhasil()
    {
        PendingIntent pendingintent = PendingIntent.getActivity(this, 0, new Intent(), 0x10000000);
        mBuilder.setContentTitle("InPonsel").setContentText("Berhasil membalas komentar").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(pendingintent).setAutoCancel(true);
        mNotifyManager.notify(notif_id, mBuilder.build());
        (new Handler()).postDelayed(new Runnable() {

            final SCReplyFormActivity this$0;

            public void run()
            {
                mNotifyManager.cancel(notif_id);
            }

            
            {
                this$0 = SCReplyFormActivity.this;
                super();
            }
        }, 3000L);
    }

    public void notifGagal()
    {
        Object obj = new Intent();
        ((Intent) (obj)).setClass(getApplicationContext(), com/inponsel/android/v2/RoomMyDraftPost);
        obj = PendingIntent.getActivity(this, 0, ((Intent) (obj)), 0x10000000);
        mBuilder.setContentTitle("InPonsel").setContentText("Gagal Mengirim komentar").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(((PendingIntent) (obj))).setAutoCancel(true);
        mNotifyManager.notify(notif_id, mBuilder.build());
    }

    public void onActivityResult(int j, int k, Intent intent)
    {
        if (k == -1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        j;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 40
    //                   2 95
    //                   3 102;
           goto _L3 _L4 _L5 _L6
_L3:
        super.onActivityResult(j, k, intent);
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

    public void onBackPressed()
    {
        Log.e("vis", "off");
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300d4);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        btn_komen_pic = (Button)findViewById(0x7f0b053a);
        rl_add_image = (RelativeLayout)findViewById(0x7f0b067f);
        lay_button_emot = (RelativeLayout)findViewById(0x7f0b04db);
        imgAskHp = (ImageView)findViewById(0x7f0b051a);
        btn_komen_pic.setOnClickListener(new android.view.View.OnClickListener() {

            final SCReplyFormActivity this$0;

            public void onClick(View view)
            {
                rl_add_image.setVisibility(0);
                lay_button_emot.setVisibility(8);
            }

            
            {
                this$0 = SCReplyFormActivity.this;
                super();
            }
        });
        imgAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final SCReplyFormActivity this$0;

            public void onClick(View view)
            {
                mFileTemp = createFolders();
                mFileTemp = getNextFileName();
                openGallery();
                Log.e("startActivityForResult", String.valueOf(-1));
            }

            
            {
                this$0 = SCReplyFormActivity.this;
                super();
            }
        });
        int j;
        int k;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Tanggapan Komentar SC");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        extras = getIntent().getExtras();
        id_sc = extras.getString("id_sc");
        parentidkomen = extras.getString("idkomen");
        userkomen = extras.getString("userkomen");
        isikomentar = extras.getString("isikomentar");
        top_id = extras.getString("top_id");
        tanggal = extras.getString("tanggal");
        sc_nama = extras.getString("sc_nama");
        sc_merk = extras.getString("sc_merk");
        Log.e("top_id", top_id);
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        k = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        j = k;
        if (k == 0)
        {
            j = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(j);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        txtUsername = (TextView)findViewById(0x7f0b0419);
        txtKomentar = (TextViewFixTouchConsume)findViewById(0x7f0b054e);
        txtWaktu = (TextView)findViewById(0x7f0b054c);
        pop_txtCountKomen = (TextView)findViewById(0x7f0b04df);
        t = Utility.session(t);
        btn_send_komen = (Button)findViewById(0x7f0b04e0);
        btn_pop_login = (Button)findViewById(0x7f0b04e1);
        btn_pop_emot = (Button)findViewById(0x7f0b04dc);
        progressbar_item = (ProgressBar)findViewById(0x7f0b00b3);
        listEmot = (GridView)findViewById(0x7f0b0534);
        listEmot.setVisibility(8);
        img_tanggap_picture = (ImageView)findViewById(0x7f0b0681);
        edt_pop_komen = (DroidWriterEditText)findViewById(0x7f0b04de);
        edt_pop_komen.requestFocus();
        edt_pop_komen.setFocusable(true);
        listEmot.setAdapter(new EmoticonAdapter(this));
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        listEmot.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SCReplyFormActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                edt_pop_komen.setImageInsertGrid(SCReplyFormActivity.emotname[l]);
            }

            
            {
                this$0 = SCReplyFormActivity.this;
                super();
            }
        });
        menu_progressbar_item = (ProgressBar)findViewById(0x7f0b02a0);
        if (userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
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
        userpict = extras.getString("userpict");
        t = Utility.session(t);
        imageLoader2.displayImage(userpict.trim(), img_tanggap_picture, options, animateFirstListener);
        Log.e("ukom", (new StringBuilder(String.valueOf(userkomen))).append("\n").append(isikomentar).append("\n").append(tanggal).toString());
        txtUsername.setText(userkomen);
        txtWaktu.setText(Utility.convertDate(tanggal));
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(isikomentar)));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
        txtKomentar.setFocusable(false);
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(isikomentar)));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final SCReplyFormActivity this$0;

            public void onClick(View view)
            {
                if (photo_upload == null)
                {
                    if (imgAskHp.getVisibility() == 0)
                    {
                        btn_send_komen.setEnabled(false);
                        Log.e("photo", "oke");
                        view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                        notif_id = Integer.parseInt(view);
                        mNotifyManager = (NotificationManager)getSystemService("notification");
                        mBuilder = new android.support.v4.app.NotificationCompat.Builder(SCReplyFormActivity.this);
                        mBuilder.setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
                        try
                        {
                            view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                            querypopkomen = (new StringBuilder("idsc=")).append(id_sc).append("&idusr=").append(user_id).append("&kom=").append(view).append("&rplto=").append(parentidkomen).append("&top_id=").append(top_id).append("&t=").append(t).append("&img=").append(resp).toString();
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            view.printStackTrace();
                        }
                        (new PostKomen()).execute(new Void[0]);
                        return;
                    }
                    if (resp.contains(".jpg") || resp.contains(".jpeg"))
                    {
                        btn_send_komen.setEnabled(false);
                        Log.e("photo", "oke");
                        view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                        notif_id = Integer.parseInt(view);
                        mNotifyManager = (NotificationManager)getSystemService("notification");
                        mBuilder = new android.support.v4.app.NotificationCompat.Builder(SCReplyFormActivity.this);
                        mBuilder.setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
                        try
                        {
                            view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                            querypopkomen = (new StringBuilder("idsc=")).append(id_sc).append("&idusr=").append(user_id).append("&kom=").append(view).append("&rplto=").append(parentidkomen).append("&top_id=").append(top_id).append("&t=").append(t).append("&img=").append(resp).toString();
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            view.printStackTrace();
                        }
                        (new PostKomen()).execute(new Void[0]);
                        return;
                    }
                    try
                    {
                        view = URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8");
                        querypopkomen = (new StringBuilder("idsc=")).append(id_sc).append("&idusr=").append(user_id).append("&kom=").append(view).append("&rplto=").append(parentidkomen).append("&top_id=").append(top_id).append("&t=").append(t).append("&img=-").toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        view.printStackTrace();
                    }
                    Log.e("querypopkomen", querypopkomen);
                    view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                    notif_id = Integer.parseInt(view);
                    mNotifyManager = (NotificationManager)getSystemService("notification");
                    mBuilder = new android.support.v4.app.NotificationCompat.Builder(SCReplyFormActivity.this);
                    mBuilder.setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new PostKomen()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new PostKomen()).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                    notif_id = Integer.parseInt(view);
                    mNotifyManager = (NotificationManager)getSystemService("notification");
                    mBuilder = new android.support.v4.app.NotificationCompat.Builder(SCReplyFormActivity.this);
                    mBuilder.setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
                    (new UploadImage(null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                }
            }

            
            {
                this$0 = SCReplyFormActivity.this;
                super();
            }
        });
        edt_pop_komen.addTextChangedListener(new TextWatcher() {

            final SCReplyFormActivity this$0;

            public void afterTextChanged(Editable editable)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    charCount = 512 - edt_pop_komen.getText().toString().length();
                    pop_txtCountKomen.setText(String.valueOf(charCount));
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int l, int i1, int j1)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    charCount = 512 - edt_pop_komen.getText().toString().length();
                    pop_txtCountKomen.setText(String.valueOf(charCount));
                    return;
                }
            }

            public void onTextChanged(CharSequence charsequence, int l, int i1, int j1)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    charCount = 512 - edt_pop_komen.getText().toString().length();
                    pop_txtCountKomen.setText(String.valueOf(charCount));
                    return;
                }
            }

            
            {
                this$0 = SCReplyFormActivity.this;
                super();
            }
        });
        img_tanggap_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final SCReplyFormActivity this$0;

            public boolean onLongClick(View view)
            {
                view = new ArrayList();
                view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(userpict.toString().trim()).toString());
                view = (String[])view.toArray(new String[view.size()]);
                Intent intent = new Intent(SCReplyFormActivity.this, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view);
                intent.putExtra("pos", 0);
                startActivity(intent);
                return false;
            }

            
            {
                this$0 = SCReplyFormActivity.this;
                super();
            }
        });
        img_tanggap_picture.setOnClickListener(new android.view.View.OnClickListener() {

            final SCReplyFormActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(SCReplyFormActivity.this, com/inponsel/android/v2/ProfileOtherUser);
                view.putExtra("id_user_view", userkomen);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = SCReplyFormActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onKeyDown(int j, KeyEvent keyevent)
    {
        switch (j)
        {
        default:
            return super.onKeyDown(j, keyevent);

        case 82: // 'R'
            return true;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            onBackPressed();
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getLoginStat().equals("1") && userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Observable observable) { }
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
    }










}
