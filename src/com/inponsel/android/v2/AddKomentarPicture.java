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
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.AndroidMultiPartEntity;
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
import com.readystatesoftware.systembartint.SystemBarTintManager;
import eu.janmuller.android.simplecropimage.CropImage;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
//            RoomMyDraftPost

public class AddKomentarPicture extends SherlockFragmentActivity
    implements Observer
{
    public class PostKomen extends AsyncTask
    {

        String res;
        final AddKomentarPicture this$0;

        private void parseJSONKom(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatus = s.getString("success");
                postMessage = s.getString("message");
                jum_komen = s.getString("jum_komen");
                tot_LikePon = s.getString("total_like");
                totdis_LikePon = s.getString("total_dislike");
                ponselBaseApp.getObserver().setJum_komenLikePon(jum_komen);
                ponselBaseApp.getObserver().setTot_LikePon(tot_LikePon);
                ponselBaseApp.getObserver().setTotdis_LikePon(totdis_LikePon);
                ponselBaseApp.getObserver().setIndexHp(codename);
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
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = "";
            if (!komen_type.equals("ponsel")) goto _L2; else goto _L1
_L1:
            avoid = url_PostKomen;
            urlEmailNotif = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_forum").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&idhp=").append(id_hp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(URLEncoder.encode(edtKomentar.getText().toString(), "utf-8")).append("&nmhp=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).append("&img=").append(resp).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
_L3:
            res = avoid.toString();
            parseJSONKom(res);
            break MISSING_BLOCK_LABEL_1724;
_L2:
label0:
            {
                if (!komen_type.equals("berita"))
                {
                    break label0;
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("plus_kom_rss").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&komen=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&id_rss=").append(id_rss).append("&top_id=").append("0").append("&t=").append(t).append("&id_usr=").append(user_id).append("&img=").append(resp).toString();
                urlEmailNotif = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_comment_rss").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&komen=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&id_rss=").append(id_rss).append("&top_id=").append("0").append("&t=").append(t).append("&id_usr=").append(user_id).append("&img=").append(resp).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
            }
              goto _L3
label1:
            {
                if (!komen_type.equals("forum"))
                {
                    break label1;
                }
                Log.e("resp", resp);
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_kom_forum").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&komen=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&tl_id=").append(tl_id).append("&type=").append(tl_type).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&img=").append(resp).toString();
                urlEmailNotif = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_comment_tl").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&komen=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&tl_id=").append(tl_id).append("&type=").append(tl_type).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&img=").append(resp).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
            }
              goto _L3
label2:
            {
                if (!komen_type.equals("servicecenter"))
                {
                    break label2;
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_komen_sc").append(Utility.BASE_FORMAT).append("?").append("idsc=").append(id_sc).append("&idusr=").append(user_id).append("&kom=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&rplto=").append("0").append("&top_id=").append(top_id).append("&t=").append(t).append("&img=").append(resp).toString();
                Log.e("pushsc_krisan", avoid);
                avoid = HttpPush.getResponse(avoid);
            }
              goto _L3
            if (!komen_type.contains("appskategori")) goto _L5; else goto _L4
_L4:
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_komen_katapps").append(Utility.BASE_FORMAT).append("?").append("idkat=").append(id_sc).append("&idusr=").append(user_id).append("&kom=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&rplto=").append("0").append("&top_id=").append(top_id).append("&t=").append(t).append("&img=").append(resp).toString();
            Log.e("pushsc_krisan", avoid);
            avoid = HttpPush.getResponse(avoid);
              goto _L3
_L5:
            if (!komen_type.equals("conversation")) goto _L3; else goto _L6
_L6:
            Log.e("resp", resp);
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_kom_forum").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&komen=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&tl_id=").append(tl_id).append("&type=").append(tl_type).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&img=").append(resp).toString();
            urlEmailNotif = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_comment_tl").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&komen=").append(URLEncoder.encode(edtKomentar.getText().toString())).append("&tl_id=").append(tl_id).append("&type=").append(tl_type).append("&top_id=").append(top_id).append("&t=").append(t).append("&id_usr=").append(user_id).append("&img=").append(resp).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
              goto _L3
            avoid;
            avoid.printStackTrace();
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            Log.e("postStatus", postStatus);
            if (!postStatus.equals("1")) goto _L2; else goto _L1
_L1:
            notifBerhasil();
            edtKomentar.setText("");
            if (!komen_type.equals("forum")) goto _L4; else goto _L3
_L3:
            ponselBaseApp.getObserver().setUpdateType("komentartl");
_L7:
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            if (android.os.Build.VERSION.SDK_INT < 11) goto _L6; else goto _L5
_L5:
            (new SendMailTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
_L8:
            Log.e("jsonKom", "res");
            setResult(-1, (new Intent()).putExtra("jsonKom", res));
            finish();
            return;
_L4:
label0:
            {
                if (!komen_type.equals("servicecenter"))
                {
                    break label0;
                }
                ponselBaseApp.getObserver().setUpdateType("komentarsc");
            }
              goto _L7
label1:
            {
                if (!komen_type.contains("appskategori"))
                {
                    break label1;
                }
                ponselBaseApp.getObserver().setUpdateType("appskategorikom");
            }
              goto _L7
label2:
            {
                if (!komen_type.equals("berita"))
                {
                    break label2;
                }
                ponselBaseApp.getObserver().setUpdateType("komentarrss");
            }
              goto _L7
label3:
            {
                if (!komen_type.equals("conversation"))
                {
                    break label3;
                }
                ponselBaseApp.getObserver().setUpdateType("komentarconv");
            }
              goto _L7
            try
            {
                ponselBaseApp.getObserver().setUpdateType("komentar");
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L7
_L6:
            (new SendMailTask()).execute(new Void[0]);
              goto _L8
_L2:
            btnPostAskHp.setEnabled(true);
            edtKomentar.setEnabled(true);
            progbar_send.setVisibility(8);
            if (postStatus.equals("040"))
            {
                void1 = new android.app.AlertDialog.Builder(ctw);
                void1.setMessage(postMessage);
                void1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                    final PostKomen this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = PostKomen.this;
                super();
            }
                });
                void1.show();
                notifGagal();
                return;
            }
            notifGagal();
            return;
              goto _L7
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Log.e("url_PostKomen", url_PostKomen);
            btnPostAskHp.setEnabled(false);
            edtKomentar.setEnabled(false);
        }

        public PostKomen()
        {
            this$0 = AddKomentarPicture.this;
            super();
        }
    }

    public class SendMailTask extends AsyncTask
    {

        final AddKomentarPicture this$0;

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
            this$0 = AddKomentarPicture.this;
            super();
        }
    }

    private class UploadImage extends AsyncTask
    {

        final AddKomentarPicture this$0;

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
                if (komen_type.equals("ponsel"))
                {
                    try
                    {
                        url_PostKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_kom_hp").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&idhp=").append(id_hp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(URLEncoder.encode(edtKomentar.getText().toString(), "utf-8")).append("&nmhp=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).append("&img=").append(resp).append("&pf=").append(str_tag_komen).toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        s.printStackTrace();
                    }
                }
                (new PostKomen()).execute(new Void[0]);
            } else
            {
                notifGagal();
            }
            Log.e("url_PostKomen", url_PostKomen);
        }

        protected void onPreExecute()
        {
            edtKomentar.setEnabled(false);
            imgAskHp.setEnabled(false);
            btnPostAskHp.setEnabled(false);
            mBuilder.setProgress(99, 0, false);
            mNotifyManager.notify(notif_id, mBuilder.build());
            progbar_send.setVisibility(0);
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
            this$0 = AddKomentarPicture.this;
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
    int charCount;
    ConnectivityManager cm;
    String codename;
    int countAllKom;
    int countKomOld;
    ContextThemeWrapper ctw;
    Cursor cursor;
    String curtime;
    DatabaseHandler db;
    EditText edtKomentar;
    String email_user;
    Bundle extras;
    String filePath;
    String gambar;
    String id_hp;
    String id_rss;
    String id_sc;
    ImageView imgAskHp;
    String insert_id;
    InputStream is;
    String json_response;
    String jum_komen;
    String komen_type;
    String komencount;
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
    String paramkomen;
    String path_image;
    Bitmap photo_upload;
    PonselBaseApp ponselBaseApp;
    TextView pop_txtCountKomen;
    TextView pop_txt_empty;
    String postMessage;
    String postStatus;
    SmoothProgressBar progbar_send;
    RadioButton rbBenchmark;
    RadioButton rbHasilFoto;
    RadioButton rbLainnya;
    String resp;
    RadioGroup rgPilTagKomentar;
    String rss_title;
    String sc_nama;
    String str_from;
    String str_img_url;
    String str_tag_komen;
    String succesStat;
    String success_stat;
    String t;
    String tl_id;
    String tl_judul;
    String tl_type;
    String top_id;
    String tot_LikePon;
    long totalSize;
    String totdis_LikePon;
    String urlEmailNotif;
    String url_PostKomen;
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

    public AddKomentarPicture()
    {
        postStatus = "";
        postMessage = "";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        ctw = new ContextThemeWrapper(this, 0x7f0d0055);
        komencount = "";
        countKomOld = 0;
        countAllKom = 0;
        resp = "-";
        str_img_url = "-";
        filePath = "";
        notif_id = 1;
        now = Calendar.getInstance();
        totalSize = 0L;
        id_sc = "";
        sc_nama = "";
        tl_judul = "";
        tl_id = "";
        tl_type = "";
        success_stat = "";
        message_stat = "";
        insert_id = "";
        json_response = "";
        urlEmailNotif = "";
        path_image = "";
        curtime = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        t = Utility.session(RestClient.pelihara);
        komen_type = "";
        paramkomen = "";
        id_rss = "";
        rss_title = "";
        user_photo = "";
        username = "";
        url_PostKomen = "";
        str_tag_komen = "";
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

    private void openGallery()
    {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        startActivityForResult(intent, 1);
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

    private void showPickerImage()
    {
        ArrayAdapter arrayadapter = new ArrayAdapter(this, 0x1090011, new String[] {
            "Dari Kamera", "Dari Galeri"
        });
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
        builder.setTitle("Pilih gambar");
        builder.setAdapter(arrayadapter, new android.content.DialogInterface.OnClickListener() {

            final AddKomentarPicture this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                mFileTemp = createFolders();
                mFileTemp = getNextFileName();
                if (i == 0)
                {
                    takePicture();
                } else
                {
                    openGallery();
                }
                Log.e("startActivityForResult", String.valueOf(-1));
            }

            
            {
                this$0 = AddKomentarPicture.this;
                super();
            }
        });
        mFileTemp = createFolders();
        mFileTemp = getNextFileName();
        openGallery();
        Log.e("startActivityForResult", String.valueOf(-1));
    }

    private void showPickerImagePopUp()
    {
        ArrayAdapter arrayadapter = new ArrayAdapter(this, 0x1090011, new String[] {
            "Dari Kamera", "Dari Galeri"
        });
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
        builder.setTitle("Pilih gambar");
        builder.setAdapter(arrayadapter, new android.content.DialogInterface.OnClickListener() {

            final AddKomentarPicture this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                mFileTemp = createFolders();
                mFileTemp = getNextFileName();
                if (i == 0)
                {
                    takePicture();
                } else
                {
                    openGallery();
                }
                Log.e("startActivityForResult", String.valueOf(-1));
            }

            
            {
                this$0 = AddKomentarPicture.this;
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

    public void notifBerhasil()
    {
        PendingIntent pendingintent = PendingIntent.getActivity(this, 0, new Intent(), 0x10000000);
        mBuilder.setContentTitle("InPonsel").setContentText("Berhasil Mengirim komentar").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(pendingintent).setAutoCancel(true);
        mNotifyManager.notify(notif_id, mBuilder.build());
        (new Handler()).postDelayed(new Runnable() {

            final AddKomentarPicture this$0;

            public void run()
            {
                mNotifyManager.cancel(notif_id);
            }

            
            {
                this$0 = AddKomentarPicture.this;
                super();
            }
        }, 3000L);
    }

    public void notifGagal()
    {
        progbar_send.setVisibility(8);
        Object obj = new Intent();
        ((Intent) (obj)).setClass(getApplicationContext(), com/inponsel/android/v2/RoomMyDraftPost);
        obj = PendingIntent.getActivity(this, 0, ((Intent) (obj)), 0x10000000);
        mBuilder.setContentTitle("InPonsel").setContentText("Gagal Mengirim komentar").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(((PendingIntent) (obj))).setAutoCancel(true);
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
        Log.e("filtemp", mFileTemp.getPath());
        Bitmap bitmap = BitmapFactory.decodeFile(mFileTemp.getPath());
        photo_upload = BitmapFactory.decodeFile(mFileTemp.getPath());
        imgAskHp.setImageBitmap(bitmap);
        filePath = path_image;
        if (filePath == null || filePath.equals(""))
        {
            rgPilTagKomentar.setVisibility(8);
        } else
        if (komen_type.equals("ponsel"))
        {
            rgPilTagKomentar.setVisibility(0);
        } else
        if (komen_type.equals("berita"))
        {
            rgPilTagKomentar.setVisibility(8);
        } else
        if (komen_type.equals("forum"))
        {
            rgPilTagKomentar.setVisibility(8);
        } else
        if (komen_type.equals("servicecenter"))
        {
            rgPilTagKomentar.setVisibility(8);
        } else
        if (komen_type.contains("appskategori"))
        {
            rgPilTagKomentar.setVisibility(8);
            str_tag_komen = "appsgamekategori";
        } else
        if (komen_type.equals("conversation"))
        {
            rgPilTagKomentar.setVisibility(8);
        } else
        {
            rgPilTagKomentar.setVisibility(8);
        }
        if (true) goto _L3; else goto _L7
_L7:
        if (true) goto _L1; else goto _L8
_L8:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030094);
        cm = (ConnectivityManager)getSystemService("connectivity");
        netInfo = cm.getActiveNetworkInfo();
        db = new DatabaseHandler(this);
        userFunctions = new UserFunctions();
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        t = Utility.session(t);
        t = Utility.session(t);
        curtime = (new SimpleDateFormat("MMddHHmmss")).format(new Date());
        extras = getIntent().getExtras();
        komen_type = extras.getString("komen_type");
        rgPilTagKomentar = (RadioGroup)findViewById(0x7f0b051b);
        int i;
        int j;
        if (komen_type.equals("ponsel"))
        {
            id_hp = extras.getString("id_hph");
            codename = extras.getString("codename");
            model = extras.getString("model");
            merk = extras.getString("merk");
            namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
            top_id = extras.getString("top_id");
        } else
        if (komen_type.equals("berita"))
        {
            id_rss = extras.getString("id_rss");
            rss_title = extras.getString("rss_title");
            top_id = extras.getString("top_id");
        } else
        if (komen_type.equals("forum"))
        {
            tl_id = extras.getString("forum_id");
            tl_type = extras.getString("tl_type");
            tl_judul = extras.getString("tl_judul");
            top_id = extras.getString("top_id");
        } else
        if (komen_type.equals("servicecenter"))
        {
            id_sc = extras.getString("id_sc");
            sc_nama = extras.getString("sc_nama");
            top_id = extras.getString("top_id");
        } else
        if (komen_type.contains("appskategori"))
        {
            id_sc = extras.getString("id_kat");
            sc_nama = extras.getString("sc_nama");
            top_id = extras.getString("top_id");
        } else
        if (komen_type.equals("conversation"))
        {
            tl_id = extras.getString("forum_id");
            tl_type = extras.getString("tl_type");
            tl_judul = extras.getString("tl_judul");
            top_id = extras.getString("top_id");
        }
        Log.e("top_id", top_id);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayUseLogoEnabled(useLogo);
        if (komen_type.equals("forum"))
        {
            bundle.setStatusBarTintResource(0x7f080170);
            actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e7));
        } else
        if (komen_type.equals("conversation"))
        {
            bundle.setStatusBarTintResource(0x7f08018a);
            actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e6));
        } else
        if (komen_type.contains("appskategorigames"))
        {
            bundle.setStatusBarTintResource(0x7f0800ab);
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7b1fa2")));
        } else
        if (komen_type.contains("appskategoriapps"))
        {
            bundle.setStatusBarTintResource(0x7f08011c);
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#689f38")));
        } else
        {
            bundle.setStatusBarTintResource(0x7f080160);
            actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        }
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Kirim komentar</font>"));
        wrapper = new ContextThemeWrapper(this, 0x103006e);
        imgAskHp = (ImageView)findViewById(0x7f0b051a);
        edtKomentar = (EditText)findViewById(0x7f0b051f);
        btnPostAskHp = (Button)findViewById(0x7f0b0520);
        progbar_send = (SmoothProgressBar)findViewById(0x7f0b0519);
        pop_txtCountKomen = (TextView)findViewById(0x7f0b04df);
        rbHasilFoto = (RadioButton)findViewById(0x7f0b051c);
        rbBenchmark = (RadioButton)findViewById(0x7f0b051d);
        rbLainnya = (RadioButton)findViewById(0x7f0b051e);
        rgPilTagKomentar.setVisibility(8);
        rgPilTagKomentar.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            final AddKomentarPicture this$0;

            public void onCheckedChanged(RadioGroup radiogroup, int k)
            {
                if (rbHasilFoto.isChecked())
                {
                    str_tag_komen = "1";
                    return;
                }
                if (rbBenchmark.isChecked())
                {
                    str_tag_komen = "2";
                    return;
                }
                if (rbLainnya.isChecked())
                {
                    str_tag_komen = "3";
                    return;
                }
                if (komen_type.equals("ponsel"))
                {
                    str_tag_komen = "";
                    return;
                }
                if (komen_type.equals("berita"))
                {
                    str_tag_komen = "-";
                    return;
                }
                if (komen_type.equals("forum"))
                {
                    str_tag_komen = "-";
                    return;
                }
                if (komen_type.equals("servicecenter"))
                {
                    str_tag_komen = "-";
                    return;
                }
                if (komen_type.contains("appskategori"))
                {
                    str_tag_komen = "-";
                    str_tag_komen = "appsgamekategori";
                    return;
                }
                if (komen_type.equals("conversation"))
                {
                    str_tag_komen = "-";
                    return;
                } else
                {
                    str_tag_komen = "-";
                    return;
                }
            }

            
            {
                this$0 = AddKomentarPicture.this;
                super();
            }
        });
        if (komen_type.equals("ponsel"))
        {
            str_tag_komen = "";
        } else
        if (komen_type.equals("berita"))
        {
            str_tag_komen = "-";
        } else
        if (komen_type.equals("forum"))
        {
            str_tag_komen = "-";
        } else
        if (komen_type.equals("servicecenter"))
        {
            str_tag_komen = "-";
        } else
        if (komen_type.contains("appskategori"))
        {
            str_tag_komen = "-";
            str_tag_komen = "appsgamekategori";
        } else
        if (komen_type.equals("conversation"))
        {
            str_tag_komen = "-";
        } else
        {
            str_tag_komen = "-";
        }
        progbar_send.setVisibility(8);
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
        edtKomentar.addTextChangedListener(new TextWatcher() {

            final AddKomentarPicture this$0;

            public void afterTextChanged(Editable editable)
            {
                if (edtKomentar.getText().toString().trim().length() == 0)
                {
                    btnPostAskHp.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btnPostAskHp.setEnabled(true);
                charCount = 512 - edtKomentar.getText().toString().length();
                komencount = edtKomentar.getText().toString();
                pop_txtCountKomen.setText(String.valueOf(charCount));
                if (charCount < 0)
                {
                    btnPostAskHp.setEnabled(false);
                    return;
                }
                if (charCount > 0 && charCount < 4)
                {
                    btnPostAskHp.setEnabled(false);
                    return;
                } else
                {
                    btnPostAskHp.setEnabled(true);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
                if (edtKomentar.getText().toString().trim().length() == 0)
                {
                    btnPostAskHp.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btnPostAskHp.setEnabled(true);
                charCount = 512 - edtKomentar.getText().toString().length();
                komencount = edtKomentar.getText().toString();
                pop_txtCountKomen.setText(String.valueOf(charCount));
                if (charCount < 0)
                {
                    btnPostAskHp.setEnabled(false);
                    return;
                }
                if (charCount > 0 && charCount < 4)
                {
                    btnPostAskHp.setEnabled(false);
                    return;
                } else
                {
                    btnPostAskHp.setEnabled(true);
                    return;
                }
            }

            public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
                komencount = edtKomentar.getText().toString();
                if (edtKomentar.getText().toString().trim().length() == 0)
                {
                    btnPostAskHp.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btnPostAskHp.setEnabled(true);
                charCount = 512 - edtKomentar.getText().toString().length();
                pop_txtCountKomen.setText(String.valueOf(charCount));
                if (charCount < 0)
                {
                    btnPostAskHp.setEnabled(false);
                    return;
                }
                if (charCount > 0 && charCount < 4)
                {
                    btnPostAskHp.setEnabled(false);
                    return;
                } else
                {
                    btnPostAskHp.setEnabled(true);
                    return;
                }
            }

            
            {
                this$0 = AddKomentarPicture.this;
                super();
            }
        });
        showPickerImage();
        btnPostAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final AddKomentarPicture this$0;

            public void onClick(View view)
            {
                if (netInfo != null && netInfo.isConnected())
                {
                    if (photo_upload == null)
                    {
                        btnPostAskHp.setEnabled(false);
                        Log.e("photo", "oke");
                        view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                        notif_id = Integer.parseInt(view);
                        mNotifyManager = (NotificationManager)getSystemService("notification");
                        mBuilder = new android.support.v4.app.NotificationCompat.Builder(AddKomentarPicture.this);
                        mBuilder.setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
                        try
                        {
                            url_PostKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_kom_hp").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&idhp=").append(id_hp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(URLEncoder.encode(edtKomentar.getText().toString(), "utf-8")).append("&nmhp=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).append("&img=").append(resp).append("&pf=").append(str_tag_komen).toString();
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
                        Log.e("str_tag_komen", str_tag_komen);
                        if (str_tag_komen.equals(""))
                        {
                            Toast.makeText(getApplicationContext(), "Tag belum dipilih", 0).show();
                            return;
                        }
                        btnPostAskHp.setEnabled(false);
                        Log.e("photo", "oke");
                        view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                        notif_id = Integer.parseInt(view);
                        mNotifyManager = (NotificationManager)getSystemService("notification");
                        mBuilder = new android.support.v4.app.NotificationCompat.Builder(AddKomentarPicture.this);
                        mBuilder.setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
                        try
                        {
                            url_PostKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("post_kom_hp").append(Utility.BASE_FORMAT).append("?").append("rplto=0").append("&idhp=").append(id_hp).append("&code=").append(codename).append("&email=").append(URLEncoder.encode(email_user, "utf-8")).append("&nama=").append(URLEncoder.encode(username, "utf-8")).append("&komentar=").append(URLEncoder.encode(edtKomentar.getText().toString(), "utf-8")).append("&nmhp=").append(URLEncoder.encode(namalengkap, "utf-8")).append("&top_id=").append(top_id).append("&t=").append(t).append("&idusr=").append(user_id).append("&img=").append(resp).append("&pf=").append(str_tag_komen).toString();
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            view.printStackTrace();
                        }
                        (new PostKomen()).execute(new Void[0]);
                        return;
                    }
                    if (str_tag_komen.equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "Tag belum dipilih", 0).show();
                        return;
                    } else
                    {
                        btnPostAskHp.setEnabled(false);
                        Log.e("photo", "oke");
                        view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                        notif_id = Integer.parseInt(view);
                        mNotifyManager = (NotificationManager)getSystemService("notification");
                        mBuilder = new android.support.v4.app.NotificationCompat.Builder(AddKomentarPicture.this);
                        mBuilder.setContentTitle("InPonsel").setContentText("Mengirim komentar... - 0%").setSmallIcon(0x7f0201e4);
                        (new UploadImage(null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    }
                } else
                {
                    Toast.makeText(getApplicationContext(), "Tidak ada koneksi internet", 1).show();
                    return;
                }
            }

            
            {
                this$0 = AddKomentarPicture.this;
                super();
            }
        });
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
