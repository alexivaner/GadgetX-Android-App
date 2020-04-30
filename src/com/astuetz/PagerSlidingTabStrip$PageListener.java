// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.astuetz;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

// Referenced classes of package com.astuetz:
//            PagerSlidingTabStrip

private class <init>
    implements android.support.v4.view.
{

    final PagerSlidingTabStrip this$0;

    public void onPageScrollStateChanged(int i)
    {
        if (i == 0)
        {
            PagerSlidingTabStrip.access$4(PagerSlidingTabStrip.this, PagerSlidingTabStrip.access$2(PagerSlidingTabStrip.this).getCurrentItem(), 0);
        }
        if (delegatePageListener != null)
        {
            delegatePageListener.ageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        PagerSlidingTabStrip.access$0(PagerSlidingTabStrip.this, i);
        PagerSlidingTabStrip.access$1(PagerSlidingTabStrip.this, f);
        getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final PagerSlidingTabStrip.PageListener this$1;

            public void onGlobalLayout()
            {
                if (android.os.Build.VERSION.SDK_INT < 16)
                {
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else
                {
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                PagerSlidingTabStrip.access$0(this$0, PagerSlidingTabStrip.access$2(this$0).getCurrentItem());
                PagerSlidingTabStrip.access$1(this$0, 0.0F);
                PagerSlidingTabStrip.access$4(this$0, PagerSlidingTabStrip.access$3(this$0), 0);
            }

            
            {
                this$1 = PagerSlidingTabStrip.PageListener.this;
                super();
            }
        });
        PagerSlidingTabStrip.access$4(PagerSlidingTabStrip.this, i, (int)((float)PagerSlidingTabStrip.access$5(PagerSlidingTabStrip.this).getChildAt(i).getWidth() * f));
        invalidate();
        if (delegatePageListener != null)
        {
            delegatePageListener.ageScrolled(i, f, j);
        }
    }

    public void onPageSelected(int i)
    {
        if (delegatePageListener != null)
        {
            delegatePageListener.ageSelected(i);
        }
    }


    private _cls1.this._cls1()
    {
        this$0 = PagerSlidingTabStrip.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
