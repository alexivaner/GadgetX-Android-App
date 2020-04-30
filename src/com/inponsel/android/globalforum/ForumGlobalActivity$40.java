// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class this._cls0
    implements com.android.volley.alActivity._cls40
{

    final ForumGlobalActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        parseJSONOLD(jsonobject.toString());
        ForumGlobalActivity.access$5(ForumGlobalActivity.this);
        ForumGlobalActivity.access$7(ForumGlobalActivity.this);
        ponselBaseApp.getObserver().setLoginStat("1");
    }

    ()
    {
        this$0 = ForumGlobalActivity.this;
        super();
    }
}
