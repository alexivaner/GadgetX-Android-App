// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ImageViewRounded extends ImageView
{

    private float mCornerRadius;

    public ImageViewRounded(Context context)
    {
        super(context);
    }

    public ImageViewRounded(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = context.obtainStyledAttributes(attributeset, com.inponsel.android.R.styleable.RoundedImageView);
        if (context != null)
        {
            mCornerRadius = context.getDimension(1, 0.0F);
            context.recycle();
        }
    }

    protected void onDraw(Canvas canvas)
    {
        Object obj = getDrawable();
        if ((obj instanceof BitmapDrawable) && mCornerRadius > 0.0F)
        {
            Paint paint = ((BitmapDrawable)obj).getPaint();
            obj = new RectF(((Drawable) (obj)).getBounds());
            int i = canvas.saveLayer(((RectF) (obj)), null, 31);
            getImageMatrix().mapRect(((RectF) (obj)));
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(0xff000000);
            canvas.drawRoundRect(((RectF) (obj)), mCornerRadius, mCornerRadius, paint);
            obj = paint.getXfermode();
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            super.onDraw(canvas);
            paint.setXfermode(((android.graphics.Xfermode) (obj)));
            canvas.restoreToCount(i);
            return;
        } else
        {
            super.onDraw(canvas);
            return;
        }
    }

    public void setCornerRadius(float f)
    {
        mCornerRadius = f;
    }
}
