// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.details.ProfilPTActivity;
import com.inponsel.android.favorit.FavoritArtikelBerita;
import com.inponsel.android.favorit.FavoritArtikelForum;
import com.inponsel.android.favorit.FavoritPonselMerek;
import com.inponsel.android.favorit.IkutiForumPonsel;
import com.inponsel.android.favorit.LanggananBeritaAll;
import com.inponsel.android.pencarianrinci.PencarianRinciPonsel;
import com.inponsel.android.tlforum.ForumHPActivity;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity, RegisterActivity, LoginActivity, RSSFeedByTag, 
//            MerekActivity, HomeNewsActivity, HomeAppsActivity, HomeGamesActivity, 
//            SCUserActivity, TurunHargaPonselActivity, PengaturanActivity, FAQActivity, 
//            KebijakanActivity, HubungiActivity, PersyaratanActivity, TentangActivity, 
//            ProfileActivity, RoomGroupChatListActivity, InboxMessageActivity, ImagePagerActivity

public abstract class BaseDrawer extends SherlockFragmentActivity
    implements android.view.View.OnClickListener, Observer
{
    private class ActionBarHelper
    {

        private final ActionBar mActionBar;
        final BaseDrawer this$0;

        public void init()
        {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeButtonEnabled(true);
        }

        public void onDrawerClosed()
        {
        }

        public void onDrawerOpened()
        {
        }

        private ActionBarHelper()
        {
            this$0 = BaseDrawer.this;
            super();
            mActionBar = getSupportActionBar();
        }

        ActionBarHelper(ActionBarHelper actionbarhelper)
        {
            this();
        }
    }

    public class DeleteHpFavTask extends AsyncTask
    {

        final BaseDrawer this$0;

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
                querySubs = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&type=").append("all").append("&stat=").append("0").append("&t=").append(t).toString();
                pushURLSubs = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_subscribe_artikel").append(Utility.BASE_FORMAT).append("?").append(querySubs).toString();
                Log.e("pushURL", pushURLSubs);
                avoid = HttpPush.getResponse(pushURLSubs);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(querySubs).toString());
                resSubs = avoid.toString();
                Log.e("url ", resSubs);
                parseJSONSubsNews(resSubs);
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
            dataPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_favorit_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).toString();
            Log.e("data", dataPonsel);
            FavPonselTask();
            if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
            {
                Toast.makeText(BaseDrawer.this, postMessageSubsNews, 1).show();
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(BaseDrawer.this, postMessageSubsNews, 1).show();
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            } else
            {
                Toast.makeText(BaseDrawer.this, postMessageSubsNews, 1).show();
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mDialog = ProgressDialog.show(BaseDrawer.this, "", "Menghapus...", true);
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public DeleteHpFavTask()
        {
            this$0 = BaseDrawer.this;
            super();
        }
    }

    private class DemoDrawerListener
        implements android.support.v4.widget.DrawerLayout.DrawerListener
    {

        final BaseDrawer this$0;

        public void onDrawerClosed(View view)
        {
            mDrawerToggle.onDrawerClosed(view);
            mActionBar.onDrawerClosed();
        }

        public void onDrawerOpened(View view)
        {
            mDrawerToggle.onDrawerOpened(view);
            mActionBar.onDrawerOpened();
        }

        public void onDrawerSlide(View view, float f)
        {
            mDrawerToggle.onDrawerSlide(view, f);
        }

        public void onDrawerStateChanged(int j)
        {
            mDrawerToggle.onDrawerStateChanged(j);
        }

        private DemoDrawerListener()
        {
            this$0 = BaseDrawer.this;
            super();
        }

        DemoDrawerListener(DemoDrawerListener demodrawerlistener)
        {
            this();
        }
    }

    private class FavBrandTask extends AsyncTask
    {

        final BaseDrawer this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataBrand, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_312;
                }
                ListModel listmodel;
                int j;
                try
                {
                    saveJson("F512991", avoid);
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    stat = avoid.getString("stat");
                    count_first_favbrand = avoid.getInt("count_first");
                    count_all_favbrand = avoid.getInt("count_all");
                    Log.e("suc", suc);
                    counterArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_319;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_319;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_319;
                }
                j = 0;
            }
            if (j >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_319;
            }
            avoid = BaseDrawer.this;
            avoid.counterArray = ((BaseDrawer) (avoid)).counterArray + 1;
            avoid = inponsel.getJSONObject(j);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_brand"));
            listmodel.setModel("");
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename("");
            listmodel.setGambar(avoid.getString("logo"));
            listmodel.setUmu_status("-");
            listmodel.setHrg_baru("");
            listmodel.setHrg_bekas("");
            favBrandArray.add(listmodel);
            j++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_165;
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
            if (count_all_favbrand > 3 || count_all_favhp > 3)
            {
                txtMoreBrandFavorit.setVisibility(0);
            } else
            {
                txtMoreBrandFavorit.setVisibility(8);
            }
            Log.e("data", dataBrand);
            Log.e("favHpArray", String.valueOf(favHpArray.size()));
            favBrandAdapter.notifyDataSetChanged();
            Log.e("favBrandArray", String.valueOf(favBrandArray.size()));
            if (counterHpArray != 0 || favBrandArray.size() != 0)
            {
                break MISSING_BLOCK_LABEL_170;
            }
            menu_ListFavorit.setVisibility(8);
