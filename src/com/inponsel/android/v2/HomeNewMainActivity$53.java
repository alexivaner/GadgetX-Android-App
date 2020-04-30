// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

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
        if (rilisTerbaruArray.size() == 0)
        {
            RilisTask();
        }
        HomeNewMainActivity.access$1(HomeNewMainActivity.this);
        if (topHitsArray.size() == 0)
        {
            TopHitsTask();
        } else
        {
            progressbar_segmen3.setVisibility(8);
        }
        if (segeraArray.size() == 0)
        {
            SegeraTask();
        }
    }

    larProgressBar()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
