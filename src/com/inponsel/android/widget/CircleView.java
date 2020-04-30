// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CircleView extends View
{

    private int circleCol;
    private Paint circlePaint;
    private String circleText;
    private int labelCol;

    public CircleView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        circlePaint = new Paint();
        context = context.getTheme().obtainStyledAttributes(attributeset, com.inponsel.android.R.styleable.LovelyView, 0, 0);
        circleText = context.getString(1);
        circleCol = context.getInteger(0, 0);
        labelCol = context.getInteger(2, 0);
        context.recycle();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    protected void onDraw(Canvas canvas)
    {
        int j = getMeasuredWidth() / 2;
        int k = getMeasuredHeight() / 2;
        int i;
        if (j > k)
        {
            i = k - 10;
        } else
        {
            i = j - 10;
        }
        circlePaint.setStyle(android.graphics.Paint.Style.FILL);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(circleCol);
        canvas.drawCircle(j, k, i, circlePaint);
        circlePaint.setColor(labelCol);
        circlePaint.setTextAlign(android.graphics.Paint.Align.CENTER);
        circlePaint.setTextSize(50F);
        canvas.drawText(circleText, j, k, circlePaint);
    }

    public void setCircleColor(int i)
    {
        circleCol = i;
        invalidate();
        requestLayout();
    }

    public void setLabelColor(int i)
    {
        labelCol = i;
        invalidate();
        requestLayout();
    }

    public void setLabelText(String s)
    {
        circleText = s;
        invalidate();
        requestLayout();
    }
}
