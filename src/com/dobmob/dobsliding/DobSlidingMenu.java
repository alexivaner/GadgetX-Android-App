// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import com.dobmob.dobsliding.controllers.VSlidingMenuController;
import com.dobmob.dobsliding.events.OnCollapsedListener;
import com.dobmob.dobsliding.events.OnExpandedListener;
import com.dobmob.dobsliding.exceptions.NoActionBarException;
import com.dobmob.dobsliding.models.SlidingItem;

public class DobSlidingMenu
{

    private Activity activity;
    private SlidingItem slidingItem;
    private VSlidingMenuController vSlidingMenuController;

    public DobSlidingMenu(Activity activity1)
        throws NoActionBarException
    {
        activity = activity1;
        init();
    }

    private void init()
        throws NoActionBarException
    {
        slidingItem = new SlidingItem();
        vSlidingMenuController = new VSlidingMenuController(activity, slidingItem);
    }

    public void collapse()
    {
        vSlidingMenuController.collapse();
    }

    public void expand()
    {
        vSlidingMenuController.expand();
    }

    public void finish()
    {
        vSlidingMenuController.finish();
    }

    public float getJumpLinePercentage()
    {
        return slidingItem.getJumpLinePercentage();
    }

    public int getMaxDuration()
    {
        return slidingItem.getMaxDuration();
    }

    public OnCollapsedListener getOnCollapsedListener()
    {
        return slidingItem.getOnCollapsedListener();
    }

    public OnExpandedListener getOnExpandedListener()
    {
        return slidingItem.getOnExpandedListener();
    }

    public com.dobmob.dobsliding.controllers.VSlidingMenuController.SlidingStatus getSlidingStatus()
    {
        return vSlidingMenuController.getSlidingStatus();
    }

    public com.dobmob.dobsliding.models.SlidingItem.SlidingType getSlidingType()
    {
        return slidingItem.getSlidingType();
    }

    public View getSlidingView()
    {
        return slidingItem.getSlidingView();
    }

    public boolean isUseHandle()
    {
        return slidingItem.isUseHandle();
    }

    public void setHandleImages(int i, int j)
    {
        slidingItem.setHandleCollapsedIcon(i);
        slidingItem.setHandleExpandedIcon(j);
        vSlidingMenuController.changeHandle(getSlidingStatus());
    }

    public void setJumpLinePercentage(float f)
    {
        slidingItem.setJumpLinePercentage(f);
    }

    public void setMaxDuration(int i)
    {
        slidingItem.setMaxDuration(i);
    }

    public void setOnCollapsedListener(OnCollapsedListener oncollapsedlistener)
    {
        slidingItem.setOnCollapsedListener(oncollapsedlistener);
    }

    public void setOnExpandedListener(OnExpandedListener onexpandedlistener)
    {
        slidingItem.setOnExpandedListener(onexpandedlistener);
    }

    public void setSlidingType(com.dobmob.dobsliding.models.SlidingItem.SlidingType slidingtype)
    {
        slidingItem.setSlidingType(slidingtype);
        vSlidingMenuController.setSlidingType(slidingtype);
    }

    public void setSlidingView(int i)
    {
        setSlidingView(LayoutInflater.from(activity).inflate(i, null, false));
    }

    public void setSlidingView(View view)
    {
        slidingItem.setSlidingView(view);
        vSlidingMenuController.setSlidingView(view);
    }

    public void setUseHandle(boolean flag)
    {
        slidingItem.setUseHandle(flag);
        vSlidingMenuController.setUseHandle(flag);
    }
}
