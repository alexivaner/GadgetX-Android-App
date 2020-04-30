// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ListAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ListOperatorAdapter;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.Base64;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.InternalStorageContentProvider;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import eu.janmuller.android.simplecropimage.CropImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Observer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, HomeNewMainActivity, ImagePagerActivity, RegisterActivity

public class ProfileActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{
    private class KecamatanSync extends AsyncTask
    {

        final ProfileActivity this$0;

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
            Log.e("preference", kotaprefrence);
            saveArray(kecamatan_strarray, kotaprefrence, getApplicationContext());
            saveArray(kecamatan_strarrayID, kotaidprefrence, getApplicationContext());
            progressbar_search.setVisibility(8);
            if (jml != 0)
            {
                break MISSING_BLOCK_LABEL_271;
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
                jml = s.length();
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
            this$0 = ProfileActivity.this;
            super();
        }

        KecamatanSync(KecamatanSync kecamatansync)
        {
            this();
        }
    }

    private class KotaSync extends AsyncTask
    {

        final ProfileActivity this$0;

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
            saveArray(kota_strarray, provinsiprefrence, getApplicationContext());
            saveArray(kota_strarrayID, provinsiidprefrence, getApplicationContext());
            progressbar_search.setVisibility(8);
            if (jml != 0)
            {
                break MISSING_BLOCK_LABEL_271;
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
                jml = s.length();
                Log.e("jarray", String.valueOf(jml));
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
            this$0 = ProfileActivity.this;
            super();
        }

        KotaSync(KotaSync kotasync)
        {
            this();
        }
    }

    private class OperatorSync extends AsyncTask
    {

        final ProfileActivity this$0;

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
            if (jml != 0)
            {
                break MISSING_BLOCK_LABEL_249;
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
                jml = s.length();
                Log.e("jarray", String.valueOf(jml));
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
            this$0 = ProfileActivity.this;
            super();
        }

        OperatorSync(OperatorSync operatorsync)
        {
            this();
        }
    }

    public class PassTask extends AsyncTask
    {

        final ProfileActivity this$0;

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
                String s = edtPassProfileLama.getText().toString();
                avoid = edtPassProfileBaru.getText().toString();
                s = Utility.session(Utility.session(Utility.session(Utility.session(Utility.session(s)))));
                avoid = Utility.session(Utility.session(Utility.session(Utility.session(Utility.session(avoid)))));
                query = (new StringBuilder("user_name=")).append(username).append("&user_password=").append(s).append("&user_passwordnew=").append(avoid).append("&t=").append(t).toString();
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mod_passwords").append(Utility.BASE_FORMAT).append("?").append(query).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
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
            mDialog.dismiss();
            try
            {
                if (res.equals("1"))
                {
                    Toast.makeText(ProfileActivity.this, "Ganti password berhasil", 1).show();
                    userFunctions.logoutUser(getApplicationContext());
                    void1 = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewMainActivity);
                    void1.addFlags(0x4000000);
                    startActivity(void1);
                    finish();
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            Toast.makeText(ProfileActivity.this, "Update profile gagal", 1).show();
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mDialog = ProgressDialog.show(wrapper, "", "Mengubah password...", true);
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public PassTask()
        {
            this$0 = ProfileActivity.this;
            super();
        }
    }

    private class ProvinsiSync extends AsyncTask
    {

        final ProfileActivity this$0;

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
            if (jml != 0)
            {
                break MISSING_BLOCK_LABEL_249;
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
                jml = s.length();
                Log.e("jarray", String.valueOf(jml));
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
            this$0 = ProfileActivity.this;
            super();
        }

        ProvinsiSync(ProvinsiSync provinsisync)
        {
            this();
        }
    }

    public class RegisterTask extends AsyncTask
    {

