// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.statistik;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.utils.YourFragmentInterface;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TitlePageIndicator;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Observer;

// Referenced classes of package com.inponsel.android.statistik:
//            BaseStatistikActivity, TestFragmentAdapter

public class StatistikPonsel extends BaseStatistikActivity
    implements android.view.View.OnClickListener, Observer
{

    Account accounts[];
    String dataRefresh;
    int decimalPlace;
    Bundle extras;
    DecimalFormat fmt;
    DecimalFormatSymbols fmts;
    LayoutInflater layoutInflater;
    ProgressDialog mDialog;
    int pageSelected;
    String pager_pos;
    PonselBaseApp ponselBaseApp;
    String profil;
    String res;
    boolean start2;
    boolean start3;
    boolean start4;
    String status;
    String t;

    public StatistikPonsel()
    {
        t = Utility.session(RestClient.pelihara);
        profil = "";
        decimalPlace = 2;
        pager_pos = "0";
        pageSelected = 0;
        start2 = false;
        start3 = false;
        start4 = false;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03008d, null, false);
        mDrawerLayout.addView(bundle, 0);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        t = Utility.session(RestClient.pelihara);
        fmt = new DecimalFormat();
        fmts = new DecimalFormatSymbols();
        fmts.setGroupingSeparator('.');
        fmt.setGroupingSize(3);
        fmt.setGroupingUsed(true);
        fmt.setDecimalFormatSymbols(fmts);
        accounts = AccountManager.get(this).getAccounts();
        getSherlock().setProgressBarIndeterminateVisibility(false);
        getSherlock().setProgressBarVisibility(false);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Statistik</font>"));
        int j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText("Statistik");
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        mAdapter = new TestFragmentAdapter(getSupportFragmentManager());
        extras = getIntent().getExtras();
        pager_pos = extras.getString("pager_pos");
        t = Utility.session(RestClient.pelihara);
        mPager = (ViewPager)findViewById(0x7f0b0059);
        i = (int)TypedValue.applyDimension(1, 3F, getResources().getDisplayMetrics());
        mPager.setPageMargin(i);
        mPager.setOffscreenPageLimit(5);
        mPager.setAdapter(mAdapter);
        mIndicator = (TitlePageIndicator)findViewById(0x7f0b02d6);
        mIndicator.setViewPager(mPager);
        mIndicator.setCurrentItem(Integer.parseInt(pager_pos));
        mIndicator.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final StatistikPonsel this$0;

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
                YourFragmentInterface yourfragmentinterface = (YourFragmentInterface)mAdapter.instantiateItem(mPager, k);
                if (yourfragmentinterface != null)
                {
                    yourfragmentinterface.fragmentBecameVisible();
                }
            }

            
            {
                this$0 = StatistikPonsel.this;
                super();
            }
        });
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
}
