// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom;

import android.os.Handler;
import it.sephiroth.android.library.imagezoom.easing.Easing;

// Referenced classes of package it.sephiroth.android.library.imagezoom:
//            ImageViewTouchBase

class val.destY
    implements Runnable
{

    final ImageViewTouchBase this$0;
    private final float val$deltaScale;
    private final float val$destX;
    private final float val$destY;
    private final float val$durationMs;
    private final float val$oldScale;
    private final long val$startTime;

    public void run()
    {
        long l = System.currentTimeMillis();
        float f = Math.min(val$durationMs, l - val$startTime);
        float f1 = (float)mEasing.easeInOut(f, 0.0D, val$deltaScale, val$durationMs);
        zoomTo(val$oldScale + f1, val$destX, val$destY);
        if (f < val$durationMs)
        {
            mHandler.post(this);
            return;
        } else
        {
            onZoomAnimationCompleted(getScale());
            center(true, true);
            return;
        }
    }

    A()
    {
        this$0 = final_imageviewtouchbase;
        val$durationMs = f;
        val$startTime = l;
        val$deltaScale = f1;
        val$oldScale = f2;
        val$destX = f3;
        val$destY = F.this;
        super();
    }
}