        final ProfileActivity this$0;

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
            passProfile = passProfile.replace(" ", "%20");
            provinsiProfile = URLEncoder.encode(provinsiProfile, "utf-8");
            kotaProfile = URLEncoder.encode(kotaProfile, "utf-8");
            hpPenggunaProfile = URLEncoder.encode(btnHpDigunakanProfile.getText().toString(), "utf-8");
            if (hpPengguna2Profile.equals(""))
            {
                hpPengguna2Profile = "NULL";
            }
            hpPengguna2Profile = URLEncoder.encode(btnHpDigunakan2Profile.getText().toString(), "utf-8");
            provider = URLEncoder.encode(provider, "utf-8");
            currentDateandTime = currentDateandTime.replace(" ", "%20");
            if (provider2.equals(""))
            {
                provider2 = "NULL";
            }
            provider2 = URLEncoder.encode(provider2, "utf-8");
            if (year != 0 || month != 0 || day != 0) goto _L2; else goto _L1
_L1:
            selectDate = user_ttl;
_L4:
            if (repassProfile.equals("63027d7630360e4203c0e3f970ec2ffcfe5f8f1b"))
            {
                repassProfile = "0";
            }
            namaProfile = URLEncoder.encode(namaProfile, "utf-8");
            emailProfile = URLEncoder.encode(emailProfile, "utf-8");
            user_jekel = user_jekel_cb;
            query = (new StringBuilder("user_nama_asli=")).append(namaProfile).append("&user_name=").append(username).append("&user_photo=").append("NULL").append("&user_password=").append(passProfile).append("&user_email=").append(emailProfile).append("&user_ttl=").append(selectDate).append("&user_provinsi=").append(provinsiProfile).append("&user_kota=").append(kotaProfile).append("&user_kecamatan=").append(kecamatan_id).append("&user_jekel=").append(user_jekel).append("&user_ponsel_1=").append(hpPenggunaProfile).append("&user_ponsel_2=").append(hpPengguna2Profile).append("&user_operator_1=").append(provider).append("&user_operator_2=").append(provider2).append("&modtime=").append(currentDateandTime).append("&t=").append(t).toString();
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("modifi_member_inponsel").append(Utility.BASE_FORMAT).append("?").append(query).toString();
            Log.e("pushURL", avoid);
            avoid = HttpPush.getResponse(avoid);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(" ").append(Util.BASE_PATH2).append("modifi_member_inponsel").append(Utility.BASE_FORMAT).append("?").append(query).toString());
            res = avoid.toString();
            Log.e("url.............", res);
            res = res.trim();
            res = res.replaceAll("\\s+", "");
            Log.e("status", res);
            break MISSING_BLOCK_LABEL_880;
_L2:
            selectDate = String.valueOf((new StringBuilder(String.valueOf(year))).append("-").append(month).append("-").append(day).toString());
            if (true) goto _L4; else goto _L3
_L3:
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
            mDialog.dismiss();
            try
            {
                if (res.equals("1"))
                {
                    db.update_byID(edtNamaProfile.getText().toString(), username, edtEmailProfile.getText().toString(), selectDate, btnProvProfile.getText().toString(), btnKotaProfile.getText().toString(), user_jekel, btnHpDigunakanProfile.getText().toString(), btnHpDigunakan2Profile.getText().toString(), btnOperatorDigunakanProfile.getText().toString(), btnOperatorDigunakan2Profile.getText().toString(), user_joindate, currentDateandTime, ucodename1, ucodename2, kecamatanProfile);
                    Toast.makeText(ProfileActivity.this, "Update profile berhasil", 1).show();
                    void1 = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewMainActivity);
                    void1.setFlags(0x10008000);
                    startActivityForResult(void1, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    finish();
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            if (res.equals("U404"))
            {
                void1 = new android.app.AlertDialog.Builder(ProfileActivity.this);
                void1.setMessage("Username anda tidak terdaftar");
                void1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                    final RegisterTask this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = RegisterTask.this;
                super();
            }
                });
                void1.show();
                return;
            }
            Toast.makeText(ProfileActivity.this, "Update profile gagal", 1).show();
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mDialog = ProgressDialog.show(wrapper, "", "Updating...", true);
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public RegisterTask()
        {
            this$0 = ProfileActivity.this;
            super();
        }
    }

    private class SearchHpSync extends AsyncTask
    {

        String suc;
        final ProfileActivity this$0;

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
                return;
            }
            jsonobject1 = s.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setId_hp(jsonobject1.getString("id_hp"));
            listmodel.setGambar(jsonobject1.getString("gambar"));
            listmodel.setNamalengkap((new StringBuilder(String.valueOf(jsonobject1.getString("merk")))).append(" ").append(jsonobject1.getString("model")).toString());
            listmodel.setModel(jsonobject1.getString("model"));
            listmodel.setMerk(jsonobject1.getString("merk"));
            listmodel.setCodename(jsonobject1.getString("codename"));
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
            this$0 = ProfileActivity.this;
            super();
        }

        SearchHpSync(SearchHpSync searchhpsync)
        {
            this();
        }
    }

    public class UploadImage extends AsyncTask
    {

        final ProfileActivity this$0;

        protected transient Long doInBackground(URL aurl[])
        {
            aurl = new ByteArrayOutputStream();
            photo_upload.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, aurl);
            String s = Base64.encodeBytes(aurl.toByteArray());
            aurl = new ArrayList();
            aurl.add(new BasicNameValuePair("image", s));
            try
            {
                DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost((new StringBuilder(String.valueOf(Util.BASE_PATH_UPLIMG))).append("photo_upload").append(Utility.BASE_FORMAT).append("?id=").append(user_id).toString());
                httppost.setEntity(new UrlEncodedFormEntity(aurl));
                aurl = defaulthttpclient.execute(httppost).getEntity();
                is = aurl.getContent();
                resp = ProfileActivity.inputToString(is);
                Log.e("url", resp);
            }
            // Misplaced declaration of an exception variable
            catch (URL aurl[])
            {
                Log.e("log_tag", (new StringBuilder("Error in http connection ")).append(aurl.toString()).toString());
            }
            return null;
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((URL[])aobj);
        }

        protected void onPostExecute(Long long1)
        {
            super.onPostExecute(long1);
            try
            {
                Log.e("update_byImage", resp);
                if (resp.contains(".jpg"))
                {
                    btnprof_savepic.setVisibility(8);
                    db.update_byImage(user_id, resp);
                    ponselBaseApp.getObserver().setLoginStat("1");
                }
                mDialog.dismiss();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Long long1)
            {
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Long)obj);
        }

        protected void onPreExecute()
        {
            mDialog = ProgressDialog.show(wrapper, "", "Saving image...", true);
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public UploadImage()
        {
            this$0 = ProfileActivity.this;
            super();
        }
    }


    private static final String FOLDER_NAME = "InPonsel";
    public static final int REQUEST_CODE_CROP_IMAGE = 3;
    public static final int REQUEST_CODE_GALLERY = 1;
    public static final int REQUEST_CODE_TAKE_PICTURE = 2;
    public static final String TEMP_PHOTO_FILE_NAME = (new StringBuilder("inponsel_")).append(System.currentTimeMillis()).append(".jpg").toString();
    public static android.content.SharedPreferences.Editor editor;
    public static SharedPreferences prefs;
    final int CROP_FROM_CAMERA = 2;
    final int DATE_DIALOG_ID = 999;
    final int PICK_FROM_CAMERA = 1;
    final int PICK_FROM_FILE = 3;
    Animation animation;
    Animation animationin;
    Animation animationout;
    Button btnBatalProfile;
    RelativeLayout btnBersihCache;
    RelativeLayout btnGantiEmail;
    RelativeLayout btnGantiPass;
    Button btnHpDigunakan2Profile;
    Button btnHpDigunakanProfile;
    Button btnKecamatan;
    RelativeLayout btnKeluar;
    Button btnKotaProfile;
    Button btnLogoutProfile;
    RelativeLayout btnLupaPass;
    Button btnOperatorDigunakan2Profile;
    Button btnOperatorDigunakanProfile;
    Button btnProvProfile;
    Button btnSimpanPassword;
    Button btnSimpanProfile;
    Button btnSubmitHp;
    Button btnTTLProfile;
    Button btn_upload;
    Button btnprof_savepic;
    Calendar c;
    ConnectivityManager cm;
    String currentDateandTime;
    private android.app.DatePickerDialog.OnDateSetListener datePickerListener;
    private int day;
    Dialog dialog;
    EditText edtAuto;
    EditText edtEmailProfile;
    EditText edtHpDigunakan;
    EditText edtHpKetik;
    EditText edtNamaProfile;
    EditText edtPassProfileBaru;
    EditText edtPassProfileLama;
    EditText edtTTL;
    EditText edtUserNameProfile;
    EditText edtrePassProfileBaru;
    String emailProfile;
    String gen_key;
    String getJson;
    String gmail;
    String hpPengguna2Profile;
    String hpPenggunaProfile;
    ImageView imgArrowPass;
    ImageView img_hp2Remove;
    ImageView img_sim2Remove;
    InputStream is;
    int jml;
    ArrayList kecamatanArray;
    ArrayList kecamatanArrayID;
    String kecamatanProfile;
    String kecamatan_id;
    String kecamatan_str;
    String kecamatan_strID;
    String kecamatan_strarray[];
    String kecamatan_strarrayID[];
    ArrayList kotaArray;
    ArrayList kotaArrayID;
    String kotaProfile;
    String kota_id;
    String kota_str;
    String kota_strID;
    String kota_strarray[];
    String kota_strarrayID[];
    String kotaidprefrence;
    String kotaprefrence;
    LinearLayout layout_empty;
    ListAdapter listAdapter;
    ArrayList listArrayList;
    ListView listHp;
    ArrayList listKecamatanArrayList;
    ArrayList listKotaArrayList;
    ArrayList listOpArrayList;
    ListOperatorAdapter listOperatorAdapter;
    ArrayList listProvArrayList;
    SharedPreferences loginPreference;
    ProgressDialog mDialog;
    private File mFileTemp;
    private ImageView mImageView;
    Matrix matrix;
    String message;
    String messageEmailNotif;
    String messageKomenNotif;
    String messageLikeNotif;
    String messagePushNotif;
    String messageTanggapNotif;
    private int month;
    String namaHp;
    String namaHp2;
    String namaProfile;
    NotificationManager notifManager;
    String opera[];
    String passProfile;
    String passSha1Profile;
    LinearLayout passform;
    String passlam;
    String passlamaUpdate;
    Bitmap photo_upload;
    ProgressBar progressbar_item;
    ProgressBar progressbar_middle_dialog;
    ProgressBar progressbar_search;
    String prov[];
    String provider;
    String provider2;
    ArrayList providerArray;
    ArrayList providerArrayID;
    String provider_ID;
    String provider_array[];
    String provider_arrayhpID[];
    String provider_kartu;
    ArrayList provinsiArray;
    ArrayList provinsiArrayID;
    String provinsiProfile;
    String provinsi_id;
    String provinsi_str;
    String provinsi_strID;
    String provinsi_strarray[];
    String provinsi_strarrayID[];
    String provinsiidprefrence;
    String provinsiprefrence;
    String query;
    RadioButton rbPriaProfile;
    RadioButton rbWanitaProfile;
    RadioGroup rdJekelProfile;
    String repassProfile;
    String res;
    String resp;
    Boolean saveLogin;
    SimpleDateFormat sdf;
    ImageView segitigaPonsel1;
    String selectDate;
    String statusEmail;
    String statusKomen;
    String statusLike;
    String statusPush;
    String statusTanggap;
    String success;
    String t;
    String tggalProfile;
    TextView titleDaftarHP;
    String toastEmailNotif;
    String toastKomenNotif;
    String toastLikeNotif;
    String toastPushNotif;
    String toastTanggapNotif;
    TextView txtEmpty;
    TextView txtketusername;
    String ucodename1;
    String ucodename2;
    String urlKecamatan;
    String user_jekel_cb;
    String usernamaProfile;
    ContextThemeWrapper wrapper;
    private int year;

    public ProfileActivity()
    {
        passlamaUpdate = "";
        statusEmail = "1";
        statusPush = "1";
        statusKomen = "1";
        messageEmailNotif = "";
        messageKomenNotif = "";
        toastEmailNotif = "";
        toastKomenNotif = "";
        messagePushNotif = "";
        toastPushNotif = "";
        statusLike = "1";
        messageLikeNotif = "";
        toastLikeNotif = "";
        statusTanggap = "1";
        messageTanggapNotif = "";
        toastTanggapNotif = "";
        urlKecamatan = "";
        ucodename1 = "";
        ucodename2 = "";
        listArrayList = null;
        listOpArrayList = null;
        listProvArrayList = null;
        listKotaArrayList = null;
        listKecamatanArrayList = null;
        res = "";
        getJson = "";
        jml = 0;
        namaHp = "";
        namaHp2 = "";
        hpPenggunaProfile = "";
        hpPengguna2Profile = "";
        t = Utility.session(RestClient.pelihara);
        provinsiProfile = "";
        kotaProfile = "";
        kota_id = "";
        kecamatanProfile = "";
        kecamatan_id = "";
        prov = null;
        opera = null;
        provinsi_id = "";
        provider = "";
        provider2 = "";
        gmail = null;
        animation = null;
        query = "";
        user_jekel_cb = "1";
        provinsiArray = null;
        provinsiArrayID = null;
        provinsiprefrence = "";
        provinsiidprefrence = "";
        kotaprefrence = "";
        kotaidprefrence = "";
        kotaArray = null;
        kotaArrayID = null;
        kecamatanArray = null;
        kecamatanArrayID = null;
        providerArray = null;
        providerArrayID = null;
        success = "";
        message = "";
        gen_key = "";
        datePickerListener = new android.app.DatePickerDialog.OnDateSetListener() {

            final ProfileActivity this$0;

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
                btnTTLProfile.setText(datepicker);
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
                this$0 = ProfileActivity.this;
                super();
            }
        };
    }

    private void PushOnlineStat(String s)
    {
        String s1 = getSharedPreferences("gcm_reg", 0).getString("gcm_id", "");
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_last_seen").append(Utility.BASE_FORMAT).append("?").append("id_user=").append(user_id).append("&stat=").append(s).append("&reg_id=").append(s1).append("&t=").append(t).toString();
        Log.e("pushOnline", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final ProfileActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                Log.e("response", jsonobject.toString());
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ProfileActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "");
    }

    private void SendEmail(String s, String s1)
    {
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_confirmationmail").append(Utility.BASE_FORMAT).append("?").append("id_user=").append(user_id).append("&new=").append(s).append("&gen_key=").append(s1).append("&t=").append(t).toString();
        Log.e("urlSendEmail", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final ProfileActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ProfileActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "tag_json_obj");
    }

    private void UpdateEmail(final String email)
    {
        String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("change_email").append(Utility.BASE_FORMAT).append("?").append("id_user=").append(user_id).append("&new=").append(email).append("&t=").append(t).toString();
        Log.e("urlUpdateEmail", s);
        email = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final ProfileActivity this$0;
            private final String val$email;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                JSONObject jsonobject2;
                int i;
                try
                {
                    JSONObject jsonobject1 = new JSONObject(jsonobject.toString());
                    Log.e("UpdateEmail", jsonobject.toString());
                    jsonobject = jsonobject1.getJSONArray("InPonsel");
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    jsonobject.printStackTrace();
                    return;
                }
                i = 0;
                if (i >= jsonobject.length())
                {
                    jsonobject = new android.app.AlertDialog.Builder(ProfileActivity.this);
                    jsonobject.setTitle("Perhatian");
                    jsonobject.setMessage(message);
                    jsonobject.setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                        final _cls33 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls33.this;
                super();
            }
                    });
                    jsonobject.show();
                    SendEmail(email, gen_key);
                    return;
                }
                jsonobject2 = jsonobject.getJSONObject(i);
                success = jsonobject2.getString("success");
                message = jsonobject2.getString("message");
                gen_key = jsonobject2.getString("gen_key");
                i++;
                if (false)
                {
                } else
                {
                    break MISSING_BLOCK_LABEL_30;
                }
            }

            
            {
                this$0 = ProfileActivity.this;
                email = s;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ProfileActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(email, "tag_json_obj");
    }

    public static void clearSharedPreferences(Context context)
    {
        File file = new File((new StringBuilder(String.valueOf(context.getFilesDir().getParent()))).append("/shared_prefs/").toString());
        String as[] = file.list();
        int i = 0;
        do
        {
label0:
            {
label1:
                {
                    {
                        if (i < as.length)
                        {
                            break label1;
                        }
                        try
                        {
                            Thread.sleep(1000L);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Context context) { }
                        i = 0;
                    }
                    if (i >= as.length)
                    {
                        return;
                    }
                    break label0;
                }
                context.getSharedPreferences(as[i].replace(".xml", ""), 0).edit().clear().commit();
                i++;
            }
        } while (true);
        (new File(file, as[i])).delete();
        i++;
        break MISSING_BLOCK_LABEL_55;
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

    private String getFormatedTime(String s)
    {
        try
        {
            Object obj = s.replace("Januari", "Jan").replace("Februari", "Feb").replace("Maret", "Mar").replace("April", "Apr").replace("Mei", "May").replace("Juni", "Jun").replace("Juli", "Jul").replace("Agustus", "Aug").replace("September", "Sept").replace("Oktober", "Oct").replace("November", "Nov").replace("Desember", "Dec").replace("Senin", "Mon").replace("Selasa", "Tue").replace("Rabu", "Wed").replace("Kamis", "Thu").replace("Jum'at", "Fri").replace("Sabtu", "Sat").replace("Minggu", "Sun");
            s = new SimpleDateFormat("E, dd MMM yyyy");
            obj = s.parse(((String) (obj)));
            s.applyPattern("yyyy-MM-dd");
            s = s.format(((Date) (obj))).replace("09", "9").replace("08", "8").replace("07", "7").replace("06", "6").replace("05", "5").replace("04", "4").replace("03", "3").replace("02", "2").replace("01", "1");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
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

    private static String inputToString(InputStream inputstream)
        throws Exception
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (inputstream == null) goto _L2; else goto _L1
_L1:
        inputstream = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
_L4:
        String s = inputstream.readLine();
        if (s != null) goto _L3; else goto _L2
_L2:
        return stringbuilder.toString();
_L3:
        stringbuilder.append(s).append('\n');
          goto _L4
        inputstream;
          goto _L2
    }

    private void openGallery()
    {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    private void startCropImage()
    {
        Intent intent = new Intent(this, eu/janmuller/android/simplecropimage/CropImage);
        intent.putExtra("image-path", mFileTemp.getPath());
        intent.putExtra("scale", true);
        intent.putExtra("aspectX", 10);
        intent.putExtra("aspectY", 10);
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

    public void backrotateView(View view)
    {
        RotateAnimation rotateanimation = new RotateAnimation(90F, 0.0F, view.getWidth() / 2, view.getWidth() / 2);
        rotateanimation.setDuration(500L);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), 0x7f020277);
        Matrix matrix1 = new Matrix();
        matrix1.postRotate(0.0F);
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix1, true);
        ((ImageView)view).setImageBitmap(bitmap);
        view.startAnimation(rotateanimation);
    }

    public void checkField()
    {
        if (edtPassProfileBaru.getText().toString().length() < 4 || edtrePassProfileBaru.getText().toString().length() < 4)
        {
            btnSimpanPassword.setEnabled(false);
            return;
        } else
        {
            btnSimpanPassword.setEnabled(true);
            return;
        }
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
        break; /* Loop/switch isn't completed */
_L6:
        continue; /* Loop/switch isn't completed */
_L7:
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
          goto _L7
_L5:
        startCropImage();
          goto _L7
        if (intent.getStringExtra("image-path") == null) goto _L1; else goto _L8
_L8:
        Bitmap bitmap = BitmapFactory.decodeFile(mFileTemp.getPath());
        photo_upload = BitmapFactory.decodeFile(mFileTemp.getPath());
        mImageView.setImageBitmap(bitmap);
        (new Handler()).postDelayed(new Runnable() {

            final ProfileActivity this$0;

            public void run()
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new UploadImage()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new URL[0]);
                    return;
                } else
                {
                    (new UploadImage()).execute(new URL[0]);
                    return;
                }
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        }, 2000L);
          goto _L7
        if (true) goto _L1; else goto _L9
