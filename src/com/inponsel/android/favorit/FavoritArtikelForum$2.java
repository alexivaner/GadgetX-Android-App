// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.timelinedetail.Hal1TLDetailActivity;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.favorit:
//            FavoritArtikelForum

class this._cls0
    implements android.widget.kListener
{

    final FavoritArtikelForum this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(FavoritArtikelForum.this, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
        adapterview.putExtra("id_artanya", kameraAdapter.getListModel(i).getId_content());
        adapterview.putExtra("act", "fav");
        adapterview.putExtra("tl_judul", kameraAdapter.getListModel(i).getRoom_title());
        adapterview.putExtra("tl_content", kameraAdapter.getListModel(i).getRoom_content());
        adapterview.putExtra("tl_content_ext", kameraAdapter.getListModel(i).getRoom_content_ext());
        adapterview.putExtra("merk", kameraAdapter.getListModel(i).getMerk());
        adapterview.putExtra("model", kameraAdapter.getListModel(i).getModel());
        adapterview.putExtra("tl_codename", kameraAdapter.getListModel(i).getCodename());
        adapterview.putExtra("tl_date", kameraAdapter.getListModel(i).getRoom_date());
        adapterview.putExtra("tl_id", kameraAdapter.getListModel(i).getId_content());
        adapterview.putExtra("tl_id_hp", kameraAdapter.getListModel(i).getId_hp());
        adapterview.putExtra("tl_id_user", "");
        adapterview.putExtra("tl_img_url", kameraAdapter.getListModel(i).getRoom_path_image());
        adapterview.putExtra("tl_tag", kameraAdapter.getListModel(i).getTag_artikel());
        adapterview.putExtra("tl_type", kameraAdapter.getListModel(i).getTl_type());
        adapterview.putExtra("tl_username", "");
        adapterview.putExtra("tl_userphoto", "");
        adapterview.putExtra("total_like", "");
        adapterview.putExtra("fav_stat", "");
        adapterview.putExtra("like_stat", "");
        Log.e("tl_content_ext", "");
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    startikelAdapter()
    {
        this$0 = FavoritArtikelForum.this;
        super();
    }
}
