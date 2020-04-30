// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationPost

class this._cls0
    implements com.android.volley.ersationPost._cls7
{

    final ConversationPost this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        ConversationPost.access$10(ConversationPost.this, jsonobject.toString());
        json_response = jsonobject.toString();
        ConversationPost.access$11(ConversationPost.this);
    }

    ()
    {
        this$0 = ConversationPost.this;
        super();
    }
}
