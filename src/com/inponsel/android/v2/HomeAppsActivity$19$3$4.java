// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemKategoriAppsGames;
import com.inponsel.android.adapter.ListAppsAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.NotificationLikeHelper;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.widget.ExpandableHeightGridView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.util.ArrayList;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            LoginActivity, HomeAppsActivity, RegisterActivity, AppsByCategory

class this._cls2
    implements android.content.istener
{

    final ePendingTransition this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(_fld0, com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        startActivityForResult(dialoginterface, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    <init>()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeAppsActivity$19

/* anonymous class */
    class HomeAppsActivity._cls19 extends AsyncHttpResponseHandler
    {

        final HomeAppsActivity this$0;

        public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
        {
        }

        public void onRetry(int i)
        {
        }

        public void onStart()
        {
            is_kategori_apps = false;
            HomeAppsActivity.access$1(HomeAppsActivity.this).clear();
            listKategoriAdsApps.removeAllViews();
            page_counter = 1;
        }

        public void onSuccess(int i, Header aheader[], byte abyte0[])
        {
            aheader = new String(abyte0);
            Log.e("respJson", aheader);
            abyte0 = new JSONObject(aheader);
            Log.e("urlKategori2", urlKategori2);
            aheader = abyte0.getJSONArray("InPonsel");
            bottom_id = abyte0.getString("bottom_id");
            succesStat = abyte0.getString("success");
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
            final String id;
            if (i >= HomeAppsActivity.access$1(HomeAppsActivity.this).size())
            {
                listKategoriAdsApps.setVisibility(0);
                is_kategori_apps = true;
                return;
            }
            aheader = HomeAppsActivity.this;
            aheader.countList_rss = ((HomeAppsActivity) (aheader)).countList_rss + 1;
            aheader = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03013e, null);
            id = aheader.findViewById(0x7f0b0868);
            progbar_apps = (CircularProgressBar)aheader.findViewById(0x7f0b090d);
            listApps = (ExpandableHeightGridView)aheader.findViewById(0x7f0b086a);
              goto _L6
_L3:
            abyte0 = aheader.getJSONObject(i);
            HomeAppsActivity.access$1(HomeAppsActivity.this).add(new ItemKategoriAppsGames(abyte0.getString("id"), abyte0.getString("kategori"), abyte0.getString("tag"), abyte0.getString("type"), abyte0.getString("deskripsi"), abyte0.getString("place"), abyte0.getString("position"), abyte0.getString("background"), abyte0.getString("background_img"), abyte0.getString("width"), abyte0.getString("height"), abyte0.getString("myfav"), abyte0.getString("mod_date"), abyte0.getString("total_like"), abyte0.getString("kategori_apps")));
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
            if (!((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).getJsonarray().equals("[]")) goto _L8; else goto _L7
_L7:
            Log.e("applist", "applistkosong");
_L13:
            abyte0 = (LinearLayout)aheader.findViewById(0x7f0b0865);
            abyte0 = (LinearLayout)aheader.findViewById(0x7f0b0862);
            final Object listAppsAdapter = (ImageView)aheader.findViewById(0x7f0b0863);
            Object obj = (TextView)aheader.findViewById(0x7f0b08f0);
            Object obj1 = (TextView)aheader.findViewById(0x7f0b0860);
            Object obj2 = (TextView)aheader.findViewById(0x7f0b0861);
            TextView textview = (TextView)aheader.findViewById(0x7f0b0866);
            final TextView txt_fav_kat_apps_1 = (TextView)aheader.findViewById(0x7f0b0864);
            LinearLayout linearlayout = (LinearLayout)aheader.findViewById(0x7f0b0907);
            final String kategori = (ImageView)aheader.findViewById(0x7f0b0908);
            kategori = (ImageView)aheader.findViewById(0x7f0b0867);
            id.setVisibility(0);
            Log.e("jsonarray", ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).getJsonarray());
            id = ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).getId();
            kategori = ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).getkategori();
            final String tag = ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).gettag();
            final String type = ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).gettype();
            final String deskripsi = ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).getdeskripsi();
            final String background = ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).getposition();
            final String background_img = ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).getplace();
            Log.e("posplace", (new StringBuilder(String.valueOf(background))).append("-").append(background_img).append("-").append(i).toString());
            background = ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).getbackground();
            background_img = ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).getbackground_img();
            final String width = ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).getwidth();
            final String height = ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).getheight();
            String s = ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).getmyfav();
            final String mod_date = ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).getmod_date();
            final String total_like = ((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).gettotal_like();
            int k;
            if (s.equals("1"))
            {
                ((ImageView) (listAppsAdapter)).setBackgroundResource(0x7f020303);
            } else
            {
                ((ImageView) (listAppsAdapter)).setBackgroundResource(0x7f020302);
            }
            linearlayout.setVisibility(0);
            ((TextView) (obj)).setText(id);
            Log.e((new StringBuilder("myfav")).append(id).toString(), s);
            txt_fav_kat_apps_1.setText(s);
            ((TextView) (obj1)).setText(kategori);
            ((TextView) (obj2)).setText(deskripsi);
            textview.setText(total_like);
            listKategoriAdsApps.addView(aheader);
            Log.e("countList_rss", (new StringBuilder("listno")).append(String.valueOf(countList_rss)).toString());
            if (countList_rss == 3)
            {
                Log.e("mLinearViewAdsFBGoogle", "ads");
            }
            aheader.setOnClickListener(new HomeAppsActivity._cls19._cls2());
            abyte0.setOnClickListener(((HomeAppsActivity._cls19._cls3) (listAppsAdapter)). new HomeAppsActivity._cls19._cls3());
            i++;
              goto _L9
_L8:
            abyte0 = new ArrayList();
            listAppsAdapter = new ListAppsAdapter(HomeAppsActivity.this, 0x7f030137, abyte0);
            obj = new JSONArray(new String(((ItemKategoriAppsGames)HomeAppsActivity.access$1(HomeAppsActivity.this).get(i)).getJsonarray()));
            Log.e("jsonArray", (new StringBuilder("applist")).append(String.valueOf(((JSONArray) (obj)).length())).toString());
            if (((JSONArray) (obj)).length() == 0) goto _L11; else goto _L10
_L10:
            k = 0;
_L14:
            if (k < ((JSONArray) (obj)).length()) goto _L12; else goto _L11
_L11:
            Log.e("arrayAppsList", (new StringBuilder("arrayAppsList")).append(String.valueOf(abyte0.size())).toString());
            listApps.setAdapter(((android.widget.ListAdapter) (listAppsAdapter)));
            listApps.setOnItemClickListener(new HomeAppsActivity._cls19._cls1());
              goto _L13
            abyte0;
            abyte0.printStackTrace();
              goto _L13
_L12:
            obj1 = ((JSONArray) (obj)).getJSONObject(k);
            Log.e("iLength", (new StringBuilder(String.valueOf(String.valueOf(k)))).append("-").append(((JSONObject) (obj1)).getString("app_name")).toString());
            obj2 = new ListModel();
            ((ListModel) (obj2)).setApppackage(((JSONObject) (obj1)).getString("app_package"));
            ((ListModel) (obj2)).setAppname(((JSONObject) (obj1)).getString("app_name"));
            ((ListModel) (obj2)).setAppcover(((JSONObject) (obj1)).getString("icon_image"));
            ((ListModel) (obj2)).setAvgrate(((JSONObject) (obj1)).getString("app_rate"));
            ((ListModel) (obj2)).setBanner_image(((JSONObject) (obj1)).getString("banner_image"));
            ((ListModel) (obj2)).setAppsize(((JSONObject) (obj1)).getString("app_size"));
            ((ListModel) (obj2)).setDownloadcount(((JSONObject) (obj1)).getString("app_download"));
            ((ListModel) (obj2)).setAppurl(((JSONObject) (obj1)).getString("app_url"));
            abyte0.add(obj2);
            k++;
              goto _L14
_L5:
            is_kategori_apps = false;
            return;
            if (true) goto _L16; else goto _L15
_L15:
        }


            
            {
                this$0 = HomeAppsActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeAppsActivity$19$1

/* anonymous class */
        class HomeAppsActivity._cls19._cls1
            implements android.widget.AdapterView.OnItemClickListener
        {

            final HomeAppsActivity._cls19 this$1;
            private final ListAppsAdapter val$listAppsAdapter;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(listAppsAdapter.getListModel(i).getAppurl())));
            }

                    
                    {
                        this$1 = HomeAppsActivity._cls19.this;
                        listAppsAdapter = listappsadapter;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeAppsActivity$19$2

/* anonymous class */
        class HomeAppsActivity._cls19._cls2
            implements android.view.View.OnClickListener
        {

            final HomeAppsActivity._cls19 this$1;
            private final String val$background;
            private final String val$background_img;
            private final String val$deskripsi;
            private final String val$height;
            private final String val$id;
            private final String val$kategori;
            private final String val$mod_date;
            private final String val$tag;
            private final String val$total_like;
            private final TextView val$txt_fav_kat_apps_1;
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
                        this$1 = HomeAppsActivity._cls19.this;
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
                        txt_fav_kat_apps_1 = textview;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/inponsel/android/v2/HomeAppsActivity$19$3

/* anonymous class */
    class HomeAppsActivity._cls19._cls3
        implements android.view.View.OnClickListener
    {

        final HomeAppsActivity._cls19 this$1;
        private final String val$id;
        private final ImageView val$img_fav_apps_1;
        private final String val$kategori;
        private final TextView val$txt_fav_kat_apps_1;

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
                (new AsyncHttpClient()).get(view, new HomeAppsActivity._cls19._cls3._cls1());
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(this$0);
                view.setMessage("Untuk menambah ke favorit harus login terlebih dahulu.");
                view.setPositiveButton("Tutup", new HomeAppsActivity._cls19._cls3._cls2());
                view.setNeutralButton("Register", new HomeAppsActivity._cls19._cls3._cls3());
                view.setNegativeButton("Login", new HomeAppsActivity._cls19._cls3._cls4());
                view.show();
                return;
            }
        }


            
            {
                this$1 = final__pcls19;
                txt_fav_kat_apps_1 = textview;
                id = s;
                kategori = s1;
                img_fav_apps_1 = ImageView.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/HomeAppsActivity$19$3$1

/* anonymous class */
        class HomeAppsActivity._cls19._cls3._cls1 extends AsyncHttpResponseHandler
        {

            final HomeAppsActivity._cls19._cls3 this$2;
            private final String val$id;
            private final ImageView val$img_fav_apps_1;
            private final String val$kategori;
            private final TextView val$txt_fav_kat_apps_1;

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
                        this$2 = HomeAppsActivity._cls19._cls3.this;
                        kategori = s;
                        txt_fav_kat_apps_1 = textview;
                        img_fav_apps_1 = imageview;
                        id = s1;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeAppsActivity$19$3$2

/* anonymous class */
        class HomeAppsActivity._cls19._cls3._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeAppsActivity._cls19._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = HomeAppsActivity._cls19._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/HomeAppsActivity$19$3$3

/* anonymous class */
        class HomeAppsActivity._cls19._cls3._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final HomeAppsActivity._cls19._cls3 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                startActivityForResult(dialoginterface, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$2 = HomeAppsActivity._cls19._cls3.this;
                        super();
                    }
        }

    }

}
