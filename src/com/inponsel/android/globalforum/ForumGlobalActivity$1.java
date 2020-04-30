// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.timelinedetail.Hal1TLDetailActivity;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class this._cls0
    implements android.widget.kListener
{

    final ForumGlobalActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(ForumGlobalActivity.this, com/inponsel/android/timelinedetail/Hal1TLDetailActivity);
        adapterview.putExtra("id_artanya", mBenchAdapter.getListModel(i).getForum_id());
        adapterview.putExtra("act", "first");
        adapterview.putExtra("tl_judul", mBenchAdapter.getListModel(i).getForum_judul());
        adapterview.putExtra("tl_content", mBenchAdapter.getListModel(i).getForum_content());
        adapterview.putExtra("tl_content_ext", mBenchAdapter.getListModel(i).getForum_content_ext());
        adapterview.putExtra("tl_codename", mBenchAdapter.getListModel(i).getCodename());
        adapterview.putExtra("tl_date", mBenchAdapter.getListModel(i).getForum_date());
        adapterview.putExtra("tl_id", mBenchAdapter.getListModel(i).getForum_id());
        adapterview.putExtra("tl_id_hp", mBenchAdapter.getListModel(i).getId_hp());
        adapterview.putExtra("tl_id_user", mBenchAdapter.getListModel(i).getId_user());
        adapterview.putExtra("tl_img_url", mBenchAdapter.getListModel(i).getForum_img());
        adapterview.putExtra("tl_tag", mBenchAdapter.getListModel(i).getForum_tag());
        adapterview.putExtra("tl_type", mBenchAdapter.getListModel(i).getForum_type());
        adapterview.putExtra("tl_username", mBenchAdapter.getListModel(i).getUsername());
        adapterview.putExtra("tl_kota", mBenchAdapter.getListModel(i).getKota());
        adapterview.putExtra("tl_userphoto", mBenchAdapter.getListModel(i).getAvatar());
        adapterview.putExtra("total_like", mBenchAdapter.getListModel(i).getForum_like());
        adapterview.putExtra("fav_stat", mBenchAdapter.getListModel(i).getForum_myfav());
        adapterview.putExtra("like_stat", mBenchAdapter.getListModel(i).getForum_mylike());
        adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(mBenchAdapter.getListModel(i).getMerk()))).append(" ").append(mBenchAdapter.getListModel(i).getModel()).toString());
        adapterview.putExtra("resolution", resolution);
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    nchAdapter()
    {
        this$0 = ForumGlobalActivity.this;
        super();
    }
}
