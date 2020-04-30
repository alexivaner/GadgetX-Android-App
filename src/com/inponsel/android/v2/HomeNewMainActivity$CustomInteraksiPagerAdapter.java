// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.AutoScrollViewPager;
import com.nirhart.parallaxscroll.views.ParallaxScrollView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity, KomentarPonsel

public class activity extends PagerAdapter
{

    Activity activity;
    float final_height;
    float final_width;
    private ArrayList lm;
    LayoutInflater mLayoutInflater;
    String str_doodle_height;
    String str_doodle_width;
    final HomeNewMainActivity this$0;

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
        View view = mLayoutInflater.inflate(0x7f030143, viewgroup, false);
        final ListModel lms = (ListModel)lm.get(i);
        Object obj = (RelativeLayout)view.findViewById(0x7f0b0910);
        final ImageView img_kom_picture = (ImageView)view.findViewById(0x7f0b054b);
        TextView textview = (TextView)view.findViewById(0x7f0b0419);
        TextView textview1 = (TextView)view.findViewById(0x7f0b0765);
        TextView textview2 = (TextView)view.findViewById(0x7f0b054c);
        TextView textview3 = (TextView)view.findViewById(0x7f0b054e);
        TextView textview4 = (TextView)view.findViewById(0x7f0b054d);
        textview.setTextColor(Color.parseColor("#ffffff"));
        textview3.setTextColor(Color.parseColor("#ffffff"));
        textview1.setTextColor(Color.parseColor("#ffffff"));
        textview2.setTextColor(Color.parseColor("#ffffff"));
        textview.setText(Html.fromHtml((new StringBuilder("<b>")).append(lms.getNama_komentar()).append("</b>").append(" mengomentari <b>").append(lms.getNamalengkap()).append("</b>").toString()));
        textview4.setText(lms.getId_hp());
        textview3.setText(Html.fromHtml(lms.getKomentarhp()));
        textview1.setText((new StringBuilder("Di ")).append(lms.getNamalengkap()).toString());
        textview2.setText(Utility.convertDate(lms.getTanggal_komentar()));
        ((RelativeLayout) (obj)).setOnTouchListener(new android.view.View.OnTouchListener() {

            int downX;
            int downY;
            int dragthreshold;
            final HomeNewMainActivity.CustomInteraksiPagerAdapter this$1;

            public boolean onTouch(View view1, MotionEvent motionevent)
            {
                Log.e("ontouch", "ontouch");
                motionevent.getAction();
                JVM INSTR tableswitch 0 3: default 40
            //                           0 42
            //                           1 200
            //                           2 62
            //                           3 240;
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
                    HomeNewMainActivity.access$3(this$0).getParent().requestDisallowInterceptTouchEvent(false);
                    sv_root.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                if (j > k && j > dragthreshold)
                {
                    HomeNewMainActivity.access$3(this$0).getParent().requestDisallowInterceptTouchEvent(true);
                    sv_root.getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
                  goto _L1
_L3:
                sv_root.getParent().requestDisallowInterceptTouchEvent(false);
                HomeNewMainActivity.access$3(this$0).getParent().requestDisallowInterceptTouchEvent(false);
                return false;
_L5:
                HomeNewMainActivity.access$3(this$0).startAutoScroll();
                return false;
            }

            
            {
                this$1 = HomeNewMainActivity.CustomInteraksiPagerAdapter.this;
                super();
                dragthreshold = 30;
            }
        });
        ((RelativeLayout) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final HomeNewMainActivity.CustomInteraksiPagerAdapter this$1;
            private final ListModel val$lms;

            public void onClick(View view1)
            {
                view1 = new Intent(activity, com/inponsel/android/v2/KomentarPonsel);
                view1.putExtra("id_hph", lms.getId_hp());
                view1.putExtra("namalengkap", lms.getNamalengkap());
                view1.putExtra("codename", lms.getCodename());
                view1.putExtra("model", lms.getModel());
                view1.putExtra("merk", lms.getMerk());
                view1.putExtra("gambar", "");
                view1.putExtra("hrg_baru", "");
                view1.putExtra("hrg_bekas", "");
                view1.putExtra("tot_like", "");
                view1.putExtra("tot_dislike", "");
                view1.putExtra("tot_komen", "");
                view1.putExtra("actfrom", "komen");
                activity.startActivityForResult(view1, 0);
                activity.overridePendingTransition(0x7f040003, 0x7f040004);
            }

            
            {
                this$1 = HomeNewMainActivity.CustomInteraksiPagerAdapter.this;
                lms = listmodel;
                super();
            }
        });
        obj = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        i = ((DisplayMetrics) (obj)).widthPixels;
        try
        {
            Picasso.with(activity).load((new StringBuilder(String.valueOf(Util.BASE_URL_THUMB_ORI))).append("w=").append(i).append("&src=").append(lms.getAvatar()).toString()).into(img_kom_picture, new Callback() {

                final HomeNewMainActivity.CustomInteraksiPagerAdapter this$1;
                private final ImageView val$img_kom_picture;

                public void onError()
                {
                    img_kom_picture.setImageResource(0x7f020297);
                }

                public void onSuccess()
                {
                }

            
            {
                this$1 = HomeNewMainActivity.CustomInteraksiPagerAdapter.this;
                img_kom_picture = imageview;
                super();
            }
            });
        }
        catch (Exception exception) { }
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


    public _cls3.val.img_kom_picture(Activity activity1, ArrayList arraylist)
    {
        this$0 = HomeNewMainActivity.this;
        super();
        str_doodle_width = "1024";
        str_doodle_height = "600";
        mLayoutInflater = (LayoutInflater)activity1.getSystemService("layout_inflater");
        lm = arraylist;
        activity = activity1;
    }
}
