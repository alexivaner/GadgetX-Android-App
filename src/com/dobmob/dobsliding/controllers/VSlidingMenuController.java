// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dobmob.dobsliding.controllers;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.dobmob.dobsliding.animations.AnimationExecutor;
import com.dobmob.dobsliding.exceptions.NoActionBarException;
import com.dobmob.dobsliding.listeners.OnMovingTouchListener;
import com.dobmob.dobsliding.listeners.OnSizingTouchListener;
import com.dobmob.dobsliding.listeners.SlidingParentKeyListener;
import com.dobmob.dobsliding.listeners.SlidingParentTouchListener;
import com.dobmob.dobsliding.models.SlidingItem;
import com.dobmob.dobsliding.utils.Computer;
import com.dobmob.dobsliding.utils.Initializer;

public class VSlidingMenuController
{
    public static final class SlidingStatus extends Enum
    {

        public static final SlidingStatus ANIMATING;
        public static final SlidingStatus COLLAPSED;
        private static final SlidingStatus ENUM$VALUES[];
        public static final SlidingStatus EXPANDED;

        public static SlidingStatus valueOf(String s)
        {
            return (SlidingStatus)Enum.valueOf(com/dobmob/dobsliding/controllers/VSlidingMenuController$SlidingStatus, s);
        }

        public static SlidingStatus[] values()
        {
            SlidingStatus aslidingstatus[] = ENUM$VALUES;
            int i = aslidingstatus.length;
            SlidingStatus aslidingstatus1[] = new SlidingStatus[i];
            System.arraycopy(aslidingstatus, 0, aslidingstatus1, 0, i);
            return aslidingstatus1;
        }

        static 
        {
            COLLAPSED = new SlidingStatus("COLLAPSED", 0);
            EXPANDED = new SlidingStatus("EXPANDED", 1);
            ANIMATING = new SlidingStatus("ANIMATING", 2);
            ENUM$VALUES = (new SlidingStatus[] {
                COLLAPSED, EXPANDED, ANIMATING
            });
        }

        private SlidingStatus(String s, int i)
        {
            super(s, i);
        }
    }


    private static int $SWITCH_TABLE$com$dobmob$dobsliding$controllers$VSlidingMenuController$SlidingStatus[];
    public static final int DEFAULT_INT = -1;
    public static final float DEFAULT_JUMP_LINE_PERCENTAGE = 0.6F;
    private View actionBarView;
    private Activity activity;
    private AnimationExecutor animationExecutor;
    private ViewGroup content;
    private ViewGroup decor;
    private ImageView handle;
    private float jumpLine;
    private OnMovingTouchListener movingTouchListener;
    private OnSizingTouchListener sizingTouchListener;
    protected int slidingHeight;
    private SlidingItem slidingItem;
    private android.widget.FrameLayout.LayoutParams slidingLayoutParams;
    private FrameLayout slidingParent;

