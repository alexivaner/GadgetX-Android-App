// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.view.MotionEvent;

// Referenced classes of package com.inponsel.android.widget:
//            MyScrollView

class t> extends android.view.reListener
{

    final MyScrollView this$0;

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return Math.abs(f1) > Math.abs(f);
    }

    ()
    {
        this$0 = MyScrollView.this;
        super();
    }
}
