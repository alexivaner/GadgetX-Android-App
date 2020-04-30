// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

// Referenced classes of package it.sephiroth.android.library.imagezoom:
//            ImageViewTouchBase

class val.max_zoom
    implements Runnable
{

    final ImageViewTouchBase this$0;
    private final Drawable val$drawable;
    private final Matrix val$initial_matrix;
    private final float val$max_zoom;
    private final float val$min_zoom;

    public void run()
    {
        setImageDrawable(val$drawable, val$initial_matrix, val$min_zoom, val$max_zoom);
    }

    A()
    {
        this$0 = final_imageviewtouchbase;
        val$drawable = drawable1;
        val$initial_matrix = matrix;
        val$min_zoom = f;
        val$max_zoom = F.this;
        super();
    }
}
