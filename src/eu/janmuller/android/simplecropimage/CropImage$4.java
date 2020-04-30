// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package eu.janmuller.android.simplecropimage:
//            CropImage, CropImageView, Util, RotateBitmap

class this._cls0
    implements android.view.Listener
{

    final CropImage this$0;

    public void onClick(View view)
    {
        CropImage.access$0(CropImage.this).mHighlightViews.clear();
        CropImage.access$8(CropImage.this, Util.rotateImage(CropImage.access$1(CropImage.this), -90F));
        view = new RotateBitmap(CropImage.access$1(CropImage.this));
        CropImage.access$0(CropImage.this).setImageRotateBitmapResetBase(view, true);
        mRunFaceDetection.run();
    }

    ()
    {
        this$0 = CropImage.this;
        super();
    }
}
