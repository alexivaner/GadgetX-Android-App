// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.statistik;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.ExpandableHeightGridView;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.statistik:
//            Hal2Minggu

class this._cls0
    implements com.android.volley.ener
{

    final Hal2Minggu this$0;

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
        Log.e("", String.valueOf(statistikArray.size()));
        listStat.setVisibility(0);
    }

    GridView()
    {
        this$0 = Hal2Minggu.this;
        super();
    }
}
