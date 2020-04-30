// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class CustomDurationScroller extends Scroller
{

    private double scrollFactor;

    public CustomDurationScroller(Context context)
    {
        super(context);
        scrollFactor = 1.0D;
    }

    public CustomDurationScroller(Context context, Interpolator interpolator)
    {
        super(context, interpolator);
        scrollFactor = 1.0D;
    }

    public void setScrollDurationFactor(double d)
    {
        scrollFactor = d;
    }

    public void startScroll(int i, int j, int k, int l, int i1)
    {
        super.startScroll(i, j, k, l, (int)((double)i1 * scrollFactor));
    }
}
