// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.animations;

import com.dobmob.dobsliding.controllers.VSlidingMenuController;
import com.dobmob.dobsliding.listeners.VSlidingAnimatorListener;
import com.dobmob.dobsliding.models.SlidingItem;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

public class AnimationExecutor
{
    public static final class MovingType extends Enum
    {

        public static final MovingType BOTTOM_TO_TOP;
        private static final MovingType ENUM$VALUES[];
        public static final MovingType TOP_TO_BOTTOM;

        public static MovingType valueOf(String s)
        {
            return (MovingType)Enum.valueOf(com/dobmob/dobsliding/animations/AnimationExecutor$MovingType, s);
        }

        public static MovingType[] values()
        {
            MovingType amovingtype[] = ENUM$VALUES;
            int i = amovingtype.length;
            MovingType amovingtype1[] = new MovingType[i];
            System.arraycopy(amovingtype, 0, amovingtype1, 0, i);
            return amovingtype1;
        }

        static 
        {
            TOP_TO_BOTTOM = new MovingType("TOP_TO_BOTTOM", 0);
            BOTTOM_TO_TOP = new MovingType("BOTTOM_TO_TOP", 1);
            ENUM$VALUES = (new MovingType[] {
                TOP_TO_BOTTOM, BOTTOM_TO_TOP
            });
        }

        private MovingType(String s, int i)
        {
            super(s, i);
        }
    }


    private VSlidingMenuController vSlidingMenuController;

    public AnimationExecutor(VSlidingMenuController vslidingmenucontroller)
    {
        vSlidingMenuController = vslidingmenucontroller;
    }

    public void animateView(int i, int j)
    {
        Object obj;
        int l = Math.abs(j - i);
        int k = l;
        if (vSlidingMenuController.getSlidingItem().getMaxDuration() > -1)
        {
            k = Math.min(l, vSlidingMenuController.getSlidingItem().getMaxDuration());
        }
        VSlidingAnimatorListener vslidinganimatorlistener = new VSlidingAnimatorListener(vSlidingMenuController);
        if (j == 0)
        {
            obj = MovingType.BOTTOM_TO_TOP;
        } else
        {
            obj = MovingType.TOP_TO_BOTTOM;
        }
        vslidinganimatorlistener.setMovingType(((MovingType) (obj)));
        obj = "";
        if (vSlidingMenuController.getSlidingItem().getSlidingType() != com.dobmob.dobsliding.models.SlidingItem.SlidingType.SIZE) goto _L2; else goto _L1
_L1:
        obj = "viewHeight";
_L4:
        obj = ObjectAnimator.ofInt(vSlidingMenuController, ((String) (obj)), new int[] {
            i, j
        });
        ((ValueAnimator) (obj)).setDuration(k);
        ((ValueAnimator) (obj)).addListener(vslidinganimatorlistener);
        ((ValueAnimator) (obj)).start();
        return;
_L2:
        if (vSlidingMenuController.getSlidingItem().getSlidingType() == com.dobmob.dobsliding.models.SlidingItem.SlidingType.MOVE)
        {
            obj = "viewTop";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
