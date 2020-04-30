// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.BaseDrawer;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfilPTActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{
    private class ProfilPTTaskTask extends AsyncTask
    {

        final ProfilPTActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataProfilPT, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_329;
                }
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    Log.e("suc", suc);
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_336;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_336;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_336;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_336;
            }
            avoid = inponsel.getJSONObject(i);
            id_pt = avoid.getString("id_pt");
            nama_pt = avoid.getString("nama_pt");
            logo_pt = avoid.getString("logo_pt");
            profil_pt = avoid.getString("profil_pt");
            alamat_pt = avoid.getString("alamat_pt");
            negara_pt = avoid.getString("negara_pt");
            c_center_pt = avoid.getString("c_center_pt");
            email_pt = avoid.getString("email_pt");
            web_pt = avoid.getString("web_pt");
            fb_pt = avoid.getString("fb_pt");
            fb_id_pt = avoid.getString("fb_id_pt");
            twitter_pt = avoid.getString("twitter_pt");
            youtube_pt = avoid.getString("youtube_pt");
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_108;
            }
            Log.e("ServiceHandlerPen", "Couldn't get any data from the url");
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            try
            {
                void1 = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
                void1.setScreenName((new StringBuilder("Profil PT ")).append(nama_pt).toString());
                void1.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
            }
            getSherlock().setProgressBarIndeterminateVisibility(false);
            getSherlock().setProgressBarVisibility(false);
            layout_empty.setVisibility(8);
            Log.e("logo_pt", logo_pt);
            Picasso.with(ProfilPTActivity.this).load(logo_pt.trim()).into(imgLogoPT, new Callback() {

                final ProfilPTTaskTask this$1;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    imgLogoPT.setVisibility(0);
                }

            
            {
                this$1 = ProfilPTTaskTask.this;
                super();
            }
            });
            fb_array = fb_pt.split(",");
            tw_array = twitter_pt.split(",");
            txt_pt_NAMA.setText(nama_pt);
            txt_pt_desc.setText(profil_pt);
            if (!alamat_pt.equals("")) goto _L2; else goto _L1
_L1:
            txt_pt_almt.setText("Tidak ada informasi");
_L13:
            if (!c_center_pt.equals("")) goto _L4; else goto _L3
_L3:
            txt_cont_center.setText("Tidak ada informasi");
_L14:
            if (!email_pt.equals("")) goto _L6; else goto _L5
_L5:
            txt_pt_email.setText("Tidak ada informasi");
_L15:
            if (!fb_pt.equals("")) goto _L8; else goto _L7
_L7:
            lay_PT_FACEBOOK.setVisibility(8);
_L16:
            if (!twitter_pt.equals("")) goto _L10; else goto _L9
_L9:
            lay_PT_TWITTER.setVisibility(8);
_L17:
            if (!web_pt.equals("")) goto _L12; else goto _L11
_L11:
            lay_PT_WEB.setVisibility(8);
_L18:
            if (!youtube_pt.equals(""))
            {
                break MISSING_BLOCK_LABEL_666;
            }
            lay_PT_YOUTUBE.setVisibility(8);
_L19:
            no_contven_center_array = c_center_pt.split("\n");
            txt_cont_center.setOnClickListener(new android.view.View.OnClickListener() {

                final ProfilPTTaskTask this$1;

                public void onClick(View view)
                {
label0:
                    {
                        if (!c_center_pt.equals("Tidak ada informasi"))
                        {
                            if (no_contven_center_array.length <= 1)
                            {
                                break label0;
                            }
                            view = new android.app.AlertDialog.Builder(_fld0);
                            view.setTitle("Nomor Telepon :");
                            view.setSingleChoiceItems(no_contven_center_array, -1, new android.content.DialogInterface.OnClickListener() {

                                final ProfilPTTaskTask._cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(no_contven_center_array[i].replaceAll("[^0-9]", "")).toString()));
                                    startActivity(dialoginterface);
                                }

            
            {
                this$2 = ProfilPTTaskTask._cls2.this;
                super();
            }
                            });
                            view.show();
                        }
                        return;
                    }
                    view = new Intent("android.intent.action.DIAL", Uri.parse((new StringBuilder("tel: ")).append(c_center_pt.replaceAll("[^0-9]", "")).toString()));
                    startActivity(view);
                }


            
            {
                this$1 = ProfilPTTaskTask.this;
                super();
            }
            });
            txt_pt_fb.setOnClickListener(new android.view.View.OnClickListener() {

                final ProfilPTTaskTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        view = getOpenFacebookIntent(_fld0);
                        startActivity(view);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://m.facebook.com/")).append(fb_pt).toString())));
                    }
                }

            
            {
                this$1 = ProfilPTTaskTask.this;
                super();
            }
            });
            txt_pt_twitter.setOnClickListener(new android.view.View.OnClickListener() {

                final ProfilPTTaskTask this$1;

                public void onClick(View view)
                {
                    if (tw_array.length > 1)
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setSingleChoiceItems(tw_array, -1, new android.content.DialogInterface.OnClickListener() {

                            final ProfilPTTaskTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(tw_array[i].replace("@", "")).toString())));
                            }

            
            {
                this$2 = ProfilPTTaskTask._cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    } else
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://twitter.com/")).append(twitter_pt).toString())));
                        return;
                    }
                }


            
            {
                this$1 = ProfilPTTaskTask.this;
                super();
            }
            });
            txt_pt_ytube.setOnClickListener(new android.view.View.OnClickListener() {

                final ProfilPTTaskTask this$1;

                public void onClick(View view)
                {
                    if (youtube_pt.contains("http"))
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://")).append(youtube_pt.trim()).toString())));
                        return;
                    } else
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://www.youtube.com/user/")).append(youtube_pt).toString())));
                        return;
                    }
                }

            
            {
                this$1 = ProfilPTTaskTask.this;
                super();
            }
            });
            return;
