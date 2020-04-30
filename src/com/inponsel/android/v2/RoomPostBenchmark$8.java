// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostBenchmark

class this._cls0
    implements com.android.volley.rk._cls8
{

    final RoomPostBenchmark this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        RoomPostBenchmark.access$14(RoomPostBenchmark.this, jsonobject.toString());
        json_response = jsonobject.toString();
        RoomPostBenchmark.access$15(RoomPostBenchmark.this);
    }

    ()
    {
        this$0 = RoomPostBenchmark.this;
        super();
    }
}
