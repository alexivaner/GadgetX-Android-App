// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;

// Referenced classes of package eu.janmuller.android.simplecropimage:
//            RotateBitmap

abstract class ImageViewTouchBase extends ImageView
{
    public static interface Recycler
    {

        public abstract void recycle(Bitmap bitmap);
    }


    static final float SCALE_RATE = 1.25F;
    private static final String TAG = "ImageViewTouchBase";
    protected Matrix mBaseMatrix;
    protected final RotateBitmap mBitmapDisplayed;
    int mBottom;
    private final Matrix mDisplayMatrix;
    protected Handler mHandler;
    int mLeft;
    private final float mMatrixValues[];
    float mMaxZoom;
    private Runnable mOnLayoutRunnable;
    private Recycler mRecycler;
    int mRight;
    protected Matrix mSuppMatrix;
    int mThisHeight;
    int mThisWidth;
    int mTop;

    public ImageViewTouchBase(Context context)
    {
        super(context);
        mBaseMatrix = new Matrix();
        mSuppMatrix = new Matrix();
        mDisplayMatrix = new Matrix();
        mMatrixValues = new float[9];
        mBitmapDisplayed = new RotateBitmap(null);
        mThisWidth = -1;
        mThisHeight = -1;
        mHandler = new Handler();
        mOnLayoutRunnable = null;
        init();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mBaseMatrix = new Matrix();
        mSuppMatrix = new Matrix();
        mDisplayMatrix = new Matrix();
        mMatrixValues = new float[9];
        mBitmapDisplayed = new RotateBitmap(null);
        mThisWidth = -1;
        mThisHeight = -1;
        mHandler = new Handler();
        mOnLayoutRunnable = null;
        init();
    }

    private void getProperBaseMatrix(RotateBitmap rotatebitmap, Matrix matrix)
    {
        float f = getWidth();
        float f1 = getHeight();
        float f2 = rotatebitmap.getWidth();
        float f3 = rotatebitmap.getHeight();
        rotatebitmap.getRotation();
        matrix.reset();
        float f4 = Math.min(Math.min(f / f2, 2.0F), Math.min(f1 / f3, 2.0F));
        matrix.postConcat(rotatebitmap.getRotateMatrix());
        matrix.postScale(f4, f4);
        matrix.postTranslate((f - f2 * f4) / 2.0F, (f1 - f3 * f4) / 2.0F);
    }

