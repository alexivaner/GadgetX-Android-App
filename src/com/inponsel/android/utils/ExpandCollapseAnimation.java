// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ExpandCollapseAnimation extends Animation
{

    private View mAnimatedView;
    private int mEndHeight;
    private int mType;

    public ExpandCollapseAnimation(View view, int i, int j)
    {
        setDuration(i);
        mAnimatedView = view;
        mEndHeight = mAnimatedView.getLayoutParams().height;
        mType = j;
        if (mType == 0)
        {
            mAnimatedView.getLayoutParams().height = 0;
            mAnimatedView.setVisibility(0);
        }
    }

    protected void applyTransformation(float f, Transformation transformation)
    {
        super.applyTransformation(f, transformation);
        if (f < 1.0F)
        {
            if (mType == 0)
            {
                mAnimatedView.getLayoutParams().height = (int)((float)mEndHeight * f);
            } else
            {
                mAnimatedView.getLayoutParams().height = mEndHeight - (int)((float)mEndHeight * f);
            }
            mAnimatedView.requestLayout();
            return;
        }
        if (mType == 0)
        {
            mAnimatedView.getLayoutParams().height = mEndHeight;
            mAnimatedView.requestLayout();
            return;
        } else
        {
            mAnimatedView.getLayoutParams().height = 0;
            mAnimatedView.setVisibility(8);
            mAnimatedView.requestLayout();
            mAnimatedView.getLayoutParams().height = mEndHeight;
            return;
        }
    }
}
