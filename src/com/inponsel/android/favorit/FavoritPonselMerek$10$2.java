// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.content.Intent;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemKategoriAppsGames;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.AppsByCategory;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritPonselMerek

class val.myfav
    implements android.view.onselMerek._cls10._cls2
{

    final idePendingTransition this$1;
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
        view.putExtra("id", val$id);
        view.putExtra("kategori", val$kategori);
        view.putExtra("tag", val$tag);
        view.putExtra("deskripsi", val$deskripsi);
        view.putExtra("mod_date", val$mod_date);
        view.putExtra("background", val$background);
        view.putExtra("background_img", val$background_img);
        view.putExtra("total_like", val$total_like);
        view.putExtra("mystat", "");
        view.putExtra("width_img", val$width);
        view.putExtra("height_img", val$height);
        view.putExtra("type", val$type);
        view.putExtra("myfav", val$myfav);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    >()
    {
        this$1 = final_>;
        val$id = s;
        val$kategori = s1;
        val$tag = s2;
        val$deskripsi = s3;
        val$mod_date = s4;
        val$background = s5;
        val$background_img = s6;
        val$total_like = s7;
        val$width = s8;
        val$height = s9;
        val$type = s10;
        val$myfav = String.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$10

/* anonymous class */
    class FavoritPonselMerek._cls10 extends AsyncHttpResponseHandler
    {

        final FavoritPonselMerek this$0;

        public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
        {
        }

        public void onRetry(int i)
        {
        }

        public void onStart()
        {
            FavoritPonselMerek.access$5(FavoritPonselMerek.this).clear();
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
            if (i < FavoritPonselMerek.access$5(FavoritPonselMerek.this).size())
            {
                break MISSING_BLOCK_LABEL_295;
            }
            listKategoriAdsApps.setVisibility(0);
_L5:
            return;
_L3:
            id = aheader.getJSONObject(i);
            FavoritPonselMerek.access$5(FavoritPonselMerek.this).add(new ItemKategoriAppsGames(id.getString("id"), id.getString("kategori"), id.getString("tag"), id.getString("type"), id.getString("deskripsi"), id.getString("place"), id.getString("position"), id.getString("background"), id.getString("background_img"), id.getString("width"), id.getString("height"), id.getString("myfav"), id.getString("mod_date"), id.getString("total_like"), ""));
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
            id = ((ItemKategoriAppsGames)FavoritPonselMerek.access$5(FavoritPonselMerek.this).get(i)).getId();
            final String kategori = ((ItemKategoriAppsGames)FavoritPonselMerek.access$5(FavoritPonselMerek.this).get(i)).getkategori();
            final String tag = ((ItemKategoriAppsGames)FavoritPonselMerek.access$5(FavoritPonselMerek.this).get(i)).gettag();
            final String type = ((ItemKategoriAppsGames)FavoritPonselMerek.access$5(FavoritPonselMerek.this).get(i)).gettype();
            final String deskripsi = ((ItemKategoriAppsGames)FavoritPonselMerek.access$5(FavoritPonselMerek.this).get(i)).getdeskripsi();
            final String background = ((ItemKategoriAppsGames)FavoritPonselMerek.access$5(FavoritPonselMerek.this).get(i)).getposition();
            final String background_img = ((ItemKategoriAppsGames)FavoritPonselMerek.access$5(FavoritPonselMerek.this).get(i)).getplace();
            Log.e("posplace", (new StringBuilder(String.valueOf(background))).append("-").append(background_img).append("-").append(i).toString());
            background = ((ItemKategoriAppsGames)FavoritPonselMerek.access$5(FavoritPonselMerek.this).get(i)).getbackground();
            background_img = ((ItemKategoriAppsGames)FavoritPonselMerek.access$5(FavoritPonselMerek.this).get(i)).getbackground_img();
            final String width = ((ItemKategoriAppsGames)FavoritPonselMerek.access$5(FavoritPonselMerek.this).get(i)).getwidth();
            final String height = ((ItemKategoriAppsGames)FavoritPonselMerek.access$5(FavoritPonselMerek.this).get(i)).getheight();
            final String myfav = ((ItemKategoriAppsGames)FavoritPonselMerek.access$5(FavoritPonselMerek.this).get(i)).getmyfav();
            final String mod_date = ((ItemKategoriAppsGames)FavoritPonselMerek.access$5(FavoritPonselMerek.this).get(i)).getmod_date();
            final String total_like = ((ItemKategoriAppsGames)FavoritPonselMerek.access$5(FavoritPonselMerek.this).get(i)).gettotal_like();
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
                Picasso.with(FavoritPonselMerek.this).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(k).append("&src=").append(background_img.trim()).toString()).tag(this).into(img_kat_apps_1, new FavoritPonselMerek._cls10._cls1());
            } else
            {
                img_kat_apps_1.setBackgroundColor(Color.parseColor(background));
            }
            listKategoriAdsApps.addView(aheader);
            aheader.setOnClickListener(myfav. new FavoritPonselMerek._cls10._cls2());
            ll_fav_apps.setOnClickListener(new FavoritPonselMerek._cls10._cls3());
            i++;
              goto _L7
        }


            
            {
                this$0 = FavoritPonselMerek.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$10$1

/* anonymous class */
        class FavoritPonselMerek._cls10._cls1
            implements Callback
        {

            final FavoritPonselMerek._cls10 this$1;

            public void onError()
            {
            }

            public void onSuccess()
            {
                img_kat_apps_1.setVisibility(0);
            }

                    
                    {
                        this$1 = FavoritPonselMerek._cls10.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$10$3

/* anonymous class */
        class FavoritPonselMerek._cls10._cls3
            implements android.view.View.OnClickListener
        {

            final FavoritPonselMerek._cls10 this$1;
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
                (new AsyncHttpClient()).get(urlPost, id. new FavoritPonselMerek._cls10._cls3._cls1());
            }


                    
                    {
                        this$1 = FavoritPonselMerek._cls10.this;
                        myfav = s;
                        id = s1;
                        kategori = s2;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/favorit/FavoritPonselMerek$10$3$1

/* anonymous class */
        class FavoritPonselMerek._cls10._cls3._cls1 extends AsyncHttpResponseHandler
        {

            final FavoritPonselMerek._cls10._cls3 this$2;
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
                FavoritPonselMerek.access$6(this$0);
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
        }

    }

}
