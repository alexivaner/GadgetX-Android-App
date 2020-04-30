// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListView extends AdapterView
{
    private class GestureListener extends android.view.GestureDetector.SimpleOnGestureListener
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
            unpressTouchedChild();
            int i = getChildIndex((int)motionevent.getX(), (int)motionevent.getY());
            if (i >= 0 && !mBlockTouchAction)
            {
                motionevent = getChildAt(i);
                android.widget.AdapterView.OnItemLongClickListener onitemlongclicklistener = getOnItemLongClickListener();
                if (onitemlongclicklistener != null)
                {
                    i = mLeftViewAdapterIndex + i;
                    if (onitemlongclicklistener.onItemLongClick(HorizontalListView.this, motionevent, i, mAdapter.getItemId(i)))
                    {
                        performHapticFeedback(0);
                    }
                }
            }
        }

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            requestParentListViewToNotInterceptTouchEvents(Boolean.valueOf(true));
            setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_TOUCH_SCROLL);
            unpressTouchedChild();
            motionevent = HorizontalListView.this;
            motionevent.mNextX = ((HorizontalListView) (motionevent)).mNextX + (int)f;
            updateOverscrollAnimation(Math.round(f));
            requestLayout();
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionevent)
        {
            unpressTouchedChild();
            android.widget.AdapterView.OnItemClickListener onitemclicklistener = getOnItemClickListener();
            int i = getChildIndex((int)motionevent.getX(), (int)motionevent.getY());
            if (i >= 0 && !mBlockTouchAction)
            {
                motionevent = getChildAt(i);
                i = mLeftViewAdapterIndex + i;
                if (onitemclicklistener != null)
                {
                    onitemclicklistener.onItemClick(HorizontalListView.this, motionevent, i, mAdapter.getItemId(i));
                    return true;
                }
            }
            if (mOnClickListener != null && !mBlockTouchAction)
            {
                mOnClickListener.onClick(HorizontalListView.this);
            }
            return false;
        }

        private GestureListener()
        {
            this$0 = HorizontalListView.this;
            super();
        }

        GestureListener(GestureListener gesturelistener)
        {
            this();
        }
    }

    private static final class HoneycombPlus
    {

        public static void setFriction(Scroller scroller, float f)
        {
            if (scroller != null)
            {
                scroller.setFriction(f);
            }
        }

        static 
        {
            if (android.os.Build.VERSION.SDK_INT < 11)
            {
                throw new RuntimeException("Should not get to HoneycombPlus class unless sdk is >= 11!");
            }
        }

        private HoneycombPlus()
        {
        }
    }

    private static final class IceCreamSandwichPlus
    {

        public static float getCurrVelocity(Scroller scroller)
        {
            return scroller.getCurrVelocity();
        }

        static 
        {
            if (android.os.Build.VERSION.SDK_INT < 14)
            {
                throw new RuntimeException("Should not get to IceCreamSandwichPlus class unless sdk is >= 14!");
            }
        }

        private IceCreamSandwichPlus()
        {
        }
    }

    public static interface OnScrollStateChangedListener
    {

        public abstract void onScrollStateChanged(ScrollState scrollstate);
    }

    public static final class OnScrollStateChangedListener.ScrollState extends Enum
    {

        private static final OnScrollStateChangedListener.ScrollState ENUM$VALUES[];
        public static final OnScrollStateChangedListener.ScrollState SCROLL_STATE_FLING;
        public static final OnScrollStateChangedListener.ScrollState SCROLL_STATE_IDLE;
        public static final OnScrollStateChangedListener.ScrollState SCROLL_STATE_TOUCH_SCROLL;

        public static OnScrollStateChangedListener.ScrollState valueOf(String s)
        {
            return (OnScrollStateChangedListener.ScrollState)Enum.valueOf(com/inponsel/android/widget/HorizontalListView$OnScrollStateChangedListener$ScrollState, s);
        }

        public static OnScrollStateChangedListener.ScrollState[] values()
        {
            OnScrollStateChangedListener.ScrollState ascrollstate[] = ENUM$VALUES;
            int i = ascrollstate.length;
            OnScrollStateChangedListener.ScrollState ascrollstate1[] = new OnScrollStateChangedListener.ScrollState[i];
            System.arraycopy(ascrollstate, 0, ascrollstate1, 0, i);
            return ascrollstate1;
        }

        static 
        {
            SCROLL_STATE_IDLE = new OnScrollStateChangedListener.ScrollState("SCROLL_STATE_IDLE", 0);
            SCROLL_STATE_TOUCH_SCROLL = new OnScrollStateChangedListener.ScrollState("SCROLL_STATE_TOUCH_SCROLL", 1);
            SCROLL_STATE_FLING = new OnScrollStateChangedListener.ScrollState("SCROLL_STATE_FLING", 2);
            ENUM$VALUES = (new OnScrollStateChangedListener.ScrollState[] {
                SCROLL_STATE_IDLE, SCROLL_STATE_TOUCH_SCROLL, SCROLL_STATE_FLING
            });
        }

        private OnScrollStateChangedListener.ScrollState(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface RunningOutOfDataListener
    {

        public abstract void onRunningOutOfData();
    }


    private static final String BUNDLE_ID_CURRENT_X = "BUNDLE_ID_CURRENT_X";
    private static final String BUNDLE_ID_PARENT_STATE = "BUNDLE_ID_PARENT_STATE";
    private static final float FLING_DEFAULT_ABSORB_VELOCITY = 30F;
    private static final float FLING_FRICTION = 0.009F;
    private static final int INSERT_AT_END_OF_LIST = -1;
    private static final int INSERT_AT_START_OF_LIST = 0;
    protected ListAdapter mAdapter;
    private DataSetObserver mAdapterDataObserver;
    private boolean mBlockTouchAction;
    private OnScrollStateChangedListener.ScrollState mCurrentScrollState;
    protected int mCurrentX;
    private int mCurrentlySelectedAdapterIndex;
    private boolean mDataChanged;
    private Runnable mDelayedLayout;
    private int mDisplayOffset;
    private Drawable mDivider;
    private int mDividerWidth;
    private EdgeEffectCompat mEdgeGlowLeft;
    private EdgeEffectCompat mEdgeGlowRight;
    protected Scroller mFlingTracker;
    private GestureDetector mGestureDetector;
    private final GestureListener mGestureListener = new GestureListener(null);
    private boolean mHasNotifiedRunningLowOnData;
    private int mHeightMeasureSpec;
    private boolean mIsParentVerticiallyScrollableViewDisallowingInterceptTouchEvent;
    private int mLeftViewAdapterIndex;
    private int mMaxX;
    protected int mNextX;
    private android.view.View.OnClickListener mOnClickListener;
    private OnScrollStateChangedListener mOnScrollStateChangedListener;
    private Rect mRect;
    private List mRemovedViewsCache;
    private Integer mRestoreX;
    private int mRightViewAdapterIndex;
    private RunningOutOfDataListener mRunningOutOfDataListener;
    private int mRunningOutOfDataThreshold;
    private View mViewBeingTouched;

    public HorizontalListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFlingTracker = new Scroller(getContext());
        mRemovedViewsCache = new ArrayList();
        mDataChanged = false;
        mRect = new Rect();
        mViewBeingTouched = null;
        mDividerWidth = 0;
        mDivider = null;
        mRestoreX = null;
        mMaxX = 0x7fffffff;
        mRunningOutOfDataListener = null;
        mRunningOutOfDataThreshold = 0;
        mHasNotifiedRunningLowOnData = false;
        mOnScrollStateChangedListener = null;
        mCurrentScrollState = OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE;
        mBlockTouchAction = false;
        mIsParentVerticiallyScrollableViewDisallowingInterceptTouchEvent = false;
        mAdapterDataObserver = new DataSetObserver() {

            final HorizontalListView this$0;

            public void onChanged()
            {
                mDataChanged = true;
                mHasNotifiedRunningLowOnData = false;
                unpressTouchedChild();
                invalidate();
                requestLayout();
            }

            public void onInvalidated()
            {
                mHasNotifiedRunningLowOnData = false;
                unpressTouchedChild();
                reset();
                invalidate();
                requestLayout();
            }

            
            {
                this$0 = HorizontalListView.this;
                super();
            }
        };
        mDelayedLayout = new Runnable() {

            final HorizontalListView this$0;

            public void run()
            {
                requestLayout();
            }

            
            {
                this$0 = HorizontalListView.this;
                super();
            }
        };
        mEdgeGlowLeft = new EdgeEffectCompat(context);
        mEdgeGlowRight = new EdgeEffectCompat(context);
        mGestureDetector = new GestureDetector(context, mGestureListener);
        bindGestureDetector();
        initView();
        retrieveXmlConfiguration(context, attributeset);
        setWillNotDraw(false);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            HoneycombPlus.setFriction(mFlingTracker, 0.009F);
        }
    }

    private void addAndMeasureChild(View view, int i)
    {
        addViewInLayout(view, i, getLayoutParams(view), true);
        measureChild(view);
    }

    private void bindGestureDetector()
    {
        setOnTouchListener(new android.view.View.OnTouchListener() {

            final HorizontalListView this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return mGestureDetector.onTouchEvent(motionevent);
            }

            
            {
                this$0 = HorizontalListView.this;
                super();
            }
        });
    }

    private float determineFlingAbsorbVelocity()
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return IceCreamSandwichPlus.getCurrVelocity(mFlingTracker);
        } else
        {
            return 30F;
        }
    }

    private void determineIfLowOnData()
    {
        if (mRunningOutOfDataListener != null && mAdapter != null && mAdapter.getCount() - (mRightViewAdapterIndex + 1) < mRunningOutOfDataThreshold && !mHasNotifiedRunningLowOnData)
        {
            mHasNotifiedRunningLowOnData = true;
            mRunningOutOfDataListener.onRunningOutOfData();
        }
    }

    private boolean determineMaxX()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (isLastItemInAdapter(mRightViewAdapterIndex))
        {
            View view = getRightmostChild();
            flag = flag1;
            if (view != null)
            {
                int i = mMaxX;
                mMaxX = (mCurrentX + (view.getRight() - getPaddingLeft())) - getRenderWidth();
                if (mMaxX < 0)
                {
                    mMaxX = 0;
                }
                flag = flag1;
                if (mMaxX != i)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private void drawDivider(Canvas canvas, Rect rect)
    {
        if (mDivider != null)
        {
            mDivider.setBounds(rect);
            mDivider.draw(canvas);
        }
    }

    private void drawDividers(Canvas canvas)
    {
        int j = getChildCount();
        Rect rect = mRect;
        mRect.top = getPaddingTop();
        mRect.bottom = mRect.top + getRenderHeight();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            if (i != j - 1 || !isLastItemInAdapter(mRightViewAdapterIndex))
            {
                View view = getChildAt(i);
                rect.left = view.getRight();
                rect.right = view.getRight() + mDividerWidth;
                if (rect.left < getPaddingLeft())
                {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight())
                {
                    rect.right = getWidth() - getPaddingRight();
                }
                drawDivider(canvas, rect);
                if (i == 0 && view.getLeft() > getPaddingLeft())
                {
                    rect.left = getPaddingLeft();
                    rect.right = view.getLeft();
                    drawDivider(canvas, rect);
                }
            }
            i++;
        } while (true);
    }

    private void drawEdgeGlow(Canvas canvas)
    {
        if (mEdgeGlowLeft != null && !mEdgeGlowLeft.isFinished() && isEdgeGlowEnabled())
        {
            int i = canvas.save();
            int k = getHeight();
            canvas.rotate(-90F, 0.0F, 0.0F);
            canvas.translate(-k + getPaddingBottom(), 0.0F);
            mEdgeGlowLeft.setSize(getRenderHeight(), getRenderWidth());
            if (mEdgeGlowLeft.draw(canvas))
            {
                invalidate();
            }
            canvas.restoreToCount(i);
        } else
        if (mEdgeGlowRight != null && !mEdgeGlowRight.isFinished() && isEdgeGlowEnabled())
        {
            int j = canvas.save();
            int l = getWidth();
            canvas.rotate(90F, 0.0F, 0.0F);
            canvas.translate(getPaddingTop(), -l);
            mEdgeGlowRight.setSize(getRenderHeight(), getRenderWidth());
            if (mEdgeGlowRight.draw(canvas))
            {
                invalidate();
            }
            canvas.restoreToCount(j);
            return;
        }
    }

    private void fillList(int i)
    {
        int j = 0;
        View view = getRightmostChild();
        if (view != null)
        {
            j = view.getRight();
        }
        fillListRight(j, i);
        j = 0;
        view = getLeftmostChild();
        if (view != null)
        {
            j = view.getLeft();
        }
        fillListLeft(j, i);
    }

    private void fillListLeft(int i, int j)
    {
        do
        {
            if ((i + j) - mDividerWidth <= 0 || mLeftViewAdapterIndex < 1)
            {
                return;
            }
            mLeftViewAdapterIndex = mLeftViewAdapterIndex - 1;
            View view = mAdapter.getView(mLeftViewAdapterIndex, getRecycledView(mLeftViewAdapterIndex), this);
            addAndMeasureChild(view, 0);
            int k;
            int l;
            if (mLeftViewAdapterIndex == 0)
            {
                k = view.getMeasuredWidth();
            } else
            {
                k = mDividerWidth + view.getMeasuredWidth();
            }
            k = i - k;
            l = mDisplayOffset;
            if (k + j == 0)
            {
                i = view.getMeasuredWidth();
            } else
            {
                i = mDividerWidth + view.getMeasuredWidth();
            }
            mDisplayOffset = l - i;
            i = k;
        } while (true);
    }

    private void fillListRight(int i, int j)
    {
        do
        {
            if (i + j + mDividerWidth >= getWidth() || mRightViewAdapterIndex + 1 >= mAdapter.getCount())
            {
                return;
            }
            mRightViewAdapterIndex = mRightViewAdapterIndex + 1;
            if (mLeftViewAdapterIndex < 0)
            {
                mLeftViewAdapterIndex = mRightViewAdapterIndex;
            }
            View view = mAdapter.getView(mRightViewAdapterIndex, getRecycledView(mRightViewAdapterIndex), this);
            addAndMeasureChild(view, -1);
            int k;
            if (mRightViewAdapterIndex == 0)
            {
                k = 0;
            } else
            {
                k = mDividerWidth;
            }
            i += k + view.getMeasuredWidth();
            determineIfLowOnData();
        } while (true);
    }

    private View getChild(int i)
    {
        if (i >= mLeftViewAdapterIndex && i <= mRightViewAdapterIndex)
        {
            return getChildAt(i - mLeftViewAdapterIndex);
        } else
        {
            return null;
        }
    }

    private int getChildIndex(int i, int j)
    {
        int k;
        int i1;
        i1 = getChildCount();
        k = 0;
_L6:
        if (k < i1) goto _L2; else goto _L1
_L1:
        int l = -1;
_L4:
        return l;
_L2:
        getChildAt(k).getHitRect(mRect);
        l = k;
        if (mRect.contains(i, j)) goto _L4; else goto _L3
_L3:
        k++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private android.view.ViewGroup.LayoutParams getLayoutParams(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        view = layoutparams;
        if (layoutparams == null)
        {
            view = new android.view.ViewGroup.LayoutParams(-2, -1);
        }
        return view;
    }

    private View getLeftmostChild()
    {
        return getChildAt(0);
    }

    private View getRecycledView(int i)
    {
        i = mAdapter.getItemViewType(i);
        if (isItemViewTypeValid(i))
        {
            return (View)((Queue)mRemovedViewsCache.get(i)).poll();
        } else
        {
            return null;
        }
    }

    private int getRenderHeight()
    {
        return getHeight() - getPaddingTop() - getPaddingBottom();
    }

    private int getRenderWidth()
    {
        return getWidth() - getPaddingLeft() - getPaddingRight();
    }

    private View getRightmostChild()
    {
        return getChildAt(getChildCount() - 1);
    }

    private void initView()
    {
        mLeftViewAdapterIndex = -1;
        mRightViewAdapterIndex = -1;
        mDisplayOffset = 0;
        mCurrentX = 0;
        mNextX = 0;
        mMaxX = 0x7fffffff;
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
    }

    private void initializeRecycledViewCache(int i)
    {
        mRemovedViewsCache.clear();
        int j = 0;
        do
        {
            if (j >= i)
            {
                return;
            }
            mRemovedViewsCache.add(new LinkedList());
            j++;
        } while (true);
    }

    private boolean isEdgeGlowEnabled()
    {
        while (mAdapter == null || mAdapter.isEmpty() || mMaxX <= 0) 
        {
            return false;
        }
        return true;
    }

    private boolean isItemViewTypeValid(int i)
    {
        return i < mRemovedViewsCache.size();
    }

    private boolean isLastItemInAdapter(int i)
    {
        return i == mAdapter.getCount() - 1;
    }

    private void measureChild(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams(view);
        int j = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec, getPaddingTop() + getPaddingBottom(), layoutparams.height);
        int i;
        if (layoutparams.width > 0)
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.width, 0x40000000);
        } else
        {
            i = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(i, j);
    }

    private void positionChildren(int i)
    {
        int k = getChildCount();
        if (k <= 0) goto _L2; else goto _L1
_L1:
        int j;
        mDisplayOffset = mDisplayOffset + i;
        j = mDisplayOffset;
        i = 0;
_L5:
        if (i < k) goto _L3; else goto _L2
_L2:
        return;
_L3:
        View view = getChildAt(i);
        int l = j + getPaddingLeft();
        int i1 = getPaddingTop();
        view.layout(l, i1, l + view.getMeasuredWidth(), i1 + view.getMeasuredHeight());
        j += view.getMeasuredWidth() + mDividerWidth;
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void recycleView(int i, View view)
    {
        i = mAdapter.getItemViewType(i);
        if (isItemViewTypeValid(i))
        {
            ((Queue)mRemovedViewsCache.get(i)).offer(view);
        }
    }

    private void releaseEdgeGlow()
    {
        if (mEdgeGlowLeft != null)
        {
            mEdgeGlowLeft.onRelease();
        }
        if (mEdgeGlowRight != null)
        {
            mEdgeGlowRight.onRelease();
        }
    }

    private void removeNonVisibleChildren(int i)
    {
        View view = getLeftmostChild();
_L3:
        if (view != null && view.getRight() + i <= 0) goto _L2; else goto _L1
_L1:
        view = getRightmostChild();
_L4:
        if (view == null || view.getLeft() + i < getWidth())
        {
            return;
        }
        break MISSING_BLOCK_LABEL_116;
_L2:
        int k = mDisplayOffset;
        int j;
        if (isLastItemInAdapter(mLeftViewAdapterIndex))
        {
            j = view.getMeasuredWidth();
        } else
        {
            j = mDividerWidth + view.getMeasuredWidth();
        }
        mDisplayOffset = j + k;
        recycleView(mLeftViewAdapterIndex, view);
        removeViewInLayout(view);
        mLeftViewAdapterIndex = mLeftViewAdapterIndex + 1;
        view = getLeftmostChild();
          goto _L3
        recycleView(mRightViewAdapterIndex, view);
        removeViewInLayout(view);
        mRightViewAdapterIndex = mRightViewAdapterIndex - 1;
        view = getRightmostChild();
          goto _L4
    }

    private void requestParentListViewToNotInterceptTouchEvents(Boolean boolean1)
    {
        if (mIsParentVerticiallyScrollableViewDisallowingInterceptTouchEvent == boolean1.booleanValue()) goto _L2; else goto _L1
_L1:
        Object obj = this;
_L5:
        if (((View) (obj)).getParent() instanceof View) goto _L3; else goto _L2
_L2:
        return;
_L3:
        if ((((View) (obj)).getParent() instanceof ListView) || (((View) (obj)).getParent() instanceof ScrollView))
        {
            ((View) (obj)).getParent().requestDisallowInterceptTouchEvent(boolean1.booleanValue());
            mIsParentVerticiallyScrollableViewDisallowingInterceptTouchEvent = boolean1.booleanValue();
            return;
        }
        obj = (View)((View) (obj)).getParent();
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void reset()
    {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    private void retrieveXmlConfiguration(Context context, AttributeSet attributeset)
    {
        if (attributeset != null)
        {
            context = context.obtainStyledAttributes(attributeset, com.inponsel.android.R.styleable.HorizontalListView);
            attributeset = context.getDrawable(1);
            if (attributeset != null)
            {
                setDivider(attributeset);
            }
            int i = context.getDimensionPixelSize(3, 0);
            if (i != 0)
            {
                setDividerWidth(i);
            }
            context.recycle();
        }
    }

    private void setCurrentScrollState(OnScrollStateChangedListener.ScrollState scrollstate)
    {
        if (mCurrentScrollState != scrollstate && mOnScrollStateChangedListener != null)
        {
            mOnScrollStateChangedListener.onScrollStateChanged(scrollstate);
        }
        mCurrentScrollState = scrollstate;
    }

    private void unpressTouchedChild()
    {
        if (mViewBeingTouched != null)
        {
            mViewBeingTouched.setPressed(false);
            refreshDrawableState();
            mViewBeingTouched = null;
        }
    }

    private void updateOverscrollAnimation(int i)
    {
        if (mEdgeGlowLeft != null && mEdgeGlowRight != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j;
        j = mCurrentX + i;
        if (mFlingTracker == null || mFlingTracker.isFinished())
        {
            if (j >= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = Math.abs(i);
            mEdgeGlowLeft.onPull((float)i / (float)getRenderWidth());
            if (!mEdgeGlowRight.isFinished())
            {
                mEdgeGlowRight.onRelease();
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (j <= mMaxX) goto _L1; else goto _L3
_L3:
        i = Math.abs(i);
        mEdgeGlowRight.onPull((float)i / (float)getRenderWidth());
        if (!mEdgeGlowLeft.isFinished())
        {
            mEdgeGlowLeft.onRelease();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        drawEdgeGlow(canvas);
    }

    protected void dispatchSetPressed(boolean flag)
    {
    }

    public volatile Adapter getAdapter()
    {
        return getAdapter();
    }

    public ListAdapter getAdapter()
    {
        return mAdapter;
    }

    public int getFirstVisiblePosition()
    {
        return mLeftViewAdapterIndex;
    }

    public int getLastVisiblePosition()
    {
        return mRightViewAdapterIndex;
    }

    protected float getLeftFadingEdgeStrength()
    {
        int i = getHorizontalFadingEdgeLength();
        if (mCurrentX == 0)
        {
            return 0.0F;
        }
        if (mCurrentX < i)
        {
            return (float)mCurrentX / (float)i;
        } else
        {
            return 1.0F;
        }
    }

    protected float getRightFadingEdgeStrength()
    {
        int i = getHorizontalFadingEdgeLength();
        if (mCurrentX == mMaxX)
        {
            return 0.0F;
        }
        if (mMaxX - mCurrentX < i)
        {
            return (float)(mMaxX - mCurrentX) / (float)i;
        } else
        {
            return 1.0F;
        }
    }

    public View getSelectedView()
    {
        return getChild(mCurrentlySelectedAdapterIndex);
    }

    protected boolean onDown(MotionEvent motionevent)
    {
        boolean flag;
        if (mFlingTracker.isFinished())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        mBlockTouchAction = flag;
        mFlingTracker.forceFinished(true);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        unpressTouchedChild();
        if (!mBlockTouchAction)
        {
            int i = getChildIndex((int)motionevent.getX(), (int)motionevent.getY());
            if (i >= 0)
            {
                mViewBeingTouched = getChildAt(i);
                if (mViewBeingTouched != null)
                {
                    mViewBeingTouched.setPressed(true);
                    refreshDrawableState();
                }
            }
        }
        return true;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        drawDividers(canvas);
    }

    protected boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        mFlingTracker.fling(mNextX, 0, (int)(-f), 0, 0, mMaxX, 0, 0);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
        requestLayout();
        return true;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (mAdapter != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        invalidate();
        if (mDataChanged)
        {
            int i1 = mCurrentX;
            initView();
            removeAllViewsInLayout();
            mNextX = i1;
            mDataChanged = false;
        }
        if (mRestoreX != null)
        {
            mNextX = mRestoreX.intValue();
            mRestoreX = null;
        }
        if (mFlingTracker.computeScrollOffset())
        {
            mNextX = mFlingTracker.getCurrX();
        }
        if (mNextX >= 0) goto _L4; else goto _L3
_L3:
        mNextX = 0;
        if (mEdgeGlowLeft.isFinished())
        {
            mEdgeGlowLeft.onAbsorb((int)determineFlingAbsorbVelocity());
        }
        mFlingTracker.forceFinished(true);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
_L6:
        int j1 = mCurrentX - mNextX;
        removeNonVisibleChildren(j1);
        fillList(j1);
        positionChildren(j1);
        mCurrentX = mNextX;
        if (determineMaxX())
        {
            onLayout(flag, i, j, k, l);
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (mNextX > mMaxX)
        {
            mNextX = mMaxX;
            if (mEdgeGlowRight.isFinished())
            {
                mEdgeGlowRight.onAbsorb((int)determineFlingAbsorbVelocity());
            }
            mFlingTracker.forceFinished(true);
            setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (mFlingTracker.isFinished())
        {
            if (mCurrentScrollState == OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING)
            {
                setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
                return;
            }
        } else
        {
            ViewCompat.postOnAnimation(this, mDelayedLayout);
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        mHeightMeasureSpec = j;
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (parcelable instanceof Bundle)
        {
            parcelable = (Bundle)parcelable;
            mRestoreX = Integer.valueOf(parcelable.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(parcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
    }

    public Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", mCurrentX);
        return bundle;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() != 1) goto _L2; else goto _L1
_L1:
        if (mFlingTracker == null || mFlingTracker.isFinished())
        {
            setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_IDLE);
        }
        requestParentListViewToNotInterceptTouchEvents(Boolean.valueOf(false));
        releaseEdgeGlow();
_L4:
        return super.onTouchEvent(motionevent);
_L2:
        if (motionevent.getAction() == 3)
        {
            unpressTouchedChild();
            releaseEdgeGlow();
            requestParentListViewToNotInterceptTouchEvents(Boolean.valueOf(false));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void scrollTo(int i)
    {
        mFlingTracker.startScroll(mNextX, 0, i - mNextX, 0);
        setCurrentScrollState(OnScrollStateChangedListener.ScrollState.SCROLL_STATE_FLING);
        requestLayout();
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(mAdapterDataObserver);
        }
        if (listadapter != null)
        {
            mHasNotifiedRunningLowOnData = false;
            mAdapter = listadapter;
            mAdapter.registerDataSetObserver(mAdapterDataObserver);
        }
        initializeRecycledViewCache(mAdapter.getViewTypeCount());
        reset();
    }

    public void setDivider(Drawable drawable)
    {
        mDivider = drawable;
        if (drawable != null)
        {
            setDividerWidth(drawable.getIntrinsicWidth());
            return;
        } else
        {
            setDividerWidth(0);
            return;
        }
    }

    public void setDividerWidth(int i)
    {
        mDividerWidth = i;
        requestLayout();
        invalidate();
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        mOnClickListener = onclicklistener;
    }

    public void setOnScrollStateChangedListener(OnScrollStateChangedListener onscrollstatechangedlistener)
    {
        mOnScrollStateChangedListener = onscrollstatechangedlistener;
    }

    public void setRunningOutOfDataListener(RunningOutOfDataListener runningoutofdatalistener, int i)
    {
        mRunningOutOfDataListener = runningoutofdatalistener;
        mRunningOutOfDataThreshold = i;
    }

    public void setSelection(int i)
    {
        mCurrentlySelectedAdapterIndex = i;
    }












}
