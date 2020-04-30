// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom.graphics;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import java.io.InputStream;

// Referenced classes of package it.sephiroth.android.library.imagezoom.graphics:
//            IBitmapDrawable

public class FastBitmapDrawable extends Drawable
    implements IBitmapDrawable
{

    protected Bitmap mBitmap;
    protected int mIntrinsicHeight;
    protected int mIntrinsicWidth;
    protected Paint mPaint;

    public FastBitmapDrawable(Resources resources, InputStream inputstream)
    {
        this(BitmapFactory.decodeStream(inputstream));
    }

    public FastBitmapDrawable(Bitmap bitmap)
    {
        mBitmap = bitmap;
        if (mBitmap != null)
        {
            mIntrinsicWidth = mBitmap.getWidth();
            mIntrinsicHeight = mBitmap.getHeight();
        } else
        {
            mIntrinsicWidth = 0;
            mIntrinsicHeight = 0;
        }
        mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setFilterBitmap(true);
    }

    public void draw(Canvas canvas)
    {
        if (mBitmap != null && !mBitmap.isRecycled())
        {
            canvas.drawBitmap(mBitmap, 0.0F, 0.0F, mPaint);
        }
    }

    public Bitmap getBitmap()
    {
        return mBitmap;
    }

    public int getIntrinsicHeight()
    {
        return mIntrinsicHeight;
    }

    public int getIntrinsicWidth()
    {
        return mIntrinsicWidth;
    }

    public int getMinimumHeight()
    {
        return mIntrinsicHeight;
    }

    public int getMinimumWidth()
    {
        return mIntrinsicWidth;
    }

    public int getOpacity()
    {
        return -3;
    }

    public Paint getPaint()
    {
        return mPaint;
    }

    public void setAlpha(int i)
    {
        mPaint.setAlpha(i);
    }

    public void setAntiAlias(boolean flag)
    {
        mPaint.setAntiAlias(flag);
        invalidateSelf();
    }

    public void setBitmap(Bitmap bitmap)
    {
        mBitmap = bitmap;
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        mPaint.setColorFilter(colorfilter);
    }
}
