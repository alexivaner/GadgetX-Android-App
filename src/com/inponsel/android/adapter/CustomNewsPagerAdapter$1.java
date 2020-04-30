// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.AutoScrollViewPager;
import com.nirhart.parallaxscroll.views.ParallaxScrollView;

// Referenced classes of package com.inponsel.android.adapter:
//            CustomNewsPagerAdapter

class dragthreshold
    implements android.view.sPagerAdapter._cls1
{

    int downX;
    int downY;
    int dragthreshold;
    final CustomNewsPagerAdapter this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        Log.e("ontouch", "ontouch");
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 40
    //                   0 42
    //                   1 188
    //                   2 62
    //                   3 222;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return false;
_L2:
        downX = (int)motionevent.getRawX();
        downY = (int)motionevent.getRawY();
        return false;
_L4:
        int i = Math.abs((int)motionevent.getRawX() - downX);
        int j = Math.abs((int)motionevent.getRawY() - downY);
        if (j > i && j > dragthreshold)
        {
            view_pager_head_news.getParent().requestDisallowInterceptTouchEvent(false);
            sv_root.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
        if (i > j && i > dragthreshold)
        {
            view_pager_head_news.getParent().requestDisallowInterceptTouchEvent(true);
            sv_root.getParent().requestDisallowInterceptTouchEvent(false);
            return false;
        }
          goto _L1
_L3:
        sv_root.getParent().requestDisallowInterceptTouchEvent(false);
        view_pager_head_news.getParent().requestDisallowInterceptTouchEvent(false);
        return false;
_L5:
        view_pager_head_news.startAutoScroll();
        return false;
    }

    ()
    {
        this$0 = CustomNewsPagerAdapter.this;
        super();
        dragthreshold = 30;
    }
}
