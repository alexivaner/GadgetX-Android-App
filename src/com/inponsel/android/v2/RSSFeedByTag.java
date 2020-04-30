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
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ItemRSS;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.rssfeeddetail.RSSKomenTab;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeRSSHelper;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
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
//            BaseDrawer, ImagePagerActivity, RegisterActivity, LoginActivity

public class RSSFeedByTag extends SherlockFragmentActivity
    implements Observer
{
    public class FavoritTask extends AsyncTask
    {

        final RSSFeedByTag this$0;

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
                mDialog = ProgressDialog.show(RSSFeedByTag.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(RSSFeedByTag.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public FavoritTask()
        {
            this$0 = RSSFeedByTag.this;
            super();
        }
    }

    public class PostBagusKurangTask extends AsyncTask
    {

        final RSSFeedByTag this$0;

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
            this$0 = RSSFeedByTag.this;
            super();
        }
    }

    public class RSSAsycTask extends AsyncTask
    {

        final RSSFeedByTag this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            JSONObject jsonobject = new JSONObject(getJSONUrl(urlRSS));
            as = jsonobject.getJSONArray("InPonsel");
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            succesStat = jsonobject.getString("success");
            Log.e("bottom_id", bottom_id);
            Log.e("top_id", top_id);
            Log.e("succesStat", succesStat);
            countKomOld = 0;
            if (!succesStat.equals("true"))
            {
                break MISSING_BLOCK_LABEL_337;
            }
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_337;
            }
            Object obj = RSSFeedByTag.this;
            obj.countAllKom = ((RSSFeedByTag) (obj)).countAllKom + 1;
            obj = RSSFeedByTag.this;
            obj.countKomOld = ((RSSFeedByTag) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            Log.e("rss_title", ((JSONObject) (obj)).getString("rss_title"));
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
            if (!succesStat.equals("true")) goto _L2; else goto _L1
_L1:
            if (mArrayListData.size() < 10)
            {
                txtbtnfooter.setVisibility(8);
                break MISSING_BLOCK_LABEL_1547;
            }
              goto _L3
_L9:
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

                        final RSSAsycTask this$1;

                        public void onClick(View view)
                        {
                            try
                            {
                                txtbtnheader.setVisibility(8);
                                limit = 0;
                                urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
                                Log.e("urlRSSLast", urlRSSLast);
                                if (android.os.Build.VERSION.SDK_INT >= 11)
                                {
                                    (new RSSNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                    return;
                                }
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                return;
                            }
                            (new RSSNextAsycTask()).execute(new String[0]);
                            return;
                        }

            
            {
                this$1 = RSSAsycTask.this;
                super();
            }
                    });
                    txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                        final RSSAsycTask this$1;

                        public void onClick(View view)
                        {
                            try
                            {
                                view = _fld0;
                                view.page_counter = ((RSSFeedByTag) (view)).page_counter + 1;
                                limit = 0;
                                urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
                                Log.e("urlRSSOld", urlRSSOld);
                                if (android.os.Build.VERSION.SDK_INT >= 11)
                                {
                                    (new RSSOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                    return;
                                }
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                return;
                            }
                            (new RSSOldAsycTask()).execute(new String[0]);
                            return;
                        }

            
            {
                this$1 = RSSAsycTask.this;
                super();
            }
                    });
                    layout_empty.setVisibility(8);
                    scrollviewKomen.setVisibility(0);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L4
_L3:
            txtbtnfooter.setVisibility(0);
            break MISSING_BLOCK_LABEL_1547;
_L4:
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030141, null);
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
            imageview1 = (ImageView)void1.findViewById(0x7f0b05f1);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            txtTotalKom = (TextView)void1.findViewById(0x7f0b034a);
            bottom_list = (LinearLayout)void1.findViewById(0x7f0b0341);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_favorite = (RelativeLayout)void1.findViewById(0x7f0b0665);
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
            Log.e("fav572", s);
            txtTitle.setText(Html.fromHtml(rss_title));
            txtIdKom.setText(id_rss);
            txtUsername.setText(rss_portal);
            txtImgAva.setText(rss_img_ava);
            txtImgMedia.setText(rss_img);
            txtKomentar.setText(Html.fromHtml(Utility.parseUrl(rss_desc)));
            txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
            txtLikeKom.setText(total_like);
            txtTotalKom.setText(total_komen);
            if (!like_stat.toString().equals("1")) goto _L6; else goto _L5
