// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

class HighlightView
{
    static final class ModifyMode extends Enum
    {

        private static final ModifyMode ENUM$VALUES[];
        public static final ModifyMode Grow;
        public static final ModifyMode Move;
        public static final ModifyMode None;

        public static ModifyMode valueOf(String s)
        {
            return (ModifyMode)Enum.valueOf(eu/janmuller/android/simplecropimage/HighlightView$ModifyMode, s);
        }

        public static ModifyMode[] values()
        {
            ModifyMode amodifymode[] = ENUM$VALUES;
            int i = amodifymode.length;
            ModifyMode amodifymode1[] = new ModifyMode[i];
            System.arraycopy(amodifymode, 0, amodifymode1, 0, i);
            return amodifymode1;
        }

        static 
        {
            None = new ModifyMode("None", 0);
            Move = new ModifyMode("Move", 1);
            Grow = new ModifyMode("Grow", 2);
            ENUM$VALUES = (new ModifyMode[] {
                None, Move, Grow
            });
        }

        private ModifyMode(String s, int i)
        {
            super(s, i);
        }
    }


    public static final int GROW_BOTTOM_EDGE = 16;
    public static final int GROW_LEFT_EDGE = 2;
    public static final int GROW_NONE = 1;
    public static final int GROW_RIGHT_EDGE = 4;
    public static final int GROW_TOP_EDGE = 8;
    public static final int MOVE = 32;
    private static final String TAG = "HighlightView";
    private boolean mCircle;
    View mContext;
    RectF mCropRect;
    Rect mDrawRect;
    private final Paint mFocusPaint = new Paint();
    boolean mHidden;
    private RectF mImageRect;
    private float mInitialAspectRatio;
    boolean mIsFocused;
    private boolean mMaintainAspectRatio;
    Matrix mMatrix;
    private ModifyMode mMode;
    private final Paint mNoFocusPaint = new Paint();
    private final Paint mOutlinePaint = new Paint();
    private Drawable mResizeDrawableDiagonal;
    private Drawable mResizeDrawableHeight;
    private Drawable mResizeDrawableWidth;

    public HighlightView(View view)
    {
        mMode = ModifyMode.None;
        mMaintainAspectRatio = false;
        mCircle = false;
        mContext = view;
    }

    private Rect computeLayout()
    {
        RectF rectf = new RectF(mCropRect.left, mCropRect.top, mCropRect.right, mCropRect.bottom);
        mMatrix.mapRect(rectf);
        return new Rect(Math.round(rectf.left), Math.round(rectf.top), Math.round(rectf.right), Math.round(rectf.bottom));
    }

    private void init()
    {
        Resources resources = mContext.getResources();
        mResizeDrawableWidth = resources.getDrawable(R.drawable.camera_crop_width);
        mResizeDrawableHeight = resources.getDrawable(R.drawable.camera_crop_height);
        mResizeDrawableDiagonal = resources.getDrawable(R.drawable.indicator_autocrop);
    }

