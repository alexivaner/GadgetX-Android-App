// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.andraskindler.quickscroll;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ExpandableListView;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.andraskindler.quickscroll:
//            Pin, ViewHelper, Scrollable

public class QuickScroll extends View
{

    public static final int BLUE_LIGHT = Color.parseColor("#FF33B5E5");
    public static final int BLUE_LIGHT_SEMITRANSPARENT = Color.parseColor("#8033B5E5");
    public static final int GREY_DARK = Color.parseColor("#e0585858");
    public static final int GREY_LIGHT = Color.parseColor("#f0888888");
    public static final int GREY_SCROLLBAR = Color.parseColor("#64404040");
    protected static final int ID_PIN = 512;
    protected static final int ID_PIN_TEXT = 513;
    protected static final int SCROLLBAR_MARGIN = 10;
    public static final int STYLE_HOLO = 1;
    public static final int STYLE_NONE = 0;
    protected static final int TEXT_PADDING = 4;
    public static final int TYPE_INDICATOR = 1;
    public static final int TYPE_INDICATOR_WITH_HANDLE = 3;
    public static final int TYPE_POPUP = 0;
    public static final int TYPE_POPUP_WITH_HANDLE = 2;
    protected AlphaAnimation fadeInAnimation;
    protected AlphaAnimation fadeOutAnimation;
    protected int groupPosition;
    protected View handleBar;
    protected boolean isInitialized;
    protected boolean isScrolling;
    protected int itemCount;
    protected ListView listView;
    protected RelativeLayout scrollIndicator;
    protected TextView scrollIndicatorTextView;
    protected Scrollable scrollable;
    protected int type;

    public QuickScroll(Context context)
    {
        super(context);
        isInitialized = false;
    }

    public QuickScroll(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        isInitialized = false;
    }

    public QuickScroll(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        isInitialized = false;
    }

    protected RelativeLayout createPin()
    {
        RelativeLayout relativelayout = new RelativeLayout(getContext());
        relativelayout.setVisibility(4);
        Object obj = new Pin(getContext());
        ((Pin) (obj)).setId(512);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(11);
        layoutparams.addRule(8, 513);
        layoutparams.addRule(6, 513);
        ((Pin) (obj)).setLayoutParams(layoutparams);
        relativelayout.addView(((View) (obj)));
        obj = new TextView(getContext());
        ((TextView) (obj)).setId(513);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(0, 512);
        ((TextView) (obj)).setLayoutParams(layoutparams);
        ((TextView) (obj)).setTextColor(-1);
        ((TextView) (obj)).setGravity(17);
        ((TextView) (obj)).setBackgroundColor(GREY_LIGHT);
        relativelayout.addView(((View) (obj)));
        return relativelayout;
    }