_L5:
            imageview.setBackgroundResource(0x7f020264);
            list_lay_like.setEnabled(false);
_L10:
            if (!s.toString().equals("1")) goto _L8; else goto _L7
_L7:
            imageview1.setBackgroundResource(0x7f020303);
_L11:
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)mArrayListData.get(i)).getRss_img_ava().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
            if (!((ItemRSS)mArrayListData.get(i)).getRss_img().trim().equals(""))
            {
                break MISSING_BLOCK_LABEL_1357;
            }
            imageMedia.setVisibility(8);
_L12:
            txtWaktu.setText(Utility.convertDate(((ItemRSS)mArrayListData.get(i)).getRss_date()));
            mLinearListView.addView(void1);
            imageMedia.setOnClickListener(rss_img. new android.view.View.OnClickListener() {

                final RSSAsycTask this$1;
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
                this$1 = final_rssasyctask;
                rss_img = String.this;
                super();
            }
            });
            img_kom_picture.setOnLongClickListener(rss_img_ava. new android.view.View.OnLongClickListener() {

                final RSSAsycTask this$1;
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
                this$1 = final_rssasyctask;
                rss_img_ava = String.this;
                super();
            }
            });
            list_lay_like.setOnClickListener(id_rss. new android.view.View.OnClickListener() {

                final RSSAsycTask this$1;
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
                id_rss = String.this;
                super();
            }
            });
            list_lay_favorite.setOnClickListener(textview. new android.view.View.OnClickListener() {

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
                        if (txt_fav_news_1.getText().toString().equals("1"))
                        {
                            view = new android.app.AlertDialog.Builder(_fld0);
                            view.setMessage("Hapus berita ini dari favorit?");
                            view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                final RSSAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                    stat = "0";
                                    (new FavoritTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = RSSAsycTask._cls4.this;
                super();
            }
                            });
                            view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final RSSAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = RSSAsycTask._cls4.this;
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

                                final RSSAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    stat = "1";
                                    (new FavoritTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = RSSAsycTask._cls4.this;
                super();
            }
                            });
                            view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final RSSAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = RSSAsycTask._cls4.this;
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

                            final RSSAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = RSSAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final RSSAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = RSSAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final RSSAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = RSSAsycTask._cls4.this;
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
            list_lay_kom.setOnClickListener(s. new android.view.View.OnClickListener() {

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
                this$1 = final_rssasyctask;
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
              goto _L9
_L6:
label0:
            {
                if (!like_stat.toString().equals("0"))
                {
                    break label0;
                }
                imageview.setBackgroundResource(0x7f020265);
                imageview1.setBackgroundResource(0x7f0201a7);
                list_lay_like.setEnabled(true);
            }
              goto _L10
            list_lay_like.setEnabled(true);
            imageview.setBackgroundResource(0x7f020265);
            list_lay_like.setBackgroundResource(0x7f020079);
              goto _L10
_L8:
label1:
            {
                if (!s.toString().equals("0"))
                {
                    break label1;
                }
                imageview1.setBackgroundResource(0x7f020302);
            }
              goto _L11
            imageview1.setBackgroundResource(0x7f020302);
              goto _L11
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)mArrayListData.get(i)).getRss_img().toString().trim()).toString(), imageMedia, options, animateFirstListener);
              goto _L12
