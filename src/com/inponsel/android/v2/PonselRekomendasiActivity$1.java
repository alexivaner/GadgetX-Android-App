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
//            PonselRekomendasiActivity

class this._cls0
    implements android.view.Activity._cls1
{

    final PonselRekomendasiActivity this$0;

    public void onClick(View view)
    {
        btnMemuatLagi.setVisibility(8);
        if (android.os.siActivity.btnMemuatLagi >= 13)
        {
            PonselRekomendasiActivity.access$0(PonselRekomendasiActivity.this).setProgressBarIndeterminateVisibility(true);
            PonselRekomendasiActivity.access$0(PonselRekomendasiActivity.this).setProgressBarVisibility(true);
        }
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            view = PonselRekomendasiActivity.this;
            view.limit = ((PonselRekomendasiActivity) (view)).limit + 1;
            dataPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("ponsel_recomended").append(Utility.BASE_FORMAT).append("?lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
            Log.e("data", dataPonsel);
            PonselMerkTask();
            return;
        } else
        {
            PonselRekomendasiActivity.access$0(PonselRekomendasiActivity.this).setProgressBarIndeterminateVisibility(false);
            PonselRekomendasiActivity.access$0(PonselRekomendasiActivity.this).setProgressBarVisibility(false);
            return;
        }
    }

    _cls9()
    {
        this$0 = PonselRekomendasiActivity.this;
        super();
    }
}
