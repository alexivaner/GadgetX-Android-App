// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import com.dobmob.dobsliding.events.OnExpandedListener;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

class this._cls0
    implements OnExpandedListener
{

    final ForumHPActivity this$0;

    public void onExpanded()
    {
        Log.i(ForumHPActivity.access$1(ForumHPActivity.this), "onExpanded");
        isExpand = true;
    }

    ()
    {
        this$0 = ForumHPActivity.this;
        super();
    }
}
