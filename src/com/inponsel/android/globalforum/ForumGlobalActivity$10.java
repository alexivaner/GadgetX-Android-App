// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.RoomMyDraftPost;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class this._cls0
    implements android.view.umGlobalActivity._cls10
{

    final ForumGlobalActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(ForumGlobalActivity.this, com/inponsel/android/v2/RoomMyDraftPost);
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
        this$0 = ForumGlobalActivity.this;
        super();
    }
}
