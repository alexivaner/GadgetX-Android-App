// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.dobmob.dobsliding.DobSlidingMenu;
import com.dobmob.dobsliding.events.OnCollapsedListener;
import com.dobmob.dobsliding.events.OnExpandedListener;
import com.dobmob.dobsliding.exceptions.NoActionBarException;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.SplashScreen;
import com.inponsel.android.adapter.CustomNewsPagerAdapter;
import com.inponsel.android.adapter.CustomPagerAdapter;
import com.inponsel.android.adapter.ItemRSS;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.favorit.FavoritArtikelBerita;
import com.inponsel.android.favorit.LanggananBeritaAll;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.AutoScrollViewPager;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.nirhart.parallaxscroll.views.ParallaxScrollView;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
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
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, RSSFeedByTag, RegisterActivity, LoginActivity

public class HomeNewsActivity extends BaseDrawer
    implements android.view.View.OnClickListener, com.nirhart.parallaxscroll.views.ParallaxScrollView.ScrollViewListener, Observer, android.view.animation.Animation.AnimationListener
{
    private class CancelListener
        implements android.content.DialogInterface.OnCancelListener
    {

        AsyncTask cancellableTask;
        final HomeNewsActivity this$0;

        public void onCancel(DialogInterface dialoginterface)
        {
            cancellableTask.cancel(true);
        }

        public CancelListener(AsyncTask asynctask)
        {
            this$0 = HomeNewsActivity.this;
            super();
            cancellableTask = asynctask;
        }
    }

    public class FavoritTask extends AsyncTask
    {

        final HomeNewsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                avoid = (new StringBuilder("idrss=")).append(idkom_pos).append("&idusr=").append(user_id).append("&stat=").append(statFav).append("&t=").append(t).toString();
                String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favrss").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", s);
                s = HttpPush.getResponse(s);
                Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
                resFav = s.toString();
                parseJSONAddFav(resFav);
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
            ponselBaseApp.getObserver().setUpdateType("favrss");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            if (postStatusAddRss.equals("1") || postStatusAddRss.equals("10"))
            {
                if (rss_img.equals(""))
                {
                    db.addRSS(id_rss, rss_portal, rss_img_ava, rss_title, rss_desc, rss_content, "", rss_srclink, rss_date, txtLikeKom.getText().toString(), total_komen, "");
                } else
                {
                    db.addRSS(id_rss, rss_portal, rss_img_ava, rss_title, rss_desc, rss_content, rss_img, rss_srclink, rss_date, txtLikeKom.getText().toString(), total_komen, "");
                }
            } else
            if (postStatusAddRss.equals("00") || postStatusAddRss.equals("0"))
            {
                Toast.makeText(HomeNewsActivity.this, "Berhasil menghapus", 1).show();
                db.deleteIDRSS(id_rss);
            } else
            if (resFav.equals("40404"))
            {
                mDialog.dismiss();
            } else
            {
                Toast.makeText(HomeNewsActivity.this, postMessageAddRss, 1).show();
            }
            mDialog.dismiss();
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statFav.equals("1"))
            {
                mDialog = ProgressDialog.show(HomeNewsActivity.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(HomeNewsActivity.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public FavoritTask()
        {
            this$0 = HomeNewsActivity.this;
            super();
        }
    }

    private class GetSubscribe extends AsyncTask
    {

        final HomeNewsActivity this$0;

        private void setButtonConfig()
        {
            if (str_LangganAndroid.equals("1"))
            {
                str_LangganAndroid = "1";
                btn_LangganAndroid.setText("Hapus");
                btn_LangganAndroid.setBackgroundResource(0x7f02013a);
                Exception exception;
                try
                {
                    btn_LangganAndroid.setTextColor(colorsHapus);
                }
                catch (Exception exception1) { }
            } else
            {
                str_LangganAndroid = "0";
                btn_LangganAndroid.setText("Langganan");
                btn_LangganAndroid.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganAndroid.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganBlackBerry.equals("1"))
            {
                str_LangganBlackBerry = "1";
                btn_LangganBlackBerry.setText("Hapus");
                btn_LangganBlackBerry.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganBlackBerry.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganBlackBerry = "0";
                btn_LangganBlackBerry.setText("Langganan");
                btn_LangganBlackBerry.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganBlackBerry.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganIOS.equals("1"))
            {
                str_LangganIOS = "1";
                btn_LangganIOS.setText("Hapus");
                btn_LangganIOS.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganIOS.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganIOS = "0";
                btn_LangganIOS.setText("Langganan");
                btn_LangganIOS.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganIOS.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganWindowsPhone.equals("1"))
            {
                str_LangganWindowsPhone = "1";
                btn_LangganWindowsPhone.setText("Hapus");
                btn_LangganWindowsPhone.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganWindowsPhone.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganWindowsPhone = "0";
                btn_LangganWindowsPhone.setText("Langganan");
                btn_LangganWindowsPhone.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganWindowsPhone.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganTelkomsel.equals("1"))
            {
                str_LangganTelkomsel = "1";
                btn_LangganTelkomsel.setText("Hapus");
                btn_LangganTelkomsel.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganTelkomsel.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganTelkomsel = "0";
                btn_LangganTelkomsel.setText("Langganan");
                btn_LangganTelkomsel.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganTelkomsel.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganXL.equals("1"))
            {
                str_LangganXL = "1";
                btn_LangganXL.setText("Hapus");
                btn_LangganXL.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganXL.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganXL = "0";
                btn_LangganXL.setText("Langganan");
                btn_LangganXL.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganXL.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganIndosat.equals("1"))
            {
                str_LangganIndosat = "1";
                btn_LangganIndosat.setText("Hapus");
                btn_LangganIndosat.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganIndosat.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganIndosat = "0";
                btn_LangganIndosat.setText("Langganan");
                btn_LangganIndosat.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganIndosat.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganTri.equals("1"))
            {
                str_LangganTri = "1";
                btn_LangganTri.setText("Hapus");
                btn_LangganTri.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganTri.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganTri = "0";
                btn_LangganTri.setText("Langganan");
                btn_LangganTri.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganTri.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganAxis.equals("1"))
            {
                str_LangganAxis = "1";
                btn_LangganAxis.setText("Hapus");
                btn_LangganAxis.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganAxis.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganAxis = "0";
                btn_LangganAxis.setText("Langganan");
                btn_LangganAxis.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganAxis.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganSmartfren.equals("1"))
            {
                str_LangganSmartfren = "1";
                btn_LangganSmartfren.setText("Hapus");
                btn_LangganSmartfren.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganSmartfren.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganSmartfren = "0";
                btn_LangganSmartfren.setText("Langganan");
                btn_LangganSmartfren.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganSmartfren.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganCeria.equals("1"))
            {
                str_LangganCeria = "1";
                btn_LangganCeria.setText("Hapus");
                btn_LangganCeria.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganCeria.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganCeria = "0";
                btn_LangganCeria.setText("Langganan");
                btn_LangganCeria.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganCeria.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganEsia.equals("1"))
            {
                str_LangganEsia = "1";
                btn_LangganEsia.setText("Hapus");
                btn_LangganEsia.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganEsia.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganEsia = "0";
                btn_LangganEsia.setText("Langganan");
                btn_LangganEsia.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganEsia.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganTelkom.equals("1"))
            {
                str_LangganTelkom = "1";
                btn_LangganTelkom.setText("Hapus");
                btn_LangganTelkom.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganTelkom.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganTelkom = "0";
                btn_LangganTelkom.setText("Langganan");
                btn_LangganTelkom.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganTelkom.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganAplikasi.equals("1"))
            {
                str_LangganAplikasi = "1";
                btn_LangganAplikasi.setText("Hapus");
                btn_LangganAplikasi.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganAplikasi.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganAplikasi = "0";
                btn_LangganAplikasi.setText("Langganan");
                btn_LangganAplikasi.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganAplikasi.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganGame.equals("1"))
            {
                str_LangganGame = "1";
                btn_LangganGame.setText("Hapus");
                btn_LangganGame.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganGame.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganGame = "0";
                btn_LangganGame.setText("Langganan");
                btn_LangganGame.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganGame.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganTips.equals("1"))
            {
                str_LangganTips = "1";
                btn_LangganTips.setText("Hapus");
                btn_LangganTips.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganTips.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganTips = "0";
                btn_LangganTips.setText("Langganan");
                btn_LangganTips.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganTips.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganInternet.equals("1"))
            {
                str_LangganInternet = "1";
                btn_LangganInternet.setText("Hapus");
                btn_LangganInternet.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganInternet.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganInternet = "0";
                btn_LangganInternet.setText("Langganan");
                btn_LangganInternet.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganInternet.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganFirmware.equals("1"))
            {
                str_LangganFirmware = "1";
                btn_LangganFirmware.setText("Hapus");
                btn_LangganFirmware.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganFirmware.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganFirmware = "0";
                btn_LangganFirmware.setText("Langganan");
                btn_LangganFirmware.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganFirmware.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganGadget.equals("1"))
            {
                str_LangganGadget = "1";
                btn_LangganGadget.setText("Hapus");
                btn_LangganGadget.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganGadget.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganGadget = "0";
                btn_LangganGadget.setText("Langganan");
                btn_LangganGadget.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganGadget.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganECommerce.equals("1"))
            {
                str_LangganECommerce = "1";
                btn_LangganECommerce.setText("Hapus");
                btn_LangganECommerce.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganECommerce.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganECommerce = "0";
                btn_LangganECommerce.setText("Langganan");
                btn_LangganECommerce.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganECommerce.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganTeknologi.equals("1"))
            {
                str_LangganTeknologi = "1";
                btn_LangganTeknologi.setText("Hapus");
                btn_LangganTeknologi.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganTeknologi.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganTeknologi = "0";
                btn_LangganTeknologi.setText("Langganan");
                btn_LangganTeknologi.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganTeknologi.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganBisnis.equals("1"))
            {
                str_LangganBisnis = "1";
                btn_LangganBisnis.setText("Hapus");
                btn_LangganBisnis.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganBisnis.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganBisnis = "0";
                btn_LangganBisnis.setText("Langganan");
                btn_LangganBisnis.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganBisnis.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganPemerintah.equals("1"))
            {
                str_LangganPemerintah = "1";
                btn_LangganPemerintah.setText("Hapus");
                btn_LangganPemerintah.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganPemerintah.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganPemerintah = "0";
                btn_LangganPemerintah.setText("Langganan");
                btn_LangganPemerintah.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganPemerintah.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganGayaHidup.equals("1"))
            {
                str_LangganGayaHidup = "1";
                btn_LangganGayaHidup.setText("Hapus");
                btn_LangganGayaHidup.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganGayaHidup.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganGayaHidup = "0";
                btn_LangganGayaHidup.setText("Langganan");
                btn_LangganGayaHidup.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganGayaHidup.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganTokoh.equals("1"))
            {
                str_LangganTokoh = "1";
                btn_LangganTokoh.setText("Hapus");
                btn_LangganTokoh.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganTokoh.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganTokoh = "0";
                btn_LangganTokoh.setText("Langganan");
                btn_LangganTokoh.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganTokoh.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganKomunitas.equals("1"))
            {
                str_LangganKomunitas = "1";
                btn_LangganKomunitas.setText("Hapus");
                btn_LangganKomunitas.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganKomunitas.setTextColor(colorsHapus);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            } else
            {
                str_LangganKomunitas = "0";
                btn_LangganKomunitas.setText("Langganan");
                btn_LangganKomunitas.setBackgroundResource(0x7f020137);
                try
                {
                    btn_LangganKomunitas.setTextColor(colorsIkuti);
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception) { }
            }
            if (str_LangganStartup.equals("1"))
            {
                str_LangganStartup = "1";
                btn_LangganStartup.setText("Hapus");
                btn_LangganStartup.setBackgroundResource(0x7f02013a);
                try
                {
                    btn_LangganStartup.setTextColor(colorsHapus);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Exception exception)
                {
                    return;
                }
            }
            str_LangganStartup = "0";
            btn_LangganStartup.setText("Langganan");
            btn_LangganStartup.setBackgroundResource(0x7f020137);
            try
            {
                btn_LangganStartup.setTextColor(colorsIkuti);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                return;
            }
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataSubscribe, 1);
            Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid == null) goto _L2; else goto _L1
_L1:
            avoid = new JSONObject(avoid);
            inponsel = avoid.getJSONArray("InPonsel");
            success = avoid.getString("success");
            stat = avoid.getString("stat");
            Log.e("success", success);
            if (!success.equals("1")) goto _L4; else goto _L3
_L3:
            int i = 0;
_L60:
            if (i < inponsel.length()) goto _L5; else goto _L4
_L5:
            avoid = inponsel.getJSONObject(i);
            if (!avoid.getString("type").equals("os") || !avoid.getString("id_subs").equals("2")) goto _L7; else goto _L6
_L6:
            str_LangganAndroid = avoid.getString("status");
              goto _L8
_L7:
            if (!avoid.getString("type").equals("os") || !avoid.getString("id_subs").equals("4")) goto _L10; else goto _L9
_L9:
            str_LangganBlackBerry = avoid.getString("status");
              goto _L8
            avoid;
            avoid.printStackTrace();
              goto _L4
_L10:
            if (!avoid.getString("type").equals("os") || !avoid.getString("id_subs").equals("5")) goto _L12; else goto _L11
_L11:
            str_LangganIOS = avoid.getString("status");
              goto _L8
            avoid;
            avoid.printStackTrace();
              goto _L4
_L12:
            if (!avoid.getString("type").equals("os") || !avoid.getString("id_subs").equals("14")) goto _L14; else goto _L13
_L13:
            str_LangganWindowsPhone = avoid.getString("status");
              goto _L8
_L14:
            if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("1")) goto _L16; else goto _L15
_L15:
            str_LangganAxis = avoid.getString("status");
              goto _L8
_L16:
            if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("2")) goto _L18; else goto _L17
_L17:
            str_LangganEsia = avoid.getString("status");
              goto _L8
_L18:
            if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("3")) goto _L20; else goto _L19
_L19:
            str_LangganCeria = avoid.getString("status");
              goto _L8
_L20:
            if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("4")) goto _L22; else goto _L21
_L21:
            str_LangganIndosat = avoid.getString("status");
              goto _L8
_L22:
            if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("5")) goto _L24; else goto _L23
_L23:
            str_LangganSmartfren = avoid.getString("status");
              goto _L8
_L24:
            if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("6")) goto _L26; else goto _L25
_L25:
            str_LangganTelkom = avoid.getString("status");
              goto _L8
_L26:
            if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("7")) goto _L28; else goto _L27
_L27:
            str_LangganTelkomsel = avoid.getString("status");
              goto _L8
_L28:
            if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("8")) goto _L30; else goto _L29
_L29:
            str_LangganTri = avoid.getString("status");
              goto _L8
_L30:
            if (!avoid.getString("type").equals("op") || !avoid.getString("id_subs").equals("9")) goto _L32; else goto _L31
_L31:
            str_LangganXL = avoid.getString("status");
              goto _L8
_L32:
            if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("teknoscience")) goto _L34; else goto _L33
_L33:
            str_LangganTeknologi = avoid.getString("status");
              goto _L8
_L34:
            if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("inetsocmed")) goto _L36; else goto _L35
_L35:
            str_LangganInternet = avoid.getString("status");
              goto _L8
_L36:
            if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("appgame")) goto _L38; else goto _L37
_L37:
            str_LangganAplikasi = avoid.getString("status");
              goto _L8
_L38:
            if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("permainan")) goto _L40; else goto _L39
_L39:
            str_LangganGame = avoid.getString("status");
              goto _L8
_L40:
            if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("firmware")) goto _L42; else goto _L41
_L41:
            str_LangganFirmware = avoid.getString("status");
              goto _L8
_L42:
            if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("bisniscorporate")) goto _L44; else goto _L43
_L43:
            str_LangganBisnis = avoid.getString("status");
              goto _L8
_L44:
            if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("pemerintah")) goto _L46; else goto _L45
_L45:
            str_LangganPemerintah = avoid.getString("status");
              goto _L8
_L46:
            if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("gayahidup")) goto _L48; else goto _L47
_L47:
            str_LangganGayaHidup = avoid.getString("status");
              goto _L8
_L48:
            if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("ecommerce")) goto _L50; else goto _L49
_L49:
            str_LangganECommerce = avoid.getString("status");
              goto _L8
_L50:
            if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("gadget")) goto _L52; else goto _L51
_L51:
            str_LangganGadget = avoid.getString("status");
              goto _L8
