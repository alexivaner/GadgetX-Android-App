// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView
{
    public static interface OnFlingListener
    {

        public abstract void onFlingStarted();

        public abstract void onFlingStopped();
    }


    private static final int DELAY_MILLIS = 100;
    private OnFlingListener mFlingListener;
    private int mPreviousPosition;
    private Runnable mScrollChecker = new Runnable() {

        final CustomScrollView this$0;

        public void run()
        {
            int j = getScrollY();
            if (mPreviousPosition - j == 0)
            {
                mFlingListener.onFlingStopped();
                removeCallbacks(mScrollChecker);
                return;
            } else
            {
                mPreviousPosition = getScrollY();
                postDelayed(mScrollChecker, 100L);
                return;
            }
        }

            
            {
                this$0 = CustomScrollView.this;
                super();
            }
    };

    public CustomScrollView(Context context)
    {
        this(context, null, 0);
    }

    public CustomScrollView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CustomScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void fling(int i)
    {
        super.fling(i);
        if (mFlingListener != null)
        {
            mFlingListener.onFlingStarted();
            post(mScrollChecker);
        }
    }

    public OnFlingListener getOnFlingListener()
    {
        return mFlingListener;
    }

    public void setOnFlingListener(OnFlingListener onflinglistener)
    {
        mFlingListener = onflinglistener;
    }




}
