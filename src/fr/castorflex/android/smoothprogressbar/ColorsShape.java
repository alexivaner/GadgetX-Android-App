// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.smoothprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

public class ColorsShape extends Shape
{

    private int mColors[];
    private float mStrokeWidth;

    public ColorsShape(float f, int ai[])
    {
        mStrokeWidth = f;
        mColors = ai;
    }

    public void draw(Canvas canvas, Paint paint)
    {
        float f = 1.0F / (float)mColors.length;
        int j = 0;
        paint.setStrokeWidth(mStrokeWidth);
        int ai[] = mColors;
        int k = ai.length;
        int i = 0;
        do
        {
            if (i >= k)
            {
                return;
            }
            paint.setColor(ai[i]);
            float f1 = j;
            float f2 = getWidth();
            float f3 = getHeight() / 2.0F;
            j++;
            float f4 = j;
            canvas.drawLine(f2 * (f1 * f), f3, getWidth() * (f4 * f), getHeight() / 2.0F, paint);
            i++;
        } while (true);
    }

    public int[] getColors()
    {
        return mColors;
    }

    public float getStrokeWidth()
    {
        return mStrokeWidth;
    }

    public void setColors(int ai[])
    {
        mColors = ai;
    }

    public void setStrokeWidth(float f)
    {
        mStrokeWidth = f;
    }
}
