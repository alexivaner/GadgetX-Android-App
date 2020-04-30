// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.astuetz.PagerSlidingTabStrip;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.HomeNewMainActivity;
import com.inponsel.android.widget.DroidWriterEditText;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.net.URLDecoder;
import java.util.List;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            RSSFragmentAdapter

public class RSSDetailTab extends SherlockFragmentActivity
{

    public static Uri dataurlemail;
    public static ViewPager mViewPager;
    String Hal1RSSDetail;
    String Hal2RSSKomen;
    Account accounts[];
    String act;
    ActionBar actionBar;
    int actionBarTitleId;
    private RSSFragmentAdapter adapter;
    Button btn_pop_login;
    Button btn_send_komen;
    Cursor cursor;
    String dataRefresh;
    DatabaseHandler db;
    int decimalPlace;
    String details;
    DroidWriterEditText edt_pop_komen;
    String email_user;
    Bundle extras;
    String fav_stat;
    String host;
    String id_rss;
    String kategori_tag;
    RelativeLayout lay_pop_komen;
    LayoutInflater layoutInflater;
    String like_stat;
    RSSFragmentAdapter mAdapter;
    ProgressDialog mDialog;
    ImageView menuSearch;
    String nama_asli;
    String notif;
    int pageSelected;
    TextView pop_txtCountKomen;
    String profil;
    String pushURL;
    String query;
    String res;
    String rss_content;
    String rss_date;
    String rss_desc;
    String rss_id;
    String rss_img;
    String rss_img_ava;
    String rss_portal;
    String rss_srclink;
    String rss_title;
    String scheme;
    String stat;
    String status;
    String t;
    private PagerSlidingTabStrip tabs;
    String total_komen;
    String total_like;
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

    public RSSDetailTab()
    {
        t = Utility.session(RestClient.pelihara);
        profil = "";
        decimalPlace = 2;
        pageSelected = 0;
        act = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        user_photo = "";
        username = "";
        scheme = "";
        host = "";
        details = "";
        notif = "000";
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

    public String getHal1RSSDetail()
    {
        return Hal1RSSDetail;
    }

    public String getHal2RSSKomen()
    {
        return Hal2RSSKomen;
    }

    public ViewPager getViewPager()
    {
        if (mViewPager == null)
        {
            mViewPager = (ViewPager)findViewById(0x7f0b0059);
        }
        return mViewPager;
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
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        extras = getIntent().getExtras();
        dataurlemail = getIntent().getData();
        if (!String.valueOf(dataurlemail).equals("null"))
        {
            scheme = dataurlemail.getScheme();
            host = dataurlemail.getHost();
            bundle = dataurlemail.getPathSegments();
            id_rss = (String)bundle.get(1);
            int i;
            int j;
            if (((String)bundle.get(1)).equals("d"))
            {
                id_rss = (String)bundle.get(2);
            } else
            {
                id_rss = (String)bundle.get(1);
            }
            rss_title = "";
            notif = "email";
            rss_id = "";
            rss_portal = "";
            rss_desc = "";
            rss_srclink = "";
            rss_date = "";
            rss_img_ava = "";
            rss_img = "";
            total_like = "";
            like_stat = "";
            total_komen = "";
            fav_stat = "";
            kategori_tag = "";
            act = "firsttab";
            Log.e("scheme", scheme);
            Log.e("host", host);
            Log.e("id_rssget", id_rss);
            Log.e("rss_title", rss_title);
        } else
        if (notif.equals("gcm"))
        {
            id_rss = extras.getString("id_rss");
            rss_title = extras.getString("rss_title");
        } else
        {
            id_rss = extras.getString("id_rss");
            rss_id = extras.getString("rss_id");
            rss_title = extras.getString("rss_title");
            rss_portal = extras.getString("rss_portal");
            rss_desc = extras.getString("rss_desc");
            rss_srclink = extras.getString("rss_srclink");
            rss_date = extras.getString("rss_date");
            rss_img_ava = extras.getString("rss_img_ava");
            rss_img = extras.getString("rss_img");
            total_like = extras.getString("total_like");
            like_stat = extras.getString("like_stat");
            total_komen = extras.getString("total_komen");
            fav_stat = extras.getString("fav_stat");
            kategori_tag = extras.getString("kategori_tag");
        }
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName((new StringBuilder("Berita ")).append(extras.getString("kategori_tag")).toString());
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
        adapter = new RSSFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        i = (int)TypedValue.applyDimension(1, 3F, getResources().getDisplayMetrics());
        mViewPager.setPageMargin(i);
        mViewPager.setOffscreenPageLimit(5);
        if (!String.valueOf(dataurlemail).equals("null"))
        {
            mViewPager.setCurrentItem(0);
        } else
        {
            mViewPager.setCurrentItem(0);
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
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
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
        if (!String.valueOf(dataurlemail).equals("null"))
        {
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Berita</font>"));
        } else
        {
            ActionBar actionbar = getSupportActionBar();
            StringBuilder stringbuilder = new StringBuilder("<font color='#FFFFFF'>");
            if (extras.getString("kategori_tag") == null || extras.getString("kategori_tag").equals(""))
            {
                bundle = "Berita";
            } else
            {
                bundle = (new StringBuilder("Berita \273 ")).append(extras.getString("kategori_tag")).toString();
            }
            actionbar.setTitle(Html.fromHtml(stringbuilder.append(URLDecoder.decode(bundle)).append("</font>").toString()));
        }
        t = Utility.session(t);
        tabs.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final RSSDetailTab this$0;

            public void onPageScrollStateChanged(int k)
            {
            }

            public void onPageScrolled(int k, float f, int l)
            {
            }

            public void onPageSelected(int k)
            {
                Log.e("onPageSelected", String.valueOf(k));
                pageSelected = k;
            }

            
            {
                this$0 = RSSDetailTab.this;
                super();
            }
        });
    }

    public void setHal1RSSDetail(String s)
    {
        Hal1RSSDetail = s;
    }

    public void setHal2RSSKomen(String s)
    {
        Hal2RSSKomen = s;
    }
}
