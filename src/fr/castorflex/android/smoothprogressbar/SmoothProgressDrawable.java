// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

// Referenced classes of package fr.castorflex.android.smoothprogressbar:
//            SmoothProgressBarUtils

public class SmoothProgressDrawable extends Drawable
    implements Animatable
{
    public static class Builder
    {

        private Drawable mBackgroundDrawableWhenHidden;
        private int mColors[];
        private boolean mGenerateBackgroundUsingColors;
        private boolean mGradients;
        private Interpolator mInterpolator;
        private boolean mMirrorMode;
        private Callbacks mOnProgressiveStopEndedListener;
        private boolean mProgressiveStartActivated;
        private float mProgressiveStartSpeed;
        private float mProgressiveStopSpeed;
        private boolean mReversed;
        private int mSectionsCount;
        private float mSpeed;
        private int mStrokeSeparatorLength;
        private float mStrokeWidth;

        private void initValues(Context context, boolean flag)
        {
            context = context.getResources();
            mInterpolator = new AccelerateInterpolator();
            if (!flag)
            {
                mSectionsCount = context.getInteger(R.integer.spb_default_sections_count);
                mSpeed = Float.parseFloat(context.getString(R.string.spb_default_speed));
                mReversed = context.getBoolean(R.bool.spb_default_reversed);
                mProgressiveStartActivated = context.getBoolean(R.bool.spb_default_progressiveStart_activated);
                mColors = (new int[] {
                    context.getColor(R.color.spb_default_color)
                });
                mStrokeSeparatorLength = context.getDimensionPixelSize(R.dimen.spb_default_stroke_separator_length);
                mStrokeWidth = context.getDimensionPixelOffset(R.dimen.spb_default_stroke_width);
            } else
            {
                mSectionsCount = 4;
                mSpeed = 1.0F;
                mReversed = false;
                mProgressiveStartActivated = false;
                mColors = (new int[] {
                    0xff33b5e5
                });
                mStrokeSeparatorLength = 4;
                mStrokeWidth = 4F;
            }
            mProgressiveStartSpeed = mSpeed;
            mProgressiveStopSpeed = mSpeed;
            mGradients = false;
        }

        public Builder backgroundDrawable(Drawable drawable)
        {
            mBackgroundDrawableWhenHidden = drawable;
            return this;
        }

        public SmoothProgressDrawable build()
        {
            if (mGenerateBackgroundUsingColors)
            {
                mBackgroundDrawableWhenHidden = SmoothProgressBarUtils.generateDrawableWithColors(mColors, mStrokeWidth);
            }
            return new SmoothProgressDrawable(mInterpolator, mSectionsCount, mStrokeSeparatorLength, mColors, mStrokeWidth, mSpeed, mProgressiveStartSpeed, mProgressiveStopSpeed, mReversed, mMirrorMode, mOnProgressiveStopEndedListener, mProgressiveStartActivated, mBackgroundDrawableWhenHidden, mGradients, null);
        }

        public Builder callbacks(Callbacks callbacks1)
        {
            mOnProgressiveStopEndedListener = callbacks1;
            return this;
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
            SmoothProgressBarUtils.checkColors(ai);
            mColors = ai;
            return this;
        }

        public Builder generateBackgroundUsingColors()
        {
            mGenerateBackgroundUsingColors = true;
            return this;
        }

        public Builder gradients()
        {
            return gradients(true);
        }

        public Builder gradients(boolean flag)
        {
            mGradients = flag;
            return this;
        }

        public Builder interpolator(Interpolator interpolator1)
        {
            SmoothProgressBarUtils.checkNotNull(interpolator1, "Interpolator");
            mInterpolator = interpolator1;
            return this;
        }

        public Builder mirrorMode(boolean flag)
        {
            mMirrorMode = flag;
            return this;
        }

        public Builder progressiveStart(boolean flag)
        {
            mProgressiveStartActivated = flag;
            return this;
        }

        public Builder progressiveStartSpeed(float f)
        {
            SmoothProgressBarUtils.checkSpeed(f);
            mProgressiveStartSpeed = f;
            return this;
        }

        public Builder progressiveStopSpeed(float f)
        {
            SmoothProgressBarUtils.checkSpeed(f);
            mProgressiveStopSpeed = f;
            return this;
        }

        public Builder reversed(boolean flag)
        {
            mReversed = flag;
            return this;
        }

        public Builder sectionsCount(int i)
        {
            SmoothProgressBarUtils.checkPositive(i, "Sections count");
            mSectionsCount = i;
            return this;
        }

        public Builder separatorLength(int i)
        {
            SmoothProgressBarUtils.checkPositiveOrZero(i, "Separator length");
            mStrokeSeparatorLength = i;
            return this;
        }

        public Builder speed(float f)
        {
            SmoothProgressBarUtils.checkSpeed(f);
            mSpeed = f;
            return this;
        }

        public Builder strokeWidth(float f)
        {
            SmoothProgressBarUtils.checkPositiveOrZero(f, "Width");
            mStrokeWidth = f;
            return this;
        }

        public Builder(Context context)
        {
            this(context, false);
        }

        public Builder(Context context, boolean flag)
        {
            initValues(context, flag);
        }
    }

    public static interface Callbacks
    {

        public abstract void onStart();

        public abstract void onStop();
    }


    private static final long FRAME_DURATION = 16L;
    private static final float OFFSET_PER_FRAME = 0.01F;
    private final Rect fBackgroundRect;
    private Drawable mBackgroundDrawable;
    private Rect mBounds;
    private Callbacks mCallbacks;
    private int mColors[];
    private int mColorsIndex;
    private float mCurrentOffset;
    private int mCurrentSections;
    private boolean mFinishing;
    private float mFinishingOffset;
    private Interpolator mInterpolator;
    private int mLinearGradientColors[];
    private float mLinearGradientPositions[];
    private float mMaxOffset;
    private boolean mMirrorMode;
    private boolean mNewTurn;
    private Paint mPaint;
    private boolean mProgressiveStartActivated;
    private float mProgressiveStartSpeed;
    private float mProgressiveStopSpeed;
    private boolean mReversed;
    private boolean mRunning;
    private int mSectionsCount;
    private int mSeparatorLength;
    private float mSpeed;
    private int mStartSection;
    private float mStrokeWidth;
    private final Runnable mUpdater;
    private boolean mUseGradients;

    private SmoothProgressDrawable(Interpolator interpolator, int i, int j, int ai[], float f, float f1, float f2, 
            float f3, boolean flag, boolean flag1, Callbacks callbacks, boolean flag2, Drawable drawable, boolean flag3)
    {
        fBackgroundRect = new Rect();
        mUpdater = new Runnable() {

            final SmoothProgressDrawable this$0;

            public void run()
            {
                if (isFinishing())
                {
                    SmoothProgressDrawable smoothprogressdrawable = SmoothProgressDrawable.this;
                    smoothprogressdrawable.mFinishingOffset = smoothprogressdrawable.mFinishingOffset + mProgressiveStopSpeed * 0.01F;
                    smoothprogressdrawable = SmoothProgressDrawable.this;
                    smoothprogressdrawable.mCurrentOffset = smoothprogressdrawable.mCurrentOffset + mProgressiveStopSpeed * 0.01F;
                    if (mFinishingOffset >= 1.0F)
                    {
                        stop();
                    }
                } else
                if (isStarting())
                {
                    SmoothProgressDrawable smoothprogressdrawable2 = SmoothProgressDrawable.this;
                    smoothprogressdrawable2.mCurrentOffset = smoothprogressdrawable2.mCurrentOffset + mProgressiveStartSpeed * 0.01F;
                } else
                {
                    SmoothProgressDrawable smoothprogressdrawable3 = SmoothProgressDrawable.this;
                    smoothprogressdrawable3.mCurrentOffset = smoothprogressdrawable3.mCurrentOffset + mSpeed * 0.01F;
                }
                if (mCurrentOffset >= mMaxOffset)
                {
                    mNewTurn = true;
                    SmoothProgressDrawable smoothprogressdrawable1 = SmoothProgressDrawable.this;
                    smoothprogressdrawable1.mCurrentOffset = smoothprogressdrawable1.mCurrentOffset - mMaxOffset;
                }
                if (isRunning())
                {
                    scheduleSelf(mUpdater, SystemClock.uptimeMillis() + 16L);
                }
                invalidateSelf();
            }

            
            {
                this$0 = SmoothProgressDrawable.this;
                super();
            }
        };
        mRunning = false;
        mInterpolator = interpolator;
        mSectionsCount = i;
        mStartSection = 0;
        mCurrentSections = mSectionsCount;
        mSeparatorLength = j;
        mSpeed = f1;
        mProgressiveStartSpeed = f2;
        mProgressiveStopSpeed = f3;
        mReversed = flag;
        mColors = ai;
        mColorsIndex = 0;
        mMirrorMode = flag1;
        mFinishing = false;
        mBackgroundDrawable = drawable;
        mStrokeWidth = f;
        mMaxOffset = 1.0F / (float)mSectionsCount;
        mPaint = new Paint();
        mPaint.setStrokeWidth(f);
        mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        mPaint.setDither(false);
        mPaint.setAntiAlias(false);
        mProgressiveStartActivated = flag2;
        mCallbacks = callbacks;
        mUseGradients = flag3;
        refreshLinearGradientOptions();
    }

    SmoothProgressDrawable(Interpolator interpolator, int i, int j, int ai[], float f, float f1, float f2, 
            float f3, boolean flag, boolean flag1, Callbacks callbacks, boolean flag2, Drawable drawable, boolean flag3, 
            SmoothProgressDrawable smoothprogressdrawable)
    {
        this(interpolator, i, j, ai, f, f1, f2, f3, flag, flag1, callbacks, flag2, drawable, flag3);
    }

    private void checkColorIndex(int i)
    {
        if (i < 0 || i >= mColors.length)
        {
            throw new IllegalArgumentException(String.format("Index %d not valid", new Object[] {
                Integer.valueOf(i)
            }));
        } else
        {
            return;
        }
    }

    private int decrementColor(int i)
    {
        int j = i - 1;
        i = j;
        if (j < 0)
        {
            i = mColors.length - 1;
        }
        return i;
    }

    private void drawBackground(Canvas canvas, float f, float f1)
    {
        int i = canvas.save();
        canvas.clipRect(f, (int)(((float)canvas.getHeight() - mStrokeWidth) / 2.0F), f1, (int)(((float)canvas.getHeight() + mStrokeWidth) / 2.0F));
        mBackgroundDrawable.draw(canvas);
        canvas.restoreToCount(i);
    }

    private void drawBackgroundIfNeeded(Canvas canvas, float f, float f1)
    {
        if (mBackgroundDrawable != null)
        {
            fBackgroundRect.top = (int)(((float)canvas.getHeight() - mStrokeWidth) / 2.0F);
            fBackgroundRect.bottom = (int)(((float)canvas.getHeight() + mStrokeWidth) / 2.0F);
            fBackgroundRect.left = 0;
            Rect rect = fBackgroundRect;
            int i;
            if (mMirrorMode)
            {
                i = canvas.getWidth() / 2;
            } else
            {
                i = canvas.getWidth();
            }
            rect.right = i;
            mBackgroundDrawable.setBounds(fBackgroundRect);
            if (!isRunning())
            {
                if (mMirrorMode)
                {
                    canvas.save();
                    canvas.translate(canvas.getWidth() / 2, 0.0F);
                    drawBackground(canvas, 0.0F, fBackgroundRect.width());
                    canvas.scale(-1F, 1.0F);
                    drawBackground(canvas, 0.0F, fBackgroundRect.width());
                    canvas.restore();
                    return;
                } else
                {
                    drawBackground(canvas, 0.0F, fBackgroundRect.width());
                    return;
                }
            }
            if (isFinishing() || isStarting())
            {
                float f3 = f;
                float f2 = f1;
                if (f > f1)
                {
                    f2 = f;
                    f3 = f1;
                }
                if (f3 > 0.0F)
                {
                    if (mMirrorMode)
                    {
                        canvas.save();
                        canvas.translate(canvas.getWidth() / 2, 0.0F);
                        if (mReversed)
                        {
                            drawBackground(canvas, 0.0F, f3);
                            canvas.scale(-1F, 1.0F);
                            drawBackground(canvas, 0.0F, f3);
                        } else
                        {
                            drawBackground(canvas, (float)(canvas.getWidth() / 2) - f3, canvas.getWidth() / 2);
                            canvas.scale(-1F, 1.0F);
                            drawBackground(canvas, (float)(canvas.getWidth() / 2) - f3, canvas.getWidth() / 2);
                        }
                        canvas.restore();
                    } else
                    {
                        drawBackground(canvas, 0.0F, f3);
                    }
                }
                if (f2 <= (float)canvas.getWidth())
                {
                    if (mMirrorMode)
                    {
                        canvas.save();
                        canvas.translate(canvas.getWidth() / 2, 0.0F);
                        if (mReversed)
                        {
                            drawBackground(canvas, f2, canvas.getWidth() / 2);
                            canvas.scale(-1F, 1.0F);
                            drawBackground(canvas, f2, canvas.getWidth() / 2);
                        } else
                        {
                            drawBackground(canvas, 0.0F, (float)(canvas.getWidth() / 2) - f2);
                            canvas.scale(-1F, 1.0F);
                            drawBackground(canvas, 0.0F, (float)(canvas.getWidth() / 2) - f2);
                        }
                        canvas.restore();
                        return;
                    } else
                    {
                        drawBackground(canvas, f2, canvas.getWidth());
                        return;
                    }
                }
            }
        }
    }

    private void drawGradient(Canvas canvas)
    {
        float f = 1.0F / (float)mSectionsCount;
        int j = mColorsIndex;
        mLinearGradientPositions[0] = 0.0F;
        mLinearGradientPositions[mLinearGradientPositions.length - 1] = 1.0F;
        int k = j - 1;
        int i = k;
        if (k < 0)
        {
            i = k + mColors.length;
        }
        mLinearGradientColors[0] = mColors[i];
        i = 0;
        do
        {
            if (i >= mSectionsCount)
            {
                mLinearGradientColors[mLinearGradientColors.length - 1] = mColors[j];
                float f1;
                float f2;
                float f3;
                float f4;
                float f5;
                int ai[];
                float af[];
                if (mReversed)
                {
                    if (mMirrorMode)
                    {
                        i = Math.abs(mBounds.left - mBounds.right) / 2;
                    } else
                    {
                        i = mBounds.left;
                    }
                } else
                {
                    i = mBounds.left;
                }
                f = i;
                if (mMirrorMode)
                {
                    if (mReversed)
                    {
                        i = mBounds.left;
                    } else
                    {
                        i = Math.abs(mBounds.left - mBounds.right) / 2;
                    }
                } else
                {
                    i = mBounds.right;
                }
                f1 = i;
                f2 = mBounds.centerY();
                f3 = mStrokeWidth / 2.0F;
                f4 = mBounds.centerY();
                f5 = mStrokeWidth / 2.0F;
                ai = mLinearGradientColors;
                af = mLinearGradientPositions;
                if (mMirrorMode)
                {
                    canvas = android.graphics.Shader.TileMode.MIRROR;
                } else
                {
                    canvas = android.graphics.Shader.TileMode.CLAMP;
                }
                canvas = new LinearGradient(f, f2 - f3, f1, f4 + f5, ai, af, canvas);
                mPaint.setShader(canvas);
                return;
            }
            f1 = mInterpolator.getInterpolation((float)i * f + mCurrentOffset);
            mLinearGradientPositions[i + 1] = f1;
            mLinearGradientColors[i + 1] = mColors[j];
            j = (j + 1) % mColors.length;
            i++;
        } while (true);
    }

    private void drawLine(Canvas canvas, int i, float f, float f1, float f2, float f3, int j)
    {
        mPaint.setColor(mColors[j]);
        if (!mMirrorMode)
        {
            canvas.drawLine(f, f1, f2, f3, mPaint);
            return;
        }
        if (mReversed)
        {
            canvas.drawLine((float)i + f, f1, (float)i + f2, f3, mPaint);
            canvas.drawLine((float)i - f, f1, (float)i - f2, f3, mPaint);
            return;
        } else
        {
            canvas.drawLine(f, f1, f2, f3, mPaint);
            canvas.drawLine((float)(i * 2) - f, f1, (float)(i * 2) - f2, f3, mPaint);
            return;
        }
    }

    private void drawStrokes(Canvas canvas)
    {
        if (mReversed)
        {
            canvas.translate(mBounds.width(), 0.0F);
            canvas.scale(-1F, 1.0F);
        }
        float f1 = 0.0F;
        int j = mBounds.width();
        int i = j;
        if (mMirrorMode)
        {
            i = j / 2;
        }
        int l = mSeparatorLength + i + mSectionsCount;
        int i1 = mBounds.centerY();
        float f6 = 1.0F / (float)mSectionsCount;
        float f3 = 0.0F;
        float f2 = 0.0F;
        int k = mColorsIndex;
        float f = f3;
        if (mStartSection == mCurrentSections)
        {
            f = f3;
            if (mCurrentSections == mSectionsCount)
            {
                f = canvas.getWidth();
            }
        }
        j = 0;
        do
        {
            if (j > mCurrentSections)
            {
                drawBackgroundIfNeeded(canvas, f, f2);
                return;
            }
            float f5 = (float)j * f6 + mCurrentOffset;
            float f4 = Math.max(0.0F, f5 - f6);
            f5 = Math.abs(mInterpolator.getInterpolation(f4) - mInterpolator.getInterpolation(Math.min(f5, 1.0F)));
            float f7 = (int)((float)l * f5);
            float f8;
            if (f7 + f4 < (float)l)
            {
                f4 = Math.min(f7, mSeparatorLength);
            } else
            {
                f4 = 0.0F;
            }
            if (f7 > f4)
            {
                f5 = f7 - f4;
            } else
            {
                f5 = 0.0F;
            }
            f8 = f1 + f5;
            f5 = f;
            if (f8 > f1)
            {
                f5 = f;
                if (j >= mStartSection)
                {
                    f5 = mInterpolator.getInterpolation(Math.min(mFinishingOffset, 1.0F));
                    float f9 = Math.max((float)l * f5, Math.min(i, f1));
                    f5 = Math.min(i, f8);
                    drawLine(canvas, i, f9, i1, f5, i1, k);
                    f5 = f;
                    if (j == mStartSection)
                    {
                        f5 = f9 - (float)mSeparatorLength;
                    }
                }
            }
            if (j == mCurrentSections)
            {
                f2 = f1 + f7;
            }
            f1 = f8 + f4;
            k = incrementColor(k);
            j++;
            f = f5;
        } while (true);
    }

    private int incrementColor(int i)
    {
        int j = i + 1;
        i = j;
        if (j >= mColors.length)
        {
            i = 0;
        }
        return i;
    }

    private void resetProgressiveStart(int i)
    {
        checkColorIndex(i);
        mCurrentOffset = 0.0F;
        mFinishing = false;
        mFinishingOffset = 0.0F;
        mStartSection = 0;
        mCurrentSections = 0;
        mColorsIndex = i;
    }

    public void draw(Canvas canvas)
    {
        mBounds = getBounds();
        canvas.clipRect(mBounds);
        if (mNewTurn)
        {
            mColorsIndex = decrementColor(mColorsIndex);
            mNewTurn = false;
            if (isFinishing())
            {
                mStartSection = mStartSection + 1;
                if (mStartSection > mSectionsCount)
                {
                    stop();
                    return;
                }
            }
            if (mCurrentSections < mSectionsCount)
            {
                mCurrentSections = mCurrentSections + 1;
            }
        }
        if (mUseGradients)
        {
            drawGradient(canvas);
        }
        drawStrokes(canvas);
    }

    public Drawable getBackgroundDrawable()
    {
        return mBackgroundDrawable;
    }

    public int[] getColors()
    {
        return mColors;
    }

    public int getOpacity()
    {
        return -2;
    }

    public float getStrokeWidth()
    {
        return mStrokeWidth;
    }

    public boolean isFinishing()
    {
        return mFinishing;
    }

    public boolean isRunning()
    {
        return mRunning;
    }

    public boolean isStarting()
    {
        return mCurrentSections < mSectionsCount;
    }

    public void progressiveStart()
    {
        progressiveStart(0);
    }

    public void progressiveStart(int i)
    {
        resetProgressiveStart(i);
        start();
    }

    public void progressiveStop()
    {
        mFinishing = true;
        mStartSection = 0;
    }

    protected void refreshLinearGradientOptions()
    {
        if (mUseGradients)
        {
            mLinearGradientColors = new int[mSectionsCount + 2];
            mLinearGradientPositions = new float[mSectionsCount + 2];
            return;
        } else
        {
            mPaint.setShader(null);
            mLinearGradientColors = null;
            mLinearGradientPositions = null;
            return;
        }
    }

    public void scheduleSelf(Runnable runnable, long l)
    {
        mRunning = true;
        super.scheduleSelf(runnable, l);
    }

    public void setAlpha(int i)
    {
        mPaint.setAlpha(i);
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        if (mBackgroundDrawable == drawable)
        {
            return;
        } else
        {
            mBackgroundDrawable = drawable;
            invalidateSelf();
            return;
        }
    }

    public void setCallbacks(Callbacks callbacks)
    {
        mCallbacks = callbacks;
    }

    public void setColor(int i)
    {
        setColors(new int[] {
            i
        });
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        mPaint.setColorFilter(colorfilter);
    }

    public void setColors(int ai[])
    {
        if (ai == null || ai.length == 0)
        {
            throw new IllegalArgumentException("Colors cannot be null or empty");
        } else
        {
            mColorsIndex = 0;
            mColors = ai;
            refreshLinearGradientOptions();
            invalidateSelf();
            return;
        }
    }

    public void setInterpolator(Interpolator interpolator)
    {
        if (interpolator == null)
        {
            throw new IllegalArgumentException("Interpolator cannot be null");
        } else
        {
            mInterpolator = interpolator;
            invalidateSelf();
            return;
        }
    }

    public void setMirrorMode(boolean flag)
    {
        if (mMirrorMode == flag)
        {
            return;
        } else
        {
            mMirrorMode = flag;
            invalidateSelf();
            return;
        }
    }

    public void setProgressiveStartActivated(boolean flag)
    {
        mProgressiveStartActivated = flag;
    }

    public void setProgressiveStartSpeed(float f)
    {
        if (f < 0.0F)
        {
            throw new IllegalArgumentException("SpeedProgressiveStart must be >= 0");
        } else
        {
            mProgressiveStartSpeed = f;
            invalidateSelf();
            return;
        }
    }

    public void setProgressiveStopSpeed(float f)
    {
        if (f < 0.0F)
        {
            throw new IllegalArgumentException("SpeedProgressiveStop must be >= 0");
        } else
        {
            mProgressiveStopSpeed = f;
            invalidateSelf();
            return;
        }
    }

    public void setReversed(boolean flag)
    {
        if (mReversed == flag)
        {
            return;
        } else
        {
            mReversed = flag;
            invalidateSelf();
            return;
        }
    }

    public void setSectionsCount(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("SectionsCount must be > 0");
        } else
        {
            mSectionsCount = i;
            mMaxOffset = 1.0F / (float)mSectionsCount;
            mCurrentOffset = mCurrentOffset % mMaxOffset;
            refreshLinearGradientOptions();
            invalidateSelf();
            return;
        }
    }

    public void setSeparatorLength(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("SeparatorLength must be >= 0");
        } else
        {
            mSeparatorLength = i;
            invalidateSelf();
            return;
        }
    }

    public void setSpeed(float f)
    {
        if (f < 0.0F)
        {
            throw new IllegalArgumentException("Speed must be >= 0");
        } else
        {
            mSpeed = f;
            invalidateSelf();
            return;
        }
    }

    public void setStrokeWidth(float f)
    {
        if (f < 0.0F)
        {
            throw new IllegalArgumentException("The strokeWidth must be >= 0");
        } else
        {
            mPaint.setStrokeWidth(f);
            invalidateSelf();
            return;
        }
    }

    public void setUseGradients(boolean flag)
    {
        if (mUseGradients == flag)
        {
            return;
        } else
        {
            mUseGradients = flag;
            refreshLinearGradientOptions();
            invalidateSelf();
            return;
        }
    }

    public void start()
    {
        if (mProgressiveStartActivated)
        {
            resetProgressiveStart(0);
        }
        if (isRunning())
        {
            return;
        }
        if (mCallbacks != null)
        {
            mCallbacks.onStart();
        }
        scheduleSelf(mUpdater, SystemClock.uptimeMillis() + 16L);
        invalidateSelf();
    }

    public void stop()
    {
        if (!isRunning())
        {
            return;
        }
        if (mCallbacks != null)
        {
            mCallbacks.onStop();
        }
        mRunning = false;
        unscheduleSelf(mUpdater);
    }










}
