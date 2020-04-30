// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListGroupMemberAdapter;
import com.inponsel.android.adapter.ListModel;

// Referenced classes of package com.inponsel.android.v2:
//            RoomGroupChatListActivity

class this._cls0
    implements android.widget.istener
{

    final RoomGroupChatListActivity this$0;

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        RoomGroupChatListActivity.access$2(RoomGroupChatListActivity.this, "Perhatian", "Berhenti mengikuti chat room ini?", pMessageAdapter.getListModel(i).getCodename().toString());
        return true;
    }

    _cls9()
    {
        this$0 = RoomGroupChatListActivity.this;
        super();
    }
}
