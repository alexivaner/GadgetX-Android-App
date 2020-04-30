// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ItemRSS;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.TextViewFixTouchConsume;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail, RSSDetailTab

public class this._cls0 extends AsyncTask
{

    final Hal1RSSDetail this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        Log.e("RSSTerkaitAsycTask", "doInBackground");
        JSONObject jsonobject = new JSONObject(getJSONUrl(urlRSS));
        Log.e("RSSTerkaitAsycTask", String.valueOf(jsonobject));
        as = jsonobject.getJSONArray("InPonsel");
        succesStat = jsonobject.getString("success");
        Log.e("bottom_id", bottom_id);
        Log.e("top_id", top_id);
        countKomOld = 0;
        if (!succesStat.equals("1"))
        {
            break MISSING_BLOCK_LABEL_261;
        }
        Hal1RSSDetail.access$10(Hal1RSSDetail.this).clear();
        int i = 0;
_L1:
        if (i >= as.length())
        {
            break MISSING_BLOCK_LABEL_261;
        }
        Object obj = Hal1RSSDetail.this;
        obj.countAllKom = ((Hal1RSSDetail) (obj)).countAllKom + 1;
        obj = Hal1RSSDetail.this;
        obj.countKomOld = ((Hal1RSSDetail) (obj)).countKomOld + 1;
        obj = as.getJSONObject(i);
        Hal1RSSDetail.access$10(Hal1RSSDetail.this).add(new ItemRSS(((JSONObject) (obj)).getString("rss_id"), ((JSONObject) (obj)).getString("rss_id"), ((JSONObject) (obj)).getString("rss_title"), ((JSONObject) (obj)).getString("rss_portal"), "", "", ((JSONObject) (obj)).getString("rss_srclink"), ((JSONObject) (obj)).getString("rss_date"), "", ((JSONObject) (obj)).getString("rss_img"), "", "", "", "", ""));
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
        int i = 0;
_L5:
        if (i >= Hal1RSSDetail.access$10(Hal1RSSDetail.this).size())
        {
            return;
        }
        final String id_rss;
        final String rss_id;
        final String rss_title;
        void1 = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f0300c7, null);
        txtUsername = (TextView)void1.findViewById(0x7f0b0419);
        txtTitle = (TextView)void1.findViewById(0x7f0b05ec);
        img_kom_picture = (ImageView)void1.findViewById(0x7f0b054b);
        imageMedia = (ImageView)void1.findViewById(0x7f0b046c);
        txtIdKom = (TextView)void1.findViewById(0x7f0b054d);
        txtKomentar = (TextViewFixTouchConsume)void1.findViewById(0x7f0b054e);
        txtWaktu = (TextView)void1.findViewById(0x7f0b054c);
        txtImgAva = (TextView)void1.findViewById(0x7f0b05e9);
        txtImgMedia = (TextView)void1.findViewById(0x7f0b05ea);
        id_rss = (ImageView)void1.findViewById(0x7f0b054f);
        id_rss = (ImageView)void1.findViewById(0x7f0b0552);
        txtTotalKom = (TextView)void1.findViewById(0x7f0b034a);
        bottom_list = (LinearLayout)void1.findViewById(0x7f0b0341);
        list_lay_like = (RelativeLayout)void1.findViewById(0x7f0b0342);
        list_lay_dislike = (RelativeLayout)void1.findViewById(0x7f0b0345);
        list_lay_kom = (RelativeLayout)void1.findViewById(0x7f0b0348);
        id_rss = ((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getId();
        rss_id = ((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_id();
        rss_title = ((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_title();
        String s = ((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_portal();
        String s1 = ((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_desc();
        ((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_content();
        ((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_srclink();
        String s2 = ((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_date();
        String s3 = ((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_img_ava();
        String s4 = ((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_img();
        ((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_tot_like();
        ((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_like_stat();
        ((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_tot_komen();
        ((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_fav_stat();
        txtTitle.setText(Html.fromHtml(rss_title));
        txtIdKom.setText(id_rss);
        txtUsername.setText((new StringBuilder(String.valueOf(s))).append(" - ").append(s2).toString());
        txtImgAva.setText(s3);
        txtImgMedia.setText(s4);
        txtKomentar.setText((new StringBuilder()).append(Html.fromHtml(Utility.parseUrl(s1))).toString());
        txtKomentar.setMovementMethod(com.inponsel.android.widget.MovementMethod.getInstance());
        txtKomentar.setVisibility(8);
        imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_img_ava().toString().trim()).toString(), img_kom_picture, Hal1RSSDetail.access$7(Hal1RSSDetail.this), Hal1RSSDetail.access$8(Hal1RSSDetail.this));
        if (!((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_img().trim().equals("") && !((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_img().trim().equals("http://inponsel.co.id/cache/image/fit/50/aHR0cDovL3N0YXRpYy5pbnBvbnNlbC5jby5pZC9pbWFnZXMvbG9nby9sb2dvLW5vLWJvcmRlci1ncmV5LnBuZw=="))
        {
            break MISSING_BLOCK_LABEL_929;
        }
        imageMedia.setVisibility(0);
        imageMedia.setImageResource(0x7f020243);
_L3:
        txtWaktu.setText(((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_date());
        listBerita.addView(void1);
        void1.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal1RSSDetail.RSSTerkaitAsycTask this$1;
            private final String val$id_rss;
            private final String val$rss_id;
            private final String val$rss_title;

            public void onClick(View view)
            {
                idkom_pos = id_rss;
                view = new Intent(getActivity(), com/inponsel/android/rssfeeddetail/RSSDetailTab);
                view.putExtra("id_rss", rss_id);
                view.putExtra("rss_title", rss_title);
                view.putExtra("notif", "gcm");
                view.putExtra("actfrom", "rssfeed");
                view.putExtra("act", "firsttab");
                getActivity().startActivityForResult(view, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = Hal1RSSDetail.RSSTerkaitAsycTask.this;
                id_rss = s;
                rss_id = s1;
                rss_title = s2;
                super();
            }
        });
        i++;
        continue; /* Loop/switch isn't completed */
        imageLoader2.displayImage((new StringBuilder()).append(((ItemRSS)Hal1RSSDetail.access$10(Hal1RSSDetail.this).get(i)).getRss_img().toString().trim()).toString(), imageMedia, Hal1RSSDetail.access$7(Hal1RSSDetail.this), Hal1RSSDetail.access$8(Hal1RSSDetail.this));
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
        Log.e("RSSTerkaitAsycTask", "onPreExecute");
    }


    public _cls1.val.rss_title()
    {
        this$0 = Hal1RSSDetail.this;
        super();
    }
}
