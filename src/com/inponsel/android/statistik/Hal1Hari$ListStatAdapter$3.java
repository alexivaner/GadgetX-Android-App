// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.statistik;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.v2.KomentarPonsel;

// Referenced classes of package com.inponsel.android.statistik:
//            Hal1Hari

class val.position
    implements android.view.ListStatAdapter._cls3
{

    final nsition this$1;
    private final int val$position;

    public void onClick(View view)
    {
        view = new Intent(cess._mth1(this._cls1.this).getActivity(), com/inponsel/android/v2/KomentarPonsel);
        view.putExtra("id_hph", tListModel(val$position).getId_hp());
        view.putExtra("namalengkap", tListModel(val$position).getNamalengkap());
        view.putExtra("codename", tListModel(val$position).getCodename());
        view.putExtra("model", tListModel(val$position).getModel());
        view.putExtra("merk", tListModel(val$position).getMerk());
        view.putExtra("gambar", tListModel(val$position).getGambar());
        view.putExtra("hrg_baru", tListModel(val$position).getHrg_baru());
        view.putExtra("hrg_bekas", tListModel(val$position).getHrg_bekas());
        view.putExtra("tot_like", tListModel(val$position).getTotal_like());
        view.putExtra("tot_dislike", tListModel(val$position).getTotal_dislike());
        view.putExtra("tot_komen", tListModel(val$position).getTotal_kom());
        cess._mth1(this._cls1.this).startActivityForResult(view, 0);
        cess._mth1(this._cls1.this).getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$1 = final_;
        val$position = I.this;
        super();
    }
}
