// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.adapter.ListModel;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity

class this._cls0
    implements com.android.volley.y._cls34
{

    final RoomChatActivity this$0;

    private void parseJSONUser(String s)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("InPonsel");
        chat_avaible = jsonobject.getString("success");
        if (jsonobject.getString("success").equals("0")) goto _L2; else goto _L1
_L1:
        int i = 0;
_L5:
        if (i < s.length()) goto _L3; else goto _L2
_L2:
        userJoinAdapter.notifyDataSetChanged();
        return;
_L3:
        try
        {
            JSONObject jsonobject1 = s.getJSONObject(i);
            ListModel listmodel = new ListModel();
            listmodel.setId_user(jsonobject1.getString("id"));
            listmodel.setUsername(jsonobject1.getString("user_name"));
            listmodel.setNama_asli(jsonobject1.getString("nama"));
            listmodel.setAvatar(jsonobject1.getString("user_photo"));
            listmodel.setLast_seen(jsonobject1.getString("last_seen"));
            listmodel.setOnline_stat(jsonobject1.getString("status"));
            chatArray.add(listmodel);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        chatArray.clear();
        parseJSONUser(jsonobject.toString());
    }

    tSCProvAdapter()
    {
        this$0 = RoomChatActivity.this;
        super();
    }
}
