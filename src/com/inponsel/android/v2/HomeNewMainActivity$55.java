// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.LinearLayout;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

class this._cls0
    implements Runnable
{

    final HomeNewMainActivity this$0;

    public void run()
    {
        progressbar_segmen3.setVisibility(0);
        ll_segmen_3.setVisibility(0);
        if (latestBrandArray.size() == 0)
        {
            LatestBrandTask();
        }
        HomeNewMainActivity.access$7(HomeNewMainActivity.this);
        if (palingHotArray.size() == 0)
        {
            PalingHotTask();
        }
    }

    larProgressBar()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
