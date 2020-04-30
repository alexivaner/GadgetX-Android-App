// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.inponsel.android.adapter.TrafficModel;
import com.inponsel.android.adapter.TwitterAdapter;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            TwitterVendor

private class <init> extends AsyncTask
{

    final TwitterVendor this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataSearch, 1);
            Log.e("Responseharga: ", (new StringBuilder("> ")).append(avoid).toString());
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_200;
            }
            TrafficModel trafficmodel;
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                inponsel = avoid.getJSONArray("InPonsel");
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_207;
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_207;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_207;
        }
        avoid = inponsel.getJSONObject(i);
        trafficmodel = new TrafficModel();
        trafficmodel.setScreen_name(avoid.getString("screen_name"));
        trafficmodel.setTweet_content(avoid.getString("tweet_content"));
        trafficmodel.setAvatar(avoid.getString("avatar"));
        trafficmodel.setMedia_url(avoid.getString("media_url"));
        trafficmodel.setTweet_time(avoid.getString("tweet_time"));
        trafficmodel.setSince_id(avoid.getString("since_id"));
        listArray.add(trafficmodel);
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        Log.e("ServiceHandlerPen", "Couldn't get any data from the url");
        return null;
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
            progressbar_middle.setVisibility(8);
            listAdapter.notifyDataSetChanged();
            Log.e("tasksdsurlSearch", dataSearch);
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

    private ()
    {
        this$0 = TwitterVendor.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
