// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
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
        Log.e("load", "segmen 3");
        if (rumorArray.size() == 0)
        {
            RumorTask();
        }
        ll_segmen_3.setVisibility(0);
        HomeGadgetActivity.access$4(HomeGadgetActivity.this);
        if (palingHotArray.size() == 0)
        {
            PalingHotTask();
        }
        if (topRateArray.size() == 0)
        {
            TopRateTask();
        }
        txt_home_inponsel.setVisibility(0);
    }

    lView()
    {
        this$0 = HomeGadgetActivity.this;
        super();
    }
}
