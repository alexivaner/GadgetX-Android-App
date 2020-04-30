// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.view.View;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

class this._cls0
    implements android.view.
{

    final HomeNewsActivity this$0;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            if (str_LangganTips.equals("1"))
            {
                statSubNews = "0";
                str_LangganTips = "0";
            } else
            if (str_LangganTips.equals("0"))
            {
                statSubNews = "1";
                str_LangganTips = "1";
            } else
            {
                statSubNews = "1";
                str_LangganTips = "1";
            }
            id_subs = "11";
            type = "general";
            type_tag = "tipstrik";
            (new sNewsTask(HomeNewsActivity.this)).execute(new Void[0]);
            return;
        } else
        {
            HomeNewsActivity.access$6(HomeNewsActivity.this, str_title_notlogin, str_msg_notlogin);
            return;
        }
    }

    sNewsTask()
    {
        this$0 = HomeNewsActivity.this;
        super();
    }
}
