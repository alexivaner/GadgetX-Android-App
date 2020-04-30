// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.DroidWriterEditText;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity

class this._cls0
    implements com.android.volley.y._cls25
{

    final RoomChatActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        Log.e("response", jsonobject.toString());
        RoomChatActivity.access$20(RoomChatActivity.this, jsonobject.toString());
        edt_pop_komen.requestFocus();
        edt_pop_komen.setFocusable(true);
        edt_pop_komen.setText("");
        RoomChatActivity.access$4(RoomChatActivity.this);
    }

    ext()
    {
        this$0 = RoomChatActivity.this;
        super();
    }
}
