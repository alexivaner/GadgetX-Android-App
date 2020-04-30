// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.dobmob.dobsliding.DobSlidingMenu;
import com.dobmob.dobsliding.events.OnCollapsedListener;
import com.dobmob.dobsliding.events.OnExpandedListener;
import com.dobmob.dobsliding.exceptions.NoActionBarException;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ItemRSS;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.rssfeeddetail.RSSKomenTab;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeRSSHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
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
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSInteraksiActivity

public class RSSTimelineActivity extends SherlockFragmentActivity
    implements Observer, android.widget.AbsListView.OnScrollListener
{
    public class FavoritTask extends AsyncTask
    {

        final RSSTimelineActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                avoid = (new StringBuilder("idrss=")).append(idkom_pos).append("&idusr=").append(user_id).append("&stat=").append(stat).append("&t=").append(t).toString();
                String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favrss").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", s);
                s = HttpPush.getResponse(s);
                Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
                res = s.toString();
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
            updateViewRSSFav(idkom_pos, res, str_srclink);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (stat.equals("1"))
            {
                mDialog = ProgressDialog.show(RSSTimelineActivity.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(RSSTimelineActivity.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public FavoritTask()
        {
            this$0 = RSSTimelineActivity.this;
            super();
        }
    }

    private class GetSubscribe extends AsyncTask
    {

        final RSSTimelineActivity this$0;

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
            this$0 = RSSTimelineActivity.this;
            super();
        }

        GetSubscribe(GetSubscribe getsubscribe)
        {
            this();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final RSSTimelineActivity this$0;

        private void parseJSONLikeKom(String s)
        {
            int i;
            try
            {
                s = new JSONObject(s);
                postStatusLikeKom = s.getString("success");
                postMessageLikeKom = s.getString("message");
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
                return;
            }
            s = jArray.getJSONObject(i);
            jum_komen = s.getString("total_komen");
            tot_LikeRSS = s.getString("total_like");
            totdis_LikeKom = s.getString("total_dislike");
            Log.e("tot_LikePon", tot_LikeRSS);
            Log.e("totdis_LikePon", totdis_LikeKom);
            ponselBaseApp.getObserver().setJum_komenLikeRSS(jum_komen);
            ponselBaseApp.getObserver().setTot_LikeRSS(tot_LikeRSS);
            ponselBaseApp.getObserver().setIndexRSS(idkom_pos);
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_50;
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
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    avoid = StrictMode.getThreadPolicy();
                    StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder(avoid)).permitDiskWrites().build());
                    StrictMode.setThreadPolicy(avoid);
                }
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_rss.php?").append(querylike).toString();
                Log.e("pushURL", avoid);
                avoid = HttpPush.getResponse(avoid);
                reslike = avoid.toString();
                parseJSONLikeKom(reslike);
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
            ponselBaseApp.getObserver().setUpdateType("likerss");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            Log.e("postStatusLikeKom", postStatusLikeKom);
            if (!postStatusLikeKom.equals("1"))
            {
                break MISSING_BLOCK_LABEL_169;
            }
            if (!statuslike.equals("1"))
            {
                break MISSING_BLOCK_LABEL_144;
            }
            notificationLikeHelper.completed("RSS Feeds", notificationLikeHelper.suclikefrontKomen);
_L1:
            Log.e("mArrayListData", String.valueOf(mArrayListData.size()));
            Log.e("index_komposlike", idkom_pos);
            updateViewLikeDis(idkom_pos);
            return;
            try
            {
                notificationLikeHelper.completed("RSS Feeds", notificationLikeHelper.sucdislikefrontKomen);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.gagal("RSS Feeds", notificationLikeHelper.gaglikefrontKomen);
                return;
            }
            notificationLikeHelper.gagal("RSS Feeds", notificationLikeHelper.gagdislikefrontKomen);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statuslike.equals("1"))
            {
                notificationLikeHelper.createNotification("RSS Feeds", notificationLikeHelper.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelper.createNotification("RSS Feeds", notificationLikeHelper.dislikefrontKomen);
                return;
            }
        }

        public PostBagusKurangTask()
        {
            this$0 = RSSTimelineActivity.this;
            super();
        }
    }

    public class SubsNewsTask extends AsyncTask
    {

        final RSSTimelineActivity this$0;

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
                        Toast.makeText(RSSTimelineActivity.this, postMessageSubsNews, 1).show();
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
                Toast.makeText(RSSTimelineActivity.this, postMessageSubsNews, 1).show();
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
                Toast.makeText(RSSTimelineActivity.this, postMessageSubsNews, 1).show();
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statSubNews.equals("1"))
            {
                mDialog = ProgressDialog.show(RSSTimelineActivity.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(RSSTimelineActivity.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public SubsNewsTask()
        {
            this$0 = RSSTimelineActivity.this;
            super();
        }
    }

    public class TimelineNEXTTask extends AsyncTask
    {

        final RSSTimelineActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlRSSLast));
            as = jsonobject.getJSONArray("InPonsel");
            if (!jsonobject.getString("top_id").equals("-"))
            {
                top_id = jsonobject.getString("top_id");
            }
            Log.e("top_id", top_id);
            countKomOld = 0;
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_275;
            }
            Object obj = RSSTimelineActivity.this;
            obj.countAllKom = ((RSSTimelineActivity) (obj)).countAllKom + 1;
            obj = RSSTimelineActivity.this;
            obj.countKomOld = ((RSSTimelineActivity) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemRSS(((JSONObject) (obj)).getString("id"), ((JSONObject) (obj)).getString("rss_id"), ((JSONObject) (obj)).getString("rss_title"), ((JSONObject) (obj)).getString("rss_portal"), ((JSONObject) (obj)).getString("rss_desc"), "", ((JSONObject) (obj)).getString("rss_srclink"), ((JSONObject) (obj)).getString("rss_date"), ((JSONObject) (obj)).getString("rss_img_ava"), ((JSONObject) (obj)).getString("rss_img"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_like"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_komen"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_hits"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_like_rss"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_fav_rss")));
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
            txtbtnheader.setVisibility(0);
            layout_header.setVisibility(8);
            final String id_rss;
            final String rss_id;
            final String rss_title;
            final String rss_portal;
            final String rss_desc;
            final String rss_srclink;
            final String rss_date;
            final String rss_img_ava;
            final String rss_img;
            final String total_like;
            final String like_stat;
            final String total_komen;
            String s;
            TextView textview;
            Object obj;
            ImageView imageview;
            int i;
            if (!strKonekStat.equals("-"))
            {
                i = 0;
            } else
            {
                txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                    final TimelineNEXTTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            txtbtnheader.setVisibility(8);
                            limit = 0;
                            urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).toString();
                            Log.e("urlRSSLast", urlRSSLast);
                            TimelineNEXTTask();
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                    }

            
            {
                this$1 = TimelineNEXTTask.this;
                super();
            }
                });
                txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                    final TimelineNEXTTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            limit = 0;
                            view = _fld0;
                            view.page_counter = ((RSSTimelineActivity) (view)).page_counter + 1;
                            urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).toString();
                            Log.e("urlRSSOld", urlRSSOld);
                            TimelinePREVTask();
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                    }

            
            {
                this$1 = TimelineNEXTTask.this;
                super();
            }
                });
                scroll_artikel.setVisibility(8);
                layout_empty.setVisibility(0);
                pop_progressbar_middle.setVisibility(8);
                pop_txt_empty.setVisibility(0);
                pop_txt_empty.setText("Berita belum tersedia");
                return;
            }
            if (i >= mArrayListData.size())
            {
                txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                    final TimelineNEXTTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            txtbtnheader.setVisibility(8);
                            limit = 0;
                            urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).toString();
                            Log.e("urlRSSLast", urlRSSLast);
                            TimelineNEXTTask();
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                    }

            
            {
                this$1 = TimelineNEXTTask.this;
                super();
            }
                });
                txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                    final TimelineNEXTTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            limit = 0;
                            view = _fld0;
                            view.page_counter = ((RSSTimelineActivity) (view)).page_counter + 1;
                            urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).toString();
                            Log.e("urlRSSOld", urlRSSOld);
                            TimelinePREVTask();
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                    }

            
            {
                this$1 = TimelineNEXTTask.this;
                super();
            }
                });
                layout_empty.setVisibility(8);
                scroll_artikel.setVisibility(0);
                return;
            }
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300c5, null);
            txtUsername = (TextView)void1.findViewById(0x7f0b0419);
            txtTitle = (TextView)void1.findViewById(0x7f0b05ec);
            img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
            imageMedia = (ImageView)void1.findViewById(0x7f0b046c);
            txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
            txtKomentar = (TextView)void1.findViewById(0x7f0b054e);
            txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
            txtImgAva = (TextView)void1.findViewById(0x7f0b05e9);
            txtImgMedia = (TextView)void1.findViewById(0x7f0b05ea);
            obj = (ImageView)void1.findViewById(0x7f0b054f);
            imageview = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            txtTotalKom = (TextView)void1.findViewById(0x7f0b034a);
            bottom_list = (LinearLayout)void1.findViewById(0x7f0b0341);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
            id_rss = ((ItemRSS)mArrayListData.get(i)).getId();
            rss_id = ((ItemRSS)mArrayListData.get(i)).getRss_id();
            rss_title = ((ItemRSS)mArrayListData.get(i)).getRss_title();
            rss_portal = ((ItemRSS)mArrayListData.get(i)).getRss_portal();
            rss_desc = ((ItemRSS)mArrayListData.get(i)).getRss_desc();
            ((ItemRSS)mArrayListData.get(i)).getRss_content();
            rss_srclink = ((ItemRSS)mArrayListData.get(i)).getRss_srclink();
            rss_date = ((ItemRSS)mArrayListData.get(i)).getRss_date();
            rss_img_ava = ((ItemRSS)mArrayListData.get(i)).getRss_img_ava();
            rss_img = ((ItemRSS)mArrayListData.get(i)).getRss_img();
            total_like = ((ItemRSS)mArrayListData.get(i)).getRss_tot_like();
            like_stat = ((ItemRSS)mArrayListData.get(i)).getRss_like_stat();
            total_komen = ((ItemRSS)mArrayListData.get(i)).getRss_tot_komen();
            s = ((ItemRSS)mArrayListData.get(i)).getRss_fav_stat();
            textview = (TextView)void1.findViewById(0x7f0b0650);
            textview.setText(s);
            Log.e("fav4016", s);
            txtTitle.setText(Html.fromHtml(rss_title));
            txtIdKom.setText(id_rss);
            txtUsername.setText(rss_portal);
            txtImgAva.setText(rss_img_ava);
            txtImgMedia.setText(rss_img);
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(rss_desc)));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtLikeKom.setText(total_like);
            txtTotalKom.setText(total_komen);
            if (like_stat.toString().equals("1"))
            {
                ((ImageView) (obj)).setBackgroundResource(0x7f020264);
                list_lay_like.setEnabled(false);
                list_lay_dislike.setEnabled(true);
            } else
            if (like_stat.toString().equals("0"))
            {
                ((ImageView) (obj)).setBackgroundResource(0x7f020265);
                list_lay_like.setEnabled(true);
            } else
            {
                list_lay_like.setEnabled(true);
                list_lay_dislike.setEnabled(true);
                ((ImageView) (obj)).setBackgroundResource(0x7f020265);
                list_lay_like.setBackgroundResource(0x7f02007a);
                list_lay_dislike.setBackgroundResource(0x7f02007a);
            }
            if (!s.toString().equals("1")) goto _L2; else goto _L1
