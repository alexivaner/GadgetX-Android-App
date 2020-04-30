// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.Log;
import com.inponsel.android.v2.RoomPostArtikel;

// Referenced classes of package com.inponsel.android.globalforum:
//            PostGlobalForum

class this._cls0
    implements android.view.er
{

    final PostGlobalForum this$0;

    public void onClick(View view)
    {
        Log.e("forum_tag", forum_tag.replaceAll(",$", ""));
        view = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomPostArtikel);
        view.putExtra("action", "post");
        view.putExtra("id_hph", "0");
        view.putExtra("namalengkap", "");
        view.putExtra("codename", "");
        view.putExtra("model", "");
        view.putExtra("merk", "");
        view.putExtra("gambar", "");
        view.putExtra("from", "apps");
        view.putExtra("tl_type", "global");
        view.putExtra("tl_tag", forum_tag);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = PostGlobalForum.this;
        super();
    }
}
