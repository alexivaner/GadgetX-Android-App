// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.ImageView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

class val.imageMedia
    implements Callback
{

    final val.imageMedia this$1;
    private final ImageView val$imageMedia;

    public void onError()
    {
    }

    public void onSuccess()
    {
        val$imageMedia.setVisibility(0);
    }

    ()
    {
        this$1 = final_;
        val$imageMedia = ImageView.this;
        super();
    }
}
