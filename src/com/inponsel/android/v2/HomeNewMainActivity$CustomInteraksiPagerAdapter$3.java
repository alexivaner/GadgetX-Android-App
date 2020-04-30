// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.ImageView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

class val.img_kom_picture
    implements Callback
{

    final val.img_kom_picture this$1;
    private final ImageView val$img_kom_picture;

    public void onError()
    {
        val$img_kom_picture.setImageResource(0x7f020297);
    }

    public void onSuccess()
    {
    }

    ()
    {
        this$1 = final_;
        val$img_kom_picture = ImageView.this;
        super();
    }
}
