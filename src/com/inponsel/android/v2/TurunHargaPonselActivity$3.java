// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

// Referenced classes of package com.inponsel.android.v2:
//            TurunHargaPonselActivity

class pleImageLoadingListener extends SimpleImageLoadingListener
{

    final TurunHargaPonselActivity this$0;

    public void onLoadingComplete(String s, View view, Bitmap bitmap)
    {
        imgAdv.setImageBitmap(bitmap);
        if (ads_status.equals("1"))
        {
            lay_advertising.setVisibility(0);
            return;
        } else
        {
            lay_advertising.setVisibility(8);
            return;
        }
    }

    pleImageLoadingListener()
    {
        this$0 = TurunHargaPonselActivity.this;
        super();
    }
}
