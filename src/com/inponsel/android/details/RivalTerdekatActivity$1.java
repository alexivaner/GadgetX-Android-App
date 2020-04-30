// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.details:
//            RivalTerdekatActivity

class this._cls0
    implements Callback
{

    final RivalTerdekatActivity this$0;

    public void onError()
    {
        progressbar_item.setVisibility(8);
    }

    public void onSuccess()
    {
        progressbar_item.setVisibility(8);
        imageHp.setVisibility(0);
    }

    ()
    {
        this$0 = RivalTerdekatActivity.this;
        super();
    }
}
