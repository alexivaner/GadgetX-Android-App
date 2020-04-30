// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.utils:
//            JSONParser, DatabaseHandler

public class UserFunctions
{

    private static String loginUrl = "http://10.0.2.2/login/";
    private static String login_tag = "login";
    private static String registerURL = "http://10.0.2.2/login/";
    private static String register_tag = "register";
    private JSONParser jsonParser;

    public UserFunctions()
    {
        jsonParser = new JSONParser();
    }

    public boolean isUserLoggedIn(Context context)
    {
        return (new DatabaseHandler(context)).getRowCount() > 0;
    }

    public JSONObject loginUser(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("tag", login_tag));
        arraylist.add(new BasicNameValuePair("email", s));
        arraylist.add(new BasicNameValuePair("password", s1));
        return jsonParser.getJSONFromUrl(loginUrl, arraylist);
    }

    public boolean logoutUser(Context context)
    {
        (new DatabaseHandler(context)).resetTables();
        return true;
    }

    public JSONObject registerUser(String s, String s1, String s2)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("tag", register_tag));
        arraylist.add(new BasicNameValuePair("name", s));
        arraylist.add(new BasicNameValuePair("email", s1));
        arraylist.add(new BasicNameValuePair("password", s2));
        return jsonParser.getJSONFromUrl(registerURL, arraylist);
    }

}
