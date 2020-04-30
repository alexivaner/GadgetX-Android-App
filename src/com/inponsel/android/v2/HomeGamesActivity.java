// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.SplashScreen;
import com.inponsel.android.adapter.CustomPagerAdapter;
import com.inponsel.android.adapter.ItemKategoriAppsGames;
import com.inponsel.android.adapter.ListAppsAdapter;
import com.inponsel.android.adapter.ListKategoriAppsAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.AutoScrollViewPager;
import com.inponsel.android.widget.CircleProgressBar;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.nirhart.parallaxscroll.views.ParallaxScrollView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.Header;
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
//            AppsByCategory, RegisterActivity, LoginActivity, RSSFeedByTag, 
//            AppsSelengkap

public class HomeGamesActivity extends SherlockFragmentActivity
    implements Observer, com.nirhart.parallaxscroll.views.ParallaxScrollView.ScrollViewListener, android.view.animation.Animation.AnimationListener
{
    public class RSSAsycTask extends AsyncTask
    {

        final HomeGamesActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Log.e("RSSAsycTask", "onPreExecute");
        }

        public RSSAsycTask()
        {
            this$0 = HomeGamesActivity.this;
            super();
        }
    }


    long ANIM_VIEWPAGER_DELAY;
    ActionBar actionBar;
    int actionBarTitleId;
    int ads_count;
    Animation animMove;
    Animation animMove2;
    ArrayList array2ListAds;
    ArrayList arrayListAds;
    ArrayList arrayListEditorApps;
    ArrayList arrayListKat1Apps;
    ArrayList arrayListTrendingApps;
    ArrayList arrayListWeekApps;
    String bottom_id;
    Button btn_doodle_action;
    Button btn_head_banner_refresh;
    CircleProgressBar circle_progress_doodle;
    ConnectivityManager cm;
    int countList_rss;
    Cursor cursor;
    CustomPagerAdapter custom2PagerAdapter;
    CustomPagerAdapter customPagerAdapter;
    DatabaseHandler db;
    String email_user;
    String fav_stat;
    float final_height;
    float final_width;
    final Handler handler = new Handler();
    int height;
    RelativeLayout home_menu_news_tips;
    String id_news1;
    ImageView image_news1;
    ImageView img_fav_apps_1;
    ImageView img_hap_artikel;
    ImageView img_head_banner;
    ImageView img_kat_apps_1;
    ImageView img_like_apps_1;
    String img_urlnews1;
    InputMethodManager imm;
    boolean is_kategori_apps;
    String jum_komen;
    int limit;
    ExpandableHeightGridView listApps;
    ListAppsAdapter listAppsEditorAdapter;
    ExpandableHeightGridView listAppsEditorChoice;
    ExpandableHeightGridView listAppsMingguIni;
    ExpandableHeightGridView listAppsTrending;
    ListAppsAdapter listAppsTrendingAdapter;
    ListAppsAdapter listAppsWeekAdapter;
    ListKategoriAppsAdapter listKatAppsAdapter;
    LinearLayout listKategoriAdsApps;
    ExpandableHeightGridView listKategoriApps;
    LinearLayout ll_fav_apps;
    LinearLayout ll_hap_adv_top;
    LinearLayout ll_kat_apps_1;
    LinearLayout ll_segmen_1;
    LinearLayout ll_segmen_2;
    LinearLayout ll_segmen_3;
    LinearLayout ll_segmen_4;
    private ArrayList mArrayListRSSData;
    String message;
    String nama_asli;
    NotificationLikeHelper notificationLikeHelper;
    DisplayImageOptions optionsDoodle;
    int page_counter;
    PonselBaseApp ponselBaseApp;
    int position1;
    int position2;
    int position3;
    int position4;
    String prev_bottom_id;
    CircularProgressBar progbar_apps;
    CircularProgressBar progbar_appseditor;
    CircularProgressBar progbar_appstrending;
    CircularProgressBar progbar_appsweek;
    CircularProgressBar progbar_katpilihan;
    CircularProgressBar progressbar_segmen1;
    CircularProgressBar progressbar_segmen2;
    CircularProgressBar progressbar_segmen3;
    CircularProgressBar progressbar_segmen4;
    CircularProgressBar progressbar_viewpager_2_ads;
    CircularProgressBar progressbar_viewpager_head_news;
    RelativeLayout rl_background_headnews;
    RelativeLayout rl_campaign_text;
    RelativeLayout rl_head_banner;
    LinearLayout rl_like_apps;
    LinearLayout rl_more_editorapps;
    RelativeLayout rl_more_weekapps;
    RelativeLayout rl_root_news;
    RelativeLayout rl_slideshow_2_ads;
    RelativeLayout rl_slideshow_ads;
    RelativeLayout rl_slideshow_head_news;
    int scroll_count;
    boolean stopSliding2Ads;
    boolean stopSlidingAds;
    boolean stopSlidingHeadNews;
    String strKonekStat;
    String str_doodle_action;
    String str_doodle_height;
    String str_doodle_img;
    String str_doodle_subtitle;
    String str_doodle_text_action;
    String str_doodle_title;
    String str_doodle_url;
    String str_doodle_width;
    String str_trending_date;
    String succesStat;
    ParallaxScrollView sv_root;
    String t;
    Timer timer1;
    Timer timer2;
    Timer timer3;
    Timer timer4;
    TimerTask timerTask1;
    TimerTask timerTask2;
    TimerTask timerTask3;
    TimerTask timerTask4;
    String title_news1;
    String top_id;
    String tot_LikePon;
    String totdis_LikePon;
    TextView txt_apps_populer;
    TextView txt_apps_week;
    TextView txt_desc_week;
    TextView txt_doodle_subtitle;
    TextView txt_doodle_title;
    TextView txt_echoice_subs;
    TextView txt_editor_choice;
    TextView txt_fav_kat_apps_1;
    TextView txt_hap_more;
    TextView txt_hap_more_editor;
    TextView txt_home_inponsel;
    TextView txt_id_applist;
    TextView txt_judul_news;
    TextView txt_kat_apps_1;
    TextView txt_like_kat_apps_1;
    TextView txt_news_tips;
    TextView txt_populer_subs;
    TextView txt_sub_kat_apps_1;
    TextView txt_trending_date;
    String url2Ads;
    String urlAds;
    String urlHeadline;
    String urlKategori;
    String urlKategori2;
    private boolean useLogo;
    UserFunctions userFunctions;
    String user_id;
    String user_jekel;
    String user_joindate;
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
    private AutoScrollViewPager view_pager_2_ads;
    private AutoScrollViewPager view_pager_ads;
    int width;
    ContextThemeWrapper wrapperLight;

    public HomeGamesActivity()
    {
        scroll_count = 1;
        urlKategori = "";
        urlKategori2 = "";
        arrayListKat1Apps = null;
        str_trending_date = "";
        arrayListWeekApps = null;
        arrayListEditorApps = null;
        arrayListTrendingApps = null;
        width = 1024;
        height = 600;
        is_kategori_apps = false;
        bottom_id = "";
        prev_bottom_id = "";
        str_doodle_width = "1024";
        str_doodle_height = "600";
        ads_count = 0;
        stopSlidingHeadNews = false;
        ANIM_VIEWPAGER_DELAY = 5000L;
        urlHeadline = "";
        arrayListAds = null;
        stopSlidingAds = false;
        urlAds = "";
        stopSliding2Ads = false;
        url2Ads = "";
        limit = 0;
        page_counter = 1;
        countList_rss = 1;
        top_id = "0";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        strKonekStat = "";
        array2ListAds = null;
        fav_stat = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
        position1 = 0;
        position2 = 0;
        position3 = 0;
        position4 = 0;
    }

    private void load_image_doodle()
    {
        try
        {
            ImageLoader.getInstance().displayImage(str_doodle_img, img_head_banner, optionsDoodle, new SimpleImageLoadingListener() {

                final HomeGamesActivity this$0;

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    FadeInBitmapDisplayer.animate(img_head_banner, 500);
                    circle_progress_doodle.setVisibility(8);
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    circle_progress_doodle.setVisibility(8);
                    btn_head_banner_refresh.setVisibility(0);
                    btn_head_banner_refresh.setOnClickListener(new android.view.View.OnClickListener() {

                        final _cls20 this$1;

                        public void onClick(View view)
                        {
                            load_image_doodle();
                        }

            
            {
                this$1 = _cls20.this;
                super();
            }
                    });
                }

                public void onLoadingStarted(String s, View view)
                {
                    circle_progress_doodle.setProgress(0.0F);
                    circle_progress_doodle.setVisibility(0);
                    btn_head_banner_refresh.setVisibility(8);
                }


            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
            }, new ImageLoadingProgressListener() {

                final HomeGamesActivity this$0;

                public void onProgressUpdate(String s, View view, int i, int j)
                {
                    circle_progress_doodle.setProgress(Math.round((100F * (float)i) / (float)j));
                }

            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
            });
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void load_segmen_1()
    {
        sendRequestHeadNews();
        String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_head_banner").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&page=3").toString();
        (new AsyncHttpClient()).get(s, new AsyncHttpResponseHandler() {

            final HomeGamesActivity this$0;

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
                float f;
                float f1;
                float f2;
                aheader = new String(abyte0);
                try
                {
                    aheader = new JSONObject(aheader);
                    if (aheader.getString("success").equals("0"))
                    {
                        rl_head_banner.setVisibility(8);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Header aheader[])
                {
                    aheader.printStackTrace();
                    return;
                }
                aheader = aheader.getJSONArray("InPonsel");
                i = 0;
_L3:
                if (i < aheader.length()) goto _L2; else goto _L1
_L1:
                aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
                abyte0 = new DisplayMetrics();
                aheader.getMetrics(abyte0);
                i = ((DisplayMetrics) (abyte0)).widthPixels;
                f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
                f = (float)Integer.parseInt(str_doodle_width) / f1;
                f1 = (float)Integer.parseInt(str_doodle_height) / f1;
                Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
                f2 = i;
                if (f <= f1)
                {
                    break MISSING_BLOCK_LABEL_548;
                }
                final_width = f2;
                final_height = Math.round((f2 * f1) / f);
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
_L4:
                img_head_banner.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
                if (str_doodle_title.equals("") && str_doodle_subtitle.equals(""))
                {
                    rl_campaign_text.setVisibility(8);
                }
                txt_doodle_subtitle.setText(str_doodle_subtitle);
                txt_doodle_title.setText(str_doodle_title);
                btn_doodle_action.setText(str_doodle_text_action);
                btn_doodle_action.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls14 this$1;

                    public void onClick(View view)
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str_doodle_url)));
                    }

            
            {
                this$1 = _cls14.this;
                super();
            }
                });
                load_image_doodle();
                return;
