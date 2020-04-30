// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail, RSSKomenTab

class this._cls0
    implements android.view.ener
{

    final Hal1RSSDetail this$0;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), com/inponsel/android/rssfeeddetail/RSSKomenTab);
        view.putExtra("actfrom", "rssfeed");
        view.putExtra("act", "komen");
        view.putExtra("rss_id", rss_id);
        view.putExtra("kategori_tag", kategori_tag);
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
        getActivity().startActivityForResult(view, 0);
        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = Hal1RSSDetail.this;
        super();
    }
}