_L2:
            try
            {
                txt_pt_almt.setText(alamat_pt);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L13
_L4:
            c_center_pt = c_center_pt.replace(", ", "\n").trim();
            txt_cont_center.setText(c_center_pt);
              goto _L14
_L6:
            txt_pt_email.setText(email_pt);
              goto _L15
_L8:
            txt_pt_fb.setText(fb_pt);
              goto _L16
_L10:
            txt_pt_twitter.setText(twitter_pt);
              goto _L17
_L12:
            txt_pt_web.setText(web_pt);
              goto _L18
            txt_pt_ytube.setText(youtube_pt);
              goto _L19
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            layout_empty.setVisibility(0);
        }


        private ProfilPTTaskTask()
        {
            this$0 = ProfilPTActivity.this;
            super();
        }

        ProfilPTTaskTask(ProfilPTTaskTask profilpttasktask)
        {
            this();
        }
    }


    String alamat_pt;
    String c_center_pt;
    ConnectivityManager cm;
    String dataProfilPT;
    String email_pt;
    Bundle extras;
    String fb_array[];
    String fb_id_pt;
    String fb_pt;
    String id_pt;
    ImageView imgLogoPT;
    JSONArray inponsel;
    JSONObject json;
    LinearLayout lay_PT_FACEBOOK;
    LinearLayout lay_PT_TWITTER;
    LinearLayout lay_PT_WEB;
    LinearLayout lay_PT_YOUTUBE;
    LinearLayout layout_empty;
    int limit;
    ListView listKomen;
    String logo_pt;
    String nama_pt;
    String negara_pt;
    int newBmapHeight;
    int newBmapWidth;
    String no_contven_center_array[];
    String profil_pt;
    ProgressBar progressbar_item;
    ProgressBar progressbar_middle;
    String suc;
    String t;
    String tw_array[];
    String twitter_pt;
    TextView txt_cont_center;
    TextView txt_empty;
    TextView txt_pt_NAMA;
    TextView txt_pt_almt;
    TextView txt_pt_desc;
    TextView txt_pt_email;
    TextView txt_pt_fb;
    TextView txt_pt_twitter;
    TextView txt_pt_web;
    TextView txt_pt_ytube;
    String urlSearch;
    String web_pt;
    String youtube_pt;

    public ProfilPTActivity()
    {
        limit = 0;
        t = Utility.session(RestClient.pelihara);
        inponsel = null;
        suc = "";
    }

    public void ProfilPTTaskTask()
    {
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        ProfilPTTaskTask profilpttasktask = new ProfilPTTaskTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            profilpttasktask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            profilpttasktask.execute(new Void[0]);
            return;
        }
    }

    public Intent getOpenFacebookIntent(Context context)
    {
        try
        {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            context = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("fb://profile/")).append(fb_id_pt).toString()));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://www.facebook.com/")).append(fb_id_pt).toString()));
        }
        return context;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        mDrawerToggle.onConfigurationChanged(configuration);
        int i = configuration.orientation;
        i = configuration.orientation;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300f8, null, false);
        mDrawerLayout.addView(bundle, 0);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        int j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Profil Perusahaan</font>"));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        imgLogoPT = (ImageView)findViewById(0x7f0b0741);
        lay_PT_WEB = (LinearLayout)findViewById(0x7f0b074b);
        lay_PT_TWITTER = (LinearLayout)findViewById(0x7f0b074d);
        lay_PT_FACEBOOK = (LinearLayout)findViewById(0x7f0b074f);
        lay_PT_YOUTUBE = (LinearLayout)findViewById(0x7f0b0751);
        txt_pt_NAMA = (TextView)findViewById(0x7f0b0742);
        txt_pt_almt = (TextView)findViewById(0x7f0b0746);
        txt_pt_NAMA = (TextView)findViewById(0x7f0b0742);
        txt_pt_desc = (TextView)findViewById(0x7f0b0744);
        txt_pt_almt = (TextView)findViewById(0x7f0b0746);
        txt_cont_center = (TextView)findViewById(0x7f0b0748);
        txt_pt_email = (TextView)findViewById(0x7f0b074a);
        txt_pt_web = (TextView)findViewById(0x7f0b074c);
        txt_pt_twitter = (TextView)findViewById(0x7f0b074e);
        txt_pt_fb = (TextView)findViewById(0x7f0b0750);
        txt_pt_ytube = (TextView)findViewById(0x7f0b0752);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        txt_empty = (TextView)findViewById(0x7f0b0093);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        txt_empty.setText("Memuat...");
        t = Utility.session(t);
        cm = (ConnectivityManager)getSystemService("connectivity");
        extras = getIntent().getExtras();
        id_pt = extras.getString("id_merk");
        progressbar_item = (ProgressBar)findViewById(0x7f0b00b3);
        t = Utility.session(t);
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            limit = 0;
            dataProfilPT = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("pt_profile").append(Utility.BASE_FORMAT).append("?id_pt=").append(id_pt).append("&t=").append(t).toString();
            Log.e("dataProfilPT", dataProfilPT);
            ProfilPTTaskTask();
        }
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
