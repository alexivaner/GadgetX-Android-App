// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.models;

import android.view.View;
import com.dobmob.dobsliding.events.OnCollapsedListener;
import com.dobmob.dobsliding.events.OnExpandedListener;

public class SlidingItem
{
    public static final class SlidingType extends Enum
    {

        private static final SlidingType ENUM$VALUES[];
        public static final SlidingType MOVE;
        public static final SlidingType SIZE;

        public static SlidingType valueOf(String s)
        {
            return (SlidingType)Enum.valueOf(com/dobmob/dobsliding/models/SlidingItem$SlidingType, s);
        }

        public static SlidingType[] values()
        {
            SlidingType aslidingtype[] = ENUM$VALUES;
            int i = aslidingtype.length;
            SlidingType aslidingtype1[] = new SlidingType[i];
            System.arraycopy(aslidingtype, 0, aslidingtype1, 0, i);
            return aslidingtype1;
        }

        static 
        {
            SIZE = new SlidingType("SIZE", 0);
            MOVE = new SlidingType("MOVE", 1);
            ENUM$VALUES = (new SlidingType[] {
                SIZE, MOVE
            });
        }

        private SlidingType(String s, int i)
        {
            super(s, i);
        }
    }


    private int handleCollapsedIcon;
    private int handleExpandedIcon;
    private float jumpLinePercentage;
    private int maxDuration;
    private OnCollapsedListener onCollapsedListener;
    private OnExpandedListener onExpandedListener;
    private SlidingType slidingType;
    private View slidingView;
    private boolean useHandle;

    public SlidingItem()
    {
        slidingType = SlidingType.SIZE;
        maxDuration = -1;
        jumpLinePercentage = 0.6F;
        useHandle = true;
        handleCollapsedIcon = com.dobmob.dobsliding.R.drawable.ic_collapsed_dark;
        handleExpandedIcon = com.dobmob.dobsliding.R.drawable.ic_expanded_dark;
    }

    public int getHandleCollapsedIcon()
    {
        return handleCollapsedIcon;
    }

    public int getHandleExpandedIcon()
    {
        return handleExpandedIcon;
    }

    public float getJumpLinePercentage()
    {
        return jumpLinePercentage;
    }

    public int getMaxDuration()
    {
        return maxDuration;
    }

    public OnCollapsedListener getOnCollapsedListener()
    {
        return onCollapsedListener;
    }

    public OnExpandedListener getOnExpandedListener()
    {
        return onExpandedListener;
    }

    public SlidingType getSlidingType()
    {
        return slidingType;
    }

    public View getSlidingView()
    {
        return slidingView;
    }

    public boolean isUseHandle()
    {
        return useHandle;
    }

    public void setHandleCollapsedIcon(int i)
    {
        handleCollapsedIcon = i;
    }

    public void setHandleExpandedIcon(int i)
    {
        handleExpandedIcon = i;
    }

    public void setJumpLinePercentage(float f)
    {
        jumpLinePercentage = f;
    }

    public void setMaxDuration(int i)
    {
        maxDuration = i;
    }

    public void setOnCollapsedListener(OnCollapsedListener oncollapsedlistener)
    {
        onCollapsedListener = oncollapsedlistener;
    }

    public void setOnExpandedListener(OnExpandedListener onexpandedlistener)
    {
        onExpandedListener = onexpandedlistener;
    }

    public void setSlidingType(SlidingType slidingtype)
    {
        slidingType = slidingtype;
    }

    public void setSlidingView(View view)
    {
        slidingView = view;
    }

    public void setUseHandle(boolean flag)
    {
        useHandle = flag;
    }
}
