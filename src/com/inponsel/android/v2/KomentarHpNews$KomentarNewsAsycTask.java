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
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
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
//            KomentarHpNews, ImagePagerActivity, ProfileOtherUser

public class this._cls0 extends AsyncTask
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
        final String nama_komentar = ((ItemKomenNews)mArrayListKomNewsData.get(i)).getNama_komentar();
        final String rss_title = ((ItemKomenNews)mArrayListKomNewsData.get(i)).getEmail_komentar();
        ((ItemKomenNews)mArrayListKomNewsData.get(i)).getTanggal_komentar();
        ((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomentar();
        ((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomen_bagus();
        ((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomen_kurang();
        final String usr_pict_komen = ((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen();
        ((ItemKomenNews)mArrayListKomNewsData.get(i)).getReply_to();
        ((ItemKomenNews)mArrayListKomNewsData.get(i)).getNama_to();
        ((ItemKomenNews)mArrayListKomNewsData.get(i)).getKomen_to();
        ((ItemKomenNews)mArrayListKomNewsData.get(i)).getTanggal_to();
        ((ItemKomenNews)mArrayListKomNewsData.get(i)).getMy_like_kom();
        if (((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen().trim().contains(".jpg") || ((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen().toString().trim().contains(".png") || ((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
        {
            imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenNews)mArrayListKomNewsData.get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, KomentarHpNews.access$2(KomentarHpNews.this), KomentarHpNews.access$3(KomentarHpNews.this));
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
        txtKomentar.setMovementMethod(com.inponsel.android.widget.ementMethod.getInstance());
        txtWaktu.setText(Utility.convertDate(((ItemKomenNews)mArrayListKomNewsData.get(i)).getTanggal_komentar()));
        linear_listviewnews.addView(void1);
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final KomentarHpNews.KomentarNewsAsycTask this$1;
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
                this$1 = KomentarHpNews.KomentarNewsAsycTask.this;
                usr_pict_komen = s;
                super();
            }
        });
        img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarHpNews.KomentarNewsAsycTask this$1;
            private final String val$nama_komentar;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/v2/ProfileOtherUser);
                view.putExtra("id_user_view", nama_komentar);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = KomentarHpNews.KomentarNewsAsycTask.this;
                nama_komentar = s;
                super();
            }
        });
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarHpNews.KomentarNewsAsycTask this$1;
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
                this$1 = KomentarHpNews.KomentarNewsAsycTask.this;
                id_rss = s;
                rss_title = s1;
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


    public _cls3.val.rss_title()
    {
        this$0 = KomentarHpNews.this;
        super();
    }
}
