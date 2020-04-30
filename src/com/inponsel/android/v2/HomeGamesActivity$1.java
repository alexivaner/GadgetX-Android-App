// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.nirhart.parallaxscroll.views.ParallaxScrollView;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGamesActivity

class val.position
    implements Runnable
{

    final HomeGamesActivity this$0;
    private final int val$position[];

    public void run()
    {
        sv_root.scrollTo(val$position[0], val$position[1]);
    }

    ollView()
    {
        this$0 = final_homegamesactivity;
        val$position = _5B_I.this;
        super();
    }
}
