// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

// Referenced classes of package com.inponsel.android.utils:
//            UrlImageGetter

public class this._cls0 extends BitmapDrawable
{

    protected Drawable drawable;
    final UrlImageGetter this$0;

    public void draw(Canvas canvas)
    {
        if (drawable != null)
        {
            drawable.draw(canvas);
        }
    }

    public ()
    {
        this$0 = UrlImageGetter.this;
        super();
    }
}
