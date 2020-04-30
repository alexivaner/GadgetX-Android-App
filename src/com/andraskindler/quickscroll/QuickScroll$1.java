// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.andraskindler.quickscroll;

import android.view.animation.Animation;

// Referenced classes of package com.andraskindler.quickscroll:
//            QuickScroll

class this._cls0
    implements android.view.animation.ationListener
{

    final QuickScroll this$0;

    public void onAnimationEnd(Animation animation)
    {
        isScrolling = false;
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    stener()
    {
        this$0 = QuickScroll.this;
        super();
    }
}
