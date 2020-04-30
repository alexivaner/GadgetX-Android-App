// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            KomentarHpNews, ProfileOtherUser

class val.nama_komentar
    implements android.view.AsycTask._cls2
{

    final on this$1;
    private final String val$nama_komentar;

    public void onClick(View view)
    {
        view = new Intent(cess._mth2(this._cls1.this), com/inponsel/android/v2/ProfileOtherUser);
        view.putExtra("id_user_view", val$nama_komentar);
        cess._mth2(this._cls1.this).startActivityForResult(view, 0);
        cess._mth2(this._cls1.this).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = final_;
        val$nama_komentar = String.this;
        super();
    }
}
