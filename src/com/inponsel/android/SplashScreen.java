// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.view.ContextThemeWrapper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.google.android.gcm.GCMRegistrar;
import com.google.gson.Gson;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.Response;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.HomeNewMainActivity;
import com.inponsel.android.v2.LoginActivity;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android:
//            AlertDialogManager, CommonUtilities, WakeLocker, ServerUtilities

public class SplashScreen extends FragmentActivity
{
    private class CheckingTask extends AsyncTask
    {

        final SplashScreen this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            chkConnectionStatus();
            return null;
        }

        protected void onCancelled()
        {
            super.onCancelled();
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            onResultCheck();
            setProgressBarIndeterminateVisibility(false);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            stat.setText("");
            setProgressBarIndeterminateVisibility(true);
        }

        protected volatile transient void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((Void[])aobj);
        }

        protected transient void onProgressUpdate(Void avoid[])
        {
            super.onProgressUpdate(avoid);
        }

        private CheckingTask()
        {
            this$0 = SplashScreen.this;
            super();
        }

        CheckingTask(CheckingTask checkingtask)
        {
            this();
        }
    }

    private class MaintenanceTask extends AsyncTask
    {

        String maintenanceMsg;
        String maintenanceStat;
        Response response;
        final SplashScreen this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = new HttpGet(dataMaintenance);
            Object obj;
            int i;
            try
            {
                obj = (new DefaultHttpClient()).execute(avoid);
                i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
            }
            catch (IOException ioexception)
            {
                avoid.abort();
                return null;
            }
            if (i == 200)
            {
                break MISSING_BLOCK_LABEL_89;
            }
            Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataMaintenance).toString());
            return null;
            obj = new InputStreamReader(((HttpResponse) (obj)).getEntity().getContent());
            response = (Response)(new Gson()).fromJson(((java.io.Reader) (obj)), com/inponsel/android/utils/Response);
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            Log.e("taskLst", "dataMaintenance");
            Log.e("data", dataMaintenance);
            void1 = response.InPonsel.iterator();
            do
            {
                ListModel listmodel;
                do
                {
                    if (!void1.hasNext())
                    {
                        return;
                    }
                    listmodel = (ListModel)void1.next();
                } while (listmodel.getMaintenanceStat().equals("-") && listmodel.getMaintenanceMsg().equals("-"));
                maintenanceStat = listmodel.getMaintenanceStat();
                maintenanceMsg = listmodel.getMaintenanceMsg();
                if (maintenanceStat.equals("1"))
                {
                    progressbar_middle.setVisibility(4);
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                    builder.setTitle("Peringatan");
                    builder.setMessage(maintenanceMsg);
                    builder.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final MaintenanceTask this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            finish();
                        }

            
            {
                this$1 = MaintenanceTask.this;
                super();
            }
                    });
                    builder.show();
                } else
                {
                    login_status();
                }
            } while (true);
        }


        private MaintenanceTask()
        {
            this$0 = SplashScreen.this;
            super();
        }

        MaintenanceTask(MaintenanceTask maintenancetask)
        {
            this();
        }
    }


    public static String curVersion = "";
    public static double currentLat;
    public static double currentLng;
    public static String email = "";
    public static String gambar;
    public static String hrg_baru;
    public static String hrg_bekas;
    public static String id_hph;
    public static String merk;
    public static String model;
    public static String namalengkap;
    public static String name;
    public static String tot_dislike;
    public static String tot_komen;
    public static String tot_like;
    String APIKEY;
    int LOST_CONNECTION;
    AlertDialogManager alert;
    Animation animAlpha;
    Animation animHide;
    Animation animShow;
    Cursor cursor;
    String dataMaintenance;
    Uri dataUrl;
    SQLiteDatabase database;
    DatabaseHandler db;
    Bundle extras;
    String first;
    String host;
    ImageView imgOverlay;
    ImageView imgRotate;
    Intent intent;
    LinearLayout lay_splash;
    LocationListener locationListener;
    LocationManager locationManager;
    String login_msg;
    String login_stat;
    private final WakefulBroadcastReceiver mHandleMessageReceiver = new WakefulBroadcastReceiver() {

        final SplashScreen this$0;

        public void onReceive(Context context, Intent intent1)
        {
            context = intent1.getExtras().getString("message");
            WakeLocker.acquire(getApplicationContext());
            WakeLocker.release();
            Log.e("start", (new StringBuilder("intent")).append(context).toString());
        }

            
            {
                this$0 = SplashScreen.this;
                super();
            }
    };
    AsyncTask mRegisterTask;
    ScrollView myrootLogin;
    NotificationManager notifManager;
    SharedPreferences prefGCM;
    ProgressBar progressbar_middle;
    String regId;
    String scheme;
    String second;
    TextView stat;
    String t;
    String url;
    UserFunctions userFunctions;
    String user_id;
    TextView versi;
    ContextThemeWrapper wrapper;

    public SplashScreen()
    {
        LOST_CONNECTION = 0;
        url = "http://www.inponsel.com";
        APIKEY = "a377c5c8";
        t = Utility.session(RestClient.pelihara);
        alert = new AlertDialogManager();
        scheme = "";
        host = "";
        first = "";
        second = "";
    }

    private void SingleLogin(String s, String s1)
    {
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("last_login").append(Utility.BASE_FORMAT).append("?").append("id_user=").append(s).append("&reg_id=").append(s1).append("&t=").append(t).toString();
        Log.e("pushOnline", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final SplashScreen this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                Log.e("response", jsonobject.toString());
                parseJSON(jsonobject.toString());
                Log.e("login_stat", login_stat);
                if (login_stat.equals("1"))
                {
                    jsonobject = new Intent(SplashScreen.this, com/inponsel/android/v2/HomeNewMainActivity);
                    startActivityForResult(jsonobject, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    finish();
                    return;
                } else
                {
                    notifManager.cancelAll();
                    db.removeAll();
                    jsonobject = new android.app.AlertDialog.Builder(wrapper);
                    jsonobject.setMessage(login_msg);
                    jsonobject.setCancelable(false);
                    jsonobject.setPositiveButton("Lanjutkan", new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.addFlags(0x4000000);
                            dialoginterface.addFlags(32768);
                            dialoginterface.putExtra("activity", "splash");
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                            finish();
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    });
                    jsonobject.show();
                    return;
                }
            }


            
            {
                this$0 = SplashScreen.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final SplashScreen this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = SplashScreen.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "");
    }

    private boolean chkConnectionStatus()
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)getSystemService("connectivity");
        if (connectivitymanager.getActiveNetworkInfo() == null || !connectivitymanager.getActiveNetworkInfo().isAvailable() || !connectivitymanager.getActiveNetworkInfo().isConnected())
        {
            break MISSING_BLOCK_LABEL_44;
        }
        LOST_CONNECTION = 0;
        return false;
        try
        {
            LOST_CONNECTION = 99;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        return false;
    }

    private void login_status()
    {
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            db = new DatabaseHandler(this);
            cursor = db.getAllData();
            cursor.moveToFirst();
            Intent intent1;
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            catch (Exception exception) { }
            SingleLogin(user_id, regId);
            return;
        } else
        {
            intent1 = new Intent(this, com/inponsel/android/v2/HomeNewMainActivity);
            intent1.addFlags(32768);
            startActivityForResult(intent1, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            finish();
            return;
        }
    }

    public void MaintenanceTask()
    {
        dataMaintenance = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("maintenance_status").append(Utility.BASE_FORMAT).append("?lmt=0&t=").append(t).toString();
        (new MaintenanceTask(null)).execute(new Void[0]);
    }

    public void checkLogin()
    {
        login_status();
    }

    public boolean isTablet(Context context)
    {
        boolean flag;
        boolean flag1;
        if ((context.getResources().getConfiguration().screenLayout & 0xf) == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((context.getResources().getConfiguration().screenLayout & 0xf) == 3)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag || flag1;
    }

    protected void onActivityResult(int i, int j, Intent intent1)
    {
        super.onActivityResult(i, j, intent1);
        if (i == 10)
        {
            intent = new Intent(this, com/inponsel/android/SplashScreen);
            startActivity(intent);
            finish();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03008a);
        dataUrl = getIntent().getData();
        myrootLogin = (ScrollView)findViewById(0x7f0b046d);
        lay_splash = (LinearLayout)findViewById(0x7f0b04bd);
        Log.e("dataurl", String.valueOf(dataUrl));
        notifManager = (NotificationManager)getSystemService("notification");
        animShow = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040003);
        animHide = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040000);
        animAlpha = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040000);
        if (!String.valueOf(dataUrl).equals("null"))
        {
            scheme = dataUrl.getScheme();
            host = dataUrl.getHost();
            bundle = dataUrl.getPathSegments();
            first = (String)bundle.get(0);
            id_hph = (String)bundle.get(1);
            Log.e("scheme", scheme);
            Log.e("host", host);
            Log.e("id_hph", id_hph);
        }
        t = Utility.session(t);
        wrapper = new ContextThemeWrapper(this, 0x103006e);
        prefGCM = getApplicationContext().getSharedPreferences("GCMPref", 0);
        if ("android.intent.action.MAIN".equals(getIntent().getAction()))
        {
            Log.w("URLHandler", (new Intent("com.inponsel.android.MY_ACTION")).toUri(1).toString());
        } else
        {
            getIntent().getData();
        }
        if (CommonUtilities.SERVER_URL == null || "546843258034" == null || CommonUtilities.SERVER_URL.length() == 0 || "546843258034".length() == 0)
        {
            return;
        }
        bundle = AccountManager.get(getApplicationContext()).getAccounts();
        int j = bundle.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                userFunctions = new UserFunctions();
                stat = (TextView)findViewById(0x7f0b04bf);
                progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
                versi = (TextView)findViewById(0x7f0b04c0);
                t = Utility.session(t);
                Object obj;
                try
                {
                    curVersion = String.valueOf(getPackageManager().getPackageInfo(getPackageName(), 0).versionCode);
                    versi.setText((new StringBuilder("Versi ")).append(getPackageManager().getPackageInfo(getPackageName(), 0).versionName).toString());
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    bundle.printStackTrace();
                }
                imgOverlay = (ImageView)findViewById(0x7f0b067d);
                imgRotate = (ImageView)findViewById(0x7f0b04be);
                imgRotate.setVisibility(8);
                (new CheckingTask(null)).execute(new Void[0]);
                return;
            }
            obj = bundle[i];
            if (((Account) (obj)).name.endsWith("gmail.com"))
            {
                email = ((Account) (obj)).name;
            }
            i++;
        } while (true);
    }

    protected void onDestroy()
    {
        if (mRegisterTask != null)
        {
            mRegisterTask.cancel(true);
        }
        try
        {
            unregisterReceiver(mHandleMessageReceiver);
            GCMRegistrar.onDestroy(this);
        }
        catch (Exception exception)
        {
            Log.e("UnRegister Receiver Error", (new StringBuilder("> ")).append(exception.getMessage()).toString());
        }
        super.onDestroy();
    }

    void onResultCheck()
    {
        Log.e("stattus", String.valueOf(LOST_CONNECTION));
        android.content.SharedPreferences.Editor editor;
        try
        {
            if (LOST_CONNECTION == 99)
            {
                progressbar_middle.setVisibility(8);
                stat.setText("Koneksi internet dibutuhkan");
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                builder.setTitle("Aktifkan Internet");
                builder.setMessage("Aplikasi ini membutuhkan koneksi internet. Apakah anda ingin mengaktifkannya sekarang?");
                builder.setPositiveButton("2G/3G/LTE", new android.content.DialogInterface.OnClickListener() {

                    final SplashScreen this$0;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        if (isTablet(getApplicationContext()))
                        {
                            intent = new Intent("android.settings.WIFI_SETTINGS");
                        } else
                        {
                            intent = new Intent("android.settings.DATA_ROAMING_SETTINGS");
                            intent.addCategory("android.intent.category.LAUNCHER");
                            dialoginterface = new ComponentName("com.android.phone", "com.android.phone.Settings");
                            intent.setComponent(dialoginterface);
                        }
                        intent.setFlags(0x10000000);
                        startActivityForResult(intent, 10);
                    }

            
            {
                this$0 = SplashScreen.this;
                super();
            }
                });
                builder.setNeutralButton("WiFi", new android.content.DialogInterface.OnClickListener() {

                    final SplashScreen this$0;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        intent = new Intent("android.settings.WIFI_SETTINGS");
                        startActivityForResult(intent, 10);
                    }

            
            {
                this$0 = SplashScreen.this;
                super();
            }
                });
                builder.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                    final SplashScreen this$0;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        finish();
                    }

            
            {
                this$0 = SplashScreen.this;
                super();
            }
                });
                builder.show();
                builder.setCancelable(true);
                return;
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return;
        }
        if (Build.MODEL.equals("Nokia_X") || Build.MODEL.contains("nokia") || Build.MODEL.contains("blackberry")) goto _L2; else goto _L1
