// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.CircleProgressBar;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

// Referenced classes of package com.inponsel.android.adapter:
//            CustomNewsPagerAdapter

class val.btn_head_banner_refresh
    implements android.view.agerAdapter._cls2._cls1
{

    final val.btn_head_banner_refresh this$1;
    private final Button val$btn_head_banner_refresh;
    private final CircleProgressBar val$circle_progress_doodle;
    private final String val$id_rss;
    private final String val$imgUrl;
    private final ImageView val$mImageView;
    private final String val$rss_name;
    private final int val$scrwidth;

    public void onClick(View view)
    {
        CustomNewsPagerAdapter.access$0(_fld0, val$scrwidth, val$imgUrl, val$id_rss, val$rss_name, val$mImageView, val$circle_progress_doodle, val$btn_head_banner_refresh);
    }

    ageLoadingListener()
    {
        this$1 = final_ageloadinglistener;
        val$scrwidth = i;
        val$imgUrl = s;
        val$id_rss = s1;
        val$rss_name = s2;
        val$mImageView = imageview;
        val$circle_progress_doodle = circleprogressbar;
        val$btn_head_banner_refresh = Button.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/adapter/CustomNewsPagerAdapter$2

/* anonymous class */
    class CustomNewsPagerAdapter._cls2 extends SimpleImageLoadingListener
    {

        final CustomNewsPagerAdapter this$0;
        private final Button val$btn_head_banner_refresh;
        private final CircleProgressBar val$circle_progress_doodle;
        private final String val$id_rss;
        private final String val$imgUrl;
        private final ImageView val$mImageView;
        private final String val$rss_name;
        private final int val$scrwidth;

        public void onLoadingComplete(String s, View view, Bitmap bitmap)
        {
            FadeInBitmapDisplayer.animate(mImageView, 500);
            circle_progress_doodle.setVisibility(8);
            mImageView.setOnClickListener(new CustomNewsPagerAdapter._cls2._cls2());
        }

        public void onLoadingFailed(String s, View view, FailReason failreason)
        {
            circle_progress_doodle.setVisibility(8);
            btn_head_banner_refresh.setVisibility(0);
            btn_head_banner_refresh.setOnClickListener(btn_head_banner_refresh. new CustomNewsPagerAdapter._cls2._cls1());
        }

        public void onLoadingStarted(String s, View view)
        {
            circle_progress_doodle.setProgress(0.0F);
            btn_head_banner_refresh.setVisibility(8);
            circle_progress_doodle.setVisibility(0);
        }


            
            {
                this$0 = final_customnewspageradapter;
                circle_progress_doodle = circleprogressbar;
                btn_head_banner_refresh = button;
                mImageView = imageview;
                scrwidth = i;
                imgUrl = s;
                id_rss = s1;
                rss_name = String.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/adapter/CustomNewsPagerAdapter$2$2

/* anonymous class */
        class CustomNewsPagerAdapter._cls2._cls2
            implements android.view.View.OnClickListener
        {

            final CustomNewsPagerAdapter._cls2 this$1;
            private final String val$id_rss;
            private final String val$rss_name;

            public void onClick(View view)
            {
                Log.e("judul", String.valueOf(id_rss));
                view = new Intent();
                view.setClass(activity, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                view.putExtra("id_rss", String.valueOf(id_rss));
                view.putExtra("rss_title", rss_name);
                view.putExtra("notif", "gcm");
                view.putExtra("actfrom", "rssfeed");
                view.putExtra("act", "firsttab");
                activity.startActivityForResult(view, 0);
                activity.overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = CustomNewsPagerAdapter._cls2.this;
                        id_rss = s;
                        rss_name = s1;
                        super();
                    }
        }

    }

}