_L2:
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final RSSAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        txtbtnheader.setVisibility(8);
                        limit = 0;
                        urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
                        Log.e("urlRSSLast", urlRSSLast);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new RSSNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new RSSNextAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = RSSAsycTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final RSSAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        view = _fld0;
                        view.page_counter = ((RSSFeedByTag) (view)).page_counter + 1;
                        limit = 0;
                        urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
                        Log.e("urlRSSOld", urlRSSOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new RSSOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new RSSOldAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = RSSAsycTask.this;
                super();
            }
            });
            scrollviewKomen.setVisibility(0);
            txtbtnfooter.setVisibility(8);
            txtbtnheader.setVisibility(8);
            layout_empty.setVisibility(0);
            pop_progressbar_middle.setVisibility(8);
            pop_txt_empty.setVisibility(0);
            pop_txt_empty.setText("Berita belum tersedia");
            return;
            i = 0;
              goto _L9
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Log.e("urlRSS", urlRSS);
            page_counter = 1;
        }


        public RSSAsycTask()
        {
            this$0 = RSSFeedByTag.this;
            super();
        }
    }

    public class RSSNextAsycTask extends AsyncTask
    {

        final RSSFeedByTag this$0;

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
            Object obj = RSSFeedByTag.this;
            obj.countAllKom = ((RSSFeedByTag) (obj)).countAllKom + 1;
            obj = RSSFeedByTag.this;
            obj.countKomOld = ((RSSFeedByTag) (obj)).countKomOld + 1;
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
            Object obj;
            ImageView imageview;
            int i;
            if (!strKonekStat.equals("-"))
            {
                i = 0;
            } else
            {
                txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                    final RSSNextAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            txtbtnheader.setVisibility(8);
                            limit = 0;
                            urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
                            Log.e("urlRSSLast", urlRSSLast);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new RSSNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                return;
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                        (new RSSNextAsycTask()).execute(new String[0]);
                        return;
                    }

            
            {
                this$1 = RSSNextAsycTask.this;
                super();
            }
                });
                txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                    final RSSNextAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            view = _fld0;
                            view.page_counter = ((RSSFeedByTag) (view)).page_counter + 1;
                            limit = 0;
                            urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
                            Log.e("urlRSSOld", urlRSSOld);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new RSSOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                return;
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                        (new RSSOldAsycTask()).execute(new String[0]);
                        return;
                    }

            
            {
                this$1 = RSSNextAsycTask.this;
                super();
            }
                });
                scrollviewKomen.setVisibility(8);
                layout_empty.setVisibility(0);
                pop_progressbar_middle.setVisibility(8);
                pop_txt_empty.setVisibility(0);
                pop_txt_empty.setText("Berita belum tersedia");
                return;
            }
            if (i >= mArrayListData.size())
            {
                txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                    final RSSNextAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            txtbtnheader.setVisibility(8);
                            limit = 0;
                            urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
                            Log.e("urlRSSLast", urlRSSLast);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new RSSNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                return;
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                        (new RSSNextAsycTask()).execute(new String[0]);
                        return;
                    }

            
            {
                this$1 = RSSNextAsycTask.this;
                super();
            }
                });
                txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                    final RSSNextAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            view = _fld0;
                            view.page_counter = ((RSSFeedByTag) (view)).page_counter + 1;
                            limit = 0;
                            urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
                            Log.e("urlRSSOld", urlRSSOld);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new RSSOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                return;
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                        (new RSSOldAsycTask()).execute(new String[0]);
                        return;
                    }

            
            {
                this$1 = RSSNextAsycTask.this;
                super();
            }
                });
                layout_empty.setVisibility(8);
                scrollviewKomen.setVisibility(0);
                return;
            }
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030141, null);
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
            imageview = (ImageView)void1.findViewById(0x7f0b05f1);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            txtTotalKom = (TextView)void1.findViewById(0x7f0b034a);
            bottom_list = (LinearLayout)void1.findViewById(0x7f0b0341);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_favorite = (RelativeLayout)void1.findViewById(0x7f0b0665);
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
            Log.e("fav2241", s);
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
            } else
            if (like_stat.toString().equals("0"))
            {
                ((ImageView) (obj)).setBackgroundResource(0x7f020265);
                imageview.setBackgroundResource(0x7f0201a7);
                list_lay_like.setEnabled(true);
            } else
            {
                list_lay_like.setEnabled(true);
                ((ImageView) (obj)).setBackgroundResource(0x7f020265);
                list_lay_like.setBackgroundResource(0x7f020079);
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
            obj = RSSFeedByTag.this;
            obj.countnext = ((RSSFeedByTag) (obj)).countnext + 1;
            imageMedia.setOnClickListener(rss_img. new android.view.View.OnClickListener() {

                final RSSNextAsycTask this$1;
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
                this$1 = final_rssnextasyctask;
                rss_img = String.this;
                super();
            }
            });
            img_kom_picture.setOnLongClickListener(rss_img_ava. new android.view.View.OnLongClickListener() {

                final RSSNextAsycTask this$1;
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
                this$1 = final_rssnextasyctask;
                rss_img_ava = String.this;
                super();
            }
            });
            list_lay_like.setOnClickListener(id_rss. new android.view.View.OnClickListener() {

                final RSSNextAsycTask this$1;
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

                            final RSSNextAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = RSSNextAsycTask._cls3.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final RSSNextAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = RSSNextAsycTask._cls3.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final RSSNextAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = RSSNextAsycTask._cls3.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_rssnextasyctask;
                id_rss = String.this;
                super();
            }
            });
            list_lay_favorite.setOnClickListener(textview. new android.view.View.OnClickListener() {

                final RSSNextAsycTask this$1;
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

                                final RSSNextAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                    stat = "0";
                                    (new FavoritTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = RSSNextAsycTask._cls4.this;
                super();
            }
                            });
                            view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final RSSNextAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = RSSNextAsycTask._cls4.this;
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

                                final RSSNextAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    stat = "1";
                                    (new FavoritTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = RSSNextAsycTask._cls4.this;
                super();
            }
                            });
                            view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final RSSNextAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = RSSNextAsycTask._cls4.this;
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

                            final RSSNextAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = RSSNextAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final RSSNextAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = RSSNextAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final RSSNextAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = RSSNextAsycTask._cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_rssnextasyctask;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = TextView.this;
                super();
            }
            });
            list_lay_kom.setOnClickListener(s. new android.view.View.OnClickListener() {

                final RSSNextAsycTask this$1;
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
                    view.putExtra("actfrom", "rssfeed");
                    view.putExtra("act", "komen");
                    view.putExtra("kategori_tag", kategori_tag);
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
                this$1 = final_rssnextasyctask;
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

                final RSSNextAsycTask this$1;
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
                this$1 = final_rssnextasyctask;
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
                break MISSING_BLOCK_LABEL_1328;
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


        public RSSNextAsycTask()
        {
            this$0 = RSSFeedByTag.this;
            super();
        }
    }

    public class RSSOldAsycTask extends AsyncTask
    {

        final RSSFeedByTag this$0;

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
            Object obj = RSSFeedByTag.this;
            obj.countAllKom = ((RSSFeedByTag) (obj)).countAllKom + 1;
            obj = RSSFeedByTag.this;
            obj.countKomOld = ((RSSFeedByTag) (obj)).countKomOld + 1;
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
            if (!strKonekStat.equals("-"))
            {
                i = 0;
            } else
            {
                txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                    final RSSOldAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            txtbtnheader.setVisibility(8);
                            limit = 0;
                            urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
                            Log.e("urlRSSLast", urlRSSLast);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new RSSNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                return;
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                        (new RSSNextAsycTask()).execute(new String[0]);
                        return;
                    }

            
            {
                this$1 = RSSOldAsycTask.this;
                super();
            }
                });
                txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                    final RSSOldAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            view = _fld0;
                            view.page_counter = ((RSSFeedByTag) (view)).page_counter + 1;
                            limit = 0;
                            urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
                            Log.e("urlRSSOld", urlRSSOld);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new RSSOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                return;
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                        (new RSSOldAsycTask()).execute(new String[0]);
                        return;
                    }

            
            {
                this$1 = RSSOldAsycTask.this;
                super();
            }
                });
                scrollviewKomen.setVisibility(8);
                layout_empty.setVisibility(0);
                pop_progressbar_middle.setVisibility(8);
                pop_txt_empty.setVisibility(0);
                pop_txt_empty.setText("Berita belum tersedia");
                return;
            }
            if (i >= mArrayListData.size())
            {
                txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                    final RSSOldAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            txtbtnheader.setVisibility(8);
                            limit = 0;
                            urlRSSLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("&top_id=").append(URLEncoder.encode(top_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
                            Log.e("urlRSSLast", urlRSSLast);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new RSSNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                return;
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                        (new RSSNextAsycTask()).execute(new String[0]);
                        return;
                    }

            
            {
                this$1 = RSSOldAsycTask.this;
                super();
            }
                });
                txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                    final RSSOldAsycTask this$1;

                    public void onClick(View view)
                    {
                        try
                        {
                            view = _fld0;
                            view.page_counter = ((RSSFeedByTag) (view)).page_counter + 1;
                            limit = 0;
                            urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
                            Log.e("urlRSSOld", urlRSSOld);
                            if (android.os.Build.VERSION.SDK_INT >= 11)
                            {
                                (new RSSOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                                return;
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            return;
                        }
                        (new RSSOldAsycTask()).execute(new String[0]);
                        return;
                    }

            
            {
                this$1 = RSSOldAsycTask.this;
                super();
            }
                });
                layout_empty.setVisibility(8);
                scrollviewKomen.setVisibility(0);
                return;
            }
            void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030141, null);
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
            imageview1 = (ImageView)void1.findViewById(0x7f0b05f1);
            txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
            txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
            txtTotalKom = (TextView)void1.findViewById(0x7f0b034a);
            bottom_list = (LinearLayout)void1.findViewById(0x7f0b0341);
            list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
            list_lay_favorite = (RelativeLayout)void1.findViewById(0x7f0b0665);
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
            Log.e("fav1519", s);
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
                imageview.setBackgroundResource(0x7f020264);
                list_lay_like.setEnabled(false);
            } else
            if (like_stat.toString().equals("0"))
            {
                imageview.setBackgroundResource(0x7f020265);
                imageview1.setBackgroundResource(0x7f0201a7);
                list_lay_like.setEnabled(true);
            } else
            {
                list_lay_like.setEnabled(true);
                imageview.setBackgroundResource(0x7f020265);
                list_lay_like.setBackgroundResource(0x7f020079);
            }
            if (!s.toString().equals("1")) goto _L2; else goto _L1
