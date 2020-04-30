// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.text.Editable;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.google.gson.Gson;
import com.inponsel.android.adapter.ItemKategoriAppsGames;
import com.inponsel.android.adapter.ItemRSS;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.details.ProfilPTActivity;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.utils.AnimateFirstDisplayListener;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.NotificationLikeRSSHelper;
import com.inponsel.android.utils.Response;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.AppsByCategory;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
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

public class FavoritPonselMerek extends SherlockFragmentActivity
    implements Observer
{
    private class FavBrandTask extends AsyncTask
    {

        final FavoritPonselMerek this$0;

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
                int i;
                try
                {
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
                    favBrandArray.clear();
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
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_319;
            }
            avoid = FavoritPonselMerek.this;
            avoid.counterArray = ((FavoritPonselMerek) (avoid)).counterArray + 1;
            avoid = inponsel.getJSONObject(i);
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
            i++;
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
            progressbar_middle.setVisibility(8);
            Log.e("data", dataBrand);
            (new Handler()).postDelayed(new Runnable() {

                final FavBrandTask this$1;

                public void run()
                {
                    scrolView.fullScroll(33);
                }

            
            {
                this$1 = FavBrandTask.this;
                super();
            }
            }, 100L);
            Log.e("favBrandArray", String.valueOf(favBrandArray.size()));
            favBrandAdapter.notifyDataSetChanged();
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }


        private FavBrandTask()
        {
            this$0 = FavoritPonselMerek.this;
            super();
        }

        FavBrandTask(FavBrandTask favbrandtask)
        {
            this();
        }
    }

    private class FavoritHPTask extends AsyncTask
    {

        Response response;
        final FavoritPonselMerek this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            avoid = new HttpGet(dataFav);
            Object obj;
            int i;
            try
            {
                obj = (new DefaultHttpClient()).execute(avoid);
                i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
            }
            catch (IOException ioexception)
            {
                avoid.abort();
                return null;
            }
            if (i == 200)
            {
                break MISSING_BLOCK_LABEL_89;
            }
            Log.e(getClass().getSimpleName(), (new StringBuilder("Error ")).append(i).append(" for URL ").append(dataFav).toString());
            return null;
            obj = new InputStreamReader(((HttpResponse) (obj)).getEntity().getContent());
            response = (Response)(new Gson()).fromJson(((java.io.Reader) (obj)), com/inponsel/android/utils/Response);
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            db.removeFavorite();
            hpFavoriteArray.clear();
            Log.e("taskLst", "pendatang");
            Log.e("data", dataFav);
            void1 = response.InPonsel.iterator();
_L3:
            if (void1.hasNext()) goto _L2; else goto _L1
_L1:
            hpFavoriteAdapter.notifyDataSetChanged();
            Log.e("size", String.valueOf(hpFavoriteArray.size()));
_L4:
            progressbar_middle.setVisibility(8);
            return;
_L2:
            ListModel listmodel;
            listmodel = (ListModel)void1.next();
            if (!listmodel.getId_hp().equals("-") || !listmodel.getModel().equals("-"))
            {
                break MISSING_BLOCK_LABEL_208;
            }
            progressbar_middle.setVisibility(8);
            txt_empty.setVisibility(0);
            txt_empty.setText("Belum ada ponsel difavoritkan");
              goto _L3
            void1;
            txt_empty.setVisibility(0);
            txt_empty.setText("Belum ada ponsel difavoritkan");
            void1.printStackTrace();
              goto _L4
            id_hph = listmodel.getId_hp();
            merk = listmodel.getMerk();
            model = listmodel.getModel();
            gambar = listmodel.getGambar();
            codename = listmodel.getCodename();
            db.addHP(id_hph, merk, model, gambar, codename);
            hpFavoriteArray.add(listmodel);
            listHp.setVisibility(0);
              goto _L3
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressbar_middle.setVisibility(0);
        }

        private FavoritHPTask()
        {
            this$0 = FavoritPonselMerek.this;
            super();
        }

        FavoritHPTask(FavoritHPTask favorithptask)
        {
            this();
        }
    }

    private class FavoritRSSTask extends AsyncTask
    {

        final FavoritPonselMerek this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            Log.e("KomentarAsycTask", "doInBackground");
            JSONObject jsonobject = new JSONObject(getJSONUrl(dataFavRSS));
            as = jsonobject.getJSONArray("InPonsel");
            bottom_id = jsonobject.getString("bottom_id");
            top_id = jsonobject.getString("top_id");
            countKomOld = 0;
            int i = 0;
_L1:
            if (i >= as.length())
            {
                break MISSING_BLOCK_LABEL_361;
            }
            Object obj = FavoritPonselMerek.this;
            obj.countAllKom = ((FavoritPonselMerek) (obj)).countAllKom + 1;
            obj = FavoritPonselMerek.this;
            obj.countKomOld = ((FavoritPonselMerek) (obj)).countKomOld + 1;
            obj = as.getJSONObject(i);
            mArrayListDataRSS.add(new ItemRSS(((JSONObject) (obj)).getString("id"), ((JSONObject) (obj)).getString("rss_id"), ((JSONObject) (obj)).getString("rss_title"), ((JSONObject) (obj)).getString("rss_portal"), ((JSONObject) (obj)).getString("rss_desc"), ((JSONObject) (obj)).getString("rss_content"), ((JSONObject) (obj)).getString("rss_srclink"), ((JSONObject) (obj)).getString("rss_date"), ((JSONObject) (obj)).getString("rss_img_ava"), ((JSONObject) (obj)).getString("rss_img"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_like"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_komen"), "", ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_like_rss"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_fav_rss")));
            db.addRSS(((JSONObject) (obj)).getString("id"), ((JSONObject) (obj)).getString("rss_portal"), ((JSONObject) (obj)).getString("rss_img_ava"), ((JSONObject) (obj)).getString("rss_title"), ((JSONObject) (obj)).getString("rss_desc"), ((JSONObject) (obj)).getString("rss_content"), ((JSONObject) (obj)).getString("rss_img"), ((JSONObject) (obj)).getString("rss_srclink"), ((JSONObject) (obj)).getString("rss_date"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_like"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_komen"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_like_rss"));
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
            Log.e("mArrayListDataRSS", String.valueOf(mArrayListDataRSS.size()));
            progressbar_RSSFav.setVisibility(8);
            mLinearListViewRSS.removeAllViewsInLayout();
            mLinearListViewRSS.removeAllViews();
            if (mArrayListDataRSS.size() <= 0)
            {
                break MISSING_BLOCK_LABEL_1420;
            }
            txt_empty_RSS.setVisibility(8);
            int i = 0;
_L7:
            ImageView imageview;
            ImageView imageview1;
            TextView textview;
            final String id_rss;
            final String rss_id;
            final String rss_title;
            final String rss_portal;
            final String rss_desc;
            final String rss_content;
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
                if (i >= mArrayListDataRSS.size())
                {
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
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
            id_rss = ((ItemRSS)mArrayListDataRSS.get(i)).getId();
            rss_id = ((ItemRSS)mArrayListDataRSS.get(i)).getRss_id();
            rss_title = ((ItemRSS)mArrayListDataRSS.get(i)).getRss_title();
            rss_portal = ((ItemRSS)mArrayListDataRSS.get(i)).getRss_portal();
            rss_desc = ((ItemRSS)mArrayListDataRSS.get(i)).getRss_desc();
            rss_content = ((ItemRSS)mArrayListDataRSS.get(i)).getRss_content();
            rss_srclink = ((ItemRSS)mArrayListDataRSS.get(i)).getRss_srclink();
            rss_date = ((ItemRSS)mArrayListDataRSS.get(i)).getRss_date();
            rss_img_ava = ((ItemRSS)mArrayListDataRSS.get(i)).getRss_img_ava();
            rss_img = ((ItemRSS)mArrayListDataRSS.get(i)).getRss_img();
            total_like = ((ItemRSS)mArrayListDataRSS.get(i)).getRss_tot_like();
            like_stat = ((ItemRSS)mArrayListDataRSS.get(i)).getRss_like_stat();
            total_komen = ((ItemRSS)mArrayListDataRSS.get(i)).getRss_tot_komen();
            s = ((ItemRSS)mArrayListDataRSS.get(i)).getRss_fav_stat();
            textview.setText(s);
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
            imageview.setBackgroundResource(0x7f02025b);
            list_lay_like.setEnabled(false);
            list_lay_dislike.setEnabled(true);
_L8:
            if (!s.toString().equals("1")) goto _L4; else goto _L3
_L3:
            imageview1.setBackgroundResource(0x7f020303);
_L9:
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)mArrayListDataRSS.get(i)).getRss_img_ava().toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
            if (!((ItemRSS)mArrayListDataRSS.get(i)).getRss_img().trim().equals("")) goto _L6; else goto _L5
_L5:
            imageMedia.setVisibility(8);
_L10:
            txtWaktu.setText(Utility.convertDate(((ItemRSS)mArrayListDataRSS.get(i)).getRss_date()));
            mLinearListViewRSS.addView(void1);
            imageMedia.setOnClickListener(rss_img. new android.view.View.OnClickListener() {

                final FavoritRSSTask this$1;
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
                this$1 = final_favoritrsstask;
                rss_img = String.this;
                super();
            }
            });
            img_kom_picture.setOnLongClickListener(rss_img_ava. new android.view.View.OnLongClickListener() {

                final FavoritRSSTask this$1;
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
                this$1 = final_favoritrsstask;
                rss_img_ava = String.this;
                super();
            }
            });
            list_lay_like.setOnClickListener(id_rss. new android.view.View.OnClickListener() {

                final FavoritRSSTask this$1;
                private final String val$id_rss;

                public void onClick(View view)
                {
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        statuslike = "1";
                        idrss_pos = id_rss;
                        querylikeRSS = (new StringBuilder("status=")).append(statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                        Log.e("querylikeRSS", querylikeRSS);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new PostBagusKurangRSSTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            return;
                        } else
                        {
                            (new PostBagusKurangRSSTask()).execute(new Void[0]);
                            return;
                        }
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(wrapperLight);
                        view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                        view.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                            final FavoritRSSTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = FavoritRSSTask._cls3.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final FavoritRSSTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = FavoritRSSTask._cls3.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final FavoritRSSTask._cls3 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = FavoritRSSTask._cls3.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_favoritrsstask;
                id_rss = String.this;
                super();
            }
            });
            list_lay_dislike.setOnClickListener(textview. new android.view.View.OnClickListener() {

                final FavoritRSSTask this$1;
                private final String val$id_rss;
                private final String val$rss_srclink;
                private final TextView val$txt_fav_news_1;

                public void onClick(View view)
                {
                    idrss_pos = id_rss;
                    str_srclink = rss_srclink;
                    if (userFunctions.isUserLoggedIn(_fld0))
                    {
                        if (txt_fav_news_1.getText().toString().equals("1"))
                        {
                            view = new android.app.AlertDialog.Builder(_fld0);
                            view.setMessage("Hapus berita ini dari favorit?");
                            view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                                final FavoritRSSTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                    stat = "0";
                                    (new RemFavoritRSSTask()).execute(new Void[0]);
                                }

            
            {
                this$2 = FavoritRSSTask._cls4.this;
                super();
            }
                            });
                            view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final FavoritRSSTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = FavoritRSSTask._cls4.this;
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

                                final FavoritRSSTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    stat = "1";
                                    (new FavoritRSSTask(null)).execute(new String[0]);
                                }

            
            {
                this$2 = FavoritRSSTask._cls4.this;
                super();
            }
                            });
                            view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                                final FavoritRSSTask._cls4 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = FavoritRSSTask._cls4.this;
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

                            final FavoritRSSTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = FavoritRSSTask._cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                            final FavoritRSSTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = FavoritRSSTask._cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                            final FavoritRSSTask._cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                                dialoginterface.putExtra("activity", "main");
                                startActivity(dialoginterface);
                            }

            
            {
                this$2 = FavoritRSSTask._cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    }
                }


            
            {
                this$1 = final_favoritrsstask;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = TextView.this;
                super();
            }
            });
            list_lay_kom.setOnClickListener(s. new android.view.View.OnClickListener() {

                final FavoritRSSTask this$1;
                private final String val$fav_stat;
                private final String val$id_rss;
                private final String val$like_stat;
                private final String val$rss_content;
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
                    idrss_pos = id_rss;
                    view = new Intent(_fld0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                    view.putExtra("actfrom", "bookmark");
                    view.putExtra("rss_id", rss_id);
                    view.putExtra("id_rss", id_rss);
                    view.putExtra("rss_title", rss_title);
                    view.putExtra("rss_portal", rss_portal);
                    view.putExtra("rss_desc", rss_desc);
                    view.putExtra("rss_content", rss_content);
                    view.putExtra("rss_srclink", rss_srclink);
                    view.putExtra("rss_date", rss_date);
                    view.putExtra("rss_img_ava", rss_img_ava);
                    view.putExtra("rss_img", rss_img);
                    view.putExtra("total_like", total_like);
                    view.putExtra("act", "komen");
                    view.putExtra("like_stat", like_stat);
                    view.putExtra("total_komen", total_komen);
                    view.putExtra("fav_stat", fav_stat);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_favoritrsstask;
                id_rss = s;
                rss_id = s1;
                rss_title = s2;
                rss_portal = s3;
                rss_desc = s4;
                rss_content = s5;
                rss_srclink = s6;
                rss_date = s7;
                rss_img_ava = s8;
                rss_img = s9;
                total_like = s10;
                like_stat = s11;
                total_komen = s12;
                fav_stat = String.this;
                super();
            }
            });
            void1.setOnClickListener(s. new android.view.View.OnClickListener() {

                final FavoritRSSTask this$1;
                private final String val$fav_stat;
                private final String val$id_rss;
                private final String val$like_stat;
                private final String val$rss_content;
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
                    idrss_pos = id_rss;
                    view = new Intent(_fld0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                    view.putExtra("actfrom", "bookmark");
                    view.putExtra("rss_id", rss_id);
                    view.putExtra("id_rss", id_rss);
                    view.putExtra("rss_title", rss_title);
                    view.putExtra("rss_portal", rss_portal);
                    view.putExtra("rss_desc", rss_desc);
                    view.putExtra("rss_content", rss_content);
                    view.putExtra("rss_srclink", rss_srclink);
                    view.putExtra("rss_date", rss_date);
                    view.putExtra("rss_img_ava", rss_img_ava);
                    view.putExtra("rss_img", rss_img);
                    view.putExtra("total_like", total_like);
                    view.putExtra("act", "firsttab");
                    view.putExtra("like_stat", like_stat);
                    view.putExtra("total_komen", total_komen);
                    view.putExtra("fav_stat", fav_stat);
                    Log.e("rss_contpush", rss_content);
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                }

            
            {
                this$1 = final_favoritrsstask;
                id_rss = s;
                rss_id = s1;
                rss_title = s2;
                rss_portal = s3;
                rss_desc = s4;
                rss_content = s5;
                rss_srclink = s6;
                rss_date = s7;
                rss_img_ava = s8;
                rss_img = s9;
                total_like = s10;
                like_stat = s11;
                total_komen = s12;
                fav_stat = String.this;
                super();
            }
            });
            i++;
              goto _L7
