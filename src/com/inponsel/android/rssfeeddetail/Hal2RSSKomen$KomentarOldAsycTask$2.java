// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.v2.ProfileOtherUser;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal2RSSKomen

class val.id_user
    implements android.view.KomentarOldAsycTask._cls2
{

    final this._cls1 this$1;
    private final String val$id_user;

    public void onClick(View view)
    {
        view = new Intent(cess._mth2(this._cls1.this).getActivity(), com/inponsel/android/v2/ProfileOtherUser);
        view.putExtra("id_user_view", val$id_user);
        cess._mth2(this._cls1.this).startActivityForResult(view, 0);
        cess._mth2(this._cls1.this).getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = final_;
        val$id_user = String.this;
        super();
    }
}
