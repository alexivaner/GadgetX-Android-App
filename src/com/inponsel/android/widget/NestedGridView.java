// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListAdapter;

public class NestedGridView extends GridView
    implements android.view.View.OnTouchListener, android.widget.AbsListView.OnScrollListener
{

    private static final int MAXIMUM_LIST_ITEMS_VIEWABLE = 99;
    private int listViewTouchAction;

    public NestedGridView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        listViewTouchAction = -1;
        setOnScrollListener(this);
        setOnTouchListener(this);
    }

    protected void onMeasure(int i, int j)
    {
        ListAdapter listadapter;
        int k;
        int l;
        int i1;
        boolean flag;
        int j1;
        super.onMeasure(i, j);
        flag = false;
        l = 0;
        j1 = android.view.View.MeasureSpec.getMode(j);
        i1 = android.view.View.MeasureSpec.getSize(j);
        if (j1 == 0x40000000)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        listadapter = getAdapter();
        k = ((flag) ? 1 : 0);
        if (listadapter == null) goto _L2; else goto _L1
_L1:
        k = ((flag) ? 1 : 0);
        if (listadapter.isEmpty()) goto _L2; else goto _L3
_L3:
        k = 0;
_L6:
        if (k < listadapter.getCount() && k < 99) goto _L5; else goto _L4
_L4:
        k = l + getVerticalSpacing() * k;
_L2:
        i = k;
        if (j1 == 0x80000000)
        {
            i = k;
            if (k > i1)
            {
                i = k;
                if (k > i1)
                {
                    i = i1;
                }
            }
        }
_L7:
        setMeasuredDimension(getMeasuredWidth(), i);
        return;
_L5:
        View view = listadapter.getView(k, null, this);
        if (view instanceof ViewGroup)
        {
            view.setLayoutParams(new android.widget.AbsListView.LayoutParams(-2, -2));
        }
        view.measure(i, j);
        l += view.getMeasuredHeight();
        k++;
          goto _L6
        i = getMeasuredHeight();
          goto _L7
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (getAdapter() != null && getAdapter().getCount() > 99 && listViewTouchAction == 2)
        {
            scrollBy(0, -1);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (getAdapter() != null && getAdapter().getCount() > 99 && listViewTouchAction == 2)
        {
            scrollBy(0, 1);
        }
        return false;
    }
}
