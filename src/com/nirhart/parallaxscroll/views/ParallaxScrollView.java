// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nirhart.parallaxscroll.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.nirhart.parallaxscroll.views:
//            ParallaxedView

public class ParallaxScrollView extends ScrollView
{
    public static interface ScrollViewListener
    {

        public abstract void onScrollChanged(ParallaxScrollView parallaxscrollview, int i, int j, int k, int l);
    }

    protected class ScrollViewParallaxedItem extends ParallaxedView
    {

        final ParallaxScrollView this$0;

        protected void translatePreICS(View view, float f)
        {
            view.offsetTopAndBottom((int)f - lastOffset);
            lastOffset = (int)f;
        }

        public ScrollViewParallaxedItem(View view)
        {
            this$0 = ParallaxScrollView.this;
            super(view);
        }
    }


    private static final float DEFAULT_ALPHA_FACTOR = -1F;
    private static final float DEFAULT_INNER_PARALLAX_FACTOR = 1.9F;
    private static final float DEFAULT_PARALLAX_FACTOR = 1.9F;
    private static final int DEFAULT_PARALLAX_VIEWS = 1;
    private float alphaFactor;
    private float innerParallaxFactor;
    private int numOfParallaxViews;
    private float parallaxFactor;
    private ArrayList parallaxedViews;
    private ScrollViewListener scrollViewListener;

    public ParallaxScrollView(Context context)
    {
        super(context);
        numOfParallaxViews = 1;
        innerParallaxFactor = 1.9F;
        parallaxFactor = 1.9F;
        alphaFactor = -1F;
        parallaxedViews = new ArrayList();
        scrollViewListener = null;
    }

    public ParallaxScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        numOfParallaxViews = 1;
        innerParallaxFactor = 1.9F;
        parallaxFactor = 1.9F;
        alphaFactor = -1F;
        parallaxedViews = new ArrayList();
        scrollViewListener = null;
        init(context, attributeset);
    }

    public ParallaxScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        numOfParallaxViews = 1;
        innerParallaxFactor = 1.9F;
        parallaxFactor = 1.9F;
        alphaFactor = -1F;
        parallaxedViews = new ArrayList();
        scrollViewListener = null;
        init(context, attributeset);
    }

    private void makeViewsParallax()
    {
        if (getChildCount() <= 0 || !(getChildAt(0) instanceof ViewGroup)) goto _L2; else goto _L1
_L1:
        ViewGroup viewgroup;
        int i;
        int j;
        viewgroup = (ViewGroup)getChildAt(0);
        j = Math.min(numOfParallaxViews, viewgroup.getChildCount());
        i = 0;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return;
_L3:
        ScrollViewParallaxedItem scrollviewparallaxeditem = new ScrollViewParallaxedItem(viewgroup.getChildAt(i));
        parallaxedViews.add(scrollviewparallaxeditem);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void init(Context context, AttributeSet attributeset)
    {
        context = context.obtainStyledAttributes(attributeset, com.nirhart.parallaxscroll.R.styleable.ParallaxScroll);
        parallaxFactor = context.getFloat(com.nirhart.parallaxscroll.R.styleable.ParallaxScroll_parallax_factor, 1.9F);
        alphaFactor = context.getFloat(com.nirhart.parallaxscroll.R.styleable.ParallaxScroll_alpha_factor, -1F);
        innerParallaxFactor = context.getFloat(com.nirhart.parallaxscroll.R.styleable.ParallaxScroll_inner_parallax_factor, 1.9F);
        numOfParallaxViews = context.getInt(com.nirhart.parallaxscroll.R.styleable.ParallaxScroll_parallax_views_num, 1);
        context.recycle();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        makeViewsParallax();
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        float f1 = parallaxFactor;
        float f = alphaFactor;
        Iterator iterator = parallaxedViews.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                if (scrollViewListener != null)
                {
                    scrollViewListener.onScrollChanged(this, i, j, k, l);
                }
                return;
            }
            ParallaxedView parallaxedview = (ParallaxedView)iterator.next();
            parallaxedview.setOffset((float)j / f1);
            float f2 = f1 * innerParallaxFactor;
            f1 = f;
            if (f != -1F)
            {
                if (j <= 0)
                {
                    f1 = 1.0F;
                } else
                {
                    f1 = 100F / ((float)j * f);
                }
                parallaxedview.setAlpha(f1);
                f1 = f / alphaFactor;
            }
            parallaxedview.animateNow();
            f = f1;
            f1 = f2;
        } while (true);
    }

    public void setScrollViewListener(ScrollViewListener scrollviewlistener)
    {
        scrollViewListener = scrollviewlistener;
    }
}
