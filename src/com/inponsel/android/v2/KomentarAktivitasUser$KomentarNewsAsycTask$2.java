// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;

// Referenced classes of package com.inponsel.android.v2:
//            KomentarAktivitasUser

class val.rss_title
    implements android.view.AsycTask._cls2
{

    final on this$1;
    private final String val$id_rss;
    private final String val$rss_title;

    public void onClick(View view)
    {
        view = new Intent(cess._mth2(this._cls1.this), com/inponsel/android/rssfeeddetail/RSSDetailTab);
        view.putExtra("actfrom", "rssfeed");
        view.putExtra("kategori_tag", "");
        view.putExtra("act", "komen");
        view.putExtra("rss_id", "");
        view.putExtra("id_rss", val$id_rss);
        view.putExtra("rss_title", val$rss_title);
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
        cess._mth2(this._cls1.this).startActivityForResult(view, 0);
        cess._mth2(this._cls1.this).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = final_;
        val$id_rss = s;
        val$rss_title = String.this;
        super();
    }
}
