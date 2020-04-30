// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.daftarharga:
//            Hal2Hasil

class this._cls0
    implements android.view.Listener
{

    final Hal2Hasil this$0;

    public void onClick(View view)
    {
        btnMemuatLagi.setVisibility(8);
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            Log.e("data", dataStatistik);
            HargaHpTaskMore();
            return;
        } else
        {
            getSherlockActivity().setProgressBarIndeterminateVisibility(false);
            getSherlockActivity().setProgressBarVisibility(false);
            Toast.makeText(getActivity(), getString(0x7f0c005a), 0).show();
            return;
        }
    }

    ivity()
    {
        this$0 = Hal2Hasil.this;
        super();
    }
}
