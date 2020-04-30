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
//            HomeGadgetActivity

class this._cls0
    implements android.widget.kListener
{

    final HomeGadgetActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        listPendatang.playSoundEffect(0);
        id_hph = rumorAdapter.getListModel(i).getId_hp().toString();
        model = rumorAdapter.getListModel(i).getModel().toString();
        merk = rumorAdapter.getListModel(i).getMerk().toString();
        gambar = rumorAdapter.getListModel(i).getGambar().toString();
        tot_like = rumorAdapter.getListModel(i).getTotal_like().toString();
        tot_dislike = rumorAdapter.getListModel(i).getTotal_dislike().toString();
        tot_komen = rumorAdapter.getListModel(i).getTotal_kom().toString();
        hrg_baru = rumorAdapter.getListModel(i).getHrg_baru().toString();
        hrg_bekas = rumorAdapter.getListModel(i).getHrg_bekas().toString();
        codename = rumorAdapter.getListModel(i).getCodename().toString();
        namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        adapterview = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
        adapterview.putExtra("id_hph", id_hph);
        adapterview.putExtra("namalengkap", namalengkap);
        adapterview.putExtra("codename", codename);
        adapterview.putExtra("model", model);
        adapterview.putExtra("merk", merk);
        adapterview.putExtra("gambar", gambar);
        adapterview.putExtra("hrg_baru", hrg_baru);
        adapterview.putExtra("hrg_bekas", hrg_bekas);
        adapterview.putExtra("tot_like", tot_like);
        adapterview.putExtra("tot_dislike", tot_dislike);
        adapterview.putExtra("tot_komen", tot_komen);
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    tRumorAdapter()
    {
        this$0 = HomeGadgetActivity.this;
        super();
    }
}
