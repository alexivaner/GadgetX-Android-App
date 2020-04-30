// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.TextView;
import com.inponsel.android.adapter.ListChatMessageAdapter;
import com.inponsel.android.utils.Utility;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            MessageActivity

class this._cls0
    implements com.android.volley.y._cls16
{

    final MessageActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        MessageActivity.access$15(MessageActivity.this, jsonobject.toString());
        if (jum_msg != 0)
        {
            chatMsgAdapter.setListArray(listpMessageArrayList);
            chatMsgAdapter.notifyDataSetChanged();
        }
        if (online_stat.equals("1"))
        {
            txtLastSeen.setText("Online");
        } else
        {
            txtLastSeen.setText((new StringBuilder("Last seen ")).append(Utility.convertDate(last_seen)).toString());
        }
        txtLastSeen.setVisibility(0);
    }

    eAdapter()
    {
        this$0 = MessageActivity.this;
        super();
    }
}
