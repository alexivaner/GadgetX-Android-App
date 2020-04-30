// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridView;

public class ExpandedListView extends GridView
{

    private int old_count;
    private android.view.ViewGroup.LayoutParams params;
    private int verSpc;

    public ExpandedListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        old_count = 0;
        verSpc = 7;
    }

    public static float convertDpToPixel(float f, Context context)
    {
        return f * ((float)context.getResources().getDisplayMetrics().densityDpi / 160F);
    }

    public static float convertPixelsToDp(float f, Context context)
    {
        return f / ((float)context.getResources().getDisplayMetrics().densityDpi / 160F);
    }

    protected void onDraw(Canvas canvas)
    {
        int i = 0;
        try
        {
            float f = convertDpToPixel(verSpc, getContext());
            if (getCount() != old_count)
            {
                old_count = getCount();
                params = getLayoutParams();
                android.view.ViewGroup.LayoutParams layoutparams = params;
                int j = getCount();
                if (old_count > 0)
                {
                    i = getChildAt(0).getHeight();
                }
                layoutparams.height = (int)((float)(i * j) + (float)getCount() * f);
                setLayoutParams(params);
            }
            super.onDraw(canvas);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Canvas canvas)
        {
            return;
        }
    }
}
