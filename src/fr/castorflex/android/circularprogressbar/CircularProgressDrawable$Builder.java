// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.circularprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.view.animation.Interpolator;

// Referenced classes of package fr.castorflex.android.circularprogressbar:
//            CircularProgressDrawable, CircularProgressBarUtils

public static class initValues
{

    private Interpolator mAngleInterpolator;
    private int mColors[];
    private int mMaxSweepAngle;
    private int mMinSweepAngle;
    private float mRotationSpeed;
    private float mStrokeWidth;
    private mSweepSpeed mStyle;
    private Interpolator mSweepInterpolator;
    private float mSweepSpeed;

    private void initValues(Context context, boolean flag)
    {
        mStrokeWidth = context.getResources().getDimension(mStrokeWidth);
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
                context.getResources().getColor(mColors)
            });
            mMinSweepAngle = context.getResources().getInteger(ngle);
            mMaxSweepAngle = context.getResources().getInteger(ngle);
        }
        mStyle = UNDED;
    }

    public UNDED angleInterpolator(Interpolator interpolator)
    {
        CircularProgressBarUtils.checkNotNull(interpolator, "Angle interpolator");
        mAngleInterpolator = interpolator;
        return this;
    }

    public CircularProgressDrawable build()
    {
        return new CircularProgressDrawable(mColors, mStrokeWidth, mSweepSpeed, mRotationSpeed, mMinSweepAngle, mMaxSweepAngle, mStyle, mAngleInterpolator, mSweepInterpolator, null);
    }

    public mSweepInterpolator color(int i)
    {
        mColors = (new int[] {
            i
        });
        return this;
    }

    public mColors colors(int ai[])
    {
        CircularProgressBarUtils.checkColors(ai);
        mColors = ai;
        return this;
    }

    public mColors maxSweepAngle(int i)
    {
        CircularProgressBarUtils.checkAngle(i);
        mMaxSweepAngle = i;
        return this;
    }

    public mMaxSweepAngle minSweepAngle(int i)
    {
        CircularProgressBarUtils.checkAngle(i);
        mMinSweepAngle = i;
        return this;
    }

    public mMinSweepAngle rotationSpeed(float f)
    {
        CircularProgressBarUtils.checkSpeed(f);
        mRotationSpeed = f;
        return this;
    }

    public mRotationSpeed strokeWidth(float f)
    {
        CircularProgressBarUtils.checkPositiveOrZero(f, "StrokeWidth");
        mStrokeWidth = f;
        return this;
    }

    public mStrokeWidth style(mStrokeWidth mstrokewidth)
    {
        CircularProgressBarUtils.checkNotNull(mstrokewidth, "Style");
        mStyle = mstrokewidth;
        return this;
    }

    public mStyle sweepInterpolator(Interpolator interpolator)
    {
        CircularProgressBarUtils.checkNotNull(interpolator, "Sweep interpolator");
        mSweepInterpolator = interpolator;
        return this;
    }

    public mSweepInterpolator sweepSpeed(float f)
    {
        CircularProgressBarUtils.checkSpeed(f);
        mSweepSpeed = f;
        return this;
    }

    public (Context context)
    {
        this(context, false);
    }

    public <init>(Context context, boolean flag)
    {
        mSweepInterpolator = CircularProgressDrawable.access$0();
        mAngleInterpolator = CircularProgressDrawable.access$1();
        initValues(context, flag);
    }
}