    private void init()
    {
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    private void setImageBitmap(Bitmap bitmap, int i)
    {
        super.setImageBitmap(bitmap);
        Object obj = getDrawable();
        if (obj != null)
        {
            ((Drawable) (obj)).setDither(true);
        }
        obj = mBitmapDisplayed.getBitmap();
        mBitmapDisplayed.setBitmap(bitmap);
        mBitmapDisplayed.setRotation(i);
        if (obj != null && obj != bitmap && mRecycler != null)
        {
            mRecycler.recycle(((Bitmap) (obj)));
        }
    }

    protected void center(boolean flag, boolean flag1)
    {
        if (mBitmapDisplayed.getBitmap() == null)
        {
            return;
        }
        Matrix matrix = getImageViewMatrix();
        RectF rectf = new RectF(0.0F, 0.0F, mBitmapDisplayed.getBitmap().getWidth(), mBitmapDisplayed.getBitmap().getHeight());
        matrix.mapRect(rectf);
        float f4 = rectf.height();
        float f3 = rectf.width();
        float f2 = 0.0F;
        float f1 = 0.0F;
        float f = f1;
        int i;
        if (flag1)
        {
            i = getHeight();
            if (f4 < (float)i)
            {
                f = ((float)i - f4) / 2.0F - rectf.top;
            } else
            if (rectf.top > 0.0F)
            {
                f = -rectf.top;
            } else
            {
                f = f1;
                if (rectf.bottom < (float)i)
                {
                    f = (float)getHeight() - rectf.bottom;
                }
            }
        }
        f1 = f2;
        if (flag)
        {
            i = getWidth();
            if (f3 < (float)i)
            {
                f1 = ((float)i - f3) / 2.0F - rectf.left;
            } else
            if (rectf.left > 0.0F)
            {
                f1 = -rectf.left;
            } else
            {
                f1 = f2;
                if (rectf.right < (float)i)
                {
                    f1 = (float)i - rectf.right;
                }
            }
        }
        postTranslate(f1, f);
        setImageMatrix(getImageViewMatrix());
    }

    public void clear()
    {
        setImageBitmapResetBase(null, true);
    }

    protected Matrix getImageViewMatrix()
    {
        mDisplayMatrix.set(mBaseMatrix);
        mDisplayMatrix.postConcat(mSuppMatrix);
        return mDisplayMatrix;
    }

    protected float getScale()
    {
        return getScale(mSuppMatrix);
    }

    protected float getScale(Matrix matrix)
    {
        return getValue(matrix, 0);
    }

    protected float getValue(Matrix matrix, int i)
    {
        matrix.getValues(mMatrixValues);
        return mMatrixValues[i];
    }

    protected float maxZoom()
    {
        if (mBitmapDisplayed.getBitmap() == null)
        {
            return 1.0F;
        } else
        {
            return Math.max((float)mBitmapDisplayed.getWidth() / (float)mThisWidth, (float)mBitmapDisplayed.getHeight() / (float)mThisHeight) * 4F;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && getScale() > 1.0F)
        {
            zoomTo(1.0F);
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        mLeft = i;
        mRight = k;
        mTop = j;
        mBottom = l;
        mThisWidth = k - i;
        mThisHeight = l - j;
        Runnable runnable = mOnLayoutRunnable;
        if (runnable != null)
        {
            mOnLayoutRunnable = null;
            runnable.run();
        }
        if (mBitmapDisplayed.getBitmap() != null)
        {
            getProperBaseMatrix(mBitmapDisplayed, mBaseMatrix);
            setImageMatrix(getImageViewMatrix());
        }
    }

    protected void panBy(float f, float f1)
    {
        postTranslate(f, f1);
        setImageMatrix(getImageViewMatrix());
    }

    protected void postTranslate(float f, float f1)
    {
        mSuppMatrix.postTranslate(f, f1);
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        setImageBitmap(bitmap, 0);
    }

    public void setImageBitmapResetBase(Bitmap bitmap, boolean flag)
    {
        setImageRotateBitmapResetBase(new RotateBitmap(bitmap), flag);
    }

    public void setImageRotateBitmapResetBase(final RotateBitmap bitmap, final boolean resetSupp)
    {
        if (getWidth() <= 0)
        {
            mOnLayoutRunnable = new Runnable() {

                final ImageViewTouchBase this$0;
                private final RotateBitmap val$bitmap;
                private final boolean val$resetSupp;

                public void run()
                {
                    setImageRotateBitmapResetBase(bitmap, resetSupp);
                }

            
            {
                this$0 = ImageViewTouchBase.this;
                bitmap = rotatebitmap;
                resetSupp = flag;
                super();
            }
            };
            return;
        }
        if (bitmap.getBitmap() != null)
        {
            getProperBaseMatrix(bitmap, mBaseMatrix);
            setImageBitmap(bitmap.getBitmap(), bitmap.getRotation());
        } else
        {
            mBaseMatrix.reset();
            setImageBitmap(null);
        }
        if (resetSupp)
        {
            mSuppMatrix.reset();
        }
        setImageMatrix(getImageViewMatrix());
        mMaxZoom = maxZoom();
    }

    public void setRecycler(Recycler recycler)
    {
        mRecycler = recycler;
    }

    protected void zoomIn()
    {
        zoomIn(1.25F);
    }

    protected void zoomIn(float f)
    {
        while (getScale() >= mMaxZoom || mBitmapDisplayed.getBitmap() == null) 
        {
            return;
        }
        float f1 = (float)getWidth() / 2.0F;
        float f2 = (float)getHeight() / 2.0F;
        mSuppMatrix.postScale(f, f, f1, f2);
        setImageMatrix(getImageViewMatrix());
    }

    protected void zoomOut()
    {
        zoomOut(1.25F);
    }

    protected void zoomOut(float f)
    {
        if (mBitmapDisplayed.getBitmap() == null)
        {
            return;
        }
        float f1 = (float)getWidth() / 2.0F;
        float f2 = (float)getHeight() / 2.0F;
        Matrix matrix = new Matrix(mSuppMatrix);
        matrix.postScale(1.0F / f, 1.0F / f, f1, f2);
        if (getScale(matrix) < 1.0F)
        {
            mSuppMatrix.setScale(1.0F, 1.0F, f1, f2);
        } else
        {
            mSuppMatrix.postScale(1.0F / f, 1.0F / f, f1, f2);
        }
        setImageMatrix(getImageViewMatrix());
        center(true, true);
    }

    protected void zoomTo(float f)
    {
        zoomTo(f, (float)getWidth() / 2.0F, (float)getHeight() / 2.0F);
    }

    protected void zoomTo(float f, float f1, float f2)
    {
        float f3 = f;
        if (f > mMaxZoom)
        {
            f3 = mMaxZoom;
        }
        f = f3 / getScale();
        mSuppMatrix.postScale(f, f, f1, f2);
        setImageMatrix(getImageViewMatrix());
        center(true, true);
    }

    protected void zoomTo(final float incrementPerMs, final float centerX, final float centerY, final float durationMs)
    {
        incrementPerMs = (incrementPerMs - getScale()) / durationMs;
        final float oldScale = getScale();
        final long startTime = System.currentTimeMillis();
        mHandler.post(new Runnable() {

            final ImageViewTouchBase this$0;
            private final float val$centerX;
            private final float val$centerY;
            private final float val$durationMs;
            private final float val$incrementPerMs;
            private final float val$oldScale;
            private final long val$startTime;

            public void run()
            {
                long l = System.currentTimeMillis();
                float f = Math.min(durationMs, l - startTime);
                float f1 = oldScale;
                float f2 = incrementPerMs;
                zoomTo(f1 + f2 * f, centerX, centerY);
                if (f < durationMs)
                {
                    mHandler.post(this);
                }
            }

            
            {
                this$0 = ImageViewTouchBase.this;
                durationMs = f;
                startTime = l;
                oldScale = f1;
                incrementPerMs = f2;
                centerX = f3;
                centerY = f4;
                super();
            }
        });
    }
}
