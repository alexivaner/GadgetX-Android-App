// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.ListView;
import com.inponsel.android.adapter.ListUserMessageAdapter;
import com.inponsel.android.utils.DatabaseHandler;

// Referenced classes of package com.inponsel.android.v2:
//            InboxMessageActivity

class this._cls1
    implements Runnable
{

    final this._cls1 this$1;

    public void run()
    {
        if (cess._mth0(this._cls1.this).db.getInBoxCount() > 0)
        {
            cess._mth0(this._cls1.this).listpMessageArrayList = cess._mth0(this._cls1.this).loadInboxDB();
            cess._mth0(this._cls1.this).pMessageAdapter = new ListUserMessageAdapter(cess._mth0(this._cls1.this), 0x7f0300c0, cess._mth0(this._cls1.this).listpMessageArrayList);
            cess._mth0(this._cls1.this).listPMessage.setAdapter(cess._mth0(this._cls1.this).pMessageAdapter);
            cess._mth0(this._cls1.this).loadDataInbox();
            return;
        } else
        {
            InboxMessageActivity inboxmessageactivity = cess._mth0(this._cls1.this);
            inboxmessageactivity.countRefresh = inboxmessageactivity.countRefresh + 1;
            cess._mth0(this._cls1.this).pMessageAdapter = new ListUserMessageAdapter(cess._mth0(this._cls1.this), 0x7f0300c0, cess._mth0(this._cls1.this).listpMessageArrayList);
            cess._mth0(this._cls1.this).listPMessage.setAdapter(cess._mth0(this._cls1.this).pMessageAdapter);
            InboxMessageActivity.access$0(cess._mth0(this._cls1.this));
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
