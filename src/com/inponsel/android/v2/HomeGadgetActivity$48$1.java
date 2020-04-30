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

class this._cls1
    implements android.view.ivity._cls48._cls1
{

    final is._cls0 this$1;

    public void onClick(View view)
    {
        HomeGadgetActivity.access$2(_fld0);
    }

    SimpleImageLoadingListener()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/HomeGadgetActivity$48

/* anonymous class */
    class HomeGadgetActivity._cls48 extends SimpleImageLoadingListener
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
            btn_head_banner_refresh.setOnClickListener(new HomeGadgetActivity._cls48._cls1());
        }

        public void onLoadingStarted(String s, View view)
        {
            circle_progress_doodle.setProgress(0.0F);
            circle_progress_doodle.setVisibility(0);
            btn_head_banner_refresh.setVisibility(8);
        }


            
            {
                this$0 = HomeGadgetActivity.this;
                super();
            }
    }

}
