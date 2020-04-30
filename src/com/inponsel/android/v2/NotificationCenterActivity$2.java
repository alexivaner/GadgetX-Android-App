// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import org.apache.http.Header;

// Referenced classes of package com.inponsel.android.v2:
//            NotificationCenterActivity

class > extends AsyncHttpResponseHandler
{

    final NotificationCenterActivity this$0;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        progressbar_middle.setVisibility(8);
        txt_empty.setText("Gagal terhubung ke server");
    }

    public void onRetry(int i)
    {
    }

    public void onStart()
    {
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        aheader = new String(abyte0);
        try
        {
            hpMoreArray.clear();
            NotificationCenterActivity.access$0(NotificationCenterActivity.this, "343212312", aheader);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
        }
        NotificationCenterActivity.access$1(NotificationCenterActivity.this, aheader);
    }

    ()
    {
        this$0 = NotificationCenterActivity.this;
        super();
    }
}
