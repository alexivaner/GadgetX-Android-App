// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rsstab;

import android.view.View;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.rsstab:
//            RSSTimelineActivity

class this._cls0
    implements android.view.ineActivity._cls50
{

    final RSSTimelineActivity this$0;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            if (str_LangganTelkom.equals("1"))
            {
                statSubNews = "0";
                str_LangganTelkom = "0";
            } else
            if (str_LangganTelkom.equals("0"))
            {
                statSubNews = "1";
                str_LangganTelkom = "1";
            } else
            {
                statSubNews = "1";
                str_LangganTelkom = "1";
            }
            id_subs = "6";
            type = "op";
            type_tag = "telkom";
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