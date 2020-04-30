// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencarianrinci;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.pencarianrinci:
//            Hal2HasilPencarian

class this._cls0
    implements android.view.i.Hal2HasilPencarian._cls1
{

    final Hal2HasilPencarian this$0;

    public void onClick(View view)
    {
        btnMemuatLagi.setVisibility(8);
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            Log.e("data", dataStatistik);
            StatistikTaskMore();
            return;
        } else
        {
            getSherlockActivity().setProgressBarIndeterminateVisibility(false);
            getSherlockActivity().setProgressBarVisibility(false);
            return;
        }
    }

    ()
    {
        this$0 = Hal2HasilPencarian.this;
        super();
    }
}