_L9:
    }

    public void onBackPressed()
    {
        if (mDrawerLayout.isDrawerOpen(0x800003))
        {
            mDrawerLayout.closeDrawers();
            Log.e("vis", "on");
            return;
        } else
        {
            Log.e("vis", "off");
            finish();
            overridePendingTransition(0x7f040001, 0x7f040002);
            return;
        }
    }

    protected void onCreate(final Bundle dialog)
    {
        super.onCreate(dialog);
        dialog = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300d1, null, false);
        mDrawerLayout.addView(dialog, 0);
        notifManager = (NotificationManager)getSystemService("notification");
        menu_profil.setEnabled(false);
        android.app.AlertDialog.Builder builder;
        int i;
        int j;
        try
        {
            dialog = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            dialog.setScreenName("Profil Pengguna");
            dialog.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
        }
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Profil</font>"));
        dialog = (TextView)findViewById(i);
        dialog.setSelected(true);
        dialog.setTextColor(Color.parseColor("#FFFFFF"));
        dialog.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        wrapper = new ContextThemeWrapper(this, 0x103006e);
        cm = (ConnectivityManager)getSystemService("connectivity");
        t = Utility.session(t);
        matrix = new Matrix();
        animation = AnimationUtils.loadAnimation(this, 0x7f040018);
        animationin = AnimationUtils.loadAnimation(this, 0x7f040010);
        animationout = AnimationUtils.loadAnimation(this, 0x7f040013);
        progressbar_item = (ProgressBar)findViewById(0x7f0b00b3);
        loginPreference = getSharedPreferences("com.inponsel.android_preference", 0);
        t = Utility.session(t);
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        currentDateandTime = sdf.format(new Date());
        edtNamaProfile = (EditText)findViewById(0x7f0b0351);
        edtUserNameProfile = (EditText)findViewById(0x7f0b0352);
        edtPassProfileLama = (EditText)findViewById(0x7f0b009c);
        edtPassProfileBaru = (EditText)findViewById(0x7f0b009d);
        edtrePassProfileBaru = (EditText)findViewById(0x7f0b009e);
        edtEmailProfile = (EditText)findViewById(0x7f0b0353);
        rdJekelProfile = (RadioGroup)findViewById(0x7f0b0354);
        rbPriaProfile = (RadioButton)findViewById(0x7f0b0355);
        rbWanitaProfile = (RadioButton)findViewById(0x7f0b0356);
        btnTTLProfile = (Button)findViewById(0x7f0b0357);
        btnProvProfile = (Button)findViewById(0x7f0b0358);
        btnKotaProfile = (Button)findViewById(0x7f0b0359);
        btnKotaProfile.setEnabled(true);
        btnKecamatan = (Button)findViewById(0x7f0b01dd);
        btnKecamatan.setEnabled(true);
        edtNamaProfile.setFocusable(false);
        img_hp2Remove = (ImageView)findViewById(0x7f0b035d);
        img_sim2Remove = (ImageView)findViewById(0x7f0b0360);
        btnHpDigunakanProfile = (Button)findViewById(0x7f0b035b);
        btnHpDigunakan2Profile = (Button)findViewById(0x7f0b035c);
        btnOperatorDigunakanProfile = (Button)findViewById(0x7f0b035e);
        btnOperatorDigunakan2Profile = (Button)findViewById(0x7f0b035f);
        btnLogoutProfile = (Button)findViewById(0x7f0b0370);
        btnSimpanProfile = (Button)findViewById(0x7f0b0361);
        btnBatalProfile = (Button)findViewById(0x7f0b0362);
        btnSimpanPassword = (Button)findViewById(0x7f0b009f);
        btnSimpanPassword.setEnabled(false);
        edtNamaProfile.setText(nama_asli);
        edtUserNameProfile.setText(username);
        edtUserNameProfile.setFocusable(false);
        edtUserNameProfile.setFocusableInTouchMode(false);
        edtUserNameProfile.setClickable(false);
        btnGantiEmail = (RelativeLayout)findViewById(0x7f0b0363);
        btnGantiPass = (RelativeLayout)findViewById(0x7f0b0366);
        btnLupaPass = (RelativeLayout)findViewById(0x7f0b036a);
        btnBersihCache = (RelativeLayout)findViewById(0x7f0b036c);
        btnKeluar = (RelativeLayout)findViewById(0x7f0b036e);
        passform = (LinearLayout)findViewById(0x7f0b0369);
        imgArrowPass = (ImageView)findViewById(0x7f0b0368);
        img_hp2Remove.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                btnHpDigunakan2Profile.setText("");
                user_ponsel2 = "";
                img_hp2Remove.setBackgroundResource(0x7f0201e5);
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        img_sim2Remove.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                btnOperatorDigunakan2Profile.setText("");
                user_provider2 = "";
                img_sim2Remove.setBackgroundResource(0x7f0201e5);
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnLupaPass.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://inponsel.com/mobile.forgot.password/")));
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnGantiEmail.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(ProfileActivity.this);
                view.setTitle("Ganti Email");
                view.setMessage("Masukkan email baru :");
                EditText edittext = new EditText(ProfileActivity.this);
                view.setView(edittext);
                view.setPositiveButton("Ganti", edittext. new android.content.DialogInterface.OnClickListener() {

                    final _cls5 this$1;
                    private final EditText val$input;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface = input.getText().toString();
                        if (!RegisterActivity.checkEmail(dialoginterface))
                        {
                            Toast.makeText(_fld0, "email tidak valid", 0).show();
                            return;
                        } else
                        {
                            UpdateEmail(dialoginterface);
                            return;
                        }
                    }

            
            {
                this$1 = final__pcls5;
                input = EditText.this;
                super();
            }
                });
                view.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                    final _cls5 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
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
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnGantiPass.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                imgArrowPass.setBackgroundColor(0);
                if (passform.getVisibility() == 0)
                {
                    animationout.setDuration(500L);
                    passform.startAnimation(animationout);
                    backrotateView(imgArrowPass);
                    (new Handler()).postDelayed(new Runnable() {

                        final _cls6 this$1;

                        public void run()
                        {
                            passform.setVisibility(8);
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    }, 400L);
                    return;
                } else
                {
                    animationin.setDuration(500L);
                    passform.startAnimation(animationin);
                    rotateView(imgArrowPass);
                    (new Handler()).postDelayed(new Runnable() {

                        final _cls6 this$1;

                        public void run()
                        {
                            passform.setVisibility(0);
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    }, 200L);
                    return;
                }
            }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnBersihCache.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(wrapper);
                view.setMessage("Hapus cache?");
                view.setPositiveButton("Gambar", new android.content.DialogInterface.OnClickListener() {

                    final _cls7 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        imageLoader2.clearMemoryCache();
                        Toast.makeText(getApplicationContext(), "Cache gambar berhasil di hapus", 1).show();
                    }

            
            {
                this$1 = _cls7.this;
                super();
            }
                });
                view.setNegativeButton("Data", new android.content.DialogInterface.OnClickListener() {

                    final _cls7 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        (new File("/data/data/com.inponsel.android/shared_prefs/inponsel_preference.xml")).delete();
                        dialoginterface.dismiss();
                        Toast.makeText(getApplicationContext(), "Cache data berhasil di hapus", 1).show();
                    }

            
            {
                this$1 = _cls7.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnKeluar.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(wrapper);
                view.setTitle("Logout InPonsel");
                view.setMessage("Ingin logout dari InPonsel?");
                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final _cls8 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        PushOnlineStat("0");
                        notifManager.cancelAll();
                        db.resetUnreadMSGTables();
                        db.removeAll();
                        dialoginterface = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewMainActivity);
                        dialoginterface.addFlags(0x4000000);
                        dialoginterface.addFlags(32768);
                        startActivity(dialoginterface);
                        finish();
                    }

            
            {
                this$1 = _cls8.this;
                super();
            }
                });
                view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final _cls8 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls8.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnBatalProfile.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        try
        {
            passlam = EncodeDecodeAES.decrypt(RestClient.pelihara, loginPreference.getString("save", ""));
            passlamaUpdate = passlam;
            edtPassProfileLama.setText("");
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
        }
        edtPassProfileLama.setClickable(true);
        edtPassProfileBaru.addTextChangedListener(new TextWatcher() {

            final ProfileActivity this$0;

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
                this$0 = ProfileActivity.this;
                super();
            }
        });
        edtrePassProfileBaru.addTextChangedListener(new TextWatcher() {

            final ProfileActivity this$0;

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
                this$0 = ProfileActivity.this;
                super();
            }
        });
        edtEmailProfile.setText(email_user);
        edtEmailProfile.setFocusable(false);
        edtEmailProfile.setFocusableInTouchMode(false);
        edtEmailProfile.setClickable(false);
        if (user_jekel.equals("Pria") || user_jekel.equals("1"))
        {
            rbPriaProfile.setChecked(true);
            user_jekel_cb = "1";
        } else
        {
            rbWanitaProfile.setChecked(true);
            user_jekel_cb = "2";
        }
        try
        {
            dialog = (new SimpleDateFormat("yyyy-MM-dd")).parse(user_ttl);
            dialog = (new SimpleDateFormat("E, dd MMM yyyy", Locale.US)).format(dialog).replace("Jan", "Januari").replace("Feb", "Februari").replace("Mar", "Maret").replace("Apr", "April").replace("May", "Mei").replace("Jun", "Juni").replace("Jul", "Juli").replace("Aug", "Agustus").replace("Sept", "September").replace("Oct", "Oktober").replace("Nov", "November").replace("Dec", "Desember").replace("Mon", "Senin").replace("Tue", "Selasa").replace("Wed", "Rabu").replace("Thu", "Kamis").replace("Fri", "Jum'at").replace("Sat", "Sabtu").replace("Sun", "Minggu");
            btnTTLProfile.setText(dialog);
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog) { }
        btnProvProfile.setText(user_provinsi);
        btnKotaProfile.setText(user_kota);
        if (!user_kecamatan.equals("-"))
        {
            btnKecamatan.setText(user_kecamatan);
        }
        btnHpDigunakanProfile.setText(user_ponsel1);
        btnHpDigunakan2Profile.setText(user_ponsel2);
        btnOperatorDigunakanProfile.setText(user_provider1);
        btnOperatorDigunakan2Profile.setText(user_provider2);
        if (!user_ponsel2.equals(""))
        {
            img_hp2Remove.setBackgroundResource(0x7f0201ec);
        }
        if (!user_provider2.equals(""))
        {
            img_sim2Remove.setBackgroundResource(0x7f0201ec);
        }
        btnLogoutProfile.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(wrapper);
                view.setTitle("Logout dari InPonsel");
                view.setMessage("Ingin logout dari InPonsel?");
                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final _cls12 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        PushOnlineStat("0");
                        notifManager.cancelAll();
                        db.removeAll();
                        dialoginterface = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewMainActivity);
                        dialoginterface.addFlags(0x4000000);
                        startActivity(dialoginterface);
                        finish();
                    }

            
            {
                this$1 = _cls12.this;
                super();
            }
                });
                view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                    final _cls12 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls12.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        Log.e("user_ttl", (new StringBuilder(String.valueOf(user_ttl))).append("=").append(getFormatedTime(btnTTLProfile.getText().toString())).toString());
        btnSimpanProfile.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                if (!edtNamaProfile.getText().toString().equals(nama_asli) || !user_jekel.equals(user_jekel_cb) || !user_ttl.equals(getFormatedTime(btnTTLProfile.getText().toString())) || !user_provinsi.equals(btnProvProfile.getText().toString()) || !user_kota.equals(btnKotaProfile.getText().toString()) || !user_kecamatan.equals(btnKecamatan.getText().toString()) || !user_ponsel1.equals(btnHpDigunakanProfile.getText().toString()) || !user_ponsel2.equals(btnHpDigunakan2Profile.getText().toString()) || !user_provider1.equals(btnOperatorDigunakanProfile.getText().toString()) || !user_provider2.equals(btnOperatorDigunakan2Profile.getText().toString())) goto _L2; else goto _L1
