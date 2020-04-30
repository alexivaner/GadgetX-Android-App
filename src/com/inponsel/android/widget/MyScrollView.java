// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView
{
    class YScrollDetector extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final MyScrollView this$0;

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            return Math.abs(f1) > Math.abs(f);
        }

        YScrollDetector()
        {
            this$0 = MyScrollView.this;
            super();
        }
    }


    private GestureDetector mGestureDetector;
    android.view.View.OnTouchListener mGestureListener;

    public MyScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mGestureDetector = new GestureDetector(context, new YScrollDetector());
        setFadingEdgeLength(0);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return super.onInterceptTouchEvent(motionevent) && mGestureDetector.onTouchEvent(motionevent);
    }
}
