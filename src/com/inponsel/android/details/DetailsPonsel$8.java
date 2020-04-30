// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.text.Html;
import com.actionbarsherlock.app.ActionBar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            DetailsPonsel

class this._cls0
    implements com.android.volley.r
{

    final DetailsPonsel this$0;

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        JSONObject jsonobject1;
        int i;
        try
        {
            jsonobject = (new JSONObject(jsonobject.toString())).getJSONArray("InPonsel");
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
        jsonobject1 = jsonobject.getJSONObject(i);
        getSupportActionBar().setTitle(Html.fromHtml((new StringBuilder("<font color='#FFFFFF'>")).append(jsonobject1.getString("namalengkap")).append("</font>").toString()));
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_19;
        }
    }

    ()
    {
        this$0 = DetailsPonsel.this;
        super();
    }
}
