// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, TurunHargaPonselActivity

class this._cls0
    implements Runnable
{

    final BaseDrawer this$0;

    public void run()
    {
        i = new Intent(getApplicationContext(), com/inponsel/android/v2/TurunHargaPonselActivity);
        startActivityForResult(i, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    elActivity()
    {
        this$0 = BaseDrawer.this;
        super();
    }
}
