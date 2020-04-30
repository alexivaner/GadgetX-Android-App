// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.scdetail.SCDetailPager;

// Referenced classes of package com.inponsel.android.v2:
//            SCMoreActivity

class this._cls0
    implements android.widget.mClickListener
{

    final SCMoreActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(getApplicationContext(), com/inponsel/android/scdetail/SCDetailPager);
        adapterview.putExtra("sc_id", pencarianAdapter.getListModel(i).getId_sc());
        adapterview.putExtra("sc_logo", pencarianAdapter.getListModel(i).getSc_logo());
        adapterview.putExtra("sc_c_center", pencarianAdapter.getListModel(i).getSc_c_center());
        adapterview.putExtra("sc_ven_center", pencarianAdapter.getListModel(i).getSc_ven_center());
        adapterview.putExtra("sc_nama", pencarianAdapter.getListModel(i).getSc_nama());
        adapterview.putExtra("sc_merk", pencarianAdapter.getListModel(i).getSc_merk());
        adapterview.putExtra("sc_fb", pencarianAdapter.getListModel(i).getSc_fb());
        adapterview.putExtra("sc_ytube", pencarianAdapter.getListModel(i).getSc_ytube());
        adapterview.putExtra("sc_fb_id", pencarianAdapter.getListModel(i).getSc_fb_id());
        adapterview.putExtra("sc_tw", pencarianAdapter.getListModel(i).getSc_tw());
        adapterview.putExtra("sc_alamat", pencarianAdapter.getListModel(i).getSc_alamat());
        adapterview.putExtra("sc_no_telp", pencarianAdapter.getListModel(i).getSc_no_telp());
        adapterview.putExtra("sc_no_telp_ket", pencarianAdapter.getListModel(i).getSc_no_telp_ket());
        adapterview.putExtra("sc_email", pencarianAdapter.getListModel(i).getSc_email());
        adapterview.putExtra("sc_web", pencarianAdapter.getListModel(i).getSc_web_url());
        adapterview.putExtra("sc_rateAvg", pencarianAdapter.getListModel(i).getSc_rate());
        adapterview.putExtra("sc_rate1", pencarianAdapter.getListModel(i).getSc_rate1());
        adapterview.putExtra("sc_rate2", pencarianAdapter.getListModel(i).getSc_rate2());
        adapterview.putExtra("sc_rate3", pencarianAdapter.getListModel(i).getSc_rate3());
        adapterview.putExtra("sc_rate4", pencarianAdapter.getListModel(i).getSc_rate4());
        adapterview.putExtra("sc_rate5", pencarianAdapter.getListModel(i).getSc_rate5());
        adapterview.putExtra("sc_total_rate", pencarianAdapter.getListModel(i).getSc_total_rate());
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    stPencarianAdapter()
    {
        this$0 = SCMoreActivity.this;
        super();
    }
}
