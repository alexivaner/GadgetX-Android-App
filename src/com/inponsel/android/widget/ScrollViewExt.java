// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class ScrollViewExt extends ScrollView
{
    public static interface ScrollViewListener
    {

        public abstract void onScrollChanged(ScrollViewExt scrollviewext, int i, int j, int k, int l);
    }


    private ScrollViewListener scrollViewListener;

    public ScrollViewExt(Context context)
    {
        super(context);
        scrollViewListener = null;
    }

    public ScrollViewExt(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        scrollViewListener = null;
    }

    public ScrollViewExt(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        scrollViewListener = null;
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        if (scrollViewListener != null)
        {
            scrollViewListener.onScrollChanged(this, i, j, k, l);
        }
    }

    public void setScrollViewListener(ScrollViewListener scrollviewlistener)
    {
        scrollViewListener = scrollviewlistener;
    }
}
