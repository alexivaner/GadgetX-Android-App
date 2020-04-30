// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.circularprogressbar;

import android.animation.Animator;
import android.animation.ValueAnimator;

// Referenced classes of package fr.castorflex.android.circularprogressbar:
//            CircularProgressDrawable

class this._cls0
    implements android.animation.cularProgressDrawable._cls8
{

    final CircularProgressDrawable this$0;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        CircularProgressDrawable.access$20(CircularProgressDrawable.this).removeListener(this);
        if (CircularProgressDrawable.access$21(CircularProgressDrawable.this) != null)
        {
            CircularProgressDrawable.access$21(CircularProgressDrawable.this).onEnd(CircularProgressDrawable.this);
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    EndListener()
    {
        this$0 = CircularProgressDrawable.this;
        super();
    }
}
