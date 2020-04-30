// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

// Referenced classes of package fr.castorflex.android.smoothprogressbar:
//            SmoothProgressDrawable, SmoothProgressBarUtils

public static class initValues
{

    private Drawable mBackgroundDrawableWhenHidden;
    private int mColors[];
    private boolean mGenerateBackgroundUsingColors;
    private boolean mGradients;
    private Interpolator mInterpolator;
    private boolean mMirrorMode;
    private s mOnProgressiveStopEndedListener;
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
            mSectionsCount = context.getInteger(count);
            mSpeed = Float.parseFloat(context.getString(mSpeed));
            mReversed = context.getBoolean(mReversed);
            mProgressiveStartActivated = context.getBoolean(tart_activated);
            mColors = (new int[] {
                context.getColor(mColors)
            });
            mStrokeSeparatorLength = context.getDimensionPixelSize(rator_length);
            mStrokeWidth = context.getDimensionPixelOffset(h);
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

    public mGradients backgroundDrawable(Drawable drawable)
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

    public s callbacks(s s)
    {
        mOnProgressiveStopEndedListener = s;
        return this;
    }

    public mOnProgressiveStopEndedListener color(int i)
    {
        mColors = (new int[] {
            i
        });
        return this;
    }

    public mColors colors(int ai[])
    {
        SmoothProgressBarUtils.checkColors(ai);
        mColors = ai;
        return this;
    }

    public mColors generateBackgroundUsingColors()
    {
        mGenerateBackgroundUsingColors = true;
        return this;
    }

    public mGenerateBackgroundUsingColors gradients()
    {
        return gradients(true);
    }

    public gradients gradients(boolean flag)
    {
        mGradients = flag;
        return this;
    }

    public mGradients interpolator(Interpolator interpolator1)
    {
        SmoothProgressBarUtils.checkNotNull(interpolator1, "Interpolator");
        mInterpolator = interpolator1;
        return this;
    }

    public mInterpolator mirrorMode(boolean flag)
    {
        mMirrorMode = flag;
        return this;
    }

    public mMirrorMode progressiveStart(boolean flag)
    {
        mProgressiveStartActivated = flag;
        return this;
    }

    public mProgressiveStartActivated progressiveStartSpeed(float f)
    {
        SmoothProgressBarUtils.checkSpeed(f);
        mProgressiveStartSpeed = f;
        return this;
    }

    public mProgressiveStartSpeed progressiveStopSpeed(float f)
    {
        SmoothProgressBarUtils.checkSpeed(f);
        mProgressiveStopSpeed = f;
        return this;
    }

    public mProgressiveStopSpeed reversed(boolean flag)
    {
        mReversed = flag;
        return this;
    }

    public mReversed sectionsCount(int i)
    {
        SmoothProgressBarUtils.checkPositive(i, "Sections count");
        mSectionsCount = i;
        return this;
    }

    public mSectionsCount separatorLength(int i)
    {
        SmoothProgressBarUtils.checkPositiveOrZero(i, "Separator length");
        mStrokeSeparatorLength = i;
        return this;
    }

    public mStrokeSeparatorLength speed(float f)
    {
        SmoothProgressBarUtils.checkSpeed(f);
        mSpeed = f;
        return this;
    }

    public mSpeed strokeWidth(float f)
    {
        SmoothProgressBarUtils.checkPositiveOrZero(f, "Width");
        mStrokeWidth = f;
        return this;
    }

    public s(Context context)
    {
        this(context, false);
    }

    public <init>(Context context, boolean flag)
    {
        initValues(context, flag);
    }
}
