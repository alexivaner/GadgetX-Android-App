// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal1TLDetailActivity

class this._cls0
    implements Callback
{

    final Hal1TLDetailActivity this$0;

    public void onError()
    {
        imgTLContent.setImageResource(0x7f0201b8);
    }

    public void onSuccess()
    {
        progressbar_imgTLContent.setVisibility(8);
    }

    ()
    {
        this$0 = Hal1TLDetailActivity.this;
        super();
    }
}
