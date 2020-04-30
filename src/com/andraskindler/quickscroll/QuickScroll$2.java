// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.andraskindler.quickscroll;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.andraskindler.quickscroll:
//            QuickScroll

class this._cls0
    implements android.view.stener
{

    final QuickScroll this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return isScrolling && (motionevent.getAction() == 2 || motionevent.getAction() == 0);
    }

    ()
    {
        this$0 = QuickScroll.this;
        super();
    }
}
