// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.nirhart.parallaxscroll.views.ParallaxScrollView;

// Referenced classes of package com.inponsel.android.v2:
//            HomeAppsActivity

class this._cls0
    implements Runnable
{

    final HomeAppsActivity this$0;

    public void run()
    {
        sv_root.scrollBy(0, 100);
        HomeAppsActivity.access$0(HomeAppsActivity.this);
    }

    ollView()
    {
        this$0 = HomeAppsActivity.this;
        super();
    }
}
