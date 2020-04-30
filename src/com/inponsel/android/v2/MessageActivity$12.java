// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.TextView;
import com.inponsel.android.adapter.ListChatMessageAdapter;
import com.inponsel.android.utils.Utility;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            MessageActivity

class this._cls0
    implements com.android.volley.y._cls12
{

    final MessageActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        parseJSON(jsonobject.toString());
        chatMsgAdapter.setListArray(listpMessageArrayList);
        if (listpMessageArrayList.size() == 20)
        {
            txt_OlderMessage.setVisibility(0);
        } else
        {
            txt_OlderMessage.setVisibility(8);
        }
        chatMsgAdapter.notifyDataSetChanged();
        if (online_stat.equals("1"))
        {
            txtLastSeen.setText("Online");
        } else
        {
            txtLastSeen.setText((new StringBuilder("Last seen ")).append(Utility.convertDate(last_seen)).toString());
        }
        txtLastSeen.setVisibility(0);
        MessageActivity.access$13(MessageActivity.this);
    }

    eAdapter()
    {
        this$0 = MessageActivity.this;
        super();
    }
}
