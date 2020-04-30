// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.adapter.ListGroupMemberAdapter;
import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomGroupChatListActivity

class this._cls0
    implements com.android.volley.ty._cls3
{

    final RoomGroupChatListActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        parseJSON(jsonobject.toString());
        pMessageAdapter.setListArray(listpMessageArrayList);
        pMessageAdapter.notifyDataSetChanged();
        RoomGroupChatListActivity.access$3(RoomGroupChatListActivity.this);
        ponselBaseApp.getObserver().setLoginStat("1");
    }

    _cls9()
    {
        this$0 = RoomGroupChatListActivity.this;
        super();
    }
}
