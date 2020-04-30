// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.statistik;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.statistik:
//            Hal1Hari

class this._cls0
    implements com.android.volley.stener
{

    final Hal1Hari this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        parseJSONGroupChat(jsonobject.toString());
        progressbar_middle.setVisibility(8);
        layout_empty.setVisibility(8);
        no = 0;
        lainAdapter.notifyDataSetChanged();
    }

    stStatAdapter()
    {
        this$0 = Hal1Hari.this;
        super();
    }
}
