// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import android.view.View;
import android.widget.TextView;
import com.dobmob.dobsliding.DobSlidingMenu;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSTimelineActivity

class this._cls0
    implements android.view.ineActivity._cls16
{

    final RSSTimelineActivity this$0;

    public void onClick(View view)
    {
        txt_sublabel_actionbar.setText("Indosat");
        RSSTimelineActivity.access$5(RSSTimelineActivity.this).collapse();
        tag_timeline = "Indosat";
        tag_code = "OPIND";
        TimelineTask();
    }

    ()
    {
        this$0 = RSSTimelineActivity.this;
        super();
    }
}
