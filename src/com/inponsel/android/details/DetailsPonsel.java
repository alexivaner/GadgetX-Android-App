// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.android.volley.VolleyError;
import com.astuetz.PagerSlidingTabStrip;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.HomeNewMainActivity;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            Hal3KomentarPull, TestFragmentAdapter

public class DetailsPonsel extends SherlockFragmentActivity
    implements android.view.View.OnClickListener, Observer
{

    public static Uri dataurlemail;
    public static String email_user = "";
    public static String nama_asli = "";
    public static PagerSlidingTabStrip tabs;
    public static String user_id = "";
    public static String user_jekel = "";
    public static String user_joindate = "";
    public static String user_kecamatan = "";
    public static String user_kota = "";
    public static String user_photo = "";
    public static String user_ponsel1 = "";
    public static String user_ponsel2 = "";
    public static String user_profile_update = "";
    public static String user_provider1 = "";
    public static String user_provider2 = "";
    public static String user_provinsi = "";
    public static String user_ttl = "";
    public static String username = "";
    double DratdobLikeDis;
    Account accounts[];
    String actfrom;
    ActionBar actionBar;
    int actionBarTitleId;
    TestFragmentAdapter adapter;
    Button btnDialog;
    Button btnIKHTISAR;
    Button btnKOMENTAR;
    Button btnSPESIFIKASI;
    String codename;
    Cursor cursor;
    String dataRefresh;
    DatabaseHandler db;
    int decimalPlace;
    String details;
    Bundle extras;
    String gambar;
    int hargaBaru;
    int hargaBekas;
    String host;
    String id_hph;
    LayoutInflater layoutInflater;
    ProgressDialog mDialog;
    ViewPager mViewPager;
    ImageView menuSearch;
    String merk;
    String model;
    String namalengkap;
    String notif;
    int pageSelected;
    PonselBaseApp ponselBaseApp;
    String profil;
    String pushURL;
    String query;
    String rata2LikeDis;
    double ratdobLikeDis;
    int ratintLikeDis;
    String res;
    String scheme;
    String stat;
    String status;
    String t;
    String tot_komen;
    private boolean useLogo;
    UserFunctions userFunctions;

    public DetailsPonsel()
    {
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        t = Utility.session(RestClient.pelihara);
        actfrom = "";
        notif = "000";
        profil = "";
        decimalPlace = 2;
        rata2LikeDis = "7.1";
        scheme = "";
        host = "";
        details = "";
        pageSelected = 0;
    }

    private void getTitleHP(String s)
    {
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("get_ponsel").append(Utility.BASE_FORMAT).append("?").append("id_hp=").append(s).append("&t=").append(t).toString();
        Log.e("urlUpdateGCM", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final DetailsPonsel this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                JSONObject jsonobject1;
                int i;
                try
                {
                    jsonobject = (new JSONObject(jsonobject.toString())).getJSONArray("InPonsel");
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
                    return;
                }
                jsonobject1 = jsonobject.getJSONObject(i);
                getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>")).append(jsonobject1.getString("namalengkap")).append("</font>").toString()));
                i++;
                if (false)
                {
                } else
                {
                    break MISSING_BLOCK_LABEL_19;
                }
            }

            
            {
                this$0 = DetailsPonsel.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final DetailsPonsel this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = DetailsPonsel.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "tag_json_obj");
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
        if (Hal3KomentarPull.komencount.length() > 0)
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setTitle("Peringatan");
            builder.setMessage("Hapus komentar yang akan dikirim?");
            builder.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                final DetailsPonsel this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    if (notif.equals("gcm") || notif.equals("email"))
                    {
                        Log.e("finish", "1");
                        dialoginterface = new Intent(DetailsPonsel.this, com/inponsel/android/v2/HomeNewMainActivity);
                        dialoginterface.addFlags(32768);
                        dialoginterface.addFlags(0x10000000);
                        startActivity(dialoginterface);
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

            
            {
                this$0 = DetailsPonsel.this;
                super();
            }
            });
            builder.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                final DetailsPonsel this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    mViewPager.setCurrentItem(2);
                }

            
            {
                this$0 = DetailsPonsel.this;
                super();
            }
            });
            builder.show();
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

    public void onClick(View view)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().requestFeature(9);
        setContentView(0x7f03014e);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        db = new DatabaseHandler(this);
        userFunctions = new UserFunctions();
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        btnIKHTISAR = (Button)findViewById(0x7f0b0929);
        btnSPESIFIKASI = (Button)findViewById(0x7f0b092a);
        btnKOMENTAR = (Button)findViewById(0x7f0b092b);
        tabs = (PagerSlidingTabStrip)findViewById(0x7f0b04c9);
        tabs.setIndicatorColor(getResources().getColor(0x7f080182));
        mViewPager = (ViewPager)findViewById(0x7f0b0059);
        adapter = new TestFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        int i = (int)TypedValue.applyDimension(1, 3F, getResources().getDisplayMetrics());
        mViewPager.setPageMargin(i);
        mViewPager.setOffscreenPageLimit(5);
        tabs.setViewPager(mViewPager);
        t = Utility.session(t);
        extras = getIntent().getExtras();
        dataurlemail = getIntent().getData();
        Log.e("dataurlemail", String.valueOf(dataurlemail));
        int k;
        if (!String.valueOf(dataurlemail).equals("null"))
        {
            scheme = dataurlemail.getScheme();
            host = dataurlemail.getHost();
            bundle = dataurlemail.getPathSegments();
            details = (String)bundle.get(0);
            id_hph = (String)bundle.get(1);
            notif = "email";
            namalengkap = "InPonsel";
        } else
        {
            namalengkap = extras.getString("namalengkap");
            id_hph = extras.getString("id_hph");
            model = extras.getString("model");
            merk = extras.getString("merk");
            gambar = extras.getString("gambar");
            if (extras.getString("notif") == null)
            {
                notif = "000";
            } else
            {
                notif = "gcm";
            }
            codename = extras.getString("codename");
        }
        if (String.valueOf(dataurlemail).equals("null")) goto _L2; else goto _L1
