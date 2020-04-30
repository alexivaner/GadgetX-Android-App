// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.net.NetworkInfo;
import android.view.View;
import com.inponsel.android.adapter.ListChatMessageAdapter;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            MessageActivity

class this._cls0
    implements android.view.er
{

    final MessageActivity this$0;

    public void onClick(View view)
    {
        if (netInfo != null && netInfo.isConnected())
        {
            Log.e("GetOlderMessage", "online");
            MessageActivity.access$11(MessageActivity.this, id_from, id_to, t, top_id);
            return;
        } else
        {
            Log.e("GetOlderMessage", "offline");
            listpMessageArrayList = loadInboxDB("older");
            chatMsgAdapter.notifyDataSetChanged();
            return;
        }
    }

    geAdapter()
    {
        this$0 = MessageActivity.this;
        super();
    }
}
