// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.inponsel.android.adapter.CustomPagerAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Utility;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

class ler extends AsyncHttpResponseHandler
{

    final HomeNewsActivity this$0;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
    }

    public void onRetry(int i)
    {
    }

    public void onStart()
    {
        arrayListAds.clear();
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        aheader = new String(abyte0);
        Log.e("responseHeadNews", aheader);
        aheader = new JSONObject(aheader);
        if (aheader.getBoolean("success")) goto _L2; else goto _L1
_L1:
        rl_slideshow_ads.setVisibility(8);
_L5:
        Log.e("arrayListAds", String.valueOf(arrayListAds.size()));
        customPagerAdapter.notifyDataSetChanged();
        return;
_L2:
        aheader = aheader.getJSONArray("InPonsel");
        i = 0;
_L6:
        if (i < aheader.length()) goto _L4; else goto _L3
_L3:
        float f3;
        float f4;
        rl_slideshow_ads.setVisibility(0);
        aheader = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        abyte0 = new DisplayMetrics();
        aheader.getMetrics(abyte0);
        i = ((DisplayMetrics) (abyte0)).widthPixels;
        float f = Utility.aspectratio(Integer.parseInt("1024"), Integer.parseInt("600"));
        f3 = (float)Integer.parseInt("1024") / f;
        f4 = (float)Integer.parseInt("600") / f;
        Log.e("ratio", String.valueOf((new StringBuilder(String.valueOf(f3))).append(" : ").append(f4).toString()));
        float f1;
        float f2;
        f1 = i;
        if (f3 <= f4)
        {
            break MISSING_BLOCK_LABEL_486;
        }
        f2 = f1;
        f1 = Math.round((f1 * f4) / f3);
        Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(f2))).append(" : ").append(f1).toString()));
_L7:
        rl_slideshow_ads.setLayoutParams(new android.widget.arams((int)f2, (int)f1));
          goto _L5
        aheader;
        aheader.printStackTrace();
          goto _L5
_L4:
        abyte0 = aheader.getJSONObject(i);
        ListModel listmodel = new ListModel();
        listmodel.setId_ads(abyte0.getString("id_ads"));
        listmodel.setAds_title(abyte0.getString("ads_title"));
        listmodel.setAds_campaign(abyte0.getString("ads_campaign"));
        listmodel.setAds_cover(abyte0.getString("ads_image"));
        listmodel.setAds_icon(abyte0.getString("logo_pub"));
        listmodel.setAds_type(abyte0.getString("ads_type"));
        listmodel.setAds_link(abyte0.getString("ads_link"));
        listmodel.setAds_method(abyte0.getString("ads_method"));
        listmodel.setAds_title_color(abyte0.getString("ads_title_color"));
        listmodel.setAds_campaign_color(abyte0.getString("ads_campaign_color"));
        listmodel.setAds_back_color(abyte0.getString("ads_back_color"));
        listmodel.setAds_btn_text_color(abyte0.getString("ads_btn_text_color"));
        listmodel.setAds_btn_text_action(abyte0.getString("ads_btn_text_action"));
        arrayListAds.add(listmodel);
        i++;
          goto _L6
        f2 = Math.round((f1 * f4) / f3);
        Log.e("ratioFinal", String.valueOf((new StringBuilder(String.valueOf(f2))).append(" : ").append(f1).toString()));
          goto _L7
    }

    ter()
    {
        this$0 = HomeNewsActivity.this;
        super();
    }
}