_L2:
                abyte0 = aheader.getJSONObject(i);
                str_doodle_action = abyte0.getString("action");
                str_doodle_img = abyte0.getString("image");
                str_doodle_subtitle = abyte0.getString("campaign");
                str_doodle_title = abyte0.getString("title");
                str_doodle_url = abyte0.getString("url");
                str_doodle_width = abyte0.getString("width");
                str_doodle_height = abyte0.getString("height");
                str_doodle_text_action = abyte0.getString("text_action");
                i++;
                  goto _L3
                final_width = Math.round((f2 * f1) / f);
                final_height = f2;
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
                  goto _L4
            }


            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
        ll_segmen_1.setVisibility(0);
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("apps_custom").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&cat=apps&pos=7").toString();
        Log.e("urlTrending", s);
        (new AsyncHttpClient()).get(s, new AsyncHttpResponseHandler() {

            final HomeGamesActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
                progbar_appsweek.setVisibility(8);
            }

            public void onStart()
            {
                progbar_appsweek.setVisibility(0);
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                progbar_appsweek.setVisibility(8);
                abyte0 = new JSONObject(aheader);
                aheader = abyte0.getJSONArray("InPonsel");
                str_trending_date = abyte0.getString("date");
                i = 0;
_L3:
                int j = aheader.length();
                if (i < j) goto _L2; else goto _L1
_L1:
                txt_trending_date.setVisibility(0);
                txt_trending_date.setText(str_trending_date);
                listAppsWeekAdapter.notifyDataSetChanged();
                (new Handler()).postDelayed(new Runnable() {

                    final _cls15 this$1;

                    public void run()
                    {
                        sv_root.scrollTo(0, 0);
                    }

            
            {
                this$1 = _cls15.this;
                super();
            }
                }, 1000L);
                return;
_L2:
                Log.e("iLength", String.valueOf(i));
                abyte0 = aheader.getJSONObject(i);
                ListModel listmodel = new ListModel();
                listmodel.setApppackage(abyte0.getString("app_package"));
                listmodel.setAppname(abyte0.getString("app_name"));
                listmodel.setAppcover(abyte0.getString("icon_image"));
                listmodel.setCategory(abyte0.getString("kategori"));
                listmodel.setAvgrate(abyte0.getString("app_rate"));
                listmodel.setBanner_image(abyte0.getString("banner_image"));
                listmodel.setAppsize(abyte0.getString("app_size"));
                listmodel.setDownloadcount(abyte0.getString("app_download"));
                listmodel.setAppurl(abyte0.getString("app_url"));
                arrayListWeekApps.add(listmodel);
                i++;
                  goto _L3
                aheader;
                aheader.printStackTrace();
                  goto _L1
            }


            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
        sendRequestAds();
        sv_root.scrollTo(0, 0);
        (new AsyncHttpClient()).get((new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("apps_custom").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&cat=apps&pos=6").toString(), new AsyncHttpResponseHandler() {

            final HomeGamesActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
                progbar_appstrending.setVisibility(8);
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                progbar_appstrending.setVisibility(0);
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                progbar_appstrending.setVisibility(8);
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                i = 0;
_L3:
                if (i < aheader.length()) goto _L2; else goto _L1
_L1:
                aheader = HomeGamesActivity.this;
                aheader.scroll_count = ((HomeGamesActivity) (aheader)).scroll_count + 1;
_L4:
                listAppsTrendingAdapter.notifyDataSetChanged();
                sv_root.scrollTo(0, 0);
                if (Utility.screen_inch(HomeGamesActivity.this) >= 6D)
                {
                    aheader = HomeGamesActivity.this;
                    aheader.scroll_count = ((HomeGamesActivity) (aheader)).scroll_count + 1;
                    load_segmen_2();
                }
                return;
_L2:
                Log.e("iLength", String.valueOf(i));
                abyte0 = aheader.getJSONObject(i);
                ListModel listmodel = new ListModel();
                listmodel.setApppackage(abyte0.getString("app_package"));
                listmodel.setAppname(abyte0.getString("app_name"));
                listmodel.setAppcover(abyte0.getString("icon_image"));
                listmodel.setCategory(abyte0.getString("kategori"));
                listmodel.setAvgrate(abyte0.getString("app_rate"));
                listmodel.setBanner_image(abyte0.getString("banner_image"));
                listmodel.setAppsize(abyte0.getString("app_size"));
                listmodel.setDownloadcount(abyte0.getString("app_download"));
                listmodel.setAppurl(abyte0.getString("app_url"));
                arrayListTrendingApps.add(listmodel);
                i++;
                  goto _L3
                aheader;
                  goto _L4
            }

            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
        progressbar_segmen1.setVisibility(8);
    }

    private void load_segmen_2()
    {
        Log.e("start", "load_segmen_2");
        ll_segmen_2.setVisibility(0);
        (new AsyncHttpClient()).get((new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("apps_custom").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&cat=apps&pos=8").toString(), new AsyncHttpResponseHandler() {

            final HomeGamesActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
                progbar_appseditor.setVisibility(8);
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                arrayListEditorApps.clear();
                progbar_appseditor.setVisibility(0);
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                progbar_appseditor.setVisibility(8);
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                i = 0;
_L3:
                int j = aheader.length();
                if (i < j) goto _L2; else goto _L1
_L1:
                listAppsEditorAdapter.notifyDataSetChanged();
                return;
_L2:
                Log.e("iLength", String.valueOf(i));
                abyte0 = aheader.getJSONObject(i);
                ListModel listmodel = new ListModel();
                listmodel.setApppackage(abyte0.getString("app_package"));
                listmodel.setAppname(abyte0.getString("app_name"));
                listmodel.setAppcover(abyte0.getString("icon_image"));
                listmodel.setCategory(abyte0.getString("kategori"));
                listmodel.setAvgrate(abyte0.getString("app_rate"));
                listmodel.setBanner_image(abyte0.getString("banner_image"));
                listmodel.setAppsize(abyte0.getString("app_size"));
                listmodel.setDownloadcount(abyte0.getString("app_download"));
                listmodel.setAppurl(abyte0.getString("app_url"));
                arrayListEditorApps.add(listmodel);
                i++;
                  goto _L3
                aheader;
                aheader.printStackTrace();
                  goto _L1
            }

            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
        sendRequest2Ads();
        (new AsyncHttpClient()).get(urlKategori, new AsyncHttpResponseHandler() {

            final HomeGamesActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
                progbar_katpilihan.setVisibility(8);
                is_kategori_apps = false;
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                progbar_katpilihan.setVisibility(0);
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                Log.e("respJson", aheader);
                progbar_katpilihan.setVisibility(8);
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                i = 0;
_L3:
                int j = aheader.length();
                if (i < j) goto _L2; else goto _L1
_L1:
                listKatAppsAdapter.notifyDataSetChanged();
                return;
_L2:
                abyte0 = aheader.getJSONObject(i);
                ListModel listmodel = new ListModel();
                listmodel.setId_apps(abyte0.getString("id"));
                listmodel.setKat_apps_name(abyte0.getString("kategori"));
                listmodel.setKat_apps_desc(abyte0.getString("deskripsi"));
                listmodel.setKat_img_height(abyte0.getString("height"));
                listmodel.setKat_apps_background(abyte0.getString("background"));
                listmodel.setKat_apps_background_img(abyte0.getString("background_img"));
                listmodel.setKat_like_status(abyte0.getString("mystat"));
                listmodel.setKat_fav_status(abyte0.getString("myfav"));
                listmodel.setKat_type(abyte0.getString("type"));
                listmodel.setKat_apps_tag(abyte0.getString("tag"));
                listmodel.setKat_apps_date("mod_date");
                listmodel.setKat_img_width(abyte0.getString("width"));
                listmodel.setKat_img_height(abyte0.getString("height"));
                listmodel.setRatio_h(abyte0.getString("ratioH"));
                listmodel.setRatio_w(abyte0.getString("ratioW"));
                arrayListKat1Apps.add(listmodel);
                i++;
                  goto _L3
                aheader;
                aheader.printStackTrace();
                  goto _L1
            }

            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
        (new AsyncHttpClient()).get(urlKategori2, new AsyncHttpResponseHandler() {

            final HomeGamesActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                is_kategori_apps = false;
                mArrayListRSSData.clear();
                listKategoriAdsApps.removeAllViews();
                page_counter = 1;
            }

            public void onSuccess(int i, Header aheader[], final byte id[])
            {
                aheader = new String(id);
                Log.e("respJson", aheader);
                id = new JSONObject(aheader);
                Log.e("urlKategori2", urlKategori2);
                aheader = id.getJSONArray("InPonsel");
                bottom_id = id.getString("bottom_id");
                succesStat = id.getString("success");
                Log.e("bottom_id", bottom_id);
                if (!succesStat.equals("1")) goto _L2; else goto _L1
_L1:
                i = 0;
_L16:
                int j = aheader.length();
                if (i < j) goto _L3; else goto _L2
_L2:
                if (!succesStat.equals("1")) goto _L5; else goto _L4
_L4:
                i = 0;
_L9:
                if (i >= mArrayListRSSData.size())
                {
                    listKategoriAdsApps.setVisibility(0);
                    is_kategori_apps = true;
                    return;
                }
                aheader = HomeGamesActivity.this;
                aheader.countList_rss = ((HomeGamesActivity) (aheader)).countList_rss + 1;
                aheader = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03013e, null);
                id = aheader.findViewById(0x7f0b0868);
                progbar_apps = (CircularProgressBar)aheader.findViewById(0x7f0b090d);
                listApps = (ExpandableHeightGridView)aheader.findViewById(0x7f0b086a);
                  goto _L6
_L3:
                id = aheader.getJSONObject(i);
                mArrayListRSSData.add(new ItemKategoriAppsGames(id.getString("id"), id.getString("kategori"), id.getString("tag"), id.getString("type"), id.getString("deskripsi"), id.getString("place"), id.getString("position"), id.getString("background"), id.getString("background_img"), id.getString("width"), id.getString("height"), id.getString("myfav"), id.getString("mod_date"), id.getString("total_like"), id.getString("kategori_apps")));
                i++;
                continue; /* Loop/switch isn't completed */
                aheader;
                aheader.printStackTrace();
                strKonekStat = "0";
                  goto _L2
                aheader;
                aheader.printStackTrace();
                  goto _L2
_L6:
                if (!((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getJsonarray().equals("[]")) goto _L8; else goto _L7
_L7:
                Log.e("applist", "applistkosong");
_L13:
                rl_like_apps = (LinearLayout)aheader.findViewById(0x7f0b0865);
                ll_fav_apps = (LinearLayout)aheader.findViewById(0x7f0b0862);
                img_fav_apps_1 = (ImageView)aheader.findViewById(0x7f0b0863);
                txt_id_applist = (TextView)aheader.findViewById(0x7f0b08f0);
                txt_kat_apps_1 = (TextView)aheader.findViewById(0x7f0b0860);
                txt_sub_kat_apps_1 = (TextView)aheader.findViewById(0x7f0b0861);
                txt_like_kat_apps_1 = (TextView)aheader.findViewById(0x7f0b0866);
                txt_fav_kat_apps_1 = (TextView)aheader.findViewById(0x7f0b0864);
                ll_kat_apps_1 = (LinearLayout)aheader.findViewById(0x7f0b0907);
                img_kat_apps_1 = (ImageView)aheader.findViewById(0x7f0b0908);
                img_like_apps_1 = (ImageView)aheader.findViewById(0x7f0b0867);
                id.setVisibility(0);
                Log.e("jsonarray", ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getJsonarray());
                id = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getId();
                final String kategori = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getkategori();
                final String tag = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).gettag();
                Object obj = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).gettype();
                final String deskripsi = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getdeskripsi();
                final String background = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getposition();
                final String background_img = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getplace();
                Log.e("posplace", (new StringBuilder(String.valueOf(background))).append("-").append(background_img).append("-").append(i).toString());
                background = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getbackground();
                background_img = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getbackground_img();
                final String width = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getwidth();
                final String height = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getheight();
                String s = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getmyfav();
                final String mod_date = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getmod_date();
                final String total_like = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).gettotal_like();
                int k;
                if (s.equals("1"))
                {
                    img_fav_apps_1.setBackgroundResource(0x7f020303);
                } else
                {
                    img_fav_apps_1.setBackgroundResource(0x7f020302);
                }
                ll_kat_apps_1.setVisibility(0);
                txt_id_applist.setText(id);
                txt_fav_kat_apps_1.setText(s);
                txt_kat_apps_1.setText(kategori);
                txt_sub_kat_apps_1.setText(deskripsi);
                txt_like_kat_apps_1.setText(total_like);
                listKategoriAdsApps.addView(aheader);
                Log.e("countList_rss", (new StringBuilder("listno")).append(String.valueOf(countList_rss)).toString());
                if (countList_rss == 3)
                {
                    Log.e("mLinearViewAdsFBGoogle", "ads");
                }
                aheader.setOnClickListener(((_cls2) (obj)). new android.view.View.OnClickListener() {

                    final _cls19 this$1;
                    private final String val$background;
                    private final String val$background_img;
                    private final String val$deskripsi;
                    private final String val$height;
                    private final String val$id;
                    private final String val$kategori;
                    private final String val$mod_date;
                    private final String val$tag;
                    private final String val$total_like;
                    private final String val$type;
                    private final String val$width;

                    public void onClick(View view)
                    {
                        view = new Intent(getApplicationContext(), com/inponsel/android/v2/AppsByCategory);
                        view.putExtra("id", id);
                        view.putExtra("kategori", kategori);
                        view.putExtra("tag", tag);
                        view.putExtra("deskripsi", deskripsi);
                        view.putExtra("mod_date", mod_date);
                        view.putExtra("background", background);
                        view.putExtra("background_img", background_img);
                        view.putExtra("total_like", total_like);
                        view.putExtra("mystat", "");
                        view.putExtra("width_img", width);
                        view.putExtra("height_img", height);
                        view.putExtra("type", type);
                        view.putExtra("myfav", txt_fav_kat_apps_1.getText().toString());
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final__pcls19;
                id = s;
                kategori = s1;
                tag = s2;
                deskripsi = s3;
                mod_date = s4;
                background = s5;
                background_img = s6;
                total_like = s7;
                width = s8;
                height = s9;
                type = String.this;
                super();
            }
                });
                ll_fav_apps.setOnClickListener(kategori. new android.view.View.OnClickListener() {

                    final _cls19 this$1;
                    private final String val$id;
                    private final String val$kategori;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(getApplicationContext()))
                        {
                            Log.e("txt_fav_kat_apps_1fav2657", txt_fav_kat_apps_1.getText().toString());
                            if (txt_fav_kat_apps_1.getText().toString().equals("1"))
                            {
                                fav_stat = "0";
                            } else
                            {
                                fav_stat = "1";
                            }
                            view = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("add_fav_applist.php?").append("t=").append(t).append("&id_user=").append(user_id).append("&status=").append(fav_stat).append("&id_kat=").append(id).toString();
                            Log.e("urlPost2657", view);
                            (new AsyncHttpClient()).get(view, id. new AsyncHttpResponseHandler() {

                                final _cls3 this$2;
                                private final String val$id;
                                private final String val$kategori;

                                public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
                                {
                                }

                                public void onRetry(int i)
                                {
                                }

                                public void onStart()
                                {
                                    if (fav_stat.equals("1"))
                                    {
                                        notificationLikeHelper.createNotification(kategori, "Menambahkan ke favorit");
                                        return;
                                    } else
                                    {
                                        notificationLikeHelper.createNotification(kategori, "Menghapus ke favorit");
                                        return;
                                    }
                                }

                                public void onSuccess(int i, Header aheader[], byte abyte0[])
                                {
                                    aheader = new String(abyte0);
                                    Log.e("respJson", aheader);
                                    try
                                    {
                                        aheader = new JSONObject(aheader);
                                        fav_stat = aheader.getString("success");
                                        txt_fav_kat_apps_1.setText(fav_stat);
                                    }
                                    // Misplaced declaration of an exception variable
                                    catch (Header aheader[]) { }
                                    Log.e("fav_stat2725", fav_stat);
                                    if (txt_fav_kat_apps_1.getText().toString().equals("0"))
                                    {
                                        img_fav_apps_1.setBackgroundResource(0x7f020302);
                                    } else
                                    {
                                        img_fav_apps_1.setBackgroundResource(0x7f020303);
                                    }
                                    if (txt_fav_kat_apps_1.getText().toString().equals("1"))
                                    {
                                        notificationLikeHelper.completed(kategori, "Berhasil menambahkan ke favorit");
                                    } else
                                    {
                                        notificationLikeHelper.completed(kategori, "Berhasil menghapus dari favorit");
                                    }
                                    ponselBaseApp.setObserver().setIndexHp(id);
                                    ponselBaseApp.setObserver().setUpdateType("favappsstore");
                                    ponselBaseApp.setObserver().setStatus_like_ponsel(txt_fav_kat_apps_1.getText().toString());
                                }

            
            {
                this$2 = final__pcls3;
                kategori = s;
                id = String.this;
                super();
            }
                            });
                            return;
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(_fld0);
                            view.setMessage("Untuk menambah ke favorit harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final _cls3 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = _cls3.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final _cls3 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                    startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = _cls3.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final _cls3 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = _cls3.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final__pcls19;
                id = s;
                kategori = String.this;
                super();
            }
                });
                i++;
                  goto _L9
_L8:
                kategori = new ArrayList();
                tag = new ListAppsAdapter(HomeGamesActivity.this, 0x7f030137, kategori);
                obj = new JSONArray(new String(((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getJsonarray()));
                Log.e("jsonArray", (new StringBuilder("applist")).append(String.valueOf(((JSONArray) (obj)).length())).toString());
                if (((JSONArray) (obj)).length() == 0) goto _L11; else goto _L10
_L10:
                k = 0;
_L14:
                if (k < ((JSONArray) (obj)).length()) goto _L12; else goto _L11
_L11:
                Log.e("arrayAppsList", (new StringBuilder("arrayAppsList")).append(String.valueOf(kategori.size())).toString());
                listApps.setAdapter(tag);
                listApps.setOnItemClickListener(tag. new android.widget.AdapterView.OnItemClickListener() {

                    final _cls19 this$1;
                    private final ListAppsAdapter val$listAppsAdapter;

                    public void onItemClick(AdapterView adapterview, View view, int i, long l)
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(listAppsAdapter.getListModel(i).getAppurl())));
                    }

            
            {
                this$1 = final__pcls19;
                listAppsAdapter = ListAppsAdapter.this;
                super();
            }
                });
                  goto _L13
                kategori;
                kategori.printStackTrace();
                  goto _L13
_L12:
                deskripsi = ((JSONArray) (obj)).getJSONObject(k);
                Log.e("iLength", (new StringBuilder(String.valueOf(String.valueOf(k)))).append("-").append(deskripsi.getString("app_name")).toString());
                background = new ListModel();
                background.setApppackage(deskripsi.getString("app_package"));
                background.setAppname(deskripsi.getString("app_name"));
                background.setAppcover(deskripsi.getString("icon_image"));
                background.setAvgrate(deskripsi.getString("app_rate"));
                background.setBanner_image(deskripsi.getString("banner_image"));
                background.setAppsize(deskripsi.getString("app_size"));
                background.setDownloadcount(deskripsi.getString("app_download"));
                background.setAppurl(deskripsi.getString("app_url"));
                kategori.add(background);
                k++;
                  goto _L14
_L5:
                is_kategori_apps = false;
                return;
                if (true) goto _L16; else goto _L15
_L15:
            }


            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
        Log.e("urlKategori2", urlKategori2);
        progressbar_segmen2.setVisibility(8);
    }

    private void load_segmen_morekataaps()
    {
        String s = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("list_kategori_ads").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&bottom_id=").append(bottom_id).append("&type=games").toString();
        Log.e("urlKategoriMore", s);
        (new AsyncHttpClient()).get(s, new AsyncHttpResponseHandler() {

            final HomeGamesActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
                progbar_katpilihan.setVisibility(8);
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                mArrayListRSSData.clear();
                is_kategori_apps = false;
                progbar_katpilihan.setVisibility(0);
            }

            public void onSuccess(int i, Header aheader[], final byte id[])
            {
                aheader = new String(id);
                Log.e("respJson", aheader);
                id = new JSONObject(aheader);
                Log.e("urlKategori2", urlKategori2);
                aheader = id.getJSONArray("InPonsel");
                bottom_id = id.getString("bottom_id");
                succesStat = id.getString("success");
                Log.e("bottom_id", bottom_id);
                if (!succesStat.equals("1")) goto _L2; else goto _L1
_L1:
                i = 0;
_L6:
                int j = aheader.length();
                if (i < j) goto _L3; else goto _L2
_L2:
                if (!succesStat.equals("1"))
                {
                    break MISSING_BLOCK_LABEL_1608;
                }
                i = 0;
_L9:
                if (i < mArrayListRSSData.size()) goto _L5; else goto _L4
_L4:
                listKategoriAdsApps.setVisibility(0);
                is_kategori_apps = true;
_L15:
                progbar_katpilihan.setVisibility(8);
                final String kategori;
                final String tag;
                Object obj;
                final String deskripsi;
                final String background;
                final String background_img;
                final String width;
                final String height;
                String s1;
                final String mod_date;
                final String total_like;
                int k;
                if (mArrayListRSSData.size() < 2)
                {
                    txt_home_inponsel.setVisibility(0);
                    is_kategori_apps = false;
                    return;
                } else
                {
                    is_kategori_apps = true;
                    return;
                }
_L3:
                id = aheader.getJSONObject(i);
                mArrayListRSSData.add(new ItemKategoriAppsGames(id.getString("id"), id.getString("kategori"), id.getString("tag"), id.getString("type"), id.getString("deskripsi"), id.getString("place"), id.getString("position"), id.getString("background"), id.getString("background_img"), id.getString("width"), id.getString("height"), id.getString("myfav"), id.getString("mod_date"), id.getString("total_like"), id.getString("kategori_apps")));
                i++;
                  goto _L6
                aheader;
                aheader.printStackTrace();
                strKonekStat = "0";
                  goto _L2
                aheader;
                aheader.printStackTrace();
                  goto _L2
_L5:
                aheader = HomeGamesActivity.this;
                aheader.countList_rss = ((HomeGamesActivity) (aheader)).countList_rss + 1;
                aheader = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03013e, null);
                id = aheader.findViewById(0x7f0b0868);
                progbar_apps = (CircularProgressBar)aheader.findViewById(0x7f0b090d);
                listApps = (ExpandableHeightGridView)aheader.findViewById(0x7f0b086a);
                if (!((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getJsonarray().equals("[]")) goto _L8; else goto _L7
_L7:
                Log.e("applist", "applistkosong");
_L13:
                rl_like_apps = (LinearLayout)aheader.findViewById(0x7f0b0865);
                ll_fav_apps = (LinearLayout)aheader.findViewById(0x7f0b0862);
                img_fav_apps_1 = (ImageView)aheader.findViewById(0x7f0b0863);
                txt_id_applist = (TextView)aheader.findViewById(0x7f0b08f0);
                txt_kat_apps_1 = (TextView)aheader.findViewById(0x7f0b0860);
                txt_sub_kat_apps_1 = (TextView)aheader.findViewById(0x7f0b0861);
                txt_like_kat_apps_1 = (TextView)aheader.findViewById(0x7f0b0866);
                txt_fav_kat_apps_1 = (TextView)aheader.findViewById(0x7f0b0864);
                ll_kat_apps_1 = (LinearLayout)aheader.findViewById(0x7f0b0907);
                img_kat_apps_1 = (ImageView)aheader.findViewById(0x7f0b0908);
                img_like_apps_1 = (ImageView)aheader.findViewById(0x7f0b0867);
                id.setVisibility(0);
                Log.e("jsonarray", ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getJsonarray());
                id = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getId();
                kategori = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getkategori();
                tag = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).gettag();
                obj = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).gettype();
                deskripsi = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getdeskripsi();
                background = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getposition();
                background_img = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getplace();
                Log.e("posplace", (new StringBuilder(String.valueOf(background))).append("-").append(background_img).append("-").append(i).toString());
                background = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getbackground();
                background_img = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getbackground_img();
                width = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getwidth();
                height = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getheight();
                s1 = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getmyfav();
                mod_date = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getmod_date();
                total_like = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).gettotal_like();
                if (s1.equals("1"))
                {
                    img_fav_apps_1.setBackgroundResource(0x7f020303);
                } else
                {
                    img_fav_apps_1.setBackgroundResource(0x7f020302);
                }
                ll_kat_apps_1.setVisibility(0);
                txt_id_applist.setText(id);
                txt_fav_kat_apps_1.setText(s1);
                txt_kat_apps_1.setText(kategori);
                txt_sub_kat_apps_1.setText(deskripsi);
                txt_like_kat_apps_1.setText(total_like);
                listKategoriAdsApps.addView(aheader);
                Log.e("countList_rss", (new StringBuilder("listno")).append(String.valueOf(countList_rss)).toString());
                if (countList_rss != 3)
                {
                    if (countList_rss == 5)
                    {
                        Log.e("mLinearViewAdsFBGoogle2", "ads2");
                    } else
                    if (countList_rss == 7)
                    {
                        Log.e("mLinearViewAdsFBGoogle3", "ads3");
                    }
                }
                aheader.setOnClickListener(((_cls2) (obj)). new android.view.View.OnClickListener() {

                    final _cls13 this$1;
                    private final String val$background;
                    private final String val$background_img;
                    private final String val$deskripsi;
                    private final String val$height;
                    private final String val$id;
                    private final String val$kategori;
                    private final String val$mod_date;
                    private final String val$tag;
                    private final String val$total_like;
                    private final String val$type;
                    private final String val$width;

                    public void onClick(View view)
                    {
                        view = new Intent(getApplicationContext(), com/inponsel/android/v2/AppsByCategory);
                        view.putExtra("id", id);
                        view.putExtra("kategori", kategori);
                        view.putExtra("tag", tag);
                        view.putExtra("deskripsi", deskripsi);
                        view.putExtra("mod_date", mod_date);
                        view.putExtra("background", background);
                        view.putExtra("background_img", background_img);
                        view.putExtra("total_like", total_like);
                        view.putExtra("mystat", "");
                        view.putExtra("width_img", width);
                        view.putExtra("height_img", height);
                        view.putExtra("type", type);
                        view.putExtra("myfav", txt_fav_kat_apps_1.getText().toString());
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final__pcls13;
                id = s;
                kategori = s1;
                tag = s2;
                deskripsi = s3;
                mod_date = s4;
                background = s5;
                background_img = s6;
                total_like = s7;
                width = s8;
                height = s9;
                type = String.this;
                super();
            }
                });
                ll_fav_apps.setOnClickListener(kategori. new android.view.View.OnClickListener() {

                    final _cls13 this$1;
                    private final String val$id;
                    private final String val$kategori;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(getApplicationContext()))
                        {
                            Log.e("txt_fav_kat_apps_1fav2657", txt_fav_kat_apps_1.getText().toString());
                            if (txt_fav_kat_apps_1.getText().toString().equals("1"))
                            {
                                fav_stat = "0";
                            } else
                            {
                                fav_stat = "1";
                            }
                            view = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("add_fav_applist.php?").append("t=").append(t).append("&id_user=").append(user_id).append("&status=").append(fav_stat).append("&id_kat=").append(id).toString();
                            Log.e("urlPost2657", view);
                            (new AsyncHttpClient()).get(view, id. new AsyncHttpResponseHandler() {

                                final _cls3 this$2;
                                private final String val$id;
                                private final String val$kategori;

                                public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
                                {
                                }

                                public void onRetry(int i)
                                {
                                }

                                public void onStart()
                                {
                                    if (fav_stat.equals("1"))
                                    {
                                        notificationLikeHelper.createNotification(kategori, "Menambahkan ke favorit");
                                        return;
                                    } else
                                    {
                                        notificationLikeHelper.createNotification(kategori, "Menghapus ke favorit");
                                        return;
                                    }
                                }

                                public void onSuccess(int i, Header aheader[], byte abyte0[])
                                {
                                    aheader = new String(abyte0);
                                    Log.e("respJson", aheader);
                                    try
                                    {
                                        aheader = new JSONObject(aheader);
                                        fav_stat = aheader.getString("success");
                                        txt_fav_kat_apps_1.setText(fav_stat);
                                    }
                                    // Misplaced declaration of an exception variable
                                    catch (Header aheader[]) { }
                                    Log.e("fav_stat2725", fav_stat);
                                    if (txt_fav_kat_apps_1.getText().toString().equals("0"))
                                    {
                                        img_fav_apps_1.setBackgroundResource(0x7f020302);
                                    } else
                                    {
                                        img_fav_apps_1.setBackgroundResource(0x7f020303);
                                    }
                                    if (txt_fav_kat_apps_1.getText().toString().equals("1"))
                                    {
                                        notificationLikeHelper.completed(kategori, "Berhasil menambahkan ke favorit");
                                    } else
                                    {
                                        notificationLikeHelper.completed(kategori, "Berhasil menghapus dari favorit");
                                    }
                                    ponselBaseApp.setObserver().setIndexHp(id);
                                    ponselBaseApp.setObserver().setUpdateType("favappsstore");
                                    ponselBaseApp.setObserver().setStatus_like_ponsel(txt_fav_kat_apps_1.getText().toString());
                                }

            
            {
                this$2 = final__pcls3;
                kategori = s;
                id = String.this;
                super();
            }
                            });
                            return;
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(_fld0);
                            view.setMessage("Untuk menambah ke favorit harus login terlebih dahulu.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final _cls3 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = _cls3.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final _cls3 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                    startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = _cls3.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final _cls3 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = _cls3.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final__pcls13;
                id = s;
                kategori = String.this;
                super();
            }
                });
                i++;
                  goto _L9
_L8:
                kategori = new ArrayList();
                tag = new ListAppsAdapter(HomeGamesActivity.this, 0x7f030137, kategori);
                obj = new JSONArray(new String(((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getJsonarray()));
                Log.e("jsonArray", (new StringBuilder("applist")).append(String.valueOf(((JSONArray) (obj)).length())).toString());
                if (((JSONArray) (obj)).length() == 0) goto _L11; else goto _L10
_L10:
                k = 0;
_L14:
                if (k < ((JSONArray) (obj)).length()) goto _L12; else goto _L11
_L11:
                Log.e("arrayAppsList", (new StringBuilder("arrayAppsList")).append(String.valueOf(kategori.size())).toString());
                listApps.setAdapter(tag);
                listApps.setOnItemClickListener(tag. new android.widget.AdapterView.OnItemClickListener() {

                    final _cls13 this$1;
                    private final ListAppsAdapter val$listAppsAdapter;

                    public void onItemClick(AdapterView adapterview, View view, int i, long l)
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(listAppsAdapter.getListModel(i).getAppurl())));
                    }

            
            {
                this$1 = final__pcls13;
                listAppsAdapter = ListAppsAdapter.this;
                super();
            }
                });
                  goto _L13
                kategori;
                kategori.printStackTrace();
                  goto _L13
_L12:
                deskripsi = ((JSONArray) (obj)).getJSONObject(k);
                Log.e("iLength", (new StringBuilder(String.valueOf(String.valueOf(k)))).append("-").append(deskripsi.getString("app_name")).toString());
                background = new ListModel();
                background.setApppackage(deskripsi.getString("app_package"));
                background.setAppname(deskripsi.getString("app_name"));
                background.setAppcover(deskripsi.getString("icon_image"));
                background.setAvgrate(deskripsi.getString("app_rate"));
                background.setBanner_image(deskripsi.getString("banner_image"));
                background.setAppsize(deskripsi.getString("app_size"));
                background.setDownloadcount(deskripsi.getString("app_download"));
                background.setAppurl(deskripsi.getString("app_url"));
                kategori.add(background);
                k++;
                  goto _L14
                is_kategori_apps = false;
                  goto _L15
            }


            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
    }

    private void sendRequest2Ads()
    {
        url2Ads = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_ads_home").append(Utility.BASE_FORMAT).append("?hal=50").append("&pver=").append(SplashScreen.curVersion).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=tagall").toString();
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(url2Ads, new AsyncHttpResponseHandler() {

            final HomeGamesActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                array2ListAds.clear();
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                Log.e("responseHeadNews", aheader);
                aheader = new JSONObject(aheader);
                if (aheader.getBoolean("success")) goto _L2; else goto _L1
_L1:
                rl_slideshow_2_ads.setVisibility(8);
_L5:
                Log.e("array2ListAds", String.valueOf(array2ListAds.size()));
                custom2PagerAdapter.notifyDataSetChanged();
                return;
_L2:
                aheader = aheader.getJSONArray("InPonsel");
                i = 0;
_L6:
                if (i < aheader.length()) goto _L4; else goto _L3
_L3:
                float f;
                float f1;
                rl_slideshow_2_ads.setVisibility(0);
                aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
                abyte0 = new DisplayMetrics();
                aheader.getMetrics(abyte0);
                i = ((DisplayMetrics) (abyte0)).widthPixels;
                f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
                f = (float)Integer.parseInt(str_doodle_width) / f1;
                f1 = (float)Integer.parseInt(str_doodle_height) / f1;
                Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
                float f2;
                f2 = i;
                if (f <= f1)
                {
                    break MISSING_BLOCK_LABEL_538;
                }
                final_width = f2;
                final_height = Math.round((f2 * f1) / f);
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
_L7:
                rl_slideshow_2_ads.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)final_width, (int)final_height));
                  goto _L5
                aheader;
                aheader.printStackTrace();
                  goto _L5
