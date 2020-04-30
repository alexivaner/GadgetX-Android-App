// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.LinearLayout;
import com.nirhart.parallaxscroll.views.ParallaxScrollView;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGadgetActivity

class this._cls0
    implements Runnable
{

    final HomeGadgetActivity this$0;

    public void run()
    {
        sv_root.scrollBy(0, 100);
        HomeGadgetActivity.access$1(HomeGadgetActivity.this);
        if (segeraArray.size() == 0)
        {
            SegeraTask();
        }
        ll_segmen_2.setVisibility(0);
        if (latestBrandArray.size() == 0)
        {
            LatestBrandTask();
        }
        isFinish2 = true;
    }

    lView()
    {
        this$0 = HomeGadgetActivity.this;
        super();
    }
}
