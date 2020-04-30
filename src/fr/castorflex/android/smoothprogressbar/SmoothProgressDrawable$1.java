// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.smoothprogressbar;

import android.os.SystemClock;

// Referenced classes of package fr.castorflex.android.smoothprogressbar:
//            SmoothProgressDrawable

class this._cls0
    implements Runnable
{

    final SmoothProgressDrawable this$0;

    public void run()
    {
        if (isFinishing())
        {
            SmoothProgressDrawable smoothprogressdrawable = SmoothProgressDrawable.this;
            SmoothProgressDrawable.access$2(smoothprogressdrawable, SmoothProgressDrawable.access$0(smoothprogressdrawable) + SmoothProgressDrawable.access$1(SmoothProgressDrawable.this) * 0.01F);
            smoothprogressdrawable = SmoothProgressDrawable.this;
            SmoothProgressDrawable.access$4(smoothprogressdrawable, SmoothProgressDrawable.access$3(smoothprogressdrawable) + SmoothProgressDrawable.access$1(SmoothProgressDrawable.this) * 0.01F);
            if (SmoothProgressDrawable.access$0(SmoothProgressDrawable.this) >= 1.0F)
            {
                stop();
            }
        } else
        if (isStarting())
        {
            SmoothProgressDrawable smoothprogressdrawable2 = SmoothProgressDrawable.this;
            SmoothProgressDrawable.access$4(smoothprogressdrawable2, SmoothProgressDrawable.access$3(smoothprogressdrawable2) + SmoothProgressDrawable.access$5(SmoothProgressDrawable.this) * 0.01F);
        } else
        {
            SmoothProgressDrawable smoothprogressdrawable3 = SmoothProgressDrawable.this;
            SmoothProgressDrawable.access$4(smoothprogressdrawable3, SmoothProgressDrawable.access$3(smoothprogressdrawable3) + SmoothProgressDrawable.access$6(SmoothProgressDrawable.this) * 0.01F);
        }
        if (SmoothProgressDrawable.access$3(SmoothProgressDrawable.this) >= SmoothProgressDrawable.access$7(SmoothProgressDrawable.this))
        {
            SmoothProgressDrawable.access$8(SmoothProgressDrawable.this, true);
            SmoothProgressDrawable smoothprogressdrawable1 = SmoothProgressDrawable.this;
            SmoothProgressDrawable.access$4(smoothprogressdrawable1, SmoothProgressDrawable.access$3(smoothprogressdrawable1) - SmoothProgressDrawable.access$7(SmoothProgressDrawable.this));
        }
        if (isRunning())
        {
            scheduleSelf(SmoothProgressDrawable.access$9(SmoothProgressDrawable.this), SystemClock.uptimeMillis() + 16L);
        }
        invalidateSelf();
    }

    ()
    {
        this$0 = SmoothProgressDrawable.this;
        super();
    }
}
