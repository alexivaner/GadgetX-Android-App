// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.widget;

import android.graphics.Bitmap;
import com.squareup.picasso.Transformation;

// Referenced classes of package com.inponsel.android.widget:
//            RoundedTransformationBuilder, RoundedDrawable

class this._cls0
    implements Transformation
{

    final RoundedTransformationBuilder this$0;

    public String key()
    {
        return (new StringBuilder("r:")).append(RoundedTransformationBuilder.access$1(RoundedTransformationBuilder.this)).append("b:").append(RoundedTransformationBuilder.access$2(RoundedTransformationBuilder.this)).append("c:").append(RoundedTransformationBuilder.access$3(RoundedTransformationBuilder.this)).append("o:").append(RoundedTransformationBuilder.access$4(RoundedTransformationBuilder.this)).toString();
    }

    public Bitmap transform(Bitmap bitmap)
    {
        Bitmap bitmap1 = RoundedDrawable.fromBitmap(bitmap).setScaleType(RoundedTransformationBuilder.access$0(RoundedTransformationBuilder.this)).setCornerRadius(RoundedTransformationBuilder.access$1(RoundedTransformationBuilder.this)).setBorderWidth(RoundedTransformationBuilder.access$2(RoundedTransformationBuilder.this)).setBorderColor(RoundedTransformationBuilder.access$3(RoundedTransformationBuilder.this)).setOval(RoundedTransformationBuilder.access$4(RoundedTransformationBuilder.this)).toBitmap();
        if (!bitmap.equals(bitmap1))
        {
            bitmap.recycle();
        }
        return bitmap1;
    }

    ()
    {
        this$0 = RoundedTransformationBuilder.this;
        super();
    }
}
