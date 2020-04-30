// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomGroupChatListActivity

class val.codename
    implements com.android.volley.ty._cls9
{

    final RoomGroupChatListActivity this$0;
    private final String val$codename;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        Log.e("responseGroup", jsonobject.toString());
        if (!jsonobject.toString().trim().equals("{\"response\":1}"))
        {
            db.delete_groupchat(val$codename);
        }
        ponselBaseApp.getObserver().setLoginStat("1");
    }

    _cls9()
    {
        this$0 = final_roomgroupchatlistactivity;
        val$codename = String.this;
        super();
    }
}
