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
//            DaftarPonselMerkActivity

class this._cls0
    implements android.view.Activity._cls2
{

    final DaftarPonselMerkActivity this$0;

    public void onClick(View view)
    {
        btnMemuatLagi.setVisibility(8);
        if (android.os.rkActivity.btnMemuatLagi >= 13)
        {
            DaftarPonselMerkActivity.access$0(DaftarPonselMerkActivity.this).setProgressBarIndeterminateVisibility(true);
            DaftarPonselMerkActivity.access$0(DaftarPonselMerkActivity.this).setProgressBarVisibility(true);
        }
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            view = DaftarPonselMerkActivity.this;
            view.limit = ((DaftarPonselMerkActivity) (view)).limit + 10;
            dataPonsel = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_hp_merk").append(Utility.BASE_FORMAT).append("?merk=").append(dataIDMerk).append("&lmt=").append(limit).append("&t=").append(t).append("&idusr=").append(user_id).toString();
            Log.e("data", dataPonsel);
            PonselMerkTask();
            return;
        } else
        {
            DaftarPonselMerkActivity.access$0(DaftarPonselMerkActivity.this).setProgressBarIndeterminateVisibility(false);
            DaftarPonselMerkActivity.access$0(DaftarPonselMerkActivity.this).setProgressBarVisibility(false);
            return;
        }
    }

    ()
    {
        this$0 = DaftarPonselMerkActivity.this;
        super();
    }
}
