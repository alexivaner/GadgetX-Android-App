// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.widget.ExpandableHeightListView2;
import org.json.JSONArray;

// Referenced classes of package com.inponsel.android.v2:
//            NotificationCenterActivity

class val.data
    implements Runnable
{

    final NotificationCenterActivity this$0;
    private final JSONArray val$data;

    public void run()
    {
        if (val$data.length() == 0)
        {
            progressbar_middle.setVisibility(8);
            txt_empty.setText("Belum ada notifikasi");
            return;
        } else
        {
            listNotifikasi.setVisibility(0);
            layout_empty.setVisibility(8);
            selengkapAdapter.notifyDataSetChanged();
            return;
        }
    }

    stSelengkapAdapter()
    {
        this$0 = final_notificationcenteractivity;
        val$data = JSONArray.this;
        super();
    }
}
