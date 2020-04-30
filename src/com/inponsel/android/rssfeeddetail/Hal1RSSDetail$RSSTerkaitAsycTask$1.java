// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail, RSSDetailTab

class val.rss_title
    implements android.view..RSSTerkaitAsycTask._cls1
{

    final this._cls1 this$1;
    private final String val$id_rss;
    private final String val$rss_id;
    private final String val$rss_title;

    public void onClick(View view)
    {
        cess._mth2(this._cls1.this).idkom_pos = val$id_rss;
        view = new Intent(cess._mth2(this._cls1.this).getActivity(), com/inponsel/android/rssfeeddetail/RSSDetailTab);
        view.putExtra("id_rss", val$rss_id);
        view.putExtra("rss_title", val$rss_title);
        view.putExtra("notif", "gcm");
        view.putExtra("actfrom", "rssfeed");
        view.putExtra("act", "firsttab");
        cess._mth2(this._cls1.this).getActivity().startActivityForResult(view, 0);
        cess._mth2(this._cls1.this).getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = final_;
        val$id_rss = s;
        val$rss_id = s1;
        val$rss_title = String.this;
        super();
    }
}