_L1:
                Toast.makeText(getApplicationContext(), "Tidak ada perubahan", 1).show();
_L4:
                return;
_L2:
                provinsiProfile = btnProvProfile.getText().toString();
                kotaProfile = btnKotaProfile.getText().toString();
                kecamatanProfile = btnKecamatan.getText().toString();
                hpPenggunaProfile = btnHpDigunakanProfile.getText().toString();
                namaProfile = edtNamaProfile.getText().toString();
                usernamaProfile = edtUserNameProfile.getText().toString();
                passProfile = passlamaUpdate;
                passProfile = Utility.session(passProfile);
                passProfile = Utility.session(passProfile);
                passProfile = Utility.session(passProfile);
                passProfile = Utility.session(passProfile);
                passProfile = Utility.session(passProfile);
                repassProfile = edtPassProfileBaru.getText().toString();
                repassProfile = Utility.session(repassProfile);
                repassProfile = Utility.session(repassProfile);
                repassProfile = Utility.session(repassProfile);
                repassProfile = Utility.session(repassProfile);
                repassProfile = Utility.session(repassProfile);
                emailProfile = edtEmailProfile.getText().toString();
                tggalProfile = btnTTLProfile.getText().toString();
                provider = btnOperatorDigunakanProfile.getText().toString();
                provider2 = btnOperatorDigunakan2Profile.getText().toString();
                if (tggalProfile.equals("*Tanggal lahir"))
                {
                    Toast.makeText(ProfileActivity.this, "Tanggal belum diisi", 0).show();
                    btnTTLProfile.startAnimation(animation);
                    return;
                }
                if (provinsiProfile.equals(""))
                {
                    Toast.makeText(ProfileActivity.this, "Anda belum mengisi provinsi", 0).show();
                    return;
                }
                if (kotaProfile.equals(""))
                {
                    Toast.makeText(ProfileActivity.this, "Anda belum mengisi kota", 0).show();
                    return;
                }
                if (kecamatanProfile.equals(""))
                {
                    Toast.makeText(ProfileActivity.this, "Anda belum mengisi kecamatan", 0).show();
                    return;
                }
                if (hpPenggunaProfile.equals("") || hpPenggunaProfile.equals("Ponsel digunakan*"))
                {
                    Toast.makeText(ProfileActivity.this, "Anda belum mengisi hp", 0).show();
                    return;
                }
                if (provider.equals(""))
                {
                    Toast.makeText(ProfileActivity.this, "Anda belum mengisi provider", 0).show();
                    return;
                }
                if (year != 0 || month != 0 || day != 0)
                {
                    break; /* Loop/switch isn't completed */
                }
                selectDate = user_ttl;
