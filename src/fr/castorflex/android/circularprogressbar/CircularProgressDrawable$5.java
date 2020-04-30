// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.circularprogressbar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Paint;

// Referenced classes of package fr.castorflex.android.circularprogressbar:
//            CircularProgressDrawable

class this._cls0
    implements android.animation.cularProgressDrawable._cls5
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
            CircularProgressDrawable.access$15(CircularProgressDrawable.this);
            CircularProgressDrawable.access$16(CircularProgressDrawable.this, (CircularProgressDrawable.access$12(CircularProgressDrawable.this) + 1) % CircularProgressDrawable.access$10(CircularProgressDrawable.this).length);
            CircularProgressDrawable.access$17(CircularProgressDrawable.this, CircularProgressDrawable.access$10(CircularProgressDrawable.this)[CircularProgressDrawable.access$12(CircularProgressDrawable.this)]);
            CircularProgressDrawable.access$14(CircularProgressDrawable.this).setColor(CircularProgressDrawable.access$11(CircularProgressDrawable.this));
            CircularProgressDrawable.access$18(CircularProgressDrawable.this).start();
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        cancelled = false;
    }

    ()
    {
        this$0 = CircularProgressDrawable.this;
        super();
    }
}
