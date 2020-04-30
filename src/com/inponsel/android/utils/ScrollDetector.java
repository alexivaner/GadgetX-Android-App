// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public abstract class ScrollDetector extends android.view.GestureDetector.SimpleOnGestureListener
    implements android.view.View.OnTouchListener
{

    private final GestureDetector mDetector;
    private boolean mDirection;
    private float mDownY;
    private boolean mIgnore;
    private final int mSlop;

    public ScrollDetector(Context context)
    {
        mDetector = new GestureDetector(context, this);
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            mSlop = ViewConfiguration.getTouchSlop() * 2;
            return;
        } else
        {
            mSlop = ViewConfiguration.get(context).getScaledPagingTouchSlop();
            return;
        }
    }

    public boolean onDown(MotionEvent motionevent)
    {
        mDownY = motionevent.getY();
        return false;
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        boolean flag1 = true;
        if (!mIgnore)
        {
            boolean flag2 = mDirection;
            boolean flag;
            if (f1 > 0.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag2 != flag)
            {
                flag = flag1;
                if (mDirection)
                {
                    flag = false;
                }
                mDirection = flag;
                mDownY = motionevent1.getY();
            }
            f = mDownY - motionevent1.getY();
            if (f < (float)(-mSlop))
            {
                onScrollDown();
                return false;
            }
            if (f > (float)mSlop)
            {
                onScrollUp();
                return false;
            }
        }
        return false;
    }

    public abstract void onScrollDown();

    public abstract void onScrollUp();

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        mDetector.onTouchEvent(motionevent);
        return false;
    }

    public void setIgnore(boolean flag)
    {
        mIgnore = flag;
    }
}
