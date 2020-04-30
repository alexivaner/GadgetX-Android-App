// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListKategoriAppsAdapter;
import com.inponsel.android.adapter.ListModel;

// Referenced classes of package com.inponsel.android.v2:
//            AppsSelengkap, AppsByCategory

class this._cls0
    implements android.widget.emClickListener
{

    final AppsSelengkap this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/AppsByCategory);
        adapterview.putExtra("id", listKatAppsAdapter.getListModel(i).getId_apps());
        adapterview.putExtra("kategori", listKatAppsAdapter.getListModel(i).getKat_apps_name());
        adapterview.putExtra("tag", listKatAppsAdapter.getListModel(i).getKat_apps_tag());
        adapterview.putExtra("deskripsi", listKatAppsAdapter.getListModel(i).getKat_apps_desc());
        adapterview.putExtra("mod_date", listKatAppsAdapter.getListModel(i).getKat_apps_date());
        adapterview.putExtra("background", listKatAppsAdapter.getListModel(i).getKat_apps_background());
        adapterview.putExtra("background_img", listKatAppsAdapter.getListModel(i).getKat_apps_background_img());
        adapterview.putExtra("height", listKatAppsAdapter.getListModel(i).getKat_img_height());
        adapterview.putExtra("mystat", listKatAppsAdapter.getListModel(i).getKat_img_width());
        adapterview.putExtra("myfav", listKatAppsAdapter.getListModel(i).getKat_fav_status());
        adapterview.putExtra("width_img", listKatAppsAdapter.getListModel(i).getKat_img_width());
        adapterview.putExtra("height_img", listKatAppsAdapter.getListModel(i).getKat_img_height());
        adapterview.putExtra("type", listKatAppsAdapter.getListModel(i).getKat_type());
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    iAppsAdapter()
    {
        this$0 = AppsSelengkap.this;
        super();
    }
}
