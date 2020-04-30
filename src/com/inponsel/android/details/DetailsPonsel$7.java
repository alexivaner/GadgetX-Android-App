// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.DialogInterface;
import android.support.v4.view.ViewPager;

// Referenced classes of package com.inponsel.android.details:
//            DetailsPonsel

class this._cls0
    implements android.content.OnClickListener
{

    final DetailsPonsel this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        mViewPager.setCurrentItem(2);
    }

    er()
    {
        this$0 = DetailsPonsel.this;
        super();
    }
}
