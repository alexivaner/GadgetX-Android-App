// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationActivity, ConversationDetailActivity

class this._cls0
    implements android.widget.Listener
{

    final ConversationActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(ConversationActivity.this, com/inponsel/android/conversation/ConversationDetailActivity);
        adapterview.putExtra("id_artanya", mFotoKameraAdapter.getListModel(i).getForum_id());
        adapterview.putExtra("act", "first");
        adapterview.putExtra("tl_judul", mFotoKameraAdapter.getListModel(i).getForum_judul());
        adapterview.putExtra("tl_content", mFotoKameraAdapter.getListModel(i).getForum_content());
        adapterview.putExtra("tl_content_ext", mFotoKameraAdapter.getListModel(i).getForum_content_ext());
        adapterview.putExtra("tl_codename", mFotoKameraAdapter.getListModel(i).getCodename());
        adapterview.putExtra("tl_date", mFotoKameraAdapter.getListModel(i).getForum_date());
        adapterview.putExtra("tl_id", mFotoKameraAdapter.getListModel(i).getForum_id());
        adapterview.putExtra("tl_id_hp", mFotoKameraAdapter.getListModel(i).getId_hp());
        adapterview.putExtra("tl_id_user", mFotoKameraAdapter.getListModel(i).getId_user());
        adapterview.putExtra("tl_img_url", mFotoKameraAdapter.getListModel(i).getForum_img());
        adapterview.putExtra("tl_tag", mFotoKameraAdapter.getListModel(i).getForum_tag());
        adapterview.putExtra("tl_type", mFotoKameraAdapter.getListModel(i).getForum_type());
        adapterview.putExtra("tl_username", mFotoKameraAdapter.getListModel(i).getUsername());
        adapterview.putExtra("tl_kota", mFotoKameraAdapter.getListModel(i).getKota());
        adapterview.putExtra("tl_userphoto", mFotoKameraAdapter.getListModel(i).getAvatar());
        adapterview.putExtra("total_like", mFotoKameraAdapter.getListModel(i).getForum_like());
        adapterview.putExtra("fav_stat", mFotoKameraAdapter.getListModel(i).getForum_myfav());
        adapterview.putExtra("like_stat", mFotoKameraAdapter.getListModel(i).getForum_mylike());
        adapterview.putExtra("namalengkap", (new StringBuilder(String.valueOf(mFotoKameraAdapter.getListModel(i).getMerk()))).append(" ").append(mFotoKameraAdapter.getListModel(i).getModel()).toString());
        adapterview.putExtra("resolution", resolution);
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    toKameraAdapter()
    {
        this$0 = ConversationActivity.this;
        super();
    }
}
