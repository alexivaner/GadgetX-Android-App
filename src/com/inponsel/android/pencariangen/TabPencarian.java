// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.astuetz.PagerSlidingTabStrip;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.Utility;
import com.readystatesoftware.systembartint.SystemBarTintManager;

// Referenced classes of package com.inponsel.android.pencariangen:
//            PencFragmentAdapter

public class TabPencarian extends SherlockFragmentActivity
{

    String Hal1SCPref;
    String Hal2SCHasil;
    Account accounts[];
    ActionBar actionBar;
    int actionBarTitleId;
    private PencFragmentAdapter adapter;
    Button btnBERITA;
    Button btnPENGGUNA;
    Button btnPONSEL;
    Button btnSERVICECENTER;
    String dataRefresh;
    int decimalPlace;
    HorizontalScrollView hsv_viewpager;
    MenuItem itemBookmark;
    LayoutInflater layoutInflater;
    PencFragmentAdapter mAdapter;
    ProgressDialog mDialog;
    ViewPager mViewPager;
    ImageView menuSearch;
    int pageSelected;
    String profil;
    String pushURL;
    String query;
    String res;
    String stat;
    String status;
    String t;
    private PagerSlidingTabStrip tabs;
    private boolean useLogo;

    public TabPencarian()
    {
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        t = Utility.session(RestClient.pelihara);
        profil = "";
        decimalPlace = 2;
        pageSelected = 0;
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
        setContentView(0x7f03014c);
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
            bundle.setScreenName("Pencarian");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        btnPONSEL = (Button)findViewById(0x7f0b0921);
        btnSERVICECENTER = (Button)findViewById(0x7f0b0922);
        btnBERITA = (Button)findViewById(0x7f0b0923);
        btnPENGGUNA = (Button)findViewById(0x7f0b0924);
        tabs = (PagerSlidingTabStrip)findViewById(0x7f0b04c9);
        hsv_viewpager = (HorizontalScrollView)findViewById(0x7f0b091a);
        mViewPager = (ViewPager)findViewById(0x7f0b0059);
        adapter = new PencFragmentAdapter(getSupportFragmentManager());
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
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Pencarian</font>"));
        t = Utility.session(t);
        btnPONSEL.setOnClickListener(new android.view.View.OnClickListener() {

            final TabPencarian this$0;

            public void onClick(View view)
            {
                mViewPager.setCurrentItem(0, true);
                btnPONSEL.setBackgroundResource(0x7f020145);
                btnSERVICECENTER.setBackgroundResource(0x7f02013f);
                btnBERITA.setBackgroundResource(0x7f02013f);
                btnPENGGUNA.setBackgroundResource(0x7f02013f);
                btnPONSEL.setTextColor(getResources().getColor(0x7f080160));
                try
                {
                    view = getResources().getXml(0x7f080197);
                    view = ColorStateList.createFromXml(getResources(), view);
                    btnSERVICECENTER.setTextColor(view);
                    btnBERITA.setTextColor(view);
                    btnPENGGUNA.setTextColor(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = TabPencarian.this;
                super();
            }
        });
        btnSERVICECENTER.setOnClickListener(new android.view.View.OnClickListener() {

            final TabPencarian this$0;

            public void onClick(View view)
            {
                mViewPager.setCurrentItem(1, true);
                btnPONSEL.setBackgroundResource(0x7f02013f);
                btnSERVICECENTER.setBackgroundResource(0x7f020145);
                btnBERITA.setBackgroundResource(0x7f02013f);
                btnPENGGUNA.setBackgroundResource(0x7f02013f);
                btnSERVICECENTER.setTextColor(getResources().getColor(0x7f080160));
                try
                {
                    view = getResources().getXml(0x7f080197);
                    view = ColorStateList.createFromXml(getResources(), view);
                    btnPONSEL.setTextColor(view);
                    btnBERITA.setTextColor(view);
                    btnPENGGUNA.setTextColor(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = TabPencarian.this;
                super();
            }
        });
        btnBERITA.setOnClickListener(new android.view.View.OnClickListener() {

            final TabPencarian this$0;

            public void onClick(View view)
            {
                mViewPager.setCurrentItem(2, true);
                btnPONSEL.setBackgroundResource(0x7f02013f);
                btnSERVICECENTER.setBackgroundResource(0x7f02013f);
                btnBERITA.setBackgroundResource(0x7f020145);
                btnPENGGUNA.setBackgroundResource(0x7f02013f);
                btnBERITA.setTextColor(getResources().getColor(0x7f080160));
                try
                {
                    view = getResources().getXml(0x7f080197);
                    view = ColorStateList.createFromXml(getResources(), view);
                    btnPONSEL.setTextColor(view);
                    btnSERVICECENTER.setTextColor(view);
                    btnPENGGUNA.setTextColor(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = TabPencarian.this;
                super();
            }
        });
        btnPENGGUNA.setOnClickListener(new android.view.View.OnClickListener() {

            final TabPencarian this$0;

            public void onClick(View view)
            {
                mViewPager.setCurrentItem(3, true);
                btnPONSEL.setBackgroundResource(0x7f02013f);
                btnSERVICECENTER.setBackgroundResource(0x7f02013f);
                btnBERITA.setBackgroundResource(0x7f02013f);
                btnPENGGUNA.setBackgroundResource(0x7f020145);
                btnPENGGUNA.setTextColor(getResources().getColor(0x7f080160));
                try
                {
                    view = getResources().getXml(0x7f080197);
                    view = ColorStateList.createFromXml(getResources(), view);
                    btnPONSEL.setTextColor(view);
                    btnSERVICECENTER.setTextColor(view);
                    btnBERITA.setTextColor(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = TabPencarian.this;
                super();
            }
        });
        tabs.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final TabPencarian this$0;

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
                    break MISSING_BLOCK_LABEL_172;
                }
                (new Handler()).postDelayed(new Runnable() {

                    final _cls5 this$1;

                    public void run()
                    {
                        hsv_viewpager.fullScroll(17);
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                }, 100L);
                btnPONSEL.setBackgroundResource(0x7f020145);
                btnSERVICECENTER.setBackgroundResource(0x7f02013f);
                btnBERITA.setBackgroundResource(0x7f02013f);
                btnPENGGUNA.setBackgroundResource(0x7f02013f);
                btnPONSEL.setTextColor(getResources().getColor(0x7f080160));
                Object obj = getResources().getXml(0x7f080197);
                obj = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj)));
                btnSERVICECENTER.setTextColor(((ColorStateList) (obj)));
                btnBERITA.setTextColor(((ColorStateList) (obj)));
                btnPENGGUNA.setTextColor(((ColorStateList) (obj)));
_L1:
                return;
                if (k == 1)
                {
                    btnPONSEL.setBackgroundResource(0x7f02013f);
                    btnSERVICECENTER.setBackgroundResource(0x7f020145);
                    btnBERITA.setBackgroundResource(0x7f02013f);
                    btnPENGGUNA.setBackgroundResource(0x7f02013f);
                    btnSERVICECENTER.setTextColor(getResources().getColor(0x7f080160));
                    try
                    {
                        Object obj1 = getResources().getXml(0x7f080197);
                        obj1 = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj1)));
                        btnPONSEL.setTextColor(((ColorStateList) (obj1)));
                        btnBERITA.setTextColor(((ColorStateList) (obj1)));
                        btnPENGGUNA.setTextColor(((ColorStateList) (obj1)));
                        return;
                    }
                    catch (Exception exception)
                    {
                        return;
                    }
                }
                if (k == 2)
                {
                    btnPONSEL.setBackgroundResource(0x7f02013f);
                    btnSERVICECENTER.setBackgroundResource(0x7f02013f);
                    btnBERITA.setBackgroundResource(0x7f020145);
                    btnPENGGUNA.setBackgroundResource(0x7f02013f);
                    btnBERITA.setTextColor(getResources().getColor(0x7f080160));
                    try
                    {
                        Object obj2 = getResources().getXml(0x7f080197);
                        obj2 = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj2)));
                        btnPONSEL.setTextColor(((ColorStateList) (obj2)));
                        btnSERVICECENTER.setTextColor(((ColorStateList) (obj2)));
                        btnPENGGUNA.setTextColor(((ColorStateList) (obj2)));
                        return;
                    }
                    catch (Exception exception1)
                    {
                        return;
                    }
                }
                if (k == 3)
                {
                    (new Handler()).postDelayed(new Runnable() {

                        final _cls5 this$1;

                        public void run()
                        {
                            hsv_viewpager.fullScroll(66);
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    }, 100L);
                    btnPONSEL.setBackgroundResource(0x7f02013f);
                    btnSERVICECENTER.setBackgroundResource(0x7f02013f);
                    btnBERITA.setBackgroundResource(0x7f02013f);
                    btnPENGGUNA.setBackgroundResource(0x7f020145);
                    btnPENGGUNA.setTextColor(getResources().getColor(0x7f080160));
                    try
                    {
                        Object obj3 = getResources().getXml(0x7f080197);
                        obj3 = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj3)));
                        btnPONSEL.setTextColor(((ColorStateList) (obj3)));
                        btnSERVICECENTER.setTextColor(((ColorStateList) (obj3)));
                        btnBERITA.setTextColor(((ColorStateList) (obj3)));
                        return;
                    }
                    catch (Exception exception2)
                    {
                        return;
                    }
                }
                  goto _L1
                Exception exception3;
                exception3;
            }


            
            {
                this$0 = TabPencarian.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0014, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        case 2131429682: 
        default:
            return true;

        case 16908332: 
            finish();
            break;
        }
        overridePendingTransition(0x7f040001, 0x7f040002);
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
