// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ListUserMessageAdapter;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            InboxMessageActivity, MessageActivity

class this._cls0
    implements android.widget.Listener
{

    final InboxMessageActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(getApplicationContext(), com/inponsel/android/v2/MessageActivity);
        pMessageAdapter.getListModel(i).setUnread_msg("0");
        id_msg = pMessageAdapter.getListModel(i).getId_msg();
        id_to = pMessageAdapter.getListModel(i).getId_from();
        from_name = pMessageAdapter.getListModel(i).getFrom_name();
        from_photo = pMessageAdapter.getListModel(i).getFrom_photo();
        id_from = pMessageAdapter.getListModel(i).getId_to();
        to_name = pMessageAdapter.getListModel(i).getTo_name();
        to_photo = pMessageAdapter.getListModel(i).getTo_photo();
        last_message = pMessageAdapter.getListModel(i).getLast_message();
        message_type = pMessageAdapter.getListModel(i).getMessage_type();
        unread_msg = pMessageAdapter.getListModel(i).getUnread_msg();
        msg_date = pMessageAdapter.getListModel(i).getMsg_date();
        adapterview.putExtra("id_msg", id_msg);
        adapterview.putExtra("id_from", id_from);
        adapterview.putExtra("from_name", from_name);
        adapterview.putExtra("from_photo", from_photo);
        adapterview.putExtra("id_to", id_to);
        adapterview.putExtra("to_name", to_name);
        adapterview.putExtra("to_photo", to_photo);
        adapterview.putExtra("last_message", last_message);
        adapterview.putExtra("message_type", message_type);
        adapterview.putExtra("unread_msg", unread_msg);
        adapterview.putExtra("msg_date", msg_date);
        Log.e("id_to", id_to);
        Log.e("id_from", id_from);
        startActivityForResult(adapterview, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    pter()
    {
        this$0 = InboxMessageActivity.this;
        super();
    }
}
