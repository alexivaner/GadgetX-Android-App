// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.android.volley.VolleyError;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostBenchmark

class this._cls0
    implements com.android.volley.er
{

    final RoomPostBenchmark this$0;

    public void onErrorResponse(VolleyError volleyerror)
    {
        Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
        RoomPostBenchmark.access$15(RoomPostBenchmark.this);
    }

    ()
    {
        this$0 = RoomPostBenchmark.this;
        super();
    }
}
