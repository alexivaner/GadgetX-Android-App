// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.bean.Product;
import com.inponsel.android.rssfeeddetail.RSSDetailTab;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.adapter:
//            ImageSlideAdapter

class val.product
    implements android.view.
{

    final ImageSlideAdapter this$0;
    private final Product val$product;

    public void onClick(View view)
    {
        Log.e("judul", String.valueOf(val$product.getId()));
        view = new Intent();
        view.setClass(activity, com/inponsel/android/rssfeeddetail/RSSDetailTab);
        view.putExtra("id_rss", String.valueOf(val$product.getId()));
        view.putExtra("rss_title", val$product.getName());
        view.putExtra("notif", "gcm");
        view.putExtra("actfrom", "rssfeed");
        view.putExtra("act", "firsttab");
        activity.startActivityForResult(view, 0);
        activity.overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = final_imageslideadapter;
        val$product = Product.this;
        super();
    }
}
