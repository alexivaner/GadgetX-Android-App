// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import com.inponsel.android.utils.Log;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

class this._cls0
    implements com.android.volley.tener
{

    final Hal2Spek this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        Log.e("responseGroup", jsonobject.toString());
    }

    ()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
