// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

// Referenced classes of package com.inponsel.android.utils:
//            ScrollDetector

public class ShowHideOnScroll extends ScrollDetector
    implements android.view.animation.Animation.AnimationListener
{

    private final int mHide;
    private final int mShow;
    private final View mView;

    public ShowHideOnScroll(View view)
    {
        this(view, 0x7f04000c, 0x7f04000b);
    }

    public ShowHideOnScroll(View view, int i, int j)
    {
        super(view.getContext());
        mView = view;
        mShow = i;
        mHide = j;
    }

    private void animate(int i)
    {
        if (i != 0)
        {
            Animation animation = AnimationUtils.loadAnimation(mView.getContext(), i);
            animation.setAnimationListener(this);
            mView.startAnimation(animation);
            setIgnore(true);
        }
    }

    public void onAnimationEnd(Animation animation)
    {
        setIgnore(false);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    public void onScrollDown()
    {
        if (mView.getVisibility() != 0)
        {
            mView.setVisibility(0);
            animate(mShow);
        }
    }

    public void onScrollUp()
    {
        if (mView.getVisibility() == 0)
        {
            mView.setVisibility(8);
            animate(mHide);
        }
    }
}
