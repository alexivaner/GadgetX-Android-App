// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.ImageView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.v2:
//            MessageActivity

class this._cls0
    implements Callback
{

    final MessageActivity this$0;

    public void onError()
    {
        img_user_picture.setImageResource(0x7f020297);
    }

    public void onSuccess()
    {
    }

    ()
    {
        this$0 = MessageActivity.this;
        super();
    }
}
