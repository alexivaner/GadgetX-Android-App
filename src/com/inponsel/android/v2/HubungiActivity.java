// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.Log;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import java.util.Observer;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

public class HubungiActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{

    String faq;
    String faq1;
    Intent i;
    PonselBaseApp ponselBaseApp;
    TextView txt_keb;
    WebView webKeb;

    public HubungiActivity()
    {
        faq = "";
        faq1 = "<p><b>Anda dapat menghubungi INPONSEL melalui alamat email berikut</b></p><br/><p>Untuk keperluan umum dan dukungan pengguna, silahkan menghubungi </p><p><a href=\"mailto:support@inponsel.co.id\">support@inponsel.co.id</a></p><br/> <p>Untuk informasi yang berhubungan dengan marketing dan sales, silahkan menghubungi</p><p><a href=\"mailto:marketing@inponsel.co.id\">marketing@inponsel.co.id</a></p><br/><p>Untuk informasi dan kerjasama perusahaan, silahkan menghubungi</p><p><a href=\"mailto:corporate@inponsel.co.id\">corporate@inponsel.co.id</a></p>";
    }

    private String getHtmlData(Context context, String s)
    {
        return (new StringBuilder("<html><body>")).append(s).append("</body></html>").toString();
    }

    public void onBackPressed()
    {
        if (mDrawerLayout.isDrawerOpen(0x800003))
        {
            mDrawerLayout.closeDrawers();
            Log.e("vis", "on");
            return;
        } else
        {
            Log.e("vis", "off");
            finish();
            overridePendingTransition(0x7f040001, 0x7f040002);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300d9, null, false);
        mDrawerLayout.addView(bundle, 0);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        menu_Hubungi.setBackgroundResource(0x7f0201cf);
        menu_Hubungi.setEnabled(false);
        int j;
        int k;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Hubungi Kami");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        k = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        j = k;
        if (k == 0)
        {
            j = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(j);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText("Hubungi Kami");
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Hubungi Kami</font>"));
        txt_keb = (TextView)findViewById(0x7f0b05a2);
        webKeb = (WebView)findViewById(0x7f0b06ad);
        webKeb.setBackgroundColor(Color.parseColor("#f7f7f7"));
        faq = (new StringBuilder("<div align=\"justify\"><font size=3>")).append(faq1).append("<br/><br/>").append("</font>  </div>").toString();
        txt_keb.setText(Html.fromHtml(faq1));
        txt_keb.setMovementMethod(LinkMovementMethod.getInstance());
        webKeb.loadDataWithBaseURL("file:///android_asset/", getHtmlData(this, faq), "text/html", "utf-8", "");
        webKeb.setVisibility(8);
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
