// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.adapter.ListChatMessageAdapter;
import com.inponsel.android.widget.DroidWriterEditText;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            MessageActivity

class this._cls0
    implements com.android.volley.y._cls14
{

    final MessageActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        MessageActivity.access$14(MessageActivity.this, jsonobject.toString());
        edt_pop_komen.requestFocus();
        edt_pop_komen.setFocusable(true);
        chatMsgAdapter.notifyDataSetChanged();
        edt_pop_komen.setText("");
        MessageActivity.access$2(MessageActivity.this);
    }

    eAdapter()
    {
        this$0 = MessageActivity.this;
        super();
    }
}
