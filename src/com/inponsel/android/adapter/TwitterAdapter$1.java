// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.adapter;

import android.widget.ImageView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.adapter:
//            TwitterAdapter

class ewHolder
    implements Callback
{

    final TwitterAdapter this$0;
    private final ewHolder val$holder;

    public void onError()
    {
    }

    public void onSuccess()
    {
        val$holder.imageMedia.setVisibility(0);
    }

    ewHolder()
    {
        this$0 = final_twitteradapter;
        val$holder = ewHolder.this;
        super();
    }
}
