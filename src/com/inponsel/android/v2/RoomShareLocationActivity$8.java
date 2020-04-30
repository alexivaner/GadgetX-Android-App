// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.utils.Log;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomShareLocationActivity

class this._cls0
    implements com.android.volley.ty._cls8
{

    final RoomShareLocationActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        Log.e("response", jsonobject.toString());
        progbar_location.setVisibility(8);
        finish();
    }

    ssBar()
    {
        this$0 = RoomShareLocationActivity.this;
        super();
    }
}
