// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class LockableScrollView extends ScrollView
{

    private boolean mScrollable;

    public LockableScrollView(Context context)
    {
        super(context);
        mScrollable = true;
    }

    public LockableScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mScrollable = true;
    }

    public boolean isScrollable()
    {
        return mScrollable;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (!isScrollable())
        {
            return false;
        } else
        {
            return super.onInterceptTouchEvent(motionevent);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        switch (motionevent.getAction())
        {
        default:
            return super.onTouchEvent(motionevent);

        case 0: // '\0'
            break;
        }
        if (isScrollable())
        {
            return super.onTouchEvent(motionevent);
        } else
        {
            return mScrollable;
        }
    }

    public void setScrollable(boolean flag)
    {
        mScrollable = flag;
    }
}
