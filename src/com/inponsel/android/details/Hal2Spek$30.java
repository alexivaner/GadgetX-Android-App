// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek, DetailsPonsel

class this._cls0
    implements android.view.Listener
{

    final Hal2Spek this$0;

    public void onClick(View view)
    {
        ((DetailsPonsel)getActivity()).getViewPager().setCurrentItem(2);
    }

    l()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
