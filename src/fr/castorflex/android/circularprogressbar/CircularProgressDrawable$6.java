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
        CircularProgressDrawable.access$19(CircularProgressDrawable.this, 1.0F - CircularProgressBarUtils.getAnimatedFraction(valueanimator));
    }

    ()
    {
        this$0 = CircularProgressDrawable.this;
        super();
    }
}