_L1:
            imageview.setBackgroundResource(0x7f020303);
_L3:
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)mArrayListData.get(i)).getRss_img_ava().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
            if (((ItemRSS)mArrayListData.get(i)).getRss_img().trim().equals(""))
            {
                imageMedia.setVisibility(8);
            } else
            {
                imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)mArrayListData.get(i)).getRss_img().toString().trim()).toString(), imageMedia, options, animateFirstListener);
            }
            txtWaktu.setText(Utility.convertDate(((ItemRSS)mArrayListData.get(i)).getRss_date()));
            mLinearListView.addView(void1, countnext);
            obj = RSSTimelineActivity.this;
            obj.countnext = ((RSSTimelineActivity) (obj)).countnext + 1;
            imageMedia.setOnClickListener(rss_img. new android.view.View.OnClickListener() {

                final TimelineNEXTTask this$1;
                private final String val$rss_img;

                public void onClick(View view)
                {
                    view = new ArrayList();
                    view.add(rss_img);
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                }

            
            {
                this$1 = final_timelinenexttask;
                rss_img = String.this;
                super();
            }
            });
            img_kom_picture.setOnLongClickListener(rss_img_ava. new android.view.View.OnLongClickListener() {

                final TimelineNEXTTask this$1;
                private final String val$rss_img_ava;

                public boolean onLongClick(View view)
                {
                    view = new ArrayList();
                    view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(rss_img_ava.toString().trim()).toString());
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                    return false;
                }

            
            {
                this$1 = final_timelinenexttask;
                rss_img_ava = String.this;
                super();
            }
            });
            list_lay_like.setOnClickListener(id_rss. new android.view.View.OnClickListener() {

                final TimelineNEXTTask this$1;
                private final String val$id_rss;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        statuslike = "1";
                        idkom_pos = id_rss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                        Log.e("querylike", querylike);
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
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final TimelineNEXTTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = TimelineNEXTTask._cls3.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final TimelineNEXTTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = TimelineNEXTTask._cls3.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final TimelineNEXTTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = TimelineNEXTTask._cls3.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_timelinenexttask;
                id_rss = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(textview. new android.view.View.OnClickListener() {

                final TimelineNEXTTask this$1;
                private final String val$id_rss;
                private final String val$rss_srclink;
                private final TextView val$txt_fav_news_1;

                public void onClick(View view)
                {
                    idkom_pos = id_rss;
                    str_srclink = rss_srclink;
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        if (txt_fav_news_1.getText().toString().equals("1"))
                        {
                            view = new android.app.AlertDialog.Builder(_fld0);
                            view.setMessage("Hapus berita ini dari favorit?");
                            view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                final TimelineNEXTTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                    stat = "0";
                                    (new FavoritTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = TimelineNEXTTask._cls4.this;
                super();
            }
                            });
                            view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final TimelineNEXTTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = TimelineNEXTTask._cls4.this;
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

                                final TimelineNEXTTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    stat = "1";
                                    (new FavoritTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = TimelineNEXTTask._cls4.this;
                super();
            }
                            });
                            view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final TimelineNEXTTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = TimelineNEXTTask._cls4.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final TimelineNEXTTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = TimelineNEXTTask._cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final TimelineNEXTTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = TimelineNEXTTask._cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final TimelineNEXTTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = TimelineNEXTTask._cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_timelinenexttask;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = TextView.this;
                super();
            }
            });
            list_lay_kom.setOnClickListener(s. new android.view.View.OnClickListener() {

                final TimelineNEXTTask this$1;
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
                    view = new Intent(_fld0, com/inponsel/android/rssfeeddetail/RSSKomenTab);
                    view.putExtra("kategori_tag", kategori_tag);
                    view.putExtra("act", "komen");
                    view.putExtra("actfrom", "rssfeed");
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
                this$1 = final_timelinenexttask;
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
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final TimelineNEXTTask this$1;
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
                    view.putExtra("kategori_tag", kategori_tag);
                    view.putExtra("act", "firsttab");
                    view.putExtra("actfrom", "rssfeed");
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
                this$1 = final_timelinenexttask;
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
            if (false)
            {
                break MISSING_BLOCK_LABEL_1355;
            } else
            {
                break MISSING_BLOCK_LABEL_41;
            }
_L2:
            if (s.toString().equals("0"))
            {
                imageview.setBackgroundResource(0x7f020302);
            } else
            {
                imageview.setBackgroundResource(0x7f020302);
            }
              goto _L3
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            countnext = 0;
            txtbtnheader.setVisibility(8);
            layout_header.setVisibility(0);
            mArrayListData.clear();
        }


        public TimelineNEXTTask()
        {
            this$0 = RSSTimelineActivity.this;
            super();
        }
    }

    public class TimelineOLDTask extends AsyncTask
    {

        final RSSTimelineActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlRSSOld));
            as = jsonobject.getJSONArray("InPonsel");
            bottom_id = jsonobject.getString("bottom_id");
            Log.e("bottom_id", bottom_id);
            Log.e("top_id", top_id);
            countKomOld = 0;
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_273;
            }
            Object obj = RSSTimelineActivity.this;
            obj.countAllKom = ((RSSTimelineActivity) (obj)).countAllKom + 1;
            obj = RSSTimelineActivity.this;
            obj.countKomOld = ((RSSTimelineActivity) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemRSS(((JSONObject) (obj)).getString("id"), ((JSONObject) (obj)).getString("rss_id"), ((JSONObject) (obj)).getString("rss_title"), ((JSONObject) (obj)).getString("rss_portal"), ((JSONObject) (obj)).getString("rss_desc"), "", ((JSONObject) (obj)).getString("rss_srclink"), ((JSONObject) (obj)).getString("rss_date"), ((JSONObject) (obj)).getString("rss_img_ava"), ((JSONObject) (obj)).getString("rss_img"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_like"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_komen"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_hits"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_like_rss"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_fav_rss")));
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
            txtbtnfooter.setVisibility(0);
            layout_footerNext.setVisibility(8);
            Log.e("mArrayListDataOld", String.valueOf(mArrayListData.size()));
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_1473;
            }
            int i = 0;
_L5:
            ImageView imageview;
            ImageView imageview1;
            TextView textview;
            final String id_rss;
            final String rss_id;
            final String rss_title;
            final String rss_portal;
            final String rss_desc;
            final String rss_srclink;
            final String rss_date;
            final String rss_img_ava;
            final String rss_img;
            final String total_like;
            final String like_stat;
            final String total_komen;
            String s;
            try
            {
                if (i >= mArrayListData.size())
                {
                    txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                        final TimelineOLDTask this$1;

                        public void onClick(View view)
                        {
                            try
                            {
                                txtbtnheader.setVisibility(8);
                                limit = 0;
                                urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
                                Log.e("urlRSSLast", urlRSSLast);
                                TimelineNEXTTask();
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                return;
                            }
                        }

            
            {
                this$1 = TimelineOLDTask.this;
                super();
            }
                    });
                    txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                        final TimelineOLDTask this$1;

                        public void onClick(View view)
                        {
                            try
                            {
                                limit = 0;
                                view = _fld0;
                                view.page_counter = ((RSSTimelineActivity) (view)).page_counter + 1;
                                urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
                                Log.e("urlRSSOld", urlRSSOld);
                                TimelinePREVTask();
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                return;
                            }
                        }

            
            {
                this$1 = TimelineOLDTask.this;
                super();
            }
                    });
                    layout_empty.setVisibility(8);
                    scroll_artikel.setVisibility(0);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                void1.printStackTrace();
                return;
            }
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300c5, null);
            txtUsername = (TextView)void1.findViewById(0x7f0b0419);
            txtTitle = (TextView)void1.findViewById(0x7f0b05ec);
            img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
            imageMedia = (ImageView)void1.findViewById(0x7f0b046c);
            txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
            txtKomentar = (TextView)void1.findViewById(0x7f0b054e);
            txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
            txtImgAva = (TextView)void1.findViewById(0x7f0b05e9);
            txtImgMedia = (TextView)void1.findViewById(0x7f0b05ea);
            imageview = (ImageView)void1.findViewById(0x7f0b054f);
            imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            txtTotalKom = (TextView)void1.findViewById(0x7f0b034a);
            bottom_list = (LinearLayout)void1.findViewById(0x7f0b0341);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
            textview = (TextView)void1.findViewById(0x7f0b0650);
            id_rss = ((ItemRSS)mArrayListData.get(i)).getId();
            rss_id = ((ItemRSS)mArrayListData.get(i)).getRss_id();
            rss_title = ((ItemRSS)mArrayListData.get(i)).getRss_title();
            rss_portal = ((ItemRSS)mArrayListData.get(i)).getRss_portal();
            rss_desc = ((ItemRSS)mArrayListData.get(i)).getRss_desc();
            ((ItemRSS)mArrayListData.get(i)).getRss_content();
            rss_srclink = ((ItemRSS)mArrayListData.get(i)).getRss_srclink();
            rss_date = ((ItemRSS)mArrayListData.get(i)).getRss_date();
            rss_img_ava = ((ItemRSS)mArrayListData.get(i)).getRss_img_ava();
            rss_img = ((ItemRSS)mArrayListData.get(i)).getRss_img();
            total_like = ((ItemRSS)mArrayListData.get(i)).getRss_tot_like();
            like_stat = ((ItemRSS)mArrayListData.get(i)).getRss_like_stat();
            total_komen = ((ItemRSS)mArrayListData.get(i)).getRss_tot_komen();
            s = ((ItemRSS)mArrayListData.get(i)).getRss_fav_stat();
            textview.setText(s);
            Log.e("fav3284", s);
            txtTitle.setText(Html.fromHtml(rss_title));
            txtIdKom.setText(id_rss);
            txtUsername.setText(rss_portal);
            txtImgAva.setText(rss_img_ava);
            txtImgMedia.setText(rss_img);
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(rss_desc)));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtLikeKom.setText(total_like);
            txtTotalKom.setText(total_komen);
            if (!like_stat.toString().equals("1")) goto _L2; else goto _L1
