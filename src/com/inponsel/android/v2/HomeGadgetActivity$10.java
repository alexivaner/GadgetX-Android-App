// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGadgetActivity

class this._cls0
    implements android.view.er
{

    final HomeGadgetActivity this$0;

    public boolean onLongClick(View view)
    {
        if (!txtMoreSegera.getText().toString().toLowerCase().contains("refresh"))
        {
            SegeraTask();
        }
        return true;
    }

    ()
    {
        this$0 = HomeGadgetActivity.this;
        super();
    }
}
