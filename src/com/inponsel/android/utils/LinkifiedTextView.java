// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

public class LinkifiedTextView extends TextView
{

    public LinkifiedTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        Object obj;
        int i;
        obj = getText();
        if (!(obj instanceof Spanned))
        {
            break MISSING_BLOCK_LABEL_164;
        }
        obj = (Spannable)obj;
        i = motionevent.getAction();
        if (i != 1 && i != 0)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        int j = (int)motionevent.getX();
        int k = (int)motionevent.getY();
        int l = getTotalPaddingLeft();
        int i1 = getTotalPaddingTop();
        int j1 = getScrollX();
        int k1 = getScrollY();
        motionevent = getLayout();
        j = motionevent.getOffsetForHorizontal(motionevent.getLineForVertical((k - i1) + k1), (j - l) + j1);
        motionevent = (ClickableSpan[])((Spannable) (obj)).getSpans(j, j, android/text/style/ClickableSpan);
        if (motionevent.length == 0)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        if (i != 1) goto _L2; else goto _L1
_L1:
        motionevent[0].onClick(this);
_L4:
        return true;
_L2:
        if (i != 0) goto _L4; else goto _L3
_L3:
        Selection.setSelection(((Spannable) (obj)), ((Spannable) (obj)).getSpanStart(motionevent[0]), ((Spannable) (obj)).getSpanEnd(motionevent[0]));
        return true;
        return false;
    }
}
