// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

// Referenced classes of package com.inponsel.android.v2:
//            SCUserActivity

class ewHolder
    implements ImageLoadingListener
{

    final ewHolder.imageHp this$1;
    private final ewHolder val$holder;

    public void onLoadingCancelled(String s, View view)
    {
    }

    public void onLoadingComplete(String s, View view, Bitmap bitmap)
    {
        val$holder.progressbar_item.setVisibility(8);
        val$holder.imageHp.setVisibility(0);
    }

    public void onLoadingFailed(String s, View view, FailReason failreason)
    {
        val$holder.progressbar_item.setVisibility(8);
        val$holder.imageHp.setVisibility(0);
    }

    public void onLoadingStarted(String s, View view)
    {
        val$holder.progressbar_item.setVisibility(0);
        val$holder.imageHp.setVisibility(8);
    }

    ewHolder()
    {
        this$1 = final_ewholder;
        val$holder = ewHolder.this;
        super();
    }
}
