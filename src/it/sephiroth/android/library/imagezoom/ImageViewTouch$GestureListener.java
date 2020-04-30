// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom;

import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

// Referenced classes of package it.sephiroth.android.library.imagezoom:
//            ImageViewTouch

public class this._cls0 extends android.view.Listener
{

    final ImageViewTouch this$0;

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        Log.i("ImageViewTouchBase", (new StringBuilder("onDoubleTap. double tap enabled? ")).append(mDoubleTapEnabled).toString());
        if (mDoubleTapEnabled)
        {
            mUserScaled = true;
            float f = getScale();
            f = onDoubleTapPost(f, getMaxScale());
            f = Math.min(getMaxScale(), Math.max(f, getMinScale()));
            zoomTo(f, motionevent.getX(), motionevent.getY(), 200F);
            invalidate();
        }
        if (ImageViewTouch.access$1(ImageViewTouch.this) != null)
        {
            ImageViewTouch.access$1(ImageViewTouch.this).onDoubleTap();
        }
        return super.onDoubleTap(motionevent);
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return ImageViewTouch.this.onDown(motionevent);
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        while (!mScrollEnabled || motionevent.getPointerCount() > 1 || motionevent1.getPointerCount() > 1 || mScaleDetector.isInProgress() || getScale() == 1.0F) 
        {
            return false;
        }
        return ImageViewTouch.this.onFling(motionevent, motionevent1, f, f1);
    }

    public void onLongPress(MotionEvent motionevent)
    {
        if (isLongClickable() && !mScaleDetector.isInProgress())
        {
            setPressed(true);
            performLongClick();
        }
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        while (!mScrollEnabled || motionevent == null || motionevent1 == null || motionevent.getPointerCount() > 1 || motionevent1.getPointerCount() > 1 || mScaleDetector.isInProgress()) 
        {
            return false;
        }
        return ImageViewTouch.this.onScroll(motionevent, motionevent1, f, f1);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        if (ImageViewTouch.access$0(ImageViewTouch.this) != null)
        {
            ImageViewTouch.access$0(ImageViewTouch.this).onSingleTapConfirmed();
        }
        return ImageViewTouch.this.onSingleTapConfirmed(motionevent);
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        return ImageViewTouch.this.onSingleTapUp(motionevent);
    }

    public SingleTapListener()
    {
        this$0 = ImageViewTouch.this;
        super();
    }
}
