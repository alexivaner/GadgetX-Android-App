// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            AppsByCategory, LoginActivity

class this._cls0
    implements android.view.ner
{

    final AppsByCategory this$0;

    public void onClick(View view)
    {
        view = new Intent(AppsByCategory.this, com/inponsel/android/v2/LoginActivity);
        view.putExtra("activity", "main");
        startActivity(view);
    }

    ()
    {
        this$0 = AppsByCategory.this;
        super();
    }
}
