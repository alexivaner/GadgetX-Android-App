// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.details.DetailsPonsel;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

class this._cls0
    implements android.widget.Listener
{

    final HomeNewMainActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        listRilis.playSoundEffect(0);
        adapterview = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
        adapterview.putExtra("id_hph", rilisTerbaruAdapter.getListModel(i).getId_hp().toString());
        adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(rilisTerbaruAdapter.getListModel(i).getMerk().toString()))).append(" ").append(rilisTerbaruAdapter.getListModel(i).getModel().toString()).toString());
        adapterview.putExtra("codename", rilisTerbaruAdapter.getListModel(i).getCodename().toString());
        adapterview.putExtra("model", rilisTerbaruAdapter.getListModel(i).getModel().toString());
        adapterview.putExtra("merk", rilisTerbaruAdapter.getListModel(i).getMerk().toString());
        adapterview.putExtra("gambar", rilisTerbaruAdapter.getListModel(i).getGambar().toString());
        adapterview.putExtra("hrg_baru", rilisTerbaruAdapter.getListModel(i).getHrg_baru().toString());
        adapterview.putExtra("hrg_bekas", rilisTerbaruAdapter.getListModel(i).getHrg_bekas().toString());
        adapterview.putExtra("tot_like", rilisTerbaruAdapter.getListModel(i).getTotal_like().toString());
        adapterview.putExtra("tot_dislike", rilisTerbaruAdapter.getListModel(i).getTotal_dislike().toString());
        adapterview.putExtra("tot_komen", rilisTerbaruAdapter.getListModel(i).getTotal_kom().toString());
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    tRilisTerbaruAdapter()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
