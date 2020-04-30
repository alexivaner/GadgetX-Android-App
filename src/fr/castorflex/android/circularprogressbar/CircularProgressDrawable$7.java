// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.circularprogressbar;

import android.animation.Animator;

// Referenced classes of package fr.castorflex.android.circularprogressbar:
//            CircularProgressDrawable

class this._cls0
    implements android.animation.cularProgressDrawable._cls7
{

    private boolean cancelled;
    final CircularProgressDrawable this$0;

    public void onAnimationCancel(Animator animator)
    {
        cancelled = true;
    }

    public void onAnimationEnd(Animator animator)
    {
        CircularProgressDrawable.access$19(CircularProgressDrawable.this, 0.0F);
        if (!cancelled)
        {
            stop();
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
