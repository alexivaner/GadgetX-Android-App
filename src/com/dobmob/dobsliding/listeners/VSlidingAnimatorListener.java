// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.listeners;

import com.dobmob.dobsliding.controllers.VSlidingMenuController;
import com.dobmob.dobsliding.events.OnCollapsedListener;
import com.dobmob.dobsliding.events.OnExpandedListener;
import com.dobmob.dobsliding.models.SlidingItem;
import com.nineoldandroids.animation.Animator;

public class VSlidingAnimatorListener
    implements com.nineoldandroids.animation.Animator.AnimatorListener
{

    private com.dobmob.dobsliding.animations.AnimationExecutor.MovingType movingType;
    private VSlidingMenuController vSlidingMenuController;

    public VSlidingAnimatorListener(VSlidingMenuController vslidingmenucontroller)
    {
        vSlidingMenuController = vslidingmenucontroller;
    }

    public com.dobmob.dobsliding.animations.AnimationExecutor.MovingType getMovingType()
    {
        return movingType;
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (vSlidingMenuController != null)
        {
            if (movingType == com.dobmob.dobsliding.animations.AnimationExecutor.MovingType.BOTTOM_TO_TOP)
            {
                vSlidingMenuController.changeHandle(com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus.COLLAPSED);
                if (vSlidingMenuController.getSlidingItem().getOnCollapsedListener() != null)
                {
                    vSlidingMenuController.getSlidingItem().getOnCollapsedListener().onCollapsed();
                }
            } else
            if (movingType == com.dobmob.dobsliding.animations.AnimationExecutor.MovingType.TOP_TO_BOTTOM)
            {
                vSlidingMenuController.changeHandle(com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus.EXPANDED);
                if (vSlidingMenuController.getSlidingItem().getOnExpandedListener() != null)
                {
                    vSlidingMenuController.getSlidingItem().getOnExpandedListener().onExpanded();
                    return;
                }
            }
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    public void setMovingType(com.dobmob.dobsliding.animations.AnimationExecutor.MovingType movingtype)
    {
        movingType = movingtype;
    }
}
