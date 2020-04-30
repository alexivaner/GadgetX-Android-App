// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.adapter.ItemRSS;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
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
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class FavoritArtikelBerita extends SherlockFragmentActivity
    implements Observer
{
    private class FavoritRSSTask extends AsyncTask
    {

        final FavoritArtikelBerita this$0;

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
            Object obj = FavoritArtikelBerita.this;
            obj.countAllKom = ((FavoritArtikelBerita) (obj)).countAllKom + 1;
            obj = FavoritArtikelBerita.this;
            obj.countKomOld = ((FavoritArtikelBerita) (obj)).countKomOld + 1;
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
                break MISSING_BLOCK_LABEL_1428;
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
            Log.e("fav471", s);
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
            this$0 = FavoritArtikelBerita.this;
            super();
        }

        FavoritRSSTask(FavoritRSSTask favoritrsstask)
        {
            this();
        }
    }

    public class PostBagusKurangRSSTask extends AsyncTask
    {

        final FavoritArtikelBerita this$0;

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
            this$0 = FavoritArtikelBerita.this;
            super();
        }
    }

    public class RemFavoritRSSTask extends AsyncTask
    {

        final FavoritArtikelBerita this$0;

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
                mDialog = ProgressDialog.show(FavoritArtikelBerita.this, "", "Menambahkan...", true);
            } else
            {
                mDialog = ProgressDialog.show(FavoritArtikelBerita.this, "", "Menghapus...", true);
            }
            mDialog.setCancelable(true);
            mDialog.show();
        }

        public RemFavoritRSSTask()
        {
            this$0 = FavoritArtikelBerita.this;
            super();
        }
    }


    ActionBar actionBar;
    int actionBarTitleId;
    private ImageLoadingListener animateFirstListener;
    String bottom_id;
    LinearLayout bottom_list;
    int charCount;
    ConnectivityManager cm;
    int countAllKom;
    int countKomOld;
    Cursor cursor;
    String dataFavRSS;
    DatabaseHandler db;
    String email_user;
    String idkom_pos;
    String idrss_pos;
    ImageLoader imageLoader2;
    ImageView imageMedia;
    ImageView img_kom_picture;
    JSONArray jArray;
    String jum_komen;
    LinearLayout lay_quote;
    int limit;
    RelativeLayout list_lay_dislike;
    RelativeLayout list_lay_kom;
    RelativeLayout list_lay_like;
    private ArrayList mArrayListDataRSS;
    ProgressDialog mDialog;
    private LinearLayout mLinearListViewRSS;
    String nama_asli;
    NetworkInfo netInfo;
    NotificationLikeRSSHelper notificationLikeHelperRSS;
    private DisplayImageOptions options;
    private DisplayImageOptions optionsnonRound;
    PonselBaseApp ponselBaseApp;
    String postMessageLikeKom;
    String postStatusLikeKom;
    ProgressBar progressbar_RSSFav;
    String querylike;
    String querylikeRSS;
    String res;
    String reslike;
    String stat;
    String statuslike;
    String strKonekStat;
    String str_srclink;
    String succesStat;
    String t;
    String top_id;
    String tot_LikeKom;
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
    TextView txt_empty_RSS;
    TextView txtdisLikeKom;
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

    public FavoritArtikelBerita()
    {
        strKonekStat = "";
        idkom_pos = "";
        idrss_pos = "";
        str_srclink = "";
        user_photo = "";
        username = "";
        dataFavRSS = "";
        querylike = "";
        querylikeRSS = "";
        limit = 0;
        t = Utility.session(RestClient.pelihara);
        bottom_id = "";
        top_id = "0";
        jum_komen = "0";
        tot_LikePon = "";
        totdis_LikePon = "";
        succesStat = "";
        countKomOld = 0;
        countAllKom = 0;
        animateFirstListener = new AnimateFirstDisplayListener();
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
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

    public void FavoritRSSTask()
    {
        dataFavRSS = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_reader_fav").append(Utility.BASE_FORMAT).append("?").append("lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
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

    public ArrayList loadRSSDB()
    {
        ArrayList arraylist;
        Cursor cursor1;
        arraylist = new ArrayList();
        cursor1 = db.getRSSData();
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_1145;
        }
_L8:
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
        if (!like_stat.toString().equals("1")) goto _L2; else goto _L1
_L1:
        imageview.setBackgroundResource(0x7f02025b);
        list_lay_like.setEnabled(false);
        list_lay_dislike.setEnabled(true);
_L9:
        if (!"1".toString().equals("1")) goto _L4; else goto _L3
_L3:
        imageview1.setBackgroundResource(0x7f020303);
_L10:
        imageLoader2.displayImage((new StringBuilder()).append(rss_img_ava.toString().trim()).toString(), img_kom_picture, options, animateFirstListener);
        if (!rss_img.trim().equals("")) goto _L6; else goto _L5
_L5:
        imageMedia.setVisibility(8);
_L11:
        boolean flag;
        txtWaktu.setText(Utility.convertDate(rss_date));
        mLinearListViewRSS.addView(view);
        imageMedia.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritArtikelBerita this$0;
            private final String val$rss_img;

            public void onClick(View view1)
            {
                view1 = new ArrayList();
                view1.add(rss_img);
                view1 = (String[])view1.toArray(new String[view1.size()]);
                Intent intent = new Intent(FavoritArtikelBerita.this, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view1);
                intent.putExtra("pos", 0);
                startActivity(intent);
            }

            
            {
                this$0 = FavoritArtikelBerita.this;
                rss_img = s;
                super();
            }
        });
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final FavoritArtikelBerita this$0;
            private final String val$rss_img_ava;

            public boolean onLongClick(View view1)
            {
                view1 = new ArrayList();
                view1.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(rss_img_ava.toString().trim()).toString());
                view1 = (String[])view1.toArray(new String[view1.size()]);
                Intent intent = new Intent(FavoritArtikelBerita.this, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view1);
                intent.putExtra("pos", 0);
                startActivity(intent);
                return false;
            }

            
            {
                this$0 = FavoritArtikelBerita.this;
                rss_img_ava = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritArtikelBerita this$0;
            private final String val$id_rss;

            public void onClick(View view1)
            {
                if (userFunctions.isUserLoggedIn(FavoritArtikelBerita.this))
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

                        final _cls3 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                    view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                    view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls3 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                    view1.show();
                    return;
                }
            }


            
            {
                this$0 = FavoritArtikelBerita.this;
                id_rss = s;
                super();
            }
        });
        list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritArtikelBerita this$0;
            private final String val$id_rss;
            private final String val$rss_srclink;
            private final TextView val$txt_fav_news_1;

            public void onClick(View view1)
            {
                idrss_pos = id_rss;
                str_srclink = rss_srclink;
                if (userFunctions.isUserLoggedIn(FavoritArtikelBerita.this))
                {
                    if (txt_fav_news_1.getText().toString().equals("1"))
                    {
                        view1 = new android.app.AlertDialog.Builder(FavoritArtikelBerita.this);
                        view1.setMessage("Hapus berita ini dari favorit?");
                        view1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls4 this$1;

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
                this$1 = _cls4.this;
                super();
            }
                        });
                        view1.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls4 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls4.this;
                super();
            }
                        });
                        view1.show();
                        return;
                    } else
                    {
                        view1 = new android.app.AlertDialog.Builder(FavoritArtikelBerita.this);
                        view1.setMessage("Favoritkan berita ini?");
                        view1.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls4 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                stat = "1";
                                (new FavoritRSSTask(null)).execute(new String[0]);
                            }

            
            {
                this$1 = _cls4.this;
                super();
            }
                        });
                        view1.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls4 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$1 = _cls4.this;
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

                        final _cls4 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    view1.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls4 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    view1.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls4 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    view1.show();
                    return;
                }
            }


            
            {
                this$0 = FavoritArtikelBerita.this;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = textview;
                super();
            }
        });
        list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritArtikelBerita this$0;
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
                view1 = new Intent(FavoritArtikelBerita.this, com/inponsel/android/rssfeeddetail/RSSDetailTab);
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
                this$0 = FavoritArtikelBerita.this;
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

            final FavoritArtikelBerita this$0;
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
                view1 = new Intent(FavoritArtikelBerita.this, com/inponsel/android/rssfeeddetail/RSSDetailTab);
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
                this$0 = FavoritArtikelBerita.this;
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
        flag = cursor1.moveToNext();
        if (flag) goto _L8; else goto _L7