_L1:
        GCMRegistrar.checkDevice(this);
        GCMRegistrar.checkManifest(this);
        regId = GCMRegistrar.getRegistrationId(this);
        prefGCM = getApplicationContext().getSharedPreferences("GCMPref", 0);
        editor = prefGCM.edit();
        editor.putString("gcm_id", regId);
        editor.commit();
        registerReceiver(mHandleMessageReceiver, new IntentFilter("com.inponsel.android.DISPLAY_MESSAGE"));
        if (!regId.equals("")) goto _L4; else goto _L3
_L3:
        GCMRegistrar.register(this, new String[] {
            "546843258034"
        });
_L2:
        (new Handler()).postDelayed(new Runnable() {

            final SplashScreen this$0;

            public void run()
            {
                checkLogin();
            }

            
            {
                this$0 = SplashScreen.this;
                super();
            }
        }, 1000L);
        return;
_L4:
        if (GCMRegistrar.isRegisteredOnServer(this)) goto _L2; else goto _L5
_L5:
        mRegisterTask = new AsyncTask() {

            final SplashScreen this$0;
            private final Context val$context;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                ServerUtilities.register(context, SplashScreen.name, SplashScreen.email, regId);
                return null;
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Void)obj);
            }

            protected void onPostExecute(Void void1)
            {
                mRegisterTask = null;
            }

            
            {
                this$0 = SplashScreen.this;
                context = context1;
                super();
            }
        };
        mRegisterTask.execute(new Void[] {
            null, null, null
        });
          goto _L2
    }

    void parseJSON(String s)
    {
        try
        {
            s = new JSONObject(s);
            login_stat = s.getString("success");
            login_msg = s.getString("message_stat");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    static 
    {
        name = Build.MODEL;
    }


}
