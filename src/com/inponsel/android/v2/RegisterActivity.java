// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ListAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ListOperatorAdapter;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.ClickSpan;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            KebijakanActivity

public class RegisterActivity extends SherlockFragmentActivity
{
    public class EmailCheckTask extends AsyncTask
    {

        final RegisterActivity this$0;

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
                avoid = (new StringBuilder("user_email=")).append(edtEmail.getText().toString()).append("&t=").append(t).toString();
                String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("email_check").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", s);
                s = HttpPush.getResponse(s);
                Log.e("push", (new StringBuilder(String.valueOf(s))).append(" ").append(Util.BASE_PATH2).append("email_check").append(Utility.BASE_FORMAT).append("?").append(avoid).toString());
                res = s.toString();
                Log.e("url.............", res);
                res = res.trim();
                res = res.replaceAll("\\s+", "");
                Log.e("status", res);
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
            progressbar_email.setVisibility(8);
            if (!res.equals("1")) goto _L2; else goto _L1
_L1:
            Log.e("valid", "1");
            txtcekemail.setVisibility(8);
_L3:
            checkField();
            return;
_L2:
label0:
            {
                if (!res.equals("404"))
                {
                    break label0;
                }
                Toast.makeText(RegisterActivity.this, "Username sudah terdaftar", 1).show();
            }
              goto _L3
label1:
            {
                if (!res.equals("40404"))
                {
                    break label1;
                }
                Log.e("valid", "40404");
                txtcekemail.setVisibility(0);
                txtcekemail.setText("Email sudah terdaftar");
                txtcekemail.setTextColor(Color.parseColor("#db261e"));
                btnSubmit.setEnabled(false);
                edtEmail.startAnimation(animation);
            }
              goto _L3
label2:
            {
                if (!res.equals("1240404"))
                {
                    break label2;
                }
                txtcekemail.setVisibility(0);
                txtcekemail.setText("Email tidak valid");
                txtcekemail.setTextColor(Color.parseColor("#db261e"));
                btnSubmit.setEnabled(false);
                edtEmail.startAnimation(animation);
            }
              goto _L3
            try
            {
                Toast.makeText(RegisterActivity.this, "Posting gagal", 1).show();
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L3
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressbar_email.setVisibility(0);
        }

        public EmailCheckTask()
        {
            this$0 = RegisterActivity.this;
            super();
        }
    }

    private class KecamatanSync extends AsyncTask
    {

