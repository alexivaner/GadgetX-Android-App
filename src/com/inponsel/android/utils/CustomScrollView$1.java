// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;


// Referenced classes of package com.inponsel.android.utils:
//            CustomScrollView

class this._cls0
    implements Runnable
{

    final CustomScrollView this$0;

    public void run()
    {
        int i = getScrollY();
        if (CustomScrollView.access$0(CustomScrollView.this) - i == 0)
        {
            CustomScrollView.access$1(CustomScrollView.this).onFlingStopped();
            removeCallbacks(CustomScrollView.access$2(CustomScrollView.this));
            return;
        } else
        {
            CustomScrollView.access$3(CustomScrollView.this, getScrollY());
            postDelayed(CustomScrollView.access$2(CustomScrollView.this), 100L);
            return;
        }
    }

    FlingListener()
    {
        this$0 = CustomScrollView.this;
        super();
    }
}
