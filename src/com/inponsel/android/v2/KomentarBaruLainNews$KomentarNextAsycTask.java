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
        JSONObject jsonobject = new JSONObject(urlKomenLast);
        as = jsonobject.getJSONArray("InPonsel");
        strKonekStat = jsonobject.getString("success");
        if (!jsonobject.getString("top_id").equals("-"))
        {
            top_id = jsonobject.getString("top_id");
        }
        countKomOld = 0;
        if (strKonekStat.equals("-"))
        {
            break MISSING_BLOCK_LABEL_248;
        }
        int i = 0;
_L1:
        if (i >= as.length())
        {
            break MISSING_BLOCK_LABEL_248;
        }
        Object obj = KomentarBaruLainNews.this;
        obj.countAllKom = ((KomentarBaruLainNews) (obj)).countAllKom + 1;
        obj = KomentarBaruLainNews.this;
        obj.countKomOld = ((KomentarBaruLainNews) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        Log.e("komentarhp", ((JSONObject) (obj)).getString("komentarhp"));
        KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).add(0, new ItemKomenNews(((JSONObject) (obj)).getString("id_komrss"), ((JSONObject) (obj)).getString("id_rss"), ((JSONObject) (obj)).getString("news_title"), ((JSONObject) (obj)).getString("id_user"), ((JSONObject) (obj)).getString("user_name"), "", ((JSONObject) (obj)).getString("tanggal_kom"), ((JSONObject) (obj)).getString("komen_rss"), "", "", ((JSONObject) (obj)).getString("user_photo"), "", "", "", "", ""));
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
        if (strKonekStat.equals("-")) goto _L2; else goto _L1
_L1:
        Log.e("countAllKom", String.valueOf(countAllKom));
        Log.e("mArrayListKomNewsDataold", String.valueOf(KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).size()));
        int i = 0;
_L5:
        if (i >= KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).size())
        {
            void1 = KomentarBaruLainNews.this;
            void1.removeNextIndex = ((KomentarBaruLainNews) (void1)).removeNextIndex + countRemIndex;
            Log.e("removeNextIndex", String.valueOf(removeNextIndex));
            return;
        }
        final String id_rss;
        final String nama_komentar;
        final String rss_title;
        final String usr_pict_komen;
        void1 = KomentarBaruLainNews.this;
        void1.countRemIndex = ((KomentarBaruLainNews) (void1)).countRemIndex + 1;
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
        id_rss = (ImageView)void1.findViewById(0x7f0b054f);
        id_rss = (ImageView)void1.findViewById(0x7f0b0552);
        txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
        txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getId_komentar();
        id_rss = ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getId_rss();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getId_user();
        nama_komentar = ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getNama_komentar();
        rss_title = ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getEmail_komentar();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getTanggal_komentar();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getKomentar();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getKomen_bagus();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getKomen_kurang();
        usr_pict_komen = ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getUsr_pict_komen();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getReply_to();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getNama_to();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getKomen_to();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getTanggal_to();
        ((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getMy_like_kom();
        if (!((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getUsr_pict_komen().trim().contains(".jpg") && !((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getUsr_pict_komen().toString().trim().contains(".png") && !((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getUsr_pict_komen().toString().trim().contains(".jpeg"))
        {
            break MISSING_BLOCK_LABEL_1147;
        }
        imageLoader2.displayImage((new StringBuilder()).append(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getUsr_pict_komen().toString().trim()).toString(), img_kom_picture, KomentarBaruLainNews.access$2(KomentarBaruLainNews.this), KomentarBaruLainNews.access$3(KomentarBaruLainNews.this));
_L3:
        txtIdKom.setText(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getId_komentar().toString());
        txtdisLikeKom.setText(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getKomen_kurang().toString());
        txtLikeKom.setText(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getKomen_bagus().toString());
        txtNamaHp.setText(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getNews_title().toString());
        txtUsername.setText(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getNama_komentar());
        txtKomentar.setText(Html.fromHtml(Utility.parseUrl(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getKomentar().toString())));
        txtKomentar.setMovementMethod(com.inponsel.android.widget.ethod.getInstance());
        txtWaktu.setText(Utility.convertDate(((ItemKomenNews)KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).get(i)).getTanggal_komentar()));
        KomentarBaruLainNews.access$0(KomentarBaruLainNews.this).addView(void1, 0);
        img_kom_picture.setOnLongClickListener(new android.view.View.OnLongClickListener() {

            final KomentarBaruLainNews.KomentarNextAsycTask this$1;
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
                this$1 = KomentarBaruLainNews.KomentarNextAsycTask.this;
                usr_pict_komen = s;
                super();
            }
        });
        img_kom_picture.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarBaruLainNews.KomentarNextAsycTask this$1;
            private final String val$nama_komentar;

            public void onClick(View view)
            {
                view = new Intent(this$0, com/inponsel/android/v2/ProfileOtherUser);
                view.putExtra("id_user_view", nama_komentar);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = KomentarBaruLainNews.KomentarNextAsycTask.this;
                nama_komentar = s;
                super();
            }
        });
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final KomentarBaruLainNews.KomentarNextAsycTask this$1;
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
                this$1 = KomentarBaruLainNews.KomentarNextAsycTask.this;
                id_rss = s;
                rss_title = s1;
                super();
            }
        });
        i++;
        continue; /* Loop/switch isn't completed */
        img_kom_picture.setImageResource(0x7f020297);
          goto _L3
        void1;
_L2:
        return;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        txtbtnheader.setVisibility(8);
        layout_header.setVisibility(0);
        Log.e("mArrayListKomNewsDataNext", String.valueOf(KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).size()));
        KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).clear();
        Log.e("mArrayListKomNewsDataNext", String.valueOf(KomentarBaruLainNews.access$1(KomentarBaruLainNews.this).size()));
    }


    public _cls3.val.rss_title()
    {
        this$0 = KomentarBaruLainNews.this;
        super();
    }
}
