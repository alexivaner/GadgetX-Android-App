// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.details.SCTerdekatActivity;
import com.inponsel.android.tlforum.ForumHPActivity;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.net.URLDecoder;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity, LoginActivity, RSSFeedByTag, RoomPenggunaHp, 
//            KomentarPonsel, RoomChatActivity, RoomPostArtikel, RoomPostHasilFotoNoCrop, 
//            RoomPostBenchmark, RoomPostPertanyaan

public class ProfilePonselUserActivity extends SherlockFragmentActivity
{
    public class SubsNewsTask extends AsyncTask
    {

        final ProfilePonselUserActivity this$0;

        private void parseJSONSubsNews(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusSubsNews = s.getString("success");
                postMessageSubsNews = s.getString("message");
                jArray = s.getJSONArray("InPonsel");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                query = (new StringBuilder("idhp=")).append(id_hp_1).append("&idusr=").append(user_id).append("&stat=").append(statSubNews).append("&t=").append(t).toString();
                pushURL = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(query).toString();
                Log.e("pushURL", pushURL);
                avoid = HttpPush.getResponse(pushURL);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(query).toString());
                res = avoid.toString();
                Log.e("url ", res);
                parseJSONSubsNews(res);
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
            if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
            {
                Toast.makeText(ProfilePonselUserActivity.this, postMessageSubsNews, 1).show();
                if (statSubNews.equals("1"))
                {
                    if (sdk < 16)
                    {
                        detail_favoritenews.setBackgroundDrawable(drwKurang);
                    } else
                    {
                        detail_favoritenews.setBackground(drwKurang);
                    }
                } else
                if (sdk < 16)
                {
                    detail_favoritenews.setBackgroundDrawable(drw);
                } else
                {
                    detail_favoritenews.setBackground(drw);
                }
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(ProfilePonselUserActivity.this, postMessageSubsNews, 1).show();
                if (statSubNews.equals("1"))
                {
                    if (sdk < 16)
                    {
                        detail_favoritenews.setBackgroundDrawable(drwKurang);
                    } else
                    {
                        detail_favoritenews.setBackground(drwKurang);
                    }
                } else
                if (sdk < 16)
                {
                    detail_favoritenews.setBackgroundDrawable(drw);
                } else
                {
                    detail_favoritenews.setBackground(drw);
                }
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            } else
            {
                Toast.makeText(ProfilePonselUserActivity.this, postMessageSubsNews, 1).show();
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statSubNews.equals("1"))
            {
                mDialog = ProgressDialog.show(ProfilePonselUserActivity.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(ProfilePonselUserActivity.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public SubsNewsTask()
        {
            this$0 = ProfilePonselUserActivity.this;
            super();
        }
    }


    ActionBar actionBar;
    int actionBarTitleId;
    String code_hp_1;
    String code_hp_2;
    Cursor cursor;
    DatabaseHandler db;
    ImageView detail_favoritenews;
    Drawable drw;
    Drawable drwKurang;
    String email_user;
    Bundle extras;
    String gambar_hp_1;
    String gambar_hp_2;
    String id_hp_1;
    String id_hp_2;
    String id_merk_1;
    String id_merk_2;
    ImageView imgHp;
    ImageView imgHpBackground;
    JSONArray jArray;
    LinearLayout ll_ppu_Chatroom;
    LinearLayout ll_ppu_Forum;
    LinearLayout ll_ppu_ikhtisar;
    LinearLayout ll_ppu_komentar;
    LinearLayout ll_ppu_news;
    LinearLayout ll_ppu_pengguna;
    LinearLayout ll_ppu_postForum;
    LinearLayout ll_ppu_sc;
    ProgressDialog mDialog;
    String merk_1;
    String merk_2;
    String model_1;
    String model_2;
    String nama_asli;
    String nama_hp_1;
    String nama_hp_2;
    String postMessageSubsNews;
    String postStatusSubsNews;
    ProgressBar progressbar_item;
    String pushURL;
    String query;
    String res;
    int sdk;
    String stat;
    String statSubNews;
    String str_img_banner;
    String t;
    String tambah_artikel[] = {
        "Topik umum", "Tips & trik", "Hasil foto kamera", "Benchmark", "Aksesori", "Tanya"
    };
    TextView txt_namalengkap;
    TextView txt_ppu_ikhtisar;
    String urlProfile;
    private boolean useLogo;
    UserFunctions userFunctions;
    String user_id;
    String user_jekel;
    String user_joindate;
    String user_kecamatan;
    String user_kota;
    String user_photo;
    String user_ponsel1;
    String user_ponsel2;
    String user_profile_update;
    String user_provider1;
    String user_provider2;
    String user_provinsi;
    String user_ttl;
    String username;

    public ProfilePonselUserActivity()
    {
        sdk = android.os.Build.VERSION.SDK_INT;
        user_id = "";
        user_photo = "";
        username = "";
        nama_asli = "";
        email_user = "";
        user_ttl = "";
        user_kota = "";
        user_kecamatan = "";
        user_provinsi = "";
        user_jekel = "";
        user_ponsel1 = "";
        user_ponsel2 = "";
        user_provider1 = "";
        user_provider2 = "";
        user_joindate = "";
        user_profile_update = "";
        id_merk_1 = "";
        id_merk_2 = "";
        merk_1 = "";
        merk_2 = "";
        model_1 = "";
        model_2 = "";
        id_hp_1 = "";
        id_hp_2 = "";
        nama_hp_1 = "";
        nama_hp_2 = "";
        code_hp_1 = "";
        code_hp_2 = "";
        gambar_hp_1 = "";
        gambar_hp_2 = "";
        str_img_banner = "";
        statSubNews = "";
        t = Utility.session(RestClient.pelihara);
        urlProfile = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
    }

    private void OnlineStatGroup(String s, String s1, String s2, String s3, String s4)
    {
        Log.e("sendto2", (new StringBuilder("from ")).append(s1).append(" to ").append(code_hp_1).toString());
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("online_status_group").append(Utility.BASE_FORMAT).append("?id_user=").append(s).append("&id_conv=").append(code_hp_1).append("&stat=").append(s2).append("&t=").append(s3).toString();
        Log.e("OnlineStatGroup", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final ProfilePonselUserActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                Log.e("responseGroup", jsonobject.toString());
            }

            
            {
                this$0 = ProfilePonselUserActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final ProfilePonselUserActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = ProfilePonselUserActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "jobj_req");
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
        setContentView(0x7f0300f7);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        t = Utility.session(t);
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
        extras = getIntent().getExtras();
        nama_hp_1 = extras.getString("namalengkap");
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        t = Utility.session(t);
        if (userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
            nama_asli = cursor.getString(2);
            username = cursor.getString(4);
            email_user = cursor.getString(5);
            user_ttl = cursor.getString(6);
            user_provinsi = cursor.getString(7);
            user_kota = cursor.getString(8);
            user_kecamatan = cursor.getString(cursor.getColumnIndex("user_kecamatan"));
            user_jekel = cursor.getString(9);
            user_ponsel1 = cursor.getString(10);
            user_ponsel2 = cursor.getString(11);
            user_provider1 = cursor.getString(12);
            user_provider2 = cursor.getString(13);
            user_joindate = cursor.getString(14);
            user_profile_update = cursor.getString(15);
            cursor.close();
        }
        if (Resources.getSystem().getIdentifier("action_bar_title", "id", "android") != 0);
        getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>")).append(user_ponsel1).append("</font>").toString()));
        progressbar_item = (ProgressBar)findViewById(0x7f0b00b3);
        imgHp = (ImageView)findViewById(0x7f0b023d);
        imgHpBackground = (ImageView)findViewById(0x7f0b0726);
        txt_namalengkap = (TextView)findViewById(0x7f0b049b);
        txt_ppu_ikhtisar = (TextView)findViewById(0x7f0b072a);
        ll_ppu_ikhtisar = (LinearLayout)findViewById(0x7f0b0728);
        ll_ppu_news = (LinearLayout)findViewById(0x7f0b072b);
        ll_ppu_sc = (LinearLayout)findViewById(0x7f0b072e);
        ll_ppu_pengguna = (LinearLayout)findViewById(0x7f0b0731);
        ll_ppu_komentar = (LinearLayout)findViewById(0x7f0b0734);
        ll_ppu_Chatroom = (LinearLayout)findViewById(0x7f0b0737);
        ll_ppu_Forum = (LinearLayout)findViewById(0x7f0b073a);
        ll_ppu_postForum = (LinearLayout)findViewById(0x7f0b073d);
        detail_favoritenews = (ImageView)findViewById(0x7f0b04b3);
        drw = getResources().getDrawable(0x7f020240);
        drw.setColorFilter(Color.parseColor("#FFFF5722"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        drwKurang = getResources().getDrawable(0x7f0201ea);
        drwKurang.setColorFilter(Color.parseColor("#FFFF5722"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        urlProfile = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_ponsel_sc").append(Utility.BASE_FORMAT).append("?id_user=").append(user_id).append("&t=").append(t).toString();
        txt_namalengkap.setText(user_ponsel1);
        txt_ppu_ikhtisar.setText((new StringBuilder("All about ")).append(user_ponsel1).toString());
        detail_favoritenews.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfilePonselUserActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(ProfilePonselUserActivity.this))
                {
                    if (statSubNews.equals("1"))
                    {
                        view = new android.app.AlertDialog.Builder(ProfilePonselUserActivity.this);
                        view.setMessage("Hentikan langganan berita perangkat ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls1 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                                statSubNews = "0";
                                (new SubsNewsTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

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
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(ProfilePonselUserActivity.this);
                        view.setMessage("Langganan berita perangkat ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls1 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statSubNews = "1";
                                (new SubsNewsTask()).execute(new Void[0]);
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                        view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

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
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(ProfilePonselUserActivity.this);
                    view.setMessage("Untuk berlangganan berita, diharuskan login.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

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
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = ProfilePonselUserActivity.this;
                super();
            }
        });
        bundle = new AsyncHttpClient();
        bundle.setMaxRetriesAndTimeout(5, 15000);
        bundle.get(urlProfile, new AsyncHttpResponseHandler() {

            final ProfilePonselUserActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                abyte0 = new JSONObject(new String(abyte0));
                aheader = abyte0.getJSONArray("InPonsel");
                str_img_banner = abyte0.getString("img_banner");
                i = 0;
_L3:
                int j = aheader.length();
                if (i < j) goto _L2; else goto _L1
_L1:
                Log.e("gambar_hp_1", gambar_hp_1);
                if (statSubNews.equals("1"))
                {
                    if (sdk < 16)
                    {
                        detail_favoritenews.setBackgroundDrawable(drwKurang);
                    } else
                    {
                        detail_favoritenews.setBackground(drwKurang);
                    }
                } else
                if (sdk < 16)
                {
                    detail_favoritenews.setBackgroundDrawable(drw);
                } else
                {
                    detail_favoritenews.setBackground(drw);
                }
                ll_ppu_ikhtisar.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls2 this$1;

                    public void onClick(View view)
                    {
                        view = new Intent(_fld0, com/inponsel/android/details/DetailsPonsel);
                        view.putExtra("id_hph", id_hp_1);
                        view.putExtra("namalengkap", nama_hp_1);
                        view.putExtra("codename", code_hp_1);
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
                this$1 = _cls2.this;
                super();
            }
                });
                ll_ppu_news.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls2 this$1;

                    public void onClick(View view)
                    {
                        view = new Intent(_fld0, com/inponsel/android/v2/RSSFeedByTag);
                        view.putExtra("tag_code", "5");
                        view.putExtra("tag_key", (new StringBuilder("hp:")).append(id_hp_1).toString());
                        view.putExtra("kategori_tag", nama_hp_1);
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                ll_ppu_sc.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls2 this$1;

                    public void onClick(View view)
                    {
                        view = new Intent(_fld0, com/inponsel/android/details/SCTerdekatActivity);
                        view.putExtra("id_merk", id_merk_1);
                        view.putExtra("titlemerek", merk_1);
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                ll_ppu_pengguna.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls2 this$1;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(_fld0))
                        {
                            view = new Intent(_fld0, com/inponsel/android/v2/RoomPenggunaHp);
                            view.putExtra("kota", "");
                            view.putExtra("kota_id", "");
                            view.putExtra("prov", "");
                            view.putExtra("merk", merk_1);
                            view.putExtra("model", model_1);
                            view.putExtra("codename", code_hp_1);
                            startActivityForResult(view, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                ll_ppu_komentar.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls2 this$1;

                    public void onClick(View view)
                    {
                        view = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarPonsel);
                        view.putExtra("id_hph", id_hp_1);
                        view.putExtra("namalengkap", nama_hp_1);
                        view.putExtra("codename", code_hp_1);
                        view.putExtra("model", model_1);
                        view.putExtra("merk", merk_1);
                        view.putExtra("gambar", "");
                        view.putExtra("tot_komen", "");
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                ll_ppu_Chatroom.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls2 this$1;

                    public void onClick(View view)
                    {
                        view = new Intent(_fld0, com/inponsel/android/v2/RoomChatActivity);
                        view.putExtra("id_from", user_id);
                        view.putExtra("from_name", username);
                        view.putExtra("from_photo", user_photo);
                        view.putExtra("to_photo", gambar_hp_1);
                        view.putExtra("merk", merk_1);
                        view.putExtra("model", model_1);
                        view.putExtra("codename", (new StringBuilder(String.valueOf(code_hp_1))).append("-").append(code_hp_1).toString());
                        view.putExtra("id_hph", id_hp_1);
                        OnlineStatGroup(user_id, code_hp_1, "1", t, "");
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                ll_ppu_Forum.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls2 this$1;

                    public void onClick(View view)
                    {
                        view = new Intent(_fld0, com/inponsel/android/tlforum/ForumHPActivity);
                        view.putExtra("id_hph", id_hp_1);
                        view.putExtra("namalengkap", nama_hp_1);
                        view.putExtra("codename", code_hp_1);
                        view.putExtra("model", model_1);
                        view.putExtra("merk", merk_1);
                        view.putExtra("gambar", gambar_hp_1);
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                ll_ppu_postForum.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls2 this$1;

                    public void onClick(View view)
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle(URLDecoder.decode((new StringBuilder("Kirim Konten ")).append(merk_1).append(" ").append(model_1).toString()));
                        view.setItems(tambah_artikel, new android.content.DialogInterface.OnClickListener() {

                            final _cls8 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                i;
                                JVM INSTR tableswitch 0 5: default 40
                            //                                           0 47
                            //                                           1 258
                            //                                           2 469
                            //                                           3 662
                            //                                           4 855
                            //                                           5 1066;
                                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
                                dialoginterface.dismiss();
                                return;
_L2:
                                Intent intent = new Intent(_fld0, com/inponsel/android/v2/RoomPostArtikel);
                                intent.putExtra("action", "post");
                                intent.putExtra("id_hph", id_hp_1);
                                intent.putExtra("namalengkap", nama_hp_1);
                                intent.putExtra("codename", code_hp_1);
                                intent.putExtra("model", model_1);
                                intent.putExtra("merk", merk_1);
                                intent.putExtra("gambar", gambar_hp_1);
                                intent.putExtra("from", "apps");
                                intent.putExtra("tl_type", "artikel");
                                intent.putExtra("tl_tag", "umum");
                                startActivityForResult(intent, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                                continue; /* Loop/switch isn't completed */
_L3:
                                Intent intent1 = new Intent(_fld0, com/inponsel/android/v2/RoomPostArtikel);
                                intent1.putExtra("action", "post");
                                intent1.putExtra("id_hph", id_hp_1);
                                intent1.putExtra("namalengkap", nama_hp_1);
                                intent1.putExtra("codename", code_hp_1);
                                intent1.putExtra("model", model_1);
                                intent1.putExtra("merk", merk_1);
                                intent1.putExtra("gambar", gambar_hp_1);
                                intent1.putExtra("from", "apps");
                                intent1.putExtra("tl_type", "artikel");
                                intent1.putExtra("tl_tag", "tips");
                                startActivityForResult(intent1, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                                continue; /* Loop/switch isn't completed */
_L4:
                                Intent intent2 = new Intent(_fld0, com/inponsel/android/v2/RoomPostHasilFotoNoCrop);
                                intent2.putExtra("id_hph", id_hp_1);
                                intent2.putExtra("namalengkap", nama_hp_1);
                                intent2.putExtra("codename", code_hp_1);
                                intent2.putExtra("model", model_1);
                                intent2.putExtra("merk", merk_1);
                                intent2.putExtra("gambar", gambar_hp_1);
                                intent2.putExtra("from", "apps");
                                intent2.putExtra("type", "fotokamera");
                                startActivityForResult(intent2, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                                continue; /* Loop/switch isn't completed */
_L5:
                                Intent intent3 = new Intent(_fld0, com/inponsel/android/v2/RoomPostBenchmark);
                                intent3.putExtra("id_hph", id_hp_1);
                                intent3.putExtra("namalengkap", nama_hp_1);
                                intent3.putExtra("codename", code_hp_1);
                                intent3.putExtra("model", model_1);
                                intent3.putExtra("merk", merk_1);
                                intent3.putExtra("gambar", gambar_hp_1);
                                intent3.putExtra("from", "apps");
                                intent3.putExtra("type", "benchmark");
                                startActivityForResult(intent3, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                                continue; /* Loop/switch isn't completed */
_L6:
                                Intent intent4 = new Intent(_fld0, com/inponsel/android/v2/RoomPostArtikel);
                                intent4.putExtra("action", "post");
                                intent4.putExtra("id_hph", id_hp_1);
                                intent4.putExtra("namalengkap", nama_hp_1);
                                intent4.putExtra("codename", code_hp_1);
                                intent4.putExtra("model", model_1);
                                intent4.putExtra("merk", merk_1);
                                intent4.putExtra("gambar", gambar_hp_1);
                                intent4.putExtra("from", "apps");
                                intent4.putExtra("tl_type", "artikel");
                                intent4.putExtra("tl_tag", "aksesoris");
                                startActivityForResult(intent4, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                                continue; /* Loop/switch isn't completed */
_L7:
                                Intent intent5 = new Intent(_fld0, com/inponsel/android/v2/RoomPostPertanyaan);
                                intent5.putExtra("id_hph", id_hp_1);
                                intent5.putExtra("namalengkap", nama_hp_1);
                                intent5.putExtra("codename", code_hp_1);
                                intent5.putExtra("model", model_1);
                                intent5.putExtra("merk", merk_1);
                                intent5.putExtra("gambar", gambar_hp_1);
                                intent5.putExtra("from", "apps");
                                intent5.putExtra("type", "faqhp");
                                startActivityForResult(intent5, 0);
                                overridePendingTransition(0x7f040003, 0x7f040004);
                                if (true) goto _L1; else goto _L8
_L8:
                            }

            
            {
                this$2 = _cls8.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                Picasso.with(ProfilePonselUserActivity.this).load(gambar_hp_1).into(imgHp, new Callback() {

                    final _cls2 this$1;

                    public void onError()
                    {
                        imgHp.setImageResource(0x7f020297);
                    }

                    public void onSuccess()
                    {
                        imgHp.setVisibility(0);
                        progressbar_item.setVisibility(8);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                Picasso.with(ProfilePonselUserActivity.this).load(str_img_banner).into(imgHpBackground, new Callback() {

                    final _cls2 this$1;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                return;
_L2:
                abyte0 = aheader.getJSONObject(i);
                id_merk_1 = abyte0.getString("id_merk_1");
                id_merk_2 = abyte0.getString("id_merk_2");
                merk_1 = abyte0.getString("merk_1");
                merk_2 = abyte0.getString("merk_2");
                model_1 = abyte0.getString("model_1");
                model_2 = abyte0.getString("model_2");
                id_hp_1 = abyte0.getString("id_hp_1");
                id_hp_2 = abyte0.getString("id_hp_2");
                nama_hp_1 = abyte0.getString("nama_hp_1");
                nama_hp_2 = abyte0.getString("nama_hp_2");
                code_hp_1 = abyte0.getString("code_hp_1");
                code_hp_2 = abyte0.getString("code_hp_2");
                gambar_hp_1 = abyte0.getString("gambar_hp_1");
                gambar_hp_2 = abyte0.getString("gambar_hp_2");
                statSubNews = abyte0.getString("subs_status");
                i++;
                  goto _L3
                aheader;
                aheader.printStackTrace();
                  goto _L1
            }


            
            {
                this$0 = ProfilePonselUserActivity.this;
                super();
            }
        });
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
        if (true) goto _L1; else goto _L3
_L3:
    }

}
