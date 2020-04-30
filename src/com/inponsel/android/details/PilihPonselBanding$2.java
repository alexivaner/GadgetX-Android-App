// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.v2.BandingkanPonsel;
import com.inponsel.android.widget.ExpandableHeightGridView;

// Referenced classes of package com.inponsel.android.details:
//            PilihPonselBanding

class this._cls0
    implements android.widget.ckListener
{

    final PilihPonselBanding this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        listPencarianHp.playSoundEffect(0);
        adapterview = pencarianAdapter.getListModel(i).getId_hp().toString();
        view = pencarianAdapter.getListModel(i).getModel().toString();
        String s = pencarianAdapter.getListModel(i).getMerk().toString();
        String s1 = pencarianAdapter.getListModel(i).getGambar().toString();
        String s2 = pencarianAdapter.getListModel(i).getTotal_like().toString();
        String s3 = pencarianAdapter.getListModel(i).getTotal_dislike().toString();
        String s4 = pencarianAdapter.getListModel(i).getTotal_kom().toString();
        String s5 = pencarianAdapter.getListModel(i).getHrg_baru().toString();
        String s6 = pencarianAdapter.getListModel(i).getHrg_bekas().toString();
        String s7 = pencarianAdapter.getListModel(i).getCodename().toString();
        String s8 = (new StringBuilder(String.valueOf(s))).append(" ").append(view).toString();
        Intent intent = new Intent(PilihPonselBanding.this, com/inponsel/android/v2/BandingkanPonsel);
        intent.putExtra("id_hp2", adapterview);
        intent.putExtra("namalengkap2", s8);
        intent.putExtra("codename2", s7);
        intent.putExtra("model2", view);
        intent.putExtra("merk2", s);
        intent.putExtra("gambar2", s1);
        intent.putExtra("hrg_baru2", s5);
        intent.putExtra("hrg_bekas2", s6);
        intent.putExtra("tot_like2", s2);
        intent.putExtra("tot_dislike2", s3);
        intent.putExtra("tot_komen2", s4);
        intent.putExtra("id_hp1", id_hp1);
        intent.putExtra("namalengkap1", namalengkap1);
        intent.putExtra("codename1", codename1);
        intent.putExtra("model1", model1);
        intent.putExtra("merk1", merk1);
        intent.putExtra("gambar1", gambar1);
        intent.putExtra("hrg_baru1", hrg_baru1);
        intent.putExtra("hrg_bekas1", hrg_bekas1);
        intent.putExtra("tot_like1", tot_like1);
        intent.putExtra("tot_dislike1", tot_dislike1);
        intent.putExtra("tot_komen1", tot_komen1);
        startActivityForResult(intent, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    stPencarianAdapter()
    {
        this$0 = PilihPonselBanding.this;
        super();
    }
}
