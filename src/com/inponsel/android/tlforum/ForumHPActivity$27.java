// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.RoomPostPertanyaan;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

class this._cls0
    implements android.view.r
{

    final ForumHPActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(ForumHPActivity.this, com/inponsel/android/v2/RoomPostPertanyaan);
        view.putExtra("id_hph", id_hp);
        view.putExtra("namalengkap", namalengkap);
        view.putExtra("codename", codename);
        view.putExtra("model", model);
        view.putExtra("merk", merk);
        view.putExtra("gambar", gambar);
        view.putExtra("from", "apps");
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = ForumHPActivity.this;
        super();
    }
}
