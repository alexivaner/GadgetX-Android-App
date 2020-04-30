// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.faizmalkani.floatingactionbutton;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.RelativeLayout;

// Referenced classes of package com.faizmalkani.floatingactionbutton:
//            DirectionScrollListener

public class FloatingActionButton extends RelativeLayout
{

    private Bitmap mBitmap;
    private final Paint mButtonPaint;
    private int mColor;
    private float mCurrentY;
    private final Paint mDrawablePaint;
    private boolean mHidden;
    private final Interpolator mInterpolator;
    private int mScreenHeight;

    public FloatingActionButton(Context context)
    {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mInterpolator = new AccelerateDecelerateInterpolator();
        mButtonPaint = new Paint(1);
        mDrawablePaint = new Paint(1);
        mHidden = false;
        attributeset = getContext().obtainStyledAttributes(attributeset, R.styleable.FloatingActionButton);
        mColor = attributeset.getColor(R.styleable.FloatingActionButton_color, -1);
        mButtonPaint.setStyle(android.graphics.Paint.Style.FILL);
        mButtonPaint.setColor(mColor);
        float f = attributeset.getFloat(R.styleable.FloatingActionButton_shadowRadius, 10F);
        float f1 = attributeset.getFloat(R.styleable.FloatingActionButton_shadowDx, 0.0F);
        float f2 = attributeset.getFloat(R.styleable.FloatingActionButton_shadowDy, 3.5F);
        i = attributeset.getInteger(R.styleable.FloatingActionButton_shadowColor, Color.argb(100, 0, 0, 0));
        mButtonPaint.setShadowLayer(f, f1, f2, i);
        attributeset = attributeset.getDrawable(R.styleable.FloatingActionButton_drawable);
        if (attributeset != null)
        {
            mBitmap = ((BitmapDrawable)attributeset).getBitmap();
        }
        setWillNotDraw(false);
        setLayerType(1, null);
        context = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        attributeset = new Point();
        context.getSize(attributeset);
        mScreenHeight = ((Point) (attributeset)).y;
    }

    public static int darkenColor(int i)
    {
        float af[] = new float[3];
        Color.colorToHSV(i, af);
        af[2] = af[2] * 0.8F;
        return Color.HSVToColor(af);
    }

    public void hide(boolean flag)
    {
        if (mHidden != flag)
        {
            float f;
            ObjectAnimator objectanimator;
            if (mHidden)
            {
                f = mCurrentY;
            } else
            {
                mCurrentY = getY();
                f = mScreenHeight;
            }
            mHidden = flag;
            objectanimator = ObjectAnimator.ofFloat(this, "Y", new float[] {
                f
            });
            objectanimator.setInterpolator(mInterpolator);
            objectanimator.start();
        }
    }

    public void listenTo(AbsListView abslistview)
    {
        if (abslistview != null)
        {
            abslistview.setOnScrollListener(new DirectionScrollListener(this));
        }
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (float)((double)getWidth() / 2.6000000000000001D), mButtonPaint);
        if (mBitmap != null)
        {
            canvas.drawBitmap(mBitmap, (getWidth() - mBitmap.getWidth()) / 2, (getHeight() - mBitmap.getHeight()) / 2, mDrawablePaint);
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        if (motionevent.getAction() == 1)
        {
            i = mColor;
        } else
        {
            i = darkenColor(mColor);
        }
        mButtonPaint.setColor(i);
        invalidate();
        return super.onTouchEvent(motionevent);
    }

    public void setColor(int i)
    {
        mColor = i;
        mButtonPaint.setColor(mColor);
        invalidate();
    }

    public void setDrawable(Drawable drawable)
    {
        mBitmap = ((BitmapDrawable)drawable).getBitmap();
        invalidate();
    }
}
