// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

// Referenced classes of package com.nostra13.universalimageloader.core.display:
//            BitmapDisplayer

public class CircleBitmapDisplayer
    implements BitmapDisplayer
{
    public static class CircleDrawable extends Drawable
    {

        protected final BitmapShader bitmapShader;
        protected final RectF mBitmapRect;
        protected final RectF mRect = new RectF();
        protected final Paint paint = new Paint();
        protected float radius;
        protected final Paint strokePaint;
        protected float strokeRadius;
        protected final float strokeWidth;

        public void draw(Canvas canvas)
        {
            canvas.drawCircle(radius, radius, radius, paint);
            if (strokePaint != null)
            {
                canvas.drawCircle(radius, radius, strokeRadius, strokePaint);
            }
        }

        public int getOpacity()
        {
            return -3;
        }

        protected void onBoundsChange(Rect rect)
        {
            super.onBoundsChange(rect);
            mRect.set(0.0F, 0.0F, rect.width(), rect.height());
            radius = Math.min(rect.width(), rect.height()) / 2;
            strokeRadius = radius - strokeWidth / 2.0F;
            rect = new Matrix();
            rect.setRectToRect(mBitmapRect, mRect, android.graphics.Matrix.ScaleToFit.FILL);
            bitmapShader.setLocalMatrix(rect);
        }

        public void setAlpha(int i)
        {
            paint.setAlpha(i);
        }

        public void setColorFilter(ColorFilter colorfilter)
        {
            paint.setColorFilter(colorfilter);
        }

        public CircleDrawable(Bitmap bitmap, Integer integer, float f)
        {
            radius = Math.min(bitmap.getWidth(), bitmap.getHeight()) / 2;
            bitmapShader = new BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
            mBitmapRect = new RectF(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
            paint.setFilterBitmap(true);
            paint.setDither(true);
            if (integer == null)
            {
                strokePaint = null;
            } else
            {
                strokePaint = new Paint();
                strokePaint.setStyle(android.graphics.Paint.Style.STROKE);
                strokePaint.setColor(integer.intValue());
                strokePaint.setStrokeWidth(f);
                strokePaint.setAntiAlias(true);
            }
            strokeWidth = f;
            strokeRadius = radius - f / 2.0F;
        }
    }


    protected final Integer strokeColor;
    protected final float strokeWidth;

    public CircleBitmapDisplayer()
    {
        this(null);
    }

    public CircleBitmapDisplayer(Integer integer)
    {
        this(integer, 0.0F);
    }

    public CircleBitmapDisplayer(Integer integer, float f)
    {
        strokeColor = integer;
        strokeWidth = f;
    }

    public void display(Bitmap bitmap, ImageAware imageaware, LoadedFrom loadedfrom)
    {
        if (!(imageaware instanceof ImageViewAware))
        {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        } else
        {
            imageaware.setImageDrawable(new CircleDrawable(bitmap, strokeColor, strokeWidth));
            return;
        }
    }
}
