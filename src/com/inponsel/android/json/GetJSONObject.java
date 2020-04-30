// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.json;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.json:
//            JSONParser

public class GetJSONObject
{

    public GetJSONObject()
    {
    }

    public static JSONObject getJSONObject(String s)
        throws IOException, JSONException
    {
        JSONParser jsonparser = new JSONParser();
        if (android.os.Build.VERSION.SDK_INT > 8)
        {
            return jsonparser.getJSONHttpURLConnection(s);
        } else
        {
            return jsonparser.getJSONHttpClient(s);
        }
    }
}