_L1:
        mViewPager.setCurrentItem(0, true);
        btnIKHTISAR.setBackgroundResource(0x7f020145);
        btnSPESIFIKASI.setBackgroundResource(0x7f020135);
        btnKOMENTAR.setBackgroundResource(0x7f020135);
        btnIKHTISAR.setTextColor(getResources().getColor(0x7f080160));
        btnSPESIFIKASI.setTextColor(getResources().getColor(0x7f080182));
        btnKOMENTAR.setTextColor(getResources().getColor(0x7f080182));
        int j;
        try
        {
            bundle = getResources().getXml(0x7f080197);
            bundle = ColorStateList.createFromXml(getResources(), bundle);
            btnSPESIFIKASI.setTextColor(bundle);
            btnKOMENTAR.setTextColor(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        btnDialog = (Button)findViewById(0x7f0b04c8);
        btnDialog.setOnClickListener(new android.view.View.OnClickListener() {

            final DetailsPonsel this$0;

            public void onClick(View view)
            {
                view = new android.app.AlertDialog.Builder(DetailsPonsel.this);
                view.setTitle(namalengkap);
                view.setMessage(namalengkap);
                view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                view.show();
            }

            
            {
                this$0 = DetailsPonsel.this;
                super();
            }
        });
        accounts = AccountManager.get(this).getAccounts();
        getSherlock().setProgressBarIndeterminateVisibility(false);
        getSherlock().setProgressBarVisibility(false);
        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        k = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = k;
        if (k == 0)
        {
            i = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>")).append(namalengkap).append("</font>").toString()));
        t = Utility.session(t);
        Log.e("nmhp", namalengkap);
        btnIKHTISAR.setOnClickListener(new android.view.View.OnClickListener() {

            final DetailsPonsel this$0;

            public void onClick(View view)
            {
                mViewPager.setCurrentItem(0, true);
                btnIKHTISAR.setBackgroundResource(0x7f020145);
                btnSPESIFIKASI.setBackgroundResource(0x7f020135);
                btnKOMENTAR.setBackgroundResource(0x7f020135);
                btnIKHTISAR.setTextColor(getResources().getColor(0x7f080160));
                btnSPESIFIKASI.setTextColor(getResources().getColor(0x7f080182));
                btnKOMENTAR.setTextColor(getResources().getColor(0x7f080182));
                try
                {
                    view = getResources().getXml(0x7f080197);
                    view = ColorStateList.createFromXml(getResources(), view);
                    btnSPESIFIKASI.setTextColor(view);
                    btnKOMENTAR.setTextColor(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = DetailsPonsel.this;
                super();
            }
        });
        btnSPESIFIKASI.setOnClickListener(new android.view.View.OnClickListener() {

            final DetailsPonsel this$0;

            public void onClick(View view)
            {
                mViewPager.setCurrentItem(1, true);
                btnIKHTISAR.setBackgroundResource(0x7f020135);
                btnSPESIFIKASI.setBackgroundResource(0x7f020145);
                btnKOMENTAR.setBackgroundResource(0x7f020135);
                btnSPESIFIKASI.setTextColor(getResources().getColor(0x7f080160));
                try
                {
                    view = getResources().getXml(0x7f080197);
                    view = ColorStateList.createFromXml(getResources(), view);
                    btnIKHTISAR.setTextColor(view);
                    btnKOMENTAR.setTextColor(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = DetailsPonsel.this;
                super();
            }
        });
        btnKOMENTAR.setOnClickListener(new android.view.View.OnClickListener() {

            final DetailsPonsel this$0;

            public void onClick(View view)
            {
                mViewPager.setCurrentItem(2, true);
                btnIKHTISAR.setBackgroundResource(0x7f020135);
                btnSPESIFIKASI.setBackgroundResource(0x7f020135);
                btnKOMENTAR.setBackgroundResource(0x7f020145);
                btnKOMENTAR.setTextColor(getResources().getColor(0x7f080160));
                try
                {
                    view = getResources().getXml(0x7f080197);
                    view = ColorStateList.createFromXml(getResources(), view);
                    btnIKHTISAR.setTextColor(view);
                    btnSPESIFIKASI.setTextColor(view);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
            }

            
            {
                this$0 = DetailsPonsel.this;
                super();
            }
        });
        tabs.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final DetailsPonsel this$0;

            public void onPageScrollStateChanged(int l)
            {
            }

            public void onPageScrolled(int l, float f, int i1)
            {
            }

            public void onPageSelected(int l)
            {
                Log.e("onPageSelected", String.valueOf(l));
                pageSelected = l;
                if (l != 0)
                {
                    break MISSING_BLOCK_LABEL_127;
                }
                btnIKHTISAR.setBackgroundResource(0x7f020145);
                btnSPESIFIKASI.setBackgroundResource(0x7f020135);
                btnKOMENTAR.setBackgroundResource(0x7f020135);
                btnIKHTISAR.setTextColor(getResources().getColor(0x7f080160));
                Object obj = getResources().getXml(0x7f080197);
                obj = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj)));
                btnKOMENTAR.setTextColor(((ColorStateList) (obj)));
                btnSPESIFIKASI.setTextColor(((ColorStateList) (obj)));
_L1:
                return;
                if (l == 1)
                {
                    btnIKHTISAR.setBackgroundResource(0x7f020135);
                    btnSPESIFIKASI.setBackgroundResource(0x7f020145);
                    btnKOMENTAR.setBackgroundResource(0x7f020135);
                    btnSPESIFIKASI.setTextColor(getResources().getColor(0x7f080160));
                    try
                    {
                        Object obj1 = getResources().getXml(0x7f080197);
                        obj1 = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj1)));
                        btnIKHTISAR.setTextColor(((ColorStateList) (obj1)));
                        btnKOMENTAR.setTextColor(((ColorStateList) (obj1)));
                        return;
                    }
                    catch (Exception exception)
                    {
                        return;
                    }
                }
                if (l == 2)
                {
                    btnIKHTISAR.setBackgroundResource(0x7f020135);
                    btnSPESIFIKASI.setBackgroundResource(0x7f020135);
                    btnKOMENTAR.setBackgroundResource(0x7f020145);
                    btnKOMENTAR.setTextColor(getResources().getColor(0x7f080160));
                    try
                    {
                        Object obj2 = getResources().getXml(0x7f080197);
                        obj2 = ColorStateList.createFromXml(getResources(), ((org.xmlpull.v1.XmlPullParser) (obj2)));
                        btnIKHTISAR.setTextColor(((ColorStateList) (obj2)));
                        btnSPESIFIKASI.setTextColor(((ColorStateList) (obj2)));
                        return;
                    }
                    catch (Exception exception1)
                    {
                        return;
                    }
                }
                  goto _L1
                Exception exception2;
                exception2;
            }

            
            {
                this$0 = DetailsPonsel.this;
                super();
            }
        });
        if (String.valueOf(dataurlemail).equals("null")) goto _L4; else goto _L3
