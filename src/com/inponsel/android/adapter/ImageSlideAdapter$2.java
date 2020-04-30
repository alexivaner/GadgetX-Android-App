// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.widget.ImageView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.adapter:
//            ImageSlideAdapter

class val.mImageView
    implements Callback
{

    final ImageSlideAdapter this$0;
    private final ImageView val$mImageView;

    public void onError()
    {
        val$mImageView.setImageResource(0x7f020209);
    }

    public void onSuccess()
    {
    }

    ()
    {
        this$0 = final_imageslideadapter;
        val$mImageView = ImageView.this;
        super();
    }
}
