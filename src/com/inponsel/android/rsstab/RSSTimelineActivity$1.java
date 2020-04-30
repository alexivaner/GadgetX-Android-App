// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import com.dobmob.dobsliding.events.OnCollapsedListener;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSTimelineActivity

class this._cls0
    implements OnCollapsedListener
{

    final RSSTimelineActivity this$0;

    public void onCollapsed()
    {
        Log.i(RSSTimelineActivity.access$4(RSSTimelineActivity.this), "onCollapsed");
        isExpand = false;
    }

    ()
    {
        this$0 = RSSTimelineActivity.this;
        super();
    }
}