        final RegisterActivity this$0;

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
            kecamatan_strarray = new String[kecamatanArray.size()];
            kecamatan_strarray = (String[])kecamatanArray.toArray(kecamatan_strarray);
            kecamatan_strarrayID = new String[kecamatanArrayID.size()];
            kecamatan_strarrayID = (String[])kecamatanArrayID.toArray(kecamatan_strarrayID);
            Log.e("preference", provinsiprefrence);
            saveArray(kecamatan_strarray, "kecamatanArray", getApplicationContext());
            saveArray(kecamatan_strarrayID, "kecamatanArrayID", getApplicationContext());
            progressbar_search.setVisibility(8);
            if (!jml.equals("0"))
            {
                break MISSING_BLOCK_LABEL_266;
            }
            txtEmpty.setText(0x7f0c0058);
            layout_empty.setVisibility(0);
_L1:
            log((new StringBuilder("lenght arrayList : ")).append(listKecamatanArrayList.size()).toString());
            listOperatorAdapter.setListArray(listKecamatanArrayList);
            listOperatorAdapter.notifyDataSetChanged();
            return;
            try
            {
                layout_empty.setVisibility(8);
                listHp.setVisibility(0);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
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
                listKecamatanArrayList = new ArrayList();
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
                jml = String.valueOf(s.length());
                Log.e("jarray", jml);
                return;
            }
            jsonobject = s.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setKecamatan_id(jsonobject.getString("id"));
            listmodel.setNm_op(jsonobject.getString("kecamatan"));
            kecamatan_str = jsonobject.getString("kecamatan");
            kecamatan_strID = jsonobject.getString("id");
            kecamatanArray.add(kecamatan_str);
            kecamatanArrayID.add(kecamatan_strID);
            listKecamatanArrayList.add(listmodel);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_56;
            }
        }

        private KecamatanSync()
        {
            this$0 = RegisterActivity.this;
            super();
        }

        KecamatanSync(KecamatanSync kecamatansync)
        {
            this();
        }
    }

    private class KotaSync extends AsyncTask
    {

        final RegisterActivity this$0;

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
            kota_strarray = new String[kotaArray.size()];
            kota_strarray = (String[])kotaArray.toArray(kota_strarray);
            kota_strarrayID = new String[kotaArrayID.size()];
            kota_strarrayID = (String[])kotaArrayID.toArray(kota_strarrayID);
            Log.e("preference", provinsiprefrence);
            saveArray(kota_strarray, "kotaArray", getApplicationContext());
            saveArray(kota_strarrayID, "kotaArrayID", getApplicationContext());
            progressbar_search.setVisibility(8);
            if (!jml.equals("0"))
            {
                break MISSING_BLOCK_LABEL_266;
            }
            txtEmpty.setText(0x7f0c0058);
            layout_empty.setVisibility(0);
_L1:
            log((new StringBuilder("lenght arrayList : ")).append(listKotaArrayList.size()).toString());
            listOperatorAdapter.setListArray(listKotaArrayList);
            listOperatorAdapter.notifyDataSetChanged();
            return;
            try
            {
                layout_empty.setVisibility(8);
                listHp.setVisibility(0);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
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
                listKotaArrayList = new ArrayList();
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
                jml = String.valueOf(s.length());
                Log.e("jarray", jml);
                return;
            }
            jsonobject = s.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setKota_id(jsonobject.getString("id"));
            listmodel.setProvinsi_id(jsonobject.getString("provinsi_id"));
            listmodel.setNm_op(jsonobject.getString("kota"));
            kota_str = jsonobject.getString("kota");
            kota_strID = jsonobject.getString("id");
            kotaArray.add(kota_str);
            kotaArrayID.add(kota_strID);
            listKotaArrayList.add(listmodel);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_56;
            }
        }

        private KotaSync()
        {
            this$0 = RegisterActivity.this;
            super();
        }

        KotaSync(KotaSync kotasync)
        {
            this();
        }
    }

    private class OperatorSync extends AsyncTask
    {

        final RegisterActivity this$0;

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
            provider_array = new String[providerArray.size()];
            provider_array = (String[])providerArray.toArray(provider_array);
            provider_arrayhpID = new String[providerArrayID.size()];
            provider_arrayhpID = (String[])providerArrayID.toArray(provider_arrayhpID);
            saveArray(provider_array, "providerArray", getApplicationContext());
            saveArray(provider_arrayhpID, "providerArrayID", getApplicationContext());
            progressbar_search.setVisibility(8);
            if (!jml.equals("0"))
            {
                break MISSING_BLOCK_LABEL_254;
            }
            txtEmpty.setText(0x7f0c0058);
            layout_empty.setVisibility(0);
_L1:
            log((new StringBuilder("lenght arrayList : ")).append(listOpArrayList.size()).toString());
            listOperatorAdapter.setListArray(listOpArrayList);
            listOperatorAdapter.notifyDataSetChanged();
            return;
            try
            {
                layout_empty.setVisibility(8);
                listHp.setVisibility(0);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
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
                listOpArrayList = new ArrayList();
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
                jml = String.valueOf(s.length());
                Log.e("jarray", jml);
                return;
            }
            jsonobject = s.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_op(jsonobject.getString("id"));
            listmodel.setNm_op(jsonobject.getString("nm_op"));
            provider_kartu = jsonobject.getString("nm_op");
            provider_ID = jsonobject.getString("id");
            providerArray.add(provider_kartu);
            providerArrayID.add(provider_ID);
            listOpArrayList.add(listmodel);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_56;
            }
        }

        private OperatorSync()
        {
            this$0 = RegisterActivity.this;
            super();
        }

        OperatorSync(OperatorSync operatorsync)
        {
            this();
        }
    }

    private class ProvinsiSync extends AsyncTask
    {

        final RegisterActivity this$0;

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
            provinsi_strarray = new String[provinsiArray.size()];
            provinsi_strarray = (String[])provinsiArray.toArray(provinsi_strarray);
            provinsi_strarrayID = new String[provinsiArrayID.size()];
            provinsi_strarrayID = (String[])provinsiArrayID.toArray(provinsi_strarrayID);
            saveArray(provinsi_strarray, "provinsiArray", getApplicationContext());
            saveArray(provinsi_strarrayID, "provinsiArrayID", getApplicationContext());
            progressbar_search.setVisibility(8);
            if (!jml.equals("0") && jml != null)
            {
                break MISSING_BLOCK_LABEL_264;
            }
            txtEmpty.setText(0x7f0c0058);
            layout_empty.setVisibility(0);
_L1:
            log((new StringBuilder("lenght arrayList : ")).append(listProvArrayList.size()).toString());
            listOperatorAdapter.setListArray(listProvArrayList);
            listOperatorAdapter.notifyDataSetChanged();
            return;
            try
            {
                layout_empty.setVisibility(8);
                listHp.setVisibility(0);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
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
                listProvArrayList = new ArrayList();
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
                jml = String.valueOf(listProvArrayList.size());
                Log.e("jarray", jml);
                return;
            }
            jsonobject = s.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setProvinsi_id(jsonobject.getString("id"));
            listmodel.setNm_op(jsonobject.getString("provinsi"));
            provinsi_str = jsonobject.getString("provinsi");
            provinsi_strID = jsonobject.getString("id");
            provinsiArray.add(provinsi_str);
            provinsiArrayID.add(provinsi_strID);
            listProvArrayList.add(listmodel);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_56;
            }
        }

        private ProvinsiSync()
        {
            this$0 = RegisterActivity.this;
            super();
        }

        ProvinsiSync(ProvinsiSync provinsisync)
        {
            this();
        }
    }

    public class RegisterTask extends AsyncTask
    {

        final RegisterActivity this$0;

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
                nama = nama.replace(" ", "%20");
                pass = pass.replace(" ", "%20");
                provinsi = provinsi.replace(" ", "%20");
                kota = kota.replace(" ", "%20");
                namaHp = namaHp.replace(" ", "%20");
                namaHp = namaHp.replace("+", "%2B");
                if (namaHp2.equals(""))
                {
                    namaHp2 = "NULL";
                }
                namaHp2 = namaHp2.replace(" ", "%20");
                namaHp2 = namaHp2.replace("+", "%2B");
                provider = provider.replace(" ", "%20");
                if (provider2.equals(""))
                {
                    provider2 = "NULL";
                }
                provider2 = provider2.replace(" ", "%20");
                avoid = (new StringBuilder("user_nama_asli=")).append(nama).append("&user_name=").append(usernama).append("&user_photo=").append("NULL").append("&user_password=").append(pass).append("&user_email=").append(email).append("&user_ttl=").append(selectDate).append("&user_provinsi=").append(provinsi).append("&user_kota=").append(kota).append("&user_kec=").append(kecamatan_id).append("&user_jekel=").append(jenisKelamin).append("&user_ponsel_1=").append(namaHp).append("&user_ponsel_2=").append(namaHp2).append("&user_operator_1=").append(provider).append("&user_operator_2=").append(provider2).append("&t=").append(t).toString();
                String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("register_account").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURLDaftar", s);
                mail_register = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_register_account").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                s = HttpPush.getResponse(s);
                Log.e("push", (new StringBuilder(String.valueOf(s))).append(" ").append(Util.BASE_PATH2).append("register_account").append(Utility.BASE_FORMAT).append("?").append(avoid).toString());
                res = s.toString();
                Log.e("url.............", res);
                Log.e("status", res);
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
            mDialog.dismiss();
            try
            {
                void1 = new JSONObject(res);
                if (void1.getString("success").equals("1"))
                {
                    mail_register = (new StringBuilder(String.valueOf(mail_register))).append("&activation_key=").append(void1.getString("activation_key")).toString();
                    push_register_mail(mail_register);
                    void1 = new android.app.AlertDialog.Builder(wrapper);
                    void1.setTitle("Perhatian!");
                    void1.setMessage((new StringBuilder("Tautan aktivasi akun sudah terkirim ke email ")).append(email).append(". Silahkan hubungi support@inponsel.co.id jika anda mengalami masalah lebih lanjut.").toString());
                    void1.setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

                        final RegisterTask this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            finish();
                        }

            
            {
                this$1 = RegisterTask.this;
                super();
            }
                    });
                    void1.show();
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            if (res.equals("404"))
            {
                Toast.makeText(RegisterActivity.this, "Username sudah terdaftar", 1).show();
                return;
            }
            if (res.equals("40404"))
            {
                Toast.makeText(RegisterActivity.this, "Email sudah terdaftar", 1).show();
                return;
            }
            Toast.makeText(RegisterActivity.this, "Register gagal", 1).show();
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mDialog = ProgressDialog.show(wrapper, "", "Registering...", true);
            mDialog.setCancelable(false);
            mDialog.show();
        }


        public RegisterTask()
        {
            this$0 = RegisterActivity.this;
            super();
        }
    }

    private class SearchHpSync extends AsyncTask
    {

        String suc;
        final RegisterActivity this$0;

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
            progressbar_search.setVisibility(8);
            if (!suc.equals("0"))
            {
                break MISSING_BLOCK_LABEL_173;
            }
            if (android.os.Build.VERSION.SDK_INT < 13)
            {
                txtEmpty.setTextColor(-1);
            }
            txtEmpty.setText("Tidak temukan silahkan tulis ponsel anda di bawah ini");
            layout_empty.setVisibility(0);
            btnSubmitHp.setVisibility(0);
            btnSubmitHp.setVisibility(0);
            edtHpKetik.setVisibility(0);
            listHp.setVisibility(8);
_L1:
            log((new StringBuilder("lenght arrayList : ")).append(listArrayList.size()).toString());
            listAdapter.setListArray(listArrayList);
            listAdapter.notifyDataSetChanged();
            return;
            try
            {
                layout_empty.setVisibility(8);
                btnSubmitHp.setVisibility(8);
                edtHpKetik.setVisibility(8);
                listHp.setVisibility(0);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
        }

        protected void onPreExcute()
        {
            super.onPreExecute();
            Log.e("search", (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(edtAuto.getText().toString()).append("&t=").append(t).toString());
        }

        void parseJSON(String s)
        {
            JSONObject jsonobject1;
            ListModel listmodel;
            int i;
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                listArrayList = new ArrayList();
                s = jsonobject.getJSONArray("InPonsel");
                suc = jsonobject.getString("success");
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
                jml = String.valueOf(s.length());
                Log.e("jarray", jml);
                return;
            }
            jsonobject1 = s.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_hp(jsonobject1.getString("id_hp"));
            listmodel.setGambar(jsonobject1.getString("gambar"));
            listmodel.setNamalengkap((new StringBuilder(String.valueOf(jsonobject1.getString("merk")))).append(" ").append(jsonobject1.getString("model")).toString());
            listmodel.setModel(jsonobject1.getString("model"));
            listmodel.setMerk(jsonobject1.getString("merk"));
            listArrayList.add(listmodel);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_66;
            }
        }

        private SearchHpSync()
        {
            this$0 = RegisterActivity.this;
            super();
        }

        SearchHpSync(SearchHpSync searchhpsync)
        {
            this();
        }
    }

    public class UserCheckTask extends AsyncTask
    {

        final RegisterActivity this$0;

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
                avoid = (new StringBuilder("user_email=")).append(edtUserName.getText().toString()).append("&t=").append(t).toString();
                String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("email_check").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", s);
                s = HttpPush.getResponse(s);
                Log.e("push", (new StringBuilder(String.valueOf(s))).append(" ").append(Util.BASE_PATH2).append("email_check").append(Utility.BASE_FORMAT).append("?").append(avoid).toString());
                res = s.toString();
                Log.e("url.............", res);
                res = res.trim();
                res = res.replaceAll("\\s+", "");
                Log.e("status", res);
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
            progressbar_username.setVisibility(8);
            if (!res.equals("1")) goto _L2; else goto _L1
_L1:
            txtcekusername.setVisibility(0);
            Log.e("valid", "1");
            txtcekusername.setText("Username tersedia");
            txtcekusername.setTextColor(Color.parseColor("#26A908"));
_L5:
            checkField();
            return;
_L2:
            if (!res.equals("404")) goto _L4; else goto _L3
_L3:
            txtcekusername.setVisibility(0);
            txtcekusername.setText("Username sudah terdaftar");
            txtcekusername.setTextColor(Color.parseColor("#db261e"));
            btnSubmit.setEnabled(false);
            edtUserName.startAnimation(animation);
              goto _L5
_L4:
            if (!res.equals("40404")) goto _L5; else goto _L6
_L6:
            Log.e("valid", "40404");
            Toast.makeText(RegisterActivity.this, "Email sudah terdaftar", 1).show();
              goto _L5
            void1;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressbar_username.setVisibility(0);
        }

        public UserCheckTask()
        {
            this$0 = RegisterActivity.this;
            super();
        }
    }


    public static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static android.content.SharedPreferences.Editor editor;
    public static SharedPreferences prefs;
    final int DATE_DIALOG_ID = 999;
    final String USERNAME_PATTERN = "^[a-zA-Z]{1}[a-zA-Z0-9_.]{4,15}$";
    ActionBar actionBar;
    int actionBarTitleId;
    Animation animation;
    Button btnHpDigunakan;
    Button btnHpDigunakan2;
    Button btnKecamatan;
    Button btnKota;
    Button btnOperatorDigunakan;
    Button btnOperatorDigunakan2;
    Button btnProv;
    Button btnSubmit;
    Button btnSubmitHp;
    Button btnTTL;
    Calendar c;
    CheckBox cb_showPassword;
    ConnectivityManager cm;
    Cursor cursor;
    private android.app.DatePickerDialog.OnDateSetListener datePickerListener;
    private int day;
    DatabaseHandler db;
    Dialog dialog;
    EditText edtAlamat;
    EditText edtAuto;
    EditText edtEmail;
    EditText edtHpDigunakan;
    EditText edtHpKetik;
    EditText edtKotaLain;
    EditText edtNama;
    EditText edtPass;
    EditText edtRePass;
    EditText edtTTL;
    EditText edtUserName;
    String email;
    String email_user;
    String getJson;
    String gmail;
    String hpPengguna;
    String hpPengguna2;
    ImageLoader imageLoader2;
    String jenisKelamin;
    String jml;
    String kecamatan;
    ArrayList kecamatanArray;
    ArrayList kecamatanArrayID;
    String kecamatan_id;
    String kecamatan_str;
    String kecamatan_strID;
    String kecamatan_strarray[];
    String kecamatan_strarrayID[];
    String kota;
    ArrayList kotaArray;
    ArrayList kotaArrayID;
    String kota_id;
    String kota_str;
    String kota_strID;
    String kota_strarray[];
    String kota_strarrayID[];
    LinearLayout layout_empty;
    ListAdapter listAdapter;
    ArrayList listArrayList;
    ListView listHp;
    ArrayList listKecamatanArrayList;
    ArrayList listKotaArrayList;
    ArrayList listOpArrayList;
    ListOperatorAdapter listOperatorAdapter;
    ArrayList listProvArrayList;
    ImageLoaderConfiguration loaderConfiguration;
    int mDay;
    ProgressDialog mDialog;
    int mMonth;
    int mYear;
    String mail_register;
    int maxDay;
    int maxMonth;
    int maxYear;
    int minDay;
    int minMonth;
    int minYear;
    private int month;
    String nama;
    String namaHp;
    String namaHp2;
    String nama_asli;
    String opera[];
    String operator[] = {
        "KartuHALO", "SimPATI", "Kartu AS", "Matrix", "IM3", "Mentari", "AXIS", "XL", "3 (Tri)", "Esia", 
        "StarOne", "Flexi", "Smartfren"
    };
    String pass;
    String passSha1;
    ProgressBar progressbar_email;
    ProgressBar progressbar_middle_dialog;
    ProgressBar progressbar_search;
    ProgressBar progressbar_username;
    String prov[];
    String provider;
    String provider2;
    ArrayList providerArray;
    ArrayList providerArrayID;
    String provider_ID;
    String provider_array[];
    String provider_arrayhpID[];
    String provider_kartu;
    String provinsi;
    ArrayList provinsiArray;
    ArrayList provinsiArrayID;
    String provinsi_id;
    String provinsi_str;
    String provinsi_strID;
    String provinsi_strarray[];
    String provinsi_strarrayID[];
    String provinsiidprefrence;
    String provinsiprefrence;
    RadioButton rbHpLain;
    RadioButton rbPilihHp;
    RadioButton rbPria;
    RadioButton rbWanita;
    RadioGroup rdJekel;
    RadioGroup rdPilHp;
    String repass;
    String res;
    ImageView segitigaPonsel1;
    String selectDate;
    String t;
    String tggal;
    TextView titleDaftarHP;
    TextView txtEmpty;
    TextView txtRegisUser;
    TextView txtSetujuKebijakan;
    TextView txtcekemail;
    TextView txtcekusername;
    TextView txtketusername;
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
    String usernama;
    String username;
    String userpass;
    ContextThemeWrapper wrapper;
    private int year;

    public RegisterActivity()
    {
        listArrayList = null;
        listOpArrayList = null;
        listProvArrayList = null;
        listKotaArrayList = null;
        listKecamatanArrayList = null;
        res = "";
        getJson = "";
        namaHp = "";
        namaHp2 = "";
        t = Utility.session(RestClient.pelihara);
        mail_register = "";
        userpass = "Username & Password minimal 4 karakter";
        hpPengguna = "";
        hpPengguna2 = "";
        provinsi = "";
        kota = "";
        kota_id = "";
        kecamatan = "";
        kecamatan_id = "";
        prov = null;
        opera = null;
        provinsi_id = "";
        provider = "";
        provider2 = "";
        jenisKelamin = "1";
        gmail = null;
        tggal = "1991-09-12";
        animation = null;
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        user_photo = "";
        username = "";
        providerArray = null;
        providerArrayID = null;
        provinsiArray = null;
        provinsiArrayID = null;
        provinsiprefrence = "";
        provinsiidprefrence = "";
        kotaArray = null;
        kotaArrayID = null;
        kecamatanArray = null;
        kecamatanArrayID = null;
        datePickerListener = new android.app.DatePickerDialog.OnDateSetListener() {

            final RegisterActivity this$0;

            public void onDateSet(DatePicker datepicker, int i, int j, int k)
            {
                month = j + 1;
                day = k;
                Log.e("range", (new StringBuilder(String.valueOf(String.valueOf(i)))).append(">").append(String.valueOf(year - 17)).toString());
                if (i <= c.get(1) - 17)
                {
                    break MISSING_BLOCK_LABEL_343;
                }
                year = c.get(1) - 17;
_L1:
                selectDate = String.valueOf((new StringBuilder(String.valueOf(year))).append("-").append(month).append("-").append(day).toString());
                datepicker = (new SimpleDateFormat("yyyy-MM-dd")).parse(selectDate);
                datepicker = (new SimpleDateFormat("E, dd MMM yyyy", Locale.US)).format(datepicker).replace("Jan", "Januari").replace("Feb", "Februari").replace("Mar", "Maret").replace("Apr", "April").replace("May", "Mei").replace("Jun", "Juni").replace("Jul", "Juli").replace("Aug", "Agustus").replace("Sept", "September").replace("Oct", "Oktober").replace("Nov", "November").replace("Dec", "Desember").replace("Mon", "Senin").replace("Tue", "Selasa").replace("Wed", "Rabu").replace("Thu", "Kamis").replace("Fri", "Jum'at").replace("Sat", "Sabtu").replace("Sun", "Minggu");
                btnTTL.setText(datepicker);
                return;
                try
                {
                    year = i;
                }
                // Misplaced declaration of an exception variable
                catch (DatePicker datepicker)
                {
                    return;
                }
                  goto _L1
            }

            
            {
                this$0 = RegisterActivity.this;
                super();
            }
        };
    }

    public static boolean checkEmail(String s)
    {
        return Pattern.compile(EMAIL_PATTERN).matcher(s).matches();
    }

    public static void clickify(TextView textview, String s, com.inponsel.android.utils.ClickSpan.OnClickListener onclicklistener)
    {
        CharSequence charsequence = textview.getText();
        String s1 = charsequence.toString();
        onclicklistener = new ClickSpan(onclicklistener);
        int i = s1.indexOf(s);
        int j = i + s.length();
        if (i != -1)
        {
            if (charsequence instanceof Spannable)
            {
                ((Spannable)charsequence).setSpan(onclicklistener, i, j, 33);
            } else
            {
                s = SpannableString.valueOf(charsequence);
                s.setSpan(onclicklistener, i, j, 33);
                textview.setText(s);
            }
            s = textview.getMovementMethod();
            if (s == null || !(s instanceof LinkMovementMethod))
            {
                textview.setMovementMethod(LinkMovementMethod.getInstance());
                return;
            }
        }
    }

    private void push_register_mail(String s)
    {
        Log.e("mail_register", s);
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(s, new AsyncHttpResponseHandler() {

            final RegisterActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                Log.e("responseHeadNews", new String(abyte0));
            }

            
            {
                this$0 = RegisterActivity.this;
                super();
            }
        });
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

    public void checkField()
    {
        if (edtEmail.getText().toString().length() < 5 || edtUserName.getText().toString().length() < 4 || edtPass.getText().toString().length() < 4 || edtRePass.getText().toString().length() < 4)
        {
            btnSubmit.setEnabled(false);
        } else
        {
            btnSubmit.setEnabled(true);
        }
        if (edtPass.getText().toString().length() > 0 && edtRePass.getText().length() > 0)
        {
            cb_showPassword.setVisibility(0);
            return;
        } else
        {
            cb_showPassword.setVisibility(8);
            return;
        }
    }

    public boolean checkUsername(String s)
    {
        return s.matches("^[a-zA-Z]{1}[a-zA-Z0-9_.]{3,15}$");
    }

    public String[] loadArray(String s, Context context)
    {
        prefs = context.getSharedPreferences("inponsel_preference", 0);
        int j = prefs.getInt((new StringBuilder(String.valueOf(s))).append("_size").toString(), 0);
        context = new String[j];
        int i = 0;
        do
        {
            if (i >= j)
            {
                return context;
            }
            context[i] = prefs.getString((new StringBuilder(String.valueOf(s))).append("_").append(i).toString(), null);
            i++;
        } while (true);
    }

    public void onBackPressed()
    {
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300d3);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Register Pengguna");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Register</font>"));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        wrapper = new ContextThemeWrapper(this, 0x103006e);
        bundle = AccountManager.get(this).getAccounts();
        j = bundle.length;
        i = 0;
        do
        {
            if (i >= j)
            {
                c = Calendar.getInstance();
                year = c.get(1);
                month = c.get(2);
                day = c.get(5);
                animation = AnimationUtils.loadAnimation(this, 0x7f040018);
                cm = (ConnectivityManager)getSystemService("connectivity");
                btnHpDigunakan = (Button)findViewById(0x7f0b00cd);
                btnHpDigunakan2 = (Button)findViewById(0x7f0b00ce);
                segitigaPonsel1 = (ImageView)findViewById(0x7f0b01de);
                btnProv = (Button)findViewById(0x7f0b01d8);
                btnKota = (Button)findViewById(0x7f0b01da);
                btnKecamatan = (Button)findViewById(0x7f0b01dd);
                cb_showPassword = (CheckBox)findViewById(0x7f0b01cc);
                cb_showPassword.setVisibility(8);
                txtSetujuKebijakan = (TextView)findViewById(0x7f0b01e2);
                txtSetujuKebijakan.setText("Dengan mengklik Daftar, berarti anda telah memahami dan menyetujui ketentuan Kebijakan Privasi yang berlaku pada layanan ini.");
                clickify(txtSetujuKebijakan, "Kebijakan Privasi", new com.inponsel.android.utils.ClickSpan.OnClickListener() {

                    final RegisterActivity this$0;

                    public void onClick()
                    {
                        Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/KebijakanActivity);
                        startActivityForResult(intent, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                btnTTL = (Button)findViewById(0x7f0b01d7);
                btnOperatorDigunakan = (Button)findViewById(0x7f0b01e0);
                btnOperatorDigunakan2 = (Button)findViewById(0x7f0b01e1);
                btnSubmit = (Button)findViewById(0x7f0b0069);
                edtHpDigunakan = (EditText)findViewById(0x7f0b01df);
                edtKotaLain = (EditText)findViewById(0x7f0b01db);
                edtNama = (EditText)findViewById(0x7f0b01c6);
                edtEmail = (EditText)findViewById(0x7f0b01ce);
                progressbar_username = (ProgressBar)findViewById(0x7f0b01c8);
                progressbar_email = (ProgressBar)findViewById(0x7f0b01cf);
                progressbar_username.setVisibility(8);
                progressbar_email.setVisibility(8);
                t = Utility.session(t);
                edtUserName = (EditText)findViewById(0x7f0b01c7);
                edtPass = (EditText)findViewById(0x7f0b01ca);
                edtRePass = (EditText)findViewById(0x7f0b01cb);
                rbHpLain = (RadioButton)findViewById(0x7f0b01d3);
                rbPilihHp = (RadioButton)findViewById(0x7f0b01d2);
                rbPria = (RadioButton)findViewById(0x7f0b01d5);
                rbWanita = (RadioButton)findViewById(0x7f0b01d6);
                t = Utility.session(t);
                rdPilHp = (RadioGroup)findViewById(0x7f0b01d1);
                rdJekel = (RadioGroup)findViewById(0x7f0b01d4);
                txtketusername = (TextView)findViewById(0x7f0b0099);
                txtcekusername = (TextView)findViewById(0x7f0b01c9);
                txtcekusername.setVisibility(8);
                txtcekemail = (TextView)findViewById(0x7f0b01d0);
                txtcekemail.setVisibility(8);
                txtketusername.setSelected(true);
                rbPilihHp.setChecked(true);
                rbPria.setChecked(true);
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(this);
                cb_showPassword.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                    final RegisterActivity this$0;

                    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                    {
                        if (cb_showPassword.isChecked())
                        {
                            edtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            edtRePass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            return;
                        } else
                        {
                            edtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            edtRePass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            return;
                        }
                    }

            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                if (userFunctions.isUserLoggedIn(this))
                {
                    cursor = db.getAllData();
                    cursor.moveToFirst();
                    Object obj;
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
                edtUserName.addTextChangedListener(new DelayedTextWatcher(2000L) {

                    final RegisterActivity this$0;

                    public void afterTextChangedDelayed(Editable editable)
                    {
                        if (!checkUsername(edtUserName.getText().toString()))
                        {
                            txtcekusername.setVisibility(0);
                            txtcekusername.setText("Username harus diawali huruf, minimal 4 karakter, tanpa spasi dan karakter yang diperbolehkan hanya . atau _");
                            txtcekusername.setTextColor(Color.parseColor("#db261e"));
                            return;
                        }
                        if (edtUserName.getText().toString().contains("admin"))
                        {
                            Toast.makeText(RegisterActivity.this, "Username tidak boleh mengandung kata admin", 0).show();
                            return;
                        }
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new UserCheckTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new UserCheckTask()).execute(new Void[0]);
                            return;
                        }
                    }

            
            {
                this$0 = RegisterActivity.this;
                super(l);
            }
                });
                edtEmail.addTextChangedListener(new DelayedTextWatcher(2000L) {

                    final RegisterActivity this$0;

                    public void afterTextChangedDelayed(Editable editable)
                    {
                        if (!RegisterActivity.checkEmail(edtEmail.getText().toString()))
                        {
                            txtcekemail.setVisibility(0);
                            txtcekemail.setText("Alamat email salah");
                            txtcekemail.setTextColor(Color.parseColor("#db261e"));
                            txtcekemail.startAnimation(animation);
                            return;
                        }
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new EmailCheckTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new EmailCheckTask()).execute(new Void[0]);
                            return;
                        }
                    }

            
            {
                this$0 = RegisterActivity.this;
                super(l);
            }
                });
                btnProv.setOnClickListener(new android.view.View.OnClickListener() {

                    final RegisterActivity this$0;

                    public void onClick(View view)
                    {
                        View view1 = getLayoutInflater().inflate(0x7f030026, null);
                        view = new android.app.AlertDialog.Builder(wrapper);
                        view.setView(view1);
                        view.setTitle("Pilih Provinsi :");
                        layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
                        edtAuto = (EditText)view1.findViewById(0x7f0b008d);
                        edtAuto.setVisibility(8);
                        listHp = (ListView)view1.findViewById(0x7f0b008f);
                        progressbar_search = (ProgressBar)view1.findViewById(0x7f0b008e);
                        txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
                        txtEmpty.setText(0x7f0c0053);
                        if (android.os.Build.VERSION.SDK_INT < 13)
                        {
                            listHp.setBackgroundColor(-1);
                        }
                        listProvArrayList = new ArrayList();
                        provinsi_strarray = loadArray("provinsiArray", getApplicationContext());
                        provinsi_strarrayID = loadArray("provinsiArrayID", getApplicationContext());
                        provinsiArray = new ArrayList();
                        provinsiArray = new ArrayList(Arrays.asList(provinsi_strarray));
                        provinsiArrayID = new ArrayList();
                        provinsiArrayID = new ArrayList(Arrays.asList(provinsi_strarrayID));
                        if (provinsiArray.size() != 0)
                        {
                            Log.e("provinsiArray", "1");
                            ArrayAdapter arrayadapter = new ArrayAdapter(wrapper, 0x1090003, provinsiArray);
                            listHp.setAdapter(arrayadapter);
                            layout_empty.setVisibility(8);
                            listHp.setVisibility(0);
                            listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                                final _cls6 this$1;

                                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                                {
                                    adapterview = ((TextView)view).getText().toString();
                                    provinsi_id = provinsi_strarrayID[i];
                                    provinsi = adapterview;
                                    btnProv.setText(provinsi);
                                    provinsiprefrence = provinsi.toString().trim();
                                    provinsiidprefrence = provinsi_id;
                                    dialog.dismiss();
                                }

            
            {
                this$1 = _cls6.this;
                super();
            }
                            });
                        } else
                        {
                            listOperatorAdapter = new ListOperatorAdapter(RegisterActivity.this, 0x7f03006e, listProvArrayList);
                            listHp.setAdapter(listOperatorAdapter);
                            Log.e("prov", (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("tinggal_provinsi").append(Utility.BASE_FORMAT).append("?t=").append(t).toString());
                            (new ProvinsiSync(null)).execute(new String[] {
                                (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("tinggal_provinsi").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                            });
                            listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                                final _cls6 this$1;

                                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                                {
                                    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                                    provinsi = listOperatorAdapter.getListModel(i).getNm_op().toString();
                                    provinsi_id = listOperatorAdapter.getListModel(i).getProvinsi_id().toString();
                                    Log.e("provinsi", provinsi);
                                    btnProv.setText(provinsi);
                                    provinsiprefrence = provinsi.toString().trim();
                                    provinsiidprefrence = provinsi_id;
                                    dialog.dismiss();
                                }

            
            {
                this$1 = _cls6.this;
                super();
            }
                            });
                        }
                        dialog = view.create();
                        dialog.show();
                    }


            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                btnKota.setEnabled(true);
                btnKota.setOnClickListener(new android.view.View.OnClickListener() {

                    final RegisterActivity this$0;

                    public void onClick(View view)
                    {
                        if (provinsi_id.equals(""))
                        {
                            Toast.makeText(getApplicationContext(), "Pilih provinsi terlebih dahulu", 1).show();
                            return;
                        }
                        View view1 = getLayoutInflater().inflate(0x7f030026, null);
                        view = new android.app.AlertDialog.Builder(wrapper);
                        view.setView(view1);
                        view.setTitle("Pilih Kota :");
                        layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
                        edtAuto = (EditText)view1.findViewById(0x7f0b008d);
                        edtAuto.setVisibility(8);
                        listHp = (ListView)view1.findViewById(0x7f0b008f);
                        if (android.os.Build.VERSION.SDK_INT < 13)
                        {
                            listHp.setBackgroundColor(-1);
                        }
                        progressbar_search = (ProgressBar)view1.findViewById(0x7f0b008e);
                        txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
                        txtEmpty.setText(0x7f0c0053);
                        listKotaArrayList = new ArrayList();
                        kota_strarray = loadArray(provinsiprefrence, getApplicationContext());
                        kota_strarrayID = loadArray(provinsiidprefrence, getApplicationContext());
                        kotaArray = new ArrayList();
                        kotaArray = new ArrayList(Arrays.asList(kota_strarray));
                        kotaArrayID = new ArrayList();
                        kotaArrayID = new ArrayList(Arrays.asList(kota_strarrayID));
                        if (kotaArray.size() != 0)
                        {
                            Log.e("kotaArray", "1");
                            ArrayAdapter arrayadapter = new ArrayAdapter(wrapper, 0x1090003, kotaArray);
                            listHp.setAdapter(arrayadapter);
                            layout_empty.setVisibility(8);
                            listHp.setVisibility(0);
                            listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                                final _cls7 this$1;

                                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                                {
                                    adapterview = ((TextView)view).getText().toString();
                                    kota_id = kota_strarrayID[i];
                                    kota = adapterview;
                                    btnKota.setText(kota);
                                    btnKecamatan.setEnabled(true);
                                    Log.e("kota", kota);
                                    dialog.dismiss();
                                }

            
            {
                this$1 = _cls7.this;
                super();
            }
                            });
                        } else
                        {
                            listOperatorAdapter = new ListOperatorAdapter(RegisterActivity.this, 0x7f03006e, listKotaArrayList);
                            listHp.setAdapter(listOperatorAdapter);
                            (new KotaSync(null)).execute(new String[] {
                                (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("tinggal_kota").append(Utility.BASE_FORMAT).append("?provinsi_id=").append(provinsi_id).append("&t=").append(t).toString()
                            });
                            listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                                final _cls7 this$1;

                                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                                {
                                    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                                    kota = listOperatorAdapter.getListModel(i).getNm_op().toString();
                                    kota_id = listOperatorAdapter.getListModel(i).getKota_id().toString();
                                    Log.e("kota", kota);
                                    btnKota.setText(kota);
                                    dialog.dismiss();
                                    btnKecamatan.setEnabled(true);
                                }

            
            {
                this$1 = _cls7.this;
                super();
            }
                            });
                        }
                        dialog = view.create();
                        dialog.show();
                    }


            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                btnKecamatan.setOnClickListener(new android.view.View.OnClickListener() {

                    final RegisterActivity this$0;

                    public void onClick(View view)
                    {
                        if (provinsi_id.equals(""))
                        {
                            Toast.makeText(getApplicationContext(), "Pilih provinsi terlebih dahulu", 1).show();
                            return;
                        }
                        if (kota.equals(""))
                        {
                            Toast.makeText(getApplicationContext(), "Pilih kota terlebih dahulu", 1).show();
                            return;
                        }
                        View view1 = getLayoutInflater().inflate(0x7f030026, null);
                        view = new android.app.AlertDialog.Builder(wrapper);
                        view.setView(view1);
                        view.setTitle("Pilih kecamatan :");
                        layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
                        edtAuto = (EditText)view1.findViewById(0x7f0b008d);
                        edtAuto.setVisibility(8);
                        listHp = (ListView)view1.findViewById(0x7f0b008f);
                        if (android.os.Build.VERSION.SDK_INT < 13)
                        {
                            listHp.setBackgroundColor(-1);
                        }
                        progressbar_search = (ProgressBar)view1.findViewById(0x7f0b008e);
                        txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
                        txtEmpty.setText(0x7f0c0053);
                        listKecamatanArrayList = new ArrayList();
                        kecamatan_strarray = loadArray(provinsiprefrence, getApplicationContext());
                        kecamatan_strarrayID = loadArray(provinsiidprefrence, getApplicationContext());
                        kecamatanArray = new ArrayList();
                        kecamatanArray = new ArrayList(Arrays.asList(kecamatan_strarray));
                        kecamatanArrayID = new ArrayList();
                        kecamatanArrayID = new ArrayList(Arrays.asList(kecamatan_strarrayID));
                        if (kecamatanArray.size() != 0)
                        {
                            Log.e("kecamatanArray", "1");
                            ArrayAdapter arrayadapter = new ArrayAdapter(wrapper, 0x1090003, kecamatanArray);
                            listHp.setAdapter(arrayadapter);
                            layout_empty.setVisibility(8);
                            listHp.setVisibility(0);
                            listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                                final _cls8 this$1;

                                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                                {
                                    adapterview = ((TextView)view).getText().toString();
                                    kecamatan_id = kecamatan_strarrayID[i];
                                    kecamatan = adapterview;
                                    btnKecamatan.setText(kecamatan);
                                    btnKecamatan.setEnabled(true);
                                    dialog.dismiss();
                                }

            
            {
                this$1 = _cls8.this;
                super();
            }
                            });
                        } else
                        {
                            listOperatorAdapter = new ListOperatorAdapter(RegisterActivity.this, 0x7f03006e, listKecamatanArrayList);
                            listHp.setAdapter(listOperatorAdapter);
                            String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_kecamatan").append(Utility.BASE_FORMAT).append("?provinsi_id=").append(provinsi_id).append("&kota_id=").append(kota_id).append("&t=").append(t).toString();
                            (new KecamatanSync(null)).execute(new String[] {
                                s
                            });
                            listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                                final _cls8 this$1;

                                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                                {
                                    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                                    kecamatan = listOperatorAdapter.getListModel(i).getNm_op().toString();
                                    kecamatan_id = listOperatorAdapter.getListModel(i).getKecamatan_id().toString();
                                    Log.e("kecamatan", kecamatan);
                                    btnKecamatan.setText(kecamatan);
                                    dialog.dismiss();
                                    btnKecamatan.setEnabled(true);
                                }

            
            {
                this$1 = _cls8.this;
                super();
            }
                            });
                        }
                        dialog = view.create();
                        dialog.show();
                    }


            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                btnOperatorDigunakan.setOnClickListener(new android.view.View.OnClickListener() {

                    final RegisterActivity this$0;

                    public void onClick(View view)
                    {
                        View view1 = getLayoutInflater().inflate(0x7f030026, null);
                        view = new android.app.AlertDialog.Builder(RegisterActivity.this);
                        view.setView(view1);
                        view.setTitle("Pilih Operator :");
                        layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
                        edtAuto = (EditText)view1.findViewById(0x7f0b008d);
                        edtAuto.setVisibility(8);
                        listHp = (ListView)view1.findViewById(0x7f0b008f);
                        if (android.os.Build.VERSION.SDK_INT < 13)
                        {
                            listHp.setBackgroundColor(-1);
                        }
                        progressbar_search = (ProgressBar)view1.findViewById(0x7f0b008e);
                        txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
                        txtEmpty.setText(0x7f0c0053);
                        listOpArrayList = new ArrayList();
                        provider_array = loadArray("providerArray", getApplicationContext());
                        provider_arrayhpID = loadArray("providerArrayID", getApplicationContext());
                        providerArray = new ArrayList();
                        providerArray = new ArrayList(Arrays.asList(provider_array));
                        providerArrayID = new ArrayList();
                        providerArrayID = new ArrayList(Arrays.asList(provider_arrayhpID));
                        Log.e("providerArray", String.valueOf(providerArray.size()));
                        if (providerArray.size() != 0)
                        {
                            Log.e("providerArray", "1");
                            ArrayAdapter arrayadapter = new ArrayAdapter(wrapper, 0x1090003, providerArray);
                            listHp.setAdapter(arrayadapter);
                            layout_empty.setVisibility(8);
                            listHp.setVisibility(0);
                            listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                                final _cls9 this$1;

                                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                                {
                                    adapterview = ((TextView)view).getText().toString();
                                    provider = adapterview;
                                    btnOperatorDigunakan.setText(adapterview);
                                    dialog.dismiss();
                                }

            
            {
                this$1 = _cls9.this;
                super();
            }
                            });
                        } else
                        {
                            listOperatorAdapter = new ListOperatorAdapter(RegisterActivity.this, 0x7f03006e, listOpArrayList);
                            listHp.setAdapter(listOperatorAdapter);
                            (new OperatorSync(null)).execute(new String[] {
                                (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("operator_inponsel").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                            });
                            listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                                final _cls9 this$1;

                                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                                {
                                    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                                    provider = listOperatorAdapter.getListModel(i).getNm_op().toString();
                                    Log.e("provider", provider);
                                    btnOperatorDigunakan.setText(provider);
                                    dialog.dismiss();
                                }

            
            {
                this$1 = _cls9.this;
                super();
            }
                            });
                        }
                        dialog = view.create();
                        dialog.show();
                    }


            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                btnOperatorDigunakan2.setOnClickListener(new android.view.View.OnClickListener() {

                    final RegisterActivity this$0;

                    public void onClick(View view)
                    {
                        View view1 = getLayoutInflater().inflate(0x7f030026, null);
                        view = new android.app.AlertDialog.Builder(wrapper);
                        view.setView(view1);
                        view.setTitle("Pilih Operator :");
                        layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
                        edtAuto = (EditText)view1.findViewById(0x7f0b008d);
                        edtAuto.setVisibility(8);
                        listHp = (ListView)view1.findViewById(0x7f0b008f);
                        if (android.os.Build.VERSION.SDK_INT < 13)
                        {
                            listHp.setBackgroundColor(-1);
                        }
                        progressbar_search = (ProgressBar)view1.findViewById(0x7f0b008e);
                        txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
                        txtEmpty.setText(0x7f0c0053);
                        listOpArrayList = new ArrayList();
                        provider_array = loadArray("providerArray", getApplicationContext());
                        provider_arrayhpID = loadArray("providerArrayID", getApplicationContext());
                        providerArray = new ArrayList();
                        providerArray = new ArrayList(Arrays.asList(provider_array));
                        providerArrayID = new ArrayList();
                        providerArrayID = new ArrayList(Arrays.asList(provider_arrayhpID));
                        Log.e("merkArray", String.valueOf(providerArray.size()));
                        if (providerArray.size() != 0)
                        {
                            Log.e("merkArray", "1");
                            ArrayAdapter arrayadapter = new ArrayAdapter(wrapper, 0x1090003, providerArray);
                            listHp.setAdapter(arrayadapter);
                            layout_empty.setVisibility(8);
                            listHp.setVisibility(0);
                            listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                                final _cls10 this$1;

                                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                                {
                                    adapterview = ((TextView)view).getText().toString();
                                    provider2 = adapterview;
                                    btnOperatorDigunakan2.setText(adapterview);
                                    dialog.dismiss();
                                }

            
            {
                this$1 = _cls10.this;
                super();
            }
                            });
                        } else
                        {
                            listOperatorAdapter = new ListOperatorAdapter(RegisterActivity.this, 0x7f03006e, listOpArrayList);
                            listHp.setAdapter(listOperatorAdapter);
                            (new OperatorSync(null)).execute(new String[] {
                                (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("operator_inponsel").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                            });
                            listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                                final _cls10 this$1;

                                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                                {
                                    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                                    provider2 = listOperatorAdapter.getListModel(i).getNm_op().toString();
                                    Log.e("provider", provider2);
                                    btnOperatorDigunakan2.setText(provider2);
                                    dialog.dismiss();
                                }

            
            {
                this$1 = _cls10.this;
                super();
            }
                            });
                        }
                        dialog = view.create();
                        dialog.show();
                    }


            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                segitigaPonsel1.setOnClickListener(new android.view.View.OnClickListener() {

                    final RegisterActivity this$0;

                    public void onClick(View view)
                    {
                        Log.e("click", "custom dialog");
                        view = getLayoutInflater().inflate(0x7f030026, null);
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                        builder.setView(view);
                        builder.setTitle("Pilih Ponsel :");
                        layout_empty = (LinearLayout)view.findViewById(0x7f0b0091);
                        edtAuto = (EditText)view.findViewById(0x7f0b008d);
                        progressbar_middle_dialog = (ProgressBar)view.findViewById(0x7f0b0092);
                        progressbar_middle_dialog.setVisibility(8);
                        edtHpKetik = (EditText)view.findViewById(0x7f0b0094);
                        btnSubmitHp = (Button)view.findViewById(0x7f0b0095);
                        listHp = (ListView)view.findViewById(0x7f0b008f);
                        if (android.os.Build.VERSION.SDK_INT < 13)
                        {
                            listHp.setBackgroundColor(-1);
                            edtAuto.setTextColor(-1);
                        }
                        progressbar_search = (ProgressBar)view.findViewById(0x7f0b008e);
                        txtEmpty = (TextView)view.findViewById(0x7f0b0093);
                        txtEmpty.setText("Masukkan ponsel yang dicari");
                        listArrayList = new ArrayList();
                        listAdapter = new ListAdapter(RegisterActivity.this, 0x7f03006e, listArrayList);
                        listHp.setAdapter(listAdapter);
                        edtAuto.setSingleLine(true);
                        edtAuto.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                            final _cls11 this$1;

                            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
                            {
                                if (i != 3) goto _L2; else goto _L1
_L1:
                                if (edtAuto.getText().toString().trim().length() == 0)
                                {
                                    txtEmpty.setText("Masukan ponsel yang ingin dicari");
                                    return true;
                                }
                                progressbar_search.setVisibility(0);
                                textview = edtAuto.getText().toString();
                                keyevent = URLEncoder.encode(textview, "utf-8");
                                textview = keyevent;
_L3:
                                (new SearchHpSync(null)).execute(new String[] {
                                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(textview).append("&t=").append(t).toString()
                                });
                                return true;
                                keyevent;
                                keyevent.printStackTrace();
                                if (true) goto _L3; else goto _L2
_L2:
                                return false;
                            }

            
            {
                this$1 = _cls11.this;
                super();
            }
                        });
                        edtAuto.addTextChangedListener(new DelayedTextWatcher(2000L) {

                            final _cls11 this$1;

                            public void afterTextChangedDelayed(Editable editable)
                            {
                                if (edtAuto.getText().toString().trim().length() == 0)
                                {
                                    txtEmpty.setText("Masukan ponsel yang ingin dicari");
                                    return;
                                }
                                progressbar_search.setVisibility(0);
                                editable = edtAuto.getText().toString();
                                String s = URLEncoder.encode(editable, "utf-8");
                                editable = s;
_L2:
                                (new SearchHpSync(null)).execute(new String[] {
                                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(editable).append("&t=").append(t).toString()
                                });
                                return;
                                UnsupportedEncodingException unsupportedencodingexception;
                                unsupportedencodingexception;
                                unsupportedencodingexception.printStackTrace();
                                if (true) goto _L2; else goto _L1
_L1:
                            }

            
            {
                this$1 = _cls11.this;
                super(l);
            }
                        });
                        listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                            final _cls11 this$1;

                            public void onItemClick(AdapterView adapterview, View view, int i, long l)
                            {
                                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                                namaHp = listAdapter.getListModel(i).getNamalengkap().toString();
                                Log.e("namahp", namaHp);
                                btnHpDigunakan.setText(namaHp);
                                hpPengguna = namaHp;
                                dialog.dismiss();
                            }

            
            {
                this$1 = _cls11.this;
                super();
            }
                        });
                        btnSubmitHp.setOnClickListener(new android.view.View.OnClickListener() {

                            final _cls11 this$1;

                            public void onClick(View view)
                            {
                                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                                hpPengguna = edtHpKetik.getText().toString();
                                btnHpDigunakan.setText(hpPengguna);
                                dialog.dismiss();
                            }

            
            {
                this$1 = _cls11.this;
                super();
            }
                        });
                        dialog = builder.create();
                        dialog.show();
                    }


            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                btnHpDigunakan.setOnClickListener(new android.view.View.OnClickListener() {

                    final RegisterActivity this$0;

                    public void onClick(View view)
                    {
                        Log.e("click", "custom dialog");
                        view = getLayoutInflater().inflate(0x7f030026, null);
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                        builder.setView(view);
                        builder.setTitle("Pilih Ponsel :");
                        progressbar_middle_dialog = (ProgressBar)view.findViewById(0x7f0b0092);
                        progressbar_middle_dialog.setVisibility(8);
                        layout_empty = (LinearLayout)view.findViewById(0x7f0b0091);
                        edtAuto = (EditText)view.findViewById(0x7f0b008d);
                        edtHpKetik = (EditText)view.findViewById(0x7f0b0094);
                        btnSubmitHp = (Button)view.findViewById(0x7f0b0095);
                        listHp = (ListView)view.findViewById(0x7f0b008f);
                        if (android.os.Build.VERSION.SDK_INT < 13)
                        {
                            edtAuto.setTextColor(-1);
                            listHp.setBackgroundColor(-1);
                        }
                        progressbar_search = (ProgressBar)view.findViewById(0x7f0b008e);
                        txtEmpty = (TextView)view.findViewById(0x7f0b0093);
                        txtEmpty.setText("Masukkan ponsel yang dicari");
                        listArrayList = new ArrayList();
                        listAdapter = new ListAdapter(RegisterActivity.this, 0x7f03006e, listArrayList);
                        listHp.setAdapter(listAdapter);
                        edtAuto.setSingleLine(true);
                        edtAuto.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                            final _cls12 this$1;

                            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
                            {
                                if (i != 3) goto _L2; else goto _L1
_L1:
                                if (edtAuto.getText().toString().trim().length() == 0)
                                {
                                    txtEmpty.setText("Masukan ponsel yang ingin dicari");
                                    return true;
                                }
                                progressbar_search.setVisibility(0);
                                textview = edtAuto.getText().toString();
                                keyevent = URLEncoder.encode(textview, "utf-8");
                                textview = keyevent;
_L3:
                                (new SearchHpSync(null)).execute(new String[] {
                                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(textview).append("&t=").append(t).toString()
                                });
                                return true;
                                keyevent;
                                keyevent.printStackTrace();
                                if (true) goto _L3; else goto _L2
_L2:
                                return false;
                            }

            
            {
                this$1 = _cls12.this;
                super();
            }
                        });
                        edtAuto.addTextChangedListener(new DelayedTextWatcher(2000L) {

                            final _cls12 this$1;

                            public void afterTextChangedDelayed(Editable editable)
                            {
                                if (edtAuto.getText().toString().trim().length() == 0)
                                {
                                    txtEmpty.setText("Masukan ponsel yang ingin dicari");
                                    return;
                                }
                                progressbar_search.setVisibility(0);
                                editable = edtAuto.getText().toString();
                                String s = URLEncoder.encode(editable, "utf-8");
                                editable = s;
_L2:
                                (new SearchHpSync(null)).execute(new String[] {
                                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(editable).append("&t=").append(t).toString()
                                });
                                return;
                                UnsupportedEncodingException unsupportedencodingexception;
                                unsupportedencodingexception;
                                unsupportedencodingexception.printStackTrace();
                                if (true) goto _L2; else goto _L1
_L1:
                            }

            
            {
                this$1 = _cls12.this;
                super(l);
            }
                        });
                        listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                            final _cls12 this$1;

                            public void onItemClick(AdapterView adapterview, View view, int i, long l)
                            {
                                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                                namaHp = listAdapter.getListModel(i).getNamalengkap().toString();
                                Log.e("namahp", namaHp);
                                btnHpDigunakan.setText(namaHp);
                                hpPengguna = namaHp;
                                dialog.dismiss();
                            }

            
            {
                this$1 = _cls12.this;
                super();
            }
                        });
                        btnSubmitHp.setOnClickListener(new android.view.View.OnClickListener() {

                            final _cls12 this$1;

                            public void onClick(View view)
                            {
                                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                                hpPengguna = edtHpKetik.getText().toString();
                                btnHpDigunakan.setText(hpPengguna);
                                dialog.dismiss();
                            }

            
            {
                this$1 = _cls12.this;
                super();
            }
                        });
                        dialog = builder.create();
                        dialog.show();
                    }


            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                btnHpDigunakan2.setOnClickListener(new android.view.View.OnClickListener() {

                    final RegisterActivity this$0;

                    public void onClick(View view)
                    {
                        Log.e("click", "custom dialog");
                        view = getLayoutInflater().inflate(0x7f030026, null);
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
                        builder.setView(view);
                        builder.setTitle("Pilih Ponsel :");
                        progressbar_middle_dialog = (ProgressBar)view.findViewById(0x7f0b0092);
                        progressbar_middle_dialog.setVisibility(8);
                        layout_empty = (LinearLayout)view.findViewById(0x7f0b0091);
                        edtHpKetik = (EditText)view.findViewById(0x7f0b0094);
                        btnSubmitHp = (Button)view.findViewById(0x7f0b0095);
                        edtAuto = (EditText)view.findViewById(0x7f0b008d);
                        listHp = (ListView)view.findViewById(0x7f0b008f);
                        progressbar_search = (ProgressBar)view.findViewById(0x7f0b008e);
                        txtEmpty = (TextView)view.findViewById(0x7f0b0093);
                        txtEmpty.setText("Masukkan ponsel yang dicari");
                        if (android.os.Build.VERSION.SDK_INT < 13)
                        {
                            edtAuto.setTextColor(-1);
                            listHp.setBackgroundColor(-1);
                        }
                        listArrayList = new ArrayList();
                        listAdapter = new ListAdapter(RegisterActivity.this, 0x7f03006e, listArrayList);
                        listHp.setAdapter(listAdapter);
                        edtAuto.addTextChangedListener(new TextWatcher() {

                            final _cls13 this$1;

                            public void afterTextChanged(Editable editable)
                            {
                            }

                            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
                            {
                            }

                            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
                            {
                                String s;
                                UnsupportedEncodingException unsupportedencodingexception;
                                try
                                {
                                    if (edtAuto.getText().toString().trim().length() == 0)
                                    {
                                        txtEmpty.setText("Masukan ponsel yang ingin dicari");
                                        return;
                                    }
                                }
                                // Misplaced declaration of an exception variable
                                catch (CharSequence charsequence)
                                {
                                    return;
                                }
                                progressbar_search.setVisibility(0);
                                charsequence = edtAuto.getText().toString();
                                s = URLEncoder.encode(charsequence, "utf-8");
                                charsequence = s;
_L1:
                                (new SearchHpSync(null)).execute(new String[] {
                                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(charsequence).append("&t=").append(t).toString()
                                });
                                return;
                                unsupportedencodingexception;
                                unsupportedencodingexception.printStackTrace();
                                  goto _L1
                            }

            
            {
                this$1 = _cls13.this;
                super();
            }
                        });
                        listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                            final _cls13 this$1;

                            public void onItemClick(AdapterView adapterview, View view, int i, long l)
                            {
                                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                                namaHp2 = listAdapter.getListModel(i).getNamalengkap().toString();
                                Log.e("namahp", namaHp2);
                                btnHpDigunakan2.setText(namaHp2);
                                hpPengguna2 = namaHp2;
                                dialog.dismiss();
                            }

            
            {
                this$1 = _cls13.this;
                super();
            }
                        });
                        btnSubmitHp.setOnClickListener(new android.view.View.OnClickListener() {

                            final _cls13 this$1;

                            public void onClick(View view)
                            {
                                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                                hpPengguna2 = edtHpKetik.getText().toString();
                                btnHpDigunakan2.setText(hpPengguna2);
                                dialog.dismiss();
                            }

            
            {
                this$1 = _cls13.this;
                super();
            }
                        });
                        dialog = builder.create();
                        dialog.show();
                    }


            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                rdPilHp.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

                    final RegisterActivity this$0;

                    public void onCheckedChanged(RadioGroup radiogroup, int k)
                    {
                        edtHpDigunakan.setText("");
                        if (rbPilihHp.isChecked())
                        {
                            btnHpDigunakan.setVisibility(0);
                            edtHpDigunakan.setVisibility(8);
                            return;
                        } else
                        {
                            btnHpDigunakan.setVisibility(8);
                            edtHpDigunakan.setVisibility(0);
                            return;
                        }
                    }

            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                rdJekel.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

                    final RegisterActivity this$0;

                    public void onCheckedChanged(RadioGroup radiogroup, int k)
                    {
                        edtHpDigunakan.setText("");
                        if (rbPria.isChecked())
                        {
                            jenisKelamin = "1";
                            return;
                        } else
                        {
                            jenisKelamin = "2";
                            return;
                        }
                    }

            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                btnTTL.setOnClickListener(new android.view.View.OnClickListener() {

                    final RegisterActivity this$0;

                    public void onClick(View view)
                    {
                        mYear = c.get(1);
                        mMonth = c.get(2);
                        mDay = c.get(5);
                        maxYear = mYear - 7;
                        maxMonth = mMonth;
                        maxDay = mDay;
                        minYear = mYear - 18;
                        minMonth = mMonth;
                        minDay = mDay;
                        showDialog(999);
                    }

            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                edtNama.addTextChangedListener(new TextWatcher() {

                    final RegisterActivity this$0;

                    public void afterTextChanged(Editable editable)
                    {
                        checkField();
                    }

                    public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
                    {
                    }

                    public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
                    {
                    }

            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                edtPass.addTextChangedListener(new TextWatcher() {

                    final RegisterActivity this$0;

                    public void afterTextChanged(Editable editable)
                    {
                        checkField();
                    }

                    public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
                    {
                        checkField();
                    }

                    public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
                    {
                        checkField();
                    }

            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                edtRePass.addTextChangedListener(new TextWatcher() {

                    final RegisterActivity this$0;

                    public void afterTextChanged(Editable editable)
                    {
                        checkField();
                    }

                    public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
                    {
                        checkField();
                    }

                    public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
                    {
                        checkField();
                    }

            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                btnSubmit.setOnClickListener(new android.view.View.OnClickListener() {

                    final RegisterActivity this$0;

                    public void onClick(View view)
                    {
                        if (edtKotaLain.getVisibility() == 0)
                        {
                            kota = edtKotaLain.getText().toString();
                        }
                        if (edtHpDigunakan.getVisibility() == 0)
                        {
                            hpPengguna = edtHpDigunakan.getText().toString();
                        } else
                        {
                            hpPengguna = namaHp;
                        }
                        nama = edtNama.getText().toString();
                        usernama = edtUserName.getText().toString();
                        pass = edtPass.getText().toString();
                        pass = Utility.session(pass);
                        pass = Utility.session(pass);
                        pass = Utility.session(pass);
                        pass = Utility.session(pass);
                        pass = Utility.session(pass);
                        repass = edtRePass.getText().toString();
                        repass = Utility.session(repass);
                        repass = Utility.session(repass);
                        repass = Utility.session(repass);
                        repass = Utility.session(repass);
                        repass = Utility.session(repass);
                        email = edtEmail.getText().toString();
                        tggal = btnTTL.getText().toString();
                        if (checkUsername(usernama)) goto _L2; else goto _L1
_L1:
                        Toast.makeText(RegisterActivity.this, "username harus diawali huruf, tanpa spasi dan karakter yang diperbolehkan hanya . atau _", 1).show();
                        edtUserName.startAnimation(animation);
_L4:
                        return;
_L2:
                        if (usernama.contains("admin"))
                        {
                            Toast.makeText(RegisterActivity.this, "Username tidak boleh mengandung kata admin", 0).show();
                            return;
                        }
                        if (!pass.equals(repass))
                        {
                            Toast.makeText(RegisterActivity.this, "Password tidak cocok", 0).show();
                            edtPass.startAnimation(animation);
                            edtRePass.startAnimation(animation);
                            return;
                        }
                        if (!RegisterActivity.checkEmail(email))
                        {
                            Toast.makeText(RegisterActivity.this, "email tidak valid", 0).show();
                            return;
                        }
                        if (tggal.contains("Tanggal"))
                        {
                            Toast.makeText(RegisterActivity.this, "Tanggal belum diisi", 0).show();
                            btnTTL.startAnimation(animation);
                            return;
                        }
                        if (provinsi.equals(""))
                        {
                            Toast.makeText(RegisterActivity.this, "Anda belum mengisi provinsi", 0).show();
                            btnProv.startAnimation(animation);
                            return;
                        }
                        if (kota.equals(""))
                        {
                            Toast.makeText(RegisterActivity.this, "Anda belum mengisi kota", 0).show();
                            btnKota.startAnimation(animation);
                            return;
                        }
                        if (kecamatan.equals(""))
                        {
                            Toast.makeText(RegisterActivity.this, "Anda belum mengisi kecamatan", 0).show();
                            btnKecamatan.startAnimation(animation);
                            return;
                        }
                        if (hpPengguna.equals("") || hpPengguna.contains("Ponsel digunakan"))
                        {
                            Toast.makeText(RegisterActivity.this, "Anda belum mengisi hp", 0).show();
                            btnHpDigunakan.startAnimation(animation);
                            return;
                        }
                        if (provider.equals(""))
                        {
                            Toast.makeText(RegisterActivity.this, "Anda belum mengisi provider", 0).show();
                            btnOperatorDigunakan.startAnimation(animation);
                            return;
                        }
                        if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected()) goto _L4; else goto _L3
_L3:
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new RegisterTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        }
                        try
                        {
                            (new RegisterTask()).execute(new Void[0]);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                    }

            
            {
                this$0 = RegisterActivity.this;
                super();
            }
                });
                return;
            }
            obj = bundle[i];
            if (((Account) (obj)).name.endsWith("gmail.com"))
            {
                gmail = ((Account) (obj)).name;
            }
            i++;
        } while (true);
    }

    protected Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 999: 
            return new DatePickerDialog(wrapper, datePickerListener, year - 17, month, day);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0002, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            finish();
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }

    public boolean saveArray(String as[], String s, Context context)
    {
        prefs = context.getSharedPreferences("inponsel_preference", 0);
        editor = prefs.edit();
        editor.putInt((new StringBuilder(String.valueOf(s))).append("_size").toString(), as.length);
        int i = 0;
        do
        {
            if (i >= as.length)
            {
                return editor.commit();
            }
            editor.putString((new StringBuilder(String.valueOf(s))).append("_").append(i).toString(), as[i]);
            i++;
        } while (true);
    }








}
