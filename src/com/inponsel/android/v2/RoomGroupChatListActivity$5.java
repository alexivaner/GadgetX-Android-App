// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomGroupChatListActivity

class this._cls0
    implements com.android.volley.ty._cls5
{

    final RoomGroupChatListActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
    }

    _cls9()
    {
        this$0 = RoomGroupChatListActivity.this;
        super();
    }
}