_L4:
                abyte0 = aheader.getJSONObject(i);
                ListModel listmodel = new ListModel();
                listmodel.setId_ads(abyte0.getString("id_ads"));
                listmodel.setAds_title(abyte0.getString("ads_title"));
                listmodel.setAds_campaign(abyte0.getString("ads_campaign"));
                listmodel.setAds_cover(abyte0.getString("ads_image"));
                listmodel.setAds_icon(abyte0.getString("logo_pub"));
                listmodel.setAds_type(abyte0.getString("ads_type"));
                listmodel.setAds_link(abyte0.getString("ads_link"));
                listmodel.setAds_method(abyte0.getString("ads_method"));
                listmodel.setAds_title_color(abyte0.getString("ads_title_color"));
                listmodel.setAds_campaign_color(abyte0.getString("ads_campaign_color"));
                listmodel.setAds_back_color(abyte0.getString("ads_back_color"));
                listmodel.setAds_btn_text_color(abyte0.getString("ads_btn_text_color"));
                listmodel.setAds_btn_text_action(abyte0.getString("ads_btn_text_action"));
                array2ListAds.add(listmodel);
                i++;
                  goto _L6
                final_width = Math.round((f2 * f1) / f);
                final_height = f2;
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
                  goto _L7
            }

            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
    }

    private void sendRequestAds()
    {
        urlAds = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_ads_home").append(Utility.BASE_FORMAT).append("?hal=49").append("&pver=").append(SplashScreen.curVersion).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=tagall").toString();
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(urlAds, new AsyncHttpResponseHandler() {

            final HomeGamesActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                arrayListAds.clear();
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                Log.e("responseHeadNews", aheader);
                aheader = new JSONObject(aheader);
                if (aheader.getBoolean("success")) goto _L2; else goto _L1
_L1:
                rl_slideshow_ads.setVisibility(8);
_L5:
                Log.e("arrayListAds", String.valueOf(arrayListAds.size()));
                customPagerAdapter.notifyDataSetChanged();
                return;
_L2:
                aheader = aheader.getJSONArray("InPonsel");
                i = 0;
_L6:
                if (i < aheader.length()) goto _L4; else goto _L3
_L3:
                float f;
                float f1;
                rl_slideshow_ads.setVisibility(0);
                aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
                abyte0 = new DisplayMetrics();
                aheader.getMetrics(abyte0);
                i = ((DisplayMetrics) (abyte0)).widthPixels;
                f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
                f = (float)Integer.parseInt(str_doodle_width) / f1;
                f1 = (float)Integer.parseInt(str_doodle_height) / f1;
                Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
                float f2;
                f2 = i;
                if (f <= f1)
                {
                    break MISSING_BLOCK_LABEL_538;
                }
                final_width = f2;
                final_height = Math.round((f2 * f1) / f);
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
_L7:
                rl_slideshow_ads.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)final_width, (int)final_height));
                  goto _L5
                aheader;
                aheader.printStackTrace();
                  goto _L5
