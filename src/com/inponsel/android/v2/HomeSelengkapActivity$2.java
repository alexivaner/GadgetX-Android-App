// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.widget.ExpandableHeightListView2;

// Referenced classes of package com.inponsel.android.v2:
//            HomeSelengkapActivity

class this._cls0
    implements android.widget.istener
{

    final HomeSelengkapActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        listSelengkap.playSoundEffect(0);
        id_hph = selengkapAdapter.getListModel(i).getId_hp().toString();
        model = selengkapAdapter.getListModel(i).getModel().toString();
        merk = selengkapAdapter.getListModel(i).getMerk().toString();
        gambar = selengkapAdapter.getListModel(i).getGambar().toString();
        tot_like = selengkapAdapter.getListModel(i).getTotal_like().toString();
        tot_dislike = selengkapAdapter.getListModel(i).getTotal_dislike().toString();
        tot_komen = selengkapAdapter.getListModel(i).getTotal_kom().toString();
        hrg_baru = selengkapAdapter.getListModel(i).getHrg_baru().toString();
        hrg_bekas = selengkapAdapter.getListModel(i).getHrg_bekas().toString();
        codename = selengkapAdapter.getListModel(i).getCodename().toString();
        namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        if (id_hph.contains("iklan"))
        {
            adapterview = new Intent("android.intent.action.VIEW");
            adapterview.setData(Uri.parse(codename.replace(" ", "")));
            startActivity(adapterview);
            return;
        } else
        {
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
            return;
        }
    }

    stSelengkapAdapter()
    {
        this$0 = HomeSelengkapActivity.this;
        super();
    }
}
