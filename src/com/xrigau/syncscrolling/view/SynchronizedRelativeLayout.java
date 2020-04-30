// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xrigau.syncscrolling.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;

// Referenced classes of package com.xrigau.syncscrolling.view:
//            EnhancedScrollView

public class SynchronizedRelativeLayout extends RelativeLayout
    implements EnhancedScrollView.OnScrollChangedListener
{
    public static class Gravity
    {

        public static final int CENTER_HORIZONTAL = 1;
        public static final int LEFT = 0;
        public static final int RIGHT = 2;

        public Gravity()
        {
        }
    }


    private int mGravity;
    private int mLastSyncViewPos;
    private View mPlaceholderView;
    private int mPlaceholderViewId;
    private View mSynchronizedView;
    private int mSynchronizedViewId;

    public SynchronizedRelativeLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mGravity = 0;
        mLastSyncViewPos = 0;
        init(context, attributeset);
    }

    public SynchronizedRelativeLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mGravity = 0;
        mLastSyncViewPos = 0;
        init(context, attributeset);
    }

    private void findEnhancedScrollViewRecursive(ViewParent viewparent)
    {
        if (viewparent == null)
        {
            throw new IllegalArgumentException("A SynchronizedRelativeLayout must be inside EnhancedScrollView, directly or indirectly.");
        }
        if (viewparent instanceof EnhancedScrollView)
        {
            ((EnhancedScrollView)viewparent).addOnScrollListener(this);
            return;
        } else
        {
            findEnhancedScrollViewRecursive(viewparent.getParent());
            return;
        }
    }

    private void init(Context context, AttributeSet attributeset)
    {
        attributeset = getContext().obtainStyledAttributes(attributeset, R.styleable.SynchronizedRelativeLayout);
        mGravity = attributeset.getInt(R.styleable.SynchronizedRelativeLayout_syncView_gravity, mGravity);
        context = null;
        mPlaceholderViewId = attributeset.getResourceId(R.styleable.SynchronizedRelativeLayout_placeholderView, 0);
        if (mPlaceholderViewId == 0)
        {
            context = new IllegalArgumentException((new StringBuilder(String.valueOf(attributeset.getPositionDescription()))).append(": The placeholderView attribute is required and must refer to a valid child.").toString());
        }
        mSynchronizedViewId = attributeset.getResourceId(R.styleable.SynchronizedRelativeLayout_synchronizedView, 0);
        if (mSynchronizedViewId == 0)
        {
            context = new IllegalArgumentException((new StringBuilder(String.valueOf(attributeset.getPositionDescription()))).append(": The synchronizedView attribute is required and must refer to a valid child.").toString());
        }
        attributeset.recycle();
        if (context != null)
        {
            throw context;
        } else
        {
            return;
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        findEnhancedScrollViewRecursive(getParent());
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mPlaceholderView = findViewById(mPlaceholderViewId);
        mSynchronizedView = findViewById(mSynchronizedViewId);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        j = mPlaceholderView.getTop();
        i = mSynchronizedView.getLeft();
        mGravity;
        JVM INSTR tableswitch 1 2: default 52
    //                   1 128
    //                   2 146;
           goto _L1 _L2 _L3
_L1:
        mSynchronizedView.layout(i, j, mSynchronizedView.getMeasuredWidth() + i, mSynchronizedView.getMeasuredHeight() + j);
        mPlaceholderView.layout(i, j, mSynchronizedView.getMeasuredWidth() + i, mSynchronizedView.getMeasuredHeight() + j);
        mLastSyncViewPos = (getTop() + getHeight()) - mSynchronizedView.getMeasuredHeight();
        return;
_L2:
        i = (getWidth() - mSynchronizedView.getMeasuredWidth()) / 2;
        continue; /* Loop/switch isn't completed */
_L3:
        i = getWidth() - mSynchronizedView.getMeasuredWidth();
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        android.view.ViewGroup.LayoutParams layoutparams = mPlaceholderView.getLayoutParams();
        if (layoutparams.height != mSynchronizedView.getMeasuredHeight())
        {
            layoutparams.height = mSynchronizedView.getMeasuredHeight();
        }
    }

    public void onVerticalScrollChanged(int i)
    {
        int k = i - getTop();
        if (k >= mPlaceholderView.getTop())
        {
            int j = 0;
            if (i > mLastSyncViewPos)
            {
                j = i - mLastSyncViewPos;
            }
            mSynchronizedView.offsetTopAndBottom(k - mSynchronizedView.getTop() - j);
            return;
        } else
        {
            mSynchronizedView.offsetTopAndBottom(mPlaceholderView.getTop() - mSynchronizedView.getTop());
            return;
        }
    }
}
