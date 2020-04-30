// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal3PencNews

class val.fav_stat
    implements android.view.ener
{

    final Hal3PencNews this$0;
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
        idkom_pos = val$id_rss;
        view = new Intent(getActivity(), com/inponsel/android/rssfeeddetail/RSSDetailTab);
        view.putExtra("kategori_tag", "");
        view.putExtra("act", "komen");
        view.putExtra("actfrom", "rssfeed");
        view.putExtra("rss_id", val$rss_id);
        view.putExtra("id_rss", val$id_rss);
        view.putExtra("rss_title", val$rss_title);
        view.putExtra("rss_portal", val$rss_portal);
        view.putExtra("rss_desc", val$rss_desc);
        view.putExtra("rss_srclink", val$rss_srclink);
        view.putExtra("rss_date", val$rss_date);
        view.putExtra("rss_img_ava", val$rss_img_ava);
        view.putExtra("rss_img", val$rss_img);
        view.putExtra("total_like", val$total_like);
        view.putExtra("like_stat", val$like_stat);
        view.putExtra("total_komen", val$total_komen);
        view.putExtra("fav_stat", val$fav_stat);
        startActivityForResult(view, 0);
        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = final_hal3pencnews;
        val$id_rss = s;
        val$rss_id = s1;
        val$rss_title = s2;
        val$rss_portal = s3;
        val$rss_desc = s4;
        val$rss_srclink = s5;
        val$rss_date = s6;
        val$rss_img_ava = s7;
        val$rss_img = s8;
        val$total_like = s9;
        val$like_stat = s10;
        val$total_komen = s11;
        val$fav_stat = String.this;
        super();
    }
}
