// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemRSS;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritPonselMerek

private class <init> extends AsyncTask
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
        FavoritPonselMerek.access$0(FavoritPonselMerek.this).add(new ItemRSS(((JSONObject) (obj)).getString("id"), ((JSONObject) (obj)).getString("rss_id"), ((JSONObject) (obj)).getString("rss_title"), ((JSONObject) (obj)).getString("rss_portal"), ((JSONObject) (obj)).getString("rss_desc"), ((JSONObject) (obj)).getString("rss_content"), ((JSONObject) (obj)).getString("rss_srclink"), ((JSONObject) (obj)).getString("rss_date"), ((JSONObject) (obj)).getString("rss_img_ava"), ((JSONObject) (obj)).getString("rss_img"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_like"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_komen"), "", ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_like_rss"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_fav_rss")));
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
        Log.e("mArrayListDataRSS", String.valueOf(FavoritPonselMerek.access$0(FavoritPonselMerek.this).size()));
        progressbar_RSSFav.setVisibility(8);
        FavoritPonselMerek.access$1(FavoritPonselMerek.this).removeAllViewsInLayout();
        FavoritPonselMerek.access$1(FavoritPonselMerek.this).removeAllViews();
        if (FavoritPonselMerek.access$0(FavoritPonselMerek.this).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_1420;
        }
        txt_empty_RSS.setVisibility(8);
        int i = 0;