_L1:
            imageview1.setBackgroundResource(0x7f020303);
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
            mLinearListView.addView(void1, mLinearListView.getChildCount());
            imageMedia.setOnClickListener(rss_img. new android.view.View.OnClickListener() {

                final RSSOldAsycTask this$1;
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
                this$1 = final_rssoldasyctask;
                rss_img = String.this;
                super();
            }
            });
            img_kom_picture.setOnLongClickListener(rss_img_ava. new android.view.View.OnLongClickListener() {

                final RSSOldAsycTask this$1;
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
                this$1 = final_rssoldasyctask;
                rss_img_ava = String.this;
                super();
            }
            });
            list_lay_like.setOnClickListener(id_rss. new android.view.View.OnClickListener() {

                final RSSOldAsycTask this$1;
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

                            final RSSOldAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = RSSOldAsycTask._cls3.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final RSSOldAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = RSSOldAsycTask._cls3.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final RSSOldAsycTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = RSSOldAsycTask._cls3.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_rssoldasyctask;
                id_rss = String.this;
                super();
            }
            });
            list_lay_favorite.setOnClickListener(textview. new android.view.View.OnClickListener() {

                final RSSOldAsycTask this$1;
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

                                final RSSOldAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                    stat = "0";
                                    (new FavoritTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = RSSOldAsycTask._cls4.this;
                super();
            }
                            });
                            view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final RSSOldAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = RSSOldAsycTask._cls4.this;
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

                                final RSSOldAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    stat = "1";
                                    (new FavoritTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = RSSOldAsycTask._cls4.this;
                super();
            }
                            });
                            view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final RSSOldAsycTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = RSSOldAsycTask._cls4.this;
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

                            final RSSOldAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = RSSOldAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final RSSOldAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = RSSOldAsycTask._cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final RSSOldAsycTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = RSSOldAsycTask._cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_rssoldasyctask;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = TextView.this;
                super();
            }
            });
            list_lay_kom.setOnClickListener(s. new android.view.View.OnClickListener() {

                final RSSOldAsycTask this$1;
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
                    view.putExtra("actfrom", "rssfeed");
                    view.putExtra("act", "komen");
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
                this$1 = final_rssoldasyctask;
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

                final RSSOldAsycTask this$1;
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
                this$1 = final_rssoldasyctask;
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
                break MISSING_BLOCK_LABEL_1334;
            } else
            {
                break MISSING_BLOCK_LABEL_59;
            }
_L2:
            if (s.toString().equals("0"))
            {
                imageview1.setBackgroundResource(0x7f020302);
            } else
            {
                imageview1.setBackgroundResource(0x7f020302);
            }
              goto _L3
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


        public RSSOldAsycTask()
        {
            this$0 = RSSFeedByTag.this;
            super();
        }
    }


    protected static final String TAG = com/inponsel/android/v2/BaseDrawer.getName();
    ActionBar actionBar;
    int actionBarTitleId;
    private ImageLoadingListener animateFirstListener;
    String bottom_id;
    LinearLayout bottom_list;
    Button btnRefresh;
    int charCount;
    ConnectivityManager cm;
    int countAllKom;
    int countKomOld;
    int countRemIndex;
    int countnext;
    Cursor cursor;
    DatabaseHandler db;
    String email_user;
    Bundle extras;
    String firtsid;
    LinearLayout grup_footer;
    LinearLayout grup_header;
    String idkom_pos;
    ImageLoader imageLoader2;
    ImageView imageMedia;
    ImageView img_kom_picture;
    InputMethodManager imm;
    JSONArray jArray;
    String jum_komen;
    String kategori_tag;
    String komencount;
    String lastid;
    LinearLayout lay_quote;
    LinearLayout layout_empty;
    LinearLayout layout_footerNext;
    LinearLayout layout_header;
    int limit;
    RelativeLayout list_lay_favorite;
    RelativeLayout list_lay_kom;
    RelativeLayout list_lay_like;
    private ArrayList mArrayListData;
    ProgressDialog mDialog;
    private LinearLayout mLinearListView;
    String nama_asli;
    NotificationLikeRSSHelper notificationLikeHelper;
    private DisplayImageOptions options;
    int page_counter;
    PonselBaseApp ponselBaseApp;
    ProgressBar pop_progressbar_middle;
    TextView pop_txt_empty;
    String postMessage;
    String postMessageAddRss;
    String postMessageLikeKom;
    String postStatus;
    String postStatusAddRss;
    String postStatusLikeKom;
    String querylike;
    String querypopkomen;
    int removeIndex;
    int removeNextIndex;
    int removeStartOld;
    String res;
    String reslike;
    String rss_content;
    ScrollView scrollviewKomen;
    String stat;
    String statuslike;
    String strKonekStat;
    String str_srclink;
    String succesStat;
    String t;
    String tag_code;
    String tag_key;
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
    TextView txtbtnfooter;
    TextView txtbtnheader;
    TextView txtdisLikeKom;
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
    ContextThemeWrapper wrapperLight;

    public RSSFeedByTag()
    {
        stat = "";
        countnext = 0;
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
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
        firtsid = "";
        lastid = "";
        tag_code = "";
        tag_key = "";
        kategori_tag = "";
        page_counter = 1;
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

    protected void onActivityResult(int i, int j, Intent intent)
    {
        Log.e("onActivityResult", "RESULT_OK");
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        intent = intent.getStringExtra("postStatus");
        android.util.Log.e("onActivityResultAct", intent);
        if (!intent.equals("1"))
        {
            break MISSING_BLOCK_LABEL_111;
        }
        try
        {
            limit = 0;
            Log.e("urlRSSLastKom", urlRSSLast);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                (new RSSNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return;
        }
        (new RSSNextAsycTask()).execute(new String[0]);
        return;
        Log.e("onActivityResult", "false");
    }

    public void onBackPressed()
    {
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
        Log.e("finish", "2");
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030102);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        wrapperLight = new ContextThemeWrapper(this, 0x103006e);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        imm = (InputMethodManager)getSystemService("input_method");
        cm = (ConnectivityManager)getSystemService("connectivity");
        t = Utility.session(t);
        extras = getIntent().getExtras();
        tag_code = extras.getString("tag_key");
        tag_key = extras.getString("tag_key");
        kategori_tag = extras.getString("kategori_tag");
        ActionBar actionbar;
        StringBuilder stringbuilder;
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName((new StringBuilder("RSS Feeds ")).append(kategori_tag).toString());
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
        actionbar = getSupportActionBar();
        stringbuilder = new StringBuilder("<font color='#FFFFFF'>");
        if (kategori_tag.trim().length() > 0)
        {
            bundle = (new StringBuilder("Berita \273 ")).append(kategori_tag).toString();
        } else
        {
            bundle = "Berita";
        }
        actionbar.setTitle(Html.fromHtml(stringbuilder.append(URLDecoder.decode(bundle)).append("</font>").toString()));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        mLinearListView = (LinearLayout)findViewById(0x7f0b04d8);
        notificationLikeHelper = new NotificationLikeRSSHelper(this);
        mArrayListData = new ArrayList();
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageOnLoading(0x7f020209).showImageForEmptyUri(0x7f020297).showImageOnFail(0x7f020297).showImageOnFail(0x7f020209).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        txtbtnheader = (TextView)findViewById(0x7f0b04d4);
        txtbtnfooter = (TextView)findViewById(0x7f0b04d9);
        txtbtnfooter.setText("Tekan untuk lihat berita lama...");
        layout_header = (LinearLayout)findViewById(0x7f0b04d5);
        grup_footer = (LinearLayout)findViewById(0x7f0b00be);
        layout_footerNext = (LinearLayout)findViewById(0x7f0b00c0);
        grup_header = (LinearLayout)findViewById(0x7f0b04d3);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        scrollviewKomen = (ScrollView)findViewById(0x7f0b052d);
        pop_progressbar_middle = (ProgressBar)findViewById(0x7f0b04ce);
        pop_txt_empty = (TextView)findViewById(0x7f0b04cf);
        pop_txt_empty.setVisibility(8);
        scrollviewKomen.setVisibility(8);
        btnRefresh = (Button)findViewById(0x7f0b04d0);
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
            urlRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
            Log.e("urlRSS", urlRSS);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        layout_empty.setVisibility(0);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new RSSAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        } else
        {
            (new RSSAsycTask()).execute(new String[0]);
        }
        grup_header.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSFeedByTag this$0;

            public void onClick(View view)
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new RSSNextAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    return;
                } else
                {
                    (new RSSNextAsycTask()).execute(new String[0]);
                    return;
                }
            }

            
            {
                this$0 = RSSFeedByTag.this;
                super();
            }
        });
        grup_footer.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSFeedByTag this$0;

            public void onClick(View view)
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new RSSOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                    return;
                } else
                {
                    (new RSSOldAsycTask()).execute(new String[0]);
                    return;
                }
            }

            
            {
                this$0 = RSSFeedByTag.this;
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

    public void update(Observable observable, Object obj)
    {
        int i;
        if (!ponselBaseApp.getObserver().getUpdateType().equals("likerss"))
        {
            break MISSING_BLOCK_LABEL_493;
        }
        Log.e("id_rssup", ponselBaseApp.getObserver().getIndexRSS());
        Log.e("mLinearListView", String.valueOf(mLinearListView.getChildCount()));
        i = 0;
_L3:
        if (i < mLinearListView.getChildCount()) goto _L2; else goto _L1
_L1:
        if (ponselBaseApp.getObserver().getLoginStat().equals("1") && userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            ImageView imageview;
            Object obj1;
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
_L2:
        obj1 = mLinearListView.getChildAt(i);
        observable = (TextView)((View) (obj1)).findViewById(0x7f0b054d);
        obj = (TextView)((View) (obj1)).findViewById(0x7f0b0551);
        imageview = (ImageView)((View) (obj1)).findViewById(0x7f0b054f);
        obj1 = (TextView)((View) (obj1)).findViewById(0x7f0b034a);
        if (observable.getText().toString().equals(ponselBaseApp.getObserver().getIndexRSS()))
        {
            ((TextView) (obj)).setText(ponselBaseApp.getObserver().getTot_LikeRSS());
            ((TextView) (obj1)).setText(ponselBaseApp.getObserver().getJum_komenLikeRSS());
            imageview.setBackgroundResource(0x7f020264);
        }
        i++;
          goto _L3
        if (ponselBaseApp.getObserver().getUpdateType().equals("favrss"))
        {
            i = 0;
            while (i < mLinearListView.getChildCount()) 
            {
                obj = mLinearListView.getChildAt(i);
                observable = (ImageView)((View) (obj)).findViewById(0x7f0b05f1);
                obj = (TextView)((View) (obj)).findViewById(0x7f0b054d);
                Log.e("rssidmatch", (new StringBuilder(String.valueOf(ponselBaseApp.getObserver().getIndexRSS()))).append("=").append(((TextView) (obj)).getText().toString()).toString());
                if (((TextView) (obj)).getText().toString().equals(ponselBaseApp.getObserver().getIndexRSS()))
                {
                    if (ponselBaseApp.getObserver().getFav_stat_rss().toString().equals("1"))
                    {
                        observable.setBackgroundResource(0x7f020303);
                    } else
                    {
                        observable.setBackgroundResource(0x7f020302);
                    }
                }
                i++;
            }
        }
          goto _L1
    }

    public void updateViewLikeDis(String s)
    {
        int i;
        Log.e("id_kom", s);
        Log.e("mLinearListView", String.valueOf(mLinearListView.getChildCount()));
        i = 0;
_L2:
        ImageView imageview;
        ImageView imageview1;
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
        imageview1 = (ImageView)((View) (obj)).findViewById(0x7f0b05f1);
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
        imageview1.setBackgroundResource(0x7f0201a7);
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
            ImageView imageview = (ImageView)((View) (obj)).findViewById(0x7f0b05f1);
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
