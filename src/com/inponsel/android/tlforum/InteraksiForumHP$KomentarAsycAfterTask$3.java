// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.timelinedetail.Hal1TLDetailActivity;

// Referenced classes of package com.inponsel.android.tlforum:
//            InteraksiForumHP

class val.tl_namalengkap
    implements android.view.AsycAfterTask._cls3
{

    final n this$1;
    private final String val$tl_id;
    private final String val$tl_judul_art;
    private final String val$tl_namalengkap;

    public void onClick(View view)
    {
        view = new Intent(cess._mth2(this._cls1.this), com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
        view.putExtra("id_artanya", cess._mth2(this._cls1.this).idkom_pos);
        view.putExtra("act", "first");
        view.putExtra("tl_id", val$tl_id);
        view.putExtra("act", "gcm");
        view.putExtra("tl_judul", val$tl_judul_art);
        view.putExtra("namalengkap", val$tl_namalengkap);
        cess._mth2(this._cls1.this).startActivityForResult(view, 0);
        cess._mth2(this._cls1.this).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = final_;
        val$tl_id = s;
        val$tl_judul_art = s1;
        val$tl_namalengkap = String.this;
        super();
    }
}
