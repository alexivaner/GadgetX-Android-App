// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.tlforum;

import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.tlforum:
//            ForumHPActivity

class this._cls0
    implements com.android.volley.tivity._cls48
{

    final ForumHPActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        parseJSONOLD(jsonobject.toString());
        ForumHPActivity.access$6(ForumHPActivity.this);
        ForumHPActivity.access$8(ForumHPActivity.this);
        ponselBaseApp.getObserver().setLoginStat("1");
    }

    ()
    {
        this$0 = ForumHPActivity.this;
        super();
    }
}
