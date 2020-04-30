// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.inponsel.android.utils.Log;

public class IndexScroller
{

    private static final int STATE_HIDDEN = 0;
    private static final int STATE_HIDING = 3;
    private static final int STATE_SHOWING = 1;
    private static final int STATE_SHOWN = 2;
    private float mAlphaRate;
    private int mCurrentSection;
    private float mDensity;
    private Handler mHandler;
    private float mIndexbarMargin;
    private RectF mIndexbarRect;
    private float mIndexbarWidth;
    private SectionIndexer mIndexer;
    private boolean mIsIndexing;
    private ListView mListView;
    private int mListViewHeight;
    private int mListViewWidth;
    private float mPreviewPadding;
    private float mScaledDensity;
    private String mSections[];
    private int mState;

    public IndexScroller(Context context, ListView listview)
    {
        mState = 0;
        mCurrentSection = -1;
        mIsIndexing = false;
        mListView = null;
        mIndexer = null;
        mSections = null;
        mHandler = new Handler() {

            final IndexScroller this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                switch (mState)
                {
                case 2: // '\002'
                default:
                    return;

                case 1: // '\001'
                    message = IndexScroller.this;
                    message.mAlphaRate = (float)((double)((IndexScroller) (message)).mAlphaRate + (double)(1.0F - mAlphaRate) * 0.20000000000000001D);
                    if ((double)mAlphaRate > 0.90000000000000002D)
                    {
                        mAlphaRate = 1.0F;
                        setState(2);
                    }
                    mListView.invalidate();
                    fade(10L);
                    return;

                case 3: // '\003'
                    message = IndexScroller.this;
                    message.mAlphaRate = (float)((double)((IndexScroller) (message)).mAlphaRate - (double)mAlphaRate * 0.20000000000000001D);
                    break;
                }
                if ((double)mAlphaRate < 0.10000000000000001D)
                {
                    mAlphaRate = 0.0F;
                }
                mListView.invalidate();
                fade(10L);
            }

            
            {
                this$0 = IndexScroller.this;
                super();
            }
        };
        mDensity = context.getResources().getDisplayMetrics().density;
        mScaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        mListView = listview;
        setAdapter(mListView.getAdapter());
        mIndexbarWidth = 20F * mDensity;
        mIndexbarMargin = 10F * mDensity;
        mPreviewPadding = 5F * mDensity;
        show();
    }

    private boolean contains(float f, float f1)
    {
        return f >= mIndexbarRect.left && f1 >= mIndexbarRect.top && f1 <= mIndexbarRect.top + mIndexbarRect.height();
    }

    private void fade(long l)
    {
        mHandler.removeMessages(0);
        mHandler.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + l);
    }

    private int getSectionByPoint(float f)
    {
        while (mSections == null || mSections.length == 0 || f < mIndexbarRect.top + mIndexbarMargin) 
        {
            return 0;
        }
        if (f >= (mIndexbarRect.top + mIndexbarRect.height()) - mIndexbarMargin)
        {
            return mSections.length - 1;
        } else
        {
            return (int)((f - mIndexbarRect.top - mIndexbarMargin) / ((mIndexbarRect.height() - 2.0F * mIndexbarMargin) / (float)mSections.length));
        }
    }

    private void setState(int i)
    {
        if (i < 0 || i > 3)
        {
            return;
        }
        mState = i;
        switch (mState)
        {
        default:
            return;

        case 0: // '\0'
            mHandler.removeMessages(0);
            return;

        case 1: // '\001'
            mAlphaRate = 0.0F;
            fade(0L);
            return;

        case 2: // '\002'
            mHandler.removeMessages(0);
            return;

        case 3: // '\003'
            mAlphaRate = 1.0F;
            break;
        }
        fade(3000L);
    }

    public void draw(Canvas canvas)
    {
        if (mState != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Paint paint = new Paint();
        paint.setColor(0xff000000);
        paint.setAlpha((int)(64F * mAlphaRate));
        paint.setAntiAlias(true);
        canvas.drawRoundRect(mIndexbarRect, 5F * mDensity, 5F * mDensity, paint);
        if (mSections != null && mSections.length > 0)
        {
            if (mCurrentSection >= 0)
            {
                Paint paint1 = new Paint();
                paint1.setColor(0xff000000);
                paint1.setAlpha(96);
                paint1.setAntiAlias(true);
                paint1.setShadowLayer(3F, 0.0F, 0.0F, Color.argb(64, 0, 0, 0));
                Paint paint3 = new Paint();
                paint3.setColor(-1);
                paint3.setAntiAlias(true);
                paint3.setTextSize(50F * mScaledDensity);
                float f = paint3.measureText(mSections[mCurrentSection]);
                float f2 = (2.0F * mPreviewPadding + paint3.descent()) - paint3.ascent();
                RectF rectf = new RectF(((float)mListViewWidth - f2) / 2.0F, ((float)mListViewHeight - f2) / 2.0F, ((float)mListViewWidth - f2) / 2.0F + f2, ((float)mListViewHeight - f2) / 2.0F + f2);
                canvas.drawRoundRect(rectf, 5F * mDensity, 5F * mDensity, paint1);
                canvas.drawText(mSections[mCurrentSection], (rectf.left + (f2 - f) / 2.0F) - 1.0F, ((rectf.top + mPreviewPadding) - paint3.ascent()) + 1.0F, paint3);
            }
            Paint paint2 = new Paint();
            paint2.setColor(-1);
            paint2.setAlpha((int)(255F * mAlphaRate));
            paint2.setAntiAlias(true);
            paint2.setTextSize(12F * mScaledDensity);
            float f1 = (mIndexbarRect.height() - 2.0F * mIndexbarMargin) / (float)mSections.length;
            float f3 = (f1 - (paint2.descent() - paint2.ascent())) / 2.0F;
            int i = 0;
            while (i < mSections.length) 
            {
                float f4 = (mIndexbarWidth - paint2.measureText(mSections[i])) / 2.0F;
                canvas.drawText(mSections[i], mIndexbarRect.left + f4, (mIndexbarRect.top + mIndexbarMargin + (float)i * f1 + f3) - paint2.ascent(), paint2);
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void hide()
    {
    }

    public void onSizeChanged(int i, int j, int k, int l)
    {
        mListViewWidth = i;
        mListViewHeight = j;
        mIndexbarRect = new RectF((float)i - mIndexbarMargin - mIndexbarWidth, mIndexbarMargin, (float)i - mIndexbarMargin, (float)j - mIndexbarMargin);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = true;
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 36
    //                   1 180
    //                   2 124;
           goto _L1 _L2 _L3 _L4
_L1:
        flag = false;
_L6:
        return flag;
_L2:
        if (mState != 0 && contains(motionevent.getX(), motionevent.getY()))
        {
            setState(2);
            mIsIndexing = true;
            mCurrentSection = getSectionByPoint(motionevent.getY());
            Log.e("CURR", (new StringBuilder()).append(mCurrentSection).toString());
            mListView.setSelection(mIndexer.getPositionForSection(mCurrentSection));
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!mIsIndexing)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!contains(motionevent.getX(), motionevent.getY())) goto _L6; else goto _L5
_L5:
        mCurrentSection = getSectionByPoint(motionevent.getY());
        mListView.setSelection(mIndexer.getPositionForSection(mCurrentSection));
        return true;
_L3:
        if (mIsIndexing)
        {
            mIsIndexing = false;
            mCurrentSection = -1;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void setAdapter(Adapter adapter)
    {
        if (adapter instanceof SectionIndexer)
        {
            mIndexer = (SectionIndexer)adapter;
            mSections = (String[])mIndexer.getSections();
        }
    }

    public void show()
    {
        if (mState == 0)
        {
            setState(1);
        }
    }






}
