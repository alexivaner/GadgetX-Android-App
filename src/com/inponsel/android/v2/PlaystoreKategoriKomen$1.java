// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            PlaystoreKategoriKomen, LoginActivity

class this._cls0
    implements android.view.oriKomen._cls1
{

    final PlaystoreKategoriKomen this$0;

    public void onClick(View view)
    {
        view = new Intent(PlaystoreKategoriKomen.this, com/inponsel/android/v2/LoginActivity);
        view.putExtra("activity", "main");
        startActivity(view);
    }

    ()
    {
        this$0 = PlaystoreKategoriKomen.this;
        super();
    }
}
