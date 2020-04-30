// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

public class PengaturanActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{
    public class GetPengaturanTask extends AsyncTask
    {

        final PengaturanActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                query = (new StringBuilder("id=")).append(user_id).append("&t=").append(t).toString();
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_pengaturan").append(Utility.BASE_FORMAT).append("?").append(query).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                res = avoid.toString();
                Log.e("url.............", res);
                Log.e("status", res);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
            }
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            parseJSON(res);
            progbar_pengaturan.setVisibility(4);
            btnset_saveset.setEnabled(true);
            chkEmailNotif.setEnabled(true);
            chkPushNotif.setEnabled(true);
            chkRSSPush.setEnabled(true);
            chkRSSEmail.setEnabled(true);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progbar_pengaturan.setVisibility(0);
            btnset_saveset.setEnabled(false);
        }

        public GetPengaturanTask()
        {
            this$0 = PengaturanActivity.this;
            super();
        }
    }

    public class PengaturanTask extends AsyncTask
    {

        final PengaturanActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                query = (new StringBuilder("id=")).append(user_id).append("&upass=").append(passlam).append("&mail=").append(statusEmail_mod).append("&push=").append(statusPush_mod).append("&rssmail=").append(statusEmail_rssmod).append("&rsspush=").append(statusPush_rssmod).append("&kmail=").append(komen_mail_mod).append("&lmail=").append(like_mail_mod).append("&tmail=").append(tanggap_mail_mod).append("&fmail=").append(forum_mail_mod).append("&kpush=").append(komen_push_mod).append("&lpush=").append(like_push_mod).append("&tpush=").append(tanggap_push_mod).append("&fpush=").append(forum_push_mod).append("&t=").append(t).toString();
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_pengaturan_mod").append(Utility.BASE_FORMAT).append("?").append(query).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                resStatus = avoid.toString();
                Log.e("url.............", resStatus);
                Log.e("status", resStatus);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
            }
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            mDialog.dismiss();
            parseJSONResponse(resStatus);
            if (settingResp.equals("1"))
            {
                Toast.makeText(PengaturanActivity.this, settingMsg, 1).show();
            } else
            if (settingResp.equals("U404"))
            {
                void1 = new android.app.AlertDialog.Builder(PengaturanActivity.this);
                void1.setMessage(settingMsg);
                void1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                    final PengaturanTask this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = PengaturanTask.this;
                super();
            }
                });
                void1.show();
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mDialog = ProgressDialog.show(PengaturanActivity.this, "", "Menyimpan...", true);
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public PengaturanTask()
        {
            this$0 = PengaturanActivity.this;
            super();
        }
    }


    Button btnset_batalset;
    Button btnset_saveset;
    CheckBox chkEmailNotif;
    CheckBox chkForumMail;
    CheckBox chkForumfPush;
    CheckBox chkKomenEmail;
    CheckBox chkKomenPush;
    CheckBox chkLikeMail;
    CheckBox chkLikePush;
    CheckBox chkPushNotif;
    CheckBox chkRSSEmail;
    CheckBox chkRSSPush;
    CheckBox chkTanggapMail;
    CheckBox chkTanggapPush;
    ConnectivityManager cm;
    String forum_mail;
    String forum_mail_mod;
    String forum_push;
    String forum_push_mod;
    JSONArray jArray;
    JSONObject json;
    String komen_mail;
    String komen_mail_mod;
    String komen_push;
    String komen_push_mod;
    String like_mail;
    String like_mail_mod;
    String like_push;
    String like_push_mod;
    SharedPreferences loginPreference;
    ProgressDialog mDialog;
    String messageEmailNotif;
    String messageKomenNotif;
    String messageLikeNotif;
    String messagePushNotif;
    String messageTanggapNotif;
    String passlam;
    SmoothProgressBar progbar_pengaturan;
    String query;
    String res;
    String resStatus;
    String settingMsg;
    String settingResp;
    String statusEmail;
    String statusEmail_mod;
    String statusEmail_rssmod;
    String statusKomen;
    String statusKomenPush;
    String statusLike;
    String statusLikePush;
    String statusPush;
    String statusPush_mod;
    String statusPush_rssmod;
    String statusTanggap;
    String statusTanggapPush;
    String statusrssEmail;
    String statusrssPush;
    String t;
    String tanggap_mail;
    String tanggap_mail_mod;
    String tanggap_push;
    String tanggap_push_mod;
    String toastEmailNotif;
    String toastKomenNotif;
    String toastLikeNotif;
    String toastPushNotif;
    String toastTanggapNotif;

    public PengaturanActivity()
    {
        statusEmail = "1";
        statusPush = "0";
        statusEmail_mod = "1";
        statusPush_mod = "0";
        statusKomen = "1";
        messageEmailNotif = "";
        messageKomenNotif = "";
        toastEmailNotif = "";
        toastKomenNotif = "";
        messagePushNotif = "";
        toastPushNotif = "";
        statusrssEmail = "1";
        statusrssPush = "0";
        statusEmail_rssmod = "1";
        statusPush_rssmod = "0";
        statusLike = "1";
        messageLikeNotif = "";
        toastLikeNotif = "";
        statusTanggap = "1";
        messageTanggapNotif = "";
        toastTanggapNotif = "";
        t = Utility.session(RestClient.pelihara);
        query = "";
        resStatus = "";
        komen_mail = "";
        like_mail = "";
        tanggap_mail = "";
        forum_mail = "";
        komen_push = "";
        like_push = "";
        tanggap_push = "";
        forum_push = "";
        komen_mail_mod = "";
        like_mail_mod = "";
        tanggap_mail_mod = "";
        forum_mail_mod = "";
        komen_push_mod = "";
        like_push_mod = "";
        tanggap_push_mod = "";
        forum_push_mod = "";
        settingResp = "1";
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
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300f3, null, false);
        mDrawerLayout.addView(bundle, 0);
        menu_Setting.setBackgroundResource(0x7f0201cf);
        menu_Setting.setEnabled(false);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        progbar_pengaturan = (SmoothProgressBar)findViewById(0x7f0b0715);
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Pengaturan");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Pengaturan</font>"));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText("Pengaturan");
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Pengaturan</font>"));
        loginPreference = getSharedPreferences("com.inponsel.android_preference", 0);
        try
        {
            passlam = EncodeDecodeAES.decrypt(RestClient.pelihara, loginPreference.getString("save", ""));
            passlam = Utility.session(passlam);
            passlam = Utility.session(passlam);
            passlam = Utility.session(passlam);
            passlam = Utility.session(passlam);
            passlam = Utility.session(passlam);
            Log.e("passlama", passlam);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        chkEmailNotif = (CheckBox)findViewById(0x7f0b06f6);
        chkPushNotif = (CheckBox)findViewById(0x7f0b06fa);
        chkEmailNotif.setEnabled(false);
        chkPushNotif.setEnabled(false);
        chkRSSPush = (CheckBox)findViewById(0x7f0b0701);
        chkRSSEmail = (CheckBox)findViewById(0x7f0b06fd);
        chkRSSPush.setEnabled(false);
        chkRSSEmail.setEnabled(false);
        chkKomenPush = (CheckBox)findViewById(0x7f0b0706);
        chkKomenEmail = (CheckBox)findViewById(0x7f0b0705);
        chkTanggapMail = (CheckBox)findViewById(0x7f0b0709);
        chkTanggapPush = (CheckBox)findViewById(0x7f0b070a);
        chkForumfPush = (CheckBox)findViewById(0x7f0b070e);
        chkForumMail = (CheckBox)findViewById(0x7f0b070d);
        chkLikeMail = (CheckBox)findViewById(0x7f0b0711);
        chkLikePush = (CheckBox)findViewById(0x7f0b0712);
        btnset_saveset = (Button)findViewById(0x7f0b0713);
        btnset_batalset = (Button)findViewById(0x7f0b0714);
        t = Utility.session(t);
        cm = (ConnectivityManager)getSystemService("connectivity");
        t = Utility.session(t);
        chkPushNotif.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PengaturanActivity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (chkPushNotif.isChecked())
                {
                    statusPush_mod = "1";
                    return;
                } else
                {
                    statusPush_mod = "0";
                    return;
                }
            }

            
            {
                this$0 = PengaturanActivity.this;
                super();
            }
        });
        chkRSSPush.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PengaturanActivity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (chkRSSPush.isChecked())
                {
                    statusPush_rssmod = "1";
                    return;
                } else
                {
                    statusPush_rssmod = "0";
                    return;
                }
            }

            
            {
                this$0 = PengaturanActivity.this;
                super();
            }
        });
        chkEmailNotif.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PengaturanActivity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (chkEmailNotif.isChecked())
                {
                    statusEmail_mod = "1";
                    return;
                } else
                {
                    statusEmail_mod = "0";
                    return;
                }
            }

            
            {
                this$0 = PengaturanActivity.this;
                super();
            }
        });
        chkRSSEmail.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PengaturanActivity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (chkRSSEmail.isChecked())
                {
                    statusEmail_rssmod = "1";
                    return;
                } else
                {
                    statusEmail_rssmod = "0";
                    return;
                }
            }

            
            {
                this$0 = PengaturanActivity.this;
                super();
            }
        });
        chkKomenPush.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PengaturanActivity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (chkKomenPush.isChecked())
                {
                    komen_push_mod = "1";
                    return;
                } else
                {
                    komen_push_mod = "0";
                    return;
                }
            }

            
            {
                this$0 = PengaturanActivity.this;
                super();
            }
        });
        chkKomenEmail.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PengaturanActivity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (chkKomenEmail.isChecked())
                {
                    komen_mail_mod = "1";
                    return;
                } else
                {
                    komen_mail_mod = "0";
                    return;
                }
            }

            
            {
                this$0 = PengaturanActivity.this;
                super();
            }
        });
        chkTanggapPush.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PengaturanActivity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (chkTanggapPush.isChecked())
                {
                    tanggap_push_mod = "1";
                    return;
                } else
                {
                    tanggap_push_mod = "0";
                    return;
                }
            }

            
            {
                this$0 = PengaturanActivity.this;
                super();
            }
        });
        chkTanggapMail.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PengaturanActivity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (chkTanggapMail.isChecked())
                {
                    tanggap_mail_mod = "1";
                    return;
                } else
                {
                    tanggap_mail_mod = "0";
                    return;
                }
            }

            
            {
                this$0 = PengaturanActivity.this;
                super();
            }
        });
        chkForumfPush.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PengaturanActivity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (chkForumfPush.isChecked())
                {
                    forum_push_mod = "1";
                    return;
                } else
                {
                    forum_push_mod = "0";
                    return;
                }
            }

            
            {
                this$0 = PengaturanActivity.this;
                super();
            }
        });
        chkForumMail.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final PengaturanActivity this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (chkForumMail.isChecked())
                {
                    forum_mail_mod = "1";
                    return;
                } else
                {
                    forum_mail_mod = "0";
                    return;
                }
            }

            
            {
                this$0 = PengaturanActivity.this;
                super();
            }
        });
        btnset_batalset.setOnClickListener(new android.view.View.OnClickListener() {

            final PengaturanActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = PengaturanActivity.this;
                super();
            }
        });
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new GetPengaturanTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else
        {
            (new GetPengaturanTask()).execute(new Void[0]);
        }
        btnset_saveset.setOnClickListener(new android.view.View.OnClickListener() {

            final PengaturanActivity this$0;

            public void onClick(View view)
            {
                Log.e("statusEmail", (new StringBuilder(String.valueOf(statusEmail))).append("=").append(statusEmail_mod).toString());
                Log.e("statusPush", (new StringBuilder(String.valueOf(statusPush))).append("=").append(statusPush_mod).toString());
                Log.e("statusrssEmail", (new StringBuilder(String.valueOf(statusrssEmail))).append("=").append(statusEmail_rssmod).toString());
                Log.e("statusrssPush", (new StringBuilder(String.valueOf(statusrssPush))).append("=").append(statusPush_rssmod).toString());
                if (statusEmail.equals(statusEmail_mod) && statusPush.equals(statusPush_mod) && statusrssEmail.equals(statusEmail_rssmod) && statusrssPush.equals(statusPush_rssmod))
                {
                    Toast.makeText(getApplicationContext(), "Tidak ada perubahan pengaturan", 1).show();
                    return;
                }
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new PengaturanTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    return;
                } else
                {
                    (new PengaturanTask()).execute(new Void[0]);
                    return;
                }
            }

            
            {
                this$0 = PengaturanActivity.this;
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

    void parseJSON(String s)
    {
        int i;
        try
        {
            json = new JSONObject(s);
            jArray = json.getJSONArray("InPonsel");
            Log.e("length:", String.valueOf(jArray.length()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        i = 0;
_L33:
        if (i >= jArray.length())
        {
            return;
        }
        s = jArray.getJSONObject(i);
        statusPush = s.getString("push_stat");
        statusPush_mod = s.getString("push_stat");
        statusEmail = s.getString("mail_stat");
        statusEmail_mod = s.getString("mail_stat");
        statusrssPush = s.getString("rsspush_stat");
        statusPush_rssmod = s.getString("rsspush_stat");
        statusEmail = s.getString("rssmail_stat");
        statusEmail_rssmod = s.getString("rssmail_stat");
        komen_push = s.getString("komen_push");
        komen_mail = s.getString("komen_mail");
        tanggap_push = s.getString("tanggap_push");
        tanggap_mail = s.getString("tanggap_mail");
        forum_push = s.getString("forum_push");
        forum_mail = s.getString("forum_mail");
        like_push = s.getString("like_push");
        like_mail = s.getString("like_mail");
        komen_push_mod = s.getString("komen_push");
        komen_mail_mod = s.getString("komen_mail");
        tanggap_push_mod = s.getString("tanggap_push");
        tanggap_mail_mod = s.getString("tanggap_mail");
        forum_push_mod = s.getString("forum_push");
        forum_mail_mod = s.getString("forum_mail");
        like_push_mod = s.getString("like_push");
        like_mail_mod = s.getString("like_mail");
        if (!s.getString("push_stat").equals("1")) goto _L2; else goto _L1
_L1:
        chkPushNotif.setChecked(true);
_L21:
        if (!s.getString("mail_stat").equals("1")) goto _L4; else goto _L3
_L3:
        chkEmailNotif.setChecked(true);
_L22:
        if (!s.getString("rsspush_stat").equals("1")) goto _L6; else goto _L5
_L5:
        chkRSSPush.setChecked(true);
_L23:
        if (!s.getString("rssmail_stat").equals("1")) goto _L8; else goto _L7
_L7:
        chkRSSEmail.setChecked(true);
_L24:
        if (!s.getString("komen_push").equals("1")) goto _L10; else goto _L9
_L9:
        chkKomenPush.setChecked(true);
_L25:
        if (!s.getString("komen_mail").equals("1")) goto _L12; else goto _L11
_L11:
        chkKomenEmail.setChecked(true);
_L26:
        if (!s.getString("tanggap_push").equals("1")) goto _L14; else goto _L13
_L13:
        chkTanggapPush.setChecked(true);
_L27:
        if (!s.getString("tanggap_mail").equals("1")) goto _L16; else goto _L15
_L15:
        chkTanggapMail.setChecked(true);
_L28:
        if (!s.getString("forum_push").equals("1")) goto _L18; else goto _L17
_L17:
        chkForumfPush.setChecked(true);
_L29:
        if (!s.getString("forum_mail").equals("1")) goto _L20; else goto _L19
_L19:
        chkForumMail.setChecked(true);
_L30:
        if (!s.getString("like_push").equals("1"))
        {
            break MISSING_BLOCK_LABEL_724;
        }
        chkLikePush.setChecked(true);
_L31:
        if (s.getString("like_mail").equals("1"))
        {
            chkLikeMail.setChecked(true);
            break MISSING_BLOCK_LABEL_746;
        }
        break MISSING_BLOCK_LABEL_735;
_L2:
        chkPushNotif.setChecked(false);
          goto _L21
_L4:
        chkEmailNotif.setChecked(false);
          goto _L22
_L6:
        chkRSSPush.setChecked(false);
          goto _L23
_L8:
        chkRSSEmail.setChecked(false);
          goto _L24
_L10:
        chkKomenPush.setChecked(false);
          goto _L25
_L12:
        chkKomenEmail.setChecked(false);
          goto _L26
_L14:
        chkTanggapPush.setChecked(false);
          goto _L27
_L16:
        chkTanggapMail.setChecked(false);
          goto _L28
_L18:
        chkForumfPush.setChecked(false);
          goto _L29
_L20:
        chkForumMail.setChecked(false);
          goto _L30
        chkLikePush.setChecked(false);
          goto _L31
        chkLikeMail.setChecked(false);
        i++;
        if (true) goto _L33; else goto _L32
_L32:
    }

    void parseJSONResponse(String s)
    {
        int i;
        try
        {
            json = new JSONObject(s);
            jArray = json.getJSONArray("InPonsel");
            Log.e("length:", String.valueOf(jArray.length()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        i = 0;
        if (i >= jArray.length())
        {
            return;
        }
        s = jArray.getJSONObject(i);
        settingResp = s.optString("success");
        settingMsg = s.optString("message");
        statusPush = s.getString("push_stat");
        statusPush_mod = s.getString("push_stat");
        statusEmail = s.getString("mail_stat");
        statusEmail_mod = s.getString("mail_stat");
        statusrssPush = s.getString("rsspush_stat");
        statusPush_rssmod = s.getString("rsspush_stat");
        statusEmail = s.getString("rssmail_stat");
        statusEmail_rssmod = s.getString("rssmail_stat");
        komen_push = s.getString("komen_push");
        komen_mail = s.getString("komen_mail");
        tanggap_push = s.getString("tanggap_push");
        tanggap_mail = s.getString("tanggap_mail");
        forum_push = s.getString("forum_push");
        forum_mail = s.getString("forum_mail");
        like_push = s.getString("like_push");
        like_mail = s.getString("like_mail");
        komen_push_mod = s.getString("komen_push");
        komen_mail_mod = s.getString("komen_mail");
        tanggap_push_mod = s.getString("tanggap_push");
        tanggap_mail_mod = s.getString("tanggap_mail");
        forum_push_mod = s.getString("forum_push");
        forum_mail_mod = s.getString("forum_mail");
        like_push_mod = s.getString("like_push");
        like_mail_mod = s.getString("like_mail");
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_44;
        }
    }
}
