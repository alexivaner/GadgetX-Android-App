// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.LoginActivity;

// Referenced classes of package com.inponsel.android.details:
//            Hal3KomentarPull

class this._cls0
    implements android.view.r
{

    final Hal3KomentarPull this$0;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
        view.putExtra("activity", "main");
        startActivity(view);
    }

    ()
    {
        this$0 = Hal3KomentarPull.this;
        super();
    }
}
