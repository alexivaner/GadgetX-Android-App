// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemRSS;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

public class this._cls0 extends AsyncTask
{

    final HomeNewMainActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        Log.e("RSSAsycTask", "doInBackground");
        as = new JSONObject(getJSONUrl(urlRSS));
        Log.e("rss_home", getJSONUrl(urlRSS));
        bottom_id = as.getString("bottom_id");
        top_id = as.getString("top_id");
        succesStat = as.getString("success");
        Log.e("bottom_id", bottom_id);
        Log.e("top_id", top_id);
        countKomOld = 0;
        as = as.getJSONArray("InPonsel");
        if (!succesStat.equals("1"))
        {
            break MISSING_BLOCK_LABEL_390;
        }
        HomeNewMainActivity.access$2(HomeNewMainActivity.this).clear();
        listBerita.removeAllViewsInLayout();
        int i = 0;
_L1:
        if (i >= as.length())
        {
            break MISSING_BLOCK_LABEL_390;
        }
        Object obj = HomeNewMainActivity.this;
        obj.countAllKom = ((HomeNewMainActivity) (obj)).countAllKom + 1;
        obj = HomeNewMainActivity.this;
        obj.countKomOld = ((HomeNewMainActivity) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        HomeNewMainActivity.access$2(HomeNewMainActivity.this).add(new ItemRSS(((JSONObject) (obj)).getString("id"), ((JSONObject) (obj)).getString("rss_id"), ((JSONObject) (obj)).getString("rss_title"), ((JSONObject) (obj)).getString("rss_portal"), ((JSONObject) (obj)).getString("rss_desc"), "", ((JSONObject) (obj)).getString("rss_srclink"), ((JSONObject) (obj)).getString("rss_date"), ((JSONObject) (obj)).getString("rss_img_ava"), ((JSONObject) (obj)).getString("rss_img"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_like"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_komen"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("total_hits"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_like_rss"), ((JSONObject) (obj)).getJSONObject("likedislike").getString("my_fav_rss")));
        i++;
          goto _L1
        as;
        as.printStackTrace();
        strKonekStat = "0";
        ll_body.setVisibility(0);
        break MISSING_BLOCK_LABEL_390;
        as;
        as.printStackTrace();
        ll_body.setVisibility(0);
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        progressbar_LatestNews.setVisibility(8);
        if (!succesStat.equals("1")) goto _L2; else goto _L1
_L1:
        int i = 0;
_L5:
        if (i < HomeNewMainActivity.access$2(HomeNewMainActivity.this).size()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300c7, null);
        txtUsername = (TextView)void1.findViewById(0x7f0b0419);
        txtTitle = (TextView)void1.findViewById(0x7f0b05ec);
        txtTitle.setTypeface(Typeface.DEFAULT, 0);
        img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
        imageMedia = (ImageView)void1.findViewById(0x7f0b046c);
        txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
        txtKomentar = (TextViewFixTouchConsume)void1.findViewById(0x7f0b054e);
        txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
        txtImgAva = (TextView)void1.findViewById(0x7f0b05e9);
        txtImgMedia = (TextView)void1.findViewById(0x7f0b05ea);
        final String id_rss = (ImageView)void1.findViewById(0x7f0b054f);
        id_rss = (ImageView)void1.findViewById(0x7f0b0552);
        txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
        txtdisLikeKom = (TextView)void1.findViewById(0x7f0b0554);
        id_rss = ((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getId();
        final String rss_id = ((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_id();
        final String rss_title = ((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_title();
        final String rss_portal = ((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_portal();
        final String rss_desc = ((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_desc();
        ((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_content();
        final String rss_srclink = ((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_srclink();
        final String rss_date = ((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_date();
        final String rss_img_ava = ((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_img_ava();
        final String rss_img = ((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_img();
        final String total_like = ((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_tot_like();
        final String like_stat = ((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_like_stat();
        final String total_komen = ((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_tot_komen();
        final String fav_stat = ((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_fav_stat();
        txtTitle.setText(Html.fromHtml(rss_title));
        txtIdKom.setText(id_rss);
        txtUsername.setText((new StringBuilder(String.valueOf(rss_portal))).append(" - ").append(Utility.convertDate(rss_date)).toString());
        txtImgAva.setText(rss_img_ava);
        txtImgMedia.setText(rss_img);
        txtKomentar.setText((new StringBuilder()).append(Html.fromHtml(Utility.parseUrl(rss_desc))).toString());
        txtKomentar.setMovementMethod(com.inponsel.android.widget.kMovementMethod.getInstance());
        txtKomentar.setVisibility(8);
        txtLikeKom.setText(total_like);
        if (((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_img().trim().equals(""))
        {
            imageMedia.setVisibility(0);
            imageMedia.setImageResource(0x7f020243);
        } else
        {
            Picasso.with(HomeNewMainActivity.this).load(((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_img().toString().trim()).tag(HomeNewMainActivity.this).placeholder(0x7f020243).error(0x7f020243).into(imageMedia, new Callback() {

                final HomeNewMainActivity.RSSAsycTask this$1;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    imageMedia.setVisibility(0);
                }

            
            {
                this$1 = HomeNewMainActivity.RSSAsycTask.this;
                super();
            }
            });
        }
        txtWaktu.setText(Utility.convertDate(((ItemRSS)HomeNewMainActivity.access$2(HomeNewMainActivity.this).get(i)).getRss_date()));
        listBerita.addView(void1);
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity.RSSAsycTask this$1;
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
                view.putExtra("kategori_tag", "");
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
                this$1 = HomeNewMainActivity.RSSAsycTask.this;
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
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        Log.e("RSSAsycTask", "onPreExecute");
    }


    public _cls2.val.fav_stat()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
