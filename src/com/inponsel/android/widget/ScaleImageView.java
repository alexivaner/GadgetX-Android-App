// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ScaleImageView extends ImageView
{

    public ScaleImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onMeasure(int i, int j)
    {
        Drawable drawable = getDrawable();
        if (drawable != null)
        {
            if (android.view.View.MeasureSpec.getMode(j) == 0x40000000)
            {
                i = android.view.View.MeasureSpec.getSize(j);
                j = (int)Math.ceil(((float)i * (float)drawable.getIntrinsicWidth()) / (float)drawable.getIntrinsicHeight());
            } else
            {
                j = android.view.View.MeasureSpec.getSize(i);
                i = (int)Math.ceil(((float)j * (float)drawable.getIntrinsicHeight()) / (float)drawable.getIntrinsicWidth());
            }
            setMeasuredDimension(j, i);
            return;
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }
}
