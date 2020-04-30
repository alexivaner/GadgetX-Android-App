// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class this._cls0
    implements Callback
{

    final ForumGlobalActivity this$0;

    public void onError()
    {
        progressbar_imgcontent.setVisibility(8);
        imageMedia.setBackgroundResource(0x7f0201b8);
    }

    public void onSuccess()
    {
        progressbar_imgcontent.setVisibility(8);
        imageMedia.setVisibility(0);
    }

    ()
    {
        this$0 = ForumGlobalActivity.this;
        super();
    }
}
