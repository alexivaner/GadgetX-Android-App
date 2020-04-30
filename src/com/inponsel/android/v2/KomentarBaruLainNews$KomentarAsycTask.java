// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.os.AsyncTask;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.actionbarsherlock.app.ActionBar;
import com.inponsel.android.adapter.ItemKomenNews;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            KomentarBaruLainNews, ImagePagerActivity, ProfileOtherUser

public class this._cls0 extends AsyncTask
{

    final KomentarBaruLainNews this$0;

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
        bottom_id = jsonobject.getString("bottom_id");
        top_id = jsonobject.getString("top_id");
        countKomOld = 0;
        if (strKonekStat.equals("-"))
        {
            break MISSING_BLOCK_LABEL_250;
        }
        int i = 0;
_L1:
        if (i >= as.length())
        {
            break MISSING_BLOCK_LABEL_250;
        }
        Object obj = KomentarBaruLainNews.this;
        obj.countAllKom = ((KomentarBaruLainNews) (obj)).countAllKom + 1;
        obj = KomentarBaruLainNews.this;
        obj.countKomOld = ((KomentarBaruLainNews) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).add(new ItemKomenNews(((JSONObject) (obj)).getString("id_komrss"), ((JSONObject) (obj)).getString("id_rss"), ((JSONObject) (obj)).getString("news_title"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("user_name"), "", ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("komen_rss"), "", "", ((JSONObject) (obj)).getString("user_photo"), "", "", "", "", ""));
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
            break MISSING_BLOCK_LABEL_1233;
        }
        if (KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).size() < 10)
        {
            grup_footer.setVisibility(8);
        } else
        {
            grup_footer.setVisibility(0);
        }
        i = 0;
_L3:
        if (i < KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).size()) goto _L2; else goto _L1
_L1:
        txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarBaruLainNews.KomentarAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    txtbtnheader.setVisibility(8);
                    view = this$0;
                    view.limit = ((KomentarBaruLainNews) (view)).limit + 15;
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_news_lain").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(str_id_user).append("&top_id=").append(top_id).toString();
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarBaruLainNews.KomentarNextAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new KomentarBaruLainNews.KomentarNextAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = KomentarBaruLainNews.KomentarAsycTask.this;
                super();
            }
        });
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarBaruLainNews.KomentarAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    limit = 0;
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_news_lain").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(str_id_user).append("&bottom_id=").append(bottom_id).toString();
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarBaruLainNews.KomentarOldAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new KomentarBaruLainNews.KomentarOldAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = KomentarBaruLainNews.KomentarAsycTask.this;
                super();
            }
        });
        layout_empty.setVisibility(8);
        scrollviewKomen.setVisibility(0);
_L4:
        getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>Aktivitas ")).append(aktifitas_name).append("</font>").toString()));
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
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getId_komentar();
        id_rss = ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getId_rss();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getId_user();
        final String nama_komentar = ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getNama_komentar();
        final String rss_title = ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getEmail_komentar();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getTanggal_komentar();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getKomentar();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getKomen_bagus();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getKomen_kurang();
        final String usr_pict_komen = ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getUsr_pict_komen();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getReply_to();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getNama_to();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getKomen_to();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getTanggal_to();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getMy_like_kom();
        if (((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getUsr_pict_komen().toString().trim().contains(".png") || ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
        {
            imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, KomentarBaruLainNews.access$2(KomentarBaruLainNews.this), KomentarBaruLainNews.access$3(KomentarBaruLainNews.this));
        } else
        {
            img_kom_picture.setImageResource(0x7f020297);
        }
        txtIdKom.setText(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getId_komentar().toString());
        txtdisLikeKom.setText(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getKomen_kurang().toString());
        txtLikeKom.setText(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getKomen_bagus().toString());
        txtNamaHp.setText(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getNews_title().toString());
        aktifitas_name = ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getNama_komentar();
        txtUsername.setText(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getNama_komentar());
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getKomentar().toString())));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.entMethod.getInstance());
        txtWaktu.setText(Utility.convertDate(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getTanggal_komentar()));
        KomentarBaruLainNews.access$0(KomentarBaruLainNews.this).addView(void1);
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final KomentarBaruLainNews.KomentarAsycTask this$1;
            private final String val$usr_pict_komen;

            public boolean onLongClick(View view)
            {
                view = new ArrayList();
                view.add((new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(usr_pict_komen.toString().trim()).toString());
                view = (String[])view.toArray(new String[view.size()]);
                Intent intent = new Intent(this$0, com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view);
                intent.putExtra("pos", 0);
                startActivity(intent);
                return false;
            }

            
            {
                this$1 = KomentarBaruLainNews.KomentarAsycTask.this;
                usr_pict_komen = s;
                super();
            }
        });
        img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarBaruLainNews.KomentarAsycTask this$1;
            private final String val$nama_komentar;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/v2/ProfileOtherUser);
                view.putExtra("id_user_view", nama_komentar);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = KomentarBaruLainNews.KomentarAsycTask.this;
                nama_komentar = s;
                super();
            }
        });
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarBaruLainNews.KomentarAsycTask this$1;
            private final String val$id_rss;
            private final String val$rss_title;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/rssfeeddetail/RSSDetailTab);
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
                this$1 = KomentarBaruLainNews.KomentarAsycTask.this;
                id_rss = s;
                rss_title = s1;
                super();
            }
        });
        i++;
          goto _L3
        txtbtnheader.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarBaruLainNews.KomentarAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    txtbtnheader.setVisibility(8);
                    view = this$0;
                    view.limit = ((KomentarBaruLainNews) (view)).limit + 15;
                    urlKomenLast = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_news_lain").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(str_id_user).append("&top_id=").append(top_id).toString();
                    Log.e("urlKomenLast", urlKomenLast);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarBaruLainNews.KomentarNextAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new KomentarBaruLainNews.KomentarNextAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = KomentarBaruLainNews.KomentarAsycTask.this;
                super();
            }
        });
        txtbtnfooter.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarBaruLainNews.KomentarAsycTask this$1;

            public void onClick(View view)
            {
                try
                {
                    limit = 0;
                    urlKomenOld = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("komen_news_lain").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(str_id_user).append("&bottom_id=").append(bottom_id).toString();
                    Log.e("urlKomenOld", urlKomenOld);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        (new KomentarBaruLainNews.KomentarOldAsycTask(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                (new KomentarBaruLainNews.KomentarOldAsycTask(this$0)).execute(new String[0]);
                return;
            }

            
            {
                this$1 = KomentarBaruLainNews.KomentarAsycTask.this;
                super();
            }
        });
        scrollviewKomen.setVisibility(8);
        layout_empty.setVisibility(0);
        pop_progressbar_middle.setVisibility(8);
        pop_txt_empty.setVisibility(0);
        pop_txt_empty.setText("Belum ada komentar");
          goto _L4
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        limit = 0;
        Log.e("KomentarAsycTask", "onPreExecute");
        scrollviewKomen.setVisibility(8);
        layout_empty.setVisibility(0);
        KomentarBaruLainNews.access$0(KomentarBaruLainNews.this).removeAllViewsInLayout();
        KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).clear();
    }


    public _cls7.this._cls1()
    {
        this$0 = KomentarBaruLainNews.this;
        super();
    }
}
