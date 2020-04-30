// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSInteraksiActivity

class val.tl_judul_art
    implements android.view.sycAfterTask._cls3
{

    final n this$1;
    private final String val$tl_id;
    private final String val$tl_judul_art;

    public void onClick(View view)
    {
        view = new Intent(cess._mth2(this._cls1.this), com/inponsel/android/rssfeeddetail/RSSDetailTab);
        view.putExtra("id_rss", val$tl_id);
        view.putExtra("rss_title", val$tl_judul_art);
        view.putExtra("notif", "gcm");
        view.putExtra("actfrom", "rssfeed");
        view.putExtra("act", "firsttab");
        cess._mth2(this._cls1.this).startActivityForResult(view, 0);
        cess._mth2(this._cls1.this).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = final_;
        val$tl_id = s;
        val$tl_judul_art = String.this;
        super();
    }
}
