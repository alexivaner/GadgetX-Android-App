// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ItemKomenHp;
import com.inponsel.android.adapter.ItemKomenNews;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URLDecoder;
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
//            ImagePagerActivity, ProfileOtherUser, KomentarBaruLainPonsel, KomentarBaruLainNews

public class KomentarHpNews extends SherlockFragmentActivity
    implements Observer
{
    public class KomentarAsycTask extends AsyncTask
    {

        final KomentarHpNews this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("KomentarAsycTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomen));
            as = jsonobject.getJSONArray("InPonsel");
            strKonekStat = jsonobject.getString("success");
            bottom_id = jsonobject.getString("lastid_kom");
            top_id = jsonobject.getString("firstid_kom");
            jum_komen = jsonobject.getString("jum_komen");
            Log.e("responsejum_komen", jum_komen);
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_313;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_313;
            }
            Object obj = KomentarHpNews.this;
            obj.countAllKom = ((KomentarHpNews) (obj)).countAllKom + 1;
            obj = KomentarHpNews.this;
            obj.countKomOld = ((KomentarHpNews) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemKomenHp(((JSONObject) (obj)).getString("id_komentar"), ((JSONObject) (obj)).getString("id_hp"), ((JSONObject) (obj)).getString("codename"), ((JSONObject) (obj)).getString("nama_komentar"), ((JSONObject) (obj)).getString("email_komentar"), ((JSONObject) (obj)).getString("tanggal_komentar"), ((JSONObject) (obj)).getString("komentarhp"), ((JSONObject) (obj)).getString("komen_bagus"), ((JSONObject) (obj)).getString("komen_kurang"), ((JSONObject) (obj)).getString("usr_pict_komen"), ((JSONObject) (obj)).getString("reply_to"), ((JSONObject) (obj)).getString("nama_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("namalengkap"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
            int i;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_1212;
            }
            i = 0;
_L3:
            if (i < mArrayListData.size()) goto _L2; else goto _L1
_L1:
            scrollviewKomen.setVisibility(0);
_L4:
            pop_progressbar_middle.setVisibility(8);
            lay_Komen_lainnya.setVisibility(0);
            return;
_L2:
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300fb, null);
            txtNamaHp = (TextView)void1.findViewById(0x7f0b0765);
            txtUsername = (TextView)void1.findViewById(0x7f0b0419);
            lay_quote = (LinearLayout)void1.findViewById(0x7f0b063a);
            img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
            txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
            txtKomentar = (TextViewFixTouchConsume)void1.findViewById(0x7f0b054e);
            txtUsernameQoute = (TextView)void1.findViewById(0x7f0b063b);
            txtKomentarQoute = (TextViewFixTouchConsume)void1.findViewById(0x7f0b063d);
            txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
            txtWaktuQoute = (TextView)void1.findViewById(0x7f0b063c);
            txtTanggapan = (TextView)void1.findViewById(0x7f0b0555);
            final String id_hp = (ImageView)void1.findViewById(0x7f0b054f);
            id_hp = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            ((ItemKomenHp)mArrayListData.get(i)).getId_komentar();
            id_hp = ((ItemKomenHp)mArrayListData.get(i)).getId_hp();
            String s = ((ItemKomenHp)mArrayListData.get(i)).getCodename();
            String s1 = ((ItemKomenHp)mArrayListData.get(i)).getNama_komentar();
            ((ItemKomenHp)mArrayListData.get(i)).getEmail_komentar();
            ((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar();
            ((ItemKomenHp)mArrayListData.get(i)).getKomentarhp();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang();
            String s2 = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen();
            ((ItemKomenHp)mArrayListData.get(i)).getReply_to();
            ((ItemKomenHp)mArrayListData.get(i)).getNama_to();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_to();
            ((ItemKomenHp)mArrayListData.get(i)).getTanggal_to();
            final String my_like_kom = ((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom();
            if (((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".png") || ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
            {
                imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
            } else
            {
                img_kom_picture.setImageResource(0x7f020297);
            }
            txtIdKom.setText(((ItemKomenHp)mArrayListData.get(i)).getId_komentar().toString());
            txtdisLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang().toString());
            txtLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus().toString());
            txtNamaHp.setText(((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString());
            txtUsername.setText(((ItemKomenHp)mArrayListData.get(i)).getNama_komentar());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomentarhp().toString())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)mArrayListData.get(i)).getNama_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_to()));
            listKomenHP.addView(void1);
            img_kom_picture.setOnLongClickListener(s2. new android.view.View.OnLongClickListener() {

                final KomentarAsycTask this$1;
                private final String val$usr_pict_komen;

                public boolean onLongClick(View view)
                {
                    view = new ArrayList();
                    view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(usr_pict_komen.toString().trim()).toString());
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                    return false;
                }

            
            {
                this$1 = final_komentarasyctask;
                usr_pict_komen = String.this;
                super();
            }
            });
            img_kom_picture.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$nama_komentar;

                public void onClick(View view)
                {
                    view = new Intent(_fld0, com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", nama_komentar);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarasyctask;
                nama_komentar = String.this;
                super();
            }
            });
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarAsycTask this$1;
                private final String val$codename;
                private final String val$id_hp;
                private final String val$my_like_kom;

                public void onClick(View view)
                {
                    view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                    view.putExtra("id_hph", id_hp);
                    view.putExtra("namalengkap", my_like_kom);
                    view.putExtra("codename", codename);
                    view.putExtra("model", "");
                    view.putExtra("merk", "");
                    view.putExtra("gambar", "");
                    view.putExtra("hrg_baru", "");
                    view.putExtra("hrg_bekas", "");
                    view.putExtra("tot_like", "");
                    view.putExtra("tot_dislike", "");
                    view.putExtra("tot_komen", "");
                    view.putExtra("actfrom", "komen");
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarasyctask;
                id_hp = s;
                my_like_kom = s1;
                codename = String.this;
                super();
            }
            });
            i++;
              goto _L3
            pop_progressbar_middle.setVisibility(8);
              goto _L4
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            limit = 0;
            Log.e("KomentarAsycTask", "onPreExecute");
            listKomenHP.removeAllViewsInLayout();
            mArrayListData.clear();
            pop_progressbar_middle.setVisibility(0);
            txtMorekomenhp.setVisibility(8);
            lay_Komen_lainnya.setVisibility(8);
            mArrayListData.clear();
        }


        public KomentarAsycTask()
        {
            this$0 = KomentarHpNews.this;
            super();
        }
    }

    public class KomentarNewsAsycTask extends AsyncTask
    {

        final KomentarHpNews this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("KomentarAsycTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomenNews));
            as = jsonobject.getJSONArray("InPonsel");
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_237;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_237;
            }
            Object obj = KomentarHpNews.this;
            obj.countAllKom = ((KomentarHpNews) (obj)).countAllKom + 1;
            obj = KomentarHpNews.this;
            obj.countKomOld = ((KomentarHpNews) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListKomNewsData.add(new ItemKomenNews(((JSONObject) (obj)).getString("id_komrss"), ((JSONObject) (obj)).getString("id_rss"), ((JSONObject) (obj)).getString("news_title"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("user_name"), "", ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("komen_rss"), "", "", ((JSONObject) (obj)).getString("user_photo"), "", "", "", "", ""));
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
            int i;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_1116;
            }
            i = 0;
_L3:
            if (i < mArrayListKomNewsData.size()) goto _L2; else goto _L1
_L1:
            scrollviewKomen.setVisibility(0);
_L4:
            pop_progressbar_news.setVisibility(8);
            lay_KomenNews_lainnya.setVisibility(0);
            imgKomenNewsRefresh.setVisibility(0);
            progressbar_KomenNewsbutton.setVisibility(8);
            return;
_L2:
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300fb, null);
            txtNamaHp = (TextView)void1.findViewById(0x7f0b0765);
            txtUsername = (TextView)void1.findViewById(0x7f0b0419);
            lay_quote = (LinearLayout)void1.findViewById(0x7f0b063a);
            img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
            txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
            txtKomentar = (TextViewFixTouchConsume)void1.findViewById(0x7f0b054e);
            txtUsernameQoute = (TextView)void1.findViewById(0x7f0b063b);
            txtKomentarQoute = (TextViewFixTouchConsume)void1.findViewById(0x7f0b063d);
            txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
            txtWaktuQoute = (TextView)void1.findViewById(0x7f0b063c);
            txtTanggapan = (TextView)void1.findViewById(0x7f0b0555);
            final String id_rss = (ImageView)void1.findViewById(0x7f0b054f);
            id_rss = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getId_komentar();
            id_rss = ((ItemKomenNews)mArrayListKomNewsData.get(i)).getId_rss();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getId_user();
            String s = ((ItemKomenNews)mArrayListKomNewsData.get(i)).getNama_komentar();
            String s1 = ((ItemKomenNews)mArrayListKomNewsData.get(i)).getEmail_komentar();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getTanggal_komentar();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomentar();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomen_bagus();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomen_kurang();
            String s2 = ((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getReply_to();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getNama_to();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomen_to();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getTanggal_to();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getMy_like_kom();
            if (((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen().toString().trim().contains(".png") || ((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
            {
                imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
            } else
            {
                img_kom_picture.setImageResource(0x7f020297);
            }
            txtIdKom.setText(((ItemKomenNews)mArrayListKomNewsData.get(i)).getId_komentar().toString());
            txtdisLikeKom.setText(((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomen_kurang().toString());
            txtLikeKom.setText(((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomen_bagus().toString());
            txtNamaHp.setText(((ItemKomenNews)mArrayListKomNewsData.get(i)).getNews_title().toString());
            txtUsername.setText(((ItemKomenNews)mArrayListKomNewsData.get(i)).getNama_komentar());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomentar().toString())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemKomenNews)mArrayListKomNewsData.get(i)).getTanggal_komentar()));
            linear_listviewnews.addView(void1);
            img_kom_picture.setOnLongClickListener(s2. new android.view.View.OnLongClickListener() {

                final KomentarNewsAsycTask this$1;
                private final String val$usr_pict_komen;

                public boolean onLongClick(View view)
                {
                    view = new ArrayList();
                    view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(usr_pict_komen.toString().trim()).toString());
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                    return false;
                }

            
            {
                this$1 = final_komentarnewsasyctask;
                usr_pict_komen = String.this;
                super();
            }
            });
            img_kom_picture.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarNewsAsycTask this$1;
                private final String val$nama_komentar;

                public void onClick(View view)
                {
                    view = new Intent(_fld0, com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", nama_komentar);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarnewsasyctask;
                nama_komentar = String.this;
                super();
            }
            });
            void1.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarNewsAsycTask this$1;
                private final String val$id_rss;
                private final String val$rss_title;

                public void onClick(View view)
                {
                    view = new Intent(_fld0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                    view.putExtra("actfrom", "rssfeed");
                    view.putExtra("kategori_tag", "");
                    view.putExtra("act", "komen");
                    view.putExtra("rss_id", "");
                    view.putExtra("id_rss", id_rss);
                    view.putExtra("rss_title", rss_title);
                    view.putExtra("rss_portal", "");
                    view.putExtra("rss_desc", "");
                    view.putExtra("rss_srclink", "");
                    view.putExtra("rss_date", "");
                    view.putExtra("rss_img_ava", "");
                    view.putExtra("rss_img", "");
                    view.putExtra("total_like", "");
                    view.putExtra("like_stat", "");
                    view.putExtra("total_komen", "");
                    view.putExtra("fav_stat", "");
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarnewsasyctask;
                id_rss = s;
                rss_title = String.this;
                super();
            }
            });
            i++;
              goto _L3
            pop_progressbar_news.setVisibility(8);
              goto _L4
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            limit = 0;
            Log.e("KomentarAsycTask", "onPreExecute");
            pop_progressbar_news.setVisibility(0);
            txtMorekomennews.setVisibility(8);
            lay_KomenNews_lainnya.setVisibility(8);
            mArrayListKomNewsData.clear();
            imgKomenNewsRefresh.setVisibility(8);
            progressbar_KomenNewsbutton.setVisibility(0);
        }


        public KomentarNewsAsycTask()
        {
            this$0 = KomentarHpNews.this;
            super();
        }
    }

    public class KomentarNewsRefreshAsycTask extends AsyncTask
    {

        final KomentarHpNews this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("KomentarNewsRefreshAsycTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomenNews));
            as = jsonobject.getJSONArray("InPonsel");
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_237;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_237;
            }
            Object obj = KomentarHpNews.this;
            obj.countAllKom = ((KomentarHpNews) (obj)).countAllKom + 1;
            obj = KomentarHpNews.this;
            obj.countKomOld = ((KomentarHpNews) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListKomNewsData.add(new ItemKomenNews(((JSONObject) (obj)).getString("id_komrss"), ((JSONObject) (obj)).getString("id_rss"), ((JSONObject) (obj)).getString("news_title"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("user_name"), "", ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("komen_rss"), "", "", ((JSONObject) (obj)).getString("user_photo"), "", "", "", "", ""));
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
            int i;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_1127;
            }
            linear_listviewnews.removeAllViewsInLayout();
            i = 0;
_L3:
            if (i < mArrayListKomNewsData.size()) goto _L2; else goto _L1
_L1:
            scrollviewKomen.setVisibility(0);
_L4:
            pop_progressbar_news.setVisibility(8);
            lay_KomenNews_lainnya.setVisibility(0);
            imgKomenNewsRefresh.setVisibility(0);
            progressbar_KomenNewsbutton.setVisibility(8);
            return;
_L2:
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300fb, null);
            txtNamaHp = (TextView)void1.findViewById(0x7f0b0765);
            txtUsername = (TextView)void1.findViewById(0x7f0b0419);
            lay_quote = (LinearLayout)void1.findViewById(0x7f0b063a);
            img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
            txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
            txtKomentar = (TextViewFixTouchConsume)void1.findViewById(0x7f0b054e);
            txtUsernameQoute = (TextView)void1.findViewById(0x7f0b063b);
            txtKomentarQoute = (TextViewFixTouchConsume)void1.findViewById(0x7f0b063d);
            txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
            txtWaktuQoute = (TextView)void1.findViewById(0x7f0b063c);
            txtTanggapan = (TextView)void1.findViewById(0x7f0b0555);
            final String id_rss = (ImageView)void1.findViewById(0x7f0b054f);
            id_rss = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getId_komentar();
            id_rss = ((ItemKomenNews)mArrayListKomNewsData.get(i)).getId_rss();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getId_user();
            String s = ((ItemKomenNews)mArrayListKomNewsData.get(i)).getNama_komentar();
            String s1 = ((ItemKomenNews)mArrayListKomNewsData.get(i)).getEmail_komentar();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getTanggal_komentar();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomentar();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomen_bagus();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomen_kurang();
            String s2 = ((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getReply_to();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getNama_to();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomen_to();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getTanggal_to();
            ((ItemKomenNews)mArrayListKomNewsData.get(i)).getMy_like_kom();
            if (((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen().toString().trim().contains(".png") || ((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
            {
                imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
            } else
            {
                img_kom_picture.setImageResource(0x7f020297);
            }
            txtIdKom.setText(((ItemKomenNews)mArrayListKomNewsData.get(i)).getId_komentar().toString());
            txtdisLikeKom.setText(((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomen_kurang().toString());
            txtLikeKom.setText(((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomen_bagus().toString());
            txtNamaHp.setText(((ItemKomenNews)mArrayListKomNewsData.get(i)).getNews_title().toString());
            txtUsername.setText(((ItemKomenNews)mArrayListKomNewsData.get(i)).getNama_komentar());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomentar().toString())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemKomenNews)mArrayListKomNewsData.get(i)).getTanggal_komentar()));
            linear_listviewnews.addView(void1);
            img_kom_picture.setOnLongClickListener(s2. new android.view.View.OnLongClickListener() {

                final KomentarNewsRefreshAsycTask this$1;
                private final String val$usr_pict_komen;

                public boolean onLongClick(View view)
                {
                    view = new ArrayList();
                    view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(usr_pict_komen.toString().trim()).toString());
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                    return false;
                }

            
            {
                this$1 = final_komentarnewsrefreshasyctask;
                usr_pict_komen = String.this;
                super();
            }
            });
            img_kom_picture.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarNewsRefreshAsycTask this$1;
                private final String val$nama_komentar;

                public void onClick(View view)
                {
                    view = new Intent(_fld0, com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", nama_komentar);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarnewsrefreshasyctask;
                nama_komentar = String.this;
                super();
            }
            });
            void1.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarNewsRefreshAsycTask this$1;
                private final String val$id_rss;
                private final String val$rss_title;

                public void onClick(View view)
                {
                    view = new Intent(_fld0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                    view.putExtra("actfrom", "rssfeed");
                    view.putExtra("kategori_tag", "");
                    view.putExtra("act", "komen");
                    view.putExtra("rss_id", "");
                    view.putExtra("id_rss", id_rss);
                    view.putExtra("rss_title", rss_title);
                    view.putExtra("rss_portal", "");
                    view.putExtra("rss_desc", "");
                    view.putExtra("rss_srclink", "");
                    view.putExtra("rss_date", "");
                    view.putExtra("rss_img_ava", "");
                    view.putExtra("rss_img", "");
                    view.putExtra("total_like", "");
                    view.putExtra("like_stat", "");
                    view.putExtra("total_komen", "");
                    view.putExtra("fav_stat", "");
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarnewsrefreshasyctask;
                id_rss = s;
                rss_title = String.this;
                super();
            }
            });
            i++;
              goto _L3
            pop_progressbar_news.setVisibility(8);
              goto _L4
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            limit = 0;
            Log.e("KomentarNewsRefreshAsycTask", "onPreExecute");
            pop_progressbar_news.setVisibility(0);
            txtMorekomennews.setVisibility(8);
            mArrayListKomNewsData.clear();
            imgKomenNewsRefresh.setVisibility(8);
            progressbar_KomenNewsbutton.setVisibility(0);
        }


        public KomentarNewsRefreshAsycTask()
        {
            this$0 = KomentarHpNews.this;
            super();
        }
    }

    public class KomentarRefreshAsycTask extends AsyncTask
    {

        final KomentarHpNews this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("KomentarRefreshAsycTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlKomen));
            as = jsonobject.getJSONArray("InPonsel");
            strKonekStat = jsonobject.getString("success");
            bottom_id = jsonobject.getString("lastid_kom");
            top_id = jsonobject.getString("firstid_kom");
            jum_komen = jsonobject.getString("jum_komen");
            Log.e("responsejum_komen", jum_komen);
            countKomOld = 0;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_313;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_313;
            }
            Object obj = KomentarHpNews.this;
            obj.countAllKom = ((KomentarHpNews) (obj)).countAllKom + 1;
            obj = KomentarHpNews.this;
            obj.countKomOld = ((KomentarHpNews) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListData.add(new ItemKomenHp(((JSONObject) (obj)).getString("id_komentar"), ((JSONObject) (obj)).getString("id_hp"), ((JSONObject) (obj)).getString("codename"), ((JSONObject) (obj)).getString("nama_komentar"), ((JSONObject) (obj)).getString("email_komentar"), ((JSONObject) (obj)).getString("tanggal_komentar"), ((JSONObject) (obj)).getString("komentarhp"), ((JSONObject) (obj)).getString("komen_bagus"), ((JSONObject) (obj)).getString("komen_kurang"), ((JSONObject) (obj)).getString("usr_pict_komen"), ((JSONObject) (obj)).getString("reply_to"), ((JSONObject) (obj)).getString("nama_to"), ((JSONObject) (obj)).getString("komen_to"), ((JSONObject) (obj)).getString("tanggal_to"), ((JSONObject) (obj)).getString("namalengkap"), ((JSONObject) (obj)).getString("img_kom"), ((JSONObject) (obj)).getString("img_kom_rep")));
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
            int i;
            if (strKonekStat.equals("-"))
            {
                break MISSING_BLOCK_LABEL_1235;
            }
            listKomenHP.removeAllViewsInLayout();
            i = 0;
_L3:
            if (i < mArrayListData.size()) goto _L2; else goto _L1
_L1:
            scrollviewKomen.setVisibility(0);
_L4:
            pop_progressbar_middle.setVisibility(8);
            imgKomenRefresh.setVisibility(0);
            progressbar_Komenbutton.setVisibility(8);
            return;
_L2:
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300fb, null);
            txtNamaHp = (TextView)void1.findViewById(0x7f0b0765);
            txtUsername = (TextView)void1.findViewById(0x7f0b0419);
            lay_quote = (LinearLayout)void1.findViewById(0x7f0b063a);
            img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
            txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
            txtKomentar = (TextViewFixTouchConsume)void1.findViewById(0x7f0b054e);
            txtUsernameQoute = (TextView)void1.findViewById(0x7f0b063b);
            txtKomentarQoute = (TextViewFixTouchConsume)void1.findViewById(0x7f0b063d);
            txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
            txtWaktuQoute = (TextView)void1.findViewById(0x7f0b063c);
            txtTanggapan = (TextView)void1.findViewById(0x7f0b0555);
            final String id_hp = (ImageView)void1.findViewById(0x7f0b054f);
            id_hp = (ImageView)void1.findViewById(0x7f0b0552);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            ((ItemKomenHp)mArrayListData.get(i)).getId_komentar();
            id_hp = ((ItemKomenHp)mArrayListData.get(i)).getId_hp();
            String s = ((ItemKomenHp)mArrayListData.get(i)).getCodename();
            String s1 = ((ItemKomenHp)mArrayListData.get(i)).getNama_komentar();
            ((ItemKomenHp)mArrayListData.get(i)).getEmail_komentar();
            ((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar();
            ((ItemKomenHp)mArrayListData.get(i)).getKomentarhp();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang();
            String s2 = ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen();
            ((ItemKomenHp)mArrayListData.get(i)).getReply_to();
            ((ItemKomenHp)mArrayListData.get(i)).getNama_to();
            ((ItemKomenHp)mArrayListData.get(i)).getKomen_to();
            ((ItemKomenHp)mArrayListData.get(i)).getTanggal_to();
            final String my_like_kom = ((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom();
            if (((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".png") || ((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
            {
                imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenHp)mArrayListData.get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
            } else
            {
                img_kom_picture.setImageResource(0x7f020297);
            }
            txtIdKom.setText(((ItemKomenHp)mArrayListData.get(i)).getId_komentar().toString());
            txtdisLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_kurang().toString());
            txtLikeKom.setText(((ItemKomenHp)mArrayListData.get(i)).getKomen_bagus().toString());
            txtNamaHp.setText(((ItemKomenHp)mArrayListData.get(i)).getMy_like_kom().toString());
            txtUsername.setText(((ItemKomenHp)mArrayListData.get(i)).getNama_komentar());
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomentarhp().toString())));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtUsernameQoute.setText(Html.fromHtml(((ItemKomenHp)mArrayListData.get(i)).getNama_to()));
            txtKomentarQoute.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenHp)mArrayListData.get(i)).getKomen_to().toString())));
            txtKomentarQoute.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtWaktu.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_komentar()));
            txtWaktuQoute.setText(Utility.convertDate(((ItemKomenHp)mArrayListData.get(i)).getTanggal_to()));
            listKomenHP.addView(void1);
            img_kom_picture.setOnLongClickListener(s2. new android.view.View.OnLongClickListener() {

                final KomentarRefreshAsycTask this$1;
                private final String val$usr_pict_komen;

                public boolean onLongClick(View view)
                {
                    view = new ArrayList();
                    view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(usr_pict_komen.toString().trim()).toString());
                    view = (String[])view.toArray(new String[view.size()]);
                    Intent intent = new Intent(_fld0, com/inponsel/android/v2/ImagePagerActivity);
                    intent.putExtra("imgUrl", view);
                    intent.putExtra("pos", 0);
                    startActivity(intent);
                    return false;
                }

            
            {
                this$1 = final_komentarrefreshasyctask;
                usr_pict_komen = String.this;
                super();
            }
            });
            img_kom_picture.setOnClickListener(s1. new android.view.View.OnClickListener() {

                final KomentarRefreshAsycTask this$1;
                private final String val$nama_komentar;

                public void onClick(View view)
                {
                    view = new Intent(_fld0, com/inponsel/android/v2/ProfileOtherUser);
                    view.putExtra("id_user_view", nama_komentar);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarrefreshasyctask;
                nama_komentar = String.this;
                super();
            }
            });
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final KomentarRefreshAsycTask this$1;
                private final String val$codename;
                private final String val$id_hp;
                private final String val$my_like_kom;

                public void onClick(View view)
                {
                    view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                    view.putExtra("id_hph", id_hp);
                    view.putExtra("namalengkap", my_like_kom);
                    view.putExtra("codename", codename);
                    view.putExtra("model", "");
                    view.putExtra("merk", "");
                    view.putExtra("gambar", "");
                    view.putExtra("hrg_baru", "");
                    view.putExtra("hrg_bekas", "");
                    view.putExtra("tot_like", "");
                    view.putExtra("tot_dislike", "");
                    view.putExtra("tot_komen", "");
                    view.putExtra("actfrom", "komen");
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_komentarrefreshasyctask;
                id_hp = s;
                my_like_kom = s1;
                codename = String.this;
                super();
            }
            });
            i++;
              goto _L3
            pop_progressbar_middle.setVisibility(8);
              goto _L4
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            limit = 0;
            Log.e("KomentarRefreshAsycTask", "onPreExecute");
            mArrayListData.clear();
            pop_progressbar_middle.setVisibility(0);
            txtMorekomenhp.setVisibility(8);
            imgKomenRefresh.setVisibility(8);
            progressbar_Komenbutton.setVisibility(0);
            mArrayListData.clear();
        }


        public KomentarRefreshAsycTask()
        {
            this$0 = KomentarHpNews.this;
            super();
        }
    }


    ActionBar actionBar;
    int actionBarTitleId;
    private ImageLoadingListener animateFirstListener;
    String bottom_id;
    RelativeLayout btnMorekomennews;
    int charCount;
    ConnectivityManager cm;
    int countAllKom;
    int countKomOld;
    int countRemIndex;
    Cursor cursor;
    String dataNotifOnOff;
    DatabaseHandler db;
    String email_user;
    Bundle extras;
    String idkom_pos;
    ImageLoader imageLoader2;
    ImageView imgKomenNewsRefresh;
    ImageView imgKomenRefresh;
    ImageView img_kom_picture;
    InputMethodManager imm;
    JSONArray inponsel;
    JSONArray jArray;
    String jumSC;
    String jum_komen;
    String kmail_stat;
    String komencount;
    RelativeLayout lay_KomenNews_lainnya;
    RelativeLayout lay_Komen_lainnya;
    LinearLayout lay_quote;
    LinearLayout layout_komennews;
    int limit;
    LinearLayout linear_listviewnews;
    private LinearLayout listKomenHP;
    SharedPreferences loginPreference;
    private ArrayList mArrayListData;
    ArrayList mArrayListKomNewsData;
    String messageNotif;
    String nama_asli;
    private DisplayImageOptions options;
    String passlam;
    PonselBaseApp ponselBaseApp;
    ProgressBar pop_progressbar_middle;
    ProgressBar pop_progressbar_news;
    String postMessage;
    String postMessageLikeKom;
    String postStatus;
    String postStatusLikeKom;
    SmoothProgressBar progbar_notifHP;
    ProgressBar progressbar_KomenNewsbutton;
    ProgressBar progressbar_Komenbutton;
    String querylike;
    String querypopkomen;
    int removeIndex;
    int removeNextIndex;
    int removeStartOld;
    String res;
    String reslike;
    ScrollView scrollviewKomen;
    String sortkom;
    String statuslike;
    String strJsonRssRep;
    String strKonekStat;
    String suc;
    String succesStat;
    String t;
    String top_id;
    String tot_LikeKom;
    String tot_LikePon;
    String totdis_LikeKom;
    String totdis_LikePon;
    TextView txtBigkomennews;
    TextView txtIdKom;
    TextViewFixTouchConsume txtKomentar;
    TextViewFixTouchConsume txtKomentarQoute;
    TextView txtLikeKom;
    TextView txtMorekomenhp;
    TextView txtMorekomennews;
    TextView txtNamaHp;
    TextView txtTanggapan;
    TextView txtUsername;
    TextView txtUsernameQoute;
    TextView txtWaktu;
    TextView txtWaktuQoute;
    TextView txtdisLikeKom;
    String urlKomen;
    String urlKomenNews;
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
    ContextThemeWrapper wrapperLight;

    public KomentarHpNews()
    {
        dataNotifOnOff = "0";
        inponsel = null;
        suc = "";
        jumSC = "";
        messageNotif = "";
        kmail_stat = "";
        strJsonRssRep = "";
        urlKomen = "";
        urlKomenNews = "";
        strKonekStat = "";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        countKomOld = 0;
        countAllKom = 0;
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
        tot_LikeKom = "0";
        totdis_LikeKom = "0";
        top_id = "";
        bottom_id = "";
        limit = 0;
        komencount = "";
        sortkom = "12";
        querypopkomen = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
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

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300cf);
        layout_komennews = (LinearLayout)findViewById(0x7f0b0674);
        linear_listviewnews = (LinearLayout)findViewById(0x7f0b0679);
        btnMorekomennews = (RelativeLayout)findViewById(0x7f0b0675);
        txtBigkomennews = (TextView)findViewById(0x7f0b0676);
        pop_progressbar_news = (ProgressBar)findViewById(0x7f0b0677);
        txtMorekomennews = (TextView)findViewById(0x7f0b0678);
        lay_Komen_lainnya = (RelativeLayout)findViewById(0x7f0b02c2);
        lay_KomenNews_lainnya = (RelativeLayout)findViewById(0x7f0b067a);
        progressbar_KomenNewsbutton = (ProgressBar)findViewById(0x7f0b067b);
        progressbar_Komenbutton = (ProgressBar)findViewById(0x7f0b02c3);
        imgKomenRefresh = (ImageView)findViewById(0x7f0b02c4);
        imgKomenNewsRefresh = (ImageView)findViewById(0x7f0b067c);
        Field field;
        bundle = ViewConfiguration.get(this);
        field = android/view/ViewConfiguration.getDeclaredField("sHasPermanentMenuKey");
        int i;
        int j;
        if (field != null)
        {
            try
            {
                field.setAccessible(true);
                field.setBoolean(bundle, false);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
        }
        wrapperLight = new ContextThemeWrapper(this, 0x103006e);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        imm = (InputMethodManager)getSystemService("input_method");
        cm = (ConnectivityManager)getSystemService("connectivity");
        t = Utility.session(t);
        extras = getIntent().getExtras();
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Komentar Lain RSSPonsel");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        t = Utility.session(t);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>")).append(URLDecoder.decode("Komentar Terbaru")).append("</font>").toString()));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setText(URLDecoder.decode("Komentar Terbaru"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        listKomenHP = (LinearLayout)findViewById(0x7f0b04d8);
        progbar_notifHP = (SmoothProgressBar)findViewById(0x7f0b04cb);
        txtMorekomenhp = (TextView)findViewById(0x7f0b0673);
        progbar_notifHP.setVisibility(8);
        mArrayListData = new ArrayList();
        mArrayListKomNewsData = new ArrayList();
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).showImageOnFail(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        scrollviewKomen = (ScrollView)findViewById(0x7f0b052d);
        pop_progressbar_middle = (ProgressBar)findViewById(0x7f0b04ce);
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
        lay_Komen_lainnya.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarHpNews this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarBaruLainPonsel);
                view.putExtra("str_id_user", "");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = KomentarHpNews.this;
                super();
            }
        });
        lay_KomenNews_lainnya.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarHpNews this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarBaruLainNews);
                view.putExtra("str_id_user", "");
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = KomentarHpNews.this;
                super();
            }
        });
        txtMorekomenhp.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarHpNews this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarBaruLainPonsel);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = KomentarHpNews.this;
                super();
            }
        });
        txtMorekomennews.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarHpNews this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/KomentarBaruLainNews);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = KomentarHpNews.this;
                super();
            }
        });
        imgKomenRefresh.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarHpNews this$0;

            public void onClick(View view)
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarRefreshAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    return;
                } else
                {
                    (new KomentarRefreshAsycTask()).execute(new String[0]);
                    return;
                }
            }

            
            {
                this$0 = KomentarHpNews.this;
                super();
            }
        });
        imgKomenNewsRefresh.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarHpNews this$0;

            public void onClick(View view)
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new KomentarNewsRefreshAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    return;
                } else
                {
                    (new KomentarNewsRefreshAsycTask()).execute(new String[0]);
                    return;
                }
            }

            
            {
                this$0 = KomentarHpNews.this;
                super();
            }
        });
        try
        {
            urlKomen = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_baruhp_list").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).toString();
            urlKomenNews = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_news_lain").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).toString();
            Log.e("urlKomen", urlKomen);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new KomentarAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else
        {
            (new KomentarAsycTask()).execute(new String[0]);
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new KomentarNewsAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        } else
        {
            (new KomentarNewsAsycTask()).execute(new String[0]);
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0014, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 2: default 32
    //                   16908332: 34
    //                   2131429682: 51;
           goto _L1 _L2 _L3
_L1:
        return true;
_L2:
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
        continue; /* Loop/switch isn't completed */
_L3:
        startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void update(Observable observable, Object obj)
    {
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
        if (ponselBaseApp.getObserver().getLoginStat().equals("1"))
        {
            userFunctions.isUserLoggedIn(this);
        }
    }




}
