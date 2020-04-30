// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.adapter:
//            GalleryAdapter

class ewHolder
    implements Callback
{

    final GalleryAdapter this$0;
    private final ewHolder val$holder;

    public void onError()
    {
        val$holder.progressbar_item.setVisibility(8);
    }

    public void onSuccess()
    {
        val$holder.progressbar_item.setVisibility(8);
        val$holder.imgCat.setVisibility(0);
    }

    ewHolder()
    {
        this$0 = final_galleryadapter;
        val$holder = ewHolder.this;
        super();
    }
}
