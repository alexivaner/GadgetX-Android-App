// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.circularprogressbar;

import android.animation.Animator;
import android.animation.ValueAnimator;

// Referenced classes of package fr.castorflex.android.circularprogressbar:
//            CircularProgressDrawable

class cancelled
    implements android.animation.cularProgressDrawable._cls3
{

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
            CircularProgressDrawable.access$7(CircularProgressDrawable.this, false);
            CircularProgressDrawable.access$8(CircularProgressDrawable.this);
            CircularProgressDrawable.access$9(CircularProgressDrawable.this).start();
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        cancelled = false;
        CircularProgressDrawable.access$6(CircularProgressDrawable.this, true);
    }

    ()
    {
        this$0 = CircularProgressDrawable.this;
        super();
        cancelled = false;
    }
}
