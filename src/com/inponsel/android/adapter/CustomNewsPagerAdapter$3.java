// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.view.View;
import com.inponsel.android.widget.CircleProgressBar;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

// Referenced classes of package com.inponsel.android.adapter:
//            CustomNewsPagerAdapter

class val.circle_progress_doodle
    implements ImageLoadingProgressListener
{

    final CustomNewsPagerAdapter this$0;
    private final CircleProgressBar val$circle_progress_doodle;

    public void onProgressUpdate(String s, View view, int i, int j)
    {
        val$circle_progress_doodle.setProgress(Math.round((100F * (float)i) / (float)j));
    }

    oadingProgressListener()
    {
        this$0 = final_customnewspageradapter;
        val$circle_progress_doodle = CircleProgressBar.this;
        super();
    }
}
