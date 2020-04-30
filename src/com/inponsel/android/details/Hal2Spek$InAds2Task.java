// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.ServiceHandler;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.v2.ImagePagerActivity;
import com.inponsel.android.v2.SCUserActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

private class <init> extends AsyncTask
{

    final Hal2Spek this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        {
            avoid = (new ServiceHandler()).makeServiceCall(dataInAds2, 1);
            if (avoid == null)
            {
                break MISSING_BLOCK_LABEL_291;
            }
            int i;
            try
            {
                avoid = new JSONObject(avoid);
                sucads2 = avoid.getString("success");
                Log.e("sucads2", sucads2);
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
        id_ads2 = avoid.getString("id_ads");
        id_user2 = avoid.getString("id_user");
        publisher_name2 = avoid.getString("publisher_name");
        title_ads2 = avoid.getString("ads_title");
        campaign2 = avoid.getString("ads_campaign");
        no_ads2 = avoid.getString("ads_no");
        image_ads2 = (new StringBuilder(String.valueOf(Util.BASE_PATH_IKADV))).append(avoid.getString("ads_image")).toString();
        link_ads2 = avoid.getString("ads_link");
        ads_method2 = avoid.getString("ads_method");
        ads_start2 = avoid.getString("ads_start");
        ads_finish2 = avoid.getString("ads_finish");
        ads_status2 = avoid.getString("ads_status");
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
            Log.e("image_ads2spek", image_ads2.replaceAll(" ", ""));
            if (sucads2.equals("0"))
            {
                lay_advertising2.setVisibility(8);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            return;
        }
        imgAdv.setLayoutParams(new android.widget.arams(Utility.getBmapWidth(getActivity()), Utility.getBmapHeight(getActivity())));
        imgAdv.setMaxWidth(Utility.getBmapWidth(getActivity()));
        imgAdv.setMaxHeight(Utility.getBmapHeight(getActivity()));
        txtAdvJudul22.setText(title_ads2);
        txtAdvDesc2.setText(campaign2);
        if (!link_ads2.contains("play.google.com")) goto _L2; else goto _L1
_L1:
        btnAdvDownload2.setText("Download");
_L3:
        if (!ads_status2.equals("0"))
        {
            break MISSING_BLOCK_LABEL_272;
        }
        lay_advertising.setVisibility(8);
_L4:
        imgAdv2.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek.InAds2Task this$1;

            public void onClick(View view)
            {
                view = new ArrayList();
                view.add(image_ads2.replaceAll(" ", "").trim());
                view = (String[])view.toArray(new String[view.size()]);
                Intent intent = new Intent(getActivity(), com/inponsel/android/v2/ImagePagerActivity);
                intent.putExtra("imgUrl", view);
                intent.putExtra("pos", 0);
                startActivity(intent);
            }

            
            {
                this$1 = Hal2Spek.InAds2Task.this;
                super();
            }
        });
        btnAdvDownload2.setOnClickListener(new android.view.View.OnClickListener() {

            final Hal2Spek.InAds2Task this$1;

            public void onClick(View view)
            {
                if (link_ads2.contains("play.google.com"))
                {
                    try
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("market://details?id=")).append(link_ads2.substring(link_ads2.lastIndexOf("id=") + 3)).toString())));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("http://play.google.com/store/apps/details?id=")).append(link_ads2.substring(link_ads2.lastIndexOf("id=") + 3)).toString())));
                    }
                    return;
                }
                if (ads_method2.equals("activity"))
                {
                    view = new Intent(getActivity(), com/inponsel/android/v2/SCUserActivity);
                    view.putExtra("activity", "main");
                    startActivityForResult(view, 0);
                    getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
                    return;
                } else
                {
                    view = new Intent("android.intent.action.VIEW");
                    view.setData(Uri.parse(link_ads2.replaceAll(" ", "")));
                    startActivity(view);
                    return;
                }
            }

            
            {
                this$1 = Hal2Spek.InAds2Task.this;
                super();
            }
        });
        return;
_L2:
        btnAdvDownload2.setText("Arahkan");
          goto _L3
        imageLoaderAds.displayImage(image_ads2.replaceAll(" ", ""), imgAdv2, Hal2Spek.access$1(Hal2Spek.this), new ImageLoadingListener() {

            final Hal2Spek.InAds2Task this$1;

            public void onLoadingCancelled(String s, View view)
            {
            }

            public void onLoadingComplete(String s, View view, Bitmap bitmap)
            {
                lay_advertising2.setVisibility(0);
                imgAdv2.setVisibility(0);
            }

            public void onLoadingFailed(String s, View view, FailReason failreason)
            {
                lay_advertising2.setVisibility(0);
                imgAdv2.setVisibility(0);
            }

            public void onLoadingStarted(String s, View view)
            {
                lay_advertising2.setVisibility(8);
                imgAdv2.setVisibility(8);
            }

            
            {
                this$1 = Hal2Spek.InAds2Task.this;
                super();
            }
        });
          goto _L4
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }


    private _cls3.this._cls1()
    {
        this$0 = Hal2Spek.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