_L1:
            imageview.setBackgroundResource(0x7f020264);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L6:
            if (!s.toString().equals("1")) goto _L4; else goto _L3
_L3:
            imageview1.setBackgroundResource(0x7f020303);
_L7:
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)mArrayListData.get(i)).getRss_img_ava().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
            if (!((ItemRSS)mArrayListData.get(i)).getRss_img().trim().equals(""))
            {
                break MISSING_BLOCK_LABEL_1402;
            }
            imageMedia.setVisibility(8);
_L8:
            txtWaktu.setText(Utility.convertDate(((ItemRSS)mArrayListData.get(i)).getRss_date()));
            mLinearListView.addView(void1, mLinearListView.getChildCount());
            imageMedia.setOnClickListener(rss_img. new android.view.View.OnClickListener() {

                final TimelineOLDTask this$1;
                private final String val$rss_img;

                public void onClick(View view)
                {
                    view = new ArrayList();
                    view.add(rss_img);
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                }

            
            {
                this$1 = final_timelineoldtask;
                rss_img = String.this;
                super();
            }
            });
            img_kom_picture.setOnLongClickListener(rss_img_ava. new android.view.View.OnLongClickListener() {

                final TimelineOLDTask this$1;
                private final String val$rss_img_ava;

                public boolean onLongClick(View view)
                {
                    view = new ArrayList();
                    view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(rss_img_ava.toString().trim()).toString());
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                    return false;
                }

            
            {
                this$1 = final_timelineoldtask;
                rss_img_ava = String.this;
                super();
            }
            });
            list_lay_like.setOnClickListener(id_rss. new android.view.View.OnClickListener() {

                final TimelineOLDTask this$1;
                private final String val$id_rss;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        statuslike = "1";
                        idkom_pos = id_rss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                        Log.e("querylike", querylike);
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
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final TimelineOLDTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = TimelineOLDTask._cls3.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final TimelineOLDTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = TimelineOLDTask._cls3.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final TimelineOLDTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = TimelineOLDTask._cls3.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_timelineoldtask;
                id_rss = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(textview. new android.view.View.OnClickListener() {

                final TimelineOLDTask this$1;
                private final String val$id_rss;
                private final String val$rss_srclink;
                private final TextView val$txt_fav_news_1;

                public void onClick(View view)
                {
                    idkom_pos = id_rss;
                    str_srclink = rss_srclink;
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        if (txt_fav_news_1.getText().toString().equals("1"))
                        {
                            view = new android.app.AlertDialog.Builder(_fld0);
                            view.setMessage("Hapus berita ini dari favorit?");
                            view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                final TimelineOLDTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                    stat = "0";
                                    (new FavoritTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = TimelineOLDTask._cls4.this;
                super();
            }
                            });
                            view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final TimelineOLDTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = TimelineOLDTask._cls4.this;
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

                                final TimelineOLDTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    stat = "1";
                                    (new FavoritTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = TimelineOLDTask._cls4.this;
                super();
            }
                            });
                            view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final TimelineOLDTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = TimelineOLDTask._cls4.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final TimelineOLDTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = TimelineOLDTask._cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final TimelineOLDTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = TimelineOLDTask._cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final TimelineOLDTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = TimelineOLDTask._cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_timelineoldtask;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = TextView.this;
                super();
            }
            });
            list_lay_kom.setOnClickListener(s. new android.view.View.OnClickListener() {

                final TimelineOLDTask this$1;
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
                    view = new Intent(_fld0, com/inponsel/android/rssfeeddetail/RSSKomenTab);
                    view.putExtra("kategori_tag", kategori_tag);
                    view.putExtra("act", "komen");
                    view.putExtra("actfrom", "rssfeed");
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
                this$1 = final_timelineoldtask;
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
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final TimelineOLDTask this$1;
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
                    view.putExtra("kategori_tag", kategori_tag);
                    view.putExtra("act", "firsttab");
                    view.putExtra("actfrom", "rssfeed");
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
                this$1 = final_timelineoldtask;
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
              goto _L5
_L2:
label0:
            {
                if (!like_stat.toString().equals("0"))
                {
                    break label0;
                }
                imageview.setBackgroundResource(0x7f020265);
                list_lay_like.setEnabled(true);
            }
              goto _L6
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(true);
            imageview.setBackgroundResource(0x7f020265);
            list_lay_like.setBackgroundResource(0x7f02007a);
            list_lay_dislike.setBackgroundResource(0x7f02007a);
              goto _L6
_L4:
label1:
            {
                if (!s.toString().equals("0"))
                {
                    break label1;
                }
                imageview1.setBackgroundResource(0x7f020302);
            }
              goto _L7
            imageview1.setBackgroundResource(0x7f020302);
              goto _L7
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)mArrayListData.get(i)).getRss_img().toString().trim()).toString(), imageMedia, options, animateFirstListener);
              goto _L8
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final TimelineOLDTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnheader.setVisibility(8);
                        limit = 0;
                        urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
                        Log.e("urlRSSLast", urlRSSLast);
                        TimelineNEXTTask();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                }

            
            {
                this$1 = TimelineOLDTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final TimelineOLDTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        limit = 0;
                        view = _fld0;
                        view.page_counter = ((RSSTimelineActivity) (view)).page_counter + 1;
                        urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
                        Log.e("urlRSSOld", urlRSSOld);
                        TimelinePREVTask();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                }

            
            {
                this$1 = TimelineOLDTask.this;
                super();
            }
            });
            scroll_artikel.setVisibility(8);
            layout_empty.setVisibility(0);
            pop_progressbar_middle.setVisibility(8);
            pop_txt_empty.setVisibility(0);
            pop_txt_empty.setText("Berita belum tersedia");
            return;
              goto _L5
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            txtbtnfooter.setVisibility(8);
            layout_footerNext.setVisibility(0);
            Log.e("mArrayListDataOld", String.valueOf(mArrayListData.size()));
            mArrayListData.clear();
            Log.e("mArrayListDataOld", String.valueOf(mArrayListData.size()));
        }


        public TimelineOLDTask()
        {
            this$0 = RSSTimelineActivity.this;
            super();
        }
    }

    public class TimelineTask extends AsyncTask
    {

        final RSSTimelineActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("TimelineTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlRSS));
            as = jsonobject.getJSONArray("InPonsel");
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            succesStat = jsonobject.getString("success");
            Log.e("bottom_id", bottom_id);
            Log.e("top_id", top_id);
            countKomOld = 0;
            if (!succesStat.equals("1"))
            {
                break MISSING_BLOCK_LABEL_321;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_321;
            }
            Object obj = RSSTimelineActivity.this;
            obj.countAllKom = ((RSSTimelineActivity) (obj)).countAllKom + 1;
            obj = RSSTimelineActivity.this;
            obj.countKomOld = ((RSSTimelineActivity) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemRSS(((JSONObject) (obj)).getString("id"), ((JSONObject) (obj)).getString("rss_id"), ((JSONObject) (obj)).getString("rss_title"), ((JSONObject) (obj)).getString("rss_portal"), ((JSONObject) (obj)).getString("rss_desc"), "", ((JSONObject) (obj)).getString("rss_srclink"), ((JSONObject) (obj)).getString("rss_date"), ((JSONObject) (obj)).getString("rss_img_ava"), ((JSONObject) (obj)).getString("rss_img"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_like"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_komen"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_hits"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_like_rss"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_fav_rss")));
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
            layout_empty.setVisibility(8);
            if (!succesStat.equals("1")) goto _L2; else goto _L1
_L1:
            if (mArrayListData.size() >= 6) goto _L4; else goto _L3
_L3:
            txtbtnfooter.setVisibility(8);
_L7:
            if (tag_timeline.equals("terpopuler") || tag_timeline.equals("terkomentari"))
            {
                txtbtnfooter.setVisibility(8);
                break MISSING_BLOCK_LABEL_1643;
            }
              goto _L5
_L12:
            ImageView imageview;
            ImageView imageview1;
            TextView textview;
            final String id_rss;
            final String rss_id;
            final String rss_title;
            final String rss_portal;
            final String rss_desc;
            final String rss_srclink;
            final String rss_date;
            final String rss_img_ava;
            final String rss_img;
            final String total_like;
            final String like_stat;
            final String total_komen;
            String s;
            int i;
            try
            {
                if (i >= mArrayListData.size())
                {
                    txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                        final TimelineTask this$1;

                        public void onClick(View view)
                        {
                            try
                            {
                                txtbtnheader.setVisibility(8);
                                limit = 0;
                                urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
                                Log.e("urlRSSLast", urlRSSLast);
                                TimelineNEXTTask();
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                return;
                            }
                        }

            
            {
                this$1 = TimelineTask.this;
                super();
            }
                    });
                    txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                        final TimelineTask this$1;

                        public void onClick(View view)
                        {
                            try
                            {
                                view = _fld0;
                                view.page_counter = ((RSSTimelineActivity) (view)).page_counter + 1;
                                limit = 0;
                                urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
                                Log.e("urlRSSOld", urlRSSOld);
                                TimelinePREVTask();
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                return;
                            }
                        }

            
            {
                this$1 = TimelineTask.this;
                super();
            }
                    });
                    layout_empty.setVisibility(8);
                    scroll_artikel.setVisibility(0);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L6
_L4:
            txtbtnfooter.setVisibility(0);
              goto _L7
_L5:
            txtbtnfooter.setVisibility(0);
            break MISSING_BLOCK_LABEL_1643;
_L6:
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300c5, null);
            txtUsername = (TextView)void1.findViewById(0x7f0b0419);
            txtTitle = (TextView)void1.findViewById(0x7f0b05ec);
            img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
            imageMedia = (ImageView)void1.findViewById(0x7f0b046c);
            txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
            txtKomentar = (TextView)void1.findViewById(0x7f0b054e);
            txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
            txtImgAva = (TextView)void1.findViewById(0x7f0b05e9);
            txtImgMedia = (TextView)void1.findViewById(0x7f0b05ea);
            imageview = (ImageView)void1.findViewById(0x7f0b054f);
            imageview1 = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            txtTotalKom = (TextView)void1.findViewById(0x7f0b034a);
            bottom_list = (LinearLayout)void1.findViewById(0x7f0b0341);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
            list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
            textview = (TextView)void1.findViewById(0x7f0b0650);
            id_rss = ((ItemRSS)mArrayListData.get(i)).getId();
            rss_id = ((ItemRSS)mArrayListData.get(i)).getRss_id();
            rss_title = ((ItemRSS)mArrayListData.get(i)).getRss_title();
            rss_portal = ((ItemRSS)mArrayListData.get(i)).getRss_portal();
            rss_desc = ((ItemRSS)mArrayListData.get(i)).getRss_desc();
            ((ItemRSS)mArrayListData.get(i)).getRss_content();
            rss_srclink = ((ItemRSS)mArrayListData.get(i)).getRss_srclink();
            rss_date = ((ItemRSS)mArrayListData.get(i)).getRss_date();
            rss_img_ava = ((ItemRSS)mArrayListData.get(i)).getRss_img_ava();
            rss_img = ((ItemRSS)mArrayListData.get(i)).getRss_img();
            total_like = ((ItemRSS)mArrayListData.get(i)).getRss_tot_like();
            like_stat = ((ItemRSS)mArrayListData.get(i)).getRss_like_stat();
            total_komen = ((ItemRSS)mArrayListData.get(i)).getRss_tot_komen();
            s = ((ItemRSS)mArrayListData.get(i)).getRss_fav_stat();
            textview.setText(s);
            Log.e("fav2323", s);
            txtTitle.setText(Html.fromHtml(rss_title));
            txtIdKom.setText(id_rss);
            txtUsername.setText(rss_portal);
            txtImgAva.setText(rss_img_ava);
            txtImgMedia.setText(rss_img);
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(rss_desc)));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtLikeKom.setText(total_like);
            txtTotalKom.setText(total_komen);
            if (!like_stat.toString().equals("1")) goto _L9; else goto _L8
