// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.widget.ImageView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.adapter:
//            CustomPagerAdapter

class val.img_icon_ads
    implements Callback
{

    final CustomPagerAdapter this$0;
    private final ImageView val$img_icon_ads;

    public void onError()
    {
        val$img_icon_ads.setImageResource(0x7f020209);
    }

    public void onSuccess()
    {
    }

    ()
    {
        this$0 = final_custompageradapter;
        val$img_icon_ads = ImageView.this;
        super();
    }
}
