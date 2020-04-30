// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.circularprogressbar;

import android.animation.ValueAnimator;

// Referenced classes of package fr.castorflex.android.circularprogressbar:
//            CircularProgressDrawable, CircularProgressBarUtils

class this._cls0
    implements android.animation.eListener
{

    final CircularProgressDrawable this$0;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = CircularProgressBarUtils.getAnimatedFraction(valueanimator);
        if (CircularProgressDrawable.access$3(CircularProgressDrawable.this))
        {
            f *= CircularProgressDrawable.access$4(CircularProgressDrawable.this);
        } else
        {
            f = (float)CircularProgressDrawable.access$5(CircularProgressDrawable.this) + (float)(CircularProgressDrawable.access$4(CircularProgressDrawable.this) - CircularProgressDrawable.access$5(CircularProgressDrawable.this)) * f;
        }
        setCurrentSweepAngle(f);
    }

    ()
    {
        this$0 = CircularProgressDrawable.this;
        super();
    }
}
