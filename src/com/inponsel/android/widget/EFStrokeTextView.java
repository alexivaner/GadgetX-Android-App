// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

public class EFStrokeTextView extends TextView
{

    private int mStrokeColor;
    private TextPaint mStrokePaint;
    private int mStrokeWidth;

    public EFStrokeTextView(Context context)
    {
        super(context);
    }

    public EFStrokeTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public EFStrokeTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onDraw(Canvas canvas)
    {
        if (mStrokePaint == null)
        {
            mStrokePaint = new TextPaint();
        }
        mStrokePaint.setTextSize(getTextSize());
        mStrokePaint.setTypeface(getTypeface());
        mStrokePaint.setFlags(getPaintFlags());
        mStrokePaint.setStyle(android.graphics.Paint.Style.STROKE);
        mStrokePaint.setColor(mStrokeColor);
        mStrokePaint.setStrokeWidth(mStrokeWidth);
        String s = getText().toString();
        canvas.drawText(s, ((float)getWidth() - mStrokePaint.measureText(s)) / 2.0F, getBaseline(), mStrokePaint);
        super.onDraw(canvas);
    }

    public void setStrokeColor(int i)
    {
        mStrokeColor = i;
    }

    public void setStrokeWidth(int i)
    {
        mStrokeWidth = i;
    }
}
