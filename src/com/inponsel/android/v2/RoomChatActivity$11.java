// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.net.NetworkInfo;
import android.view.View;
import com.inponsel.android.adapter.ListChatGroupAdapter;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity

class this._cls0
    implements android.view.
{

    final RoomChatActivity this$0;

    public void onClick(View view)
    {
        if (netInfo != null && netInfo.isConnected())
        {
            Log.e("GetOlderMessage", "online");
            RoomChatActivity.access$15(RoomChatActivity.this, id_from, codename, t, top_id);
            return;
        } else
        {
            Log.e("GetOlderMessage", "offline");
            listpMessageArrayList = loadInboxDB("older");
            chatMsgAdapter.notifyDataSetChanged();
            return;
        }
    }

    apter()
    {
        this$0 = RoomChatActivity.this;
        super();
    }
}
