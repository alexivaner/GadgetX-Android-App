// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity, RSSFeedByTag

class this._cls1
    implements android.view.MoreTask._cls2
{

    final nsition this$1;

    public void onClick(View view)
    {
        view = new Intent(cess._mth2(this._cls1.this), com/inponsel/android/v2/RSSFeedByTag);
        view.putExtra("tag_code", "0");
        view.putExtra("kategori_tag", cess._mth2(this._cls1.this).title_single);
        view.putExtra("tag_key", (new StringBuilder("al:")).append(cess._mth2(this._cls1.this).tag_key_single).toString());
        cess._mth2(this._cls1.this).startActivityForResult(view, 0);
        cess._mth2(this._cls1.this).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
