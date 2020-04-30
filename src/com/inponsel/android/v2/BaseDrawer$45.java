// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer

class seHandler extends AsyncHttpResponseHandler
{

    final BaseDrawer this$0;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
    }

    public void onRetry(int i)
    {
    }

    public void onStart()
    {
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        String s7;
        String s8;
        String s9;
        String s10;
        String s11;
        String s12;
        String s13;
        String s14;
        String s15;
        Object obj;
        try
        {
            aheader = (new JSONObject(new String(abyte0))).getJSONArray("InPonsel");
        }
        // Misplaced declaration of an exception variable
        catch (Header aheader[])
        {
            aheader.printStackTrace();
            return;
        }
        i = 0;
        if (i >= aheader.length())
        {
            return;
        }
        obj = aheader.getJSONObject(i);
        abyte0 = new DatabaseHandler(getApplicationContext());
        s = ((JSONObject) (obj)).getString("name");
        s1 = ((JSONObject) (obj)).getString("avatar");
        s2 = ((JSONObject) (obj)).getString("uname");
        s3 = ((JSONObject) (obj)).getString("umail");
        s4 = ((JSONObject) (obj)).getString("uborn");
        s5 = ((JSONObject) (obj)).getString("uprov");
        s6 = ((JSONObject) (obj)).getString("ucity");
        s7 = ((JSONObject) (obj)).getString("ukec");
        s8 = ((JSONObject) (obj)).getString("ugen");
        s9 = ((JSONObject) (obj)).getString("uphone1");
        s10 = ((JSONObject) (obj)).getString("uphone2");
        s11 = ((JSONObject) (obj)).getString("uope1");
        s12 = ((JSONObject) (obj)).getString("uope2");
        s13 = ((JSONObject) (obj)).getString("ujdate");
        s14 = ((JSONObject) (obj)).getString("modified_date");
        s15 = ((JSONObject) (obj)).getString("codephone1");
        obj = ((JSONObject) (obj)).getString("codephone2");
        Log.e("user_photo", s1);
        abyte0.update_by_site(s, s1, s2, s3, s4, s5, s6, s8, s9, s10, s11, s12, s13, s14, s15, ((String) (obj)), s7);
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_23;
        }
    }

    dler()
    {
        this$0 = BaseDrawer.this;
        super();
    }
}
