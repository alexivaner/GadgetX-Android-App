// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class PagerContainer extends FrameLayout
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    private Point mCenter;
    private Point mInitialTouch;
    boolean mNeedsRedraw;
    private ViewPager mPager;

    public PagerContainer(Context context)
    {
        super(context);
        mNeedsRedraw = false;
        mCenter = new Point();
        mInitialTouch = new Point();
        init();
    }

    public PagerContainer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mNeedsRedraw = false;
        mCenter = new Point();
        mInitialTouch = new Point();
        init();
    }

    public PagerContainer(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mNeedsRedraw = false;
        mCenter = new Point();
        mInitialTouch = new Point();
        init();
    }

    private void init()
    {
        setClipChildren(false);
        setLayerType(1, null);
    }

    public ViewPager getViewPager()
    {
        return mPager;
    }

    protected void onFinishInflate()
    {
        try
        {
            mPager = (ViewPager)getChildAt(0);
            mPager.setOnPageChangeListener(this);
            return;
        }
        catch (Exception exception)
        {
            throw new IllegalStateException("The root child of PagerContainer must be a ViewPager");
        }
    }

    public void onPageScrollStateChanged(int i)
    {
        boolean flag;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mNeedsRedraw = flag;
    }

    public void onPageScrolled(int i, float f, int j)
    {
        if (mNeedsRedraw)
        {
            invalidate();
        }
    }

    public void onPageSelected(int i)
    {
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        mCenter.x = i / 2;
        mCenter.y = j / 2;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 0: default 24
    //                   0 69;
           goto _L1 _L2
_L1:
        motionevent.offsetLocation(mCenter.x - mInitialTouch.x, mCenter.y - mInitialTouch.y);
        return mPager.dispatchTouchEvent(motionevent);
_L2:
        mInitialTouch.x = (int)motionevent.getX();
        mInitialTouch.y = (int)motionevent.getY();
        if (true) goto _L1; else goto _L3
_L3:
    }
}