    public void init(int i, ListView listview, Scrollable scrollable1, int j)
    {
        if (isInitialized)
        {
            return;
        }
        type = i;
        listView = listview;
        scrollable = scrollable1;
        groupPosition = -1;
        fadeInAnimation = new AlphaAnimation(0.0F, 1.0F);
        fadeInAnimation.setFillAfter(true);
        fadeOutAnimation = new AlphaAnimation(1.0F, 0.0F);
        fadeOutAnimation.setFillAfter(true);
        fadeOutAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final QuickScroll this$0;

            public void onAnimationEnd(Animation animation)
            {
                isScrolling = false;
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = QuickScroll.this;
                super();
            }
        });
        isScrolling = false;
        listView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final QuickScroll this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return isScrolling && (motionevent.getAction() == 2 || motionevent.getAction() == 0);
            }

            
            {
                this$0 = QuickScroll.this;
                super();
            }
        });
        scrollable1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        listview = new RelativeLayout(getContext());
        listview.setBackgroundColor(0);
        scrollable1.addRule(6, getId());
        scrollable1.addRule(8, getId());
        listview.setLayoutParams(scrollable1);
        float f;
        if (type == 0 || type == 2)
        {
            scrollIndicatorTextView = new TextView(getContext());
            scrollIndicatorTextView.setTextColor(-1);
            scrollIndicatorTextView.setVisibility(4);
            scrollIndicatorTextView.setGravity(17);
            scrollable1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            scrollable1.addRule(13);
            scrollIndicatorTextView.setLayoutParams(scrollable1);
            setPopupColor(GREY_LIGHT, GREY_DARK, 1, -1, 1.0F);
            setTextPadding(4, 4, 4, 4);
            listview.addView(scrollIndicatorTextView);
        } else
        {
            scrollIndicator = createPin();
            scrollIndicatorTextView = (TextView)scrollIndicator.findViewById(513);
            scrollIndicator.findViewById(512).getLayoutParams().width = 25;
            listview.addView(scrollIndicator);
        }
        f = getResources().getDisplayMetrics().density;
        getLayoutParams().width = (int)(30F * f);
        scrollIndicatorTextView.setTextSize(1, 32F);
        if (j != 0)
        {
            scrollable1 = new RelativeLayout(getContext());
            Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(5, getId());
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(6, getId());
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(7, getId());
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(8, getId());
            scrollable1.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = new View(getContext());
            ((View) (obj)).setBackgroundColor(GREY_SCROLLBAR);
            android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(1, -1);
            layoutparams1.addRule(14);
            layoutparams1.topMargin = 10;
            layoutparams1.bottomMargin = 10;
            ((View) (obj)).setLayoutParams(layoutparams1);
            scrollable1.addView(((View) (obj)));
            ((ViewGroup)android/view/ViewGroup.cast(listView.getParent())).addView(scrollable1);
            if (type == 3 || type == 2)
            {
                handleBar = new View(getContext());
                setHandlebarColor(BLUE_LIGHT, BLUE_LIGHT, BLUE_LIGHT_SEMITRANSPARENT);
                android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(12F * f), (int)(36F * f));
                handleBar.setLayoutParams(layoutparams);
                ((android.widget.RelativeLayout.LayoutParams)handleBar.getLayoutParams()).addRule(14);
                scrollable1.addView(handleBar);
                listView.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

                    final QuickScroll this$0;

                    public void onScroll(AbsListView abslistview, int k, int l, int i1)
                    {
                        if (!isScrolling && i1 - l > 0)
                        {
                            moveHandlebar((getHeight() * k) / (i1 - l));
                        }
                    }

                    public void onScrollStateChanged(AbsListView abslistview, int k)
                    {
                    }

            
            {
                this$0 = QuickScroll.this;
                super();
            }
                });
            }
        }
        isInitialized = true;
        ((ViewGroup)android/view/ViewGroup.cast(listView.getParent())).addView(listview);
    }

    protected void moveHandlebar(float f)
    {
        float f1 = f;
        if (f1 >= 10F) goto _L2; else goto _L1
_L1:
        f = 10F;
_L4:
        ViewHelper.setTranslationY(handleBar, f);
        return;
_L2:
        f = f1;
        if (f1 > (float)(getHeight() - handleBar.getHeight() - 10))
        {
            f = getHeight() - handleBar.getHeight() - 10;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        android.widget.ListAdapter listadapter1 = listView.getAdapter();
        if (listadapter1 != null)
        {
            android.widget.ListAdapter listadapter = listadapter1;
            if (listadapter1 instanceof HeaderViewListAdapter)
            {
                listadapter = ((HeaderViewListAdapter)listadapter1).getWrappedAdapter();
            }
            itemCount = listadapter.getCount();
            if (itemCount != 0)
            {
                if (motionevent.getActionMasked() == 3)
                {
                    if (type == 0 || type == 1)
                    {
                        scrollIndicatorTextView.startAnimation(fadeOutAnimation);
                    } else
                    {
                        if (type == 3 || type == 2)
                        {
                            handleBar.setSelected(false);
                        }
                        scrollIndicator.startAnimation(fadeOutAnimation);
                    }
                }
                switch (motionevent.getActionMasked())
                {
                default:
                    return false;

                case 0: // '\0'
                    if (type == 1 || type == 3)
                    {
                        scrollIndicator.startAnimation(fadeInAnimation);
                        scrollIndicator.setPadding(0, 0, getWidth(), 0);
                    } else
                    {
                        scrollIndicatorTextView.startAnimation(fadeInAnimation);
                    }
                    scroll(motionevent.getY());
                    isScrolling = true;
                    return true;

                case 2: // '\002'
                    scroll(motionevent.getY());
                    return true;

                case 1: // '\001'
                    break;
                }
                if (type == 3 || type == 2)
                {
                    handleBar.setSelected(false);
                }
                if (type == 1 || type == 3)
                {
                    scrollIndicator.startAnimation(fadeOutAnimation);
                } else
                {
                    scrollIndicatorTextView.startAnimation(fadeOutAnimation);
                }
                return true;
            }
        }
        return false;
    }

    protected void scroll(float f)
    {
        int i;
        int j;
        if (type == 1 || type == 3)
        {
            float f2 = f - (float)(scrollIndicator.getHeight() / 2);
            float f1;
            if (f2 < 0.0F)
            {
                f1 = 0.0F;
            } else
            {
                f1 = f2;
                if (f2 > (float)(getHeight() - scrollIndicator.getHeight()))
                {
                    f1 = getHeight() - scrollIndicator.getHeight();
                }
            }
            ViewHelper.setTranslationY(scrollIndicator, f1);
        }
        if (type == 3 || type == 2)
        {
            handleBar.setSelected(true);
            moveHandlebar(f - (float)(handleBar.getHeight() / 2));
        }
        j = (int)((f / (float)getHeight()) * (float)itemCount);
        if (listView instanceof ExpandableListView)
        {
            i = ExpandableListView.getPackedPositionGroup(((ExpandableListView)listView).getExpandableListPosition(j));
            if (i != -1)
            {
                groupPosition = i;
            }
        }
        if (j < 0)
        {
            i = 0;
        } else
        {
            i = j;
            if (j >= itemCount)
            {
                i = itemCount - 1;
            }
        }
        scrollIndicatorTextView.setText(scrollable.getIndicatorForPosition(i, groupPosition));
        listView.setSelection(scrollable.getScrollPosition(i, groupPosition));
    }

    public void setFadeDuration(long l)
    {
        fadeInAnimation.setDuration(l);
        fadeOutAnimation.setDuration(l);
    }

    public void setFixedSize(int i)
    {
        scrollIndicatorTextView.setEms(i);
    }

    public void setHandlebarColor(int i, int j, int k)
    {
        StateListDrawable statelistdrawable;
label0:
        {
            if (type == 3 || type == 2)
            {
                float f = getResources().getDisplayMetrics().density;
                GradientDrawable gradientdrawable = new GradientDrawable();
                gradientdrawable.setCornerRadius(f);
                gradientdrawable.setColor(i);
                gradientdrawable.setStroke((int)(5F * f), 0);
                GradientDrawable gradientdrawable1 = new GradientDrawable();
                gradientdrawable1.setCornerRadius(f);
                gradientdrawable1.setColor(j);
                gradientdrawable1.setStroke((int)(5F * f), k);
                statelistdrawable = new StateListDrawable();
                statelistdrawable.addState(new int[] {
                    0x10100a1
                }, gradientdrawable1);
                statelistdrawable.addState(new int[] {
                    0x101009e
                }, gradientdrawable);
                if (android.os.Build.VERSION.SDK_INT >= 16)
                {
                    break label0;
                }
                handleBar.setBackgroundDrawable(statelistdrawable);
            }
            return;
        }
        handleBar.setBackground(statelistdrawable);
    }

    public void setIndicatorColor(int i, int j, int k)
    {
        if (type == 1 || type == 3)
        {
            ((Pin)scrollIndicator.findViewById(512)).setColor(j);
            scrollIndicatorTextView.setTextColor(k);
            scrollIndicatorTextView.setBackgroundColor(i);
        }
    }

    public void setPopupColor(int i, int j, int k, int l, float f)
    {
        GradientDrawable gradientdrawable = new GradientDrawable();
        gradientdrawable.setCornerRadius(getResources().getDisplayMetrics().density * f);
        gradientdrawable.setStroke((int)((float)k * getResources().getDisplayMetrics().density), j);
        gradientdrawable.setColor(i);
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            scrollIndicatorTextView.setBackgroundDrawable(gradientdrawable);
        } else
        {
            scrollIndicatorTextView.setBackground(gradientdrawable);
        }
        scrollIndicatorTextView.setTextColor(l);
    }

    public void setSize(int i, int j)
    {
        float f = getResources().getDisplayMetrics().density;
        scrollIndicatorTextView.getLayoutParams().width = (int)((float)i * f);
        scrollIndicatorTextView.getLayoutParams().height = (int)((float)j * f);
    }

    public void setTextPadding(int i, int j, int k, int l)
    {
        float f = getResources().getDisplayMetrics().density;
        scrollIndicatorTextView.setPadding((int)((float)i * f), (int)((float)j * f), (int)((float)l * f), (int)((float)k * f));
    }

    public void setTextSize(int i, float f)
    {
        scrollIndicatorTextView.setTextSize(i, f);
    }

}
