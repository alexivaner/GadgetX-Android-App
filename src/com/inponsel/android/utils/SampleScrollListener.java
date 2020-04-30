// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.widget.AbsListView;
import com.squareup.picasso.Picasso;

public class SampleScrollListener
    implements android.widget.AbsListView.OnScrollListener
{

    private final Context context;

    public SampleScrollListener(Context context1)
    {
        context = context1;
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        abslistview = Picasso.with(context);
        if (i == 0 || i == 1)
        {
            abslistview.resumeTag(context);
            return;
        } else
        {
            abslistview.pauseTag(context);
            return;
        }
    }
}
