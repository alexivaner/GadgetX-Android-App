// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.widget.Toast;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal1TLDetailActivity

public class this._cls0 extends AsyncTask
{

    final Hal1TLDetailActivity this$0;

    private void parseJSONFlag(String s)
    {
        try
        {
            s = new JSONObject(s);
            postStatusFlagKom = s.getString("success");
            postMessageFlagKom = s.getString("message");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            if (android.os.ailActivity.PostFlagTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.nit>(avoid)).rmitDiskWrites().ild());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("flag_artanya.php?").append(queryFlag).toString();
            Log.e("pushURLFlag", avoid);
            avoid = HttpPush.getResponse(avoid);
            resFlag = avoid.toString();
            parseJSONFlag(resFlag);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        Toast.makeText(Hal1TLDetailActivity.this, postMessageFlagKom, 1).show();
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        Toast.makeText(Hal1TLDetailActivity.this, "Mengirim laporan...", 1).show();
    }

    public ()
    {
        this$0 = Hal1TLDetailActivity.this;
        super();
    }
}
