// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.andraskindler.quickscroll;

import android.widget.AbsListView;

// Referenced classes of package com.andraskindler.quickscroll:
//            QuickScroll

class this._cls0
    implements android.widget.ScrollListener
{

    final QuickScroll this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (!isScrolling && k - j > 0)
        {
            moveHandlebar((getHeight() * i) / (k - j));
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    ()
    {
        this$0 = QuickScroll.this;
        super();
    }
}
