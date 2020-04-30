// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gcm.GCMRegistrar;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity, KebijakanActivity, RegisterActivity

public class LoginActivity extends FragmentActivity
    implements Observer
{
    private class AddDBTask extends AsyncTask
    {

        final LoginActivity this$0;

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
            Log.e("login", "success");
            ponselBaseApp.getObserver().setLoginStat("1");
            if (classname.equals("com.inponsel.android.SplashScreen"))
            {
                Log.e("stack", "1");
                void1 = new Intent(LoginActivity.this, com/inponsel/android/v2/HomeNewMainActivity);
                void1.addFlags(0x4000000);
                void1.addFlags(32768);
                startActivityForResult(void1, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
                finish();
            } else
            {
                Log.e("stack", "2");
                finish();
            }
            finish();
        }

        protected void onPreExcute()
        {
            super.onPreExecute();
            db.resetUnreadMSGTables();
        }

        void parseJSON(String s)
            throws Exception
        {
            JSONObject jsonobject;
            DatabaseHandler databasehandler;
            String s1;
            String s2;
            String s3;
            String s4;
            String s5;
            String s6;
            String s7;
            String s8;
            String s9;
            String s10;
            String s11;
            String s12;
            String s13;
            String s14;
            String s15;
            String s16;
            String s17;
            String s18;
            String s19;
            String s20;
            String s21;
            String s22;
            String s23;
            String s24;
            String s25;
            android.content.SharedPreferences.Editor editor;
            int i;
            try
            {
                s = (new JSONObject(s)).getJSONArray("InPonsel");
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
            databasehandler = new DatabaseHandler(getApplicationContext());
            s1 = jsonobject.getString("id");
            s2 = jsonobject.getString("name");
            s3 = jsonobject.getString("avatar");
            s4 = jsonobject.getString("uname");
            s5 = jsonobject.getString("umail");
            s6 = jsonobject.getString("uborn");
            s7 = jsonobject.getString("uprov");
            s8 = jsonobject.getString("ucity");
            s9 = jsonobject.getString("ugen");
            s10 = jsonobject.getString("uphone1");
            s11 = jsonobject.getString("uphone2");
            s12 = jsonobject.getString("uope1");
            s13 = jsonobject.getString("uope2");
            s14 = jsonobject.getString("ujdate");
            s15 = jsonobject.getString("modified_date");
            s16 = jsonobject.getString("mailnotif");
            s17 = jsonobject.getString("pushnotif");
            s18 = jsonobject.getString("komnotif");
            s19 = jsonobject.getString("likenotif");
            s20 = jsonobject.getString("tanggapnotif");
            s21 = jsonobject.getString("komennotif_push");
            s22 = jsonobject.getString("likenotif_push");
            s23 = jsonobject.getString("tanggapnotif_push");
            s24 = jsonobject.getString("codephone1");
            s25 = jsonobject.getString("codephone2");
            databasehandler.addUnread(jsonobject.getString("unread"));
            editor = getApplicationContext().getSharedPreferences("UnreadGroup", 0).edit();
            editor.putString("unread_group", jsonobject.getString("unread_group"));
            editor.commit();
            Log.e("user_id_encr", EncodeDecodeAES.encrypt(RestClient.pelihara, s1));
            databasehandler.addUser(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, jsonobject.getString("ukec"));
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_40;
            }
        }

        private AddDBTask()
        {
            this$0 = LoginActivity.this;
            super();
        }

        AddDBTask(AddDBTask adddbtask)
        {
            this();
        }
    }

    public class LoginTask extends AsyncTask
    {

        final LoginActivity this$0;

        private void parseJSONLogin(String s)
        {
            try
            {
                s = new JSONObject(s);
                loginStatus = s.getString("success");
                loginMessage = s.getString("message");
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
            String s1;
            String s2;
            String s3;
            avoid = "";
            s1 = "";
            s2 = inputEmail.getText().toString().trim();
            s3 = Utility.session(Utility.session(Utility.session(Utility.session(Utility.session(inputPassword.getText().toString())))));
            String s = URLEncoder.encode(Build.MODEL, "utf-8");
            avoid = s;
            int i = android.os.Build.VERSION.SDK_INT;
            s1 = String.valueOf(i);
            avoid = s;
_L2:
            UnsupportedEncodingException unsupportedencodingexception;
            try
            {
                regid = prefGCM.getString("gcm_id", null);
                query = (new StringBuilder("user_name=")).append(s2).append("&user_password=").append(s3).append("&t=").append(t).append("&reg=").append(regid).append("&dev=").append(avoid).append("&dos=").append(s1).toString();
                pushURL = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("login_user").append(Utility.BASE_FORMAT).append("?").append(query).toString();
                Log.e("pushURL", pushURL);
                avoid = HttpPush.getResponse(pushURL);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(query).toString());
                res = avoid.toString();
                Log.e("url ", res);
                parseJSONLogin(res);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                return null;
            }
            return null;
            unsupportedencodingexception;
            unsupportedencodingexception.printStackTrace();
            if (true) goto _L2; else goto _L1
_L1:
        }

        public void execute(String s)
        {
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            try
            {
                if (loginStatus.equals("0"))
                {
                    Toast.makeText(LoginActivity.this, loginMessage, 1).show();
                    mGoogleNow.setVisibility(8);
                    inputEmail.setEnabled(true);
                    inputPassword.setEnabled(true);
                    chkRemember.setEnabled(true);
                    btnLogin.setEnabled(true);
                    btnLinkToRegister.setEnabled(true);
                    btnSkip.setEnabled(true);
                    txtKebijakan.setEnabled(true);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            try
            {
                (new AddDBTask(null)).execute(new String[] {
                    pushURL
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1) { }
            void1.printStackTrace();
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            status = "";
            txtKebijakan.setEnabled(false);
            inputEmail.setEnabled(false);
            inputPassword.setEnabled(false);
            chkRemember.setEnabled(false);
            btnLogin.setEnabled(false);
            btnLinkToRegister.setEnabled(false);
            btnSkip.setEnabled(false);
            mGoogleNow.setVisibility(0);
        }

        public LoginTask()
        {
            this$0 = LoginActivity.this;
            super();
        }
    }


    static ConnectivityManager cm;
    public static String email;
    public static String emails;
    public static String password = "";
    public static String passwords = "";
    public static String savePass;
    String activitystat;
    RelativeLayout btnLinkToRegister;
    Button btnLogin;
    RelativeLayout btnSkip;
    CheckBox chkRemember;
    String classname;
    DatabaseHandler db;
    Bundle extras;
    String getJson;
    EditText inputEmail;
    EditText inputPassword;
    JSONObject json;
    TextView loginErrorMsg;
    String loginMessage;
    android.content.SharedPreferences.Editor loginPrefEditor;
    SharedPreferences loginPreference;
    String loginStatus;
    LoginTask loginTask;
    ProgressDialog mDialog;
    private SmoothProgressBar mGoogleNow;
    String passlam;
    PonselBaseApp ponselBaseApp;
    SharedPreferences prefGCM;
    String pushURL;
    String query;
    String regid;
    String res;
    Boolean saveLogin;
    String status;
    String t;
    TextView txtKebijakan;
    TextView txtLoginDaftar;
    TextView txtLoginLanjutkan;
    TextView txtLoginLupa;
    UserFunctions userFunction;
    ContextThemeWrapper wrapper;

    public LoginActivity()
    {
        regid = "";
        status = "";
        t = Utility.session(RestClient.pelihara);
        loginTask = null;
        activitystat = "";
        loginStatus = "";
        loginMessage = "";
        classname = "";
    }

    public void checkField()
    {
        if (inputEmail.getText().toString().length() < 4 || inputPassword.getText().toString().length() < 4 || inputEmail.getText().toString().trim().equals("") || inputPassword.getText().toString().trim().equals(""))
        {
            btnLogin.setEnabled(false);
            return;
        } else
        {
            btnLogin.setEnabled(true);
            return;
        }
    }

    public void onBackPressed()
    {
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300d0);
        db = new DatabaseHandler(this);
        userFunction = new UserFunctions();
        bundle = ((ActivityManager)getSystemService("activity")).getRunningTasks(10);
        classname = ((android.app.ActivityManager.RunningTaskInfo)bundle.get(0)).baseActivity.getClassName();
        if (((android.app.ActivityManager.RunningTaskInfo)bundle.get(0)).numActivities == 1 && ((android.app.ActivityManager.RunningTaskInfo)bundle.get(0)).topActivity.getClassName().equals(getClass().getName()))
        {
            Log.e("Activity1", classname);
        } else
        {
            Log.e("Activity2", classname);
        }
        if (!Build.MODEL.equals("Nokia_X") && !Build.MODEL.contains("nokia") && !Build.MODEL.contains("blackberry"))
        {
            regid = GCMRegistrar.getRegistrationId(this);
            Log.e("regid", regid);
            prefGCM = getApplicationContext().getSharedPreferences("GCMPref", 0);
            bundle = prefGCM.edit();
            bundle.putString("gcm_id", regid);
            bundle.commit();
        }
        wrapper = new ContextThemeWrapper(this, 0x103006e);
        mGoogleNow = (SmoothProgressBar)findViewById(0x7f0b067e);
        mGoogleNow.setVisibility(8);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        mDialog = new ProgressDialog(this);
        inputEmail = (EditText)findViewById(0x7f0b046e);
        inputPassword = (EditText)findViewById(0x7f0b046f);
        btnLogin = (Button)findViewById(0x7f0b0474);
        btnSkip = (RelativeLayout)findViewById(0x7f0b0477);
        btnLinkToRegister = (RelativeLayout)findViewById(0x7f0b0475);
        loginErrorMsg = (TextView)findViewById(0x7f0b0470);
        txtLoginLanjutkan = (TextView)findViewById(0x7f0b0478);
        txtLoginDaftar = (TextView)findViewById(0x7f0b0476);
        txtLoginLupa = (TextView)findViewById(0x7f0b0473);
        t = Utility.session(t);
        cm = (ConnectivityManager)getSystemService("connectivity");
        extras = getIntent().getExtras();
        loginTask = new LoginTask();
        txtKebijakan = (TextView)findViewById(0x7f0b0479);
        bundle = new SpannableString("Kebijakan Privasi");
        bundle.setSpan(new UnderlineSpan(), 0, bundle.length(), 0);
        bundle.setSpan(new StyleSpan(1), 0, bundle.length(), 0);
        txtKebijakan.setText(bundle);
        txtKebijakan.setOnClickListener(new android.view.View.OnClickListener() {

            final LoginActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/KebijakanActivity);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        });
        bundle = new SpannableString("Lupa Password?");
        bundle.setSpan(new UnderlineSpan(), 0, bundle.length(), 0);
        bundle.setSpan(new StyleSpan(1), 0, bundle.length(), 0);
        txtLoginLupa.setText(bundle);
        txtLoginLupa.setOnClickListener(new android.view.View.OnClickListener() {

            final LoginActivity this$0;

            public void onClick(View view)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://inponsel.co.id/member/reset/kata-sandi")));
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        });
        chkRemember = (CheckBox)findViewById(0x7f0b0471);
        loginPreference = getSharedPreferences("com.inponsel.android_preference", 0);
        loginPrefEditor = loginPreference.edit();
        saveLogin = Boolean.valueOf(loginPreference.getBoolean("saveLogin", false));
        chkRemember.setText("Ingatkan username & password");
        btnLogin.setEnabled(true);
        if (saveLogin.booleanValue())
        {
            try
            {
                passlam = EncodeDecodeAES.decrypt(RestClient.pelihara, loginPreference.getString("save", ""));
                inputEmail.setText(loginPreference.getString("email", ""));
                inputPassword.setText(passlam);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
            chkRemember.setChecked(true);
        }
        btnSkip.setOnClickListener(new android.view.View.OnClickListener() {

            final LoginActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(LoginActivity.this, com/inponsel/android/v2/HomeNewMainActivity);
                if (activitystat.equals("main"))
                {
                    Log.e("stack", "1");
                    view.addFlags(0x4000000);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    finish();
                    return;
                } else
                {
                    Log.e("stack", "0");
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    finish();
                    return;
                }
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        });
        inputEmail.addTextChangedListener(new TextWatcher() {

            final LoginActivity this$0;

            public void afterTextChanged(Editable editable)
            {
                checkField();
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                checkField();
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                checkField();
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        });
        t = Utility.session(t);
        inputPassword.addTextChangedListener(new TextWatcher() {

            final LoginActivity this$0;

            public void afterTextChanged(Editable editable)
            {
                checkField();
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                checkField();
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                checkField();
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        });
        mDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final LoginActivity this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                if (loginTask != null && loginTask.getStatus() != android.os.AsyncTask.Status.FINISHED)
                {
                    loginTask.cancel(true);
                }
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        });
        btnLogin.setOnClickListener(new android.view.View.OnClickListener() {

            final LoginActivity this$0;

            public void onClick(View view)
            {
                if (!inputEmail.getText().toString().equals("") || !inputPassword.getText().toString().equals("")) goto _L2; else goto _L1
_L1:
                Toast.makeText(getApplicationContext(), "Username dan password belum diisi", 1).show();
                btnLogin.setEnabled(false);
_L8:
                return;
_L2:
                if (view != btnLogin) goto _L4; else goto _L3
_L3:
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(inputEmail.getWindowToken(), 0);
                LoginActivity.emails = inputEmail.getText().toString().trim();
                LoginActivity.passwords = inputPassword.getText().toString();
                LoginActivity.savePass = EncodeDecodeAES.encrypt(RestClient.pelihara, inputPassword.getText().toString());
                loginPrefEditor.putString("save", LoginActivity.savePass);
                if (!chkRemember.isChecked()) goto _L6; else goto _L5
_L5:
                loginPrefEditor.putBoolean("saveLogin", true);
                loginPrefEditor.putString("email", LoginActivity.emails);
                loginPrefEditor.putString("pref", LoginActivity.savePass);
_L9:
                loginPrefEditor.commit();
_L4:
                if (LoginActivity.cm.getActiveNetworkInfo() == null || !LoginActivity.cm.getActiveNetworkInfo().isAvailable() || !LoginActivity.cm.getActiveNetworkInfo().isConnected()) goto _L8; else goto _L7
_L7:
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new LoginTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new LoginTask()).execute(new Void[0]);
                    return;
                }
_L6:
                loginPrefEditor.clear();
                  goto _L9
                view;
                view.printStackTrace();
                  goto _L4
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        });
        btnLinkToRegister.setOnClickListener(new android.view.View.OnClickListener() {

            final LoginActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        });
    }

    public void update(Observable observable, Object obj)
    {
        ponselBaseApp.getObserver().getLoginStat();
    }


}
