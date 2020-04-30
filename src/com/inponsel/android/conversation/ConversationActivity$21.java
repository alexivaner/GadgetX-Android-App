// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationActivity

class this._cls0
    implements com.android.volley.ionActivity._cls21
{

    final ConversationActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        parseJSONOLD(jsonobject.toString());
        ConversationActivity.access$3(ConversationActivity.this);
        ConversationActivity.access$5(ConversationActivity.this);
        ponselBaseApp.getObserver().setLoginStat("1");
    }

    ()
    {
        this$0 = ConversationActivity.this;
        super();
    }
}
