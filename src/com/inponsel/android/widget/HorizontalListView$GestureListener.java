// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.view.MotionEvent;
import android.widget.ListAdapter;

// Referenced classes of package com.inponsel.android.widget:
//            HorizontalListView

private class <init> extends android.view.ener
{

    final HorizontalListView this$0;

    public boolean onDown(MotionEvent motionevent)
    {
        return HorizontalListView.this.onDown(motionevent);
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return HorizontalListView.this.onFling(motionevent, motionevent1, f, f1);
    }

    public void onLongPress(MotionEvent motionevent)
    {
        HorizontalListView.access$4(HorizontalListView.this);
        int i = HorizontalListView.access$9(HorizontalListView.this, (int)motionevent.getX(), (int)motionevent.getY());
        if (i >= 0 && !HorizontalListView.access$10(HorizontalListView.this))
        {
            motionevent = getChildAt(i);
            android.widget.  = getOnItemLongClickListener();
            if ( != null)
            {
                i = HorizontalListView.access$11(HorizontalListView.this) + i;
                if (.onItemLongClick(HorizontalListView.this, motionevent, i, mAdapter.getItemId(i)))
                {
                    performHapticFeedback(0);
                }
            }
        }
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        HorizontalListView.access$6(HorizontalListView.this, Boolean.valueOf(true));
        HorizontalListView.access$7(HorizontalListView.this, ngedListener.ScrollState.SCROLL_STATE_TOUCH_SCROLL);
        HorizontalListView.access$4(HorizontalListView.this);
        motionevent = HorizontalListView.this;
        motionevent.mNextX = ((HorizontalListView) (motionevent)).mNextX + (int)f;
        HorizontalListView.access$8(HorizontalListView.this, Math.round(f));
        requestLayout();
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        HorizontalListView.access$4(HorizontalListView.this);
        android.widget.tureListener turelistener = getOnItemClickListener();
        int i = HorizontalListView.access$9(HorizontalListView.this, (int)motionevent.getX(), (int)motionevent.getY());
        if (i >= 0 && !HorizontalListView.access$10(HorizontalListView.this))
        {
            motionevent = getChildAt(i);
            i = HorizontalListView.access$11(HorizontalListView.this) + i;
            if (turelistener != null)
            {
                turelistener.temClick(HorizontalListView.this, motionevent, i, mAdapter.getItemId(i));
                return true;
            }
        }
        if (HorizontalListView.access$12(HorizontalListView.this) != null && !HorizontalListView.access$10(HorizontalListView.this))
        {
            HorizontalListView.access$12(HorizontalListView.this)._mth0(HorizontalListView.this);
        }
        return false;
    }

    private ngedListener.ScrollState()
    {
        this$0 = HorizontalListView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