_L7:
        db.close();
        return arraylist;
_L2:
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
          goto _L9
        list_lay_like.setEnabled(true);
        list_lay_dislike.setEnabled(true);
        imageview.setBackgroundResource(0x7f020257);
        list_lay_like.setBackgroundResource(0x7f020079);
        list_lay_dislike.setBackgroundResource(0x7f020079);
          goto _L9
_L4:
label1:
        {
            if (!"1".toString().equals("0"))
            {
                break label1;
            }
            imageview1.setBackgroundResource(0x7f020302);
        }
          goto _L10
        imageview1.setBackgroundResource(0x7f020302);
          goto _L10
_L6:
        imageLoader2.displayImage((new StringBuilder()).append(rss_img.toString().trim()).toString(), imageMedia, optionsnonRound, animateFirstListener);
          goto _L11
        try
        {
            Log.e("bookmarkRSS", "nol");
            txt_empty_RSS.setVisibility(0);
            txt_empty_RSS.setText("Belum ada berita difavoritkan");
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            txt_empty_RSS.setVisibility(0);
            txt_empty_RSS.setText("Belum ada berita difavoritkan");
        }
          goto _L7
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300e7);
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
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Favorit Berita</font>"));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        ponselBaseApp = (PonselBaseApp)getApplication();
        ponselBaseApp.getObserver().addObserver(this);
        wrapperLight = new ContextThemeWrapper(this, 0x103006e);
        t = Utility.session(t);
        notificationLikeHelperRSS = new NotificationLikeRSSHelper(this);
        cm = (ConnectivityManager)getSystemService("connectivity");
        netInfo = cm.getActiveNetworkInfo();
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        t = Utility.session(t);
        imageLoader2 = ImageLoader.getInstance();
        imageLoader2.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020297).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        mLinearListViewRSS = (LinearLayout)findViewById(0x7f0b06de);
        mArrayListDataRSS = new ArrayList();
        progressbar_RSSFav = (ProgressBar)findViewById(0x7f0b06dd);
        txt_empty_RSS = (TextView)findViewById(0x7f0b06dc);
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
        if (db.getRSSCount() > 0)
        {
            mArrayListDataRSS = loadRSSDB();
            txt_empty_RSS.setVisibility(8);
            progressbar_RSSFav.setVisibility(8);
            if (netInfo != null && netInfo.isConnected())
            {
                FavoritRSSTask();
            }
            return;
        } else
        {
            FavoritRSSTask();
            return;
        }
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
