// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import com.dobmob.dobsliding.events.OnCollapsedListener;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class this._cls0
    implements OnCollapsedListener
{

    final ForumGlobalActivity this$0;

    public void onCollapsed()
    {
        Log.i(ForumGlobalActivity.access$1(ForumGlobalActivity.this), "onCollapsed");
        isExpand = false;
    }

    ()
    {
        this$0 = ForumGlobalActivity.this;
        super();
    }
}
