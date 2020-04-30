// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class ExpandableHeightListView2 extends ListView
{

    boolean expanded;

    public ExpandableHeightListView2(Context context)
    {
        super(context);
        expanded = true;
    }

    public ExpandableHeightListView2(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        expanded = true;
    }

    public ExpandableHeightListView2(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        expanded = true;
    }

    public boolean isExpanded()
    {
        return expanded;
    }

    public void onMeasure(int i, int j)
    {
        if (isExpanded())
        {
            super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(0x1fffffff, 0x80000000));
            getLayoutParams().height = getMeasuredHeight();
            return;
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }

    public void setExpanded(boolean flag)
    {
        expanded = flag;
    }
}
