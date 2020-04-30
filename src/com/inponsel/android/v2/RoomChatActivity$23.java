// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.adapter.ListChatGroupAdapter;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity

class this._cls0
    implements com.android.volley.y._cls23
{

    final RoomChatActivity this$0;

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
        if (statJoinChat.equals("1"))
        {
            btn_JoinGroupChat.setBackgroundResource(0x7f02013b);
            btn_JoinGroupChat.setText("Hapus");
            btn_JoinGroupChat.setTextColor(getResources().getColor(0x7f080182));
            itemTurnNotif.setChecked(true);
        } else
        {
            btn_JoinGroupChat.setBackgroundResource(0x7f02013a);
            btn_JoinGroupChat.setText("Ikuti");
            btn_JoinGroupChat.setTextColor(getResources().getColor(0x7f080181));
            itemTurnNotif.setChecked(false);
        }
        chatMsgAdapter.notifyDataSetChanged();
        txtLastSeen.setVisibility(8);
        RoomChatActivity.access$19(RoomChatActivity.this);
    }

    apter()
    {
        this$0 = RoomChatActivity.this;
        super();
    }
}
