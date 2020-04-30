// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.details:
//            RivalTerdekatActivity

class this._cls0
    implements android.view.dekatActivity._cls2
{

    final RivalTerdekatActivity this$0;

    public void onClick(View view)
    {
        btnMemuatLagi.setVisibility(8);
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            view = RivalTerdekatActivity.this;
            view.limit = ((RivalTerdekatActivity) (view)).limit + 10;
            dataRival = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("details_list_rival").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
            Log.e("dataRival", dataRival);
            RivalTerdekatTask();
        }
    }

    ()
    {
        this$0 = RivalTerdekatActivity.this;
        super();
    }
}