_L2:
label0:
            {
                if (!like_stat.toString().equals("0"))
                {
                    break label0;
                }
                imageview.setBackgroundResource(0x7f020257);
                imageview1.setBackgroundResource(0x7f0201a7);
                list_lay_like.setEnabled(true);
            }
              goto _L8
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(true);
            imageview.setBackgroundResource(0x7f020257);
            list_lay_like.setBackgroundResource(0x7f020079);
            list_lay_dislike.setBackgroundResource(0x7f020079);
              goto _L8
_L4:
label1:
            {
                if (!s.toString().equals("0"))
                {
                    break label1;
                }
                imageview1.setBackgroundResource(0x7f020302);
            }
              goto _L9
            imageview1.setBackgroundResource(0x7f020302);
              goto _L9
_L6:
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)mArrayListDataRSS.get(i)).getRss_img().toString().trim()).toString(), imageMedia, optionsnonRound, animateFirstListener);
              goto _L10
            progressbar_RSSFav.setVisibility(8);
            txt_empty_RSS.setVisibility(0);
            txt_empty_RSS.setText("Belum ada berita difavoritkan");
            return;
              goto _L8
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            Log.e("KomentarAsycTask", "onPreExecute");
            progressbar_RSSFav.setVisibility(0);
            mArrayListDataRSS.clear();
            db.resetRSSTables();
        }


        private FavoritRSSTask()
        {
            this$0 = FavoritPonselMerek.this;
            super();
        }

        FavoritRSSTask(FavoritRSSTask favoritrsstask)
        {
            this();
        }
    }

    private class FavoritSearchTask extends AsyncTask
    {

        final FavoritPonselMerek this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            {
                avoid = (new ServiceHandler()).makeServiceCall(dataSearch, 1);
                Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
                if (avoid == null)
                {
                    break MISSING_BLOCK_LABEL_264;
                }
                ListModel listmodel;
                int i;
                try
                {
                    avoid = new JSONObject(avoid);
                    inponsel = avoid.getJSONArray("InPonsel");
                    suc = avoid.getString("success");
                    stat = avoid.getString("stat");
                    counterArray = 0;
                    if (!suc.equals("1"))
                    {
                        break MISSING_BLOCK_LABEL_271;
                    }
                    listSearchArrayList.clear();
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_271;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                    break MISSING_BLOCK_LABEL_271;
                }
                i = 0;
            }
            if (i >= inponsel.length())
            {
                break MISSING_BLOCK_LABEL_271;
            }
            avoid = FavoritPonselMerek.this;
            avoid.counterArray = ((FavoritPonselMerek) (avoid)).counterArray + 1;
            avoid = inponsel.getJSONObject(i);
            listmodel = new ListModel();
            listmodel.setUni_id(avoid.getString("id"));
            listmodel.setUni_name(avoid.getString("nama"));
            listmodel.setUni_gambar(avoid.getString("gambar"));
            listmodel.setUni_type(avoid.getString("type"));
            listmodel.setUni_stat(avoid.getString("favorit"));
            listSearchArrayList.add(listmodel);
            i++;
            if (true)
            {
                break MISSING_BLOCK_LABEL_127;
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
                progressbar_search.setVisibility(8);
                listSearchAdapter.notifyDataSetChanged();
                listFindDev.setVisibility(0);
                Log.e("counterArray", String.valueOf(listSearchArrayList.size()));
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
        }

        private FavoritSearchTask()
        {
            this$0 = FavoritPonselMerek.this;
            super();
        }

        FavoritSearchTask(FavoritSearchTask favoritsearchtask)
        {
            this();
        }
    }

    public class ListSearchAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        Drawable drwAdd;
        Drawable drwDel;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        ImageLoader imageLoader2;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        private DisplayImageOptions options;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final FavoritPonselMerek this$0;
        String user;
        UserFunctions userFunctions;
        String username;

        public int getCount()
        {
            return lm.size();
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public ListModel getListModel(int i)
        {
            return (ListModel)lm.get(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            pos = i;
            viewgroup = (LayoutInflater)activity.getSystemService("layout_inflater");
            if (view == null)
            {
                view = viewgroup.inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.img_delete = (ImageView)view.findViewById(0x7f0b0645);
                viewgroup.img_tambah = (ImageView)view.findViewById(0x7f0b0647);
                viewgroup.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
                viewgroup.leftdel = (RelativeLayout)view.findViewById(0x7f0b0480);
                viewgroup.leftadd = (RelativeLayout)view.findViewById(0x7f0b0646);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                drwAdd = getResources().getDrawable(0x7f020240);
                drwAdd.setColorFilter(Color.parseColor("#FFFF5722"), android.graphics.PorterDuff.Mode.SRC_ATOP);
                drwDel = getResources().getDrawable(0x7f0201a1);
                drwDel.setColorFilter(Color.parseColor("#FFFF5722"), android.graphics.PorterDuff.Mode.SRC_ATOP);
                if (android.os.Build.VERSION.SDK_INT < 16)
                {
                    ((ViewHolder) (viewgroup)).img_delete.setBackgroundDrawable(drwDel);
                    ((ViewHolder) (viewgroup)).img_tambah.setBackgroundDrawable(drwAdd);
                } else
                {
                    ((ViewHolder) (viewgroup)).img_delete.setBackground(drwDel);
                    ((ViewHolder) (viewgroup)).img_tambah.setBackground(drwAdd);
                }
                ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_txtMerek.setText(lms.getUni_name());
                if (lms.getUni_stat().equals("1"))
                {
                    ((ViewHolder) (viewgroup)).leftdel.setVisibility(8);
                    ((ViewHolder) (viewgroup)).img_delete.setVisibility(8);
                    ((ViewHolder) (viewgroup)).img_tambah.setVisibility(8);
                    ((ViewHolder) (viewgroup)).leftadd.setVisibility(8);
                } else
                {
                    ((ViewHolder) (viewgroup)).leftdel.setVisibility(8);
                    ((ViewHolder) (viewgroup)).img_delete.setVisibility(8);
                    ((ViewHolder) (viewgroup)).img_tambah.setVisibility(0);
                    ((ViewHolder) (viewgroup)).leftadd.setVisibility(0);
                }
                try
                {
                    imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getUni_gambar().trim()).toString(), ((ViewHolder) (viewgroup)).imageHp, options, viewgroup. new ImageLoadingListener() {

                        final ListSearchAdapter this$1;
                        private final ListSearchAdapter.ViewHolder val$holder;

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
                this$1 = final_listsearchadapter;
                holder = ListSearchAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                catch (Exception exception) { }
                ((ViewHolder) (viewgroup)).leftadd.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListSearchAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        id_hp_del = getListModel(position).getUni_id();
                        uni_type = getListModel(position).getUni_type();
                        Log.e("id_hp_del", id_hp_del);
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle("Peringatan");
                        view.setMessage("Tambahkan ke favorit?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final ListSearchAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statdel = "1";
                                if (netInfo != null && netInfo.isConnected())
                                {
                                    (new ListSearchAdapter.AddDelSearchTask()).execute(new Void[0]);
                                    return;
                                } else
                                {
                                    Toast.makeText(_fld0, "Tidak ada koneksi internet", 1).show();
                                    return;
                                }
                            }

            
            {
                this$2 = ListSearchAdapter._cls2.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final ListSearchAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = ListSearchAdapter._cls2.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = final_listsearchadapter;
                position = I.this;
                super();
            }
                });
            }
            return view;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }



        public ListSearchAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = FavoritPonselMerek.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            username = "";
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = i;
            try
            {
                imageLoader2 = ImageLoader.getInstance();
                imageLoader2.init(ImageLoaderConfiguration.createDefault(FavoritPonselMerek.this));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (FavoritPonselMerek favoritponselmerek)
            {
                return;
            }
        }
    }

    public class ListSearchAdapter.AddDelSearchTask extends AsyncTask
    {

        final ListSearchAdapter this$1;

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
            if (!uni_type.equals("hp")) goto _L2; else goto _L1
_L1:
            querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&stat=").append("1").append("&t=").append(t).toString();
            pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favhp").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
_L4:
            Log.e("pushURL", pushURLdel);
            avoid = HttpPush.getResponse(pushURLdel);
            Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(querydel).toString());
            resdel = avoid.toString();
            Log.e("url ", resdel);
            if (uni_type.equals("hp"))
            {
                resdel = resdel.trim();
                resdel = resdel.replaceAll("\\s+", "");
                Log.e("resdel", resdel);
                break MISSING_BLOCK_LABEL_485;
            }
            break; /* Loop/switch isn't completed */
