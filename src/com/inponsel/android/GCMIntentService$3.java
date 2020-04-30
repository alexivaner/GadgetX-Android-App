// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android;

import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android:
//            GCMIntentService

class this._cls0
    implements com.android.volley._cls3
{

    final GCMIntentService this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        parseJSONSC(jsonobject.toString());
        ponselBaseApp.getObserver().setLoginStat("1");
    }

    er()
    {
        this$0 = GCMIntentService.this;
        super();
    }
}
