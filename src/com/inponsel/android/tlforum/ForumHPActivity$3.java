// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import android.view.View;
import com.dobmob.dobsliding.DobSlidingMenu;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

class this._cls0
    implements android.view.er
{

    final ForumHPActivity this$0;

    public void onClick(View view)
    {
        if (isExpand)
        {
            ForumHPActivity.access$2(ForumHPActivity.this).collapse();
            return;
        } else
        {
            ForumHPActivity.access$2(ForumHPActivity.this).expand();
            return;
        }
    }

    ()
    {
        this$0 = ForumHPActivity.this;
        super();
    }
}
