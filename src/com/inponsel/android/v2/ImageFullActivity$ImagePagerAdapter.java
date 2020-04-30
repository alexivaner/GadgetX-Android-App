// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.graphics.Bitmap;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

// Referenced classes of package com.inponsel.android.v2:
//            ImageFullActivity

private class inflater extends PagerAdapter
{

    private String images[];
    private LayoutInflater inflater;
    final ImageFullActivity this$0;

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
        final ImageViewTouch imageView = (ImageViewTouch)view1.findViewById(0x7f0b007f);
        final ProgressBar spinner = (ProgressBar)view1.findViewById(0x7f0b02a5);
        imageView.setDisplayType(it.sephiroth.android.library.imagezoom.O_SCREEN);
        imageLoader.displayImage(images[i], imageView, ImageFullActivity.access$0(ImageFullActivity.this), new ImageLoadingListener() {

            final ImageFullActivity.ImagePagerAdapter this$1;
            private final ImageViewTouch val$imageView;
            private final ProgressBar val$spinner;

            public void onLoadingCancelled(String s, View view2)
            {
            }

            public void onLoadingComplete(String s, View view2, Bitmap bitmap)
            {
                spinner.setVisibility(8);
                s = AnimationUtils.loadAnimation(this$0, 0x7f040009);
                imageView.setAnimation(s);
                s.start();
            }

            public void onLoadingFailed(String s, View view2, FailReason failreason)
            {
                Toast.makeText(this$0, "Gagal memuat gambar", 0).show();
                spinner.setVisibility(8);
                imageView.setImageResource(0x108001d);
            }

            public void onLoadingStarted(String s, View view2)
            {
                spinner.setVisibility(0);
            }

            
            {
                this$1 = ImageFullActivity.ImagePagerAdapter.this;
                spinner = progressbar;
                imageView = imageviewtouch;
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


    _cls1.val.imageView(String as[])
    {
        this$0 = ImageFullActivity.this;
        super();
        images = as;
        inflater = getLayoutInflater();
    }
}
