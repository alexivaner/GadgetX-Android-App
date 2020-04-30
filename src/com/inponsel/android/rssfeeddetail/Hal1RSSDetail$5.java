// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

class this._cls0
    implements android.view.ener
{

    final Hal1RSSDetail this$0;

    public void onClick(View view)
    {
        if (ll_kontenlain.getVisibility() == 0)
        {
            ll_kontenlain.setVisibility(8);
            return;
        } else
        {
            ll_kontenlain.setVisibility(0);
            return;
        }
    }

    ()
    {
        this$0 = Hal1RSSDetail.this;
        super();
    }
}
