// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.android.volley.VolleyError;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            RoomGroupChatListActivity

class this._cls0
    implements com.android.volley.ty._cls6
{

    final RoomGroupChatListActivity this$0;

    public void onErrorResponse(VolleyError volleyerror)
    {
        Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
    }

    _cls9()
    {
        this$0 = RoomGroupChatListActivity.this;
        super();
    }
}
