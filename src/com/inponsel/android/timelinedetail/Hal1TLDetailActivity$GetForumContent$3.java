// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal1TLDetailActivity

class this._cls1
    implements Callback
{

    final ontent this$1;

    public void onError()
    {
        cess._mth2(this._cls1.this).imgTLContent.setImageResource(0x7f0201b8);
    }

    public void onSuccess()
    {
        cess._mth2(this._cls1.this).progressbar_imgTLContent.setVisibility(8);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
