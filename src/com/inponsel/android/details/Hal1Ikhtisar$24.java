// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.animation.Animator;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar

class this._cls0
    implements android.animation.rListener
{

    final Hal1Ikhtisar this$0;

    public void onAnimationCancel(Animator animator)
    {
        Log.d("piefrag", "anim cancel");
    }

    public void onAnimationEnd(Animator animator)
    {
        Log.d("piefrag", "anim end");
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }
}
