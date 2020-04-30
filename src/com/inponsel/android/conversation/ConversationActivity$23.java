// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationActivity

class this._cls0
    implements com.android.volley.ionActivity._cls23
{

    final ConversationActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        ConversationActivity.access$0(ConversationActivity.this).clear();
        parseJSONNew(jsonobject.toString());
        Log.e("succesStat", succesStat);
        if (succesStat.equals("1"))
        {
            ConversationActivity.access$3(ConversationActivity.this);
        }
        ponselBaseApp.getObserver().setLoginStat("1");
    }

    ()
    {
        this$0 = ConversationActivity.this;
        super();
    }
}
