// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import com.inponsel.android.favorit.FavoritPonselMerek;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGadgetActivity

class this._cls0
    implements Runnable
{

    final HomeGadgetActivity this$0;

    public void run()
    {
        i = new Intent(getApplicationContext(), com/inponsel/android/favorit/FavoritPonselMerek);
        startActivityForResult(i, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    k()
    {
        this$0 = HomeGadgetActivity.this;
        super();
    }
}
