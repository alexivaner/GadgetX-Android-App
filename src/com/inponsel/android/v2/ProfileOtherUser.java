// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, ImagePagerActivity, InboxMessageActivity, MessageActivity, 
//            RegisterActivity, LoginActivity, KomentarAktivitasUser

public class ProfileOtherUser extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{
    public class UserViewAsycTask extends AsyncTask
    {

        final ProfileOtherUser this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("UserViewAsycTask", "doInBackground");
            as = (new JSONObject(getJSONUrl(urlUserView))).getJSONArray("InPonsel");
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_403;
            }
            JSONObject jsonobject = as.getJSONObject(i);
            str_id_user = jsonobject.getString("id");
            str_nmlengkap = jsonobject.getString("name");
            str_username = jsonobject.getString("uname");
            str_jekel = jsonobject.getString("ugen");
            str_kab = jsonobject.getString("uprov");
            str_kota = jsonobject.getString("ucity");
            strTotalLikes = jsonobject.getString("total_like");
            strTotalDisLikes = jsonobject.getString("total_dislike");
            strTotalPost = jsonobject.getString("totpost");
            strIDHP1 = jsonobject.getString("id_hp1");
            strIDHP2 = jsonobject.getString("id_hp2");
            strCodename1 = jsonobject.getString("codename1");
            strCodename2 = jsonobject.getString("codename2");
            strMerek1 = jsonobject.getString("uphone1");
            strMerek2 = jsonobject.getString("uphone2");
            strHarga1 = jsonobject.getString("uprice1");
            strHarga2 = jsonobject.getString("uprice2");
            stroperator1 = jsonobject.getString("uope1");
            stroperator2 = jsonobject.getString("uope2");
            stroperatorgbr1 = jsonobject.getString("uopegbr1");
            stroperatorgbr2 = jsonobject.getString("uopegbr2");
            str_srcimguser = jsonobject.getString("avatar");
            str_srcimghp1 = jsonobject.getString("upichp1");
            str_srcimghp2 = jsonobject.getString("upichp2");
            strJoinDate = jsonobject.getString("ujdate");
            strMeStat = jsonobject.getString("me");
            i++;
              goto _L1
            as;
            as.printStackTrace();
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            layout_empty.setVisibility(8);
            if (strMeStat.equals("yes"))
            {
                txt_pmesssage.setText("Pesan Masuk");
            } else
            {
                txt_pmesssage.setText("Kirim Pesan");
            }
            if (strIDHP1.equals(""))
            {
                break MISSING_BLOCK_LABEL_317;
            }
            updateUIData();
            if (!db.checkIfExistUserView(str_username))
            {
                break MISSING_BLOCK_LABEL_334;
            }
            db.updateUserView(str_id_user, str_nmlengkap, str_srcimguser, str_username, str_kab, str_kota, str_jekel, strIDHP1, strIDHP2, strMerek1, strMerek2, strHarga1, strHarga2, str_srcimghp1, str_srcimghp2, (new StringBuilder(String.valueOf(stroperator1))).append("#").append(stroperatorgbr1).toString(), (new StringBuilder(String.valueOf(stroperator2))).append("#").append(stroperatorgbr2).toString(), strTotalPost, strTotalLikes, strTotalDisLikes, strMeStat, strJoinDate, strCodename1, strCodename2);
            return;
            try
            {
                db.addUserView(str_id_user, str_nmlengkap, str_srcimguser, str_username, str_kab, str_kota, str_jekel, strIDHP1, strIDHP2, strMerek1, strMerek2, strHarga1, strHarga2, str_srcimghp1, str_srcimghp2, (new StringBuilder(String.valueOf(stroperator1))).append("#").append(stroperatorgbr1).toString(), (new StringBuilder(String.valueOf(stroperator2))).append("#").append(stroperatorgbr2).toString(), strTotalPost, strTotalLikes, strTotalDisLikes, strMeStat, strJoinDate, strCodename1, strCodename2);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
            }
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Log.e("UserViewAsycTask", "onPreExecute");
        }

        public UserViewAsycTask()
        {
            this$0 = ProfileOtherUser.this;
            super();
        }
    }


    Cursor curUser;
    Bundle extras;
    String id_user_view;
    ImageLoader imageLoader2;
    ImageView img_UserProfil;
    ImageView imghp1;
    ImageView imghp2;
    ImageView imgoperator1;
    ImageView imgoperator2;
    LinearLayout layout_empty;
    LinearLayout ll_hp1;
    LinearLayout ll_hp2;
    LinearLayout ll_operator1;
    LinearLayout ll_operator2;
    ImageLoaderConfiguration loaderConfiguration;
    String opr1[];
    String opr2[];
    private DisplayImageOptions optionsNotRound;
    ProgressBar progressbar_UserProfil;
    ProgressBar progressbar_hp1;
    ProgressBar progressbar_hp2;
    ProgressBar progressbar_middle;
    ProgressBar progressbar_operator1;
    ProgressBar progressbar_operator2;
    RelativeLayout rl_aktifitas;
    RelativeLayout rl_pmesssage;
    String strCodename1;
    String strCodename2;
    String strHarga1;
    String strHarga2;
    String strIDHP1;
    String strIDHP2;
    String strJoinDate;
    String strMeStat;
    String strMerek1;
    String strMerek2;
    String strTotalDisLikes;
    String strTotalLikes;
    String strTotalPost;
    String str_id_user;
    String str_jekel;
    String str_kab;
    String str_kota;
    String str_nmlengkap;
    String str_srcimghp1;
    String str_srcimghp2;
    String str_srcimguser;
    String str_username;
    String stroperator1;
    String stroperator2;
    String stroperatorgbr1;
    String stroperatorgbr2;
    String t;
    TextView txtHarga1;
    TextView txtHarga2;
    TextView txtLabelTotPost;
    TextView txtMerek1;
    TextView txtMerek2;
    TextView txtTotalDisLikes;
    TextView txtTotalLikes;
    TextView txtTotalTotPost;
    TextView txt_kabkota;
    TextView txt_pmesssage;
    TextView txt_username;
    TextView txtoperator1;
    TextView txtoperator2;
    String urlUserView;

    public ProfileOtherUser()
    {
        str_id_user = "";
        str_nmlengkap = "";
        str_username = "";
        str_jekel = "";
        str_kab = "";
        str_kota = "";
        strTotalPost = "";
        strTotalLikes = "";
        strTotalDisLikes = "";
        strMerek1 = "";
        strMerek2 = "";
        strIDHP1 = "";
        strIDHP2 = "";
        strHarga1 = "";
        strHarga2 = "";
        stroperator1 = "";
        stroperator2 = "";
        stroperatorgbr1 = "";
        stroperatorgbr2 = "";
        str_srcimguser = "";
        str_srcimghp1 = "";
        str_srcimghp2 = "";
        strJoinDate = "";
        strMeStat = "";
        strCodename1 = "";
        strCodename2 = "";
        t = Utility.session(RestClient.pelihara);
    }

    private void updateUIData()
    {
        try
        {
            Tracker tracker = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            tracker.setScreenName((new StringBuilder("Profil ")).append(str_username).toString());
            tracker.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        txt_username.setText(str_username);
        txt_kabkota.setText((new StringBuilder(String.valueOf(str_kota))).append(", ").append(str_kab).toString());
        txtMerek1.setText(strMerek1);
        txtMerek2.setText(strMerek2);
        if (strHarga1.equals("0") || strHarga1.equals(""))
        {
            txtHarga1.setText("");
        } else
        {
            txtHarga1.setText((new StringBuilder("Rp. ")).append(strHarga1).toString());
        }
        if (strHarga2.equals("0") || strHarga2.equals(""))
        {
            txtHarga2.setText("");
        } else
        {
            txtHarga2.setText((new StringBuilder("Rp. ")).append(strHarga2).toString());
        }
        txtoperator1.setText(stroperator1);
        txtoperator2.setText(stroperator2);
        txtTotalLikes.setText(strTotalLikes);
        txtTotalDisLikes.setText(strTotalDisLikes);
        txtTotalTotPost.setText(strTotalPost);
        imageLoader2.displayImage(str_srcimguser.trim(), img_UserProfil, optionsNotRound, new ImageLoadingListener() {

            final ProfileOtherUser this$0;

            public void onLoadingCancelled(String s, View view)
            {
            }

            public void onLoadingComplete(String s, View view, Bitmap bitmap)
            {
                progressbar_UserProfil.setVisibility(8);
                img_UserProfil.setVisibility(0);
            }

            public void onLoadingFailed(String s, View view, FailReason failreason)
            {
                progressbar_UserProfil.setVisibility(8);
                img_UserProfil.setVisibility(0);
            }

            public void onLoadingStarted(String s, View view)
            {
                progressbar_UserProfil.setVisibility(0);
                img_UserProfil.setVisibility(8);
            }

            
            {
                this$0 = ProfileOtherUser.this;
                super();
            }
        });
        imageLoader2.displayImage(str_srcimghp1.trim(), imghp1, optionsNotRound, new ImageLoadingListener() {

            final ProfileOtherUser this$0;

            public void onLoadingCancelled(String s, View view)
            {
            }

            public void onLoadingComplete(String s, View view, Bitmap bitmap)
            {
                progressbar_hp1.setVisibility(8);
                imghp1.setVisibility(0);
            }

            public void onLoadingFailed(String s, View view, FailReason failreason)
            {
                progressbar_hp1.setVisibility(8);
                imghp1.setVisibility(0);
            }

            public void onLoadingStarted(String s, View view)
            {
                progressbar_hp1.setVisibility(0);
                imghp1.setVisibility(8);
            }

            
            {
                this$0 = ProfileOtherUser.this;
                super();
            }
        });
        if (stroperator2.equals("") || stroperator2.equals("0"))
        {
            ll_operator2.setVisibility(8);
        }
        if (strIDHP2.equals("") || strIDHP2.equals("0"))
        {
            ll_hp2.setVisibility(8);
        } else
        {
            ll_hp2.setVisibility(0);
            imageLoader2.displayImage(str_srcimghp2.trim(), imghp2, optionsNotRound, new ImageLoadingListener() {

                final ProfileOtherUser this$0;

                public void onLoadingCancelled(String s, View view)
                {
                }

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    progressbar_hp2.setVisibility(8);
                    imghp2.setVisibility(0);
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    progressbar_hp2.setVisibility(8);
                    imghp2.setVisibility(0);
                }

                public void onLoadingStarted(String s, View view)
                {
                    progressbar_hp2.setVisibility(0);
                    imghp2.setVisibility(8);
                }

            
            {
                this$0 = ProfileOtherUser.this;
                super();
            }
            });
        }
        ll_hp1.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileOtherUser this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                view.putExtra("id_hph", strIDHP1);
                view.putExtra("namalengkap", strMerek1);
                view.putExtra("codename", strCodename1);
                view.putExtra("model", "");
                view.putExtra("merk", "");
                view.putExtra("gambar", "");
                view.putExtra("hrg_baru", "");
                view.putExtra("hrg_bekas", "");
                view.putExtra("tot_like", "");
                view.putExtra("tot_dislike", "");
                view.putExtra("tot_komen", "");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ProfileOtherUser.this;
                super();
            }
        });
        ll_hp2.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileOtherUser this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                view.putExtra("id_hph", strIDHP2);
                view.putExtra("namalengkap", strMerek2);
                view.putExtra("codename", strCodename2);
                view.putExtra("model", "");
                view.putExtra("merk", "");
                view.putExtra("gambar", "");
                view.putExtra("hrg_baru", "");
                view.putExtra("hrg_bekas", "");
                view.putExtra("tot_like", "");
                view.putExtra("tot_dislike", "");
                view.putExtra("tot_komen", "");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ProfileOtherUser.this;
                super();
            }
        });
        rl_aktifitas.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileOtherUser this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarAktivitasUser);
                view.putExtra("str_id_user", str_id_user);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ProfileOtherUser.this;
                super();
            }
        });
        rl_pmesssage.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileOtherUser this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(ProfileOtherUser.this))
                {
                    if (strMeStat.equals("yes"))
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/InboxMessageActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    } else
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/MessageActivity);
                        i.putExtra("id_msg", "");
                        i.putExtra("id_to", str_id_user);
                        i.putExtra("to_name", username);
                        i.putExtra("to_photo", user_photo);
                        i.putExtra("id_from", user_id);
                        i.putExtra("from_name", str_username);
                        i.putExtra("from_photo", str_srcimguser.trim());
                        i.putExtra("last_message", "");
                        i.putExtra("message_type", "");
                        i.putExtra("unread_msg", "");
                        i.putExtra("msg_date", "");
                        Log.e("id_to", str_id_user);
                        Log.e("id_from", user_id);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(ProfileOtherUser.this);
                    view.setMessage("Untuk mengirim pesan harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls9 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls9 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls9 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = ProfileOtherUser.this;
                super();
            }
        });
        img_UserProfil.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileOtherUser this$0;

            public void onClick(View view)
            {
                view = new ArrayList();
                view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(str_srcimguser.toString().trim()).toString());
                view = (String[])view.toArray(new String[view.size()]);
                Intent intent = new Intent(ProfileOtherUser.this, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view);
                intent.putExtra("pos", 0);
                startActivity(intent);
            }

            
            {
                this$0 = ProfileOtherUser.this;
                super();
            }
        });
        imageLoader2.displayImage(stroperatorgbr1.trim(), imgoperator1, optionsNotRound, new ImageLoadingListener() {

            final ProfileOtherUser this$0;

            public void onLoadingCancelled(String s, View view)
            {
            }

            public void onLoadingComplete(String s, View view, Bitmap bitmap)
            {
                progressbar_operator1.setVisibility(8);
                imgoperator1.setVisibility(0);
            }

            public void onLoadingFailed(String s, View view, FailReason failreason)
            {
                progressbar_operator1.setVisibility(8);
                imgoperator1.setVisibility(0);
            }

            public void onLoadingStarted(String s, View view)
            {
                progressbar_operator1.setVisibility(0);
                imgoperator1.setVisibility(8);
            }

            
            {
                this$0 = ProfileOtherUser.this;
                super();
            }
        });
        imageLoader2.displayImage(stroperatorgbr2.trim(), imgoperator2, optionsNotRound, new ImageLoadingListener() {

            final ProfileOtherUser this$0;

            public void onLoadingCancelled(String s, View view)
            {
            }

            public void onLoadingComplete(String s, View view, Bitmap bitmap)
            {
                progressbar_operator2.setVisibility(8);
                imgoperator2.setVisibility(0);
            }

            public void onLoadingFailed(String s, View view, FailReason failreason)
            {
                progressbar_operator2.setVisibility(8);
                imgoperator2.setVisibility(0);
            }

            public void onLoadingStarted(String s, View view)
            {
                progressbar_operator2.setVisibility(0);
                imgoperator2.setVisibility(8);
            }

            
            {
                this$0 = ProfileOtherUser.this;
                super();
            }
        });
    }

    public void UserViewAsycTask()
    {
        layout_empty.setVisibility(0);
        progressbar_middle.setVisibility(0);
        UserViewAsycTask userviewasyctask;
        try
        {
            urlUserView = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("profile_user").append(Utility.BASE_FORMAT).append("?id=").append(URLEncoder.encode(id_user_view, "utf-8")).append("&from=").append(user_id).append("&t=").append(t).toString();
            Log.e("urlUserViewUpdate", urlUserView);
        }
        catch (Exception exception) { }
        userviewasyctask = new UserViewAsycTask();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            userviewasyctask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        } else
        {
            userviewasyctask.execute(new String[0]);
            return;
        }
    }

    public String getJSONUrl(String s)
    {
        StringBuilder stringbuilder;
        Object obj;
        stringbuilder = new StringBuilder();
        obj = new DefaultHttpClient();
        s = new HttpGet(s);
        s = ((HttpClient) (obj)).execute(s);
        if (s.getStatusLine().getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        s = new BufferedReader(new InputStreamReader(s.getEntity().getContent()));
_L3:
        obj = s.readLine();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return stringbuilder.toString();
_L2:
        stringbuilder.append(((String) (obj)));
          goto _L3
        try
        {
            Log.e("Log", "Failed to download file..");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
          goto _L1
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
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300dd, null, false);
        mDrawerLayout.addView(bundle, 0);
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        int j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText("Profil");
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        t = Utility.session(t);
        extras = getIntent().getExtras();
        id_user_view = extras.getString("id_user_view");
        txt_username = (TextView)findViewById(0x7f0b0373);
        txt_kabkota = (TextView)findViewById(0x7f0b0374);
        txtTotalLikes = (TextView)findViewById(0x7f0b0377);
        txtTotalDisLikes = (TextView)findViewById(0x7f0b0379);
        txtMerek1 = (TextView)findViewById(0x7f0b0388);
        txtMerek2 = (TextView)findViewById(0x7f0b038e);
        txtHarga1 = (TextView)findViewById(0x7f0b0389);
        txtHarga2 = (TextView)findViewById(0x7f0b038f);
        txt_pmesssage = (TextView)findViewById(0x7f0b0380);
        txtoperator1 = (TextView)findViewById(0x7f0b0398);
        txtoperator2 = (TextView)findViewById(0x7f0b039c);
        txtTotalTotPost = (TextView)findViewById(0x7f0b0375);
        t = Utility.session(t);
        img_UserProfil = (ImageView)findViewById(0x7f0b0372);
        imghp1 = (ImageView)findViewById(0x7f0b0387);
        imghp2 = (ImageView)findViewById(0x7f0b038d);
        imgoperator1 = (ImageView)findViewById(0x7f0b0397);
        imgoperator2 = (ImageView)findViewById(0x7f0b039b);
        progressbar_UserProfil = (ProgressBar)findViewById(0x7f0b0371);
        progressbar_hp1 = (ProgressBar)findViewById(0x7f0b0386);
        progressbar_hp2 = (ProgressBar)findViewById(0x7f0b038c);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        progressbar_operator1 = (ProgressBar)findViewById(0x7f0b0396);
        progressbar_operator2 = (ProgressBar)findViewById(0x7f0b039a);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        ll_hp1 = (LinearLayout)findViewById(0x7f0b0385);
        ll_hp2 = (LinearLayout)findViewById(0x7f0b038b);
        ll_operator1 = (LinearLayout)findViewById(0x7f0b0395);
        ll_operator2 = (LinearLayout)findViewById(0x7f0b0399);
        rl_aktifitas = (RelativeLayout)findViewById(0x7f0b037b);
        rl_pmesssage = (RelativeLayout)findViewById(0x7f0b037e);
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        optionsNotRound = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        if (!userFunctions.isUserLoggedIn(this))
        {
            user_id = "";
        }
        boolean flag;
        try
        {
            flag = db.checkIfExistUserView(id_user_view);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        curUser = db.getUserData(id_user_view);
        curUser.moveToFirst();
        str_id_user = EncodeDecodeAES.decrypt(RestClient.pelihara, curUser.getString(1));
        str_srcimguser = curUser.getString(3);
        str_username = EncodeDecodeAES.decrypt(RestClient.pelihara, curUser.getString(4));
        str_kab = curUser.getString(5);
        str_kota = curUser.getString(6);
        strIDHP1 = curUser.getString(8);
        strIDHP2 = curUser.getString(9);
        strMerek1 = curUser.getString(10);
        strMerek2 = curUser.getString(11);
        strHarga1 = curUser.getString(12);
        strHarga2 = curUser.getString(13);
        str_srcimghp1 = curUser.getString(14);
        str_srcimghp2 = curUser.getString(15);
        opr1 = curUser.getString(16).split("#");
        opr2 = curUser.getString(17).split("#");
        stroperator1 = opr1[0];
        stroperator2 = opr2[0];
        stroperatorgbr1 = opr1[1];
        stroperatorgbr2 = opr2[1];
        strTotalPost = curUser.getString(18);
        strTotalLikes = curUser.getString(19);
        strTotalDisLikes = curUser.getString(20);
        strJoinDate = curUser.getString(22);
        strMeStat = curUser.getString(21);
        Log.e("strCodename2", (new StringBuilder(String.valueOf(curUser.getString(23)))).append("=").append(curUser.getString(24)).toString());
        strCodename1 = curUser.getString(23);
        strCodename2 = curUser.getString(24);
_L11:
        updateUIData();
        if (!strMeStat.equals("yes")) goto _L4; else goto _L3
_L3:
        txt_pmesssage.setText("Pesan Masuk");
_L9:
        layout_empty.setVisibility(8);
        urlUserView = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("profile_user").append(Utility.BASE_FORMAT).append("?id=").append(URLEncoder.encode(id_user_view, "utf-8")).append("&from=").append(user_id).append("&t=").append(t).toString();
        Log.e("urlUserViewUpdate", urlUserView);
        bundle = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
        if (bundle == null) goto _L6; else goto _L5
_L5:
        if (!bundle.isConnected()) goto _L6; else goto _L7
_L7:
        bundle = new UserViewAsycTask();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            bundle.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        }
          goto _L8
        bundle;
        bundle.printStackTrace();
        continue; /* Loop/switch isn't completed */
_L4:
        txt_pmesssage.setText("Kirim Pesan");
          goto _L9
_L8:
        bundle.execute(new String[0]);
        return;
_L2:
        UserViewAsycTask();
_L6:
        return;
        if (true) goto _L11; else goto _L10
_L10:
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

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getLoginStat().equals("1"))
        {
            runOnUiThread(new Runnable() {

                final ProfileOtherUser this$0;

                public void run()
                {
label0:
                    {
                        if (userFunctions.isUserLoggedIn(getApplicationContext()))
                        {
                            if (!user_id.equals(str_id_user))
                            {
                                break label0;
                            }
                            txt_pmesssage.setText("Pesan Masuk");
                        }
                        return;
                    }
                    txt_pmesssage.setText("Kirim Pesan");
                }

            
            {
                this$0 = ProfileOtherUser.this;
                super();
            }
            });
        }
        rl_pmesssage.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileOtherUser this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(ProfileOtherUser.this))
                {
                    if (user_id.equals(str_id_user))
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/InboxMessageActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    } else
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/MessageActivity);
                        i.putExtra("id_msg", "");
                        i.putExtra("id_to", str_id_user);
                        i.putExtra("to_name", username);
                        i.putExtra("to_photo", user_photo);
                        i.putExtra("id_from", user_id);
                        i.putExtra("from_name", str_username);
                        i.putExtra("from_photo", str_srcimguser.trim());
                        i.putExtra("last_message", "");
                        i.putExtra("message_type", "");
                        i.putExtra("unread_msg", "");
                        i.putExtra("msg_date", "");
                        Log.e("id_to", str_id_user);
                        Log.e("id_from", user_id);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(ProfileOtherUser.this);
                    view.setMessage("Untuk mengirim pesan harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = ProfileOtherUser.this;
                super();
            }
        });
    }

}
