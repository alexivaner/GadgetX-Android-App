// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.util.DisplayMetrics;
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
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.Utility;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Observer;

// Referenced classes of package com.inponsel.android.daftarharga:
//            BaseDaftarActivity, TestFragmentAdapter

public class DaftarHargaPonsel extends BaseDaftarActivity
    implements android.view.View.OnClickListener, Observer
{

    Account accounts[];
    Button btnHASIL;
    Button btnPENCARIAN;
    Cursor cursor;
    String dataRefresh;
    Uri dataUrl;
    int decimalPlace;
    String details;
    DecimalFormat fmt;
    DecimalFormatSymbols fmts;
    String host;
    LayoutInflater layoutInflater;
    ProgressDialog mDialog;
    ImageView menuSearch;
    int pageSelected;
    PonselBaseApp ponselBaseApp;
    String profil;
    String res;
    String scheme;
    String status;
    String t;

    public DaftarHargaPonsel()
    {
        t = Utility.session(RestClient.pelihara);
        profil = "";
        decimalPlace = 2;
        pageSelected = 0;
        scheme = "";
        host = "";
        details = "";
    }

    protected int dpToPx(int i)
    {
        return (int)(getResources().getDisplayMetrics().density * (float)i + 0.5F);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030149, null, false);
        mDrawerLayout.addView(bundle, 0);
        btnPENCARIAN = (Button)findViewById(0x7f0b0918);
        btnHASIL = (Button)findViewById(0x7f0b0919);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        t = Utility.session(RestClient.pelihara);
        dataUrl = getIntent().getData();
        Log.e("dataurl", String.valueOf(dataUrl));
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
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Panduan Belanja</font>"));
        int j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText("Daftar Harga");
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        mAdapter = new TestFragmentAdapter(getSupportFragmentManager());
        t = Utility.session(RestClient.pelihara);
        mPager = (ViewPager)findViewById(0x7f0b0059);
        mPager.setOffscreenPageLimit(2);
        mPager.setCurrentItem(0);
        mPager.setAdapter(mAdapter);
        mIndicator = (PagerSlidingTabStrip)findViewById(0x7f0b02d6);
        mIndicator.setBackgroundColor(getResources().getColor(0x7f080160));
        mIndicator.setViewPager(mPager);
        btnPENCARIAN.setOnClickListener(new android.view.View.OnClickListener() {

            final DaftarHargaPonsel this$0;

            public void onClick(View view)
            {
                DaftarHargaPonsel.mPager.setCurrentItem(0, true);
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
                this$0 = DaftarHargaPonsel.this;
                super();
            }
        });
        btnHASIL.setOnClickListener(new android.view.View.OnClickListener() {

            final DaftarHargaPonsel this$0;

            public void onClick(View view)
            {
                DaftarHargaPonsel.mPager.setCurrentItem(1, true);
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
                this$0 = DaftarHargaPonsel.this;
                super();
            }
        });
        mIndicator.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final DaftarHargaPonsel this$0;

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
                this$0 = DaftarHargaPonsel.this;
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
            mDrawerToggle.onOptionsItemSelected(menuitem);
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }
}
