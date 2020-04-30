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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemRSS;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Utility;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

public class this._cls0 extends AsyncTask
{

    final HomeNewsActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        Log.e("RSSAsycTask", "doInBackground");
        JSONObject jsonobject = new JSONObject(getJSONUrl(urlRSS));
        as = jsonobject.getJSONArray("InPonsel");
        bottom_id = jsonobject.getString("bottom_id");
        top_id = jsonobject.getString("top_id");
        succesStat = jsonobject.getString("success");
        Log.e("bottom_id", bottom_id);
        Log.e("top_id", top_id);
        if (!succesStat.equals("1"))
        {
            break MISSING_BLOCK_LABEL_283;
        }
        int i = 0;
_L1:
        if (i >= as.length())
        {
            break MISSING_BLOCK_LABEL_283;
        }
        JSONObject jsonobject1 = as.getJSONObject(i);
        HomeNewsActivity.access$0(HomeNewsActivity.this).add(new ItemRSS(jsonobject1.getString("id"), jsonobject1.getString("rss_id"), jsonobject1.getString("rss_title"), jsonobject1.getString("rss_portal"), jsonobject1.getString("rss_desc"), "", jsonobject1.getString("rss_srclink"), jsonobject1.getString("rss_date"), jsonobject1.getString("rss_img_ava"), jsonobject1.getString("rss_img"), jsonobject1.getJSONObject("likedislike").getString("total_like"), jsonobject1.getJSONObject("likedislike").getString("total_komen"), jsonobject1.getJSONObject("likedislike").getString("total_hits"), jsonobject1.getJSONObject("likedislike").getString("my_like_rss"), jsonobject1.getJSONObject("likedislike").getString("my_fav_rss")));
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
        if (!succesStat.equals("1")) goto _L2; else goto _L1
_L1:
        int i;
        listBerita.removeAllViewsInLayout();
        i = 0;
_L5:
        if (i < HomeNewsActivity.access$0(HomeNewsActivity.this).size()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        void1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030141, null);
        TextView textview = (TextView)void1.findViewById(0x7f0b0419);
        TextView textview1 = (TextView)void1.findViewById(0x7f0b05ec);
        final ImageView imageMedia = (ImageView)void1.findViewById(0x7f0b054b);
        imageMedia = (ImageView)void1.findViewById(0x7f0b046c);
        TextView textview2 = (TextView)void1.findViewById(0x7f0b054d);
        TextView textview3 = (TextView)void1.findViewById(0x7f0b054e);
        TextView textview4 = (TextView)void1.findViewById(0x7f0b054c);
        TextView textview5 = (TextView)void1.findViewById(0x7f0b05e9);
        TextView textview6 = (TextView)void1.findViewById(0x7f0b05ea);
        Object obj = (ImageView)void1.findViewById(0x7f0b054f);
        obj = (ImageView)void1.findViewById(0x7f0b0552);
        txtLikeKom = (TextView)void1.findViewById(0x7f0b0551);
        obj = (TextView)void1.findViewById(0x7f0b0554);
        obj = (TextView)void1.findViewById(0x7f0b034a);
        TextView textview7 = (TextView)void1.findViewById(0x7f0b0650);
        final String id_rss = (LinearLayout)void1.findViewById(0x7f0b0341);
        id_rss = (RelativeLayout)void1.findViewById(0x7f0b0342);
        id_rss = (RelativeLayout)void1.findViewById(0x7f0b0345);
        id_rss = (RelativeLayout)void1.findViewById(0x7f0b0348);
        id_rss = (RelativeLayout)void1.findViewById(0x7f0b0665);
        id_rss = (ImageView)void1.findViewById(0x7f0b05f1);
        id_rss = ((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getId();
        final String rss_id = ((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_id();
        final String rss_title = ((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_title();
        final String rss_portal = ((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_portal();
        final String rss_desc = ((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_desc();
        ((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_content();
        final String rss_srclink = ((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_srclink();
        final String rss_date = ((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_date();
        final String rss_img_ava = ((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_img_ava();
        final String rss_img = ((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_img();
        final String total_like = ((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_tot_like();
        final String like_stat = ((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_like_stat();
        final String total_komen = ((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_tot_komen();
        final String fav_stat = ((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_fav_stat();
        textview7.setText(fav_stat);
        textview1.setText(Html.fromHtml(rss_title));
        textview2.setText(id_rss);
        textview.setText((new StringBuilder(String.valueOf(rss_portal))).append(" - ").append(Utility.convertDate(rss_date)).toString());
        textview5.setText(rss_img_ava);
        textview6.setText(rss_img);
        textview3.setText(Html.fromHtml(Utility.parseUrl(rss_desc)));
        textview3.setMovementMethod(com.inponsel.android.widget.ementMethod.getInstance());
        txtLikeKom.setText(total_like);
        ((TextView) (obj)).setText(total_komen);
        if (((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_img().trim().equals(""))
        {
            imageMedia.setVisibility(0);
            imageMedia.setImageResource(0x7f020243);
        } else
        {
            Picasso.with(HomeNewsActivity.this).load(((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_img().toString().trim()).tag(HomeNewsActivity.this).error(0x7f020243).placeholder(0x7f020243).into(imageMedia, new Callback() {

                final HomeNewsActivity.RSSRefreshAsycTask this$1;
                private final ImageView val$imageMedia;

                public void onError()
                {
                }

                public void onSuccess()
                {
                    imageMedia.setVisibility(0);
                }

            
            {
                this$1 = HomeNewsActivity.RSSRefreshAsycTask.this;
                imageMedia = imageview;
                super();
            }
            });
        }
        textview4.setText(Utility.convertDate(((ItemRSS)HomeNewsActivity.access$0(HomeNewsActivity.this).get(i)).getRss_date()));
        listBerita.addView(void1);
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewsActivity.RSSRefreshAsycTask this$1;
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
                this$1 = HomeNewsActivity.RSSRefreshAsycTask.this;
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
        HomeNewsActivity.access$0(HomeNewsActivity.this).clear();
    }


    public _cls2.val.fav_stat()
    {
        this$0 = HomeNewsActivity.this;
        super();
    }
}
