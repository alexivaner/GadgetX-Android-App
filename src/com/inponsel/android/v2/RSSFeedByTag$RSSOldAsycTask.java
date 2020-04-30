// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

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
import android.widget.ScrollView;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemRSS;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.rssfeeddetail.RSSKomenTab;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RSSFeedByTag, ImagePagerActivity, RegisterActivity, LoginActivity

public class this._cls0 extends AsyncTask
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
        RSSFeedByTag.access$0(RSSFeedByTag.this).add(new ItemRSS(((JSONObject) (obj)).getString("id"), ((JSONObject) (obj)).getString("rss_id"), ((JSONObject) (obj)).getString("rss_title"), ((JSONObject) (obj)).getString("rss_portal"), ((JSONObject) (obj)).getString("rss_desc"), "", ((JSONObject) (obj)).getString("rss_srclink"), ((JSONObject) (obj)).getString("rss_date"), ((JSONObject) (obj)).getString("rss_img_ava"), ((JSONObject) (obj)).getString("rss_img"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_like"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_komen"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_hits"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_like_rss"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_fav_rss")));
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
        Log.e("mArrayListDataOld", String.valueOf(RSSFeedByTag.access$0(RSSFeedByTag.this).size()));
        ImageView imageview;
        ImageView imageview1;
        final TextView txt_fav_news_1;
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
        final String fav_stat;
        int i;
        if (!strKonekStat.equals("-"))
        {
            i = 0;
        } else
        {
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final RSSFeedByTag.RSSOldAsycTask this$1;

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
                            (new RSSFeedByTag.RSSNextAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new RSSFeedByTag.RSSNextAsycTask(this$0)).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = RSSFeedByTag.RSSOldAsycTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final RSSFeedByTag.RSSOldAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        view = this$0;
                        view.page_counter = ((RSSFeedByTag) (view)).page_counter + 1;
                        limit = 0;
                        urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
                        Log.e("urlRSSOld", urlRSSOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new RSSFeedByTag.RSSOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new RSSFeedByTag.RSSOldAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = RSSFeedByTag.RSSOldAsycTask.this;
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
        if (i >= RSSFeedByTag.access$0(RSSFeedByTag.this).size())
        {
            txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

                final RSSFeedByTag.RSSOldAsycTask this$1;

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
                            (new RSSFeedByTag.RSSNextAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new RSSFeedByTag.RSSNextAsycTask(this$0)).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = RSSFeedByTag.RSSOldAsycTask.this;
                super();
            }
            });
            txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

                final RSSFeedByTag.RSSOldAsycTask this$1;

                public void onClick(View view)
                {
                    try
                    {
                        view = this$0;
                        view.page_counter = ((RSSFeedByTag) (view)).page_counter + 1;
                        limit = 0;
                        urlRSSOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("rss_by_tag").append(Utility.BASE_FORMAT).append("?").append("bottom_id=").append(URLEncoder.encode(bottom_id, "utf-8")).append("&t=").append(t).append("&idusr=").append(user_id).append("&tag=").append(tag_code).append("&key=").append(tag_key).append("&page=").append(page_counter).toString();
                        Log.e("urlRSSOld", urlRSSOld);
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            (new RSSFeedByTag.RSSOldAsycTask()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                    (new RSSFeedByTag.RSSOldAsycTask()).execute(new String[0]);
                    return;
                }

            
            {
                this$1 = RSSFeedByTag.RSSOldAsycTask.this;
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
        txt_fav_news_1 = (TextView)void1.findViewById(0x7f0b0650);
        id_rss = ((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getId();
        rss_id = ((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_id();
        rss_title = ((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_title();
        rss_portal = ((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_portal();
        rss_desc = ((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_desc();
        ((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_content();
        rss_srclink = ((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_srclink();
        rss_date = ((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_date();
        rss_img_ava = ((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_img_ava();
        rss_img = ((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_img();
        total_like = ((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_tot_like();
        like_stat = ((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_like_stat();
        total_komen = ((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_tot_komen();
        fav_stat = ((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_fav_stat();
        txt_fav_news_1.setText(fav_stat);
        Log.e("fav1519", fav_stat);
        txtTitle.setText(Html.fromHtml(rss_title));
        txtIdKom.setText(id_rss);
        txtUsername.setText(rss_portal);
        txtImgAva.setText(rss_img_ava);
        txtImgMedia.setText(rss_img);
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(rss_desc)));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.lLinkMovementMethod.getInstance());
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
        if (!fav_stat.toString().equals("1")) goto _L2; else goto _L1
_L1:
        imageview1.setBackgroundResource(0x7f020303);
_L3:
        imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_img_ava().toString().trim()).toString(), img_kom_picture, RSSFeedByTag.access$1(RSSFeedByTag.this), RSSFeedByTag.access$2(RSSFeedByTag.this));
        if (((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_img().trim().equals(""))
        {
            imageMedia.setVisibility(8);
        } else
        {
            imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_img().toString().trim()).toString(), imageMedia, RSSFeedByTag.access$1(RSSFeedByTag.this), RSSFeedByTag.access$2(RSSFeedByTag.this));
        }
        txtWaktu.setText(Utility.convertDate(((ItemRSS)RSSFeedByTag.access$0(RSSFeedByTag.this).get(i)).getRss_date()));
        RSSFeedByTag.access$3(RSSFeedByTag.this).addView(void1, RSSFeedByTag.access$3(RSSFeedByTag.this).getChildCount());
        imageMedia.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSFeedByTag.RSSOldAsycTask this$1;
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
                this$1 = RSSFeedByTag.RSSOldAsycTask.this;
                rss_img = s;
                super();
            }
        });
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final RSSFeedByTag.RSSOldAsycTask this$1;
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
                this$1 = RSSFeedByTag.RSSOldAsycTask.this;
                rss_img_ava = s;
                super();
            }
        });
        list_lay_like.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSFeedByTag.RSSOldAsycTask this$1;
            private final String val$id_rss;

            public void onClick(View view)
            {
                if (userFunctions.isUserLoggedIn(this$0))
                {
                    statuslike = "1";
                    idkom_pos = id_rss;
                    querylike = (new StringBuilder("status=")).append(statuslike).append("&id_rss=").append(id_rss).append("&id_usr=").append(user_id).append("&t=").append(t).toString();
                    Log.e("querylike", querylike);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new RSSFeedByTag.PostBagusKurangTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                        return;
                    } else
                    {
                        (new RSSFeedByTag.PostBagusKurangTask(this$0)).execute(new Void[0]);
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
                this$1 = RSSFeedByTag.RSSOldAsycTask.this;
                id_rss = s;
                super();
            }
        });
        list_lay_favorite.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSFeedByTag.RSSOldAsycTask this$1;
            private final String val$id_rss;
            private final String val$rss_srclink;
            private final TextView val$txt_fav_news_1;

            public void onClick(View view)
            {
                idkom_pos = id_rss;
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
                                (new RSSFeedByTag.FavoritTask(this$0)).execute(new Void[0]);
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
                                (new RSSFeedByTag.FavoritTask(this$0)).execute(new Void[0]);
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
                this$1 = RSSFeedByTag.RSSOldAsycTask.this;
                id_rss = s;
                rss_srclink = s1;
                txt_fav_news_1 = textview;
                super();
            }
        });
        list_lay_kom.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSFeedByTag.RSSOldAsycTask this$1;
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
                view = new Intent(this$0, com/inponsel/android/rssfeeddetail/RSSKomenTab);
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
                this$1 = RSSFeedByTag.RSSOldAsycTask.this;
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
                fav_stat = s12;
                super();
            }
        });
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final RSSFeedByTag.RSSOldAsycTask this$1;
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
                view = new Intent(this$0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
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
                this$1 = RSSFeedByTag.RSSOldAsycTask.this;
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
                fav_stat = s12;
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
        if (fav_stat.toString().equals("0"))
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
        Log.e("mArrayListDataOld", String.valueOf(RSSFeedByTag.access$0(RSSFeedByTag.this).size()));
        RSSFeedByTag.access$0(RSSFeedByTag.this).clear();
        Log.e("mArrayListDataOld", String.valueOf(RSSFeedByTag.access$0(RSSFeedByTag.this).size()));
    }


    public _cls9.this._cls1()
    {
        this$0 = RSSFeedByTag.this;
        super();
    }
}
