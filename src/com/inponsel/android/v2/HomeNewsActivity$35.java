// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.view.View;
import android.widget.TextView;
import com.dobmob.dobsliding.DobSlidingMenu;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

class this._cls0
    implements android.view.
{

    final HomeNewsActivity this$0;

    public void onClick(View view)
    {
        txt_sublabel_actionbar.setText("Teknologi & Science");
        HomeNewsActivity.access$5(HomeNewsActivity.this).collapse();
        tag_timeline = "Teknologi";
        tag_code = "KATTEKNO";
        TimelineTask();
    }

    ()
    {
        this$0 = HomeNewsActivity.this;
        super();
    }
}