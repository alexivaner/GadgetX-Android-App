// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.adapter.ModelObserver;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Log;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeForumActivity

class this._cls0
    implements com.android.volley.y._cls26
{

    final HomeForumActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        HomeForumActivity.access$0(HomeForumActivity.this).clear();
        parseJSONNew(jsonobject.toString());
        Log.e("succesStat", succesStat);
        if (succesStat.equals("1"))
        {
            HomeForumActivity.access$3(HomeForumActivity.this);
        }
        ponselBaseApp.getObserver().setLoginStat("1");
    }

    ()
    {
        this$0 = HomeForumActivity.this;
        super();
    }
}
