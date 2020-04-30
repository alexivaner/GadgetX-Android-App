// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;
import com.actionbarsherlock.ActionBarSherlock;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.v2:
//            HomeSelengkapActivity

class this._cls0
    implements android.view.Activity._cls1
{

    final HomeSelengkapActivity this$0;

    public void onClick(View view)
    {
        btnMemuatLagi.setVisibility(8);
        int i = android.os.;
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            view = HomeSelengkapActivity.this;
            view.limit = ((HomeSelengkapActivity) (view)).limit + 10;
            dataSelengkap = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append(urlStatus).append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
            Log.e("data", dataSelengkap);
            SelengkapHPTask();
            return;
        } else
        {
            HomeSelengkapActivity.access$0(HomeSelengkapActivity.this).setProgressBarIndeterminateVisibility(false);
            HomeSelengkapActivity.access$0(HomeSelengkapActivity.this).setProgressBarVisibility(false);
            return;
        }
    }

    ()
    {
        this$0 = HomeSelengkapActivity.this;
        super();
    }
}
