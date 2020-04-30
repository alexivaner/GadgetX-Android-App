// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostBenchmark

class this._cls1
    implements android.widget.kListener
{

    final og this$1;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        strPencBench = listMerkAdapter.getListModel(i).getId_bench().toString();
        benchmark_apps = listMerkAdapter.getListModel(i).getNm_apps().toString();
        btnbenchmark.setText(listMerkAdapter.getListModel(i).getNm_apps().toString());
        dialog.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/RoomPostBenchmark$3

/* anonymous class */
    class RoomPostBenchmark._cls3
        implements android.view.View.OnClickListener
    {

        final RoomPostBenchmark this$0;

        public void onClick(View view)
        {
            view = getLayoutInflater().inflate(0x7f0300a4, null);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(RoomPostBenchmark.this);
            builder.setView(view);
            builder.setTitle("Pilih Benchmark :");
            layout_empty = (LinearLayout)view.findViewById(0x7f0b0091);
            listHp = (ListView)view.findViewById(0x7f0b008f);
            if (android.os.Build.VERSION.SDK_INT < 13)
            {
                listHp.setBackgroundColor(-1);
            }
            progressbar_middle_dialog = (ProgressBar)view.findViewById(0x7f0b0092);
            txtEmpty = (TextView)view.findViewById(0x7f0b0093);
            txtEmpty.setText(0x7f0c0053);
            listMerkArrayList = new ArrayList();
            listMerkAdapter = new RoomPostBenchmark.ListBenchAdapter(RoomPostBenchmark.this, RoomPostBenchmark.this, 0x7f03006e, listMerkArrayList);
            listHp.setAdapter(listMerkAdapter);
            (new RoomPostBenchmark.MerkSync(RoomPostBenchmark.this, null)).execute(new String[] {
                (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_benchmark").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
            });
            listHp.setOnItemClickListener(new RoomPostBenchmark._cls3._cls1());
            dialog = builder.create();
            dialog.show();
        }


            
            {
                this$0 = RoomPostBenchmark.this;
                super();
            }
    }

}
