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
            if (str_LangganIOS.equals("1"))
            {
                statSubNews = "0";
                str_LangganIOS = "0";
            } else
            if (str_LangganIOS.equals("0"))
            {
                statSubNews = "1";
                str_LangganIOS = "1";
            } else
            {
                statSubNews = "1";
                str_LangganIOS = "1";
            }
            id_subs = "5";
            type = "os";
            type_tag = "ios";
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