_L52:
            if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("tipstrik")) goto _L54; else goto _L53
_L53:
            str_LangganTips = avoid.getString("status");
              goto _L8
_L54:
            if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("tokomstartup")) goto _L56; else goto _L55
_L55:
            str_LangganTokoh = avoid.getString("status");
              goto _L8
_L56:
            if (!avoid.getString("type").equals("general") || !avoid.getString("id_subs").equals("komunitas")) goto _L58; else goto _L57
_L57:
            str_LangganKomunitas = avoid.getString("status");
              goto _L8
_L58:
            if (avoid.getString("type").equals("general") && avoid.getString("id_subs").equals("start_up"))
            {
                str_LangganStartup = avoid.getString("status");
            }
              goto _L8
_L2:
            Log.e("ServiceHandlerPen", "Couldn't get any data from the url");
_L4:
            return null;
_L8:
            i++;
            if (true) goto _L60; else goto _L59
_L59:
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
                setButtonConfig();
                slidingView.findViewById(0x7f0b05db).setVisibility(4);
                btn_LangganAndroid.setVisibility(0);
                btn_LangganBlackBerry.setVisibility(0);
                btn_LangganIOS.setVisibility(0);
                btn_LangganWindowsPhone.setVisibility(0);
                btn_LangganPlatformLain.setVisibility(4);
                btn_LangganTelkomsel.setVisibility(0);
                btn_LangganXL.setVisibility(0);
                btn_LangganIndosat.setVisibility(0);
                btn_LangganTri.setVisibility(0);
                btn_LangganAxis.setVisibility(0);
                btn_LangganSmartfren.setVisibility(0);
                btn_LangganCeria.setVisibility(0);
                btn_LangganEsia.setVisibility(0);
                btn_LangganTelkom.setVisibility(0);
                btn_LangganAplikasi.setVisibility(0);
                btn_LangganGame.setVisibility(0);
                btn_LangganTips.setVisibility(0);
                btn_LangganInternet.setVisibility(0);
                btn_LangganFirmware.setVisibility(0);
                btn_LangganGadget.setVisibility(0);
                btn_LangganECommerce.setVisibility(0);
                btn_LangganTeknologi.setVisibility(0);
                btn_LangganBisnis.setVisibility(0);
                btn_LangganPemerintah.setVisibility(0);
                btn_LangganGayaHidup.setVisibility(0);
                btn_LangganTokoh.setVisibility(0);
                btn_LangganKomunitas.setVisibility(0);
                btn_LangganStartup.setVisibility(0);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            slidingView.findViewById(0x7f0b05db).setVisibility(0);
            btn_LangganAndroid.setVisibility(8);
            btn_LangganBlackBerry.setVisibility(8);
            btn_LangganIOS.setVisibility(8);
            btn_LangganWindowsPhone.setVisibility(8);
            btn_LangganPlatformLain.setVisibility(8);
            btn_LangganTelkomsel.setVisibility(8);
            btn_LangganXL.setVisibility(8);
            btn_LangganIndosat.setVisibility(8);
            btn_LangganTri.setVisibility(8);
            btn_LangganAxis.setVisibility(8);
            btn_LangganSmartfren.setVisibility(8);
            btn_LangganCeria.setVisibility(8);
            btn_LangganEsia.setVisibility(8);
            btn_LangganTelkom.setVisibility(8);
            btn_LangganAplikasi.setVisibility(8);
            btn_LangganGame.setVisibility(8);
            btn_LangganTips.setVisibility(8);
            btn_LangganInternet.setVisibility(8);
            btn_LangganFirmware.setVisibility(8);
            btn_LangganGadget.setVisibility(8);
            btn_LangganECommerce.setVisibility(8);
            btn_LangganTeknologi.setVisibility(8);
            btn_LangganBisnis.setVisibility(8);
            btn_LangganPemerintah.setVisibility(8);
            btn_LangganGayaHidup.setVisibility(8);
            btn_LangganTokoh.setVisibility(8);
            btn_LangganKomunitas.setVisibility(8);
            btn_LangganStartup.setVisibility(8);
        }

        private GetSubscribe()
        {
            this$0 = HomeNewsActivity.this;
            super();
        }

        GetSubscribe(GetSubscribe getsubscribe)
        {
            this();
        }
    }

    public class NetworkReceiver extends BroadcastReceiver
    {

        final HomeNewsActivity this$0;

        public void onReceive(Context context, Intent intent)
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            if ("Wi-Fi".equals(HomeNewsActivity.sPref) && context != null && context.getType() == 1)
            {
                HomeNewsActivity.refreshDisplay = true;
                return;
            }
            if (context != null && context.isConnected())
            {
                HomeNewsActivity.refreshDisplay = true;
                return;
            }
            if ("Any".equals(HomeNewsActivity.sPref) && context != null)
            {
                HomeNewsActivity.refreshDisplay = true;
                return;
            } else
            {
                HomeNewsActivity.refreshDisplay = false;
                showErrorPage();
                return;
            }
        }

        public NetworkReceiver()
        {
            this$0 = HomeNewsActivity.this;
            super();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final HomeNewsActivity this$0;

        private void parseJSONLikePon(String s)
        {
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                postStatusLikePon = jsonobject.getString("success");
                postMessageLikePon = jsonobject.getString("message");
                Log.e("postStatusLikePon", s);
                jArray = jsonobject.getJSONArray("InPonsel");
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
                if (android.os.Build.VERSION.SDK_INT > 9)
                {
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
                }
                avoid = (new StringBuilder("idhp=")).append(random_id_hp).append("&email=").append(username).append("&namalengkap=").append(URLEncoder.encode(random_merek_hp, "utf-8")).append("&status=").append(statusLikeHp).append("&t=").append(t).toString();
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_ponsel").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", avoid);
                parseJSONLikePon(HttpPush.getResponse(avoid).toString());
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
            Log.e("postStatusLikePon", postStatusLikePon);
            if (!postStatusLikePon.equals("1"))
            {
                break MISSING_BLOCK_LABEL_146;
            }
            notificationLikeHelper.completed(namalengkapbgskrg, notificationLikeHelper.SucdislikeStatement);
            img_likerandom_ponsel.setEnabled(false);
            img_dislikerandom_ponsel.setEnabled(false);
            if (!statusLikeHp.equals("1"))
            {
                break MISSING_BLOCK_LABEL_131;
            }
            img_likerandom_ponsel.setBackgroundResource(0x7f02025b);
_L1:
            (new Handler()).postDelayed(new Runnable() {

                final PostBagusKurangTask this$1;

                public void run()
                {
                    load_random_hp();
                }

            
            {
                this$1 = PostBagusKurangTask.this;
                super();
            }
            }, 2000L);
            return;
            try
            {
                img_likerandom_ponsel.setBackgroundResource(0x7f0201a7);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            notificationLikeHelper.gagal(namalengkapbgskrg, notificationLikeHelper.gagallikeStatement);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statusLikeHp.equals("1"))
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.likeStatement);
                return;
            } else
            {
                notificationLikeHelper.createNotification(namalengkapbgskrg, notificationLikeHelper.dislikeStatement);
                return;
            }
        }


        public PostBagusKurangTask()
        {
            this$0 = HomeNewsActivity.this;
            super();
        }
    }

    public class RSSAsycMoreTask extends AsyncTask
    {

        final HomeNewsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("RSSAsycTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlRSSMore));
            as = jsonobject.getJSONArray("InPonsel");
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            succesStat = jsonobject.getString("success");
            Log.e("bottom_id", bottom_id);
            Log.e("top_id", top_id);
            if (!succesStat.equals("1"))
            {
                break MISSING_BLOCK_LABEL_301;
            }
            mArrayListRSSData.clear();
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_301;
            }
            JSONObject jsonobject1 = as.getJSONObject(i);
            mArrayListRSSData.add(new ItemRSS(jsonobject1.getString("id"), jsonobject1.getString("rss_id"), jsonobject1.getString("rss_title"), jsonobject1.getString("rss_portal"), jsonobject1.getString("rss_desc"), "", jsonobject1.getString("rss_srclink"), jsonobject1.getString("rss_date"), jsonobject1.getString("rss_img_ava"), jsonobject1.getString("rss_img"), jsonobject1.getJSONObject("likedislike").getString("total_like"), jsonobject1.getJSONObject("likedislike").getString("total_komen"), jsonobject1.getJSONObject("likedislike").getString("total_hits"), jsonobject1.getJSONObject("likedislike").getString("my_like_rss"), jsonobject1.getJSONObject("likedislike").getString("my_fav_rss")));
            i++;
              goto _L1
            as;
            as.printStackTrace();
            strKonekStat = "0";
            break MISSING_BLOCK_LABEL_301;
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
            progressbar_rssfeedmore.setVisibility(8);
            if (!succesStat.equals("1")) goto _L2; else goto _L1
_L1:
            int i = 0;
_L6:
            if (i < mArrayListRSSData.size()) goto _L4; else goto _L3
_L3:
            void1 = HomeNewsActivity.this;
            void1.count_task = ((HomeNewsActivity) (void1)).count_task + 1;
            page_count = count_task;
_L2:
            return;
_L4:
            void1 = HomeNewsActivity.this;
            void1.countList_rss = ((HomeNewsActivity) (void1)).countList_rss + 1;
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030141, null);
            TextView textview = (TextView)void1.findViewById(0x7f0b0419);
            TextView textview1 = (TextView)void1.findViewById(0x7f0b05ec);
            ImageView imageview = (ImageView)void1.findViewById(0x7f0b054b);
            imageview = (ImageView)void1.findViewById(0x7f0b046c);
            TextView textview2 = (TextView)void1.findViewById(0x7f0b054d);
            TextView textview3 = (TextView)void1.findViewById(0x7f0b054e);
            TextView textview4 = (TextView)void1.findViewById(0x7f0b054c);
            TextView textview5 = (TextView)void1.findViewById(0x7f0b05e9);
            TextView textview6 = (TextView)void1.findViewById(0x7f0b05ea);
            Object obj = (ImageView)void1.findViewById(0x7f0b054f);
            obj = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            obj = (TextView)void1.findViewById(0x7f0b0554);
            obj = (TextView)void1.findViewById(0x7f0b034a);
            TextView textview7 = (TextView)void1.findViewById(0x7f0b0650);
            final String id_rss = (LinearLayout)void1.findViewById(0x7f0b0341);
            id_rss = (RelativeLayout)void1.findViewById(0x7f0b0342);
            id_rss = (RelativeLayout)void1.findViewById(0x7f0b0345);
            id_rss = (RelativeLayout)void1.findViewById(0x7f0b0348);
            id_rss = (RelativeLayout)void1.findViewById(0x7f0b0665);
            id_rss = (ImageView)void1.findViewById(0x7f0b05f1);
            id_rss = ((ItemRSS)mArrayListRSSData.get(i)).getId();
            final String rss_id = ((ItemRSS)mArrayListRSSData.get(i)).getRss_id();
            final String rss_title = ((ItemRSS)mArrayListRSSData.get(i)).getRss_title();
            final String rss_portal = ((ItemRSS)mArrayListRSSData.get(i)).getRss_portal();
            final String rss_desc = ((ItemRSS)mArrayListRSSData.get(i)).getRss_desc();
            ((ItemRSS)mArrayListRSSData.get(i)).getRss_content();
            final String rss_srclink = ((ItemRSS)mArrayListRSSData.get(i)).getRss_srclink();
            final String rss_date = ((ItemRSS)mArrayListRSSData.get(i)).getRss_date();
            final String rss_img_ava = ((ItemRSS)mArrayListRSSData.get(i)).getRss_img_ava();
            final String rss_img = ((ItemRSS)mArrayListRSSData.get(i)).getRss_img();
            final String total_like = ((ItemRSS)mArrayListRSSData.get(i)).getRss_tot_like();
            final String like_stat = ((ItemRSS)mArrayListRSSData.get(i)).getRss_like_stat();
            final String total_komen = ((ItemRSS)mArrayListRSSData.get(i)).getRss_tot_komen();
            String s = ((ItemRSS)mArrayListRSSData.get(i)).getRss_fav_stat();
            textview7.setText(s);
            textview1.setText(Html.fromHtml(rss_title));
            textview2.setText(id_rss);
            textview.setText((new StringBuilder(String.valueOf(rss_portal))).append(" - ").append(Utility.convertDate(rss_date)).toString());
            textview5.setText(rss_img_ava);
            textview6.setText(rss_img);
            textview3.setText((new StringBuilder()).append(Html.fromHtml(Utility.parseUrl(rss_desc))).toString());
            textview3.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            textview3.setVisibility(8);
            txtLikeKom.setText(total_like);
            ((TextView) (obj)).setText(total_komen);
            if (((ItemRSS)mArrayListRSSData.get(i)).getRss_img().trim().equals(""))
            {
                imageview.setVisibility(0);
                imageview.setImageResource(0x7f020243);
            } else
            {
                Picasso.with(HomeNewsActivity.this).load(((ItemRSS)mArrayListRSSData.get(i)).getRss_img().toString().trim()).tag(HomeNewsActivity.this).error(0x7f020243).placeholder(0x7f020243).into(imageview, imageview. new Callback() {

                    final RSSAsycMoreTask this$1;
                    private final ImageView val$imageMedia;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                        imageMedia.setVisibility(0);
                    }

            
            {
                this$1 = final_rssasycmoretask;
                imageMedia = ImageView.this;
                super();
            }
                });
            }
            textview4.setText(Utility.convertDate(((ItemRSS)mArrayListRSSData.get(i)).getRss_date()));
            Log.e("countList_rss", String.valueOf(countList_rss));
            if (countList_rss != 12 && countList_rss != 18 && countList_rss != 24)
            {
                if (countList_rss != 30)
                {
                    break; /* Loop/switch isn't completed */
                }
                if (!id_hp.equals("-") && !id_hp.equals(""))
                {
                    listBerita.addView(mLinearViewTurun);
                }
            }
_L8:
            listBerita.addView(void1);
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final RSSAsycMoreTask this$1;
                private final String val$fav_stat;
                private final String val$id_rss;
                private final String val$like_stat;
                private final String val$rss_date;
                private final String val$rss_desc;
                private final String val$rss_id;
                private final String val$rss_img;
                private final String val$rss_img_ava;
                private final String val$rss_portal;
                private final String val$rss_srclink;
                private final String val$rss_title;
                private final String val$total_komen;
                private final String val$total_like;

                public void onClick(View view)
                {
                    idkom_pos = id_rss;
                    view = new Intent(_fld0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                    Log.e("rss_title", rss_title);
                    view.putExtra("actfrom", "rssfeed");
                    view.putExtra("kategori_tag", kategori_tag);
                    view.putExtra("act", "firsttab");
                    view.putExtra("rss_id", rss_id);
                    view.putExtra("id_rss", id_rss);
                    view.putExtra("rss_title", rss_title);
                    view.putExtra("rss_portal", rss_portal);
                    view.putExtra("rss_desc", rss_desc);
                    view.putExtra("rss_srclink", rss_srclink);
                    view.putExtra("rss_date", rss_date);
                    view.putExtra("rss_img_ava", rss_img_ava);
                    view.putExtra("rss_img", rss_img);
                    view.putExtra("total_like", total_like);
                    view.putExtra("like_stat", like_stat);
                    view.putExtra("total_komen", total_komen);
                    view.putExtra("fav_stat", fav_stat);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_rssasycmoretask;
                id_rss = s;
                rss_title = s1;
                rss_id = s2;
                rss_portal = s3;
                rss_desc = s4;
                rss_srclink = s5;
                rss_date = s6;
                rss_img_ava = s7;
                rss_img = s8;
                total_like = s9;
                like_stat = s10;
                total_komen = s11;
                fav_stat = String.this;
                super();
            }
            });
            i++;
            if (true) goto _L6; else goto _L5
_L5:
            if (countList_rss != 36) goto _L8; else goto _L7
