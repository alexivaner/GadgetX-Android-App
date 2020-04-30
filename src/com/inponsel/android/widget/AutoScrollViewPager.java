// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

// Referenced classes of package com.inponsel.android.widget:
//            CustomDurationScroller

public class AutoScrollViewPager extends ViewPager
{
    private static class MyHandler extends Handler
    {

        private final WeakReference autoScrollViewPager;

        public void handleMessage(Message message)
        {
            super.handleMessage(message);
            message.what;
            JVM INSTR tableswitch 0 0: default 28
        //                       0 29;
               goto _L1 _L2
_L1:
            return;
_L2:
            if ((message = (AutoScrollViewPager)autoScrollViewPager.get()) != null)
            {
                ((AutoScrollViewPager) (message)).scroller.setScrollDurationFactor(((AutoScrollViewPager) (message)).autoScrollFactor);
                message.scrollOnce();
                ((AutoScrollViewPager) (message)).scroller.setScrollDurationFactor(((AutoScrollViewPager) (message)).swipeScrollFactor);
                message.sendScrollMessage(((AutoScrollViewPager) (message)).interval + (long)((AutoScrollViewPager) (message)).scroller.getDuration());
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public MyHandler(AutoScrollViewPager autoscrollviewpager)
        {
            autoScrollViewPager = new WeakReference(autoscrollviewpager);
        }
    }


    public static final int DEFAULT_INTERVAL = 1500;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int SCROLL_WHAT = 0;
    public static final int SLIDE_BORDER_MODE_CYCLE = 1;
    public static final int SLIDE_BORDER_MODE_NONE = 0;
    public static final int SLIDE_BORDER_MODE_TO_PARENT = 2;
    private double autoScrollFactor;
    private int direction;
    private float downX;
    private Handler handler;
    private long interval;
    private boolean isAutoScroll;
    private boolean isBorderAnimation;
    private boolean isCycle;
    private boolean isStopByTouch;
    private CustomDurationScroller scroller;
    private int slideBorderMode;
    private boolean stopScrollWhenTouch;
    private double swipeScrollFactor;
    private float touchX;

    public AutoScrollViewPager(Context context)
    {
        super(context);
        interval = 1500L;
        direction = 1;
        isCycle = true;
        stopScrollWhenTouch = true;
        slideBorderMode = 0;
        isBorderAnimation = true;
        autoScrollFactor = 1.0D;
        swipeScrollFactor = 1.0D;
        isAutoScroll = false;
        isStopByTouch = false;
        touchX = 0.0F;
        downX = 0.0F;
        scroller = null;
        init();
    }

    public AutoScrollViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        interval = 1500L;
        direction = 1;
        isCycle = true;
        stopScrollWhenTouch = true;
        slideBorderMode = 0;
        isBorderAnimation = true;
        autoScrollFactor = 1.0D;
        swipeScrollFactor = 1.0D;
        isAutoScroll = false;
        isStopByTouch = false;
        touchX = 0.0F;
        downX = 0.0F;
        scroller = null;
        init();
    }

    private void init()
    {
        handler = new MyHandler(this);
        setViewPagerScroller();
    }

    private void sendScrollMessage(long l)
    {
        handler.removeMessages(0);
        handler.sendEmptyMessageDelayed(0, l);
    }

    private void setViewPagerScroller()
    {
        try
        {
            Field field = android/support/v4/view/ViewPager.getDeclaredField("mScroller");
            field.setAccessible(true);
            Field field1 = android/support/v4/view/ViewPager.getDeclaredField("sInterpolator");
            field1.setAccessible(true);
            scroller = new CustomDurationScroller(getContext(), (Interpolator)field1.get(null));
            field.set(this, scroller);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1 && isStopByTouch)
        {
            startAutoScroll();
        }
        continue;
        int i = MotionEventCompat.getActionMasked(motionevent);
        if (stopScrollWhenTouch)
        {
            if (i != 0 || !isAutoScroll)
            {
                break MISSING_BLOCK_LABEL_149;
            }
            isStopByTouch = true;
            stopAutoScroll();
        }
        do
        {
            if (slideBorderMode == 2 || slideBorderMode == 1)
            {
                touchX = motionevent.getX();
                if (motionevent.getAction() == 0)
                {
                    downX = touchX;
                }
                int k = getCurrentItem();
                PagerAdapter pageradapter = getAdapter();
                int j;
                if (pageradapter == null)
                {
                    j = 0;
                } else
                {
                    j = pageradapter.getCount();
                }
                if (k == 0 && downX <= touchX || k == j - 1 && downX >= touchX)
                {
                    if (slideBorderMode == 2)
                    {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else
                    {
                        if (j > 1)
                        {
                            setCurrentItem(j - k - 1, isBorderAnimation);
                        }
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return super.dispatchTouchEvent(motionevent);
                }
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            return super.dispatchTouchEvent(motionevent);
        } while (true);
    }

    public int getDirection()
    {
        return direction != 0 ? 1 : 0;
    }

    public long getInterval()
    {
        return interval;
    }

    public int getSlideBorderMode()
    {
        return slideBorderMode;
    }

    public boolean isBorderAnimation()
    {
        return isBorderAnimation;
    }

    public boolean isCycle()
    {
        return isCycle;
    }

    public boolean isStopScrollWhenTouch()
    {
        return stopScrollWhenTouch;
    }

    public void scrollOnce()
    {
        int i;
        int l;
label0:
        {
            PagerAdapter pageradapter = getAdapter();
            i = getCurrentItem();
            if (pageradapter != null)
            {
                l = pageradapter.getCount();
                if (l > 1)
                {
                    break label0;
                }
            }
            return;
        }
        if (direction == 0)
        {
            i--;
            int j = i;
        } else
        {
            i++;
            int k = i;
        }
        if (i >= 0) goto _L2; else goto _L1
_L1:
        if (isCycle)
        {
            setCurrentItem(l - 1, isBorderAnimation);
        }
_L4:
        return;
_L2:
        if (i == l)
        {
            if (isCycle)
            {
                setCurrentItem(0, isBorderAnimation);
            }
        } else
        {
            setCurrentItem(i, true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setAutoScrollDurationFactor(double d)
    {
        autoScrollFactor = d;
    }

    public void setBorderAnimation(boolean flag)
    {
        isBorderAnimation = flag;
    }

    public void setCycle(boolean flag)
    {
        isCycle = flag;
    }

    public void setDirection(int i)
    {
        direction = i;
    }

    public void setInterval(long l)
    {
        interval = l;
    }

    public void setSlideBorderMode(int i)
    {
        slideBorderMode = i;
    }

    public void setStopScrollWhenTouch(boolean flag)
    {
        stopScrollWhenTouch = flag;
    }

    public void setSwipeScrollDurationFactor(double d)
    {
        swipeScrollFactor = d;
    }

    public void startAutoScroll()
    {
        isAutoScroll = true;
        sendScrollMessage((long)((double)interval + ((double)scroller.getDuration() / autoScrollFactor) * swipeScrollFactor));
    }

    public void startAutoScroll(int i)
    {
        isAutoScroll = true;
        sendScrollMessage(i);
    }

    public void stopAutoScroll()
    {
        isAutoScroll = false;
        handler.removeMessages(0);
    }





}
