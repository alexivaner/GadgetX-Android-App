// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nirhart.parallaxscroll.views;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ParallaxedView
{

    public static boolean isAPI11;
    protected List animations;
    protected int lastOffset;
    protected WeakReference view;

    public ParallaxedView(View view1)
    {
        lastOffset = 0;
        animations = new ArrayList();
        view = new WeakReference(view1);
    }

    protected void addAnimation(Animation animation)
    {
        this;
        JVM INSTR monitorenter ;
        animations.add(animation);
        this;
        JVM INSTR monitorexit ;
        return;
        animation;
        throw animation;
    }

    protected void alphaPreICS(View view1, float f)
    {
        addAnimation(new AlphaAnimation(f, f));
    }

    protected void animateNow()
    {
        this;
        JVM INSTR monitorenter ;
        View view1 = (View)view.get();
        if (view1 == null) goto _L2; else goto _L1
_L1:
        AnimationSet animationset;
        Iterator iterator;
        animationset = new AnimationSet(true);
        iterator = animations.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        animationset.setDuration(0L);
        animationset.setFillAfter(true);
        view1.setAnimation(animationset);
        animationset.start();
        animations.clear();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        Animation animation = (Animation)iterator.next();
        if (animation == null) goto _L6; else goto _L5
_L5:
        animationset.addAnimation(animation);
          goto _L6
        Exception exception;
        exception;
        throw exception;
    }

    public boolean is(View view1)
    {
        return view1 != null && view != null && view.get() != null && ((View)view.get()).equals(view1);
    }

    public void setAlpha(float f)
    {
        View view1;
label0:
        {
            view1 = (View)view.get();
            if (view1 != null)
            {
                if (!isAPI11)
                {
                    break label0;
                }
                view1.setAlpha(f);
            }
            return;
        }
        alphaPreICS(view1, f);
    }

    public void setOffset(float f)
    {
        View view1;
label0:
        {
            view1 = (View)view.get();
            if (view1 != null)
            {
                if (!isAPI11)
                {
                    break label0;
                }
                view1.setTranslationY(f);
            }
            return;
        }
        translatePreICS(view1, f);
    }

    public void setView(View view1)
    {
        view = new WeakReference(view1);
    }

    protected abstract void translatePreICS(View view1, float f);

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isAPI11 = flag;
    }
}
