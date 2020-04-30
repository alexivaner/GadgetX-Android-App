// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.text.style.ClickableSpan;
import android.view.View;

public class ClickSpan extends ClickableSpan
{
    public static interface OnClickListener
    {

        public abstract void onClick();
    }


    private OnClickListener mListener;

    public ClickSpan(OnClickListener onclicklistener)
    {
        mListener = onclicklistener;
    }

    public void onClick(View view)
    {
        if (mListener != null)
        {
            mListener.onClick();
        }
    }
}
