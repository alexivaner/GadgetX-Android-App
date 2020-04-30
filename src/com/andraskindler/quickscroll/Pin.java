// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.andraskindler.quickscroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class Pin extends View
{

    private static final int mPinColor = Color.argb(224, 66, 66, 66);
    private Paint mPaint;
    private Path mPath;

    public Pin(Context context)
    {
        super(context);
        init();
    }

    public Pin(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public Pin(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(android.graphics.Paint.Style.FILL);
        setColor(mPinColor);
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawPath(mPath, mPaint);
        super.onDraw(canvas);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (flag)
        {
            mPath.reset();
            mPath.moveTo(0.0F, getHeight());
            mPath.lineTo(getWidth(), getHeight() / 2);
            mPath.lineTo(0.0F, 0.0F);
            mPath.close();
        }
        super.onLayout(flag, i, j, k, l);
    }

    public void setColor(int i)
    {
        mPaint.setColor(i);
    }

}
