// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

public class ZoomableImageView extends ImageView
{
    private class ScaleListener extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
    {

        final ZoomableImageView this$0;

        public boolean onScale(ScaleGestureDetector scalegesturedetector)
        {
            float f = scalegesturedetector.getScaleFactor();
            float f1 = saveScale;
            ZoomableImageView zoomableimageview = ZoomableImageView.this;
            zoomableimageview.saveScale = zoomableimageview.saveScale * f;
            if (saveScale > maxScale)
            {
                saveScale = maxScale;
                f = maxScale / f1;
            } else
            if (saveScale < minScale)
            {
                saveScale = minScale;
                f = minScale / f1;
            }
            right = width * saveScale - width - redundantXSpace * 2.0F * saveScale;
            bottom = height * saveScale - height - redundantYSpace * 2.0F * saveScale;
            if (origWidth * saveScale <= width || origHeight * saveScale <= height)
            {
                matrix.postScale(f, f, width / 2.0F, height / 2.0F);
                if (f < 1.0F)
                {
                    matrix.getValues(m);
                    f1 = m[2];
                    float f3 = m[5];
                    if (f < 1.0F)
                    {
                        if ((float)Math.round(origWidth * saveScale) < width)
                        {
                            if (f3 < -bottom)
                            {
                                matrix.postTranslate(0.0F, -(bottom + f3));
                            } else
                            if (f3 > 0.0F)
                            {
                                matrix.postTranslate(0.0F, -f3);
                            }
                        } else
                        if (f1 < -right)
                        {
                            matrix.postTranslate(-(right + f1), 0.0F);
                        } else
                        if (f1 > 0.0F)
                        {
                            matrix.postTranslate(-f1, 0.0F);
                        }
                    }
                }
            } else
            {
                matrix.postScale(f, f, scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
                matrix.getValues(m);
                float f2 = m[2];
                float f4 = m[5];
                if (f < 1.0F)
                {
                    if (f2 < -right)
                    {
                        matrix.postTranslate(-(right + f2), 0.0F);
                    } else
                    if (f2 > 0.0F)
                    {
                        matrix.postTranslate(-f2, 0.0F);
                    }
                    if (f4 < -bottom)
                    {
                        matrix.postTranslate(0.0F, -(bottom + f4));
                    } else
                    if (f4 > 0.0F)
                    {
                        matrix.postTranslate(0.0F, -f4);
                    }
                }
            }
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
        {
            mode = 2;
            return true;
        }

        private ScaleListener()
        {
            this$0 = ZoomableImageView.this;
            super();
        }

        ScaleListener(ScaleListener scalelistener)
        {
            this();
        }
    }


    static final int CLICK = 3;
    static final int DRAG = 1;
    static final int NONE = 0;
    static final int ZOOM = 2;
    float bmHeight;
    float bmWidth;
    float bottom;
    Context context;
    float height;
    PointF last;
    float m[];
    ScaleGestureDetector mScaleDetector;
    Matrix matrix;
    float maxScale;
    float minScale;
    int mode;
    float origHeight;
    float origWidth;
    float redundantXSpace;
    float redundantYSpace;
    float right;
    float saveScale;
    PointF start;
    float width;

    public ZoomableImageView(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        matrix = new Matrix();
        mode = 0;
        last = new PointF();
        start = new PointF();
        minScale = 1.0F;
        maxScale = 4F;
        saveScale = 1.0F;
        super.setClickable(true);
        context = context1;
        mScaleDetector = new ScaleGestureDetector(context1, new ScaleListener(null));
        matrix.setTranslate(1.0F, 1.0F);
        m = new float[9];
        setImageMatrix(matrix);
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        setOnTouchListener(new android.view.View.OnTouchListener() {

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
            //                           0 135
            //                           1 649
            //                           2 227
            //                           3 112
            //                           4 112
            //                           5 181
            //                           6 722;
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

            
            {
                this$0 = ZoomableImageView.this;
                super();
            }
        });
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        width = android.view.View.MeasureSpec.getSize(i);
        height = android.view.View.MeasureSpec.getSize(j);
        float f = Math.min(width / bmWidth, height / bmHeight);
        matrix.setScale(f, f);
        setImageMatrix(matrix);
        saveScale = 1.0F;
        redundantYSpace = height - bmHeight * f;
        redundantXSpace = width - bmWidth * f;
        redundantYSpace = redundantYSpace / 2.0F;
        redundantXSpace = redundantXSpace / 2.0F;
        matrix.postTranslate(redundantXSpace, redundantYSpace);
        origWidth = width - redundantXSpace * 2.0F;
        origHeight = height - redundantYSpace * 2.0F;
        right = width * saveScale - width - redundantXSpace * 2.0F * saveScale;
        bottom = height * saveScale - height - redundantYSpace * 2.0F * saveScale;
        setImageMatrix(matrix);
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        super.setImageBitmap(bitmap);
        bmWidth = bitmap.getWidth();
        bmHeight = bitmap.getHeight();
    }

    public void setMaxZoom(float f)
    {
        maxScale = f;
    }
}