_L8:
            imageview.setBackgroundResource(0x7f020264);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L13:
            if (!s.toString().equals("1")) goto _L11; else goto _L10
_L10:
            imageview1.setBackgroundResource(0x7f020303);
_L14:
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)mArrayListData.get(i)).getRss_img_ava().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
            if (!((ItemRSS)mArrayListData.get(i)).getRss_img().trim().equals(""))
            {
                break MISSING_BLOCK_LABEL_1453;
            }
            imageMedia.setVisibility(8);
_L15:
            txtWaktu.setText(Utility.convertDate(((ItemRSS)mArrayListData.get(i)).getRss_date()));
            mLinearListView.addView(void1);
            imageMedia.setOnClickListener(rss_img. new android.view.View.OnClickListener() {

                final TimelineTask this$1;
                private final String val$rss_img;

                public void onClick(View view)
                {
                    view = new ArrayList();
                    view.add(rss_img);
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                }

            
            {
                this$1 = final_timelinetask;
                rss_img = String.this;
                super();
            }
            });
            img_kom_picture.setOnLongClickListener(rss_img_ava. new android.view.View.OnLongClickListener() {

                final TimelineTask this$1;
                private final String val$rss_img_ava;

                public boolean onLongClick(View view)
                {
                    view = new ArrayList();
                    view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(rss_img_ava.toString().trim()).toString());
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                    return false;
                }

            
            {
                this$1 = final_timelinetask;
                rss_img_ava = String.this;
                super();
            }
            });
            list_lay_like.setOnClickListener(id_rss. new android.view.View.OnClickListener() {

                final TimelineTask this$1;
                private final String val$id_rss;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        statuslike = "1";
                        idkom_pos = id_rss;
                        querylike = (new StringBuilder("status=")).append(statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                        Log.e("querylike", querylike);
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
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final TimelineTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = TimelineTask._cls3.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final TimelineTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = TimelineTask._cls3.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final TimelineTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = TimelineTask._cls3.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_timelinetask;
                id_rss = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(textview. new android.view.View.OnClickListener() {

                final TimelineTask this$1;
                private final String val$id_rss;
                private final String val$rss_srclink;
                private final TextView val$txt_fav_news_1;

                public void onClick(View view)
                {
                    idkom_pos = id_rss;
                    str_srclink = rss_srclink;
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        if (txt_fav_news_1.getText().toString().equals("1"))
                        {
                            view = new android.app.AlertDialog.Builder(_fld0);
                            view.setMessage("Hapus berita ini dari favorit?");
                            view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                final TimelineTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                    stat = "0";
                                    (new FavoritTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = TimelineTask._cls4.this;
                super();
            }
                            });
                            view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final TimelineTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = TimelineTask._cls4.this;
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

                                final TimelineTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    stat = "1";
                                    (new FavoritTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = TimelineTask._cls4.this;
                super();
            }
                            });
                            view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final TimelineTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = TimelineTask._cls4.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final TimelineTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = TimelineTask._cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final TimelineTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = TimelineTask._cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final TimelineTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = TimelineTask._cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_timelinetask;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = TextView.this;
                super();
            }
            });
            list_lay_kom.setOnClickListener(s. new android.view.View.OnClickListener() {

                final TimelineTask this$1;
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
                    view = new Intent(_fld0, com/inponsel/android/rssfeeddetail/RSSKomenTab);
                    view.putExtra("kategori_tag", kategori_tag);
                    view.putExtra("act", "komen");
                    view.putExtra("actfrom", "rssfeed");
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
                this$1 = final_timelinetask;
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
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final TimelineTask this$1;
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
                    view.putExtra("kategori_tag", kategori_tag);
                    view.putExtra("act", "firsttab");
                    view.putExtra("actfrom", "rssfeed");
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
                this$1 = final_timelinetask;
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
              goto _L12
_L9:
label0:
            {
                if (!like_stat.toString().equals("0"))
                {
                    break label0;
                }
                imageview.setBackgroundResource(0x7f020265);
                list_lay_like.setEnabled(true);
            }
              goto _L13
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(true);
            imageview.setBackgroundResource(0x7f020265);
            list_lay_like.setBackgroundResource(0x7f02007a);
            list_lay_dislike.setBackgroundResource(0x7f02007a);
              goto _L13
_L11:
label1:
            {
                if (!s.toString().equals("0"))
                {
                    break label1;
                }
                imageview1.setBackgroundResource(0x7f020302);
            }
              goto _L14
            imageview1.setBackgroundResource(0x7f020302);
              goto _L14
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)mArrayListData.get(i)).getRss_img().toString().trim()).toString(), imageMedia, options, animateFirstListener);
              goto _L15
