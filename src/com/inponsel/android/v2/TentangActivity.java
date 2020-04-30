// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Utility;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.util.Calendar;

public class TentangActivity extends SherlockFragmentActivity
{

    Calendar c;
    String contact;
    int day;
    Bundle extras;
    String gcmMessage;
    String gcmNotiftype;
    String gcmTitle;
    ImageView imgTentang;
    int month;
    TextView txt_about_def;
    TextView txt_tntg_name;
    TextView txtcontact;
    TextView versionab;
    String webContact;
    int year;

    public TentangActivity()
    {
        contact = " Contact us at:<br /><a href=\"mailto:support@inponsel.co.id\">support@inponsel.co.id </a><br /><a href=\"mailto:marketing@inponsel.co.id\">marketing@inponsel.co.id </a><br /><a href=\"mailto:corporate@inponsel.co.id\">corporate@inponsel.co.id </a><br />Twitter <a href=\"https://mobile.twitter.com/InPonsel\">@inponsel </a> <br />";
        gcmNotiftype = "";
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

    public void onBackPressed()
    {
        Log.e("vis", "off");
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03008b);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Tentang INPONSEL");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        c = Calendar.getInstance();
        year = c.get(1);
        month = c.get(2) + 1;
        day = c.get(5);
        txt_about_def = (TextView)findViewById(0x7f0b04c3);
        imgTentang = (ImageView)findViewById(0x7f0b04c4);
        txtcontact = (TextView)findViewById(0x7f0b04c7);
        versionab = (TextView)findViewById(0x7f0b04c2);
        txt_tntg_name = (TextView)findViewById(0x7f0b04c5);
        txt_tntg_name.setText("PT. INTELE HUB INDONESIA\nCassablanca, Jakarta 12810");
        txt_about_def.setText(Html.fromHtml("Dengan <font color=\"#ffffff\"><b>INPONSEL</b></font> Anda tidak akan lagi ketinggalan informasi teknologi mobile dan produk smartphone terkini dari berbagai belahan dunia."));
        try
        {
            versionab.setText(Html.fromHtml((new StringBuilder("<font color=\"#e0e0e0\">Versi</font> <br><font color=\"#ffffff\">")).append(getPackageManager().getPackageInfo(getPackageName(), 0).versionName).append("</font>").toString()));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        txtcontact.setText(Html.fromHtml(contact));
        txtcontact.setTextColor(-1);
        txtcontact.setLinkTextColor(-1);
        txtcontact.setMovementMethod(LinkMovementMethod.getInstance());
        if (Utility.isTablet(getApplicationContext()))
        {
            txt_tntg_name.setTextSize(24F);
            txtcontact.setTextSize(22F);
        }
    }
}
