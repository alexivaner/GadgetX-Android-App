// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.FaceDetector;
import android.os.Handler;
import android.widget.Toast;
import java.util.ArrayList;

// Referenced classes of package eu.janmuller.android.simplecropimage:
//            CropImage, CropImageView, HighlightView

class this._cls1
    implements Runnable
{

    final keDefault this$1;

    public void run()
    {
        int i;
        CropImage cropimage = _fld0;
        boolean flag;
        if (umFaces > 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        cropimage.mWaitingToPick = flag;
        if (umFaces <= 0)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        i = 0;
_L3:
        if (i < umFaces) goto _L2; else goto _L1
_L1:
        CropImage.access$0(_fld0).invalidate();
        if (CropImage.access$0(_fld0).mHighlightViews.size() == 1)
        {
            mCrop = (HighlightView)CropImage.access$0(_fld0).mHighlightViews.get(0);
            mCrop.setFocus(true);
        }
        if (umFaces > 1)
        {
            Toast.makeText(_fld0, "Multi face crop help", 0).show();
        }
        return;
_L2:
        ndleFace(aces[i]);
        i++;
          goto _L3
        keDefault();
          goto _L1
    }

    aces()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class eu/janmuller/android/simplecropimage/CropImage$1

/* anonymous class */
    class CropImage._cls1
        implements Runnable
    {

        android.media.FaceDetector.Face mFaces[];
        Matrix mImageMatrix;
        int mNumFaces;
        float mScale;
        final CropImage this$0;

        private void handleFace(android.media.FaceDetector.Face face)
        {
            Object obj = new PointF();
            int i = (int)(face.eyesDistance() * mScale) * 2;
            face.getMidPoint(((PointF) (obj)));
            obj.x = ((PointF) (obj)).x * mScale;
            obj.y = ((PointF) (obj)).y * mScale;
            int j = (int)((PointF) (obj)).x;
            int k = (int)((PointF) (obj)).y;
            face = new HighlightView(CropImage.access$0(CropImage.this));
            obj = new Rect(0, 0, CropImage.access$1(CropImage.this).getWidth(), CropImage.access$1(CropImage.this).getHeight());
            RectF rectf = new RectF(j, k, j, k);
            rectf.inset(-i, -i);
            if (rectf.left < 0.0F)
            {
                rectf.inset(-rectf.left, -rectf.left);
            }
            if (rectf.top < 0.0F)
            {
                rectf.inset(-rectf.top, -rectf.top);
            }
            if (rectf.right > (float)((Rect) (obj)).right)
            {
                rectf.inset(rectf.right - (float)((Rect) (obj)).right, rectf.right - (float)((Rect) (obj)).right);
            }
            if (rectf.bottom > (float)((Rect) (obj)).bottom)
            {
                rectf.inset(rectf.bottom - (float)((Rect) (obj)).bottom, rectf.bottom - (float)((Rect) (obj)).bottom);
            }
            Matrix matrix = mImageMatrix;
            boolean flag1 = CropImage.access$2(CropImage.this);
            boolean flag;
            if (CropImage.access$3(CropImage.this) != 0 && CropImage.access$4(CropImage.this) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            face.setup(matrix, ((Rect) (obj)), rectf, flag1, flag);
            CropImage.access$0(CropImage.this).add(face);
        }

        private void makeDefault()
        {
            boolean flag1 = false;
            HighlightView highlightview = new HighlightView(CropImage.access$0(CropImage.this));
            int j1 = CropImage.access$1(CropImage.this).getWidth();
            int i1 = CropImage.access$1(CropImage.this).getHeight();
            Rect rect = new Rect(0, 0, j1, i1);
            int k = (Math.min(j1, i1) * 4) / 5;
            int l = k;
            int i = l;
            int j = k;
            if (CropImage.access$3(CropImage.this) != 0)
            {
                i = l;
                j = k;
                RectF rectf;
                Matrix matrix;
                boolean flag;
                boolean flag2;
                if (CropImage.access$4(CropImage.this) != 0)
                {
                    if (CropImage.access$3(CropImage.this) > CropImage.access$4(CropImage.this))
                    {
                        i = (CropImage.access$4(CropImage.this) * k) / CropImage.access$3(CropImage.this);
                        j = k;
                    } else
                    {
                        j = (CropImage.access$3(CropImage.this) * l) / CropImage.access$4(CropImage.this);
                        i = l;
                    }
                }
            }
            k = (j1 - j) / 2;
            l = (i1 - i) / 2;
            rectf = new RectF(k, l, k + j, l + i);
            matrix = mImageMatrix;
            flag2 = CropImage.access$2(CropImage.this);
            flag = flag1;
            if (CropImage.access$3(CropImage.this) != 0)
            {
                flag = flag1;
                if (CropImage.access$4(CropImage.this) != 0)
                {
                    flag = true;
                }
            }
            highlightview.setup(matrix, rect, rectf, flag2, flag);
            CropImage.access$0(CropImage.this).mHighlightViews.clear();
            CropImage.access$0(CropImage.this).add(highlightview);
        }

        private Bitmap prepareBitmap()
        {
            if (CropImage.access$1(CropImage.this) == null)
            {
                return null;
            }
            if (CropImage.access$1(CropImage.this).getWidth() > 256)
            {
                mScale = 256F / (float)CropImage.access$1(CropImage.this).getWidth();
            }
            Matrix matrix = new Matrix();
            matrix.setScale(mScale, mScale);
            return Bitmap.createBitmap(CropImage.access$1(CropImage.this), 0, 0, CropImage.access$1(CropImage.this).getWidth(), CropImage.access$1(CropImage.this).getHeight(), matrix, true);
        }

        public void run()
        {
            mImageMatrix = CropImage.access$0(CropImage.this).getImageMatrix();
            Bitmap bitmap = prepareBitmap();
            mScale = 1.0F / mScale;
            if (bitmap != null && CropImage.access$5(CropImage.this))
            {
                mNumFaces = (new FaceDetector(bitmap.getWidth(), bitmap.getHeight(), mFaces.length)).findFaces(bitmap, mFaces);
            }
            if (bitmap != null && bitmap != CropImage.access$1(CropImage.this))
            {
                bitmap.recycle();
            }
            CropImage.access$6(CropImage.this).post(new CropImage._cls1._cls1());
        }




            
            {
                this$0 = CropImage.this;
                super();
                mScale = 1.0F;
                mFaces = new android.media.FaceDetector.Face[3];
            }
    }

}
