// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.SimpleAdapter;

// Referenced classes of package com.inponsel.android.widget:
//            IndexScroller

public class IndexableListView extends ListView
{

    private GestureDetector mGestureDetector;
    private boolean mIsFastScrollEnabled;
    private IndexScroller mScroller;

    public IndexableListView(Context context)
    {
        super(context);
        mIsFastScrollEnabled = false;
        mScroller = null;
        mGestureDetector = null;
    }

    public IndexableListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsFastScrollEnabled = false;
        mScroller = null;
        mGestureDetector = null;
    }

    public IndexableListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mIsFastScrollEnabled = false;
        mScroller = null;
        mGestureDetector = null;
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (mScroller != null)
        {
            mScroller.draw(canvas);
        }
    }

    public boolean isFastScrollEnabled()
    {
        return mIsFastScrollEnabled;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (mScroller != null)
        {
            mScroller.onSizeChanged(i, j, k, l);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (mScroller != null && mScroller.onTouchEvent(motionevent))
        {
            return true;
        }
        if (mGestureDetector == null)
        {
            mGestureDetector = new GestureDetector(getContext(), new android.view.GestureDetector.SimpleOnGestureListener() {

                final IndexableListView this$0;

                public boolean onFling(MotionEvent motionevent1, MotionEvent motionevent2, float f, float f1)
                {
                    mScroller.show();
                    return super.onFling(motionevent1, motionevent2, f, f1);
                }

            
            {
                this$0 = IndexableListView.this;
                super();
            }
            });
        }
        mGestureDetector.onTouchEvent(motionevent);
        return super.onTouchEvent(motionevent);
    }

    public void setAdapter(SimpleAdapter simpleadapter)
    {
        super.setAdapter(simpleadapter);
        if (mScroller != null)
        {
            mScroller.setAdapter(simpleadapter);
        }
    }

    public void setFastScrollEnabled(boolean flag)
    {
        mIsFastScrollEnabled = flag;
        if (mIsFastScrollEnabled)
        {
            if (mScroller == null)
            {
                mScroller = new IndexScroller(getContext(), this);
            }
        } else
        if (mScroller != null)
        {
            mScroller.hide();
            mScroller = null;
            return;
        }
    }

}
