// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListGroupMemberAdapter;
import com.inponsel.android.adapter.ListModel;

// Referenced classes of package com.inponsel.android.v2:
//            RoomGroupChatListActivity, RoomChatActivity

class this._cls0
    implements android.widget.ner
{

    final RoomGroupChatListActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/RoomChatActivity);
        adapterview.putExtra("id_from", user_id);
        adapterview.putExtra("from_name", username);
        adapterview.putExtra("from_photo", pMessageAdapter.getListModel(i).getGambar());
        adapterview.putExtra("to_photo", pMessageAdapter.getListModel(i).getGambar());
        adapterview.putExtra("id_hph", pMessageAdapter.getListModel(i).getId_hp());
        adapterview.putExtra("merk", pMessageAdapter.getListModel(i).getMerk());
        adapterview.putExtra("model", pMessageAdapter.getListModel(i).getModel());
        adapterview.putExtra("codename", (new StringBuilder(String.valueOf(pMessageAdapter.getListModel(i).getCodename()))).append("-").append(pMessageAdapter.getListModel(i).getCodename()).toString());
        RoomGroupChatListActivity.access$1(RoomGroupChatListActivity.this, user_id, pMessageAdapter.getListModel(i).getCodename(), "1", t, "");
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    _cls9()
    {
        this$0 = RoomGroupChatListActivity.this;
        super();
    }
}
