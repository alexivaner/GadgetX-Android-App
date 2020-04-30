// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.statistik.StatistikPonsel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.DaftarPonselMerkActivity;
import com.inponsel.android.v2.RSSFeedByTag;
import com.inponsel.android.v2.SCMerkActivity;
import com.inponsel.android.v2.TurunHargaPonselActivity;
import com.inponsel.android.widget.AutoScrollViewPager;
import com.inponsel.android.widget.CircleProgressBar;
import com.nirhart.parallaxscroll.views.ParallaxScrollView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.adapter:
//            ListModel

public class CustomPagerAdapter extends PagerAdapter
{

    Activity activity;
    float final_height;
    float final_width;
    private ArrayList lm;
    LayoutInflater mLayoutInflater;
    DisplayImageOptions optionsDoodle;
    String str_doodle_height;
    String str_doodle_width;
    ParallaxScrollView sv_root;
    AutoScrollViewPager view_pager_ads;

    public CustomPagerAdapter(Activity activity1, ArrayList arraylist, AutoScrollViewPager autoscrollviewpager, ParallaxScrollView parallaxscrollview)
    {
        str_doodle_width = "1024";
        str_doodle_height = "600";
        mLayoutInflater = (LayoutInflater)activity1.getSystemService("layout_inflater");
        lm = arraylist;
        activity = activity1;
        view_pager_ads = autoscrollviewpager;
        sv_root = parallaxscrollview;
        optionsDoodle = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageOnLoading(0x7f02033f).showImageForEmptyUri(0x7f020209).cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
    }