_L1:
            img_RefBookmark.setVisibility(0);
            progressbar_Bookmark.setVisibility(8);
            return;
            try
            {
                menu_ListFavorit.setVisibility(0);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            favBrandArray.clear();
        }

        private FavBrandTask()
        {
            this$0 = BaseDrawer.this;
            super();
        }

        FavBrandTask(FavBrandTask favbrandtask)
        {
            this();
        }
    }

    private class FavPonselTask extends AsyncTask
    {

        final BaseDrawer this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataPonsel, 1);
                Log.e("Responsefavhp: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_322;
                }
                ListModel listmodel;
                int j;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    stat = avoid.getString("stat");
                    count_first_favhp = avoid.getInt("count_first");
                    count_all_favhp = avoid.getInt("count_all");
                    Log.e("suc", suc);
                    counterHpArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_329;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_329;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_329;
                }
                j = 0;
            }
            if (j >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_329;
            }
            avoid = BaseDrawer.this;
            avoid.counterHpArray = ((BaseDrawer) (avoid)).counterHpArray + 1;
            avoid = inponsel.getJSONObject(j);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel(avoid.getString("model"));
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename(avoid.getString("codename"));
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status(avoid.getString("umu_status"));
            listmodel.setHrg_baru(avoid.getString("hrg_baru"));
            listmodel.setHrg_bekas(avoid.getString("hrg_bekas"));
            favHpArray.add(listmodel);
            j++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_155;
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
                Log.e("data", dataPonsel);
                Log.e("favHpArrayafter", String.valueOf(favHpArray.size()));
                favHpAdapter.notifyDataSetChanged();
                Log.e("counterArray", String.valueOf(favHpArray.size()));
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
            favHpArray.clear();
        }

        private FavPonselTask()
        {
            this$0 = BaseDrawer.this;
            super();
        }

        FavPonselTask(FavPonselTask favponseltask)
        {
            this();
        }
    }

    private class ForumPonselTask extends AsyncTask
    {

        final BaseDrawer this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataForumPonsel, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_310;
                }
                ListModel listmodel;
                int j;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    stat = avoid.getString("stat");
                    count_first_HPForum = avoid.getInt("count_first");
                    count_all_HPForum = avoid.getInt("count_all");
                    Log.e("suc", suc);
                    counterArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_317;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_317;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_317;
                }
                j = 0;
            }
            if (j >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_317;
            }
            avoid = BaseDrawer.this;
            avoid.counterArray = ((BaseDrawer) (avoid)).counterArray + 1;
            avoid = inponsel.getJSONObject(j);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel(avoid.getString("model"));
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename(avoid.getString("codename"));
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status("");
            listmodel.setHrg_baru("");
            listmodel.setHrg_bekas("");
            ForumHpArray.add(listmodel);
            j++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_155;
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
            if (count_all_HPForum > 3)
            {
                txtMoreHPForum.setVisibility(0);
            } else
            {
                txtMoreHPForum.setVisibility(8);
            }
            try
            {
                Log.e("ForumHpArray", String.valueOf(ForumHpArray.size()));
                Log.e("dataForumPonsel", dataForumPonsel);
                Log.e("ForumHpArray", String.valueOf(ForumHpArray.size()));
                ForumHpAdapter.notifyDataSetChanged();
                Log.e("counterArray", String.valueOf(ForumHpArray.size()));
                progressbar_ForumFollow.setVisibility(8);
                img_RefForumFollow.setVisibility(0);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1) { }
            (new Handler()).postDelayed(new Runnable() {

                final ForumPonselTask this$1;

                public void run()
                {
                    sv_drawer_menu.fullScroll(33);
                }

            
            {
                this$1 = ForumPonselTask.this;
                super();
            }
            }, 100L);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            ForumHpArray.clear();
        }


        private ForumPonselTask()
        {
            this$0 = BaseDrawer.this;
            super();
        }

        ForumPonselTask(ForumPonselTask forumponseltask)
        {
            this();
        }
    }

    private class LangananBrandTask extends AsyncTask
    {

        final BaseDrawer this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataLangganBrand, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_302;
                }
                ListModel listmodel;
                int j;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    stat = avoid.getString("stat");
                    count_first_BrandLangganan = avoid.getInt("count_first");
                    count_all_BrandLangganan = avoid.getInt("count_all");
                    Log.e("suc", suc);
                    counterArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_309;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_309;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_309;
                }
                j = 0;
            }
            if (j >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_309;
            }
            avoid = BaseDrawer.this;
            avoid.counterArray = ((BaseDrawer) (avoid)).counterArray + 1;
            avoid = inponsel.getJSONObject(j);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel("");
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename("");
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status("-");
            listmodel.setHrg_baru("");
            listmodel.setHrg_bekas("");
            langganBrandArray.add(listmodel);
            j++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_155;
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
                Log.e("langganBrandArray", String.valueOf(langganBrandArray.size()));
                Log.e("dataLangganBrand", dataLangganBrand);
                Log.e("langganBrandArray", String.valueOf(langganBrandArray.size()));
                langganBrandAdapter.notifyDataSetChanged();
                Log.e("counterArray", String.valueOf(langganBrandArray.size()));
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
            langganBrandArray.clear();
        }

        private LangananBrandTask()
        {
            this$0 = BaseDrawer.this;
            super();
        }

        LangananBrandTask(LangananBrandTask langananbrandtask)
        {
            this();
        }
    }

    private class LangananKatsusTask extends AsyncTask
    {

        final BaseDrawer this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataLangganKatsus, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_302;
                }
                ListModel listmodel;
                int j;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    stat = avoid.getString("stat");
                    count_first_KatKhususLangganan = avoid.getInt("count_first");
                    count_all_KatKhususLangganan = avoid.getInt("count_all");
                    Log.e("suc", suc);
                    counterArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_309;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_309;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_309;
                }
                j = 0;
            }
            if (j >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_309;
            }
            avoid = BaseDrawer.this;
            avoid.counterArray = ((BaseDrawer) (avoid)).counterArray + 1;
            avoid = inponsel.getJSONObject(j);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel("");
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename("");
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status("-");
            listmodel.setHrg_baru("");
            listmodel.setHrg_bekas("");
            langganKatKhususArray.add(listmodel);
            j++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_155;
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
            if (count_all_HPLangganan > 3 || count_all_BrandLangganan > 3 || count_all_OperatorLangganan > 3 || count_all_KatKhususLangganan > 3)
            {
                txtMoreKatKhususLangganan.setVisibility(0);
            } else
            {
                txtMoreKatKhususLangganan.setVisibility(8);
            }
            try
            {
                Log.e("langganKatKhususArray", String.valueOf(langganKatKhususArray.size()));
                Log.e("dataLangganKatsus", dataLangganKatsus);
                Log.e("langganKatKhususArray", String.valueOf(langganKatKhususArray.size()));
                langganKatKhususAdapter.notifyDataSetChanged();
                Log.e("counterArray", String.valueOf(langganKatKhususArray.size()));
                progressbar_LanggananBerita.setVisibility(8);
                img_RefLanggananBerita.setVisibility(0);
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
            langganKatKhususArray.clear();
        }

        private LangananKatsusTask()
        {
            this$0 = BaseDrawer.this;
            super();
        }

        LangananKatsusTask(LangananKatsusTask langanankatsustask)
        {
            this();
        }
    }

    private class LangananOpTask extends AsyncTask
    {

        final BaseDrawer this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataLangganOperator, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_302;
                }
                ListModel listmodel;
                int j;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    stat = avoid.getString("stat");
                    count_first_OperatorLangganan = avoid.getInt("count_first");
                    count_all_OperatorLangganan = avoid.getInt("count_all");
                    Log.e("suc", suc);
                    counterArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_309;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_309;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_309;
                }
                j = 0;
            }
            if (j >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_309;
            }
            avoid = BaseDrawer.this;
            avoid.counterArray = ((BaseDrawer) (avoid)).counterArray + 1;
            avoid = inponsel.getJSONObject(j);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel("");
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename("");
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status("-");
            listmodel.setHrg_baru("");
            listmodel.setHrg_bekas("");
            langganOpArray.add(listmodel);
            j++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_155;
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
                Log.e("langganOpArray", String.valueOf(langganOpArray.size()));
                Log.e("dataLangganOperator", dataLangganOperator);
                Log.e("langganOpArray", String.valueOf(langganOpArray.size()));
                langganOpAdapter.notifyDataSetChanged();
                Log.e("counterArray", String.valueOf(langganOpArray.size()));
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
            langganOpArray.clear();
        }

        private LangananOpTask()
        {
            this$0 = BaseDrawer.this;
            super();
        }

        LangananOpTask(LangananOpTask langananoptask)
        {
            this();
        }
    }

    private class LangananPonselTask extends AsyncTask
    {

        final BaseDrawer this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataLangganPonsel, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_322;
                }
                ListModel listmodel;
                int j;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    stat = avoid.getString("stat");
                    count_first_HPLangganan = avoid.getInt("count_first");
                    count_all_HPLangganan = avoid.getInt("count_all");
                    Log.e("suc", suc);
                    counterArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_329;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_329;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_329;
                }
                j = 0;
            }
            if (j >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_329;
            }
            avoid = BaseDrawer.this;
            avoid.counterArray = ((BaseDrawer) (avoid)).counterArray + 1;
            avoid = inponsel.getJSONObject(j);
            listmodel = new ListModel();
            listmodel.setId_hp(avoid.getString("id_hp"));
            listmodel.setModel(avoid.getString("model"));
            listmodel.setMerk(avoid.getString("merk"));
            listmodel.setCodename(avoid.getString("codename"));
            listmodel.setGambar(avoid.getString("gambar"));
            listmodel.setUmu_status(avoid.getString("umu_status"));
            listmodel.setHrg_baru(avoid.getString("hrg_baru"));
            listmodel.setHrg_bekas(avoid.getString("hrg_bekas"));
            langganHpArray.add(listmodel);
            j++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_155;
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
                Log.e("langganHpArray", String.valueOf(langganHpArray.size()));
                Log.e("dataLangganPonsel", dataLangganPonsel);
                Log.e("langganHpArray", String.valueOf(langganHpArray.size()));
                langganHpAdapter.notifyDataSetChanged();
                Log.e("counterArray", String.valueOf(langganHpArray.size()));
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
            langganHpArray.clear();
        }

        private LangananPonselTask()
        {
            this$0 = BaseDrawer.this;
            super();
        }

        LangananPonselTask(LangananPonselTask langananponseltask)
        {
            this();
        }
    }

    public class ListHPFavAdapter extends BaseAdapter
    {

        private Activity activity;
        private ArrayList arraylm;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        int hargaBaru;
        int hargaBekas;
        String hrg_baru;
        String hrg_bekas;
        ImageLoader imageLoader2;
        String indexhp;
        String komen;
        ListModel lms;
        private DisplayImageOptions options;
        PonselBaseApp ponselBaseApp;
        int pos;
        String res;
        int resource;
        String response;
        String statSubNews;
        String statusLikeHp;
        String t;
        final BaseDrawer this$0;
        String user;
        UserFunctions userFunctions;

        public int getCount()
        {
            return arraylm.size();
        }

        public Object getItem(int j)
        {
            return null;
        }

        public long getItemId(int j)
        {
            return 0L;
        }

        public ListModel getListModel(int j)
        {
            return (ListModel)arraylm.get(j);
        }

        public View getView(int j, View view, ViewGroup viewgroup)
        {
            pos = j;
            viewgroup = (LayoutInflater)activity.getSystemService("layout_inflater");
            if (view == null)
            {
                view = viewgroup.inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.list_txtCodename = (TextView)view.findViewById(0x7f0b033f);
                viewgroup.txt_NotifHp = (TextView)view.findViewById(0x7f0b0651);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)arraylm.get(j);
            if (arraylm != null)
            {
                hrg_baru = lms.getHrg_baru();
                hrg_bekas = lms.getHrg_bekas();
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                ((ViewHolder) (viewgroup)).list_txtCodename.setText(lms.getCodename());
                if (lms.getUmu_status().equals("3") || hrg_baru.equals("-") || hrg_baru.equals("0"))
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                } else
                {
                    ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                    ((ViewHolder) (viewgroup)).list_txtHarga.setText((new StringBuilder()).append(hrg_baru).toString());
                }
                ((ViewHolder) (viewgroup)).txt_NotifHp.setText("Hapus");
                ((ViewHolder) (viewgroup)).txt_NotifHp.setOnClickListener(j. new android.view.View.OnClickListener() {

                    final ListHPFavAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        if (userFunctions.isUserLoggedIn(getApplicationContext()))
                        {
                            view = new android.app.AlertDialog.Builder(getApplicationContext());
                            view.setMessage("Hentikan langganan forum perangkat ini?");
                            view.setPositiveButton("Ya", position. new android.content.DialogInterface.OnClickListener() {

                                final ListHPFavAdapter._cls1 this$2;
                                private final int val$position;

                                public void onClick(DialogInterface dialoginterface, int j)
                                {
                                    dialoginterface.dismiss();
                                    id_hp_del = getListModel(position).getId_hp();
                                    statSubNews = "0";
                                    (new DeleteHpFavTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = final__pcls1;
                position = I.this;
                super();
            }
                            });
                            view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final ListHPFavAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int j)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListHPFavAdapter._cls1.this;
                super();
            }
                            });
                            view.show();
                            return;
                        } else
                        {
                            view = new android.app.AlertDialog.Builder(getApplicationContext());
                            view.setMessage("Untuk berlangganan forum, diharuskan login.");
                            view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                                final ListHPFavAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int j)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = ListHPFavAdapter._cls1.this;
                super();
            }
                            });
                            view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                                final ListHPFavAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int j)
                                {
                                    dialoginterface = new Intent(getApplicationContext(), com/inponsel/android/v2/RegisterActivity);
                                    startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListHPFavAdapter._cls1.this;
                super();
            }
                            });
                            view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                                final ListHPFavAdapter._cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int j)
                                {
                                    dialoginterface = new Intent(getApplicationContext(), com/inponsel/android/v2/LoginActivity);
                                    dialoginterface.putExtra("activity", "main");
                                    startActivityForResult(dialoginterface, 0);
                                    overridePendingTransition(0x7f040003, 0x7f040004);
                                }

            
            {
                this$2 = ListHPFavAdapter._cls1.this;
                super();
            }
                            });
                            view.show();
                            return;
                        }
                    }


            
            {
                this$1 = final_listhpfavadapter;
                position = I.this;
                super();
            }
                });
                try
                {
                    imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString(), ((ViewHolder) (viewgroup)).imageHp, options, viewgroup. new ImageLoadingListener() {

                        final ListHPFavAdapter this$1;
                        private final ListHPFavAdapter.ViewHolder val$holder;

                        public void onLoadingCancelled(String s, View view)
                        {
                        }

                        public void onLoadingComplete(String s, View view, Bitmap bitmap)
                        {
                            holder.progressbar_item.setVisibility(8);
                            holder.imageHp.setVisibility(0);
                        }

                        public void onLoadingFailed(String s, View view, FailReason failreason)
                        {
                            holder.progressbar_item.setVisibility(8);
                            holder.imageHp.setVisibility(0);
                        }

                        public void onLoadingStarted(String s, View view)
                        {
                            holder.progressbar_item.setVisibility(0);
                            holder.imageHp.setVisibility(8);
                        }

            
            {
                this$1 = final_listhpfavadapter;
                holder = ListHPFavAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                // Misplaced declaration of an exception variable
                catch (ViewGroup viewgroup)
                {
                    return view;
                }
            }
            return view;
        }

        void log(String s)
        {
        }

        public void setListArray(ArrayList arraylist)
        {
            arraylm = arraylist;
        }


        public ListHPFavAdapter(Activity activity1, int j, ArrayList arraylist)
        {
            this$0 = BaseDrawer.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            user = "";
            komen = "";
            email_user = "";
            indexhp = "";
            finalUrl = "";
            statSubNews = "";
            t = Utility.session(t);
            arraylm = arraylist;
            activity = activity1;
            resource = j;
            t = Utility.session(t);
            try
            {
                imageLoader2 = ImageLoader.getInstance();
                imageLoader2.init(ImageLoaderConfiguration.createDefault(activity.getApplicationContext()));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (BaseDrawer basedrawer)
            {
                return;
            }
        }
    }

    class ListHPFavAdapter.ViewHolder
    {

        ImageView imageHp;
        TextView list_txtCodename;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        final ListHPFavAdapter this$1;
        TextView txt_NotifHp;

        ListHPFavAdapter.ViewHolder()
        {
            this$1 = ListHPFavAdapter.this;
            super();
        }
    }


    protected static final String TAG = com/inponsel/android/v2/BaseDrawer.getName();
    public static boolean isAppWentToBg = false;
    public static boolean isMenuOpened = false;
    public static boolean isWindowFocused = false;
    public ListHPFavAdapter ForumHpAdapter;
    public ArrayList ForumHpArray;
    protected ActionBar actionBar;
    int actionBarTitleId;
    protected ImageLoadingListener animateFirstListener;
    private BufferedReader breader;
    ConnectivityManager cm;
    int count_all_BrandLangganan;
    int count_all_HPForum;
    int count_all_HPLangganan;
    int count_all_KatKhususLangganan;
    int count_all_OperatorLangganan;
    int count_all_favbrand;
    int count_all_favhp;
    int count_first_BrandLangganan;
    int count_first_HPForum;
    int count_first_HPLangganan;
    int count_first_KatKhususLangganan;
    int count_first_OperatorLangganan;
    int count_first_favbrand;
    int count_first_favhp;
    int counterArray;
    int counterHpArray;
    protected Cursor cursor;
    String dataBrand;
    String dataForumPonsel;
    String dataIDMerk;
    String dataLangganBrand;
    String dataLangganKatsus;
    String dataLangganOperator;
    String dataLangganPonsel;
    String dataPonsel;
    protected DatabaseHandler db;
    public String email_user;
    public ListHPFavAdapter favBrandAdapter;
    public ArrayList favBrandArray;
    public ListHPFavAdapter favHpAdapter;
    public ArrayList favHpArray;
    Intent i;
    String id_hp_del;
    protected ImageLoader imageLoader2;
    ImageView imgHpDetail;
    ImageView img_RefBookmark;
    ImageView img_RefForumFollow;
    ImageView img_RefLanggananBerita;
    JSONArray inponsel;
    JSONArray jArray;
    public ListHPFavAdapter langganBrandAdapter;
    public ArrayList langganBrandArray;
    public ListHPFavAdapter langganHpAdapter;
    public ArrayList langganHpArray;
    public ListHPFavAdapter langganKatKhususAdapter;
    public ArrayList langganKatKhususArray;
    public ListHPFavAdapter langganOpAdapter;
    public ArrayList langganOpArray;
    LinearLayout left_drawer;
    GridView listBrandFavorit;
    GridView listBrandLangganan;
    GridView listHPForum;
    GridView listHPLangganan;
    GridView listHpFavorit;
    GridView listKatKhususLangganan;
    GridView listOperatorLangganan;
    LinearLayout ll_home_sc;
    LinearLayout ll_menu_msg;
    ImageLoaderConfiguration loaderConfiguration;
    protected ActionBarHelper mActionBar;
    ProgressDialog mDialog;
    protected DrawerLayout mDrawerLayout;
    protected SherlockActionBarDrawerToggle mDrawerToggle;
    protected RelativeLayout menu_Aplikasi;
    protected RelativeLayout menu_Berita;
    protected RelativeLayout menu_Bookmark;
    protected RelativeLayout menu_FAQ;
    protected RelativeLayout menu_FavArtikelForum;
    protected RelativeLayout menu_FavBerita;
    protected RelativeLayout menu_ForumFollow;
    protected RelativeLayout menu_Games;
    protected RelativeLayout menu_GroupChat;
    protected RelativeLayout menu_Hubungi;
    protected RelativeLayout menu_KebijakanPrivasi;
    protected RelativeLayout menu_LanggananBerita;
    LinearLayout menu_ListFavorit;
    protected RelativeLayout menu_LoginRegister;
    protected RelativeLayout menu_PencarianRinci;
    protected RelativeLayout menu_Persyaratan;
    protected RelativeLayout menu_PusatLayanan;
    protected RelativeLayout menu_Setting;
    protected RelativeLayout menu_Tentang;
    protected RelativeLayout menu_beranda;
    ImageView menu_imgProfil;
    protected RelativeLayout menu_katalog;
    protected RelativeLayout menu_pesan;
    TextView menu_ponsel_pengguna;
    RelativeLayout menu_profil;
    ProgressBar menu_progressbar_item;
    TextView menu_sim_pengguna;
    RelativeLayout menu_turun_harga;
    TextView menu_username;
    public String nama_asli;
    protected DisplayImageOptions options;
    protected PonselBaseApp ponselBaseApp;
    String postMessageSubsNews;
    String postStatusSubsNews;
    ProgressBar progressbar_Bookmark;
    ProgressBar progressbar_ForumFollow;
    ProgressBar progressbar_LanggananBerita;
    String pushURLSubs;
    String pushURLSubsStat;
    String querySubs;
    String querySubsStat;
    String resSubs;
    float speedwheel;
    String stat;
    String suc;
    ScrollView sv_drawer_menu;
    String t;
    String titleMerek;
    Tracker tracker;
    TextView txtMoreBrandFavorit;
    TextView txtMoreBrandLangganan;
    TextView txtMoreHPForum;
    TextView txtMoreHPLangganan;
    TextView txtMoreHpFavorit;
    TextView txtMoreKatKhususLangganan;
    TextView txtMoreOperatorLangganan;
    TextView txtUnreadCount;
    TextView txtUnreadGroupChat;
    String url_update_profile;
    protected boolean useLogo;
    protected UserFunctions userFunctions;
    public String user_id;
    public String user_jekel;
    public String user_joindate;
    public String user_kecamatan;
    public String user_kota;
    public String user_photo;
    public String user_ponsel1;
    public String user_ponsel2;
    public String user_profile_update;
    public String user_provider1;
    public String user_provider2;
    public String user_provinsi;
    public String user_ttl;
    public String username;

    public BaseDrawer()
    {
        url_update_profile = "";
        speedwheel = 1.0F;
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
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
        animateFirstListener = new AnimateFirstDisplayListener();
        count_first_favhp = 0;
        count_all_favhp = 0;
        count_first_favbrand = 0;
        count_all_favbrand = 0;
        count_first_HPLangganan = 0;
        count_all_HPLangganan = 0;
        count_first_BrandLangganan = 0;
        count_all_BrandLangganan = 0;
        count_first_OperatorLangganan = 0;
        count_all_OperatorLangganan = 0;
        count_first_KatKhususLangganan = 0;
        count_all_KatKhususLangganan = 0;
        count_first_HPForum = 0;
        count_all_HPForum = 0;
        dataPonsel = "";
        dataBrand = "";
        dataLangganPonsel = "";
        dataLangganBrand = "";
        dataLangganOperator = "";
        dataLangganKatsus = "";
        dataForumPonsel = "";
        favHpArray = null;
        favBrandArray = null;
        langganHpArray = null;
        langganBrandArray = null;
        langganOpArray = null;
        langganKatKhususArray = null;
        ForumHpArray = null;
        titleMerek = "InPonsel";
        counterHpArray = 0;
        inponsel = null;
        suc = "";
        stat = "";
        t = Utility.session(RestClient.pelihara);
        id_hp_del = "";
    }

    private void PushOnlineStat(String s)
    {
        String s1 = Utility.session(Utility.session(Utility.session(RestClient.pelihara)));
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_last_seen").append(Utility.BASE_FORMAT).append("?").append("id_user=").append(user_id).append("&reg_id=").append("0").append("&stat=").append(s).append("&t=").append(s1).toString();
        Log.e("pushOnline", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final BaseDrawer this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                Log.e("response", jsonobject.toString());
            }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final BaseDrawer this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "");
    }

    private void applicationWillEnterForeground()
    {
        if (isAppWentToBg)
        {
            isAppWentToBg = false;
            if (userFunctions.isUserLoggedIn(getApplicationContext()))
            {
                PushOnlineStat("1");
            }
        }
    }

    private ActionBarHelper createActionBarHelper()
    {
        return new ActionBarHelper(null);
    }

    private void favoriteMerekOpenJson()
    {
        JSONObject jsonobject = new JSONObject(getJSONFile("F512991"));
        inponsel = jsonobject.getJSONArray("InPonsel");
        suc = jsonobject.getString("success");
        stat = jsonobject.getString("stat");
        count_first_favbrand = jsonobject.getInt("count_first");
        count_all_favbrand = jsonobject.getInt("count_all");
        Log.e("suc", suc);
        counterArray = 0;
        if (!suc.equals("1")) goto _L2; else goto _L1
_L1:
        int j = 0;
_L5:
        int k = inponsel.length();
        if (j < k) goto _L3; else goto _L2
_L2:
        JSONObject jsonobject1;
        ListModel listmodel;
        if (count_all_favbrand > 3 || count_all_favhp > 3)
        {
            txtMoreBrandFavorit.setVisibility(0);
        } else
        {
            txtMoreBrandFavorit.setVisibility(8);
        }
        try
        {
            Log.e("favHpArraybefore", String.valueOf(favBrandArray.size()));
            Log.e("data", dataBrand);
            Log.e("favBrandArray", String.valueOf(favBrandArray.size()));
            favBrandAdapter.notifyDataSetChanged();
            Log.e("counterArray", String.valueOf(favBrandArray.size()));
            if (favHpArray.size() == 0 && favBrandArray.size() == 0)
            {
                menu_ListFavorit.setVisibility(8);
                return;
            }
        }
        catch (Exception exception)
        {
            return;
        }
          goto _L4
_L3:
        counterArray = counterArray + 1;
        jsonobject1 = inponsel.getJSONObject(j);
        listmodel = new ListModel();
        listmodel.setId_hp(jsonobject1.getString("id_brand"));
        listmodel.setModel("");
        listmodel.setMerk(jsonobject1.getString("merk"));
        listmodel.setCodename("");
        listmodel.setGambar(jsonobject1.getString("logo"));
        listmodel.setUmu_status("-");
        listmodel.setHrg_baru("");
        listmodel.setHrg_bekas("");
        favBrandArray.add(listmodel);
        j++;
          goto _L5
_L4:
        menu_ListFavorit.setVisibility(0);
        return;
        Exception exception1;
        exception1;
          goto _L2
    }

    private void favoriteOpenJson()
    {
        Object obj = getJSONFile("F412991");
        obj = new JSONObject(((String) (obj)));
        inponsel = ((JSONObject) (obj)).getJSONArray("InPonsel");
        suc = ((JSONObject) (obj)).getString("success");
        stat = ((JSONObject) (obj)).getString("stat");
        count_first_favhp = ((JSONObject) (obj)).getInt("count_first");
        count_all_favhp = ((JSONObject) (obj)).getInt("count_all");
        Log.e("suc", suc);
        counterArray = 0;
        if (!suc.equals("1")) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        int k = inponsel.length();
        if (j < k) goto _L3; else goto _L2
_L2:
        Object obj1;
        ListModel listmodel;
        try
        {
            Log.e("favHpArraybefore", String.valueOf(favHpArray.size()));
            Log.e("data", dataPonsel);
            Log.e("favHpArrayafter", String.valueOf(favHpArray.size()));
            favHpAdapter.notifyDataSetChanged();
            Log.e("counterArray", String.valueOf(favHpArray.size()));
            return;
        }
        catch (Exception exception)
        {
            return;
        }
_L3:
        counterArray = counterArray + 1;
        obj = inponsel.getJSONObject(j);
        listmodel = new ListModel();
        listmodel.setId_hp(((JSONObject) (obj)).getString("id_hp"));
        listmodel.setModel(((JSONObject) (obj)).getString("model"));
        listmodel.setMerk(((JSONObject) (obj)).getString("merk"));
        listmodel.setCodename(((JSONObject) (obj)).getString("codename"));
        listmodel.setGambar(((JSONObject) (obj)).getString("gambar"));
        listmodel.setUmu_status(((JSONObject) (obj)).getString("umu_status"));
        listmodel.setHrg_baru(((JSONObject) (obj)).getString("hrg_baru"));
        listmodel.setHrg_bekas(((JSONObject) (obj)).getString("hrg_bekas"));
        favHpArray.add(listmodel);
        j++;
          goto _L4
        obj1;
        try
        {
            ((JSONException) (obj1)).printStackTrace();
        }
        catch (Exception exception1) { }
          goto _L2
        obj1;
        ((Exception) (obj1)).printStackTrace();
          goto _L2
    }

    private void saveJson(String s, String s1)
        throws Exception
    {
        s = new File((new StringBuilder("/sdcard/Android/data/")).append(getPackageName()).append("/cache/").append(s).toString());
        s.createNewFile();
        s = new FileOutputStream(s);
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(s);
        EncodeDecodeAES.encrypt(RestClient.pelihara, s1);
        outputstreamwriter.append(EncodeDecodeAES.encrypt(RestClient.pelihara, s1));
        outputstreamwriter.close();
        s.close();
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

    private void update_profile()
    {
        try
        {
            Object obj = getSharedPreferences("com.inponsel.android_preference", 0);
            obj = Utility.session(Utility.session(Utility.session(Utility.session(Utility.session(EncodeDecodeAES.decrypt(RestClient.pelihara, ((SharedPreferences) (obj)).getString("save", "")))))));
            String s = URLEncoder.encode(Build.MODEL, "utf-8");
            int j = android.os.Build.VERSION.SDK_INT;
            String s1 = getApplicationContext().getSharedPreferences("GCMPref", 0).getString("gcm_id", null);
            obj = (new StringBuilder("user_name=")).append(username).append("&user_password=").append(((String) (obj))).append("&t=").append(t).append("&reg=").append(s1).append("&dev=").append(s).append("&dos=").append(String.valueOf(j)).toString();
            url_update_profile = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("get_update_profile").append(Utility.BASE_FORMAT).append("?").append(((String) (obj))).toString();
            Log.e("url_update_profile", url_update_profile);
            obj = new AsyncHttpClient();
            ((AsyncHttpClient) (obj)).setMaxRetriesAndTimeout(5, 15000);
            ((AsyncHttpClient) (obj)).get(url_update_profile, new AsyncHttpResponseHandler() {

                final BaseDrawer this$0;

                public void onFailure(int k, Header aheader[], byte abyte0[], Throwable throwable)
                {
                }

                public void onRetry(int k)
                {
                }

                public void onStart()
                {
                }

                public void onSuccess(int k, Header aheader[], byte abyte0[])
                {
                    String s2;
                    String s3;
                    String s4;
                    String s5;
                    String s6;
                    String s7;
                    String s8;
                    String s9;
                    String s10;
                    String s11;
                    String s12;
                    String s13;
                    String s14;
                    String s15;
                    String s16;
                    String s17;
                    Object obj1;
                    try
                    {
                        aheader = (new JSONObject(new String(abyte0))).getJSONArray("InPonsel");
                    }
                    // Misplaced declaration of an exception variable
                    catch (Header aheader[])
                    {
                        aheader.printStackTrace();
                        return;
                    }
                    k = 0;
                    if (k >= aheader.length())
                    {
                        return;
                    }
                    obj1 = aheader.getJSONObject(k);
                    abyte0 = new DatabaseHandler(getApplicationContext());
                    s2 = ((JSONObject) (obj1)).getString("name");
                    s3 = ((JSONObject) (obj1)).getString("avatar");
                    s4 = ((JSONObject) (obj1)).getString("uname");
                    s5 = ((JSONObject) (obj1)).getString("umail");
                    s6 = ((JSONObject) (obj1)).getString("uborn");
                    s7 = ((JSONObject) (obj1)).getString("uprov");
                    s8 = ((JSONObject) (obj1)).getString("ucity");
                    s9 = ((JSONObject) (obj1)).getString("ukec");
                    s10 = ((JSONObject) (obj1)).getString("ugen");
                    s11 = ((JSONObject) (obj1)).getString("uphone1");
                    s12 = ((JSONObject) (obj1)).getString("uphone2");
                    s13 = ((JSONObject) (obj1)).getString("uope1");
                    s14 = ((JSONObject) (obj1)).getString("uope2");
                    s15 = ((JSONObject) (obj1)).getString("ujdate");
                    s16 = ((JSONObject) (obj1)).getString("modified_date");
                    s17 = ((JSONObject) (obj1)).getString("codephone1");
                    obj1 = ((JSONObject) (obj1)).getString("codephone2");
                    Log.e("user_photo", s3);
                    abyte0.update_by_site(s2, s3, s4, s5, s6, s7, s8, s10, s11, s12, s13, s14, s15, s16, s17, ((String) (obj1)), s9);
                    k++;
                    if (false)
                    {
                    } else
                    {
                        break MISSING_BLOCK_LABEL_23;
                    }
                }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
            });
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void FavBrandTask()
    {
        FavBrandTask favbrandtask = new FavBrandTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            favbrandtask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            favbrandtask.execute(new Void[0]);
            return;
        }
    }

    public void FavPonselTask()
    {
        FavPonselTask favponseltask = new FavPonselTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            favponseltask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            favponseltask.execute(new Void[0]);
            return;
        }
    }

    public void ForumPonselTask()
    {
        ForumPonselTask forumponseltask = new ForumPonselTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            forumponseltask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            forumponseltask.execute(new Void[0]);
            return;
        }
    }

    public void LangananBrandTask()
    {
        LangananBrandTask langananbrandtask = new LangananBrandTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            langananbrandtask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            langananbrandtask.execute(new Void[0]);
            return;
        }
    }

    public void LangananKatsusTask()
    {
        LangananKatsusTask langanankatsustask = new LangananKatsusTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            langanankatsustask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            langanankatsustask.execute(new Void[0]);
            return;
        }
    }

    public void LangananOpTask()
    {
        LangananOpTask langananoptask = new LangananOpTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            langananoptask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            langananoptask.execute(new Void[0]);
            return;
        }
    }

    public void LangananPonselTask()
    {
        LangananPonselTask langananponseltask = new LangananPonselTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            langananponseltask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            langananponseltask.execute(new Void[0]);
            return;
        }
    }

    public void applicationdidenterbackground()
    {
        if (!isWindowFocused)
        {
            isAppWentToBg = true;
            if (userFunctions.isUserLoggedIn(getApplicationContext()))
            {
                PushOnlineStat("0");
            }
        }
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

    public void onClick(View view)
    {
        if (view == menu_katalog)
        {
            mDrawerLayout.closeDrawers();
            (new Handler()).postDelayed(new Runnable() {

                final BaseDrawer this$0;

                public void run()
                {
                    i = new Intent(getApplicationContext(), com/inponsel/android/v2/MerekActivity);
                    startActivityForResult(i, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
            }, 250L);
        } else
        {
            if (view == menu_Berita)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewsActivity);
                        i.putExtra("tag_timeline", "terbaru");
                        i.putExtra("tag_code", "tagall");
                        i.putExtra("tag_page", "1");
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_Aplikasi)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeAppsActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_Games)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeGamesActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_PusatLayanan)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/SCUserActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_PencarianRinci)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/pencarianrinci/PencarianRinciPonsel);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_turun_harga)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/TurunHargaPonselActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_LoginRegister)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/LoginActivity);
                        i.putExtra("activity", "main");
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_Bookmark)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_Setting)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/PengaturanActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_FAQ)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/FAQActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_KebijakanPrivasi)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/KebijakanActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_Hubungi)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/HubungiActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_Persyaratan)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/PersyaratanActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_Tentang)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/TentangActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_profil)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/ProfileActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_GroupChat)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomGroupChatListActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_pesan)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final BaseDrawer this$0;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/v2/InboxMessageActivity);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
                }, 250L);
                return;
            }
            if (view == menu_beranda)
            {
                i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewMainActivity);
                i.addFlags(0x4000000);
                startActivityForResult(i, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
                finish();
                return;
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        mDrawerToggle.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001e);
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
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        t = Utility.session(t);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        int k = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int j = k;
        if (k == 0)
        {
            j = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(j);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText("Kebijakan Privasi");
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        t = Utility.session(t);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        menu_turun_harga = (RelativeLayout)findViewById(0x7f0b044f);
        txtMoreHpFavorit = (TextView)findViewById(0x7f0b0583);
        txtMoreHpFavorit.setVisibility(8);
        txtMoreBrandFavorit = (TextView)findViewById(0x7f0b0585);
        txtMoreBrandFavorit.setVisibility(8);
        txtMoreHPLangganan = (TextView)findViewById(0x7f0b056f);
        txtMoreHPLangganan.setVisibility(8);
        txtMoreBrandLangganan = (TextView)findViewById(0x7f0b0571);
        txtMoreBrandLangganan.setVisibility(8);
        txtMoreOperatorLangganan = (TextView)findViewById(0x7f0b0573);
        txtMoreOperatorLangganan.setVisibility(8);
        txtMoreKatKhususLangganan = (TextView)findViewById(0x7f0b0575);
        txtMoreKatKhususLangganan.setVisibility(8);
        txtMoreHPForum = (TextView)findViewById(0x7f0b058b);
        txtMoreHPForum.setVisibility(8);
        menu_ListFavorit = (LinearLayout)findViewById(0x7f0b057b);
        menu_ListFavorit.setVisibility(8);
        menu_FavBerita = (RelativeLayout)findViewById(0x7f0b057c);
        menu_FavArtikelForum = (RelativeLayout)findViewById(0x7f0b057f);
        progressbar_LanggananBerita = (ProgressBar)findViewById(0x7f0b056c);
        progressbar_Bookmark = (ProgressBar)findViewById(0x7f0b0579);
        progressbar_ForumFollow = (ProgressBar)findViewById(0x7f0b0588);
        progressbar_LanggananBerita.setVisibility(8);
        progressbar_Bookmark.setVisibility(8);
        progressbar_ForumFollow.setVisibility(8);
        mDrawerLayout = (DrawerLayout)findViewById(0x7f0b0079);
        menu_profil = (RelativeLayout)findViewById(0x7f0b029e);
        left_drawer = (LinearLayout)findViewById(0x7f0b007b);
        ll_menu_msg = (LinearLayout)findViewById(0x7f0b0420);
        if (Utility.isTablet(getApplicationContext()))
        {
            left_drawer.getLayoutParams().width = (int)(getResources().getDisplayMetrics().density * (float)Util.tabletSize + 0.5F);
        } else
        {
            left_drawer.getLayoutParams().width = (int)(getResources().getDisplayMetrics().density * 270F + 0.5F);
        }
        left_drawer.requestLayout();
        menu_katalog = (RelativeLayout)findViewById(0x7f0b0447);
        menu_Berita = (RelativeLayout)findViewById(0x7f0b00cf);
        menu_Aplikasi = (RelativeLayout)findViewById(0x7f0b0441);
        menu_Games = (RelativeLayout)findViewById(0x7f0b0444);
        menu_PusatLayanan = (RelativeLayout)findViewById(0x7f0b0449);
        menu_PencarianRinci = (RelativeLayout)findViewById(0x7f0b044c);
        menu_LoginRegister = (RelativeLayout)findViewById(0x7f0b0452);
        menu_Bookmark = (RelativeLayout)findViewById(0x7f0b0576);
        menu_LanggananBerita = (RelativeLayout)findViewById(0x7f0b0569);
        menu_ForumFollow = (RelativeLayout)findViewById(0x7f0b00f0);
        menu_Setting = (RelativeLayout)findViewById(0x7f0b0428);
        menu_FAQ = (RelativeLayout)findViewById(0x7f0b0455);
        menu_KebijakanPrivasi = (RelativeLayout)findViewById(0x7f0b0458);
        menu_Persyaratan = (RelativeLayout)findViewById(0x7f0b045b);
        menu_Tentang = (RelativeLayout)findViewById(0x7f0b0461);
        menu_Hubungi = (RelativeLayout)findViewById(0x7f0b045e);
        menu_beranda = (RelativeLayout)findViewById(0x7f0b042a);
        txtUnreadCount = (TextView)findViewById(0x7f0b0423);
        txtUnreadGroupChat = (TextView)findViewById(0x7f0b0427);
        txtUnreadCount.setVisibility(8);
        menu_pesan = (RelativeLayout)findViewById(0x7f0b0421);
        menu_GroupChat = (RelativeLayout)findViewById(0x7f0b0424);
        menu_beranda.setOnClickListener(this);
        menu_pesan.setOnClickListener(this);
        menu_GroupChat.setOnClickListener(this);
        menu_katalog.setOnClickListener(this);
        menu_Berita.setOnClickListener(this);
        menu_Aplikasi.setOnClickListener(this);
        menu_Games.setOnClickListener(this);
        menu_PusatLayanan.setOnClickListener(this);
        menu_PencarianRinci.setOnClickListener(this);
        menu_turun_harga.setOnClickListener(this);
        menu_LoginRegister.setOnClickListener(this);
        menu_Setting.setOnClickListener(this);
        menu_KebijakanPrivasi.setOnClickListener(this);
        menu_Hubungi.setOnClickListener(this);
        menu_Persyaratan.setOnClickListener(this);
        menu_Tentang.setOnClickListener(this);
        menu_FAQ.setOnClickListener(this);
        menu_profil.setOnClickListener(this);
        menu_Bookmark.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/favorit/FavoritPonselMerek);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        menu_LanggananBerita.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final _cls2 this$1;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/favorit/LanggananBeritaAll);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        menu_ForumFollow.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final _cls3 this$1;

                    public void run()
                    {
                        i = new Intent(getApplicationContext(), com/inponsel/android/favorit/IkutiForumPonsel);
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        mDrawerLayout.setDrawerListener(new DemoDrawerListener(null));
        mDrawerLayout.setDrawerShadow(0x7f0201a9, 0x800003);
        mActionBar = createActionBarHelper();
        mActionBar.init();
        mDrawerToggle = new SherlockActionBarDrawerToggle(this, mDrawerLayout, 0x7f0201f3, 0x7f0c0082, 0x7f0c0083);
        mDrawerToggle.syncState();
        menu_progressbar_item = (ProgressBar)findViewById(0x7f0b02a0);
        menu_username = (TextView)findViewById(0x7f0b02a2);
        menu_ponsel_pengguna = (TextView)findViewById(0x7f0b02a3);
        menu_ponsel_pengguna.setSelected(true);
        menu_sim_pengguna = (TextView)findViewById(0x7f0b02a4);
        menu_imgProfil = (ImageView)findViewById(0x7f0b02a1);
        img_RefLanggananBerita = (ImageView)findViewById(0x7f0b056d);
        img_RefBookmark = (ImageView)findViewById(0x7f0b057a);
        img_RefForumFollow = (ImageView)findViewById(0x7f0b0589);
        img_RefBookmark.setVisibility(8);
        img_RefLanggananBerita.setVisibility(8);
        img_RefForumFollow.setVisibility(8);
        img_RefBookmark.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected() && userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    Log.e("refresh", "img_RefBookmark");
                    img_RefBookmark.setVisibility(8);
                    Toast.makeText(getApplicationContext(), "Refresh...", 1).show();
                    progressbar_Bookmark.setVisibility(0);
                    dataPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_favorit_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).toString();
                    Log.e("dataPonsel", dataPonsel);
                    dataBrand = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_fav_brand").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&lmt=0").toString();
                    Log.e("dataBrand", dataBrand);
                    FavPonselTask();
                    FavBrandTask();
                    return;
                } else
                {
                    Log.e("offline", "offline");
                    progressbar_Bookmark.setVisibility(8);
                    return;
                }
            }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        img_RefLanggananBerita.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected() && userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    Log.e("refresh", "img_RefLanggananBerita");
                    img_RefLanggananBerita.setVisibility(8);
                    Toast.makeText(getApplicationContext(), "Refresh...", 1).show();
                    progressbar_LanggananBerita.setVisibility(0);
                    dataLangganPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("subscribe_news_list").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&t=").append(t).append("&lmt=0").toString();
                    Log.e("dataLangganPonsel", dataLangganPonsel);
                    dataLangganBrand = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("subscribe_news_merek").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&t=").append(t).append("&lmt=0").toString();
                    Log.e("dataLangganBrand", dataLangganBrand);
                    dataLangganOperator = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_rssfollow_op").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&t=").append(t).append("&lmt=0").toString();
                    Log.e("dataLangganOperator", dataLangganOperator);
                    dataLangganKatsus = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_rssfollow_katsus").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&t=").append(t).append("&lmt=0").toString();
                    Log.e("dataLangganKatsus", dataLangganKatsus);
                    LangananPonselTask();
                    LangananBrandTask();
                    LangananOpTask();
                    LangananKatsusTask();
                    return;
                } else
                {
                    Log.e("offline", "offline");
                    progressbar_LanggananBerita.setVisibility(8);
                    return;
                }
            }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        img_RefForumFollow.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected() && userFunctions.isUserLoggedIn(getApplicationContext()))
                {
                    Log.e("refresh", "img_RefForumFollow");
                    img_RefForumFollow.setVisibility(8);
                    Toast.makeText(getApplicationContext(), "Refresh...", 1).show();
                    progressbar_ForumFollow.setVisibility(0);
                    dataForumPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_ikutiforum_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&lmt=0").toString();
                    Log.e("dataForumPonsel", dataForumPonsel);
                    ForumPonselTask();
                    return;
                } else
                {
                    Log.e("offline", "offline");
                    progressbar_ForumFollow.setVisibility(8);
                    return;
                }
            }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        menu_imgProfil.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final BaseDrawer this$0;

            public boolean onLongClick(View view)
            {
                view = new ArrayList();
                view.add(user_photo.trim());
                view = (String[])view.toArray(new String[view.size()]);
                Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view);
                intent.putExtra("pos", 0);
                startActivity(intent);
                return false;
            }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        if (userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            username = cursor.getString(4);
            Log.e("username", username);
            update_profile();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
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
            imageLoader2.displayImage((new StringBuilder("http://tools.inponsel.com/thumb/thumb.php?w=300&src=")).append(user_photo.trim()).toString(), menu_imgProfil, options, animateFirstListener);
            menu_profil.setVisibility(0);
            menu_LoginRegister.setVisibility(8);
            menu_Bookmark.setVisibility(0);
            menu_LanggananBerita.setVisibility(0);
            menu_ForumFollow.setVisibility(0);
            menu_FavBerita.setVisibility(0);
            menu_FavArtikelForum.setVisibility(0);
            ll_menu_msg.setVisibility(0);
            if (db.getGroupChatCount() > 0)
            {
                Log.e("unread", "getTotalUnread");
                bundle = db.getTotalUnreadGroupChat();
                bundle.moveToFirst();
                bundle = bundle.getString(bundle.getColumnIndex("total"));
                Log.e("getGroupChatCount()", bundle);
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
            if (db.getInBoxCount() > 0)
            {
                bundle = db.getTotalUnread();
                bundle.moveToFirst();
                bundle = bundle.getString(bundle.getColumnIndex("total"));
                if (bundle.equals("0") || bundle.equals(""))
                {
                    txtUnreadCount.setVisibility(8);
                } else
                {
                    txtUnreadCount.setText(bundle);
                    txtUnreadCount.setVisibility(0);
                }
            } else
            {
                bundle = db.getTotalUnreadSQLSEQ();
                bundle.moveToFirst();
                bundle = bundle.getString(bundle.getColumnIndex("total"));
                if (bundle.equals("0") || bundle.equals(""))
                {
                    txtUnreadCount.setVisibility(8);
                } else
                {
                    txtUnreadCount.setText(bundle);
                    txtUnreadCount.setVisibility(0);
                }
            }
            menu_pesan.setVisibility(0);
            menu_GroupChat.setVisibility(0);
        } else
        {
            ll_menu_msg.setVisibility(8);
            menu_LanggananBerita.setVisibility(8);
            menu_ForumFollow.setVisibility(8);
            menu_FavBerita.setVisibility(8);
            menu_FavArtikelForum.setVisibility(8);
            menu_GroupChat.setVisibility(8);
            menu_pesan.setVisibility(8);
            menu_LoginRegister.setVisibility(0);
            menu_Bookmark.setVisibility(8);
            menu_Setting.setVisibility(8);
            menu_profil.setVisibility(8);
            menu_ListFavorit.setVisibility(8);
        }
        sv_drawer_menu = (ScrollView)findViewById(0x7f0b041f);
        listHpFavorit = (GridView)findViewById(0x7f0b0582);
        favHpArray = new ArrayList();
        favHpAdapter = new ListHPFavAdapter(this, 0x7f0300c9, favHpArray);
        listHpFavorit.setAdapter(favHpAdapter);
        listBrandFavorit = (GridView)findViewById(0x7f0b0584);
        favBrandArray = new ArrayList();
        favBrandAdapter = new ListHPFavAdapter(this, 0x7f0300c9, favBrandArray);
        listBrandFavorit.setAdapter(favBrandAdapter);
        listHPLangganan = (GridView)findViewById(0x7f0b056e);
        langganHpArray = new ArrayList();
        langganHpAdapter = new ListHPFavAdapter(this, 0x7f0300c9, langganHpArray);
        listHPLangganan.setAdapter(langganHpAdapter);
        listBrandLangganan = (GridView)findViewById(0x7f0b0570);
        langganBrandArray = new ArrayList();
        langganBrandAdapter = new ListHPFavAdapter(this, 0x7f0300c9, langganBrandArray);
        listBrandLangganan.setAdapter(langganBrandAdapter);
        listOperatorLangganan = (GridView)findViewById(0x7f0b0572);
        langganOpArray = new ArrayList();
        langganOpAdapter = new ListHPFavAdapter(this, 0x7f0300c9, langganOpArray);
        listOperatorLangganan.setAdapter(langganOpAdapter);
        listKatKhususLangganan = (GridView)findViewById(0x7f0b0574);
        langganKatKhususArray = new ArrayList();
        langganKatKhususAdapter = new ListHPFavAdapter(this, 0x7f0300c9, langganKatKhususArray);
        listKatKhususLangganan.setAdapter(langganKatKhususAdapter);
        listHPForum = (GridView)findViewById(0x7f0b058a);
        ForumHpArray = new ArrayList();
        ForumHpAdapter = new ListHPFavAdapter(this, 0x7f0300c9, ForumHpArray);
        listHPForum.setAdapter(ForumHpAdapter);
        menu_FavBerita.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final _cls8 this$1;

                    public void run()
                    {
                        Intent intent = new Intent(_fld0, com/inponsel/android/favorit/FavoritArtikelBerita);
                        startActivityForResult(intent, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls8.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        menu_FavArtikelForum.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final _cls9 this$1;

                    public void run()
                    {
                        Intent intent = new Intent(_fld0, com/inponsel/android/favorit/FavoritArtikelForum);
                        startActivityForResult(intent, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls9.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        txtMoreHpFavorit.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final _cls10 this$1;

                    public void run()
                    {
                    }

            
            {
                this$1 = _cls10.this;
                super();
            }
                }, 250L);
            }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        txtMoreBrandFavorit.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final _cls11 this$1;

                    public void run()
                    {
                        Intent intent = new Intent(_fld0, com/inponsel/android/favorit/FavoritPonselMerek);
                        startActivityForResult(intent, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls11.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        txtMoreHPLangganan.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final _cls12 this$1;

                    public void run()
                    {
                    }

            
            {
                this$1 = _cls12.this;
                super();
            }
                }, 250L);
            }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        txtMoreBrandLangganan.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final _cls13 this$1;

                    public void run()
                    {
                    }

            
            {
                this$1 = _cls13.this;
                super();
            }
                }, 250L);
            }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        txtMoreOperatorLangganan.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final _cls14 this$1;

                    public void run()
                    {
                    }

            
            {
                this$1 = _cls14.this;
                super();
            }
                }, 250L);
            }

            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        txtMoreKatKhususLangganan.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final _cls15 this$1;

                    public void run()
                    {
                        Intent intent = new Intent(_fld0, com/inponsel/android/favorit/LanggananBeritaAll);
                        startActivityForResult(intent, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls15.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        txtMoreHPForum.setOnClickListener(new android.view.View.OnClickListener() {

            final BaseDrawer this$0;

            public void onClick(View view)
            {
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(new Runnable() {

                    final _cls16 this$1;

                    public void run()
                    {
                        Intent intent = new Intent(_fld0, com/inponsel/android/favorit/IkutiForumPonsel);
                        startActivityForResult(intent, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = _cls16.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        listHpFavorit.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final BaseDrawer this$0;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                adapterview = new Intent(BaseDrawer.this, com/inponsel/android/details/DetailsPonsel);
                adapterview.putExtra("id_hph", favHpAdapter.getListModel(l).getId_hp());
                adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(favHpAdapter.getListModel(l).getMerk()))).append(" ").append(favHpAdapter.getListModel(l).getModel()).toString());
                adapterview.putExtra("codename", "");
                adapterview.putExtra("model", favHpAdapter.getListModel(l).getModel());
                adapterview.putExtra("merk", favHpAdapter.getListModel(l).getMerk());
                adapterview.putExtra("gambar", favHpAdapter.getListModel(l).getGambar());
                adapterview.putExtra("hrg_baru", "");
                adapterview.putExtra("hrg_bekas", "");
                adapterview.putExtra("tot_like", "");
                adapterview.putExtra("tot_dislike", "");
                adapterview.putExtra("tot_komen", "");
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(adapterview. new Runnable() {

                    final _cls17 this$1;
                    private final Intent val$i;

                    public void run()
                    {
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final__pcls17;
                i = Intent.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        listBrandFavorit.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final BaseDrawer this$0;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                adapterview = new Intent(BaseDrawer.this, com/inponsel/android/details/ProfilPTActivity);
                adapterview.putExtra("id_merk", favBrandAdapter.getListModel(l).getId_hp());
                adapterview.putExtra("titlemerek", favBrandAdapter.getListModel(l).getMerk());
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(adapterview. new Runnable() {

                    final _cls18 this$1;
                    private final Intent val$i;

                    public void run()
                    {
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final__pcls18;
                i = Intent.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        listHPLangganan.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final BaseDrawer this$0;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                adapterview = new Intent(BaseDrawer.this, com/inponsel/android/v2/RSSFeedByTag);
                adapterview.putExtra("tag_code", "5");
                adapterview.putExtra("tag_key", langganHpAdapter.getListModel(l).getId_hp());
                adapterview.putExtra("kategori_tag", (new StringBuilder(String.valueOf(langganHpAdapter.getListModel(l).getMerk()))).append(" ").append(langganHpAdapter.getListModel(l).getModel()).toString());
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(adapterview. new Runnable() {

                    final _cls19 this$1;
                    private final Intent val$i;

                    public void run()
                    {
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final__pcls19;
                i = Intent.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        listBrandLangganan.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final BaseDrawer this$0;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/RSSFeedByTag);
                adapterview.putExtra("tag_code", "2");
                adapterview.putExtra("tag_key", langganBrandAdapter.getListModel(l).getId_hp().toString());
                adapterview.putExtra("kategori_tag", langganBrandAdapter.getListModel(l).getMerk().toString());
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(adapterview. new Runnable() {

                    final _cls20 this$1;
                    private final Intent val$i;

                    public void run()
                    {
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final__pcls20;
                i = Intent.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        listOperatorLangganan.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final BaseDrawer this$0;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                adapterview = new Intent(BaseDrawer.this, com/inponsel/android/v2/RSSFeedByTag);
                adapterview.putExtra("tag_code", "4");
                adapterview.putExtra("tag_key", langganOpAdapter.getListModel(l).getId_hp());
                adapterview.putExtra("kategori_tag", langganOpAdapter.getListModel(l).getMerk());
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(adapterview. new Runnable() {

                    final _cls21 this$1;
                    private final Intent val$i;

                    public void run()
                    {
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final__pcls21;
                i = Intent.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        listKatKhususLangganan.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final BaseDrawer this$0;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                adapterview = new Intent(BaseDrawer.this, com/inponsel/android/v2/RSSFeedByTag);
                adapterview.putExtra("tag_code", "0");
                adapterview.putExtra("tag_key", langganKatKhususAdapter.getListModel(l).getId_hp());
                adapterview.putExtra("kategori_tag", langganKatKhususAdapter.getListModel(l).getMerk());
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(adapterview. new Runnable() {

                    final _cls22 this$1;
                    private final Intent val$i;

                    public void run()
                    {
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final__pcls22;
                i = Intent.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        listHPForum.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final BaseDrawer this$0;

            public void onItemClick(AdapterView adapterview, View view, int l, long l1)
            {
                adapterview = new Intent(BaseDrawer.this, com/inponsel/android/tlforum/ForumHPActivity);
                adapterview.putExtra("id_hph", ForumHpAdapter.getListModel(l).getId_hp());
                adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(ForumHpAdapter.getListModel(l).getMerk()))).append(" ").append(ForumHpAdapter.getListModel(l).getModel()).toString());
                adapterview.putExtra("codename", ForumHpAdapter.getListModel(l).getCodename());
                adapterview.putExtra("model", ForumHpAdapter.getListModel(l).getModel());
                adapterview.putExtra("merk", ForumHpAdapter.getListModel(l).getMerk());
                adapterview.putExtra("gambar", ForumHpAdapter.getListModel(l).getGambar());
                mDrawerLayout.closeDrawers();
                (new Handler()).postDelayed(adapterview. new Runnable() {

                    final _cls23 this$1;
                    private final Intent val$i;

                    public void run()
                    {
                        startActivityForResult(i, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final__pcls23;
                i = Intent.this;
                super();
            }
                }, 250L);
            }


            
            {
                this$0 = BaseDrawer.this;
                super();
            }
        });
        cm = (ConnectivityManager)getSystemService("connectivity");
        userFunctions.isUserLoggedIn(this);
    }

    public boolean onKeyDown(int j, KeyEvent keyevent)
    {
        switch (j)
        {
        default:
            return super.onKeyDown(j, keyevent);

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
            break;
        }
        return true;
    }

    protected void onStart()
    {
        Log.d(TAG, (new StringBuilder("onStart isAppWentToBg ")).append(isAppWentToBg).toString());
        applicationWillEnterForeground();
        super.onStart();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }

    protected void onStop()
    {
        super.onStop();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
        Log.d(TAG, "onStop ");
        applicationdidenterbackground();
    }

    public void update(Observable observable, Object obj)
    {
        if (ponselBaseApp.getObserver().getLoginStat().equals("1"))
        {
            runOnUiThread(new Runnable() {

                final BaseDrawer this$0;

                public void run()
                {
                    Log.e("update", "BaseDrawer");
                    if (userFunctions.isUserLoggedIn(getApplicationContext()))
                    {
                        cursor = db.getAllData();
                        cursor.moveToFirst();
                        Object obj1;
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
                        update_profile();
                        if (db.getGroupChatCount() > 0)
                        {
                            Log.e("unread", "getTotalUnread");
                            obj1 = db.getTotalUnreadGroupChat();
                            ((Cursor) (obj1)).moveToFirst();
                            obj1 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndex("total"));
                            Log.e("getGroupChatCount()", ((String) (obj1)));
                            if (((String) (obj1)).equals("0") || ((String) (obj1)).equals(""))
                            {
                                txtUnreadGroupChat.setVisibility(8);
                                txtUnreadGroupChat.setText("0");
                            } else
                            {
                                txtUnreadGroupChat.setText(((CharSequence) (obj1)));
                                txtUnreadGroupChat.setVisibility(0);
                            }
                        } else
                        {
                            obj1 = getApplicationContext().getSharedPreferences("UnreadGroup", 0).getString("unread_group", null);
                            if (((String) (obj1)).equals("0") || ((String) (obj1)).equals(""))
                            {
                                txtUnreadGroupChat.setVisibility(8);
                                txtUnreadGroupChat.setText("0");
                            } else
                            {
                                txtUnreadGroupChat.setText(((CharSequence) (obj1)));
                                txtUnreadGroupChat.setVisibility(0);
                            }
                        }
                        if (db.getInBoxCount() > 0)
                        {
                            obj1 = db.getTotalUnread();
                            ((Cursor) (obj1)).moveToFirst();
                            obj1 = ((Cursor) (obj1)).getString(((Cursor) (obj1)).getColumnIndex("total"));
                            if (((String) (obj1)).equals("0") || ((String) (obj1)).equals(""))
                            {
                                txtUnreadCount.setVisibility(8);
                            } else
                            {
                                txtUnreadCount.setText(((CharSequence) (obj1)));
                                txtUnreadCount.setVisibility(0);
                            }
                        } else
                        {
                            Object obj2 = db.getTotalUnreadSQLSEQ();
                            ((Cursor) (obj2)).moveToFirst();
                            obj2 = ((Cursor) (obj2)).getString(((Cursor) (obj2)).getColumnIndex("total"));
                            if (((String) (obj2)).equals("0") || ((String) (obj2)).equals(""))
                            {
                                txtUnreadCount.setVisibility(8);
                            } else
                            {
                                txtUnreadCount.setText(((CharSequence) (obj2)));
                                txtUnreadCount.setVisibility(0);
                            }
                        }
                        Log.e("user_photo", user_photo);
                        imageLoader2.displayImage((new StringBuilder("http://tools.inponsel.com/thumb/thumb.php?w=300&src=")).append(user_photo.trim()).toString(), menu_imgProfil, options, animateFirstListener);
                        menu_profil.setVisibility(0);
                        menu_LoginRegister.setVisibility(8);
                        menu_Bookmark.setVisibility(0);
                        menu_pesan.setVisibility(0);
                        menu_GroupChat.setVisibility(0);
                        if (!ponselBaseApp.getObserver().getUpdateType().equals("inboxchatroom"))
                        {
                            userContentFavorit();
                        }
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
                this$0 = BaseDrawer.this;
                super();
            }
            });
        }
    }

    protected void userContentFavorit()
    {
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected() && userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            menu_Bookmark.setVisibility(0);
            menu_LanggananBerita.setVisibility(0);
            menu_ForumFollow.setVisibility(0);
            dataPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_favorit_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).toString();
            Log.e("dataPonsel", dataPonsel);
            dataBrand = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_fav_brand").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&lmt=0").toString();
            Log.e("dataBrand", dataBrand);
            dataLangganPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("subscribe_news_list").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&t=").append(t).append("&lmt=0").toString();
            Log.e("dataLangganPonsel", dataLangganPonsel);
            dataLangganBrand = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("subscribe_news_merek").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&t=").append(t).append("&lmt=0").toString();
            Log.e("dataLangganBrand", dataLangganBrand);
            dataLangganOperator = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_rssfollow_op").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&t=").append(t).append("&lmt=0").toString();
            Log.e("dataLangganOperator", dataLangganOperator);
            dataLangganKatsus = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_rssfollow_katsus").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&t=").append(t).append("&lmt=0").toString();
            Log.e("dataLangganKatsus", dataLangganKatsus);
            dataForumPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_ikutiforum_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&lmt=0").toString();
            Log.e("dataForumPonsel", dataForumPonsel);
            return;
        } else
        {
            Log.e("offline", "offline");
            progressbar_Bookmark.setVisibility(8);
            progressbar_ForumFollow.setVisibility(8);
            progressbar_LanggananBerita.setVisibility(8);
            favoriteOpenJson();
            favoriteMerekOpenJson();
            return;
        }
    }



}
