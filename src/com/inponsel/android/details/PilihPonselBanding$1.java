// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.widget.ImageView;
import com.squareup.picasso.Callback;

// Referenced classes of package com.inponsel.android.details:
//            PilihPonselBanding

class this._cls0
    implements Callback
{

    final PilihPonselBanding this$0;

    public void onError()
    {
    }

    public void onSuccess()
    {
        imageHp.setVisibility(0);
    }

    ()
    {
        this$0 = PilihPonselBanding.this;
        super();
    }
}
