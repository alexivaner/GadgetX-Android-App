// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListKategoriApps3Adapter;
import com.inponsel.android.adapter.ListModel;

// Referenced classes of package com.inponsel.android.v2:
//            AppsByCategory

class this._cls0
    implements android.widget.ClickListener
{

    final AppsByCategory this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/AppsByCategory);
        adapterview.putExtra("id", listKatApps3Adapter.getListModel(i).getId_apps());
        adapterview.putExtra("kategori", listKatApps3Adapter.getListModel(i).getKat_apps_name());
        adapterview.putExtra("tag", listKatApps3Adapter.getListModel(i).getKat_apps_tag());
        adapterview.putExtra("deskripsi", listKatApps3Adapter.getListModel(i).getKat_apps_desc());
        adapterview.putExtra("mod_date", listKatApps3Adapter.getListModel(i).getKat_apps_date());
        adapterview.putExtra("background", listKatApps3Adapter.getListModel(i).getKat_apps_background());
        adapterview.putExtra("background_img", listKatApps3Adapter.getListModel(i).getKat_apps_background_img());
        adapterview.putExtra("total_like", listKatApps3Adapter.getListModel(i).getKat_total_like());
        adapterview.putExtra("mystat", listKatApps3Adapter.getListModel(i).getKat_like_status());
        adapterview.putExtra("myfav", listKatApps3Adapter.getListModel(i).getKat_fav_status());
        adapterview.putExtra("width_img", listKatApps3Adapter.getListModel(i).getKat_img_width());
        adapterview.putExtra("height_img", listKatApps3Adapter.getListModel(i).getKat_img_height());
        adapterview.putExtra("type", listKatApps3Adapter.getListModel(i).getKat_type());
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    pps3Adapter()
    {
        this$0 = AppsByCategory.this;
        super();
    }
}
