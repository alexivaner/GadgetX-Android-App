// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package eu.janmuller.android.simplecropimage:
//            ImageViewTouchBase, HighlightView, RotateBitmap, CropImage

class CropImageView extends ImageViewTouchBase
{

    private Context mContext;
    ArrayList mHighlightViews;
    float mLastX;
    float mLastY;
    int mMotionEdge;
    HighlightView mMotionHighlightView;

    public CropImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mHighlightViews = new ArrayList();
        mMotionHighlightView = null;
        mContext = context;
    }

    private void centerBasedOnHighlightView(HighlightView highlightview)
    {
        Rect rect = highlightview.mDrawRect;
        float f = rect.width();
        float f1 = rect.height();
        float f2 = getWidth();
        float f3 = getHeight();
        f = Math.max(1.0F, Math.min((f2 / f) * 0.6F, (f3 / f1) * 0.6F) * getScale());
        if ((double)(Math.abs(f - getScale()) / f) > 0.10000000000000001D)
        {
            float af[] = new float[2];
            af[0] = highlightview.mCropRect.centerX();
            af[1] = highlightview.mCropRect.centerY();
            getImageMatrix().mapPoints(af);
            zoomTo(f, af[0], af[1], 300F);
        }
        ensureVisible(highlightview);
    }

    private void ensureVisible(HighlightView highlightview)
    {
        highlightview = highlightview.mDrawRect;
        int i = Math.max(0, mLeft - ((Rect) (highlightview)).left);
        int l = Math.min(0, mRight - ((Rect) (highlightview)).right);
        int j = Math.max(0, mTop - ((Rect) (highlightview)).top);
        int k = Math.min(0, mBottom - ((Rect) (highlightview)).bottom);
        if (i == 0)
        {
            i = l;
        }
        if (j == 0)
        {
            j = k;
        }
        if (i != 0 || j != 0)
        {
            panBy(i, j);
        }
    }

    private void recomputeFocus(MotionEvent motionevent)
    {
        int i = 0;
_L3:
        if (i < mHighlightViews.size()) goto _L2; else goto _L1
_L1:
        i = 0;
_L4:
        HighlightView highlightview;
        if (i < mHighlightViews.size())
        {
label0:
            {
                HighlightView highlightview1 = (HighlightView)mHighlightViews.get(i);
                if (highlightview1.getHit(motionevent.getX(), motionevent.getY()) == 1)
                {
                    break label0;
                }
                if (!highlightview1.hasFocus())
                {
                    highlightview1.setFocus(true);
                    highlightview1.invalidate();
                }
            }
        }
        invalidate();
        return;
_L2:
        highlightview = (HighlightView)mHighlightViews.get(i);
        highlightview.setFocus(false);
        highlightview.invalidate();
        i++;
          goto _L3
        i++;
          goto _L4
    }

    public void add(HighlightView highlightview)
    {
        mHighlightViews.add(highlightview);
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int i = 0;
        do
        {
            if (i >= mHighlightViews.size())
            {
                return;
            }
            ((HighlightView)mHighlightViews.get(i)).draw(canvas);
            i++;
        } while (true);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (mBitmapDisplayed.getBitmap() == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = mHighlightViews.iterator();
_L5:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        HighlightView highlightview = (HighlightView)iterator.next();
        highlightview.mMatrix.set(getImageMatrix());
        highlightview.invalidate();
        if (highlightview.mIsFocused)
        {
            centerBasedOnHighlightView(highlightview);
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        Object obj;
        obj = (CropImage)mContext;
        if (((CropImage) (obj)).mSaving)
        {
            return false;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 48
    //                   0 78
    //                   1 208
    //                   2 368;
           goto _L1 _L2 _L3 _L4
_L1:
        motionevent.getAction();
        JVM INSTR tableswitch 1 2: default 76
    //                   1 446
    //                   2 455;
           goto _L5 _L6 _L7
_L5:
        return true;
_L2:
        if (!((CropImage) (obj)).mWaitingToPick) goto _L9; else goto _L8
_L8:
        recomputeFocus(motionevent);
          goto _L1
_L9:
        int i = 0;
_L13:
        if (i >= mHighlightViews.size()) goto _L1; else goto _L10
_L10:
        int j;
        obj = (HighlightView)mHighlightViews.get(i);
        j = ((HighlightView) (obj)).getHit(motionevent.getX(), motionevent.getY());
        if (j == 1) goto _L12; else goto _L11
_L11:
        mMotionEdge = j;
        mMotionHighlightView = ((HighlightView) (obj));
        mLastX = motionevent.getX();
        mLastY = motionevent.getY();
        HighlightView highlightview = mMotionHighlightView;
        if (j == 32)
        {
            obj = HighlightView.ModifyMode.Move;
        } else
        {
            obj = HighlightView.ModifyMode.Grow;
        }
        highlightview.setMode(((HighlightView.ModifyMode) (obj)));
          goto _L1
_L12:
        i++;
          goto _L13
_L3:
        if (!((CropImage) (obj)).mWaitingToPick) goto _L15; else goto _L14
_L14:
        i = 0;
_L18:
        if (i < mHighlightViews.size()) goto _L17; else goto _L16
_L16:
        mMotionHighlightView = null;
          goto _L1
_L17:
        HighlightView highlightview1 = (HighlightView)mHighlightViews.get(i);
        if (highlightview1.hasFocus())
        {
            obj.mCrop = highlightview1;
            int k = 0;
            do
            {
                if (k >= mHighlightViews.size())
                {
                    centerBasedOnHighlightView(highlightview1);
                    ((CropImage)mContext).mWaitingToPick = false;
                    return true;
                }
                if (k != i)
                {
                    ((HighlightView)mHighlightViews.get(k)).setHidden(true);
                }
                k++;
            } while (true);
        }
        i++;
          goto _L18
_L15:
        if (mMotionHighlightView != null)
        {
            centerBasedOnHighlightView(mMotionHighlightView);
            mMotionHighlightView.setMode(HighlightView.ModifyMode.None);
        }
          goto _L16
_L4:
        if (((CropImage) (obj)).mWaitingToPick)
        {
            recomputeFocus(motionevent);
        } else
        if (mMotionHighlightView != null)
        {
            mMotionHighlightView.handleMotion(mMotionEdge, motionevent.getX() - mLastX, motionevent.getY() - mLastY);
            mLastX = motionevent.getX();
            mLastY = motionevent.getY();
            ensureVisible(mMotionHighlightView);
        }
          goto _L1
_L6:
        center(true, true);
          goto _L5
_L7:
        if (getScale() == 1.0F)
        {
            center(true, true);
        }
          goto _L5
    }

    protected void postTranslate(float f, float f1)
    {
        super.postTranslate(f, f1);
        int i = 0;
        do
        {
            if (i >= mHighlightViews.size())
            {
                return;
            }
            HighlightView highlightview = (HighlightView)mHighlightViews.get(i);
            highlightview.mMatrix.postTranslate(f, f1);
            highlightview.invalidate();
            i++;
        } while (true);
    }

    protected void zoomIn()
    {
        super.zoomIn();
        Iterator iterator = mHighlightViews.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            HighlightView highlightview = (HighlightView)iterator.next();
            highlightview.mMatrix.set(getImageMatrix());
            highlightview.invalidate();
        } while (true);
    }

    protected void zoomOut()
    {
        super.zoomOut();
        Iterator iterator = mHighlightViews.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            HighlightView highlightview = (HighlightView)iterator.next();
            highlightview.mMatrix.set(getImageMatrix());
            highlightview.invalidate();
        } while (true);
    }

    protected void zoomTo(float f, float f1, float f2)
    {
        super.zoomTo(f, f1, f2);
        Iterator iterator = mHighlightViews.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            HighlightView highlightview = (HighlightView)iterator.next();
            highlightview.mMatrix.set(getImageMatrix());
            highlightview.invalidate();
        } while (true);
    }
}
