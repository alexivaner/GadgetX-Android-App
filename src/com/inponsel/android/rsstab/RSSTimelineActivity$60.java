// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import android.view.View;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSTimelineActivity

class this._cls0
    implements android.view.ineActivity._cls60
{

    final RSSTimelineActivity this$0;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            if (str_LangganPemerintah.equals("1"))
            {
                statSubNews = "0";
                str_LangganPemerintah = "0";
            } else
            if (str_LangganPemerintah.equals("0"))
            {
                statSubNews = "1";
                str_LangganPemerintah = "1";
            } else
            {
                statSubNews = "1";
                str_LangganPemerintah = "1";
            }
            id_subs = "7";
            type = "general";
            type_tag = "pemerintah";
            (new sNewsTask(RSSTimelineActivity.this)).execute(new Void[0]);
            return;
        } else
        {
            RSSTimelineActivity.access$6(RSSTimelineActivity.this, str_title_notlogin, str_msg_notlogin);
            return;
        }
    }

    sNewsTask()
    {
        this$0 = RSSTimelineActivity.this;
        super();
    }
}
