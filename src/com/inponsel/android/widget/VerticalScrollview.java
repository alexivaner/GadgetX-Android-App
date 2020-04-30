// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.inponsel.android.utils.Log;

public class VerticalScrollview extends ScrollView
{

    public VerticalScrollview(Context context)
    {
        super(context);
    }

    public VerticalScrollview(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public VerticalScrollview(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i = motionevent.getAction();
        switch (i)
        {
        default:
            Log.i("VerticalScrollview", (new StringBuilder("onInterceptTouchEvent: ")).append(i).toString());
            // fall through

        case 2: // '\002'
            return false;

        case 0: // '\0'
            Log.i("VerticalScrollview", "onInterceptTouchEvent: DOWN super false");
            super.onTouchEvent(motionevent);
            return false;

        case 3: // '\003'
            Log.i("VerticalScrollview", "onInterceptTouchEvent: CANCEL super false");
            super.onTouchEvent(motionevent);
            return false;

        case 1: // '\001'
            Log.i("VerticalScrollview", "onInterceptTouchEvent: UP super false");
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        super.onTouchEvent(motionevent);
        Log.i("VerticalScrollview", (new StringBuilder("onTouchEvent. action: ")).append(motionevent.getAction()).toString());
        return true;
    }
}
