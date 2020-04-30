// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.servicenter;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.astuetz.PagerSlidingTabStrip;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.BaseDrawer;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import java.util.Observer;

// Referenced classes of package com.inponsel.android.servicenter:
//            SCFragmentAdapter

public class SCPencarian extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{

    public static ViewPager mViewPager;
    String Hal1SCPref;
    String Hal2SCHasil;
    Account accounts[];
    private SCFragmentAdapter adapter;
    Button btnHASIL;
    Button btnPENCARIAN;
    String dataRefresh;
    int decimalPlace;
    MenuItem itemBookmark;
    LayoutInflater layoutInflater;
    SCFragmentAdapter mAdapter;
    ProgressDialog mDialog;
    ImageView menuSearch;
    int pageSelected;
    PonselBaseApp ponselBaseApp;
    String profil;
    String pushURL;
    String query;
    String res;
    String stat;
    String status;
    String t;
    private PagerSlidingTabStrip tabs;

    public SCPencarian()
    {
        t = Utility.session(RestClient.pelihara);
        profil = "";
        decimalPlace = 2;
        pageSelected = 0;
    }

    public String getHal1SCPref()
    {
        return Hal1SCPref;
    }

    public String getHal2SCHasil()
    {
        return Hal2SCHasil;
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
        if (mDrawerLayout.isDrawerOpen(0x800003))
        {
            mDrawerLayout.closeDrawers();
            Log.e("vis", "on");
            return;
        }
        if (pageSelected != 0)
        {
            mViewPager.setCurrentItem(0, true);
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
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030149, null, false);
        mDrawerLayout.addView(bundle, 0);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("SC Manual");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        tabs = (PagerSlidingTabStrip)findViewById(0x7f0b02d6);
        btnPENCARIAN = (Button)findViewById(0x7f0b0918);
        btnHASIL = (Button)findViewById(0x7f0b0919);
        mViewPager = (ViewPager)findViewById(0x7f0b0059);
        adapter = new SCFragmentAdapter(getSupportFragmentManager());
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
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Service Center</font>"));
        t = Utility.session(t);
        btnPENCARIAN.setOnClickListener(new android.view.View.OnClickListener() {

            final SCPencarian this$0;

            public void onClick(View view)
            {
                SCPencarian.mViewPager.setCurrentItem(0, true);
                btnPENCARIAN.setBackgroundResource(0x7f020145);
                btnHASIL.setBackgroundResource(0x7f020135);
                btnPENCARIAN.setTextColor(getResources().getColor(0x7f080160));
                try
                {
                    view = getResources().getXml(0x7f080197);
                    view = ColorStateList.createFromXml(getResources(), view);
                    btnHASIL.setTextColor(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = SCPencarian.this;
                super();
            }
        });
        btnHASIL.setOnClickListener(new android.view.View.OnClickListener() {

            final SCPencarian this$0;

            public void onClick(View view)
            {
                SCPencarian.mViewPager.setCurrentItem(1, true);
                btnPENCARIAN.setBackgroundResource(0x7f020135);
                btnHASIL.setBackgroundResource(0x7f020145);
                btnHASIL.setTextColor(getResources().getColor(0x7f080160));
                try
                {
                    view = getResources().getXml(0x7f080197);
                    view = ColorStateList.createFromXml(getResources(), view);
                    btnPENCARIAN.setTextColor(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = SCPencarian.this;
                super();
            }
        });
        tabs.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final SCPencarian this$0;

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
                if (k != 0)
                {
                    break MISSING_BLOCK_LABEL_116;
                }
                btnPENCARIAN.setBackgroundResource(0x7f020145);
                btnHASIL.setBackgroundResource(0x7f020135);
                btnPENCARIAN.setTextColor(getResources().getColor(0x7f080160));
                btnHASIL.setTextColor(0x7f020333);
                Object obj = getResources().getXml(0x7f080197);
                obj = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj)));
                btnHASIL.setTextColor(((ColorStateList) (obj)));
_L1:
                return;
                if (k == 1)
                {
                    btnPENCARIAN.setBackgroundResource(0x7f020135);
                    btnHASIL.setBackgroundResource(0x7f020145);
                    try
                    {
                        Object obj1 = getResources().getXml(0x7f080197);
                        obj1 = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj1)));
                        btnPENCARIAN.setTextColor(((ColorStateList) (obj1)));
                    }
                    catch (Exception exception) { }
                    btnHASIL.setTextColor(getResources().getColor(0x7f080160));
                    return;
                }
                  goto _L1
                Exception exception1;
                exception1;
            }

            
            {
                this$0 = SCPencarian.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0014, menu);
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

        case 2131429694: 
            startActivityForResult(new Intent(this, com/inponsel/android/pencariangen/TabPencarian), 0);
            break;
        }
        overridePendingTransition(0x7f040003, 0x7f040004);
        return true;
    }

    public void setHal1SCPref(String s)
    {
        Hal1SCPref = s;
    }

    public void setHal2SCHasil(String s)
    {
        Hal2SCHasil = s;
    }
}