    protected void draw(Canvas canvas)
    {
        if (!mHidden)
        {
            Path path = new Path();
            if (!hasFocus())
            {
                mOutlinePaint.setColor(0xff000000);
                canvas.drawRect(mDrawRect, mOutlinePaint);
                return;
            }
            Rect rect = new Rect();
            mContext.getDrawingRect(rect);
            if (mCircle)
            {
                canvas.save();
                float f = mDrawRect.width();
                float f1 = mDrawRect.height();
                path.addCircle((float)mDrawRect.left + f / 2.0F, (float)mDrawRect.top + f1 / 2.0F, f / 2.0F, android.graphics.Path.Direction.CW);
                mOutlinePaint.setColor(0xffef04d6);
                canvas.clipPath(path, android.graphics.Region.Op.DIFFERENCE);
                Paint paint;
                int i;
                int k;
                int i1;
                if (hasFocus())
                {
                    paint = mFocusPaint;
                } else
                {
                    paint = mNoFocusPaint;
                }
                canvas.drawRect(rect, paint);
                canvas.restore();
            } else
            {
                Rect rect1 = new Rect(rect.left, rect.top, rect.right, mDrawRect.top);
                Paint paint1;
                if (rect1.width() > 0 && rect1.height() > 0)
                {
                    Rect rect2;
                    Rect rect3;
                    if (hasFocus())
                    {
                        paint1 = mFocusPaint;
                    } else
                    {
                        paint1 = mNoFocusPaint;
                    }
                    canvas.drawRect(rect1, paint1);
                }
                rect2 = new Rect(rect.left, mDrawRect.bottom, rect.right, rect.bottom);
                if (rect2.width() > 0 && rect2.height() > 0)
                {
                    if (hasFocus())
                    {
                        paint1 = mFocusPaint;
                    } else
                    {
                        paint1 = mNoFocusPaint;
                    }
                    canvas.drawRect(rect2, paint1);
                }
                rect3 = new Rect(rect.left, rect1.bottom, mDrawRect.left, rect2.top);
                if (rect3.width() > 0 && rect3.height() > 0)
                {
                    if (hasFocus())
                    {
                        paint1 = mFocusPaint;
                    } else
                    {
                        paint1 = mNoFocusPaint;
                    }
                    canvas.drawRect(rect3, paint1);
                }
                rect = new Rect(mDrawRect.right, rect1.bottom, rect.right, rect2.top);
                if (rect.width() > 0 && rect.height() > 0)
                {
                    if (hasFocus())
                    {
                        paint1 = mFocusPaint;
                    } else
                    {
                        paint1 = mNoFocusPaint;
                    }
                    canvas.drawRect(rect, paint1);
                }
                path.addRect(new RectF(mDrawRect), android.graphics.Path.Direction.CW);
                mOutlinePaint.setColor(Color.parseColor("#F44336"));
            }
            canvas.drawPath(path, mOutlinePaint);
            if (mMode == ModifyMode.Grow)
            {
                if (mCircle)
                {
                    i1 = mResizeDrawableDiagonal.getIntrinsicWidth();
                    i = mResizeDrawableDiagonal.getIntrinsicHeight();
                    k = (int)Math.round(Math.cos(0.78539816339744828D) * ((double)mDrawRect.width() / 2D));
                    i1 = (mDrawRect.left + mDrawRect.width() / 2 + k) - i1 / 2;
                    i = (mDrawRect.top + mDrawRect.height() / 2) - k - i / 2;
                    mResizeDrawableDiagonal.setBounds(i1, i, mResizeDrawableDiagonal.getIntrinsicWidth() + i1, mResizeDrawableDiagonal.getIntrinsicHeight() + i);
                    mResizeDrawableDiagonal.draw(canvas);
                    return;
                } else
                {
                    int j = mDrawRect.left + 1;
                    int l = mDrawRect.right + 1;
                    int j1 = mDrawRect.top + 4;
                    int k1 = mDrawRect.bottom + 3;
                    int l1 = mResizeDrawableWidth.getIntrinsicWidth() / 2;
                    int i2 = mResizeDrawableWidth.getIntrinsicHeight() / 2;
                    int j2 = mResizeDrawableHeight.getIntrinsicHeight() / 2;
                    int k2 = mResizeDrawableHeight.getIntrinsicWidth() / 2;
                    int l2 = mDrawRect.left + (mDrawRect.right - mDrawRect.left) / 2;
                    int i3 = mDrawRect.top + (mDrawRect.bottom - mDrawRect.top) / 2;
                    mResizeDrawableWidth.setBounds(j - l1, i3 - i2, j + l1, i3 + i2);
                    mResizeDrawableWidth.draw(canvas);
                    mResizeDrawableWidth.setBounds(l - l1, i3 - i2, l + l1, i3 + i2);
                    mResizeDrawableWidth.draw(canvas);
                    mResizeDrawableHeight.setBounds(l2 - k2, j1 - j2, l2 + k2, j1 + j2);
                    mResizeDrawableHeight.draw(canvas);
                    mResizeDrawableHeight.setBounds(l2 - k2, k1 - j2, l2 + k2, k1 + j2);
                    mResizeDrawableHeight.draw(canvas);
                    return;
                }
            }
        }
    }

