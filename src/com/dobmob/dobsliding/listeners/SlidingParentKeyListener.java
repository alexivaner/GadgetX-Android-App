// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.listeners;

import android.view.KeyEvent;
import android.view.View;
import com.dobmob.dobsliding.controllers.VSlidingMenuController;

public class SlidingParentKeyListener
    implements android.view.View.OnKeyListener
{

    private VSlidingMenuController vSlidingMenuController;

    public SlidingParentKeyListener(VSlidingMenuController vslidingmenucontroller)
    {
        vSlidingMenuController = vslidingmenucontroller;
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (i == 4)
        {
            flag = flag1;
            if (vSlidingMenuController.getSlidingStatus() == com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus.EXPANDED)
            {
                vSlidingMenuController.collapse();
                flag = true;
            }
        }
        return flag;
    }
}
