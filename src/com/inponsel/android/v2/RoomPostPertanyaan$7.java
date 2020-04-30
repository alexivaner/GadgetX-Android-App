// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostPertanyaan

class this._cls0
    implements com.android.volley.an._cls7
{

    final RoomPostPertanyaan this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        RoomPostPertanyaan.access$10(RoomPostPertanyaan.this, jsonobject.toString());
        json_response = jsonobject.toString();
        RoomPostPertanyaan.access$11(RoomPostPertanyaan.this);
    }

    ()
    {
        this$0 = RoomPostPertanyaan.this;
        super();
    }
}
