// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

// Referenced classes of package com.inponsel.android.widget:
//            ZoomableImageView

class this._cls0
    implements android.view.
{

    final ZoomableImageView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        float f5;
        float f6;
        mScaleDetector.onTouchEvent(motionevent);
        matrix.getValues(m);
        f6 = m[2];
        f5 = m[5];
        view = new PointF(motionevent.getX(), motionevent.getY());
        motionevent.getAction();
        JVM INSTR tableswitch 0 6: default 112
    //                   0 135
    //                   1 649
    //                   2 227
    //                   3 112
    //                   4 112
    //                   5 181
    //                   6 722;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
        setImageMatrix(matrix);
        invalidate();
        return true;
_L2:
        last.set(motionevent.getX(), motionevent.getY());
        start.set(last);
        mode = 1;
        continue; /* Loop/switch isn't completed */
_L5:
        last.set(motionevent.getX(), motionevent.getY());
        start.set(last);
        mode = 2;
        continue; /* Loop/switch isn't completed */
_L4:
        float f;
        float f1;
        float f3;
        float f4;
        if (mode != 2 && (mode != 1 || saveScale <= minScale))
        {
            continue; /* Loop/switch isn't completed */
        }
        f3 = ((PointF) (view)).x - last.x;
        f4 = ((PointF) (view)).y - last.y;
        f = Math.round(origWidth * saveScale);
        f1 = Math.round(origHeight * saveScale);
        if (f >= width) goto _L8; else goto _L7
_L7:
        float f2 = 0.0F;
        if (f5 + f4 <= 0.0F) goto _L10; else goto _L9
_L9:
        f = -f5;
        f1 = f2;
_L15:
        matrix.postTranslate(f1, f);
        last.set(((PointF) (view)).x, ((PointF) (view)).y);
        continue; /* Loop/switch isn't completed */
_L10:
        f1 = f2;
        f = f4;
        if (f5 + f4 < -bottom)
        {
            f = -(bottom + f5);
            f1 = f2;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (f1 < height)
        {
            f2 = 0.0F;
            if (f6 + f3 > 0.0F)
            {
                f1 = -f6;
                f = f2;
            } else
            {
                f1 = f3;
                f = f2;
                if (f6 + f3 < -right)
                {
                    f1 = -(right + f6);
                    f = f2;
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        if (f6 + f3 <= 0.0F) goto _L12; else goto _L11
_L11:
        f2 = -f6;
_L14:
        if (f5 + f4 <= 0.0F)
        {
            break; /* Loop/switch isn't completed */
        }
        f = -f5;
        f1 = f2;
        continue; /* Loop/switch isn't completed */
_L12:
        f2 = f3;
        if (f6 + f3 < -right)
        {
            f2 = -(right + f6);
        }
        if (true) goto _L14; else goto _L13
_L13:
        f1 = f2;
        f = f4;
        if (f5 + f4 < -bottom)
        {
            f = -(bottom + f5);
            f1 = f2;
        }
        if (true) goto _L15; else goto _L3
_L3:
        mode = 0;
        int i = (int)Math.abs(((PointF) (view)).x - start.x);
        int j = (int)Math.abs(((PointF) (view)).y - start.y);
        if (i < 3 && j < 3)
        {
            performClick();
        }
        continue; /* Loop/switch isn't completed */
_L6:
        mode = 0;
        if (true) goto _L1; else goto _L16
_L16:
    }

    ()
    {
        this$0 = ZoomableImageView.this;
        super();
    }
}
