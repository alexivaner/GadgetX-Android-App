// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            HomeAppsActivity, AppsSelengkap

class this._cls0
    implements android.view.r
{

    final HomeAppsActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(HomeAppsActivity.this, com/inponsel/android/v2/AppsSelengkap);
        view.putExtra("category", "weekapps");
        view.putExtra("title", "Aplikasi Minggu Ini");
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = HomeAppsActivity.this;
        super();
    }
}
