// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.faizmalkani.floatingactionbutton;

import android.view.View;
import android.widget.AbsListView;

// Referenced classes of package com.faizmalkani.floatingactionbutton:
//            FloatingActionButton

class DirectionScrollListener
    implements android.widget.AbsListView.OnScrollListener
{

    private static final int DIRECTION_CHANGE_THRESHOLD = 1;
    private final FloatingActionButton mFloatingActionButton;
    private int mPrevPosition;
    private int mPrevTop;
    private boolean mUpdated;

    DirectionScrollListener(FloatingActionButton floatingactionbutton)
    {
        mFloatingActionButton = floatingactionbutton;
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        abslistview = abslistview.getChildAt(0);
        k = 0;
        if (abslistview != null)
        {
            k = abslistview.getTop();
        }
        j = 1;
        boolean flag;
        if (mPrevPosition == i)
        {
            j = mPrevTop;
            if (k < mPrevTop)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (Math.abs(j - k) > 1)
            {
                j = 1;
            } else
            {
                j = 0;
            }
        } else
        if (i > mPrevPosition)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (j != 0 && mUpdated)
        {
            mFloatingActionButton.hide(flag);
        }
        mPrevPosition = i;
        mPrevTop = k;
        mUpdated = true;
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }
}
