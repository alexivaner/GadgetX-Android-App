// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            LoginActivity, RegisterActivity

class this._cls0
    implements android.view.ener
{

    final LoginActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(getApplicationContext(), com/inponsel/android/v2/RegisterActivity);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = LoginActivity.this;
        super();
    }
}
