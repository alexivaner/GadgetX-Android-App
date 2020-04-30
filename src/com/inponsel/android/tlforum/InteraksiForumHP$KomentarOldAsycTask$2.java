// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.ProfileOtherUser;

// Referenced classes of package com.inponsel.android.tlforum:
//            InteraksiForumHP

class val.id_user
    implements android.view.arOldAsycTask._cls2
{

    final ion this$1;
    private final String val$id_user;

    public void onClick(View view)
    {
        view = new Intent(cess._mth2(this._cls1.this), com/inponsel/android/v2/ProfileOtherUser);
        view.putExtra("id_user_view", val$id_user);
        cess._mth2(this._cls1.this).startActivityForResult(view, 0);
        cess._mth2(this._cls1.this).overridePendingTransition(0x7f040003, 0x7f040004);
    }

    I()
    {
        this$1 = final_i;
        val$id_user = String.this;
        super();
    }
}