_L4:
                abyte0 = aheader.getJSONObject(i);
                ListModel listmodel = new ListModel();
                listmodel.setId_ads(abyte0.getString("id_ads"));
                listmodel.setAds_title(abyte0.getString("ads_title"));
                listmodel.setAds_campaign(abyte0.getString("ads_campaign"));
                listmodel.setAds_cover(abyte0.getString("ads_image"));
                listmodel.setAds_icon(abyte0.getString("logo_pub"));
                listmodel.setAds_type(abyte0.getString("ads_type"));
                listmodel.setAds_link(abyte0.getString("ads_link"));
                listmodel.setAds_method(abyte0.getString("ads_method"));
                listmodel.setAds_title_color(abyte0.getString("ads_title_color"));
                listmodel.setAds_campaign_color(abyte0.getString("ads_campaign_color"));
                listmodel.setAds_back_color(abyte0.getString("ads_back_color"));
                listmodel.setAds_btn_text_color(abyte0.getString("ads_btn_text_color"));
                listmodel.setAds_btn_text_action(abyte0.getString("ads_btn_text_action"));
                arrayListAds.add(listmodel);
                i++;
                  goto _L6
                final_width = Math.round((f2 * f1) / f);
                final_height = f2;
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
                  goto _L7
            }

            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
    }

    private void sendRequestHeadNews()
    {
        urlHeadline = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_random").append(Utility.BASE_FORMAT).append("?lmt=0&t=").append(t).append("&idusr=").append(user_id).append("&tag=permainan").toString();
        Log.e("urlHeadline", urlHeadline);
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(15, 10000);
        asynchttpclient.get(urlHeadline, new AsyncHttpResponseHandler() {

            final HomeGamesActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                progressbar_viewpager_head_news.setVisibility(0);
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                Log.e("responseHeadNews", aheader);
                rl_root_news = (RelativeLayout)findViewById(0x7f0b0263);
                image_news1 = (ImageView)findViewById(0x7f0b0264);
                txt_judul_news = (TextView)findViewById(0x7f0b0265);
                float f;
                float f1;
                float f2;
                try
                {
                    aheader = (new JSONObject(aheader)).getJSONArray("InPonsel").getJSONObject(0);
                    id_news1 = aheader.getString("rss_id");
                    title_news1 = aheader.getString("rss_title");
                    img_urlnews1 = aheader.getString("rss_img");
                }
                // Misplaced declaration of an exception variable
                catch (Header aheader[])
                {
                    aheader.printStackTrace();
                }
                aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
                abyte0 = new DisplayMetrics();
                aheader.getMetrics(abyte0);
                i = ((DisplayMetrics) (abyte0)).widthPixels;
                f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
                f = (float)Integer.parseInt(str_doodle_width) / f1;
                f1 = (float)Integer.parseInt(str_doodle_height) / f1;
                Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
                f2 = i;
                if (f > f1)
                {
                    final_width = f2;
                    final_height = Math.round((f2 * f1) / f);
                    Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
                } else
                {
                    final_width = Math.round((f2 * f1) / f);
                    final_height = f2;
                    Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
                }
                image_news1.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
                rl_root_news.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
                txt_judul_news.setText(title_news1);
                progressbar_viewpager_head_news.setVisibility(8);
                image_news1.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls10 this$1;

                    public void onClick(View view)
                    {
                        Log.e("judul", String.valueOf(id_news1));
                        view = new Intent();
                        view.setClass(_fld0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                        view.putExtra("id_rss", id_news1);
                        view.putExtra("rss_title", title_news1);
                        view.putExtra("notif", "gcm");
                        view.putExtra("actfrom", "rssfeed");
                        view.putExtra("act", "firsttab");
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls10.this;
                super();
            }
                });
            }


            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
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

    private void updateViewFavApps(String s)
    {
        Log.e("ponselBaseApp", s);
        Log.e("listKategoriAdsGames", String.valueOf(listKategoriAdsApps.getChildCount()));
        int i = 0;
        do
        {
            if (i >= listKategoriAdsApps.getChildCount())
            {
                return;
            }
            Object obj = listKategoriAdsApps.getChildAt(i);
            TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b08f0);
            ImageView imageview = (ImageView)((View) (obj)).findViewById(0x7f0b0863);
            obj = (TextView)((View) (obj)).findViewById(0x7f0b0864);
            Log.e("textindex", (new StringBuilder(String.valueOf(textview.getText().toString()))).append("=").append(s).toString());
            if (textview.getText().toString().equals(s))
            {
                ((TextView) (obj)).setText(ponselBaseApp.getObserver().getStatus_like_ponsel().toString());
                if (ponselBaseApp.getObserver().getStatus_like_ponsel().equals("1"))
                {
                    imageview.setImageResource(0x7f020303);
                } else
                {
                    imageview.setImageResource(0x7f020302);
                }
            }
            i++;
        } while (true);
    }

    public void TimelineTask()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new RSSAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        } else
        {
            (new RSSAsycTask()).execute(new String[0]);
            return;
        }
    }

    public void endScroll()
    {
        Log.e("scroll_count", String.valueOf(scroll_count));
        if (scroll_count == 2)
        {
            scroll_count = scroll_count + 1;
            progressbar_segmen2.setVisibility(0);
            (new Handler()).postDelayed(new Runnable() {

                final HomeGamesActivity this$0;

                public void run()
                {
                    sv_root.scrollBy(0, 100);
                    load_segmen_2();
                }

            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
            }, 1000L);
            return;
        }
        if (is_kategori_apps)
        {
            is_kategori_apps = false;
            Log.e("load", (new StringBuilder(String.valueOf(prev_bottom_id))).append("=").append(bottom_id).toString());
            Log.e("load", "moreapps");
            load_segmen_morekataaps();
            return;
        } else
        {
            Log.e("load", "none");
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

    public void initializeTimerTask(View view, View view1)
    {
    }

    public void onAnimationEnd(Animation animation)
    {
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    public void onBackPressed()
    {
        if (timer1 != null)
        {
            timer1.cancel();
            timer1 = null;
        }
        if (timer2 != null)
        {
            timer2.cancel();
            timer2 = null;
        }
        if (timer3 != null)
        {
            timer3.cancel();
            timer3 = null;
        }
        if (timer4 != null)
        {
            timer4.cancel();
            timer4 = null;
        }
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03012e);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        bundle.setStatusBarTintResource(0x7f0800ab);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7b1fa2")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Games</font>"));
        wrapperLight = new ContextThemeWrapper(this, 0x103006e);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        t = Utility.session(t);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        imm = (InputMethodManager)getSystemService("input_method");
        cm = (ConnectivityManager)getSystemService("connectivity");
        t = Utility.session(t);
        optionsDoodle = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageOnLoading(0x7f02033f).showImageForEmptyUri(0x7f020209).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        circle_progress_doodle = (CircleProgressBar)findViewById(0x7f0b08a1);
        btn_head_banner_refresh = (Button)findViewById(0x7f0b08a0);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        if (userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            DisplayMetrics displaymetrics;
            int i;
            int j;
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
            user_jekel = cursor.getString(9);
            user_ponsel1 = cursor.getString(10);
            user_ponsel2 = cursor.getString(11);
            user_provider1 = cursor.getString(12);
            user_provider2 = cursor.getString(13);
            user_joindate = cursor.getString(14);
            user_profile_update = cursor.getString(15);
            cursor.close();
        }
        animMove = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040014);
        animMove2 = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040015);
        animMove.setAnimationListener(this);
        animMove2.setAnimationListener(this);
        notificationLikeHelper = new NotificationLikeHelper(this);
        listKategoriAdsApps = (LinearLayout)findViewById(0x7f0b06e0);
        mArrayListRSSData = new ArrayList();
        listKategoriApps = (ExpandableHeightGridView)findViewById(0x7f0b086c);
        arrayListKat1Apps = new ArrayList();
        listKatAppsAdapter = new ListKategoriAppsAdapter(this, 0x7f030139, arrayListKat1Apps);
        listKategoriApps.setAdapter(listKatAppsAdapter);
        txt_home_inponsel = (TextView)findViewById(0x7f0b0219);
        bundle = Calendar.getInstance();
        txt_home_inponsel.setText((new StringBuilder("InPonsel @ ")).append(bundle.get(1)).toString());
        txt_home_inponsel.setVisibility(8);
        listAppsMingguIni = (ExpandableHeightGridView)findViewById(0x7f0b0277);
        listAppsMingguIni.setExpanded(true);
        arrayListWeekApps = new ArrayList();
        listAppsWeekAdapter = new ListAppsAdapter(this, 0x7f030137, arrayListWeekApps);
        listAppsMingguIni.setAdapter(listAppsWeekAdapter);
        listAppsEditorChoice = (ExpandableHeightGridView)findViewById(0x7f0b08bf);
        arrayListEditorApps = new ArrayList();
        listAppsEditorAdapter = new ListAppsAdapter(this, 0x7f030137, arrayListEditorApps);
        listAppsEditorChoice.setAdapter(listAppsEditorAdapter);
        txt_trending_date = (TextView)findViewById(0x7f0b08af);
        txt_apps_week = (TextView)findViewById(0x7f0b08b5);
        txt_desc_week = (TextView)findViewById(0x7f0b08b6);
        txt_editor_choice = (TextView)findViewById(0x7f0b08bb);
        txt_echoice_subs = (TextView)findViewById(0x7f0b08bc);
        txt_apps_populer = (TextView)findViewById(0x7f0b08c3);
        txt_populer_subs = (TextView)findViewById(0x7f0b08c4);
        txt_news_tips = (TextView)findViewById(0x7f0b026e);
        txt_news_tips.setText("Artikel games lainnya");
        txt_apps_week.setText("Games minggu ini");
        txt_desc_week.setText("Hot 7 hari terakhir");
        txt_editor_choice.setText("Games pilihan editor");
        txt_echoice_subs.setText("Games pilihan InPonsel");
        txt_apps_populer.setText("Topik games pilihan");
        listAppsTrending = (ExpandableHeightGridView)findViewById(0x7f0b08b2);
        arrayListTrendingApps = new ArrayList();
        listAppsTrendingAdapter = new ListAppsAdapter(this, 0x7f030137, arrayListTrendingApps);
        listAppsTrending.setAdapter(listAppsTrendingAdapter);
        progbar_appsweek = (CircularProgressBar)findViewById(0x7f0b08b8);
        progbar_appseditor = (CircularProgressBar)findViewById(0x7f0b08be);
        progbar_katpilihan = (CircularProgressBar)findViewById(0x7f0b08c5);
        progbar_appstrending = (CircularProgressBar)findViewById(0x7f0b08b1);
        txt_hap_more = (TextView)findViewById(0x7f0b08b7);
        txt_hap_more_editor = (TextView)findViewById(0x7f0b08bd);
        rl_head_banner = (RelativeLayout)findViewById(0x7f0b089f);
        rl_background_headnews = (RelativeLayout)findViewById(0x7f0b08ac);
        rl_background_headnews.setBackgroundResource(0x7f0201bb);
        rl_campaign_text = (RelativeLayout)findViewById(0x7f0b08a2);
        img_head_banner = (ImageView)findViewById(0x7f0b04ca);
        txt_doodle_title = (TextView)findViewById(0x7f0b08a4);
        txt_doodle_subtitle = (TextView)findViewById(0x7f0b08a5);
        btn_doodle_action = (Button)findViewById(0x7f0b08a3);
        progressbar_segmen1 = (CircularProgressBar)findViewById(0x7f0b08ab);
        progressbar_segmen2 = (CircularProgressBar)findViewById(0x7f0b08b9);
        ll_segmen_1 = (LinearLayout)findViewById(0x7f0b021a);
        ll_segmen_2 = (LinearLayout)findViewById(0x7f0b0233);
        ll_segmen_1.setVisibility(8);
        ll_segmen_2.setVisibility(8);
        progressbar_segmen1.setVisibility(8);
        progressbar_segmen2.setVisibility(8);
        sv_root = (ParallaxScrollView)findViewById(0x7f0b089e);
        sv_root.setScrollViewListener(this);
        rl_slideshow_ads = (RelativeLayout)findViewById(0x7f0b01f6);
        rl_slideshow_head_news = (RelativeLayout)findViewById(0x7f0b0261);
        progressbar_viewpager_head_news = (CircularProgressBar)findViewById(0x7f0b0262);
        arrayListAds = new ArrayList();
        view_pager_ads = (AutoScrollViewPager)findViewById(0x7f0b01f8);
        view_pager_ads.setOffscreenPageLimit(5);
        customPagerAdapter = new CustomPagerAdapter(this, arrayListAds, view_pager_ads, sv_root);
        view_pager_ads.setAdapter(customPagerAdapter);
        view_pager_ads.setInterval(5000L);
        view_pager_ads.startAutoScroll();
        rl_slideshow_ads = (RelativeLayout)findViewById(0x7f0b01f6);
        array2ListAds = new ArrayList();
        view_pager_2_ads = (AutoScrollViewPager)findViewById(0x7f0b08c2);
        view_pager_2_ads.setOffscreenPageLimit(5);
        custom2PagerAdapter = new CustomPagerAdapter(this, array2ListAds, view_pager_2_ads, sv_root);
        view_pager_2_ads.setAdapter(custom2PagerAdapter);
        view_pager_2_ads.setInterval(5000L);
        view_pager_2_ads.startAutoScroll();
        rl_slideshow_2_ads = (RelativeLayout)findViewById(0x7f0b08c0);
        progressbar_viewpager_2_ads = (CircularProgressBar)findViewById(0x7f0b08c1);
        home_menu_news_tips = (RelativeLayout)findViewById(0x7f0b026d);
        home_menu_news_tips.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeGamesActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(HomeGamesActivity.this, com/inponsel/android/v2/RSSFeedByTag);
                view.putExtra("tag_code", "0");
                view.putExtra("kategori_tag", "Games");
                view.putExtra("tag_key", "gn:games");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
        bundle = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        displaymetrics = new DisplayMetrics();
        bundle.getMetrics(displaymetrics);
        i = displaymetrics.widthPixels;
        j = displaymetrics.heightPixels;
        img_head_banner.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(i, Math.min((int)(((double)i / (double)Integer.parseInt(str_doodle_width)) * (double)Integer.parseInt(str_doodle_height)), j / 3)));
        rl_more_weekapps = (RelativeLayout)findViewById(0x7f0b08b4);
        rl_more_editorapps = (LinearLayout)findViewById(0x7f0b08ba);
        rl_more_weekapps.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeGamesActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(HomeGamesActivity.this, com/inponsel/android/v2/AppsSelengkap);
                view.putExtra("category", "weekgame");
                view.putExtra("title", "Games Minggu Ini");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
        rl_more_editorapps.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeGamesActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(HomeGamesActivity.this, com/inponsel/android/v2/AppsSelengkap);
                view.putExtra("category", "editorgames");
                view.putExtra("title", "Aplikasi Pilihan Editor");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
        urlKategori = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("list_kategori_games").append(Utility.BASE_FORMAT).append("?t=").append(t).toString();
        Log.e("urlKategori", urlKategori);
        urlKategori2 = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("list_kategori_ads").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&bottom_id=0").append("&type=games").toString();
        load_segmen_1();
        listAppsMingguIni.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeGamesActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(listAppsWeekAdapter.getListModel(k).getAppurl())));
            }

            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
        listAppsTrending.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeGamesActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(listAppsTrendingAdapter.getListModel(k).getAppurl())));
            }

            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
        listAppsEditorChoice.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeGamesActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(listAppsEditorAdapter.getListModel(k).getAppurl())));
            }

            
            {
                this$0 = HomeGamesActivity.this;
                super();
            }
        });
        listKategoriApps.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final HomeGamesActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/AppsByCategory);
                adapterview.putExtra("id", listKatAppsAdapter.getListModel(k).getId_apps());
                adapterview.putExtra("kategori", listKatAppsAdapter.getListModel(k).getKat_apps_name());
                adapterview.putExtra("tag", listKatAppsAdapter.getListModel(k).getKat_apps_tag());
                adapterview.putExtra("deskripsi", listKatAppsAdapter.getListModel(k).getKat_apps_desc());
                adapterview.putExtra("mod_date", listKatAppsAdapter.getListModel(k).getKat_apps_date());
                adapterview.putExtra("background", listKatAppsAdapter.getListModel(k).getKat_apps_background());
                adapterview.putExtra("background_img", listKatAppsAdapter.getListModel(k).getKat_apps_background_img());
                adapterview.putExtra("height", listKatAppsAdapter.getListModel(k).getKat_img_height());
                adapterview.putExtra("mystat", listKatAppsAdapter.getListModel(k).getKat_img_width());
                adapterview.putExtra("myfav", listKatAppsAdapter.getListModel(k).getKat_fav_status());
                adapterview.putExtra("width_img", listKatAppsAdapter.getListModel(k).getKat_img_width());
                adapterview.putExtra("height_img", listKatAppsAdapter.getListModel(k).getKat_img_height());
                adapterview.putExtra("type", listKatAppsAdapter.getListModel(k).getKat_type());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeGamesActivity.this;
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
            finish();
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }

    protected void onRestoreInstanceState(final Bundle position)
    {
        super.onRestoreInstanceState(position);
        position = position.getIntArray("ARTICLE_SCROLL_POSITION");
        if (position != null)
        {
            sv_root.post(new Runnable() {

                final HomeGamesActivity this$0;
                private final int val$position[];

                public void run()
                {
                    sv_root.scrollTo(position[0], position[1]);
                }

            
            {
                this$0 = HomeGamesActivity.this;
                position = ai;
                super();
            }
            });
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putIntArray("ARTICLE_SCROLL_POSITION", new int[] {
            sv_root.getScrollX(), sv_root.getScrollY()
        });
    }

    public void onScrollChanged(ParallaxScrollView parallaxscrollview, int i, int j, int k, int l)
    {
        i = parallaxscrollview.getChildAt(parallaxscrollview.getChildCount() - 1).getBottom() - (parallaxscrollview.getHeight() + parallaxscrollview.getScrollY());
        if (i <= 30 && scroll_count == 2)
        {
            progressbar_segmen2.setVisibility(0);
        }
        if (i <= 15)
        {
            Log.e("bottom", "oke");
            endScroll();
        }
    }

    public void runnable(int i)
    {
    }

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getUpdateType().toString().contains("favappsstore"))
        {
            updateViewFavApps(ponselBaseApp.getObserver().getIndexHp());
        }
    }



}
