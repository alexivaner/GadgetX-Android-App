// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.inponsel.android.adapter.ListModel;
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
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomMyDraftPost

public class RoomPostBenchmark extends SherlockFragmentActivity
    implements Observer
{
    public class ListBenchAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        ImageLoader imageLoader2;
        private ArrayList lm;
        private DisplayImageOptions options;
        int resource;
        String response;
        final RoomPostBenchmark this$0;

        public int getCount()
        {
            return lm.size();
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public ListModel getListModel(int i)
        {
            return (ListModel)lm.get(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            ListModel listmodel;
            if (viewgroup == null)
            {
                viewgroup = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                view = new ViewHolder();
                view.imageHp = (ImageView)viewgroup.findViewById(0x7f0b023d);
                view.homeMerek = (TextView)viewgroup.findViewById(0x7f0b0464);
                view.headImage = (LinearLayout)viewgroup.findViewById(0x7f0b029f);
                ((ViewHolder) (view)).headImage.setVisibility(8);
                viewgroup.setTag(view);
            } else
            {
                view = (ViewHolder)viewgroup.getTag();
            }
            ((ViewHolder) (view)).headImage.setVisibility(8);
            listmodel = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (view)).homeMerek.setText(listmodel.getNm_apps());
                ((ViewHolder) (view)).headImage.setVisibility(0);
                Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(150).append("&src=").append(listmodel.getGambar()).toString()).into(((ViewHolder) (view)).imageHp, view. new Callback() {

                    final ListBenchAdapter this$1;
                    private final ListBenchAdapter.ViewHolder val$holder;

                    public void onError()
                    {
                        holder.imageHp.setImageResource(0x7f020209);
                    }

                    public void onSuccess()
                    {
                    }

            
            {
                this$1 = final_listbenchadapter;
                holder = ListBenchAdapter.ViewHolder.this;
                super();
            }
                });
            }
            return viewgroup;
        }

        void log(String s)
        {
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public ListBenchAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = RoomPostBenchmark.this;
            super();
            lm = arraylist;
            activity = activity1;
            resource = i;
            imageLoader2 = ImageLoader.getInstance();
            imageLoader2.init(ImageLoaderConfiguration.createDefault(activity.getApplicationContext()));
            options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        }
    }

    class ListBenchAdapter.ViewHolder
    {

        LinearLayout headImage;
        TextView homeMerek;
        ImageView imageHp;
        RatingBar rateRate;
        final ListBenchAdapter this$1;

        ListBenchAdapter.ViewHolder()
        {
            this$1 = ListBenchAdapter.this;
            super();
        }
    }

    private class MerkSync extends AsyncTask
    {

        final RoomPostBenchmark this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            int i;
            int j;
            j = as.length;
            i = 0;
_L3:
            if (i >= j)
            {
                return null;
            }
            Object obj = new RestClient(as[i]);
            ((RestClient) (obj)).Execute(com.inponsel.android.utils.RestClient.RequestMethod.GET);
_L1:
            Exception exception1;
            try
            {
                obj = ((RestClient) (obj)).getResponse();
                getJson = ((String) (obj));
                parseJSON(((String) (obj)));
            }
            catch (Exception exception) { }
            break MISSING_BLOCK_LABEL_65;
            exception1;
            exception1.printStackTrace();
              goto _L1
            i++;
            if (true) goto _L3; else goto _L2
_L2:
        }

        void log(String s)
        {
            Log.e("Near", s);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            progressbar_middle_dialog.setVisibility(8);
            if (listMerkArrayList.size() != 0)
            {
                break MISSING_BLOCK_LABEL_70;
            }
            txtEmpty.setText(0x7f0c0059);
_L1:
            listMerkAdapter.setListArray(listMerkArrayList);
            listMerkAdapter.notifyDataSetChanged();
            return;
            try
            {
                layout_empty.setVisibility(8);
                listHp.setVisibility(0);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
                return;
            }
              goto _L1
        }

        protected void onPreExcute()
        {
            super.onPreExecute();
        }

        void parseJSON(String s)
        {
            JSONObject jsonobject;
            ListModel listmodel;
            int i;
            try
            {
                s = new JSONObject(s);
                listMerkArrayList = new ArrayList();
                s = s.getJSONArray("InPonsel");
                log((new StringBuilder("lenght: ")).append(s.length()).toString());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return;
            }
            i = 0;
            if (i >= s.length())
            {
                return;
            }
            jsonobject = s.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_bench(jsonobject.getString("id"));
            listmodel.setNm_apps(jsonobject.getString("nm_apps"));
            listmodel.setBench_url(jsonobject.getString("playstore"));
            listmodel.setGambar(jsonobject.getString("gambar"));
            listMerkArrayList.add(listmodel);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_56;
            }
        }

        private MerkSync()
        {
            this$0 = RoomPostBenchmark.this;
            super();
        }

        MerkSync(MerkSync merksync)
        {
            this();
        }
    }

    public class SendMailTask extends AsyncTask
    {

        final RoomPostBenchmark this$0;

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
            this$0 = RoomPostBenchmark.this;
            super();
        }
    }

    private class UploadImage extends AsyncTask
    {

        final RoomPostBenchmark this$0;

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
                    SendPertanyaan(id_hp, user_id, URLEncoder.encode(edtJudulAskHp.getText().toString().replace(".", "").trim(), "utf-8"), URLEncoder.encode(edtPertanyaan.getText().toString(), "utf-8"), URLEncoder.encode(str_img_url.trim(), "utf-8"), t);
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
                s = new Intent();
                s.setClass(getApplicationContext(), com/inponsel/android/v2/RoomMyDraftPost);
                s = PendingIntent.getActivity(RoomPostBenchmark.this, 0, s, 0x10000000);
                mBuilder.setContentTitle((new StringBuilder("Benchmark ")).append(namalengkap).append(" - ").append(benchmark_apps).toString()).setContentText("Gagal memposting hasil benchmark").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(s).setAutoCancel(true);
                mNotifyManager.notify(notif_id, mBuilder.build());
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
                mBuilder.setContentTitle((new StringBuilder("Benchmark ")).append(namalengkap).toString()).setOngoing(true).setContentText((new StringBuilder("Mengirim ")).append(String.valueOf(99)).append("%").toString()).setSmallIcon(0x7f0201e4);
            } else
            {
                mBuilder.setProgress(99, ainteger[0].intValue(), false);
                mBuilder.setContentTitle((new StringBuilder("Benchmark ")).append(namalengkap).toString()).setOngoing(true).setContentText((new StringBuilder("Mengirim ")).append(String.valueOf(ainteger[0])).append("%").toString()).setSmallIcon(0x7f0201e4);
            }
            mNotifyManager.notify(notif_id, mBuilder.build());
        }

        protected volatile transient void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((Integer[])aobj);
        }



        private UploadImage()
        {
            this$0 = RoomPostBenchmark.this;
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
    String benchmark_apps;
    Button btnPostAskHp;
    Button btnSaveAskHp;
    Button btnbenchmark;
    ConnectivityManager cm;
    String codename;
    Cursor cursor;
    String curtime;
    DatabaseHandler db;
    private DecimalFormat df;
    private DecimalFormat dfnd;
    Dialog dialog;
    String display;
    EditText edtJudulAskHp;
    EditText edtPertanyaan;
    String email_user;
    Bundle extras;
    String filePath;
    String gambar;
    String getJson;
    private boolean hasFractionalPart;
    String id_hp;
    ImageView imgAskHp;
    String insert_id;
    InputStream is;
    String json_response;
    LinearLayout layout_empty;
    ListView listHp;
    ListBenchAdapter listMerkAdapter;
    ArrayList listMerkArrayList;
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
    String pilih_benchmark[] = {
        "Antutu", "Quadrant", "Smartbench", "CPU Benchmark", "GFXBench GL Benchmark", "Basemark X", "GeekBench", "Neocore", "NenaMark"
    };
    PonselBaseApp ponselBaseApp;
    SmoothProgressBar progbar_send;
    ProgressBar progressbar_middle_dialog;
    ProgressBar progressbar_search;
    String resp;
    RelativeLayout rl_benchmark;
    String strPencBench;
    String str_from;
    String str_img_url;
    String success_stat;
    String t;
    String tag_artikel;
    long totalSize;
    TextView txtEmpty;
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
    String v;
    ContextThemeWrapper wrapper;

    public RoomPostBenchmark()
    {
        urlEmailNotif = "";
        tag_artikel = "";
        user_photo = "";
        username = "";
        str_img_url = "";
        filePath = "";
        notif_id = 1;
        now = Calendar.getInstance();
        totalSize = 0L;
        success_stat = "";
        message_stat = "";
        insert_id = "";
        json_response = "";
        path_image = "";
        curtime = "";
        benchmark_apps = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        t = Utility.session(RestClient.pelihara);
        getJson = "";
        strPencBench = "";
        listMerkArrayList = null;
    }

    private void SendPertanyaan(String s, String s1, String s2, String s3, String s4, String s5)
    {
        try
        {
            String s6 = URLEncoder.encode((new StringBuilder("Benchmark: ")).append(namalengkap).toString(), "utf-8");
            tag_artikel = URLEncoder.encode(benchmark_apps, "utf-8");
            s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_benchmark").append(Utility.BASE_FORMAT).append("?idhp=").append(s).append("&iduser=").append(s1).append("&title=").append(s6).append("&skor=").append(s2).append("&codename=").append(codename).append("&app=").append(strPencBench).append("&skor=").append(s2).append("&ask=").append(s3).append("&img=").append(s4).append("&t=").append(s5).toString();
            Log.e("urlSend", s);
            showSmoothProgress();
            s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

                final RoomPostBenchmark this$0;

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
                this$0 = RoomPostBenchmark.this;
                super();
            }
            }, new com.android.volley.Response.ErrorListener() {

                final RoomPostBenchmark this$0;

                public void onErrorResponse(VolleyError volleyerror)
                {
                    Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                    hideSmoothProgress();
                }

            
            {
                this$0 = RoomPostBenchmark.this;
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
            if (progbar_send.getVisibility() == 0)
            {
                progbar_send.setVisibility(8);
                progbar_send.setVisibility(8);
                if (!success_stat.equals("1"))
                {
                    break label0;
                }
                Log.e("urlEmailNotifsuc", urlEmailNotif);
                PendingIntent pendingintent = PendingIntent.getActivity(this, 0, new Intent(), 0x10000000);
                mBuilder.setContentTitle((new StringBuilder("Benchmark ")).append(namalengkap).append(" - ").append(benchmark_apps).toString()).setContentText("Berhasil memposting benchmark").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(pendingintent).setAutoCancel(true);
                mNotifyManager.notify(notif_id, mBuilder.build());
                db.delete_byARTID(curtime, edtJudulAskHp.getText().toString().replace(".", "").trim());
                setResult(-1, (new Intent()).putExtra("jsonKom", json_response));
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
        if (!db.checkARTJudulIfExist(curtime, edtJudulAskHp.getText().toString().replace(".", "").trim())) goto _L2; else goto _L1
_L1:
        DatabaseHandler databasehandler;
        String s;
        String s1;
        String s2;
        Toast.makeText(getApplicationContext(), "Berhasil memperbaharui", 1).show();
        databasehandler = db;
        s = curtime;
        s1 = (new StringBuilder("Benchmark ")).append(namalengkap).append(" - ").append(benchmark_apps).toString();
        s2 = benchmark_apps;
        if (photo_upload != null) goto _L4; else goto _L3
_L3:
        Object obj = "";
_L5:
        String s3;
        try
        {
            databasehandler.update_byARTID(s, s1, s2, ((String) (obj)), edtPertanyaan.getText().toString(), edtJudulAskHp.getText().toString().replace(".", "").trim());
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
        mBuilder.setContentTitle((new StringBuilder("Benchmark ")).append(namalengkap).append(" - ").append(benchmark_apps).toString()).setContentText("Gagal memposting benchmark").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(((PendingIntent) (obj))).setAutoCancel(true);
        mNotifyManager.notify(notif_id, mBuilder.build());
        return;
_L4:
        obj = path_image;
          goto _L5
_L2:
        databasehandler = db;
        s = id_hp;
        s1 = codename;
        s2 = (new StringBuilder("Benchmark ")).append(namalengkap).append(" - ").append(benchmark_apps).toString();
        s3 = benchmark_apps;
        if (photo_upload != null)
        {
            break MISSING_BLOCK_LABEL_706;
        }
        obj = "";
_L7:
        databasehandler.addArtUser(s, s1, "benchmark", s2, s3, ((String) (obj)), "", edtPertanyaan.getText().toString(), curtime);
          goto _L6
        obj = path_image;
          goto _L7
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
            Log.e("urlEmailNotifSend", urlEmailNotif);
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
        intent.putExtra("scale", false);
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

    public void notifGagal()
    {
        Object obj = new Intent();
        ((Intent) (obj)).setClass(getApplicationContext(), com/inponsel/android/v2/RoomMyDraftPost);
        obj = PendingIntent.getActivity(this, 0, ((Intent) (obj)), 0x10000000);
        mBuilder.setContentTitle((new StringBuilder("Benchmark ")).append(namalengkap).append(" - ").append(benchmark_apps).toString()).setContentText("Gagal memposting hasil benchmark").setProgress(0, 0, false).setOngoing(false).setSmallIcon(0x7f0201e4).setContentIntent(((PendingIntent) (obj))).setAutoCancel(true);
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
        Bitmap bitmap;
        if (edtJudulAskHp.getText().length() > 2)
        {
            btnPostAskHp.setEnabled(true);
            btnSaveAskHp.setEnabled(true);
        } else
        {
            btnPostAskHp.setEnabled(false);
            btnSaveAskHp.setEnabled(false);
        }
        bitmap = BitmapFactory.decodeFile(mFileTemp.getPath());
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
        setContentView(0x7f0300aa);
        cm = (ConnectivityManager)getSystemService("connectivity");
        netInfo = cm.getActiveNetworkInfo();
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
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
        dialog = new SystemBarTintManager(this);
        dialog.setStatusBarTintEnabled(true);
        dialog.setStatusBarTintResource(0x7f080173);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        curtime = (new SimpleDateFormat("MMddHHmmss")).format(new Date());
        t = Utility.session(t);
        t = Utility.session(t);
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
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Kirim benchmark</font>"));
        wrapper = new ContextThemeWrapper(this, 0x103006e);
        rl_benchmark = (RelativeLayout)findViewById(0x7f0b05a4);
        imgAskHp = (ImageView)findViewById(0x7f0b051a);
        edtJudulAskHp = (EditText)findViewById(0x7f0b05a7);
        edtPertanyaan = (EditText)findViewById(0x7f0b05a8);
        edtPertanyaan.setHint("Deskripsi tambahan");
        btnPostAskHp = (Button)findViewById(0x7f0b0520);
        btnSaveAskHp = (Button)findViewById(0x7f0b05a9);
        btnbenchmark = (Button)findViewById(0x7f0b05a6);
        progbar_send = (SmoothProgressBar)findViewById(0x7f0b0519);
        progbar_send.setVisibility(8);
        df = new DecimalFormat("#,###.##");
        df.setDecimalSeparatorAlwaysShown(true);
        dfnd = new DecimalFormat("#,###");
        hasFractionalPart = false;
        edtJudulAskHp.addTextChangedListener(new TextWatcher() {

            final RoomPostBenchmark this$0;

            public void afterTextChanged(Editable editable)
            {
                edtJudulAskHp.removeTextChangedListener(this);
                int k;
                int l;
                k = edtJudulAskHp.getText().length();
                v = editable.toString().substring(0, k);
                v = v.replace(".", ",");
                v = v.replace(String.valueOf(df.getDecimalFormatSymbols().getGroupingSeparator()), "");
                editable = df.parse(v);
                l = edtJudulAskHp.getSelectionStart();
                if (!hasFractionalPart) goto _L2; else goto _L1
_L1:
                display = df.format(editable);
                display = display.replace(",", ".");
                display = display.substring(0, display.length() - 1);
                edtJudulAskHp.setText(display);
_L3:
                k = l + (edtJudulAskHp.getText().length() - k);
                if (k <= 0)
                {
                    break MISSING_BLOCK_LABEL_351;
                }
                if (k > edtJudulAskHp.getText().length())
                {
                    break MISSING_BLOCK_LABEL_351;
                }
                edtJudulAskHp.setSelection(k);
_L4:
                edtJudulAskHp.addTextChangedListener(this);
                return;
_L2:
                display = dfnd.format(editable);
                display = display.replace(",", ".");
                edtJudulAskHp.setText(display);
                  goto _L3
                try
                {
                    edtJudulAskHp.setSelection(edtJudulAskHp.getText().length() - 1);
                }
                // Misplaced declaration of an exception variable
                catch (Editable editable) { }
                // Misplaced declaration of an exception variable
                catch (Editable editable) { }
                  goto _L4
            }

            public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
                if (charsequence.toString().contains(String.valueOf(df.getDecimalFormatSymbols().getDecimalSeparator())))
                {
                    hasFractionalPart = true;
                    return;
                } else
                {
                    hasFractionalPart = false;
                    return;
                }
            }

            public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
                if (edtJudulAskHp.getText().length() > 0)
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
                this$0 = RoomPostBenchmark.this;
                super();
            }
        });
        edtPertanyaan.addTextChangedListener(new TextWatcher() {

            final RoomPostBenchmark this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
                if (edtJudulAskHp.getText().length() > 0 && edtPertanyaan.getText().length() > 10)
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
                this$0 = RoomPostBenchmark.this;
                super();
            }
        });
        btnbenchmark.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPostBenchmark this$0;

            public void onClick(View view)
            {
                view = getLayoutInflater().inflate(0x7f0300a4, null);
                android.app.AlertDialog.Builder builder1 = new android.app.AlertDialog.Builder(RoomPostBenchmark.this);
                builder1.setView(view);
                builder1.setTitle("Pilih Benchmark :");
                layout_empty = (LinearLayout)view.findViewById(0x7f0b0091);
                listHp = (ListView)view.findViewById(0x7f0b008f);
                if (android.os.Build.VERSION.SDK_INT < 13)
                {
                    listHp.setBackgroundColor(-1);
                }
                progressbar_middle_dialog = (ProgressBar)view.findViewById(0x7f0b0092);
                txtEmpty = (TextView)view.findViewById(0x7f0b0093);
                txtEmpty.setText(0x7f0c0053);
                listMerkArrayList = new ArrayList();
                listMerkAdapter = new ListBenchAdapter(RoomPostBenchmark.this, 0x7f03006e, listMerkArrayList);
                listHp.setAdapter(listMerkAdapter);
                (new MerkSync(null)).execute(new String[] {
                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_benchmark").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                });
                listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                    final _cls3 this$1;

                    public void onItemClick(AdapterView adapterview, View view, int i, long l)
                    {
                        strPencBench = listMerkAdapter.getListModel(i).getId_bench().toString();
                        benchmark_apps = listMerkAdapter.getListModel(i).getNm_apps().toString();
                        btnbenchmark.setText(listMerkAdapter.getListModel(i).getNm_apps().toString());
                        dialog.dismiss();
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
                dialog = builder1.create();
                dialog.show();
            }


            
            {
                this$0 = RoomPostBenchmark.this;
                super();
            }
        });
        dialog = new ArrayAdapter(this, 0x1090011, new String[] {
            "Dari Kamera", "Dari Galeri"
        });
        builder = new android.app.AlertDialog.Builder(wrapper);
        builder.setTitle("Pilih gambar");
        builder.setAdapter(dialog, new android.content.DialogInterface.OnClickListener() {

            final RoomPostBenchmark this$0;

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
                this$0 = RoomPostBenchmark.this;
                super();
            }
        });
        dialog = builder.create();
        imgAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPostBenchmark this$0;
            private final AlertDialog val$dialog;

            public void onClick(View view)
            {
                dialog.show();
            }

            
            {
                this$0 = RoomPostBenchmark.this;
                dialog = alertdialog;
                super();
            }
        });
        btnSaveAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPostBenchmark this$0;

            public void onClick(View view)
            {
                DatabaseHandler databasehandler;
                String s;
                String s1;
                String s2;
                if (!db.checkARTJudulIfExist(curtime, edtJudulAskHp.getText().toString().replace(".", "").trim()))
                {
                    break MISSING_BLOCK_LABEL_188;
                }
                Toast.makeText(getApplicationContext(), "Berhasil memperbaharui", 1).show();
                databasehandler = db;
                s = curtime;
                s1 = edtJudulAskHp.getText().toString().replace(".", "").trim();
                s2 = benchmark_apps;
                if (photo_upload == null)
                {
                    view = "";
                    break MISSING_BLOCK_LABEL_126;
                }
                view = path_image;
                  goto _L1
                Toast.makeText(getApplicationContext(), "Berhasil menyimpan", 1).show();
                databasehandler = db;
                s = id_hp;
                s1 = codename;
                s2 = (new StringBuilder("Benchmark ")).append(namalengkap).append(" - ").append(benchmark_apps).toString();
                s3 = benchmark_apps;
                if (photo_upload != null)
                {
                    break MISSING_BLOCK_LABEL_335;
                }
                view = "";
_L2:
                databasehandler.addArtUser(s, s1, "benchmark", s2, s3, view, "", edtPertanyaan.getText().toString(), curtime);
                return;
_L1:
                String s3;
                try
                {
                    databasehandler.update_byARTID(s, s1, s2, view, edtPertanyaan.getText().toString(), edtJudulAskHp.getText().toString().replace(".", "").trim());
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
                this$0 = RoomPostBenchmark.this;
                super();
            }
        });
        btnPostAskHp.setOnClickListener(new android.view.View.OnClickListener() {

            final RoomPostBenchmark this$0;

            public void onClick(View view)
            {
                if (netInfo != null && netInfo.isConnected())
                {
                    btnPostAskHp.setEnabled(false);
                    if (photo_upload == null)
                    {
                        Toast.makeText(getApplicationContext(), "Screenshoot benchmark belum diisi", 1).show();
                        return;
                    }
                    if (benchmark_apps.equals(""))
                    {
                        Toast.makeText(getApplicationContext(), "Aplikasi benchmark belum diisi", 1).show();
                        return;
                    }
                    Log.e("photo", "oke");
                    view = (new StringBuilder(String.valueOf(String.valueOf(now.get(12))))).append(now.get(13)).toString();
                    notif_id = Integer.parseInt(view);
                    mNotifyManager = (NotificationManager)getSystemService("notification");
                    mBuilder = new android.support.v4.app.NotificationCompat.Builder(RoomPostBenchmark.this);
                    mBuilder.setContentTitle((new StringBuilder("Benchmark ")).append(namalengkap).append(" - ").append(benchmark_apps).toString()).setContentText("Mengirim 0%").setSmallIcon(0x7f0201e4);
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
                this$0 = RoomPostBenchmark.this;
                super();
            }
        });
        if (!str_from.equals("notif"))
        {
            break MISSING_BLOCK_LABEL_1268;
        }
        dialog = extras.getString("id_date");
        curtime = dialog;
        if (!db.checkArtIfExist(dialog))
        {
            break MISSING_BLOCK_LABEL_1268;
        }
        cursor = db.getARTID(dialog);
        cursor.moveToFirst();
        id_hp = cursor.getString(1);
        benchmark_apps = cursor.getString(5);
        if (!benchmark_apps.equals(""))
        {
            break MISSING_BLOCK_LABEL_1227;
        }
        btnbenchmark.setText("Aplikasi digunakan?");
_L1:
        edtJudulAskHp.setText(cursor.getString(8));
        if (cursor.getString(6).equals(""))
        {
            break MISSING_BLOCK_LABEL_1268;
        }
        dialog = new File(cursor.getString(6));
        if (dialog.exists())
        {
            dialog = BitmapFactory.decodeFile(dialog.getAbsolutePath());
            imgAskHp.setImageBitmap(dialog);
            return;
        }
        break MISSING_BLOCK_LABEL_1253;
        try
        {
            btnbenchmark.setText(cursor.getString(5));
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
            return;
        }
          goto _L1
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
