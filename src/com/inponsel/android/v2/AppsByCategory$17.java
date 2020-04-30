// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.inponsel.android.v2:
//            AppsByCategory, LoginActivity

class this._cls0
    implements android.content.ClickListener
{

    final AppsByCategory this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(AppsByCategory.this, com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        startActivity(dialoginterface);
    }

    tener()
    {
        this$0 = AppsByCategory.this;
        super();
    }
}
