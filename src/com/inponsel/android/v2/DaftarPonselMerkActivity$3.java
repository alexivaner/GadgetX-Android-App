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
import com.inponsel.android.widget.ExpandableHeightGridView;

// Referenced classes of package com.inponsel.android.v2:
//            DaftarPonselMerkActivity

class this._cls0
    implements android.widget.ener
{

    final DaftarPonselMerkActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        listPonselOS.playSoundEffect(0);
        id_hph = ponselOsAdapter.getListModel(i).getId_hp().toString();
        model = ponselOsAdapter.getListModel(i).getModel().toString();
        merk = ponselOsAdapter.getListModel(i).getMerk().toString();
        gambar = ponselOsAdapter.getListModel(i).getGambar().toString();
        tot_like = ponselOsAdapter.getListModel(i).getTotal_like().toString();
        tot_dislike = ponselOsAdapter.getListModel(i).getTotal_dislike().toString();
        tot_komen = ponselOsAdapter.getListModel(i).getTotal_kom().toString();
        hrg_baru = ponselOsAdapter.getListModel(i).getHrg_baru().toString();
        hrg_bekas = ponselOsAdapter.getListModel(i).getHrg_bekas().toString();
        codename = ponselOsAdapter.getListModel(i).getCodename().toString();
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

    stPendatangAdapter()
    {
        this$0 = DaftarPonselMerkActivity.this;
        super();
    }
}
