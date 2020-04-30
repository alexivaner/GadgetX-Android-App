// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.listeners;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.dobmob.dobsliding.controllers.VSlidingMenuController;

public class OnSizingTouchListener
    implements android.view.View.OnTouchListener
{

    private android.widget.FrameLayout.LayoutParams slidingLayoutParams;
    private FrameLayout slidingParent;
    private VSlidingMenuController vSlidingMenuController;

    public OnSizingTouchListener(VSlidingMenuController vslidingmenucontroller)
    {
        vSlidingMenuController = vslidingmenucontroller;
        init();
    }

    private void init()
    {
        slidingParent = vSlidingMenuController.getSlidingParent();
        slidingLayoutParams = (android.widget.FrameLayout.LayoutParams)slidingParent.getLayoutParams();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        float f = motionevent.getY();
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 36
    //                   0 38
    //                   1 80
    //                   2 57;
           goto _L1 _L2 _L3 _L4
_L1:
        return true;
_L2:
        vSlidingMenuController.focusOnSliding();
        if (slidingParent.getHeight() > 0)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        slidingLayoutParams.height = (int)f;
        slidingParent.setLayoutParams(slidingLayoutParams);
        continue; /* Loop/switch isn't completed */
_L3:
        if (f > vSlidingMenuController.getJumpLine())
        {
            vSlidingMenuController.animateSliding((int)f, vSlidingMenuController.getSlidingHeight());
        } else
        {
            vSlidingMenuController.animateSliding((int)f, 0);
        }
        if (true) goto _L1; else goto _L5
_L5:
    }
}
