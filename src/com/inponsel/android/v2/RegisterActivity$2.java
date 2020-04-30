// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity, KebijakanActivity

class this._cls0
    implements com.inponsel.android.utils.stener
{

    final RegisterActivity this$0;

    public void onClick()
    {
        Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/KebijakanActivity);
        startActivityForResult(intent, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    kListener()
    {
        this$0 = RegisterActivity.this;
        super();
    }
}
