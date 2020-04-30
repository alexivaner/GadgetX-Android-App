// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.utils;

import android.widget.FrameLayout;
import com.dobmob.dobsliding.controllers.VSlidingMenuController;
import com.dobmob.dobsliding.models.SlidingItem;

public class Computer
{

    public Computer()
    {
    }

    public static com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus getSlidingStatus(VSlidingMenuController vslidingmenucontroller)
    {
        FrameLayout framelayout = vslidingmenucontroller.getSlidingParent();
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)framelayout.getLayoutParams();
        if (vslidingmenucontroller.getSlidingItem().getSlidingType() == com.dobmob.dobsliding.models.SlidingItem.SlidingType.SIZE)
        {
            int i = framelayout.getHeight();
            if (i == 0)
            {
                return com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus.COLLAPSED;
            }
            if (i >= vslidingmenucontroller.getSlidingHeight())
            {
                return com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus.EXPANDED;
            } else
            {
                return com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus.ANIMATING;
            }
        }
        if (vslidingmenucontroller.getSlidingItem().getSlidingType() == com.dobmob.dobsliding.models.SlidingItem.SlidingType.MOVE)
        {
            int j = layoutparams.topMargin;
            if (j <= -vslidingmenucontroller.getSlidingHeight())
            {
                return com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus.COLLAPSED;
            }
            if (j >= 0)
            {
                return com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus.EXPANDED;
            } else
            {
                return com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus.ANIMATING;
            }
        } else
        {
            return com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus.ANIMATING;
        }
    }
}
