// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.scdetail;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.astuetz.PagerSlidingTabStrip;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.Utility;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.inponsel.android.scdetail:
//            SCFragmentAdapter

public class SCDetailPager extends SherlockFragmentActivity
{

    public static ViewPager mViewPager;
    public static PagerSlidingTabStrip tabs;
    String Hal1SCPref;
    String Hal2SCHasil;
    Account accounts[];
    ActionBar actionBar;
    int actionBarTitleId;
    private SCFragmentAdapter adapter;
    Button btnHASIL;
    Button btnPENCARIAN;
    LinearLayout custom_pager;
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
    private boolean useLogo;

    public SCDetailPager()
    {
        t = Utility.session(RestClient.pelihara);
        profil = "";
        decimalPlace = 2;
        pageSelected = 0;
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
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

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        Iterator iterator = getSupportFragmentManager().getFragments().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            ((Fragment)iterator.next()).onActivityResult(i, j, intent);
        } while (true);
    }

    public void onBackPressed()
    {
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
        setContentView(0x7f030149);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        btnPENCARIAN = (Button)findViewById(0x7f0b0918);
        btnHASIL = (Button)findViewById(0x7f0b0919);
        btnPENCARIAN.setText("PROFIL");
        btnHASIL.setText("KOMENTAR");
        custom_pager = (LinearLayout)findViewById(0x7f0b0917);
        tabs = (PagerSlidingTabStrip)findViewById(0x7f0b02d6);
        custom_pager.setVisibility(8);
        tabs.setVisibility(8);
        mViewPager = (ViewPager)findViewById(0x7f0b0059);
        adapter = new SCFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        int i = (int)TypedValue.applyDimension(1, 3F, getResources().getDisplayMetrics());
        mViewPager.setPageMargin(i);
        mViewPager.setOffscreenPageLimit(5);
        tabs.setViewPager(mViewPager);
        t = Utility.session(t);
        accounts = AccountManager.get(this).getAccounts();
        getSherlock().setProgressBarIndeterminateVisibility(false);
        getSherlock().setProgressBarVisibility(false);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        int j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
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

            final SCDetailPager this$0;

            public void onClick(View view)
            {
                SCDetailPager.mViewPager.setCurrentItem(0, true);
                btnPENCARIAN.setBackgroundResource(0x7f020145);
                btnHASIL.setBackgroundResource(0x7f02013f);
                btnPENCARIAN.setTextColor(getResources().getColor(0x7f080160));
                btnHASIL.setTextColor(getResources().getColor(0x7f080182));
            }

            
            {
                this$0 = SCDetailPager.this;
                super();
            }
        });
        btnHASIL.setOnClickListener(new android.view.View.OnClickListener() {

            final SCDetailPager this$0;

            public void onClick(View view)
            {
                SCDetailPager.mViewPager.setCurrentItem(1, true);
                btnPENCARIAN.setBackgroundResource(0x7f02013f);
                btnHASIL.setBackgroundResource(0x7f020145);
                btnPENCARIAN.setTextColor(getResources().getColor(0x7f080182));
                btnHASIL.setTextColor(getResources().getColor(0x7f080160));
            }

            
            {
                this$0 = SCDetailPager.this;
                super();
            }
        });
        tabs.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final SCDetailPager this$0;

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
                if (k == 0)
                {
                    btnPENCARIAN.setBackgroundResource(0x7f020145);
                    btnHASIL.setBackgroundResource(0x7f02013f);
                    btnPENCARIAN.setTextColor(getResources().getColor(0x7f080160));
                    btnHASIL.setTextColor(getResources().getColor(0x7f080182));
                } else
                if (k == 1)
                {
                    btnPENCARIAN.setBackgroundResource(0x7f02013f);
                    btnHASIL.setBackgroundResource(0x7f020145);
                    btnPENCARIAN.setTextColor(getResources().getColor(0x7f080182));
                    btnHASIL.setTextColor(getResources().getColor(0x7f080160));
                    return;
                }
            }

            
            {
                this$0 = SCDetailPager.this;
                super();
            }
        });
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
