// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity, ProfileOtherUser

class this._cls0
    implements android.widget.lickListener
{

    final RoomChatActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(RoomChatActivity.this, com/inponsel/android/v2/ProfileOtherUser);
        Log.e("user_name", userJoinAdapter.getListModel(i).getUsername());
        adapterview.putExtra("id_user_view", userJoinAdapter.getListModel(i).getUsername());
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    stSCProvAdapter()
    {
        this$0 = RoomChatActivity.this;
        super();
    }
}