_L7:
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
        final String fav_stat;
        try
        {
            if (i >= FavoritPonselMerek.access$0(FavoritPonselMerek.this).size())
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
        txt_fav_news_1 = (TextView)void1.findViewById(0x7f0b0650);
        id_rss = ((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getId();
        rss_id = ((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_id();
        rss_title = ((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_title();
        rss_portal = ((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_portal();
        rss_desc = ((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_desc();
        rss_content = ((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_content();
        rss_srclink = ((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_srclink();
        rss_date = ((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_date();
        rss_img_ava = ((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_img_ava();
        rss_img = ((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_img();
        total_like = ((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_tot_like();
        like_stat = ((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_like_stat();
        total_komen = ((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_tot_komen();
        fav_stat = ((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_fav_stat();
        txt_fav_news_1.setText(fav_stat);
        txtTitle.setText(Html.fromHtml(rss_title));
        txtIdKom.setText(id_rss);
        txtUsername.setText(rss_portal);
        txtImgAva.setText(rss_img_ava);
        txtImgMedia.setText(rss_img);
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(rss_desc)));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.ovementMethod.getInstance());
        txtLikeKom.setText(total_like);
        txtTotalKom.setText(total_komen);
        if (!like_stat.toString().equals("1")) goto _L2; else goto _L1
_L1:
        imageview.setBackgroundResource(0x7f02025b);
        list_lay_like.setEnabled(false);
        list_lay_dislike.setEnabled(true);
_L8:
        if (!fav_stat.toString().equals("1")) goto _L4; else goto _L3
_L3:
        imageview1.setBackgroundResource(0x7f020303);
_L9:
        imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_img_ava().toString().trim()).toString(), img_kom_picture, FavoritPonselMerek.access$2(FavoritPonselMerek.this), FavoritPonselMerek.access$3(FavoritPonselMerek.this));
        if (!((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_img().trim().equals("")) goto _L6; else goto _L5
_L5:
        imageMedia.setVisibility(8);
_L10:
        txtWaktu.setText(Utility.convertDate(((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_date()));
        FavoritPonselMerek.access$1(FavoritPonselMerek.this).addView(void1);
        imageMedia.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritPonselMerek.FavoritRSSTask this$1;
            private final String val$rss_img;

            public void onClick(View view)
            {
                view = new ArrayList();
                view.add(rss_img);
                view = (String[])view.toArray(new String[view.size()]);
                Intent intent = new Intent(this$0, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view);
                intent.putExtra("pos", 0);
                startActivity(intent);
            }

            
            {
                this$1 = FavoritPonselMerek.FavoritRSSTask.this;
                rss_img = s;
                super();
            }
        });
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final FavoritPonselMerek.FavoritRSSTask this$1;
            private final String val$rss_img_ava;

            public boolean onLongClick(View view)
            {
                view = new ArrayList();
                view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(rss_img_ava.toString().trim()).toString());
                view = (String[])view.toArray(new String[view.size()]);
                Intent intent = new Intent(this$0, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view);
                intent.putExtra("pos", 0);
                startActivity(intent);
                return false;
            }

            
            {
                this$1 = FavoritPonselMerek.FavoritRSSTask.this;
                rss_img_ava = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritPonselMerek.FavoritRSSTask this$1;
            private final String val$id_rss;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(this$0))
                {
                    statuslike = "1";
                    idrss_pos = id_rss;
                    querylikeRSS = (new StringBuilder("status=")).append(statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylikeRSS", querylikeRSS);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new FavoritPonselMerek.PostBagusKurangRSSTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new FavoritPonselMerek.PostBagusKurangRSSTask(this$0)).execute(new Void[0]);
                        return;
                    }
                } else
                {
                    view = new android.app.AlertDialog.Builder(wrapperLight);
                    view.setMessage("Untuk memberi penilaian harus login terlebih dahulu.");
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
                            dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
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
                            dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
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
                this$1 = FavoritPonselMerek.FavoritRSSTask.this;
                id_rss = s;
                super();
            }
        });
        list_lay_dislike.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritPonselMerek.FavoritRSSTask this$1;
            private final String val$id_rss;
            private final String val$rss_srclink;
            private final TextView val$txt_fav_news_1;

            public void onClick(View view)
            {
                idrss_pos = id_rss;
                str_srclink = rss_srclink;
                if (userFunctions.isUserLoggedIn(this$0))
                {
                    if (txt_fav_news_1.getText().toString().equals("1"))
                    {
                        view = new android.app.AlertDialog.Builder(this$0);
                        view.setMessage("Hapus berita ini dari favorit?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                                stat = "0";
                                (new FavoritPonselMerek.RemFavoritRSSTask(this$0)).execute(new Void[0]);
                            }

            
            {
                this$2 = _cls4.this;
                super();
            }
                        });
                        view.setNegativeButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = _cls4.this;
                super();
            }
                        });
                        view.show();
                        return;
                    } else
                    {
                        view = new android.app.AlertDialog.Builder(this$0);
                        view.setMessage("Favoritkan berita ini?");
                        view.setPositiveButton("Ya", new android.content.DialogInterface.OnClickListener() {

                            final _cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                stat = "1";
                                (new FavoritPonselMerek.FavoritRSSTask(null)).execute(new String[0]);
                            }

            
            {
                this$2 = _cls4.this;
                super();
            }
                        });
                        view.setNeutralButton("Tidak", new android.content.DialogInterface.OnClickListener() {

                            final _cls4 this$2;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface.dismiss();
                            }

            
            {
                this$2 = _cls4.this;
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

                        final _cls4 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$2 = _cls4.this;
                super();
            }
                    });
                    view.setNeutralButton("Register", new android.content.DialogInterface.OnClickListener() {

                        final _cls4 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(this$0, com/inponsel/android/v2/RegisterActivity);
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls4.this;
                super();
            }
                    });
                    view.setNegativeButton("Login", new android.content.DialogInterface.OnClickListener() {

                        final _cls4 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface = new Intent(this$0, com/inponsel/android/v2/LoginActivity);
                            dialoginterface.putExtra("activity", "main");
                            startActivity(dialoginterface);
                        }

            
            {
                this$2 = _cls4.this;
                super();
            }
                    });
                    view.show();
                    return;
                }
            }


            
            {
                this$1 = FavoritPonselMerek.FavoritRSSTask.this;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = textview;
                super();
            }
        });
        list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritPonselMerek.FavoritRSSTask this$1;
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
                view = new Intent(this$0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
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
                this$1 = FavoritPonselMerek.FavoritRSSTask.this;
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
                fav_stat = s13;
                super();
            }
        });
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final FavoritPonselMerek.FavoritRSSTask this$1;
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
                view = new Intent(this$0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
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
                this$1 = FavoritPonselMerek.FavoritRSSTask.this;
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
                fav_stat = s13;
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
            if (!fav_stat.toString().equals("0"))
            {
                break label1;
            }
            imageview1.setBackgroundResource(0x7f020302);
        }
          goto _L9
        imageview1.setBackgroundResource(0x7f020302);
          goto _L9
_L6:
        imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)FavoritPonselMerek.access$0(FavoritPonselMerek.this).get(i)).getRss_img().toString().trim()).toString(), imageMedia, FavoritPonselMerek.access$4(FavoritPonselMerek.this), FavoritPonselMerek.access$3(FavoritPonselMerek.this));
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
        FavoritPonselMerek.access$0(FavoritPonselMerek.this).clear();
        db.resetRSSTables();
    }


    private _cls6.val.fav_stat()
    {
        this$0 = FavoritPonselMerek.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
