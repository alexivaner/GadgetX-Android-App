// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.widget.ImageView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.adapter:
//            NewsSlideAdapter

class val.imageMedia
    implements Callback
{

    final NewsSlideAdapter this$0;
    private final ImageView val$imageMedia;

    public void onError()
    {
        val$imageMedia.setImageResource(0x7f020209);
    }

    public void onSuccess()
    {
    }

    ()
    {
        this$0 = final_newsslideadapter;
        val$imageMedia = ImageView.this;
        super();
    }
}
