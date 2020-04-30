// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import com.inponsel.android.v2.LoginActivity;

// Referenced classes of package com.inponsel.android.details:
//            SCTerdekatActivity

class this._cls0
    implements com.inponsel.android.utils.ener
{

    final SCTerdekatActivity this$0;

    public void onClick()
    {
        Intent intent = new Intent(getApplicationContext(), com/inponsel/android/v2/LoginActivity);
        intent.putExtra("activity", "main");
        startActivityForResult(intent, 0);
        overridePendingTransition(0x7f040001, 0x7f040002);
    }

    er()
    {
        this$0 = SCTerdekatActivity.this;
        super();
    }
}