_L2:
            querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&stat=").append("1").append("&t=").append(t).toString();
            pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_fav_brand").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
            if (true) goto _L4; else goto _L3
_L3:
            try
            {
                parseJSONSubsNews(resdel);
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
            dialog.dismiss();
            if (!uni_type.equals("hp"))
            {
                break MISSING_BLOCK_LABEL_285;
            }
            if (resdel.equals("1") || resdel.equals("10"))
            {
                Toast.makeText(activity, "Berhasil menambahkan", 1).show();
                Log.e("statSubNews", resdel);
                FavoritHPTask();
                ponselBaseApp.getObserver().setUpdateType("sidemenufav");
                ponselBaseApp.getObserver().setLoginStat("1");
                return;
            }
            try
            {
                if (resdel.equals("0") || resdel.equals("00"))
                {
                    Toast.makeText(activity, postMessageSubsNews, 1).show();
                    mDialog.dismiss();
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            }
            Toast.makeText(activity, postMessageSubsNews, 1).show();
            return;
            if (postStatusSubsNews.equals("1") || postStatusSubsNews.equals("10"))
            {
                Toast.makeText(activity, postMessageSubsNews, 1).show();
                Log.e("postStatusSubsNews", postStatusSubsNews);
                FavBrandTask();
                ponselBaseApp.getObserver().setUpdateType("sidemenufav");
                ponselBaseApp.getObserver().setLoginStat("1");
                return;
            }
            if (postStatusSubsNews.equals("00") || postStatusSubsNews.equals("0"))
            {
                Toast.makeText(activity, postMessageSubsNews, 1).show();
                mDialog.dismiss();
                return;
            }
            if (postStatusSubsNews.equals("40404"))
            {
                mDialog.dismiss();
                return;
            }
            Toast.makeText(activity, postMessageSubsNews, 1).show();
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            statusdel = "";
            if (statdel.equals("1"))
            {
                mDialog = ProgressDialog.show(_fld0, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(_fld0, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public ListSearchAdapter.AddDelSearchTask()
        {
            this$1 = ListSearchAdapter.this;
            super();
        }
    }

    class ListSearchAdapter.ViewHolder
    {

        LinearLayout headImage;
        ImageView imageHp;
        ImageView img_delete;
        ImageView img_tambah;
        RelativeLayout leftadd;
        RelativeLayout leftdel;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        final ListSearchAdapter this$1;

        ListSearchAdapter.ViewHolder()
        {
            this$1 = ListSearchAdapter.this;
            super();
        }
    }

    public class ListfavBrandAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        ImageLoader imageLoader2;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        private DisplayImageOptions options;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final FavoritPonselMerek this$0;
        String user;
        UserFunctions userFunctions;
        String username;

        public int getCount()
        {
            return lm.size();
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public ListModel getListModel(int i)
        {
            return (ListModel)lm.get(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            pos = i;
            viewgroup = (LayoutInflater)activity.getSystemService("layout_inflater");
            if (view == null)
            {
                view = viewgroup.inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                viewgroup.imgIklan = (ImageView)view.findViewById(0x7f0b0484);
                viewgroup.headIklan = (LinearLayout)view.findViewById(0x7f0b0482);
                viewgroup.progressbar_item_iklan = (ProgressBar)view.findViewById(0x7f0b0483);
                viewgroup.headHp = (LinearLayout)view.findViewById(0x7f0b0481);
                viewgroup.separator = (LinearLayout)view.findViewById(0x7f0b0340);
                viewgroup.bottom_list = (LinearLayout)view.findViewById(0x7f0b0341);
                viewgroup.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
                viewgroup.list_txtBigRight = (TextView)view.findViewById(0x7f0b034d);
                viewgroup.leftdel = (RelativeLayout)view.findViewById(0x7f0b0480);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                ((ViewHolder) (viewgroup)).bottom_list.setVisibility(8);
                ((ViewHolder) (viewgroup)).separator.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_txtBigRight.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                try
                {
                    imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString(), ((ViewHolder) (viewgroup)).imageHp, options, viewgroup. new ImageLoadingListener() {

                        final ListfavBrandAdapter this$1;
                        private final ListfavBrandAdapter.ViewHolder val$holder;

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
                this$1 = final_listfavbrandadapter;
                holder = ListfavBrandAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                catch (Exception exception) { }
                ((ViewHolder) (viewgroup)).leftdel.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListfavBrandAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        id_hp_del = getListModel(position).getId_hp();
                        Log.e("id_hp_del", id_hp_del);
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle("Peringatan");
                        view.setMessage("Hapus merek ini dari favorit?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final ListfavBrandAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statdel = "0";
                                if (netInfo != null && netInfo.isConnected())
                                {
                                    (new ListfavBrandAdapter.AddDelFavBrandTask()).execute(new Void[0]);
                                    return;
                                } else
                                {
                                    Toast.makeText(_fld0, "Tidak ada koneksi internet", 1).show();
                                    return;
                                }
                            }

            
            {
                this$2 = ListfavBrandAdapter._cls2.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final ListfavBrandAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = ListfavBrandAdapter._cls2.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = final_listfavbrandadapter;
                position = I.this;
                super();
            }
                });
            }
            return view;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }


        public ListfavBrandAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = FavoritPonselMerek.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            username = "";
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = i;
            try
            {
                imageLoader2 = ImageLoader.getInstance();
                imageLoader2.init(ImageLoaderConfiguration.createDefault(FavoritPonselMerek.this));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (FavoritPonselMerek favoritponselmerek)
            {
                return;
            }
        }
    }

    public class ListfavBrandAdapter.AddDelFavBrandTask extends AsyncTask
    {

        final ListfavBrandAdapter this$1;

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
                querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&stat=").append(statusdel).append("&t=").append(t).toString();
                pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_fav_brand").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
                Log.e("pushURL", pushURLdel);
                avoid = HttpPush.getResponse(pushURLdel);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(querydel).toString());
                resdel = avoid.toString();
                Log.e("url ", resdel);
                parseJSONSubsNews(resdel);
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
            if (!postStatusSubsNews.equals("1") && !postStatusSubsNews.equals("10")) goto _L2; else goto _L1
_L1:
            mDialog.dismiss();
            Toast.makeText(_fld0, postMessageSubsNews, 1).show();
            FavBrandTask();
            ponselBaseApp.getObserver().setUpdateType("sidemenufav");
            ponselBaseApp.getObserver().setLoginStat("1");
_L3:
            favBrandAdapter.notifyDataSetChanged();
            return;
_L2:
label0:
            {
                if (!postStatusSubsNews.equals("00") && !postStatusSubsNews.equals("0"))
                {
                    break label0;
                }
                mDialog.dismiss();
                Toast.makeText(_fld0, postMessageSubsNews, 1).show();
            }
              goto _L3
label1:
            {
                if (!resdel.equals("40404"))
                {
                    break label1;
                }
                mDialog.dismiss();
                Toast.makeText(_fld0, postMessageSubsNews, 1).show();
            }
              goto _L3
            try
            {
                Toast.makeText(_fld0, postMessageSubsNews, 1).show();
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L3
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            statusdel = "";
            if (statdel.equals("1"))
            {
                mDialog = ProgressDialog.show(_fld0, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(_fld0, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public ListfavBrandAdapter.AddDelFavBrandTask()
        {
            this$1 = ListfavBrandAdapter.this;
            super();
        }
    }

    class ListfavBrandAdapter.ViewHolder
    {

        LinearLayout bottom_list;
        LinearLayout headHp;
        LinearLayout headIklan;
        LinearLayout headImage;
        ImageView imageHp;
        ImageView imgIklan;
        RelativeLayout leftdel;
        TextView list_txtBigRight;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        ProgressBar progressbar_item_iklan;
        RatingBar rateRate;
        LinearLayout separator;
        final ListfavBrandAdapter this$1;

        ListfavBrandAdapter.ViewHolder()
        {
            this$1 = ListfavBrandAdapter.this;
            super();
        }
    }

    public class ListhpFavoriteAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        DatabaseHandler db;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        ImageLoader imageLoader2;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        private DisplayImageOptions options;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        String t;
        final FavoritPonselMerek this$0;
        String user;
        UserFunctions userFunctions;
        String username;

        public int getCount()
        {
            return lm.size();
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public ListModel getListModel(int i)
        {
            return (ListModel)lm.get(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            pos = i;
            viewgroup = (LayoutInflater)activity.getSystemService("layout_inflater");
            if (view == null)
            {
                view = viewgroup.inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.imageHp = (ImageView)view.findViewById(0x7f0b023d);
                viewgroup.list_txtMerek = (TextView)view.findViewById(0x7f0b033c);
                viewgroup.list_txtHarga = (TextView)view.findViewById(0x7f0b033d);
                viewgroup.progressbar_item = (ProgressBar)view.findViewById(0x7f0b00b3);
                viewgroup.rateRate = (RatingBar)view.findViewById(0x7f0b00c9);
                viewgroup.imgIklan = (ImageView)view.findViewById(0x7f0b0484);
                viewgroup.headIklan = (LinearLayout)view.findViewById(0x7f0b0482);
                viewgroup.progressbar_item_iklan = (ProgressBar)view.findViewById(0x7f0b0483);
                viewgroup.headHp = (LinearLayout)view.findViewById(0x7f0b0481);
                viewgroup.separator = (LinearLayout)view.findViewById(0x7f0b0340);
                viewgroup.bottom_list = (LinearLayout)view.findViewById(0x7f0b0341);
                viewgroup.headImage = (LinearLayout)view.findViewById(0x7f0b029f);
                viewgroup.list_txtBigRight = (TextView)view.findViewById(0x7f0b034d);
                viewgroup.leftdel = (RelativeLayout)view.findViewById(0x7f0b0480);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).list_txtHarga.setVisibility(8);
                ((ViewHolder) (viewgroup)).bottom_list.setVisibility(8);
                ((ViewHolder) (viewgroup)).separator.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_txtBigRight.setVisibility(8);
                ((ViewHolder) (viewgroup)).list_txtMerek.setText((new StringBuilder(String.valueOf(lms.getMerk()))).append(" ").append(lms.getModel()).toString());
                try
                {
                    imageLoader2.displayImage((new StringBuilder(String.valueOf(Util.BASE_PATH_NEWIMAGE))).append(lms.getGambar().trim()).toString(), ((ViewHolder) (viewgroup)).imageHp, options, viewgroup. new ImageLoadingListener() {

                        final ListhpFavoriteAdapter this$1;
                        private final ListhpFavoriteAdapter.ViewHolder val$holder;

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
                this$1 = final_listhpfavoriteadapter;
                holder = ListhpFavoriteAdapter.ViewHolder.this;
                super();
            }
                    });
                }
                catch (Exception exception) { }
                ((ViewHolder) (viewgroup)).leftdel.setOnClickListener(i. new android.view.View.OnClickListener() {

                    final ListhpFavoriteAdapter this$1;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        id_hp_del = getListModel(position).getId_hp();
                        Log.e("id_hp_del", id_hp_del);
                        view = new android.app.AlertDialog.Builder(_fld0);
                        view.setTitle("Peringatan");
                        view.setMessage("Hapus perangkat ini dari favorit?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final ListhpFavoriteAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                statdel = "0";
                                if (netInfo != null && netInfo.isConnected())
                                {
                                    (new ListhpFavoriteAdapter.AddDelFavoritHPTask()).execute(new Void[0]);
                                    return;
                                } else
                                {
                                    Toast.makeText(_fld0, "Tidak ada koneksi internet", 1).show();
                                    return;
                                }
                            }

            
            {
                this$2 = ListhpFavoriteAdapter._cls2.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final ListhpFavoriteAdapter._cls2 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = ListhpFavoriteAdapter._cls2.this;
                super();
            }
                        });
                        view.show();
                    }


            
            {
                this$1 = final_listhpfavoriteadapter;
                position = I.this;
                super();
            }
                });
            }
            return view;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }


        public ListhpFavoriteAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = FavoritPonselMerek.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            t = Utility.session(RestClient.pelihara);
            username = "";
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            t = Utility.session(t);
            lm = arraylist;
            activity = activity1;
            resource = i;
            try
            {
                imageLoader2 = ImageLoader.getInstance();
                imageLoader2.init(ImageLoaderConfiguration.createDefault(FavoritPonselMerek.this));
                options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
                userFunctions = new UserFunctions();
                db = new DatabaseHandler(activity1);
                t = Utility.session(t);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (FavoritPonselMerek favoritponselmerek)
            {
                return;
            }
        }
    }

    public class ListhpFavoriteAdapter.AddDelFavoritHPTask extends AsyncTask
    {

        final ListhpFavoriteAdapter this$1;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                querydel = (new StringBuilder("idhp=")).append(id_hp_del).append("&idusr=").append(user_id).append("&stat=").append(statusdel).append("&t=").append(t).toString();
                pushURLdel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favhp").append(Utility.BASE_FORMAT).append("?").append(querydel).toString();
                Log.e("pushURL", pushURLdel);
                avoid = HttpPush.getResponse(pushURLdel);
                Log.e("push", (new StringBuilder(String.valueOf(avoid))).append(querydel).toString());
                resdel = avoid.toString();
                Log.e("url ", resdel);
                resdel = resdel.trim();
                resdel = resdel.replaceAll("\\s+", "");
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
            if (!resdel.equals("1") && !resdel.equals("10"))
            {
                break MISSING_BLOCK_LABEL_196;
            }
            db.addHP(id_hp_del, merk, model, gambar, codename);
            if (db.getHPCount() <= 0)
            {
                break MISSING_BLOCK_LABEL_177;
            }
            Toast.makeText(_fld0, "Berhasil menambahkan", 1).show();
_L1:
            mDialog.dismiss();
            ponselBaseApp.getObserver().setUpdateType("sidemenufav");
            ponselBaseApp.getObserver().setLoginStat("1");
            return;
            try
            {
                Toast.makeText(_fld0, "Gagal menambahkan", 1).show();
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            if (!resdel.equals("00") && !resdel.equals("0"))
            {
                break MISSING_BLOCK_LABEL_344;
            }
            db.deleteHP(id_hp_del);
            loadDataHP();
            hpFavoriteAdapter.notifyDataSetChanged();
            if (db.checkIfExist(id_hp_del))
            {
                break MISSING_BLOCK_LABEL_325;
            }
            Toast.makeText(_fld0, "Berhasil menghapus", 1).show();
_L3:
            mDialog.dismiss();
            return;
            Toast.makeText(_fld0, "Berhasil menghapus", 1).show();
            if (true) goto _L3; else goto _L2
_L2:
            if (resdel.equals("40404"))
            {
                mDialog.dismiss();
                return;
            }
            Toast.makeText(_fld0, "Gagal menambahkan", 1).show();
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            statusdel = "";
            if (statdel.equals("1"))
            {
                mDialog = ProgressDialog.show(_fld0, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(_fld0, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public ListhpFavoriteAdapter.AddDelFavoritHPTask()
        {
            this$1 = ListhpFavoriteAdapter.this;
            super();
        }
    }

    class ListhpFavoriteAdapter.ViewHolder
    {

        LinearLayout bottom_list;
        LinearLayout headHp;
        LinearLayout headIklan;
        LinearLayout headImage;
        ImageView imageHp;
        ImageView imgIklan;
        RelativeLayout leftdel;
        TextView list_txtBigRight;
        TextView list_txtHarga;
        TextView list_txtMerek;
        ProgressBar progressbar_item;
        ProgressBar progressbar_item_iklan;
        RatingBar rateRate;
        LinearLayout separator;
        final ListhpFavoriteAdapter this$1;

        ListhpFavoriteAdapter.ViewHolder()
        {
            this$1 = ListhpFavoriteAdapter.this;
            super();
        }
    }

    public class PostBagusKurangRSSTask extends AsyncTask
    {

        final FavoritPonselMerek this$0;

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
            ponselBaseApp.getObserver().setIndexRSS(idrss_pos);
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
                avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("likedis_rss.php?").append(querylikeRSS).toString();
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
            notificationLikeHelperRSS.completed("RSS Berita", notificationLikeHelperRSS.suclikefrontKomen);
_L1:
            Log.e("mArrayListDataTW", String.valueOf(mArrayListDataRSS.size()));
            Log.e("index_komposlike", idkom_pos);
            updateViewLikeDisRSS(idrss_pos);
            return;
            try
            {
                notificationLikeHelperRSS.completed("RSS Berita", notificationLikeHelperRSS.sucdislikefrontKomen);
            }
            // Misplaced declaration of an exception variable
            catch (Void void1)
            {
                return;
            }
              goto _L1
            if (statuslike.equals("1"))
            {
                notificationLikeHelperRSS.gagal("RSS Berita", notificationLikeHelperRSS.gaglikefrontKomen);
                return;
            }
            notificationLikeHelperRSS.gagal("RSS Berita", notificationLikeHelperRSS.gagdislikefrontKomen);
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (statuslike.equals("1"))
            {
                notificationLikeHelperRSS.createNotification("RSS Berita", notificationLikeHelperRSS.likefrontKomen);
                return;
            } else
            {
                notificationLikeHelperRSS.createNotification("RSS Berita", notificationLikeHelperRSS.dislikefrontKomen);
                return;
            }
        }

        public PostBagusKurangRSSTask()
        {
            this$0 = FavoritPonselMerek.this;
            super();
        }
    }

    public class RemFavoritRSSTask extends AsyncTask
    {

        final FavoritPonselMerek this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            try
            {
                avoid = (new StringBuilder("idrss=")).append(idrss_pos).append("&idusr=").append(user_id).append("&stat=").append(stat).append("&t=").append(t).toString();
                String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("add_favrss").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
                Log.e("pushURL", s);
                s = HttpPush.getResponse(s);
                Log.e("push", (new StringBuilder(String.valueOf(s))).append(avoid).toString());
                res = s.toString();
                Log.e("url ", res);
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
            mDialog.cancel();
            db.deleteIDRSS(idrss_pos);
            FavoritRSSTask();
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            if (stat.equals("1"))
            {
                mDialog = ProgressDialog.show(FavoritPonselMerek.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(FavoritPonselMerek.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public RemFavoritRSSTask()
        {
            this$0 = FavoritPonselMerek.this;
            super();
        }
    }


    ActionBar actionBar;
    int actionBarTitleId;
    private ImageLoadingListener animateFirstListener;
    String bottom_id;
    LinearLayout bottom_list;
    Button btnSubmitHp;
    int charCount;
    ConnectivityManager cm;
    String codename;
    int countAllKom;
    int countKomOld;
    int count_all_favbrand;
    int count_first_favbrand;
    int counterArray;
    Cursor cursor;
    String dataBrand;
    String dataFav;
    String dataFavRSS;
    String dataSearch;
    DatabaseHandler db;
    Dialog dialog;
    EditText edtAuto;
    EditText edtHpKetik;
    String email_user;
    ListfavBrandAdapter favBrandAdapter;
    ArrayList favBrandArray;
    String fav_stat;
    String gambar;
    ListhpFavoriteAdapter hpFavoriteAdapter;
    ArrayList hpFavoriteArray;
    String id_hp_del;
    String id_hph;
    String idkom_pos;
    String idrss_pos;
    ImageLoader imageLoader2;
    ImageView imageMedia;
    ImageView img_fav_apps_1;
    ImageView img_kat_apps_1;
    ImageView img_kom_picture;
    ImageView img_like_apps_1;
    JSONArray inponsel;
    JSONArray jArray;
    String jum_komen;
    LinearLayout lay_quote;
    LinearLayout layout_empty;
    ListView listFindDev;
    ExpandableHeightGridView listHp;
    LinearLayout listKategoriAdsApps;
    ExpandableHeightGridView listMerek;
    ListSearchAdapter listSearchAdapter;
    ArrayList listSearchArrayList;
    RelativeLayout list_lay_dislike;
    RelativeLayout list_lay_kom;
    RelativeLayout list_lay_like;
    LinearLayout ll_fav_apps;
    LinearLayout ll_kat_apps_1;
    private ArrayList mArrayListDataRSS;
    private ArrayList mArrayListRSSData;
    ProgressDialog mDialog;
    private LinearLayout mLinearListViewRSS;
    String merk;
    String model;
    String nama_asli;
    String namalengkap;
    NetworkInfo netInfo;
    NotificationLikeHelper notificationLikeHelper;
    NotificationLikeRSSHelper notificationLikeHelperRSS;
    private DisplayImageOptions options;
    private DisplayImageOptions optionsnonRound;
    PonselBaseApp ponselBaseApp;
    String postMessageLikeKom;
    String postMessageSubsNews;
    String postStatusLikeKom;
    String postStatusSubsNews;
    ProgressBar progressbar_RSSFav;
    ProgressBar progressbar_middle;
    ProgressBar progressbar_middle_dialog;
    ProgressBar progressbar_search;
    String pushURL;
    String pushURLdel;
    String querydel;
    String querylike;
    String querylikeRSS;
    String res;
    String resdel;
    String reslike;
    LinearLayout rl_like_apps;
    ScrollView scrolView;
    String stat;
    String statSubNews;
    String statdel;
    String statusdel;
    String statuslike;
    String strKonekStat;
    String str_srclink;
    String suc;
    String succesStat;
    String t;
    String top_id;
    String tot_LikeKom;
    String tot_LikePon;
    String tot_LikeRSS;
    String totdis_LikeKom;
    String totdis_LikePon;
    TextView txtEmpty;
    TextView txtFavDevice;
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
    TextView txt_empty;
    TextView txt_empty_RSS;
    TextView txt_fav_kat_apps_1;
    TextView txt_id_applist;
    TextView txt_kat_apps_1;
    TextView txt_like_kat_apps_1;
    TextView txt_sub_kat_apps_1;
    TextView txtdisLikeKom;
    String uni_type;
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
    ContextThemeWrapper wrapperLight;

    public FavoritPonselMerek()
    {
        id_hp_del = "";
        uni_type = "";
        pushURL = "";
        statSubNews = "";
        favBrandArray = null;
        dataBrand = "";
        count_first_favbrand = 0;
        count_all_favbrand = 0;
        inponsel = null;
        suc = "";
        stat = "";
        hpFavoriteArray = null;
        dataSearch = "";
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
        listSearchArrayList = null;
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        dataFavRSS = "";
        countKomOld = 0;
        countAllKom = 0;
        bottom_id = "";
        top_id = "0";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        strKonekStat = "";
        idkom_pos = "";
        idrss_pos = "";
        str_srclink = "";
        animateFirstListener = new AnimateFirstDisplayListener();
        querylike = "";
        querylikeRSS = "";
        res = "";
        urlKategori2 = "";
        fav_stat = "";
    }

    private void load_FavKategoriApps()
    {
        urlKategori2 = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("list_kategori_fav").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&bottom_id=0").toString();
        Log.e("urlKategoriMore", urlKategori2);
        (new AsyncHttpClient()).get(urlKategori2, new AsyncHttpResponseHandler() {

            final FavoritPonselMerek this$0;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
            }

            public void onRetry(int i)
            {
            }

            public void onStart()
            {
                mArrayListRSSData.clear();
                listKategoriAdsApps.removeAllViews();
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
                if (!succesStat.equals("1")) goto _L5; else goto _L4
_L4:
                i = 0;
_L7:
                if (i < mArrayListRSSData.size())
                {
                    break MISSING_BLOCK_LABEL_295;
                }
                listKategoriAdsApps.setVisibility(0);
_L5:
                return;
_L3:
                id = aheader.getJSONObject(i);
                mArrayListRSSData.add(new ItemKategoriAppsGames(id.getString("id"), id.getString("kategori"), id.getString("tag"), id.getString("type"), id.getString("deskripsi"), id.getString("place"), id.getString("position"), id.getString("background"), id.getString("background_img"), id.getString("width"), id.getString("height"), id.getString("myfav"), id.getString("mod_date"), id.getString("total_like"), ""));
                i++;
                  goto _L6
                aheader;
                aheader.printStackTrace();
                strKonekStat = "0";
                  goto _L2
                aheader;
                aheader.printStackTrace();
                  goto _L2
                aheader = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03013e, null);
                id = aheader.findViewById(0x7f0b0868);
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
                id = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getId();
                final String kategori = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getkategori();
                final String tag = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).gettag();
                final String type = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).gettype();
                final String deskripsi = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getdeskripsi();
                final String background = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getposition();
                final String background_img = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getplace();
                Log.e("posplace", (new StringBuilder(String.valueOf(background))).append("-").append(background_img).append("-").append(i).toString());
                background = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getbackground();
                background_img = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getbackground_img();
                final String width = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getwidth();
                final String height = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getheight();
                final String myfav = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getmyfav();
                final String mod_date = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).getmod_date();
                final String total_like = ((ItemKategoriAppsGames)mArrayListRSSData.get(i)).gettotal_like();
                Display display;
                DisplayMetrics displaymetrics;
                int k;
                int l;
                int i1;
                if (myfav.equals("1"))
                {
                    img_fav_apps_1.setBackgroundResource(0x7f020303);
                } else
                {
                    img_fav_apps_1.setBackgroundResource(0x7f020302);
                }
                ll_kat_apps_1.setVisibility(0);
                txt_id_applist.setText(id);
                txt_fav_kat_apps_1.setText(myfav);
                txt_kat_apps_1.setText(kategori);
                txt_sub_kat_apps_1.setText(deskripsi);
                txt_like_kat_apps_1.setText(total_like);
                display = ((WindowManager)getSystemService("window")).getDefaultDisplay();
                displaymetrics = new DisplayMetrics();
                display.getMetrics(displaymetrics);
                k = displaymetrics.widthPixels - (int)Utility.convertDpToPixel(10F, FavoritPonselMerek.this);
                l = displaymetrics.heightPixels;
                i1 = (int)Utility.convertDpToPixel(10F, FavoritPonselMerek.this);
                img_kat_apps_1.setLayoutParams(new android.widget.LinearLayout.LayoutParams(k, Math.min((int)(((double)k / (double)Integer.parseInt(width)) * (double)Integer.parseInt(height)), (l - i1) / 3)));
                if (background_img.contains(".jpeg") || background_img.contains(".jpg") || background_img.contains(".png"))
                {
                    img_kat_apps_1.setBackgroundColor(Color.parseColor(background));
                    Picasso.with(FavoritPonselMerek.this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(k).append("&src=").append(background_img.trim()).toString()).tag(this).into(img_kat_apps_1, new Callback() {

                        final _cls10 this$1;

                        public void onError()
                        {
                        }

                        public void onSuccess()
                        {
                            img_kat_apps_1.setVisibility(0);
                        }

            
            {
                this$1 = _cls10.this;
                super();
            }
                    });
                } else
                {
                    img_kat_apps_1.setBackgroundColor(Color.parseColor(background));
                }
                listKategoriAdsApps.addView(aheader);
                aheader.setOnClickListener(myfav. new android.view.View.OnClickListener() {

                    final _cls10 this$1;
                    private final String val$background;
                    private final String val$background_img;
                    private final String val$deskripsi;
                    private final String val$height;
                    private final String val$id;
                    private final String val$kategori;
                    private final String val$mod_date;
                    private final String val$myfav;
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
                        view.putExtra("myfav", myfav);
                        startActivityForResult(view, 0);
                        overridePendingTransition(0x7f040003, 0x7f040004);
                    }

            
            {
                this$1 = final__pcls10;
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
                type = s10;
                myfav = String.this;
                super();
            }
                });
                ll_fav_apps.setOnClickListener(kategori. new android.view.View.OnClickListener() {

                    final _cls10 this$1;
                    private final String val$id;
                    private final String val$kategori;
                    private final String val$myfav;

                    public void onClick(final View urlPost)
                    {
                        Log.e("postfav", myfav);
                        Log.e("id", id);
                        Log.e("kategori", kategori);
                        fav_stat = "0";
                        urlPost = (new StringBuilder(String.valueOf(Util.BASE_PATH_STORE))).append("add_fav_applist.php?").append("t=").append(t).append("&id_user=").append(user_id).append("&status=").append(fav_stat).append("&id_kat=").append(id).toString();
                        (new AsyncHttpClient()).get(urlPost, id. new AsyncHttpResponseHandler() {

                            final _cls3 this$2;
                            private final String val$id;
                            private final String val$kategori;
                            private final String val$urlPost;

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
                                } else
                                {
                                    notificationLikeHelper.createNotification(kategori, "Menghapus ke favorit");
                                }
                                Log.e("urlPost", urlPost);
                            }

                            public void onSuccess(int i, Header aheader[], byte abyte0[])
                            {
                                aheader = new String(abyte0);
                                Log.e("respJson", aheader);
                                try
                                {
                                    aheader = new JSONObject(aheader);
                                    fav_stat = aheader.getString("success");
                                }
                                // Misplaced declaration of an exception variable
                                catch (Header aheader[]) { }
                                load_FavKategoriApps();
                                if (fav_stat.equals("1"))
                                {
                                    notificationLikeHelper.completed(kategori, "Berhasil menambahkan ke favorit");
                                } else
                                {
                                    notificationLikeHelper.completed(kategori, "Berhasil menghapus ke favorit");
                                }
                                ponselBaseApp.setObserver().setIndexHp(id);
                                ponselBaseApp.setObserver().setUpdateType("favappsstore");
                                ponselBaseApp.setObserver().setStatus_like_ponsel(fav_stat);
                            }

            
            {
                this$2 = final__pcls3;
                kategori = s;
                urlPost = s1;
                id = String.this;
                super();
            }
                        });
                    }


            
            {
                this$1 = final__pcls10;
                myfav = s;
                id = s1;
                kategori = String.this;
                super();
            }
                });
                i++;
                  goto _L7
            }


            
            {
                this$0 = FavoritPonselMerek.this;
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

    public void FavBrandTask()
    {
        dataBrand = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_fav_brand").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&lmt=1").toString();
        Log.e("dataBrand", dataBrand);
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

    public void FavoritHPTask()
    {
        dataFav = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_favhp").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&t=").append(t).toString();
        Log.e("dataFav", dataFav);
        FavoritHPTask favorithptask = new FavoritHPTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            favorithptask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            favorithptask.execute(new Void[0]);
            return;
        }
    }

    public void FavoritRSSTask()
    {
        dataFavRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_reader_fav").append(Utility.BASE_FORMAT).append("?").append("lmt=").append("0").append("&t=").append(t).append("&idusr=").append(user_id).toString();
        Log.e("dataFavRSS", dataFavRSS);
        FavoritRSSTask favoritrsstask = new FavoritRSSTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            favoritrsstask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        } else
        {
            favoritrsstask.execute(new String[0]);
            return;
        }
    }

    public void FavoritSearchTask(String s)
    {
        dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_favorit_union").append(Utility.BASE_FORMAT).append("?id_user=").append(user_id).append("&key=").append(s).append("&t=").append(t).toString();
        Log.e("dataSearch", dataSearch);
        s = new FavoritSearchTask(null);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            s.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            s.execute(new Void[0]);
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

    public void loadDataHP()
    {
        if (hpFavoriteArray.size() == 0)
        {
            txt_empty.setVisibility(0);
            txt_empty.setText("Belum ada ponsel difavoritkan");
        } else
        {
            txt_empty.setVisibility(8);
        }
        progressbar_middle.setVisibility(8);
        if (netInfo != null && netInfo.isConnected())
        {
            FavoritHPTask();
        }
    }

    public ArrayList loadHpDB()
    {
        ArrayList arraylist;
        Cursor cursor1;
        arraylist = new ArrayList();
        cursor1 = db.getHPData();
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_181;
        }
        do
        {
            id_hph = String.valueOf(cursor1.getString(1));
            merk = String.valueOf(cursor1.getString(2));
            model = String.valueOf(cursor1.getString(3));
            gambar = String.valueOf(cursor1.getString(4));
            codename = String.valueOf(cursor1.getString(5));
            ListModel listmodel = new ListModel();
            listmodel.setId_hp(id_hph);
            listmodel.setMerk(merk);
            listmodel.setModel(model);
            listmodel.setGambar(gambar);
            listmodel.setCodename(codename);
            arraylist.add(listmodel);
        } while (cursor1.moveToNext());
        Log.e("bookmark", String.valueOf(arraylist.size()));
        listHp.setVisibility(0);
        return arraylist;
        try
        {
            Log.e("bookmark", "nol");
            progressbar_middle.setVisibility(8);
            txt_empty.setVisibility(0);
            txt_empty.setText("Belum ada ponsel difavoritkan");
        }
        catch (Exception exception)
        {
            return arraylist;
        }
        return arraylist;
    }

    public ArrayList loadRSSDB()
    {
        ArrayList arraylist;
        Cursor cursor1;
        arraylist = new ArrayList();
        cursor1 = db.getRSSData();
        if (!cursor1.moveToFirst()) goto _L2; else goto _L1
_L1:
        View view;
        ImageView imageview;
        ImageView imageview1;
        final TextView txt_fav_news_1;
        final String id_rss;
        final String rss_id;
        final String rss_title;
        final String rss_portal;
        final String rss_desc;
        final String rss_content;
        final String rss_srclink;
        final String rss_date;
        final String rss_img_ava;
        final String rss_img;
        final String total_like;
        final String like_stat;
        final String total_komen;
        arraylist.add(new ItemRSS(cursor1.getString(1), cursor1.getString(1), cursor1.getString(4), cursor1.getString(2), cursor1.getString(5), cursor1.getString(6), cursor1.getString(8), cursor1.getString(9), cursor1.getString(3), cursor1.getString(7), cursor1.getString(10), cursor1.getString(11), "", cursor1.getString(12), "1"));
        view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300c5, null);
        txtUsername = (TextView)view.findViewById(0x7f0b0419);
        txtTitle = (TextView)view.findViewById(0x7f0b05ec);
        img_kom_picture = (ImageView)view.findViewById(0x7f0b054b);
        imageMedia = (ImageView)view.findViewById(0x7f0b046c);
        txtIdKom = (TextView)view.findViewById(0x7f0b054d);
        txtKomentar = (TextView)view.findViewById(0x7f0b054e);
        txtWaktu = (TextView)view.findViewById(0x7f0b054c);
        txtImgAva = (TextView)view.findViewById(0x7f0b05e9);
        txtImgMedia = (TextView)view.findViewById(0x7f0b05ea);
        imageview = (ImageView)view.findViewById(0x7f0b054f);
        imageview1 = (ImageView)view.findViewById(0x7f0b0552);
        txtLikeKom = (TextView)view.findViewById(0x7f0b0551);
        txtdisLikeKom = (TextView)view.findViewById(0x7f0b0554);
        txtTotalKom = (TextView)view.findViewById(0x7f0b034a);
        bottom_list = (LinearLayout)view.findViewById(0x7f0b0341);
        list_lay_like = (RelativeLayout)view.findViewById(0x7f0b0342);
        list_lay_dislike = (RelativeLayout)view.findViewById(0x7f0b0345);
        list_lay_kom = (RelativeLayout)view.findViewById(0x7f0b0348);
        txt_fav_news_1 = (TextView)view.findViewById(0x7f0b0650);
        id_rss = cursor1.getString(1);
        rss_id = cursor1.getString(1);
        rss_title = cursor1.getString(4);
        rss_portal = cursor1.getString(2);
        rss_desc = cursor1.getString(5);
        rss_content = cursor1.getString(6);
        rss_srclink = cursor1.getString(8);
        rss_date = cursor1.getString(9);
        rss_img_ava = cursor1.getString(3);
        rss_img = cursor1.getString(7);
        total_like = cursor1.getString(10);
        like_stat = cursor1.getString(11);
        total_komen = cursor1.getString(12);
        txt_fav_news_1.setText("1");
        txtTitle.setText(Html.fromHtml(rss_title));
        txtIdKom.setText(id_rss);
        txtUsername.setText(rss_portal);
        txtImgAva.setText(rss_img_ava);
        txtImgMedia.setText(rss_img);
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(rss_desc)));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
        txtLikeKom.setText(total_like);
        txtTotalKom.setText(total_komen);
        if (!like_stat.toString().equals("1")) goto _L4; else goto _L3
_L3:
        imageview.setBackgroundResource(0x7f02025b);
        list_lay_like.setEnabled(false);
        list_lay_dislike.setEnabled(true);
_L10:
        if (!"1".toString().equals("1")) goto _L6; else goto _L5
_L5:
        imageview1.setBackgroundResource(0x7f020303);
_L11:
        imageLoader2.displayImage((new StringBuilder()).append(rss_img_ava.toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
        if (!rss_img.trim().equals("")) goto _L8; else goto _L7
_L7:
        imageMedia.setVisibility(8);
_L12:
        txtWaktu.setText(Utility.convertDate(rss_date));
        mLinearListViewRSS.addView(view);
        imageMedia.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritPonselMerek this$0;
            private final String val$rss_img;

            public void onClick(View view1)
            {
                view1 = new ArrayList();
                view1.add(rss_img);
                view1 = (String[])view1.toArray(new String[view1.size()]);
                Intent intent = new Intent(FavoritPonselMerek.this, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view1);
                intent.putExtra("pos", 0);
                startActivity(intent);
            }

            
            {
                this$0 = FavoritPonselMerek.this;
                rss_img = s;
                super();
            }
        });
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final FavoritPonselMerek this$0;
            private final String val$rss_img_ava;

            public boolean onLongClick(View view1)
            {
                view1 = new ArrayList();
                view1.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(rss_img_ava.toString().trim()).toString());
                view1 = (String[])view1.toArray(new String[view1.size()]);
                Intent intent = new Intent(FavoritPonselMerek.this, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view1);
                intent.putExtra("pos", 0);
                startActivity(intent);
                return false;
            }

            
            {
                this$0 = FavoritPonselMerek.this;
                rss_img_ava = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritPonselMerek this$0;
            private final String val$id_rss;

            public void onClick(View view1)
            {
                if (userFunctions.isUserLoggedIn(FavoritPonselMerek.this))
                {
                    statuslike = "1";
                    idrss_pos = id_rss;
                    querylikeRSS = (new StringBuilder("status=")).append(statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylikeRSS", querylikeRSS);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new PostBagusKurangRSSTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new PostBagusKurangRSSTask()).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    view1 = new android.app.AlertDialog.Builder(wrapperLight);
                    view1.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
                    view1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

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
                    view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls6 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls6 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    view1.show();
                    return;
                }
            }


            
            {
                this$0 = FavoritPonselMerek.this;
                id_rss = s;
                super();
            }
        });
        list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritPonselMerek this$0;
            private final String val$id_rss;
            private final String val$rss_srclink;
            private final TextView val$txt_fav_news_1;

            public void onClick(View view1)
            {
                idrss_pos = id_rss;
                str_srclink = rss_srclink;
                if (userFunctions.isUserLoggedIn(FavoritPonselMerek.this))
                {
                    if (txt_fav_news_1.getText().toString().equals("1"))
                    {
                        view1 = new android.app.AlertDialog.Builder(FavoritPonselMerek.this);
                        view1.setMessage("Hapus berita ini dari favorit?");
                        view1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls7 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                                stat = "0";
                                if (netInfo != null && netInfo.isConnected())
                                {
                                    (new RemFavoritRSSTask()).execute(new Void[0]);
                                    return;
                                } else
                                {
                                    Toast.makeText(_fld0, "Tidak ada koneksi internet", 1).show();
                                    return;
                                }
                            }

            
            {
                this$1 = _cls7.this;
                super();
            }
                        });
                        view1.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls7 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls7.this;
                super();
            }
                        });
                        view1.show();
                        return;
                    } else
                    {
                        view1 = new android.app.AlertDialog.Builder(FavoritPonselMerek.this);
                        view1.setMessage("Favoritkan berita ini?");
                        view1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls7 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                stat = "1";
                                (new FavoritRSSTask(null)).execute(new String[0]);
                            }

            
            {
                this$1 = _cls7.this;
                super();
            }
                        });
                        view1.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls7 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls7.this;
                super();
            }
                        });
                        view1.show();
                        return;
                    }
                } else
                {
                    view1 = new android.app.AlertDialog.Builder(wrapperLight);
                    view1.setMessage("Untuk menambahkan ke favorit harus login terlebih dahulu.");
                    view1.setPositiveButton("Tutup", new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    });
                    view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    });
                    view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls7 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    });
                    view1.show();
                    return;
                }
            }


            
            {
                this$0 = FavoritPonselMerek.this;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = textview;
                super();
            }
        });
        list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritPonselMerek this$0;
            private final String val$id_rss;
            private final String val$like_stat;
            private final String val$rss_content;
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

            public void onClick(View view1)
            {
                idrss_pos = id_rss;
                view1 = new Intent(FavoritPonselMerek.this, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                view1.putExtra("actfrom", "bookmark");
                view1.putExtra("rss_id", rss_id);
                view1.putExtra("id_rss", id_rss);
                view1.putExtra("rss_title", rss_title);
                view1.putExtra("rss_portal", rss_portal);
                view1.putExtra("rss_desc", rss_desc);
                view1.putExtra("rss_content", rss_content);
                view1.putExtra("rss_srclink", rss_srclink);
                view1.putExtra("rss_date", rss_date);
                view1.putExtra("rss_img_ava", rss_img_ava);
                view1.putExtra("rss_img", rss_img);
                view1.putExtra("total_like", total_like);
                view1.putExtra("act", "komen");
                view1.putExtra("like_stat", like_stat);
                view1.putExtra("total_komen", total_komen);
                view1.putExtra("fav_stat", "1");
                startActivityForResult(view1, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = FavoritPonselMerek.this;
                id_rss = s;
                rss_id = s1;
                rss_title = s2;
                rss_portal = s3;
                rss_desc = s4;
                rss_content = s5;
                rss_srclink = s6;
                rss_date = s7;
                rss_img_ava = s8;
                rss_img = s9;
                total_like = s10;
                like_stat = s11;
                total_komen = s12;
                super();
            }
        });
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritPonselMerek this$0;
            private final String val$id_rss;
            private final String val$like_stat;
            private final String val$rss_content;
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

            public void onClick(View view1)
            {
                idrss_pos = id_rss;
                view1 = new Intent(FavoritPonselMerek.this, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                view1.putExtra("actfrom", "bookmark");
                view1.putExtra("rss_id", rss_id);
                view1.putExtra("id_rss", id_rss);
                view1.putExtra("rss_title", rss_title);
                view1.putExtra("rss_portal", rss_portal);
                view1.putExtra("rss_desc", rss_desc);
                view1.putExtra("rss_content", rss_content);
                view1.putExtra("rss_srclink", rss_srclink);
                view1.putExtra("rss_date", rss_date);
                view1.putExtra("rss_img_ava", rss_img_ava);
                view1.putExtra("rss_img", rss_img);
                view1.putExtra("total_like", total_like);
                view1.putExtra("act", "firsttab");
                view1.putExtra("like_stat", like_stat);
                view1.putExtra("total_komen", total_komen);
                view1.putExtra("fav_stat", "1");
                startActivityForResult(view1, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = FavoritPonselMerek.this;
                id_rss = s;
                rss_id = s1;
                rss_title = s2;
                rss_portal = s3;
                rss_desc = s4;
                rss_content = s5;
                rss_srclink = s6;
                rss_date = s7;
                rss_img_ava = s8;
                rss_img = s9;
                total_like = s10;
                like_stat = s11;
                total_komen = s12;
                super();
            }
        });
        if (cursor1.moveToNext()) goto _L1; else goto _L9
