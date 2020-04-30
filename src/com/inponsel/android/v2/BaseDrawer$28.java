// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, HomeNewsActivity

class this._cls0
    implements Runnable
{

    final BaseDrawer this$0;

    public void run()
    {
        i = new Intent(getApplicationContext(), com/inponsel/android/v2/HomeNewsActivity);
        i.putExtra("tag_timeline", "terbaru");
        i.putExtra("tag_code", "tagall");
        i.putExtra("tag_page", "1");
        startActivityForResult(i, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ty()
    {
        this$0 = BaseDrawer.this;
        super();
    }
}
