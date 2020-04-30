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
//            ViewPropertyAnimatorHC

private class <init>
    implements com.nineoldandroids.animation.>, com.nineoldandroids.animation.>
{

    final ViewPropertyAnimatorHC this$0;

    public void onAnimationCancel(Animator animator)
    {
        if (ViewPropertyAnimatorHC.access$1(ViewPropertyAnimatorHC.this) != null)
        {
            ViewPropertyAnimatorHC.access$1(ViewPropertyAnimatorHC.this)._mth0(animator);
        }
    }

    public void onAnimationEnd(Animator animator)
    {
        if (ViewPropertyAnimatorHC.access$1(ViewPropertyAnimatorHC.this) != null)
        {
            ViewPropertyAnimatorHC.access$1(ViewPropertyAnimatorHC.this)._mth0(animator);
        }
        ViewPropertyAnimatorHC.access$2(ViewPropertyAnimatorHC.this).remove(animator);
        if (ViewPropertyAnimatorHC.access$2(ViewPropertyAnimatorHC.this).isEmpty())
        {
            ViewPropertyAnimatorHC.access$3(ViewPropertyAnimatorHC.this, null);
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
        if (ViewPropertyAnimatorHC.access$1(ViewPropertyAnimatorHC.this) != null)
        {
            ViewPropertyAnimatorHC.access$1(ViewPropertyAnimatorHC.this)._mth0(animator);
        }
    }

    public void onAnimationStart(Animator animator)
    {
        if (ViewPropertyAnimatorHC.access$1(ViewPropertyAnimatorHC.this) != null)
        {
            ViewPropertyAnimatorHC.access$1(ViewPropertyAnimatorHC.this)._mth0(animator);
        }
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f;
        f = valueanimator.getAnimatedFraction();
        valueanimator = (rt)ViewPropertyAnimatorHC.access$2(ViewPropertyAnimatorHC.this).get(valueanimator);
        if ((((this._cls0) (valueanimator)).tyMask & 0x1ff) != 0)
        {
            View view = (View)ViewPropertyAnimatorHC.access$4(ViewPropertyAnimatorHC.this).get();
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
        valueanimator = (View)ViewPropertyAnimatorHC.access$4(ViewPropertyAnimatorHC.this).get();
        if (valueanimator != null)
        {
            valueanimator.invalidate();
        }
        return;
_L3:
        rt rt = (this._cls0)valueanimator.get(i);
        float f1 = rt.Value;
        float f2 = rt.aValue;
        ViewPropertyAnimatorHC.access$5(ViewPropertyAnimatorHC.this, rt.Constant, f1 + f2 * f);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private ()
    {
        this$0 = ViewPropertyAnimatorHC.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
