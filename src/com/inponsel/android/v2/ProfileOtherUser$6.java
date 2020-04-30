// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.details.DetailsPonsel;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileOtherUser

class this._cls0
    implements android.view.r
{

    final ProfileOtherUser this$0;

    public void onClick(View view)
    {
        view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
        view.putExtra("id_hph", strIDHP1);
        view.putExtra("namalengkap", strMerek1);
        view.putExtra("codename", strCodename1);
        view.putExtra("model", "");
        view.putExtra("merk", "");
        view.putExtra("gambar", "");
        view.putExtra("hrg_baru", "");
        view.putExtra("hrg_bekas", "");
        view.putExtra("tot_like", "");
        view.putExtra("tot_dislike", "");
        view.putExtra("tot_komen", "");
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = ProfileOtherUser.this;
        super();
    }
}
