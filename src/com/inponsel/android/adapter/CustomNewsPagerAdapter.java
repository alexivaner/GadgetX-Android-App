// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.AutoScrollViewPager;
import com.inponsel.android.widget.CircleProgressBar;
import com.nirhart.parallaxscroll.views.ParallaxScrollView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.adapter:
//            ListModel

public class CustomNewsPagerAdapter extends PagerAdapter
{

    Activity activity;
    float final_height;
    float final_width;
    private ArrayList lm;
    LayoutInflater mLayoutInflater;
    DisplayImageOptions optionsDoodle;
    ProgressBar progressbar_headline;
    String str_doodle_height;
    String str_doodle_width;
    ParallaxScrollView sv_root;
    AutoScrollViewPager view_pager_head_news;

    public CustomNewsPagerAdapter(Activity activity1, ArrayList arraylist, AutoScrollViewPager autoscrollviewpager, ParallaxScrollView parallaxscrollview, ProgressBar progressbar)
    {
        str_doodle_width = "1024";
        str_doodle_height = "600";
        mLayoutInflater = (LayoutInflater)activity1.getSystemService("layout_inflater");
        lm = arraylist;
        activity = activity1;
        view_pager_head_news = autoscrollviewpager;
        sv_root = parallaxscrollview;
        progressbar_headline = progressbar;
        optionsDoodle = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageOnLoading(0x7f02033f).showImageForEmptyUri(0x7f020209).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
    }

    private void load_image_doodle(final int scrwidth, final String imgUrl, final String id_rss, final String rss_name, final ImageView mImageView, final CircleProgressBar circle_progress_doodle, final Button btn_head_banner_refresh)
    {
        try
        {
            ImageLoader.getInstance().displayImage((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(scrwidth).append("&src=").append(imgUrl).toString(), mImageView, optionsDoodle, new SimpleImageLoadingListener() {

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
                    mImageView.setOnClickListener(rss_name. new android.view.View.OnClickListener() {

                        final _cls2 this$1;
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
                this$1 = final__pcls2;
                id_rss = s;
                rss_name = String.this;
                super();
            }
                    });
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    circle_progress_doodle.setVisibility(8);
                    btn_head_banner_refresh.setVisibility(0);
                    btn_head_banner_refresh.setOnClickListener(btn_head_banner_refresh. new android.view.View.OnClickListener() {

                        final _cls2 this$1;
                        private final Button val$btn_head_banner_refresh;
                        private final CircleProgressBar val$circle_progress_doodle;
                        private final String val$id_rss;
                        private final String val$imgUrl;
                        private final ImageView val$mImageView;
                        private final String val$rss_name;
                        private final int val$scrwidth;

                        public void onClick(View view)
                        {
                            load_image_doodle(scrwidth, imgUrl, id_rss, rss_name, mImageView, circle_progress_doodle, btn_head_banner_refresh);
                        }

            
            {
                this$1 = final__pcls2;
                scrwidth = i;
                imgUrl = s;
                id_rss = s1;
                rss_name = s2;
                mImageView = imageview;
                circle_progress_doodle = circleprogressbar;
                btn_head_banner_refresh = Button.this;
                super();
            }
                    });
                }

                public void onLoadingStarted(String s, View view)
                {
                    circle_progress_doodle.setProgress(0.0F);
                    btn_head_banner_refresh.setVisibility(8);
                    circle_progress_doodle.setVisibility(0);
                }


            
            {
                this$0 = CustomNewsPagerAdapter.this;
                circle_progress_doodle = circleprogressbar;
                btn_head_banner_refresh = button;
                mImageView = imageview;
                scrwidth = i;
                imgUrl = s;
                id_rss = s1;
                rss_name = s2;
                super();
            }
            }, new ImageLoadingProgressListener() {

                final CustomNewsPagerAdapter this$0;
                private final CircleProgressBar val$circle_progress_doodle;

                public void onProgressUpdate(String s, View view, int i, int j)
                {
                    circle_progress_doodle.setProgress(Math.round((100F * (float)i) / (float)j));
                }

            
            {
                this$0 = CustomNewsPagerAdapter.this;
                circle_progress_doodle = circleprogressbar;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final String imgUrl)
        {
            imgUrl.printStackTrace();
        }
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((LinearLayout)obj);
    }

    public int getCount()
    {
        return lm.size();
    }

    public ListModel getListModel(int i)
    {
        return (ListModel)lm.get(i);
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        View view = mLayoutInflater.inflate(0x7f030150, viewgroup, false);
        ListModel listmodel = (ListModel)lm.get(i);
        ImageView imageview = (ImageView)view.findViewById(0x7f0b092f);
        Object obj = (TextView)view.findViewById(0x7f0b0930);
        CircleProgressBar circleprogressbar = (CircleProgressBar)view.findViewById(0x7f0b08a1);
        Button button = (Button)view.findViewById(0x7f0b08a0);
        ((TextView) (obj)).setText(listmodel.getName());
        imageview.setOnTouchListener(new android.view.View.OnTouchListener() {

            int downX;
            int downY;
            int dragthreshold;
            final CustomNewsPagerAdapter this$0;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                Log.e("ontouch", "ontouch");
                motionevent.getAction();
                JVM INSTR tableswitch 0 3: default 40
            //                           0 42
            //                           1 188
            //                           2 62
            //                           3 222;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                return false;
_L2:
                downX = (int)motionevent.getRawX();
                downY = (int)motionevent.getRawY();
                return false;
_L4:
                int j = Math.abs((int)motionevent.getRawX() - downX);
                int k = Math.abs((int)motionevent.getRawY() - downY);
                if (k > j && k > dragthreshold)
                {
                    view_pager_head_news.getParent().requestDisallowInterceptTouchEvent(false);
                    sv_root.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                if (j > k && j > dragthreshold)
                {
                    view_pager_head_news.getParent().requestDisallowInterceptTouchEvent(true);
                    sv_root.getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
                  goto _L1
_L3:
                sv_root.getParent().requestDisallowInterceptTouchEvent(false);
                view_pager_head_news.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
_L5:
                view_pager_head_news.startAutoScroll();
                return false;
            }

            
            {
                this$0 = CustomNewsPagerAdapter.this;
                super();
                dragthreshold = 30;
            }
        });
        obj = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        i = ((DisplayMetrics) (obj)).widthPixels;
        Log.e("scrwidth", String.valueOf(i));
        imageview.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(i, (int)Utility.convertDpToPixel(230F, activity)));
        progressbar_headline.setVisibility(8);
        circleprogressbar.setProgress(0.0F);
        circleprogressbar.setVisibility(8);
        load_image_doodle(i, listmodel.getImageUrl(), String.valueOf(listmodel.getId_rss()), listmodel.getName(), imageview, circleprogressbar, button);
        viewgroup.addView(view);
        return view;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == (RelativeLayout)obj;
    }

    public void setListArray(ArrayList arraylist)
    {
        lm = arraylist;
    }

}
