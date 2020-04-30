// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.inponsel.android.widget.CircleProgressBar;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

// Referenced classes of package com.inponsel.android.adapter:
//            CustomPagerAdapter

class val.btn_head_banner_refresh
    implements android.view.agerAdapter._cls5._cls1
{

    final val.btn_head_banner_refresh this$1;
    private final Button val$btn_head_banner_refresh;
    private final CircleProgressBar val$circle_progress_doodle;
    private final String val$imgUrl;
    private final ImageView val$mImageView;
    private final int val$scrwidth;

    public void onClick(View view)
    {
        CustomPagerAdapter.access$0(_fld0, val$scrwidth, val$imgUrl, val$mImageView, val$circle_progress_doodle, val$btn_head_banner_refresh);
    }

    leImageLoadingListener()
    {
        this$1 = final_leimageloadinglistener;
        val$scrwidth = i;
        val$imgUrl = s;
        val$mImageView = imageview;
        val$circle_progress_doodle = circleprogressbar;
        val$btn_head_banner_refresh = Button.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/adapter/CustomPagerAdapter$5

/* anonymous class */
    class CustomPagerAdapter._cls5 extends SimpleImageLoadingListener
    {

        final CustomPagerAdapter this$0;
        private final Button val$btn_head_banner_refresh;
        private final CircleProgressBar val$circle_progress_doodle;
        private final String val$imgUrl;
        private final ImageView val$mImageView;
        private final int val$scrwidth;

        public void onLoadingComplete(String s, View view, Bitmap bitmap)
        {
            FadeInBitmapDisplayer.animate(mImageView, 500);
            circle_progress_doodle.setVisibility(8);
        }

        public void onLoadingFailed(String s, View view, FailReason failreason)
        {
            circle_progress_doodle.setVisibility(8);
            btn_head_banner_refresh.setVisibility(0);
            btn_head_banner_refresh.setOnClickListener(btn_head_banner_refresh. new CustomPagerAdapter._cls5._cls1());
        }

        public void onLoadingStarted(String s, View view)
        {
            circle_progress_doodle.setProgress(0.0F);
            btn_head_banner_refresh.setVisibility(8);
            circle_progress_doodle.setVisibility(0);
        }


            
            {
                this$0 = final_custompageradapter;
                circle_progress_doodle = circleprogressbar;
                btn_head_banner_refresh = button;
                mImageView = imageview;
                scrwidth = i;
                imgUrl = String.this;
                super();
            }
    }

}
