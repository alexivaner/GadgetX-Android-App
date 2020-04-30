// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.ListView;
import com.inponsel.android.adapter.ListUserMessageAdapter;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import java.util.TimerTask;

// Referenced classes of package com.inponsel.android.v2:
//            InboxMessageActivity

class this._cls0 extends TimerTask
{

    final InboxMessageActivity this$0;

    public void run()
    {
        Log.e("timertask", "running");
        runOnUiThread(new Runnable() {

            final InboxMessageActivity.MyTimerTask this$1;

            public void run()
            {
                if (db.getInBoxCount() > 0)
                {
                    listpMessageArrayList = loadInboxDB();
                    pMessageAdapter = new ListUserMessageAdapter(this$0, 0x7f0300c0, listpMessageArrayList);
                    listPMessage.setAdapter(pMessageAdapter);
                    loadDataInbox();
                    return;
                } else
                {
                    InboxMessageActivity inboxmessageactivity = this$0;
                    inboxmessageactivity.countRefresh = inboxmessageactivity.countRefresh + 1;
                    pMessageAdapter = new ListUserMessageAdapter(this$0, 0x7f0300c0, listpMessageArrayList);
                    listPMessage.setAdapter(pMessageAdapter);
                    InboxMessageActivity.access$0(this$0);
                    return;
                }
            }

            
            {
                this$1 = InboxMessageActivity.MyTimerTask.this;
                super();
            }
        });
    }


    _cls1.this._cls1()
    {
        this$0 = InboxMessageActivity.this;
        super();
    }
}
