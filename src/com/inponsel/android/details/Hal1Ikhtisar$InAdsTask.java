// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar

private class <init> extends AsyncTask
{

    final Hal1Ikhtisar this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataInAds, 1);
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_332;
            }
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                sucads = avoid.getString("success");
                Log.e("sucadsNative", sucads);
                inponsel = avoid.getJSONArray("InPonsel");
                if (!sucads.equals("1"))
                {
                    break MISSING_BLOCK_LABEL_339;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_339;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_339;
        }
        avoid = inponsel.getJSONObject(i);
        id_ads = avoid.getString("id_ads");
        id_user = avoid.getString("id_user");
        publisher_name = avoid.getString("publisher_name");
        title_ads = avoid.getString("ads_title");
        campaign = avoid.getString("ads_campaign");
        no_ads = avoid.getString("ads_no");
        logo_pub = avoid.getString("logo_pub");
        image_ads = (new StringBuilder(String.valueOf(Util.BASE_PATH_IKADV))).append(avoid.getString("ads_image")).toString();
        link_ads = avoid.getString("ads_link");
        ads_method = avoid.getString("ads_method");
        ads_start = avoid.getString("ads_start");
        ads_finish = avoid.getString("ads_finish");
        ads_status = avoid.getString("ads_status");
        ad_type = avoid.getString("ads_type");
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        Log.e("ServiceHandler", "Couldn't get any data from the url");
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        if (sucads.equals("1"))
        {
            Log.e("title_ads", title_ads);
            if (ad_type.equals("1"))
            {
                inadView = inflaterInAd.inflate(0x7f03002b, ll_inad_native);
            } else
            if (ad_type.equals("2"))
            {
                inadView = inflaterInAd.inflate(0x7f030041, ll_inad_native);
            } else
            if (ad_type.equals("3"))
            {
                inadView = inflaterInAd.inflate(0x7f03002f, ll_inad_native);
            } else
            if (ad_type.equals("4"))
            {
                inadView = inflaterInAd.inflate(0x7f030030, ll_inad_native);
            } else
            if (ad_type.equals("5"))
            {
                inadView = inflaterInAd.inflate(0x7f030032, ll_inad_native);
            } else
            {
                inadView = inflaterInAd.inflate(0x7f030033, ll_inad_native);
            }
            showIn_AD(inadView);
        }
        Log.e("image_ads", image_ads.replaceAll(" ", ""));
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    private _cls9()
    {
        this$0 = Hal1Ikhtisar.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
