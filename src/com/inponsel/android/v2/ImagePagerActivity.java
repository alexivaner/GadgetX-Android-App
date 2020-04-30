// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.BaseImageActivity;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

public class ImagePagerActivity extends BaseImageActivity
{
    private class ImagePagerAdapter extends PagerAdapter
    {

        private String images[];
        private LayoutInflater inflater;
        final ImagePagerActivity this$0;

        public void destroyItem(View view, int i, Object obj)
        {
            ((ViewPager)view).removeView((View)obj);
        }

        public void finishUpdate(View view)
        {
        }

        public int getCount()
        {
            return images.length;
        }

        public Object instantiateItem(View view, int i)
        {
            View view1 = inflater.inflate(0x7f030058, null);
            ImageViewTouch imageviewtouch = (ImageViewTouch)view1.findViewById(0x7f0b007f);
            final ProgressBar spinner = (ProgressBar)view1.findViewById(0x7f0b02a5);
            imageviewtouch.setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
            imageLoader.displayImage(images[i], imageviewtouch, options, imageviewtouch. new ImageLoadingListener() {

                final ImagePagerAdapter this$1;
                private final ImageViewTouch val$imageView;
                private final ProgressBar val$spinner;

                public void onLoadingCancelled(String s, View view)
                {
                }

                public void onLoadingComplete(String s, View view, Bitmap bitmap)
                {
                    spinner.setVisibility(8);
                    s = AnimationUtils.loadAnimation(_fld0, 0x7f040009);
                    imageView.setAnimation(s);
                    s.start();
                }

                public void onLoadingFailed(String s, View view, FailReason failreason)
                {
                    Toast.makeText(_fld0, "Gagal memuat gambar", 0).show();
                    spinner.setVisibility(8);
                    imageView.setImageResource(0x108001d);
                }

                public void onLoadingStarted(String s, View view)
                {
                    spinner.setVisibility(0);
                }

            
            {
                this$1 = final_imagepageradapter;
                spinner = progressbar;
                imageView = ImageViewTouch.this;
                super();
            }
            });
            ((ViewPager)view).addView(view1, 0);
            return view1;
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            return view.equals(obj);
        }

        public void restoreState(Parcelable parcelable, ClassLoader classloader)
        {
        }

        public Parcelable saveState()
        {
            return null;
        }

        public void startUpdate(View view)
        {
        }


        ImagePagerAdapter(String as[])
        {
            this$0 = ImagePagerActivity.this;
            super();
            images = as;
            inflater = getLayoutInflater();
        }
    }


    ImageLoader imageLoader;
    private DisplayImageOptions options;
    private ViewPager pager;

    public ImagePagerActivity()
    {
    }

    public void onBackPressed()
    {
        Log.e("vis", "off");
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f030016);
        String as[];
        int i;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Gallery Ponsel Zoom");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        bundle = getIntent().getExtras();
        as = bundle.getStringArray("imgUrl");
        i = bundle.getInt("pos", 0);
        Log.e("img", as[i]);
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        options = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).showImageForEmptyUri(0x7f020208).cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY).bitmapConfig(android.graphics.Bitmap.Config.RGB_565).build();
        pager = (ViewPager)findViewById(0x7f0b0059);
        pager.setAdapter(new ImagePagerAdapter(as));
        pager.setCurrentItem(i);
        pager.setOffscreenPageLimit(3);
    }

}
