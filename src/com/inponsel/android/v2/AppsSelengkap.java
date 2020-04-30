// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.adapter.ListAppsHorizontalAdapter;
import com.inponsel.android.adapter.ListKategoriAppsAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.util.ArrayList;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            AppsByCategory

public class AppsSelengkap extends SherlockFragmentActivity
{

    ActionBar actionBar;
    int actionBarTitleId;
    ArrayList arrayListCategoryApps;
    ArrayList arrayListKatApps;
    ConnectivityManager cm;
    Cursor cursor;
    DatabaseHandler db;
    String email_user;
    Bundle extras;
    ImageView img_week_apps;
    InputMethodManager imm;
    ExpandableHeightGridView listApps;
    ListAppsHorizontalAdapter listAppsCateforyAdapter;
    ListKategoriAppsAdapter listKatAppsAdapter;
    ExpandableHeightGridView listKategoriApps;
    String nama_asli;
    PonselBaseApp ponselBaseApp;
    String str_category;
    String str_title_cat;
    ScrollView sv_root;
    String t;
    TextView txt_title_category;
    String url_bydat;
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
    String username;
    ContextThemeWrapper wrapperLight;

    public AppsSelengkap()
    {
        str_category = "";
        str_title_cat = "";
        url_bydat = "";
        arrayListCategoryApps = null;
        arrayListKatApps = null;
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
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

    public void onBackPressed()
    {
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03012b);
        listApps = (ExpandableHeightGridView)findViewById(0x7f0b086a);
        listKategoriApps = (ExpandableHeightGridView)findViewById(0x7f0b086c);
        img_week_apps = (ImageView)findViewById(0x7f0b086d);
        txt_title_category = (TextView)findViewById(0x7f0b086e);
        sv_root = (ScrollView)findViewById(0x7f0b085d);
        extras = getIntent().getExtras();
        str_category = extras.getString("category");
        str_title_cat = extras.getString("title");
        txt_title_category.setText(str_title_cat);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        Log.e("str_category", str_category);
        if (str_category.contains("game"))
        {
            bundle.setStatusBarTintResource(0x7f0800ab);
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7b1fa2")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Games</font>"));
        } else
        {
            bundle.setStatusBarTintResource(0x7f08011c);
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#689f38")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Aplikasi</font>"));
        }
        Log.e("str_category", str_category);
        if (str_category.contains("game"))
        {
            bundle.setStatusBarTintResource(0x7f0800ab);
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7b1fa2")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Games</font>"));
        } else
        {
            bundle.setStatusBarTintResource(0x7f08011c);
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#689f38")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Aplikasi</font>"));
        }
        t = Utility.session(t);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        imm = (InputMethodManager)getSystemService("input_method");
        cm = (ConnectivityManager)getSystemService("connectivity");
        t = Utility.session(t);
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
            cursor.close();
        }
        listApps.setExpanded(true);
        arrayListCategoryApps = new ArrayList();
        listAppsCateforyAdapter = new ListAppsHorizontalAdapter(this, 0x7f030138, arrayListCategoryApps);
        listApps.setAdapter(listAppsCateforyAdapter);
        arrayListKatApps = new ArrayList();
        listKatAppsAdapter = new ListKategoriAppsAdapter(this, 0x7f030139, arrayListKatApps);
        listKategoriApps.setAdapter(listKatAppsAdapter);
        listKategoriApps.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppsSelengkap this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/AppsByCategory);
                adapterview.putExtra("id", listKatAppsAdapter.getListModel(i).getId_apps());
                adapterview.putExtra("kategori", listKatAppsAdapter.getListModel(i).getKat_apps_name());
                adapterview.putExtra("tag", listKatAppsAdapter.getListModel(i).getKat_apps_tag());
                adapterview.putExtra("deskripsi", listKatAppsAdapter.getListModel(i).getKat_apps_desc());
                adapterview.putExtra("mod_date", listKatAppsAdapter.getListModel(i).getKat_apps_date());
                adapterview.putExtra("background", listKatAppsAdapter.getListModel(i).getKat_apps_background());
                adapterview.putExtra("background_img", listKatAppsAdapter.getListModel(i).getKat_apps_background_img());
                adapterview.putExtra("height", listKatAppsAdapter.getListModel(i).getKat_img_height());
                adapterview.putExtra("mystat", listKatAppsAdapter.getListModel(i).getKat_img_width());
                adapterview.putExtra("myfav", listKatAppsAdapter.getListModel(i).getKat_fav_status());
                adapterview.putExtra("width_img", listKatAppsAdapter.getListModel(i).getKat_img_width());
                adapterview.putExtra("height_img", listKatAppsAdapter.getListModel(i).getKat_img_height());
                adapterview.putExtra("type", listKatAppsAdapter.getListModel(i).getKat_type());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = AppsSelengkap.this;
                super();
            }
        });
        bundle = new AsyncHttpClient();
        url_bydat = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("apps_byday").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&key=").append(str_category).toString();
        Log.e("url_bydat", url_bydat);
        bundle.get(url_bydat, new AsyncHttpResponseHandler() {

            final AppsSelengkap this$0;

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
                aheader = new String(abyte0);
                Log.e("respJson", aheader);
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                i = 0;
_L5:
                int j = aheader.length();
                if (i < j) goto _L2; else goto _L1
_L1:
                listAppsCateforyAdapter.notifyDataSetChanged();
                return;
_L2:
                Log.e("iLength", String.valueOf(i));
                abyte0 = aheader.getJSONObject(i);
                if (abyte0.getString("app_rate") == null)
                {
                    break; /* Loop/switch isn't completed */
                }
                try
                {
                    ListModel listmodel = new ListModel();
                    listmodel.setApppackage(abyte0.getString("app_package"));
                    listmodel.setAppname(abyte0.getString("app_name"));
                    listmodel.setAppcover(abyte0.getString("icon_image"));
                    listmodel.setCategory(abyte0.getString("kategori"));
                    listmodel.setAvgrate(abyte0.getString("app_rate"));
                    listmodel.setBanner_image(abyte0.getString("banner_image"));
                    listmodel.setAppsize(abyte0.getString("app_size"));
                    listmodel.setDownloadcount(abyte0.getString("app_download"));
                    listmodel.setAppurl(abyte0.getString("app_url"));
                    arrayListCategoryApps.add(listmodel);
                    break; /* Loop/switch isn't completed */
                }
                // Misplaced declaration of an exception variable
                catch (Header aheader[]) { }
                if (true) goto _L1; else goto _L3
_L3:
                i++;
                if (true) goto _L5; else goto _L4
_L4:
            }

            
            {
                this$0 = AppsSelengkap.this;
                super();
            }
        });
        (new AsyncHttpClient()).get((new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("list_kategori_apps2").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&key=").append(str_category).toString(), new AsyncHttpResponseHandler() {

            final AppsSelengkap this$0;

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
                aheader = new String(abyte0);
                Log.e("respJson", aheader);
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                i = 0;
_L3:
                int j = aheader.length();
                if (i < j) goto _L2; else goto _L1
_L1:
                listKatAppsAdapter.notifyDataSetChanged();
                sv_root.scrollTo(0, 0);
                return;
_L2:
                abyte0 = aheader.getJSONObject(i);
                ListModel listmodel = new ListModel();
                Log.e("kategori_random", abyte0.getString("background_img"));
                listmodel.setId_apps(abyte0.getString("id"));
                listmodel.setKat_apps_name(abyte0.getString("kategori"));
                listmodel.setKat_apps_desc(abyte0.getString("deskripsi"));
                listmodel.setKat_img_height(abyte0.getString("height"));
                listmodel.setKat_apps_background(abyte0.getString("background"));
                listmodel.setKat_apps_background_img(abyte0.getString("background_img"));
                listmodel.setKat_like_status(abyte0.getString("mystat"));
                listmodel.setKat_fav_status(abyte0.getString("myfav"));
                listmodel.setKat_type(abyte0.getString("type"));
                listmodel.setKat_apps_tag(abyte0.getString("tag"));
                listmodel.setKat_apps_date("mod_date");
                listmodel.setKat_img_width(abyte0.getString("width"));
                listmodel.setKat_img_height(abyte0.getString("height"));
                listmodel.setRatio_h(abyte0.getString("ratioH"));
                listmodel.setRatio_w(abyte0.getString("ratioW"));
                arrayListKatApps.add(listmodel);
                i++;
                  goto _L3
                aheader;
                  goto _L1
            }

            
            {
                this$0 = AppsSelengkap.this;
                super();
            }
        });
        listApps.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppsSelengkap this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(listAppsCateforyAdapter.getListModel(i).getAppurl())));
            }

            
            {
                this$0 = AppsSelengkap.this;
                super();
            }
        });
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
            onBackPressed();
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }
}