_L2:
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final TimelineTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnheader.setVisibility(8);
                        limit = 0;
                        urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
                        Log.e("urlRSSLast", urlRSSLast);
                        TimelineNEXTTask();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                }

            
            {
                this$1 = TimelineTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final TimelineTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        limit = 0;
                        view = _fld0;
                        view.page_counter = ((RSSTimelineActivity) (view)).page_counter + 1;
                        urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
                        Log.e("urlRSSOld", urlRSSOld);
                        TimelinePREVTask();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                }

            
            {
                this$1 = TimelineTask.this;
                super();
            }
            });
            scroll_artikel.setVisibility(0);
            txtbtnfooter.setVisibility(8);
            txtbtnheader.setVisibility(8);
            layout_empty.setVisibility(0);
            pop_progressbar_middle.setVisibility(8);
            pop_txt_empty.setVisibility(0);
            pop_txt_empty.setText("Berita belum tersedia");
            return;
            i = 0;
              goto _L12
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mArrayListData.clear();
            mLinearListView.removeAllViews();
            mLinearListView.removeAllViewsInLayout();
            Log.e("TimelineTask", "onPreExecute");
            layout_empty.setVisibility(0);
            txtbtnfooter.setVisibility(8);
        }


        public TimelineTask()
        {
            this$0 = RSSTimelineActivity.this;
            super();
        }
    }


    private String TAG;
    ActionBar actionBar;
    int actionBarTitleId;
    private ImageLoadingListener animateFirstListener;
    String bottom_id;
    LinearLayout bottom_list;
    Button btnRefresh;
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
    int charCount;
    ConnectivityManager cm;
    ColorStateList colorsHapus;
    ColorStateList colorsIkuti;
    int countAllKom;
    int countKomOld;
    int countRemIndex;
    int countnext;
    Cursor cursor;
    String dataSubscribe;
    DatabaseHandler db;
    String email_user;
    Bundle extras;
    String firtsid;
    LinearLayout grup_footer;
    LinearLayout grup_header;
    String id_subs;
    String idkom_pos;
    ImageLoader imageLoader2;
    ImageView imageMedia;
    ImageView img_kom_picture;
    ImageView img_label_actionbar;
    InputMethodManager imm;
    JSONArray inponsel;
    boolean isExpand;
    JSONArray jArray;
    int jum_berita;
    String jum_komen;
    String kategori_tag;
    String komencount;
    String lastid;
    LinearLayout lay_quote;
    LinearLayout layout_empty;
    LinearLayout layout_footerNext;
    LinearLayout layout_header;
    int limit;
    RelativeLayout list_lay_dislike;
    RelativeLayout list_lay_kom;
    RelativeLayout list_lay_like;
    LinearLayout ll_TLTerbaru;
    LinearLayout ll_TLTerkomentari;
    LinearLayout ll_TLTerpopuler;
    LinearLayout ll_head_1;
    LinearLayout ll_head_2;
    private ArrayList mArrayListData;
    ProgressDialog mDialog;
    private LinearLayout mLinearListView;
    String nama_asli;
    NotificationLikeRSSHelper notificationLikeHelper;
    private DisplayImageOptions options;
    int page_counter;
    XmlResourceParser parserHapus;
    XmlResourceParser parserIkuti;
    PonselBaseApp ponselBaseApp;
    ProgressBar pop_progressbar_middle;
    TextView pop_txt_empty;
    String postMessage;
    String postMessageAddRss;
    String postMessageLikeKom;
    String postMessageSubsNews;
    String postStatus;
    String postStatusAddRss;
    String postStatusLikeKom;
    String postStatusSubsNews;
    SmoothProgressBar progbar_roomhp;
    String querylike;
    String querypopkomen;
    int removeIndex;
    int removeNextIndex;
    int removeStartOld;
    String res;
    String reslike;
    RelativeLayout rl_actionbarforum;
    String rss_content;
    ViewGroup scroll_artikel;
    View slidingView;
    String stat;
    String statSubNews;
    String statuslike;
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
    String succesStat;
    String success;
    String t;
    String tag_code;
    String tag_timeline;
    String title_bar;
    TextView topTextView;
    String top_id;
    String tot_LikePon;
    String tot_LikeRSS;
    String totdis_LikeKom;
    String totdis_LikePon;
    TextView txtIdKom;
    TextView txtImgAva;
    TextView txtImgMedia;
    TextView txtKomentar;
    TextView txtKomentarQoute;
    TextView txtLikeKom;
    TextView txtTanggapan;
    TextView txtTitle;
    TextView txtTotalKom;
    TextView txtUsername;
    TextView txtUsernameQoute;
    TextView txtWaktu;
    TextView txtWaktuQoute;
    TextView txt_label_actionbar;
    TextView txt_sublabel_actionbar;
    TextView txtbtnfooter;
    TextView txtbtnheader;
    TextView txtdisLikeKom;
    String type;
    String type_tag;
    String urlRSS;
    String urlRSSLast;
    String urlRSSOld;
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
    private DobSlidingMenu vSlidingMenu;
    ContextThemeWrapper wrapperLight;

    public RSSTimelineActivity()
    {
        stat = "";
        countnext = 0;
        page_counter = 1;
        urlRSS = "";
        urlRSSOld = "";
        urlRSSLast = "";
        strKonekStat = "";
        bottom_id = "";
        top_id = "0";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        countKomOld = 0;
        countAllKom = 0;
        jum_berita = 0;
        postStatus = "";
        postMessage = "";
        animateFirstListener = new AnimateFirstDisplayListener();
        removeIndex = 0;
        removeStartOld = 0;
        removeNextIndex = 0;
        countRemIndex = 0;
        querylike = "";
        postStatusLikeKom = "";
        postMessageLikeKom = "Gagal mengirim";
        tot_LikeRSS = "0";
        totdis_LikeKom = "0";
        postStatusAddRss = "";
        postMessageAddRss = "";
        limit = 0;
        komencount = "";
        querypopkomen = "";
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
        firtsid = "";
        lastid = "";
        kategori_tag = "";
        tag_code = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        tag_timeline = "";
        isExpand = false;
        TAG = getClass().getSimpleName();
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
        title_bar = "";
    }

    private void LoginPopup(String s, String s1)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(s);
        builder.setMessage(s1);
        builder.setPositiveButton("Login", new android.content.DialogInterface.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RSSTimelineActivity.this, com/inponsel/android/v2/LoginActivity);
                dialoginterface.putExtra("activity", "main");
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        builder.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(RSSTimelineActivity.this, com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        builder.setNegativeButton("Tutup", new android.content.DialogInterface.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        builder.show();
    }

    public static int dpToPx(Context context, float f)
    {
        return (int)(f * context.getResources().getDisplayMetrics().density + 0.5F);
    }

    private void parseJSONAddFav(String s)
    {
        int i;
        try
        {
            s = new JSONObject(s);
            postStatusAddRss = s.getString("success");
            postMessageAddRss = s.getString("message");
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
            ponselBaseApp.getObserver().setFav_stat_rss(stat);
            ponselBaseApp.getObserver().setIndexRSS(idkom_pos);
            ponselBaseApp.getObserver().setUpdateType("favrss");
            ponselBaseApp.getObserver().setStatus_like_ponsel("-");
            return;
        }
        rss_content = jArray.getJSONObject(i).getString("rss_content");
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_44;
        }
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

    public void TimelineNEXTTask()
    {
        mArrayListData.clear();
        pop_txt_empty.setVisibility(8);
        if (!tag_timeline.equals("") && !tag_timeline.equals("terbaru")) goto _L2; else goto _L1
_L1:
        urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
_L3:
        Log.e("urlRSSLast", urlRSSLast);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new TimelineNEXTTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        }
        break MISSING_BLOCK_LABEL_551;
_L2:
label0:
        {
            if (!tag_timeline.equals("terkomentari"))
            {
                break label0;
            }
            urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_reader_bykom").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
        }
          goto _L3
label1:
        {
            if (!tag_timeline.equals("terpopuler"))
            {
                break label1;
            }
            urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_reader_hits").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
        }
          goto _L3
        try
        {
            urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
        }
        catch (Exception exception)
        {
            return;
        }
          goto _L3
        (new TimelineNEXTTask()).execute(new String[0]);
        return;
    }

    public void TimelinePREVTask()
    {
        mArrayListData.clear();
        pop_txt_empty.setVisibility(8);
        if (!tag_timeline.equals("") && !tag_timeline.equals("terbaru")) goto _L2; else goto _L1
_L1:
        urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
_L4:
        Log.e("urlRSSOld", urlRSSOld);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new TimelineOLDTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        } else
        {
            (new TimelineOLDTask()).execute(new String[0]);
            return;
        }
