// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.nineoldandroids.view:
//            ViewPropertyAnimatorPreHC

private class <init>
    implements com.nineoldandroids.animation.>, com.nineoldandroids.animation.>
{

    final ViewPropertyAnimatorPreHC this$0;

    public void onAnimationCancel(Animator animator)
    {
        if (ViewPropertyAnimatorPreHC.access$1(ViewPropertyAnimatorPreHC.this) != null)
        {
            ViewPropertyAnimatorPreHC.access$1(ViewPropertyAnimatorPreHC.this)._mth0(animator);
        }
    }

    public void onAnimationEnd(Animator animator)
    {
        if (ViewPropertyAnimatorPreHC.access$1(ViewPropertyAnimatorPreHC.this) != null)
        {
            ViewPropertyAnimatorPreHC.access$1(ViewPropertyAnimatorPreHC.this)._mth0(animator);
        }
        ViewPropertyAnimatorPreHC.access$2(ViewPropertyAnimatorPreHC.this).remove(animator);
        if (ViewPropertyAnimatorPreHC.access$2(ViewPropertyAnimatorPreHC.this).isEmpty())
        {
            ViewPropertyAnimatorPreHC.access$3(ViewPropertyAnimatorPreHC.this, null);
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
        if (ViewPropertyAnimatorPreHC.access$1(ViewPropertyAnimatorPreHC.this) != null)
        {
            ViewPropertyAnimatorPreHC.access$1(ViewPropertyAnimatorPreHC.this)._mth0(animator);
        }
    }

    public void onAnimationStart(Animator animator)
    {
        if (ViewPropertyAnimatorPreHC.access$1(ViewPropertyAnimatorPreHC.this) != null)
        {
            ViewPropertyAnimatorPreHC.access$1(ViewPropertyAnimatorPreHC.this)._mth0(animator);
        }
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f;
        f = valueanimator.getAnimatedFraction();
        valueanimator = (this._cls0)ViewPropertyAnimatorPreHC.access$2(ViewPropertyAnimatorPreHC.this).get(valueanimator);
        if ((((this._cls0) (valueanimator)).tyMask & 0x1ff) != 0)
        {
            View view = (View)ViewPropertyAnimatorPreHC.access$4(ViewPropertyAnimatorPreHC.this).get();
            if (view != null)
            {
                view.invalidate();
            }
        }
        valueanimator = ((this._cls0) (valueanimator)).luesHolder;
        if (valueanimator == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = valueanimator.size();
        i = 0;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        valueanimator = (View)ViewPropertyAnimatorPreHC.access$4(ViewPropertyAnimatorPreHC.this).get();
        if (valueanimator != null)
        {
            valueanimator.invalidate();
        }
        return;
_L3:
        this._cls0 _lcls0 = (this._cls0)valueanimator.get(i);
        float f1 = _lcls0.Value;
        float f2 = _lcls0.aValue;
        ViewPropertyAnimatorPreHC.access$5(ViewPropertyAnimatorPreHC.this, _lcls0.Constant, f1 + f2 * f);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private ()
    {
        this$0 = ViewPropertyAnimatorPreHC.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
