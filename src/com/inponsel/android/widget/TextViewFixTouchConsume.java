// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.text.Html;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

public class TextViewFixTouchConsume extends TextView
{
    public static class LocalLinkMovementMethod extends LinkMovementMethod
    {

        static LocalLinkMovementMethod sInstance;

        public static volatile MovementMethod getInstance()
        {
            return getInstance();
        }

        public static LocalLinkMovementMethod getInstance()
        {
            if (sInstance == null)
            {
                sInstance = new LocalLinkMovementMethod();
            }
            return sInstance;
        }

        public boolean onTouchEvent(TextView textview, Spannable spannable, MotionEvent motionevent)
        {
            ClickableSpan aclickablespan[];
            int i;
            i = motionevent.getAction();
            if (i != 1 && i != 0)
            {
                break MISSING_BLOCK_LABEL_189;
            }
            int j = (int)motionevent.getX();
            int k = (int)motionevent.getY();
            int l = textview.getTotalPaddingLeft();
            int i1 = textview.getTotalPaddingTop();
            int j1 = textview.getScrollX();
            int k1 = textview.getScrollY();
            Layout layout = textview.getLayout();
            j = layout.getOffsetForHorizontal(layout.getLineForVertical((k - i1) + k1), (j - l) + j1);
            aclickablespan = (ClickableSpan[])spannable.getSpans(j, j, android/text/style/ClickableSpan);
            if (aclickablespan.length == 0) goto _L2; else goto _L1
_L1:
            if (i != 1) goto _L4; else goto _L3
_L3:
            aclickablespan[0].onClick(textview);
_L5:
            if (textview instanceof TextViewFixTouchConsume)
            {
                ((TextViewFixTouchConsume)textview).linkHit = true;
            }
            return true;
_L4:
            if (i == 0)
            {
                Selection.setSelection(spannable, spannable.getSpanStart(aclickablespan[0]), spannable.getSpanEnd(aclickablespan[0]));
            }
            if (true) goto _L5; else goto _L2
_L2:
            Selection.removeSelection(spannable);
            Touch.onTouchEvent(textview, spannable, motionevent);
            return false;
            return Touch.onTouchEvent(textview, spannable, motionevent);
        }

        public LocalLinkMovementMethod()
        {
        }
    }


    boolean dontConsumeNonUrlClicks;
    boolean linkHit;

    public TextViewFixTouchConsume(Context context)
    {
        super(context);
        dontConsumeNonUrlClicks = true;
    }

    public TextViewFixTouchConsume(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        dontConsumeNonUrlClicks = true;
    }

    public TextViewFixTouchConsume(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        dontConsumeNonUrlClicks = true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        linkHit = false;
        boolean flag = super.onTouchEvent(motionevent);
        if (dontConsumeNonUrlClicks)
        {
            flag = linkHit;
        }
        return flag;
    }

    public void setTextViewHTML(String s)
    {
        setText(new SpannableStringBuilder(Html.fromHtml(s)));
    }
}
