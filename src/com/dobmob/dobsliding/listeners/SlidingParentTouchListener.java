// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.listeners;

import android.view.MotionEvent;
import android.view.View;
import com.dobmob.dobsliding.controllers.VSlidingMenuController;

public class SlidingParentTouchListener
    implements android.view.View.OnTouchListener
{

    private VSlidingMenuController vSlidingMenuController;

    public SlidingParentTouchListener()
    {
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        vSlidingMenuController.finish();
        return true;
    }

    public void register(VSlidingMenuController vslidingmenucontroller)
    {
        vSlidingMenuController = vslidingmenucontroller;
    }
}
