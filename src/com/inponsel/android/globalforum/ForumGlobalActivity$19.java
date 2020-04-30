// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.view.View;
import android.widget.TextView;
import com.dobmob.dobsliding.DobSlidingMenu;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class this._cls0
    implements android.view.umGlobalActivity._cls19
{

    final ForumGlobalActivity this$0;

    public void onClick(View view)
    {
        txt_sublabel_actionbar.setText("Opini");
        ForumGlobalActivity.access$2(ForumGlobalActivity.this).collapse();
        tag_timeline = "opini";
        TimelineTask();
    }

    ()
    {
        this$0 = ForumGlobalActivity.this;
        super();
    }
}
