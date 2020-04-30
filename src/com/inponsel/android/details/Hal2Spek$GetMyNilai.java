// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.os.AsyncTask;
import android.widget.Button;
import com.inponsel.android.utils.RestClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

public class this._cls0 extends AsyncTask
{

    JSONArray jArray;
    final Hal2Spek this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        int i;
        int j;
        j = as.length;
        i = 0;
_L3:
        if (i >= j)
        {
            return null;
        }
        Object obj = new RestClient(as[i]);
        ((RestClient) (obj)).Execute(com.inponsel.android.utils.thod.GET);
_L1:
        Exception exception1;
        try
        {
            obj = ((RestClient) (obj)).getResponse();
            getJson = ((String) (obj));
            parseJSON(((String) (obj)));
        }
        catch (Exception exception) { }
        break MISSING_BLOCK_LABEL_65;
        exception1;
        exception1.printStackTrace();
          goto _L1
        i++;
        if (true) goto _L3; else goto _L2
_L2:
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        try
        {
            btnDesainRate.setText(nilbtnDesain);
            btnLayarRate.setText(nilbtnLayar);
            btnKinerjaRate.setText(nilbtnKinerja);
            btnKameraRate.setText(nilbtnKamera);
            btnBateraiRate.setText(nilbtnBaterai);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    void parseJSON(String s)
    {
        int i;
        try
        {
            jArray = (new JSONObject(s)).getJSONArray("InPonsel");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        i = 0;
        if (i >= jArray.length())
        {
            return;
        }
        s = jArray.getJSONObject(i);
        nilbtnDesain = s.getString("rating_hp_desain");
        nilbtnLayar = s.getString("rating_hp_layar");
        nilbtnKinerja = s.getString("rating_hp_kinerja");
        nilbtnKamera = s.getString("rating_hp_kamera");
        nilbtnBaterai = s.getString("rating_hp_baterai");
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_19;
        }
    }

    public od()
    {
        this$0 = Hal2Spek.this;
        super();
    }
}
