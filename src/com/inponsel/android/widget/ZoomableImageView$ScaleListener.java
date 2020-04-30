// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;

// Referenced classes of package com.inponsel.android.widget:
//            ZoomableImageView

private class <init> extends android.view.leGestureListener
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

    private er()
    {
        this$0 = ZoomableImageView.this;
        super();
    }

    er(er er)
    {
        this();
    }
}