    public Rect getCropRect()
    {
        return new Rect((int)mCropRect.left, (int)mCropRect.top, (int)mCropRect.right, (int)mCropRect.bottom);
    }

    public int getHit(float f, float f1)
    {
        Rect rect;
        int j;
        rect = computeLayout();
        j = 1;
        if (!mCircle) goto _L2; else goto _L1
_L1:
        int i;
        f -= rect.centerX();
        f1 -= rect.centerY();
        i = (int)Math.sqrt(f * f + f1 * f1);
        j = mDrawRect.width() / 2;
        if ((float)Math.abs(i - j) > 20F) goto _L4; else goto _L3
_L3:
        if (Math.abs(f1) <= Math.abs(f)) goto _L6; else goto _L5
_L5:
        if (f1 >= 0.0F) goto _L8; else goto _L7
_L7:
        i = 8;
_L10:
        return i;
_L8:
        return 16;
_L6:
        return f >= 0.0F ? 4 : 2;
_L4:
        return i >= j ? 1 : 32;
_L2:
        boolean flag;
        boolean flag1;
        if (f1 >= (float)rect.top - 20F && f1 < (float)rect.bottom + 20F)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (f >= (float)rect.left - 20F && f < (float)rect.right + 20F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = j;
        if (Math.abs((float)rect.left - f) < 20F)
        {
            i = j;
            if (flag1)
            {
                i = 1 | 2;
            }
        }
        j = i;
        if (Math.abs((float)rect.right - f) < 20F)
        {
            j = i;
            if (flag1)
            {
                j = i | 4;
            }
        }
        i = j;
        if (Math.abs((float)rect.top - f1) < 20F)
        {
            i = j;
            if (flag)
            {
                i = j | 8;
            }
        }
        j = i;
        if (Math.abs((float)rect.bottom - f1) < 20F)
        {
            j = i;
            if (flag)
            {
                j = i | 0x10;
            }
        }
        i = j;
        if (j == 1)
        {
            i = j;
            if (rect.contains((int)f, (int)f1))
            {
                return 32;
            }
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public ModifyMode getMode()
    {
        return mMode;
    }

    void growBy(float f, float f1)
    {
        float f4 = 25F;
        float f3 = f;
        float f2 = f1;
        RectF rectf;
        if (mMaintainAspectRatio)
        {
            if (f != 0.0F)
            {
                f2 = f / mInitialAspectRatio;
                f3 = f;
            } else
            {
                f3 = f;
                f2 = f1;
                if (f1 != 0.0F)
                {
                    f3 = f1 * mInitialAspectRatio;
                    f2 = f1;
                }
            }
        }
        rectf = new RectF(mCropRect);
        f = f3;
        f1 = f2;
        if (f3 > 0.0F)
        {
            f = f3;
            f1 = f2;
            if (rectf.width() + 2.0F * f3 > mImageRect.width())
            {
                f3 = (mImageRect.width() - rectf.width()) / 2.0F;
                f = f3;
                f1 = f2;
                if (mMaintainAspectRatio)
                {
                    f1 = f3 / mInitialAspectRatio;
                    f = f3;
                }
            }
        }
        f3 = f;
        f2 = f1;
        if (f1 > 0.0F)
        {
            f3 = f;
            f2 = f1;
            if (rectf.height() + 2.0F * f1 > mImageRect.height())
            {
                f1 = (mImageRect.height() - rectf.height()) / 2.0F;
                f3 = f;
                f2 = f1;
                if (mMaintainAspectRatio)
                {
                    f3 = f1 * mInitialAspectRatio;
                    f2 = f1;
                }
            }
        }
        rectf.inset(-f3, -f2);
        if (rectf.width() < 25F)
        {
            rectf.inset(-(25F - rectf.width()) / 2.0F, 0.0F);
        }
        f = f4;
        if (mMaintainAspectRatio)
        {
            f = 25F / mInitialAspectRatio;
        }
        if (rectf.height() < f)
        {
            rectf.inset(0.0F, -(f - rectf.height()) / 2.0F);
        }
        if (rectf.left < mImageRect.left)
        {
            rectf.offset(mImageRect.left - rectf.left, 0.0F);
        } else
        if (rectf.right > mImageRect.right)
        {
            rectf.offset(-(rectf.right - mImageRect.right), 0.0F);
        }
        if (rectf.top < mImageRect.top)
        {
            rectf.offset(0.0F, mImageRect.top - rectf.top);
        } else
        if (rectf.bottom > mImageRect.bottom)
        {
            rectf.offset(0.0F, -(rectf.bottom - mImageRect.bottom));
        }
        mCropRect.set(rectf);
        mDrawRect = computeLayout();
        mContext.invalidate();
    }

    void handleMotion(int i, float f, float f1)
    {
        byte byte0 = -1;
        Rect rect = computeLayout();
        if (i == 1)
        {
            return;
        }
        if (i == 32)
        {
            moveBy((mCropRect.width() / (float)rect.width()) * f, (mCropRect.height() / (float)rect.height()) * f1);
            return;
        }
        if ((i & 6) == 0)
        {
            f = 0.0F;
        }
        if ((i & 0x18) == 0)
        {
            f1 = 0.0F;
        }
        float f2 = mCropRect.width() / (float)rect.width();
        float f3 = mCropRect.height() / (float)rect.height();
        float f4;
        int j;
        if ((i & 2) != 0)
        {
            j = -1;
        } else
        {
            j = 1;
        }
        f4 = j;
        if ((i & 8) != 0)
        {
            i = byte0;
        } else
        {
            i = 1;
        }
        growBy(f4 * (f * f2), (float)i * (f1 * f3));
    }

    public boolean hasFocus()
    {
        return mIsFocused;
    }

    public void invalidate()
    {
        mDrawRect = computeLayout();
    }

    void moveBy(float f, float f1)
    {
        Rect rect = new Rect(mDrawRect);
        mCropRect.offset(f, f1);
        mCropRect.offset(Math.max(0.0F, mImageRect.left - mCropRect.left), Math.max(0.0F, mImageRect.top - mCropRect.top));
        mCropRect.offset(Math.min(0.0F, mImageRect.right - mCropRect.right), Math.min(0.0F, mImageRect.bottom - mCropRect.bottom));
        mDrawRect = computeLayout();
        rect.union(mDrawRect);
        rect.inset(-10, -10);
        mContext.invalidate(rect);
    }

    public void setFocus(boolean flag)
    {
        mIsFocused = flag;
    }

    public void setHidden(boolean flag)
    {
        mHidden = flag;
    }

    public void setMode(ModifyMode modifymode)
    {
        if (modifymode != mMode)
        {
            mMode = modifymode;
            mContext.invalidate();
        }
    }

    public void setup(Matrix matrix, Rect rect, RectF rectf, boolean flag, boolean flag1)
    {
        if (flag)
        {
            flag1 = true;
        }
        mMatrix = new Matrix(matrix);
        mCropRect = rectf;
        mImageRect = new RectF(rect);
        mMaintainAspectRatio = flag1;
        mCircle = flag;
        mInitialAspectRatio = mCropRect.width() / mCropRect.height();
        mDrawRect = computeLayout();
        mFocusPaint.setARGB(125, 50, 50, 50);
        mNoFocusPaint.setARGB(125, 50, 50, 50);
        mOutlinePaint.setStrokeWidth(3F);
        mOutlinePaint.setStyle(android.graphics.Paint.Style.STROKE);
        mOutlinePaint.setAntiAlias(true);
        mMode = ModifyMode.None;
        init();
    }
}
