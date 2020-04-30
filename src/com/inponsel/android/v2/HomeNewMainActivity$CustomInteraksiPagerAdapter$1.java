// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.AutoScrollViewPager;
import com.nirhart.parallaxscroll.views.ParallaxScrollView;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

class dragthreshold
    implements android.view.rAdapter._cls1
{

    int downX;
    int downY;
    int dragthreshold;
    final this._cls1 this$1;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        Log.e("ontouch", "ontouch");
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 40
    //                   0 42
    //                   1 200
    //                   2 62
    //                   3 240;
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
            HomeNewMainActivity.access$3(cess._mth0(this._cls1.this)).getParent().requestDisallowInterceptTouchEvent(false);
            cess._mth0(this._cls1.this).sv_root.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
        if (i > j && i > dragthreshold)
        {
            HomeNewMainActivity.access$3(cess._mth0(this._cls1.this)).getParent().requestDisallowInterceptTouchEvent(true);
            cess._mth0(this._cls1.this).sv_root.getParent().requestDisallowInterceptTouchEvent(false);
            return false;
        }
          goto _L1
_L3:
        cess._mth0(this._cls1.this).sv_root.getParent().requestDisallowInterceptTouchEvent(false);
        HomeNewMainActivity.access$3(cess._mth0(this._cls1.this)).getParent().requestDisallowInterceptTouchEvent(false);
        return false;
_L5:
        HomeNewMainActivity.access$3(cess._mth0(this._cls1.this)).startAutoScroll();
        return false;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
        dragthreshold = 30;
    }
}
