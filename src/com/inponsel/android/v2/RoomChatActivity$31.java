// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity

class val.status
    implements com.android.volley.y._cls31
{

    final RoomChatActivity this$0;
    private final String val$status;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        val$status.equals("1");
    }

    ()
    {
        this$0 = final_roomchatactivity;
        val$status = String.this;
        super();
    }
}