_L9:
        return arraylist;
_L4:
        Exception exception;
label0:
        {
            if (!like_stat.toString().equals("0"))
            {
                break label0;
            }
            imageview.setBackgroundResource(0x7f020257);
            imageview1.setBackgroundResource(0x7f0201a7);
            list_lay_like.setEnabled(true);
        }
          goto _L10
        try
        {
            list_lay_like.setEnabled(true);
            list_lay_dislike.setEnabled(true);
            imageview.setBackgroundResource(0x7f020257);
            list_lay_like.setBackgroundResource(0x7f020079);
            list_lay_dislike.setBackgroundResource(0x7f020079);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            txt_empty_RSS.setVisibility(0);
            txt_empty_RSS.setText("Belum ada berita difavoritkan");
            return arraylist;
        }
          goto _L10
_L6:
label1:
        {
            if (!"1".toString().equals("0"))
            {
                break label1;
            }
            imageview1.setBackgroundResource(0x7f020302);
        }
          goto _L11
        imageview1.setBackgroundResource(0x7f020302);
          goto _L11
_L8:
        imageLoader2.displayImage((new StringBuilder()).append(rss_img.toString().trim()).toString(), imageMedia, optionsnonRound, animateFirstListener);
          goto _L12
_L2:
        Log.e("bookmarkRSS", "nol");
        txt_empty_RSS.setVisibility(0);
        txt_empty_RSS.setText("Belum ada berita difavoritkan");
        return arraylist;
          goto _L10
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300e6);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            setTranslucentStatus(true);
        }
        bundle = new SystemBarTintManager(this);
        bundle.setStatusBarTintEnabled(true);
        bundle.setStatusBarTintResource(0x7f080160);
        wrapperLight = new ContextThemeWrapper(this, 0x103006e);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        int j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        int i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Favorit</font>"));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        t = Utility.session(t);
        notificationLikeHelper = new NotificationLikeHelper(this);
        cm = (ConnectivityManager)getSystemService("connectivity");
        netInfo = cm.getActiveNetworkInfo();
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        t = Utility.session(t);
        hpFavoriteArray = new ArrayList();
        favBrandArray = new ArrayList();
        scrolView = (ScrollView)findViewById(0x7f0b02aa);
        listMerek = (ExpandableHeightGridView)findViewById(0x7f0b06d4);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        listHp = (ExpandableHeightGridView)findViewById(0x7f0b008f);
        txt_empty = (TextView)findViewById(0x7f0b0093);
        listMerek.setExpanded(true);
        listHp.setExpanded(true);
        txtFavDevice = (TextView)findViewById(0x7f0b06d6);
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
        if (db.getHPCount() > 0)
        {
            hpFavoriteArray = loadHpDB();
            hpFavoriteAdapter = new ListhpFavoriteAdapter(this, 0x7f03011d, hpFavoriteArray);
            listHp.setAdapter(hpFavoriteAdapter);
            loadDataHP();
        } else
        {
            hpFavoriteAdapter = new ListhpFavoriteAdapter(this, 0x7f03011d, hpFavoriteArray);
            listHp.setAdapter(hpFavoriteAdapter);
            FavoritHPTask();
        }
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        mLinearListViewRSS = (LinearLayout)findViewById(0x7f0b06de);
        mArrayListDataRSS = new ArrayList();
        progressbar_RSSFav = (ProgressBar)findViewById(0x7f0b06dd);
        txt_empty_RSS = (TextView)findViewById(0x7f0b06dc);
        favBrandAdapter = new ListfavBrandAdapter(this, 0x7f0300b9, favBrandArray);
        listMerek.setAdapter(favBrandAdapter);
        FavBrandTask();
        listMerek.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final FavoritPonselMerek this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listMerek.playSoundEffect(0);
                adapterview = new Intent(FavoritPonselMerek.this, com/inponsel/android/details/ProfilPTActivity);
                adapterview.putExtra("id_merk", favBrandAdapter.getListModel(k).getId_hp());
                adapterview.putExtra("titlemerek", favBrandAdapter.getListModel(k).getMerk());
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = FavoritPonselMerek.this;
                super();
            }
        });
        listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final FavoritPonselMerek this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                listHp.playSoundEffect(0);
                id_hph = hpFavoriteAdapter.getListModel(k).getId_hp().toString();
                model = hpFavoriteAdapter.getListModel(k).getModel().toString();
                merk = hpFavoriteAdapter.getListModel(k).getMerk().toString();
                gambar = hpFavoriteAdapter.getListModel(k).getGambar().toString();
                codename = hpFavoriteAdapter.getListModel(k).getCodename().toString();
                namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
                adapterview = new Intent(FavoritPonselMerek.this, com/inponsel/android/details/DetailsPonsel);
                adapterview.putExtra("id_hph", id_hph);
                adapterview.putExtra("namalengkap", namalengkap);
                adapterview.putExtra("codename", "");
                adapterview.putExtra("model", model);
                adapterview.putExtra("merk", merk);
                adapterview.putExtra("gambar", gambar);
                adapterview.putExtra("hrg_baru", "");
                adapterview.putExtra("hrg_bekas", "");
                adapterview.putExtra("tot_like", "");
                adapterview.putExtra("tot_dislike", "");
                adapterview.putExtra("tot_komen", "");
                startActivityForResult(adapterview, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = FavoritPonselMerek.this;
                super();
            }
        });
        txtFavDevice.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritPonselMerek this$0;

            public void onClick(View view)
            {
                Log.e("click", "custom dialog");
                view = getLayoutInflater().inflate(0x7f030025, null);
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapperLight);
                builder.setView(view);
                edtAuto = (EditText)view.findViewById(0x7f0b008d);
                listFindDev = (ListView)view.findViewById(0x7f0b008f);
                if (android.os.Build.VERSION.SDK_INT < 13)
                {
                    edtAuto.setTextColor(-1);
                    listFindDev.setBackgroundColor(-1);
                }
                progressbar_search = (ProgressBar)view.findViewById(0x7f0b008e);
                progressbar_search.setVisibility(8);
                listSearchArrayList = new ArrayList();
                listSearchAdapter = new ListSearchAdapter(FavoritPonselMerek.this, 0x7f0300c2, listSearchArrayList);
                listFindDev.setAdapter(listSearchAdapter);
                edtAuto.setSingleLine(true);
                edtAuto.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                    final _cls3 this$1;

                    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
                    {
                        boolean flag = false;
                        if (i != 3) goto _L2; else goto _L1
_L1:
                        if (edtAuto.getText().toString().length() < 2) goto _L4; else goto _L3
_L3:
                        progressbar_search.setVisibility(0);
                        textview = edtAuto.getText().toString();
                        keyevent = URLEncoder.encode(textview, "utf-8");
                        textview = keyevent;
_L6:
                        FavoritSearchTask(textview);
_L4:
                        flag = true;
_L2:
                        return flag;
                        keyevent;
                        keyevent.printStackTrace();
                        if (true) goto _L6; else goto _L5
_L5:
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
                edtAuto.addTextChangedListener(new DelayedTextWatcher(2000L) {

                    final _cls3 this$1;

                    public void afterTextChangedDelayed(Editable editable)
                    {
                        if (edtAuto.getText().toString().length() < 2) goto _L2; else goto _L1
_L1:
                        progressbar_search.setVisibility(0);
                        editable = edtAuto.getText().toString();
                        String s = URLEncoder.encode(editable, "utf-8");
                        editable = s;
_L4:
                        FavoritSearchTask(editable);
_L2:
                        return;
                        UnsupportedEncodingException unsupportedencodingexception;
                        unsupportedencodingexception;
                        unsupportedencodingexception.printStackTrace();
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                this$1 = _cls3.this;
                super(l);
            }
                });
                dialog = builder.create();
                dialog.show();
            }


            
            {
                this$0 = FavoritPonselMerek.this;
                super();
            }
        });
        if (db.getRSSCount() > 0)
        {
            mArrayListDataRSS = loadRSSDB();
            txt_empty_RSS.setVisibility(8);
            progressbar_RSSFav.setVisibility(8);
            if (netInfo != null && netInfo.isConnected())
            {
                FavoritRSSTask();
            }
        } else
        {
            FavoritRSSTask();
        }
        listKategoriAdsApps = (LinearLayout)findViewById(0x7f0b06e0);
        mArrayListRSSData = new ArrayList();
        load_FavKategoriApps();
        db.close();
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
    }

    public void updateViewLikeDisRSS(String s)
    {
        int i;
        Log.e("id_kom", s);
        Log.e("mLinearListViewRSS", String.valueOf(mLinearListViewRSS.getChildCount()));
        i = 0;
_L2:
        ImageView imageview;
        Object obj;
        if (i >= mLinearListViewRSS.getChildCount())
        {
            return;
        }
        obj = mLinearListViewRSS.getChildAt(i);
        TextView textview = (TextView)((View) (obj)).findViewById(0x7f0b054d);
        TextView textview1 = (TextView)((View) (obj)).findViewById(0x7f0b0551);
        TextView textview2 = (TextView)((View) (obj)).findViewById(0x7f0b0554);
        imageview = (ImageView)((View) (obj)).findViewById(0x7f0b054f);
        obj = (RelativeLayout)((View) (obj)).findViewById(0x7f0b0342);
        if (textview.getText().toString().equals(s))
        {
            textview1.setText(tot_LikeKom);
            textview2.setText(totdis_LikeKom);
            if (!statuslike.equals("1"))
            {
                break; /* Loop/switch isn't completed */
            }
            imageview.setBackgroundResource(0x7f02025b);
            ((RelativeLayout) (obj)).setEnabled(false);
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!statuslike.equals("0")) goto _L4; else goto _L3
_L3:
        imageview.setBackgroundResource(0x7f020257);
        ((RelativeLayout) (obj)).setEnabled(true);
          goto _L4
    }







}
