// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.RoomPenggunaHp;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

class this._cls0
    implements android.view.er
{

    final ForumHPActivity this$0;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(ForumHPActivity.this))
        {
            view = new Intent(ForumHPActivity.this, com/inponsel/android/v2/RoomPenggunaHp);
            view.putExtra("kota", "");
            view.putExtra("kota_id", "");
            view.putExtra("prov", "");
            view.putExtra("merk", merk);
            view.putExtra("model", model);
            view.putExtra("codename", codename);
            startActivityForResult(view, 0);
            overridePendingTransition(0x7f040003, 0x7f040004);
            return;
        } else
        {
            ForumHPActivity.access$3(ForumHPActivity.this, "Perhatian", "Untuk masuk ke halaman ini diharuskan login terlebih dahulu");
            return;
        }
    }

    ()
    {
        this$0 = ForumHPActivity.this;
        super();
    }
}
