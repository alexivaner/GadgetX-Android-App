// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.details.DetailsPonsel;
import com.inponsel.android.widget.ExpandableHeightGridView;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritPonselMerek

class this._cls0
    implements android.widget.ckListener
{

    final FavoritPonselMerek this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        listHp.playSoundEffect(0);
        id_hph = hpFavoriteAdapter.getListModel(i).getId_hp().toString();
        model = hpFavoriteAdapter.getListModel(i).getModel().toString();
        merk = hpFavoriteAdapter.getListModel(i).getMerk().toString();
        gambar = hpFavoriteAdapter.getListModel(i).getGambar().toString();
        codename = hpFavoriteAdapter.getListModel(i).getCodename().toString();
        namalengkap = (new StringBuilder(String.valueOf(merk))).append(" ").append(model).toString();
        adapterview = new Intent(FavoritPonselMerek.this, com/inponsel/android/details/DetailsPonsel);
        adapterview.putExtra("id_hph", id_hph);
        adapterview.putExtra("namalengkap", namalengkap);
        adapterview.putExtra("codename", "");
        adapterview.putExtra("model", model);
        adapterview.putExtra("merk", merk);
        adapterview.putExtra("gambar", gambar);
        adapterview.putExtra("hrg_baru", "");
        adapterview.putExtra("hrg_bekas", "");
        adapterview.putExtra("tot_like", "");
        adapterview.putExtra("tot_dislike", "");
        adapterview.putExtra("tot_komen", "");
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    sthpFavoriteAdapter()
    {
        this$0 = FavoritPonselMerek.this;
        super();
    }
}
