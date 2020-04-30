// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

class this._cls0
    implements com.android.volley.y._cls48
{

    final HomeNewMainActivity this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        Log.e("response", jsonobject.toString());
        JSONObject jsonobject2;
        int i;
        try
        {
            JSONObject jsonobject1 = new JSONObject(jsonobject.toString());
            Log.e("UpdateEmail", jsonobject.toString());
            jsonobject = jsonobject1.getJSONArray("InPonsel");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            return;
        }
        i = 0;
        if (i >= jsonobject.length())
        {
            return;
        }
        jsonobject2 = jsonobject.getJSONObject(i);
        db.update_EmailbyID(jsonobject2.getString("email"));
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_39;
        }
    }

    ()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
