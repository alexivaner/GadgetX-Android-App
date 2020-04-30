// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.statistik;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.widget.ExpandableHeightGridView;

// Referenced classes of package com.inponsel.android.statistik:
//            Hal1Hari

class this._cls0
    implements android.widget..OnItemClickListener
{

    final Hal1Hari this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        listStat.playSoundEffect(0);
        id_hph = lainAdapter.getListModel(i).getId_hp().toString();
        model = lainAdapter.getListModel(i).getModel().toString();
        merk = lainAdapter.getListModel(i).getMerk().toString();
        gambar = lainAdapter.getListModel(i).getGambar().toString();
        tot_like = lainAdapter.getListModel(i).getTotal_like().toString();
        tot_dislike = lainAdapter.getListModel(i).getTotal_dislike().toString();
        tot_komen = lainAdapter.getListModel(i).getTotal_kom().toString();
        hrg_baru = lainAdapter.getListModel(i).getHrg_baru().toString();
        hrg_bekas = lainAdapter.getListModel(i).getHrg_bekas().toString();
        codename = lainAdapter.getListModel(i).getCodename().toString();
        namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        adapterview = new Intent(getActivity(), com/inponsel/android/details/DetailsPonsel);
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
        getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = Hal1Hari.this;
        super();
    }
}
