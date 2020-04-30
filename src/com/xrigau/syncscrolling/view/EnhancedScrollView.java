// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xrigau.syncscrolling.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.Iterator;

public class EnhancedScrollView extends ScrollView
{
    static interface OnScrollChangedListener
    {

        public abstract void onVerticalScrollChanged(int i);
    }


    private ArrayList mOnScrollListener;

    public EnhancedScrollView(Context context)
    {
        super(context);
        mOnScrollListener = new ArrayList();
    }

    public EnhancedScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mOnScrollListener = new ArrayList();
    }

    public EnhancedScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mOnScrollListener = new ArrayList();
    }

    public void addOnScrollListener(OnScrollChangedListener onscrollchangedlistener)
    {
        mOnScrollListener.add(onscrollchangedlistener);
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        Iterator iterator = mOnScrollListener.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            ((OnScrollChangedListener)iterator.next()).onVerticalScrollChanged(j);
        } while (true);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        post(new Runnable() {

            final EnhancedScrollView this$0;

            public void run()
            {
                Iterator iterator = mOnScrollListener.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        invalidate();
                        return;
                    }
                    ((OnScrollChangedListener)iterator.next()).onVerticalScrollChanged(getScrollY());
                } while (true);
            }

            
            {
                this$0 = EnhancedScrollView.this;
                super();
            }
        });
    }

}
