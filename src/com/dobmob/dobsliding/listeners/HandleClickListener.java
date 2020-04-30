// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.listeners;

import android.view.View;
import com.dobmob.dobsliding.controllers.VSlidingMenuController;

public class HandleClickListener
    implements android.view.View.OnClickListener
{

    private VSlidingMenuController vSlidingMenuController;

    public HandleClickListener(VSlidingMenuController vslidingmenucontroller)
    {
        vSlidingMenuController = vslidingmenucontroller;
    }

    public void onClick(View view)
    {
        if (vSlidingMenuController.getSlidingStatus() == com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus.COLLAPSED)
        {
            vSlidingMenuController.expand();
        } else
        if (vSlidingMenuController.getSlidingStatus() == com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus.EXPANDED)
        {
            vSlidingMenuController.collapse();
            return;
        }
    }
}
