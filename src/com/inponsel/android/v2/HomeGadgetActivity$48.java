// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import com.inponsel.android.widget.CircleProgressBar;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGadgetActivity

class r.SimpleImageLoadingListener extends SimpleImageLoadingListener
{

    final HomeGadgetActivity this$0;

    public void onLoadingComplete(String s, View view, Bitmap bitmap)
    {
        FadeInBitmapDisplayer.animate(img_head_banner, 500);
        circle_progress_doodle.setVisibility(8);
    }

    public void onLoadingFailed(String s, View view, FailReason failreason)
    {
        circle_progress_doodle.setVisibility(8);
        btn_head_banner_refresh.setVisibility(0);
        btn_head_banner_refresh.setOnClickListener(new android.view.View.OnClickListener() {

            final HomeGadgetActivity._cls48 this$1;

            public void onClick(View view1)
            {
                HomeGadgetActivity.access$2(this$0);
            }

            
            {
                this$1 = HomeGadgetActivity._cls48.this;
                super();
            }
        });
    }

    public void onLoadingStarted(String s, View view)
    {
        circle_progress_doodle.setProgress(0.0F);
        circle_progress_doodle.setVisibility(0);
        btn_head_banner_refresh.setVisibility(8);
    }


    _cls1.this._cls1()
    {
        this$0 = HomeGadgetActivity.this;
        super();
    }
}
