// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.utils.Log;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostHasilFotoNoCrop

class this._cls0
    implements com.android.volley.p._cls10
{

    final RoomPostHasilFotoNoCrop this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        Log.e("jsonKamera", jsonobject.toString());
        RoomPostHasilFotoNoCrop.access$10(RoomPostHasilFotoNoCrop.this, jsonobject.toString());
        json_response = jsonobject.toString();
        RoomPostHasilFotoNoCrop.access$11(RoomPostHasilFotoNoCrop.this);
    }

    ()
    {
        this$0 = RoomPostHasilFotoNoCrop.this;
        super();
    }
}