_L3:
        getTitleHP(id_hph);
_L6:
        return;
_L2:
        bundle = mViewPager;
        if (extras.getString("actfrom") == null)
        {
            j = 0;
        } else
        if (extras.getString("actfrom").equals("spek"))
        {
            j = 1;
        } else
        {
            j = 2;
        }
        bundle.setCurrentItem(j);
        if (mViewPager.getCurrentItem() == 1)
        {
            btnIKHTISAR.setBackgroundResource(0x7f020135);
            btnSPESIFIKASI.setBackgroundResource(0x7f020145);
            btnKOMENTAR.setBackgroundResource(0x7f020135);
            btnSPESIFIKASI.setTextColor(getResources().getColor(0x7f080160));
            try
            {
                bundle = getResources().getXml(0x7f080197);
                bundle = ColorStateList.createFromXml(getResources(), bundle);
                btnIKHTISAR.setTextColor(bundle);
                btnKOMENTAR.setTextColor(bundle);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
        } else
        if (mViewPager.getCurrentItem() == 2)
        {
            btnIKHTISAR.setBackgroundResource(0x7f020135);
            btnSPESIFIKASI.setBackgroundResource(0x7f020135);
            btnKOMENTAR.setBackgroundResource(0x7f020145);
            btnKOMENTAR.setTextColor(getResources().getColor(0x7f080160));
            try
            {
                bundle = getResources().getXml(0x7f080197);
                bundle = ColorStateList.createFromXml(getResources(), bundle);
                btnIKHTISAR.setTextColor(bundle);
                btnSPESIFIKASI.setTextColor(bundle);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!merk.equals("") && !model.equals("") && !namalengkap.equals("")) goto _L6; else goto _L5
_L5:
        getTitleHP(id_hph);
        return;
        if (true) goto _L8; else goto _L7
_L8:
        break MISSING_BLOCK_LABEL_523;
_L7:
    }

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getLoginStat().equals("1"))
        {
            runOnUiThread(new Runnable() {

                final DetailsPonsel this$0;

                public void run()
                {
                    Log.e("updateObserverLogin", "HomeNewMainActivity");
                    if (userFunctions.isUserLoggedIn(DetailsPonsel.this))
                    {
                        cursor = db.getAllData();
                        cursor.moveToFirst();
                        try
                        {
                            DetailsPonsel.user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
                        }
                        catch (Exception exception) { }
                        DetailsPonsel.nama_asli = cursor.getString(2);
                        DetailsPonsel.user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
                        DetailsPonsel.username = cursor.getString(4);
                        DetailsPonsel.email_user = cursor.getString(5);
                        DetailsPonsel.user_ttl = cursor.getString(6);
                        DetailsPonsel.user_provinsi = cursor.getString(7);
                        DetailsPonsel.user_kota = cursor.getString(8);
                        DetailsPonsel.user_kecamatan = cursor.getString(cursor.getColumnIndex("user_kecamatan"));
                        DetailsPonsel.user_jekel = cursor.getString(9);
                        DetailsPonsel.user_ponsel1 = cursor.getString(10);
                        DetailsPonsel.user_ponsel2 = cursor.getString(11);
                        DetailsPonsel.user_provider1 = cursor.getString(12);
                        DetailsPonsel.user_provider2 = cursor.getString(13);
                        DetailsPonsel.user_joindate = cursor.getString(14);
                        DetailsPonsel.user_profile_update = cursor.getString(15);
                    }
                }

            
            {
                this$0 = DetailsPonsel.this;
                super();
            }
            });
        }
    }

}
