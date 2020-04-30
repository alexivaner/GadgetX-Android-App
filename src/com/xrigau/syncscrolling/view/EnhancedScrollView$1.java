// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xrigau.syncscrolling.view;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.xrigau.syncscrolling.view:
//            EnhancedScrollView

class this._cls0
    implements Runnable
{

    final EnhancedScrollView this$0;

    public void run()
    {
        Iterator iterator = EnhancedScrollView.access$0(EnhancedScrollView.this).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                invalidate();
                return;
            }
            ((ScrollChangedListener)iterator.next()).onVerticalScrollChanged(getScrollY());
        } while (true);
    }

    ScrollChangedListener()
    {
        this$0 = EnhancedScrollView.this;
        super();
    }
}
