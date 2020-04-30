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
//            MerekActivity

class this._cls0
    implements android.view.ener
{

    final MerekActivity this$0;

    public void onClick(View view)
    {
        btnMemuatLagi.setVisibility(8);
        int i = android.os.K_INT;
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            view = MerekActivity.this;
            view.limit = ((MerekActivity) (view)).limit + 10;
            dataMerek = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("daftar_merk").append(Utility.BASE_FORMAT).append("?t=").append(t).toString();
            Log.e("data", dataMerek);
            MerekTask();
            return;
        } else
        {
            MerekActivity.access$0(MerekActivity.this).setProgressBarIndeterminateVisibility(false);
            MerekActivity.access$0(MerekActivity.this).setProgressBarVisibility(false);
            return;
        }
    }

    ()
    {
        this$0 = MerekActivity.this;
        super();
    }
}
