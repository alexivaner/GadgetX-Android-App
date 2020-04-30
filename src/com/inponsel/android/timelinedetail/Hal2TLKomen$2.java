// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.LoginActivity;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal2TLKomen

class this._cls0
    implements android.view.stener
{

    final Hal2TLKomen this$0;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
        view.putExtra("activity", "main");
        startActivity(view);
    }

    ()
    {
        this$0 = Hal2TLKomen.this;
        super();
    }
}
