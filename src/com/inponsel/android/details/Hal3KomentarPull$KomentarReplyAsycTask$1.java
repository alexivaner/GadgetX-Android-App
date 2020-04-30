// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.widget.ImageView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.details:
//            Hal3KomentarPull

class this._cls1
    implements Callback
{

    final this._cls1 this$1;

    public void onError()
    {
    }

    public void onSuccess()
    {
        cess._mth2(this._cls1.this).img_kom_picture.setVisibility(0);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