    private void load_image_doodle(final int scrwidth, final String imgUrl, final ImageView mImageView, final CircleProgressBar circle_progress_doodle, final Button btn_head_banner_refresh)
    {
        try
        {
            ImageLoader.getInstance().displayImage((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(scrwidth).append("&src=").append(imgUrl).toString(), mImageView, optionsDoodle, new SimpleImageLoadingListener() {

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
                    btn_head_banner_refresh.setOnClickListener(btn_head_banner_refresh. new android.view.View.OnClickListener() {

                        final _cls5 this$1;
                        private final Button val$btn_head_banner_refresh;
                        private final CircleProgressBar val$circle_progress_doodle;
                        private final String val$imgUrl;
                        private final ImageView val$mImageView;
                        private final int val$scrwidth;

                        public void onClick(View view)
                        {
                            load_image_doodle(scrwidth, imgUrl, mImageView, circle_progress_doodle, btn_head_banner_refresh);
                        }

            
            {
                this$1 = final__pcls5;
                scrwidth = i;
                imgUrl = s;
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
                this$0 = CustomPagerAdapter.this;
                circle_progress_doodle = circleprogressbar;
                btn_head_banner_refresh = button;
                mImageView = imageview;
                scrwidth = i;
                imgUrl = s;
                super();
            }
            }, new ImageLoadingProgressListener() {

                final CustomPagerAdapter this$0;
                private final CircleProgressBar val$circle_progress_doodle;

                public void onProgressUpdate(String s, View view, int i, int j)
                {
                    circle_progress_doodle.setProgress(Math.round((100F * (float)i) / (float)j));
                }

            
            {
                this$0 = CustomPagerAdapter.this;
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
        viewgroup.removeView((RelativeLayout)obj);
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
        final Object lms;
        final Object img_icon_ads;
        View view = mLayoutInflater.inflate(0x7f030136, viewgroup, false);
        lms = (ListModel)lm.get(i);
        ImageView imageview = (ImageView)view.findViewById(0x7f0b08f2);
        img_icon_ads = (ImageView)view.findViewById(0x7f0b08f4);
        Object obj1 = (ImageView)view.findViewById(0x7f0b08f8);
        Object obj2 = (RelativeLayout)view.findViewById(0x7f0b08f3);
        Object obj = (RelativeLayout)view.findViewById(0x7f0b08f1);
        TextView textview = (TextView)view.findViewById(0x7f0b08f6);
        textview.setTextColor(Color.parseColor(((ListModel) (lms)).getAds_title_color()));
        TextView textview1 = (TextView)view.findViewById(0x7f0b08f7);
        textview1.setTextColor(Color.parseColor(((ListModel) (lms)).getAds_campaign_color()));
        ((RelativeLayout) (obj2)).setBackgroundColor(Color.parseColor(((ListModel) (lms)).getAds_back_color()));
        Button button = (Button)view.findViewById(0x7f0b08f5);
        float f;
        float f1;
        float f2;
        if (((ListModel) (lms)).getAds_btn_text_action().equals(""))
        {
            button.setVisibility(8);
            ((ImageView) (obj1)).setVisibility(8);
        } else
        {
            button.setText(((ListModel) (lms)).getAds_btn_text_action());
            button.setTextColor(Color.parseColor(((ListModel) (lms)).getAds_btn_text_color()));
        }
        textview.setText(((ListModel) (lms)).getAds_title());
        textview1.setText(((ListModel) (lms)).getAds_campaign());
        Log.e("lms.getAds_title()", ((ListModel) (lms)).getAds_title());
        if (((ListModel) (lms)).getAds_title().equals("") && ((ListModel) (lms)).getAds_campaign().equals(""))
        {
            ((RelativeLayout) (obj2)).setVisibility(8);
        } else
        if (((ListModel) (lms)).getAds_title().equals(""))
        {
            textview.setVisibility(8);
        } else
        if (((ListModel) (lms)).getAds_campaign().equals(""))
        {
            textview1.setVisibility(8);
        }
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final CustomPagerAdapter this$0;

            public void onClick(View view1)
            {
            }

            
            {
                this$0 = CustomPagerAdapter.this;
                super();
            }
        });
        obj1 = ((WindowManager)activity.getSystemService("window")).getDefaultDisplay();
        obj2 = new DisplayMetrics();
        ((Display) (obj1)).getMetrics(((DisplayMetrics) (obj2)));
        i = ((DisplayMetrics) (obj2)).widthPixels;
        f1 = Utility.aspectratio(Integer.parseInt(str_doodle_width), Integer.parseInt(str_doodle_height));
        f = (float)Integer.parseInt(str_doodle_width) / f1;
        f1 = (float)Integer.parseInt(str_doodle_height) / f1;
        Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f))).append(" : ").append(f1).toString()));
        f2 = i;
        if (f > f1)
        {
            final_width = f2;
            final_height = Math.round((f2 * f1) / f);
            Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
        } else
        {
            final_width = Math.round((f2 * f1) / f);
            final_height = f2;
            Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(final_width))).append(" : ").append(final_height).toString()));
        }
        imageview.setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
        ((RelativeLayout) (obj)).setLayoutParams(new android.widget.RelativeLayout.LayoutParams((int)final_width, (int)final_height));
        imageview.setOnTouchListener(new android.view.View.OnTouchListener() {

            int downX;
            int downY;
            int dragthreshold;
            final CustomPagerAdapter this$0;

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
                    view_pager_ads.getParent().requestDisallowInterceptTouchEvent(false);
                    sv_root.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                if (j > k && j > dragthreshold)
                {
                    view_pager_ads.getParent().requestDisallowInterceptTouchEvent(true);
                    sv_root.getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
                  goto _L1
_L3:
                sv_root.getParent().requestDisallowInterceptTouchEvent(false);
                view_pager_ads.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
_L5:
                view_pager_ads.startAutoScroll();
                return false;
            }

            
            {
                this$0 = CustomPagerAdapter.this;
                super();
                dragthreshold = 30;
            }
        });
        imageview.setOnClickListener(new android.view.View.OnClickListener() {

            final CustomPagerAdapter this$0;
            private final ListModel val$lms;

            public void onClick(View view1)
            {
                Log.e("method", lms.getAds_link().toLowerCase());
                if (!lms.getAds_method().toLowerCase().contains("activity")) goto _L2; else goto _L1
_L1:
                if (!lms.getAds_link().toLowerCase().contains("pencarian/rinci")) goto _L4; else goto _L3
_L3:
                view1 = new Intent(activity, com/inponsel/android/v2/DaftarPonselMerkActivity);
                view1.putExtra("merk", "");
                view1.putExtra("titlemerek", lms.getAds_link());
                view1.putExtra("cover_img", lms.getAds_cover());
                activity.startActivityForResult(view1, 0);
                activity.overridePendingTransition(0x7f040003, 0x7f040004);
_L6:
                return;
_L4:
                if (lms.getAds_link().toLowerCase().contains("turun-harga"))
                {
                    view1 = new Intent(activity, com/inponsel/android/v2/TurunHargaPonselActivity);
                    activity.startActivityForResult(view1, 0);
                    activity.overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (lms.getAds_link().toLowerCase().contains("news_"))
                {
                    String as[] = lms.getAds_link().split("_");
                    view1 = as[1];
                    String s = as[2];
                    Intent intent2 = new Intent(activity, com/inponsel/android/v2/RSSFeedByTag);
                    intent2.putExtra("tag_code", "0");
                    intent2.putExtra("tag_key", view1);
                    intent2.putExtra("kategori_tag", s);
                    activity.startActivityForResult(intent2, 0);
                    activity.overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (lms.getAds_link().toLowerCase().contains("pencarian/service-center"))
                {
                    view1 = lms.getAds_link().split("vendor=")[1];
                    Intent intent = new Intent(activity, com/inponsel/android/v2/SCMerkActivity);
                    intent.putExtra("sc_id_merk", view1);
                    activity.startActivityForResult(intent, 0);
                    activity.overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (lms.getAds_link().toLowerCase().contains("statistikhp"))
                {
                    view1 = lms.getAds_link().split("statistikhp_")[1];
                    Intent intent1 = new Intent(activity, com/inponsel/android/statistik/StatistikPonsel);
                    intent1.putExtra("pager_pos", view1);
                    activity.startActivityForResult(intent1, 0);
                    activity.overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (lms.getAds_method().toLowerCase().contains("download"))
                {
                    view1 = lms.getAds_link().split("details?id=")[1];
                    try
                    {
                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(view1).toString())));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view1)
                    {
                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(lms.getAds_link())));
                    }
                    return;
                }
                if (lms.getAds_method().toLowerCase().contains("email"))
                {
                    view1 = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", lms.getAds_link(), null));
                    view1.putExtra("android.intent.extra.SUBJECT", "");
                    view1.putExtra("android.intent.extra.TEXT", "");
                    activity.startActivity(Intent.createChooser(view1, "Send email..."));
                    return;
                }
                if (lms.getAds_method().toLowerCase().contains("direct"))
                {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(lms.getAds_link())));
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                this$0 = CustomPagerAdapter.this;
                lms = listmodel;
                super();
            }
        });
        obj = ((ListModel) (lms)).getAds_cover();
        Log.e("url_cover", ((String) (obj)));
        if (!((ListModel) (lms)).getAds_icon().equals("")) goto _L2; else goto _L1
_L1:
        ((ImageView) (img_icon_ads)).setVisibility(8);
_L3:
        lms = (CircleProgressBar)view.findViewById(0x7f0b08a1);
        img_icon_ads = (Button)view.findViewById(0x7f0b08a0);
        load_image_doodle((int)final_width, ((String) (obj)), imageview, ((CircleProgressBar) (lms)), ((Button) (img_icon_ads)));
_L4:
        viewgroup.addView(view);
        return view;
_L2:
        Picasso.with(activity).load(((ListModel) (lms)).getAds_icon()).into(((ImageView) (img_icon_ads)), new Callback() {

            final CustomPagerAdapter this$0;
            private final ImageView val$img_icon_ads;

            public void onError()
            {
                img_icon_ads.setImageResource(0x7f020209);
            }

            public void onSuccess()
            {
            }

            
            {
                this$0 = CustomPagerAdapter.this;
                img_icon_ads = imageview;
                super();
            }
        });
          goto _L3
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L4
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
