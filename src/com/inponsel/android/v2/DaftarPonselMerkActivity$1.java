// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.ImageView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.v2:
//            DaftarPonselMerkActivity

class this._cls0
    implements Callback
{

    final DaftarPonselMerkActivity this$0;

    public void onError()
    {
        img_head_banner.setVisibility(8);
    }

    public void onSuccess()
    {
        img_head_banner.setVisibility(0);
    }

    ()
    {
        this$0 = DaftarPonselMerkActivity.this;
        super();
    }
}
