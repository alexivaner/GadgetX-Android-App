// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.net.NetworkInfo;
import android.widget.ListView;
import com.inponsel.android.adapter.ListGroupMemberAdapter;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            RoomGroupChatListActivity

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
        if (cess._mth0(this._cls1.this).db.getGroupChatCount() > 0)
        {
            if (cess._mth0(this._cls1.this).countRefresh > 0 && cess._mth0(this._cls1.this).netInfo != null && cess._mth0(this._cls1.this).netInfo.isConnected())
            {
                Log.e("refresh", "1");
                cess._mth0(this._cls1.this).pMessageAdapter = new ListGroupMemberAdapter(cess._mth0(this._cls1.this), 0x7f0300c1, cess._mth0(this._cls1.this).listpMessageArrayList);
                cess._mth0(this._cls1.this).listPMessage.setAdapter(cess._mth0(this._cls1.this).pMessageAdapter);
                RoomGroupChatListActivity.access$0(cess._mth0(this._cls1.this));
                return;
            } else
            {
                Log.e("refresh", "2");
                RoomGroupChatListActivity roomgroupchatlistactivity = cess._mth0(this._cls1.this);
                roomgroupchatlistactivity.countRefresh = roomgroupchatlistactivity.countRefresh + 1;
                cess._mth0(this._cls1.this).listpMessageArrayList = cess._mth0(this._cls1.this).loadInboxDB();
                cess._mth0(this._cls1.this).pMessageAdapter = new ListGroupMemberAdapter(cess._mth0(this._cls1.this), 0x7f0300c1, cess._mth0(this._cls1.this).listpMessageArrayList);
                cess._mth0(this._cls1.this).listPMessage.setAdapter(cess._mth0(this._cls1.this).pMessageAdapter);
                cess._mth0(this._cls1.this).loadDataInbox();
                return;
            }
        } else
        {
            Log.e("refresh", "3");
            cess._mth0(this._cls1.this).pMessageAdapter = new ListGroupMemberAdapter(cess._mth0(this._cls1.this), 0x7f0300c1, cess._mth0(this._cls1.this).listpMessageArrayList);
            cess._mth0(this._cls1.this).listPMessage.setAdapter(cess._mth0(this._cls1.this).pMessageAdapter);
            RoomGroupChatListActivity.access$0(cess._mth0(this._cls1.this));
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
