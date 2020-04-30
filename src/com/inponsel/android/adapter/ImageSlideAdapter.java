// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.inponsel.android.bean.Product;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;

public class ImageSlideAdapter extends PagerAdapter
{

    FragmentActivity activity;
    List products;

    public ImageSlideAdapter(FragmentActivity fragmentactivity, List list)
    {
        activity = fragmentactivity;
        products = list;
    }

    public static int getBmapHeight(Context context)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int i = displaymetrics.heightPixels;
        int j = displaymetrics.widthPixels;
        int k = displaymetrics.densityDpi;
        float f;
        float f1;
        float f2;
        float f3;
        char c;
        if (k == 640)
        {
            c = '2';
        } else
        if (k == 480)
        {
            c = '2';
        } else
        if (k == 320)
        {
            c = '2';
        } else
        if (k == 240)
        {
            c = '+';
        } else
        if (k == 160)
        {
            c = '\036';
        } else
        if (k == 160 && (context.getResources().getConfiguration().screenLayout & 0xf) == 4)
        {
            c = '\202';
        } else
        if (k == 120)
        {
            c = '\025';
        } else
        {
            c = '\0';
        }
        Log.e("minheight", String.valueOf(c));
        if (k == 160 && (context.getResources().getConfiguration().screenLayout & 0xf) == 4)
        {
            f = 350F;
        } else
        {
            f = 625 - c;
        }
        f2 = (float)j / 1200F;
        f3 = (float)i / f;
        f1 = f2;
        if (f3 < f2)
        {
            f1 = f3;
        }
        return (int)(f * f1);
    }

    public static int getBmapWidth(Context context)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int i = displaymetrics.heightPixels;
        float f1 = (float)displaymetrics.widthPixels / 1200F;
        float f2 = (float)i / 625F;
        float f = f1;
        if (f2 < f1)
        {
            f = f2;
        }
        return (int)(1200F * f);
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public int getCount()
    {
        return products.size();
    }

    public View instantiateItem(ViewGroup viewgroup, int i)
    {
        View view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(0x7f030150, viewgroup, false);
        final Product product = (Product)products.get(i);
        final ImageView mImageView = (ImageView)view.findViewById(0x7f0b092f);
        ((TextView)view.findViewById(0x7f0b0930)).setText(product.getName());
        mImageView.setOnClickListener(new android.view.View.OnClickListener() {

            final ImageSlideAdapter this$0;
            private final Product val$product;

            public void onClick(View view1)
            {
                Log.e("judul", String.valueOf(product.getId()));
                view1 = new Intent();
                view1.setClass(activity, com/inponsel/android/rssfeeddetail/RSSDetailTab);
                view1.putExtra("id_rss", String.valueOf(product.getId()));
                view1.putExtra("rss_title", product.getName());
                view1.putExtra("notif", "gcm");
                view1.putExtra("actfrom", "rssfeed");
                view1.putExtra("act", "firsttab");
                activity.startActivityForResult(view1, 0);
                activity.overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$0 = ImageSlideAdapter.this;
                product = product1;
                super();
            }
        });
        product = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(product);
        int j = ((DisplayMetrics) (product)).widthPixels;
        try
        {
            Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(j).append("&src=").append(((Product)products.get(i)).getImageUrl()).toString()).into(mImageView, new Callback() {

                final ImageSlideAdapter this$0;
                private final ImageView val$mImageView;

                public void onError()
                {
                    mImageView.setImageResource(0x7f020209);
                }

                public void onSuccess()
                {
                }

            
            {
                this$0 = ImageSlideAdapter.this;
                mImageView = imageview;
                super();
            }
            });
        }
        catch (Exception exception) { }
        viewgroup.addView(view);
        return view;
    }

    public volatile Object instantiateItem(ViewGroup viewgroup, int i)
    {
        return instantiateItem(viewgroup, i);
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }
}
