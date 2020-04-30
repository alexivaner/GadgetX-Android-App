// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPostArtikel

class this._cls0
    implements com.android.volley.l._cls10
{

    final RoomPostArtikel this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        RoomPostArtikel.access$10(RoomPostArtikel.this, jsonobject.toString());
        json_response = jsonobject.toString();
        RoomPostArtikel.access$11(RoomPostArtikel.this);
        if (post_action.equals("edit"))
        {
            finish();
            return;
        }
        if (android.os.NT >= 11)
        {
            (new dMailTask(RoomPostArtikel.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else
        {
            (new dMailTask(RoomPostArtikel.this)).execute(new Void[0]);
        }
        finish();
    }

    dMailTask()
    {
        this$0 = RoomPostArtikel.this;
        super();
    }
}