    static int[] $SWITCH_TABLE$com$dobmob$dobsliding$controllers$VSlidingMenuController$SlidingStatus()
    {
        int ai[] = $SWITCH_TABLE$com$dobmob$dobsliding$controllers$VSlidingMenuController$SlidingStatus;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[SlidingStatus.values().length];
        try
        {
            ai[SlidingStatus.ANIMATING.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[SlidingStatus.COLLAPSED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[SlidingStatus.EXPANDED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$dobmob$dobsliding$controllers$VSlidingMenuController$SlidingStatus = ai;
        return ai;
    }

    public VSlidingMenuController(Activity activity1, SlidingItem slidingitem)
        throws NoActionBarException
    {
        activity = activity1;
        slidingItem = slidingitem;
        init();
    }

    private void init()
        throws NoActionBarException
    {
        slidingParent = new FrameLayout(activity);
        animationExecutor = new AnimationExecutor(this);
        decor = (ViewGroup)activity.getWindow().getDecorView();
        content = (ViewGroup)decor.findViewById(0x1020002);
        content.addView(slidingParent);
        handle = Initializer.initHandle(activity, this, slidingItem);
        handle.setOnTouchListener(movingTouchListener);
        actionBarView = Initializer.getActionBarView(decor);
        setSlidingType(slidingItem.getSlidingType());
        sizingTouchListener = new OnSizingTouchListener(this);
        movingTouchListener = new OnMovingTouchListener(this);
    }

    public void animateSliding(int i, int j)
    {
        animationExecutor.animateView(i, j);
    }

    public void changeHandle(SlidingStatus slidingstatus)
    {
        if (handle == null) goto _L2; else goto _L1
_L1:
        $SWITCH_TABLE$com$dobmob$dobsliding$controllers$VSlidingMenuController$SlidingStatus()[slidingstatus.ordinal()];
        JVM INSTR tableswitch 1 2: default 36
    //                   1 37
    //                   2 52;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        handle.setImageResource(slidingItem.getHandleCollapsedIcon());
        return;
_L4:
        handle.setImageResource(slidingItem.getHandleExpandedIcon());
        return;
    }

    public void collapse()
    {
        animateSliding(slidingHeight, 0);
    }

    public void expand()
    {
        animateSliding(0, slidingHeight);
        focusOnSliding();
    }

    public void finish()
    {
        collapse();
    }

    public void focusOnSliding()
    {
        slidingParent.setFocusable(true);
        slidingParent.setFocusableInTouchMode(true);
        slidingParent.requestFocus();
    }

    public float getJumpLine()
    {
        return jumpLine;
    }

    public int getSlidingHeight()
    {
        return slidingHeight;
    }

    public SlidingItem getSlidingItem()
    {
        return slidingItem;
    }

    public FrameLayout getSlidingParent()
    {
        return slidingParent;
    }

    public SlidingStatus getSlidingStatus()
    {
        return Computer.getSlidingStatus(this);
    }

    public int getViewHeight()
    {
        return slidingLayoutParams.height;
    }

    public int getViewTop()
    {
        return slidingLayoutParams.topMargin;
    }

    protected void hideSlidingLayout()
    {
        slidingHeight = content.getHeight();
        jumpLine = (float)slidingHeight * slidingItem.getJumpLinePercentage();
        slidingLayoutParams.height = slidingHeight;
        slidingParent.setLayoutParams(slidingLayoutParams);
        if (slidingItem.getSlidingType() != com.dobmob.dobsliding.models.SlidingItem.SlidingType.SIZE) goto _L2; else goto _L1
_L1:
        slidingLayoutParams.height = 0;
        slidingLayoutParams.topMargin = 0;
_L4:
        slidingParent.setLayoutParams(slidingLayoutParams);
        return;
_L2:
        if (slidingItem.getSlidingType() == com.dobmob.dobsliding.models.SlidingItem.SlidingType.MOVE)
        {
            slidingLayoutParams.topMargin = -slidingHeight;
            slidingLayoutParams.height = slidingHeight;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void prepareSlidingLayout()
    {
        slidingLayoutParams = (android.widget.FrameLayout.LayoutParams)slidingParent.getLayoutParams();
        slidingParent.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final VSlidingMenuController this$0;

            public void onGlobalLayout()
            {
                hideSlidingLayout();
                ViewTreeObserver viewtreeobserver = slidingParent.getViewTreeObserver();
                if (android.os.Build.VERSION.SDK_INT >= 16)
                {
                    viewtreeobserver.removeOnGlobalLayoutListener(this);
                    return;
                } else
                {
                    viewtreeobserver.removeGlobalOnLayoutListener(this);
                    return;
                }
            }

            
            {
                this$0 = VSlidingMenuController.this;
                super();
            }
        });
        Object obj = new SlidingParentTouchListener();
        ((SlidingParentTouchListener) (obj)).register(this);
        slidingParent.setOnTouchListener(((android.view.View.OnTouchListener) (obj)));
        obj = new SlidingParentKeyListener(this);
        slidingParent.setOnKeyListener(((android.view.View.OnKeyListener) (obj)));
    }

    public void setSlidingItem(SlidingItem slidingitem)
    {
        slidingItem = slidingitem;
    }

    public void setSlidingType(com.dobmob.dobsliding.models.SlidingItem.SlidingType slidingtype)
    {
        if (slidingtype != com.dobmob.dobsliding.models.SlidingItem.SlidingType.SIZE) goto _L2; else goto _L1
_L1:
        actionBarView.setOnTouchListener(sizingTouchListener);
_L4:
        if (slidingItem.getSlidingView() != null)
        {
            hideSlidingLayout();
        }
        return;
_L2:
        if (slidingtype == com.dobmob.dobsliding.models.SlidingItem.SlidingType.MOVE)
        {
            actionBarView.setOnTouchListener(movingTouchListener);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setSlidingView(View view)
    {
        if (slidingParent.getChildCount() > 0)
        {
            slidingParent.removeViewAt(0);
        }
        view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        slidingParent.addView(view);
        prepareSlidingLayout();
        hideSlidingLayout();
    }

    public void setUseHandle(boolean flag)
    {
        ViewGroup viewgroup = (ViewGroup)actionBarView.getParent();
        if (flag)
        {
            if (handle.getParent() != viewgroup)
            {
                viewgroup.addView(handle);
            }
        } else
        if (handle.getParent() == viewgroup)
        {
            viewgroup.removeView(handle);
            return;
        }
    }

    public void setViewHeight(int i)
    {
        slidingLayoutParams.height = i;
        slidingParent.setLayoutParams(slidingLayoutParams);
    }

    public void setViewTop(int i)
    {
        slidingLayoutParams.topMargin = i - slidingHeight;
        slidingParent.setLayoutParams(slidingLayoutParams);
    }

}
