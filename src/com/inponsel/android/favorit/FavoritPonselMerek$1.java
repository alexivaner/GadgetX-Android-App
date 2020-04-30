// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.details.ProfilPTActivity;
import com.inponsel.android.widget.ExpandableHeightGridView;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritPonselMerek

class this._cls0
    implements android.widget.ckListener
{

    final FavoritPonselMerek this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        listMerek.playSoundEffect(0);
        adapterview = new Intent(FavoritPonselMerek.this, com/inponsel/android/details/ProfilPTActivity);
        adapterview.putExtra("id_merk", favBrandAdapter.getListModel(i).getId_hp());
        adapterview.putExtra("titlemerek", favBrandAdapter.getListModel(i).getMerk());
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    stfavBrandAdapter()
    {
        this$0 = FavoritPonselMerek.this;
        super();
    }
}
