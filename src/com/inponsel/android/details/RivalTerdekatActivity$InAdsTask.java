// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.SCUserActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            RivalTerdekatActivity, DetailsPonsel

private class <init> extends AsyncTask
{

    final RivalTerdekatActivity this$0;

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
                break MISSING_BLOCK_LABEL_291;
            }
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                sucads = avoid.getString("success");
                Log.e("sucads", sucads);
                inponsel = avoid.getJSONArray("InPonsel");
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                avoid.printStackTrace();
                break MISSING_BLOCK_LABEL_298;
            }
            i = 0;
        }
        if (i >= inponsel.length())
        {
            break MISSING_BLOCK_LABEL_298;
        }
        avoid = inponsel.getJSONObject(i);
        id_ads = avoid.getString("id_ads");
        id_user = avoid.getString("id_user");
        publisher_name = avoid.getString("publisher_name");
        title_ads = avoid.getString("ads_title");
        campaign = avoid.getString("ads_campaign");
        no_ads = avoid.getString("ads_no");
        image_ads = (new StringBuilder(String.valueOf(Util.BASE_PATH_IKADV))).append(avoid.getString("ads_image")).toString();
        link_ads = avoid.getString("ads_link");
        ads_method = avoid.getString("ads_method");
        ads_start = avoid.getString("ads_start");
        ads_finish = avoid.getString("ads_finish");
        ads_status = avoid.getString("ads_status");
        i++;
        if (true)
        {
            break MISSING_BLOCK_LABEL_72;
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
        try
        {
            Log.e("image_ads", image_ads.replaceAll(" ", ""));
            if (sucads.equals("0"))
            {
                lay_advertising.setVisibility(8);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        imgAdv.setLayoutParams(new android.widget.(Utility.getBmapWidth(RivalTerdekatActivity.this), Utility.getBmapHeight(RivalTerdekatActivity.this)));
        imgAdv.setMaxWidth(Utility.getBmapWidth(RivalTerdekatActivity.this));
        imgAdv.setMaxHeight(Utility.getBmapHeight(RivalTerdekatActivity.this));
        if (!title_ads.equals("")) goto _L2; else goto _L1
_L1:
        txtAdvJudul2.setVisibility(8);
_L7:
        if (!campaign.equals("")) goto _L4; else goto _L3
_L3:
        txtAdvDesc.setVisibility(8);
_L8:
        if (!ads_method.equals("")) goto _L6; else goto _L5
_L5:
        btnAdvDownload.setVisibility(8);
_L9:
        if (ads_status.equals("0"))
        {
            lay_advertising.setVisibility(8);
        }
        btnAdvDownload.setOnClickListener(new android.view.View.OnClickListener() {

            final RivalTerdekatActivity.InAdsTask this$1;

            public void onClick(View view)
            {
                if (link_ads.contains("play.google.com"))
                {
                    try
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(link_ads.substring(link_ads.lastIndexOf("id=") + 3)).toString())));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://play.google.com/store/apps/details?id=")).append(link_ads.substring(link_ads.lastIndexOf("id=") + 3)).toString())));
                    }
                    return;
                }
                if (ads_method.toLowerCase().equals("ponsel"))
                {
                    view = new Intent(getApplicationContext(), com/inponsel/android/details/DetailsPonsel);
                    view.putExtra("id_hph", link_ads);
                    view.putExtra("namalengkap", "");
                    view.putExtra("codename", "");
                    view.putExtra("model", "");
                    view.putExtra("merk", "");
                    view.putExtra("gambar", "");
                    view.putExtra("hrg_baru", "");
                    view.putExtra("hrg_bekas", "");
                    view.putExtra("tot_like", "");
                    view.putExtra("tot_dislike", "");
                    view.putExtra("tot_komen", "");
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                }
                if (ads_method.equals("activity"))
                {
                    view = new Intent(this$0, com/inponsel/android/v2/SCUserActivity);
                    view.putExtra("activity", "main");
                    startActivityForResult(view, 0);
                    overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                } else
                {
                    view = new Intent("android.intent.action.VIEW");
                    view.setData(Uri.parse(link_ads.replaceAll(" ", "")));
                    startActivity(view);
                    return;
                }
            }

            
            {
                this$1 = RivalTerdekatActivity.InAdsTask.this;
                super();
            }
        });
        return;
_L2:
        txtAdvJudul2.setText(title_ads);
          goto _L7
_L4:
        txtAdvDesc.setText(campaign);
          goto _L8
_L6:
label0:
        {
            if (!ads_method.contains("Download"))
            {
                break label0;
            }
            btnAdvDownload.setText("Download");
        }
          goto _L9
label1:
        {
            if (!ads_method.equals("activity"))
            {
                break label1;
            }
            btnAdvDownload.setText("Arahkan");
        }
          goto _L9
        btnAdvDownload.setText("Arahkan");
          goto _L9
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }


    private _cls1.this._cls1()
    {
        this$0 = RivalTerdekatActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
