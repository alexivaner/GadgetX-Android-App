// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

class this._cls0
    implements android.view.istener
{

    final BaseDrawer this$0;

    public void onClick(View view)
    {
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected() && userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            Log.e("refresh", "img_RefForumFollow");
            img_RefForumFollow.setVisibility(8);
            Toast.makeText(getApplicationContext(), "Refresh...", 1).show();
            progressbar_ForumFollow.setVisibility(0);
            dataForumPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("user_ikutiforum_hp").append(Utility.BASE_FORMAT).append("?t=").append(t).append("&id_user=").append(user_id).append("&lmt=0").toString();
            Log.e("dataForumPonsel", dataForumPonsel);
            ForumPonselTask();
            return;
        } else
        {
            Log.e("offline", "offline");
            progressbar_ForumFollow.setVisibility(8);
            return;
        }
    }

    ons()
    {
        this$0 = BaseDrawer.this;
        super();
    }
}