_L7:
            listBerita.addView(mLinearViewNewsSlide);
            home_menu_news_tips.setOnClickListener(new android.view.View.OnClickListener() {

                final RSSAsycMoreTask this$1;

                public void onClick(View view)
                {
                    view = new Intent(_fld0, com/inponsel/android/v2/RSSFeedByTag);
                    view.putExtra("tag_code", "0");
                    view.putExtra("kategori_tag", title_single);
                    view.putExtra("tag_key", (new StringBuilder("al:")).append(tag_key_single).toString());
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = RSSAsycMoreTask.this;
                super();
            }
            });
              goto _L8
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Log.e("RSSAsycTask", "onPreExecute");
        }


        public RSSAsycMoreTask()
        {
            this$0 = HomeNewsActivity.this;
            super();
        }
    }

    public class RSSAsycTask extends AsyncTask
    {

        final HomeNewsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("RSSAsycTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlRSS));
            as = jsonobject.getJSONArray("InPonsel");
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            succesStat = jsonobject.getString("success");
            Log.e("bottom_id", bottom_id);
            Log.e("top_id", top_id);
            if (!succesStat.equals("1"))
            {
                break MISSING_BLOCK_LABEL_291;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_291;
            }
            JSONObject jsonobject1 = as.getJSONObject(i);
            mArrayListRSSData.add(new ItemRSS(jsonobject1.getString("id"), jsonobject1.getString("rss_id"), jsonobject1.getString("rss_title"), jsonobject1.getString("rss_portal"), jsonobject1.getString("rss_desc"), "", jsonobject1.getString("rss_srclink"), jsonobject1.getString("rss_date"), jsonobject1.getString("rss_img_ava"), jsonobject1.getString("rss_img"), jsonobject1.getJSONObject("likedislike").getString("total_like"), jsonobject1.getJSONObject("likedislike").getString("total_komen"), jsonobject1.getJSONObject("likedislike").getString("total_hits"), jsonobject1.getJSONObject("likedislike").getString("my_like_rss"), jsonobject1.getJSONObject("likedislike").getString("my_fav_rss")));
            i++;
              goto _L1
            as;
            as.printStackTrace();
            strKonekStat = "0";
            break MISSING_BLOCK_LABEL_291;
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
            progressbar_rssfeed.setVisibility(8);
            if (!succesStat.equals("1")) goto _L2; else goto _L1
_L1:
            int i;
            Log.e("mArrayListRSSData", String.valueOf(mArrayListRSSData.size()));
            i = 0;
_L5:
            if (i < mArrayListRSSData.size()) goto _L3; else goto _L2
_L2:
            Log.e("inch", (new StringBuilder("screen ")).append(String.valueOf(Utility.screen_inch(HomeNewsActivity.this))).toString());
            if (Utility.screen_inch(HomeNewsActivity.this) >= 6D)
            {
                load_more_rss();
            }
            return;
_L3:
            void1 = HomeNewsActivity.this;
            void1.countList_rss = ((HomeNewsActivity) (void1)).countList_rss + 1;
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030141, null);
            TextView textview = (TextView)void1.findViewById(0x7f0b0419);
            TextView textview1 = (TextView)void1.findViewById(0x7f0b05ec);
            ImageView imageview = (ImageView)void1.findViewById(0x7f0b054b);
            imageview = (ImageView)void1.findViewById(0x7f0b046c);
            TextView textview2 = (TextView)void1.findViewById(0x7f0b054d);
            TextView textview3 = (TextView)void1.findViewById(0x7f0b054e);
            TextView textview4 = (TextView)void1.findViewById(0x7f0b054c);
            TextView textview5 = (TextView)void1.findViewById(0x7f0b05e9);
            TextView textview6 = (TextView)void1.findViewById(0x7f0b05ea);
            Object obj = (ImageView)void1.findViewById(0x7f0b054f);
            obj = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            obj = (TextView)void1.findViewById(0x7f0b0554);
            obj = (TextView)void1.findViewById(0x7f0b034a);
            TextView textview7 = (TextView)void1.findViewById(0x7f0b0650);
            Object obj1 = (LinearLayout)void1.findViewById(0x7f0b0341);
            obj1 = (RelativeLayout)void1.findViewById(0x7f0b0342);
            obj1 = (RelativeLayout)void1.findViewById(0x7f0b0345);
            obj1 = (RelativeLayout)void1.findViewById(0x7f0b0348);
            obj1 = (RelativeLayout)void1.findViewById(0x7f0b0665);
            ImageView imageview1 = (ImageView)void1.findViewById(0x7f0b05f1);
            final String id_rss = ((ItemRSS)mArrayListRSSData.get(i)).getId();
            final String rss_id = ((ItemRSS)mArrayListRSSData.get(i)).getRss_id();
            final String rss_title = ((ItemRSS)mArrayListRSSData.get(i)).getRss_title();
            Log.e("rss_title", rss_title);
            final String rss_portal = ((ItemRSS)mArrayListRSSData.get(i)).getRss_portal();
            final String rss_desc = ((ItemRSS)mArrayListRSSData.get(i)).getRss_desc();
            ((ItemRSS)mArrayListRSSData.get(i)).getRss_content();
            final String rss_srclink = ((ItemRSS)mArrayListRSSData.get(i)).getRss_srclink();
            final String rss_date = ((ItemRSS)mArrayListRSSData.get(i)).getRss_date();
            final String rss_img_ava = ((ItemRSS)mArrayListRSSData.get(i)).getRss_img_ava();
            final String rss_img = ((ItemRSS)mArrayListRSSData.get(i)).getRss_img();
            final String total_like = ((ItemRSS)mArrayListRSSData.get(i)).getRss_tot_like();
            final String like_stat = ((ItemRSS)mArrayListRSSData.get(i)).getRss_like_stat();
            final String total_komen = ((ItemRSS)mArrayListRSSData.get(i)).getRss_tot_komen();
            String s = ((ItemRSS)mArrayListRSSData.get(i)).getRss_fav_stat();
            if (s.equals("1"))
            {
                textview7.setText("1");
                imageview1.setBackgroundResource(0x7f020303);
            } else
            {
                imageview1.setBackgroundResource(0x7f020302);
                textview7.setText("0");
            }
            textview1.setText(Html.fromHtml(rss_title));
            textview2.setText(id_rss);
            textview.setText((new StringBuilder(String.valueOf(rss_portal))).append(" - ").append(Utility.convertDate(rss_date)).toString());
            textview5.setText(rss_img_ava);
            textview6.setText(rss_img);
            textview3.setText((new StringBuilder()).append(Html.fromHtml(Utility.parseUrl(rss_desc))).toString());
            textview3.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            textview3.setVisibility(8);
            txtLikeKom.setText(total_like);
            ((TextView) (obj)).setText(total_komen);
            if (((ItemRSS)mArrayListRSSData.get(i)).getRss_img().trim().equals(""))
            {
                imageview.setVisibility(0);
                imageview.setImageResource(0x7f020243);
            } else
            {
                Picasso.with(HomeNewsActivity.this).load(((ItemRSS)mArrayListRSSData.get(i)).getRss_img().toString().trim()).tag(HomeNewsActivity.this).error(0x7f020243).placeholder(0x7f020243).into(imageview, imageview. new Callback() {

                    final RSSAsycTask this$1;
                    private final ImageView val$imageMedia;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                        imageMedia.setVisibility(0);
                    }

            
            {
                this$1 = final_rssasyctask;
                imageMedia = ImageView.this;
                super();
            }
                });
            }
            textview4.setText(Utility.convertDate(((ItemRSS)mArrayListRSSData.get(i)).getRss_date()));
            Log.e("countList_rss", String.valueOf(countList_rss));
            if (countList_rss == 6)
            {
                listBerita.addView(mLinearViewAds);
            }
            listBerita.addView(void1);
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final RSSAsycTask this$1;
                private final String val$fav_stat;
                private final String val$id_rss;
                private final String val$like_stat;
                private final String val$rss_date;
                private final String val$rss_desc;
                private final String val$rss_id;
                private final String val$rss_img;
                private final String val$rss_img_ava;
                private final String val$rss_portal;
                private final String val$rss_srclink;
                private final String val$rss_title;
                private final String val$total_komen;
                private final String val$total_like;

                public void onClick(View view)
                {
                    idkom_pos = id_rss;
                    view = new Intent(_fld0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                    Log.e("rss_title", rss_title);
                    view.putExtra("actfrom", "rssfeed");
                    view.putExtra("kategori_tag", kategori_tag);
                    view.putExtra("act", "firsttab");
                    view.putExtra("rss_id", rss_id);
                    view.putExtra("id_rss", id_rss);
                    view.putExtra("rss_title", rss_title);
                    view.putExtra("rss_portal", rss_portal);
                    view.putExtra("rss_desc", rss_desc);
                    view.putExtra("rss_srclink", rss_srclink);
                    view.putExtra("rss_date", rss_date);
                    view.putExtra("rss_img_ava", rss_img_ava);
                    view.putExtra("rss_img", rss_img);
                    view.putExtra("total_like", total_like);
                    view.putExtra("like_stat", like_stat);
                    view.putExtra("total_komen", total_komen);
                    view.putExtra("fav_stat", fav_stat);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_rssasyctask;
                id_rss = s;
                rss_title = s1;
                rss_id = s2;
                rss_portal = s3;
                rss_desc = s4;
                rss_srclink = s5;
                rss_date = s6;
                rss_img_ava = s7;
                rss_img = s8;
                total_like = s9;
                like_stat = s10;
                total_komen = s11;
                fav_stat = String.this;
                super();
            }
            });
            ((RelativeLayout) (obj1)).setOnClickListener(textview7. new android.view.View.OnClickListener() {

                final RSSAsycTask this$1;
                private final String val$id_rss;
                private final String val$rss_srclink;
                private final TextView val$txt_fav_news_1;

                public void onClick(View view)
                {
                    idkom_pos = id_rss;
                    str_srclink = rss_srclink;
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        Log.e("idkom_posfav", idkom_pos);
                        if (txt_fav_news_1.getText().toString().equals("1"))
                        {
                            view = new android.app.AlertDialog.Builder(_fld0);
                            view.setMessage("Hapus berita ini dari favorit?");
                            view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                final RSSAsycTask._cls3 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                    statFav = "0";
                                    (new FavoritTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = RSSAsycTask._cls3.this;
                super();
            }
                            });
                            view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final RSSAsycTask._cls3 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = RSSAsycTask._cls3.this;
                super();
            }
                            });
                            view.show();
                            return;
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(_fld0);
                            view.setMessage("Favoritkan berita ini?");
                            view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                final RSSAsycTask._cls3 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    statFav = "1";
                                    (new FavoritTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = RSSAsycTask._cls3.this;
                super();
            }
                            });
                            view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final RSSAsycTask._cls3 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = RSSAsycTask._cls3.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final RSSAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = RSSAsycTask._cls3.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final RSSAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = RSSAsycTask._cls3.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final RSSAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = RSSAsycTask._cls3.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_rssasyctask;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = TextView.this;
                super();
            }
            });
            i++;
            if (true) goto _L5; else goto _L4
_L4:
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Log.e("RSSAsycTask", "onPreExecute");
            mArrayListRSSData.clear();
            listBerita.removeAllViewsInLayout();
            listBerita.removeAllViews();
        }


        public RSSAsycTask()
        {
            this$0 = HomeNewsActivity.this;
            super();
        }
    }

    public class RSSRefreshAsycTask extends AsyncTask
    {

        final HomeNewsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("RSSAsycTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlRSS));
            as = jsonobject.getJSONArray("InPonsel");
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            succesStat = jsonobject.getString("success");
            Log.e("bottom_id", bottom_id);
            Log.e("top_id", top_id);
            if (!succesStat.equals("1"))
            {
                break MISSING_BLOCK_LABEL_283;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_283;
            }
            JSONObject jsonobject1 = as.getJSONObject(i);
            mArrayListRSSData.add(new ItemRSS(jsonobject1.getString("id"), jsonobject1.getString("rss_id"), jsonobject1.getString("rss_title"), jsonobject1.getString("rss_portal"), jsonobject1.getString("rss_desc"), "", jsonobject1.getString("rss_srclink"), jsonobject1.getString("rss_date"), jsonobject1.getString("rss_img_ava"), jsonobject1.getString("rss_img"), jsonobject1.getJSONObject("likedislike").getString("total_like"), jsonobject1.getJSONObject("likedislike").getString("total_komen"), jsonobject1.getJSONObject("likedislike").getString("total_hits"), jsonobject1.getJSONObject("likedislike").getString("my_like_rss"), jsonobject1.getJSONObject("likedislike").getString("my_fav_rss")));
            i++;
              goto _L1
            as;
            as.printStackTrace();
            strKonekStat = "0";
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            if (!succesStat.equals("1")) goto _L2; else goto _L1
_L1:
            int i;
            listBerita.removeAllViewsInLayout();
            i = 0;
_L5:
            if (i < mArrayListRSSData.size()) goto _L3; else goto _L2
_L2:
            return;
_L3:
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030141, null);
            TextView textview = (TextView)void1.findViewById(0x7f0b0419);
            TextView textview1 = (TextView)void1.findViewById(0x7f0b05ec);
            ImageView imageview = (ImageView)void1.findViewById(0x7f0b054b);
            imageview = (ImageView)void1.findViewById(0x7f0b046c);
            TextView textview2 = (TextView)void1.findViewById(0x7f0b054d);
            TextView textview3 = (TextView)void1.findViewById(0x7f0b054e);
            TextView textview4 = (TextView)void1.findViewById(0x7f0b054c);
            TextView textview5 = (TextView)void1.findViewById(0x7f0b05e9);
            TextView textview6 = (TextView)void1.findViewById(0x7f0b05ea);
            Object obj = (ImageView)void1.findViewById(0x7f0b054f);
            obj = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            obj = (TextView)void1.findViewById(0x7f0b0554);
            obj = (TextView)void1.findViewById(0x7f0b034a);
            TextView textview7 = (TextView)void1.findViewById(0x7f0b0650);
            final String id_rss = (LinearLayout)void1.findViewById(0x7f0b0341);
            id_rss = (RelativeLayout)void1.findViewById(0x7f0b0342);
            id_rss = (RelativeLayout)void1.findViewById(0x7f0b0345);
            id_rss = (RelativeLayout)void1.findViewById(0x7f0b0348);
            id_rss = (RelativeLayout)void1.findViewById(0x7f0b0665);
            id_rss = (ImageView)void1.findViewById(0x7f0b05f1);
            id_rss = ((ItemRSS)mArrayListRSSData.get(i)).getId();
            final String rss_id = ((ItemRSS)mArrayListRSSData.get(i)).getRss_id();
            final String rss_title = ((ItemRSS)mArrayListRSSData.get(i)).getRss_title();
            final String rss_portal = ((ItemRSS)mArrayListRSSData.get(i)).getRss_portal();
            final String rss_desc = ((ItemRSS)mArrayListRSSData.get(i)).getRss_desc();
            ((ItemRSS)mArrayListRSSData.get(i)).getRss_content();
            final String rss_srclink = ((ItemRSS)mArrayListRSSData.get(i)).getRss_srclink();
            final String rss_date = ((ItemRSS)mArrayListRSSData.get(i)).getRss_date();
            final String rss_img_ava = ((ItemRSS)mArrayListRSSData.get(i)).getRss_img_ava();
            final String rss_img = ((ItemRSS)mArrayListRSSData.get(i)).getRss_img();
            final String total_like = ((ItemRSS)mArrayListRSSData.get(i)).getRss_tot_like();
            final String like_stat = ((ItemRSS)mArrayListRSSData.get(i)).getRss_like_stat();
            final String total_komen = ((ItemRSS)mArrayListRSSData.get(i)).getRss_tot_komen();
            String s = ((ItemRSS)mArrayListRSSData.get(i)).getRss_fav_stat();
            textview7.setText(s);
            textview1.setText(Html.fromHtml(rss_title));
            textview2.setText(id_rss);
            textview.setText((new StringBuilder(String.valueOf(rss_portal))).append(" - ").append(Utility.convertDate(rss_date)).toString());
            textview5.setText(rss_img_ava);
            textview6.setText(rss_img);
            textview3.setText(Html.fromHtml(Utility.parseUrl(rss_desc)));
            textview3.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtLikeKom.setText(total_like);
            ((TextView) (obj)).setText(total_komen);
            if (((ItemRSS)mArrayListRSSData.get(i)).getRss_img().trim().equals(""))
            {
                imageview.setVisibility(0);
                imageview.setImageResource(0x7f020243);
            } else
            {
                Picasso.with(HomeNewsActivity.this).load(((ItemRSS)mArrayListRSSData.get(i)).getRss_img().toString().trim()).tag(HomeNewsActivity.this).error(0x7f020243).placeholder(0x7f020243).into(imageview, imageview. new Callback() {

                    final RSSRefreshAsycTask this$1;
                    private final ImageView val$imageMedia;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                        imageMedia.setVisibility(0);
                    }

            
            {
                this$1 = final_rssrefreshasyctask;
                imageMedia = ImageView.this;
                super();
            }
                });
            }
            textview4.setText(Utility.convertDate(((ItemRSS)mArrayListRSSData.get(i)).getRss_date()));
            listBerita.addView(void1);
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final RSSRefreshAsycTask this$1;
                private final String val$fav_stat;
                private final String val$id_rss;
                private final String val$like_stat;
                private final String val$rss_date;
                private final String val$rss_desc;
                private final String val$rss_id;
                private final String val$rss_img;
                private final String val$rss_img_ava;
                private final String val$rss_portal;
                private final String val$rss_srclink;
                private final String val$rss_title;
                private final String val$total_komen;
                private final String val$total_like;

                public void onClick(View view)
                {
                    idkom_pos = id_rss;
                    view = new Intent(_fld0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                    view.putExtra("actfrom", "rssfeed");
                    view.putExtra("kategori_tag", kategori_tag);
                    view.putExtra("act", "firsttab");
                    view.putExtra("rss_id", rss_id);
                    view.putExtra("id_rss", id_rss);
                    view.putExtra("rss_title", rss_title);
                    view.putExtra("rss_portal", rss_portal);
                    view.putExtra("rss_desc", rss_desc);
                    view.putExtra("rss_srclink", rss_srclink);
                    view.putExtra("rss_date", rss_date);
                    view.putExtra("rss_img_ava", rss_img_ava);
                    view.putExtra("rss_img", rss_img);
                    view.putExtra("total_like", total_like);
                    view.putExtra("like_stat", like_stat);
                    view.putExtra("total_komen", total_komen);
                    view.putExtra("fav_stat", fav_stat);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_rssrefreshasyctask;
                id_rss = s;
                rss_id = s1;
                rss_title = s2;
                rss_portal = s3;
                rss_desc = s4;
                rss_srclink = s5;
                rss_date = s6;
                rss_img_ava = s7;
                rss_img = s8;
                total_like = s9;
                like_stat = s10;
                total_komen = s11;
                fav_stat = String.this;
                super();
            }
            });
            i++;
            if (true) goto _L5; else goto _L4
