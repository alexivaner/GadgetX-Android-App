// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.dobmob.dobsliding.events.OnCollapsedListener;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

class this._cls0
    implements OnCollapsedListener
{

    final HomeNewsActivity this$0;

    public void onCollapsed()
    {
        Log.i(HomeNewsActivity.TAG, "onCollapsed");
        isExpand = false;
    }

    tener()
    {
        this$0 = HomeNewsActivity.this;
        super();
    }
}
