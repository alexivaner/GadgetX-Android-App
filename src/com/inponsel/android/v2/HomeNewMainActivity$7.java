// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.daftarharga.DaftarHargaPonsel;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

class this._cls0
    implements android.view.Activity._cls7
{

    final HomeNewMainActivity this$0;

    public void onClick(View view)
    {
        i = new Intent(getApplicationContext(), com/inponsel/android/daftarharga/DaftarHargaPonsel);
        startActivityForResult(i, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    nsel()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}