_L5:
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
                {
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new RegisterTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    }
                    break MISSING_BLOCK_LABEL_1113;
                }
                if (true) goto _L4; else goto _L3
_L3:
                try
                {
                    selectDate = String.valueOf((new StringBuilder(String.valueOf(year))).append("-").append(month).append("-").append(day).toString());
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                  goto _L5
                if (true) goto _L4; else goto _L6
_L6:
                (new RegisterTask()).execute(new Void[0]);
                return;
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnProvProfile.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

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

                        final _cls14 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            adapterview = ((TextView)view).getText().toString();
                            provinsi_id = provinsi_strarrayID[i];
                            provinsiProfile = adapterview;
                            btnProvProfile.setText(provinsiProfile);
                            btnKotaProfile.setEnabled(true);
                            provinsiprefrence = provinsiProfile.toString().trim();
                            provinsiidprefrence = provinsi_id;
                            dialog.dismiss();
                        }

            
            {
                this$1 = _cls14.this;
                super();
            }
                    });
                } else
                {
                    listOperatorAdapter = new ListOperatorAdapter(ProfileActivity.this, 0x7f03006e, listProvArrayList);
                    listHp.setAdapter(listOperatorAdapter);
                    Log.e("prov", (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("tinggal_provinsi").append(Utility.BASE_FORMAT).append("?t=").append(t).toString());
                    (new ProvinsiSync(null)).execute(new String[] {
                        (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("tinggal_provinsi").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                    });
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls14 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                            provinsiProfile = listOperatorAdapter.getListModel(i).getNm_op().toString();
                            provinsi_id = listOperatorAdapter.getListModel(i).getProvinsi_id().toString();
                            Log.e("provinsi", provinsiProfile);
                            btnProvProfile.setText(provinsiProfile);
                            provinsiprefrence = provinsiProfile.toString().trim();
                            provinsiidprefrence = provinsi_id;
                            btnKotaProfile.setEnabled(true);
                            dialog.dismiss();
                        }

            
            {
                this$1 = _cls14.this;
                super();
            }
                    });
                }
                dialog = view.create();
                dialog.show();
            }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnKotaProfile.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

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
                progressbar_search = (ProgressBar)view1.findViewById(0x7f0b008e);
                txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
                txtEmpty.setText(0x7f0c0053);
                if (android.os.Build.VERSION.SDK_INT < 13)
                {
                    listHp.setBackgroundColor(-1);
                }
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

                        final _cls15 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            adapterview = ((TextView)view).getText().toString();
                            kota_id = kota_strarrayID[i];
                            kotaProfile = adapterview;
                            btnKotaProfile.setText(kotaProfile);
                            kotaprefrence = kotaProfile.toString().trim();
                            kotaidprefrence = kota_id;
                            dialog.dismiss();
                        }

            
            {
                this$1 = _cls15.this;
                super();
            }
                    });
                } else
                {
                    listOperatorAdapter = new ListOperatorAdapter(ProfileActivity.this, 0x7f03006e, listKotaArrayList);
                    listHp.setAdapter(listOperatorAdapter);
                    (new KotaSync(null)).execute(new String[] {
                        (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("tinggal_kota").append(Utility.BASE_FORMAT).append("?provinsi_id=").append(provinsi_id).append("&t=").append(t).toString()
                    });
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls15 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                            kotaProfile = listOperatorAdapter.getListModel(i).getNm_op().toString();
                            kota_id = listOperatorAdapter.getListModel(i).getKota_id().toString();
                            Log.e("kota", kotaProfile);
                            btnKotaProfile.setText(kotaProfile);
                            kotaprefrence = kotaProfile.toString().trim();
                            kotaidprefrence = kota_id;
                            dialog.dismiss();
                        }

            
            {
                this$1 = _cls15.this;
                super();
            }
                    });
                }
                dialog = view.create();
                dialog.show();
            }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnKecamatan.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                if (provinsi_id.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Pilih provinsi terlebih dahulu", 1).show();
                    return;
                }
                if (kota_id.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Pilih kota terlebih dahulu", 1).show();
                    return;
                }
                View view1 = getLayoutInflater().inflate(0x7f030026, null);
                view = new android.app.AlertDialog.Builder(wrapper);
                view.setView(view1);
                view.setTitle("Pilih Kecamatan :");
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
                listKecamatanArrayList = new ArrayList();
                kecamatan_strarray = loadArray(kotaprefrence, getApplicationContext());
                kecamatan_strarrayID = loadArray(kotaidprefrence, getApplicationContext());
                kecamatanArray = new ArrayList();
                kecamatanArray = new ArrayList(Arrays.asList(kecamatan_strarray));
                kecamatanArrayID = new ArrayList();
                kecamatanArrayID = new ArrayList(Arrays.asList(kecamatan_strarrayID));
                if (kecamatanArray.size() != 0)
                {
                    Log.e("kecamatanArray", String.valueOf(kecamatanArray));
                    Log.e("kecamatanArrayID", String.valueOf(kecamatanArrayID));
                    ArrayAdapter arrayadapter = new ArrayAdapter(wrapper, 0x1090003, kecamatanArray);
                    listHp.setAdapter(arrayadapter);
                    layout_empty.setVisibility(8);
                    listHp.setVisibility(0);
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls16 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            adapterview = ((TextView)view).getText().toString();
                            kecamatan_id = kecamatan_strarrayID[i];
                            Log.e("kecamatan_id", kecamatan_id);
                            kecamatanProfile = adapterview;
                            btnKecamatan.setText(kecamatanProfile);
                            dialog.dismiss();
                        }

            
            {
                this$1 = _cls16.this;
                super();
            }
                    });
                } else
                {
                    listOperatorAdapter = new ListOperatorAdapter(ProfileActivity.this, 0x7f03006e, listKecamatanArrayList);
                    listHp.setAdapter(listOperatorAdapter);
                    try
                    {
                        urlKecamatan = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_kecamatan").append(Utility.BASE_FORMAT).append("?provinsi_id=").append(URLEncoder.encode(btnProvProfile.getText().toString(), "utf-8")).append("&kota_id=").append(URLEncoder.encode(btnKotaProfile.getText().toString(), "utf-8")).append("&t=").append(t).toString();
                    }
                    catch (UnsupportedEncodingException unsupportedencodingexception)
                    {
                        unsupportedencodingexception.printStackTrace();
                    }
                    Log.e("urlKecamatan", urlKecamatan);
                    (new KecamatanSync(null)).execute(new String[] {
                        urlKecamatan
                    });
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls16 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                            kecamatan_id = listOperatorAdapter.getListModel(i).getKecamatan_id().toString();
                            kecamatanProfile = listOperatorAdapter.getListModel(i).getNm_op().toString();
                            Log.e("kecamatan", kecamatanProfile);
                            btnKecamatan.setText(kecamatanProfile);
                            dialog.dismiss();
                        }

            
            {
                this$1 = _cls16.this;
                super();
            }
                    });
                }
                dialog = view.create();
                dialog.show();
            }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnOperatorDigunakanProfile.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                View view1 = getLayoutInflater().inflate(0x7f030026, null);
                view = new android.app.AlertDialog.Builder(ProfileActivity.this);
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

                        final _cls17 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            adapterview = ((TextView)view).getText().toString();
                            provider = adapterview;
                            btnOperatorDigunakanProfile.setText(adapterview);
                            dialog.dismiss();
                        }

            
            {
                this$1 = _cls17.this;
                super();
            }
                    });
                } else
                {
                    listOperatorAdapter = new ListOperatorAdapter(ProfileActivity.this, 0x7f03006e, listOpArrayList);
                    listHp.setAdapter(listOperatorAdapter);
                    (new OperatorSync(null)).execute(new String[] {
                        (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("operator_inponsel").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                    });
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls17 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                            provider = listOperatorAdapter.getListModel(i).getNm_op().toString();
                            Log.e("provider", provider);
                            btnOperatorDigunakanProfile.setText(provider);
                            dialog.dismiss();
                        }

            
            {
                this$1 = _cls17.this;
                super();
            }
                    });
                }
                dialog = view.create();
                dialog.show();
            }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnOperatorDigunakan2Profile.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                View view1 = getLayoutInflater().inflate(0x7f030026, null);
                view = new android.app.AlertDialog.Builder(wrapper);
                view.setView(view1);
                view.setTitle("Pilih Operator Kedua:");
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

                        final _cls18 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            adapterview = ((TextView)view).getText().toString();
                            provider2 = adapterview;
                            btnOperatorDigunakan2Profile.setText(adapterview);
                            img_sim2Remove.setBackgroundResource(0x7f0201ec);
                            dialog.dismiss();
                        }

            
            {
                this$1 = _cls18.this;
                super();
            }
                    });
                } else
                {
                    listOperatorAdapter = new ListOperatorAdapter(ProfileActivity.this, 0x7f03006e, listOpArrayList);
                    listHp.setAdapter(listOperatorAdapter);
                    (new OperatorSync(null)).execute(new String[] {
                        (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("operator_inponsel").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                    });
                    listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                        final _cls18 this$1;

                        public void onItemClick(AdapterView adapterview, View view, int i, long l)
                        {
                            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                            provider2 = listOperatorAdapter.getListModel(i).getNm_op().toString();
                            Log.e("provider", provider2);
                            btnOperatorDigunakan2Profile.setText(provider2);
                            img_sim2Remove.setBackgroundResource(0x7f0201ec);
                            dialog.dismiss();
                        }

            
            {
                this$1 = _cls18.this;
                super();
            }
                    });
                }
                dialog = view.create();
                dialog.show();
            }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        segitigaPonsel1 = (ImageView)findViewById(0x7f0b01de);
        segitigaPonsel1.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                Log.e("click", "custom dialog");
                view = getLayoutInflater().inflate(0x7f030026, null);
                android.app.AlertDialog.Builder builder1 = new android.app.AlertDialog.Builder(wrapper);
                builder1.setView(view);
                builder1.setTitle("Pilih Ponsel :");
                progressbar_middle_dialog = (ProgressBar)view.findViewById(0x7f0b0092);
                progressbar_middle_dialog.setVisibility(8);
                layout_empty = (LinearLayout)view.findViewById(0x7f0b0091);
                edtAuto = (EditText)view.findViewById(0x7f0b008d);
                edtHpKetik = (EditText)view.findViewById(0x7f0b0094);
                btnSubmitHp = (Button)view.findViewById(0x7f0b0095);
                listHp = (ListView)view.findViewById(0x7f0b008f);
                if (android.os.Build.VERSION.SDK_INT < 13)
                {
                    listHp.setBackgroundColor(-1);
                }
                progressbar_search = (ProgressBar)view.findViewById(0x7f0b008e);
                txtEmpty = (TextView)view.findViewById(0x7f0b0093);
                txtEmpty.setText("Masukkan ponsel yang dicari");
                listArrayList = new ArrayList();
                listAdapter = new ListAdapter(ProfileActivity.this, 0x7f03006e, listArrayList);
                listHp.setAdapter(listAdapter);
                edtAuto.setSingleLine(true);
                edtAuto.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                    final _cls19 this$1;

                    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
                    {
                        if (i != 3) goto _L2; else goto _L1
_L1:
                        if (edtAuto.getText().length() == 0)
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
                this$1 = _cls19.this;
                super();
            }
                });
                edtAuto.addTextChangedListener(new DelayedTextWatcher(2000L) {

                    final _cls19 this$1;

                    public void afterTextChangedDelayed(Editable editable)
                    {
                        if (edtAuto.getText().length() == 0)
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
                this$1 = _cls19.this;
                super(l);
            }
                });
                listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                    final _cls19 this$1;

                    public void onItemClick(AdapterView adapterview, View view, int i, long l)
                    {
                        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                        namaHp = listAdapter.getListModel(i).getNamalengkap().toString();
                        Log.e("namahp", namaHp);
                        btnHpDigunakanProfile.setText(namaHp);
                        hpPenggunaProfile = namaHp;
                        dialog.dismiss();
                    }

            
            {
                this$1 = _cls19.this;
                super();
            }
                });
                btnSubmitHp.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls19 this$1;

                    public void onClick(View view)
                    {
                        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                        hpPenggunaProfile = edtHpKetik.getText().toString();
                        btnHpDigunakanProfile.setText(hpPenggunaProfile);
                        dialog.dismiss();
                    }

            
            {
                this$1 = _cls19.this;
                super();
            }
                });
                dialog = builder1.create();
                dialog.show();
            }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnHpDigunakanProfile.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                Log.e("click", "custom dialog");
                view = getLayoutInflater().inflate(0x7f030026, null);
                android.app.AlertDialog.Builder builder1 = new android.app.AlertDialog.Builder(wrapper);
                builder1.setView(view);
                builder1.setTitle("Pilih Ponsel :");
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
                listAdapter = new ListAdapter(ProfileActivity.this, 0x7f03006e, listArrayList);
                listHp.setAdapter(listAdapter);
                edtAuto.setSingleLine(true);
                edtAuto.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                    final _cls20 this$1;

                    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
                    {
                        if (i != 3) goto _L2; else goto _L1
_L1:
                        if (edtAuto.getText().length() == 0)
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
                this$1 = _cls20.this;
                super();
            }
                });
                edtAuto.addTextChangedListener(new DelayedTextWatcher(2000L) {

                    final _cls20 this$1;

                    public void afterTextChangedDelayed(Editable editable)
                    {
                        if (edtAuto.getText().length() == 0)
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
                this$1 = _cls20.this;
                super(l);
            }
                });
                listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                    final _cls20 this$1;

                    public void onItemClick(AdapterView adapterview, View view, int i, long l)
                    {
                        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                        namaHp = listAdapter.getListModel(i).getNamalengkap().toString();
                        ucodename1 = listAdapter.getListModel(i).getCodename().toString();
                        Log.e("namahp", namaHp);
                        btnHpDigunakanProfile.setText(namaHp);
                        hpPenggunaProfile = namaHp;
                        dialog.dismiss();
                    }

            
            {
                this$1 = _cls20.this;
                super();
            }
                });
                btnSubmitHp.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls20 this$1;

                    public void onClick(View view)
                    {
                        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                        hpPenggunaProfile = edtHpKetik.getText().toString();
                        btnHpDigunakanProfile.setText(hpPenggunaProfile);
                        dialog.dismiss();
                    }

            
            {
                this$1 = _cls20.this;
                super();
            }
                });
                dialog = builder1.create();
                dialog.show();
            }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnHpDigunakan2Profile.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                Log.e("click", "custom dialog");
                view = getLayoutInflater().inflate(0x7f030026, null);
                android.app.AlertDialog.Builder builder1 = new android.app.AlertDialog.Builder(wrapper);
                builder1.setView(view);
                builder1.setTitle("Pilih Ponsel Kedua:");
                progressbar_middle_dialog = (ProgressBar)view.findViewById(0x7f0b0092);
                progressbar_middle_dialog.setVisibility(8);
                layout_empty = (LinearLayout)view.findViewById(0x7f0b0091);
                edtAuto = (EditText)view.findViewById(0x7f0b008d);
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
                listAdapter = new ListAdapter(ProfileActivity.this, 0x7f03006e, listArrayList);
                listHp.setAdapter(listAdapter);
                edtAuto.setSingleLine(true);
                edtAuto.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                    final _cls21 this$1;

                    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
                    {
                        if (i != 3) goto _L2; else goto _L1
_L1:
                        if (edtAuto.getText().length() == 0)
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
                this$1 = _cls21.this;
                super();
            }
                });
                edtAuto.addTextChangedListener(new DelayedTextWatcher(2000L) {

                    final _cls21 this$1;

                    public void afterTextChangedDelayed(Editable editable)
                    {
                        if (edtAuto.getText().length() == 0)
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
                this$1 = _cls21.this;
                super(l);
            }
                });
                listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                    final _cls21 this$1;

                    public void onItemClick(AdapterView adapterview, View view, int i, long l)
                    {
                        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                        namaHp2 = listAdapter.getListModel(i).getNamalengkap().toString();
                        ucodename2 = listAdapter.getListModel(i).getCodename().toString();
                        Log.e("namahp", namaHp2);
                        btnHpDigunakan2Profile.setText(namaHp2);
                        hpPengguna2Profile = namaHp2;
                        img_hp2Remove.setBackgroundResource(0x7f0201ec);
                        dialog.dismiss();
                    }

            
            {
                this$1 = _cls21.this;
                super();
            }
                });
                btnSubmitHp.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls21 this$1;

                    public void onClick(View view)
                    {
                        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                        hpPengguna2Profile = edtHpKetik.getText().toString();
                        btnHpDigunakan2Profile.setText(hpPengguna2Profile);
                        dialog.dismiss();
                    }

            
            {
                this$1 = _cls21.this;
                super();
            }
                });
                dialog = builder1.create();
                dialog.show();
            }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        rdJekelProfile.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            final ProfileActivity this$0;

            public void onCheckedChanged(RadioGroup radiogroup, int k)
            {
                if (rbPriaProfile.isChecked())
                {
                    user_jekel_cb = "1";
                    return;
                } else
                {
                    user_jekel_cb = "2";
                    return;
                }
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnTTLProfile.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                c = Calendar.getInstance();
                year = c.get(1);
                month = c.get(2);
                day = c.get(5);
                showDialog(999);
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        btnSimpanPassword.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                if (!edtrePassProfileBaru.getText().toString().equals(edtPassProfileBaru.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Password baru tidak cocok", 1).show();
                    edtPassProfileBaru.startAnimation(animation);
                    edtrePassProfileBaru.startAnimation(animation);
                    return;
                }
                try
                {
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new PassTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new PassTask()).execute(new Void[0]);
                return;
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        dialog = new ArrayAdapter(this, 0x1090011, new String[] {
            "Dari Kamera", "Dari Galeri"
        });
        builder = new android.app.AlertDialog.Builder(wrapper);
        builder.setTitle("Pilih gambar");
        builder.setAdapter(dialog, new android.content.DialogInterface.OnClickListener() {

            final ProfileActivity this$0;

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
                this$0 = ProfileActivity.this;
                super();
            }
        });
        dialog = builder.create();
        mImageView = (ImageView)findViewById(0x7f0b034f);
        btnprof_savepic = (Button)findViewById(0x7f0b0350);
        btnprof_savepic.setVisibility(8);
        btnprof_savepic.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;

            public void onClick(View view)
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new UploadImage()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new URL[0]);
                    return;
                } else
                {
                    (new UploadImage()).execute(new URL[0]);
                    return;
                }
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        mImageView.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileActivity this$0;
            private final AlertDialog val$dialog;

            public void onClick(View view)
            {
                dialog.show();
            }

            
            {
                this$0 = ProfileActivity.this;
                dialog = alertdialog;
                super();
            }
        });
        imageLoader2.displayImage(user_photo.trim(), mImageView, options, new ImageLoadingListener() {

            final ProfileActivity this$0;

            public void onLoadingCancelled(String s, View view)
            {
            }

            public void onLoadingComplete(String s, View view, Bitmap bitmap)
            {
                progressbar_item.setVisibility(8);
                mImageView.setVisibility(0);
            }

            public void onLoadingFailed(String s, View view, FailReason failreason)
            {
                progressbar_item.setVisibility(8);
                mImageView.setVisibility(0);
                mImageView.setImageResource(0x7f020297);
            }

            public void onLoadingStarted(String s, View view)
            {
                user_photo = user_photo.replaceAll("%0A", "");
                Log.e("repl", user_photo);
                progressbar_item.setVisibility(0);
                mImageView.setVisibility(8);
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
        mImageView.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final ProfileActivity this$0;

            public boolean onLongClick(View view)
            {
                view = new ArrayList();
                view.add(user_photo.trim());
                view = (String[])view.toArray(new String[view.size()]);
                Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view);
                intent.putExtra("pos", 0);
                startActivity(intent);
                return false;
            }

            
            {
                this$0 = ProfileActivity.this;
                super();
            }
        });
    }

    protected Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 999: 
            return new DatePickerDialog(wrapper, datePickerListener, year, month, day);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0002, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        switch (i)
        {
        default:
            return super.onKeyDown(i, keyevent);

        case 82: // 'R'
            break;
        }
        if (mDrawerLayout.isDrawerOpen(0x800003))
        {
            mDrawerLayout.closeDrawers();
        } else
        {
            mDrawerLayout.openDrawer(0x800003);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            mDrawerToggle.onOptionsItemSelected(menuitem);
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }

    public void rotateView(View view)
    {
        RotateAnimation rotateanimation = new RotateAnimation(-90F, 0.0F, view.getWidth() / 2, view.getWidth() / 2);
        rotateanimation.setDuration(500L);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), 0x7f020277);
        Matrix matrix1 = new Matrix();
        matrix1.postRotate(90F);
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix1, true);
        ((ImageView)view).setImageBitmap(bitmap);
        view.startAnimation(rotateanimation);
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
