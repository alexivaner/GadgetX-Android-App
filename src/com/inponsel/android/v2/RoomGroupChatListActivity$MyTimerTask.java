// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.net.NetworkInfo;
import android.widget.ListView;
import com.inponsel.android.adapter.ListGroupMemberAdapter;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import java.util.TimerTask;

// Referenced classes of package com.inponsel.android.v2:
//            RoomGroupChatListActivity

class this._cls0 extends TimerTask
{

    final RoomGroupChatListActivity this$0;

    public void run()
    {
        Log.e("timertask", "running");
        runOnUiThread(new Runnable() {

            final RoomGroupChatListActivity.MyTimerTask this$1;

            public void run()
            {
                if (db.getGroupChatCount() > 0)
                {
                    if (countRefresh > 0 && netInfo != null && netInfo.isConnected())
                    {
                        Log.e("refresh", "1");
                        pMessageAdapter = new ListGroupMemberAdapter(this$0, 0x7f0300c1, listpMessageArrayList);
                        listPMessage.setAdapter(pMessageAdapter);
                        RoomGroupChatListActivity.access$0(this$0);
                        return;
                    } else
                    {
                        Log.e("refresh", "2");
                        RoomGroupChatListActivity roomgroupchatlistactivity = this$0;
                        roomgroupchatlistactivity.countRefresh = roomgroupchatlistactivity.countRefresh + 1;
                        listpMessageArrayList = loadInboxDB();
                        pMessageAdapter = new ListGroupMemberAdapter(this$0, 0x7f0300c1, listpMessageArrayList);
                        listPMessage.setAdapter(pMessageAdapter);
                        loadDataInbox();
                        return;
                    }
                } else
                {
                    Log.e("refresh", "3");
                    pMessageAdapter = new ListGroupMemberAdapter(this$0, 0x7f0300c1, listpMessageArrayList);
                    listPMessage.setAdapter(pMessageAdapter);
                    RoomGroupChatListActivity.access$0(this$0);
                    return;
                }
            }

            
            {
                this$1 = RoomGroupChatListActivity.MyTimerTask.this;
                super();
            }
        });
    }


    _cls1.this._cls1()
    {
        this$0 = RoomGroupChatListActivity.this;
        super();
    }
}
