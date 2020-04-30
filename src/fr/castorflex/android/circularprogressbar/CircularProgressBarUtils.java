// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.circularprogressbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

class CircularProgressBarUtils
{

    private CircularProgressBarUtils()
    {
    }

    static void checkAngle(int i)
    {
        if (i < 0 || i > 360)
        {
            throw new IllegalArgumentException(String.format("Illegal angle %d: must be >=0 and <= 360", new Object[] {
                Integer.valueOf(i)
            }));
        } else
        {
            return;
        }
    }

    static void checkColors(int ai[])
    {
        if (ai == null || ai.length == 0)
        {
            throw new IllegalArgumentException("You must provide at least 1 color");
        } else
        {
            return;
        }
    }

    static void checkNotNull(Object obj, String s)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException(String.format("%s must be not null", new Object[] {
                s
            }));
        } else
        {
            return;
        }
    }

    static void checkPositive(int i, String s)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException(String.format("%s must not be null", new Object[] {
                s
            }));
        } else
        {
            return;
        }
    }

    static void checkPositiveOrZero(float f, String s)
    {
        if (f < 0.0F)
        {
            throw new IllegalArgumentException(String.format("%s %d must be positive", new Object[] {
                s, Float.valueOf(f)
            }));
        } else
        {
            return;
        }
    }

    static void checkSpeed(float f)
    {
        if (f <= 0.0F)
        {
            throw new IllegalArgumentException("Speed must be >= 0");
        } else
        {
            return;
        }
    }

    static float getAnimatedFraction(ValueAnimator valueanimator)
    {
        float f;
        if (valueanimator.getDuration() > 0L)
        {
            f = (float)valueanimator.getCurrentPlayTime() / (float)valueanimator.getDuration();
        } else
        {
            f = 0.0F;
        }
        f = Math.min(f, 1.0F);
        return valueanimator.getInterpolator().getInterpolation(f);
    }
}
