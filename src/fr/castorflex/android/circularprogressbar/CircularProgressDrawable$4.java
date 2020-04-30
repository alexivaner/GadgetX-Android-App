// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.circularprogressbar;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Paint;

// Referenced classes of package fr.castorflex.android.circularprogressbar:
//            CircularProgressDrawable, CircularProgressBarUtils

class this._cls0
    implements android.animation.eListener
{

    final CircularProgressDrawable this$0;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = CircularProgressBarUtils.getAnimatedFraction(valueanimator);
        setCurrentSweepAngle((float)CircularProgressDrawable.access$4(CircularProgressDrawable.this) - (float)(CircularProgressDrawable.access$4(CircularProgressDrawable.this) - CircularProgressDrawable.access$5(CircularProgressDrawable.this)) * f);
        long l = valueanimator.getDuration();
        f = (float)valueanimator.getCurrentPlayTime() / (float)l;
        if (CircularProgressDrawable.access$10(CircularProgressDrawable.this).length > 1 && f > 0.7F)
        {
            int i = CircularProgressDrawable.access$11(CircularProgressDrawable.this);
            int j = CircularProgressDrawable.access$10(CircularProgressDrawable.this)[(CircularProgressDrawable.access$12(CircularProgressDrawable.this) + 1) % CircularProgressDrawable.access$10(CircularProgressDrawable.this).length];
            i = ((Integer)CircularProgressDrawable.access$13().evaluate((f - 0.7F) / 0.3F, Integer.valueOf(i), Integer.valueOf(j))).intValue();
            CircularProgressDrawable.access$14(CircularProgressDrawable.this).setColor(i);
        }
    }

    ()
    {
        this$0 = CircularProgressDrawable.this;
        super();
    }
}
