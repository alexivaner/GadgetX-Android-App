// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.astuetz.PagerSlidingTabStrip;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.HomeNewMainActivity;
import java.net.URLDecoder;
import java.util.List;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            RSSKomenAdapter

public class RSSKomenTab extends SherlockFragmentActivity
{

    public static Uri dataurlemail;
    public static ViewPager mViewPager;
    String Hal1RSSDetail;
    String Hal2RSSKomen;
    Account accounts[];
    String act;
    ActionBar actionBar;
    int actionBarTitleId;
    private RSSKomenAdapter adapter;
    String dataRefresh;
    int decimalPlace;
    String details;
    Bundle extras;
    String fav_stat;
    String host;
    String id_rss;
    MenuItem itemBookmark;
    String kategori_tag;
    LayoutInflater layoutInflater;
    String like_stat;
    RSSKomenAdapter mAdapter;
    ProgressDialog mDialog;
    ImageView menuSearch;
    String notif;
    int pageSelected;
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

    public RSSKomenTab()
    {
        t = Utility.session(RestClient.pelihara);
        profil = "";
        decimalPlace = 2;
        pageSelected = 0;
        act = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        scheme = "";
        host = "";
        details = "";
        notif = "000";
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
        extras = getIntent().getExtras();
        dataurlemail = getIntent().getData();
        ActionBar actionbar;
        StringBuilder stringbuilder;
        int i;
        int j;
        if (!String.valueOf(dataurlemail).equals("null"))
        {
            scheme = dataurlemail.getScheme();
            host = dataurlemail.getHost();
            id_rss = (String)dataurlemail.getPathSegments().get(1);
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
            Log.e("id_rss", id_rss);
            Log.e("rss_title", rss_title);
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
            bundle.setScreenName((new StringBuilder("Komentar Berita ")).append(extras.getString("kategori_tag")).toString());
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
        adapter = new RSSKomenAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        i = (int)TypedValue.applyDimension(1, 3F, getResources().getDisplayMetrics());
        mViewPager.setPageMargin(i);
        mViewPager.setOffscreenPageLimit(5);
        tabs.setViewPager(mViewPager);
        t = Utility.session(t);
        accounts = AccountManager.get(this).getAccounts();
        getSherlock().setProgressBarIndeterminateVisibility(false);
        getSherlock().setProgressBarVisibility(false);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
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
        actionbar = getSupportActionBar();
        stringbuilder = new StringBuilder("<font color='#FFFFFF'>");
        if (extras.getString("kategori_tag") == null || extras.getString("kategori_tag").equals(""))
        {
            bundle = "Komentar Berita";
        } else
        {
            bundle = (new StringBuilder("Komentar Berita \273 ")).append(extras.getString("kategori_tag")).toString();
        }
        actionbar.setTitle(Html.fromHtml(stringbuilder.append(URLDecoder.decode(bundle)).append("</font>").toString()));
        t = Utility.session(t);
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
