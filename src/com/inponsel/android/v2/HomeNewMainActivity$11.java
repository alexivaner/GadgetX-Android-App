// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.squareup.picasso.Callback;
import de.hdodenhof.circleimageview.CircleImageView;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

class this._cls0
    implements Callback
{

    final HomeNewMainActivity this$0;

    public void onError()
    {
        img_user_ponsel.setVisibility(0);
        img_user_ponsel.setImageResource(0x7f020297);
    }

    public void onSuccess()
    {
    }

    ()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
