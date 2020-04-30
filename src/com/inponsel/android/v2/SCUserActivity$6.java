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
//            SCUserActivity

class this._cls0
    implements android.widget.mClickListener
{

    final SCUserActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(getApplicationContext(), com/inponsel/android/scdetail/SCDetailPager);
        adapterview.putExtra("sc_id", scProvAdapter.getListModel(i).getId_sc());
        adapterview.putExtra("sc_logo", scProvAdapter.getListModel(i).getSc_logo());
        adapterview.putExtra("sc_c_center", scProvAdapter.getListModel(i).getSc_c_center());
        adapterview.putExtra("sc_ven_center", scProvAdapter.getListModel(i).getSc_ven_center());
        adapterview.putExtra("sc_nama", scProvAdapter.getListModel(i).getSc_nama());
        adapterview.putExtra("sc_merk", scProvAdapter.getListModel(i).getSc_merk());
        adapterview.putExtra("sc_fb", scProvAdapter.getListModel(i).getSc_fb());
        adapterview.putExtra("sc_ytube", scProvAdapter.getListModel(i).getSc_ytube());
        adapterview.putExtra("sc_fb_id", scProvAdapter.getListModel(i).getSc_fb_id());
        adapterview.putExtra("sc_tw", scProvAdapter.getListModel(i).getSc_tw());
        adapterview.putExtra("sc_alamat", scProvAdapter.getListModel(i).getSc_alamat());
        adapterview.putExtra("sc_no_telp", scProvAdapter.getListModel(i).getSc_no_telp());
        adapterview.putExtra("sc_no_telp_ket", scProvAdapter.getListModel(i).getSc_no_telp_ket());
        adapterview.putExtra("sc_email", scProvAdapter.getListModel(i).getSc_email());
        adapterview.putExtra("sc_web", scProvAdapter.getListModel(i).getSc_web_url());
        adapterview.putExtra("sc_rateAvg", scProvAdapter.getListModel(i).getSc_rate());
        adapterview.putExtra("sc_rate1", scProvAdapter.getListModel(i).getSc_rate1());
        adapterview.putExtra("sc_rate2", scProvAdapter.getListModel(i).getSc_rate2());
        adapterview.putExtra("sc_rate3", scProvAdapter.getListModel(i).getSc_rate3());
        adapterview.putExtra("sc_rate4", scProvAdapter.getListModel(i).getSc_rate4());
        adapterview.putExtra("sc_rate5", scProvAdapter.getListModel(i).getSc_rate5());
        adapterview.putExtra("sc_total_rate", scProvAdapter.getListModel(i).getSc_total_rate());
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    stSCProvAdapter()
    {
        this$0 = SCUserActivity.this;
        super();
    }
}
