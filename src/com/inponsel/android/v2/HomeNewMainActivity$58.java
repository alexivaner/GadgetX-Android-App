// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import fr.castorflex.android.circularprogressbar.CircularProgressBar;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

class this._cls0
    implements android.view.ctivity._cls58
{

    final HomeNewMainActivity this$0;

    public void onClick(View view)
    {
        scroll_count = 1;
        view = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
        if (view != null && view.isConnected())
        {
            txt_connection.setVisibility(8);
            btnRefreshconnection.setVisibility(8);
            progressbar_connection.setVisibility(8);
            progressbar_segmen2.setVisibility(8);
            progressbar_segmen3.setVisibility(8);
            progressbar_segmen4.setVisibility(8);
            ll_connection.setVisibility(8);
            HomeNewMainActivity.access$8(HomeNewMainActivity.this);
        }
    }

    larProgressBar()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