_L2:
        if (tag_timeline.equals("terkomentari"))
        {
            urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_reader_bykom").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
            continue; /* Loop/switch isn't completed */
        }
        if (tag_timeline.equals("terpopuler"))
        {
            urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_reader_hits").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
        }
        catch (Exception exception) { }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void TimelineTask()
    {
        mArrayListData.clear();
        page_counter = 1;
        pop_txt_empty.setVisibility(8);
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
        Log.e("urlRSS", urlRSS);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new TimelineTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        } else
        {
            (new TimelineTask()).execute(new String[0]);
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
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030103);
        scroll_artikel = (ViewGroup)findViewById(0x7f0b0685);
        topTextView = (TextView)findViewById(0x7f0b06ca);
        topTextView.setVisibility(8);
        Drawable drawable;
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
        wrapperLight = new ContextThemeWrapper(this, 0x103006e);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        actionBar.setDisplayShowTitleEnabled(false);
        bundle = LayoutInflater.from(this).inflate(0x7f030018, null);
        drawable = getResources().getDrawable(0x7f0200ce);
        drawable.setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_ATOP);
        rl_actionbarforum = (RelativeLayout)bundle.findViewById(0x7f0b005c);
        txt_label_actionbar = (TextView)bundle.findViewById(0x7f0b005d);
        txt_sublabel_actionbar = (TextView)bundle.findViewById(0x7f0b005e);
        txt_label_actionbar.setSelected(true);
        img_label_actionbar = (ImageView)bundle.findViewById(0x7f0b005f);
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            img_label_actionbar.setBackgroundDrawable(drawable);
            txt_sublabel_actionbar.setBackgroundDrawable(drawable);
        } else
        {
            img_label_actionbar.setBackground(drawable);
            txt_sublabel_actionbar.setBackground(drawable);
        }
        actionBar.setCustomView(bundle);
        actionBar.setDisplayShowCustomEnabled(true);
        try
        {
            vSlidingMenu = new DobSlidingMenu(this);
            vSlidingMenu.setSlidingType(com.dobmob.dobsliding.models.SlidingItem.SlidingType.MOVE);
            vSlidingMenu.setSlidingView(0x7f030105);
            vSlidingMenu.setUseHandle(false);
            vSlidingMenu.setMaxDuration(500);
            vSlidingMenu.setOnCollapsedListener(new OnCollapsedListener() {

                final RSSTimelineActivity this$0;

                public void onCollapsed()
                {
                    Log.i(TAG, "onCollapsed");
                    isExpand = false;
                }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
            });
            vSlidingMenu.setOnExpandedListener(new OnExpandedListener() {

                final RSSTimelineActivity this$0;

                public void onExpanded()
                {
                    Log.i(TAG, "onExpanded");
                    isExpand = true;
                }

            
            {
                this$0 = RSSTimelineActivity.this;
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

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        extras = getIntent().getExtras();
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
        if (tag_timeline.equals("BlackBerry"))
        {
            title_bar = "BlackBerry";
            tag_timeline = "Blackberry";
        } else
        if (tag_timeline.equals("WindowsPhone"))
        {
            title_bar = "Windows Phone";
            tag_timeline = "WindowsPhone";
        } else
        if (tag_timeline.equals("internet"))
        {
            title_bar = "Internet & Social Media";
            tag_timeline = "internet";
        } else
        if (tag_timeline.equals("Aplikasi"))
        {
            title_bar = "Aplikasi";
            tag_timeline = "Aplikasi";
        } else
        if (tag_timeline.equals("Tips"))
        {
            title_bar = "Tips & Trik";
            tag_timeline = "TipsTrik";
        } else
        if (tag_timeline.equals("Game"))
        {
            title_bar = "Game";
            tag_timeline = "Game";
        } else
        if (tag_timeline.equals("Tips"))
        {
            title_bar = "Tips & Trik";
            tag_timeline = "TipsTrik";
        } else
        if (tag_timeline.equals("ECommerce"))
        {
            title_bar = "E-Commerce";
            tag_timeline = "ECommerce";
        } else
        {
            title_bar = "Terbaru";
            tag_timeline = "terbaru";
        }
        txt_sublabel_actionbar.setText(title_bar);
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName((new StringBuilder("RSS ")).append(title_bar).toString());
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        imm = (InputMethodManager)getSystemService("input_method");
        cm = (ConnectivityManager)getSystemService("connectivity");
        t = Utility.session(t);
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
        extras = getIntent().getExtras();
        t = Utility.session(t);
        if (Resources.getSystem().getIdentifier("action_bar_title", "id", "android") != 0);
        mLinearListView = (LinearLayout)findViewById(0x7f0b04d8);
        notificationLikeHelper = new NotificationLikeRSSHelper(this);
        mArrayListData = new ArrayList();
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showStubImage(0x7f020297).showImageOnLoading(0x7f020209).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020209).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        txtbtnheader = (TextView)findViewById(0x7f0b04d4);
        txtbtnfooter = (TextView)findViewById(0x7f0b04d9);
        txtbtnfooter.setText("Tekan untuk lihat berita lama...");
        layout_header = (LinearLayout)findViewById(0x7f0b04d5);
        grup_footer = (LinearLayout)findViewById(0x7f0b00be);
        layout_footerNext = (LinearLayout)findViewById(0x7f0b00c0);
        grup_header = (LinearLayout)findViewById(0x7f0b04d3);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        pop_progressbar_middle = (ProgressBar)findViewById(0x7f0b04ce);
        pop_txt_empty = (TextView)findViewById(0x7f0b04cf);
        pop_txt_empty.setVisibility(8);
        scroll_artikel.setVisibility(8);
        btnRefresh = (Button)findViewById(0x7f0b04d0);
        slidingView = vSlidingMenu.getSlidingView();
        ll_head_1 = (LinearLayout)slidingView.findViewById(0x7f0b05bc);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            ll_head_1.setVisibility(0);
        } else
        {
            ll_head_1.setVisibility(8);
        }
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
            user_jekel = cursor.getString(9);
            user_ponsel1 = cursor.getString(10);
            user_ponsel2 = cursor.getString(11);
            user_provider1 = cursor.getString(12);
            user_provider2 = cursor.getString(13);
            user_joindate = cursor.getString(14);
            user_profile_update = cursor.getString(15);
            cursor.close();
        }
        try
        {
            urlRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_all_category").append(Utility.BASE_FORMAT).append("?").append("lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&page=").append(page_counter).toString();
            Log.e("urlRSS", urlRSS);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        layout_empty.setVisibility(0);
        TimelineTask();
        grup_header.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                TimelineNEXTTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        grup_footer.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                TimelinePREVTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03d3).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Terbaru");
                vSlidingMenu.collapse();
                tag_timeline = "terbaru";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03d4).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Terpopuler");
                vSlidingMenu.collapse();
                tag_timeline = "terpopuler";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b03d5).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Terkomentari");
                vSlidingMenu.collapse();
                tag_timeline = "terkomentari";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b0797).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Android");
                vSlidingMenu.collapse();
                tag_timeline = "Android";
                tag_code = "OS2";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b079a).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("BlackBerry");
                vSlidingMenu.collapse();
                tag_timeline = "BlackBerry";
                tag_code = "OS4";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b079d).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("IOS");
                vSlidingMenu.collapse();
                tag_timeline = "IOS";
                tag_code = "OS5";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07a0).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Windows Phone");
                vSlidingMenu.collapse();
                tag_timeline = "WindowsPhone";
                tag_code = "OS14";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07a3).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Platform Lain");
                vSlidingMenu.collapse();
                tag_timeline = "PlatformLain";
                tag_code = "OSALL";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07a8).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Telkomsel");
                vSlidingMenu.collapse();
                tag_timeline = "Telkomsel";
                tag_code = "OPTSEL";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07ab).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("XL");
                vSlidingMenu.collapse();
                tag_timeline = "XL";
                tag_code = "OPXL";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07ae).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Indosat");
                vSlidingMenu.collapse();
                tag_timeline = "Indosat";
                tag_code = "OPIND";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07b1).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Tri");
                vSlidingMenu.collapse();
                tag_timeline = "Tri";
                tag_code = "OPTRI";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07b4).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Axis");
                vSlidingMenu.collapse();
                tag_timeline = "Axis";
                tag_code = "OPAXIS";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07b7).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Smartfren");
                vSlidingMenu.collapse();
                tag_timeline = "Smartfren";
                tag_code = "OPSMTF";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07ba).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Ceria");
                vSlidingMenu.collapse();
                tag_timeline = "Ceria";
                tag_code = "OPCERIA";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07bd).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Esia");
                vSlidingMenu.collapse();
                tag_timeline = "Esia";
                tag_code = "OPESIA";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07c0).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Telkom");
                vSlidingMenu.collapse();
                tag_timeline = "Telkom";
                tag_code = "OPTKOM";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07c5).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Aplikasi");
                vSlidingMenu.collapse();
                tag_timeline = "Aplikasi";
                tag_code = "KATAPP";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07c8).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Game");
                vSlidingMenu.collapse();
                tag_timeline = "Game";
                tag_code = "KATGAME";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07cb).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Tips & Trik");
                vSlidingMenu.collapse();
                tag_timeline = "TipsTrik";
                tag_code = "KATTIPS";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07ce).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Internet & Social Media");
                vSlidingMenu.collapse();
                tag_timeline = "Internet";
                tag_code = "KATINET";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07d1).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Firmware");
                vSlidingMenu.collapse();
                tag_timeline = "Firmware";
                tag_code = "KATFIRM";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07d4).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Gadget");
                vSlidingMenu.collapse();
                tag_timeline = "Gadget";
                tag_code = "KATGADGET";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07d6).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("E-Commerce");
                vSlidingMenu.collapse();
                tag_timeline = "ECommerce";
                tag_code = "KATECOM";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07d9).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Teknologi & Science");
                vSlidingMenu.collapse();
                tag_timeline = "Teknologi";
                tag_code = "KATTEKNO";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07dc).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Bisnis & Corporate");
                vSlidingMenu.collapse();
                tag_timeline = "Bisnis";
                tag_code = "KATBIS";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07df).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Pemerintah");
                vSlidingMenu.collapse();
                tag_timeline = "Pemerintah";
                tag_code = "KATGOV";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07e2).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Gaya Hidup");
                vSlidingMenu.collapse();
                tag_timeline = "GayaHidup";
                tag_code = "KATGAYA";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07e5).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Tokoh");
                vSlidingMenu.collapse();
                tag_timeline = "Tokoh";
                tag_code = "KATTOKOH";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07e8).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Komunitas");
                vSlidingMenu.collapse();
                tag_timeline = "Komunitas";
                tag_code = "KATKOM";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        slidingView.findViewById(0x7f0b07eb).setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

            public void onClick(View view)
            {
                txt_sublabel_actionbar.setText("Startup");
                vSlidingMenu.collapse();
                tag_timeline = "Startup";
                tag_code = "KATSTUP";
                TimelineTask();
            }

            
            {
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganAndroid.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganBlackBerry.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganIOS.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganWindowsPhone.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganPlatformLain.setVisibility(4);
        btn_LangganPlatformLain.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganTelkomsel.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganXL.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganIndosat.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganTri.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganAxis.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganSmartfren.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganCeria.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganEsia.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganTelkom.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganAplikasi.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganGame.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganTips.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganInternet.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganFirmware.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganGadget.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganECommerce.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganTeknologi.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganBisnis.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganPemerintah.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganGayaHidup.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganTokoh.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganKomunitas.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        btn_LangganStartup.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSTimelineActivity this$0;

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
                this$0 = RSSTimelineActivity.this;
                super();
            }
        });
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            dataSubscribe = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("get_user_rsssubscribe").append(Utility.BASE_FORMAT).append("?").append("id_user=").append(user_id).append("&t=").append(t).toString();
            (new GetSubscribe(null)).execute(new Void[0]);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0000, menu);
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
            overridePendingTransition(0x7f040001, 0x7f040002);
            return true;

        case 2131429681: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/rsstab/RSSInteraksiActivity));
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    public void update(Observable observable, Object obj)
    {
        if (!ponselBaseApp.getObserver().getUpdateType().equals("likerss")) goto _L2; else goto _L1
_L1:
        int i;
        Log.e("id_rssup", ponselBaseApp.getObserver().getIndexRSS());
        Log.e("mLinearListView", String.valueOf(mLinearListView.getChildCount()));
        i = 0;
_L3:
        if (i < mLinearListView.getChildCount())
        {
label0:
            {
                Object obj1 = mLinearListView.getChildAt(i);
                observable = (TextView)((View) (obj1)).findViewById(0x7f0b054d);
                obj = (TextView)((View) (obj1)).findViewById(0x7f0b0551);
                ImageView imageview = (ImageView)((View) (obj1)).findViewById(0x7f0b054f);
                obj1 = (TextView)((View) (obj1)).findViewById(0x7f0b034a);
                if (!observable.getText().toString().equals(ponselBaseApp.getObserver().getIndexRSS()))
                {
                    break label0;
                }
                ((TextView) (obj)).setText(ponselBaseApp.getObserver().getTot_LikeRSS());
                ((TextView) (obj1)).setText(ponselBaseApp.getObserver().getJum_komenLikeRSS());
                imageview.setBackgroundResource(0x7f020264);
            }
        }
_L4:
        if (ponselBaseApp.getObserver().getLoginStat().equals("1") && userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Observable observable) { }
            nama_asli = cursor.getString(2);
            user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
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
        }
        return;
        i++;
          goto _L3
