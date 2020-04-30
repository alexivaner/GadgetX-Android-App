// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.astuetz.PagerSlidingTabStrip;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.HomeNewMainActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            TLKomenAdapter

public class TLKomenTab extends SherlockFragmentActivity
    implements Observer
{

    public static Uri dataurlemail;
    public static String email_user;
    public static ViewPager mViewPager;
    public static String nama_asli;
    public static String user_id;
    public static String user_jekel;
    public static String user_joindate;
    public static String user_kota;
    public static String user_photo = "";
    public static String user_ponsel1;
    public static String user_ponsel2;
    public static String user_profile_update;
    public static String user_provider1;
    public static String user_provider2;
    public static String user_provinsi;
    public static String user_ttl;
    public static String username = "";
    String Hal1TLDetail;
    String Hal2TLKomen;
    Account accounts[];
    String act;
    ActionBar actionBar;
    int actionBarTitleId;
    private TLKomenAdapter adapter;
    Cursor c;
    Cursor cursor;
    String dataRefresh;
    DatabaseHandler db;
    int decimalPlace;
    String details;
    Bundle extras;
    String host;
    Intent i;
    String id_rss;
    ImageLoader imageLoader2;
    MenuItem itemBookmark;
    LayoutInflater layoutInflater;
    ImageLoaderConfiguration loaderConfiguration;
    TLKomenAdapter mAdapter;
    ProgressDialog mDialog;
    ImageView menuSearch;
    ImageView menu_imgProfil;
    TextView menu_ponsel_pengguna;
    ProgressBar menu_progressbar_item;
    TextView menu_sim_pengguna;
    TextView menu_username;
    String namalengkap;
    String notif;
    int pageSelected;
    PonselBaseApp ponselBaseApp;
    String profil;
    String pushURL;
    String query;
    String res;
    String rss_title;
    String scheme;
    String stat;
    String status;
    String t;
    private PagerSlidingTabStrip tabs;
    String tl_judul;
    String tl_type;
    private boolean useLogo;
    UserFunctions userFunctions;

    public TLKomenTab()
    {
        t = Utility.session(RestClient.pelihara);
        profil = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        decimalPlace = 2;
        pageSelected = 0;
        act = "";
        scheme = "";
        host = "";
        details = "";
        notif = "000";
        tl_type = "";
        namalengkap = "";
        tl_judul = "";
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

    public String getHal1TLDetail()
    {
        return Hal1TLDetail;
    }

    public String getHal2TLKomen()
    {
        return Hal2TLKomen;
    }

    public void onBackPressed()
    {
        if (pageSelected != 0)
        {
            mViewPager.setCurrentItem(0, true);
            return;
        }
        if (notif.equals("gcm") || notif.equals("email"))
        {
            Log.e("finish", "1");
            Intent intent = new Intent(this, com/inponsel/android/v2/HomeNewMainActivity);
            intent.addFlags(32768);
            intent.addFlags(0x10000000);
            startActivity(intent);
            finish();
            overridePendingTransition(0x7f040001, 0x7f040002);
            return;
        } else
        {
            finish();
            overridePendingTransition(0x7f040001, 0x7f040002);
            Log.e("finish", "2");
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03008e);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        extras = getIntent().getExtras();
        dataurlemail = getIntent().getData();
        int j;
        int l;
        if (!String.valueOf(dataurlemail).equals("null"))
        {
            scheme = dataurlemail.getScheme();
            host = dataurlemail.getHost();
            id_rss = (String)dataurlemail.getPathSegments().get(0);
            rss_title = "";
            notif = "email";
            act = "firsttab";
            Log.e("scheme", scheme);
            Log.e("host", host);
        } else
        {
            if (extras.getString("notif") == null)
            {
                notif = "000";
            } else
            {
                notif = "gcm";
            }
            id_rss = extras.getString("id_rss");
            namalengkap = extras.getString("namalengkap");
            tl_judul = extras.getString("tl_judul");
        }
        tl_type = extras.getString("tl_type");
        if (tl_type.equals("conversation"))
        {
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                setTranslucentStatus(true);
            }
            bundle = new SystemBarTintManager(this);
            bundle.setStatusBarTintEnabled(true);
            bundle.setStatusBarTintResource(0x7f08018a);
        } else
        {
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                setTranslucentStatus(true);
            }
            bundle = new SystemBarTintManager(this);
            bundle.setStatusBarTintEnabled(true);
            bundle.setStatusBarTintResource(0x7f080173);
        }
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName((new StringBuilder("Forum ")).append(tl_judul).toString());
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        tabs = (PagerSlidingTabStrip)findViewById(0x7f0b04c9);
        tabs.setVisibility(8);
        mViewPager = (ViewPager)findViewById(0x7f0b0059);
        adapter = new TLKomenAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        j = (int)TypedValue.applyDimension(1, 3F, getResources().getDisplayMetrics());
        mViewPager.setPageMargin(j);
        mViewPager.setOffscreenPageLimit(5);
        if (!String.valueOf(dataurlemail).equals("null"))
        {
            mViewPager.setCurrentItem(0);
        } else
        {
            bundle = mViewPager;
            int k;
            if (!extras.getString("act").equals("komen"))
            {
                k = 0;
            } else
            {
                k = 1;
            }
            bundle.setCurrentItem(k);
        }
        if (tl_judul == null)
        {
            tl_judul = "";
        }
        tabs.setViewPager(mViewPager);
        t = Utility.session(t);
        accounts = AccountManager.get(this).getAccounts();
        getSherlock().setProgressBarIndeterminateVisibility(false);
        getSherlock().setProgressBarVisibility(false);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayUseLogoEnabled(useLogo);
        if (tl_type.equals("conversation"))
        {
            actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e8));
        } else
        {
            actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e7));
        }
        l = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        j = l;
        if (l == 0)
        {
            j = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(j);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        if (tl_type.equals("conversation"))
        {
            getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>Topik ")).append(tl_judul).append("</font>").toString()));
        } else
        {
            getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>Forum ")).append(tl_judul).append("</font>").toString()));
        }
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(this));
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
        tabs.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final TLKomenTab this$0;

            public void onPageScrollStateChanged(int i1)
            {
            }

            public void onPageScrolled(int i1, float f, int j1)
            {
            }

            public void onPageSelected(int i1)
            {
                Log.e("onPageSelected", String.valueOf(i1));
                pageSelected = i1;
            }

            
            {
                this$0 = TLKomenTab.this;
                super();
            }
        });
    }

    public void setHal1TLDetail(String s)
    {
        Hal1TLDetail = s;
    }

    public void setHal2TLKomen(String s)
    {
        Hal2TLKomen = s;
    }

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getLoginStat().equals("1"))
        {
            runOnUiThread(new Runnable() {

                final TLKomenTab this$0;

                public void run()
                {
                    if (userFunctions.isUserLoggedIn(getApplicationContext()))
                    {
                        cursor = db.getAllData();
                        cursor.moveToFirst();
                        try
                        {
                            TLKomenTab.user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
                        }
                        catch (Exception exception) { }
                        TLKomenTab.nama_asli = cursor.getString(2);
                        TLKomenTab.user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
                        TLKomenTab.username = cursor.getString(4);
                        TLKomenTab.email_user = cursor.getString(5);
                        TLKomenTab.user_ttl = cursor.getString(6);
                        TLKomenTab.user_provinsi = cursor.getString(7);
                        TLKomenTab.user_kota = cursor.getString(8);
                        TLKomenTab.user_jekel = cursor.getString(9);
                        TLKomenTab.user_ponsel1 = cursor.getString(10);
                        TLKomenTab.user_ponsel2 = cursor.getString(11);
                        TLKomenTab.user_provider1 = cursor.getString(12);
                        TLKomenTab.user_provider2 = cursor.getString(13);
                        TLKomenTab.user_joindate = cursor.getString(14);
                        TLKomenTab.user_profile_update = cursor.getString(15);
                    }
                }

            
            {
                this$0 = TLKomenTab.this;
                super();
            }
            });
        }
    }

}
