// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.circularprogressbar;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

// Referenced classes of package fr.castorflex.android.circularprogressbar:
//            CircularProgressBarUtils

public class CircularProgressDrawable extends Drawable
    implements Animatable
{
    public static class Builder
    {

        private Interpolator mAngleInterpolator;
        private int mColors[];
        private int mMaxSweepAngle;
        private int mMinSweepAngle;
        private float mRotationSpeed;
        private float mStrokeWidth;
        private Style mStyle;
        private Interpolator mSweepInterpolator;
        private float mSweepSpeed;

        private void initValues(Context context, boolean flag)
        {
            mStrokeWidth = context.getResources().getDimension(R.dimen.cpb_default_stroke_width);
            mSweepSpeed = 1.0F;
            mRotationSpeed = 1.0F;
            if (flag)
            {
                mColors = (new int[] {
                    0xff0000ff
                });
                mMinSweepAngle = 20;
                mMaxSweepAngle = 300;
            } else
            {
                mColors = (new int[] {
                    context.getResources().getColor(R.color.cpb_default_color)
                });
                mMinSweepAngle = context.getResources().getInteger(R.integer.cpb_default_min_sweep_angle);
                mMaxSweepAngle = context.getResources().getInteger(R.integer.cpb_default_max_sweep_angle);
            }
            mStyle = Style.ROUNDED;
        }

        public Builder angleInterpolator(Interpolator interpolator)
        {
            CircularProgressBarUtils.checkNotNull(interpolator, "Angle interpolator");
            mAngleInterpolator = interpolator;
            return this;
        }

        public CircularProgressDrawable build()
        {
            return new CircularProgressDrawable(mColors, mStrokeWidth, mSweepSpeed, mRotationSpeed, mMinSweepAngle, mMaxSweepAngle, mStyle, mAngleInterpolator, mSweepInterpolator, null);
        }

        public Builder color(int i)
        {
            mColors = (new int[] {
                i
            });
            return this;
        }

        public Builder colors(int ai[])
        {
            CircularProgressBarUtils.checkColors(ai);
            mColors = ai;
            return this;
        }

        public Builder maxSweepAngle(int i)
        {
            CircularProgressBarUtils.checkAngle(i);
            mMaxSweepAngle = i;
            return this;
        }

        public Builder minSweepAngle(int i)
        {
            CircularProgressBarUtils.checkAngle(i);
            mMinSweepAngle = i;
            return this;
        }

        public Builder rotationSpeed(float f)
        {
            CircularProgressBarUtils.checkSpeed(f);
            mRotationSpeed = f;
            return this;
        }

        public Builder strokeWidth(float f)
        {
            CircularProgressBarUtils.checkPositiveOrZero(f, "StrokeWidth");
            mStrokeWidth = f;
            return this;
        }

        public Builder style(Style style1)
        {
            CircularProgressBarUtils.checkNotNull(style1, "Style");
            mStyle = style1;
            return this;
        }

        public Builder sweepInterpolator(Interpolator interpolator)
        {
            CircularProgressBarUtils.checkNotNull(interpolator, "Sweep interpolator");
            mSweepInterpolator = interpolator;
            return this;
        }

        public Builder sweepSpeed(float f)
        {
            CircularProgressBarUtils.checkSpeed(f);
            mSweepSpeed = f;
            return this;
        }

        public Builder(Context context)
        {
            this(context, false);
        }

        public Builder(Context context, boolean flag)
        {
            mSweepInterpolator = CircularProgressDrawable.DEFAULT_SWEEP_INTERPOLATOR;
            mAngleInterpolator = CircularProgressDrawable.DEFAULT_ROTATION_INTERPOLATOR;
            initValues(context, flag);
        }
    }

    public static interface OnEndListener
    {

        public abstract void onEnd(CircularProgressDrawable circularprogressdrawable);
    }

    public static final class Style extends Enum
    {

        private static final Style ENUM$VALUES[];
        public static final Style NORMAL;
        public static final Style ROUNDED;

        public static Style valueOf(String s)
        {
            return (Style)Enum.valueOf(fr/castorflex/android/circularprogressbar/CircularProgressDrawable$Style, s);
        }

        public static Style[] values()
        {
            Style astyle[] = ENUM$VALUES;
            int i = astyle.length;
            Style astyle1[] = new Style[i];
            System.arraycopy(astyle, 0, astyle1, 0, i);
            return astyle1;
        }

        static 
        {
            NORMAL = new Style("NORMAL", 0);
            ROUNDED = new Style("ROUNDED", 1);
            ENUM$VALUES = (new Style[] {
                NORMAL, ROUNDED
            });
        }

        private Style(String s, int i)
        {
            super(s, i);
        }
    }


    private static final ArgbEvaluator COLOR_EVALUATOR = new ArgbEvaluator();
    private static final Interpolator DEFAULT_ROTATION_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator DEFAULT_SWEEP_INTERPOLATOR = new DecelerateInterpolator();
    private static final int END_ANIMATOR_DURATION = 200;
    public static final Interpolator END_INTERPOLATOR = new LinearInterpolator();
    private static final int ROTATION_ANIMATOR_DURATION = 2000;
    private static final int SWEEP_ANIMATOR_DURATION = 600;
    private final RectF fBounds;
    private Interpolator mAngleInterpolator;
    private float mBorderWidth;
    private int mColors[];
    private int mCurrentColor;
    private float mCurrentEndRatio;
    private int mCurrentIndexColor;
    private float mCurrentRotationAngle;
    private float mCurrentRotationAngleOffset;
    private float mCurrentSweepAngle;
    private ValueAnimator mEndAnimator;
    private boolean mFirstSweepAnimation;
    private int mMaxSweepAngle;
    private int mMinSweepAngle;
    private boolean mModeAppearing;
    private OnEndListener mOnEndListener;
    private Paint mPaint;
    private ValueAnimator mRotationAnimator;
    private float mRotationSpeed;
    private boolean mRunning;
    private ValueAnimator mSweepAppearingAnimator;
    private ValueAnimator mSweepDisappearingAnimator;
    private Interpolator mSweepInterpolator;
    private float mSweepSpeed;

    private CircularProgressDrawable(int ai[], float f, float f1, float f2, int i, int j, Style style, 
            Interpolator interpolator, Interpolator interpolator1)
    {
        fBounds = new RectF();
        mCurrentRotationAngleOffset = 0.0F;
        mCurrentRotationAngle = 0.0F;
        mCurrentEndRatio = 1.0F;
        mSweepInterpolator = interpolator1;
        mAngleInterpolator = interpolator;
        mBorderWidth = f;
        mCurrentIndexColor = 0;
        mColors = ai;
        mCurrentColor = mColors[0];
        mSweepSpeed = f1;
        mRotationSpeed = f2;
        mMinSweepAngle = i;
        mMaxSweepAngle = j;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        mPaint.setStrokeWidth(f);
        interpolator = mPaint;
        if (style == Style.ROUNDED)
        {
            ai = android.graphics.Paint.Cap.ROUND;
        } else
        {
            ai = android.graphics.Paint.Cap.BUTT;
        }
        interpolator.setStrokeCap(ai);
        mPaint.setColor(mColors[0]);
        setupAnimations();
    }

    CircularProgressDrawable(int ai[], float f, float f1, float f2, int i, int j, Style style, 
            Interpolator interpolator, Interpolator interpolator1, CircularProgressDrawable circularprogressdrawable)
    {
        this(ai, f, f1, f2, i, j, style, interpolator, interpolator1);
    }

    private void reinitValues()
    {
        mFirstSweepAnimation = true;
        mCurrentEndRatio = 1.0F;
        mPaint.setColor(mCurrentColor);
    }

    private void setAppearing()
    {
        mModeAppearing = true;
        mCurrentRotationAngleOffset = mCurrentRotationAngleOffset + (float)mMinSweepAngle;
    }

    private void setDisappearing()
    {
        mModeAppearing = false;
        mCurrentRotationAngleOffset = mCurrentRotationAngleOffset + (float)(360 - mMaxSweepAngle);
    }

    private void setEndRatio(float f)
    {
        mCurrentEndRatio = f;
        invalidateSelf();
    }

    private void setupAnimations()
    {
        mRotationAnimator = ValueAnimator.ofFloat(new float[] {
            0.0F, 360F
        });
        mRotationAnimator.setInterpolator(mAngleInterpolator);
        mRotationAnimator.setDuration((long)(2000F / mRotationSpeed));
        mRotationAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final CircularProgressDrawable this$0;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                float f = CircularProgressBarUtils.getAnimatedFraction(valueanimator);
                setCurrentRotationAngle(f * 360F);
            }

            
            {
                this$0 = CircularProgressDrawable.this;
                super();
            }
        });
        mRotationAnimator.setRepeatCount(-1);
        mRotationAnimator.setRepeatMode(1);
        mSweepAppearingAnimator = ValueAnimator.ofFloat(new float[] {
            (float)mMinSweepAngle, (float)mMaxSweepAngle
        });
        mSweepAppearingAnimator.setInterpolator(mSweepInterpolator);
        mSweepAppearingAnimator.setDuration((long)(600F / mSweepSpeed));
        mSweepAppearingAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final CircularProgressDrawable this$0;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                float f = CircularProgressBarUtils.getAnimatedFraction(valueanimator);
                if (mFirstSweepAnimation)
                {
                    f *= mMaxSweepAngle;
                } else
                {
                    f = (float)mMinSweepAngle + (float)(mMaxSweepAngle - mMinSweepAngle) * f;
                }
                setCurrentSweepAngle(f);
            }

            
            {
                this$0 = CircularProgressDrawable.this;
                super();
            }
        });
        mSweepAppearingAnimator.addListener(new android.animation.Animator.AnimatorListener() {

            boolean cancelled;
            final CircularProgressDrawable this$0;

            public void onAnimationCancel(Animator animator)
            {
                cancelled = true;
            }

            public void onAnimationEnd(Animator animator)
            {
                if (!cancelled)
                {
                    mFirstSweepAnimation = false;
                    setDisappearing();
                    mSweepDisappearingAnimator.start();
                }
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
                cancelled = false;
                mModeAppearing = true;
            }

            
            {
                this$0 = CircularProgressDrawable.this;
                super();
                cancelled = false;
            }
        });
        mSweepDisappearingAnimator = ValueAnimator.ofFloat(new float[] {
            (float)mMaxSweepAngle, (float)mMinSweepAngle
        });
        mSweepDisappearingAnimator.setInterpolator(mSweepInterpolator);
        mSweepDisappearingAnimator.setDuration((long)(600F / mSweepSpeed));
        mSweepDisappearingAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final CircularProgressDrawable this$0;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                float f = CircularProgressBarUtils.getAnimatedFraction(valueanimator);
                setCurrentSweepAngle((float)mMaxSweepAngle - (float)(mMaxSweepAngle - mMinSweepAngle) * f);
                long l = valueanimator.getDuration();
                f = (float)valueanimator.getCurrentPlayTime() / (float)l;
                if (mColors.length > 1 && f > 0.7F)
                {
                    int i = mCurrentColor;
                    int j = mColors[(mCurrentIndexColor + 1) % mColors.length];
                    i = ((Integer)CircularProgressDrawable.COLOR_EVALUATOR.evaluate((f - 0.7F) / 0.3F, Integer.valueOf(i), Integer.valueOf(j))).intValue();
                    mPaint.setColor(i);
                }
            }

            
            {
                this$0 = CircularProgressDrawable.this;
                super();
            }
        });
        mSweepDisappearingAnimator.addListener(new android.animation.Animator.AnimatorListener() {

            boolean cancelled;
            final CircularProgressDrawable this$0;

            public void onAnimationCancel(Animator animator)
            {
                cancelled = true;
            }

            public void onAnimationEnd(Animator animator)
            {
                if (!cancelled)
                {
                    setAppearing();
                    mCurrentIndexColor = (mCurrentIndexColor + 1) % mColors.length;
                    mCurrentColor = mColors[mCurrentIndexColor];
                    mPaint.setColor(mCurrentColor);
                    mSweepAppearingAnimator.start();
                }
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
                cancelled = false;
            }

            
            {
                this$0 = CircularProgressDrawable.this;
                super();
            }
        });
        mEndAnimator = ValueAnimator.ofFloat(new float[] {
            1.0F, 0.0F
        });
        mEndAnimator.setInterpolator(END_INTERPOLATOR);
        mEndAnimator.setDuration(200L);
        mEndAnimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            final CircularProgressDrawable this$0;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                setEndRatio(1.0F - CircularProgressBarUtils.getAnimatedFraction(valueanimator));
            }

            
            {
                this$0 = CircularProgressDrawable.this;
                super();
            }
        });
        mEndAnimator.addListener(new android.animation.Animator.AnimatorListener() {

            private boolean cancelled;
            final CircularProgressDrawable this$0;

            public void onAnimationCancel(Animator animator)
            {
                cancelled = true;
            }

            public void onAnimationEnd(Animator animator)
            {
                setEndRatio(0.0F);
                if (!cancelled)
                {
                    stop();
                }
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
                cancelled = false;
            }

            
            {
                this$0 = CircularProgressDrawable.this;
                super();
            }
        });
    }

    private void stopAnimators()
    {
        mRotationAnimator.cancel();
        mSweepAppearingAnimator.cancel();
        mSweepDisappearingAnimator.cancel();
        mEndAnimator.cancel();
    }

    public void draw(Canvas canvas)
    {
        float f1 = mCurrentRotationAngle - mCurrentRotationAngleOffset;
        float f2 = mCurrentSweepAngle;
        float f = f1;
        if (!mModeAppearing)
        {
            f = f1 + (360F - f2);
        }
        float f3 = f % 360F;
        f1 = f3;
        f = f2;
        if (mCurrentEndRatio < 1.0F)
        {
            f = f2 * mCurrentEndRatio;
            f1 = ((f2 - f) + f3) % 360F;
        }
        canvas.drawArc(fBounds, f1, f, false, mPaint);
    }

    public int getOpacity()
    {
        return -3;
    }

    public boolean isRunning()
    {
        return mRunning;
    }

    protected void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        fBounds.left = (float)rect.left + mBorderWidth / 2.0F + 0.5F;
        fBounds.right = (float)rect.right - mBorderWidth / 2.0F - 0.5F;
        fBounds.top = (float)rect.top + mBorderWidth / 2.0F + 0.5F;
        fBounds.bottom = (float)rect.bottom - mBorderWidth / 2.0F - 0.5F;
    }

    public void progressiveStop()
    {
        progressiveStop(null);
    }

    public void progressiveStop(OnEndListener onendlistener)
    {
        if (!isRunning() || mEndAnimator.isRunning())
        {
            return;
        } else
        {
            mOnEndListener = onendlistener;
            mEndAnimator.addListener(new android.animation.Animator.AnimatorListener() {

                final CircularProgressDrawable this$0;

                public void onAnimationCancel(Animator animator)
                {
                }

                public void onAnimationEnd(Animator animator)
                {
                    mEndAnimator.removeListener(this);
                    if (mOnEndListener != null)
                    {
                        mOnEndListener.onEnd(CircularProgressDrawable.this);
                    }
                }

                public void onAnimationRepeat(Animator animator)
                {
                }

                public void onAnimationStart(Animator animator)
                {
                }

            
            {
                this$0 = CircularProgressDrawable.this;
                super();
            }
            });
            mEndAnimator.start();
            return;
        }
    }

    public void setAlpha(int i)
    {
        mPaint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        mPaint.setColorFilter(colorfilter);
    }

    public void setCurrentRotationAngle(float f)
    {
        mCurrentRotationAngle = f;
        invalidateSelf();
    }

    public void setCurrentSweepAngle(float f)
    {
        mCurrentSweepAngle = f;
        invalidateSelf();
    }

    public void start()
    {
        if (isRunning())
        {
            return;
        } else
        {
            mRunning = true;
            reinitValues();
            mRotationAnimator.start();
            mSweepAppearingAnimator.start();
            invalidateSelf();
            return;
        }
    }

    public void stop()
    {
        if (!isRunning())
        {
            return;
        } else
        {
            mRunning = false;
            stopAnimators();
            invalidateSelf();
            return;
        }
    }






















}