_L2:
        if (!ponselBaseApp.getObserver().getUpdateType().equals("favrss"))
        {
            continue; /* Loop/switch isn't completed */
        }
        i = 0;
_L5:
        if (i < mLinearListView.getChildCount())
        {
label1:
            {
                obj = mLinearListView.getChildAt(i);
                observable = (ImageView)((View) (obj)).findViewById(0x7f0b0552);
                obj = (TextView)((View) (obj)).findViewById(0x7f0b054d);
                Log.e("rssidmatch", (new StringBuilder(String.valueOf(ponselBaseApp.getObserver().getIndexRSS()))).append("=").append(((TextView) (obj)).getText().toString()).toString());
                if (!((TextView) (obj)).getText().toString().equals(ponselBaseApp.getObserver().getIndexRSS()))
                {
                    break label1;
                }
                if (ponselBaseApp.getObserver().getFav_stat_rss().toString().equals("1"))
                {
                    observable.setBackgroundResource(0x7f020303);
                } else
                {
                    observable.setBackgroundResource(0x7f020302);
                }
            }
        }
          goto _L4
        i++;
          goto _L5
        if (!ponselBaseApp.getObserver().getUpdateType().equals("komentarrss")) goto _L4; else goto _L6
_L6:
        i = 0;
        while (i < mLinearListView.getChildCount()) 
        {
            obj = mLinearListView.getChildAt(i);
            observable = (TextView)((View) (obj)).findViewById(0x7f0b054d);
            obj = (TextView)((View) (obj)).findViewById(0x7f0b034a);
            Log.e("rssidmatch", (new StringBuilder(String.valueOf(ponselBaseApp.getObserver().getIndexRSS()))).append("=").append(observable.getText().toString()).toString());
            if (observable.getText().toString().equals(ponselBaseApp.getObserver().getIndexRSS()))
            {
                ((TextView) (obj)).setText(ponselBaseApp.getObserver().getJum_komenLikeRSS());
            }
            i++;
        }
          goto _L4
    }

    public void updateViewLikeDis(String s)
    {
        int i;
        Log.e("id_kom", s);
        Log.e("mLinearListView", String.valueOf(mLinearListView.getChildCount()));
        i = 0;
_L2:
        ImageView imageview;
        RelativeLayout relativelayout;
        if (i >= mLinearListView.getChildCount())
        {
            return;
        }
        Object obj = mLinearListView.getChildAt(i);
        TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b054d);
        TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0551);
        TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b0554);
        imageview = (ImageView)((View) (obj)).findViewById(0x7f0b054f);
        relativelayout = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0342);
        obj = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0345);
        if (textview.getText().toString().equals(s))
        {
            textview1.setText(tot_LikeRSS);
            textview2.setText(totdis_LikeKom);
            if (!statuslike.equals("1"))
            {
                break; /* Loop/switch isn't completed */
            }
            imageview.setBackgroundResource(0x7f020264);
            relativelayout.setEnabled(false);
            ((RelativeLayout) (obj)).setEnabled(true);
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!statuslike.equals("0")) goto _L4; else goto _L3
_L3:
        imageview.setBackgroundResource(0x7f020265);
        relativelayout.setEnabled(true);
          goto _L4
    }

    public void updateViewRSSFav(String s, String s1, String s2)
    {
        Log.e("id_kom", s);
        Log.e("resstat", s1);
        Log.e("mLinearListView", String.valueOf(mLinearListView.getChildCount()));
        int i = 0;
        do
        {
            if (i >= mLinearListView.getChildCount())
            {
                return;
            }
            Object obj = mLinearListView.getChildAt(i);
            TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b054d);
            TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0419);
            TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b05ec);
            TextView textview3 = (TextView)((View) (obj)).findViewById(0x7f0b054e);
            TextView textview4 = (TextView)((View) (obj)).findViewById(0x7f0b054c);
            TextView textview5 = (TextView)((View) (obj)).findViewById(0x7f0b05e9);
            TextView textview6 = (TextView)((View) (obj)).findViewById(0x7f0b05ea);
            TextView textview7 = (TextView)((View) (obj)).findViewById(0x7f0b0551);
            TextView textview8 = (TextView)((View) (obj)).findViewById(0x7f0b034a);
            ImageView imageview = (ImageView)((View) (obj)).findViewById(0x7f0b0552);
            obj = (TextView)((View) (obj)).findViewById(0x7f0b0650);
            if (textview.getText().toString().equals(s))
            {
                parseJSONAddFav(s1);
                Log.e("postStatusAddRss", postStatusAddRss);
                if (postStatusAddRss.equals("1") || postStatusAddRss.equals("10"))
                {
                    if (textview6.equals(""))
                    {
                        db.addRSS(textview.getText().toString(), textview1.getText().toString(), textview5.getText().toString(), textview2.getText().toString(), textview3.getText().toString(), rss_content, "", s2, textview4.getText().toString(), textview7.getText().toString(), textview8.getText().toString(), "");
                    } else
                    {
                        db.addRSS(textview.getText().toString(), textview1.getText().toString(), textview5.getText().toString(), textview2.getText().toString(), textview3.getText().toString(), rss_content, textview6.getText().toString(), s2, textview4.getText().toString(), textview7.getText().toString(), textview8.getText().toString(), "");
                    }
                    if (db.getRSSCount() > 0)
                    {
                        Toast.makeText(this, postMessageAddRss, 1).show();
                        imageview.setBackgroundResource(0x7f020303);
                    } else
                    {
                        Toast.makeText(this, postMessageAddRss, 1).show();
                        imageview.setBackgroundResource(0x7f020302);
                    }
                    ((TextView) (obj)).setText("1");
                    mDialog.dismiss();
                    return;
                }
                if (postStatusAddRss.equals("00") || postStatusAddRss.equals("0"))
                {
                    db.deleteHP(textview.getText().toString());
                    if (!db.checkIfExist(textview.getText().toString()))
                    {
                        Toast.makeText(this, "Berhasil menghapus", 1).show();
                        imageview.setBackgroundResource(0x7f020302);
                    } else
                    {
                        Toast.makeText(this, postMessageAddRss, 1).show();
                        imageview.setBackgroundResource(0x7f020303);
                    }
                    ((TextView) (obj)).setText("0");
                    mDialog.dismiss();
                    return;
                }
                if (res.equals("40404"))
                {
                    mDialog.dismiss();
                    return;
                } else
                {
                    Toast.makeText(this, postMessageAddRss, 1).show();
                    return;
                }
            }
            i++;
        } while (true);
    }







}
