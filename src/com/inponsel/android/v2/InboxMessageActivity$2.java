// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.adapter.ListUserMessageAdapter;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            InboxMessageActivity

class this._cls0
    implements com.android.volley.ty._cls2
{

    final InboxMessageActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        parseJSON(jsonobject.toString());
        pMessageAdapter.setListArray(listpMessageArrayList);
        pMessageAdapter.notifyDataSetChanged();
        InboxMessageActivity.access$1(InboxMessageActivity.this);
        ponselBaseApp.getObserver().setUpdateType("inboxchatroom");
        ponselBaseApp.getObserver().setLoginStat("1");
    }

    pter()
    {
        this$0 = InboxMessageActivity.this;
        super();
    }
}
