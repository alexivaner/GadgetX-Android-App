// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.LinearLayout;
import com.inponsel.android.adapter.ListHPPeopleAdapter;
import com.inponsel.android.utils.Log;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomPenggunaHp

class this._cls0
    implements com.android.volley.
{

    final RoomPenggunaHp this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        parseJSON(jsonobject.toString());
        hpPeopleAdapter.setListArray(hpPeopleArrayList);
        hpPeopleAdapter.notifyDataSetChanged();
        Log.e("countter", String.valueOf(hpPeopleArrayList.size()));
        if (hpPeopleArrayList.size() < 20)
        {
            grup_footer.setVisibility(8);
        } else
        {
            grup_footer.setVisibility(0);
        }
        RoomPenggunaHp.access$1(RoomPenggunaHp.this);
    }

    Adapter()
    {
        this$0 = RoomPenggunaHp.this;
        super();
    }
}
