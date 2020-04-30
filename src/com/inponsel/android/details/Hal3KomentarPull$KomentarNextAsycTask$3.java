// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.v2.ProfileOtherUser;

// Referenced classes of package com.inponsel.android.details:
//            Hal3KomentarPull

class val.nama_komentar
    implements android.view.rNextAsycTask._cls3
{

    final this._cls1 this$1;
    private final String val$nama_komentar;

    public void onClick(View view)
    {
        view = new Intent(cess._mth2(this._cls1.this).getActivity(), com/inponsel/android/v2/ProfileOtherUser);
        view.putExtra("id_user_view", val$nama_komentar);
        cess._mth2(this._cls1.this).startActivityForResult(view, 0);
        cess._mth2(this._cls1.this).getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = final_;
        val$nama_komentar = String.this;
        super();
    }
}