_L4:
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Log.e("RSSAsycTask", "onPreExecute");
            mArrayListRSSData.clear();
        }


        public RSSRefreshAsycTask()
        {
            this$0 = HomeNewsActivity.this;
            super();
        }
    }

    public class SubsNewsTask extends AsyncTask
    {

        final HomeNewsActivity this$0;

        private void parseJSONSubsNews(String s)
        {
            try
            {
                s = new JSONObject(s);
                postStatusSubsNews = s.getString("success");
                postMessageSubsNews = s.getString("message");
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
                avoid = (new StringBuilder("idhp=")).append(id_subs).append("&idusr=").append(user_id).append("&stat=").append(statSubNews).append("&type=").append(type).append("&t=").append(t).toString();
                String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_news").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", s);
                s = HttpPush.getResponse(s);
                Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
                avoid = s.toString();
                Log.e("url ", avoid);
                parseJSONSubsNews(avoid);
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
label0:
            {
label1:
                {
                    {
                        super.onPostExecute(void1);
                        if (!postStatusSubsNews.equals("1") && !postStatusSubsNews.equals("10"))
                        {
                            break label0;
                        }
                        Toast.makeText(HomeNewsActivity.this, postMessageSubsNews, 1).show();
                        if (!type.equals("os") || !type_tag.toLowerCase().equals("android"))
                        {
                            break label1;
                        }
                        if (str_LangganAndroid.equals("1"))
                        {
                            str_LangganAndroid = "1";
                            btn_LangganAndroid.setText("Hapus");
                            btn_LangganAndroid.setBackgroundResource(0x7f02013a);
                            try
                            {
                                btn_LangganAndroid.setTextColor(colorsHapus);
                            }
                            // Misplaced declaration of an exception variable
                            catch (Void void1) { }
                        } else
                        {
                            str_LangganAndroid = "0";
                            btn_LangganAndroid.setText("Langganan");
                            btn_LangganAndroid.setBackgroundResource(0x7f020137);
                            try
                            {
                                btn_LangganAndroid.setTextColor(colorsIkuti);
                            }
                            // Misplaced declaration of an exception variable
                            catch (Void void1) { }
                        }
                    }
                    mDialog.dismiss();
                    return;
                }
                if (type.equals("os") && type_tag.toLowerCase().equals("blackberry"))
                {
                    if (str_LangganBlackBerry.equals("1"))
                    {
                        str_LangganBlackBerry = "1";
                        btn_LangganBlackBerry.setText("Hapus");
                        btn_LangganBlackBerry.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganBlackBerry.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganBlackBerry = "0";
                        btn_LangganBlackBerry.setText("Langganan");
                        btn_LangganBlackBerry.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganBlackBerry.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("os") && type_tag.toLowerCase().equals("ios"))
                {
                    if (str_LangganIOS.equals("1"))
                    {
                        str_LangganIOS = "1";
                        btn_LangganIOS.setText("Hapus");
                        btn_LangganIOS.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganIOS.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganIOS = "0";
                        btn_LangganIOS.setText("Langganan");
                        btn_LangganIOS.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganIOS.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("os") && type_tag.toLowerCase().equals("windowsphone"))
                {
                    if (str_LangganWindowsPhone.equals("1"))
                    {
                        str_LangganWindowsPhone = "1";
                        btn_LangganWindowsPhone.setText("Hapus");
                        btn_LangganWindowsPhone.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganWindowsPhone.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganWindowsPhone = "0";
                        btn_LangganWindowsPhone.setText("Langganan");
                        btn_LangganWindowsPhone.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganWindowsPhone.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("os") && type_tag.toLowerCase().equals("platformlain"))
                {
                    if (str_LangganPlatformLain.equals("1"))
                    {
                        str_LangganPlatformLain = "1";
                        btn_LangganPlatformLain.setText("Hapus");
                        btn_LangganPlatformLain.setBackgroundResource(0x7f020137);
                        try
                        {
                            void1 = getResources().getXml(0x7f080197);
                            void1 = ColorStateList.createFromXml(getResources(), void1);
                            btn_LangganPlatformLain.setTextColor(void1);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganPlatformLain = "0";
                        btn_LangganPlatformLain.setText("Langganan");
                        btn_LangganPlatformLain.setBackgroundResource(0x7f02013a);
                        try
                        {
                            void1 = getResources().getXml(0x7f080194);
                            void1 = ColorStateList.createFromXml(getResources(), void1);
                            btn_LangganPlatformLain.setTextColor(void1);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("op") && type_tag.toLowerCase().equals("telkomsel"))
                {
                    if (str_LangganTelkomsel.equals("1"))
                    {
                        str_LangganTelkomsel = "1";
                        btn_LangganTelkomsel.setText("Hapus");
                        btn_LangganTelkomsel.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganTelkomsel.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganTelkomsel = "0";
                        btn_LangganTelkomsel.setText("Langganan");
                        btn_LangganTelkomsel.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganTelkomsel.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("op") && type_tag.toLowerCase().equals("xl"))
                {
                    if (str_LangganXL.equals("1"))
                    {
                        str_LangganXL = "1";
                        btn_LangganXL.setText("Hapus");
                        btn_LangganXL.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganXL.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganXL = "0";
                        btn_LangganXL.setText("Langganan");
                        btn_LangganXL.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganXL.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("op") && type_tag.toLowerCase().equals("indosat"))
                {
                    if (str_LangganIndosat.equals("1"))
                    {
                        str_LangganIndosat = "1";
                        btn_LangganIndosat.setText("Hapus");
                        btn_LangganIndosat.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganIndosat.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganIndosat = "0";
                        btn_LangganIndosat.setText("Langganan");
                        btn_LangganIndosat.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganIndosat.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("op") && type_tag.toLowerCase().equals("tri"))
                {
                    if (str_LangganTri.equals("1"))
                    {
                        str_LangganTri = "1";
                        btn_LangganTri.setText("Hapus");
                        btn_LangganTri.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganTri.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganTri = "0";
                        btn_LangganTri.setText("Langganan");
                        btn_LangganTri.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganTri.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("op") && type_tag.toLowerCase().equals("axis"))
                {
                    if (str_LangganAxis.equals("1"))
                    {
                        str_LangganAxis = "1";
                        btn_LangganAxis.setText("Hapus");
                        btn_LangganAxis.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganAxis.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganAxis = "0";
                        btn_LangganAxis.setText("Langganan");
                        btn_LangganAxis.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganAxis.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("op") && type_tag.toLowerCase().equals("smartfren"))
                {
                    if (str_LangganSmartfren.equals("1"))
                    {
                        str_LangganSmartfren = "1";
                        btn_LangganSmartfren.setText("Hapus");
                        btn_LangganSmartfren.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganSmartfren.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganSmartfren = "0";
                        btn_LangganSmartfren.setText("Langganan");
                        btn_LangganSmartfren.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganSmartfren.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("op") && type_tag.toLowerCase().equals("ceria"))
                {
                    if (str_LangganCeria.equals("1"))
                    {
                        str_LangganCeria = "1";
                        btn_LangganCeria.setText("Hapus");
                        btn_LangganCeria.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganCeria.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganCeria = "0";
                        btn_LangganCeria.setText("Langganan");
                        btn_LangganCeria.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganCeria.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("op") && type_tag.toLowerCase().equals("esia"))
                {
                    if (str_LangganEsia.equals("1"))
                    {
                        str_LangganEsia = "1";
                        btn_LangganEsia.setText("Hapus");
                        btn_LangganEsia.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganEsia.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganEsia = "0";
                        btn_LangganEsia.setText("Langganan");
                        btn_LangganEsia.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganEsia.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("op") && type_tag.toLowerCase().equals("telkom"))
                {
                    if (str_LangganTelkom.equals("1"))
                    {
                        str_LangganTelkom = "1";
                        btn_LangganTelkom.setText("Hapus");
                        btn_LangganTelkom.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganTelkom.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganTelkom = "0";
                        btn_LangganTelkom.setText("Langganan");
                        btn_LangganTelkom.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganTelkom.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("general") && type_tag.toLowerCase().equals("appgame"))
                {
                    if (str_LangganAplikasi.equals("1"))
                    {
                        str_LangganAplikasi = "1";
                        btn_LangganAplikasi.setText("Hapus");
                        btn_LangganAplikasi.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganAplikasi.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganAplikasi = "0";
                        btn_LangganAplikasi.setText("Langganan");
                        btn_LangganAplikasi.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganAplikasi.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("general") && type_tag.toLowerCase().equals("permainan"))
                {
                    if (str_LangganGame.equals("1"))
                    {
                        str_LangganGame = "1";
                        btn_LangganGame.setText("Hapus");
                        btn_LangganGame.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganGame.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganGame = "0";
                        btn_LangganGame.setText("Langganan");
                        btn_LangganGame.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganGame.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("general") && type_tag.toLowerCase().equals("tipstrik"))
                {
                    if (str_LangganTips.equals("1"))
                    {
                        str_LangganTips = "1";
                        btn_LangganTips.setText("Hapus");
                        btn_LangganTips.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganTips.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganTips = "0";
                        btn_LangganTips.setText("Langganan");
                        btn_LangganTips.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganTips.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("general") && type_tag.toLowerCase().equals("inetsocmed"))
                {
                    if (str_LangganInternet.equals("1"))
                    {
                        str_LangganInternet = "1";
                        btn_LangganInternet.setText("Hapus");
                        btn_LangganInternet.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganInternet.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganInternet = "0";
                        btn_LangganInternet.setText("Langganan");
                        btn_LangganInternet.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganInternet.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("general") && type_tag.toLowerCase().equals("firmware"))
                {
                    if (str_LangganFirmware.equals("1"))
                    {
                        str_LangganFirmware = "1";
                        btn_LangganFirmware.setText("Hapus");
                        btn_LangganFirmware.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganFirmware.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganFirmware = "0";
                        btn_LangganFirmware.setText("Langganan");
                        btn_LangganFirmware.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganFirmware.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("general") && type_tag.toLowerCase().equals("gadget"))
                {
                    if (str_LangganGadget.equals("1"))
                    {
                        str_LangganGadget = "1";
                        btn_LangganGadget.setText("Hapus");
                        btn_LangganGadget.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganGadget.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganGadget = "0";
                        btn_LangganGadget.setText("Langganan");
                        btn_LangganGadget.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganGadget.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("general") && type_tag.toLowerCase().equals("ecommerce"))
                {
                    if (str_LangganECommerce.equals("1"))
                    {
                        str_LangganECommerce = "1";
                        btn_LangganECommerce.setText("Hapus");
                        btn_LangganECommerce.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganECommerce.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganECommerce = "0";
                        btn_LangganECommerce.setText("Langganan");
                        btn_LangganECommerce.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganECommerce.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("general") && type_tag.toLowerCase().equals("teknoscience"))
                {
                    if (str_LangganTeknologi.equals("1"))
                    {
                        str_LangganTeknologi = "1";
                        btn_LangganTeknologi.setText("Hapus");
                        btn_LangganTeknologi.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganTeknologi.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganTeknologi = "0";
                        btn_LangganTeknologi.setText("Langganan");
                        btn_LangganTeknologi.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganTeknologi.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("general") && type_tag.toLowerCase().equals("bisniscorporate"))
                {
                    if (str_LangganBisnis.equals("1"))
                    {
                        str_LangganBisnis = "1";
                        btn_LangganBisnis.setText("Hapus");
                        btn_LangganBisnis.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganBisnis.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganBisnis = "0";
                        btn_LangganBisnis.setText("Langganan");
                        btn_LangganBisnis.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganBisnis.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("general") && type_tag.toLowerCase().equals("pemerintah"))
                {
                    if (str_LangganPemerintah.equals("1"))
                    {
                        str_LangganPemerintah = "1";
                        btn_LangganPemerintah.setText("Hapus");
                        btn_LangganPemerintah.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganPemerintah.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganPemerintah = "0";
                        btn_LangganPemerintah.setText("Langganan");
                        btn_LangganPemerintah.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganPemerintah.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("general") && type_tag.toLowerCase().equals("gayahidup"))
                {
                    if (str_LangganGayaHidup.equals("1"))
                    {
                        str_LangganGayaHidup = "1";
                        btn_LangganGayaHidup.setText("Hapus");
                        btn_LangganGayaHidup.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganGayaHidup.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganGayaHidup = "0";
                        btn_LangganGayaHidup.setText("Langganan");
                        btn_LangganGayaHidup.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganGayaHidup.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("general") && type_tag.toLowerCase().equals("tokomstartup"))
                {
                    if (str_LangganTokoh.equals("1"))
                    {
                        str_LangganTokoh = "1";
                        btn_LangganTokoh.setText("Hapus");
                        btn_LangganTokoh.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganTokoh.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganTokoh = "0";
                        btn_LangganTokoh.setText("Langganan");
                        btn_LangganTokoh.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganTokoh.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("general") && type_tag.toLowerCase().equals("komunitas"))
                {
                    if (str_LangganKomunitas.equals("1"))
                    {
                        str_LangganKomunitas = "1";
                        btn_LangganKomunitas.setText("Hapus");
                        btn_LangganKomunitas.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganKomunitas.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganKomunitas = "0";
                        btn_LangganKomunitas.setText("Langganan");
                        btn_LangganKomunitas.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganKomunitas.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                } else
                if (type.equals("general") && type_tag.toLowerCase().equals("start_up"))
                {
                    if (str_LangganStartup.equals("1"))
                    {
                        str_LangganStartup = "1";
                        btn_LangganStartup.setText("Hapus");
                        btn_LangganStartup.setBackgroundResource(0x7f02013a);
                        try
                        {
                            btn_LangganStartup.setTextColor(colorsHapus);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    } else
                    {
                        str_LangganStartup = "0";
                        btn_LangganStartup.setText("Langganan");
                        btn_LangganStartup.setBackgroundResource(0x7f020137);
                        try
                        {
                            btn_LangganStartup.setTextColor(colorsIkuti);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void void1) { }
                    }
                }
                if (true)
                {
                    break MISSING_BLOCK_LABEL_151;
                }
            }
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(HomeNewsActivity.this, postMessageSubsNews, 1).show();
                statSubNews.equals("1");
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            } else
            {
                Toast.makeText(HomeNewsActivity.this, postMessageSubsNews, 1).show();
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statSubNews.equals("1"))
            {
                mDialog = ProgressDialog.show(HomeNewsActivity.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(HomeNewsActivity.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public SubsNewsTask()
        {
            this$0 = HomeNewsActivity.this;
            super();
        }
    }


    public static final String ANY = "Any";
    public static final String ARG_ITEM_ID = "home_fragment";
    public static final String WIFI = "Wi-Fi";
    private static boolean mobileConnected = false;
    public static boolean refreshDisplay = true;
    public static String sPref = null;
    private static boolean wifiConnected = false;
    int CONNECTION_STAT;
    AlertDialog alertDialog;
    Animation animMove;
    Animation animMove2;
    ArrayList array2ListAds;
    ArrayList arrayListAds;
    ArrayList arrayListNews;
    ArrayList arrayRandomListNews;
    String bottom_id;
    private BufferedReader breader;
    Button btn_LangganAndroid;
    Button btn_LangganAplikasi;
    Button btn_LangganAxis;
    Button btn_LangganBisnis;
    Button btn_LangganBlackBerry;
    Button btn_LangganCeria;
    Button btn_LangganECommerce;
    Button btn_LangganEsia;
    Button btn_LangganFirmware;
    Button btn_LangganGadget;
    Button btn_LangganGame;
    Button btn_LangganGayaHidup;
    Button btn_LangganIOS;
    Button btn_LangganIndosat;
    Button btn_LangganInternet;
    Button btn_LangganKomunitas;
    Button btn_LangganPemerintah;
    Button btn_LangganPlatformLain;
    Button btn_LangganSmartfren;
    Button btn_LangganStartup;
    Button btn_LangganTeknologi;
    Button btn_LangganTelkom;
    Button btn_LangganTelkomsel;
    Button btn_LangganTips;
    Button btn_LangganTokoh;
    Button btn_LangganTri;
    Button btn_LangganWindowsPhone;
    Button btn_LangganXL;
    android.app.AlertDialog.Builder builderKomen;
    ConnectivityManager cm;
    String codename;
    ColorStateList colorsHapus;
    ColorStateList colorsIkuti;
    int countList_rss;
    int count_task;
    CustomPagerAdapter custom2PagerAdapter;
    CustomNewsPagerAdapter customNewsPagerAdapter;
    CustomPagerAdapter customPagerAdapter;
    CustomNewsPagerAdapter customRandomNewsPagerAdapter;
    String dataSubscribe;
    Bundle extras;
    String fav_stat;
    String gambar;
    final Handler handler = new Handler();
    RelativeLayout home_menu_news_tips;
    String hrg_baru;
    String hrg_bekas;
    String id_hp;
    String id_rss;
    String id_subs;
    String idkom_pos;
    ImageView imgHpRandom;
    ImageView img_dislikerandom_ponsel;
    ImageView img_label_actionbar;
    ImageView img_likerandom_ponsel;
    RelativeLayout img_slideshow_layout;
    JSONArray inponsel;
    boolean isExpand;
    JSONArray jArray;
    JSONObject json;
    String jum_komen;
    String jum_komenLikePonPend;
    String kategori;
    String kategori_tag;
    String lastid;
    RelativeLayout lay_Komen_lainnya;
    RelativeLayout lay_head_rssnews;
    LayoutInflater layoutInflater;
    LinearLayout layout_rssfeed;
    String like_stat;
    int limit;
    LinearLayout listBerita;
    ListView listKomen;
    TextView list_txtHarga;
    TextView list_txtHargaRandom;
    TextView list_txtMerek;
    TextView list_txtMerekRandom;
    LinearLayout ll_head_1;
    boolean load_more;
    private ArrayList mArrayListRSSData;
    View mLinearViewAds;
    View mLinearViewAds2FBGoogle;
    View mLinearViewAdsFBGoogle;
    View mLinearViewAdsInPonsel;
    View mLinearViewJempol;
    View mLinearViewNewsSlide;
    View mLinearViewTurun;
    String merk;
    String message;
    String model;
    String namalengkap;
    String namalengkapbgskrg;
    int newBmapHeight;
    int newBmapWidth;
    NotificationLikeHelper notificationLikeHelper;
    String oldid;
    int page_count;
    int page_counter;
    XmlResourceParser parserHapus;
    XmlResourceParser parserIkuti;
    String penurunan_harga;
    Picasso picasso;
    int position1;
    int position2;
    int position3;
    int position4;
    String postMessage;
    String postMessageAddRss;
    String postMessageLikePon;
    String postMessagePendLikePon;
    String postMessageSubsNews;
    String postStatus;
    String postStatusAddRss;
    String postStatusLikePon;
    String postStatusPendLikePon;
    String postStatusSubsNews;
    SharedPreferences prefGCM;
    SmoothProgressBar progbar_roomhp;
    ProgressBar progressbar_headline;
    CircularProgressBar progressbar_hp_random;
    ProgressBar progressbar_middle;
    SmoothProgressBar progressbar_rssfeed;
    CircularProgressBar progressbar_rssfeedmore;
    CircularProgressBar progressbar_viewpager_2_ads;
    CircularProgressBar progressbar_viewpager_ads;
    CircularProgressBar progressbar_viewpager_head_news;
    CircularProgressBar progressbar_viewpager_tips_news;
    String random_codename;
    String random_harga_hp;
    String random_id_hp;
    String random_img_url;
    String random_kategori[] = {
        "Android", "Telkomsel", "E-Commerce"
    };
    String random_like;
    String random_merek_hp;
    String random_umu_status;
    private NetworkReceiver receiver;
    String regexURL;
    String regid;
    String resFav;
    RelativeLayout rl_actionbarforum;
    RelativeLayout rl_hnews_Favorit;
    RelativeLayout rl_hnews_berlangganan;
    RelativeLayout rl_hnews_terkomentari;
    RelativeLayout rl_hnews_terpopuler;
    RelativeLayout rl_hp_random;
    RelativeLayout rl_slideshow_ads;
    RelativeLayout rl_slideshow_tips_news;
    String rss_content;
    String rss_date;
    String rss_desc;
    String rss_id;
    String rss_img;
    String rss_img_ava;
    String rss_img_single;
    String rss_portal;
    String rss_srclink;
    String rss_title;
    String searchcode;
    View slidingView;
    String statFav;
    String statSubNews;
    String statusLikeHp;
    boolean stopSliding2Ads;
    boolean stopSlidingAds;
    boolean stopSlidingHeadNewsHeadNews;
    boolean stopSlidingTipsNews;
    String strKonekStat;
    String str_LangganAndroid;
    String str_LangganAplikasi;
    String str_LangganAxis;
    String str_LangganBisnis;
    String str_LangganBlackBerry;
    String str_LangganCeria;
    String str_LangganECommerce;
    String str_LangganEsia;
    String str_LangganFirmware;
    String str_LangganGadget;
    String str_LangganGame;
    String str_LangganGayaHidup;
    String str_LangganIOS;
    String str_LangganIndosat;
    String str_LangganInternet;
    String str_LangganKomunitas;
    String str_LangganPemerintah;
    String str_LangganPlatformLain;
    String str_LangganSmartfren;
    String str_LangganStartup;
    String str_LangganTeknologi;
    String str_LangganTelkom;
    String str_LangganTelkomsel;
    String str_LangganTips;
    String str_LangganTokoh;
    String str_LangganTri;
    String str_LangganWindowsPhone;
    String str_LangganXL;
    String str_msg_notlogin;
    String str_srclink;
    String str_title_notlogin;
    String suc;
    String succesStat;
    String success;
    ParallaxScrollView sv_root;
    String t;
    String tag_code;
    String tag_key;
    String tag_key_single;
    String tag_timeline;
    Timer timer1;
    Timer timer2;
    Timer timer3;
    Timer timer4;
    TimerTask timerTask1;
    TimerTask timerTask2;
    TimerTask timerTask3;
    TimerTask timerTask4;
    String title_bar;
    String title_single;
    String top_id;
    String tot_LikePon;
    String tot_LikePonPend;
    String tot_dislike;
    String tot_komen;
    String tot_like;
    String total_komen;
    String total_like;
    String totdis_LikePon;
    String totdis_LikePonPend;
    TextView txtLikeKom;
    TextView txtMoreJempolInPonsel;
    TextView txt_label_actionbar;
    TextView txt_news_tips;
    TextView txt_sublabel_actionbar;
    String type;
    String type_tag;
    String url2Ads;
    String urlAds;
    String urlHeadline;
    String urlKomen;
    String urlKomenLast;
    String urlKomenOld;
    String urlRSS;
    String urlRSSMore;
    String urlTipsNews;
    String urlTurunHp;
    private DobSlidingMenu vSlidingMenu;
    private AutoScrollViewPager view_pager_2_ads;
    private AutoScrollViewPager view_pager_ads;
    private AutoScrollViewPager view_pager_head_news;
    private AutoScrollViewPager view_pager_tips_news;
    private Window wind;

    public HomeNewsActivity()
    {
        strKonekStat = "";
        urlRSS = "";
        urlRSSMore = "";
        page_count = 1;
        count_task = 1;
        regid = "";
        suc = "";
        t = Utility.session(RestClient.pelihara);
        searchcode = "";
        regexURL = "<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>";
        postStatusAddRss = "";
        postMessageAddRss = "";
        oldid = "";
        lastid = "0";
        urlKomen = "";
        urlKomenOld = "";
        urlKomenLast = "";
        rss_img = "";
        postStatus = "";
        postMessage = "";
        limit = 0;
        page_counter = 1;
        postStatusPendLikePon = "";
        postMessagePendLikePon = "";
        tot_LikePonPend = "0";
        totdis_LikePonPend = "0";
        jum_komenLikePonPend = "0";
        bottom_id = "";
        top_id = "0";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        CONNECTION_STAT = 10;
        stopSlidingHeadNewsHeadNews = false;
        receiver = new NetworkReceiver();
        kategori_tag = "";
        idkom_pos = "";
        str_srclink = "";
        arrayListNews = null;
        arrayRandomListNews = null;
        countList_rss = 0;
        load_more = false;
        stopSlidingAds = false;
        arrayListAds = null;
        urlAds = "";
        stopSliding2Ads = false;
        url2Ads = "";
        array2ListAds = null;
        statusLikeHp = "";
        postStatusLikePon = "";
        postMessageLikePon = "";
        namalengkapbgskrg = "";
        stopSlidingTipsNews = false;
        urlTipsNews = "";
        title_single = "";
        tag_key_single = "";
        rss_img_single = "";
        kategori = "";
        tag_key = "";
        isExpand = false;
        tag_timeline = "";
        title_bar = "";
        tag_code = "";
        dataSubscribe = "";
        inponsel = null;
        success = "";
        str_LangganAndroid = "0";
        str_LangganBlackBerry = "0";
        str_LangganIOS = "0";
        str_LangganWindowsPhone = "0";
        str_LangganPlatformLain = "0";
        str_LangganTelkomsel = "0";
        str_LangganXL = "0";
        str_LangganIndosat = "0";
        str_LangganTri = "0";
        str_LangganAxis = "0";
        str_LangganSmartfren = "0";
        str_LangganCeria = "0";
        str_LangganEsia = "0";
        str_LangganTelkom = "0";
        str_LangganAplikasi = "0";
        str_LangganGame = "0";
        str_LangganTips = "0";
        str_LangganInternet = "0";
        str_LangganFirmware = "0";
        str_LangganGadget = "0";
        str_LangganECommerce = "0";
        str_LangganTeknologi = "0";
        str_LangganBisnis = "0";
        str_LangganPemerintah = "0";
        str_LangganGayaHidup = "0";
        str_LangganTokoh = "0";
        str_LangganKomunitas = "0";
        str_LangganStartup = "0";
        statSubNews = "";
        id_subs = "";
        type = "";
        type_tag = "";
        str_title_notlogin = "Perhatian";
        str_msg_notlogin = "Untuk mengikuti berita diharuskan login terlebih dahulu";
        position1 = 0;
        position2 = 0;
        position3 = 0;
        position4 = 0;
    }

    private void GetInboxGroupList()
    {
        MyObjectRequest myobjectrequest = new MyObjectRequest((new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("list_chat_group").append(Utility.BASE_FORMAT).append("?").append("id_user=").append(user_id).append("&t=").append(t).toString(), new com.android.volley.Response.Listener() {

            final HomeNewsActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSONGroupChat(jsonobject.toString());
                ponselBaseApp.getObserver().setLoginStat("1");
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final HomeNewsActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(myobjectrequest, "tag_json_obj");
    }

    private void LoginPopup(String s, String s1)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(s);
        builder.setMessage(s1);
        builder.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(HomeNewsActivity.this, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        builder.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(HomeNewsActivity.this, com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        builder.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        builder.show();
    }

    private void loadPage()
    {
        if (sPref.equals("Any") || wifiConnected || mobileConnected || sPref.equals("Wi-Fi") || wifiConnected)
        {
            Log.e("networkStateReceiver", "isOnline");
            if (mArrayListRSSData.size() <= 0)
            {
                startTask();
            }
            return;
        } else
        {
            showErrorPage();
            return;
        }
    }

    private void load_more_rss()
    {
        (new Handler()).postDelayed(new Runnable() {

            final HomeNewsActivity this$0;

            public void run()
            {
                sv_root.scrollBy(0, 100);
                mArrayListRSSData.clear();
                Log.e("mArrayListRSSData", String.valueOf(mArrayListRSSData.size()));
                RSSAsycMoreTask rssasycmoretask = new RSSAsycMoreTask();
                Log.e("page_count", (new StringBuilder(String.valueOf(String.valueOf(page_count)))).append("-").append(String.valueOf(count_task)).toString());
                if (page_count - count_task == 0)
                {
                    HomeNewsActivity homenewsactivity = HomeNewsActivity.this;
                    homenewsactivity.page_count = homenewsactivity.page_count + 1;
                    urlRSSMore = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_count).toString();
                    Log.e("urlRSSMore", urlRSSMore);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        rssasycmoretask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    } else
                    {
                        rssasycmoretask.execute(new String[0]);
                    }
                }
                Log.e("page_task", (new StringBuilder(String.valueOf(String.valueOf(page_count)))).append("=").append(String.valueOf(count_task)).toString());
                Log.e("MyScrollView", "MyScrollView: Bottom has been reached");
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        }, 1000L);
    }

    private void load_random_hp()
    {
        String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_random_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).toString();
        Log.e("randomhp", s);
        (new AsyncHttpClient()).get(s, new AsyncHttpResponseHandler() {

            final HomeNewsActivity this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                progressbar_hp_random.setVisibility(0);
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                i = 0;
_L3:
                if (i < 1) goto _L2; else goto _L1
_L1:
                rl_hp_random.setVisibility(0);
                list_txtMerekRandom.setText(random_merek_hp);
                if (random_umu_status.equals("3") || random_harga_hp.equals("-") || random_harga_hp.equals("0"))
                {
                    list_txtHargaRandom.setVisibility(8);
                } else
                {
                    list_txtHargaRandom.setText(random_harga_hp);
                }
                if (random_like.equals("1"))
                {
                    img_likerandom_ponsel.setBackgroundResource(0x7f02025b);
                    img_dislikerandom_ponsel.setBackgroundResource(0x7f0201a3);
                    img_likerandom_ponsel.setEnabled(false);
                    img_dislikerandom_ponsel.setEnabled(true);
                } else
                if (random_like.equals("0"))
                {
                    img_likerandom_ponsel.setBackgroundResource(0x7f020257);
                    img_dislikerandom_ponsel.setBackgroundResource(0x7f0201a7);
                    img_likerandom_ponsel.setEnabled(true);
                    img_dislikerandom_ponsel.setEnabled(false);
                } else
                {
                    img_likerandom_ponsel.setEnabled(true);
                    img_dislikerandom_ponsel.setEnabled(true);
                    img_likerandom_ponsel.setBackgroundResource(0x7f020257);
                    img_dislikerandom_ponsel.setBackgroundResource(0x7f0201a3);
                }
                Picasso.with(HomeNewsActivity.this).load(random_img_url.trim()).tag(this).into(imgHpRandom, new Callback() {

                    final _cls79 this$1;

                    public void onError()
                    {
                        progressbar_hp_random.setVisibility(8);
                    }

                    public void onSuccess()
                    {
                        progressbar_hp_random.setVisibility(8);
                    }

            
            {
                this$1 = _cls79.this;
                super();
            }
                });
                img_likerandom_ponsel.setEnabled(true);
                img_dislikerandom_ponsel.setEnabled(true);
                return;
_L2:
                abyte0 = aheader.getJSONObject(i);
                random_id_hp = abyte0.getString("id_hp");
                random_codename = abyte0.getString("codename");
                random_umu_status = abyte0.getString("umu_status");
                random_img_url = abyte0.getString("gambar");
                random_merek_hp = (new StringBuilder(String.valueOf(abyte0.getString("merk")))).append(" ").append(abyte0.getString("model")).toString();
                namalengkapbgskrg = random_merek_hp;
                random_harga_hp = abyte0.getString("hrg_baru");
                random_like = abyte0.getString("my_like_pon");
                i++;
                  goto _L3
                aheader;
                aheader.printStackTrace();
                  goto _L1
            }


            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
    }

    private void parseJSONAddFav(String s)
    {
        int i;
        try
        {
            s = new JSONObject(s);
            postStatusAddRss = s.getString("success");
            postMessageAddRss = s.getString("message");
            Log.e("idkom_pos", idkom_pos);
            jArray = s.getJSONArray("InPonsel");
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
            ponselBaseApp.getObserver().setFav_stat_rss(statFav);
            ponselBaseApp.getObserver().setIndexRSS(idkom_pos);
            return;
        }
        s = jArray.getJSONObject(i);
        if (!statFav.equals("0"))
        {
            rss_content = s.getString("rss_content");
        }
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_54;
        }
    }

    private void sendRequest()
    {
        urlHeadline = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_rss_headline").append(Utility.BASE_FORMAT).append("?lmt=0&t=").append(t).append("&idusr=").append(user_id).append("&tag=tagall").toString();
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(urlHeadline, new AsyncHttpResponseHandler() {

            final HomeNewsActivity this$0;

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
                aheader = new String(abyte0);
                Log.e("responseHeadNews", aheader);
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                Log.e("jsonArray", (new StringBuilder("jsonArray")).append(String.valueOf(aheader.length())).toString());
                i = 0;
_L3:
                int j = aheader.length();
                if (i < j) goto _L2; else goto _L1
_L1:
                Log.e("arrayListNews", (new StringBuilder("arrayListNews")).append(String.valueOf(arrayListNews.size())).toString());
                customNewsPagerAdapter.notifyDataSetChanged();
                return;
_L2:
                abyte0 = aheader.getJSONObject(i);
                ListModel listmodel = new ListModel();
                listmodel.setId_rss(Integer.parseInt(abyte0.getString("id")));
                listmodel.setName(abyte0.getString("rss_title"));
                listmodel.setSumber(abyte0.getString("rss_portal"));
                listmodel.setImageUrl(abyte0.getString("rss_img"));
                arrayListNews.add(listmodel);
                i++;
                  goto _L3
                aheader;
                aheader.printStackTrace();
                  goto _L1
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
    }

    private void sendRequest2Ads()
    {
        url2Ads = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_ads_home").append(Utility.BASE_FORMAT).append("?hal=52").append("&pver=").append(SplashScreen.curVersion).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=tagall").toString();
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(url2Ads, new AsyncHttpResponseHandler() {

            final HomeNewsActivity this$0;

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
                aheader = new String(abyte0);
                Log.e("responseHeadNews", aheader);
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                i = 0;
_L3:
                int j = aheader.length();
                if (i < j) goto _L2; else goto _L1
_L1:
                Log.e("array2ListAds", String.valueOf(array2ListAds.size()));
                custom2PagerAdapter.notifyDataSetChanged();
                return;
_L2:
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
                  goto _L3
                aheader;
                aheader.printStackTrace();
                  goto _L1
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
    }

    private void sendRequestAds()
    {
        urlAds = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_ads_home").append(Utility.BASE_FORMAT).append("?hal=51").append("&pver=").append(SplashScreen.curVersion).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=tagall").toString();
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(urlAds, new AsyncHttpResponseHandler() {

            final HomeNewsActivity this$0;

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
                float f3;
                float f4;
                rl_slideshow_ads.setVisibility(0);
                aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
                abyte0 = new DisplayMetrics();
                aheader.getMetrics(abyte0);
                i = ((DisplayMetrics) (abyte0)).widthPixels;
                float f = Utility.aspectratio(Integer.parseInt("1024"), Integer.parseInt("600"));
                f3 = (float)Integer.parseInt("1024") / f;
                f4 = (float)Integer.parseInt("600") / f;
                Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f3))).append(" : ").append(f4).toString()));
                float f1;
                float f2;
                f1 = i;
                if (f3 <= f4)
                {
                    break MISSING_BLOCK_LABEL_486;
                }
                f2 = f1;
                f1 = Math.round((f1 * f4) / f3);
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(f2))).append(" : ").append(f1).toString()));
_L7:
                rl_slideshow_ads.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)f2, (int)f1));
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
                f2 = Math.round((f1 * f4) / f3);
                Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(f2))).append(" : ").append(f1).toString()));
                  goto _L7
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
    }

    private void sendRequestTipsNews()
    {
        urlTipsNews = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_news_single").append(Utility.BASE_FORMAT).append("?lmt=0&t=").append(t).append("&idusr=").append(user_id).append("&tag=").toString();
        Log.e("urlTipsNews", urlTipsNews);
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        asynchttpclient.setMaxRetriesAndTimeout(5, 10000);
        asynchttpclient.get(urlTipsNews, new AsyncHttpResponseHandler() {

            final HomeNewsActivity this$0;

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
                aheader = new String(abyte0);
                Log.e("responseHeadNews", aheader);
                abyte0 = new JSONObject(aheader);
                aheader = abyte0.getJSONArray("InPonsel");
                txt_news_tips.setText((new StringBuilder("Artikel ")).append(abyte0.getString("kategori")).append(" lainnya").toString());
                title_single = abyte0.getString("kategori");
                tag_key_single = abyte0.getString("tag");
                Log.e("jsonArray", (new StringBuilder("jsonArray")).append(String.valueOf(aheader.length())).toString());
                i = 0;
_L3:
                int j = aheader.length();
                if (i < j) goto _L2; else goto _L1
_L1:
                Log.e("arrayRandomListNews", (new StringBuilder("arrayRandomListNews")).append(String.valueOf(arrayRandomListNews.size())).toString());
                customRandomNewsPagerAdapter.notifyDataSetChanged();
                if (rss_img_single.equals("") || rss_img_single == null)
                {
                    sendRequestTipsNews();
                }
                return;
_L2:
                abyte0 = aheader.getJSONObject(i);
                ListModel listmodel = new ListModel();
                listmodel.setId_rss(Integer.parseInt(abyte0.getString("id")));
                listmodel.setName(abyte0.getString("rss_title"));
                listmodel.setSumber(abyte0.getString("rss_portal"));
                listmodel.setImageUrl(abyte0.getString("rss_img"));
                rss_img_single = abyte0.getString("rss_img");
                arrayRandomListNews.add(listmodel);
                i++;
                  goto _L3
                aheader;
                aheader.printStackTrace();
                  goto _L1
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
    }

    private void showErrorPage()
    {
        Log.e("networkStateReceiver", "false");
        Utility.show_dialog(this);
    }

    private void startTask()
    {
        sendRequest();
        Log.e("requestHeadNewsTask", "start");
        urlRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_home").append(Utility.BASE_FORMAT).append("?").append("lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").toString();
        urlHeadline = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_rss_headline").append(Utility.BASE_FORMAT).append("?lmt=0&t=").append(t).append("&idusr=").append(user_id).append("&tag=tagall").toString();
        Log.e("urlHeadline", urlHeadline);
        Log.e("urlRSS", urlRSS);
        Log.e("headlineRss", "start");
        sendRequestAds();
        if (mArrayListRSSData.size() == 0)
        {
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new RSSAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            } else
            {
                (new RSSAsycTask()).execute(new String[0]);
            }
        }
        load_random_hp();
        sendRequestTipsNews();
    }

    private void updateConnectedFlags()
    {
        boolean flag1 = true;
        NetworkInfo networkinfo = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo != null && networkinfo.isConnected())
        {
            boolean flag;
            if (networkinfo.getType() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            wifiConnected = flag;
            if (networkinfo.getType() == 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            mobileConnected = flag;
            return;
        } else
        {
            wifiConnected = false;
            mobileConnected = false;
            return;
        }
    }

    public void TimelineTask()
    {
        if (Utility.hasActiveInternetConnection(this))
        {
            mArrayListRSSData.clear();
            listBerita.removeAllViewsInLayout();
            listBerita.removeAllViews();
            progressbar_rssfeed.setVisibility(0);
            page_counter = 1;
            countList_rss = 0;
            if (tag_timeline.equals("") || tag_timeline.equals("terbaru"))
            {
                urlRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
            } else
            if (tag_timeline.equals("terkomentari"))
            {
                urlRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_reader_bykom").append(Utility.BASE_FORMAT).append("?").append("lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
            } else
            if (tag_timeline.equals("terpopuler"))
            {
                urlRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_mostpopular").append(Utility.BASE_FORMAT).append("?").append("lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
            } else
            {
                urlRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
            }
            Log.e("urlRSSlist", urlRSS);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new RSSAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            } else
            {
                (new RSSAsycTask()).execute(new String[0]);
                return;
            }
        } else
        {
            Utility.show_dialog(this);
            return;
        }
    }

    public boolean checkURL(String s)
    {
        return s.matches(regexURL);
    }

    public String getJSONFile(String s)
        throws Exception
    {
        File file = new File(Environment.getExternalStorageDirectory(), (new StringBuilder("/Android/data/")).append(getPackageName()).append("/cache/").append(s).toString());
        s = new StringBuilder();
        breader = new BufferedReader(new FileReader(file));
        do
        {
            String s1 = breader.readLine();
            if (s1 == null)
            {
                EncodeDecodeAES.decrypt(RestClient.pelihara, String.valueOf(s));
                return EncodeDecodeAES.decrypt(RestClient.pelihara, String.valueOf(s));
            }
            s.append(s1);
            s.append('\n');
        } while (true);
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
        if (mDrawerLayout.isDrawerOpen(0x800003))
        {
            mDrawerLayout.closeDrawers();
            Log.e("vis", "on");
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        mDrawerToggle.onConfigurationChanged(configuration);
        getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>")).append(getString(0x7f0c0035)).append("</font>").toString()));
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030133, null, false);
        mDrawerLayout.addView(bundle, 0);
        bundle = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        receiver = new NetworkReceiver();
        registerReceiver(receiver, bundle);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        int i = (int)(Math.random() * 2D);
        Log.e("random", random_kategori[i]);
        t = Utility.session(t);
        animMove = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040014);
        animMove2 = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040015);
        animMove.setAnimationListener(this);
        animMove2.setAnimationListener(this);
        Object obj;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Halaman Utama");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        cm = (ConnectivityManager)getSystemService("connectivity");
        t = Utility.session(t);
        searchcode = t;
        prefGCM = getApplicationContext().getSharedPreferences("GCMPref", 0);
        getSherlock().setProgressBarIndeterminateVisibility(false);
        getSherlock().setProgressBarVisibility(false);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        actionBar.setDisplayShowTitleEnabled(false);
        bundle = LayoutInflater.from(this).inflate(0x7f030018, null);
        obj = getResources().getDrawable(0x7f0200ce);
        ((Drawable) (obj)).setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_ATOP);
        rl_actionbarforum = (RelativeLayout)bundle.findViewById(0x7f0b005c);
        txt_label_actionbar = (TextView)bundle.findViewById(0x7f0b005d);
        txt_sublabel_actionbar = (TextView)bundle.findViewById(0x7f0b005e);
        txt_label_actionbar.setSelected(true);
        img_label_actionbar = (ImageView)bundle.findViewById(0x7f0b005f);
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            img_label_actionbar.setBackgroundDrawable(((Drawable) (obj)));
            txt_sublabel_actionbar.setBackgroundDrawable(((Drawable) (obj)));
        } else
        {
            img_label_actionbar.setBackground(((Drawable) (obj)));
            txt_sublabel_actionbar.setBackground(((Drawable) (obj)));
        }
        actionBar.setCustomView(bundle);
        actionBar.setDisplayShowCustomEnabled(true);
        extras = getIntent().getExtras();
        try
        {
            parserHapus = getResources().getXml(0x7f080194);
            colorsHapus = ColorStateList.createFromXml(getResources(), parserHapus);
            parserIkuti = getResources().getXml(0x7f080197);
            colorsIkuti = ColorStateList.createFromXml(getResources(), parserIkuti);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        try
        {
            vSlidingMenu = new DobSlidingMenu(this);
            vSlidingMenu.setSlidingType(com.dobmob.dobsliding.models.SlidingItem.SlidingType.MOVE);
            vSlidingMenu.setSlidingView(0x7f030105);
            vSlidingMenu.setUseHandle(false);
            vSlidingMenu.setMaxDuration(500);
            vSlidingMenu.setOnCollapsedListener(new OnCollapsedListener() {

                final HomeNewsActivity this$0;

                public void onCollapsed()
                {
                    Log.i(HomeNewsActivity.TAG, "onCollapsed");
                    isExpand = false;
                }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
            });
            vSlidingMenu.setOnExpandedListener(new OnExpandedListener() {

                final HomeNewsActivity this$0;

                public void onExpanded()
                {
                    Log.i(HomeNewsActivity.TAG, "onExpanded");
                    isExpand = true;
                }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        txt_label_actionbar.setText("Berita");
        rl_actionbarforum.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (isExpand)
                {
                    vSlidingMenu.collapse();
                    return;
                } else
                {
                    vSlidingMenu.expand();
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        tag_timeline = extras.getString("tag_timeline");
        tag_code = extras.getString("tag_code");
        if (tag_timeline.equals("terbaru"))
        {
            title_bar = "Terbaru";
            tag_timeline = "terbaru";
        } else
        if (tag_timeline.equals("terpopuler"))
        {
            title_bar = "Terpopuler";
            tag_timeline = "terpopuler";
        } else
        if (tag_timeline.equals("terkomentari"))
        {
            title_bar = "Terkomentari";
            tag_timeline = "terkomentari";
        } else
        if (tag_timeline.equals("Android"))
        {
            title_bar = "Android";
            tag_timeline = "Android";
        } else
        if (tag_timeline.equals("iOS"))
        {
            title_bar = "IOS";
            tag_timeline = "iOS";
        } else
        if (tag_timeline.equals("BlackBerry OS"))
        {
            title_bar = "BlackBerry";
            tag_timeline = "blackberry";
        } else
        if (tag_timeline.equals("Windows Phone"))
        {
            title_bar = "Windows Phone";
            tag_timeline = "windowsphone";
        } else
        if (tag_timeline.equals("Internet & Social Media"))
        {
            title_bar = "Internet & Social Media";
            tag_timeline = "inetsocmed";
        } else
        if (tag_timeline.equals("Aplikasi"))
        {
            title_bar = "Aplikasi";
            tag_timeline = "aplikasi";
        } else
        if (tag_timeline.equals("Tips & Trik"))
        {
            title_bar = "Tips & Trik";
            tag_timeline = "tipstrik";
        } else
        if (tag_timeline.equals("Game"))
        {
            title_bar = "Game";
            tag_timeline = "permainan";
        } else
        if (tag_timeline.equals("Tips & Trik"))
        {
            title_bar = "Tips & Trik";
            tag_timeline = "tipstrik";
        } else
        if (tag_timeline.equals("E-Commerce"))
        {
            title_bar = "E-Commerce";
            tag_timeline = "ecommerce";
        } else
        {
            title_bar = "Terbaru";
            tag_timeline = "terbaru";
        }
        txt_sublabel_actionbar.setText(title_bar);
        sv_root = (ParallaxScrollView)findViewById(0x7f0b089e);
        sv_root.setScrollViewListener(this);
        progressbar_headline = (ProgressBar)findViewById(0x7f0b02d3);
        arrayListNews = new ArrayList();
        view_pager_head_news = (AutoScrollViewPager)findViewById(0x7f0b02d5);
        view_pager_head_news.setPageMargin((int)Utility.convertDpToPixel(15F, this));
        view_pager_head_news.setOffscreenPageLimit(5);
        customNewsPagerAdapter = new CustomNewsPagerAdapter(this, arrayListNews, view_pager_head_news, sv_root, progressbar_headline);
        view_pager_head_news.setAdapter(customNewsPagerAdapter);
        view_pager_head_news.setInterval(5000L);
        view_pager_head_news.startAutoScroll();
        notificationLikeHelper = new NotificationLikeHelper(this);
        bundle = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        obj = new DisplayMetrics();
        bundle.getMetrics(((DisplayMetrics) (obj)));
        (new android.widget.FrameLayout.LayoutParams(((DisplayMetrics) (obj)).widthPixels - (int)Utility.convertDpToPixel(50F, this), (int)Utility.convertDpToPixel(200F, this))).gravity = 1;
        img_slideshow_layout = (RelativeLayout)findViewById(0x7f0b02d2);
        txtUnreadCount = (TextView)findViewById(0x7f0b0423);
        txtUnreadGroupChat = (TextView)findViewById(0x7f0b0427);
        progressbar_rssfeed = (SmoothProgressBar)findViewById(0x7f0b02d8);
        progressbar_rssfeedmore = (CircularProgressBar)findViewById(0x7f0b08ef);
        txtUnreadCount.setVisibility(8);
        txtUnreadGroupChat.setVisibility(8);
        lay_Komen_lainnya = (RelativeLayout)findViewById(0x7f0b02c2);
        lay_head_rssnews = (RelativeLayout)findViewById(0x7f0b02bd);
        picasso = Picasso.with(this);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        mLinearViewAds = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03004d, null);
        mLinearViewJempol = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03013d, null);
        img_likerandom_ponsel = (ImageView)mLinearViewJempol.findViewById(0x7f0b028c);
        img_dislikerandom_ponsel = (ImageView)mLinearViewJempol.findViewById(0x7f0b028d);
        imgHpRandom = (ImageView)mLinearViewJempol.findViewById(0x7f0b028a);
        progressbar_hp_random = (CircularProgressBar)mLinearViewJempol.findViewById(0x7f0b0289);
        rl_hp_random = (RelativeLayout)mLinearViewJempol.findViewById(0x7f0b0280);
        list_txtMerekRandom = (TextView)mLinearViewJempol.findViewById(0x7f0b0287);
        list_txtHargaRandom = (TextView)mLinearViewJempol.findViewById(0x7f0b028b);
        txtMoreJempolInPonsel = (TextView)mLinearViewJempol.findViewById(0x7f0b0285);
        txtMoreJempolInPonsel.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                load_random_hp();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        mLinearViewAdsInPonsel = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03004d, null);
        mLinearViewTurun = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030146, null);
        list_txtMerek = (TextView)mLinearViewTurun.findViewById(0x7f0b033c);
        list_txtHarga = (TextView)mLinearViewTurun.findViewById(0x7f0b033d);
        mLinearViewNewsSlide = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030140, null);
        home_menu_news_tips = (RelativeLayout)mLinearViewNewsSlide.findViewById(0x7f0b026d);
        view_pager_tips_news = (AutoScrollViewPager)mLinearViewNewsSlide.findViewById(0x7f0b090f);
        arrayRandomListNews = new ArrayList();
        customRandomNewsPagerAdapter = new CustomNewsPagerAdapter(this, arrayRandomListNews, view_pager_tips_news, sv_root, progressbar_headline);
        view_pager_tips_news.setAdapter(customRandomNewsPagerAdapter);
        view_pager_tips_news.setInterval(5000L);
        view_pager_tips_news.startAutoScroll();
        rl_slideshow_tips_news = (RelativeLayout)mLinearViewNewsSlide.findViewById(0x7f0b0268);
        progressbar_viewpager_tips_news = (CircularProgressBar)mLinearViewNewsSlide.findViewById(0x7f0b0269);
        txt_news_tips = (TextView)mLinearViewNewsSlide.findViewById(0x7f0b026e);
        progbar_roomhp = (SmoothProgressBar)findViewById(0x7f0b05db);
        progbar_roomhp.setVisibility(4);
        btn_LangganAndroid = (Button)findViewById(0x7f0b0799);
        btn_LangganBlackBerry = (Button)findViewById(0x7f0b079c);
        btn_LangganIOS = (Button)findViewById(0x7f0b079f);
        btn_LangganWindowsPhone = (Button)findViewById(0x7f0b07a2);
        btn_LangganPlatformLain = (Button)findViewById(0x7f0b07a5);
        btn_LangganTelkomsel = (Button)findViewById(0x7f0b07aa);
        btn_LangganXL = (Button)findViewById(0x7f0b07ad);
        btn_LangganIndosat = (Button)findViewById(0x7f0b07b0);
        btn_LangganTri = (Button)findViewById(0x7f0b07b3);
        btn_LangganAxis = (Button)findViewById(0x7f0b07b6);
        btn_LangganSmartfren = (Button)findViewById(0x7f0b07b9);
        btn_LangganCeria = (Button)findViewById(0x7f0b07bc);
        btn_LangganEsia = (Button)findViewById(0x7f0b07bf);
        btn_LangganTelkom = (Button)findViewById(0x7f0b07c2);
        btn_LangganAplikasi = (Button)findViewById(0x7f0b07c7);
        btn_LangganGame = (Button)findViewById(0x7f0b07ca);
        btn_LangganTips = (Button)findViewById(0x7f0b07cd);
        btn_LangganInternet = (Button)findViewById(0x7f0b07d0);
        btn_LangganFirmware = (Button)findViewById(0x7f0b07d3);
        btn_LangganGadget = (Button)findViewById(0x7f0b07d5);
        btn_LangganECommerce = (Button)findViewById(0x7f0b07d8);
        btn_LangganTeknologi = (Button)findViewById(0x7f0b07db);
        btn_LangganBisnis = (Button)findViewById(0x7f0b07de);
        btn_LangganPemerintah = (Button)findViewById(0x7f0b07e1);
        btn_LangganGayaHidup = (Button)findViewById(0x7f0b07e4);
        btn_LangganTokoh = (Button)findViewById(0x7f0b07e7);
        btn_LangganKomunitas = (Button)findViewById(0x7f0b07ea);
        btn_LangganStartup = (Button)findViewById(0x7f0b07ed);
        view_pager_ads = (AutoScrollViewPager)mLinearViewAds.findViewById(0x7f0b01f8);
        view_pager_ads.setOffscreenPageLimit(5);
        arrayListAds = new ArrayList();
        customPagerAdapter = new CustomPagerAdapter(this, arrayListAds, view_pager_ads, sv_root);
        view_pager_ads.setAdapter(customPagerAdapter);
        view_pager_ads.setInterval(5000L);
        view_pager_ads.startAutoScroll();
        rl_slideshow_ads = (RelativeLayout)mLinearViewAds.findViewById(0x7f0b01f6);
        progressbar_viewpager_ads = (CircularProgressBar)mLinearViewAds.findViewById(0x7f0b01f7);
        view_pager_2_ads = (AutoScrollViewPager)mLinearViewAdsInPonsel.findViewById(0x7f0b01f8);
        view_pager_2_ads.setOffscreenPageLimit(5);
        array2ListAds = new ArrayList();
        custom2PagerAdapter = new CustomPagerAdapter(this, array2ListAds, view_pager_2_ads, sv_root);
        view_pager_2_ads.setAdapter(custom2PagerAdapter);
        view_pager_2_ads.setInterval(5000L);
        view_pager_2_ads.startAutoScroll();
        progressbar_viewpager_2_ads = (CircularProgressBar)mLinearViewAdsInPonsel.findViewById(0x7f0b01f7);
        img_likerandom_ponsel.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    statusLikeHp = "1";
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new PostBagusKurangTask()).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(HomeNewsActivity.this);
                    view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls5 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        img_dislikerandom_ponsel.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    statusLikeHp = "0";
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new PostBagusKurangTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new PostBagusKurangTask()).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(HomeNewsActivity.this);
                    view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls6 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls6 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls6 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivityForResult(dialoginterface, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        if (userFunctions.isUserLoggedIn(this))
        {
            if (db.getInBoxCount() > 0)
            {
                Log.e("unread", "getTotalUnread");
                bundle = db.getTotalUnread();
                bundle.moveToFirst();
                bundle = bundle.getString(bundle.getColumnIndex("total"));
                if (bundle.equals("0") || bundle.equals(""))
                {
                    txtUnreadCount.setVisibility(8);
                    txtUnreadCount.setText("0");
                } else
                {
                    txtUnreadCount.setText(bundle);
                    txtUnreadCount.setVisibility(0);
                }
            } else
            {
                Log.e("unread", "getTotalUnreadSQLSEQ");
                bundle = db.getTotalUnreadSQLSEQ();
                bundle.moveToFirst();
                bundle = bundle.getString(bundle.getColumnIndex("total"));
                if (bundle.equals("0") || bundle.equals(""))
                {
                    txtUnreadCount.setVisibility(8);
                    txtUnreadCount.setText("0");
                } else
                {
                    txtUnreadCount.setText(bundle);
                    txtUnreadCount.setVisibility(0);
                }
            }
            if (db.getGroupChatCount() > 0)
            {
                bundle = db.getTotalUnreadGroupChat();
                bundle.moveToFirst();
                bundle = bundle.getString(bundle.getColumnIndex("total"));
                if (bundle.equals("0") || bundle.equals(""))
                {
                    txtUnreadGroupChat.setVisibility(8);
                    txtUnreadGroupChat.setText("0");
                } else
                {
                    txtUnreadGroupChat.setText(bundle);
                    txtUnreadGroupChat.setVisibility(0);
                }
            } else
            {
                bundle = getApplicationContext().getSharedPreferences("UnreadGroup", 0).getString("unread_group", null);
                if (bundle.equals("0") || bundle.equals(""))
                {
                    txtUnreadGroupChat.setVisibility(8);
                    txtUnreadGroupChat.setText("0");
                } else
                {
                    txtUnreadGroupChat.setText(bundle);
                    txtUnreadGroupChat.setVisibility(0);
                }
            }
            txtUnreadCount.getText().toString().equals("0");
        }
        rl_hnews_terpopuler = (RelativeLayout)findViewById(0x7f0b08e7);
        rl_hnews_terkomentari = (RelativeLayout)findViewById(0x7f0b08e9);
        rl_hnews_Favorit = (RelativeLayout)findViewById(0x7f0b08eb);
        rl_hnews_berlangganan = (RelativeLayout)findViewById(0x7f0b08ed);
        layout_rssfeed = (LinearLayout)findViewById(0x7f0b02d1);
        layout_rssfeed.setVisibility(0);
        listBerita = (LinearLayout)findViewById(0x7f0b0220);
        mArrayListRSSData = new ArrayList();
        menu_beranda.setOnClickListener(this);
        menu_pesan.setOnClickListener(this);
        menu_GroupChat.setOnClickListener(this);
        menu_katalog.setOnClickListener(this);
        menu_Berita.setOnClickListener(this);
        menu_PusatLayanan.setOnClickListener(this);
        menu_LoginRegister.setOnClickListener(this);
        menu_Bookmark.setOnClickListener(this);
        menu_Setting.setOnClickListener(this);
        menu_KebijakanPrivasi.setOnClickListener(this);
        menu_Tentang.setOnClickListener(this);
        menu_FAQ.setOnClickListener(this);
        menu_profil.setOnClickListener(this);
        slidingView = vSlidingMenu.getSlidingView();
        ll_head_1 = (LinearLayout)slidingView.findViewById(0x7f0b05bc);
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            ll_head_1.setVisibility(8);
        } else
        {
            ll_head_1.setVisibility(0);
        }
        slidingView.findViewById(0x7f0b03d3).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Terbaru");
                vSlidingMenu.collapse();
                tag_timeline = "terbaru";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03d4).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Terpopuler");
                vSlidingMenu.collapse();
                tag_timeline = "terpopuler";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        rl_hnews_terpopuler.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Terpopuler");
                tag_timeline = "terpopuler";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03d5).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Terkomentari");
                tag_timeline = "terkomentari";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        rl_hnews_terkomentari.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Terkomentari");
                tag_timeline = "terkomentari";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        rl_hnews_berlangganan.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/favorit/LanggananBeritaAll);
                    startActivity(i);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, "Fitur ini hanya untuk user terdaftar");
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        rl_hnews_Favorit.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/favorit/FavoritArtikelBerita);
                    startActivity(i);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, "Fitur ini hanya untuk user terdaftar");
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b0797).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Android");
                vSlidingMenu.collapse();
                tag_timeline = "Android";
                tag_code = "OS2";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b079a).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("BlackBerry");
                vSlidingMenu.collapse();
                tag_timeline = "BlackBerry";
                tag_code = "OS4";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b079d).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("IOS");
                vSlidingMenu.collapse();
                tag_timeline = "IOS";
                tag_code = "OS5";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07a0).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Windows Phone");
                vSlidingMenu.collapse();
                tag_timeline = "WindowsPhone";
                tag_code = "OS14";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07a3).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Platform Lain");
                vSlidingMenu.collapse();
                tag_timeline = "PlatformLain";
                tag_code = "OSALL";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07a8).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Telkomsel");
                vSlidingMenu.collapse();
                tag_timeline = "Telkomsel";
                tag_code = "OPTSEL";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07ab).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("XL");
                vSlidingMenu.collapse();
                tag_timeline = "XL";
                tag_code = "OPXL";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07ae).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Indosat");
                vSlidingMenu.collapse();
                tag_timeline = "Indosat";
                tag_code = "OPIND";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07b1).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Tri");
                vSlidingMenu.collapse();
                tag_timeline = "Tri";
                tag_code = "OPTRI";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07b4).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Axis");
                vSlidingMenu.collapse();
                tag_timeline = "Axis";
                tag_code = "OPAXIS";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07b7).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Smartfren");
                vSlidingMenu.collapse();
                tag_timeline = "Smartfren";
                tag_code = "OPSMTF";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07ba).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Ceria");
                vSlidingMenu.collapse();
                tag_timeline = "Ceria";
                tag_code = "OPCERIA";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07bd).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Esia");
                vSlidingMenu.collapse();
                tag_timeline = "Esia";
                tag_code = "OPESIA";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07c0).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Telkom");
                vSlidingMenu.collapse();
                tag_timeline = "Telkom";
                tag_code = "OPTKOM";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07c5).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Aplikasi");
                vSlidingMenu.collapse();
                tag_timeline = "Aplikasi";
                tag_code = "KATAPP";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07c8).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Game");
                vSlidingMenu.collapse();
                tag_timeline = "Game";
                tag_code = "KATGAME";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07cb).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Tips & Trik");
                vSlidingMenu.collapse();
                tag_timeline = "TipsTrik";
                tag_code = "KATTIPS";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07ce).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Internet & Social Media");
                vSlidingMenu.collapse();
                tag_timeline = "Internet";
                tag_code = "KATINET";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07d1).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Firmware");
                vSlidingMenu.collapse();
                tag_timeline = "Firmware";
                tag_code = "KATFIRM";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07d4).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Gadget");
                vSlidingMenu.collapse();
                tag_timeline = "Gadget";
                tag_code = "KATGADGET";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07d6).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("E-Commerce");
                vSlidingMenu.collapse();
                tag_timeline = "ECommerce";
                tag_code = "KATECOM";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07d9).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Teknologi & Science");
                vSlidingMenu.collapse();
                tag_timeline = "Teknologi";
                tag_code = "KATTEKNO";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07dc).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Bisnis & Corporate");
                vSlidingMenu.collapse();
                tag_timeline = "Bisnis";
                tag_code = "KATBIS";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07df).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Pemerintah");
                vSlidingMenu.collapse();
                tag_timeline = "Pemerintah";
                tag_code = "KATGOV";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07e2).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Gaya Hidup");
                vSlidingMenu.collapse();
                tag_timeline = "GayaHidup";
                tag_code = "KATGAYA";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07e5).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Tokoh");
                vSlidingMenu.collapse();
                tag_timeline = "Tokoh";
                tag_code = "KATTOKOH";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07e8).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Komunitas");
                vSlidingMenu.collapse();
                tag_timeline = "Komunitas";
                tag_code = "KATKOM";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07eb).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Startup");
                vSlidingMenu.collapse();
                tag_timeline = "Startup";
                tag_code = "KATSTUP";
                TimelineTask();
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganAndroid.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganAndroid.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganAndroid = "0";
                    } else
                    if (str_LangganAndroid.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganAndroid = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganAndroid = "1";
                    }
                    id_subs = "2";
                    type = "os";
                    type_tag = "android";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganBlackBerry.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganBlackBerry.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganBlackBerry = "0";
                    } else
                    if (str_LangganBlackBerry.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganBlackBerry = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganBlackBerry = "1";
                    }
                    id_subs = "4";
                    type = "os";
                    type_tag = "blackberry";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganIOS.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganIOS.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganIOS = "0";
                    } else
                    if (str_LangganIOS.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganIOS = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganIOS = "1";
                    }
                    id_subs = "5";
                    type = "os";
                    type_tag = "ios";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganWindowsPhone.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganWindowsPhone.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganWindowsPhone = "0";
                    } else
                    if (str_LangganWindowsPhone.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganWindowsPhone = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganWindowsPhone = "1";
                    }
                    id_subs = "14";
                    type = "os";
                    type_tag = "windowsphone";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganPlatformLain.setVisibility(4);
        btn_LangganPlatformLain.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganPlatformLain.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganPlatformLain = "0";
                    } else
                    if (str_LangganPlatformLain.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganPlatformLain = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganPlatformLain = "1";
                    }
                    id_subs = "000";
                    type = "os";
                    type_tag = "platformlain";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganTelkomsel.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganTelkomsel.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganTelkomsel = "0";
                    } else
                    if (str_LangganTelkomsel.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganTelkomsel = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganTelkomsel = "1";
                    }
                    id_subs = "7";
                    type = "op";
                    type_tag = "telkomsel";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganXL.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganXL.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganXL = "0";
                    } else
                    if (str_LangganXL.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganXL = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganXL = "1";
                    }
                    id_subs = "9";
                    type = "op";
                    type_tag = "xl";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganIndosat.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganIndosat.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganIndosat = "0";
                    } else
                    if (str_LangganIndosat.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganIndosat = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganIndosat = "1";
                    }
                    id_subs = "4";
                    type = "op";
                    type_tag = "indosat";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganTri.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganTri.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganTri = "0";
                    } else
                    if (str_LangganTri.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganTri = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganTri = "1";
                    }
                    id_subs = "8";
                    type = "op";
                    type_tag = "tri";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganAxis.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganAxis.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganAxis = "0";
                    } else
                    if (str_LangganAxis.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganAxis = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganAxis = "1";
                    }
                    id_subs = "1";
                    type = "op";
                    type_tag = "axis";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganSmartfren.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganSmartfren.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganSmartfren = "0";
                    } else
                    if (str_LangganSmartfren.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganSmartfren = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganSmartfren = "1";
                    }
                    id_subs = "5";
                    type = "op";
                    type_tag = "smartfren";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganCeria.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganCeria.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganCeria = "0";
                    } else
                    if (str_LangganCeria.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganCeria = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganCeria = "1";
                    }
                    id_subs = "3";
                    type = "op";
                    type_tag = "ceria";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganEsia.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganEsia.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganEsia = "0";
                    } else
                    if (str_LangganEsia.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganEsia = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganEsia = "1";
                    }
                    id_subs = "2";
                    type = "op";
                    type_tag = "esia";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganTelkom.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganTelkom.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganTelkom = "0";
                    } else
                    if (str_LangganTelkom.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganTelkom = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganTelkom = "1";
                    }
                    id_subs = "6";
                    type = "op";
                    type_tag = "telkom";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganAplikasi.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganAplikasi.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganAplikasi = "0";
                    } else
                    if (str_LangganAplikasi.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganAplikasi = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganAplikasi = "1";
                    }
                    id_subs = "3";
                    type = "general";
                    type_tag = "appgame";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganGame.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganGame.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganGame = "0";
                    } else
                    if (str_LangganGame.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganGame = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganGame = "1";
                    }
                    id_subs = "4";
                    type = "general";
                    type_tag = "permainan";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganTips.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganTips.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganTips = "0";
                    } else
                    if (str_LangganTips.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganTips = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganTips = "1";
                    }
                    id_subs = "11";
                    type = "general";
                    type_tag = "tipstrik";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganInternet.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganInternet.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganInternet = "0";
                    } else
                    if (str_LangganInternet.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganInternet = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganInternet = "1";
                    }
                    id_subs = "2";
                    type = "general";
                    type_tag = "inetsocmed";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganFirmware.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganFirmware.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganFirmware = "0";
                    } else
                    if (str_LangganFirmware.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganFirmware = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganFirmware = "1";
                    }
                    id_subs = "5";
                    type = "general";
                    type_tag = "firmware";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganGadget.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganGadget.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganGadget = "0";
                    } else
                    if (str_LangganGadget.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganGadget = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganGadget = "1";
                    }
                    id_subs = "10";
                    type = "general";
                    type_tag = "gadget";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganECommerce.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganECommerce.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganECommerce = "0";
                    } else
                    if (str_LangganECommerce.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganECommerce = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganECommerce = "1";
                    }
                    id_subs = "9";
                    type = "general";
                    type_tag = "ecommerce";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganTeknologi.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganTeknologi.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganTeknologi = "0";
                    } else
                    if (str_LangganTeknologi.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganTeknologi = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganTeknologi = "1";
                    }
                    id_subs = "1";
                    type = "general";
                    type_tag = "teknoscience";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganBisnis.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganBisnis.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganBisnis = "0";
                    } else
                    if (str_LangganBisnis.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganBisnis = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganBisnis = "1";
                    }
                    id_subs = "6";
                    type = "general";
                    type_tag = "bisniscorporate";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganPemerintah.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganPemerintah.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganPemerintah = "0";
                    } else
                    if (str_LangganPemerintah.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganPemerintah = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganPemerintah = "1";
                    }
                    id_subs = "7";
                    type = "general";
                    type_tag = "pemerintah";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganGayaHidup.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganGayaHidup.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganGayaHidup = "0";
                    } else
                    if (str_LangganGayaHidup.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganGayaHidup = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganGayaHidup = "1";
                    }
                    id_subs = "8";
                    type = "general";
                    type_tag = "gayahidup";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganTokoh.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganTokoh.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganTokoh = "0";
                    } else
                    if (str_LangganTokoh.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganTokoh = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganTokoh = "1";
                    }
                    id_subs = "12";
                    type = "general";
                    type_tag = "tokomstartup";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganKomunitas.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganKomunitas.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganKomunitas = "0";
                    } else
                    if (str_LangganKomunitas.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganKomunitas = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganKomunitas = "1";
                    }
                    id_subs = "13";
                    type = "general";
                    type_tag = "komunitas";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        btn_LangganStartup.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity this$0;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    if (str_LangganStartup.equals("1"))
                    {
                        statSubNews = "0";
                        str_LangganStartup = "0";
                    } else
                    if (str_LangganStartup.equals("0"))
                    {
                        statSubNews = "1";
                        str_LangganStartup = "1";
                    } else
                    {
                        statSubNews = "1";
                        str_LangganStartup = "1";
                    }
                    id_subs = "14";
                    type = "general";
                    type_tag = "start_up";
                    (new SubsNewsTask()).execute(new Void[0]);
                    return;
                } else
                {
                    LoginPopup(str_title_notlogin, str_msg_notlogin);
                    return;
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            dataSubscribe = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("get_user_rsssubscribe").append(Utility.BASE_FORMAT).append("?").append("id_user=").append(user_id).append("&t=").append(t).toString();
            (new GetSubscribe(null)).execute(new Void[0]);
        }
        urlTurunHp = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("turun_harga_random").append(Utility.BASE_FORMAT).append("?lmt=0&t=").append(t).append("&idusr=").append(user_id).append("&tag=").toString();
        (new AsyncHttpClient()).get(urlTurunHp, new AsyncHttpResponseHandler() {

            final HomeNewsActivity this$0;

            public void onFailure(int j, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int j)
            {
            }

            public void onStart()
            {
                Log.e("urlTurunHp", urlTurunHp);
            }

            public void onSuccess(int j, Header aheader[], byte abyte0[])
            {
                aheader = new String(abyte0);
                aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
                j = 0;
_L2:
                if (j >= aheader.length())
                {
                    if (id_hp.equals("-") || id_hp.equals(""))
                    {
                        mLinearViewTurun.setVisibility(8);
                        return;
                    }
                    break; /* Loop/switch isn't completed */
                }
                abyte0 = aheader.getJSONObject(j);
                id_hp = abyte0.getString("id_hp");
                merk = abyte0.getString("merk");
                model = abyte0.getString("model");
                codename = abyte0.getString("codename");
                gambar = abyte0.getString("gambar");
                penurunan_harga = abyte0.getString("penurunan_harga");
                hrg_baru = abyte0.getString("hrg_baru");
                hrg_bekas = abyte0.getString("hrg_bekas");
                tot_like = abyte0.getString("total_like");
                tot_dislike = abyte0.getString("total_dislike");
                tot_komen = abyte0.getString("total_kom");
                j++;
                if (true) goto _L2; else goto _L1
_L1:
                try
                {
                    list_txtMerek.setText((new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString());
                    list_txtHarga.setText(penurunan_harga);
                    mLinearViewTurun.setOnClickListener(new android.view.View.OnClickListener() {

                        final _cls70 this$1;

                        public void onClick(View view)
                        {
                            view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                            view.putExtra("id_hph", id_hp);
                            view.putExtra("namalengkap", (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString());
                            view.putExtra("codename", codename);
                            view.putExtra("model", model);
                            view.putExtra("merk", merk);
                            view.putExtra("gambar", gambar);
                            view.putExtra("hrg_baru", hrg_baru);
                            view.putExtra("hrg_bekas", hrg_bekas);
                            view.putExtra("tot_like", tot_like);
                            view.putExtra("tot_dislike", tot_dislike);
                            view.putExtra("tot_komen", tot_komen);
                            startActivityForResult(view, 0);
                            overridePendingTransition(0x7f040003, 0x7f040004);
                        }

            
            {
                this$1 = _cls70.this;
                super();
            }
                    });
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Header aheader[])
                {
                    aheader.printStackTrace();
                }
                return;
            }


            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0002, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (receiver != null)
        {
            unregisterReceiver(receiver);
        }
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

    public void onPause()
    {
        super.onPause();
    }

    public void onRefreshStarted(View view)
    {
        startTask();
    }

    public void onResume()
    {
        super.onResume();
        wind = getWindow();
        wind.addFlags(0x200000);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void onScrollChanged(ParallaxScrollView parallaxscrollview, int i, int j, int k, int l)
    {
        i = parallaxscrollview.getChildAt(parallaxscrollview.getChildCount() - 1).getBottom() - (parallaxscrollview.getHeight() + parallaxscrollview.getScrollY());
        if (i <= 20)
        {
            progressbar_rssfeedmore.setVisibility(0);
        }
        if (i <= 10)
        {
            load_more_rss();
        }
    }

    public void onStart()
    {
        super.onStart();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
        sPref = PreferenceManager.getDefaultSharedPreferences(this).getString("listPref", "Wi-Fi");
        updateConnectedFlags();
        if (refreshDisplay)
        {
            loadPage();
        }
    }

    public void onStop()
    {
        super.onStop();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }

    void parseJSONGroupChat(String s)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("InPonsel");
        if (jsonobject.getString("success").equals("0")) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        Object obj;
        try
        {
            if (i >= s.length())
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        jsonobject = s.getJSONObject(i);
        if (!db.checkIfGroupExist(jsonobject.getString("codename"))) goto _L4; else goto _L3
_L3:
        db.update_groupmsg(jsonobject.getString("codename"), jsonobject.getString("username"), jsonobject.getString("message"), jsonobject.getString("type"), jsonobject.getString("post_date"), jsonobject.getString("me"), jsonobject.getString("unread"));
          goto _L5
_L4:
        db.addGroupChat(jsonobject.getString("id"), jsonobject.getString("merk"), jsonobject.getString("model"), jsonobject.getString("codename"), jsonobject.getString("hp_gambar"), jsonobject.getString("username"), jsonobject.getString("message"), jsonobject.getString("type"), jsonobject.getString("unread"), jsonobject.getString("me"), jsonobject.getString("post_date"));
          goto _L5
        obj;
        ((SQLException) (obj)).printStackTrace();
          goto _L5
        obj;
        ((Exception) (obj)).printStackTrace();
          goto _L5
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void showAlertDialog(String s, final boolean finish)
    {
        alertDialog = (new android.app.AlertDialog.Builder(this)).create();
        alertDialog.setMessage(s);
        alertDialog.setCancelable(false);
        alertDialog.setButton(-1, "OK", new android.content.DialogInterface.OnClickListener() {

            final HomeNewsActivity this$0;
            private final boolean val$finish;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                if (finish)
                {
                    HomeNewsActivity.this.finish();
                }
            }

            
            {
                this$0 = HomeNewsActivity.this;
                finish = flag;
                super();
            }
        });
    }

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getLoginStat().equals("1"))
        {
            runOnUiThread(new Runnable() {

                final HomeNewsActivity this$0;

                public void run()
                {
                    Log.e("updateObserverLogin", "HomeNewsActivity");
                    if (userFunctions.isUserLoggedIn(getApplicationContext()))
                    {
                        cursor = db.getAllData();
                        cursor.moveToFirst();
                        invalidateOptionsMenu();
                        Object obj2;
                        try
                        {
                            user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
                        }
                        catch (Exception exception) { }
                        nama_asli = cursor.getString(2);
                        user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
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
                        menu_profil.setVisibility(0);
                        menu_username.setText((new StringBuilder()).append(username).toString());
                        menu_ponsel_pengguna.setText((new StringBuilder()).append(user_ponsel1).toString());
                        menu_sim_pengguna.setText((new StringBuilder()).append(user_provider1).toString());
                        Picasso.with(HomeNewsActivity.this).load(user_photo.trim()).tag(HomeNewsActivity.this).into(menu_imgProfil, new Callback() {

                            final _cls73 this$1;

                            public void onError()
                            {
                            }

                            public void onSuccess()
                            {
                            }

            
            {
                this$1 = _cls73.this;
                super();
            }
                        });
                        menu_profil.setVisibility(0);
                        menu_LoginRegister.setVisibility(8);
                        menu_Bookmark.setVisibility(0);
                        menu_pesan.setVisibility(0);
                        menu_GroupChat.setVisibility(0);
                        if (db.getInBoxCount() > 0)
                        {
                            Log.e("unread", "getTotalUnread");
                            obj2 = db.getTotalUnread();
                            ((Cursor) (obj2)).moveToFirst();
                            obj2 = ((Cursor) (obj2)).getString(((Cursor) (obj2)).getColumnIndex("total"));
                            if (((String) (obj2)).equals("0") || ((String) (obj2)).equals(""))
                            {
                                txtUnreadCount.setVisibility(8);
                                txtUnreadCount.setText("0");
                            } else
                            {
                                txtUnreadCount.setText(((CharSequence) (obj2)));
                                txtUnreadCount.setVisibility(0);
                            }
                        } else
                        {
                            Log.e("unread", "getTotalUnreadSQLSEQ");
                            obj2 = db.getTotalUnreadSQLSEQ();
                            ((Cursor) (obj2)).moveToFirst();
                            obj2 = ((Cursor) (obj2)).getString(((Cursor) (obj2)).getColumnIndex("total"));
                            if (((String) (obj2)).equals("0") || ((String) (obj2)).equals(""))
                            {
                                txtUnreadCount.setVisibility(8);
                                txtUnreadCount.setText("0");
                            } else
                            {
                                txtUnreadCount.setText(((CharSequence) (obj2)));
                                txtUnreadCount.setVisibility(0);
                            }
                        }
                        GetInboxGroupList();
                        if (db.getGroupChatCount() > 0)
                        {
                            Log.e("getGroupChatCount", "getTotalUnread");
                            obj2 = db.getTotalUnreadGroupChat();
                            ((Cursor) (obj2)).moveToFirst();
                            obj2 = ((Cursor) (obj2)).getString(((Cursor) (obj2)).getColumnIndex("total"));
                            Log.e("getGroupChatCount()", ((String) (obj2)));
                            if (((String) (obj2)).equals("0") || ((String) (obj2)).equals(""))
                            {
                                txtUnreadGroupChat.setVisibility(8);
                                txtUnreadGroupChat.setText("0");
                            } else
                            {
                                txtUnreadGroupChat.setText(((CharSequence) (obj2)));
                                txtUnreadGroupChat.setVisibility(0);
                            }
                        } else
                        {
                            Log.e("prefUnreadgroup", "getTotalUnread");
                            String s = getApplicationContext().getSharedPreferences("UnreadGroup", 0).getString("unread_group", null);
                            if (s.equals("0") || s.equals(""))
                            {
                                txtUnreadGroupChat.setVisibility(8);
                                txtUnreadGroupChat.setText("0");
                            } else
                            {
                                txtUnreadGroupChat.setText(s);
                                txtUnreadGroupChat.setVisibility(0);
                            }
                        }
                        txtUnreadCount.getText().toString().equals("0");
                        menu_Setting.setVisibility(0);
                        return;
                    } else
                    {
                        menu_GroupChat.setVisibility(8);
                        menu_pesan.setVisibility(8);
                        menu_LoginRegister.setVisibility(0);
                        menu_Bookmark.setVisibility(8);
                        menu_Setting.setVisibility(8);
                        menu_profil.setVisibility(8);
                        return;
                    }
                }

            
            {
                this$0 = HomeNewsActivity.this;
                super();
            }
            });
        }
        if (!ponselBaseApp.getObserver().getUpdateType().equals("favrss")) goto _L2; else goto _L1
_L1:
        int i = 0;
_L5:
        if (i < listBerita.getChildCount()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        Log.e("listBerita", String.valueOf(i));
        if (i != 5 && i != 11 && i != 17 && i != 23 && i != 29 && i != 35)
        {
            Object obj1 = listBerita.getChildAt(i);
            observable = (ImageView)((View) (obj1)).findViewById(0x7f0b05f1);
            obj = (TextView)((View) (obj1)).findViewById(0x7f0b054d);
            obj1 = (TextView)((View) (obj1)).findViewById(0x7f0b0650);
            Log.e("rssidmatch", (new StringBuilder(String.valueOf(ponselBaseApp.getObserver().getIndexRSS()))).append("=").append(((TextView) (obj)).getText().toString()).toString());
            if (((TextView) (obj)).getText().toString().equals(ponselBaseApp.getObserver().getIndexRSS()))
            {
                if (ponselBaseApp.getObserver().getFav_stat_rss().toString().equals("1"))
                {
                    observable.setBackgroundResource(0x7f020303);
                    ((TextView) (obj1)).setText("1");
                } else
                {
                    observable.setBackgroundResource(0x7f020302);
                    ((TextView) (obj1)).setText("0");
                }
            }
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }










}
