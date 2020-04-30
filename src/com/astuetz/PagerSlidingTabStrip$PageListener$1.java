// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.astuetz;

import android.support.v4.view.ViewPager;
import android.view.ViewTreeObserver;

// Referenced classes of package com.astuetz:
//            PagerSlidingTabStrip

class this._cls1
    implements android.view.ner
{

    final this._cls1 this$1;

    public void onGlobalLayout()
    {
        if (android.os.tener < 16)
        {
            cess._mth1(this._cls1.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else
        {
            cess._mth1(this._cls1.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        PagerSlidingTabStrip.access$0(cess._mth1(this._cls1.this), PagerSlidingTabStrip.access$2(cess._mth1(this._cls1.this)).getCurrentItem());
        PagerSlidingTabStrip.access$1(cess._mth1(this._cls1.this), 0.0F);
        PagerSlidingTabStrip.access$4(cess._mth1(this._cls1.this), PagerSlidingTabStrip.access$3(cess._mth1(this._cls1.this)), 0);
    }

    ener()
    {
        this$1 = this._cls1.this;
        super();
    }
}
