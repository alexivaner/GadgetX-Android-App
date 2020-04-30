// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class CircleProgressBar extends View
{

    private Paint backgroundPaint;
    private int color;
    private Paint foregroundPaint;
    private int max;
    private int min;
    private float progress;
    private RectF rectF;
    private int startAngle;
    private float strokeWidth;

    public CircleProgressBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        strokeWidth = 4F;
        progress = 0.0F;
        min = 0;
        max = 100;
        startAngle = -90;
        color = 0xff444444;
        init(context, attributeset);
    }

    private void init(Context context, AttributeSet attributeset)
    {
        rectF = new RectF();
        context = context.getTheme().obtainStyledAttributes(attributeset, com.inponsel.android.R.styleable.CircleProgressBar, 0, 0);
        strokeWidth = context.getDimension(4, strokeWidth);
        progress = context.getFloat(2, progress);
        color = context.getInt(3, color);
        min = context.getInt(0, min);
        max = context.getInt(1, max);
        context.recycle();
        backgroundPaint = new Paint(1);
        backgroundPaint.setColor(adjustAlpha(color, 0.3F));
        backgroundPaint.setStyle(android.graphics.Paint.Style.STROKE);
        backgroundPaint.setStrokeWidth(strokeWidth);
        foregroundPaint = new Paint(1);
        foregroundPaint.setColor(color);
        foregroundPaint.setStyle(android.graphics.Paint.Style.STROKE);
        foregroundPaint.setStrokeWidth(strokeWidth);
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    public int adjustAlpha(int i, float f)
    {
        return Color.argb(Math.round((float)Color.alpha(i) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public int getColor()
    {
        return color;
    }

    public int getMax()
    {
        return max;
    }

    public int getMin()
    {
        return min;
    }

    public float getProgress()
    {
        return progress;
    }

    public float getStrokeWidth()
    {
        return strokeWidth;
    }

    public int lightenColor(int i, float f)
    {
        float f1 = Color.red(i);
        float f2 = Color.green(i);
        float f3 = Color.blue(i);
        int j = Math.min(255, (int)(f1 * f));
        int k = Math.min(255, (int)(f2 * f));
        int l = Math.min(255, (int)(f3 * f));
        return Color.argb(Color.alpha(i), j, k, l);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawOval(rectF, backgroundPaint);
        float f = (360F * progress) / (float)max;
        canvas.drawArc(rectF, startAngle, f, false, foregroundPaint);
    }

    protected void onMeasure(int i, int j)
    {
        j = getDefaultSize(getSuggestedMinimumHeight(), j);
        i = Math.min(getDefaultSize(getSuggestedMinimumWidth(), i), j);
        setMeasuredDimension(i, i);
        rectF.set(strokeWidth / 2.0F + 0.0F, strokeWidth / 2.0F + 0.0F, (float)i - strokeWidth / 2.0F, (float)i - strokeWidth / 2.0F);
    }

    public void setColor(int i)
    {
        color = i;
        backgroundPaint.setColor(getResources().getColor(0x7f08017a));
        foregroundPaint.setColor(i);
        invalidate();
        requestLayout();
    }

    public void setMax(int i)
    {
        max = i;
        invalidate();
    }

    public void setMin(int i)
    {
        min = i;
        invalidate();
    }

    public void setProgress(float f)
    {
        progress = f;
        invalidate();
    }

    public void setProgressWithAnimation(float f)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(this, "progress", new float[] {
            f
        });
        objectanimator.setDuration(1500L);
        objectanimator.setInterpolator(new DecelerateInterpolator());
        objectanimator.start();
    }

    public void setStrokeWidth(float f)
    {
        strokeWidth = f;
        backgroundPaint.setStrokeWidth(f);
        foregroundPaint.setStrokeWidth(f);
        invalidate();
        requestLayout();
    }
}
